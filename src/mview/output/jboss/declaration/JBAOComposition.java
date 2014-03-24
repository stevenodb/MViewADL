/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBAOComposition.java
 * created:  Mar 21, 2011, 2:21:27 PM
 *
 * Copyright 2013 KU Leuven Research and Development - iMinds - DistriNet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Administrative Contact: dnet-project-office@cs.kuleuven.be
 * Technical Contact: steven@opdebeeck.org
 */
package mview.output.jboss.declaration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import be.kuleuven.cs.distrinet.chameleon.util.Pair;
import mview.model.composition.AOComposition;
import mview.model.composition.PatternSignature;
import mview.output.jboss.element.JBActorPropValue;
import mview.output.jboss.element.JBAdviceElement;
import mview.output.jboss.element.JBPointcutElement;
import mview.output.jboss.element.JBPointcutElement.ActorType;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class JBAOComposition extends JBDeclarationImpl<JBAOComposition,AOComposition> {

	private JBPointcutElement	_jbPointcut;
	private JBAdviceElement		_jbAdvice;

	
	String cflow =
		"@DynamicCFlowDef" + "\n" +
		"public class HostConditions implements DynamicCFlow {" + "\n" +
		"" + "\n" +
		"	/**" + "\n" +
		"	 * Verify Host Conditions" + "\n" +
		"	 * @return	true is should execute; otherwise false" + "\n" +
		"	 */" + "\n" +
		"	public boolean shouldExecute(Invocation invocation) {" + "\n" +
		"		String hostname = null;" + "\n" +
		"		List<String> validHL, invalidHL;" + "\n" +
		"		validHL = Arrays.asList(validHosts);" + "\n" +
		"		invalidHL = Arrays.asList(invalidHosts);" + "\n" +
		"		" + "\n" +
		"		try {" + "\n" +
		"			hostname = InetAddress.getLocalHost().getHostName();" + "\n" +
		"		} catch (UnknownHostException e) {}" + "\n" +
		"		" + "\n" +
		"		return validHL.contains(hostname) && " + "\n" +
		"				! invalidHL.contains(hostname);" + "\n" +
		"	}" + "\n" +
		"}";
	

	/**
	 * @param sourceElement
	 */
	public JBAOComposition(AOComposition sourceElement, JBDeclaration parentDeclaration) {
		super(sourceElement,parentDeclaration);
	}


	/**
	 * @return
	 */
	public JBPointcutElement pointcut() {
		return _jbPointcut;
	}
	

	/**
	 * @return
	 */
	public JBAdviceElement advice() {
		return _jbAdvice;
	}


	/**
	 * @param jbPC
	 */
	public void addPointcut(JBPointcutElement jbPC) {
		_jbPointcut = jbPC;
	}


	/**
	 * @param jbAdv
	 */
	public void addAdvice(JBAdviceElement jbAdv) {
		_jbAdvice = jbAdv;
	}


	@Override
	protected String toCode(JBDeclaration parent) {
		final StringBuffer sb = startLine();
		
		// pointcut
		if (pointcut() != null && advice() != null) {
			JBPointcutElement pc = pointcut();
			
			// hosts
			final List<String> validHosts = new ArrayList<String>();
			final List<String> invalidHosts = new ArrayList<String>();
			
			if (pc.calleeMap().containsKey(ActorType.HOST)) {
				for(JBActorPropValue propVal : pc.calleeMap().get(ActorType.HOST)) {
					
					JBHost host = ((JBApplication) parent.parentDeclaration()).hostWithName(propVal.value());
					String hostName = (host != null && host.getHostName() != null) 
												? host.getHostName() : propVal.value();
					
					if (propVal.isNegated()) {
						invalidHosts.add(hostName);
					} else {
						validHosts.add(hostName);
					}
				}
			}

			List[] hostLists = {validHosts,invalidHosts};
			
			for (List<String> lst : hostLists) {
				
				if (lst == validHosts) {
					startNewLine(sb,"final String[] validHosts = {");
				} else {
					startNewLine(sb,"final String[] invalidHosts = {");
				}
				
				for(Iterator<String> itHost = lst.iterator(); itHost.hasNext();) {
					String host = itHost.next();
					appendTermStrict(sb,host+(itHost.hasNext()?",":""));
				}
				appendTermStrict(sb, "};");
				
			}
			
//			startNewLine(sb,"final String[] validHosts = {");
//			for(Iterator<String> itHost = validHosts.iterator(); itHost.hasNext();) {
//				String host = itHost.next();
//				appendTermStrict(sb,host+(itHost.hasNext()?",":""));
//			}
//			appendTermStrict(sb, "};");
//
//			
//			startNewLine(sb,"final String[] invalidHosts = {");
//			for(Iterator<String> itHost = invalidHosts.iterator(); itHost.hasNext();) {
//				String host = itHost.next();
//				appendTermStrict(sb,"\""+host+"\""+(itHost.hasNext()?",":""));
//			}
//			appendTermStrict(sb, "};");
			
			// signatures
			newLine(sb);
			startNewLine(sb, "@PointcutDef(");
			
			indent();
			
			if (pc.patternSignature().size() > 0) {
				startNewLine(sb,"\"");
				for(Iterator<PatternSignature> itSig = pc.patternSignature().iterator();
						itSig.hasNext();) {
					
					PatternSignature psig = itSig.next();
					
					appendTermStrict(sb,pc.kind() + "(");
					appendTerm(sb, psig.returnTypePattern());
					appendTermStrict(sb, "*"); // TODO: revisit model
					appendTermStrict(sb, "->"+psig.signaturePattern()+"(");
					
					for(Iterator<Pair<String,String>> itPar = 
							psig.formalParametersPattern().iterator(); itPar.hasNext();) {
						
						Pair<String,String> param = itPar.next();
						
						if (itPar.hasNext()) {
							appendTerm(sb,param.first()+",");
						} else {
							appendTermStrict(sb,param.first()+")");
						}
					}
					
//					appendTermStrict(sb,"\")");
					
					if (itSig.hasNext()) {
						appendTermStrict(sb, "\" +");
						startNewLine(sb, "\"OR ");
					}
				}
			}
			
			if (pc.calleeMap().containsKey(ActorType.INTERFACE)) {
				final List<JBActorPropValue> propValList = 
					pc.calleeMap().get(ActorType.INTERFACE);
				
				appendTermStrict(sb, "\" +");
				startNewLine(sb,"\"AND ");
				for (Iterator iterator = propValList.iterator(); iterator.hasNext();) {
					JBActorPropValue propValue = (JBActorPropValue) iterator.next();

					appendTerm(
						sb,(propValue.isNegated()?"!":"") + 
						"class($instanceof(" +
						propValue.value() +
						"))\"");
					
					if (iterator.hasNext()) {
						startNewLine(sb, "\"AND ");
					}
				}
			}

			appendTermStrict(sb, ")");

			undent(); // pointcutdef
			
			startNewLine(sb,"public static Pointcut " +	getName() + ";");
		
		
			// advice
			JBAdviceElement advice = advice();
			
			newLine(sb);
			
			startNewLine(sb, "@Bind(");
			
			indent(); //bind
			
			startNewLine(sb, "pointcut=\"" + getName() + "\",");
			startNewLine(sb, "type="+advice.type() + ",");
			startNewLine(sb, "cflow=\""+ parent.getName() + ".HostConditions\"");
			appendTermStrict(sb, ")");
			
			undent(); // bind
			
			startNewLine(sb, "public void " 
					+ advice.serviceSignature()
					+ "(@Args Object[] args)"
					+ "{");
			
			indent();
			
			startNewLine(sb, 
					typeToInstanceName(advice.serviceInterface())
					+ "."
					+ advice.serviceSignature()
					+ "(args)"
					+ ";");
			
			undent(); // advicebody
			
			startNewLine(sb, "}");
		}

		// dynamic cflow
		newLine(sb);
		sb.append(cflow);
		
		return sb.toString();
	}

}

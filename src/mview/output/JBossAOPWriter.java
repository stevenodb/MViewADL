/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBossAOPWriter.java
 * created:  Dec 15, 2010, 5:03:21 PM
 * license:
 * The code contained in this file is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * The code contained in this file is distributed in the hope that it 
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License. 
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mview.output;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import mview.model.application.Instance;
import mview.model.composition.AOComposition;
import mview.model.composition.Advice;
import mview.model.composition.PatternSignature;
import mview.model.composition.Pointcut;
import mview.model.composition.ServiceSignature;
import mview.model.deployment.Deployment;
import mview.model.module.Connector;
import mview.model.module.Interface;
import mview.model.module.Module;
import mview.model.namespace.MViewDeclaration;
import mview.model.refinement.RefinementRelation;

import org.rejuse.java.collections.RobustVisitor;
import org.rejuse.java.collections.Visitor;

import chameleon.core.reference.SimpleReference;
import chameleon.exception.ModelException;
import chameleon.util.Pair;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class JBossAOPWriter extends MViewWriter {

	private JBossAOPWriter(WriterArguments wArguments) {
		super(wArguments);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.output.MViewWriter#initPreambles()
	 */
	@Override
	protected void initPreambles() {
		String imports =
				"import javax.ejb.EJB;\n" +
						"import org.jboss.aop.AdviceType;\n" +
						"import org.jboss.aop.Aspect;\n" +
						"import org.jboss.aop.Bind;\n" +
						"import org.jboss.aop.PointcutDef;\n" +
						"import org.jboss.aop.pointcut.Pointcut;\n";
		StringBuffer connPA = new StringBuffer(imports);
		addPreamble(Connector.class, connPA);
	}

	/**
	 * @param declarations
	 * @param defaultNamespace
	 * @param outputDir
	 * @throws IOException
	 * @throws ModelException
	 */
	public static void writeCode(Set<MViewDeclaration> declarations,
			String defaultNamespace, String outputDir,
			List<MViewDeclaration> declsAllowedOutput)
				throws IOException, ModelException {

		WriterArguments wArgs = new WriterArguments(defaultNamespace,
				outputDir, declsAllowedOutput);

		MViewWriter writer = new JBossAOPWriter(wArgs);

		for (MViewDeclaration decl : declarations) {
			writer.toCode(decl);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.tool.ConnectorImpl#clone()
	 */
	@Override
	public MViewWriter clone() {
		return new JBossAOPWriter(writerArguments());
	}


	/**
	 * @param typeName
	 * @return
	 */
	public String typeToInstanceName(String typeName) {
		final StringBuffer result = new StringBuffer();
		result.append(typeName.substring(0, 1).toLowerCase());
		result.append(typeName.substring(1));
		return result.toString();
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.output.MViewWriter#toCodeDeployment(mview.model.deployment.Deployment
	 * )
	 */
	@Override
	protected String toCodeDeployment(Deployment element)
			throws ModelException {
		final StringBuffer result = startLine();

		List<Instance> instances = element.members(Instance.class);

		try {
			new RobustVisitor<Instance>() {
				@Override
				public Object visit(Instance element) throws ModelException {
					toCode(element);
					return null;
				}

				@Override
				public void unvisit(Instance element, Object unvisitData) {
					// NOP
				}
			}.applyTo(instances);
		} catch (ModelException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result.toString();
	}
	
	/* (non-Javadoc)
	 * @see mview.output.MViewWriter#toCodeInstance(mview.model.application.Instance)
	 */
	@Override
	protected String toCodeInstance(Instance element) throws ModelException {
		return toCode(element.type().getElement());
	}

	/**
	 * @param module
	 * @return
	 * NOTE: should be replaced by decent refinement support for required/provided
	 * interfaces.
	 */
	protected List<SimpleReference<Interface>> gatherRequiredInterfaces(Module module) {
		List<SimpleReference<Interface>> result = 
			new ArrayList<SimpleReference<Interface>>();
		
		result.addAll(module.requiredInterfaces());
		
		List<RefinementRelation> refinements = module.refinementRelations();
		for (RefinementRelation refinementRelation : refinements) {
			Module parent = (Module)refinementRelation.parentDeclarationEnd();
			result.addAll(0, this.gatherRequiredInterfaces(parent));
		}
		
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.output.MViewWriter#toCodeConnector(chameleon.tool.Connector)
	 */
	@Override
	protected String toCodeConnector(Connector element) throws
			ModelException {

		final StringBuffer result = startLine();

		result.append(startNewLine("@Aspect"));
		result.append(startNewLine("public class "));
		result.append(element.signature().name());

		result.append(" {");

		indent();

		{
			// required interfaces => define injections
			List<SimpleReference<Interface>> required = 
				this.gatherRequiredInterfaces(element);
			
			Iterator<SimpleReference<Interface>> it = required.iterator();
			
			while (it.hasNext()) {
				SimpleReference<mview.model.module.Interface> ifaceRef =
						(SimpleReference<mview.model.module.Interface>) it.next();
				
				Interface iface = ifaceRef.getElement();
				String ifaceName = iface.signature().name();
				
				String appendix = "";
				int n = Collections.frequency(required, ifaceRef);
				if (n > 1) { 
					appendix = ""+n;
				}
				
				result.append(startNewLine("@EJB"));
				result.append(startNewLine("private "));
				result.append(ifaceName);
				result.append(" ");
				result.append(typeToInstanceName(ifaceName)+appendix);
				result.append(';');
				
				it.remove();
				
			}
		}
		
//		try {
//			new RobustVisitor<SimpleReference<Interface>>() {
//
//				@Override
//				public Object visit(SimpleReference<Interface> element)
//						throws Exception {
//					
//					Interface iface = element.getElement();
//					String ifaceName = iface.signature().name();
//					
//					
//					
//					result.append(startNewLine("@EJB"));
//					result.append(startNewLine("private "));
//					result.append(ifaceName);
//					result.append(" ");
//					result.append(typeToInstanceName(ifaceName));
//					result.append(';');
//					
//					return null;
//				}
//
//				@Override
//				public void unvisit(SimpleReference<Interface> element,
//						Object unvisitData) {
//					// NOP
//				}
//			}.applyTo(required);
//		} catch (ModelException e1) {
//			throw e1;
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
		
		
		// handle AOCompositions
		List<AOComposition> compositions = element.members(AOComposition.class);
		
		try {

			new RobustVisitor<AOComposition>() {
				@Override
				public Object visit(AOComposition element)
						throws ModelException {
					result.append(toCode(element));
					return null;
				}

				@Override
				public void unvisit(AOComposition element, Object unvisitData) {
					// NOP
				}
			}.applyTo(compositions);

		} catch (ModelException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}

		undent();

		result.append(startNewLine("}"));

		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.output.MViewWriter#toCodeAOComposition(mview.model.composition.
	 * AOComposition)
	 */
	@Override
	protected String toCodeAOComposition(AOComposition element) {
		StringBuffer result = new StringBuffer();
		
		//pointcut
		List<Pointcut> pointcuts = element.members(Pointcut.class);
		
		//advice
		List<Advice> advices = element.members(Advice.class);

		if ((pointcuts.size() == 1) && (advices.size() == 1)) {
			Pointcut pc = pointcuts.get(0);
			Advice adv = advices.get(0);
			
			result.append(startNewLine("@PointcutDef(\""));
			
			Iterator<ServiceSignature> it = pc.signature().signatures().iterator();
			
			while (it.hasNext()) {
				PatternSignature pSig =
						(PatternSignature) it.next();
				
				result.append(pSig.returnTypePattern()+" ");
				result.append(pSig.signaturePattern()+" (");
				
				for(Pair<String,String> param 
						: pSig.formalParametersPattern()) {
					
					result.append(param.first()+" ");
				}
				
				if(result.charAt(result.length()-1) == ' ') {
					result.replace(result.length()-1, result.length()-1, ")");
				} else {
					result.append(")");
				}

				result.append("\"");
				
				if (it.hasNext()) {
					result.append(" + ");
					result.append(startNewLine("\"OR "));
				}
			}
			result.append(")");
			
			result.append(startNewLine("public static Pointcut "
					+element.signature().name()+";"));
			
			
		} else {
			throw new ModelException("AOComposition only allows one pointcut " +
					"and one advice, something went horribly wrong.");
		}
	
		Advice advice = element.advice();
		
		return 
	}

}

/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBConnector.java
 * created:  Mar 15, 2011, 4:42:59 PM
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
import java.util.List;

import mview.model.module.Connector;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBConnector extends JBModule<JBConnector,Connector> {
	
	private List<JBAOComposition> _aocompositions =
		new ArrayList<JBAOComposition>();

	/**
	 * @param name
	 */
	public JBConnector(Connector sourceElement, JBDeclaration parentDeclaration) {
		super(sourceElement,parentDeclaration);
	}
		
	/**
	 * @return
	 */
	protected String getPreamble() {
		String preamble = 
			"import java.net.InetAddress;\n" +
			"import java.net.UnknownHostException;\n" +
			"import java.util.Arrays;\n" +
			"import java.util.List;\n" +
			"import javax.ejb.EJB;\n" +
			"import org.jboss.aop.AdviceType;\n" +
			"import org.jboss.aop.Aspect;\n" +
			"import org.jboss.aop.Bind;\n" +
			"import org.jboss.aop.DynamicCFlowDef;\n" +
			"import org.jboss.aop.PointcutDef;\n" +
			"import org.jboss.aop.advice.annotation.Args;\n" +
			"import org.jboss.aop.joinpoint.Invocation;\n" +
			"import org.jboss.aop.pointcut.DynamicCFlow;\n" +
			"import org.jboss.aop.pointcut.Pointcut;"; 
		return preamble;
	}
	
	/**
	 * @param jbAOC
	 */
	public void addComposition(JBAOComposition aoc) {
		_aocompositions.add(aoc);
	}

	public List<JBAOComposition> aocompositions() {
		return new ArrayList<JBAOComposition>(_aocompositions);
	}
	
	@Override
	protected String toCode(JBDeclaration parent) {
		
		final StringBuffer sb = startLine();
		
		startNewLine(sb, getPreamble());
		newLine(sb);

//		newLine(sb);
		startNewLine(sb,"@Aspect");
		startNewLine(sb,"public class "+getName()+ " {");
		newLine(sb);

		indent();

		// Module does required interfaces
		sb.append(super.toCode(this));
		
		newLine(sb);
		
		// AOComp does Pointcut and Advice
		for(JBAOComposition aoc : aocompositions()) {
			identCode(sb,aoc.toCode(this));
		}
		
		undent();
		
		startNewLine(sb, "}");
		
		return sb.toString();
	}
}

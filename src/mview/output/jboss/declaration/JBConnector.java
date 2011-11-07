/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBConnector.java
 * created:  Mar 15, 2011, 4:42:59 PM
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

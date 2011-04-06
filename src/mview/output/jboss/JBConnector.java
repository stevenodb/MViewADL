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
package mview.output.jboss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import mview.model.module.Connector;
import mview.model.module.Interface;
import mview.output.WriterArguments;
import chameleon.core.reference.SimpleReference;
import chameleon.oo.type.TypeWithBody;

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
	public JBConnector(Connector sourceElement) {
		super(sourceElement);
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

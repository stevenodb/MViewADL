/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBComponent.java
 * created:  Mar 15, 2011, 4:42:51 PM
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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import mview.model.module.Component;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBComponent extends JBModule<JBComponent,Component> {

	/**
	 * @param sourceElement
	 */
	public JBComponent(Component sourceElement, JBDeclaration parentDeclaration) {
		super(sourceElement,parentDeclaration);
	}

	/**
	 * @return
	 */
	protected String getPreamble() {
		String preamble = 
			"import javax.ejb.EJB;\n" +
			"import javax.ejb.Stateless;"; 
		return preamble;
	}
	

	@Override
	protected String toCode(JBDeclaration parent) {
		final StringBuffer sb = startLine();
		
		startNewLine(sb, getPreamble());
		newLine(sb);

//		newLine(sb);
		startNewLine(sb,"@Stateless");
		startNewLine(sb,"public class "+getName()+" "); 
		
		if (providedInterfaces().size() > 0) {
			appendTerm(sb, "implements");
			
			List<JBInterface> provList = providedInterfaces();
			Iterator<JBInterface> provIter = provList.iterator();
			
			while (provIter.hasNext()) {
				JBInterface provItem = provIter.next();
				String iName = provItem.getName();
				
				appendTermStrict(sb, iName);
				
				if (provIter.hasNext()) {
					appendTermStrict(sb, ", ");
				}
			}
		}
		
		appendTermStrict(sb," {");
		newLine(sb);

		indent();

		// Module does required interfaces
		sb.append(super.toCode(this));
		
		newLine(sb);
		
		undent();
		
		startNewLine(sb, "}");
		
		return sb.toString();
	}
	
}

/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBComponent.java
 * created:  Mar 15, 2011, 4:42:51 PM
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

/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBHost.java
 * created:  Jun 9, 2011, 4:32:20 PM
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

import mview.model.application.Host;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBHost extends JBDeclarationImpl<JBHost, Host> {

	/**
	 * @param sourceElement
	 */
	public JBHost(Host sourceElement, JBDeclaration parentDeclaration) {
		super(sourceElement, parentDeclaration);
	}
	
	/**
	 * @return
	 */
	public String getHostName() {
		String result = null;
		
		if (sourceElement().hostName() != null) {
			result = sourceElement().hostName().signature().toString();
		}		
		
		return result;
	}

	@Override
	protected String toCode(JBDeclaration parent) {
		return getHostName();
	}

}

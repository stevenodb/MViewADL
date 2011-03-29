/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBInterface.java
 * created:  Mar 15, 2011, 4:43:12 PM
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

import chameleon.core.declaration.SimpleNameSignature;
import mview.model.module.Interface;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBInterface extends JBDeclarationImpl<JBInterface, Interface> {

	/**
	 * @param sourceElement
	 */
	protected JBInterface(Interface sourceElement) {
		super(sourceElement);
	}

	/**
	 * @param signature
	 */
	public void addReturnType(String signature) {
		// TODO Auto-generated method stub
	}

	/**
	 * @param string
	 */
	public void addSignature(String signature) {
		// TODO Auto-generated method stub
	}

	/**
	 * @param signature
	 * @param type
	 */
	public void addFormalParameter(String signature, String type) {
		// TODO Auto-generated method stub
	}

}

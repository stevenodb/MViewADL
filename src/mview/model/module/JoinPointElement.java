/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: InterfaceElement.java
 * created:  Dec 1, 2009, 1:45:30 PM
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
 * You should have received a copy of the GNU General Public License
 *
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mview.model.module;

import mview.model.namespace.MViewDeclaration;


/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public abstract class JoinPointElement extends MViewDeclaration {

	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#clone()
	 */
	@Override
	public JoinPointElement clone() {
		return (JoinPointElement) super.clone();
	}

}

/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBModule.java
 * created:  Mar 21, 2011, 2:06:00 PM
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

import mview.model.module.Module;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class JBModule<D extends JBModule, E extends Module>
		extends JBDeclarationImpl<D,E> {

	/**
	 * @param sourceElement
	 */
	protected JBModule(E sourceElement) {
		super(sourceElement);
	}
}

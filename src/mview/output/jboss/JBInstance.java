/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBInstance.java
 * created:  Mar 20, 2011, 1:15:26 PM
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

import mview.model.application.Instance;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
@Deprecated
public class JBInstance extends JBDeclarationImpl<JBInstance,Instance> {

	/**
	 * @param sourceElement
	 */
	protected JBInstance(Instance sourceElement) {
		super(sourceElement);
	}


}

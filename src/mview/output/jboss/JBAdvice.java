/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBAdvice.java
 * created:  Mar 21, 2011, 3:31:33 PM
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

import mview.model.composition.AOComposition;
import mview.model.composition.Advice;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBAdvice extends JBDeclarationImpl<JBAdvice,Advice> {

	private AOComposition	_id;

	/**
	 * @param sourceElement
	 */
	protected JBAdvice(AOComposition id, Advice sourceElement) {
		super(sourceElement);
		_id = id;
	}

	/**
	 * @param id the id to set
	 */
	private void setID(AOComposition id) {
		this._id = id;
	}

	/**
	 * @return the id
	 */
	public AOComposition getID() {
		return _id;
	}

}

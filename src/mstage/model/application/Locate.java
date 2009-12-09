/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Locate.java
 * created:  Dec 1, 2009, 6:03:43 PM
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
 * along with Digital Publishing Demonstrator.  
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mstage.model.application;

import mstage.model.module.HostMap;
import mstage.model.module.Module;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Locate extends HostMap<Locate,AbstractHost,Module<?>> {

	/* (non-Javadoc)
	 * @see mstage.model.module.HostMap#cloneThis()
	 */
	@Override
	protected Locate cloneThis() {
		return new Locate();
	}

}

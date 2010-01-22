/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Map.java
 * created:  Dec 2, 2009, 10:23:32 AM
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
package mstage.model.deployment;

import mstage.model.application.AbstractHost;
import mstage.reuse.Mapping;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class HostMap extends Mapping<HostMap,Host,AbstractHost> {

	/* (non-Javadoc)
	 * @see mstage.model.module.HostMap#cloneThis()
	 */
	@Override
	protected HostMap cloneThis() {
		return new HostMap();
	}


}
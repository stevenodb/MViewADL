/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: ModuleContainer.java
 * created:  Jun 10, 2010, 6:24:10 PM
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
package mstage.model.module;

import java.util.List;

import chameleon.core.reference.SimpleReference;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 * @param <E>
 */
public interface ModuleContainer {

	/**
	 * @return a list of references to the contained modules
	 */
	public List<SimpleReference<Module<?>>> modules();

	/**
	 * @param relation	reference to the Module to add
	 */
	public void addModule(SimpleReference<Module<?>> relation);

	/**
	 * @param relation	reference to the Module to remove
	 */
	public void removeModule(SimpleReference<Module<?>> relation);

}
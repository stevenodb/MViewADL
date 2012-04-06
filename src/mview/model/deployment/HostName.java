/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: HostName.java
 * created:  Oct 25, 2010, 1:23:53 PM
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
package mview.model.deployment;

import mview.model.namespace.MViewDeclaration;
import chameleon.core.declaration.SimpleNameSignature;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class HostName extends MViewDeclaration {
	
	/**
	 * default 
	 */
	public HostName() {
		super();
	}

	/**
	 * @param signature
	 */
	public HostName(SimpleNameSignature signature) {
		super(signature);
	}

	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#cloneThis()
	 */
	@Override
	protected HostName cloneThis() {
		return new HostName();
	}

}

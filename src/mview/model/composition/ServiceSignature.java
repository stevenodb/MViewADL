/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JointPoint.java
 * created:  Nov 27, 2009, 6:03:10 PM
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
package mview.model.composition;

import java.util.List;

import mview.model.module.JoinPointElement;
import chameleon.core.declaration.Declaration;
import chameleon.core.lookup.LookupException;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.reference.SimpleReference;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class ServiceSignature<JPE extends JoinPointElement> extends ElementWithModifiersImpl {

	/**
	 * default constructor
	 */
	protected ServiceSignature() {
		super();
	}

	/**
	 * @return
	 */
	public abstract List<SimpleReference<JPE>> services()
			throws LookupException;

	/**
	 * @return An incomplete clone with the correct sub-Type
	 */
	protected abstract ServiceSignature cloneThis();

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public ServiceSignature clone() {
		return cloneThis();
	}
}

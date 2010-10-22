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

import java.util.ArrayList;
import java.util.List;

import chameleon.core.element.Element;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public abstract class Signature<E extends Signature<E>> extends NamespaceElementImpl<E, Element> {

	/**
	 * @return An incomplete clone with the correct sub-Type 
	 */
	protected abstract E cloneThis();
	
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public E clone() {
		final E clone = this.cloneThis();
		return clone;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		return Valid.create();
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.Element#children()
	 */
	public List<Element> children() {
		return new ArrayList<Element>();
	}
}

/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Actor.java
 * created:  Oct 7, 2010, 5:27:04 PM
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
package mview.model.composition;

import java.util.List;

import chameleon.core.element.Element;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Actor extends NamespaceElementImpl<Actor, Element> {

	/* (non-Javadoc)
	 * @see chameleon.core.element.Element#children()
	 */
	@Override
	public List<? extends Element> children() {
		return null;
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Actor clone() {
		return null;
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		return null;
		// TODO Auto-generated method stub
	}

}

/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RefinementContext.java
 * created:  Nov 11, 2010, 12:38:50 PM
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
package mview.model.refinement;

import chameleon.core.element.Element;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class RefinementContext<M extends MViewMember<M, Element>> {
	
	private final M _child, _parent;

	/**
	 * @param _child
	 * @param _parent
	 */
	public RefinementContext(M child, M parent) {
		super();
		this._child = child;
		this._parent = parent;
	}

	/**
	 * @return the _child
	 */
	public M child() {
		return _child;
	}

	/**
	 * @return the _parent
	 */
	public M parent() {
		return _parent;
	}
	
	/**
	 * @return
	 */
	public boolean verify() {
		RefinableDeclaration childD, parentD;
		
/*		if ((child() instanceof RefinableDeclaration) 
				&& (parent() instanceof RefinableDeclaration)) {
		
			childD = (RefinableDeclaration)child();
			parentD = (RefinableDeclaration)parent();

		} else {
		
		} */
		
		childD = child().nearestAncestor(RefinableDeclaration.class);
		parentD = parent().nearestAncestor(RefinableDeclaration.class);

		return childD.isRefinementOf(parentD);
	}
	
}

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

import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;


/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class RefinementContext {
	
	/**
	 * @param <M>
	 * @param child
	 * @param parent
	 * @return
	 * @throws LookupException 
	 */
	public boolean verify(MViewMember child, MViewMember parent) throws LookupException {
		RefinableDeclaration childD, parentD;
		
		childD = (RefinableDeclaration) child.nearestAncestor(RefinableDeclaration.class);
		parentD = (RefinableDeclaration) parent.nearestAncestor(RefinableDeclaration.class);

		return (childD == parentD) || (childD.isRefinementOf(parentD)); 
		// TODO: ASK MARKO: multiple refinement paths?
	}
	
}

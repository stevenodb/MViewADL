/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RefinableDeclaration.java
 * created:  Oct 28, 2010, 4:34:02 PM
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

import java.util.List;

import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.Signature;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.exception.ModelException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public interface RefinableDeclaration	extends Declaration {

	// /**
	// * Returns the List of all member declarations up to and including this
	// * level of refinement. Overridden declarations are not retained.
	// *
	// * @return a list of member declarations
	// * @throws LookupException
	// */
	// public List<Declaration> declarations() throws LookupException;

	/**
	 * Returns the list of clones of all member elements up to and including
	 * this level of refinement. Overridden declarations are not retained.
	 * 
	 * @return
	 * @throws LookupException
	 */
	public List<Element> flatten() throws ModelException;

	/**
	 * Return the list of all members, including those of parent declarations.
	 * 
	 * @return the list of members
	 * @throws LookupException
	 */
	public List<MViewMember> members() throws ModelException;

	/**
	 * @param <M>
	 *            type M extending MViewMember
	 * @param kind
	 *            the kind of member to retain
	 * @return a list of members of type <code>kind</code>
	 * @throws LookupException
	 */
	public <M extends MViewMember> List<M> members(final Class<M> kind) throws ModelException;

	/**
	 * Return the list of local members
	 * 
	 * @return the list of local members
	 */
	public List<MViewMember> localMembers();

	/**
	 * Return the list of local members of type <code>kind</code>.
	 * @param <M>
	 *            type M extending MViewMember
	 * @param kind
	 *            the kind of member to retain
	 * @return list of local members of type <code>kind</code>
	 */
	public <M extends MViewMember> List<M> localMembers(Class<M> kind);

	/**
	 * Returns the list of all direct refinable parent declarations.
	 * 
	 * @return the list of all direct refinable parent declarations.
	 */
	public List<RefinableDeclaration> getDirectParents();
	
	/**
	 * Returns whether this declaration is abstract
	 * @return true if this declaration is abstract
	 */
	public boolean isAbstract();

	/**
	 * Returns whether this refinable declaration is a refinement of
	 * <code>other</code>. This method is recursive.
	 * 
	 * @param other
	 *            the other declaration
	 * @return true if this is a refinement of other
	 */
	public boolean isRefinementOf(RefinableDeclaration other);

	/**
	 * Add a refinement relation
	 * 
	 * @param relation
	 *            the relation to add
	 */
	public void addRefinementRelation(RefinementRelation relation);

	/**
	 * Remove a refinement relation
	 * 
	 * @param relation
	 *            the relation to remove
	 */
	public void removeRefinemtRelation(RefinementRelation relation);

	/**
	 * Remove all refinement relations
	 */
	public void removeAllRefinementRelations();

}

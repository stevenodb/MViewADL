/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RefinableDeclaration.java
 * created:  Oct 28, 2010, 4:34:02 PM
 *
 * Copyright 2013 KU Leuven Research and Development - iMinds - DistriNet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Administrative Contact: dnet-project-office@cs.kuleuven.be
 * Technical Contact: steven@opdebeeck.org
 */
package mview.model.refinement;

import java.util.List;

import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Signature;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;

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
	 * @throws LookupException 
	 */
	public List<RefinableDeclaration> getDirectParents() throws LookupException;
	
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
	 * @throws LookupException 
	 */
	public boolean isRefinementOf(RefinableDeclaration other) throws LookupException;

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

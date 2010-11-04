/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RefinableDeclarationImpl.java
 * created:  Oct 28, 2010, 5:03:16 PM
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

import java.util.ArrayList;
import java.util.List;

import mview.model.namespace.MViewDeclaration;

import org.rejuse.association.MultiAssociation;

import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class RefinableDeclarationImpl<D extends RefinableDeclarationImpl<D, P>, P extends Element>
		extends MViewDeclaration<D, P> implements RefinableDeclaration<D, P> {

	/*
	 * Parent declarations
	 */
	MultiAssociation<RefinableDeclaration, RefinementRelation> _refinementRelations =
			new MultiAssociation<RefinableDeclaration, RefinementRelation>(this);

	/**
	 * @return	the list of refinement relations
	 */
	protected List<RefinementRelation> refinementRelations() {
		return _refinementRelations.getOtherEnds();
	}
	
	@Override
	public void addRefinementRelation(RefinementRelation relation) {
		_refinementRelations.add(relation.parentLink());
	}

	@Override
	public void removeRefinemtRelation(RefinementRelation relation) {
		_refinementRelations.remove(relation.parentLink());
	}

	@Override
	public void removeAllRefinementRelations() {
		_refinementRelations.clear();
	}

	@Override
	public List<Declaration> declarations() throws LookupException {

		List<Declaration> result = new ArrayList<Declaration>();

		for (RefinableDeclaration declaration : getDirectParents()) {
			result.addAll(declaration.declarations());
		}

		for (Element elem : members()) {
			if (elem instanceof Declaration) {
				result.add((Declaration) elem);
			}
		}

		return result;
	}

	@Override
	public List<Element> flatten() throws LookupException {
		List<Element> result = new ArrayList<Element>();

		for (Element elem : members()) {

		}

		return result;
	}

	@Override
	public List<? extends MViewMember> members() throws LookupException {
		List<MViewMember> result;
		
		// 1. local members
		result = new ArrayList<MViewMember>(localMembers());
		
		// 2. parent members
		for (RefinementRelation	relation : refinementRelations()) {
			relation.gatherParentMembers(result);
		}
		
		return result;
	}

	@Override
	public List<RefinableDeclaration> getDirectParents() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#cloneThis()
	 */
	@Override
	protected D cloneThis() {
		return null;
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#clone()
	 */
	@Override
	public D clone() {
		return null;
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#children()
	 */
	@Override
	public List<Element> children() {
		return null;
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		return null;
		// TODO Auto-generated method stub
	}

}

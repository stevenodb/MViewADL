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
import org.rejuse.java.collections.TypeFilter;

import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.DeclarationContainer;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.declaration.TargetDeclaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.DeclarationSelector;
import chameleon.core.lookup.LookupException;
import chameleon.core.lookup.LookupStrategy;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class RefinableDeclarationImpl<D extends RefinableDeclarationImpl<D, P>, P extends Element>
		extends MViewDeclaration<D, P>
		implements RefinableDeclaration<D, P>,
			TargetDeclaration<D, P, SimpleNameSignature, D>,
			DeclarationContainer<D, P> {

	/**
	 * default constructor
	 */
	protected RefinableDeclarationImpl() {
		super();
	}

	/**
	 * @param signature
	 */
	protected RefinableDeclarationImpl(SimpleNameSignature signature) {
		super(signature);
	}

	/*
	 * Parent declarations
	 */
	private MultiAssociation<RefinableDeclaration, RefinementRelation> _refinementRelations =
			new MultiAssociation<RefinableDeclaration, RefinementRelation>(this);

	/**
	 * @return the list of refinement relations
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

	// @Override
	// public List<Declaration> declarations() throws LookupException {
	// List<Declaration> result = new ArrayList<Declaration>();
	//
	// Collection<Declaration> localDeclarations =
	// new TypeFilter(Declaration.class).retain(localMembers());
	//
	// result.addAll(localDeclarations);
	//
	// for (RefinableDeclaration declaration : getDirectParents()) {
	// result.addAll(declaration.declarations());
	// }
	// return result;
	// }

	@Override
	public List<Element> flatten() throws LookupException {
		List<Element> result = new ArrayList<Element>();

		for (Element element : members()) {
			result.add(element.clone());
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.declaration.DeclarationContainer#declarations()
	 */
	@Override
	public List<? extends MViewMemberDeclaration> declarations()
			throws LookupException {

		return members(MViewMemberDeclaration.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * chameleon.core.declaration.DeclarationContainer#locallyDeclaredDeclarations
	 * ()
	 */
	@Override
	public List<? extends MViewDeclaration> locallyDeclaredDeclarations()
			throws LookupException {
		return new ArrayList<MViewDeclaration>(
				new TypeFilter(MViewDeclaration.class).retain(localMembers()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * chameleon.core.declaration.DeclarationContainer#declarations(chameleon
	 * .core.lookup.DeclarationSelector)
	 */
	@Override
	public <D extends Declaration> List<D> declarations(
			DeclarationSelector<D> selector) throws LookupException {
		
		return selector.selection(declarations());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * chameleon.core.element.ElementImpl#lexicalLookupStrategy(chameleon.core
	 * .element.Element)
	 */
	public LookupStrategy lexicalLookupStrategy(Element element)
			throws LookupException {
		
    	if(refinementRelations().contains(element)) {
    		Element parent = parent();
    		if(parent != null) {
    			return parent().lexicalLookupStrategy(this);
    		} else {
    			throw new LookupException("Parent of type is null when looking for the parent context of a type.");
    		}
    	} else {
    	  return lexicalMembersLookupStrategy();
    	}
	}

	private LookupStrategy lexicalMembersLookupStrategy() {
		if(_lus == null) {
			_lus = language().lookupFactory().createLexicalLookupStrategy(
					targetContext(), this);
		}
		return _lus;
	}
	
	private LookupStrategy _lus;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.declaration.TargetDeclaration#targetContext()
	 */
	public LookupStrategy targetContext() {
		return language().lookupFactory().createTargetLookupStrategy(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.refinement.RefinableDeclaration#members()
	 */
	@Override
	public List<MViewMember> members() throws LookupException {
		return members(MViewMember.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.refinement.RefinableDeclaration#members(java.lang.Class)
	 */
	@Override
	public <M extends MViewMember> List<M> members(Class<M> kind)
			throws LookupException {

		List<M> result;

		// 1. local members
		result = new ArrayList<M>(localMembers(kind));

		// 2. fetch all parent members
		for (RefinementRelation relation : refinementRelations()) {
			relation.gatherParentMembers(kind, result);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.model.refinement.RefinableDeclaration#localMembers(java.lang.Class)
	 */
	@Override
	public <M extends MViewMember> List<M> localMembers(Class<M> kind)
			throws LookupException {
		return (List<M>) new TypeFilter(kind).retain(localMembers());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.refinement.RefinableDeclaration#getDirectParents()
	 */
	@Override
	public List<RefinableDeclaration> getDirectParents() {
		List<RefinableDeclaration> result =
				new ArrayList<RefinableDeclaration>();

		for (RefinementRelation relation : refinementRelations()) {
			result.add(relation.parentDeclarationEnd());
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.model.refinement.RefinableDeclaration#isRefinementOf(mview.model
	 * .refinement.RefinableDeclaration)
	 */
	@Override
	public boolean isRefinementOf(RefinableDeclaration other) {
		List<RefinableDeclaration> parents = getDirectParents();

		// breadth first search
		boolean result = parents.contains(other);

		if (!result) {
			for (RefinableDeclaration declaration : parents) {
				result = declaration.isRefinementOf(other);
				if (result)
					break;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#clone()
	 */
	@Override
	public D clone() {
		D clone = super.clone();

		for (RefinementRelation relation : refinementRelations()) {
			clone.addRefinementRelation(relation);
		}

		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#children()
	 */
	@Override
	public List<Element> children() {
		List<Element> result = super.children();

		result.addAll(refinementRelations());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		return result;
	}

}

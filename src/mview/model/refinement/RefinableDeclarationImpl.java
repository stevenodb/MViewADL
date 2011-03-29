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

import mview.model.language.MView;
import mview.model.module.Interface;
import mview.model.module.Module.RequiredInterfaceDependency;
import mview.model.namespace.MViewDeclaration;

import org.rejuse.association.OrderedMultiAssociation;
import org.rejuse.java.collections.TypeFilter;

import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.DeclarationContainer;
import chameleon.core.declaration.Signature;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.declaration.TargetDeclaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.DeclarationSelector;
import chameleon.core.lookup.LocalLookupStrategy;
import chameleon.core.lookup.LookupException;
import chameleon.core.lookup.LookupStrategy;
import chameleon.core.lookup.LookupStrategySelector;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.VerificationResult;
import chameleon.exception.ModelException;
import chameleon.util.Util;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class RefinableDeclarationImpl<D extends RefinableDeclarationImpl<D, P>, P extends Element>
		extends MViewDeclaration<D, P>
		implements RefinableDeclaration<D, P>, TargetDeclaration<D, P, Signature, D>,
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
	private OrderedMultiAssociation<RefinableDeclaration, RefinementRelation> _refinementRelations =
			new OrderedMultiAssociation<RefinableDeclaration, RefinementRelation>(this); 


	/**
	 * @return the list of refinement relations 
	 * TODO: make this protected again!!!!
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
	public List<Element> flatten() throws ModelException {
		List<Element> result = new ArrayList<Element>();

		for (Element element : members()) {
			result.add(element.clone());
		}

		return result;
	}


	@Override
	public List<? extends MViewMemberDeclaration> declarations()
			throws LookupException {

		return members(MViewMemberDeclaration.class);
	}


	@Override
	public List<? extends MViewDeclaration> locallyDeclaredDeclarations()
			throws LookupException {
		return new ArrayList<MViewDeclaration>(
				new TypeFilter(MViewDeclaration.class).retain(localMembers()));
	}


	@Override
	public <D extends Declaration> List<D> declarations(
			DeclarationSelector<D> selector) throws LookupException {

		return selector.selection(declarations());
	}


	@Override
	public LookupStrategy lexicalLookupStrategy(Element element) throws LookupException {
		
		if (refinementRelations().contains(element) || element.isDerived()) {
			Element parent = parent();
			if (parent != null) {
				return parent().lexicalLookupStrategy(this);
			} else {
				throw new LookupException("Parent of type is null when looking " +
						"for the parent context of a type.");
			}
		} else {
			return lexicalMembersLookupStrategy();
		}
	}

	private LookupStrategy _lus;
	
	/**
	 * @return
	 */
	private LookupStrategy lexicalMembersLookupStrategy() {
		if (_lus == null) {
			_lus = language().lookupFactory().createLexicalLookupStrategy(
					targetContext(), this, new RequiredStrategySelector());
//					targetContext(), this);
		}
		return _lus;
	}

	/**
	 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
	 *
	 */
	protected class RequiredStrategySelector implements LookupStrategySelector {
		@Override
		public LookupStrategy strategy() throws LookupException {
			return requiredLookupStrategy();
		}
	}

	private LookupStrategy _requiredLookupStrategy;

	/**
	 * @return
	 */
	private LookupStrategy requiredLookupStrategy() {
		if (_requiredLookupStrategy == null) {
			_requiredLookupStrategy =
					language().lookupFactory().createLexicalLookupStrategy(
							new RequiredLocalStrategy(this), this);
		}
		return _requiredLookupStrategy;
	}

	/**
	 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
	 *
	 */
	protected class RequiredLocalStrategy extends
			LocalLookupStrategy<RefinableDeclarationImpl> {
		
		/**
		 * @param element
		 */
		public RequiredLocalStrategy(RefinableDeclarationImpl element) {
			super(element);
		}

		@Override
		public <D extends Declaration> List<D> declarations(
				DeclarationSelector<D> selector) throws LookupException {
			
			List<D> result = new ArrayList<D>();
			
			List<RequiredInterfaceDependency> requires =
					members(RequiredInterfaceDependency.class);
	
			if (requires.size() > 0) {
				RequiredInterfaceDependency dependency = requires.get(0);
				result.addAll(dependency.declarations(selector));
			}
			return result;
		}
	}


	@Override
	public LookupStrategy targetContext() {
		return language().lookupFactory().createTargetLookupStrategy(this);
	}


	@Override
	public List<MViewMember> members() throws ModelException {
		return members(MViewMember.class);
	}


	@Override
	public <M extends MViewMember> List<M> members(Class<M> kind)
			throws LookupException {

		List<M> result;

		// 1. local members
		result = new ArrayList<M>(localMembers(kind));

		// 2. fetch all parent members
		for (RefinementRelation relation : refinementRelations()) {
			try {
				relation.gatherParentMembers(kind, result);
			} catch (ModelException e) {
				throw new LookupException("gatherParentMembers failed with ModelException");
			}
		}

		return result;
	}


	@Override
	public <M extends MViewMember> List<M> localMembers(Class<M> kind) {
		return (List<M>) new TypeFilter(kind).retain(localMembers());
	}


	@Override
	public List<RefinableDeclaration> getDirectParents() {
		List<RefinableDeclaration> result =
				new ArrayList<RefinableDeclaration>();

		for (RefinementRelation relation : refinementRelations()) {
			result.add(relation.parentDeclarationEnd());
		}

		return result;
	}


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


	@Override
	public D clone() {
		D clone = super.clone();

		for (RefinementRelation relation : refinementRelations()) {
			clone.addRefinementRelation(relation);
		}

		return clone;
	}


	@Override
	public List<Element> children() {
		List<Element> result = super.children();

		result.addAll(refinementRelations());

		return result;
	}


	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		return result;
	}


	@Override
	public boolean isAbstract() {
		return this.isTrue(language(MView.class).ABSTRACT);
	}
}

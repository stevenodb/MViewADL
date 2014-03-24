/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RefinableDeclarationImpl.java
 * created:  Oct 28, 2010, 5:03:16 PM
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

import java.util.ArrayList;
import java.util.List;

import mview.model.language.MView;
import mview.model.module.Module.RequiredInterfaceDependency;
import mview.model.namespace.MViewDeclaration;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.DeclarationContainer;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.TargetDeclaration;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.DeclarationSelector;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LocalLookupContext;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupContext;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupContextSelector;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.SelectionResult;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;
import be.kuleuven.cs.distrinet.rejuse.association.Association;
import be.kuleuven.cs.distrinet.rejuse.java.collections.TypeFilter;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class RefinableDeclarationImpl
		extends MViewDeclaration
		implements RefinableDeclaration, TargetDeclaration,
			DeclarationContainer {

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
	private Multi<RefinementRelation> _refinementRelations = new Multi<RefinementRelation>(this); 


	/**
	 * @return the list of refinement relations 
	 */
	protected List<RefinementRelation> refinementRelations() {
		return _refinementRelations.getOtherEnds();
	}


	/**
	 * Adds a refinement relation in a last-in-first-out manner.
	 */
	@Override
	public void addRefinementRelation(RefinementRelation relation) {
		_refinementRelations.addInFront((Association)relation.parentLink());
	}


	@Override
	public void removeRefinemtRelation(RefinementRelation relation) {
		remove(_refinementRelations,relation);
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
	public <D extends Declaration> List<? extends SelectionResult> declarations(
			DeclarationSelector<D> selector) throws LookupException {

		return selector.selection(declarations());
	}


	@Override
	public LookupContext lookupContext(Element element) throws LookupException {
		
		if (refinementRelations().contains(element) || element.isDerived()) {
			Element parent = parent();
			if (parent != null) {
				return parent().lookupContext(this);
			} else {
				throw new LookupException("Parent of type is null when looking " +
						"for the parent context of a type.");
			}
		} else {
			return lexicalMembersLookupStrategy();
		}
	}

	protected LookupContext _lus;
	
	/**
	 * @return
	 */
	protected LookupContext lexicalMembersLookupStrategy() {
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
	protected class RequiredStrategySelector implements LookupContextSelector {
		@Override
		public LookupContext strategy() throws LookupException {
			return requiredLookupStrategy();
		}
	}

	private LookupContext _requiredLookupStrategy;

	/**
	 * @return
	 */
	protected LookupContext requiredLookupStrategy() {
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
			LocalLookupContext<RefinableDeclarationImpl> {
		
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
			
			List<RequiredInterfaceDependency> requires = 	members(RequiredInterfaceDependency.class);
	
			if (requires.size() > 0) {
				RequiredInterfaceDependency dependency = requires.get(0);
				result.addAll(dependency.declarations(selector));
			}
			return result;
		}
	}


	@Override
	public LocalLookupContext<DeclarationContainer> targetContext() {
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

//		Set<M> noDoubles = new HashSet<M>(result);
//		if (noDoubles.size() != result.size()) {
//			System.err.println("Contains doubles.");
//		}
		return result;
	}


	@Override
	public <M extends MViewMember> List<M> localMembers(Class<M> kind) {
		return (List<M>) new TypeFilter(kind).retain(localMembers());
	}


	@Override
	public List<RefinableDeclaration> getDirectParents() throws LookupException {
		List<RefinableDeclaration> result =
				new ArrayList<RefinableDeclaration>();

		for (RefinementRelation relation : refinementRelations()) {
			result.add(relation.parentDeclarationEnd());
		}

		return result;
	}


	@Override
	public boolean isRefinementOf(RefinableDeclaration other) throws LookupException {
		
		List<RefinableDeclaration> parents = getDirectParents();

		// breadth first search
		boolean result = parents.contains(other);

		if (!result) {
			for (RefinableDeclaration declaration : parents) {
				result = declaration.isRefinementOf(other);
				if (result)	break;
			}
		}
		return result;
	}

	@Override
	public Verification verifySelf() {
		Verification result = super.verifySelf();
		return result;
	}


	@Override
	public boolean isAbstract() {
		return this.isTrue(language(MView.class).ABSTRACT);
	}
	
	
}

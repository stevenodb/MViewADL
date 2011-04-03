/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RequiredInterface.java
 * created:  Dec 21, 2010, 4:52:26 PM
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
package mview.model.module;

import java.util.ArrayList;
import java.util.List;

import mview.exception.MergeNotSupportedException;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.TargetDeclaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.DeclarationSelector;
import chameleon.core.lookup.LookupException;
import chameleon.core.lookup.LookupStrategy;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.exception.ModelException;
import chameleon.util.Util;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class Dependency<E extends Dependency<E, T>, T extends TargetDeclaration>
		extends	NamespaceElementImpl<E, Element> implements MViewMember<E, Element> {

	private final OrderedMultiAssociation<Dependency<E,T>, SimpleReference<T>> _dependencies =
			new OrderedMultiAssociation<Dependency<E,T>, SimpleReference<T>>(this);

	/**
	 * @return	a list of SimpleReferences to dependencies
	 */
	public List<SimpleReference<T>> dependencies() {
		return _dependencies.getOtherEnds();
	}
	
	/**
	 * @param relation
	 */
	public void addDependency(SimpleReference<T> relation) {
		if (relation != null)
			_dependencies.add(relation.parentLink());
	}
	
	/**
	 * @param relation
	 */
	public void removeDependency(SimpleReference<T> relation) {
		if (relation != null)
			_dependencies.remove(relation.parentLink());
	}
	
	
	@Override
	public List<? extends Element> children() {
		List<Element> result = new ArrayList<Element>();
		
		result.addAll(this.dependencies());
		
		return result;
	}

	/**
	 * @return An incomplete clone with the correct sub-Type
	 */
	protected abstract E cloneThis();

	
	@Override
	public E clone() {
		final E clone = this.cloneThis();

		for (SimpleReference<T> t: dependencies()) {
			clone.addDependency(t.clone());
		}

		return clone;
	}
	
	@Override
	public VerificationResult verifySelf() {
		return Valid.create();
	}
	
	/**
	 * @param selector
	 * @return
	 * @throws LookupException
	 */
	public List<T> declarations(DeclarationSelector<T> selector) throws LookupException {
		
		List<T> result = new ArrayList<T>();
		
		List<SimpleReference<T>> deps = this.dependencies();
		
		for (SimpleReference<T> reference : deps) {
			T element = reference.getElement();
			LookupStrategy targetContext = element.targetContext();
			Declaration declaration = targetContext.lookUp(selector);
			Util.addNonNull(declaration, result);
		}

		return (List<T>) selector.declarators(result);
	}

	@Override
	public boolean sharesContext(MViewMember other) {
		return (new RefinementContext()).verify(this, other);
	}

	@Override
	public boolean overrides(MViewMember other) throws ModelException {
		return false;
	}

	@Override
	public boolean mergesWith(MViewMember other) throws ModelException {
		return sameMemberAs(other) 
			&& sharesContext(other) 
			&& !overrides(other);
	}

	@Override
	public E merge(MViewMember other)
			throws MergeNotSupportedException, ModelException {
		E merged;
		
		if (mergesWith(other)) {
			
			E child = this.clone();
			child.setUniParent(parent());
			
			E parent = (E) other.clone();
			parent.setUniParent(other.parent());
			
			merged = cloneThis();
			merged.setUniParent(parent());
			
			List<SimpleReference<T>> childDependencies = child.dependencies();
			
			for(SimpleReference<T> dep : childDependencies) {
				merged.addDependency(dep);
			}

			List<SimpleReference<T>> parentDependencies = parent.dependencies();
			List<SimpleReference<T>> existingDependencies = merged.dependencies();
			
			for(SimpleReference<T> dep : parentDependencies) {
				if (merged.dependencies().size() > 0) {
					for(SimpleReference<T> existing : existingDependencies) {
						if (!existing.getElement().sameAs(dep.getElement())) {
							merged.addDependency(dep);
						}
					}
				} else {
					merged.addDependency(dep);
				}
			}
		} else {
			merged = (E) this;
		}
		
		return merged;
	}

	@Override
	public boolean sameMemberAs(MViewMember other) throws ModelException {
		return other != null
			&& other instanceof Dependency;
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer(parent().toString() + " dependency: ");
		for (SimpleReference<T> ref : dependencies()) {
			try {
				s.append(ref.getElement().signature().name());
			} catch (LookupException e) {
				e.printStackTrace();
			}
			s.append(", ");
		}
		return s.toString();
	}

	
}
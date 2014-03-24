/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RequiredInterface.java
 * created:  Dec 21, 2010, 4:52:26 PM
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
package mview.model.module;

import java.util.ArrayList;
import java.util.List;

import mview.exception.MergeNotSupportedException;
import mview.model.language.MView;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;
import mview.model.refinement.modifier.Overridable;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.TargetDeclaration;
import be.kuleuven.cs.distrinet.chameleon.core.element.ElementImpl;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.DeclarationCollector;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.DeclarationSelector;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupContext;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.ElementWithModifiersImpl;
import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;
import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import be.kuleuven.cs.distrinet.chameleon.util.Util;
import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class Dependency<T extends TargetDeclaration> extends ElementWithModifiersImpl implements MViewMember {

	private final Multi<SimpleReference<T>> _dependencies = new Multi<SimpleReference<T>>(this);

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
		add(_dependencies,relation);
	}
	
	/**
	 * @param relation
	 */
	public void removeDependency(SimpleReference<T> relation) {
		remove(_dependencies,relation);
	}
	
	/**
	 * @param selector
	 * @return
	 * @throws LookupException
	 */
	public <D extends Declaration> List<D> declarations(DeclarationSelector<D> selector) throws LookupException {
		
		List<D> result = new ArrayList<D>();
		
		List<SimpleReference<T>> deps = this.dependencies();
		
		for (SimpleReference<T> reference : deps) {
			T element = reference.getElement();
			LookupContext targetContext = element.targetContext();
			DeclarationCollector<D> collector = new DeclarationCollector<D>(selector);
			targetContext.lookUp(collector);
			if(!collector.willProceed()) {
				D declaration = collector.result();
				Util.addNonNull(declaration, result);
			}
		}

		return (List<D>) selector.declarators(result);
	}

	/**
	 * @return true if overridable
	 */
	public boolean overridable() {
//		return this.hasModifier(new Overridable());
		return this.isTrue(language(MView.class).OVERRIDABLE);
	}
	
	@Override
	public boolean sharesContext(MViewMember other) throws LookupException {
		return (new RefinementContext()).verify(this, other);
	}

	@Override
	public boolean overrides(MViewMember other) throws ModelException {
		return this.overridable() && this.sharesContext(other);
	}

	@Override
	public boolean mergesWith(MViewMember other) throws ModelException {
		return sameMemberAs(other) 
			&& sharesContext(other) 
			&& !overridable();
	}

	@Override
	public Dependency<T> merge(MViewMember other)
			throws MergeNotSupportedException, ModelException {
		Dependency<T> merged;
		
		if (mergesWith(other)) {
			
			Dependency<T> child = clone(this);
			child.setUniParent(parent());
			
			Dependency<T> parent = (Dependency<T>) other.clone();
			parent.setUniParent(other.parent());
			
			merged = (Dependency<T>) cloneSelf();
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
			merged = this;
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

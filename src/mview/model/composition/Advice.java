/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Advice.java
 * created:  Nov 24, 2009, 6:27:38 PM
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
 * You should have received a copy of the GNU General Public License
 *
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mview.model.composition;

import mview.exception.MergeNotSupportedException;
import mview.model.application.Instance;
import mview.model.language.MView;
import mview.model.module.Service;
import mview.model.refinement.AbstractElement;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.ElementWithModifiersImpl;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.Modifier;
import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;
import be.kuleuven.cs.distrinet.rejuse.property.Property;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Advice extends ElementWithModifiersImpl implements MViewMember, AbstractElement { 
	
	
	private Single<SimpleReference<Service>> _service = new Single<SimpleReference<Service>>(this);
	
	/**
	 * @return	the reference to the service
	 */
	public SimpleReference<Service> service() {
		return _service.getOtherEnd();
	}
	
	/**
	 * @param reference	the reference to set
	 */
	public void setService(SimpleReference<Service> relation) {
		set(_service,relation);
	}

	
	
	private Single<SimpleReference<Instance>> _instance = new Single<SimpleReference<Instance>>(this);
	
	/**
	 * @return reference to the instance
	 */
	public SimpleReference<Instance> instance() {
		return _instance.getOtherEnd();
	}
	
	/**
	 * @param simpleReference
	 */
	public void setInstance(SimpleReference<Instance> relation) {
		set(_instance, relation);
	}


	/**
	 * @return the type of this advice
	 */
	public Property type() {
		Property type;
		try {
			type = this.property(language(MView.class).ADVICE_MUTEX);
		} catch (ModelException e) {
			type = null; //this.language(MView.class).BEFORE;
		}
		return type;
	}

	
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	protected Advice cloneSelf() {
		return new Advice();
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		Verification result = Valid.create();
		
//		int n = 0;
//		try {
//			if (this.property(language(MView.class).ADVICE_MUTEX) != null) {
//				n++;
//			}
//		} catch (ModelException e) {
//			result = result.and(new BasicProblem(this, 
//					"Advice: Error in model: Advice type invalid."));
//		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#sharesContext(mview.model.refinement.MViewMember)
	 */
	@Override
	public boolean sharesContext(MViewMember other) throws LookupException {
		return (new RefinementContext().verify(this, other));
	}
	
	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#overrides(mview.model.refinement.MViewMember)
	 */
	@Override
	public boolean overrides(MViewMember other) throws ModelException {
		return false;
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#mergesWith(mview.model.refinement.MViewMember)
	 */
	@Override
	public boolean mergesWith(MViewMember other) throws ModelException {
		return sameMemberAs(other)   
			&& sharesContext(other) 
			&& !overrides(other);
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember)
	 */
	@Override
	public Advice merge(MViewMember other) throws MergeNotSupportedException, ModelException {
		
		Advice merged;
		
		if (mergesWith(other)) {

			Advice child = clone(this);
			child.setUniParent(parent());
			
			Advice parent =clone( ((Advice) other));
			parent.setUniParent(other.parent());
			
			merged = new Advice();
			merged.setUniParent(parent());
			
			if (child.service() != null) {
				merged.setService(child.service());
			} else if (parent.service() != null) {
				merged.setService(parent.service());
			}
			
			Modifier adviceType = null;
			if (child.type() != null) {
				adviceType =
					language(MView.class)
						.adviceTypeModifierForProperty(child.type());
			} else if (parent.type() != null) {
				adviceType = 
					language(MView.class)
						.adviceTypeModifierForProperty(parent.type());
			}
			if (adviceType != null) {
				merged.addModifier(adviceType);
			}
			
		} else {
			merged = this;
		}

		return merged;
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.AbstractElement#isAbstract()
	 */
	@Override
	public boolean isAbstract() {
		return false;
	}


	@Override
	public boolean sameMemberAs(MViewMember other) throws ModelException {
		return other != null 
			&& other instanceof Advice;
	}
	

	@Override
	public String toString() {
		return "advice of " + nearestAncestor(Declaration.class).signature().name();
	}
}

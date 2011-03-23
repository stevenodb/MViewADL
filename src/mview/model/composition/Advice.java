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

import java.util.List;

import mview.exception.MergeNotSupportedException;
import mview.model.language.MView;
import mview.model.module.Service;
import mview.model.refinement.AbstractElement;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;

import org.rejuse.association.SingleAssociation;

import chameleon.core.element.Element;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.modifier.Modifier;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.exception.ModelException;
import chameleon.util.Util;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Advice extends ElementWithModifiersImpl<Advice, Element> 
		implements MViewMember<Advice, Element>, AbstractElement { 
	//extends NamespaceElementImpl<Advice, Element> {
	
	/**
	 * default constructor
	 */
	public Advice() {
	}
	
	/* 
	 * Advice type
	 * through modifier
	 */
		
	
	// Service
	private SingleAssociation<Advice, SimpleReference<Service>> _service =
		new SingleAssociation<Advice, SimpleReference<Service>>(this);
	
	
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
		if (relation != null)
			_service.connectTo(relation.parentLink());
	}

	
//	/**
//	 * @return
//	 */
//	public boolean hasTypeModifier() {
//	}
	
	public Modifier type() {
		Modifier result = null;
		for (Modifier modifier : this.modifiers()) {
			try {
				if (modifier.property(language(MView.class).ADVICE_MUTEX) != null) {
					if (result == null) {
						result = modifier;
					}
				}
			} catch (ModelException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Advice clone() {
		final Advice clone = new Advice();
		
		clone.addModifiers(this.modifiers());
		
		clone.setService(
				this.service().clone()
		);
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = Valid.create();
		
//		int n = 0;
//		try {
//			if (this.property(language(MView.class).ADVICE_MUTEX) != null) {
//				n++;
//			}
//		} catch (ModelException e) {
//			result = result.and(new BasicProblem(this, 
//					"Advice: Error in model: Advice type invalid."));
//		}
		
//		if (! (n == 1) ) {
//			result = result.and(new BasicProblem(this, 
//					"Advice: Type not set. ("+n+")"));
//		}
//		
//		if (! (this.service() != null)) {
//			result = result.and(new BasicProblem(this, 
//					"Advice: Service not set."));
//		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.Element#children()
	 */
	public List<Element> children() {
		final List<Element> result = super.children();
		
		Util.addNonNull(this.service(), result);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#sharesContext(mview.model.refinement.MViewMember)
	 */
	@Override
	public boolean sharesContext(MViewMember other) {
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
		return (other != null) && (this.getClass().equals(other.getClass())) 
			&& sharesContext(other) && !overrides(other);
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember)
	 */
	@Override
	public Advice merge(MViewMember other) throws MergeNotSupportedException, ModelException {
		
		Advice merged;
		
		if (mergesWith(other)) {
			
			merged = new Advice();
			merged.setUniParent(parent());
					
			if (this.service() != null) {
				merged.setService(this.service().clone());
			} else if (((Advice)other).service() != null) {
				merged.setService(((Advice)other).service().clone());
			}
			
			if (this.type() != null) {
				merged.addModifier(this.type());
			} else if (((Advice)other).type() != null) {
				merged.addModifier(((Advice)other).type().clone());
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
	public String toString() {
		return service() != null ? service().toString() : super.toString();
	}
	
}

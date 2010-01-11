/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: PatternJoinPoint.java
 * created:  Nov 27, 2009, 6:05:14 PM
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
package mstage.model.composition;

import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;

import mstage.model.module.Service;

import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;
import chameleon.util.Util;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class PatternJoinPoint<E extends PatternJoinPoint<E>> 
						extends JoinPoint<PatternJoinPoint<E>> {
	
	
	
	/*
	 * The raw pattern
	 */
	private String _rawPattern;

	/**
	 * @return the pattern
	 */
	public String rawPattern() {
		return _rawPattern;
	}

	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern) {
		_rawPattern = pattern;
	}
	
	
	
	/*
	 * Assessors for service association
	 */
	private OrderedMultiAssociation<PatternJoinPoint<?>, SimpleReference<Service>> _services =
		new OrderedMultiAssociation<PatternJoinPoint<?>, SimpleReference<Service>>(this);
	
	/**
	 * @return	a List of references to Services
	 */
	public List<SimpleReference<Service>> services() {
		return _services.getOtherEnds();
	}
	
	/**
	 * @param relation	reference to the Service to add
	 */
	public void addService(SimpleReference<Service> relation) {
		_services.add(relation.parentLink());
	}
	
	/**
	 * @param relation	reference to the Service to remove
	 */
	public void removeService(SimpleReference<Service> relation) {
		_services.remove(relation.parentLink());
	}
	
	
	
	/* (non-Javadoc)
	 * @see mstage.model.composition.JoinPoint#cloneThis()
	 */
	@Override
	protected E cloneThis() {
		return (E) new PatternJoinPoint(); 
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public E clone() {
		final E clone = (E) super.clone();
		
		// 1
		clone.setPattern(
				this.rawPattern() //string is immutable.
		);
		
		// 2
		for (SimpleReference<Service> ref : this.services()) {
			SimpleReference<Service> localClone = ref.clone();
			
			clone.addService(localClone);
		}
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if ( ! (this.rawPattern() != null )  ) {
			result = result.and(new BasicProblem(this, "Raw pattern is null"));
		}
		
		if ( ! (this.services().size() >= 0) ) {
			//nothing
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.Element#children()
	 */
	public List<Element> children() {
		final List<Element> result = super.children();
		
		Util.addNonNull(this.rawPattern(), result);
		result.addAll(this.services());
		
		return result;
	}


}

/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: SingleJoinPoint.java
 * created:  Dec 1, 2009, 1:38:25 PM
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

import mstage.model.module.JoinPointElement;

import org.rejuse.association.SingleAssociation;

import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;
import chameleon.util.Util;

/**
 * @author  Steven Op de beeck <steven /at/ opdebeeck /./ org>
 */
public abstract class SingleJoinPoint<E extends SingleJoinPoint<E,JPE>,JPE extends JoinPointElement> 
					extends JoinPoint<SingleJoinPoint<E,JPE>> {
	
	
	/**
	 * Default constructor
	 */
	public SingleJoinPoint() {
	}
	
	/**
	 * @param joinPoint
	 */
	public SingleJoinPoint(JPE joinPoint) {
		this();
		setShadow(joinPoint);
	}

	/*
	 * Accessors for joinPoint  
	 */
	private SingleAssociation<SingleJoinPoint, JPE> _shadow =
		new SingleAssociation<SingleJoinPoint, JPE>(this);

	/**
	 * @return the joinPoint
	 */
	public JPE shadow() {
		if (_shadow != null)
			return _shadow.getOtherEnd();
		else
			return null;
	}

	/**
	 * @param joinPoint the joinPoint to set
	 */
	public void setShadow(JPE relation) {
		if (relation != null)
			_shadow.connectTo(relation.parentLink());
	}

	
	/* (non-Javadoc)
	 * @see mstage.model.composition.JoinPoint#clone()
	 */
	@Override
	public E clone() {
		final E clone =	(E) super.clone();
	
		clone.setShadow(
				(JPE) this.shadow().clone()
		);
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see mstage.model.composition.JoinPoint#children()
	 */
	@Override
	public List<Element> children() {
		final List<Element> result = super.children();
		
		Util.addNonNull(this.shadow(), result);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mstage.model.composition.JoinPoint#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if ( ! (this.shadow() != null)) {
			result = result.and(new BasicProblem(this, "Missing a joinpoint."));
		}
		
		return result;
	}
	
}
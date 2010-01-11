/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Pointcut.java
 * created:  Nov 26, 2009, 3:09:22 PM
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

import mstage.model.namespace.MStageDeclaration;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.element.Element;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * @param <E>
 *
 */
public class Pointcut extends MStageDeclaration<Pointcut, Element> {

	
	private OrderedMultiAssociation<Pointcut,JoinPoint<?>> _joinpoints =
		new OrderedMultiAssociation<Pointcut, JoinPoint<?>>(this);
	
	/**
	 * @return
	 */
	public List<JoinPoint<?>> joinPoints() {
		return _joinpoints.getOtherEnds();
	}
	
	/**
	 * @param joinPoint
	 */
	public void addJoinPoint(JoinPoint<?> joinPoint) {
		_joinpoints.add(joinPoint.parentLink());
	}
	
	/**
	 * @param joinPoint
	 */
	public void removeJoinPoint(JoinPoint<?> joinPoint) {
		_joinpoints.remove(joinPoint.parentLink());
	}
	
	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#cloneThis()
	 */
	@Override
	protected Pointcut cloneThis() {
		return new Pointcut();
	}
	
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Pointcut clone() {
		final Pointcut clone = super.clone();
		
		for (JoinPoint<?> joinpoint : this.joinPoints()) {
			JoinPoint<?> localClone = joinpoint.clone();
			
			clone.addJoinPoint(localClone);
		}
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if (! (joinPoints().size() >= 1)) {
			result = result.and(new BasicProblem(this, "Does not aggregate any JoinPoint"));
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#children()
	 */
	@Override
	public List<Element> children() {
		List<Element> result = super.children();

		result.addAll(this.joinPoints());
		
		return result;
	}
	
}

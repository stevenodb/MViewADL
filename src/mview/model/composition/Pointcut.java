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
package mview.model.composition;

import java.util.ArrayList;
import java.util.List;

import mview.model.namespace.MStageDeclaration;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * @param <E>
 *
 */
public class Pointcut extends ElementWithModifiersImpl<Pointcut, Element> { 
	// NamespaceElementImpl<Pointcut, Element> {
		
	/**
	 * Default constructor
	 */
	public Pointcut() {
		super();
	}

	// KIND
//	private JoinpointKind _kind;
	
//	/**
//	 * @param kind the kind to set
//	 */
//	public void setKind(JoinpointKind kind) {
//		this._kind = kind;
//	}
//
//	/**
//	 * @return the kind
//	 */
//	public JoinpointKind kind() {
//		return _kind;
//	}

	
	// Join points
	private OrderedMultiAssociation<Pointcut,Signature<?>> _joinpoints =
		new OrderedMultiAssociation<Pointcut, Signature<?>>(this);
	
	/**
	 * @return
	 */
	public List<Signature<?>> joinPoints() {
		return _joinpoints.getOtherEnds();
	}
	
	/**
	 * @param joinPoint
	 */
	public void addJoinPoint(Signature<?> joinPoint) {
		_joinpoints.add(joinPoint.parentLink());
	}
	
	/**
	 * @param joinPoint
	 */
	public void removeJoinPoint(Signature<?> joinPoint) {
		_joinpoints.remove(joinPoint.parentLink());
	}
	
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Pointcut clone() {
		final Pointcut clone = new Pointcut();
		
//		clone.setKind(this.kind());
		
		for (Signature<?> joinpoint : this.joinPoints()) {
			Signature<?> localClone = joinpoint.clone();
			
			clone.addJoinPoint(localClone);
		}
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = Valid.create();
		
//		if (! (this.kind() != null)) {
//			result = result.and(new BasicProblem(this, "Does not have a kind set"));
//		}
		
		if (! ((this.joinPoints() != null) && (this.joinPoints().size() >= 1))) {
			result = result.and(new BasicProblem(this, "Does not aggregate any join point"));
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.Element#children()
	 */
	public List<Element> children() {
		List<Element> result = new ArrayList<Element>();

		result.addAll(this.joinPoints());
		
		return result;
	}	
}

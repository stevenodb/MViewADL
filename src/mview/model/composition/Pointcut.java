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

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.element.Element;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.modifier.Modifier;
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
	// done through modifiers
	
//	/**
//	 * @param kind the kind to set
//	 */
//	public void setKind(Modifier kind) {
//		this.addModifier(kind);
//	}
//
//	/**
//	 * @return the kind
//	 */
//	public Modifier kind() {
//		Modifier result = null;
//		
//		if(this.modifiers().size() > 0) {
//			result = this.modifiers().get(0);
//		}
//		return result;
//	}
	
	
	// signatures
	private OrderedMultiAssociation<Pointcut,Signature<?>> _signatures =
		new OrderedMultiAssociation<Pointcut, Signature<?>>(this);
	
	/**
	 * @return
	 */
	public List<Signature<?>> signatures() {
		return _signatures.getOtherEnds();
	}
	
	/**
	 * @param signature
	 */
	public void addSignature(Signature<?> signature) {
		_signatures.add(signature.parentLink());
	}
	
	/**
	 * @param signature
	 */
	public void removeJoinPoint(Signature<?> signature) {
		_signatures.remove(signature.parentLink());
	}
	
	
	
	// actors
	
	public void addCallerProp() {
		
	}
	
	public void addCalleeProp() {
		
	}
	
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Pointcut clone() {
		final Pointcut clone = new Pointcut();
		
		clone.addModifiers(this.modifiers());
		
		for (Signature<?> joinpoint : this.signatures()) {
			Signature<?> localClone = joinpoint.clone();
			
			clone.addSignature(localClone);
		}
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = Valid.create();
		
		if (! (this.modifiers().size() > 0 )) {
			result = result.and(new BasicProblem(this, "Does not have a kind modifier"));
		}
			
		if (! (this.modifiers().size() < 2)) {
			result = result.and(new BasicProblem(this, "Has more than one kind modifier"));
		}
		
		if (! ((this.signatures() != null) && (this.signatures().size() >= 1))) {
			result = result.and(new BasicProblem(this, "Does not aggregate any join point"));
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.Element#children()
	 */
	public List<Element> children() {
		List<Element> result = super.children();

		result.addAll(this.signatures());
//		result.addAll(this.modifiers()); cfr super.children()
		
		return result;
	}	
}

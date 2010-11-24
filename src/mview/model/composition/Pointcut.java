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

import java.util.List;

import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;

import org.rejuse.association.SingleAssociation;

import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.modifier.Modifier;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import exception.MergeNotSupportedException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * @param <E>
 * 
 */
public class Pointcut extends ElementWithModifiersImpl<Pointcut, Element>
		implements MViewMember<Pointcut, Element> {

	/**
	 * Default constructor
	 */
	public Pointcut() {
		super();
	}

	/**
	 * @param kind
	 *            the kind of pointcut modifier
	 */
	public Pointcut(Modifier kind) {
		this();
		addModifier(kind);
	}

	/*
	 * KIND is realized through modifier
	 */


	/*
	 * SIGNATURE
	 */
	private SingleAssociation<Pointcut, Signature> _signature =
		new SingleAssociation<Pointcut, Signature>(this);
	
	/**
	 * @return
	 */
	public Signature signature() {
		return _signature.getOtherEnd();
	}
	
	/**
	 * @param signature
	 */
	public void setSignature(Signature signature) {
		_signature.connectTo(signature.parentLink());
	}
	
	/**
	 * Clears the signature
	 */
	public void clearSignature() {
		_signature.clear();
	}
	
	/*
	 * ACTORS
	 */

	/*
	 * CALLER 
	 */
	private SingleAssociation<Pointcut, Actor> _caller =
		new SingleAssociation<Pointcut, Actor>(this);

	
	/**
	 * Add Caller actor
	 * @param actor
	 */
	public void setCaller(Actor actor) {
		_caller.connectTo(actor.parentLink());
	}
	
	/**
	 * Clear Caller actor
	 * @param actor
	 */
	public void clearCaller() {
		_caller.clear();
	}
	
	/**
	 * @return the Caller actor
	 */
	public Actor caller() {
		return _caller.getOtherEnd();
	}


	/*
	 * CALLEE 
	 */
	private SingleAssociation<Pointcut, Actor> _callee =
		new SingleAssociation<Pointcut, Actor>(this);

	/**
	 * Add Callee actor
	 * @param actor
	 */
	public void setCallee(Actor actor) {
		_callee.connectTo(actor.parentLink());
	}
	
	/**
	 * Clear Callee actor
	 * @param actor
	 */
	public void clearCallee() {
		_callee.clear();
	}
	
	/**
	 * @return the Callee actor
	 */
	public Actor callee() {
		return _callee.getOtherEnd();
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Pointcut clone() {
		final Pointcut clone = new Pointcut();

		// modifiers
		clone.addModifiers(this.modifiers());

		// signature
		clone.setSignature(this.signature());

		clone.setCallee(this.callee().clone());
		clone.setCaller(this.caller().clone());

		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = Valid.create();

		if (!(this.modifiers().size() > 0)) {
			result = result.and(new BasicProblem(this,
					"Does not have a kind modifier"));
		}

		if (!(this.modifiers().size() < 2)) {
			result = result.and(new BasicProblem(this,
					"Has more than one kind modifier"));
		}

		if (! (this.signature() != null)) {
			result = result.and(new BasicProblem(this,
					"Does not have a signature"));
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.Element#children()
	 */
	public List<Element> children() {
		List<Element> result = super.children();

		result.add(this.signature());
		result.add(this.caller());
		result.add(this.callee());

		return result;
	}
	
	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#sharesContext(mview.model.refinement.MViewMember)
	 */
	@Override
	public boolean sharesContext(Pointcut other) {
		return new RefinementContext(this, other).verify();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.refinement.MViewMember#overrides(mview.model.refinement.
	 * MViewMember)
	 */
	@Override
	public boolean overrides(Pointcut member) {
		return false;
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#mergesWith(mview.model.refinement.MViewMember)
	 */
	@Override
	public boolean mergesWith(Pointcut other) {
		return sharesContext(other) && !overrides(other);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember
	 * )
	 */
	@Override
	public Pointcut merge(Pointcut other) throws MergeNotSupportedException {

		Pointcut merged;
		
		if (mergesWith(other)) {
			
			Pointcut child = this.clone();
			Pointcut parent = other.clone();
			
			// 1. kind modifier: override with child's kind
			merged = new Pointcut(child.modifiers().get(0));
			
			// 2. signature
			merged.setSignature(child.signature().merge(parent.signature()));
			
			// 3. CallerProps
			merged.setCaller(child.caller().merge(parent.caller()));
			
			// 4. CalleeProps
			merged.setCallee(child.callee().merge(parent.callee()));
		} else {
			merged = this.clone();
		}
		

		return merged;
	}
}

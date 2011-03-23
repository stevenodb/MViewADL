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

import mview.exception.MergeNotSupportedException;
import mview.model.language.MView;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;

import org.rejuse.association.SingleAssociation;

import chameleon.core.element.Element;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.modifier.Modifier;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.exception.ModelException;
import chameleon.util.Util;

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
	 *           the kind of pointcut modifier
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
	private SingleAssociation<Pointcut, PointcutSignature> _pointcutSignature =
			new SingleAssociation<Pointcut, PointcutSignature>(
																															this);


	/**
	 * @return
	 */
	public PointcutSignature signature() {
		return _pointcutSignature.getOtherEnd();
	}


	/**
	 * @param pointcutSignature
	 */
	public void setSignature(PointcutSignature pointcutSignature) {
		if (pointcutSignature != null)
			_pointcutSignature.connectTo(pointcutSignature.parentLink());
	}


	/**
	 * Clears the signature
	 */
	public void clearSignature() {
		_pointcutSignature.clear();
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
	 * 
	 * @param actor
	 */
	public void setCaller(Actor actor) {
		if (actor != null) {
			_caller.connectTo(actor.parentLink());
		}
	}


	/**
	 * Clear Caller actor
	 * 
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
	 * 
	 * @param actor
	 */
	public void setCallee(Actor actor) {
		if (actor != null) {
			_callee.connectTo(actor.parentLink());
		}
	}


	/**
	 * Clear Callee actor
	 * 
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
		if (this.signature() != null) {
			clone.setSignature(this.signature().clone());
		}

		if (this.callee() != null) {
			clone.setCallee(this.callee().clone());
		}

		if (this.caller() != null) {
			clone.setCaller(this.caller().clone());
		}

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

		// if (! (this.isTrue(language(MView.class).CALL)
		// || this.isTrue(language(MView.class).EXTENDABLE))) {
		// result = result.and(new BasicProblem(this,
		// "Pointcut: Kind not set."));
		// }
		//
		// if (! (this.signature() != null)) {
		// result = result.and(new BasicProblem(this,
		// "Pointcut: Signature not set."));
		// }

		return result;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.Element#children()
	 */
	public List<Element> children() {
		List<Element> result = super.children();

		Util.addNonNull(signature(), result);
		Util.addNonNull(caller(), result);
		Util.addNonNull(callee(), result);

		return result;
	}


	@Override
	public boolean sharesContext(MViewMember other) {
		return (new RefinementContext().verify(this, other));
	}


	@Override
	public boolean overrides(MViewMember member) throws ModelException {
		return false;
	}


	@Override
	public boolean mergesWith(MViewMember other) throws ModelException {
		return (other != null) && (this.getClass().equals(other.getClass()))
				&& sharesContext(other) && !overrides(other);
	}


	@Override
	public Pointcut merge(MViewMember other) throws MergeNotSupportedException,
			ModelException {

		Pointcut merged;

		if (mergesWith(other)) {

			Pointcut child = this.clone();
			// Pointcut child = this;
			Pointcut parent = (Pointcut) other.clone();
			// Pointcut parent = (Pointcut) other;
			child.setUniParent(parent());
			parent.setUniParent(other.parent());

			merged = new Pointcut();
			merged.setUniParent(parent());

			// 1. kind modifier: override with child's kind
			merged.addModifiers(child.modifiers());

			// 2. signature
			if (child.signature() != null) {
				PointcutSignature newSignature =
						child.signature().merge(parent.signature());
				newSignature.setUniParent(null);
				merged.setSignature(newSignature);
			} else {
				merged.setSignature(parent.signature());
			}

			// 3. CallerProps
			if (child.caller() != null) {
				Actor newCaller = child.caller().merge(parent.caller());
				newCaller.setUniParent(null);
				merged.setCaller(newCaller);
			} else {
				merged.setCaller(parent.caller());
			}

			// 4. CalleeProps
			if (child.callee() != null) {
				Actor newCallee = child.callee().merge(parent.callee());
				newCallee.setUniParent(null);
				merged.setCallee(newCallee);
			} else {
				merged.setCallee(parent.callee());
			}

		} else {
			merged = this;
		}
		return merged;
	}


	@Override
	public String toString() {
		return signature() != null ? signature().toString() : super.toString();
	}
}

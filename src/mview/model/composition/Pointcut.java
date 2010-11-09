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
import mview.model.refinement.RefinableDeclaration;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
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
	 * SIGNATURES
	 */
	private OrderedMultiAssociation<Pointcut, PointcutSignature> _signatures =
			new OrderedMultiAssociation<Pointcut, PointcutSignature>(this);

	private boolean _signatureOverride = false;

	/**
	 * @return
	 */
	public List<PointcutSignature> signatures() {
		return _signatures.getOtherEnds();
	}

	/**
	 * @param signature
	 */
	public void addSignature(PointcutSignature signature) {
		_signatures.add(signature.parentLink());
	}

	/**
	 * @param signatures
	 */
	public void addAllSignatures(List<PointcutSignature> signatures) {
		for (PointcutSignature signature : signatures) {
			addSignature(signature);
		}
	}

	/**
	 * @param signature
	 */
	public void removeSignature(PointcutSignature signature) {
		_signatures.remove(signature.parentLink());
	}

	/**
	 * @param signatureOverride
	 *            the signatureOverride to set
	 */
	public void setSignatureOverride(boolean signatureOverride) {
		this._signatureOverride = signatureOverride;
	}

	/**
	 * @return the signatureOverride
	 */
	public boolean signatureOverride() {
		return _signatureOverride;
	}

	/*
	 * ACTORS
	 */

	/**
	 * Generic actor prop getter based on given declarationType
	 * 
	 * @param <D>
	 * @param declarationType
	 * @param props
	 * @return
	 */
	private <D extends Declaration> Actor<D> actorProp(
			Class<D> declarationType,
			List<Actor> props) {

		Actor<D> result = null;

		for (Actor actor : props) {
			if (actor.declarationType().equals(declarationType)) {
				result = actor;
				break;
			}
		}

		return result;
	}

	// caller
	OrderedMultiAssociation<Pointcut, Actor> _callerProps =
			new OrderedMultiAssociation<Pointcut, Actor>(this);

	/**
	 * @param actor
	 */
	public void addCallerProp(Actor actor) {
		_callerProps.add(actor.parentLink());
	}

	/**
	 * @param actors
	 */
	public void addAllCallerProps(List<Actor> actors) {
		for (Actor actor : actors) {
			this.addCallerProp(actor);
		}
	}

	/**
	 * Remove actor from caller props
	 * 
	 * @param actor
	 */
	public void removeCallerProp(Actor actor) {
		_callerProps.remove(actor.parentLink());
	}

	/**
	 * @return
	 */
	public List<Actor> callerProps() {
		return _callerProps.getOtherEnds();
	}

	/**
	 * @param <D>
	 * @param declarationType
	 * @return
	 */
	public <D extends Declaration> Actor<D> callerProp(Class<D> declarationType) {
		return actorProp(declarationType, callerProps());
	}

	// callee
	OrderedMultiAssociation<Pointcut, Actor> _calleeProps =
			new OrderedMultiAssociation<Pointcut, Actor>(this);

	/**
	 * @param actor
	 */
	public void addCalleeProp(Actor actor) {
		_calleeProps.add(actor.parentLink());
	}

	/**
	 * @param actors
	 */
	public void addAllCalleeProps(List<Actor> actors) {
		for (Actor actor : actors) {
			this.addCalleeProp(actor);
		}
	}

	/**
	 * Remove actor from callee props
	 * 
	 * @param actor
	 */
	public void removeCalleeProp(Actor actor) {
		_calleeProps.remove(actor.parentLink());
	}

	/**
	 * @return
	 */
	public List<Actor> calleeProps() {
		return _calleeProps.getOtherEnds();
	}

	/**
	 * @param <D>
	 * @param declarationType
	 * @return
	 */
	public <D extends Declaration> Actor<D> calleeProp(Class<D> declarationType) {
		return actorProp(declarationType, calleeProps());
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

		// signatures
		for (PointcutSignature sig : this.signatures()) {
			clone.addSignature(sig.clone());
		}

		// callees
		for (Actor<?> actor : calleeProps()) {
			clone.addCalleeProp(actor.clone());
		}

		// callers
		for (Actor<?> actor : callerProps()) {
			clone.addCallerProp(actor.clone());
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

		if (!(this.modifiers().size() > 0)) {
			result = result.and(new BasicProblem(this,
					"Does not have a kind modifier"));
		}

		if (!(this.modifiers().size() < 2)) {
			result = result.and(new BasicProblem(this,
					"Has more than one kind modifier"));
		}

		if (!((this.signatures() != null) && (this.signatures().size() >= 1))) {
			result = result.and(new BasicProblem(this,
					"Does not aggregate any join point"));
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

		result.addAll(this.signatures());
		result.addAll(this.callerProps());
		result.addAll(this.calleeProps());

		return result;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember
	 * )
	 */
	@Override
	public Pointcut merge(Pointcut other) throws MergeNotSupportedException {
		RefinableDeclaration thisD =
				this.nearestAncestor(RefinableDeclaration.class);
		RefinableDeclaration otherD =
				other.nearestAncestor(RefinableDeclaration.class);

		if (!thisD.hasParent(otherD)) {
			throw new MergeNotSupportedException(
					"This member and other member " +
							"do not share the same refinement context.");
		}

		Pointcut child = this.clone();
		Pointcut parent = other.clone();

		// 1. kind modifier: override with child's kind
		Pointcut merged = new Pointcut(child.modifiers().get(0));

		// 2. signature
		merged.addAllSignatures(child.signatures());
		if (!this.signatureOverride()) {
			merged.addAllSignatures(parent.signatures());
		}

		// 3. CallerProps

		// for all caller props
		for (Actor childCallerProp : child.callerProps()) {

			// get the respective prop of the parent, if it has one
			// in which case, this one's a refinement (merge/overidde) of
			// the parent's
			Actor parentCallerProp =
					parent.callerProp(childCallerProp.declarationType());

			if (parentCallerProp != null) {
				
				// check if the childprop overrides its parent
				if (!childCallerProp.overrides(parentCallerProp)) {
					
					// if it doesn't, merge both of their props
					Actor mergedProp = childCallerProp.merge(parentCallerProp);
					merged.addCallerProp(mergedProp);
				} else {
					
					// if it does, only keep the child's props
					merged.addCallerProp(childCallerProp);
				}

				// remove callerprop from the parent, we are done with it
				parent.removeCallerProp(parentCallerProp);
			}		
		}

		// add remaining parent props
		merged.addAllCallerProps(parent.callerProps());
		
		
		// 4. CalleeProps

		return merged;
	}
}

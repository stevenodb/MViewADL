/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Pointcut.java
 * created:  Nov 26, 2009, 3:09:22 PM
 *
 * Copyright 2013 KU Leuven Research and Development - iMinds - DistriNet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Administrative Contact: dnet-project-office@cs.kuleuven.be
 * Technical Contact: steven@opdebeeck.org
 */
package mview.model.composition;

import java.util.List;

import mview.exception.MergeNotSupportedException;
import mview.model.language.MView;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;
import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import be.kuleuven.cs.distrinet.chameleon.util.Util;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;
import be.kuleuven.cs.distrinet.rejuse.association.SingleAssociation;
import be.kuleuven.cs.distrinet.rejuse.property.Property;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.ElementWithModifiersImpl;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.Modifier;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * @param <E>
 * 
 */
public class Pointcut extends ElementWithModifiersImpl implements MViewMember {

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

	
	/**
	 * Return the kind of advice.
	 * @return
	 */
	public Property kind() {
		Property kind = null;
		if (isTrue(language(MView.class).CALL)) {
			kind = language(MView.class).CALL;
		} else /*if (isTrue(language(MView.class).EXECUTION))*/ {
			kind = language(MView.class).EXECUTION;
		} /* else {
			kind = null;
		} */
		return kind;
	}
	
	/*
	 * SIGNATURE
	 */
	private Single<PointcutSignature> _pointcutSignature = new Single<PointcutSignature>(this);

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
		set(_pointcutSignature,pointcutSignature);
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
	private Single<Actor> _caller =	new Single<Actor>(this);


	/**
	 * Add Caller actor
	 * 
	 * @param actor
	 */
	public void setCaller(Actor actor) {
		set(_caller,actor);
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
	private Single<Actor> _callee = new Single<Actor>(this);


	/**
	 * Add Callee actor
	 * 
	 * @param actor
	 */
	public void setCallee(Actor actor) {
		set(_callee,actor);
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
	protected Pointcut cloneSelf() {
		return new Pointcut();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		Verification result = Valid.create();

//		 if (! (this.isTrue(language(MView.class).CALL)
//		 || this.isTrue(language(MView.class).EXTENDABLE))) {
//		 result = result.and(new BasicProblem(this,
//		 "Pointcut: Kind not set."));
//		 }
//		
//		 if (! (this.signature() != null)) {
//		 result = result.and(new BasicProblem(this,
//		 "Pointcut: Signature not set."));
//		 }

		return result;
	}

	@Override
	public boolean sharesContext(MViewMember other) throws LookupException {
		return (new RefinementContext().verify(this, other));
	}


	@Override
	public boolean overrides(MViewMember member) throws ModelException {
		return false;
	}


	@Override
	public boolean mergesWith(MViewMember other) throws ModelException {
		return sameMemberAs(other) && sharesContext(other) && !overrides(other);
	}


	@Override
	public Pointcut merge(MViewMember other) throws MergeNotSupportedException, ModelException {
		Pointcut merged;
		if (mergesWith(other)) {
			Pointcut child = clone(this);
			// Pointcut child = this;
			Pointcut parent = clone(((Pointcut) other));
			// Pointcut parent = (Pointcut) other;
			child.setUniParent(parent());
			parent.setUniParent(other.parent());

			merged = new Pointcut();
			merged.setUniParent(parent());

			// 1. kind modifier: override with child's kind
			Modifier pointcutKind = null;
			if (child.kind() != null) {
				pointcutKind = 
					(language(MView.class).pointcutKindModifierForProperty(child.kind()));
			} else if (parent.kind() != null) {
				pointcutKind =
					(language(MView.class).pointcutKindModifierForProperty(parent.kind()));
			}
			if (pointcutKind != null) {
				merged.addModifier(pointcutKind);
			}

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
		return "pointcut of " + nearestAncestor(Declaration.class).signature().name();
	}


	@Override
	public boolean sameMemberAs(MViewMember other) throws ModelException {
		return other != null
			&& other instanceof Pointcut;
	}
}

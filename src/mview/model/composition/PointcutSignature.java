/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: PointcutSignature.java
 * created:  Nov 10, 2010, 10:16:03 PM
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

import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;
import mview.exception.MergeNotSupportedException;
import mview.model.language.MView;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;
import mview.model.refinement.modifier.Overridable;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.ElementWithModifiersImpl;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.Modifier;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class PointcutSignature extends ElementWithModifiersImpl implements MViewMember {

	/**
	 * default constructor
	 */
	public PointcutSignature() {
		super();
	}

//	public PointcutSignature(boolean overridable) {
//		this();
//		setOverridable(overridable);
//	}

	/*
	 * SIGNATURES
	 */
	private Multi<ServiceSignature> _pointcutSignatures = new Multi<ServiceSignature>(this);

	/**
	 * @return
	 */
	public List<ServiceSignature> signatures() {
		return _pointcutSignatures.getOtherEnds();
	}

	/**
	 * @param signature
	 */
	public void addSignature(ServiceSignature signature) {
		add(_pointcutSignatures,signature);
	}

	/**
	 * @param signatures
	 */
	public void addAllSignatures(List<ServiceSignature> signatures) {
		for (ServiceSignature signature : signatures) {
			addSignature(signature);
		}
	}

	/**
	 * @param signature
	 */
	public void removeSignature(ServiceSignature signature) {
		remove(_pointcutSignatures,signature);
	}

	/**
	 * @return true if overridable
	 */
	public boolean overridable() {
//		return this.hasModifier(new Overridable());
		return this.isTrue(language(MView.class).OVERRIDABLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	protected PointcutSignature cloneSelf() {
		return new PointcutSignature();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		Verification result = Valid.create();

		if (!((this.signatures() != null) && (this.signatures().size() >= 1))) {
			result = result.and(new BasicProblem(this,
					"Does not aggregate any signature"));
		}

		return result;
	}
	
	@Override
	public boolean sharesContext(MViewMember other) throws LookupException {
		return new RefinementContext().verify(this, other);
	}

	@Override
	public boolean overrides(MViewMember other) throws ModelException {
		return this.overridable() && this.sharesContext(other);
	}

	@Override
	public boolean mergesWith(MViewMember other) throws ModelException {
		return sameMemberAs(other)
			&& sharesContext(other) 
			&& !overridable();
	}

	@Override
	public PointcutSignature merge(MViewMember other) throws MergeNotSupportedException, ModelException {
		
		PointcutSignature merged;
		
		if (mergesWith(other) ) {
			merged = clone(this);
			merged.setUniParent(parent());
			merged.addAllSignatures(((PointcutSignature)other).signatures());
		} else {
			merged = this;
		}
		
		return merged;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (ServiceSignature sig : signatures()) {
			result.append(sig.toString());
		}
		return result.toString();
	}

	@Override
	public boolean sameMemberAs(MViewMember other) throws ModelException {
		return other != null
			&& other instanceof PointcutSignature;
	}	
}




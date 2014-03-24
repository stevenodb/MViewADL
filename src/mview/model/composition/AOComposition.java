/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: AOComposition.java
 * created:  Nov 24, 2009, 5:52:14 PM
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

import java.util.ArrayList;
import java.util.List;

import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinableMemberDeclarationImpl;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupContext;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class AOComposition extends RefinableMemberDeclarationImpl {

	/**
	 * 
	 */
	protected AOComposition() {
		super();
	}

	/**
	 * @param signature
	 */
	public AOComposition(SimpleNameSignature signature) {
		super(signature);
	}

	/*
	 * Advice
	 */
	private Single<Advice> _advice = new Single<Advice>(this);

	/**
	 * @return
	 */
	protected Advice advice() {
		return _advice.getOtherEnd();
	}

	/**
	 * @param relation
	 */
	public void setAdvice(Advice relation) {
		set(_advice,relation);
	}

	/*
	 * Pointcut
	 */
	private Single<Pointcut> _pointcut = new Single<Pointcut>(this);

	/**
	 * @return
	 */
	protected Pointcut pointcut() {
		if (_pointcut != null)
			return _pointcut.getOtherEnd();
		else
			return null;
	}

	/**
	 * @param relation
	 */
	public void setPointcut(Pointcut relation) {
		set(_pointcut,relation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#cloneThis()
	 */
	@Override
	protected AOComposition cloneSelf() {
		return new AOComposition();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		Verification result = super.verifySelf();

		if (!isAbstract()) {

			try {
				if (!(this.members(Advice.class).size() > 0)) {
					result = result.and(new BasicProblem(this,
									"Composition "+ signature().name() +": Needs an advice."));
				}
			} catch (LookupException e) {
				result = result.and(new BasicProblem(this,
									""));
			}

			try {
				if (!(this.members(Pointcut.class).size() > 0)) {
					result =
							result.and(new BasicProblem(this,
									"Composition "+ signature().name() +": Needs a pointcut."));
				}
			} catch (LookupException e) {
			}
		}

		return result;
	}

	// /* (non-Javadoc)
	// * @see
	// mview.model.refinement.MViewMember#overrides(mview.model.refinement.MViewMember)
	// */
	// @Override
	// public boolean overrides(AOComposition other) {
	// return this.equals(other);
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember)
	// */
	// @Override
	// public AOComposition merge(AOComposition member)
	// throws MergeNotSupportedException {
	// throw new MergeNotSupportedException(this+" does not support merge");
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.refinement.RefinableDeclaration#localMembers()
	 */
	@Override
	public List<MViewMember> localMembers() {
		List<MViewMember> result = new ArrayList<MViewMember>();
		result.add(advice());
		result.add(pointcut());
		return result;
	}

	@Override
	public LookupContext localContext() throws LookupException {
		return language().lookupFactory().createLocalLookupStrategy(this);
	}

}

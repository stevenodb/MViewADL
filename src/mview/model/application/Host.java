/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Host.java
 * created:  Jun 16, 2010, 12:19:08 PM
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
package mview.model.application;

import java.util.List;

import be.kuleuven.cs.distrinet.chameleon.util.Util;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;
import mview.model.deployment.HostName;
import mview.model.refinement.MViewMemberDeclarationImpl;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 * @param <E>
 */
public class Host extends MViewMemberDeclarationImpl {

	/**
	 * default
	 */
	public Host() {
		super();
	}

	/**
	 * @param signature
	 */
	public Host(SimpleNameSignature signature) {
		super(signature);
	}

	/*
	 * HOSTNAME
	 */
	private Single<HostName> _hostName = new Single<HostName>(this);

	/**
	 * @param hostName
	 *            the hostName to set
	 */
	public void setHostName(HostName hostName) {
		set(_hostName, hostName);
	}

	/**
	 * @return the hostName
	 */
	public HostName hostName() {
		return _hostName.getOtherEnd();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#cloneThis()
	 */
	@Override
	protected Host cloneSelf() {
		return new Host();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		final Verification result = super.verifySelf();
		return result;
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// mview.model.refinement.MViewMember#overrides(mview.model.refinement.
	// * MViewMember)
	// */
	// @Override
	// public boolean overrides(Host other) {
	// boolean equal = this.equals(other);
	// boolean inARelationship =
	// this.nearestAncestor(RefinableDeclaration.class).hasParent(
	// other.nearestAncestor(RefinableDeclaration.class));
	// return equal && inARelationship;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// *
	// mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember
	// * )
	// */
	// @Override
	// public Host merge(Host member) throws MergeNotSupportedException {
	// throw new MergeNotSupportedException(this + " doesn't support merge.");
	// }

}

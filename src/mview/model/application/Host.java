/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Host.java
 * created:  Jun 16, 2010, 12:19:08 PM
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
 * You should have received a copy of the GNU General Public License. 
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mview.model.application;

import java.util.List;

import mview.model.deployment.HostName;
import mview.model.refinement.MViewMemberDeclarationImpl;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.validation.VerificationResult;
import chameleon.util.Util;
import chameleon.util.association.Single;

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
		set(_hostName,hostName);
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
	protected Host cloneThis() {
		return new Host();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#clone()
	 */
	@Override
	public Host clone() {
		final Host clone = (Host) super.clone();
		clone.setHostName((HostName) hostName().clone());
		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		final VerificationResult result = super.verifySelf();
		return result;
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see mview.model.refinement.MViewMember#overrides(mview.model.refinement.
//	 * MViewMember)
//	 */
//	@Override
//	public boolean overrides(Host other) {
//		boolean equal = this.equals(other);
//		boolean inARelationship =
//				this.nearestAncestor(RefinableDeclaration.class).hasParent(
//						other.nearestAncestor(RefinableDeclaration.class));
//		return equal && inARelationship;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember
//	 * )
//	 */
//	@Override
//	public Host merge(Host member) throws MergeNotSupportedException {
//		throw new MergeNotSupportedException(this + " doesn't support merge.");
//	}

}
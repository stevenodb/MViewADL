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

import org.rejuse.association.SingleAssociation;

import mview.model.deployment.HostName;
import mview.model.namespace.MViewDeclaration;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 * @param <E>
 */
public class Host extends MViewDeclaration<Host, Element> {

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
	private SingleAssociation<Host, SimpleReference<HostName>> _hostName =
			new SingleAssociation<Host, SimpleReference<HostName>>(this);

	/**
	 * @param hostName
	 *            the hostName to set
	 */
	public void setHostName(SimpleReference<HostName> hostName) {
		_hostName.connectTo(hostName.parentLink());
	}

	/**
	 * @return the hostName
	 */
	public SimpleReference<HostName> hostName() {
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
		final Host clone = super.clone();
		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#children()
	 */
	@Override
	public List<Element> children() {
		final List<Element> result = super.children();
		return result;
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

}
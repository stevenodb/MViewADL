/**
 * author:     Steven Op de beeck <steven /at/ opdebeeck /./ org>
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
package mview.model.module;

import java.util.ArrayList;
import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;
import org.rejuse.association.SingleAssociation;

import chameleon.core.declaration.Signature;
import chameleon.core.element.Element;
import chameleon.core.method.MethodHeader;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.core.variable.FormalParameter;
import chameleon.oo.type.TypeReference;
import chameleon.support.member.simplename.SimpleNameMethodHeader;
import chameleon.util.Util;

public class Service extends JoinPointElement<Service, Element> {

	/**
	 * Default constructor
	 */
	protected Service() {
	}

	/**
	 * @param signature
	 * @param returnType
	 * @param formalParameters
	 */
	public Service(Signature signature, TypeReference returnType,
			List<FormalParameter> formalParameters) {
		this(signature,returnType,formalParameters,null);
	}
	
	/**
	 * @param signature
	 * @param returnType
	 * @param formalParameters
	 * @param properties
	 */
	public Service(Signature signature, TypeReference returnType,
			List<FormalParameter> formalParameters,
			List<SimpleReference<Property>> properties) {

		super();

		// return type
		if (returnType != null) {
			setReturnType(returnType);
		}

		// signature (+formal parameters)
		MethodHeader header = new SimpleNameMethodHeader(signature.toString());

		if (formalParameters != null) {
			for (FormalParameter formalParameter : formalParameters) {
				header.addFormalParameter(formalParameter);
			}
		}
		setHeader(header);

		// properties
		if (properties != null) {
			for (SimpleReference<Property> property : properties) {
				addProperty(property);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#signature()
	 */
	@Override
	public Signature signature() {
		return header().signature();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * chameleon.core.method.MethodHeader#addFormalParameter(chameleon.core.
	 * variable.FormalParameter)
	 */
	/**
	 * @param arg
	 */
	public void addFormalParameter(FormalParameter arg) {
		header().addFormalParameter(arg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.method.MethodHeader#formalParameters()
	 */
	/**
	 * @return a List of FormalParameter objects
	 */
	public List<FormalParameter> formalParameters() {
		return header().formalParameters();
	}

	/*
	 * Association to the return type
	 */
	private final SingleAssociation<Service, TypeReference> _returnType =
			new SingleAssociation<Service, TypeReference>(this);

	/**
	 * @return the service's return type
	 */
	public TypeReference returnType() {
		return _returnType.getOtherEnd();
	}

	/**
	 * @param returnType
	 */
	public void setReturnType(TypeReference returnType) {
		if (returnType != null) {
			_returnType.connectTo(returnType.parentLink());
		}
	}

	/*
	 * Association to the Service
	 */
	private final SingleAssociation<Service, MethodHeader> _header =
			new SingleAssociation<Service, MethodHeader>(this);

	/**
	 * @return the service's header
	 */
	public MethodHeader header() {
		return _header.getOtherEnd();
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(MethodHeader header) {
		if (header != null) {
			_header.connectTo(header.parentLink());
		}
	}

	/*
	 * The service's attached properties
	 */
	private final OrderedMultiAssociation<Service, SimpleReference<Property>> _attachedProperties =
			new OrderedMultiAssociation<Service, SimpleReference<Property>>(
					this);

	/**
	 * @return the attached properties
	 */
	public List<SimpleReference<Property>> attachedProperties() {
		return _attachedProperties.getOtherEnds();
	}

	/**
	 * @param relation
	 *            the property to attach
	 */
	public void addProperty(SimpleReference<Property> relation) {
		_attachedProperties.add(relation.parentLink());
	}

	/**
	 * @param relation
	 *            the service to remove from the aggregation
	 */
	public void removeProperty(SimpleReference<Property> relation) {
		_attachedProperties.remove(relation.parentLink());
	}

	// /* (non-Javadoc)
	// * @see mview.model.namespace.MViewDeclaration#cloneThis()
	// */
	// @Override
	// protected Service cloneThis() throws InstantiationException,
	// IllegalAccessException {
	// return this.getClass().newInstance();
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#cloneThis()
	 */
	@Override
	protected Service cloneThis() {
		return new Service();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Service clone() {
		final Service clone = super.clone();

		clone.setHeader(
				this.header().clone()
				);

		clone.setReturnType(
				this.returnType().clone()
				);

		for (SimpleReference<Property> property : attachedProperties()) {
			SimpleReference<Property> localClone = property.clone();

			clone.addProperty(localClone);
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

		if (!(this.header() != null)) {
			result = result.and(new BasicProblem(this, "Missing header"));
		}

		if (!(this.returnType() != null)) {
			result = result.and(new BasicProblem(this, "ReturnType is null"));
		}

		if (!(this.attachedProperties() != null)) {
			result =
					result.and(new BasicProblem(this,
							"AttachedProperties is null"));
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#children()
	 */
	@Override
	public List<Element> children() {
		// The super method only adds the signature, but for a Service,
		// the signature is generated, so we don't add it.
		final List<Element> result = new ArrayList<Element>();

		Util.addNonNull(this.header(), result);
		Util.addNonNull(this.returnType(), result);
		
		result.addAll(attachedProperties());

		return result;
	}

}

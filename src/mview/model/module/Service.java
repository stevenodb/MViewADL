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

import chameleon.core.declaration.DeclarationWithParametersHeader;
import chameleon.core.declaration.Signature;
import chameleon.core.declaration.SimpleNameDeclarationWithParametersHeader;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.method.Method;
import chameleon.core.method.SimpleNameMethodHeader;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.core.variable.FormalParameter;
import chameleon.oo.type.BasicTypeReference;
import chameleon.support.member.simplename.method.NormalMethod;
import chameleon.util.Util;

public class Service extends JoinPointElement<Service> {

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
	public Service(Signature signature, BasicTypeReference returnType,
			List<FormalParameter> formalParameters) {
		this(signature, returnType, formalParameters, null);
	}


	/**
	 * @param signature
	 * @param returnType
	 * @param formalParameters
	 * @param properties
	 */
	public Service(Signature signature, BasicTypeReference returnType,
			List<FormalParameter> formalParameters,
			List<SimpleReference<Property>> properties) {

		super();

		// returnType, signature, formal parameters
		
		Method method = new NormalMethod(
				new SimpleNameMethodHeader(signature.name(), 
				returnType));

		if (formalParameters != null) {
			for (FormalParameter formalParameter : formalParameters) {
				method.header().addFormalParameter(formalParameter);
			}
		}
		
		this.setMethod(method);

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
		//return header().signature();
		Signature result = new SimpleNameSignature(method().name());
		result.setUniParent(this);
		return result;
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
		method().header().addFormalParameter(arg);
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
		return method().formalParameters();
	}

//	/*
//	 * Association to the return type
//	 */
//	private final SingleAssociation<Service, BasicTypeReference> _returnType =
//			new SingleAssociation<Service, BasicTypeReference>(this);


	/**
	 * @return the service's return type
	 */
	public BasicTypeReference returnType() {
		return (BasicTypeReference) method().returnTypeReference();
	}


	/**
	 * @param returnType
	 */
	public void setReturnType(BasicTypeReference returnType) {
		if (returnType != null) {
			method().setReturnTypeReference(returnType);
		}
	}

	/*
	 * Association to the Service
	 */
	private final SingleAssociation<Service, Method> _method =
			new SingleAssociation<Service, Method>(this);


	/**
	 * @return the service's header
	 */
	public Method method() {
		return _method.getOtherEnd();
	}


	/**
	 * @param method
	 *            the header to set
	 */
	public void setMethod(Method method) {
		if (method != null) {
			_method.connectTo(method.parentLink());
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

		clone.setMethod(
				this.method().clone()
				);

		clone.setReturnType(
				this.returnType().clone()
				);

		for (SimpleReference<Property> property : attachedProperties()) {
			clone.addProperty(property.clone());
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

		if (!(this.method() != null)) {
			result = result.and(new BasicProblem(this,
					this.signature().name() + ": Missing header"));
		}

		if (!(this.returnType() != null)) {
			result = result.and(new BasicProblem(this,
					this.signature().name() + ": ReturnType is null"));
		}

		if (!(this.attachedProperties() != null)) {
			result = result.and(new BasicProblem(this,
					this.signature().name() + ": AttachedProperties is null"));
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

		Util.addNonNull(this.method(), result);
		Util.addNonNull(this.returnType(), result);

		result.addAll(attachedProperties());

		return result;
	}


	@Override
	public String toString() {
		return signature() != null ? signature().toString() : super.toString(); 
	}

}

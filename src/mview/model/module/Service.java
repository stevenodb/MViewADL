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

import java.util.List;

import mview.model.refinement.MViewMemberDeclarationImpl;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Signature;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.oo.method.Method;
import be.kuleuven.cs.distrinet.chameleon.oo.method.SimpleNameMethodHeader;
import be.kuleuven.cs.distrinet.chameleon.oo.type.BasicTypeReference;
import be.kuleuven.cs.distrinet.chameleon.oo.variable.FormalParameter;
import be.kuleuven.cs.distrinet.chameleon.support.member.simplename.method.NormalMethod;
import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

public class Service extends MViewMemberDeclarationImpl implements JoinPointElement {

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
				new SimpleNameMethodHeader(signature.name(),returnType));

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


	/**
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

	/**
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
	private Single< Method> _method = new Single<Method>(this);


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
		set(_method,method);
	}

	/*
	 * The service's attached properties
	 */
	private final Multi<SimpleReference<Property>> _attachedProperties = new Multi<SimpleReference<Property>>(this);


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
		add(_attachedProperties,relation);
	}


	/**
	 * @param relation
	 *            the service to remove from the aggregation
	 */
	public void removeProperty(SimpleReference<Property> relation) {
		remove(_attachedProperties,relation);
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
		final Service clone = (Service) super.clone();
		clone.setMethod(this.method().clone());
		clone.setReturnType(this.returnType().clone());
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
	public Verification verifySelf() {
		Verification result = Valid.create();

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

	@Override
	public String toString() {
		return signature() != null ? signature().toString() : super.toString(); 
	}

//
//	@Override
//	public boolean sharesContext(MViewMember other) throws LookupException {
//		return (new RefinementContext()).verify(this, other);
//	}
//
//
//	@Override
//	public boolean overrides(MViewMember other) throws ModelException {
//		boolean result = false;
//		
//		result = sameMemberAs(other)
//			&& this.sharesContext(other);
//		
//		return result;
//	}
//
//
//	@Override
//	public boolean mergesWith(MViewMember other) throws ModelException {
//		return false;
//	}
//
//
//	@Override
//	public MViewMember merge(MViewMember other)
//			throws MergeNotSupportedException, ModelException {
//		throw new MergeNotSupportedException(this + " doesn't support merge.");
//	}
//
//	@Override
//	public boolean sameMemberAs(MViewMember other) throws ModelException {
//		return (other != null)
//				&& other instanceof Service
//				&& this.signature().equals(((Service)other).signature());	
//	}
}

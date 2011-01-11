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

import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinableMemberDeclarationImpl;

import org.rejuse.association.OrderedMultiAssociation;
import org.rejuse.association.SingleAssociation;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;
import chameleon.util.Util;

/**
 * Class representing the Module concept.
 * 
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 * @param <E>
 */
public abstract class Module<E extends Module<E>>
			extends RefinableMemberDeclarationImpl<E, Element> {

	/**
	 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
	 *
	 */
	public class RequiredInterfaceDependency extends
			Dependency<RequiredInterfaceDependency, Interface> {

		@Override
		protected RequiredInterfaceDependency cloneThis() {
			return new RequiredInterfaceDependency();
		}
	}

	/**
	 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
	 *
	 */
	public class ProvidedInterfaceDependency extends
			Dependency<ProvidedInterfaceDependency, Interface> {

		@Override
		protected ProvidedInterfaceDependency cloneThis() {
			return new ProvidedInterfaceDependency();
		}
	}

	/**
	 * Default constructor
	 */
	protected Module() {
//		_providedInterfaces.connectTo((new ProvidedInterfaceDependency()).parentLink());
//		_requiredInterfaces.connectTo((new RequiredInterfaceDependency()).parentLink());
	}

	/**
	 * @param signature
	 */
	protected Module(SimpleNameSignature signature) {
		super(signature);
	}

	/*
	 * Provided Interfaces association
	 */
	private final SingleAssociation<Module<E>, ProvidedInterfaceDependency> _providedInterfaces = (
			new SingleAssociation<Module<E>, ProvidedInterfaceDependency>(this));

	/**
	 * @return
	 */
	private ProvidedInterfaceDependency providedInterfaceDependency() {
		return _providedInterfaces.getOtherEnd();
	}

	/**
	 * @return
	 */
	public List<SimpleReference<Interface>> providedInterfaces() {
		if (providedInterfaceDependency() == null) {
			_providedInterfaces.connectTo(new ProvidedInterfaceDependency().parentLink());
		}
		return providedInterfaceDependency().dependencies();
	}

	/**
	 * @param relation
	 */
	public void addProvidedInterface(SimpleReference<Interface> relation) {
		if (relation != null) {
			if (providedInterfaceDependency() == null) {
				_providedInterfaces.connectTo(new ProvidedInterfaceDependency().parentLink());
			}
			providedInterfaceDependency().addDependency(relation);
		}
	}

	/**
	 * @param relation
	 */
	public void removeProvidedInterface(SimpleReference<Interface> relation) {
		if (relation != null) {
			if (providedInterfaceDependency() == null) {
				_providedInterfaces.connectTo(new ProvidedInterfaceDependency().parentLink());
			}
			providedInterfaceDependency().removeDependency(relation);
		}
	}

	/*
	 * Required Interfaces association
	 */
	private final SingleAssociation<Module<E>, RequiredInterfaceDependency> _requiredInterfaces =
			new SingleAssociation<Module<E>, RequiredInterfaceDependency>(this);

	/**
	 * @return
	 */
	private RequiredInterfaceDependency requiredInterfaceDependency() {
		return _requiredInterfaces.getOtherEnd();
	}

	/**
	 * @return
	 */
	public List<SimpleReference<Interface>> requiredInterfaces() {
		if (requiredInterfaceDependency() == null) {
			_requiredInterfaces.connectTo(new RequiredInterfaceDependency().parentLink());
		}
		return requiredInterfaceDependency().dependencies();
	}

	/**
	 * @param relation
	 */
	public void addRequiredInterface(SimpleReference<Interface> relation) {
		if (relation != null) {
			if (requiredInterfaceDependency() == null) {
				_requiredInterfaces.connectTo(new RequiredInterfaceDependency().parentLink());
			}
			
			requiredInterfaceDependency().addDependency(relation);
		}
	}

	/**
	 * @param relation
	 */
	public void removeRequiredInterface(SimpleReference<Interface> relation) {
		if (relation != null) {
			if (requiredInterfaceDependency() == null) {
				_requiredInterfaces.connectTo(new RequiredInterfaceDependency().parentLink());
			}

			requiredInterfaceDependency().removeDependency(relation);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public E clone() {
		final E clone = super.clone();

		// moved to MViewDeclaration
		// clone.setSignature(signature().clone());

		// TODO: setter
		clone._providedInterfaces.connectTo(providedInterfaceDependency()
				.clone().parentLink());

		clone._requiredInterfaces.connectTo(requiredInterfaceDependency()
				.clone().parentLink());

		// for (SimpleReference<Interface> simpleReference :
		// this.providedInterfaces()) {
		// SimpleReference<Interface> localClone = simpleReference.clone();
		//
		// clone.addProvidedInterface(localClone);
		// }
		// for (SimpleReference<Interface> simpleReference :
		// this.requiredInterfaces()) {
		// SimpleReference<Interface> localClone = simpleReference.clone();
		//
		// clone.addRequiredInterface(localClone);
		// }

		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();

		if (!(signature() != null)) {
			result = result.and(new BasicProblem(this, "Signature invalid."));
		}

		{ // check provided and required interface overlap
			boolean containsAny = false;

			try {

				for (SimpleReference<Interface> provided : this
						.providedInterfaces()) {
					for (SimpleReference<Interface> required : this
							.requiredInterfaces()) {
						if (provided.getElement().sameAs(required.getElement())) {
							containsAny = true;
						}
						if (containsAny)
							break;
					}
					if (containsAny)
						break;
				}

			} catch (LookupException e) {
				e.printStackTrace();
			}

			if (containsAny) {
				result =
					result.and(new BasicProblem(this, this.signature().name()
						+ "Provided and required interfaces should not overlap."));
			}
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
		final List<Element> result = super.children();

		Util.addNonNull(requiredInterfaceDependency(), result);
		Util.addNonNull(providedInterfaceDependency(), result);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.refinement.RefinableDeclaration#localMembers()
	 */
	@Override
	public List<MViewMember> localMembers() {
		List<MViewMember> result = new ArrayList<MViewMember>();

		Util.addNonNull(requiredInterfaceDependency(), result);
		Util.addNonNull(providedInterfaceDependency(), result);

		return result;
	}

}

/**
 * author:     Steven Op de beeck <steven /at/ opdebeeck /./ org>
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
package mview.model.module;

import java.util.ArrayList;
import java.util.List;

import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinableMemberDeclarationImpl;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupContext;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.Modifier;
import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.util.Util;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

/**
 * Class representing the Module concept.
 * 
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 * @param <E>
 */
public abstract class Module extends RefinableMemberDeclarationImpl {

	/**
	 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
	 *
	 */
	public class RequiredInterfaceDependency extends Dependency<Interface> {
		
		@Override
		protected RequiredInterfaceDependency cloneSelf() {
			return new RequiredInterfaceDependency();
		}
	}

	/**
	 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
	 *
	 */
	public class ProvidedInterfaceDependency extends Dependency<Interface> {

		@Override
		protected ProvidedInterfaceDependency cloneSelf() {
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
	private final Single<ProvidedInterfaceDependency> _providedInterfaces = new Single<ProvidedInterfaceDependency>(this);

	/**
	 * @return
	 */
	private ProvidedInterfaceDependency providedInterfaceDependency() {
		return _providedInterfaces.getOtherEnd();
	}

	/**
	 * @return
	 */
	protected List<SimpleReference<Interface>> providedInterfaces() {
		if (providedInterfaceDependency() == null) {
			set(_providedInterfaces,new ProvidedInterfaceDependency());
		}
		return providedInterfaceDependency().dependencies();
	}

	/**
	 * @param relation
	 */
	public void addProvidedInterface(SimpleReference<Interface> relation) {
		if (relation != null) {
			if (providedInterfaceDependency() == null) {
				set(_providedInterfaces,new ProvidedInterfaceDependency());
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
				set(_providedInterfaces,new ProvidedInterfaceDependency());
			}
			providedInterfaceDependency().removeDependency(relation);
		}
	}

	/**
	 * @param modifier
	 */
	public void addProvidedInterfaceModifier(Modifier modifier) {
		if (providedInterfaceDependency() == null) {
			set(_providedInterfaces,new ProvidedInterfaceDependency());
		}
		providedInterfaceDependency().addModifier(modifier);
	}
	
	/*
	 * Required Interfaces association
	 */
	private final Single<RequiredInterfaceDependency> _requiredInterfaces = new Single<RequiredInterfaceDependency>(this);

	/**
	 * @return
	 */
	private RequiredInterfaceDependency requiredInterfaceDependency() {
		return _requiredInterfaces.getOtherEnd();
	}
	
	/**
	 * @return
	 */
	protected List<SimpleReference<Interface>> requiredInterfaces() {
		if (requiredInterfaceDependency() == null) {
			set(_requiredInterfaces,new RequiredInterfaceDependency());
		}
		return requiredInterfaceDependency().dependencies();
	}

	/**
	 * @param relation
	 */
	public void addRequiredInterface(SimpleReference<Interface> relation) {
		if (relation != null) {
			if (requiredInterfaceDependency() == null) {
				set(_requiredInterfaces,new RequiredInterfaceDependency());
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
				set(_requiredInterfaces,new RequiredInterfaceDependency());
			}

			requiredInterfaceDependency().removeDependency(relation);
		}
	}
	
	/**
	 * @param modifier
	 */
	public void adRequiredInterfaceModifier(Modifier modifier) {
		if (requiredInterfaceDependency() == null) {
			set(_requiredInterfaces,new RequiredInterfaceDependency());
		}
		requiredInterfaceDependency().addModifier(modifier);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		Verification result = super.verifySelf();

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
	 * @see mview.model.refinement.RefinableDeclaration#localMembers()
	 */
	@Override
	public List<MViewMember> localMembers() {
		List<MViewMember> result = new ArrayList<MViewMember>();

		Util.addNonNull(requiredInterfaceDependency(), result);
		Util.addNonNull(providedInterfaceDependency(), result);

		return result;
	}

	@Override
	public LookupContext lookupContext(Element element) throws LookupException {
		if (element == requiredInterfaceDependency()) {
			Element parent = parent();
			if (parent != null) {
				return parent().lookupContext(this);
			} else {
				throw new LookupException("Parent of type is null when looking " +
						"for the parent context of a type.");
			}
		} else {
			return super.lookupContext(element);
		}
	}
	
	@Override
	public LookupContext localContext() throws LookupException {
		return language().lookupFactory().createLocalLookupStrategy(this);
	}

}

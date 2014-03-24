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
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.DeclarationSelector;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupContext;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.SelectionResult;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;

public class Interface extends RefinableMemberDeclarationImpl { //implements TargetDeclaration, DeclarationContainer {

	/**
	 * @param signature
	 */
	public Interface(SimpleNameSignature signature) {
		super(signature);
	}

	/*
	 * Association to Services
	 */
	private Multi<Service> _services = new Multi<Service>(this);

	/**
	 * @param service
	 */
	public void removeService(Service service) {
		remove(_services,service);
	}


	/**
	 * @return
	 */
	protected List<Service> services() {
		return _services.getOtherEnds();
	}


	/**
	 * @param service
	 */
	public void addService(Service service) {
		add(_services,service);
	}


	@Override
	protected Interface cloneSelf() {
		return new Interface(null);
	}


	@Override
	public Verification verifySelf() {
		Verification result = super.verifySelf();

		if (!(services() != null)) {
			result = result.and(new BasicProblem(this,
					this.signature().name() + ": Services is null."));
		}

		return result;
	}

//	@Override
//	public LocalLookupStrategy<?> targetContext() throws LookupException {
//		return language().lookupFactory().createTargetLookupStrategy(this);
//	}
//
//
//	@Override
//	public List<? extends Declaration> declarations() throws LookupException {
//		return services();
//	}
//
//
//	@Override
//	public List<? extends Declaration> locallyDeclaredDeclarations()
//			throws LookupException {
//		return declarations();
//	}


	@Override
	public <D extends Declaration> List<? extends SelectionResult> declarations(DeclarationSelector<D> selector)
			throws LookupException {
		return selector.selection(declarations());
	}
	@Override
	public LookupContext localContext() throws LookupException {
		return language().lookupFactory().createLocalLookupStrategy(this);
	}


	@Override
	public List<MViewMember> localMembers() {
		List<MViewMember> result = new ArrayList<MViewMember>();
		result.addAll(services());
		return result;
	}
}

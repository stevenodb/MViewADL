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
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.DeclarationSelector;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupContext;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
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
	protected Interface cloneThis() {
		return new Interface((SimpleNameSignature) this.signature());
	}


	@Override
	public Interface clone() {
		final Interface clone = (Interface) super.clone();

		for (Service service : services()) {
			clone.addService(service.clone());
		}

		return clone;
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
	public <D extends Declaration> List<D> declarations(DeclarationSelector<D> selector)
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

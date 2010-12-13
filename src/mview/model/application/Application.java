/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Application.java
 * created:  Dec 1, 2009, 5:08:45 PM
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
package mview.model.application;

import java.util.ArrayList;
import java.util.List;

import mview.model.module.Module;
import mview.model.module.ModuleContainer;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinableDeclarationImpl;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 * @param <A>
 */
public class Application<A extends Application<A>>
		extends RefinableDeclarationImpl<A, Element>
		implements ModuleContainer {

	// extends HostMapper<Application,AbstractHost,Locate>

	/**
	 * default
	 */
	protected Application() {
		super();
	}

	/**
	 * @param signature
	 */
	public Application(SimpleNameSignature signature) {
		super(signature);
	}

	/*
	 * Hosts
	 */
	private final OrderedMultiAssociation<Application<A>, Host> _hosts =
			new OrderedMultiAssociation<Application<A>, Host>(this);

	/**
	 * @return
	 */
	public List<Host> hosts() {
		return _hosts.getOtherEnds();
	}

	/**
	 * @param host
	 */
	public void addHost(Host host) {
		if (host != null) {
			_hosts.add(host.parentLink());
		}
	}

	/**
	 * @param host
	 */
	public void removeHost(Host host) {
		if (host != null) {
			_hosts.remove(host.parentLink());
		}
	}

	/*
	 * Instances
	 */
	private final OrderedMultiAssociation<Application<A>, Instance> _instances =
			new OrderedMultiAssociation<Application<A>, Instance>(this);

	/**
	 * @return
	 */
	public List<Instance> instances() {
		return _instances.getOtherEnds();
	}

	/**
	 * @param host
	 */
	public void addInstance(Instance instance) {
		if (instance != null) {
			_instances.add(instance.parentLink());
		}
	}

	/**
	 * @param host
	 */
	public void removeInstance(Instance instance) {
		if (instance != null) {
			_instances.remove(instance.parentLink());
		}
	}

	/*
	 * Modules
	 */
	private final OrderedMultiAssociation<Application<A>, Module> _modules =
			new OrderedMultiAssociation<Application<A>, Module>(this);

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.module.ModuleContainer#modules()
	 */
	public List<Module> modules() {
		return _modules.getOtherEnds();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.model.module.ModuleContainer#addModule(mview.model.module.Module)
	 */
	public void addModule(Module module) {
		if (module != null) {
			_modules.add(module.parentLink());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.model.module.ModuleContainer#removeModule(mview.model.module.Module
	 * )
	 */
	public void removeModule(Module module) {
		if (module != null) {
			_modules.remove(module.parentLink());
		}
	}

	/*
	 * REFINEMENT
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.namespace.MViewDeclaration#cloneThis()
	 */
	@Override
	protected A cloneThis() {
		return (A) new Application();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.application.HostMapper#clone()
	 */
	@Override
	public A clone() {
		final A clone = super.clone();

		for (Host host : hosts()) {
			clone.addHost(host.clone());
		}

		for (Instance instance : instances()) {
			clone.addInstance(instance.clone());
		}

		for (Module module : this.modules()) {
			Module localClone = module.clone();
			clone.addModule(localClone);
		}

		return clone;
	}

	// /* (non-Javadoc)
	// * @see
	// mview.model.namespace.MViewDeclaration#uniSameAs(chameleon.core.element.Element)
	// */
	// @Override
	// public boolean uniSameAs(Element other) throws LookupException {
	// return super.uniSameAs(other);
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.application.HostMapper#children()
	 */
	@Override
	public List<Element> children() {
		final List<Element> result = super.children();
		result.addAll(modules());
		result.addAll(instances());
		result.addAll(hosts());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.application.HostMapper#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();

		if (!(this.instances() != null)) {
			result =
					result.and(new BasicProblem(this,
							"Application needs an instance"));
		}

		if (!(this.hosts() != null)) {
			result =
					result.and(new BasicProblem(this,
							"Application needs a host"));
		}

		
		try {
			List<Host> hostMembers = members(Host.class);
		
			for (Instance instance : this.instances()) {
				if (!hostMembers.contains(instance.host().getElement())) {
					result = result.and(new BasicProblem(this,
								"Host undefined in this application: "
										+ instance.host().name()));
				}
			}
		} catch (LookupException e) {
			result.and(new BasicProblem(this,
					"Exception looking up instance's host."));
			e.printStackTrace();
		}

		// if ( !(this.modules() != null) ) {
		// result = result.and(new BasicProblem(this, "Modules is null"));
		// }

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.refinement.RefinableDeclaration#localMembers()
	 */
	@Override
	public List<MViewMember> localMembers()
			throws LookupException {
		List<MViewMember> result = new ArrayList<MViewMember>();

		result.addAll(hosts());
		result.addAll(instances());
		result.addAll(modules());

		return result;
	}

}

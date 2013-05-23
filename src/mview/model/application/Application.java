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
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupContext;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;
import be.kuleuven.cs.distrinet.rejuse.association.OrderedMultiAssociation;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 * @param <A>
 */
public class Application
		extends RefinableDeclarationImpl
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
	private final Multi<Host> _hosts = new Multi<Host>(this);

	/**
	 * @return
	 */
	protected List<Host> hosts() {
		return _hosts.getOtherEnds();
	}

	/**
	 * @param host
	 */
	public void addHost(Host host) {
		add(_hosts,host);
	}

	/**
	 * @param host
	 */
	public void removeHost(Host host) {
		remove(_hosts,host);
	}

	/*
	 * Instances
	 */
	private final Multi<Instance> _instances = new Multi<Instance>(this);

	/**
	 * @return
	 */
	protected List<Instance> instances() {
		return _instances.getOtherEnds();
	}

	/**
	 * @param host
	 */
	public void addInstance(Instance instance) {
		add(_instances,instance);
	}

	/**
	 * @param host
	 */
	public void removeInstance(Instance instance) {
		remove(_instances,instance);
	}

	/*
	 * Modules
	 */
	private final Multi<Module> _modules = new Multi<Module>(this);

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.module.ModuleContainer#modules()
	 */
	protected List<Module> modules() {
		return _modules.getOtherEnds();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.model.module.ModuleContainer#addModule(mview.model.module.Module)
	 */
	public void addModule(Module module) {
		add(_modules,module);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.model.module.ModuleContainer#removeModule(mview.model.module.Module
	 * )
	 */
	public void removeModule(Module module) {
		remove(_modules,module);
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
	protected Application cloneThis() {
		return new Application();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.application.HostMapper#clone()
	 */
	@Override
	public Application clone() {
		final Application clone = (Application) super.clone();

		for (Host host : hosts()) {
			clone.addHost(host.clone());
		}

		for (Instance instance : instances()) {
			clone.addInstance(instance.clone());
		}

		for (Module module : this.modules()) {
			clone.addModule((Module)module.clone());
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

	/**
	 * @return
	 */
	protected Verification verifyHosts() {
		Verification result = Valid.create();
		
		if (!isAbstract()) {
			List<Host> hostMembers = new ArrayList<Host>();
			try {
				hostMembers = this.members(Host.class);
			} catch (LookupException e) {
				e.printStackTrace();
			} 
			
			for (Host host : hostMembers) {
				if ( (host.hostName() == null )) {
					result = result.and(
							new BasicProblem(this, 
									"Non-abstract Application "+ signature().name() +": " +
									"Host "+host.signature().name()+ " should define a hostname."));
				}
			}
		}
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.application.HostMapper#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		Verification result = super.verifySelf();

		if ( !isAbstract() ) {
		
			try {
				if (!(this.members(Instance.class).size() > 0)) {
					result =
							result.and(new BasicProblem(this,
									"Application "+ signature().name() +": Instance required."));
				}
			} catch (LookupException e) {
				e.printStackTrace();
			}
	
			if (!(this.hosts() != null)) {
				result =
						result.and(new BasicProblem(this,
								"Application "+ signature().name() +": Host required."));
			}
		}
		
		try {
			List<Host> hostMembers = members(Host.class);
		
			for (Instance instance : this.instances()) {
				if (!hostMembers.contains(instance.host().getElement())) {
					result = result.and(new BasicProblem(this,
							"Application "+ signature().name() +": Host undefined in this application: "
										+ instance.host().name()));
				}
			}
		} catch (LookupException e) {
			result.and(new BasicProblem(this,
					"Application "+ signature().name() +": Exception looking up instance's host."));
			e.printStackTrace();
		}
		
		
		// verify hosts
		result = result.and(verifyHosts());

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

		result.addAll(hosts());
		result.addAll(instances());
		result.addAll(modules());

		return result;
	}

	@Override
	public LookupContext localContext() throws LookupException {
		return language().lookupFactory().createLocalLookupStrategy(this);
	}

}

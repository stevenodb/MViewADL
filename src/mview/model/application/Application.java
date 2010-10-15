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

import java.util.List;

import mview.model.module.Module;
import mview.model.module.ModuleContainer;
import mview.reuse.HostMapper;

import org.rejuse.association.OrderedMultiAssociation;


import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Application extends HostMapper<Application,AbstractHost,Locate> implements ModuleContainer {
	
	/**
	 * default 
	 */
	protected Application() {
	}

	/**
	 * @param signature
	 */
	public Application(SimpleNameSignature signature) {
		super(signature);
	}

	/*
	 * Modules
	 */
	private final OrderedMultiAssociation<Application, SimpleReference<Module<?>>> _modules =
		new OrderedMultiAssociation<Application, SimpleReference<Module<?>>>(this);
	
	
	/**
	 * @return
	 */
	public List<SimpleReference<Module<?>>> modules() {
		return _modules.getOtherEnds();
	}
	
	/**
	 * @param relation
	 */
	public void addModule(SimpleReference<Module<?>> relation) {
		_modules.add(relation.parentLink());
	}
	
	/**
	 * @param relation
	 */
	public void removeModule(SimpleReference<Module<?>> relation) {
		_modules.remove(relation.parentLink());
	}
	
	
	/* (non-Javadoc)
	 * @see mstage.reuse.HostMapper#createEmptyMapping()
	 */
	@Override
	public Locate createEmptyMapping() {
		return new Locate();
	}
		
	
	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#cloneThis()
	 */
	@Override
	protected Application cloneThis() {
		return new Application();
	}
	
	/* (non-Javadoc)
	 * @see mstage.model.application.HostMapper#clone()
	 */
	@Override
	public Application clone() {
		final Application clone = super.clone();
		
		for (SimpleReference<Module<?>> ref : this.modules()) {
			SimpleReference<Module<?>> localClone = ref.clone();
			
			clone.addModule(localClone);
		}
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see mstage.model.application.HostMapper#children()
	 */
	@Override
	public List<Element> children() {
		final List<Element> result = super.children();
		
		result.addAll(modules());
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mstage.model.application.HostMapper#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if ( !(this.modules() != null) ) {
			result = result.and(new BasicProblem(this, "Modules is null"));
		}
		
		return result;
	}

}

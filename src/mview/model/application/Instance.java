/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Instance.java
 * created:  Oct 20, 2010, 3:48:46 PM
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
package mview.model.application;

import be.kuleuven.cs.distrinet.chameleon.util.association.Single;
import mview.model.module.Module;
import mview.model.refinement.MViewMemberDeclarationImpl;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Instance extends MViewMemberDeclarationImpl {
	
	/**
	 * Default 
	 */
	public Instance() {
		super();
	}

	/**
	 * @param signature
	 */
	public Instance(SimpleNameSignature signature) {
		super(signature);
	}

	// type
	private Single<SimpleReference<Module>> _type = new Single<SimpleReference<Module>>(this);
	
	/**
	 * @return
	 */
	public SimpleReference<Module> type() {
		return _type.getOtherEnd();
	}

	/**
	 * @param relation
	 */
	public void setType(SimpleReference<Module> relation) {
		set(_type,relation);	 
	}
	
	// host
	private Single<SimpleReference<Host>> _host = new Single<SimpleReference<Host>>(this);
	
	/**
	 * @return
	 */
	public SimpleReference<Host> host() {
		return _host.getOtherEnd();
	}
	
	/**
	 * @param relation
	 */
	public void setHost(SimpleReference<Host> relation) {
		set(_host,relation);
	}
	
	
	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#cloneThis()
	 */
	@Override
	protected Instance cloneSelf() {
		return new Instance();
	}
	
	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		final Verification result = super.verifySelf();
		
		if ( ! (host() != null) ) { 
			result.and(new BasicProblem(this, "Instance needs a host"));
		}
		
		if ( ! (type() != null) ) { 
			result.and(new BasicProblem(this, "Instance needs a type"));
		}
		
		return result;
	}

//	/* (non-Javadoc)
//	 * @see mview.model.refinement.MViewMember#overrides(mview.model.refinement.MViewMember)
//	 */
//	@Override
//	public boolean overrides(Instance other) {
//		return this.equals(other);
//	}
//
//	/* (non-Javadoc)
//	 * @see mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember)
//	 */
//	@Override
//	public Instance merge(Instance member) throws MergeNotSupportedException {
//		throw new MergeNotSupportedException(this+" does not support merge");
//	}
}

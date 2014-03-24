/**
 * author:     Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename:   Component.java
 * created:    Nov 20, 2009, 11:23:49 AM
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

import java.util.List;

import mview.model.module.Module.ProvidedInterfaceDependency;
import mview.model.refinement.MViewMember;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 * @param <E>
 */
public class Component extends Module {

	/**
	 * default
	 */
	protected Component() {
	}
	
	/**
	 * @param signature
	 */
	public Component(SimpleNameSignature signature) {
		super(signature);
	}
	
	

	/* (non-Javadoc)
	 * @see mview.model.module.Module#cloneThis()
	 */
	@Override
	protected Component cloneSelf() {
		return new Component();
	}
	
	/* (non-Javadoc)
	 * @see mview.model.module.Module#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		Verification result = super.verifySelf();
		
		if ( ! isAbstract() ) {
		
			try {
				if ( ! (this.members(ProvidedInterfaceDependency.class).size() >= 1) ) {
					result = result.and(new BasicProblem(this, 
						this.signature().name() + ": Missing provided interface."));
				}
			} catch (LookupException e) {
				result.and(new BasicProblem(this,
						"Component "+ signature().name() +": Exception looking up provided interfaces."));
				e.printStackTrace();
			}
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.RefinableDeclaration#localMembers()
	 */
	@Override
	public List<MViewMember> localMembers() {
		return super.localMembers();
	}

}

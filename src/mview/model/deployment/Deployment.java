/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Deployment.java
 * created:  Dec 2, 2009, 10:47:54 AM
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
package mview.model.deployment;

import java.util.List;

import mview.model.application.Application;
import mview.model.application.Host;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Deployment extends Application {
	
	/**
	 * default
	 */
	public Deployment() {
		super();
	}

	/**
	 * @param signature
	 */
	public Deployment(SimpleNameSignature signature) {
		super(signature);
	}

	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#cloneThis()
	 */
	@Override
	protected Deployment cloneSelf() {
		return new Deployment();
	}

	@Override
	protected Verification verifyHosts() {
		Verification result = Valid.create();

		for (Host host : hosts()) {
			if ( (host.hostName() == null )) {
				result = result.and(
						new BasicProblem(this, 
								"Application "+ signature().name() +": " +
								"Host "+host.signature().name()+ " should define a hostname."));
			}
		}

		return result;
//		return Valid.create();
	}
	
	/* (non-Javadoc)
	 * @see mview.model.application.HostMapper#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		Verification result = super.verifySelf();
		return result;
	}

}

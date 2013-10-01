/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Deployment.java
 * created:  Dec 2, 2009, 10:47:54 AM
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

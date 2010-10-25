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
import chameleon.core.element.Element;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Deployment extends Application<Deployment> {
	
	
	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#cloneThis()
	 */
	@Override
	protected Deployment cloneThis() {
		return new Deployment();
	}

	/* (non-Javadoc)
	 * @see mstage.model.application.HostMapper#children()
	 */
	@Override
	public List<Element> children() {
		final List<Element> result = super.children();
		return result;
	}

	/* (non-Javadoc)
	 * @see mstage.model.application.HostMapper#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		return result;
	}

}

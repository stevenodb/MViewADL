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
 * along with Digital Publishing Demonstrator.  
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mstage.model.deployment;

import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;

import mstage.model.application.Application;
import mstage.model.application.Locate;
import mstage.model.namespace.MStageDeclaration;
import chameleon.core.element.Element;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Deployment extends MStageDeclaration<Deployment, Element> {
	
	private OrderedMultiAssociation<Deployment, Map> _locates =
		new OrderedMultiAssociation<Deployment, Map>(this);
	
	/**
	 * @return
	 */
	public List<Map> locates() {
		return _locates.getOtherEnds();
	}
	
	/**
	 * @param relation
	 */
	public void addLocate(Map relation) {
		_locates.add(relation.parentLink());
	}
	

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Deployment clone() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		// TODO Auto-generated method stub
	}

}

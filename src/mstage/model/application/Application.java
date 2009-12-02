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
 * along with Digital Publishing Demonstrator.  
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mstage.model.application;

import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;

import com.sun.xml.internal.ws.message.RelatesToHeader;

import chameleon.core.element.Element;
import chameleon.core.validation.VerificationResult;
import mstage.model.namespace.MStageDeclaration;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Application extends MStageDeclaration<Application, Element> {

	private OrderedMultiAssociation<Application, Locate> _locates =
		new OrderedMultiAssociation<Application, Locate>(this);
	
	/**
	 * @return
	 */
	public List<Locate> locates() {
		return _locates.getOtherEnds();
	}
	
	/**
	 * @param relation
	 */
	public void addLocate(Locate relation) {
		_locates.add(relation.parentLink());
	}
	
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Application clone() {
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

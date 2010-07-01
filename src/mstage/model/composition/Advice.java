/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Advice.java
 * created:  Nov 24, 2009, 6:27:38 PM
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
package mstage.model.composition;

import java.util.ArrayList;
import java.util.List;

import mstage.model.module.Service;

import org.rejuse.association.SingleAssociation;

import chameleon.core.element.Element;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.util.Util;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Advice extends NamespaceElementImpl<Advice, Element> {
	
	/**
	 * default constructor
	 */
	public Advice() {
	}
	
	// Advice type
	private AdviceType _type;
	
	/**
	 * @return the type
	 */
	public AdviceType type() {
		return this._type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(AdviceType type) {
		this._type = type;
	}

	
	// Service
	private SingleAssociation<Advice, SimpleReference<Service>> _service =
		new SingleAssociation<Advice, SimpleReference<Service>>(this);
	
	
	/**
	 * @return	the reference to the service
	 */
	public SimpleReference<Service> service() {
		return _service.getOtherEnd();
	}
	
	/**
	 * @param reference	the reference to set
	 */
	public void setService(SimpleReference<Service> relation) {
		if (relation != null)
			_service.connectTo(relation.parentLink());
	}

	
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Advice clone() {
		final Advice clone = new Advice();
		
		clone.setType(this.type());
		
		clone.setService(
				this.service().clone()
		);
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = Valid.create();
		
		if (! (this.type() != null)) {
			result = result.and(new BasicProblem(this, "Does not have a type set"));
		}
		
		if (! (this.service() != null)) {
			result = result.and(new BasicProblem(this, "Does not have a service set"));
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.Element#children()
	 */
	public List<Element> children() {
		final List<Element> result = new ArrayList<Element>();
		
		Util.addNonNull(this.service(), result);
		
		return result;
	}

}

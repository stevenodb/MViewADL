/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: PatternJoinPoint.java
 * created:  Nov 27, 2009, 6:05:14 PM
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
package mstage.model.composition;

import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;

import mstage.model.module.Service;

import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class PatternJoinPoint extends JoinPoint<PatternJoinPoint> {
	
	private String _pattern;

	/**
	 * @return the pattern
	 */
	public String pattern() {
		return _pattern;
	}

	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern) {
		_pattern = pattern;
	}
	
	
	
	private OrderedMultiAssociation<PatternJoinPoint, SimpleReference<Service>> _services =
		new OrderedMultiAssociation<PatternJoinPoint, SimpleReference<Service>>(this);
	
	/**
	 * @return	a List of references to Services
	 */
	public List<SimpleReference<Service>> services() {
		return _services.getOtherEnds();
	}
	
	/**
	 * @param relation	reference to the Service to add
	 */
	public void addService(SimpleReference<Service> relation) {
		_services.add(relation.parentLink());
	}
	
	/**
	 * @param relation	reference to the Service to remove
	 */
	public void removeService(SimpleReference<Service> relation) {
		_services.remove(relation.parentLink());
	}
	
	
	
	

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public PatternJoinPoint clone() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.Element#children()
	 */
	public List<? extends Element> children() {
		// TODO Auto-generated method stub
	}


}

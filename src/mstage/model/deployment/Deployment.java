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
package mstage.model.deployment;

import java.util.List;

import mstage.model.application.Application;
import mstage.reuse.HostMapper;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Deployment extends HostMapper<Deployment,Map> {
	
	/*
	 * Applications
	 */
	private final OrderedMultiAssociation<Deployment, SimpleReference<Application>> _applications =
		new OrderedMultiAssociation<Deployment, SimpleReference<Application>>(this);
	
	/**
	 * @return
	 */
	public List<SimpleReference<Application>> applications() {
		return _applications.getOtherEnds();
	}
	
	/**
	 * @param relation
	 */
	public void addApplication(SimpleReference<Application> relation) {
		_applications.add(relation.parentLink());
	}
	
	/**
	 * @param relation
	 */
	public void removeApplication(SimpleReference<Application> relation) {
		_applications.remove(relation.parentLink());
	}
	
	/*
	 * Maps
	 */

	/**
	 * @return
	 */
	public List<Map> maps() {
		return this.hostMaps();
	}	

	/**
	 * @param relation
	 */
	public void addLocate(Map relation) {
		this.addHostMap(relation);
	}
	
	/**
	 * @param relation
	 */
	public void removeLocate(Map relation) {
		this.removeHostMap(relation);
	}

	
	
	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#cloneThis()
	 */
	@Override
	protected Deployment cloneThis() {
		return new Deployment();
	}

	/* (non-Javadoc)
	 * @see mstage.model.application.HostMapper#clone()
	 */
	@Override
	public Deployment clone() {
		final Deployment clone = super.clone();
		
		for (SimpleReference<Application> ref : this.applications()) {
			SimpleReference<Application> localClone = ref.clone();
			
			clone.addApplication(localClone);
		}
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see mstage.model.application.HostMapper#children()
	 */
	@Override
	public List<Element> children() {
		final List<Element> result = super.children();
		
		result.addAll(applications());
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mstage.model.application.HostMapper#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if ( !(this.applications() != null) ) {
			result = result.and(new BasicProblem(this, "Applications is null"));
		}
		
		return result;
	}

}

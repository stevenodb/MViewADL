/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: HostMapper.java
 * created:  Dec 8, 2009, 12:55:31 PM
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
package mstage.reuse;

import java.util.List;

import mstage.model.namespace.MStageDeclaration;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.element.Element;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 * @param <E>
 * @param <M>
 */
public abstract class HostMapper<E extends HostMapper<E,M>,M extends Mapping<M,?,?>> 
	extends	MStageDeclaration<E,Element> {

	/*
	 * HostMap association
	 */
	private final OrderedMultiAssociation<HostMapper<E,M>, M> _hostMap = 
		new OrderedMultiAssociation<HostMapper<E,M>, M>(this);

	/**
	 * @return
	 */
	protected List<M> hostMaps() {
		return _hostMap.getOtherEnds();
	}

	/**
	 * @param relation
	 */
	protected void addHostMap(M relation) {
		_hostMap.add(relation.parentLink());
	}
	
	/**
	 * @param relation
	 */
	protected void removeHostMap(M relation) {
		_hostMap.add(relation.parentLink());
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#clone()
	 */
	@Override
	public E clone() {
		final E clone = (E) super.clone();
		
		for (M hostMap : this.hostMaps()) {
			M localClone = hostMap.clone();
			
			clone.addHostMap(localClone);
		}
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if ( ! (this.hostMaps().size() >= 0) ) {
			//nothing
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#children()
	 */
	@Override
	public List<Element> children() {
		final List<Element> result = super.children();
		
		result.addAll(this.hostMaps());
			
		return result;	
	}

}
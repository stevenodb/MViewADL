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

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 * @param <E>
 * @param <M>
 */
public abstract class HostMapper
						<E extends HostMapper<E,H,M>,
						H extends Host<H>,
						M extends HostMapping<M,?,H>> 
								extends	MStageDeclaration<E,Element> {
	
	/**
	 * default
	 */
	protected HostMapper() {
	}

	/**
	 * @param signature
	 */
	protected HostMapper(SimpleNameSignature signature) {
		super(signature);
	}

	
	/**
	 * @return
	 */
	public abstract M createEmptyMapping();
	
	
	/*
	 * HostMap association
	 */
	private final OrderedMultiAssociation<HostMapper<E,H,M>, M> _hostMap = 
		new OrderedMultiAssociation<HostMapper<E,H,M>, M>(this);

	
	/**
	 * @return
	 */
	public List<M> hostMappings() {
		return _hostMap.getOtherEnds();
	}

	/**
	 * @param relation
	 */
	public void addHostMapping(M relation) {
		if (relation != null)
			_hostMap.add(relation.parentLink());
	}
	
	/**
	 * @param relation
	 */
	public void removeHostMapping(M relation) {
		if (relation != null)
			_hostMap.remove(relation.parentLink());
	}

	
	/*
	 * Hosts
	 */	
	private final OrderedMultiAssociation<HostMapper<E,H,M>,SimpleReference<H>> _hosts =
		new OrderedMultiAssociation<HostMapper<E,H,M>, SimpleReference<H>>(this);
	
	
	/**
	 * @return
	 */
	public List<SimpleReference<H>> hosts(){
		return _hosts.getOtherEnds();
	}
	
	/**
	 * @param relation
	 */
	public void addHost(SimpleReference<H> relation) {
		if (relation != null)
			_hosts.add(relation.parentLink());
	}
	
	/**
	 * @param relation
	 */
	public void removeHost(SimpleReference<H> relation) {
		if (relation != null)
			_hosts.remove(relation.parentLink());
	}
	
	
	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#clone()
	 */
	@Override
	public E clone() {
		final E clone = (E) super.clone();
		
		for (M hostMap : this.hostMappings()) {
			M localClone = hostMap.clone();
			clone.addHostMapping(localClone);
		}
		
		for (SimpleReference<H> relation : this.hosts()) {
			SimpleReference<H> localClone = relation.clone();
			clone.addHost(localClone);
		}
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if ( ! (this.hostMappings().size() >= 0) ) {
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
		
		result.addAll(this.hostMappings());
		
		result.addAll(this.hosts());
			
		return result;	
	}

}
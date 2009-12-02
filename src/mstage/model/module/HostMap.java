/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Map.java
 * created:  Dec 1, 2009, 6:03:43 PM
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
package mstage.model.module;

import org.rejuse.association.SingleAssociation;

import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.reference.SimpleReference;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 * @param <From>
 * @param <To>
 */
public abstract class HostMap<From extends Declaration<?,?,?,?>,To extends Declaration<?, ?, ?, ?>,M extends HostMap<From,To,M>> 
			extends NamespaceElementImpl<M, Element> {

	
	/*
	 * Association to Host
	 */
	private SingleAssociation<HostMap<From,To,M>, SimpleReference<From>> _from =
		new SingleAssociation<HostMap<From,To,M>, SimpleReference<From>>(this); 
	
	/**
	 * @return
	 */
	public SimpleReference<From> from() {
		return _from.getOtherEnd();
	}

	/**
	 * @param relation
	 */
	public void setFrom(SimpleReference<From> relation) {
		_from.connectTo(relation.parentLink());
	}
	
	
	/*
	 * Association to Module
	 */
	private SingleAssociation<HostMap<From,To,M>, SimpleReference<To>> _to =
		new SingleAssociation<HostMap<From,To,M>, SimpleReference<To>>(this);

	public void setTo(SimpleReference<To> relation) {
		_to.connectTo(relation.parentLink());
	}

	/**
	 * @return
	 */
	public SimpleReference<To> to() {
		return _to.getOtherEnd();
	}

}

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
 *
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mview.reuse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mview.model.namespace.MViewDeclaration;

import org.rejuse.association.OrderedMultiAssociation;
import org.rejuse.association.SingleAssociation;

import chameleon.core.declaration.Declaration;
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
 * @param <From>
 * @param <To>
 */
public abstract class HostMapping<M extends HostMapping<M,From,To>,
			From extends MViewDeclaration<?,? extends Element>,
			To extends Host<? extends Host<?>>> 
			extends NamespaceElementImpl<M, Element> {

	/**
	 * default
	 */
	public HostMapping() {
	}
	

	/*
	 * Association to From
	 */
	private final OrderedMultiAssociation<HostMapping<M,From,To>, SimpleReference<From>> _from =
		new OrderedMultiAssociation<HostMapping<M,From,To>, SimpleReference<From>>(this); 
	
	
	/**
	 * @return
	 */
	public List<SimpleReference<From>> from() {
		return _from.getOtherEnds();
	}

	/**
	 * @param relation
	 */
	public void addFrom(SimpleReference<From> relation) {
		_from.add(relation.parentLink());
	}
	
	
	public void removeFrom(SimpleReference<From> relation) {
		_from.remove(relation.parentLink());
	}
	
	
	/*
	 * Association to To
	 */
	private final SingleAssociation<HostMapping<M,From,To>, SimpleReference<To>> _to =
		new SingleAssociation<HostMapping<M,From,To>, SimpleReference<To>>(this);

	/**
	 * @param relation
	 */
	public void setTo(SimpleReference<To> relation) {
		_to.connectTo(relation.parentLink());
	}

	/**
	 * @return
	 */
	public SimpleReference<To> to() {
		return _to.getOtherEnd();
	}
	
	
	/**
	 * @return An incomplete clone with the correct sub-Type 
	 */
	protected abstract M cloneThis();

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public M clone() {
		final M clone = (M) this.cloneThis();
		
		for (SimpleReference<From> simpleReference : this.from()) {
			SimpleReference<From> localClone = simpleReference.clone();
			
			clone.addFrom(localClone);
		}
		
		clone.setTo(
			this.to().clone()
		);
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = Valid.create();
		
		if ( ! (this.from() != null) ) {
			result = result.and(new BasicProblem(this, "From is null"));
		} else
			if ( ! (this.from().size() > 0) ) {
				result = result.and(new BasicProblem(this, "Does not have any From targets."));
			}

		if ( ! (this.to() != null) ) {
			result = result.and(new BasicProblem(this, "To is null"));
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.Element#children()
	 */
	public List<Element> children() {
		final List<Element> result = new ArrayList<Element>();
		
		result.addAll(this.from());
		Util.addNonNull(this.to(), result);
		
		return result;
	}

}

/**
 * author:     Steven Op de beeck <steven /at/ opdebeeck /./ org>
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
package mview.model.module;

import java.util.ArrayList;
import java.util.List;

import mview.model.composition.AOComposition;
import mview.model.refinement.MViewMember;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;

public class Connector<E extends Connector<E>> extends Module<E> {
	
	/**
	 * Default constructor 
	 */
	protected Connector() {
	}

	/**
	 * @param signature
	 */
	public Connector(SimpleNameSignature signature) {
		super(signature);
	}

	/*
	 * composition association
	 */
	private OrderedMultiAssociation<Connector<E>, AOComposition> _compositions = 
		new OrderedMultiAssociation<Connector<E>, AOComposition>(this); 
 
	public List<AOComposition> compositions() {
		return _compositions.getOtherEnds();
	}
	
	public void removeComposition(AOComposition relation) {
		if (relation != null) {
			_compositions.remove(relation.parentLink());
		}
	}
	
	public void addComposition(AOComposition relation) {
		if (relation != null) {
		_compositions.add(relation.parentLink());
		}
	}

	
	/* (non-Javadoc)
	 * @see mview.model.module.Module#cloneThis()
	 */
	@Override
	protected E cloneThis() {
		return (E) new Connector();
	}

	/* (non-Javadoc)
	 * @see mview.model.module.Module#clone()
	 */
	@Override
	public E clone() {
		final E clone = super.clone();
		
		for (AOComposition composition : compositions()) {
			AOComposition localClone = composition.clone();
			
			clone.addComposition(localClone);
		}
		
		return clone;
	}

	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if ( ! (compositions() != null) ) {
			result = result.and(new BasicProblem(this, "Compositions is null"));
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mview.model.module.Module#children()
	 */
	@Override
	public List<Element> children() {
		final List<Element> result = super.children();
		
		result.addAll(compositions());

		return result;
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.RefinableDeclaration#localMembers()
	 */
	@Override
	public List<MViewMember> localMembers() {
		List<MViewMember> result = super.localMembers();
		result.addAll(compositions());
		return result;
	}

}

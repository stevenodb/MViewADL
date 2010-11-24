/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Signature.java
 * created:  Nov 10, 2010, 10:16:03 PM
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
 * You should have received a copy of the GNU General Public License. 
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mview.model.composition;

import java.util.List;

import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;
import mview.model.refinement.modifier.Overridable;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.element.Element;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import exception.MergeNotSupportedException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class Signature extends ElementWithModifiersImpl<Signature, Element>
		implements MViewMember<Signature, Element> {

	/**
	 * default constructor
	 */
	public Signature() {
		super();
	}

	public Signature(boolean overridable) {
		this();
		setOverridable(overridable);
	}

	/*
	 * SIGNATURES
	 */
	private OrderedMultiAssociation<Signature, PointcutSignature> _signatures =
			new OrderedMultiAssociation<Signature, PointcutSignature>(this);

	/**
	 * @return
	 */
	public List<PointcutSignature> signatures() {
		return _signatures.getOtherEnds();
	}

	/**
	 * @param signature
	 */
	public void addSignature(PointcutSignature signature) {
		_signatures.add(signature.parentLink());
	}

	/**
	 * @param signatures
	 */
	public void addAllSignatures(List<PointcutSignature> signatures) {
		for (PointcutSignature signature : signatures) {
			addSignature(signature);
		}
	}

	/**
	 * @param signature
	 */
	public void removeSignature(PointcutSignature signature) {
		_signatures.remove(signature.parentLink());
	}

	/**
	 * @return true if overridable
	 */
	public boolean overridable() {
		return this.hasModifier(new Overridable());
	}

	/**
	 * @param overridable
	 */
	public void setOverridable(boolean overridable) {
		if (overridable) {
			addModifier(new Overridable());
		} else {
			removeModifier(new Overridable());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.Element#children()
	 */
	@Override
	public List<Element> children() {
		List<Element> result = super.children();

		result.addAll(this.signatures());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Signature clone() {
		final Signature clone = new Signature();

		clone.addModifiers(this.modifiers());

		for (PointcutSignature sig : signatures()) {
			clone.addSignature(sig.clone());
		}

		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = Valid.create();

		if (!((this.signatures() != null) && (this.signatures().size() >= 1))) {
			result = result.and(new BasicProblem(this,
					"Does not aggregate any signature"));
		}

		return result;
	}
	
	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#sharesContext(mview.model.refinement.MViewMember)
	 */
	@Override
	public boolean sharesContext(Signature other) {
		return new RefinementContext<Signature>(this, other).verify();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.refinement.MViewMember#overrides(mview.model.refinement.
	 * MViewMember)
	 */
	@Override
	public boolean overrides(Signature other) {
		return this.overridable() && this.sharesContext(other);
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#mergesWith(mview.model.refinement.MViewMember)
	 */
	@Override
	public boolean mergesWith(Signature other) {
		return sharesContext(other) && !overridable();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember
	 * )
	 */
	@Override
	public Signature merge(Signature other) throws MergeNotSupportedException {
		
		Signature merged = this.clone();
		
		if (mergesWith(other) ) {
			merged.addAllSignatures(other.signatures());
		}
		
		return merged;
	}
}

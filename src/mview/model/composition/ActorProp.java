/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: ActorProp.java
 * created:  Oct 7, 2010, 5:27:04 PM
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

import mview.model.composition.modifier.PropModifier;
import mview.model.module.Interface;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinableDeclaration;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import exception.MergeNotSupportedException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class ActorProp<D extends Declaration> extends
		ElementWithModifiersImpl<ActorProp<D>, Element>
		implements MViewMember<ActorProp<D>, Element> {

	/**
	 * default
	 */
	public ActorProp() {
		super();
	}

	/**
	 * @param modifier
	 */
	public ActorProp(PropModifier<D> modifier, Class<D> declaration) {
		this();
		addModifier(modifier);
		setDeclarationType(declaration);
	}

	// list of prop values
	private OrderedMultiAssociation<ActorProp<D>, SimpleReference<D>> _propValues =
			new OrderedMultiAssociation<ActorProp<D>, SimpleReference<D>>(this);

	/**
	 * @return
	 */
	public List<SimpleReference<D>> propValues() {
		return _propValues.getOtherEnds();
	}

	/**
	 * @param relation
	 */
	public void addPropValue(SimpleReference<D> relation) {
		_propValues.add(relation.parentLink());
	}

	/**
	 * @param relation
	 */
	public void removePropValue(SimpleReference<D> relation) {
		_propValues.remove(relation.parentLink());
	}

	/**
	 * @param relations
	 */
	public void addAllPropValues(List<SimpleReference<D>> relations) {
		for (SimpleReference<D> relation : relations) {
			this.addPropValue(relation);
		}
	}

	/*
	 * DECLARATION
	 */
	private Class<D> _declarationType = null;

	/**
	 * @param declaration
	 *            the declaration to set
	 */
	public void setDeclarationType(Class<D> declaration) {
		this._declarationType = declaration;
	}

	/**
	 * @return the declaration
	 */
	public Class<D> declarationType() {
		return _declarationType;
	}

	/*
	 * PROPSOVERRIDE
	 */
	private boolean _propsOverride = false;

	/**
	 * @return
	 */
	protected boolean override() {
		return _propsOverride;
	}

	/**
	 * @param propsOverride
	 *            the propsOverride to set
	 */
	public void setOverride(boolean propsOverride) {
		this._propsOverride = propsOverride;
	}

	/**
	 * @return the guaranteed single modifier of this ActorProp
	 */
	private PropModifier<D> modifier() {
		return (PropModifier<D>) modifiers().get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.Element#children()
	 */
	@Override
	public List<Element> children() {
		List<Element> result = super.children();

		result.addAll(propValues());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public ActorProp<D> clone() {
		final ActorProp<D> clone = new ActorProp<D>();

		clone.addModifier(this.modifier().clone());
		clone.setDeclarationType(this.declarationType());
		clone.setOverride(this.override());

		for (SimpleReference<D> reference : propValues()) {
			clone.addPropValue(reference.clone());
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
		final VerificationResult result = Valid.create();

		if (!((this.modifiers().size() > 0) && (this.modifiers().size() < 2))) {
			result.and(new BasicProblem(this,
					"Must contain a single prop modifier"));
		}

		if (!(this.propValues().size() > 0)) {
			result.and(new BasicProblem(this,
					"Does not contain an actor property"));
		}

		if (!(this.declarationType() != null)) {
			result.and(new BasicProblem(this,
					"Does not contain a target declaration type"));
		}

		for (SimpleReference<D> relation : propValues()) {
			D declaration = null;

			try {
				declaration = relation.getElement();
			} catch (LookupException e) {
				result.and(new BasicProblem(this,
						"Invalid reference to declaration"));
			}

			if (declaration instanceof Interface) {
				result.and(new BasicProblem(this,
						"Contains declaration of invalid type: " + declaration));
			}
			// relation.nearestAncestor(c)
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.refinement.MViewMember#overrides(mview.model.refinement.
	 * MViewMember)
	 */
	@Override
	public boolean overrides(ActorProp<D> other) {
		return _propsOverride
				&& this.declarationType().equals(other.declarationType()) &&
				this.nearestAncestor(RefinableDeclaration.class).hasParent(
						other.nearestAncestor(RefinableDeclaration.class));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember
	 * )
	 */
	@Override
	public ActorProp<D> merge(ActorProp<D> other) throws MergeNotSupportedException {

		ActorProp<D> result = null;

		if (overrides(other)) {
			throw new MergeNotSupportedException("This member can only " +
					"be overridden.");
		} else if (!this.declarationType().equals(other.declarationType())) {
			throw new MergeNotSupportedException("Actors are of different" +
					"declaration types.");
		}	
		else {
			result = this.clone();
			ActorProp<D> parent = other.clone();

			this.addAllPropValues(parent.propValues());
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 0;

		for (SimpleReference<D> relation : propValues()) {
			result = (result * 10) + relation.parentLink().hashCode();
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * chameleon.core.element.ElementImpl#uniSameAs(chameleon.core.element.Element
	 * )
	 */
	@Override
	public boolean uniSameAs(Element other) throws LookupException {
		return (other instanceof ActorProp)
				&& (this.override() == ((ActorProp) other).override()) &&
				modifier().equals(((ActorProp) other).modifier());

	}
}

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
import mview.model.language.MView;
import mview.model.module.Interface;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinableDeclaration;
import mview.model.refinement.modifier.Overridable;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.modifier.Modifier;
import chameleon.core.property.StaticChameleonProperty;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.exception.ModelException;
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
	}

	/**
	 * @param modifier
	 * @param declaration
	 * @param overridable
	 */
	public ActorProp(PropModifier<D> modifier, Class<D> declaration,
			boolean overridable) {

		this(modifier, declaration);
		setOverride(overridable);
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
	 * OVERRIDE through modifier
	 */

	/**
	 * @return true if overridable
	 */
	public boolean overridable() {
		return this.hasModifier(new Overridable());
	}

	/**
	 * @param propsOverride
	 *            the propsOverride to set
	 */
	public void setOverride(boolean propsOverride) {
		if (propsOverride) {
			addModifier(new Overridable());
		} else {
			removeModifier(new Overridable());
		}
	}

	/**
	 * @return
	 */
	public Class<D> declarationType() {
		Class<D> result = null;

		try {
			result =
					(Class<D>) ((StaticChameleonProperty)
					property(language(MView.class).ACTOR_MUTEX))
							.validElementTypes().get(0);
		} catch (ModelException e) {
		}

		return result;
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

		clone.addModifiers(this.modifiers());

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

		// if (!((this.modifiers().size() > 0) && (this.modifiers().size() <
		// 2))) {
		// result.and(new BasicProblem(this,
		// "Must contain a single prop modifier"));
		// }

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

			if (declaration.getClass() == declarationType()) {
				result.and(new BasicProblem(this,
						"Contains declaration of invalid type: " + declaration));
			}
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
		return this.overridable()
				&& this.declarationType() == other.declarationType()
				&& this.nearestAncestor(RefinableDeclaration.class)
						.isRefinementOf(
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
	public ActorProp<D> merge(ActorProp<D> other)
			throws MergeNotSupportedException {

		ActorProp<D> merged = this.clone();

		if (!(this.declarationType() == other.declarationType())) {
			throw new MergeNotSupportedException("Actors are of different" +
					"declaration types.");
		}

		if (!this.overrides(other)) {
			ActorProp<D> parent = other.clone();
			merged.addAllPropValues(parent.propValues());
		}

		return merged;
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
				&& (this.overridable() == ((ActorProp) other).overridable()) &&
				this.declarationType() == ((ActorProp) other).declarationType();

	}
}

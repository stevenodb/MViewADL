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

import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.ElementWithModifiersImpl;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.Modifier;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;
import mview.exception.MergeNotSupportedException;
import mview.model.composition.modifier.PropModifier;
import mview.model.language.MView;
import mview.model.property.ActorProperty;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class ActorProp extends ElementWithModifiersImpl implements MViewMember {

	/**
	 * default
	 */
	public ActorProp() {
		super();
	}

	/**
	 * @param modifier
	 */
	public ActorProp(PropModifier modifier) {
		this();
		addModifier(modifier);
	}

//	/**
//	 * @param modifier
//	 * @param declaration
//	 * @param overridable
//	 */
//	public ActorProp(PropModifier modifier, boolean overridable) {
//		this(modifier);
//		setOverridable(overridable);
//	}

	// list of prop values
	private Multi<PropValue<Declaration>> _propValues = new Multi<PropValue<Declaration>>(this);

	/**
	 * @return
	 */
	public List<PropValue<Declaration>> propValues() {
		return _propValues.getOtherEnds();
	}

	/**
	 * @param propValue
	 */
	public void addPropValue(PropValue propValue) {
		add(_propValues,propValue);
	}

	/**
	 * @param propValue
	 */
	public void removePropValue(PropValue propValue) {
		remove(_propValues,propValue);
	}

	/**
	 * @param propValues
	 */
	public void addAllPropValues(List<PropValue<Declaration>> propValues) {
		for (PropValue propValue : propValues) {
			this.addPropValue(propValue);
		}
	}

	/*
	 * OVERRIDE through modifier
	 */

	/**
	 * @return true if overridable
	 */
	public boolean overridable() {
		return this.isTrue(language(MView.class).OVERRIDABLE);
	}

//	/**
//	 * @param propsOverride
//	 *            the propsOverride to set
//	 */
//	public void setOverridable(boolean propsOverride) {
//		if (propsOverride) {
//			addModifier(new Overridable());
//		} else {
//			removeModifier(new Overridable());
//		}
//	}

//	/**
//	 * @return
//	 * @throws LookupException 
//	 */
//	public Class declarationType() throws LookupException {
//		Class result;
//
//		try {
//			result =
//					(Class) ((ActorProperty)
//							this.property(language(MView.class).ACTOR_MUTEX))
//									.targetDeclarationType();
//		} catch (ModelException e) {
//			throw new LookupException("Property not found");
//		}
//
//		return result;
//	}
	
	/**
	 * @return
	 * @throws ModelException
	 */
	public ActorProperty actorProperty() throws LookupException {
		try {
			return (ActorProperty) this.property(language(MView.class).ACTOR_MUTEX);
		} catch (ModelException e) {
			throw new LookupException("Property lookup failed with ModelException");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public ActorProp clone() {
		final ActorProp clone = new ActorProp();

		for(Modifier mod: modifiers()) {
			clone.addModifier(mod.clone());
		}
		for (PropValue propValues : propValues()) {
			clone.addPropValue(propValues.clone());
		}

		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		final Verification result = Valid.create();

		// if (!((this.modifiers().size() > 0) && (this.modifiers().size() <
		// 2))) {
		// result.and(new BasicProblem(this,
		// "Must contain a single prop modifier"));
		// }
		
		if (!(this.propValues().size() > 0)) {
			try {
				result.and(new BasicProblem(this, "ActorProp " 
					+ actorProperty().name() + " Contains no actor properties."));
			} catch (LookupException e) {
			}
		}

		try {
			if (!(this.actorProperty() != null)) {
				result.and(new BasicProblem(this,"ActorProp " 
						+ actorProperty().name() + " Property type not set."));
			}
		} catch (ModelException e1) {
			result.and(new BasicProblem(this, 
					"Error in Model: ActorProp Exception getting property type"));
		}

		for (PropValue propValue : propValues()) {
			Declaration declaration = null;

			try {
				declaration = propValue.value().getElement();
			} catch (LookupException e) {
				// should be caught by PropValue verify.
			}

			try {
				if ((declaration != null) 
//						&& (declaration.getClass() == declarationType())) {
						&& (actorProperty().hasDeclarationType(declaration.getClass()))) {
					result.and(new BasicProblem(this, "ActorProp " 
							+ actorProperty().name() +
							"Contains declaration of invalid type: " + declaration));
				}
			} catch (ModelException e) {
				result.and(new BasicProblem(this, 
						"Error in Model: ActorProp Exception getting property type"));
			}
		}

		return result;
	}

	@Override
	public boolean sharesContext(MViewMember other) throws LookupException {
		return (new RefinementContext().verify(this, other));
	}

	@Override
	public boolean overrides(MViewMember other) throws ModelException {
		return overridable()
			&& sameMemberAs(other)
			&& sharesContext(other);
	}

	@Override
	public boolean mergesWith(MViewMember other) throws ModelException {
		return !overrides(other)
			&& sameMemberAs(other)
			&& sharesContext(other);
	}

	@Override
	public ActorProp merge(MViewMember other)
			throws MergeNotSupportedException, ModelException {

//		if (!(this.declarationType() == other.declarationType())) {
//			throw new MergeNotSupportedException("Actors are of different" +
//					"declaration types.");
//		}

		ActorProp merged = this.clone();
		merged.setUniParent(parent());

		if (mergesWith(other)) {
			ActorProp parent = ((ActorProp)other).clone();
			merged.addAllPropValues(parent.propValues());
		}

		return merged;
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see java.lang.Object#hashCode()
//	 */
//	@Override
//	public int hashCode() {
//		int result = 0;
//
//		for (PropValue value : propValues()) {
//			result = (result * 10) + value. .parentLink().hashCode();
//		}
//
//		return result;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * chameleon.core.element.ElementImpl#uniSameAs(chameleon.core.element.Element
	 * )
	 */
//	@Override
//	public boolean uniSameAs(Element other) throws LookupException {
//		return (other instanceof ActorProp)
//				&& (this.overridable() == ((ActorProp) other).overridable()) &&
//				this.actorProperty() == ((ActorProp) other).actorProperty();
//	}

	@Override
	public boolean sameMemberAs(MViewMember other) throws ModelException {
		return other != null
			&& other instanceof ActorProp
			&& actorProperty() == ((ActorProp)other).actorProperty();
	}
}

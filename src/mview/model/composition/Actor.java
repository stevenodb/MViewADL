/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Actor.java
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

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.modifier.Modifier;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class Actor<D extends Declaration> extends
		ElementWithModifiersImpl<Actor<D>, Element> {

	// list of prop (rich join point properties)
	OrderedMultiAssociation<Actor<?>, SimpleReference<D>> _props =
			new OrderedMultiAssociation<Actor<?>, SimpleReference<D>>(
																					this);

	public Actor() {
		super();
	}

	/**
	 * @param modifier
	 */
	public Actor(PropModifier<D> modifier) {
		this();
		addModifier(modifier);
	}

	/**
	 * @return
	 */
	public List<SimpleReference<D>> props() {
		return _props.getOtherEnds();
	}

	/**
	 * @param relation
	 */
	public void addProp(SimpleReference<D> relation) {
		_props.add(relation.parentLink());
	}

	/**
	 * @param relations
	 */
	public void addAllProps(List<SimpleReference<D>> relations) {
		for (SimpleReference<D> relation : relations) {
			this.addProp(relation);
		}
	}

	/**
	 * @return the guaranteed single modifier of this Actor
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

		result.addAll(props());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Actor<D> clone() {
		final Actor<D> clone = new Actor<D>();

		clone.addModifier(modifier().clone());

		for (SimpleReference<D> reference : props()) {
			clone.addProp(reference.clone());
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

		if (!(this.props().size() > 0)) {
			result.and(new BasicProblem(this,
					"Does not contain an actor property"));
		}

		for (SimpleReference<D> relation : props()) {
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

}

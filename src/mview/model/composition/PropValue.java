/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: PropValue.java
 * created:  Dec 15, 2010, 12:13:34 PM
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

import mview.model.composition.modifier.Negate;

import org.rejuse.association.SingleAssociation;

import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.modifier.Modifier;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.util.Util;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class PropValue<D extends Declaration>
		extends ElementWithModifiersImpl<PropValue<D>, Element> {

	/**
	 * 
	 */
	public PropValue() {
		super();
	}

	/**
	 * @param value
	 * @param negate
	 */
	public PropValue(SimpleReference<D> value) {
		this();
		setValue(value);
	}

	// VALUE
	private SingleAssociation<PropValue, SimpleReference<D>> _value =
			new SingleAssociation<PropValue, SimpleReference<D>>(this);

	/**
	 * @return
	 */
	public SimpleReference<D> value() {
		return _value.getOtherEnd();
	}

	/**
	 * @param value
	 */
	public void setValue(SimpleReference<D> value) {
		if (value != null) {
			_value.connectTo(value.parentLink());
		}
	}

	// NEGATION
	// stored in modifier

	/**
	 * @return
	 */
	public boolean negation() {
		return modifiers().contains(new Negate());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public PropValue<D> clone() {
		final PropValue<D> result = new PropValue<D>();

		result.addModifiers(this.modifiers());
		result.setValue(this.value().clone());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.modifier.ElementWithModifiersImpl#children()
	 */
	@Override
	public List<Element> children() {
		List<Element> result = super.children();

		Util.addNonNull(value(),result);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		final VerificationResult result = Valid.create();

//		result.and(new BasicProblem(this, "nothing to see, carry on"));

		try {
			
			if ( !(value() == null ) ) {
				result.and(new BasicProblem(this,
				"PropValue has null value"));
			}
			
			if (!(value().getElement() == null)) {
				result.and(new BasicProblem(this,
							"Invalid reference to declaration"));
			}
		} catch (LookupException e) {
			result.and(new BasicProblem(this,
					"LookupException when resolving reference to declaration"));
		}

		return result;
	}

}

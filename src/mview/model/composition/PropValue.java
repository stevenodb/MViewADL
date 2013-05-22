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

import be.kuleuven.cs.distrinet.chameleon.util.Util;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;
import mview.model.language.MView;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.ElementWithModifiersImpl;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.Modifier;
import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class PropValue<D extends Declaration> extends ElementWithModifiersImpl {

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
	private Single<SimpleReference<D>> _value =	new Single<SimpleReference<D>>(this);

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
		set(_value,value);
	}

	// NEGATION
	// stored in modifier

	/**
	 * @return
	 */
	public boolean isNegated() {
		return isTrue(language(MView.class).NEGATE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public PropValue<D> clone() {
		final PropValue<D> result = new PropValue<D>();

		for(Modifier modifier : this.modifiers()) {
			result.addModifier(modifier.clone());
		}

		result.setValue(this.value().clone());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		Verification result = Valid.create();

		try {
			if ( !(value() != null ) ) {
				result = result.and(new BasicProblem(this,
				"PropValue: PropValue is null."));
			} else 
				
				if (!(value().getElement() != null)) {
				result.and(new BasicProblem(this,
				"PropValue: Invalid reference to declaration."));
			}
		} catch (LookupException e) {
			result.and(new BasicProblem(this,
				"PropValue: LookupException when resolving reference."));
		}

		return result;
	}

}

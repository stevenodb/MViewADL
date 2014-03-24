/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: PropValue.java
 * created:  Dec 15, 2010, 12:13:34 PM
 *
 * Copyright 2013 KU Leuven Research and Development - iMinds - DistriNet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Administrative Contact: dnet-project-office@cs.kuleuven.be
 * Technical Contact: steven@opdebeeck.org
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
	protected PropValue<D> cloneSelf() {
		return new PropValue<D>();
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

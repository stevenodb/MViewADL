/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MView.java
 * created:  Jan 22, 2010, 1:56:34 PM
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
package mview.model.language;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import mview.model.application.Application;
import mview.model.application.Host;
import mview.model.application.Instance;
import mview.model.composition.ActorProp;
import mview.model.composition.Advice;
import mview.model.composition.Pointcut;
import mview.model.composition.PointcutSignature;
import mview.model.composition.PropValue;
import mview.model.composition.ServiceSignature;
import mview.model.composition.modifier.After;
import mview.model.composition.modifier.Around;
import mview.model.composition.modifier.Before;
import mview.model.composition.modifier.Call;
import mview.model.composition.modifier.Execution;
import mview.model.module.Component;
import mview.model.module.Dependency;
import mview.model.module.Interface;
import mview.model.property.ActorProperty;
import mview.model.refinement.RefinableDeclaration;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupContextFactory;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.Modifier;
import be.kuleuven.cs.distrinet.chameleon.core.property.ChameleonProperty;
import be.kuleuven.cs.distrinet.chameleon.core.property.StaticChameleonProperty;
import be.kuleuven.cs.distrinet.jnome.core.language.Java;
import be.kuleuven.cs.distrinet.rejuse.junit.BasicRevision;
import be.kuleuven.cs.distrinet.rejuse.property.Property;
import be.kuleuven.cs.distrinet.rejuse.property.PropertyMutex;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class MView extends Java {

	// mutex
	public final PropertyMutex<ChameleonProperty> ACTOR_MUTEX;
	public final PropertyMutex<ChameleonProperty> ADVICE_MUTEX;

	// final. ... properties
	public final ChameleonProperty EXECUTION;
	public final ChameleonProperty CALL;

	public final ChameleonProperty BEFORE;
	public final ChameleonProperty AFTER;
	public final ChameleonProperty AROUND;

	public final ActorProperty INTERFACE;
	public final ActorProperty COMPONENT;
	public final ActorProperty APPLICATION;
	public final ActorProperty INSTANCE;
	public final ActorProperty HOST;

	public final ChameleonProperty NEGATE;

	public final ChameleonProperty OVERRIDABLE;
	public final ChameleonProperty EXTENDABLE;

	public final ChameleonProperty ABSTRACT;

	public final Set<ActorProperty> ACTOR_PROPERTIES;

	/**
	 * @param name
	 */
	public MView() {
		super("MView", new LookupContextFactory(),new BasicRevision(0,1,0));

		// Pointcut
		EXECUTION =
				new StaticChameleonProperty("Execution", this, Pointcut.class);
		CALL = EXECUTION.inverse();
		CALL.setName("Call");

		// Advice
		ADVICE_MUTEX = new PropertyMutex<ChameleonProperty>();

		BEFORE =
				new StaticChameleonProperty("Before advice", this,
						ADVICE_MUTEX,
						Advice.class);

		AFTER = new StaticChameleonProperty("After advice", this,
						ADVICE_MUTEX,
						Advice.class);

		AROUND =
				new StaticChameleonProperty("Around advice", this,
						ADVICE_MUTEX,
						Advice.class);

		// ActorProperties
		ACTOR_MUTEX = new PropertyMutex<ChameleonProperty>();

		INTERFACE = new ActorProperty(Interface.class, this, ACTOR_MUTEX,
				ActorProp.class);

		COMPONENT = new ActorProperty(Component.class, this, ACTOR_MUTEX,
				ActorProp.class);

		INSTANCE = new ActorProperty(Instance.class, this, ACTOR_MUTEX,
				ActorProp.class);

		APPLICATION =
				new ActorProperty(Application.class, this, ACTOR_MUTEX,
						ActorProp.class);

		HOST = new ActorProperty(Host.class, this, ACTOR_MUTEX,
				ActorProp.class);

		final ActorProperty[] ACTOR_PROPERTIES_DECL =
			{
					INTERFACE,
					COMPONENT,
					APPLICATION,
					INSTANCE,
					HOST
			};

		ACTOR_PROPERTIES = new HashSet<ActorProperty>(
				Arrays.asList(ACTOR_PROPERTIES_DECL));

		// overridable property
		OVERRIDABLE =
				new StaticChameleonProperty("Overridable", this,
						ActorProp.class);
		OVERRIDABLE.addValidElementType(PointcutSignature.class);
		OVERRIDABLE.addValidElementType(Dependency.class);

		EXTENDABLE = OVERRIDABLE.inverse();
		EXTENDABLE.setName("Extendable");

		// negate property
		NEGATE = new StaticChameleonProperty("Negate", this, PropValue.class);
		NEGATE.addValidElementType(ServiceSignature.class);

		// abstract property
		ABSTRACT =
				new StaticChameleonProperty("Abstract", this,
						RefinableDeclaration.class);
	}
	
	/**
	 * Return Pointcut Kind modifier for given property <code>kind</code>.
	 * @param kind
	 * @return
	 */
	public Modifier pointcutKindModifierForProperty(Property kind) {
		
		Modifier result = null;
		
		if (kind == EXECUTION) {
			result = new Execution();
		} else if (kind == CALL) {
			result = new Call();
		}
		
		return result;
	}

	/**
	 * Return Advice Type modifier for given Property <code>type</code>.
	 * @param type
	 * @return
	 */
	public Modifier adviceTypeModifierForProperty(Property type) {
		
		Modifier result = null;
		
		if (type == BEFORE) {
			result = new Before();			
		} else if (type == AROUND) {
			result = new Around();
		} else if (type == AFTER) {
			result = new After();
		}
		
		return result;
		
	}
	
	// /**
	// * @param declaration
	// * @return A PropertySet of actor properties for the given declaration
	// */
	// public <D extends Declaration> Set<ChameleonProperty> actorProperties(
	// Class<D> declaration) {
	// Set<ChameleonProperty> result = new HashSet<ChameleonProperty>();
	//
	// for (ActorProperty property : ACTOR_PROPERTIES) {
	// if (property.targetDeclarationType().equals(declaration)) {
	// result.add(property);
	// }
	// }
	//
	// return result;
	// }

	@Override
	protected void initializePropertyRules() {
	}

	@Override
	protected void initializeValidityRules() {
	}

	@Override
	public boolean isValidIdentifierCharacter(char character) {
		return Character.isJavaIdentifierPart(character);
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see chameleon.core.language.Language#cloneThis()
//	 */
//	@Override
//	protected Language cloneThis() {
//		throw new RuntimeException("unimplemented");
//	}

//	@Override
//	public RootNamespace defaultNamespace() {
//		super.defaultNamespace();
//	}

}

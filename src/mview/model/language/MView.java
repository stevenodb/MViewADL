/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MView.java
 * created:  Jan 22, 2010, 1:56:34 PM
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
package mview.model.language;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import mview.model.application.Application;
import mview.model.application.Host;
import mview.model.application.Instance;
import mview.model.composition.Advice;
import mview.model.composition.Pointcut;
import mview.model.module.Component;
import mview.model.module.Interface;
import mview.model.refinement.MViewMember;

import org.rejuse.property.PropertyMutex;

import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.language.Language;
import chameleon.core.namespace.RootNamespace;
import chameleon.core.property.ChameleonProperty;
import chameleon.core.property.StaticChameleonProperty;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class MView extends Language {

	// mutex
	public final PropertyMutex<ChameleonProperty> ACTOR_MUTEX;
	public final PropertyMutex<ChameleonProperty> ADVICE_MUTEX;

	// final. ... properties
	public final StaticChameleonProperty EXECUTION;
	public final ChameleonProperty CALL;

	public final StaticChameleonProperty BEFORE;
	public final StaticChameleonProperty AFTER;
	public final StaticChameleonProperty AROUND;

	public final StaticChameleonProperty INTERFACE;
	public final StaticChameleonProperty COMPONENT;
	public final StaticChameleonProperty APPLICATION;
	public final StaticChameleonProperty INSTANCE;
	public final StaticChameleonProperty HOST;
	
	public final StaticChameleonProperty OVERRIDABLE;

	private final Set<StaticChameleonProperty> ACTOR_PROPERTIES;

	/**
	 * @param name
	 */
	public MView() {
		super("MView", new MViewLookupFactory());
		new RootNamespace(new SimpleNameSignature(""), this);

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

		
		// ActorProp
		ACTOR_MUTEX = new PropertyMutex<ChameleonProperty>();

		INTERFACE = new StaticChameleonProperty("Interface", this, ACTOR_MUTEX,
				Interface.class);

		COMPONENT = new StaticChameleonProperty("Component", this, ACTOR_MUTEX,
				Component.class);

		INSTANCE = new StaticChameleonProperty("Instance", this, ACTOR_MUTEX,
				Instance.class);

		APPLICATION =
				new StaticChameleonProperty("Application", this, ACTOR_MUTEX,
						Application.class);

		HOST = new StaticChameleonProperty("Host", this, ACTOR_MUTEX,
				Host.class);

		final StaticChameleonProperty[] ACTOR_PROPERTIES_DECL =
			{
					INTERFACE,
					COMPONENT,
					APPLICATION,
					INSTANCE,
					HOST
			};

		ACTOR_PROPERTIES = new HashSet<StaticChameleonProperty>(
				Arrays.asList(ACTOR_PROPERTIES_DECL));

		// overridable property
		OVERRIDABLE =
				new StaticChameleonProperty("Overridable", this,
						MViewMember.class);
	}

	/**
	 * @param declaration
	 * @return A PropertySet of actor properties for the given declaration
	 */
	public <D extends Declaration> Set<ChameleonProperty> actorProperties(Class<D> declaration) {
		Set<ChameleonProperty> result = new HashSet<ChameleonProperty>();

		for (StaticChameleonProperty property : ACTOR_PROPERTIES) {
			if (property.validElementTypes().contains(declaration)) {
				result.add(property);
			}
		}

		return result;
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.language.Language#cloneThis()
	 */
	@Override
	protected Language cloneThis() {
		throw new RuntimeException("unimplemented");
	}

}

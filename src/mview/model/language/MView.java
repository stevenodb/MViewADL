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

import java.util.HashSet;
import java.util.Set;

import mview.model.application.Application;
import mview.model.application.Instance;
import mview.model.composition.Pointcut;
import mview.model.module.Component;
import mview.model.module.Interface;
import mview.reuse.Host;

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
	
	
	// final. ... properties
	public final StaticChameleonProperty EXECUTION;
	public final StaticChameleonProperty CALL;
	
	public final StaticChameleonProperty INTERFACE;
	public final StaticChameleonProperty COMPONENT;
	public final StaticChameleonProperty APPLICATION;
	public final StaticChameleonProperty INSTANCE;
	public final StaticChameleonProperty HOST;
	
	private final Set<StaticChameleonProperty> ACTOR_PROPERTIES 
		= new HashSet<StaticChameleonProperty>();
	
	/**
	 * @param name
	 */
	public MView() {
		super("MView",new MViewLookupFactory());
		new RootNamespace(new SimpleNameSignature(""), this);
		
		EXECUTION = new StaticChameleonProperty("Execution", this, Pointcut.class);
		CALL = (StaticChameleonProperty) EXECUTION.inverse();
		CALL.setName("Call");
		
		ACTOR_MUTEX = new PropertyMutex<ChameleonProperty>();
		
		INTERFACE = new StaticChameleonProperty("Interface", this, ACTOR_MUTEX, Interface.class);
		ACTOR_PROPERTIES.add(INTERFACE);
		
		COMPONENT = new StaticChameleonProperty("Component", this, ACTOR_MUTEX, Component.class);
		ACTOR_PROPERTIES.add(COMPONENT);
		
		INSTANCE = new StaticChameleonProperty("Instance",this,ACTOR_MUTEX,Instance.class);
		ACTOR_PROPERTIES.add(INSTANCE);
		
		APPLICATION = new StaticChameleonProperty("Application", this, ACTOR_MUTEX, Application.class);
		ACTOR_PROPERTIES.add(APPLICATION);
		
		HOST = new StaticChameleonProperty("Host", this, ACTOR_MUTEX, Host.class);
		ACTOR_PROPERTIES.add(HOST);
		
	}
	
	
	/**
	 * @param declaration
	 * @return	A PropertySet of actor properties for the given declaration
	 */
	public Set<ChameleonProperty> actorProperties(Class<Declaration> declaration) {
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

	/* (non-Javadoc)
	 * @see chameleon.core.language.Language#cloneThis()
	 */
	@Override
	protected Language cloneThis() {
		throw new RuntimeException("unimplemented");
	}

}

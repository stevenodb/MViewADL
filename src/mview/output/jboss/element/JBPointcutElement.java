/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBPointcut.java
 * created:  Mar 21, 2011, 2:32:24 PM
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
package mview.output.jboss.element;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import mview.model.composition.PatternSignature;
import mview.model.composition.Pointcut;
import mview.output.WriterArguments;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBPointcutElement extends JBElementImpl {
	
	/**
	 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
	 *
	 */
	public enum PointcutKind {
		EXECUTION("Execution"), CALL("Call");
		
		private String _name;

		private PointcutKind(String name) {
			_name = name;
		}
		
		@Override
		public String toString() {
			return _name;
		}
	}
	
	/**
	 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
	 *
	 */
	public enum ActorType {
		INTERFACE, COMPONENT, INSTANCE, APPLICATION, HOST;
	}

	private PointcutKind _kind;
	private List<PatternSignature> _patternSignatures =
		new ArrayList<PatternSignature>();
	private Map<ActorType, List<JBActorPropValue>> _callerMap;
	private Map<ActorType, List<JBActorPropValue>> _calleeMap;

	/**
	 * @param sourceElement
	 */
	public JBPointcutElement(Pointcut sourceElement) {
		super(sourceElement);
	}	

	/**
	 * @return
	 */
	public PointcutKind kind() {
		return _kind;
	}
	
	/**
	 * @param pcKi
	 */
	public void setKind(PointcutKind pcKind) {
		_kind = pcKind;
	}
	
	/**
	 * @return
	 */
	public List<PatternSignature> patternSignature() {
		return _patternSignatures;
	}

	/**
	 * @param clone
	 */
	public void addPatternSignature(PatternSignature signature) {
		_patternSignatures.add(signature);
	}

	/**
	 * @return
	 */
	public Map<ActorType, List<JBActorPropValue>> callerMap() {
		return new EnumMap<ActorType, List<JBActorPropValue>>(_callerMap);
	}
	
	/**
	 * @param callerMap
	 */
	public void addCaller(Map<ActorType, List<JBActorPropValue>> callerMap) {
		_callerMap = callerMap;
	}

	/**
	 * @return
	 */
	public Map<ActorType, List<JBActorPropValue>> calleeMap() {
		return new EnumMap<ActorType, List<JBActorPropValue>>(_calleeMap);
	}

	/**
	 * @param calleeMap
	 */
	public void addCallee(Map<ActorType, List<JBActorPropValue>> calleeMap) {
		_calleeMap = calleeMap;
	}

	@Override
	public void writeCode(WriterArguments arg) {
		// TODO Auto-generated method stub
	}
}

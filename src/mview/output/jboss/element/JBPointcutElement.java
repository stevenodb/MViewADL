/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBPointcut.java
 * created:  Mar 21, 2011, 2:32:24 PM
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
package mview.output.jboss.element;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import mview.model.composition.AOComposition;
import mview.model.composition.PatternSignature;
import mview.model.composition.Pointcut;
import mview.model.composition.ServiceSignature;
import mview.model.module.Service;
import mview.output.WriterArguments;
import mview.output.jboss.element.JBPointcutElement.ActorType;
import mview.output.jboss.element.JBPointcutElement.PointcutKind;

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

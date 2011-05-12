/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBAdvice.java
 * created:  Mar 21, 2011, 3:31:33 PM
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

import mview.model.composition.AOComposition;
import mview.model.composition.Advice;
import mview.output.jboss.element.JBAdviceElement.AdviceType;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBAdviceElement {
	
	public enum AdviceType {
		BEFORE("AdviceType.BEFORE"), 
		AROUND("AdviceType.AROUND"), 
		AFTER("AdviceType.AFTER");
				
		private String _name;

		AdviceType(String name) {
			_name = name;
		}
		
		@Override
		public String toString() {
			return _name;
		}
	}

	private AdviceType _adviceType;
	private String _serviceReturnType;
	private String _serviceSignature;
	private String _serviceInterface;

	/**
	 * @param sourceElement
	 */
	public JBAdviceElement(Advice sourceElement) {
	}

	/**
	 * @return
	 */
	public AdviceType type() {
		return _adviceType;
	}
	
	/**
	 * @param adviceType
	 */
	public void setType(AdviceType adviceType) {
		_adviceType = adviceType;
	}

	/**
	 * @return
	 */
	public String serviceReturnType() {
		return _serviceReturnType;
	}
	
	/**
	 * @param name
	 */
	public void setServiceReturnType(String returnType) {
		_serviceReturnType = returnType;
	}
	
	public String serviceSignature() {
		return _serviceSignature;
	}

	/**
	 * @param name
	 */
	public void setServiceSignature(String signature) {
		_serviceSignature = signature;
	}
	
	public String serviceInterface() {
		return _serviceInterface;
	}

	/**
	 * @param name
	 */
	public void setServiceInterface(String name) {
		_serviceInterface = name;
	}
}

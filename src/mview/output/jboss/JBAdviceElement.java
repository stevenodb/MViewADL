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
package mview.output.jboss;

import mview.model.composition.AOComposition;
import mview.model.composition.Advice;
import mview.output.jboss.JBAdviceElement.AdviceType;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBAdviceElement {
	
	/**
	 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
	 *
	 */
	public enum AdviceType {
		BEFORE, AROUND, AFTER
	}

	private AdviceType _adviceType;
	private String _adviceReturnType;
	private String _adviceSignature;

	/**
	 * @param sourceElement
	 */
	protected JBAdviceElement(Advice sourceElement) {
	}

	/**
	 * @param adviceType
	 */
	public void setAdviceType(AdviceType adviceType) {
		_adviceType = adviceType;
	}

	/**
	 * @param name
	 */
	public void addSericeReturnType(String returnType) {
		_adviceReturnType = returnType;
	}

	/**
	 * @param name
	 */
	public void addServiceSignature(String signature) {
		_adviceSignature = signature;
	}
}

/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBActorProp.java
 * created:  Mar 31, 2011, 1:56:20 PM
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

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBActorPropValue {

	private boolean _negated;
	private String _value;

	/**
	 * @return
	 */
	public boolean isNegated() {
		return _negated;
	}
	
	/**
	 * @param negated
	 */
	public void setNegated(boolean negated) {
		_negated = negated;
	}

	/**
	 * @return
	 */
	public String value() {
		return _value;
	}
	
	/**
	 * @param name
	 */
	public void setValue(String name) {
		_value = name;
	}

}

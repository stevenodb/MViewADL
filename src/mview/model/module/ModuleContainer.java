/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: ModuleContainer.java
 * created:  Jun 10, 2010, 6:24:10 PM
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
package mview.model.module;

import java.util.List;


/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 */
public interface ModuleContainer {

//	/**
//	 * @return a list of contained modules
//	 */
//	List<Module> modules();

	/**
	 * @param relation	the Module to add
	 */
	public void addModule(Module relation);

	/**
	 * @param relation	the Module to remove
	 */
	public void removeModule(Module relation);

}

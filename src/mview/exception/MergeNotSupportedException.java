/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MergeNotSupportedException.java
 * created:  Nov 5, 2010, 3:14:13 PM
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
package mview.exception;


/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class MergeNotSupportedException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5930589425559260240L;

	/**
	 * default 
	 */
	public MergeNotSupportedException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public MergeNotSupportedException(String message) {
		super(message);
	}

}

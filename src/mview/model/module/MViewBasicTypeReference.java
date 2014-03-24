/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MViewBasicTypeReference.java
 * created:  Dec 15, 2010, 4:12:12 PM
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

import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.reference.CrossReference;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.oo.type.BasicTypeReference;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class MViewBasicTypeReference extends BasicTypeReference {

	/**
	 * @param fqn
	 */
	public MViewBasicTypeReference(String fqn) {
		super(fqn);
	}

	/**
	 * @param target
	 * @param name
	 */
	public MViewBasicTypeReference(CrossReference target, String name) {
		super(target, name);
	}

	/**
	 * @param target
	 * @param signature
	 */
	public MViewBasicTypeReference(CrossReference target,
			SimpleNameSignature signature) {
		super(target, signature);
	}

	/* (non-Javadoc)
	 * @see chameleon.core.reference.CrossReferenceImpl#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		return Valid.create();
	}
}

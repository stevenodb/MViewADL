/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MViewBasicTypeReference.java
 * created:  Dec 15, 2010, 4:12:12 PM
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

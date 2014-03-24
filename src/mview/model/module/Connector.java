/**
 * author:     Steven Op de beeck <steven /at/ opdebeeck /./ org>
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

import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;
import mview.model.composition.AOComposition;
import mview.model.refinement.MViewMember;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;

public class Connector extends Module {
	
	/**
	 * Default constructor 
	 */
	protected Connector() {
	}

	/**
	 * @param signature
	 */
	public Connector(SimpleNameSignature signature) {
		super(signature);
	}

	/*
	 * composition association
	 */
	private Multi<AOComposition> _compositions = new Multi<AOComposition>(this); 
 
	protected List<AOComposition> compositions() {
		return _compositions.getOtherEnds();
	}
	
	public void removeComposition(AOComposition relation) {
		remove(_compositions,relation);
	}
	
	public void addComposition(AOComposition relation) {
		add(_compositions,relation);
	}

	
	/* (non-Javadoc)
	 * @see mview.model.module.Module#cloneThis()
	 */
	@Override
	protected Connector cloneSelf() {
		return new Connector();
	}

	@Override
	public Verification verifySelf() {
		Verification result = super.verifySelf();
		
		if ( ! (compositions() != null) ) {
			result = result.and(new BasicProblem(this, 
					this.signature().name() + ": Compositions is null"));
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.RefinableDeclaration#localMembers()
	 */
	@Override
	public List<MViewMember> localMembers() {
		List<MViewMember> result = super.localMembers();
		result.addAll(compositions());
		return result;
	}

}

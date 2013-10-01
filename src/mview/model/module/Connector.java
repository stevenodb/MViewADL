/**
 * author:     Steven Op de beeck <steven /at/ opdebeeck /./ org>
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
 * You should have received a copy of the GNU General Public License
 *
 * If not, see <http://www.gnu.org/licenses/>.
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

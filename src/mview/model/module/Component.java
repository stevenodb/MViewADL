/**
 * author:     Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename:   Component.java
 * created:    Nov 20, 2009, 11:23:49 AM
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

import mview.model.refinement.MViewMember;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 * @param <E>
 */
public class Component extends Module {

	/**
	 * default
	 */
	protected Component() {
	}
	
	/**
	 * @param signature
	 */
	public Component(SimpleNameSignature signature) {
		super(signature);
	}
	
	

	/* (non-Javadoc)
	 * @see mview.model.module.Module#cloneThis()
	 */
	@Override
	protected Component cloneThis() {
		return new Component();
	}
	
	/* (non-Javadoc)
	 * @see mview.model.module.Module#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		Verification result = super.verifySelf();
		
		if ( ! isAbstract() ) {
		
			if ( ! (this.providedInterfaces().size() >= 1) ) {
				result = result.and(new BasicProblem(this, 
					this.signature().name() + ": Missing provided interface."));
			}
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.RefinableDeclaration#localMembers()
	 */
	@Override
	public List<MViewMember> localMembers() {
		return super.localMembers();
	}

}

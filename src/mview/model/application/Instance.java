/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Instance.java
 * created:  Oct 20, 2010, 3:48:46 PM
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
package mview.model.application;

import mview.model.module.Module;
import mview.model.refinement.MViewMemberDeclarationImpl;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;
import chameleon.util.association.Single;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Instance extends MViewMemberDeclarationImpl {
	
	/**
	 * Default 
	 */
	public Instance() {
		super();
	}

	/**
	 * @param signature
	 */
	public Instance(SimpleNameSignature signature) {
		super(signature);
	}

	// type
	private Single<SimpleReference<Module>> _type = new Single<SimpleReference<Module>>(this);
	
	/**
	 * @return
	 */
	public SimpleReference<Module> type() {
		return _type.getOtherEnd();
	}

	/**
	 * @param relation
	 */
	public void setType(SimpleReference<Module> relation) {
		set(_type,relation);	 
	}
	
	// host
	private Single<SimpleReference<Host>> _host = new Single<SimpleReference<Host>>(this);
	
	/**
	 * @return
	 */
	public SimpleReference<Host> host() {
		return _host.getOtherEnd();
	}
	
	/**
	 * @param relation
	 */
	public void setHost(SimpleReference<Host> relation) {
		set(_host,relation);
	}
	
	
	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#cloneThis()
	 */
	@Override
	protected Instance cloneThis() {
		return new Instance();
	}
	
	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#clone()
	 */
	@Override
	public Instance clone() {
		final Instance clone = (Instance) super.clone();
		
		clone.setType(type().clone());
		clone.setHost(host().clone());
				
		return clone;
	}

	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		final VerificationResult result = super.verifySelf();
		
		if ( ! (host() != null) ) { 
			result.and(new BasicProblem(this, "Instance needs a host"));
		}
		
		if ( ! (type() != null) ) { 
			result.and(new BasicProblem(this, "Instance needs a type"));
		}
		
		return result;
	}

//	/* (non-Javadoc)
//	 * @see mview.model.refinement.MViewMember#overrides(mview.model.refinement.MViewMember)
//	 */
//	@Override
//	public boolean overrides(Instance other) {
//		return this.equals(other);
//	}
//
//	/* (non-Javadoc)
//	 * @see mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember)
//	 */
//	@Override
//	public Instance merge(Instance member) throws MergeNotSupportedException {
//		throw new MergeNotSupportedException(this+" does not support merge");
//	}
}

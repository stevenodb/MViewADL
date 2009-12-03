/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Composite.java
 * created:  Nov 20, 2009, 11:42:55 AM
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
 * along with Digital Publishing Demonstrator.  
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mstage.model.module;

import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;

import com.sun.xml.internal.rngom.parse.host.Base;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * @param <E>
 *
 */
public class Composite extends Component<Composite> {
	
	
	/**
	 * Default constructor
	 */
	public Composite() {
		//what are you staring at?
	}
	
	/**
	 * @param submodules
	 */
	protected Composite(
			SimpleNameSignature signature) {
		
		super(signature);	
	}

	/*
	 * Association to composite's submodules 
	 */
	private OrderedMultiAssociation<Composite, SimpleReference<Module<?>>> _submodules =
		new OrderedMultiAssociation<Composite, SimpleReference<Module<?>>>(this);

	
	/**
	 * @return a list of references to submodules
	 */
	public List<SimpleReference<Module<?>>> submodules() {
		return _submodules.getOtherEnds();
	}

	/**
	 * @param relation	reference to the Module to add
	 */
	public void addSubmodules(SimpleReference<Module<?>> relation) {
		_submodules.add(relation.parentLink());
	}
	
	
	/**
	 * @param relation	reference to the Module to remove
	 */
	public void removeSubmodules(SimpleReference<Module<?>> relation) {
		_submodules.remove(relation.parentLink());
	}
	

	/* (non-Javadoc)
	 * @see mstage.model.Component#clone()
	 */
	@Override
	public Composite clone() {
		Composite clone = super.clone();

		for (SimpleReference<Module<?>> simpleReference : this.submodules()) {
			clone.addSubmodules(simpleReference.clone());
		}
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see mstage.model.Component#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if (submodules().size() == 0) {
			result = result.and(new BasicProblem(this, "No submodules in Composite"));
		}
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#children()
	 */
	@Override
	public List<Element> children() {
		// TODO Auto-generated method stub
	}

}

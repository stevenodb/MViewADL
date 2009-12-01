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

import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * @param <E>
 *
 */
public class Composite extends Component<Composite> {
	
	
	/*
	 * Association to composite's submodules 
	 */
	private OrderedMultiAssociation<Composite, SimpleReference<Module<?>>> _submodules =
		new OrderedMultiAssociation<Composite, SimpleReference<Module<?>>>(this);

	
	/**
	 * @return a list of references to submodules
	 */
	public List<SimpleReference<Module<?>>> _submodules() {
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
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see mstage.model.Component#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		// TODO Auto-generated method stub
	}
	

}

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
 * along with Digital Publishing Demonstrator.  
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mstage.model.module;

import java.util.List;

import mstage.model.composition.AOComposition;

import org.rejuse.association.OrderedMultiAssociation;

import sun.awt.im.CompositionArea;

import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.VerificationResult;

public class Connector extends Module<Connector> {
	
	private OrderedMultiAssociation<Connector, AOComposition> _compositions = 
		new OrderedMultiAssociation<Connector, AOComposition>(this); 
	// FIXME:this ok?
 
	
	public void removeComposition(AOComposition relation) {
		_compositions.remove(relation.parentLink());
	}

	public List<AOComposition> compositions() {
		return _compositions.getOtherEnds();
	}
	
	public void addComposition(AOComposition relation) {
		_compositions.add(relation.parentLink());
	}

	@Override
	public Connector clone() {
		// TODO Auto-generated method stub
	}

	@Override
	public VerificationResult verifySelf() {
		// TODO Auto-generated method stub
	}

}

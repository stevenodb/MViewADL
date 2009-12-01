/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: AOComposition.java
 * created:  Nov 24, 2009, 5:52:14 PM
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
package mstage.model.composition;

import mstage.model.module.Service;
import mstage.model.namespace.MStageDeclaration;

import org.rejuse.association.OrderedMultiAssociation;
import org.rejuse.association.SingleAssociation;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class AOComposition extends MStageDeclaration<AOComposition, Element> {
	
	/*
	 * Advice
	 */
	private SingleAssociation<AOComposition, Advice> _advice;
	
	/**
	 * @return
	 */
	public Advice _advice() {
		return _advice.getOtherEnd();
	}
	
	/**
	 * @param relation
	 */
	public void setAdvice(Advice relation) {
		_advice.connectTo(relation.parentLink());
	}

	
	/*
	 * Pointcut
	 */
	private SingleAssociation<AOComposition, Pointcut> _pointcut;

	/**
	 * @return
	 */
	public Pointcut _pointcut() {
		return _pointcut.getOtherEnd();
	}
	
	/**
	 * @param relation
	 */
	public void setPointcut(Pointcut relation) {
		_pointcut.connectTo(relation.parentLink());
	}

	

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public AOComposition clone() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		// TODO Auto-generated method stub
	}

}

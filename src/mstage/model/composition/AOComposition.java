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

import java.util.List;

import mstage.model.module.Service;
import mstage.model.namespace.MStageDeclaration;

import org.rejuse.association.OrderedMultiAssociation;
import org.rejuse.association.SingleAssociation;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;
import chameleon.util.Util;

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
	public Advice advice() {
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
	public Pointcut pointcut() {
		return _pointcut.getOtherEnd();
	}
	
	/**
	 * @param relation
	 */
	public void setPointcut(Pointcut relation) {
		_pointcut.connectTo(relation.parentLink());
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#cloneThis()
	 */
	@Override
	protected AOComposition cloneThis() {
		return new AOComposition();
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#clone()
	 */
	@Override
	public AOComposition clone() {
		final AOComposition clone = super.clone();
		
		clone.setAdvice(
				this.advice().clone()
		);
		
		clone.setPointcut(
				this.pointcut()
		);
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#children()
	 */
	@Override
	public List<Element> children() {
		List<Element> result = super.children();
		
		Util.addNonNull(this.advice(), result);
		Util.addNonNull(this.pointcut(), result);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if ( ! (this.advice() != null) ) {
			result = result.and(new BasicProblem(this, "Advice is null"));
		}
		
		if ( ! (this.pointcut() != null) ) {
			result = result.and(new BasicProblem(this, "Pointcut is null"));
		}
		
		return result;
	}

}

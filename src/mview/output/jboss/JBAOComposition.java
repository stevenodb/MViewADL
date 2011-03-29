/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBAOComposition.java
 * created:  Mar 21, 2011, 2:21:27 PM
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
package mview.output.jboss;

import mview.model.composition.AOComposition;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class JBAOComposition extends JBDeclarationImpl<JBAOComposition,AOComposition> {

	private JBPointcutElement	_jbPointcut;
	private JBAdviceElement		_jbAdvice;


	/**
	 * @param sourceElement
	 */
	protected JBAOComposition(AOComposition sourceElement) {
		super(sourceElement);
	}


	/**
	 * @return
	 */
	public JBPointcutElement pointcut() {
		return _jbPointcut;
	}
	

	/**
	 * @return
	 */
	public JBAdviceElement advice() {
		return _jbAdvice;
	}


	/**
	 * @param jbPC
	 */
	public void addPointcut(JBPointcutElement jbPC) {
		// TODO Auto-generated method stub
	}


	/**
	 * @param jbAdv
	 */
	public void addAdvice(JBAdviceElement jbAdv) {
		// TODO Auto-generated method stub
	}

}

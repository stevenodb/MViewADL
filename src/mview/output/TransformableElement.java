/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: TransformableElement.java
 * created:  May 23, 2011, 5:17:29 PM
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
package mview.output;

import java.util.List;

import mview.output.jboss.declaration.JBDeclaration;
import chameleon.core.compilationunit.CompilationUnit;
import chameleon.core.element.Element;
import chameleon.exception.ModelException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public interface TransformableElement {
	
//	public void transform(Element src, JBDeclaration parentTarget,
//			final List<JBDeclaration> result) throws ModelException;
	public Element sourceElement();
	public void writeCode(WriterArguments arg);
	
}

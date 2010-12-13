/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MViewMemberDeclaration.java
 * created:  Dec 13, 2010, 5:38:03 PM
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
package mview.model.refinement;

import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import mview.model.namespace.MViewDeclaration;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public interface MViewMemberDeclaration<M extends MViewMemberDeclaration<M, P>, P extends Element> extends Declaration<M, P, SimpleNameSignature, M> , MViewMember<M, P>{

}

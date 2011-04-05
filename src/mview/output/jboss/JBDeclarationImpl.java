/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBDeclarationImpl.java
 * created:  Mar 21, 2011, 2:29:30 PM
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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import mview.model.namespace.MViewDeclaration;
import mview.output.WriterArguments;
import chameleon.core.declaration.Declaration;
import chameleon.core.lookup.LookupException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class JBDeclarationImpl<D extends JBDeclarationImpl, E extends Declaration>
		implements JBDeclaration<D> {

	private final E	_sourceElement;
	private String _packageName;

	protected JBDeclarationImpl(E sourceElement) {
		_sourceElement = sourceElement;
	}

	@Override
	public E sourceElement() {
		return _sourceElement;
	}

	public String getName() {
		return sourceElement().signature().name(); 
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public void writeCode(WriterArguments args) {
		String fileName = this.getName() + ".java";

		String packageFQN = packageName();

		if (packageFQN.equals("")) {
			packageFQN = args.defaultNamespace();
		}

		String relDirName = packageFQN.replace('.', File.separatorChar);
		File out =
				new File(args.outputDir().getAbsolutePath()
						+ File.separatorChar + relDirName
						+ File.separatorChar + fileName);

		System.out.println("Writing: " + out.getAbsolutePath());

		File parent = out.getParentFile();
		parent.mkdirs();
		
		try {
			out.createNewFile();
			FileWriter fw = new FileWriter(out);
	
			// preamble
	//		fw.write(preamble(element.getClass()).toString());
	
			// body
	//		fw.write(code);
	
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return
	 */
	public String packageName() {
		return _packageName;
	}
	
	public void setPackageName(String fqn) {
		_packageName = fqn;
	}

	@Override
	public boolean equals(Object other) {
		try {
			return (other != null) 
				&& (other instanceof JBDeclaration) 
				&& (this.sourceElement().sameAs(((JBDeclaration)other).sourceElement()));
		} catch (LookupException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.sourceElement().hashCode();
	}
}

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
package mview.output.jboss.declaration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	private final JBDeclaration _parentDeclaration;
	private String _packageName;

	protected JBDeclarationImpl(E sourceElement, JBDeclaration parentDeclaration) {
		if (sourceElement != null) {
			_sourceElement = sourceElement;
			_parentDeclaration = parentDeclaration;			
		} else {
			throw new NullPointerException("sourceElement cannot be Null.");
		}
	}
	
	@Override
	public JBDeclaration parentDeclaration() {
		return _parentDeclaration;
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

	private int _indent;
	private final int _tabSize = 4;


	/**
	 * @return the indent
	 */
	public int getIndent() {
		return _indent;
	}


	protected void indent() {
		_indent += _tabSize;
	}


	protected void undent() {
		_indent -= _tabSize;
	}


	/**
	 * @return
	 */
	protected StringBuffer startLine() {
		final StringBuffer sb = new StringBuffer(); 
		int indent = getIndent();
		for (int i = 0; i < indent; i++) {
			sb.append(' ');
		}
		
		return sb;
	}
	
	private StringBuffer newLine() {
		return newLine(new StringBuffer());
	}

	protected StringBuffer newLine(StringBuffer sb) {
		return sb.append("\n");
	}

	/**
	 * @param text
	 * @return start text on a new line
	 */
	public StringBuffer startNewLine(StringBuffer sb, String text) {
		return sb.append(newLine().toString() + startLine().toString() + text);
	}
	
	/**
	 * @param sb
	 * @param term
	 * @return
	 */
	public StringBuffer appendTerm(StringBuffer sb, String term) {
		return appendTermStrict(sb, term+" ");
	}
	
	/**
	 * @param sb
	 * @param term
	 * @return
	 */
	public StringBuffer appendTermStrict(StringBuffer sb, String term) {
		return sb.append(term);
	}
	
	/**
	 * @param code
	 */
	public StringBuffer identCode(StringBuffer sb, String code) {
		return sb.append(code.replaceAll("\\n", "\n"+startLine().toString()));
	}


	/**
	 * @param typeName
	 * @return
	 */
	public String typeToInstanceName(String typeName) {
		final StringBuffer result = new StringBuffer();
		result.append(typeName.substring(0, 1).toLowerCase());
		result.append(typeName.substring(1));
		return result.toString();
	}
	
	/**
	 * @param args
	 * @param code
	 */
	public void writeCode(WriterArguments args) {
		String fileName = this.getName() + ".java";

		String packageFQN = packageName();

		if (packageFQN == null || packageFQN.equals("")) {
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
			fw.write(toCode(this));
	
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
	
	/**
	 * @param parent
	 * @return
	 */
	abstract protected String toCode(JBDeclaration parent);
}

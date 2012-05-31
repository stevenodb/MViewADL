/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MViewModelFactory.java
 * created:  Jan 22, 2010, 1:59:47 PM
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
package mview.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

import mview.model.language.MView;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

import chameleon.core.element.Element;
import chameleon.core.language.Language;
import chameleon.input.ModelFactory;
import chameleon.input.ParseException;
import chameleon.support.input.ChameleonParser;
import chameleon.support.input.ModelFactoryUsingANTLR;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class MViewModelFactory extends ModelFactoryUsingANTLR {

	public MViewModelFactory() {
		this(new MView());
	}
	
	/**
	 * @param result
	 */
	public MViewModelFactory(Language language) {
		setLanguage(language, ModelFactory.class);
	}

	/* (non-Javadoc)
	 * @see chameleon.support.input.ModelFactoryUsingANTLR#getParser(java.io.InputStream, java.lang.String)
	 */
	@Override
	public ChameleonParser getParser(InputStream inputStream, String fileName)
			throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        MViewLexer lexer = new MViewLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MViewParser parser = new MViewParser(tokens);
        parser.setLanguage((Language) language());
        return parser;
	}

	@Override
	protected void initializePredefinedElements() {
	}

	/* (non-Javadoc)
	 * @see chameleon.support.input.ModelFactoryUsingANTLR#parse(chameleon.core.element.Element, java.lang.String)
	 */
	@Override
	protected <P extends Element> Element parse(Element element,
			String text) throws ParseException {
//  		try {
    		  InputStream inputStream = new StringBufferInputStream(text);
    		  Element result = null;
//    		  if(element instanceof Member) {
//    	  		result = getParser(inputStream, "document").memberDecl().element;
//    			}
    			return result;
//    		} catch(RecognitionException exc) {
//    			throw new ParseException(element.nearestAncestor(CompilationUnit.class));
//    		} catch(IOException exc) {
//    			throw new ChameleonProgrammerException("Parsing of a string caused an IOException",exc);
//    		}
	}

	@Override
	public MViewModelFactory clone() {
		try {
			return new MViewModelFactory();
		} catch (Exception e) {
			throw new RuntimeException("Exception while cloning a JavaModelFactory", e);
		}
	}

}

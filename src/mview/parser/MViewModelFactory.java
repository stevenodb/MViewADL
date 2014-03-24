/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MViewModelFactory.java
 * created:  Jan 22, 2010, 1:59:47 PM
 *
 * Copyright 2013 KU Leuven Research and Development - iMinds - DistriNet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Administrative Contact: dnet-project-office@cs.kuleuven.be
 * Technical Contact: steven@opdebeeck.org
 */
package mview.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

import mview.model.language.MView;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

import be.kuleuven.cs.distrinet.chameleon.input.ModelFactory;
import be.kuleuven.cs.distrinet.chameleon.input.ParseException;
import be.kuleuven.cs.distrinet.chameleon.support.input.ChameleonParser;
import be.kuleuven.cs.distrinet.chameleon.support.input.ModelFactoryUsingANTLR;
import be.kuleuven.cs.distrinet.chameleon.workspace.View;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.language.Language;

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
	public ChameleonParser getParser(InputStream inputStream, View view) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        MViewLexer lexer = new MViewLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MViewParser parser = new MViewParser(tokens);
        parser.setView(view);
        return parser;
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

/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: ParserTest.java
 * created:  Feb 1, 2010, 1:39:19 PM
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
package mstage.parser;

import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class ParserTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws RecognitionException 
	 */
	public static void main(String[] args) throws IOException, RecognitionException {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		
		MstageLexer lexer = new MstageLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		MstageParser parser = new MstageParser(tokens);
		
		parser.compilationUnit();
	}

}

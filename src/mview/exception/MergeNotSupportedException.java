/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MergeNotSupportedException.java
 * created:  Nov 5, 2010, 3:14:13 PM
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
package mview.exception;


/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class MergeNotSupportedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5930589425559260240L;

	/**
	 * default 
	 */
	public MergeNotSupportedException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public MergeNotSupportedException(String message) {
		super(message);
	}

}

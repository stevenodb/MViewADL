/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: PatternJoinPoint.java
 * created:  Nov 27, 2009, 6:05:14 PM
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
 *
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mview.model.composition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mview.model.module.Service;

import org.rejuse.predicate.UnsafePredicate;

import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;
import chameleon.util.Pair;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class PatternSignature extends
		ServiceSignature<PatternSignature, Service> {

	// eg: *, *Map, System*, newspaper..Article
	private String _returnTypePattern;

	// eg: *, do*, fetch*
	private String _signaturePattern;

	// eg: *, .. , *Set set, *List lst, *Person p,
	private List<Pair<String, String>> _formalParametersPattern;

	/**
	 * default constructor
	 */
	protected PatternSignature() {
		super();
	}

	/**
	 * @param returnTypePattern
	 * @param signaturePattern
	 */
	public PatternSignature(String returnTypePattern,
			String signaturePattern) {
		
		this(
			returnTypePattern,
			signaturePattern, 
			new ArrayList<Pair<String,String>>()
			);
	}
	
	/**
	 * @param returnTypePattern
	 * @param signaturePattern
	 * @param formalParamPatterns
	 */
	public PatternSignature(String returnTypePattern,
			String signaturePattern,	
			List<Pair<String, String>> formalParamPatterns) {
		this();
		
		_returnTypePattern = returnTypePattern;
		_signaturePattern = signaturePattern;
		_formalParametersPattern = formalParamPatterns;
	}

	/*
	 * Assessors for service association
	 */

	/**
	 * @param returnTypePattern
	 *            the returnTypePattern to set
	 */
	public void setReturnTypePattern(String returnTypePattern) {
		this._returnTypePattern = returnTypePattern;
	}

	/**
	 * @return the returnTypePattern
	 */
	public String returnTypePattern() {
		return _returnTypePattern;
	}

	/**
	 * @param signaturePattern
	 *            the signaturePattern to set
	 */
	public void setSignaturePattern(String signaturePattern) {
		this._signaturePattern = signaturePattern;
	}

	/**
	 * @return the signaturePattern
	 */
	public String signaturePattern() {
		return _signaturePattern;
	}

	/**
	 * @param formalParametersPattern
	 *            the formalParametersPattern to set
	 */
	private void setFormalParametersPattern(
			List<Pair<String, String>> formalParametersPattern) {
		this._formalParametersPattern = formalParametersPattern;
	}
	
	/**
	 * @param id
	 * @param typePattern
	 */
	public void addFormalParameterPattern(String id, String typePattern) {
		this._formalParametersPattern.add(
				new Pair<String,String>(typePattern, id));
	}
	
	/**
	 * @param id
	 */
	public void removeFormalParameterPattern(String id) {
		Iterator<Pair<String,String>> it = 
			this._formalParametersPattern.iterator();
		
		while (it.hasNext()) {
			Pair<String,String> paramPair = it.next();
			if (paramPair.second().equals(id)) {
				it.remove();
			}
		}
	}

	/**
	 * @return the formalParametersPattern
	 */
	public List<Pair<String, String>> formalParametersPattern() {
		return _formalParametersPattern;
	}

	
	/**
	 * Convert Wildcards to Regular Expression. Shamelessly stolen from the
	 * web and possibly adjusted. (RŽal Gagnon)
	 * @param wildcard	the wildcard pattern to convert
	 * @return	the resulting regexp
	 */
	private String wildcardToRegex(String wildcard) {
		StringBuffer s = new StringBuffer(wildcard.length());
		s.append('^');
		for (int i = 0, is = wildcard.length(); i < is; i++) {
			char c = wildcard.charAt(i);
			switch (c) {
			case '*':
				s.append(".*");
				break;
			case '?':
				s.append(".");
				break;
			// escape special regexp-characters
			case '(':
			case ')':
			case '[':
			case ']':
			case '$':
			case '^':
			case '.':
			case '{':
			case '}':
			case '|':
			case '\\':
				s.append("\\");
				s.append(c);
				break;
			default:
				s.append(c);
				break;
			}
		}
		s.append('$');
		return (s.toString());
	}	
	
	/**
	 * @return a List of references to Services
	 * @throws LookupException
	 */
	@SuppressWarnings("unchecked")
	public List<SimpleReference<Service>> services() throws LookupException {

		List<SimpleReference<Service>> result =
				new ArrayList<SimpleReference<Service>>();

		try {
			getNamespace().descendants(Service.class,
					new UnsafePredicate<Service, LookupException>() {

						@Override
						public boolean eval(Service service)
								throws LookupException {

		boolean evalResult;

	// 1. deal with service signatures
			
		String reSigPattern 
			= wildcardToRegex(signaturePattern());

		String signature = service.signature().name();
		
		evalResult = signature.matches(reSigPattern);
			

	// 2. deal with return type
			
		if (evalResult) {
			
			String reReturnType 
				= wildcardToRegex(returnTypePattern());
			
			String returnTypeName 
				= service.returnType().getType().getName();				

			evalResult &= returnTypeName.matches(reReturnType);
			
		}
			

	// 3. deal with formal parameters
		
		if (evalResult) {

			if (service.formalParameters().size() 
								< formalParametersPattern().size() ) {
				evalResult = false;
			} else {

				for (int i = 0; i < formalParametersPattern().size(); i++) {
					
					Pair<String,String> formalParam 
						= formalParametersPattern().get(i);
					
					String reFormalParamType = wildcardToRegex(formalParam.first());
					
					String formalParamType 
						= service.formalParameters().get(i).getType().getName();
							
					evalResult &= formalParamType.matches(reFormalParamType);
				}
			}
		}
				
		return evalResult;

						}
					});
		} catch (Exception e) {
			throw new LookupException("Exception during Declaration lookup");
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.composition.JoinPoint#cloneThis()
	 */
	@Override
	protected PatternSignature cloneThis() {
		return new PatternSignature();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public PatternSignature clone() {
		final PatternSignature clone = super.clone();

		clone.setReturnTypePattern(returnTypePattern());
		clone.setSignaturePattern(signaturePattern());
		clone.setFormalParametersPattern(formalParametersPattern());
		
		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();

		if (!(this.returnTypePattern() != null)) {
			result =
					result.and(new BasicProblem(this,
							"Signature: returnType patterns is null."));
		}

		if (!(this.signaturePattern() != null)) {
			result =
					result.and(new BasicProblem(this,
							"Signature: signature patterns is null."));
		}
		
		if (!(this.formalParametersPattern() != null)) {
			result =
					result.and(new BasicProblem(this,
							"Signature: returnType patterns is null."));
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.Element#children()
	 */
	public List<Element> children() {
		final List<Element> result = super.children();
		
		// do not add generated stuff
		
		return result;
	}
}

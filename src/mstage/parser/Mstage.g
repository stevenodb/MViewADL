gBasicTypeReferencerammar Mstage;

options {
  backtrack=true; 
  memoize=true;
  output=AST;
  superClass=ChameleonParser;
}

scope TargetScope {
  InvocationTarget target;
  Token start;
}

@parser::header {
package mstage.parser;

import mstage.model.application.AbstractHost;
import mstage.model.application.Application;
import mstage.model.application.Locate;
import mstage.model.composition.Advice;
import mstage.model.composition.AdviceType;
import mstage.model.composition.AOComposition;
import mstage.model.composition.JoinPoint;
import mstage.model.composition.JoinpointKind;
import mstage.model.composition.NamedJoinPoint;
import mstage.model.composition.PatternJoinPoint;
import mstage.model.composition.Pointcut;
import mstage.model.composition.PropertyJoinPoint;
import mstage.model.composition.SingleJoinPoint;
import mstage.model.deployment.Deployment;
import mstage.model.deployment.Host;
import mstage.model.deployment.HostMap;
import mstage.model.module.Component;
import mstage.model.module.Composite;
import mstage.model.module.Connector;
import mstage.model.module.Interface;
import mstage.model.module.JoinPointElement;
import mstage.model.module.Module;
import mstage.model.module.Property;
import mstage.model.module.Service;
import mstage.model.namespace.MStageDeclaration;


import chameleon.core.compilationunit.CompilationUnit;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.declaration.Signature;
import chameleon.core.expression.InvocationTarget;
import chameleon.core.type.TypeReference;
import chameleon.core.type.BasicTypeReference;
import chameleon.core.type.Type;
import chameleon.core.namespace.NamespaceOrTypeReference;
import chameleon.core.namespacepart.NamespacePart;
import chameleon.core.reference.SimpleReference;
import chameleon.core.variable.FormalParameter;

import chameleon.support.input.ChameleonParser;


import mstage.reuse.Mapping;
import mstage.reuse.HostMapper;
}

@lexer::header {
package mstage.parser;
}



// starting point for parsing
compilationUnit returns [CompilationUnit element] 
@init{ 
	NamespacePart npp = null;
	$element = getCompilationUnit();
	npp = new NamespacePart(language().defaultNamespace());
	$element.add(npp);
}
	:	cd=componentDeclaration {npp.add($cd.element);}
	|	id=interfaceDeclaration {npp.add($id.element);}
	;




/* ***********
 * INTERFACE
 *********** */
 
 interfaceDeclaration returns [Interface element]
	:	'interface' name=Identifier {
			$element = new Interface(new SimpleNameSignature($name.text));
			setLocation($element,$name,"__NAME");
		}
		interfaceBody[$element]
	;


interfaceBody[Interface element]
	:	(service=serviceDeclaration';')* {
			$element.addService($service.element);
		}
	;

serviceDeclaration returns [Service element]
	:	rtype=serviceReturnType name=Identifier params=formalParameters {
			Signature signature = new SimpleNameSignature($name.text);
			$element= new Service(signature,$rtype.element,$params.element,null); //TODO: add properties
		}
	;

serviceReturnType returns [TypeReference element]
	:	vt=voidType { $element=$vt.element; }
	|	tp=type { $element=$tp.element; }
	;

formalParameters returns [List<FormalParameter> element]
@init{$element = new ArrayList<FormalParameter>();} // create empty one, in case there are no parameters
    :   '(' (pars=formalParameterDecls {$element=$pars.element;})? ')'
    ;

formalParameterDecls returns [List<FormalParameter> element]
    :   t=type name=Identifier (',' decls=formalParameterDecls { $element=decls.element; })? 
    	{
    		if($element == null) {
         		$element=new ArrayList<FormalParameter>();
         	}
			
			FormalParameter param = 
				new FormalParameter(new SimpleNameSignature($name.text),$t.element);
			
			$element.add(0,param);
         }
	;






/* ***********
 * CONNECTOR
 *********** */

connectorDeclaration returns [Connector element]
	:	'connector' name=Identifier connectorBody[$element] {
			$element = new Connector(new SimpleNameSignature($name.text));
		}
	;


connectorBody[Connector element]
	:	'{'  connectorBodyDeclaration[$element]*  '}'
	;


connectorBodyDeclaration[Connector component]
	:	connectorAOCompositionDeclaration
	|	moduleRequireDependencyDeclaration[$component]
	;	
	

connectorAOCompositionDeclaration returns [AOComposition element]
	:	'ao-composition' name=Identifier aoc=connectorAOCompositionBody {
			$element = new AOComposition(new SimpleNameSignature($name.text));
			
			$element.setAdvice($aoc.advice);
			$element.setPointcut($aoc.pointcut);
		}
	;


connectorAOCompositionBody returns [Pointcut pointcut, Advice advice]
	:	'{' pc=pointcutDeclaration adv=adviceDeclaration '}' {
				$pointcut = $pc.element;
				$advice = $adv.element;
			}
	;

/*
connectorAOCompositionBodyDeclaration
	:	
	;
*/

pointcutDeclaration returns [Pointcut element]
	:	'pointcut' pointcutBody[$element] {
				$element = new Pointcut();
			}
	;
	
	
pointcutBody[Pointcut pointcut]
	:	'{' pointcutBodyDeclaration[$pointcut]* '}'
	;
	
pointcutBodyDeclaration[Pointcut pointcut]
	:	pointcutKindDeclaration[$pointcut]
	|	pointcutSignatureDeclaration[$pointcut]
//	|	pointcutCallerDeclaration[$pointcut] 
//	|	pointcutCalleeDeclaration[$pointcut]
	;
	
pointcutKindDeclaration[Pointcut pointcut]
	:	'kind' ':' kind=joinpointKind ';' {
				$pointcut.setKind($kind.element);
			}
	;
	
pointcutSignatureDeclaration[Pointcut pointcut]
	:	'signature' ':' pattern=(.*) ';' {
				JoinPoint jp = new PatternJoinPoint($pattern.text);
				$pointcut.addJoinPoint(jp);
			}
	;
	
/*	
pointcutServicePattern
	:	rtype=(serviceReturnType|'*')? ctype=(type'.'|'*')? name=(Identifier|'*') params=(formalParameters|'(..)') {
			}
	;
*/	
	
pointcutCallerDeclaration[Pointcut pointcut]
	:	'caller'
	;
	
pointcutCalleeDeclaration[Pointcut pointcut]
	:	'callee'
	;
	
	
adviceDeclaration returns [Advice element]
	:	'advice' adviceBody[$element] {
				$element = new Advice();
			}
	;

adviceBody[Advice advice]
	:	'{' adviceBodyDeclaration[$advice]* '}'
	;
	
adviceBodyDeclaration[Advice advice]
	:	adviceServiceDeclaration[$advice]
	|	adviceTypeDeclaration[$advice]
	;
	
adviceServiceDeclaration[Advice advice]
	:	'service' ':' service=(.*) ';' {
			$advice.setService(new SimpleReference($service.text,Service.class));
		}
	;
	
adviceTypeDeclaration[Advice advice]
	:	'type' ':' advtype=adviceType ';' {
			$advice.setType($advtype.element);
		}
	;

/* ***********
 * COMPOSITE
 *********** */
  
 
compositeDeclaration returns [Composite element]
	:	'composite' name=Identifier {
				$element = new Composite(new SimpleNameSignature($name.text));
			}
	 compositeBody[$element]
	;


compositeBody[Composite element]
	:	'{' (compositeBodyDeclaration[$element] | componentBodyDeclaration[$element])* '}'
	;


compositeBodyDeclaration[Composite element]
	:	'contain' conts=compositeContainBody {
			for(String module : $conts.elements) {
				$element.addSubmodules(new SimpleReference<Module>(module,Module.class));
			}
		}
	;

compositeContainBody returns [List<String> elements]
@init{ $elements = new ArrayList<String>(); }
	:	'{' (decls=commaSeparatedBodyDecls {$elements=$decls.elements;} )? '}'
	;
	





/* ***********
 * COMPONENT
 *********** */
 
 
componentDeclaration returns [Component element]
	:   'component' name=Identifier {
    			$element = new Component(new SimpleNameSignature($name.text)); 
    			setLocation(retval.element,name,"__NAME");
			} componentBody[$element]
	;
    
    
componentBody[Component element]
	: '{' componentBodyDeclaration[$element]* '}'
	;
	
    
componentBodyDeclaration[Component element]
	:	moduleRequireDependencyDeclaration[$element]
	|	moduleProvideDependencyDeclaration[$element]
/*	|	'implementation' */
	;






/* ***********
 * MODULE
 *********** */
 
moduleDependencyBody returns [List<String> elements]
@init{ $elements = new ArrayList<String>(); }
	:	'{' (decls=commaSeparatedBodyDecls {$elements=$decls.elements; } )? '}'
	;
 
 moduleRequireDependencyDeclaration[Module element]
	:	'require' rd=moduleDependencyBody {
			for(String iface : $rd.elements ) {
				$element.addRequiredInterface(new SimpleReference<Interface>(iface, Interface.class));
			}
		 }
	;


 moduleProvideDependencyDeclaration[Module element]
	:	'provide' rd=moduleDependencyBody {
			for(String iface : $rd.elements ) {
				$element.addProvidedInterface(new SimpleReference<Interface>(iface, Interface.class));
			}
		 }
	;


/* ***********
 * MISC
 *********** */
 
commaSeparatedBodyDecls returns [List<String> elements]
	:	id=Identifier (',' decls=commaSeparatedBodyDecls {$elements=$decls.elements;})? {
			
			if ($elements == null) {
				$elements = new ArrayList<String>();
			}
			
			$elements.add(0,$id.text);
		}
	;
	
	
	
/* ***********
 * TYPING, etc.
 *********** */
 
 
adviceType returns [AdviceType element]
	:	'before' {$element = AdviceType.BEFORE;}
	|	'after' {$element = AdviceType.AFTER;}
	|	'around' {$element = AdviceType.AROUND;}
	;
 
joinpointKind returns [JoinpointKind element]
	:	'execution'	{$element = JoinpointKind.EXECUTION;}
	|	'call' {$element = JoinpointKind.CALL;}
	;
 
voidType returns [TypeReference element]
/*@after{setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop, "__PRIMITIVE");}*/
     	:	 'void' {$element=new BasicTypeReference("void");}
     	;


type returns [TypeReference element]
/*@after{setLocation(retval.element, retval.start, retval.stop);}*/
	:	cd=classOrInterfaceType {$element = $cd.element;}
	|	pt=primitiveType {$element = $pt.element;}
	;
	

classOrInterfaceType returns [TypeReference element]
@init{NamespaceOrTypeReference target = null;}
	:	name=Identifier 
	          {
	           retval.element = new BasicTypeReference($name.text); 
	           target =  new NamespaceOrTypeReference($name.text); 
	          } 
	        ('.' namex=Identifier 
	          {
	           if(target != null) {
	             retval.element = new BasicTypeReference(target,$namex.text);
	             // We must clone the target here, or else it will be removed from the
	             // type reference we just created.
	             target = new NamespaceOrTypeReference(target.clone(),$namex.text);
	           } else {
	             retval.element = new BasicTypeReference(retval.element,$namex.text);
	           }
	          } 
	         )*
	;


primitiveType returns [TypeReference element]
    :   'boolean' {retval.element = new BasicTypeReference("boolean");}
    |   'char' {retval.element = new BasicTypeReference("char");}
    |   'byte' {retval.element = new BasicTypeReference("byte");}
    |   'short' {retval.element = new BasicTypeReference("short");}
    |   'int' {retval.element = new BasicTypeReference("int");}
    |   'long' {retval.element = new BasicTypeReference("long");}
    |   'float' {retval.element = new BasicTypeReference("float");}
    |   'double' {retval.element = new BasicTypeReference("double");}
    ;


// ANNOTATIONS

annotations
    :   annotation+
    ;

annotation
    :   '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
    ;
    
annotationName
    : Identifier ('.' Identifier)*
    ;

elementValuePairs
    :   elementValuePair (',' elementValuePair)*
    ;

elementValuePair
    :   Identifier '=' elementValue
    ;
    
elementValue
    :   annotation
    |   elementValueArrayInitializer
    ;
    
elementValueArrayInitializer
    :   '{' (elementValue (',' elementValue)*)? (',')? '}'
    ;
    
annotationTypeDeclaration returns [Type element]
    :   '@' 'interface' name=Identifier annotationTypeBody
    ;
    
annotationTypeBody
    :   '{' (annotationTypeElementDeclaration)* '}'
    ;
    
annotationTypeElementDeclaration
    :   /*modifiers*/ annotationTypeElementRest
    ;
    
annotationTypeElementRest
    :   type annotationMethodOrConstantRest ';'
    |   annotationTypeDeclaration ';'?
    ;
    
annotationMethodOrConstantRest
    :   annotationMethodRest
    ;
    
annotationMethodRest
    :   Identifier '(' ')' defaultValue?
    ;
        
defaultValue
    :   'default' elementValue
    ;
    


// LEXER

HexLiteral : '0' ('x'|'X') HexDigit+ IntegerTypeSuffix? ;

DecimalLiteral : ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;

OctalLiteral : '0' ('0'..'7')+ IntegerTypeSuffix? ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
IntegerTypeSuffix : ('l'|'L') ;

FloatingPointLiteral
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatTypeSuffix?
    |   '.' ('0'..'9')+ Exponent? FloatTypeSuffix?
    |   ('0'..'9')+ Exponent FloatTypeSuffix?
    |   ('0'..'9')+ FloatTypeSuffix
    ;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
FloatTypeSuffix : ('f'|'F'|'d'|'D') ;

CharacterLiteral
    :   '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
    ;

StringLiteral
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UnicodeEscape
    |   OctalEscape
    ;

fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;
    
Identifier 
    :   Letter (Letter|JavaIDDigit)*
    ;

/**I found this char range in JavaCC's grammar, but Letter and Digit overlap.
   Still works, but...
 */
fragment
Letter
    :  '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;

fragment
JavaIDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;



/*@lexer::members {
 
}*/

/*
@parser::members {

  public InvocationTarget cloneTarget(InvocationTarget target) {
    InvocationTarget result = null;
    if(target != null) {
        result = target.clone();
    }
    return result;
  }
}
*/


/*	
componentDependencyBodyDecls returns [List<SimpleReference<Interface>> elements]
	:	iface=Identifier (',' decls=componentDependencyBodyDecls {$elements = $decls.elements; })? {
		
			if ($elements == null) {
				$elements = new ArrayList<SimpleReference<Interface>>();
			}
			
			SimpleReference<Interface> reference =
				new SimpleReference<Interface>($iface.text, Interface.class);
				
			$elements.add(0,reference);
			}
	;
*/

/*componentInterfaceDependencyBody returns [List<String> interfaces]
	:	'{' { 
				$interfaces=new ArrayList<String>(); 
			} iface=Identifier 
				{
					$interfaces.add($iface.text);
				} (',' iface=Identifier 
					{
						$interfaces.add($iface.text);
					})*
		'}'
	;
*/

/*
interfaceDeclaration returns [Interface element]
    :   ifkw='interface' name=Identifier {
    			retval.element = new Interface(new SimpleNameSignature($name.text)); 
                setLocation(retval.element,name,"__NAME");
			} 
    ;
    
classBody returns [ClassBody element]
    :   '{' {retval.element = new ClassBody();} (decl=classBodyDeclaration {retval.element.add(decl.element);})* '}'
    ;
    
interfaceBody returns [ClassBody element]
    :   '{' {retval.element = new ClassBody();} (decl=interfaceBodyDeclaration {retval.element.add(decl.element);})* '}'
    ;

classBodyDeclaration returns [TypeElement element]
@init{
  Token start=null;
  Token stop=null;
}
@after{setLocation(retval.element, (CommonToken)start, (CommonToken)stop);}
    :   sckw=';' {retval.element = new EmptyTypeElement(); start=sckw; stop=sckw;}
    |   stkw='static'? bl=block {retval.element = new StaticInitializer(bl.element); start=stkw;stop=bl.stop;}
    |   mods=modifiers decl=memberDecl {retval.element = decl.element; retval.element.addModifiers(mods.element); start=mods.start; stop=decl.stop;}
    ;
    
memberDecl returns [TypeElement element]
    :   gen=genericMethodOrConstructorDecl {retval.element = gen.element;}
    |   mem=memberDeclaration {retval.element = mem.element;}
    |   vmd=voidMethodDeclaration {retval.element = vmd.element;}
    |   cs=constructorDeclaration {retval.element = cs.element;}
    |   id=interfaceDeclaration {retval.element=id.element; addNonTopLevelObjectInheritance(id.element);}
    |   cd=classDeclaration {retval.element=cd.element; addNonTopLevelObjectInheritance(cd.element);}
    ;
*/

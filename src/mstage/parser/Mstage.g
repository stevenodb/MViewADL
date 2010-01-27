grammar Mstage;

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
import mstage.model.composition.AOComposition;
import mstage.model.composition.JoinPoint;
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

// starting point for parsing
compilationUnit returns [CompilationUnit element] 
@init{ 
NamespacePart npp = null;
retval.element = getCompilationUnit();
npp = new NamespacePart(language().defaultNamespace());
retval.element.add(npp);
}
	:	componentDeclaration
	|	interfaceDeclaration
	;




//interface
interfaceDeclaration returns [Interface element]
	:	'interface' name=Identifier {
			$element = new Interface(new SimpleNameSignature($name.text));
			setLocation($element,$name,"__NAME");
		}
		interfaceBody[$element]
	;


interfaceBody[Interface element]
	:	(service=interfaceServiceDeclaration';')* {
			$element.addService($service.element);
		}
	;

interfaceServiceDeclaration returns [Service element]
	:	rtype=interfaceServiceReturnType name=Identifier params=formalParameters {
			Signature signature = new SimpleNameSignature($name.text);
			$element= new Service(signature,$rtype.element,$params.element,null); //TODO: add properties
		}
	;

interfaceServiceReturnType returns [TypeReference element]
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



// composite
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
	:	'contain'
	;




//component
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
	:	'require' rd=componentDependencyBody {
			for(SimpleReference<Interface> iface : $rd.elements ) {
				$element.addRequiredInterface(iface);
			}
		 }
	|	'provide' pd=componentDependencyBody {
			for(SimpleReference<Interface> iface : $pd.elements ) {
				$element.addProvidedInterface(iface);
			}
		 }
/*	|	'implementation' */
	;

componentDependencyBody returns [List<SimpleReference<Interface>> elements]
@init{ $elements = new ArrayList<SimpleReference<Interface>>(); }
	:	'{' (decls=componentDependencyBodyDecls {$elements=$decls.elements; } )? '}'
	;
	
	
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


voidType returns [TypeReference element]
/*@after{setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop, "__PRIMITIVE");}*/
     	:	 'void' {$element=new TypeReference("void");}
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
	           retval.element = new TypeReference($name.text); 
	           target =  new NamespaceOrTypeReference($name.text); 
	          } 
	        ('.' namex=Identifier 
	          {
	           if(target != null) {
	             retval.element = new TypeReference(target,$namex.text);
	             // We must clone the target here, or else it will be removed from the
	             // type reference we just created.
	             target = new NamespaceOrTypeReference(target.clone(),$namex.text);
	           } else {
	             retval.element = new TypeReference(retval.element,$namex.text);
	           }
	          } 
	         )*
	;


primitiveType returns [TypeReference element]
    :   'boolean' {retval.element = new TypeReference("boolean");}
    |   'char' {retval.element = new TypeReference("char");}
    |   'byte' {retval.element = new TypeReference("byte");}
    |   'short' {retval.element = new TypeReference("short");}
    |   'int' {retval.element = new TypeReference("int");}
    |   'long' {retval.element = new TypeReference("long");}
    |   'float' {retval.element = new TypeReference("float");}
    |   'double' {retval.element = new TypeReference("double");}
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

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
import mstage.model.deployment.PhysicalHost;
import mstage.model.deployment.HostMap;
import mstage.model.module.Component;
import mstage.model.module.Composite;
import mstage.model.module.Connector;
import mstage.model.module.Interface;
import mstage.model.module.JoinPointElement;
import mstage.model.module.Module;
import mstage.model.module.Property;
import mstage.model.module.Service;
import mstage.model.module.ModuleContainer;
import mstage.model.namespace.MStageDeclaration;


import chameleon.core.compilationunit.CompilationUnit;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.declaration.Signature;
import chameleon.core.expression.InvocationTarget;
import chameleon.oo.type.TypeReference;
import chameleon.oo.type.generics.ActualTypeArgument;
import chameleon.oo.type.BasicTypeReference;
import chameleon.oo.type.Type;
import chameleon.core.namespace.NamespaceOrTypeReference;
import chameleon.core.namespacepart.NamespacePart;
import chameleon.core.reference.SimpleReference;
import chameleon.core.variable.FormalParameter;

import chameleon.support.input.ChameleonParser;


import mstage.reuse.HostMapping;
import mstage.reuse.HostMapper;
import mstage.reuse.Host;
}

@lexer::header {
	package mstage.parser;
}



// starting point for parsing
compilationUnit returns [CompilationUnit element] 
@init{ 
	$element = getCompilationUnit();
	NamespacePart npp = new NamespacePart(language().defaultNamespace());
	$element.add(npp);
}
	:	( 
			ifd=interfaceDeclaration {npp.add($ifd.element);}
		|
			cod=componentDeclaration {npp.add($cod.element);} 
		|		
			cmd=compositeDeclaration {npp.add($cmd.element);}
		|
			cnd=connectorDeclaration {npp.add($cnd.element);}
		|
			apd=applicationDeclaration {npp.add($apd.element);}
		|
			dpd=deploymentDeclaration {npp.add($dpd.element);}
		|
			ahd=abstractHostDeclaration {npp.add($ahd.element);}			
		)*
	;




/* ***********
 * INTERFACE
 *********** */


interfaceDeclaration returns [Interface element]
	:	intkw='interface' name=Identifier {
			$element = new Interface(new SimpleNameSignature($name.text));
			setKeyword($element,$intkw);
			setLocation($element,$name,"__NAME");
		}
		interfaceBody[$element]
	;


interfaceBody[Interface element]
	:	'{' interfaceBodyDeclaration[$element]* '}'
	;



interfaceBodyDeclaration[Interface element]
	:	(service=serviceDeclaration';') {
			$element.addService($service.element);
		}
	;




/* ***********
 * SERVICE
 *********** */


serviceDeclaration returns [Service element]
	:	rtype=serviceReturnType name=Identifier params=formalParameters {
			Signature signature = new SimpleNameSignature($name.text);
			$element= new Service(signature,$rtype.value,$params.element,null); //TODO: add properties
		}
	;

serviceReturnType returns [TypeReference value]
	:	( 
			vt=voidType { $value=$vt.value; }
		| 
			tp=type { $value=$tp.value; } 
		)
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
				new FormalParameter(new SimpleNameSignature($name.text),$t.value);
			
			$element.add(0,param);
         }
	;



/* ***********
 * CONNECTOR
 *********** */

connectorDeclaration returns [Connector element]
	:	conkw='connector' name=Identifier {
			$element = new Connector(new SimpleNameSignature($name.text));
			setKeyword($element,$conkw);
			setLocation($element,$name,"__NAME");
		} connectorBody[$element]
	;


connectorBody[Connector element]
	:	'{'  connectorBodyDeclaration[$element]*  '}'
	;


connectorBodyDeclaration[Connector element]
	:	connectorAOCompositionDeclaration[$element]
	|	moduleRequireDependencyDeclaration[$element]
	;	
	

connectorAOCompositionDeclaration[Connector element]
	:	kw='ao-composition' name=Identifier aoc=connectorAOCompositionBody {
			AOComposition composition = new AOComposition(new SimpleNameSignature($name.text));
			setKeyword(composition,$kw);
			setLocation(composition,$name,"__NAME");
			
			composition.setAdvice($aoc.advice);
			composition.setPointcut($aoc.pointcut);
			
			$element.addComposition(composition);
		}
	;


connectorAOCompositionBody returns [Pointcut pointcut, Advice advice]
	:	'{' pc=pointcutDeclaration {
				$pointcut = $pc.pointcut;
			} adv=adviceDeclaration '}' {
				$advice = $adv.advice;
			}
	;

pointcutDeclaration returns [Pointcut pointcut]
	:	'pointcut' {
				$pointcut = new Pointcut();
			} pointcutBody[$pointcut]
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
				$pointcut.setKind($kind.value);
			}
	;
	
pointcutSignatureDeclaration[Pointcut pointcut]
	:	'signature' ':' pattern=(.*) ';' {
				JoinPoint jp = new PatternJoinPoint($pattern.text);
				System.out.println($pattern.text);
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
	
	
adviceDeclaration returns [Advice advice]
	:	'advice' { 
				$advice = new Advice(); 
				System.out.println("construct advice "+$advice);				
			} adviceBody[$advice]
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
			$advice.setType($advtype.value);
		}
	;


/* ***********
 * COMPONENT
 *********** */
 
 
componentDeclaration returns [Component element]
	:  compkw='component' name=Identifier {
    			$element = new Component(new SimpleNameSignature($name.text)); 
    			setKeyword($element,$compkw);
    			setLocation($element,$name,"__NAME");
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
 
moduleDependencyBody returns [List<SimpleReference> elements]
@init{ $elements = new ArrayList<SimpleReference>(); }
	:	'{' (decls=commaSeparatedBodyDecls[Interface.class] {$elements=$decls.elements; } )? '}'
	;
 
 
moduleRequireDependencyDeclaration[Module element]
	:	'require' rd=moduleDependencyBody {
			for(SimpleReference iface : $rd.elements ) {
				$element.addRequiredInterface(iface);
			}
		 }
	;


moduleProvideDependencyDeclaration[Module element]
	:	'provide' rd=moduleDependencyBody {
			for(SimpleReference iface : $rd.elements ) {		
				$element.addProvidedInterface(iface);
			}
		 }
	;




/* ***********
 * COMPOSITE
 *********** */
  
 
compositeDeclaration returns [Composite element]
	:	cmkw='composite' name=Identifier {
				$element = new Composite(new SimpleNameSignature($name.text));
    			setKeyword($element,$cmkw);
    			setLocation($element,$name,"__NAME");
			}
	 compositeBody[$element]
	;


compositeBody[Composite element]
	:	'{' (compositeBodyDeclaration[$element] | componentBodyDeclaration[$element])* '}'
	;


compositeBodyDeclaration[Composite element]
	: modulecontainerDeclaration[$element]
	;



/* ***********
 * APPLICATION
 *********** */


applicationDeclaration returns [Application element]
	: appkw='application' name=Identifier { 
			$element = new Application(new SimpleNameSignature($name.text));
			setKeyword($element,$appkw);
   			setLocation($element,$name,"__NAME");
		} applicationBody[$element]
	;

applicationBody[Application element]
	: '{' applicationBodyDeclaration[$element]* '}'
	;


applicationBodyDeclaration[Application element]
	: modulecontainerDeclaration[$element]
	| locateDeclaration[$element]
	;
	
	
locateDeclaration[Application element]
	: mappingDeclaration[$element, Module.class, AbstractHost.class]
	;




/* ***********
 * DEPLOYMENT
 *********** */


deploymentDeclaration returns [Deployment element]
	: depkw='deployment' name=Identifier { 
			$element = new Deployment(new SimpleNameSignature($name.text)); 
			setKeyword($element,$depkw);
   			setLocation($element,$name,"__NAME");
		} deploymentBody[$element]
	;

deploymentBody[Deployment element]
	: '{' deploymentBodyDeclaration[$element]* '}'
	;


deploymentBodyDeclaration[Deployment element]
	: appcontainDeclaration[$element]
	| hostMapDeclaration[$element]
	;
	
	
appcontainDeclaration[Deployment element]
	:	ctkw='contain' conts=appcontainBody {

			for(SimpleReference<Application> app : $conts.elements) {
				$element.addApplication(app);
			}
		}
	;
	

appcontainBody returns [List<SimpleReference> elements]
@init{ $elements = new ArrayList<SimpleReference>(); }
	:	'{' (decls=commaSeparatedBodyDecls[Application.class] {$elements=$decls.elements;} )? '}'
	;

	
hostMapDeclaration[Deployment element]
	: mappingDeclaration[$element, AbstractHost.class, PhysicalHost.class]
	;


/* **********
 * HOST
 ********** */


abstractHostDeclaration returns [AbstractHost element]
	: ahkw='abstracthost' name=Identifier {
			$element = new AbstractHost(new SimpleNameSignature($name.text));
	    	setKeyword($element,$ahkw);
    		setLocation($element,$name,"__NAME");
		} abstractHostBody[$element]
	;
	
	
abstractHostBody[AbstractHost element]
	: '{' abstractHostBodyDeclaration[$element]* '}'
	;


abstractHostBodyDeclaration[AbstractHost element]
	: 'none'
	;


/* **********
 * HOSTMAPPER
 ********** */

mappingDeclaration[HostMapper element, Class<? extends MStageDeclaration> fromType, Class<? extends Host> toType]
	: mapkw=('map'|'locate') name=Identifier rfroms=mappingDeclarationBody[fromType] {

			HostMapping mapping = $element.createEmptyMapping();

			SimpleReference<? extends Host> to = 
				new SimpleReference($name.text,$toType);
				
			setLocation(to,$name,$name);
			setKeyword(to,$mapkw);					

			// add host reference to host list
			$element.addHost(to);
			
			// set host to mapping target
			mapping.setTo(to);

	        for(SimpleReference<Module> from : $rfroms.elements) { 	
				mapping.addFrom(from);
			}
			
			// add hostmapping
			$element.addHostMapping(mapping);
		} 
		
	;

mappingDeclarationBody[Class<? extends MStageDeclaration> fromType] returns [List<SimpleReference> elements]
	: '{' ( decls = commaSeparatedBodyDecls[fromType] { $elements = $decls.elements; } )? '}'
	;
	


/* ***********
 * MODULECONTAINER
 *********** */

modulecontainerDeclaration[ModuleContainer element]
	:	ctkw='contain' conts=modulecontainerBody {

			for(SimpleReference<Module<?>> module : $conts.elements) {
				$element.addModule(module);
			}
		}
	;

modulecontainerBody returns [List<SimpleReference> elements]
@init{ $elements = new ArrayList<SimpleReference>(); }
	:	'{' (decls=commaSeparatedBodyDecls[Module.class] {$elements=$decls.elements;} )? '}'
	;



/* ***********
 * MISC
 *********** */
 
commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements]
@init{ $elements = new ArrayList<SimpleReference>(); }
	:	id=Identifier (',' decls=commaSeparatedBodyDecls[$targetType] {$elements=$decls.elements;})? {
			
			SimpleReference<Interface> relation = new SimpleReference($id.text, $targetType);
			$elements.add(0,relation);
			setLocation(relation, id, id);
		}
	;
	

	
/* ***********
 * TYPING, etc.
 *********** */
 
 
adviceType returns [AdviceType value]
	:	'before' {$value = AdviceType.BEFORE;}
	|	'after' {$value = AdviceType.AFTER;}
	|	'around' {$value = AdviceType.AROUND;}
	;
 
joinpointKind returns [JoinpointKind value]
	:	'execution'	{$value = JoinpointKind.EXECUTION;}
	|	'call' {$value = JoinpointKind.CALL;}
	;
 
voidType returns [TypeReference value]
/*@after{setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop, "__PRIMITIVE");}*/
     	:	 'void' {$value=new BasicTypeReference("void");}
     	;


type returns [TypeReference value]
/*@after{setLocation(retval.element, retval.start, retval.stop);}*/
	:	cd=classOrInterfaceType {$value = $cd.element;}
	|	pt=primitiveType {$value = $pt.value;}
	;
	

classOrInterfaceType returns [TypeReference element]
@init{NamespaceOrTypeReference target = null;}
	:	name=Identifier 
	          {
	           $element = new BasicTypeReference($name.text); 
	           target =  new NamespaceOrTypeReference($name.text); 
	          }
			typeArguments? 
	        ('.' namex=Identifier 
	          {
	           if(target != null) {
	             $element = new BasicTypeReference(target,$namex.text);
	             // We must clone the target here, or else it will be removed from the
	             // type reference we just created.
	             target = new NamespaceOrTypeReference(target.clone(),$namex.text);
	           } else {
	             $element = new BasicTypeReference($element,$namex.text);
	           }
	          } 
	         typeArguments? )*
	;


primitiveType returns [TypeReference value]
    :   'boolean' {$value = new BasicTypeReference("boolean");}
    |   'char' {$value = new BasicTypeReference("char");}
    |   'byte' {$value = new BasicTypeReference("byte");}
    |   'short' {$value = new BasicTypeReference("short");}
    |   'int' {$value = new BasicTypeReference("int");}
    |   'long' {$value = new BasicTypeReference("long");}
    |   'float' {$value = new BasicTypeReference("float");}
    |   'double' {$value = new BasicTypeReference("double");}
    ;

// GENERICS

typeArguments
    :   '<' typeArgument ( ',' typeArgument )* '>'
    ;
    
typeArgument
    :   t=type |   '?'  ( ('extends' | 'super') t=type )?
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


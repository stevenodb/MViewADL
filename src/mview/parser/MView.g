grammar MView;

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
package mview.parser;

import exception.MergeNotSupportedException;
import mview.model.application.Application;
import mview.model.application.Host;
import mview.model.application.Instance;

import mview.model.composition.Actor;
import mview.model.composition.ActorProp;
import mview.model.composition.Advice;
import mview.model.composition.AOComposition;
import mview.model.composition.modifier.After;
import mview.model.composition.modifier.Around;
import mview.model.composition.modifier.Before;
import mview.model.composition.modifier.Call;
import mview.model.composition.modifier.Execution;
import mview.model.composition.modifier.PropModifier;
import mview.model.composition.PatternSignature;
import mview.model.composition.Pointcut;
import mview.model.composition.PointcutSignature;
import mview.model.composition.ServiceSignature;

import mview.model.deployment.Deployment;
import mview.model.deployment.HostName;

import mview.model.language.MView;
import mview.model.language.MViewLookupFactory;

import mview.model.module.Component;
//import mview.model.module.Composite;
import mview.model.module.Connector;
import mview.model.module.Interface;
import mview.model.module.JoinPointElement;
import mview.model.module.Module;
import mview.model.module.ModuleContainer;
import mview.model.module.Property;
import mview.model.module.Service;

import mview.model.namespace.MViewDeclaration;

import mview.model.refinement.AbstractElement;
import mview.model.refinement.modifier.Overridable;
import mview.model.refinement.modifier.Extendable;
import mview.model.refinement.MViewMember;
import mview.model.refinement.MViewMemberDeclarationImpl;
import mview.model.refinement.RefinableDeclaration;
import mview.model.refinement.RefinableDeclarationImpl;
import mview.model.refinement.RefinableMemberDeclarationImpl;
import mview.model.refinement.RefinementContext;
import mview.model.refinement.RefinementRelation;


import chameleon.core.compilationunit.CompilationUnit;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.declaration.Signature;
import chameleon.core.declaration.Declaration;
//import chameleon.core.method.MethodSignature;
import chameleon.core.expression.InvocationTarget;
import chameleon.oo.type.TypeReference;
import chameleon.oo.type.generics.ActualTypeArgument;
import chameleon.oo.type.BasicTypeReference;
import chameleon.oo.type.Type;
import chameleon.core.namespace.NamespaceOrTypeReference;
import chameleon.core.namespacepart.NamespacePart;
import chameleon.core.reference.SimpleReference;
import chameleon.core.variable.FormalParameter;
import chameleon.core.modifier.Modifier;
import chameleon.util.Pair;

import chameleon.support.input.ChameleonParser;
}

@lexer::header {
	package mview.parser;
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
//		|		
//			cmd=compositeDeclaration {npp.add($cmd.element);}
		|
			cnd=connectorDeclaration {npp.add($cnd.element);}
		|
			apd=applicationDeclaration {npp.add($apd.element);}
		|
			dpd=deploymentDeclaration {npp.add($dpd.element);}
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
	:	(service=serviceDeclaration ';') {
			$element.addService($service.element);
		}
	;



/* ***********
 * SERVICE -- REFERENCE 
 *********** */


serviceReferenceDeclaration returns [SimpleReference<Service> relation]
	:	name=Identifier params=actualParameters {
			String signature = $name.text;
			$relation = new SimpleReference<Service>(signature, Service.class);
			setLocation($relation,$name,$name);
		}
	;

actualParameters returns [List<String> lst]
@init{$lst = new ArrayList<String>();} // create empty one, in case there are no parameters
    :   '(' (pars=actualParameterDecls {$lst=$pars.lst;})? ')'
    ;

actualParameterDecls returns [List<String> lst]
    :   name=Identifier (',' decls=actualParameterDecls { $lst=decls.lst; })?
    	{
    		if($lst == null) {
         		$lst=new ArrayList<String>();
         	}
					
			$lst.add(0,$name.text);
         }
	;


/* ***********
 * SERVICE
 *********** */


serviceDeclaration returns [Service element]
	: result=serviceHeaderDeclaration {
			Signature signature = new SimpleNameSignature($result.signature);
			$element= new Service(signature,$result.returnType,$result.parLst); //TODO: add properties
		}
	;


serviceHeaderDeclaration returns [String signature, TypeReference returnType, List<FormalParameter> parLst]
	:	rtype=serviceReturnType name=Identifier params=formalParameters {
			$signature = $name.text;
			$returnType = $rtype.value;
			$parLst = $params.lst;
		}
	;

serviceReturnType returns [TypeReference value]
	:	( 
			vt=voidType { $value=$vt.value; }
		| 
			tp=type { $value=$tp.value; }
		)
	;

formalParameters returns [List<FormalParameter> lst]
@init{$lst = new ArrayList<FormalParameter>();} // create empty one, in case there are no parameters
    :   '(' (pars=formalParameterDecls {$lst=$pars.lst;})? ')'
    ;

formalParameterDecls returns [List<FormalParameter> lst]
    :   t=type name=Identifier (',' decls=formalParameterDecls { $lst=decls.lst; })?
    	{
    		if($lst == null) {
         		$lst=new ArrayList<FormalParameter>();
         	}
			
			FormalParameter param = 
				new FormalParameter(
					new SimpleNameSignature($name.text),$t.value);
			
			$lst.add(0,param);
         }
	;




/* *******************
 * POINTCUT SIGNATURE
 ********************* */

pointcutServiceSignatureDecl returns [ServiceSignature element]
	:	rtype=Identifier sig=Identifier pars=pointcutServiceSignatureParameters {
			$element = new PatternSignature($rtype.text,$sig.text,$pars.lst);
		}
	;

pointcutServiceSignatureParameters returns [List<Pair<String,String>> lst]
@init{$lst = new ArrayList<Pair<String,String>>();}
	: '(' (pointcutServiceSignatureParameterDecls[$lst] )? ')'
	;

pointcutServiceSignatureParameterDecls[List<Pair<String,String>> lst]
	: t=Identifier name=Identifier (',' pointcutServiceSignatureParameterDecls[$lst])?
	 {
	 	Pair pair = new Pair($t.text,$name.text);
	 	$lst.add(0,pair);
	 }
	;


//joinPointDeclaration returns [PointcutSignature element]
//	:	rtype=jointPointReturnType
//		(name=Identifier) 
//		params=formalJoinPointParameters {
//			Signature signature = new SimpleNameSignature($name.text);
//			Service service = new Service(signature,$rtype.value,$params.element,null);
//			$element = new NamedJoinPoint(service);
//		}
//	;


//jointPointReturnType returns [TypeReference value]
//	:	(
//			rt=serviceReturnType { $value = $rt.value; }
//		|
//			wt=wildcardType { $value = wt.value; }
//		)
//	;
	

//formalJoinPointParameters returns [List<FormalParameter> element]
//@init{$element = new ArrayList<FormalParameter>();}
//    :   '(' (pars=formalJoinPointParameterDecls {$element=$pars.element;})? ')'
//    ;
    

//formalJoinPointParameterDecls returns [List<FormalParameter> element]
//    :   t=type name=Identifier (',' decls=formalJoinPointParameterDecls { $element=decls.element; })? 
//    	{
//    		if($element == null) {
//         		$element=new ArrayList<FormalParameter>();
//         	}
//			
//			FormalParameter param = 
//				new FormalParameter(
//					new SimpleNameSignature($name.text),$t.value);
//			
//			$element.add(0,param);
//         }
//	|
//		'..' {
//			System.err.println("TODO: implement '..' ");
//		}
//	;



/* ***********
 * CONNECTOR
 *********** */

connectorDeclaration returns [Connector element]
	:	conkw='connector' name=Identifier {
			$element = new Connector(new SimpleNameSignature($name.text));
			setKeyword($element,$conkw);
			setLocation($element,$name,"__NAME");
		} 
		refinementDeclaration[$element,Connector.class]
		connectorBody[$element]
	;


connectorBody[Connector element]
	:	'{' connectorBodyDeclaration[$element]* '}'
	;


connectorBodyDeclaration[Connector element]
	:	aoc=connectorAOCompositionDeclaration {
			$element.addComposition($aoc.element);
		}
	|	moduleRequireDependencyDeclaration[$element]
	;	
	

connectorAOCompositionDeclaration returns [AOComposition element]
	:	kw='ao-composition' name=Identifier  {
			$element = new AOComposition(new SimpleNameSignature($name.text));
			setKeyword($element,$kw);
			setLocation($element,$name,"__NAME");
		}
		refinementDeclaration[$element,AOComposition.class] 
		connectorAOCompositionBody[$element]
	;


connectorAOCompositionBody[AOComposition element]
	:	'{' 
		pc=pointcutDeclaration? {	
			$element.setPointcut($pc.pointcut);
		}
		adv=adviceDeclaration? {
			$element.setAdvice($adv.advice);
		}
		'}'
	;

pointcutDeclaration returns [Pointcut pointcut]
	:	pckw='pointcut' {
				$pointcut = new Pointcut();
				setKeyword($pointcut,$pckw);
			} pointcutBody[$pointcut]
	;
	
	
pointcutBody[Pointcut pointcut]
	:	'{' pointcutBodyDeclaration[$pointcut]* '}'
	;
	

pointcutBodyDeclaration[Pointcut pointcut]
	:	pointcutKindDeclaration[$pointcut]
	|	pointcutSignatureDeclaration[$pointcut]
	|	pointcutActorDeclaration[$pointcut]
	;

	
pointcutKindDeclaration[Pointcut pointcut]
	:	kikw='kind' ':' kind=joinPointKind ';' {
			$pointcut.addModifier($kind.value);
			setKeyword($kind.value,$kikw);
		}
	;

	
pointcutSignatureDeclaration[Pointcut element]
	:	(override=overrideOrExtend)? sikw='signature' ':' ps=pointcutSignatureBody {
			PointcutSignature pcsig = $ps.element;
			Modifier ovr = $override.value;
			if (ovr != null) {
				pcsig.addModifier(ovr);
			}
			$element.setSignature(pcsig);
			setKeyword(pcsig,$sikw);
		} ';' ;


pointcutSignatureBody returns [PointcutSignature element]
@init{ $element = new PointcutSignature(); }
	:	pointcutSignatureBodyDecls[$element]
	;

	
pointcutSignatureBodyDecls[PointcutSignature element]
	:	pss=pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? {
			$element.addSignature($pss.element);
		}
	;

	
pointcutActorDeclaration[Pointcut pointcut]
	:	clkw='caller' actor=pointcutActorBody {
   			setKeyword($actor.element,$clkw);
			$pointcut.setCaller($actor.element);
		}
	|
		clkw='callee' actor=pointcutActorBody {
   			setKeyword($actor.element,$clkw);
			$pointcut.setCallee($actor.element);
		}
	;
	
//pointcutCalleeDeclaration[Pointcut pointcut]
//	:	'callee'
//	;

pointcutActorBody returns [Actor element]
@init {
	$element = new Actor();
}
	: '{' pointcutActorBodyDecls[$element]* '}'
	;
	

pointcutActorBodyDecls[Actor actor]
@init{
	ActorProp prop = null;
	Class<? extends MViewDeclaration> declClass = null;
}
	: (override=overrideOrExtend)?
	(
		'interface' ':' {
			declClass = Interface.class;
		}
	|	
		'component' ':' {
			declClass = Component.class;
		}
	|
		'application' ':' {
			declClass = Application.class;
		}
	|
		'instance' ':' {
			declClass = Instance.class;
		}
	|
		'host' ':' {
			declClass = Host.class;
		} 
	) {
		prop = new ActorProp(new PropModifier(declClass));
		actor.addProp(prop);
		if ($override.value != null) {
			prop.addModifier($override.value);
		}
	} pointcutActorPropDecls[prop,declClass] ';'
	;


pointcutActorPropDecls[ActorProp prop,Class<? extends Declaration> declClass]
	: 	apdref=pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? {
			$prop.addPropValue($apdref.relation);
		}
	;

pointcutActorPropDecl[Class<? extends Declaration> declClass] returns [SimpleReference<? extends Declaration> relation]
	: 	name=Identifier {
			$relation = new SimpleReference($name.text,$declClass);
			setLocation($relation, $name, $name);
		}
	;

	
	
adviceDeclaration returns [Advice advice]
	:	avkw='advice' { 
			$advice = new Advice();
			setKeyword($advice,$avkw);
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
	:	svkw='service' ':' service=serviceReferenceDeclaration ';' {
			$advice.setService($service.relation);
			setKeyword($service.relation,$svkw);
		}
	;
	
adviceTypeDeclaration[Advice advice]
	:	tpkw='type' ':' avtype=adviceType ';' {
			$advice.addModifier($avtype.value);
			setKeyword($avtype.value,$tpkw);
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
	:	rekw='require' rd=moduleDependencyBody {
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
  
/* 
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

*/

/* ***********
 * APPLICATION
 *********** */

applicationDeclaration returns [Application element]
	:	appkw='application' name=Identifier {
			$element = new Application(new SimpleNameSignature($name.text));
			setKeyword($element,$appkw);
   			setLocation($element,$name,"__NAME");
		} 
		refinementDeclaration[$element,Application.class]
		applicationBody[$element]
	;


applicationBody[Application element]
	: '{' ( applicationBodyDeclaration[$element] )* '}'
	;
	

applicationBodyDeclaration[Application element]
	:	mod=moduleContainerDeclarations {
			$element.addModule(mod.element);
		}
	|
		hod=hostDeclaration {
			$element.addHost(hod.element);
		}
	|	
		ind=instanceDeclaration {
			$element.addInstance(ind.element); 
		}
	;
	
	
/* ***********
 * DEPLOYMENT
 *********** */

deploymentDeclaration returns [Deployment element]
	:	appkw='deployment' name=Identifier {
			$element = new Deployment(new SimpleNameSignature($name.text));
			setKeyword($element,$appkw);
   			setLocation($element,$name,"__NAME");
		} 
		refinementDeclaration[$element,Application.class]
		applicationBody[$element]
	;

/*

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

*/

/* ********************
 * INSTANCE DECLARATION
 ********************* */


instanceDeclaration returns [Instance element]
	:	tpe=Identifier name=Identifier onkw='on' hst=Identifier ';' {
	
			$element = new Instance(new SimpleNameSignature($name.text));

			SimpleReference<Module> modRelation = new SimpleReference<Module>($tpe.text,Module.class);
			if (modRelation != null) {
				$element.setType(modRelation);
				setLocation(modRelation,$tpe,$tpe);
			}
			
			SimpleReference<Host> hostRelation = new SimpleReference<Host>($hst.text,Host.class);
			if (hostRelation != null) {
				$element.setHost(hostRelation);
				setLocation(hostRelation,$hst,$hst);
				setKeyword(hostRelation,$onkw);
			}
		}
	;


/* ****************
 * HOST DECLARATION
 ***************** */
 
 
hostDeclaration returns [Host element]
	: 	hkw='host' name=Identifier {
			
			$element = new Host(new SimpleNameSignature($name.text));
			setKeyword($element,$hkw);
			setLocation($element,$name,"__NAME");
			
		} ( onkw='on' value=StringLiteral {
			
			HostName hostName = new HostName(new SimpleNameSignature($value.text));
			SimpleReference<HostName> hostNameRelation = new SimpleReference<HostName>($value.text,HostName.class);
			$element.setHostName(hostNameRelation);
			setKeyword(hostNameRelation,$onkw);
			
		} )? ';'
	;
 


/* ***************
 * MODULECONTAINER
 *************** */

moduleContainerDeclarations returns [Module element]
	:	
		cod=componentDeclaration {
			$element = $cod.element;
		}
	|
		cnd=connectorDeclaration {
			$element = $cnd.element;
		}
	;
	
/*
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
*/


/* ***********
 * REFINEMENT
 *********** */

refinementDeclaration[RefinableDeclaration element, Class kind]
	:	(rfkw=':' refinementRelationDeclarations[$element,$kind] {
			setKeyword($element,$rfkw);
		})?
	;

refinementRelationDeclarations[RefinableDeclaration element, Class kind]
	:	name=Identifier ( ',' refinementRelationDeclarations[$element,$kind] )? {
			SimpleReference parentRef = new SimpleReference($name.text,$kind);
			RefinementRelation relation = new RefinementRelation(parentRef);
			$element.addRefinementRelation(relation);
			setLocation(parentRef,$name,$name);
		}
	;


/* ***********
 * MISC
 *********** */
 
commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements]
@init{ $elements = new ArrayList<SimpleReference>(); }
	:	id=Identifier (',' decls=commaSeparatedBodyDecls[$targetType] {$elements=$decls.elements;})? {
			
			SimpleReference<Interface> relation = new SimpleReference($id.text, $targetType);
			$elements.add(0,relation);
			setLocation(relation, $id, $id);
		}
	;
	

	
/* ***********
 * TYPING, etc.
 *********** */
 
 
adviceType returns [Modifier value]
	:	'before' {$value = new Before();}
	|	'after' {$value = new After();}
	|	'around' {$value = new Around();}
	;
 
joinPointKind returns [Modifier value]
	:	'execution'	{$value = new Execution();}
	|	'call' {$value = new Call();}
	;
 
overrideOrExtend returns [Modifier value]
	:	okw='override' {$value = new Overridable(); setKeyword($value,$okw); }
	|	ekw='extend' {$value = new Extendable(); setKeyword($value,$ekw); }
	;

voidType returns [TypeReference value]
/*@after{setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop, "__PRIMITIVE");}*/
    : 'void' {$value=new BasicTypeReference("void");}
    ;


wildcardType returns [TypeReference value]
	: '*' { $value = new BasicTypeReference("wildcard"); }
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
//    :   Letter (Letter|JavaIDDigit)*
    :   Letter (Letter|JavaIDDigit|'*')*
    ;
    
//WildCardIdentifier 
//    :   Letter (Letter|JavaIDDigit|'..'|'*')*
//    ;


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


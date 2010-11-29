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
//		|
//			mid=moduleInstanceDeclaration {npp.add($mid.element);}
//		|
//			apd=applicationDeclaration {
//				npp.add($apd.element);
//				for(Host host : $apd.hosts) {
//					if (host != null) npp.add(host);
//				}
//			}
//		|
//			dpd=deploymentDeclaration {npp.add($dpd.element);}
///		|
	//		ahd=abstractHostDeclaration {npp.add($ahd.element);}
	//	|	
	//		phd=physicalHostDeclaration {npp.add($phd.element);}
		)*
	;



/* ***********
 * MODULE INSTANCE
 *********** */

//moduleInstanceDeclaration returns [Instance element]
//	: 	'componentinstance'
//		|
//		'connectorinstance'
//	;


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
			$relation = new SimpleReference(signature, Service.class);
			
			setLocation($relation,$name,$name);
			
			System.err.print(signature + " parameters: ");
			for(String arg : $params.lst) { System.err.print(arg+" "); }
			System.err.println();
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
	: t=Identifier name=Identifier (',' pointcutServiceSignatureParameterDecls[lst])?
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
		} connectorBody[$element]
	;


connectorBody[Connector element]
	:	'{' connectorBodyDeclaration[$element]* '}'
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
			
			System.err.println($aoc.advice);
			System.err.println($aoc.pointcut);
			composition.setAdvice($aoc.advice);
			composition.setPointcut($aoc.pointcut);
			
			$element.addComposition(composition);
		}
	;


connectorAOCompositionBody returns [Pointcut pointcut, Advice advice]
	:	'{' 
		pc=pointcutDeclaration {
				$pointcut = $pc.pointcut;
			} 
		adv=adviceDeclaration {
				$advice = $adv.advice;
			}
		'}'
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
	|	pointcutActorDeclaration[$pointcut]
	;
	
pointcutKindDeclaration[Pointcut pointcut]
	:	'kind' ':' kind=joinPointKind ';' {
				$pointcut.addModifier($kind.value);
			}
	;
	
pointcutSignatureDeclaration[Pointcut pointcut]
	@init{
		PointcutSignature ps = new PointcutSignature();
		pointcut.setSignature(ps);
	}
	:	(override=overrideOrMerge)? {
			ps.addModifier($override.value);
		} 'signature' ':' pointcutSignatureBodyDecls[ps] ';' ;

//pointcutSignatureBody returns [PointcutSignature element]
//@init{$element = new PointcutSignature();}
//	:	pointcutSignatureBodyDecls[$element]
//	;
	
pointcutSignatureBodyDecls[PointcutSignature element]
	:	pss=pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? {
			$element.addSignature($pss.element);
		}
	;

	
pointcutActorDeclaration[Pointcut pointcut]
	:	'caller' actor=pointcutActorBody {
			$pointcut.setCaller($actor.element);
		}
	|
		'callee' actor=pointcutActorBody {
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
	: (override=overrideOrMerge)?
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
		prop.addModifier($override.value);
		actor.addProp(prop);
	} pointcutActorPropDecls[prop,declClass]
	;


pointcutActorPropDecls[ActorProp prop,Class<? extends MViewDeclaration> declClass]
	: 	apdref=pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? {
			$prop.addPropValue($apdref.relation);
		}
	;

pointcutActorPropDecl[Class<? extends MViewDeclaration> declClass] returns [SimpleReference<? extends MViewDeclaration> relation]
	: 	name=Identifier {
			$relation = new SimpleReference($name.text,$declClass);
		}
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
	:	'service' ':' service=serviceReferenceDeclaration ';' {
			$advice.setService($service.relation);
		}
	;
	
adviceTypeDeclaration[Advice advice]
	:	'type' ':' advMod=adviceType ';' {
			$advice.addModifier($advMod.value);
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

/*

applicationDeclaration returns [Application element, List<Host> hosts]
	: appkw='application' name=Identifier { 
			$element = new Application(new SimpleNameSignature($name.text));
			setKeyword($element,$appkw);
   			setLocation($element,$name,"__NAME");
		} ret=applicationBody[$element] { $hosts = $ret.hosts; }
	;

applicationBody[Application element] returns [List<Host> hosts]
@init { $hosts = new ArrayList<Host>(); }
	: '{' (ret=applicationBodyDeclaration[$element]{ $hosts.add($ret.host); })*  '}'
	;


applicationBodyDeclaration[Application element] returns [Host host]
	: modulecontainerDeclaration[$element]
	| locateDeclaration[$element]
//	| ahd=abstractHostDeclaration { $host = $ahd.element; }
	;
	
	
locateDeclaration[Application element]
	: mappingDeclaration[$element, Module.class, AbstractHost.class]
	;

*/


/* ***********
 * DEPLOYMENT
 *********** */

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
	:	tpe=Identifier name=Identifier onkw='on' host=Identifier {
			$element = new Instance(new SimpleNameSignature($name.text));
			$element.setType(new SimpleReference<Module>($tpe.text,Module.class));
			$element.setHost(new SimpleReference<Host>($host.text,Host.class));
		}
	;

/* ****************
 * HOST DECLARATION
 ***************** */
 
 
hostDeclaration returns [Host element]
	: 	hkw='host' name=Identifier {
			$element = new Host(new SimpleNameSignature($name.text));
		} onkw='on' value=StringLiteral {
			HostName hostName = new HostName(new SimpleNameSignature($value.text));
			$element.setHostName(new SimpleReference<HostName>($value.text,HostName.class));
		}
	;
 

/* **********
 * ABSTRACTHOST
 ********** */

/*
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

*/

/* **********
 * PHYSICALHOST
 ********** */

/*

physicalHostDeclaration returns [PhysicalHost element]
	: phkw='host' name=Identifier {
			$element = new PhysicalHost(new SimpleNameSignature($name.text));
	    	setKeyword($element,$phkw);
    		setLocation($element,$name,"__NAME");	
		} physicalHostBody[$element]
	;

physicalHostBody[PhysicalHost element]
	: '{' physicalHostBodyDeclaration[$element]* '}'
	;

physicalHostBodyDeclaration[PhysicalHost element]
	: 'none'
	;

*/

/* **********
 * HOSTMAPPER
 ********** */

/*
mappingDeclaration[HostMapper element, Class<? extends MViewDeclaration> fromType, Class<? extends Host> toType]
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

mappingDeclarationBody[Class<? extends MViewDeclaration> fromType] returns [List<SimpleReference> elements]
	: '{' ( decls = commaSeparatedBodyDecls[fromType] { $elements = $decls.elements; } )? '}'
	;

*/


/* ***********
 * MODULECONTAINER
 *********** */

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
 
 
adviceType returns [Modifier value]
	:	'before' {$value = new Before();}
	|	'after' {$value = new After();}
	|	'around' {$value = new Around();}
	;
 
joinPointKind returns [Modifier value]
	:	'execution'	{$value = new Execution();}
	|	'call' {$value = new Call();}
	;
 
overrideOrMerge returns [Modifier value]
	:	'override' {$value = new Overridable();}
	|	'extend' {$value = null;}
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


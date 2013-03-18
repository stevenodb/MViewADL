grammar MView;

options {
  backtrack=true; 
  memoize=true;
  output=AST;
  superClass=ChameleonParser;
}

scope TargetScope {
  CrossReferenceTarget target;
  Token start;
}

@parser::header {
package mview.parser;

import mview.exception.MergeNotSupportedException;
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
import mview.model.composition.modifier.Negate;
import mview.model.composition.modifier.PropModifier;
import mview.model.composition.PatternSignature;
import mview.model.composition.Pointcut;
import mview.model.composition.PointcutSignature;
import mview.model.composition.PropValue;
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
import mview.model.module.MViewBasicTypeReference;

import mview.model.namespace.MViewDeclaration;

import mview.model.refinement.AbstractElement;
import mview.model.refinement.modifier.Overridable;
import mview.model.refinement.modifier.Extendable;
import mview.model.refinement.modifier.Abstract;
import mview.model.refinement.MViewMember;
import mview.model.refinement.MViewMemberDeclarationImpl;
import mview.model.refinement.RefinableDeclaration;
import mview.model.refinement.RefinableDeclarationImpl;
import mview.model.refinement.RefinableMemberDeclarationImpl;
import mview.model.refinement.RefinementContext;
import mview.model.refinement.RefinementRelation;


import chameleon.core.document.Document;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.declaration.Signature;
import chameleon.core.declaration.Declaration;
//import chameleon.core.method.MethodSignature;
import chameleon.core.reference.CrossReferenceTarget;
import chameleon.oo.type.TypeReference;
import chameleon.oo.type.generics.ActualTypeArgument;
import chameleon.oo.type.BasicTypeReference;
import chameleon.oo.type.Type;
import chameleon.core.namespace.NamespaceReference;
import chameleon.core.namespacedeclaration.NamespaceDeclaration;
import chameleon.core.reference.SimpleReference;
import chameleon.core.reference.ElementReference;
import chameleon.oo.variable.FormalParameter;
import chameleon.core.modifier.Modifier;
import chameleon.util.Pair;
import chameleon.oo.expression.NamedTarget;
import chameleon.oo.plugin.ObjectOrientedFactory;

import jnome.core.language.Java;

import chameleon.support.input.ChameleonParser;
}

@lexer::header {
package mview.parser;
}

@members {

  public NamespaceDeclaration createNamespaceDeclaration() {
    return ((Java)language()).plugin(ObjectOrientedFactory.class).createRootNamespaceDeclaration();
  }
  


}
//@members {
//
//private String unQuote(String quoted) {
//	String result = null;
//	if (quoted != null) {
//		if (quoted.matches("^\".*\"$")) {
//			result = quoted.substring(1,quoted.length()-1);
//		}
//	}
//	return result;
//}
//
//}

// starting point for parsing
compilationUnit returns [Document element] 
@init{ 
	$element = getDocument();
	NamespaceDeclaration npp = createNamespaceDeclaration();
	$element.add(npp);
}
	:	(
			ifd=interfaceDeclaration {npp.add($ifd.element);}
		|
			cod=componentDeclaration {npp.add($cod.element);}
		|
			cnd=connectorDeclaration {npp.add($cnd.element);}
		|
			apd=applicationDeclaration {npp.add($apd.element);}
		/*|
			dpd=deploymentDeclaration {npp.add($dpd.element);}*/
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
		(refinementDeclaration[$element,Interface.class])?
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
			$relation = new SimpleReference<Service>($name.text, Service.class);
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
	: res=serviceHeaderDeclaration {
			$element = $res.element;
		}
	;


serviceHeaderDeclaration returns [Service element]
	:	rtype=serviceReturnType name=Identifier params=formalParameters {
			Signature signature = new SimpleNameSignature($name.text);
			$element = new Service(signature,$rtype.value,$params.lst); //TODO: add properties
			setLocation($element,$name,$name);
		}
	;


serviceReturnType returns [BasicTypeReference value]
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
	:	(negate=negationModifier)? rtype=(Identifier|'*') sig=(Identifier|'*') pars=pointcutServiceSignatureParameters {
			$element = new PatternSignature($rtype.text,$sig.text,$pars.lst);
			
			if ($negate.value != null) {
				$element.addModifier($negate.value);
			}

		}
	;
	

pointcutServiceSignatureParameters returns [List<Pair<String,String>> lst]
@init{$lst = new ArrayList<Pair<String,String>>();}
	: '(' (pointcutServiceSignatureParameterDecls[$lst] )? ')'
	;


pointcutServiceSignatureParameterDecls[List<Pair<String,String>> lst]
	: t=(Identifier|'*') (name=Identifier)? (',' pointcutServiceSignatureParameterDecls[$lst])?
	 {
	 	Pair pair = new Pair($t.text,$name.text);
	 	$lst.add(0,pair);
	 }
	;


/* ***********
 * CONNECTOR
 *********** */
 

connectorDeclaration returns [Connector element]
	:	(abs=abstractModifier)? conkw='connector' name=Identifier {
			$element = new Connector(new SimpleNameSignature($name.text));
			
			if ($abs.value != null) {
				$element.addModifier($abs.value);
			}
			
			setKeyword($element,$conkw);
			setLocation($element,$name,"__NAME");
		} 
		(refinementDeclaration[$element,Connector.class])?
		connectorBody[$element]
	;


connectorBody[Connector element]
	:	'{' connectorBodyDeclaration[$element]* '}'
	;


connectorBodyDeclaration[Connector element]
	:	aoc=aoCompositionDeclaration {
			$element.addComposition($aoc.element);
		}
	|	moduleProvideDependencyDeclaration[$element]
	|	moduleRequireDependencyDeclaration[$element]
	;	
	

aoCompositionDeclaration returns [AOComposition element]
	:	(abs=abstractModifier)? kw='ao-composition' name=Identifier  {
			$element = new AOComposition(new SimpleNameSignature($name.text));
			
			if ($abs.value != null) {
				$element.addModifier($abs.value);
			}
			
			setKeyword($element,$kw);
			setLocation($element,$name,"__NAME");
		}
		(refinementDeclaration[$element,AOComposition.class])?
		aoCompositionBody[$element]
	;


aoCompositionBody[AOComposition element]
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
	Token propKw = null;
	Class<? extends Declaration> declClass = null;
}
	: (override=overrideOrExtend)?
	(
		kw='interface' ':' {
			declClass = Interface.class;
			propKw = kw;
		}
	|	
		kw='component' ':' {
			declClass = Component.class;
			propKw = kw;
		}
	|
		kw='application' ':' {
			declClass = Application.class;
			propKw = kw;
		}
	|
		kw='instance' ':' {
			declClass = Instance.class;
			propKw = kw;
		}
	|
		kw='host' ':' {
			declClass = Host.class;
			propKw = kw;
		}
	) {
		prop = new ActorProp(new PropModifier(declClass));
		setKeyword(prop,propKw);
		actor.addProp(prop);
		if ($override.value != null) {
			prop.addModifier($override.value);
		}
		
	} pointcutActorPropDecls[prop,declClass] ';'
	;


pointcutActorPropDecls[ActorProp prop,Class<? extends Declaration> declClass]
	: 	(negate=negationModifier)? apdref=pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? {
			PropValue propValue = new PropValue($apdref.relation);
			
			if ($negate.value != null) {
				propValue.addModifier($negate.value);
			}

			$prop.addPropValue(propValue);
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
	|	adviceInstanceDeclaration[$advice]
	;
	
	
adviceServiceDeclaration[Advice advice]
	:	svkw='method' ':' service=serviceReferenceDeclaration ';' {
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

adviceInstanceDeclaration[Advice advice]
	:	inskw='instance' ':' instance=instanceReferenceDeclaration ';' {
			$advice.setInstance($instance.relation);
			setKeyword($instance.relation,$inskw);
		}
	;
	
instanceReferenceDeclaration returns [SimpleReference<Instance> relation]
	: 	name=Identifier {
			$relation = new SimpleReference($name.text,Instance.class);
			setLocation($relation, $name, $name);
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
		} 
		(refinementDeclaration[$element,Component.class])?
		componentBody[$element]
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
	:	(abs=abstractModifier)? appkw='application' name=Identifier {
			$element = new Application(new SimpleNameSignature($name.text));
			
			if ($abs.value != null) {
				$element.addModifier($abs.value);
			}

			setKeyword($element,$appkw);
   			setLocation($element,$name,"__NAME");
		} 
		(refinementDeclaration[$element,Application.class])?
		applicationBody[$element]
	;


applicationBody[Application element]
	: '{' ( applicationBodyDeclaration[$element] )* '}'
	;
	

applicationBodyDeclaration[Application element]
	:	mod=moduleContainerDeclarations {
			$element.addModule($mod.element);
		}
	|
		hod=hostDeclaration {
			$element.addHost($hod.element);
		}
	|	
		ind=instanceDeclaration {
			$element.addInstance($ind.element); 
		}
	;
	
	
/* ***********
 * DEPLOYMENT
 *********** */

/*deploymentDeclaration returns [Deployment element]
	:	(abs=abstractModifier)? appkw='deployment' name=Identifier {
			$element = new Deployment(new SimpleNameSignature($name.text));

			if ($abs.value != null) {
				$element.addModifier($abs.value);
			}

			setKeyword($element,$appkw);
   			setLocation($element,$name,"__NAME");
		} 
		(refinementDeclaration[$element,Application.class])?
		applicationBody[$element]
	;
*/

/* ********************
 * INSTANCE DECLARATION
 ********************* */

//				setLocation(relation,$ref,$ref);

instanceDeclaration returns [Instance element]
	:	ref=qualifiedDeclarationReference[Module.class] name=Identifier onkw='on' hst=Identifier ';' {
	
			$element = new Instance(new SimpleNameSignature($name.text));
			setLocation($element,$name,"__NAME");

			SimpleReference<Module> relation = $ref.reference;
			//new SimpleReference<Module>($tpe.text,Module.class);
			if (relation != null) {
				$element.setType(relation);
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
			
		} ( onkw='is' value=StringLiteral {
			
			HostName hostName = new HostName(new SimpleNameSignature($value.text));
			$element.setHostName(hostName);
			setKeyword(hostName,$onkw);
			
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

// single
refinementDeclarationSingle[RefinableDeclaration element, Class kind]
	:	rfkw='refines' rel=refinementDeclarationBody[$kind] {
			setKeyword(rel.relation,rfkw);
			$element.addRefinementRelation(rel.relation);
		}
	;	

// multiple
refinementDeclaration[RefinableDeclaration element, Class kind]
	:	refinementDeclarationSingle[$element,$kind] ( ',' rel=refinementDeclarationBody[$kind] {
			$element.addRefinementRelation(rel.relation);
		} )* 
	;
	
	
refinementDeclarationBody[Class kind] returns [RefinementRelation relation]
	:	parent=qualifiedDeclarationReference[$kind] {
			$relation = new RefinementRelation(parent.reference);		
		}
	;



/* ***********
 * MISC
 *********** */
qualifiedDeclarationReference[Class kind] returns [SimpleReference reference]
@init{
	Token start = null; 
	Token end = null;
	SimpleReference target = null;}
@after{
	check_null($reference);
	setLocation($reference, start, end);
}
	:	name=Identifier {
			$reference = new SimpleReference($name.text,$kind);
			target = new SimpleReference($name.text,RefinableDeclaration.class);
			start = $name;
			end = $name;
		}
		('.' namex=Identifier {
				if (target != null) {
//					setLocation($
					$reference = new SimpleReference(target,$namex.text,RefinableDeclaration.class);
					target = new SimpleReference(target.clone(),$namex.text,RefinableDeclaration.class);
				} else {
					$reference = new SimpleReference($name.text,$kind);
				}
				//start = $namex;
				end = $namex;
			} 
		)*
	;


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
	|	ekw='merge' {$value = new Extendable(); setKeyword($value,$ekw); }
	;
	

negationModifier returns [Modifier value]
	: 	'!' {$value = new Negate(); }
	;
	
abstractModifier returns [Modifier value]
	:	akw='abstract' {$value = new Abstract(); setKeyword($value,$akw); }
	;
	
voidType returns [BasicTypeReference value]
/*@after{setLocation(retval.element, (CommonToken)retval.start, (CommonToken)retval.stop, "__PRIMITIVE");}*/
    : 'void' {$value=new BasicTypeReference("void");}
    ;


//wildcardType returns [TypeReference value]
//	: '*' { $value = new BasicTypeReference("wildcard"); }
//	;


type returns [BasicTypeReference value]
@after{setLocation($value, $start, $stop);}
	:	cd=classOrInterfaceType {$value = $cd.element;}
	|	pt=primitiveType {$value = $pt.value;}
	;
	

classOrInterfaceType returns [BasicTypeReference element]
@init{NamedTarget target = null;}
	:	name=Identifier 
	          {
	           $element = new MViewBasicTypeReference($name.text);
	           target =  new NamedTarget($name.text);
	           setLocation($element,$name,$name); 
	          }
			typeArguments? 
	        ('.' namex=Identifier
	          {
	           if(target != null) {
	             $element = new MViewBasicTypeReference(target,$namex.text);
	             // We must clone the target here, or else it will be removed from the
	             // type reference we just created.
	             target = new NamedTarget($namex.text,target.clone());
	           } else {
	             $element = new MViewBasicTypeReference($element,$namex.text);
	           }
	          } 
	         typeArguments? )*
	;


primitiveType returns [BasicTypeReference value]
    :   'boolean' {$value = new MViewBasicTypeReference("boolean");}
    |   'char' {$value = new MViewBasicTypeReference("char");}
    |   'byte' {$value = new MViewBasicTypeReference("byte");}
    |   'short' {$value = new MViewBasicTypeReference("short");}
    |   'int' {$value = new MViewBasicTypeReference("int");}
    |   'long' {$value = new MViewBasicTypeReference("long");}
    |   'float' {$value = new MViewBasicTypeReference("float");}
    |   'double' {$value = new MViewBasicTypeReference("double");}
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
    :   Letter(Letter|JavaIDDigit)*
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
       '\uf900'..'\ufaff' |
       '*'
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


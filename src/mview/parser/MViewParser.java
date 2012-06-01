// $ANTLR 3.4 /Users/steveno/repos/mview-lang/src/mview/parser/MView.g 2012-06-01 14:12:07

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

import chameleon.support.input.ChameleonParser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class MViewParser extends ChameleonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "CharacterLiteral", "DecimalLiteral", "EscapeSequence", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "HexDigit", "HexLiteral", "Identifier", "IntegerTypeSuffix", "JavaIDDigit", "LINE_COMMENT", "Letter", "OctalEscape", "OctalLiteral", "StringLiteral", "UnicodeEscape", "WS", "'!'", "'('", "')'", "'*'", "','", "'.'", "':'", "';'", "'<'", "'='", "'>'", "'?'", "'@'", "'abstract'", "'advice'", "'after'", "'ao-composition'", "'application'", "'around'", "'before'", "'boolean'", "'byte'", "'call'", "'callee'", "'caller'", "'char'", "'component'", "'connector'", "'default'", "'double'", "'execution'", "'extends'", "'float'", "'host'", "'instance'", "'int'", "'interface'", "'is'", "'kind'", "'long'", "'merge'", "'on'", "'override'", "'pointcut'", "'provide'", "'refines'", "'require'", "'service'", "'short'", "'signature'", "'super'", "'type'", "'void'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int COMMENT=4;
    public static final int CharacterLiteral=5;
    public static final int DecimalLiteral=6;
    public static final int EscapeSequence=7;
    public static final int Exponent=8;
    public static final int FloatTypeSuffix=9;
    public static final int FloatingPointLiteral=10;
    public static final int HexDigit=11;
    public static final int HexLiteral=12;
    public static final int Identifier=13;
    public static final int IntegerTypeSuffix=14;
    public static final int JavaIDDigit=15;
    public static final int LINE_COMMENT=16;
    public static final int Letter=17;
    public static final int OctalEscape=18;
    public static final int OctalLiteral=19;
    public static final int StringLiteral=20;
    public static final int UnicodeEscape=21;
    public static final int WS=22;

    // delegates
    public ChameleonParser[] getDelegates() {
        return new ChameleonParser[] {};
    }

    // delegators

    protected static class TargetScope_scope {
        CrossReferenceTarget target;
        Token start;
    }
    protected Stack TargetScope_stack = new Stack();



    public MViewParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public MViewParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[169+1];
         

    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return MViewParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/steveno/repos/mview-lang/src/mview/parser/MView.g"; }


    public static class compilationUnit_return extends ParserRuleReturnScope {
        public Document element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "compilationUnit"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:113:1: compilationUnit returns [Document element] : (ifd= interfaceDeclaration |cod= componentDeclaration |cnd= connectorDeclaration |apd= applicationDeclaration )* ;
    public final MViewParser.compilationUnit_return compilationUnit() throws RecognitionException {
        MViewParser.compilationUnit_return retval = new MViewParser.compilationUnit_return();
        retval.start = input.LT(1);

        int compilationUnit_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.interfaceDeclaration_return ifd =null;

        MViewParser.componentDeclaration_return cod =null;

        MViewParser.connectorDeclaration_return cnd =null;

        MViewParser.applicationDeclaration_return apd =null;



         
        	retval.element = getDocument();
        	NamespaceDeclaration npp = new NamespaceDeclaration(language().defaultNamespace());
        	retval.element.add(npp);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:119:2: ( (ifd= interfaceDeclaration |cod= componentDeclaration |cnd= connectorDeclaration |apd= applicationDeclaration )* )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:119:4: (ifd= interfaceDeclaration |cod= componentDeclaration |cnd= connectorDeclaration |apd= applicationDeclaration )*
            {
            root_0 = (Object)adaptor.nil();


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:119:4: (ifd= interfaceDeclaration |cod= componentDeclaration |cnd= connectorDeclaration |apd= applicationDeclaration )*
            loop1:
            do {
                int alt1=5;
                switch ( input.LA(1) ) {
                case 59:
                    {
                    alt1=1;
                    }
                    break;
                case 49:
                    {
                    alt1=2;
                    }
                    break;
                case 36:
                    {
                    int LA1_4 = input.LA(2);

                    if ( (LA1_4==50) ) {
                        alt1=3;
                    }
                    else if ( (LA1_4==40) ) {
                        alt1=4;
                    }


                    }
                    break;
                case 50:
                    {
                    alt1=3;
                    }
                    break;
                case 40:
                    {
                    alt1=4;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:120:4: ifd= interfaceDeclaration
            	    {
            	    pushFollow(FOLLOW_interfaceDeclaration_in_compilationUnit101);
            	    ifd=interfaceDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifd.getTree());

            	    if ( state.backtracking==0 ) {npp.add((ifd!=null?ifd.element:null));}

            	    }
            	    break;
            	case 2 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:122:4: cod= componentDeclaration
            	    {
            	    pushFollow(FOLLOW_componentDeclaration_in_compilationUnit114);
            	    cod=componentDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cod.getTree());

            	    if ( state.backtracking==0 ) {npp.add((cod!=null?cod.element:null));}

            	    }
            	    break;
            	case 3 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:124:4: cnd= connectorDeclaration
            	    {
            	    pushFollow(FOLLOW_connectorDeclaration_in_compilationUnit127);
            	    cnd=connectorDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cnd.getTree());

            	    if ( state.backtracking==0 ) {npp.add((cnd!=null?cnd.element:null));}

            	    }
            	    break;
            	case 4 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:126:4: apd= applicationDeclaration
            	    {
            	    pushFollow(FOLLOW_applicationDeclaration_in_compilationUnit140);
            	    apd=applicationDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, apd.getTree());

            	    if ( state.backtracking==0 ) {npp.add((apd!=null?apd.element:null));}

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, compilationUnit_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "compilationUnit"


    public static class interfaceDeclaration_return extends ParserRuleReturnScope {
        public Interface element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "interfaceDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:139:1: interfaceDeclaration returns [Interface element] : intkw= 'interface' name= Identifier interfaceBody[$element] ;
    public final MViewParser.interfaceDeclaration_return interfaceDeclaration() throws RecognitionException {
        MViewParser.interfaceDeclaration_return retval = new MViewParser.interfaceDeclaration_return();
        retval.start = input.LT(1);

        int interfaceDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token intkw=null;
        Token name=null;
        MViewParser.interfaceBody_return interfaceBody1 =null;


        Object intkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:140:2: (intkw= 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:140:4: intkw= 'interface' name= Identifier interfaceBody[$element]
            {
            root_0 = (Object)adaptor.nil();


            intkw=(Token)match(input,59,FOLLOW_59_in_interfaceDeclaration174); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            intkw_tree = 
            (Object)adaptor.create(intkw)
            ;
            adaptor.addChild(root_0, intkw_tree);
            }

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            if ( state.backtracking==0 ) {
            			retval.element = new Interface(new SimpleNameSignature((name!=null?name.getText():null)));
            			setKeyword(retval.element,intkw);
            			setLocation(retval.element,name,"__NAME");
            		}

            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration184);
            interfaceBody1=interfaceBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, interfaceBody1.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, interfaceDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "interfaceDeclaration"


    public static class interfaceBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "interfaceBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:149:1: interfaceBody[Interface element] : '{' ( interfaceBodyDeclaration[$element] )* '}' ;
    public final MViewParser.interfaceBody_return interfaceBody(Interface element) throws RecognitionException {
        MViewParser.interfaceBody_return retval = new MViewParser.interfaceBody_return();
        retval.start = input.LT(1);

        int interfaceBody_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal2=null;
        Token char_literal4=null;
        MViewParser.interfaceBodyDeclaration_return interfaceBodyDeclaration3 =null;


        Object char_literal2_tree=null;
        Object char_literal4_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:150:2: ( '{' ( interfaceBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:150:4: '{' ( interfaceBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();


            char_literal2=(Token)match(input,76,FOLLOW_76_in_interfaceBody198); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = 
            (Object)adaptor.create(char_literal2)
            ;
            adaptor.addChild(root_0, char_literal2_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:150:8: ( interfaceBodyDeclaration[$element] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||(LA2_0 >= 43 && LA2_0 <= 44)||LA2_0==48||LA2_0==52||LA2_0==55||LA2_0==58||LA2_0==62||LA2_0==71||LA2_0==75) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:150:8: interfaceBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody200);
            	    interfaceBodyDeclaration3=interfaceBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, interfaceBodyDeclaration3.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            char_literal4=(Token)match(input,77,FOLLOW_77_in_interfaceBody204); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal4_tree = 
            (Object)adaptor.create(char_literal4)
            ;
            adaptor.addChild(root_0, char_literal4_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, interfaceBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "interfaceBody"


    public static class interfaceBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "interfaceBodyDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:154:1: interfaceBodyDeclaration[Interface element] : (service= serviceDeclaration ';' ) ;
    public final MViewParser.interfaceBodyDeclaration_return interfaceBodyDeclaration(Interface element) throws RecognitionException {
        MViewParser.interfaceBodyDeclaration_return retval = new MViewParser.interfaceBodyDeclaration_return();
        retval.start = input.LT(1);

        int interfaceBodyDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal5=null;
        MViewParser.serviceDeclaration_return service =null;


        Object char_literal5_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:155:2: ( (service= serviceDeclaration ';' ) )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:155:4: (service= serviceDeclaration ';' )
            {
            root_0 = (Object)adaptor.nil();


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:155:4: (service= serviceDeclaration ';' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:155:5: service= serviceDeclaration ';'
            {
            pushFollow(FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration220);
            service=serviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());

            char_literal5=(Token)match(input,30,FOLLOW_30_in_interfaceBodyDeclaration222); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal5_tree = 
            (Object)adaptor.create(char_literal5)
            ;
            adaptor.addChild(root_0, char_literal5_tree);
            }

            }


            if ( state.backtracking==0 ) {
            			element.addService((service!=null?service.element:null));
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, interfaceBodyDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "interfaceBodyDeclaration"


    public static class serviceReferenceDeclaration_return extends ParserRuleReturnScope {
        public SimpleReference<Service> relation;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "serviceReferenceDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:166:1: serviceReferenceDeclaration returns [SimpleReference<Service> relation] : name= Identifier params= actualParameters ;
    public final MViewParser.serviceReferenceDeclaration_return serviceReferenceDeclaration() throws RecognitionException {
        MViewParser.serviceReferenceDeclaration_return retval = new MViewParser.serviceReferenceDeclaration_return();
        retval.start = input.LT(1);

        int serviceReferenceDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token name=null;
        MViewParser.actualParameters_return params =null;


        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:167:2: (name= Identifier params= actualParameters )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:167:4: name= Identifier params= actualParameters
            {
            root_0 = (Object)adaptor.nil();


            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceReferenceDeclaration247); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            pushFollow(FOLLOW_actualParameters_in_serviceReferenceDeclaration251);
            params=actualParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, params.getTree());

            if ( state.backtracking==0 ) {
            			retval.relation = new SimpleReference<Service>((name!=null?name.getText():null), Service.class);
            			setLocation(retval.relation,name,name);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, serviceReferenceDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "serviceReferenceDeclaration"


    public static class actualParameters_return extends ParserRuleReturnScope {
        public List<String> lst;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "actualParameters"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:174:1: actualParameters returns [List<String> lst] : '(' (pars= actualParameterDecls )? ')' ;
    public final MViewParser.actualParameters_return actualParameters() throws RecognitionException {
        MViewParser.actualParameters_return retval = new MViewParser.actualParameters_return();
        retval.start = input.LT(1);

        int actualParameters_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal6=null;
        Token char_literal7=null;
        MViewParser.actualParameterDecls_return pars =null;


        Object char_literal6_tree=null;
        Object char_literal7_tree=null;

        retval.lst = new ArrayList<String>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:176:5: ( '(' (pars= actualParameterDecls )? ')' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:176:9: '(' (pars= actualParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();


            char_literal6=(Token)match(input,24,FOLLOW_24_in_actualParameters280); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = 
            (Object)adaptor.create(char_literal6)
            ;
            adaptor.addChild(root_0, char_literal6_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:176:13: (pars= actualParameterDecls )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Identifier) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:176:14: pars= actualParameterDecls
                    {
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameters285);
                    pars=actualParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());

                    if ( state.backtracking==0 ) {retval.lst =(pars!=null?pars.lst:null);}

                    }
                    break;

            }


            char_literal7=(Token)match(input,25,FOLLOW_25_in_actualParameters291); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal7_tree = 
            (Object)adaptor.create(char_literal7)
            ;
            adaptor.addChild(root_0, char_literal7_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, actualParameters_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "actualParameters"


    public static class actualParameterDecls_return extends ParserRuleReturnScope {
        public List<String> lst;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "actualParameterDecls"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:179:1: actualParameterDecls returns [List<String> lst] : name= Identifier ( ',' decls= actualParameterDecls )? ;
    public final MViewParser.actualParameterDecls_return actualParameterDecls() throws RecognitionException {
        MViewParser.actualParameterDecls_return retval = new MViewParser.actualParameterDecls_return();
        retval.start = input.LT(1);

        int actualParameterDecls_StartIndex = input.index();

        Object root_0 = null;

        Token name=null;
        Token char_literal8=null;
        MViewParser.actualParameterDecls_return decls =null;


        Object name_tree=null;
        Object char_literal8_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:180:5: (name= Identifier ( ',' decls= actualParameterDecls )? )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:180:9: name= Identifier ( ',' decls= actualParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();


            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_actualParameterDecls316); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:180:25: ( ',' decls= actualParameterDecls )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==27) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:180:26: ',' decls= actualParameterDecls
                    {
                    char_literal8=(Token)match(input,27,FOLLOW_27_in_actualParameterDecls319); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = 
                    (Object)adaptor.create(char_literal8)
                    ;
                    adaptor.addChild(root_0, char_literal8_tree);
                    }

                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameterDecls323);
                    decls=actualParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());

                    if ( state.backtracking==0 ) { retval.lst =decls.lst; }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                		if(retval.lst == null) {
                     		retval.lst =new ArrayList<String>();
                     	}
            					
            			retval.lst.add(0,(name!=null?name.getText():null));
                     }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, actualParameterDecls_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "actualParameterDecls"


    public static class serviceDeclaration_return extends ParserRuleReturnScope {
        public Service element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "serviceDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:196:1: serviceDeclaration returns [Service element] : res= serviceHeaderDeclaration ;
    public final MViewParser.serviceDeclaration_return serviceDeclaration() throws RecognitionException {
        MViewParser.serviceDeclaration_return retval = new MViewParser.serviceDeclaration_return();
        retval.start = input.LT(1);

        int serviceDeclaration_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.serviceHeaderDeclaration_return res =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:197:2: (res= serviceHeaderDeclaration )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:197:4: res= serviceHeaderDeclaration
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration356);
            res=serviceHeaderDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, res.getTree());

            if ( state.backtracking==0 ) {
            			retval.element = (res!=null?res.element:null);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, serviceDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "serviceDeclaration"


    public static class serviceHeaderDeclaration_return extends ParserRuleReturnScope {
        public Service element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "serviceHeaderDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:203:1: serviceHeaderDeclaration returns [Service element] : rtype= serviceReturnType name= Identifier params= formalParameters ;
    public final MViewParser.serviceHeaderDeclaration_return serviceHeaderDeclaration() throws RecognitionException {
        MViewParser.serviceHeaderDeclaration_return retval = new MViewParser.serviceHeaderDeclaration_return();
        retval.start = input.LT(1);

        int serviceHeaderDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token name=null;
        MViewParser.serviceReturnType_return rtype =null;

        MViewParser.formalParameters_return params =null;


        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:204:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:204:4: rtype= serviceReturnType name= Identifier params= formalParameters
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_serviceReturnType_in_serviceHeaderDeclaration376);
            rtype=serviceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceHeaderDeclaration380); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            pushFollow(FOLLOW_formalParameters_in_serviceHeaderDeclaration384);
            params=formalParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, params.getTree());

            if ( state.backtracking==0 ) {
            			Signature signature = new SimpleNameSignature((name!=null?name.getText():null));
            			retval.element = new Service(signature,(rtype!=null?rtype.value:null),(params!=null?params.lst:null)); //TODO: add properties
            			setLocation(retval.element,name,name);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, serviceHeaderDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "serviceHeaderDeclaration"


    public static class serviceReturnType_return extends ParserRuleReturnScope {
        public BasicTypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "serviceReturnType"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:212:1: serviceReturnType returns [BasicTypeReference value] : (vt= voidType |tp= type ) ;
    public final MViewParser.serviceReturnType_return serviceReturnType() throws RecognitionException {
        MViewParser.serviceReturnType_return retval = new MViewParser.serviceReturnType_return();
        retval.start = input.LT(1);

        int serviceReturnType_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.voidType_return vt =null;

        MViewParser.type_return tp =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:213:2: ( (vt= voidType |tp= type ) )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:213:4: (vt= voidType |tp= type )
            {
            root_0 = (Object)adaptor.nil();


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:213:4: (vt= voidType |tp= type )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==75) ) {
                alt5=1;
            }
            else if ( (LA5_0==Identifier||(LA5_0 >= 43 && LA5_0 <= 44)||LA5_0==48||LA5_0==52||LA5_0==55||LA5_0==58||LA5_0==62||LA5_0==71) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:214:4: vt= voidType
                    {
                    pushFollow(FOLLOW_voidType_in_serviceReturnType410);
                    vt=voidType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vt.getTree());

                    if ( state.backtracking==0 ) { retval.value =(vt!=null?vt.value:null); }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:216:4: tp= type
                    {
                    pushFollow(FOLLOW_type_in_serviceReturnType424);
                    tp=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tp.getTree());

                    if ( state.backtracking==0 ) { retval.value =(tp!=null?tp.value:null); }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, serviceReturnType_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "serviceReturnType"


    public static class formalParameters_return extends ParserRuleReturnScope {
        public List<FormalParameter> lst;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "formalParameters"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:221:1: formalParameters returns [List<FormalParameter> lst] : '(' (pars= formalParameterDecls )? ')' ;
    public final MViewParser.formalParameters_return formalParameters() throws RecognitionException {
        MViewParser.formalParameters_return retval = new MViewParser.formalParameters_return();
        retval.start = input.LT(1);

        int formalParameters_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal9=null;
        Token char_literal10=null;
        MViewParser.formalParameterDecls_return pars =null;


        Object char_literal9_tree=null;
        Object char_literal10_tree=null;

        retval.lst = new ArrayList<FormalParameter>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:223:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:223:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();


            char_literal9=(Token)match(input,24,FOLLOW_24_in_formalParameters456); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal9_tree = 
            (Object)adaptor.create(char_literal9)
            ;
            adaptor.addChild(root_0, char_literal9_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:223:13: (pars= formalParameterDecls )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Identifier||(LA6_0 >= 43 && LA6_0 <= 44)||LA6_0==48||LA6_0==52||LA6_0==55||LA6_0==58||LA6_0==62||LA6_0==71) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:223:14: pars= formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters461);
                    pars=formalParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());

                    if ( state.backtracking==0 ) {retval.lst =(pars!=null?pars.lst:null);}

                    }
                    break;

            }


            char_literal10=(Token)match(input,25,FOLLOW_25_in_formalParameters467); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal10_tree = 
            (Object)adaptor.create(char_literal10)
            ;
            adaptor.addChild(root_0, char_literal10_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, formalParameters_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "formalParameters"


    public static class formalParameterDecls_return extends ParserRuleReturnScope {
        public List<FormalParameter> lst;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "formalParameterDecls"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:227:1: formalParameterDecls returns [List<FormalParameter> lst] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
    public final MViewParser.formalParameterDecls_return formalParameterDecls() throws RecognitionException {
        MViewParser.formalParameterDecls_return retval = new MViewParser.formalParameterDecls_return();
        retval.start = input.LT(1);

        int formalParameterDecls_StartIndex = input.index();

        Object root_0 = null;

        Token name=null;
        Token char_literal11=null;
        MViewParser.type_return t =null;

        MViewParser.formalParameterDecls_return decls =null;


        Object name_tree=null;
        Object char_literal11_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:228:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:228:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_type_in_formalParameterDecls493);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls497); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:228:32: ( ',' decls= formalParameterDecls )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==27) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:228:33: ',' decls= formalParameterDecls
                    {
                    char_literal11=(Token)match(input,27,FOLLOW_27_in_formalParameterDecls500); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal11_tree = 
                    (Object)adaptor.create(char_literal11)
                    ;
                    adaptor.addChild(root_0, char_literal11_tree);
                    }

                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls504);
                    decls=formalParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());

                    if ( state.backtracking==0 ) { retval.lst =decls.lst; }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                		if(retval.lst == null) {
                     		retval.lst =new ArrayList<FormalParameter>();
                     	}
            			
            			FormalParameter param = 
            				new FormalParameter(
            					new SimpleNameSignature((name!=null?name.getText():null)),(t!=null?t.value:null));
            			
            			retval.lst.add(0,param);
                     }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, formalParameterDecls_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "formalParameterDecls"


    public static class pointcutServiceSignatureDecl_return extends ParserRuleReturnScope {
        public ServiceSignature element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutServiceSignatureDecl"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:249:1: pointcutServiceSignatureDecl returns [ServiceSignature element] : (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters ;
    public final MViewParser.pointcutServiceSignatureDecl_return pointcutServiceSignatureDecl() throws RecognitionException {
        MViewParser.pointcutServiceSignatureDecl_return retval = new MViewParser.pointcutServiceSignatureDecl_return();
        retval.start = input.LT(1);

        int pointcutServiceSignatureDecl_StartIndex = input.index();

        Object root_0 = null;

        Token rtype=null;
        Token sig=null;
        MViewParser.negationModifier_return negate =null;

        MViewParser.pointcutServiceSignatureParameters_return pars =null;


        Object rtype_tree=null;
        Object sig_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:250:2: ( (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:250:4: (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters
            {
            root_0 = (Object)adaptor.nil();


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:250:4: (negate= negationModifier )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:250:5: negate= negationModifier
                    {
                    pushFollow(FOLLOW_negationModifier_in_pointcutServiceSignatureDecl540);
                    negate=negationModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, negate.getTree());

                    }
                    break;

            }


            rtype=(Token)input.LT(1);

            if ( input.LA(1)==Identifier||input.LA(1)==26 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(rtype)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            sig=(Token)input.LT(1);

            if ( input.LA(1)==Identifier||input.LA(1)==26 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(sig)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            pushFollow(FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl562);
            pars=pointcutServiceSignatureParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());

            if ( state.backtracking==0 ) {
            			retval.element = new PatternSignature((rtype!=null?rtype.getText():null),(sig!=null?sig.getText():null),(pars!=null?pars.lst:null));
            			
            			if ((negate!=null?negate.value:null) != null) {
            				retval.element.addModifier((negate!=null?negate.value:null));
            			}

            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, pointcutServiceSignatureDecl_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutServiceSignatureDecl"


    public static class pointcutServiceSignatureParameters_return extends ParserRuleReturnScope {
        public List<Pair<String,String>> lst;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutServiceSignatureParameters"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:261:1: pointcutServiceSignatureParameters returns [List<Pair<String,String>> lst] : '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' ;
    public final MViewParser.pointcutServiceSignatureParameters_return pointcutServiceSignatureParameters() throws RecognitionException {
        MViewParser.pointcutServiceSignatureParameters_return retval = new MViewParser.pointcutServiceSignatureParameters_return();
        retval.start = input.LT(1);

        int pointcutServiceSignatureParameters_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal12=null;
        Token char_literal14=null;
        MViewParser.pointcutServiceSignatureParameterDecls_return pointcutServiceSignatureParameterDecls13 =null;


        Object char_literal12_tree=null;
        Object char_literal14_tree=null;

        retval.lst = new ArrayList<Pair<String,String>>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:263:2: ( '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:263:4: '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')'
            {
            root_0 = (Object)adaptor.nil();


            char_literal12=(Token)match(input,24,FOLLOW_24_in_pointcutServiceSignatureParameters585); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal12_tree = 
            (Object)adaptor.create(char_literal12)
            ;
            adaptor.addChild(root_0, char_literal12_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:263:8: ( pointcutServiceSignatureParameterDecls[$lst] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Identifier||LA9_0==26) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:263:9: pointcutServiceSignatureParameterDecls[$lst]
                    {
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters588);
                    pointcutServiceSignatureParameterDecls13=pointcutServiceSignatureParameterDecls(retval.lst);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutServiceSignatureParameterDecls13.getTree());

                    }
                    break;

            }


            char_literal14=(Token)match(input,25,FOLLOW_25_in_pointcutServiceSignatureParameters594); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal14_tree = 
            (Object)adaptor.create(char_literal14)
            ;
            adaptor.addChild(root_0, char_literal14_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, pointcutServiceSignatureParameters_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutServiceSignatureParameters"


    public static class pointcutServiceSignatureParameterDecls_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutServiceSignatureParameterDecls"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:267:1: pointcutServiceSignatureParameterDecls[List<Pair<String,String>> lst] : t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? ;
    public final MViewParser.pointcutServiceSignatureParameterDecls_return pointcutServiceSignatureParameterDecls(List<Pair<String,String>> lst) throws RecognitionException {
        MViewParser.pointcutServiceSignatureParameterDecls_return retval = new MViewParser.pointcutServiceSignatureParameterDecls_return();
        retval.start = input.LT(1);

        int pointcutServiceSignatureParameterDecls_StartIndex = input.index();

        Object root_0 = null;

        Token t=null;
        Token name=null;
        Token char_literal15=null;
        MViewParser.pointcutServiceSignatureParameterDecls_return pointcutServiceSignatureParameterDecls16 =null;


        Object t_tree=null;
        Object name_tree=null;
        Object char_literal15_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:268:2: (t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:268:4: t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
            {
            root_0 = (Object)adaptor.nil();


            t=(Token)input.LT(1);

            if ( input.LA(1)==Identifier||input.LA(1)==26 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(t)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:268:23: (name= Identifier )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Identifier) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:268:24: name= Identifier
                    {
                    name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls618); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    name_tree = 
                    (Object)adaptor.create(name)
                    ;
                    adaptor.addChild(root_0, name_tree);
                    }

                    }
                    break;

            }


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:268:42: ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:268:43: ',' pointcutServiceSignatureParameterDecls[$lst]
                    {
                    char_literal15=(Token)match(input,27,FOLLOW_27_in_pointcutServiceSignatureParameterDecls623); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = 
                    (Object)adaptor.create(char_literal15)
                    ;
                    adaptor.addChild(root_0, char_literal15_tree);
                    }

                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls625);
                    pointcutServiceSignatureParameterDecls16=pointcutServiceSignatureParameterDecls(lst);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutServiceSignatureParameterDecls16.getTree());

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            	 	Pair pair = new Pair((t!=null?t.getText():null),(name!=null?name.getText():null));
            	 	lst.add(0,pair);
            	 }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, pointcutServiceSignatureParameterDecls_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutServiceSignatureParameterDecls"


    public static class connectorDeclaration_return extends ParserRuleReturnScope {
        public Connector element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "connectorDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:281:1: connectorDeclaration returns [Connector element] : (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] ;
    public final MViewParser.connectorDeclaration_return connectorDeclaration() throws RecognitionException {
        MViewParser.connectorDeclaration_return retval = new MViewParser.connectorDeclaration_return();
        retval.start = input.LT(1);

        int connectorDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token conkw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs =null;

        MViewParser.refinementDeclaration_return refinementDeclaration17 =null;

        MViewParser.connectorBody_return connectorBody18 =null;


        Object conkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:282:2: ( (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:282:4: (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element]
            {
            root_0 = (Object)adaptor.nil();


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:282:4: (abs= abstractModifier )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==36) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:282:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_connectorDeclaration656);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }


            conkw=(Token)match(input,50,FOLLOW_50_in_connectorDeclaration662); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            conkw_tree = 
            (Object)adaptor.create(conkw)
            ;
            adaptor.addChild(root_0, conkw_tree);
            }

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration666); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            if ( state.backtracking==0 ) {
            			retval.element = new Connector(new SimpleNameSignature((name!=null?name.getText():null)));
            			
            			if ((abs!=null?abs.value:null) != null) {
            				retval.element.addModifier((abs!=null?abs.value:null));
            			}
            			
            			setKeyword(retval.element,conkw);
            			setLocation(retval.element,name,"__NAME");
            		}

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:292:3: ( refinementDeclaration[$element,Connector.class] )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==68) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:292:4: refinementDeclaration[$element,Connector.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_connectorDeclaration674);
                    refinementDeclaration17=refinementDeclaration(retval.element, Connector.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration17.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration681);
            connectorBody18=connectorBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorBody18.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, connectorDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "connectorDeclaration"


    public static class connectorBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "connectorBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:297:1: connectorBody[Connector element] : '{' ( connectorBodyDeclaration[$element] )* '}' ;
    public final MViewParser.connectorBody_return connectorBody(Connector element) throws RecognitionException {
        MViewParser.connectorBody_return retval = new MViewParser.connectorBody_return();
        retval.start = input.LT(1);

        int connectorBody_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal19=null;
        Token char_literal21=null;
        MViewParser.connectorBodyDeclaration_return connectorBodyDeclaration20 =null;


        Object char_literal19_tree=null;
        Object char_literal21_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:298:2: ( '{' ( connectorBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:298:4: '{' ( connectorBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();


            char_literal19=(Token)match(input,76,FOLLOW_76_in_connectorBody695); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = 
            (Object)adaptor.create(char_literal19)
            ;
            adaptor.addChild(root_0, char_literal19_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:298:8: ( connectorBodyDeclaration[$element] )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==36||LA14_0==39||LA14_0==69) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:298:8: connectorBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_connectorBodyDeclaration_in_connectorBody697);
            	    connectorBodyDeclaration20=connectorBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorBodyDeclaration20.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            char_literal21=(Token)match(input,77,FOLLOW_77_in_connectorBody701); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal21_tree = 
            (Object)adaptor.create(char_literal21)
            ;
            adaptor.addChild(root_0, char_literal21_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, connectorBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "connectorBody"


    public static class connectorBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "connectorBodyDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:302:1: connectorBodyDeclaration[Connector element] : (aoc= aoCompositionDeclaration | moduleRequireDependencyDeclaration[$element] );
    public final MViewParser.connectorBodyDeclaration_return connectorBodyDeclaration(Connector element) throws RecognitionException {
        MViewParser.connectorBodyDeclaration_return retval = new MViewParser.connectorBodyDeclaration_return();
        retval.start = input.LT(1);

        int connectorBodyDeclaration_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.aoCompositionDeclaration_return aoc =null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration22 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:303:2: (aoc= aoCompositionDeclaration | moduleRequireDependencyDeclaration[$element] )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==36||LA15_0==39) ) {
                alt15=1;
            }
            else if ( (LA15_0==69) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:303:4: aoc= aoCompositionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_aoCompositionDeclaration_in_connectorBodyDeclaration716);
                    aoc=aoCompositionDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aoc.getTree());

                    if ( state.backtracking==0 ) {
                    			element.addComposition((aoc!=null?aoc.element:null));
                    		}

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:306:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration723);
                    moduleRequireDependencyDeclaration22=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration22.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, connectorBodyDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "connectorBodyDeclaration"


    public static class aoCompositionDeclaration_return extends ParserRuleReturnScope {
        public AOComposition element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aoCompositionDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:310:1: aoCompositionDeclaration returns [AOComposition element] : (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclarationSingle[$element,AOComposition.class] )? aoCompositionBody[$element] ;
    public final MViewParser.aoCompositionDeclaration_return aoCompositionDeclaration() throws RecognitionException {
        MViewParser.aoCompositionDeclaration_return retval = new MViewParser.aoCompositionDeclaration_return();
        retval.start = input.LT(1);

        int aoCompositionDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token kw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs =null;

        MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle23 =null;

        MViewParser.aoCompositionBody_return aoCompositionBody24 =null;


        Object kw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:311:2: ( (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclarationSingle[$element,AOComposition.class] )? aoCompositionBody[$element] )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:311:4: (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclarationSingle[$element,AOComposition.class] )? aoCompositionBody[$element]
            {
            root_0 = (Object)adaptor.nil();


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:311:4: (abs= abstractModifier )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==36) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:311:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_aoCompositionDeclaration745);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }


            kw=(Token)match(input,39,FOLLOW_39_in_aoCompositionDeclaration751); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kw_tree = 
            (Object)adaptor.create(kw)
            ;
            adaptor.addChild(root_0, kw_tree);
            }

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_aoCompositionDeclaration755); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            if ( state.backtracking==0 ) {
            			retval.element = new AOComposition(new SimpleNameSignature((name!=null?name.getText():null)));
            			
            			if ((abs!=null?abs.value:null) != null) {
            				retval.element.addModifier((abs!=null?abs.value:null));
            			}
            			
            			setKeyword(retval.element,kw);
            			setLocation(retval.element,name,"__NAME");
            		}

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:321:3: ( refinementDeclarationSingle[$element,AOComposition.class] )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==68) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:321:4: refinementDeclarationSingle[$element,AOComposition.class]
                    {
                    pushFollow(FOLLOW_refinementDeclarationSingle_in_aoCompositionDeclaration763);
                    refinementDeclarationSingle23=refinementDeclarationSingle(retval.element, AOComposition.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationSingle23.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_aoCompositionBody_in_aoCompositionDeclaration770);
            aoCompositionBody24=aoCompositionBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aoCompositionBody24.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, aoCompositionDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "aoCompositionDeclaration"


    public static class aoCompositionBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aoCompositionBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:326:1: aoCompositionBody[AOComposition element] : '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' ;
    public final MViewParser.aoCompositionBody_return aoCompositionBody(AOComposition element) throws RecognitionException {
        MViewParser.aoCompositionBody_return retval = new MViewParser.aoCompositionBody_return();
        retval.start = input.LT(1);

        int aoCompositionBody_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal25=null;
        Token char_literal26=null;
        MViewParser.pointcutDeclaration_return pc =null;

        MViewParser.adviceDeclaration_return adv =null;


        Object char_literal25_tree=null;
        Object char_literal26_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:327:2: ( '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:327:4: '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}'
            {
            root_0 = (Object)adaptor.nil();


            char_literal25=(Token)match(input,76,FOLLOW_76_in_aoCompositionBody784); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal25_tree = 
            (Object)adaptor.create(char_literal25)
            ;
            adaptor.addChild(root_0, char_literal25_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:328:5: (pc= pointcutDeclaration )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==66) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:328:5: pc= pointcutDeclaration
                    {
                    pushFollow(FOLLOW_pointcutDeclaration_in_aoCompositionBody791);
                    pc=pointcutDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pc.getTree());

                    }
                    break;

            }


            if ( state.backtracking==0 ) {	
            			element.setPointcut((pc!=null?pc.pointcut:null));
            		}

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:331:6: (adv= adviceDeclaration )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==37) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:331:6: adv= adviceDeclaration
                    {
                    pushFollow(FOLLOW_adviceDeclaration_in_aoCompositionBody800);
                    adv=adviceDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adv.getTree());

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			element.setAdvice((adv!=null?adv.advice:null));
            		}

            char_literal26=(Token)match(input,77,FOLLOW_77_in_aoCompositionBody807); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal26_tree = 
            (Object)adaptor.create(char_literal26)
            ;
            adaptor.addChild(root_0, char_literal26_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, aoCompositionBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "aoCompositionBody"


    public static class pointcutDeclaration_return extends ParserRuleReturnScope {
        public Pointcut pointcut;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:337:1: pointcutDeclaration returns [Pointcut pointcut] : pckw= 'pointcut' pointcutBody[$pointcut] ;
    public final MViewParser.pointcutDeclaration_return pointcutDeclaration() throws RecognitionException {
        MViewParser.pointcutDeclaration_return retval = new MViewParser.pointcutDeclaration_return();
        retval.start = input.LT(1);

        int pointcutDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token pckw=null;
        MViewParser.pointcutBody_return pointcutBody27 =null;


        Object pckw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:338:2: (pckw= 'pointcut' pointcutBody[$pointcut] )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:338:4: pckw= 'pointcut' pointcutBody[$pointcut]
            {
            root_0 = (Object)adaptor.nil();


            pckw=(Token)match(input,66,FOLLOW_66_in_pointcutDeclaration824); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            pckw_tree = 
            (Object)adaptor.create(pckw)
            ;
            adaptor.addChild(root_0, pckw_tree);
            }

            if ( state.backtracking==0 ) {
            				retval.pointcut = new Pointcut();
            				setKeyword(retval.pointcut,pckw);
            			}

            pushFollow(FOLLOW_pointcutBody_in_pointcutDeclaration828);
            pointcutBody27=pointcutBody(retval.pointcut);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBody27.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, pointcutDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutDeclaration"


    public static class pointcutBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:345:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
    public final MViewParser.pointcutBody_return pointcutBody(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutBody_return retval = new MViewParser.pointcutBody_return();
        retval.start = input.LT(1);

        int pointcutBody_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal28=null;
        Token char_literal30=null;
        MViewParser.pointcutBodyDeclaration_return pointcutBodyDeclaration29 =null;


        Object char_literal28_tree=null;
        Object char_literal30_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:346:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:346:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
            {
            root_0 = (Object)adaptor.nil();


            char_literal28=(Token)match(input,76,FOLLOW_76_in_pointcutBody844); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal28_tree = 
            (Object)adaptor.create(char_literal28)
            ;
            adaptor.addChild(root_0, char_literal28_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:346:8: ( pointcutBodyDeclaration[$pointcut] )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0 >= 46 && LA20_0 <= 47)||LA20_0==61||LA20_0==63||LA20_0==65||LA20_0==72) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:346:8: pointcutBodyDeclaration[$pointcut]
            	    {
            	    pushFollow(FOLLOW_pointcutBodyDeclaration_in_pointcutBody846);
            	    pointcutBodyDeclaration29=pointcutBodyDeclaration(pointcut);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBodyDeclaration29.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            char_literal30=(Token)match(input,77,FOLLOW_77_in_pointcutBody850); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal30_tree = 
            (Object)adaptor.create(char_literal30)
            ;
            adaptor.addChild(root_0, char_literal30_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, pointcutBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutBody"


    public static class pointcutBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutBodyDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:350:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] );
    public final MViewParser.pointcutBodyDeclaration_return pointcutBodyDeclaration(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutBodyDeclaration_return retval = new MViewParser.pointcutBodyDeclaration_return();
        retval.start = input.LT(1);

        int pointcutBodyDeclaration_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.pointcutKindDeclaration_return pointcutKindDeclaration31 =null;

        MViewParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration32 =null;

        MViewParser.pointcutActorDeclaration_return pointcutActorDeclaration33 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:351:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt21=1;
                }
                break;
            case 63:
            case 65:
            case 72:
                {
                alt21=2;
                }
                break;
            case 46:
            case 47:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }

            switch (alt21) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:351:4: pointcutKindDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration864);
                    pointcutKindDeclaration31=pointcutKindDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutKindDeclaration31.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:352:4: pointcutSignatureDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration870);
                    pointcutSignatureDeclaration32=pointcutSignatureDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureDeclaration32.getTree());

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:353:4: pointcutActorDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration876);
                    pointcutActorDeclaration33=pointcutActorDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorDeclaration33.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, pointcutBodyDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutBodyDeclaration"


    public static class pointcutKindDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutKindDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:357:1: pointcutKindDeclaration[Pointcut pointcut] : kikw= 'kind' ':' kind= joinPointKind ';' ;
    public final MViewParser.pointcutKindDeclaration_return pointcutKindDeclaration(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutKindDeclaration_return retval = new MViewParser.pointcutKindDeclaration_return();
        retval.start = input.LT(1);

        int pointcutKindDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token kikw=null;
        Token char_literal34=null;
        Token char_literal35=null;
        MViewParser.joinPointKind_return kind =null;


        Object kikw_tree=null;
        Object char_literal34_tree=null;
        Object char_literal35_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:358:2: (kikw= 'kind' ':' kind= joinPointKind ';' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:358:4: kikw= 'kind' ':' kind= joinPointKind ';'
            {
            root_0 = (Object)adaptor.nil();


            kikw=(Token)match(input,61,FOLLOW_61_in_pointcutKindDeclaration893); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kikw_tree = 
            (Object)adaptor.create(kikw)
            ;
            adaptor.addChild(root_0, kikw_tree);
            }

            char_literal34=(Token)match(input,29,FOLLOW_29_in_pointcutKindDeclaration895); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal34_tree = 
            (Object)adaptor.create(char_literal34)
            ;
            adaptor.addChild(root_0, char_literal34_tree);
            }

            pushFollow(FOLLOW_joinPointKind_in_pointcutKindDeclaration899);
            kind=joinPointKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, kind.getTree());

            char_literal35=(Token)match(input,30,FOLLOW_30_in_pointcutKindDeclaration901); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal35_tree = 
            (Object)adaptor.create(char_literal35)
            ;
            adaptor.addChild(root_0, char_literal35_tree);
            }

            if ( state.backtracking==0 ) {
            			pointcut.addModifier((kind!=null?kind.value:null));
            			setKeyword((kind!=null?kind.value:null),kikw);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, pointcutKindDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutKindDeclaration"


    public static class pointcutSignatureDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutSignatureDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:365:1: pointcutSignatureDeclaration[Pointcut element] : (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' ;
    public final MViewParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration(Pointcut element) throws RecognitionException {
        MViewParser.pointcutSignatureDeclaration_return retval = new MViewParser.pointcutSignatureDeclaration_return();
        retval.start = input.LT(1);

        int pointcutSignatureDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token sikw=null;
        Token char_literal36=null;
        Token char_literal37=null;
        MViewParser.overrideOrExtend_return override =null;

        MViewParser.pointcutSignatureBody_return ps =null;


        Object sikw_tree=null;
        Object char_literal36_tree=null;
        Object char_literal37_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:366:2: ( (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:366:4: (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';'
            {
            root_0 = (Object)adaptor.nil();


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:366:4: (override= overrideOrExtend )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==63||LA22_0==65) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:366:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration920);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }


            sikw=(Token)match(input,72,FOLLOW_72_in_pointcutSignatureDeclaration926); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            sikw_tree = 
            (Object)adaptor.create(sikw)
            ;
            adaptor.addChild(root_0, sikw_tree);
            }

            char_literal36=(Token)match(input,29,FOLLOW_29_in_pointcutSignatureDeclaration928); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal36_tree = 
            (Object)adaptor.create(char_literal36)
            ;
            adaptor.addChild(root_0, char_literal36_tree);
            }

            pushFollow(FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration932);
            ps=pointcutSignatureBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ps.getTree());

            if ( state.backtracking==0 ) {
            			PointcutSignature pcsig = (ps!=null?ps.element:null);
            			Modifier ovr = (override!=null?override.value:null);
            			if (ovr != null) {
            				pcsig.addModifier(ovr);
            			}
            			element.setSignature(pcsig);
            			setKeyword(pcsig,sikw);
            		}

            char_literal37=(Token)match(input,30,FOLLOW_30_in_pointcutSignatureDeclaration936); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal37_tree = 
            (Object)adaptor.create(char_literal37)
            ;
            adaptor.addChild(root_0, char_literal37_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, pointcutSignatureDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutSignatureDeclaration"


    public static class pointcutSignatureBody_return extends ParserRuleReturnScope {
        public PointcutSignature element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutSignatureBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:377:1: pointcutSignatureBody returns [PointcutSignature element] : pointcutSignatureBodyDecls[$element] ;
    public final MViewParser.pointcutSignatureBody_return pointcutSignatureBody() throws RecognitionException {
        MViewParser.pointcutSignatureBody_return retval = new MViewParser.pointcutSignatureBody_return();
        retval.start = input.LT(1);

        int pointcutSignatureBody_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls38 =null;



         retval.element = new PointcutSignature(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:379:2: ( pointcutSignatureBodyDecls[$element] )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:379:4: pointcutSignatureBodyDecls[$element]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody955);
            pointcutSignatureBodyDecls38=pointcutSignatureBodyDecls(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureBodyDecls38.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, pointcutSignatureBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutSignatureBody"


    public static class pointcutSignatureBodyDecls_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutSignatureBodyDecls"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:383:1: pointcutSignatureBodyDecls[PointcutSignature element] : pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? ;
    public final MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls(PointcutSignature element) throws RecognitionException {
        MViewParser.pointcutSignatureBodyDecls_return retval = new MViewParser.pointcutSignatureBodyDecls_return();
        retval.start = input.LT(1);

        int pointcutSignatureBodyDecls_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal39=null;
        MViewParser.pointcutServiceSignatureDecl_return pss =null;

        MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls40 =null;


        Object char_literal39_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:384:2: (pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:384:4: pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls972);
            pss=pointcutServiceSignatureDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pss.getTree());

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:384:37: ( ',' pointcutSignatureBodyDecls[$element] )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==27) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:384:39: ',' pointcutSignatureBodyDecls[$element]
                    {
                    char_literal39=(Token)match(input,27,FOLLOW_27_in_pointcutSignatureBodyDecls976); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal39_tree = 
                    (Object)adaptor.create(char_literal39)
                    ;
                    adaptor.addChild(root_0, char_literal39_tree);
                    }

                    pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls978);
                    pointcutSignatureBodyDecls40=pointcutSignatureBodyDecls(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureBodyDecls40.getTree());

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			element.addSignature((pss!=null?pss.element:null));
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, pointcutSignatureBodyDecls_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutSignatureBodyDecls"


    public static class pointcutActorDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutActorDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:390:1: pointcutActorDeclaration[Pointcut pointcut] : (clkw= 'caller' actor= pointcutActorBody |clkw= 'callee' actor= pointcutActorBody );
    public final MViewParser.pointcutActorDeclaration_return pointcutActorDeclaration(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutActorDeclaration_return retval = new MViewParser.pointcutActorDeclaration_return();
        retval.start = input.LT(1);

        int pointcutActorDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token clkw=null;
        MViewParser.pointcutActorBody_return actor =null;


        Object clkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:391:2: (clkw= 'caller' actor= pointcutActorBody |clkw= 'callee' actor= pointcutActorBody )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==47) ) {
                alt24=1;
            }
            else if ( (LA24_0==46) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }
            switch (alt24) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:391:4: clkw= 'caller' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();


                    clkw=(Token)match(input,47,FOLLOW_47_in_pointcutActorDeclaration1000); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    clkw_tree = 
                    (Object)adaptor.create(clkw)
                    ;
                    adaptor.addChild(root_0, clkw_tree);
                    }

                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1004);
                    actor=pointcutActorBody();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, actor.getTree());

                    if ( state.backtracking==0 ) {
                       			setKeyword((actor!=null?actor.element:null),clkw);
                    			pointcut.setCaller((actor!=null?actor.element:null));
                    		}

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:396:3: clkw= 'callee' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();


                    clkw=(Token)match(input,46,FOLLOW_46_in_pointcutActorDeclaration1015); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    clkw_tree = 
                    (Object)adaptor.create(clkw)
                    ;
                    adaptor.addChild(root_0, clkw_tree);
                    }

                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1019);
                    actor=pointcutActorBody();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, actor.getTree());

                    if ( state.backtracking==0 ) {
                       			setKeyword((actor!=null?actor.element:null),clkw);
                    			pointcut.setCallee((actor!=null?actor.element:null));
                    		}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, pointcutActorDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutActorDeclaration"


    public static class pointcutActorBody_return extends ParserRuleReturnScope {
        public Actor element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutActorBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:407:1: pointcutActorBody returns [Actor element] : '{' ( pointcutActorBodyDecls[$element] )* '}' ;
    public final MViewParser.pointcutActorBody_return pointcutActorBody() throws RecognitionException {
        MViewParser.pointcutActorBody_return retval = new MViewParser.pointcutActorBody_return();
        retval.start = input.LT(1);

        int pointcutActorBody_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal41=null;
        Token char_literal43=null;
        MViewParser.pointcutActorBodyDecls_return pointcutActorBodyDecls42 =null;


        Object char_literal41_tree=null;
        Object char_literal43_tree=null;


        	retval.element = new Actor();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:411:2: ( '{' ( pointcutActorBodyDecls[$element] )* '}' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:411:4: '{' ( pointcutActorBodyDecls[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();


            char_literal41=(Token)match(input,76,FOLLOW_76_in_pointcutActorBody1047); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = 
            (Object)adaptor.create(char_literal41)
            ;
            adaptor.addChild(root_0, char_literal41_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:411:8: ( pointcutActorBodyDecls[$element] )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==40||LA25_0==49||(LA25_0 >= 56 && LA25_0 <= 57)||LA25_0==59||LA25_0==63||LA25_0==65) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:411:8: pointcutActorBodyDecls[$element]
            	    {
            	    pushFollow(FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1049);
            	    pointcutActorBodyDecls42=pointcutActorBodyDecls(retval.element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorBodyDecls42.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            char_literal43=(Token)match(input,77,FOLLOW_77_in_pointcutActorBody1053); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal43_tree = 
            (Object)adaptor.create(char_literal43)
            ;
            adaptor.addChild(root_0, char_literal43_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, pointcutActorBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutActorBody"


    public static class pointcutActorBodyDecls_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutActorBodyDecls"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:415:1: pointcutActorBodyDecls[Actor actor] : (override= overrideOrExtend )? (kw= 'interface' ':' |kw= 'component' ':' |kw= 'application' ':' |kw= 'instance' ':' |kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' ;
    public final MViewParser.pointcutActorBodyDecls_return pointcutActorBodyDecls(Actor actor) throws RecognitionException {
        MViewParser.pointcutActorBodyDecls_return retval = new MViewParser.pointcutActorBodyDecls_return();
        retval.start = input.LT(1);

        int pointcutActorBodyDecls_StartIndex = input.index();

        Object root_0 = null;

        Token kw=null;
        Token char_literal44=null;
        Token char_literal45=null;
        Token char_literal46=null;
        Token char_literal47=null;
        Token char_literal48=null;
        Token char_literal50=null;
        MViewParser.overrideOrExtend_return override =null;

        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls49 =null;


        Object kw_tree=null;
        Object char_literal44_tree=null;
        Object char_literal45_tree=null;
        Object char_literal46_tree=null;
        Object char_literal47_tree=null;
        Object char_literal48_tree=null;
        Object char_literal50_tree=null;


        	ActorProp prop = null;
        	Token propKw = null;
        	Class<? extends Declaration> declClass = null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:421:2: ( (override= overrideOrExtend )? (kw= 'interface' ':' |kw= 'component' ':' |kw= 'application' ':' |kw= 'instance' ':' |kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:421:4: (override= overrideOrExtend )? (kw= 'interface' ':' |kw= 'component' ':' |kw= 'application' ':' |kw= 'instance' ':' |kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';'
            {
            root_0 = (Object)adaptor.nil();


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:421:4: (override= overrideOrExtend )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==63||LA26_0==65) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:421:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1074);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:422:2: (kw= 'interface' ':' |kw= 'component' ':' |kw= 'application' ':' |kw= 'instance' ':' |kw= 'host' ':' )
            int alt27=5;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt27=1;
                }
                break;
            case 49:
                {
                alt27=2;
                }
                break;
            case 40:
                {
                alt27=3;
                }
                break;
            case 57:
                {
                alt27=4;
                }
                break;
            case 56:
                {
                alt27=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }

            switch (alt27) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:423:3: kw= 'interface' ':'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_pointcutActorBodyDecls1085); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = 
                    (Object)adaptor.create(kw)
                    ;
                    adaptor.addChild(root_0, kw_tree);
                    }

                    char_literal44=(Token)match(input,29,FOLLOW_29_in_pointcutActorBodyDecls1087); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal44_tree = 
                    (Object)adaptor.create(char_literal44)
                    ;
                    adaptor.addChild(root_0, char_literal44_tree);
                    }

                    if ( state.backtracking==0 ) {
                    			declClass = Interface.class;
                    			propKw = kw;
                    		}

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:428:3: kw= 'component' ':'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_pointcutActorBodyDecls1099); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = 
                    (Object)adaptor.create(kw)
                    ;
                    adaptor.addChild(root_0, kw_tree);
                    }

                    char_literal45=(Token)match(input,29,FOLLOW_29_in_pointcutActorBodyDecls1101); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = 
                    (Object)adaptor.create(char_literal45)
                    ;
                    adaptor.addChild(root_0, char_literal45_tree);
                    }

                    if ( state.backtracking==0 ) {
                    			declClass = Component.class;
                    			propKw = kw;
                    		}

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:433:3: kw= 'application' ':'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_pointcutActorBodyDecls1112); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = 
                    (Object)adaptor.create(kw)
                    ;
                    adaptor.addChild(root_0, kw_tree);
                    }

                    char_literal46=(Token)match(input,29,FOLLOW_29_in_pointcutActorBodyDecls1114); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal46_tree = 
                    (Object)adaptor.create(char_literal46)
                    ;
                    adaptor.addChild(root_0, char_literal46_tree);
                    }

                    if ( state.backtracking==0 ) {
                    			declClass = Application.class;
                    			propKw = kw;
                    		}

                    }
                    break;
                case 4 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:438:3: kw= 'instance' ':'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_pointcutActorBodyDecls1125); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = 
                    (Object)adaptor.create(kw)
                    ;
                    adaptor.addChild(root_0, kw_tree);
                    }

                    char_literal47=(Token)match(input,29,FOLLOW_29_in_pointcutActorBodyDecls1127); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal47_tree = 
                    (Object)adaptor.create(char_literal47)
                    ;
                    adaptor.addChild(root_0, char_literal47_tree);
                    }

                    if ( state.backtracking==0 ) {
                    			declClass = Instance.class;
                    			propKw = kw;
                    		}

                    }
                    break;
                case 5 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:443:3: kw= 'host' ':'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_pointcutActorBodyDecls1138); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = 
                    (Object)adaptor.create(kw)
                    ;
                    adaptor.addChild(root_0, kw_tree);
                    }

                    char_literal48=(Token)match(input,29,FOLLOW_29_in_pointcutActorBodyDecls1140); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal48_tree = 
                    (Object)adaptor.create(char_literal48)
                    ;
                    adaptor.addChild(root_0, char_literal48_tree);
                    }

                    if ( state.backtracking==0 ) {
                    			declClass = Host.class;
                    			propKw = kw;
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		prop = new ActorProp(new PropModifier(declClass));
            		setKeyword(prop,propKw);
            		actor.addProp(prop);
            		if ((override!=null?override.value:null) != null) {
            			prop.addModifier((override!=null?override.value:null));
            		}
            		
            	}

            pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1149);
            pointcutActorPropDecls49=pointcutActorPropDecls(prop, declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls49.getTree());

            char_literal50=(Token)match(input,30,FOLLOW_30_in_pointcutActorBodyDecls1152); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal50_tree = 
            (Object)adaptor.create(char_literal50)
            ;
            adaptor.addChild(root_0, char_literal50_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, pointcutActorBodyDecls_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutActorBodyDecls"


    public static class pointcutActorPropDecls_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutActorPropDecls"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:459:1: pointcutActorPropDecls[ActorProp prop,Class<? extends Declaration> declClass] : (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? ;
    public final MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls(ActorProp prop, Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecls_return retval = new MViewParser.pointcutActorPropDecls_return();
        retval.start = input.LT(1);

        int pointcutActorPropDecls_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal51=null;
        MViewParser.negationModifier_return negate =null;

        MViewParser.pointcutActorPropDecl_return apdref =null;

        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls52 =null;


        Object char_literal51_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:460:2: ( (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:460:5: (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            {
            root_0 = (Object)adaptor.nil();


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:460:5: (negate= negationModifier )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==23) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:460:6: negate= negationModifier
                    {
                    pushFollow(FOLLOW_negationModifier_in_pointcutActorPropDecls1169);
                    negate=negationModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, negate.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1175);
            apdref=pointcutActorPropDecl(declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, apdref.getTree());

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:460:73: ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==27) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:460:75: ',' pointcutActorPropDecls[$prop,$declClass]
                    {
                    char_literal51=(Token)match(input,27,FOLLOW_27_in_pointcutActorPropDecls1180); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal51_tree = 
                    (Object)adaptor.create(char_literal51)
                    ;
                    adaptor.addChild(root_0, char_literal51_tree);
                    }

                    pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1182);
                    pointcutActorPropDecls52=pointcutActorPropDecls(prop, declClass);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls52.getTree());

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			PropValue propValue = new PropValue((apdref!=null?apdref.relation:null));
            			
            			if ((negate!=null?negate.value:null) != null) {
            				propValue.addModifier((negate!=null?negate.value:null));
            			}

            			prop.addPropValue(propValue);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, pointcutActorPropDecls_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutActorPropDecls"


    public static class pointcutActorPropDecl_return extends ParserRuleReturnScope {
        public SimpleReference<? extends Declaration> relation;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointcutActorPropDecl"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:471:1: pointcutActorPropDecl[Class<? extends Declaration> declClass] returns [SimpleReference<? extends Declaration> relation] : name= Identifier ;
    public final MViewParser.pointcutActorPropDecl_return pointcutActorPropDecl(Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecl_return retval = new MViewParser.pointcutActorPropDecl_return();
        retval.start = input.LT(1);

        int pointcutActorPropDecl_StartIndex = input.index();

        Object root_0 = null;

        Token name=null;

        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:472:2: (name= Identifier )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:472:5: name= Identifier
            {
            root_0 = (Object)adaptor.nil();


            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutActorPropDecl1207); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            if ( state.backtracking==0 ) {
            			retval.relation = new SimpleReference((name!=null?name.getText():null),declClass);
            			setLocation(retval.relation, name, name);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, pointcutActorPropDecl_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "pointcutActorPropDecl"


    public static class adviceDeclaration_return extends ParserRuleReturnScope {
        public Advice advice;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "adviceDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:480:1: adviceDeclaration returns [Advice advice] : avkw= 'advice' adviceBody[$advice] ;
    public final MViewParser.adviceDeclaration_return adviceDeclaration() throws RecognitionException {
        MViewParser.adviceDeclaration_return retval = new MViewParser.adviceDeclaration_return();
        retval.start = input.LT(1);

        int adviceDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token avkw=null;
        MViewParser.adviceBody_return adviceBody53 =null;


        Object avkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:481:2: (avkw= 'advice' adviceBody[$advice] )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:481:4: avkw= 'advice' adviceBody[$advice]
            {
            root_0 = (Object)adaptor.nil();


            avkw=(Token)match(input,37,FOLLOW_37_in_adviceDeclaration1230); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            avkw_tree = 
            (Object)adaptor.create(avkw)
            ;
            adaptor.addChild(root_0, avkw_tree);
            }

            if ( state.backtracking==0 ) { 
            			retval.advice = new Advice();
            			setKeyword(retval.advice,avkw);
            		}

            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration1234);
            adviceBody53=adviceBody(retval.advice);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBody53.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 33, adviceDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "adviceDeclaration"


    public static class adviceBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "adviceBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:488:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
    public final MViewParser.adviceBody_return adviceBody(Advice advice) throws RecognitionException {
        MViewParser.adviceBody_return retval = new MViewParser.adviceBody_return();
        retval.start = input.LT(1);

        int adviceBody_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal54=null;
        Token char_literal56=null;
        MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration55 =null;


        Object char_literal54_tree=null;
        Object char_literal56_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:489:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:489:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
            {
            root_0 = (Object)adaptor.nil();


            char_literal54=(Token)match(input,76,FOLLOW_76_in_adviceBody1249); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal54_tree = 
            (Object)adaptor.create(char_literal54)
            ;
            adaptor.addChild(root_0, char_literal54_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:489:8: ( adviceBodyDeclaration[$advice] )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==57||LA30_0==70||LA30_0==74) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:489:8: adviceBodyDeclaration[$advice]
            	    {
            	    pushFollow(FOLLOW_adviceBodyDeclaration_in_adviceBody1251);
            	    adviceBodyDeclaration55=adviceBodyDeclaration(advice);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBodyDeclaration55.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            char_literal56=(Token)match(input,77,FOLLOW_77_in_adviceBody1255); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal56_tree = 
            (Object)adaptor.create(char_literal56)
            ;
            adaptor.addChild(root_0, char_literal56_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 34, adviceBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "adviceBody"


    public static class adviceBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "adviceBodyDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:493:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] | adviceInstanceDeclaration[$advice] );
    public final MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceBodyDeclaration_return retval = new MViewParser.adviceBodyDeclaration_return();
        retval.start = input.LT(1);

        int adviceBodyDeclaration_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration57 =null;

        MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration58 =null;

        MViewParser.adviceInstanceDeclaration_return adviceInstanceDeclaration59 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:494:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] | adviceInstanceDeclaration[$advice] )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt31=1;
                }
                break;
            case 74:
                {
                alt31=2;
                }
                break;
            case 57:
                {
                alt31=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:494:4: adviceServiceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1270);
                    adviceServiceDeclaration57=adviceServiceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceServiceDeclaration57.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:495:4: adviceTypeDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1276);
                    adviceTypeDeclaration58=adviceTypeDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceTypeDeclaration58.getTree());

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:496:4: adviceInstanceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_adviceInstanceDeclaration_in_adviceBodyDeclaration1282);
                    adviceInstanceDeclaration59=adviceInstanceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceInstanceDeclaration59.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 35, adviceBodyDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "adviceBodyDeclaration"


    public static class adviceServiceDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "adviceServiceDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:500:1: adviceServiceDeclaration[Advice advice] : svkw= 'service' ':' service= serviceReferenceDeclaration ';' ;
    public final MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceServiceDeclaration_return retval = new MViewParser.adviceServiceDeclaration_return();
        retval.start = input.LT(1);

        int adviceServiceDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token svkw=null;
        Token char_literal60=null;
        Token char_literal61=null;
        MViewParser.serviceReferenceDeclaration_return service =null;


        Object svkw_tree=null;
        Object char_literal60_tree=null;
        Object char_literal61_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:501:2: (svkw= 'service' ':' service= serviceReferenceDeclaration ';' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:501:4: svkw= 'service' ':' service= serviceReferenceDeclaration ';'
            {
            root_0 = (Object)adaptor.nil();


            svkw=(Token)match(input,70,FOLLOW_70_in_adviceServiceDeclaration1300); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            svkw_tree = 
            (Object)adaptor.create(svkw)
            ;
            adaptor.addChild(root_0, svkw_tree);
            }

            char_literal60=(Token)match(input,29,FOLLOW_29_in_adviceServiceDeclaration1302); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal60_tree = 
            (Object)adaptor.create(char_literal60)
            ;
            adaptor.addChild(root_0, char_literal60_tree);
            }

            pushFollow(FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1306);
            service=serviceReferenceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());

            char_literal61=(Token)match(input,30,FOLLOW_30_in_adviceServiceDeclaration1308); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal61_tree = 
            (Object)adaptor.create(char_literal61)
            ;
            adaptor.addChild(root_0, char_literal61_tree);
            }

            if ( state.backtracking==0 ) {
            			advice.setService((service!=null?service.relation:null));
            			setKeyword((service!=null?service.relation:null),svkw);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 36, adviceServiceDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "adviceServiceDeclaration"


    public static class adviceTypeDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "adviceTypeDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:508:1: adviceTypeDeclaration[Advice advice] : tpkw= 'type' ':' avtype= adviceType ';' ;
    public final MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceTypeDeclaration_return retval = new MViewParser.adviceTypeDeclaration_return();
        retval.start = input.LT(1);

        int adviceTypeDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token tpkw=null;
        Token char_literal62=null;
        Token char_literal63=null;
        MViewParser.adviceType_return avtype =null;


        Object tpkw_tree=null;
        Object char_literal62_tree=null;
        Object char_literal63_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:509:2: (tpkw= 'type' ':' avtype= adviceType ';' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:509:4: tpkw= 'type' ':' avtype= adviceType ';'
            {
            root_0 = (Object)adaptor.nil();


            tpkw=(Token)match(input,74,FOLLOW_74_in_adviceTypeDeclaration1327); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tpkw_tree = 
            (Object)adaptor.create(tpkw)
            ;
            adaptor.addChild(root_0, tpkw_tree);
            }

            char_literal62=(Token)match(input,29,FOLLOW_29_in_adviceTypeDeclaration1329); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal62_tree = 
            (Object)adaptor.create(char_literal62)
            ;
            adaptor.addChild(root_0, char_literal62_tree);
            }

            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration1333);
            avtype=adviceType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, avtype.getTree());

            char_literal63=(Token)match(input,30,FOLLOW_30_in_adviceTypeDeclaration1335); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal63_tree = 
            (Object)adaptor.create(char_literal63)
            ;
            adaptor.addChild(root_0, char_literal63_tree);
            }

            if ( state.backtracking==0 ) {
            			advice.addModifier((avtype!=null?avtype.value:null));
            			setKeyword((avtype!=null?avtype.value:null),tpkw);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 37, adviceTypeDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "adviceTypeDeclaration"


    public static class adviceInstanceDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "adviceInstanceDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:515:1: adviceInstanceDeclaration[Advice advice] : inskw= 'instance' ':' instance= instanceReferenceDeclaration ';' ;
    public final MViewParser.adviceInstanceDeclaration_return adviceInstanceDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceInstanceDeclaration_return retval = new MViewParser.adviceInstanceDeclaration_return();
        retval.start = input.LT(1);

        int adviceInstanceDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token inskw=null;
        Token char_literal64=null;
        Token char_literal65=null;
        MViewParser.instanceReferenceDeclaration_return instance =null;


        Object inskw_tree=null;
        Object char_literal64_tree=null;
        Object char_literal65_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:516:2: (inskw= 'instance' ':' instance= instanceReferenceDeclaration ';' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:516:4: inskw= 'instance' ':' instance= instanceReferenceDeclaration ';'
            {
            root_0 = (Object)adaptor.nil();


            inskw=(Token)match(input,57,FOLLOW_57_in_adviceInstanceDeclaration1351); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            inskw_tree = 
            (Object)adaptor.create(inskw)
            ;
            adaptor.addChild(root_0, inskw_tree);
            }

            char_literal64=(Token)match(input,29,FOLLOW_29_in_adviceInstanceDeclaration1353); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = 
            (Object)adaptor.create(char_literal64)
            ;
            adaptor.addChild(root_0, char_literal64_tree);
            }

            pushFollow(FOLLOW_instanceReferenceDeclaration_in_adviceInstanceDeclaration1357);
            instance=instanceReferenceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, instance.getTree());

            char_literal65=(Token)match(input,30,FOLLOW_30_in_adviceInstanceDeclaration1359); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = 
            (Object)adaptor.create(char_literal65)
            ;
            adaptor.addChild(root_0, char_literal65_tree);
            }

            if ( state.backtracking==0 ) {
            			advice.setInstance((instance!=null?instance.relation:null));
            			setKeyword((instance!=null?instance.relation:null),inskw);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 38, adviceInstanceDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "adviceInstanceDeclaration"


    public static class instanceReferenceDeclaration_return extends ParserRuleReturnScope {
        public SimpleReference<Instance> relation;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "instanceReferenceDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:522:1: instanceReferenceDeclaration returns [SimpleReference<Instance> relation] : name= Identifier ;
    public final MViewParser.instanceReferenceDeclaration_return instanceReferenceDeclaration() throws RecognitionException {
        MViewParser.instanceReferenceDeclaration_return retval = new MViewParser.instanceReferenceDeclaration_return();
        retval.start = input.LT(1);

        int instanceReferenceDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token name=null;

        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:523:2: (name= Identifier )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:523:5: name= Identifier
            {
            root_0 = (Object)adaptor.nil();


            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceReferenceDeclaration1380); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            if ( state.backtracking==0 ) {
            			retval.relation = new SimpleReference((name!=null?name.getText():null),Instance.class);
            			setLocation(retval.relation, name, name);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 39, instanceReferenceDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "instanceReferenceDeclaration"


    public static class componentDeclaration_return extends ParserRuleReturnScope {
        public Component element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "componentDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:534:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier componentBody[$element] ;
    public final MViewParser.componentDeclaration_return componentDeclaration() throws RecognitionException {
        MViewParser.componentDeclaration_return retval = new MViewParser.componentDeclaration_return();
        retval.start = input.LT(1);

        int componentDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token compkw=null;
        Token name=null;
        MViewParser.componentBody_return componentBody66 =null;


        Object compkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:535:2: (compkw= 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:535:5: compkw= 'component' name= Identifier componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();


            compkw=(Token)match(input,49,FOLLOW_49_in_componentDeclaration1407); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            compkw_tree = 
            (Object)adaptor.create(compkw)
            ;
            adaptor.addChild(root_0, compkw_tree);
            }

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration1411); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            if ( state.backtracking==0 ) {
               			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
               			setKeyword(retval.element,compkw);
               			setLocation(retval.element,name,"__NAME");
            		}

            pushFollow(FOLLOW_componentBody_in_componentDeclaration1415);
            componentBody66=componentBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBody66.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 40, componentDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "componentDeclaration"


    public static class componentBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "componentBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:543:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
    public final MViewParser.componentBody_return componentBody(Component element) throws RecognitionException {
        MViewParser.componentBody_return retval = new MViewParser.componentBody_return();
        retval.start = input.LT(1);

        int componentBody_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal67=null;
        Token char_literal69=null;
        MViewParser.componentBodyDeclaration_return componentBodyDeclaration68 =null;


        Object char_literal67_tree=null;
        Object char_literal69_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:544:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:544:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();


            char_literal67=(Token)match(input,76,FOLLOW_76_in_componentBody1437); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal67_tree = 
            (Object)adaptor.create(char_literal67)
            ;
            adaptor.addChild(root_0, char_literal67_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:544:8: ( componentBodyDeclaration[$element] )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==67||LA32_0==69) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:544:8: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody1439);
            	    componentBodyDeclaration68=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration68.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            char_literal69=(Token)match(input,77,FOLLOW_77_in_componentBody1443); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal69_tree = 
            (Object)adaptor.create(char_literal69)
            ;
            adaptor.addChild(root_0, char_literal69_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 41, componentBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "componentBody"


    public static class componentBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "componentBodyDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:548:1: componentBodyDeclaration[Component element] : ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] );
    public final MViewParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MViewParser.componentBodyDeclaration_return retval = new MViewParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);

        int componentBodyDeclaration_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration70 =null;

        MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration71 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:549:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==69) ) {
                alt33=1;
            }
            else if ( (LA33_0==67) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:549:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1461);
                    moduleRequireDependencyDeclaration70=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration70.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:550:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1467);
                    moduleProvideDependencyDeclaration71=moduleProvideDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleProvideDependencyDeclaration71.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 42, componentBodyDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "componentBodyDeclaration"


    public static class moduleDependencyBody_return extends ParserRuleReturnScope {
        public List<SimpleReference> elements;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "moduleDependencyBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:560:1: moduleDependencyBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' ;
    public final MViewParser.moduleDependencyBody_return moduleDependencyBody() throws RecognitionException {
        MViewParser.moduleDependencyBody_return retval = new MViewParser.moduleDependencyBody_return();
        retval.start = input.LT(1);

        int moduleDependencyBody_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal72=null;
        Token char_literal73=null;
        MViewParser.commaSeparatedBodyDecls_return decls =null;


        Object char_literal72_tree=null;
        Object char_literal73_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:562:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:562:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();


            char_literal72=(Token)match(input,76,FOLLOW_76_in_moduleDependencyBody1495); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal72_tree = 
            (Object)adaptor.create(char_literal72)
            ;
            adaptor.addChild(root_0, char_literal72_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:562:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==Identifier) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:562:9: decls= commaSeparatedBodyDecls[Interface.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1500);
                    decls=commaSeparatedBodyDecls(Interface.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());

                    if ( state.backtracking==0 ) {retval.elements =(decls!=null?decls.elements:null); }

                    }
                    break;

            }


            char_literal73=(Token)match(input,77,FOLLOW_77_in_moduleDependencyBody1508); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal73_tree = 
            (Object)adaptor.create(char_literal73)
            ;
            adaptor.addChild(root_0, char_literal73_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 43, moduleDependencyBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "moduleDependencyBody"


    public static class moduleRequireDependencyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "moduleRequireDependencyDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:566:1: moduleRequireDependencyDeclaration[Module element] : rekw= 'require' rd= moduleDependencyBody ;
    public final MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration(Module element) throws RecognitionException {
        MViewParser.moduleRequireDependencyDeclaration_return retval = new MViewParser.moduleRequireDependencyDeclaration_return();
        retval.start = input.LT(1);

        int moduleRequireDependencyDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token rekw=null;
        MViewParser.moduleDependencyBody_return rd =null;


        Object rekw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:567:2: (rekw= 'require' rd= moduleDependencyBody )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:567:4: rekw= 'require' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();


            rekw=(Token)match(input,69,FOLLOW_69_in_moduleRequireDependencyDeclaration1525); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rekw_tree = 
            (Object)adaptor.create(rekw)
            ;
            adaptor.addChild(root_0, rekw_tree);
            }

            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1529);
            rd=moduleDependencyBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rd.getTree());

            if ( state.backtracking==0 ) {
            			for(SimpleReference iface : (rd!=null?rd.elements:null) ) {
            				element.addRequiredInterface(iface);
            			}
            		 }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 44, moduleRequireDependencyDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "moduleRequireDependencyDeclaration"


    public static class moduleProvideDependencyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "moduleProvideDependencyDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:575:1: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
    public final MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration(Module element) throws RecognitionException {
        MViewParser.moduleProvideDependencyDeclaration_return retval = new MViewParser.moduleProvideDependencyDeclaration_return();
        retval.start = input.LT(1);

        int moduleProvideDependencyDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token string_literal74=null;
        MViewParser.moduleDependencyBody_return rd =null;


        Object string_literal74_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:576:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:576:4: 'provide' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();


            string_literal74=(Token)match(input,67,FOLLOW_67_in_moduleProvideDependencyDeclaration1544); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal74_tree = 
            (Object)adaptor.create(string_literal74)
            ;
            adaptor.addChild(root_0, string_literal74_tree);
            }

            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1548);
            rd=moduleDependencyBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rd.getTree());

            if ( state.backtracking==0 ) {
            			for(SimpleReference iface : (rd!=null?rd.elements:null) ) {		
            				element.addProvidedInterface(iface);
            			}
            		 }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 45, moduleProvideDependencyDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "moduleProvideDependencyDeclaration"


    public static class applicationDeclaration_return extends ParserRuleReturnScope {
        public Application element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "applicationDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:615:1: applicationDeclaration returns [Application element] : (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] ;
    public final MViewParser.applicationDeclaration_return applicationDeclaration() throws RecognitionException {
        MViewParser.applicationDeclaration_return retval = new MViewParser.applicationDeclaration_return();
        retval.start = input.LT(1);

        int applicationDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token appkw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs =null;

        MViewParser.refinementDeclaration_return refinementDeclaration75 =null;

        MViewParser.applicationBody_return applicationBody76 =null;


        Object appkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:616:2: ( (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:616:4: (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:616:4: (abs= abstractModifier )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==36) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:616:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_applicationDeclaration1581);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }


            appkw=(Token)match(input,40,FOLLOW_40_in_applicationDeclaration1587); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = 
            (Object)adaptor.create(appkw)
            ;
            adaptor.addChild(root_0, appkw_tree);
            }

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_applicationDeclaration1591); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            if ( state.backtracking==0 ) {
            			retval.element = new Application(new SimpleNameSignature((name!=null?name.getText():null)));
            			
            			if ((abs!=null?abs.value:null) != null) {
            				retval.element.addModifier((abs!=null?abs.value:null));
            			}

            			setKeyword(retval.element,appkw);
               			setLocation(retval.element,name,"__NAME");
            		}

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:626:3: ( refinementDeclaration[$element,Application.class] )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==68) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:626:4: refinementDeclaration[$element,Application.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_applicationDeclaration1599);
                    refinementDeclaration75=refinementDeclaration(retval.element, Application.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration75.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_applicationBody_in_applicationDeclaration1606);
            applicationBody76=applicationBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBody76.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 46, applicationDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "applicationDeclaration"


    public static class applicationBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "applicationBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:631:1: applicationBody[Application element] : '{' ( applicationBodyDeclaration[$element] )* '}' ;
    public final MViewParser.applicationBody_return applicationBody(Application element) throws RecognitionException {
        MViewParser.applicationBody_return retval = new MViewParser.applicationBody_return();
        retval.start = input.LT(1);

        int applicationBody_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal77=null;
        Token char_literal79=null;
        MViewParser.applicationBodyDeclaration_return applicationBodyDeclaration78 =null;


        Object char_literal77_tree=null;
        Object char_literal79_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:632:2: ( '{' ( applicationBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:632:4: '{' ( applicationBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();


            char_literal77=(Token)match(input,76,FOLLOW_76_in_applicationBody1620); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal77_tree = 
            (Object)adaptor.create(char_literal77)
            ;
            adaptor.addChild(root_0, char_literal77_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:632:8: ( applicationBodyDeclaration[$element] )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==Identifier||LA37_0==36||(LA37_0 >= 49 && LA37_0 <= 50)||LA37_0==56) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:632:10: applicationBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_applicationBodyDeclaration_in_applicationBody1624);
            	    applicationBodyDeclaration78=applicationBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBodyDeclaration78.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            char_literal79=(Token)match(input,77,FOLLOW_77_in_applicationBody1630); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal79_tree = 
            (Object)adaptor.create(char_literal79)
            ;
            adaptor.addChild(root_0, char_literal79_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 47, applicationBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "applicationBody"


    public static class applicationBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "applicationBodyDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:636:1: applicationBodyDeclaration[Application element] : (mod= moduleContainerDeclarations |hod= hostDeclaration |ind= instanceDeclaration );
    public final MViewParser.applicationBodyDeclaration_return applicationBodyDeclaration(Application element) throws RecognitionException {
        MViewParser.applicationBodyDeclaration_return retval = new MViewParser.applicationBodyDeclaration_return();
        retval.start = input.LT(1);

        int applicationBodyDeclaration_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.moduleContainerDeclarations_return mod =null;

        MViewParser.hostDeclaration_return hod =null;

        MViewParser.instanceDeclaration_return ind =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:637:2: (mod= moduleContainerDeclarations |hod= hostDeclaration |ind= instanceDeclaration )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 36:
            case 49:
            case 50:
                {
                alt38=1;
                }
                break;
            case 56:
                {
                alt38=2;
                }
                break;
            case Identifier:
                {
                alt38=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:637:4: mod= moduleContainerDeclarations
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1646);
                    mod=moduleContainerDeclarations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod.getTree());

                    if ( state.backtracking==0 ) {
                    			element.addModule((mod!=null?mod.element:null));
                    		}

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:641:3: hod= hostDeclaration
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_hostDeclaration_in_applicationBodyDeclaration1657);
                    hod=hostDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hod.getTree());

                    if ( state.backtracking==0 ) {
                    			element.addHost((hod!=null?hod.element:null));
                    		}

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:645:3: ind= instanceDeclaration
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1669);
                    ind=instanceDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ind.getTree());

                    if ( state.backtracking==0 ) {
                    			element.addInstance((ind!=null?ind.element:null)); 
                    		}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 48, applicationBodyDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "applicationBodyDeclaration"


    public static class instanceDeclaration_return extends ParserRuleReturnScope {
        public Instance element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "instanceDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:676:1: instanceDeclaration returns [Instance element] : tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';' ;
    public final MViewParser.instanceDeclaration_return instanceDeclaration() throws RecognitionException {
        MViewParser.instanceDeclaration_return retval = new MViewParser.instanceDeclaration_return();
        retval.start = input.LT(1);

        int instanceDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token tpe=null;
        Token name=null;
        Token onkw=null;
        Token hst=null;
        Token char_literal80=null;

        Object tpe_tree=null;
        Object name_tree=null;
        Object onkw_tree=null;
        Object hst_tree=null;
        Object char_literal80_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:677:2: (tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:677:4: tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';'
            {
            root_0 = (Object)adaptor.nil();


            tpe=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1701); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tpe_tree = 
            (Object)adaptor.create(tpe)
            ;
            adaptor.addChild(root_0, tpe_tree);
            }

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1705); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            onkw=(Token)match(input,64,FOLLOW_64_in_instanceDeclaration1709); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            onkw_tree = 
            (Object)adaptor.create(onkw)
            ;
            adaptor.addChild(root_0, onkw_tree);
            }

            hst=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1713); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hst_tree = 
            (Object)adaptor.create(hst)
            ;
            adaptor.addChild(root_0, hst_tree);
            }

            char_literal80=(Token)match(input,30,FOLLOW_30_in_instanceDeclaration1715); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal80_tree = 
            (Object)adaptor.create(char_literal80)
            ;
            adaptor.addChild(root_0, char_literal80_tree);
            }

            if ( state.backtracking==0 ) {
            	
            			retval.element = new Instance(new SimpleNameSignature((name!=null?name.getText():null)));
            			setLocation(retval.element,name,"__NAME");

            			SimpleReference<Module> modRelation = new SimpleReference<Module>((tpe!=null?tpe.getText():null),Module.class);
            			if (modRelation != null) {
            				retval.element.setType(modRelation);
            				setLocation(modRelation,tpe,tpe);
            			}
            			
            			SimpleReference<Host> hostRelation = new SimpleReference<Host>((hst!=null?hst.getText():null),Host.class);
            			if (hostRelation != null) {
            				retval.element.setHost(hostRelation);
            				setLocation(hostRelation,hst,hst);
            				setKeyword(hostRelation,onkw);
            			}
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 49, instanceDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "instanceDeclaration"


    public static class hostDeclaration_return extends ParserRuleReturnScope {
        public Host element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hostDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:703:1: hostDeclaration returns [Host element] : hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';' ;
    public final MViewParser.hostDeclaration_return hostDeclaration() throws RecognitionException {
        MViewParser.hostDeclaration_return retval = new MViewParser.hostDeclaration_return();
        retval.start = input.LT(1);

        int hostDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token hkw=null;
        Token name=null;
        Token onkw=null;
        Token value=null;
        Token char_literal81=null;

        Object hkw_tree=null;
        Object name_tree=null;
        Object onkw_tree=null;
        Object value_tree=null;
        Object char_literal81_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:704:2: (hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:704:5: hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';'
            {
            root_0 = (Object)adaptor.nil();


            hkw=(Token)match(input,56,FOLLOW_56_in_hostDeclaration1742); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hkw_tree = 
            (Object)adaptor.create(hkw)
            ;
            adaptor.addChild(root_0, hkw_tree);
            }

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_hostDeclaration1746); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            if ( state.backtracking==0 ) {
            			
            			retval.element = new Host(new SimpleNameSignature((name!=null?name.getText():null)));
            			setKeyword(retval.element,hkw);
            			setLocation(retval.element,name,"__NAME");
            			
            		}

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:710:5: (onkw= 'is' value= StringLiteral )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==60) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:710:7: onkw= 'is' value= StringLiteral
                    {
                    onkw=(Token)match(input,60,FOLLOW_60_in_hostDeclaration1754); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    onkw_tree = 
                    (Object)adaptor.create(onkw)
                    ;
                    adaptor.addChild(root_0, onkw_tree);
                    }

                    value=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_hostDeclaration1758); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    value_tree = 
                    (Object)adaptor.create(value)
                    ;
                    adaptor.addChild(root_0, value_tree);
                    }

                    if ( state.backtracking==0 ) {
                    			
                    			HostName hostName = new HostName(new SimpleNameSignature((value!=null?value.getText():null)));
                    			retval.element.setHostName(hostName);
                    			setKeyword(hostName,onkw);
                    			
                    		}

                    }
                    break;

            }


            char_literal81=(Token)match(input,30,FOLLOW_30_in_hostDeclaration1765); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal81_tree = 
            (Object)adaptor.create(char_literal81)
            ;
            adaptor.addChild(root_0, char_literal81_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 50, hostDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "hostDeclaration"


    public static class moduleContainerDeclarations_return extends ParserRuleReturnScope {
        public Module element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "moduleContainerDeclarations"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:725:1: moduleContainerDeclarations returns [Module element] : (cod= componentDeclaration |cnd= connectorDeclaration );
    public final MViewParser.moduleContainerDeclarations_return moduleContainerDeclarations() throws RecognitionException {
        MViewParser.moduleContainerDeclarations_return retval = new MViewParser.moduleContainerDeclarations_return();
        retval.start = input.LT(1);

        int moduleContainerDeclarations_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.componentDeclaration_return cod =null;

        MViewParser.connectorDeclaration_return cnd =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:726:2: (cod= componentDeclaration |cnd= connectorDeclaration )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==49) ) {
                alt40=1;
            }
            else if ( (LA40_0==36||LA40_0==50) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }
            switch (alt40) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:727:3: cod= componentDeclaration
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_componentDeclaration_in_moduleContainerDeclarations1791);
                    cod=componentDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cod.getTree());

                    if ( state.backtracking==0 ) {
                    			retval.element = (cod!=null?cod.element:null);
                    		}

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:731:3: cnd= connectorDeclaration
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1802);
                    cnd=connectorDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cnd.getTree());

                    if ( state.backtracking==0 ) {
                    			retval.element = (cnd!=null?cnd.element:null);
                    		}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 51, moduleContainerDeclarations_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "moduleContainerDeclarations"


    public static class refinementDeclarationSingle_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "refinementDeclarationSingle"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:758:1: refinementDeclarationSingle[RefinableDeclaration element, Class kind] : rfkw= 'refines' rel= refinementDeclarationBody[$kind] ;
    public final MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementDeclarationSingle_return retval = new MViewParser.refinementDeclarationSingle_return();
        retval.start = input.LT(1);

        int refinementDeclarationSingle_StartIndex = input.index();

        Object root_0 = null;

        Token rfkw=null;
        MViewParser.refinementDeclarationBody_return rel =null;


        Object rfkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:759:2: (rfkw= 'refines' rel= refinementDeclarationBody[$kind] )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:759:4: rfkw= 'refines' rel= refinementDeclarationBody[$kind]
            {
            root_0 = (Object)adaptor.nil();


            rfkw=(Token)match(input,68,FOLLOW_68_in_refinementDeclarationSingle1827); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rfkw_tree = 
            (Object)adaptor.create(rfkw)
            ;
            adaptor.addChild(root_0, rfkw_tree);
            }

            pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1831);
            rel=refinementDeclarationBody(kind);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rel.getTree());

            if ( state.backtracking==0 ) {
            			setKeyword(rel.relation,rfkw);
            			element.addRefinementRelation(rel.relation);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 52, refinementDeclarationSingle_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "refinementDeclarationSingle"


    public static class refinementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "refinementDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:766:1: refinementDeclaration[RefinableDeclaration element, Class kind] : refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )* ;
    public final MViewParser.refinementDeclaration_return refinementDeclaration(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementDeclaration_return retval = new MViewParser.refinementDeclaration_return();
        retval.start = input.LT(1);

        int refinementDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal83=null;
        MViewParser.refinementDeclarationBody_return rel =null;

        MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle82 =null;


        Object char_literal83_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:767:2: ( refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )* )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:767:4: refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1848);
            refinementDeclarationSingle82=refinementDeclarationSingle(element, kind);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationSingle82.getTree());

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:767:48: ( ',' rel= refinementDeclarationBody[$kind] )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==27) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:767:50: ',' rel= refinementDeclarationBody[$kind]
            	    {
            	    char_literal83=(Token)match(input,27,FOLLOW_27_in_refinementDeclaration1853); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal83_tree = 
            	    (Object)adaptor.create(char_literal83)
            	    ;
            	    adaptor.addChild(root_0, char_literal83_tree);
            	    }

            	    pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclaration1857);
            	    rel=refinementDeclarationBody(kind);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, rel.getTree());

            	    if ( state.backtracking==0 ) {
            	    			element.addRefinementRelation(rel.relation);
            	    		}

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 53, refinementDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "refinementDeclaration"


    public static class refinementDeclarationBody_return extends ParserRuleReturnScope {
        public RefinementRelation relation;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "refinementDeclarationBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:773:1: refinementDeclarationBody[Class kind] returns [RefinementRelation relation] : parent= refinementParentDeclaration[$kind] ;
    public final MViewParser.refinementDeclarationBody_return refinementDeclarationBody(Class kind) throws RecognitionException {
        MViewParser.refinementDeclarationBody_return retval = new MViewParser.refinementDeclarationBody_return();
        retval.start = input.LT(1);

        int refinementDeclarationBody_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.refinementParentDeclaration_return parent =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:774:2: (parent= refinementParentDeclaration[$kind] )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:774:4: parent= refinementParentDeclaration[$kind]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_refinementParentDeclaration_in_refinementDeclarationBody1885);
            parent=refinementParentDeclaration(kind);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, parent.getTree());

            if ( state.backtracking==0 ) {
            			retval.relation = new RefinementRelation(parent.reference);		
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 54, refinementDeclarationBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "refinementDeclarationBody"


    public static class refinementParentDeclaration_return extends ParserRuleReturnScope {
        public SimpleReference reference;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "refinementParentDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:780:1: refinementParentDeclaration[Class kind] returns [SimpleReference reference] : name= Identifier ( '.' namex= Identifier )* ;
    public final MViewParser.refinementParentDeclaration_return refinementParentDeclaration(Class kind) throws RecognitionException {
        MViewParser.refinementParentDeclaration_return retval = new MViewParser.refinementParentDeclaration_return();
        retval.start = input.LT(1);

        int refinementParentDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal84=null;

        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal84_tree=null;

        Token start = null; 
              Token end = null;
              SimpleReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:788:2: (name= Identifier ( '.' namex= Identifier )* )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:788:4: name= Identifier ( '.' namex= Identifier )*
            {
            root_0 = (Object)adaptor.nil();


            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_refinementParentDeclaration1915); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            if ( state.backtracking==0 ) {
            			retval.reference = new SimpleReference((name!=null?name.getText():null),kind);
            			target = new SimpleReference((name!=null?name.getText():null),RefinableDeclaration.class);
            			start = name;
            			end = name;
            		}

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:794:3: ( '.' namex= Identifier )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==28) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:794:4: '.' namex= Identifier
            	    {
            	    char_literal84=(Token)match(input,28,FOLLOW_28_in_refinementParentDeclaration1922); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal84_tree = 
            	    (Object)adaptor.create(char_literal84)
            	    ;
            	    adaptor.addChild(root_0, char_literal84_tree);
            	    }

            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_refinementParentDeclaration1926); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    namex_tree = 
            	    (Object)adaptor.create(namex)
            	    ;
            	    adaptor.addChild(root_0, namex_tree);
            	    }

            	    if ( state.backtracking==0 ) {
            	    				if (target != null) {
            	    //					setLocation($
            	    					retval.reference = new SimpleReference(target,(namex!=null?namex.getText():null),RefinableDeclaration.class);
            	    					target = new SimpleReference(target.clone(),(namex!=null?namex.getText():null),RefinableDeclaration.class);
            	    				} else {
            	    					retval.reference = new SimpleReference((name!=null?name.getText():null),kind);
            	    				}
            	    				//start = namex;
            	    				end = namex;
            	    			}

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              check_null(retval.reference);
              setLocation(retval.reference, start, end);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 55, refinementParentDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "refinementParentDeclaration"


    public static class commaSeparatedBodyDecls_return extends ParserRuleReturnScope {
        public List<SimpleReference> elements;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "commaSeparatedBodyDecls"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:813:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
    public final MViewParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls(Class targetType) throws RecognitionException {
        MViewParser.commaSeparatedBodyDecls_return retval = new MViewParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);

        int commaSeparatedBodyDecls_StartIndex = input.index();

        Object root_0 = null;

        Token id=null;
        Token char_literal85=null;
        MViewParser.commaSeparatedBodyDecls_return decls =null;


        Object id_tree=null;
        Object char_literal85_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:815:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:815:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            {
            root_0 = (Object)adaptor.nil();


            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls1960); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = 
            (Object)adaptor.create(id)
            ;
            adaptor.addChild(root_0, id_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:815:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==27) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:815:19: ',' decls= commaSeparatedBodyDecls[$targetType]
                    {
                    char_literal85=(Token)match(input,27,FOLLOW_27_in_commaSeparatedBodyDecls1963); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal85_tree = 
                    (Object)adaptor.create(char_literal85)
                    ;
                    adaptor.addChild(root_0, char_literal85_tree);
                    }

                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1967);
                    decls=commaSeparatedBodyDecls(targetType);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());

                    if ( state.backtracking==0 ) {retval.elements =(decls!=null?decls.elements:null);}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            			
            			SimpleReference<Interface> relation = new SimpleReference((id!=null?id.getText():null), targetType);
            			retval.elements.add(0,relation);
            			setLocation(relation, id, id);
            		}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 56, commaSeparatedBodyDecls_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "commaSeparatedBodyDecls"


    public static class adviceType_return extends ParserRuleReturnScope {
        public Modifier value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "adviceType"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:829:1: adviceType returns [Modifier value] : ( 'before' | 'after' | 'around' );
    public final MViewParser.adviceType_return adviceType() throws RecognitionException {
        MViewParser.adviceType_return retval = new MViewParser.adviceType_return();
        retval.start = input.LT(1);

        int adviceType_StartIndex = input.index();

        Object root_0 = null;

        Token string_literal86=null;
        Token string_literal87=null;
        Token string_literal88=null;

        Object string_literal86_tree=null;
        Object string_literal87_tree=null;
        Object string_literal88_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:830:2: ( 'before' | 'after' | 'around' )
            int alt44=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt44=1;
                }
                break;
            case 38:
                {
                alt44=2;
                }
                break;
            case 41:
                {
                alt44=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }

            switch (alt44) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:830:4: 'before'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal86=(Token)match(input,42,FOLLOW_42_in_adviceType1996); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal86_tree = 
                    (Object)adaptor.create(string_literal86)
                    ;
                    adaptor.addChild(root_0, string_literal86_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new Before();}

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:831:4: 'after'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal87=(Token)match(input,38,FOLLOW_38_in_adviceType2003); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal87_tree = 
                    (Object)adaptor.create(string_literal87)
                    ;
                    adaptor.addChild(root_0, string_literal87_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new After();}

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:832:4: 'around'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal88=(Token)match(input,41,FOLLOW_41_in_adviceType2010); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal88_tree = 
                    (Object)adaptor.create(string_literal88)
                    ;
                    adaptor.addChild(root_0, string_literal88_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new Around();}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 57, adviceType_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "adviceType"


    public static class joinPointKind_return extends ParserRuleReturnScope {
        public Modifier value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "joinPointKind"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:836:1: joinPointKind returns [Modifier value] : ( 'execution' | 'call' );
    public final MViewParser.joinPointKind_return joinPointKind() throws RecognitionException {
        MViewParser.joinPointKind_return retval = new MViewParser.joinPointKind_return();
        retval.start = input.LT(1);

        int joinPointKind_StartIndex = input.index();

        Object root_0 = null;

        Token string_literal89=null;
        Token string_literal90=null;

        Object string_literal89_tree=null;
        Object string_literal90_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:837:2: ( 'execution' | 'call' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==53) ) {
                alt45=1;
            }
            else if ( (LA45_0==45) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }
            switch (alt45) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:837:4: 'execution'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal89=(Token)match(input,53,FOLLOW_53_in_joinPointKind2030); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = 
                    (Object)adaptor.create(string_literal89)
                    ;
                    adaptor.addChild(root_0, string_literal89_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new Execution();}

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:838:4: 'call'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal90=(Token)match(input,45,FOLLOW_45_in_joinPointKind2037); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = 
                    (Object)adaptor.create(string_literal90)
                    ;
                    adaptor.addChild(root_0, string_literal90_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new Call();}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 58, joinPointKind_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "joinPointKind"


    public static class overrideOrExtend_return extends ParserRuleReturnScope {
        public Modifier value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "overrideOrExtend"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:842:1: overrideOrExtend returns [Modifier value] : (okw= 'override' |ekw= 'merge' );
    public final MViewParser.overrideOrExtend_return overrideOrExtend() throws RecognitionException {
        MViewParser.overrideOrExtend_return retval = new MViewParser.overrideOrExtend_return();
        retval.start = input.LT(1);

        int overrideOrExtend_StartIndex = input.index();

        Object root_0 = null;

        Token okw=null;
        Token ekw=null;

        Object okw_tree=null;
        Object ekw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:843:2: (okw= 'override' |ekw= 'merge' )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==65) ) {
                alt46=1;
            }
            else if ( (LA46_0==63) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:843:4: okw= 'override'
                    {
                    root_0 = (Object)adaptor.nil();


                    okw=(Token)match(input,65,FOLLOW_65_in_overrideOrExtend2059); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    okw_tree = 
                    (Object)adaptor.create(okw)
                    ;
                    adaptor.addChild(root_0, okw_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new Overridable(); setKeyword(retval.value,okw); }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:844:4: ekw= 'merge'
                    {
                    root_0 = (Object)adaptor.nil();


                    ekw=(Token)match(input,63,FOLLOW_63_in_overrideOrExtend2068); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ekw_tree = 
                    (Object)adaptor.create(ekw)
                    ;
                    adaptor.addChild(root_0, ekw_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new Extendable(); setKeyword(retval.value,ekw); }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 59, overrideOrExtend_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "overrideOrExtend"


    public static class negationModifier_return extends ParserRuleReturnScope {
        public Modifier value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "negationModifier"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:848:1: negationModifier returns [Modifier value] : '!' ;
    public final MViewParser.negationModifier_return negationModifier() throws RecognitionException {
        MViewParser.negationModifier_return retval = new MViewParser.negationModifier_return();
        retval.start = input.LT(1);

        int negationModifier_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal91=null;

        Object char_literal91_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:849:2: ( '!' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:849:5: '!'
            {
            root_0 = (Object)adaptor.nil();


            char_literal91=(Token)match(input,23,FOLLOW_23_in_negationModifier2088); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal91_tree = 
            (Object)adaptor.create(char_literal91)
            ;
            adaptor.addChild(root_0, char_literal91_tree);
            }

            if ( state.backtracking==0 ) {retval.value = new Negate(); }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 60, negationModifier_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "negationModifier"


    public static class abstractModifier_return extends ParserRuleReturnScope {
        public Modifier value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "abstractModifier"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:852:1: abstractModifier returns [Modifier value] : akw= 'abstract' ;
    public final MViewParser.abstractModifier_return abstractModifier() throws RecognitionException {
        MViewParser.abstractModifier_return retval = new MViewParser.abstractModifier_return();
        retval.start = input.LT(1);

        int abstractModifier_StartIndex = input.index();

        Object root_0 = null;

        Token akw=null;

        Object akw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:853:2: (akw= 'abstract' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:853:4: akw= 'abstract'
            {
            root_0 = (Object)adaptor.nil();


            akw=(Token)match(input,36,FOLLOW_36_in_abstractModifier2108); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            akw_tree = 
            (Object)adaptor.create(akw)
            ;
            adaptor.addChild(root_0, akw_tree);
            }

            if ( state.backtracking==0 ) {retval.value = new Abstract(); setKeyword(retval.value,akw); }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 61, abstractModifier_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "abstractModifier"


    public static class voidType_return extends ParserRuleReturnScope {
        public BasicTypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "voidType"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:856:1: voidType returns [BasicTypeReference value] : 'void' ;
    public final MViewParser.voidType_return voidType() throws RecognitionException {
        MViewParser.voidType_return retval = new MViewParser.voidType_return();
        retval.start = input.LT(1);

        int voidType_StartIndex = input.index();

        Object root_0 = null;

        Token string_literal92=null;

        Object string_literal92_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:858:5: ( 'void' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:858:7: 'void'
            {
            root_0 = (Object)adaptor.nil();


            string_literal92=(Token)match(input,75,FOLLOW_75_in_voidType2131); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal92_tree = 
            (Object)adaptor.create(string_literal92)
            ;
            adaptor.addChild(root_0, string_literal92_tree);
            }

            if ( state.backtracking==0 ) {retval.value =new BasicTypeReference("void");}

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 62, voidType_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "voidType"


    public static class type_return extends ParserRuleReturnScope {
        public BasicTypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:867:1: type returns [BasicTypeReference value] : (cd= classOrInterfaceType |pt= primitiveType );
    public final MViewParser.type_return type() throws RecognitionException {
        MViewParser.type_return retval = new MViewParser.type_return();
        retval.start = input.LT(1);

        int type_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.classOrInterfaceType_return cd =null;

        MViewParser.primitiveType_return pt =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:869:2: (cd= classOrInterfaceType |pt= primitiveType )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==Identifier) ) {
                alt47=1;
            }
            else if ( ((LA47_0 >= 43 && LA47_0 <= 44)||LA47_0==48||LA47_0==52||LA47_0==55||LA47_0==58||LA47_0==62||LA47_0==71) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }
            switch (alt47) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:869:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_classOrInterfaceType_in_type2163);
                    cd=classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cd.getTree());

                    if ( state.backtracking==0 ) {retval.value = (cd!=null?cd.element:null);}

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:870:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_primitiveType_in_type2172);
                    pt=primitiveType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pt.getTree());

                    if ( state.backtracking==0 ) {retval.value = (pt!=null?pt.value:null);}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {setLocation(retval.value, ((Token)retval.start), ((Token)retval.stop));}
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 63, type_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "type"


    public static class classOrInterfaceType_return extends ParserRuleReturnScope {
        public BasicTypeReference element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "classOrInterfaceType"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:874:1: classOrInterfaceType returns [BasicTypeReference element] : name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* ;
    public final MViewParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MViewParser.classOrInterfaceType_return retval = new MViewParser.classOrInterfaceType_return();
        retval.start = input.LT(1);

        int classOrInterfaceType_StartIndex = input.index();

        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal94=null;
        MViewParser.typeArguments_return typeArguments93 =null;

        MViewParser.typeArguments_return typeArguments95 =null;


        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal94_tree=null;

        NamedTarget target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:876:2: (name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:876:4: name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )*
            {
            root_0 = (Object)adaptor.nil();


            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2197); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            if ( state.backtracking==0 ) {
            	           retval.element = new MViewBasicTypeReference((name!=null?name.getText():null));
            	           target =  new NamedTarget((name!=null?name.getText():null));
            	           setLocation(retval.element,name,name); 
            	          }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:882:4: ( typeArguments )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==31) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:882:4: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2216);
                    typeArguments93=typeArguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments93.getTree());

                    }
                    break;

            }


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:883:10: ( '.' namex= Identifier ( typeArguments )? )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==28) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:883:11: '.' namex= Identifier ( typeArguments )?
            	    {
            	    char_literal94=(Token)match(input,28,FOLLOW_28_in_classOrInterfaceType2230); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal94_tree = 
            	    (Object)adaptor.create(char_literal94)
            	    ;
            	    adaptor.addChild(root_0, char_literal94_tree);
            	    }

            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2234); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    namex_tree = 
            	    (Object)adaptor.create(namex)
            	    ;
            	    adaptor.addChild(root_0, namex_tree);
            	    }

            	    if ( state.backtracking==0 ) {
            	    	           if(target != null) {
            	    	             retval.element = new MViewBasicTypeReference(target,(namex!=null?namex.getText():null));
            	    	             // We must clone the target here, or else it will be removed from the
            	    	             // type reference we just created.
            	    	             target = new NamedTarget((namex!=null?namex.getText():null),target.clone());
            	    	           } else {
            	    	             retval.element = new MViewBasicTypeReference(retval.element,(namex!=null?namex.getText():null));
            	    	           }
            	    	          }

            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:894:11: ( typeArguments )?
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==31) ) {
            	        alt49=1;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:894:11: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2260);
            	            typeArguments95=typeArguments();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments95.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 64, classOrInterfaceType_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "classOrInterfaceType"


    public static class primitiveType_return extends ParserRuleReturnScope {
        public BasicTypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "primitiveType"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:898:1: primitiveType returns [BasicTypeReference value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MViewParser.primitiveType_return primitiveType() throws RecognitionException {
        MViewParser.primitiveType_return retval = new MViewParser.primitiveType_return();
        retval.start = input.LT(1);

        int primitiveType_StartIndex = input.index();

        Object root_0 = null;

        Token string_literal96=null;
        Token string_literal97=null;
        Token string_literal98=null;
        Token string_literal99=null;
        Token string_literal100=null;
        Token string_literal101=null;
        Token string_literal102=null;
        Token string_literal103=null;

        Object string_literal96_tree=null;
        Object string_literal97_tree=null;
        Object string_literal98_tree=null;
        Object string_literal99_tree=null;
        Object string_literal100_tree=null;
        Object string_literal101_tree=null;
        Object string_literal102_tree=null;
        Object string_literal103_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:899:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt51=8;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt51=1;
                }
                break;
            case 48:
                {
                alt51=2;
                }
                break;
            case 44:
                {
                alt51=3;
                }
                break;
            case 71:
                {
                alt51=4;
                }
                break;
            case 58:
                {
                alt51=5;
                }
                break;
            case 62:
                {
                alt51=6;
                }
                break;
            case 55:
                {
                alt51=7;
                }
                break;
            case 52:
                {
                alt51=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }

            switch (alt51) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:899:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal96=(Token)match(input,43,FOLLOW_43_in_primitiveType2285); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal96_tree = 
                    (Object)adaptor.create(string_literal96)
                    ;
                    adaptor.addChild(root_0, string_literal96_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new MViewBasicTypeReference("boolean");}

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:900:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal97=(Token)match(input,48,FOLLOW_48_in_primitiveType2297); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal97_tree = 
                    (Object)adaptor.create(string_literal97)
                    ;
                    adaptor.addChild(root_0, string_literal97_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new MViewBasicTypeReference("char");}

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:901:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal98=(Token)match(input,44,FOLLOW_44_in_primitiveType2309); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal98_tree = 
                    (Object)adaptor.create(string_literal98)
                    ;
                    adaptor.addChild(root_0, string_literal98_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new MViewBasicTypeReference("byte");}

                    }
                    break;
                case 4 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:902:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal99=(Token)match(input,71,FOLLOW_71_in_primitiveType2321); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal99_tree = 
                    (Object)adaptor.create(string_literal99)
                    ;
                    adaptor.addChild(root_0, string_literal99_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new MViewBasicTypeReference("short");}

                    }
                    break;
                case 5 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:903:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal100=(Token)match(input,58,FOLLOW_58_in_primitiveType2333); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal100_tree = 
                    (Object)adaptor.create(string_literal100)
                    ;
                    adaptor.addChild(root_0, string_literal100_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new MViewBasicTypeReference("int");}

                    }
                    break;
                case 6 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:904:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal101=(Token)match(input,62,FOLLOW_62_in_primitiveType2345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal101_tree = 
                    (Object)adaptor.create(string_literal101)
                    ;
                    adaptor.addChild(root_0, string_literal101_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new MViewBasicTypeReference("long");}

                    }
                    break;
                case 7 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:905:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal102=(Token)match(input,55,FOLLOW_55_in_primitiveType2357); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal102_tree = 
                    (Object)adaptor.create(string_literal102)
                    ;
                    adaptor.addChild(root_0, string_literal102_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new MViewBasicTypeReference("float");}

                    }
                    break;
                case 8 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:906:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal103=(Token)match(input,52,FOLLOW_52_in_primitiveType2369); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal103_tree = 
                    (Object)adaptor.create(string_literal103)
                    ;
                    adaptor.addChild(root_0, string_literal103_tree);
                    }

                    if ( state.backtracking==0 ) {retval.value = new MViewBasicTypeReference("double");}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 65, primitiveType_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "primitiveType"


    public static class typeArguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "typeArguments"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:911:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final MViewParser.typeArguments_return typeArguments() throws RecognitionException {
        MViewParser.typeArguments_return retval = new MViewParser.typeArguments_return();
        retval.start = input.LT(1);

        int typeArguments_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal104=null;
        Token char_literal106=null;
        Token char_literal108=null;
        MViewParser.typeArgument_return typeArgument105 =null;

        MViewParser.typeArgument_return typeArgument107 =null;


        Object char_literal104_tree=null;
        Object char_literal106_tree=null;
        Object char_literal108_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:912:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:912:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            root_0 = (Object)adaptor.nil();


            char_literal104=(Token)match(input,31,FOLLOW_31_in_typeArguments2392); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal104_tree = 
            (Object)adaptor.create(char_literal104)
            ;
            adaptor.addChild(root_0, char_literal104_tree);
            }

            pushFollow(FOLLOW_typeArgument_in_typeArguments2394);
            typeArgument105=typeArgument();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument105.getTree());

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:912:26: ( ',' typeArgument )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==27) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:912:28: ',' typeArgument
            	    {
            	    char_literal106=(Token)match(input,27,FOLLOW_27_in_typeArguments2398); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal106_tree = 
            	    (Object)adaptor.create(char_literal106)
            	    ;
            	    adaptor.addChild(root_0, char_literal106_tree);
            	    }

            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2400);
            	    typeArgument107=typeArgument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument107.getTree());

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            char_literal108=(Token)match(input,33,FOLLOW_33_in_typeArguments2405); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal108_tree = 
            (Object)adaptor.create(char_literal108)
            ;
            adaptor.addChild(root_0, char_literal108_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 66, typeArguments_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "typeArguments"


    public static class typeArgument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "typeArgument"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:915:1: typeArgument : (t= type | '?' ( ( 'extends' | 'super' ) t= type )? );
    public final MViewParser.typeArgument_return typeArgument() throws RecognitionException {
        MViewParser.typeArgument_return retval = new MViewParser.typeArgument_return();
        retval.start = input.LT(1);

        int typeArgument_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal109=null;
        Token set110=null;
        MViewParser.type_return t =null;


        Object char_literal109_tree=null;
        Object set110_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:916:5: (t= type | '?' ( ( 'extends' | 'super' ) t= type )? )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==Identifier||(LA54_0 >= 43 && LA54_0 <= 44)||LA54_0==48||LA54_0==52||LA54_0==55||LA54_0==58||LA54_0==62||LA54_0==71) ) {
                alt54=1;
            }
            else if ( (LA54_0==34) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }
            switch (alt54) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:916:9: t= type
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_type_in_typeArgument2430);
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:916:20: '?' ( ( 'extends' | 'super' ) t= type )?
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal109=(Token)match(input,34,FOLLOW_34_in_typeArgument2436); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal109_tree = 
                    (Object)adaptor.create(char_literal109)
                    ;
                    adaptor.addChild(root_0, char_literal109_tree);
                    }

                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:916:25: ( ( 'extends' | 'super' ) t= type )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==54||LA53_0==73) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:916:27: ( 'extends' | 'super' ) t= type
                            {
                            set110=(Token)input.LT(1);

                            if ( input.LA(1)==54||input.LA(1)==73 ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                                (Object)adaptor.create(set110)
                                );
                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            pushFollow(FOLLOW_type_in_typeArgument2451);
                            t=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 67, typeArgument_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "typeArgument"


    public static class annotations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "annotations"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:923:1: annotations : ( annotation )+ ;
    public final MViewParser.annotations_return annotations() throws RecognitionException {
        MViewParser.annotations_return retval = new MViewParser.annotations_return();
        retval.start = input.LT(1);

        int annotations_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.annotation_return annotation111 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:924:5: ( ( annotation )+ )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:924:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:924:9: ( annotation )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==35) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:924:9: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations2481);
            	    annotation111=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation111.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt55 >= 1 ) break loop55;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 68, annotations_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "annotations"


    public static class annotation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "annotation"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:927:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MViewParser.annotation_return annotation() throws RecognitionException {
        MViewParser.annotation_return retval = new MViewParser.annotation_return();
        retval.start = input.LT(1);

        int annotation_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal112=null;
        Token char_literal114=null;
        Token char_literal117=null;
        MViewParser.annotationName_return annotationName113 =null;

        MViewParser.elementValuePairs_return elementValuePairs115 =null;

        MViewParser.elementValue_return elementValue116 =null;


        Object char_literal112_tree=null;
        Object char_literal114_tree=null;
        Object char_literal117_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:928:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:928:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();


            char_literal112=(Token)match(input,35,FOLLOW_35_in_annotation2501); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal112_tree = 
            (Object)adaptor.create(char_literal112)
            ;
            adaptor.addChild(root_0, char_literal112_tree);
            }

            pushFollow(FOLLOW_annotationName_in_annotation2503);
            annotationName113=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName113.getTree());

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:928:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==24) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:928:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal114=(Token)match(input,24,FOLLOW_24_in_annotation2507); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal114_tree = 
                    (Object)adaptor.create(char_literal114)
                    ;
                    adaptor.addChild(root_0, char_literal114_tree);
                    }

                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:928:34: ( elementValuePairs | elementValue )?
                    int alt56=3;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==Identifier) ) {
                        alt56=1;
                    }
                    else if ( (LA56_0==35||LA56_0==76) ) {
                        alt56=2;
                    }
                    switch (alt56) {
                        case 1 :
                            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:928:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation2511);
                            elementValuePairs115=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs115.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:928:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation2515);
                            elementValue116=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue116.getTree());

                            }
                            break;

                    }


                    char_literal117=(Token)match(input,25,FOLLOW_25_in_annotation2520); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal117_tree = 
                    (Object)adaptor.create(char_literal117)
                    ;
                    adaptor.addChild(root_0, char_literal117_tree);
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 69, annotation_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "annotation"


    public static class annotationName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "annotationName"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:931:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MViewParser.annotationName_return annotationName() throws RecognitionException {
        MViewParser.annotationName_return retval = new MViewParser.annotationName_return();
        retval.start = input.LT(1);

        int annotationName_StartIndex = input.index();

        Object root_0 = null;

        Token Identifier118=null;
        Token char_literal119=null;
        Token Identifier120=null;

        Object Identifier118_tree=null;
        Object char_literal119_tree=null;
        Object Identifier120_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:932:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:932:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();


            Identifier118=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2544); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier118_tree = 
            (Object)adaptor.create(Identifier118)
            ;
            adaptor.addChild(root_0, Identifier118_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:932:18: ( '.' Identifier )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==28) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:932:19: '.' Identifier
            	    {
            	    char_literal119=(Token)match(input,28,FOLLOW_28_in_annotationName2547); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal119_tree = 
            	    (Object)adaptor.create(char_literal119)
            	    ;
            	    adaptor.addChild(root_0, char_literal119_tree);
            	    }

            	    Identifier120=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2549); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier120_tree = 
            	    (Object)adaptor.create(Identifier120)
            	    ;
            	    adaptor.addChild(root_0, Identifier120_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 70, annotationName_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "annotationName"


    public static class elementValuePairs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elementValuePairs"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:935:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MViewParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MViewParser.elementValuePairs_return retval = new MViewParser.elementValuePairs_return();
        retval.start = input.LT(1);

        int elementValuePairs_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal122=null;
        MViewParser.elementValuePair_return elementValuePair121 =null;

        MViewParser.elementValuePair_return elementValuePair123 =null;


        Object char_literal122_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:936:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:936:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2570);
            elementValuePair121=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair121.getTree());

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:936:26: ( ',' elementValuePair )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==27) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:936:27: ',' elementValuePair
            	    {
            	    char_literal122=(Token)match(input,27,FOLLOW_27_in_elementValuePairs2573); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal122_tree = 
            	    (Object)adaptor.create(char_literal122)
            	    ;
            	    adaptor.addChild(root_0, char_literal122_tree);
            	    }

            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2575);
            	    elementValuePair123=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair123.getTree());

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 71, elementValuePairs_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "elementValuePairs"


    public static class elementValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elementValuePair"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:939:1: elementValuePair : Identifier '=' elementValue ;
    public final MViewParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MViewParser.elementValuePair_return retval = new MViewParser.elementValuePair_return();
        retval.start = input.LT(1);

        int elementValuePair_StartIndex = input.index();

        Object root_0 = null;

        Token Identifier124=null;
        Token char_literal125=null;
        MViewParser.elementValue_return elementValue126 =null;


        Object Identifier124_tree=null;
        Object char_literal125_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:940:5: ( Identifier '=' elementValue )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:940:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();


            Identifier124=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair2596); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier124_tree = 
            (Object)adaptor.create(Identifier124)
            ;
            adaptor.addChild(root_0, Identifier124_tree);
            }

            char_literal125=(Token)match(input,32,FOLLOW_32_in_elementValuePair2598); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal125_tree = 
            (Object)adaptor.create(char_literal125)
            ;
            adaptor.addChild(root_0, char_literal125_tree);
            }

            pushFollow(FOLLOW_elementValue_in_elementValuePair2600);
            elementValue126=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue126.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 72, elementValuePair_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "elementValuePair"


    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elementValue"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:943:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MViewParser.elementValue_return elementValue() throws RecognitionException {
        MViewParser.elementValue_return retval = new MViewParser.elementValue_return();
        retval.start = input.LT(1);

        int elementValue_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.annotation_return annotation127 =null;

        MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer128 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:944:5: ( annotation | elementValueArrayInitializer )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==35) ) {
                alt60=1;
            }
            else if ( (LA60_0==76) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:944:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_annotation_in_elementValue2623);
                    annotation127=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation127.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:945:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue2633);
                    elementValueArrayInitializer128=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer128.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 73, elementValue_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "elementValue"


    public static class elementValueArrayInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elementValueArrayInitializer"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:948:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MViewParser.elementValueArrayInitializer_return retval = new MViewParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);

        int elementValueArrayInitializer_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal129=null;
        Token char_literal131=null;
        Token char_literal133=null;
        Token char_literal134=null;
        MViewParser.elementValue_return elementValue130 =null;

        MViewParser.elementValue_return elementValue132 =null;


        Object char_literal129_tree=null;
        Object char_literal131_tree=null;
        Object char_literal133_tree=null;
        Object char_literal134_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:949:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:949:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();


            char_literal129=(Token)match(input,76,FOLLOW_76_in_elementValueArrayInitializer2656); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal129_tree = 
            (Object)adaptor.create(char_literal129)
            ;
            adaptor.addChild(root_0, char_literal129_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:949:13: ( elementValue ( ',' elementValue )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==35||LA62_0==76) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:949:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2659);
                    elementValue130=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue130.getTree());

                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:949:27: ( ',' elementValue )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==27) ) {
                            int LA61_1 = input.LA(2);

                            if ( (LA61_1==35||LA61_1==76) ) {
                                alt61=1;
                            }


                        }


                        switch (alt61) {
                    	case 1 :
                    	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:949:28: ',' elementValue
                    	    {
                    	    char_literal131=(Token)match(input,27,FOLLOW_27_in_elementValueArrayInitializer2662); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal131_tree = 
                    	    (Object)adaptor.create(char_literal131)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal131_tree);
                    	    }

                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2664);
                    	    elementValue132=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue132.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }
                    break;

            }


            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:949:49: ( ',' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==27) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:949:50: ','
                    {
                    char_literal133=(Token)match(input,27,FOLLOW_27_in_elementValueArrayInitializer2671); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal133_tree = 
                    (Object)adaptor.create(char_literal133)
                    ;
                    adaptor.addChild(root_0, char_literal133_tree);
                    }

                    }
                    break;

            }


            char_literal134=(Token)match(input,77,FOLLOW_77_in_elementValueArrayInitializer2675); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal134_tree = 
            (Object)adaptor.create(char_literal134)
            ;
            adaptor.addChild(root_0, char_literal134_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 74, elementValueArrayInitializer_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "elementValueArrayInitializer"


    public static class annotationTypeDeclaration_return extends ParserRuleReturnScope {
        public Type element;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "annotationTypeDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:952:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MViewParser.annotationTypeDeclaration_return retval = new MViewParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);

        int annotationTypeDeclaration_StartIndex = input.index();

        Object root_0 = null;

        Token name=null;
        Token char_literal135=null;
        Token string_literal136=null;
        MViewParser.annotationTypeBody_return annotationTypeBody137 =null;


        Object name_tree=null;
        Object char_literal135_tree=null;
        Object string_literal136_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:953:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:953:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();


            char_literal135=(Token)match(input,35,FOLLOW_35_in_annotationTypeDeclaration2702); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal135_tree = 
            (Object)adaptor.create(char_literal135)
            ;
            adaptor.addChild(root_0, char_literal135_tree);
            }

            string_literal136=(Token)match(input,59,FOLLOW_59_in_annotationTypeDeclaration2704); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal136_tree = 
            (Object)adaptor.create(string_literal136)
            ;
            adaptor.addChild(root_0, string_literal136_tree);
            }

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration2708); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = 
            (Object)adaptor.create(name)
            ;
            adaptor.addChild(root_0, name_tree);
            }

            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2710);
            annotationTypeBody137=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody137.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 75, annotationTypeDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "annotationTypeDeclaration"


    public static class annotationTypeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "annotationTypeBody"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:956:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MViewParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MViewParser.annotationTypeBody_return retval = new MViewParser.annotationTypeBody_return();
        retval.start = input.LT(1);

        int annotationTypeBody_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal138=null;
        Token char_literal140=null;
        MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration139 =null;


        Object char_literal138_tree=null;
        Object char_literal140_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:957:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:957:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();


            char_literal138=(Token)match(input,76,FOLLOW_76_in_annotationTypeBody2733); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal138_tree = 
            (Object)adaptor.create(char_literal138)
            ;
            adaptor.addChild(root_0, char_literal138_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:957:13: ( annotationTypeElementDeclaration )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==Identifier||LA64_0==35||(LA64_0 >= 43 && LA64_0 <= 44)||LA64_0==48||LA64_0==52||LA64_0==55||LA64_0==58||LA64_0==62||LA64_0==71) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:957:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2736);
            	    annotationTypeElementDeclaration139=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration139.getTree());

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            char_literal140=(Token)match(input,77,FOLLOW_77_in_annotationTypeBody2740); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal140_tree = 
            (Object)adaptor.create(char_literal140)
            ;
            adaptor.addChild(root_0, char_literal140_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 76, annotationTypeBody_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "annotationTypeBody"


    public static class annotationTypeElementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "annotationTypeElementDeclaration"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:960:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MViewParser.annotationTypeElementDeclaration_return retval = new MViewParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);

        int annotationTypeElementDeclaration_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.annotationTypeElementRest_return annotationTypeElementRest141 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:961:5: ( annotationTypeElementRest )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:961:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2765);
            annotationTypeElementRest141=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest141.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 77, annotationTypeElementDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementDeclaration"


    public static class annotationTypeElementRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "annotationTypeElementRest"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:964:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MViewParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MViewParser.annotationTypeElementRest_return retval = new MViewParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);

        int annotationTypeElementRest_StartIndex = input.index();

        Object root_0 = null;

        Token char_literal144=null;
        Token char_literal146=null;
        MViewParser.type_return type142 =null;

        MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest143 =null;

        MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration145 =null;


        Object char_literal144_tree=null;
        Object char_literal146_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:965:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==Identifier||(LA66_0 >= 43 && LA66_0 <= 44)||LA66_0==48||LA66_0==52||LA66_0==55||LA66_0==58||LA66_0==62||LA66_0==71) ) {
                alt66=1;
            }
            else if ( (LA66_0==35) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }
            switch (alt66) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:965:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2788);
                    type142=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type142.getTree());

                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2790);
                    annotationMethodOrConstantRest143=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest143.getTree());

                    char_literal144=(Token)match(input,30,FOLLOW_30_in_annotationTypeElementRest2792); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal144_tree = 
                    (Object)adaptor.create(char_literal144)
                    ;
                    adaptor.addChild(root_0, char_literal144_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:966:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2802);
                    annotationTypeDeclaration145=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration145.getTree());

                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:966:35: ( ';' )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==30) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:966:35: ';'
                            {
                            char_literal146=(Token)match(input,30,FOLLOW_30_in_annotationTypeElementRest2804); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal146_tree = 
                            (Object)adaptor.create(char_literal146)
                            ;
                            adaptor.addChild(root_0, char_literal146_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 78, annotationTypeElementRest_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementRest"


    public static class annotationMethodOrConstantRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "annotationMethodOrConstantRest"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:969:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MViewParser.annotationMethodOrConstantRest_return retval = new MViewParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);

        int annotationMethodOrConstantRest_StartIndex = input.index();

        Object root_0 = null;

        MViewParser.annotationMethodRest_return annotationMethodRest147 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:970:5: ( annotationMethodRest )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:970:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2828);
            annotationMethodRest147=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest147.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 79, annotationMethodOrConstantRest_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "annotationMethodOrConstantRest"


    public static class annotationMethodRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "annotationMethodRest"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:973:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MViewParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MViewParser.annotationMethodRest_return retval = new MViewParser.annotationMethodRest_return();
        retval.start = input.LT(1);

        int annotationMethodRest_StartIndex = input.index();

        Object root_0 = null;

        Token Identifier148=null;
        Token char_literal149=null;
        Token char_literal150=null;
        MViewParser.defaultValue_return defaultValue151 =null;


        Object Identifier148_tree=null;
        Object char_literal149_tree=null;
        Object char_literal150_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:974:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:974:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();


            Identifier148=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2851); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier148_tree = 
            (Object)adaptor.create(Identifier148)
            ;
            adaptor.addChild(root_0, Identifier148_tree);
            }

            char_literal149=(Token)match(input,24,FOLLOW_24_in_annotationMethodRest2853); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal149_tree = 
            (Object)adaptor.create(char_literal149)
            ;
            adaptor.addChild(root_0, char_literal149_tree);
            }

            char_literal150=(Token)match(input,25,FOLLOW_25_in_annotationMethodRest2855); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal150_tree = 
            (Object)adaptor.create(char_literal150)
            ;
            adaptor.addChild(root_0, char_literal150_tree);
            }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:974:28: ( defaultValue )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==51) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:974:28: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest2857);
                    defaultValue151=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue151.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 80, annotationMethodRest_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "annotationMethodRest"


    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "defaultValue"
    // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:977:1: defaultValue : 'default' elementValue ;
    public final MViewParser.defaultValue_return defaultValue() throws RecognitionException {
        MViewParser.defaultValue_return retval = new MViewParser.defaultValue_return();
        retval.start = input.LT(1);

        int defaultValue_StartIndex = input.index();

        Object root_0 = null;

        Token string_literal152=null;
        MViewParser.elementValue_return elementValue153 =null;


        Object string_literal152_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return retval; }

            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:978:5: ( 'default' elementValue )
            // /Users/steveno/repos/mview-lang/src/mview/parser/MView.g:978:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();


            string_literal152=(Token)match(input,51,FOLLOW_51_in_defaultValue2885); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal152_tree = 
            (Object)adaptor.create(string_literal152)
            ;
            adaptor.addChild(root_0, string_literal152_tree);
            }

            pushFollow(FOLLOW_elementValue_in_defaultValue2887);
            elementValue153=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue153.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 81, defaultValue_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit101 = new BitSet(new long[]{0x0806011000000002L});
    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit114 = new BitSet(new long[]{0x0806011000000002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_compilationUnit127 = new BitSet(new long[]{0x0806011000000002L});
    public static final BitSet FOLLOW_applicationDeclaration_in_compilationUnit140 = new BitSet(new long[]{0x0806011000000002L});
    public static final BitSet FOLLOW_59_in_interfaceDeclaration174 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration178 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_interfaceBody198 = new BitSet(new long[]{0x4491180000002000L,0x0000000000002880L});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody200 = new BitSet(new long[]{0x4491180000002000L,0x0000000000002880L});
    public static final BitSet FOLLOW_77_in_interfaceBody204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration220 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_interfaceBodyDeclaration222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_serviceReferenceDeclaration247 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_actualParameters_in_serviceReferenceDeclaration251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_actualParameters280 = new BitSet(new long[]{0x0000000002002000L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameters285 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_actualParameters291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_actualParameterDecls316 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_actualParameterDecls319 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameterDecls323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceHeaderDeclaration376 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_serviceHeaderDeclaration380 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceHeaderDeclaration384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_formalParameters456 = new BitSet(new long[]{0x4491180002002000L,0x0000000000000080L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters461 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_formalParameters467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls493 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls497 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_formalParameterDecls500 = new BitSet(new long[]{0x4491180000002000L,0x0000000000000080L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negationModifier_in_pointcutServiceSignatureDecl540 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl546 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl554 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutServiceSignatureParameters585 = new BitSet(new long[]{0x0000000006002000L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters588 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_pointcutServiceSignatureParameters594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureParameterDecls609 = new BitSet(new long[]{0x0000000008002002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls618 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_pointcutServiceSignatureParameterDecls623 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_connectorDeclaration656 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_connectorDeclaration662 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration666 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001010L});
    public static final BitSet FOLLOW_refinementDeclaration_in_connectorDeclaration674 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_connectorBody695 = new BitSet(new long[]{0x0000009000000000L,0x0000000000002020L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody697 = new BitSet(new long[]{0x0000009000000000L,0x0000000000002020L});
    public static final BitSet FOLLOW_77_in_connectorBody701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aoCompositionDeclaration_in_connectorBodyDeclaration716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_aoCompositionDeclaration745 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_aoCompositionDeclaration751 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_aoCompositionDeclaration755 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001010L});
    public static final BitSet FOLLOW_refinementDeclarationSingle_in_aoCompositionDeclaration763 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_aoCompositionBody_in_aoCompositionDeclaration770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_aoCompositionBody784 = new BitSet(new long[]{0x0000002000000000L,0x0000000000002004L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_aoCompositionBody791 = new BitSet(new long[]{0x0000002000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_aoCompositionBody800 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_aoCompositionBody807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_pointcutDeclaration824 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_pointcutBody844 = new BitSet(new long[]{0xA000C00000000000L,0x0000000000002102L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody846 = new BitSet(new long[]{0xA000C00000000000L,0x0000000000002102L});
    public static final BitSet FOLLOW_77_in_pointcutBody850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_pointcutKindDeclaration893 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_pointcutKindDeclaration895 = new BitSet(new long[]{0x0020200000000000L});
    public static final BitSet FOLLOW_joinPointKind_in_pointcutKindDeclaration899 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_pointcutKindDeclaration901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration920 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_pointcutSignatureDeclaration926 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_pointcutSignatureDeclaration928 = new BitSet(new long[]{0x0000000004802000L});
    public static final BitSet FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration932 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_pointcutSignatureDeclaration936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls972 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_pointcutSignatureBodyDecls976 = new BitSet(new long[]{0x0000000004802000L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_pointcutActorDeclaration1000 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_pointcutActorDeclaration1015 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_pointcutActorBody1047 = new BitSet(new long[]{0x8B02010000000000L,0x0000000000002002L});
    public static final BitSet FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1049 = new BitSet(new long[]{0x8B02010000000000L,0x0000000000002002L});
    public static final BitSet FOLLOW_77_in_pointcutActorBody1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1074 = new BitSet(new long[]{0x0B02010000000000L});
    public static final BitSet FOLLOW_59_in_pointcutActorBodyDecls1085 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_pointcutActorBodyDecls1087 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_49_in_pointcutActorBodyDecls1099 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_pointcutActorBodyDecls1101 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_40_in_pointcutActorBodyDecls1112 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_pointcutActorBodyDecls1114 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_57_in_pointcutActorBodyDecls1125 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_pointcutActorBodyDecls1127 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_56_in_pointcutActorBodyDecls1138 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_pointcutActorBodyDecls1140 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1149 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_pointcutActorBodyDecls1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negationModifier_in_pointcutActorPropDecls1169 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1175 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_pointcutActorPropDecls1180 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutActorPropDecl1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_adviceDeclaration1230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_adviceBody1249 = new BitSet(new long[]{0x0200000000000000L,0x0000000000002440L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody1251 = new BitSet(new long[]{0x0200000000000000L,0x0000000000002440L});
    public static final BitSet FOLLOW_77_in_adviceBody1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceInstanceDeclaration_in_adviceBodyDeclaration1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_adviceServiceDeclaration1300 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_adviceServiceDeclaration1302 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1306 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_adviceServiceDeclaration1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_adviceTypeDeclaration1327 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_adviceTypeDeclaration1329 = new BitSet(new long[]{0x0000064000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration1333 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_adviceTypeDeclaration1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_adviceInstanceDeclaration1351 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_adviceInstanceDeclaration1353 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_instanceReferenceDeclaration_in_adviceInstanceDeclaration1357 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_adviceInstanceDeclaration1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_instanceReferenceDeclaration1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_componentDeclaration1407 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration1411 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_componentBody1437 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002028L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody1439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002028L});
    public static final BitSet FOLLOW_77_in_componentBody1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_moduleDependencyBody1495 = new BitSet(new long[]{0x0000000000002000L,0x0000000000002000L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1500 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_moduleDependencyBody1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_moduleRequireDependencyDeclaration1525 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_moduleProvideDependencyDeclaration1544 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_applicationDeclaration1581 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_applicationDeclaration1587 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_applicationDeclaration1591 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001010L});
    public static final BitSet FOLLOW_refinementDeclaration_in_applicationDeclaration1599 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_applicationBody_in_applicationDeclaration1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_applicationBody1620 = new BitSet(new long[]{0x0106001000002000L,0x0000000000002000L});
    public static final BitSet FOLLOW_applicationBodyDeclaration_in_applicationBody1624 = new BitSet(new long[]{0x0106001000002000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_applicationBody1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hostDeclaration_in_applicationBodyDeclaration1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1701 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1705 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_instanceDeclaration1709 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1713 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_instanceDeclaration1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_hostDeclaration1742 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_hostDeclaration1746 = new BitSet(new long[]{0x1000000040000000L});
    public static final BitSet FOLLOW_60_in_hostDeclaration1754 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_StringLiteral_in_hostDeclaration1758 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_hostDeclaration1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_componentDeclaration_in_moduleContainerDeclarations1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_refinementDeclarationSingle1827 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1848 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_refinementDeclaration1853 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclaration1857 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_refinementParentDeclaration_in_refinementDeclarationBody1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_refinementParentDeclaration1915 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_refinementParentDeclaration1922 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_refinementParentDeclaration1926 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls1960 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_commaSeparatedBodyDecls1963 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_adviceType1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_adviceType2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_adviceType2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_joinPointKind2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_joinPointKind2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_overrideOrExtend2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_overrideOrExtend2068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_negationModifier2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_abstractModifier2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_voidType2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2197 = new BitSet(new long[]{0x0000000090000002L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2216 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_classOrInterfaceType2230 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2234 = new BitSet(new long[]{0x0000000090000002L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2260 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_43_in_primitiveType2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_primitiveType2297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_primitiveType2309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_primitiveType2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_primitiveType2333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType2345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_primitiveType2357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_primitiveType2369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_typeArguments2392 = new BitSet(new long[]{0x4491180400002000L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2394 = new BitSet(new long[]{0x0000000208000000L});
    public static final BitSet FOLLOW_27_in_typeArguments2398 = new BitSet(new long[]{0x4491180400002000L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2400 = new BitSet(new long[]{0x0000000208000000L});
    public static final BitSet FOLLOW_33_in_typeArguments2405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_typeArgument2436 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_set_in_typeArgument2441 = new BitSet(new long[]{0x4491180000002000L,0x0000000000000080L});
    public static final BitSet FOLLOW_type_in_typeArgument2451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations2481 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_annotation2501 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_annotationName_in_annotation2503 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_annotation2507 = new BitSet(new long[]{0x0000000802002000L,0x0000000000001000L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation2511 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation2515 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_annotation2520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2544 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_annotationName2547 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2549 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2570 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_elementValuePairs2573 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2575 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair2596 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_elementValuePair2598 = new BitSet(new long[]{0x0000000800000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue2623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_elementValueArrayInitializer2656 = new BitSet(new long[]{0x0000000808000000L,0x0000000000003000L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2659 = new BitSet(new long[]{0x0000000008000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_27_in_elementValueArrayInitializer2662 = new BitSet(new long[]{0x0000000800000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2664 = new BitSet(new long[]{0x0000000008000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_27_in_elementValueArrayInitializer2671 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_elementValueArrayInitializer2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_annotationTypeDeclaration2702 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_annotationTypeDeclaration2704 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration2708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_annotationTypeBody2733 = new BitSet(new long[]{0x4491180800002000L,0x0000000000002080L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2736 = new BitSet(new long[]{0x4491180800002000L,0x0000000000002080L});
    public static final BitSet FOLLOW_77_in_annotationTypeBody2740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2788 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2790 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_annotationTypeElementRest2792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2802 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_annotationTypeElementRest2804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2851 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_annotationMethodRest2853 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_annotationMethodRest2855 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_defaultValue2885 = new BitSet(new long[]{0x0000000800000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2887 = new BitSet(new long[]{0x0000000000000002L});

}
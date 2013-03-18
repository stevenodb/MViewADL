// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g 2013-03-18 14:26:52

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class MViewParser extends ChameleonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "StringLiteral", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "'{'", "'}'", "';'", "'('", "')'", "','", "'*'", "'connector'", "'ao-composition'", "'pointcut'", "'kind'", "':'", "'signature'", "'caller'", "'callee'", "'component'", "'application'", "'instance'", "'host'", "'advice'", "'method'", "'type'", "'require'", "'provide'", "'on'", "'is'", "'refines'", "'.'", "'before'", "'after'", "'around'", "'execution'", "'call'", "'override'", "'merge'", "'!'", "'abstract'", "'void'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'<'", "'>'", "'?'", "'extends'", "'super'", "'@'", "'='", "'default'"
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
    public static final int Identifier=4;
    public static final int StringLiteral=5;
    public static final int HexDigit=6;
    public static final int IntegerTypeSuffix=7;
    public static final int HexLiteral=8;
    public static final int DecimalLiteral=9;
    public static final int OctalLiteral=10;
    public static final int Exponent=11;
    public static final int FloatTypeSuffix=12;
    public static final int FloatingPointLiteral=13;
    public static final int EscapeSequence=14;
    public static final int CharacterLiteral=15;
    public static final int UnicodeEscape=16;
    public static final int OctalEscape=17;
    public static final int Letter=18;
    public static final int JavaIDDigit=19;
    public static final int WS=20;
    public static final int COMMENT=21;
    public static final int LINE_COMMENT=22;

    // delegates
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
            this.state.ruleMemo = new HashMap[172+1];
             
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return MViewParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g"; }



      public NamespaceDeclaration createNamespaceDeclaration() {
        return ((Java)language()).plugin(ObjectOrientedFactory.class).createRootNamespaceDeclaration();
      }
      




    public static class compilationUnit_return extends ParserRuleReturnScope {
        public Document element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compilationUnit"
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:125:1: compilationUnit returns [Document element] : (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )* ;
    public final MViewParser.compilationUnit_return compilationUnit() throws RecognitionException {
        MViewParser.compilationUnit_return retval = new MViewParser.compilationUnit_return();
        retval.start = input.LT(1);
        int compilationUnit_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.interfaceDeclaration_return ifd = null;

        MViewParser.componentDeclaration_return cod = null;

        MViewParser.connectorDeclaration_return cnd = null;

        MViewParser.applicationDeclaration_return apd = null;



         
        	retval.element = getDocument();
        	NamespaceDeclaration npp = createNamespaceDeclaration();
        	retval.element.add(npp);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:131:2: ( (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:131:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:131:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )*
            loop1:
            do {
                int alt1=5;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    alt1=1;
                    }
                    break;
                case 39:
                    {
                    alt1=2;
                    }
                    break;
                case 60:
                    {
                    int LA1_4 = input.LA(2);

                    if ( (LA1_4==31) ) {
                        alt1=3;
                    }
                    else if ( (LA1_4==40) ) {
                        alt1=4;
                    }


                    }
                    break;
                case 31:
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
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:132:4: ifd= interfaceDeclaration
            	    {
            	    pushFollow(FOLLOW_interfaceDeclaration_in_compilationUnit106);
            	    ifd=interfaceDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifd.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((ifd!=null?ifd.element:null));
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:134:4: cod= componentDeclaration
            	    {
            	    pushFollow(FOLLOW_componentDeclaration_in_compilationUnit119);
            	    cod=componentDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cod.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((cod!=null?cod.element:null));
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:136:4: cnd= connectorDeclaration
            	    {
            	    pushFollow(FOLLOW_connectorDeclaration_in_compilationUnit132);
            	    cnd=connectorDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cnd.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((cnd!=null?cnd.element:null));
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:138:4: apd= applicationDeclaration
            	    {
            	    pushFollow(FOLLOW_applicationDeclaration_in_compilationUnit145);
            	    apd=applicationDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, apd.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((apd!=null?apd.element:null));
            	    }

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:151:1: interfaceDeclaration returns [Interface element] : intkw= 'interface' name= Identifier ( refinementDeclaration[$element,Interface.class] )? interfaceBody[$element] ;
    public final MViewParser.interfaceDeclaration_return interfaceDeclaration() throws RecognitionException {
        MViewParser.interfaceDeclaration_return retval = new MViewParser.interfaceDeclaration_return();
        retval.start = input.LT(1);
        int interfaceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token intkw=null;
        Token name=null;
        MViewParser.refinementDeclaration_return refinementDeclaration1 = null;

        MViewParser.interfaceBody_return interfaceBody2 = null;


        Object intkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:152:2: (intkw= 'interface' name= Identifier ( refinementDeclaration[$element,Interface.class] )? interfaceBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:152:4: intkw= 'interface' name= Identifier ( refinementDeclaration[$element,Interface.class] )? interfaceBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            intkw=(Token)match(input,23,FOLLOW_23_in_interfaceDeclaration179); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            intkw_tree = (Object)adaptor.create(intkw);
            adaptor.addChild(root_0, intkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration183); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Interface(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,intkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:157:3: ( refinementDeclaration[$element,Interface.class] )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==50) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:157:4: refinementDeclaration[$element,Interface.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_interfaceDeclaration190);
                    refinementDeclaration1=refinementDeclaration(retval.element, Interface.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration1.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration197);
            interfaceBody2=interfaceBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, interfaceBody2.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:162:1: interfaceBody[Interface element] : '{' ( interfaceBodyDeclaration[$element] )* '}' ;
    public final MViewParser.interfaceBody_return interfaceBody(Interface element) throws RecognitionException {
        MViewParser.interfaceBody_return retval = new MViewParser.interfaceBody_return();
        retval.start = input.LT(1);
        int interfaceBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal3=null;
        Token char_literal5=null;
        MViewParser.interfaceBodyDeclaration_return interfaceBodyDeclaration4 = null;


        Object char_literal3_tree=null;
        Object char_literal5_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:163:2: ( '{' ( interfaceBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:163:4: '{' ( interfaceBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal3=(Token)match(input,24,FOLLOW_24_in_interfaceBody211); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal3_tree = (Object)adaptor.create(char_literal3);
            adaptor.addChild(root_0, char_literal3_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:163:8: ( interfaceBodyDeclaration[$element] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Identifier||(LA3_0>=61 && LA3_0<=69)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: interfaceBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody213);
            	    interfaceBodyDeclaration4=interfaceBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, interfaceBodyDeclaration4.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            char_literal5=(Token)match(input,25,FOLLOW_25_in_interfaceBody217); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal5_tree = (Object)adaptor.create(char_literal5);
            adaptor.addChild(root_0, char_literal5_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:167:1: interfaceBodyDeclaration[Interface element] : (service= serviceDeclaration ';' ) ;
    public final MViewParser.interfaceBodyDeclaration_return interfaceBodyDeclaration(Interface element) throws RecognitionException {
        MViewParser.interfaceBodyDeclaration_return retval = new MViewParser.interfaceBodyDeclaration_return();
        retval.start = input.LT(1);
        int interfaceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal6=null;
        MViewParser.serviceDeclaration_return service = null;


        Object char_literal6_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:168:2: ( (service= serviceDeclaration ';' ) )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:168:4: (service= serviceDeclaration ';' )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:168:4: (service= serviceDeclaration ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:168:5: service= serviceDeclaration ';'
            {
            pushFollow(FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration233);
            service=serviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal6=(Token)match(input,26,FOLLOW_26_in_interfaceBodyDeclaration235); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:179:1: serviceReferenceDeclaration returns [SimpleReference<Service> relation] : name= Identifier params= actualParameters ;
    public final MViewParser.serviceReferenceDeclaration_return serviceReferenceDeclaration() throws RecognitionException {
        MViewParser.serviceReferenceDeclaration_return retval = new MViewParser.serviceReferenceDeclaration_return();
        retval.start = input.LT(1);
        int serviceReferenceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        MViewParser.actualParameters_return params = null;


        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:180:2: (name= Identifier params= actualParameters )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:180:4: name= Identifier params= actualParameters
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceReferenceDeclaration260); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_actualParameters_in_serviceReferenceDeclaration264);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:187:1: actualParameters returns [List<String> lst] : '(' (pars= actualParameterDecls )? ')' ;
    public final MViewParser.actualParameters_return actualParameters() throws RecognitionException {
        MViewParser.actualParameters_return retval = new MViewParser.actualParameters_return();
        retval.start = input.LT(1);
        int actualParameters_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal7=null;
        Token char_literal8=null;
        MViewParser.actualParameterDecls_return pars = null;


        Object char_literal7_tree=null;
        Object char_literal8_tree=null;

        retval.lst = new ArrayList<String>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:189:5: ( '(' (pars= actualParameterDecls )? ')' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:189:9: '(' (pars= actualParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal7=(Token)match(input,27,FOLLOW_27_in_actualParameters293); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal7_tree = (Object)adaptor.create(char_literal7);
            adaptor.addChild(root_0, char_literal7_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:189:13: (pars= actualParameterDecls )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Identifier) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:189:14: pars= actualParameterDecls
                    {
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameters298);
                    pars=actualParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
                    if ( state.backtracking==0 ) {
                      retval.lst =(pars!=null?pars.lst:null);
                    }

                    }
                    break;

            }

            char_literal8=(Token)match(input,28,FOLLOW_28_in_actualParameters304); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal8_tree = (Object)adaptor.create(char_literal8);
            adaptor.addChild(root_0, char_literal8_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:192:1: actualParameterDecls returns [List<String> lst] : name= Identifier ( ',' decls= actualParameterDecls )? ;
    public final MViewParser.actualParameterDecls_return actualParameterDecls() throws RecognitionException {
        MViewParser.actualParameterDecls_return retval = new MViewParser.actualParameterDecls_return();
        retval.start = input.LT(1);
        int actualParameterDecls_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal9=null;
        MViewParser.actualParameterDecls_return decls = null;


        Object name_tree=null;
        Object char_literal9_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:193:5: (name= Identifier ( ',' decls= actualParameterDecls )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:193:9: name= Identifier ( ',' decls= actualParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_actualParameterDecls329); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:193:25: ( ',' decls= actualParameterDecls )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==29) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:193:26: ',' decls= actualParameterDecls
                    {
                    char_literal9=(Token)match(input,29,FOLLOW_29_in_actualParameterDecls332); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal9_tree = (Object)adaptor.create(char_literal9);
                    adaptor.addChild(root_0, char_literal9_tree);
                    }
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameterDecls336);
                    decls=actualParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                       retval.lst =decls.lst; 
                    }

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:209:1: serviceDeclaration returns [Service element] : res= serviceHeaderDeclaration ;
    public final MViewParser.serviceDeclaration_return serviceDeclaration() throws RecognitionException {
        MViewParser.serviceDeclaration_return retval = new MViewParser.serviceDeclaration_return();
        retval.start = input.LT(1);
        int serviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.serviceHeaderDeclaration_return res = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:210:2: (res= serviceHeaderDeclaration )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:210:4: res= serviceHeaderDeclaration
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration369);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:216:1: serviceHeaderDeclaration returns [Service element] : rtype= serviceReturnType name= Identifier params= formalParameters ;
    public final MViewParser.serviceHeaderDeclaration_return serviceHeaderDeclaration() throws RecognitionException {
        MViewParser.serviceHeaderDeclaration_return retval = new MViewParser.serviceHeaderDeclaration_return();
        retval.start = input.LT(1);
        int serviceHeaderDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        MViewParser.serviceReturnType_return rtype = null;

        MViewParser.formalParameters_return params = null;


        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:217:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:217:4: rtype= serviceReturnType name= Identifier params= formalParameters
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceReturnType_in_serviceHeaderDeclaration389);
            rtype=serviceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceHeaderDeclaration393); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_formalParameters_in_serviceHeaderDeclaration397);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:225:1: serviceReturnType returns [BasicTypeReference value] : (vt= voidType | tp= type ) ;
    public final MViewParser.serviceReturnType_return serviceReturnType() throws RecognitionException {
        MViewParser.serviceReturnType_return retval = new MViewParser.serviceReturnType_return();
        retval.start = input.LT(1);
        int serviceReturnType_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.voidType_return vt = null;

        MViewParser.type_return tp = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:226:2: ( (vt= voidType | tp= type ) )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:226:4: (vt= voidType | tp= type )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:226:4: (vt= voidType | tp= type )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==61) ) {
                alt6=1;
            }
            else if ( (LA6_0==Identifier||(LA6_0>=62 && LA6_0<=69)) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:227:4: vt= voidType
                    {
                    pushFollow(FOLLOW_voidType_in_serviceReturnType423);
                    vt=voidType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vt.getTree());
                    if ( state.backtracking==0 ) {
                       retval.value =(vt!=null?vt.value:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:229:4: tp= type
                    {
                    pushFollow(FOLLOW_type_in_serviceReturnType437);
                    tp=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tp.getTree());
                    if ( state.backtracking==0 ) {
                       retval.value =(tp!=null?tp.value:null); 
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:234:1: formalParameters returns [List<FormalParameter> lst] : '(' (pars= formalParameterDecls )? ')' ;
    public final MViewParser.formalParameters_return formalParameters() throws RecognitionException {
        MViewParser.formalParameters_return retval = new MViewParser.formalParameters_return();
        retval.start = input.LT(1);
        int formalParameters_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal10=null;
        Token char_literal11=null;
        MViewParser.formalParameterDecls_return pars = null;


        Object char_literal10_tree=null;
        Object char_literal11_tree=null;

        retval.lst = new ArrayList<FormalParameter>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:236:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:236:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal10=(Token)match(input,27,FOLLOW_27_in_formalParameters469); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal10_tree = (Object)adaptor.create(char_literal10);
            adaptor.addChild(root_0, char_literal10_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:236:13: (pars= formalParameterDecls )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Identifier||(LA7_0>=62 && LA7_0<=69)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:236:14: pars= formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters474);
                    pars=formalParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
                    if ( state.backtracking==0 ) {
                      retval.lst =(pars!=null?pars.lst:null);
                    }

                    }
                    break;

            }

            char_literal11=(Token)match(input,28,FOLLOW_28_in_formalParameters480); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal11_tree = (Object)adaptor.create(char_literal11);
            adaptor.addChild(root_0, char_literal11_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:240:1: formalParameterDecls returns [List<FormalParameter> lst] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
    public final MViewParser.formalParameterDecls_return formalParameterDecls() throws RecognitionException {
        MViewParser.formalParameterDecls_return retval = new MViewParser.formalParameterDecls_return();
        retval.start = input.LT(1);
        int formalParameterDecls_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal12=null;
        MViewParser.type_return t = null;

        MViewParser.formalParameterDecls_return decls = null;


        Object name_tree=null;
        Object char_literal12_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:241:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:241:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_type_in_formalParameterDecls506);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls510); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:241:32: ( ',' decls= formalParameterDecls )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:241:33: ',' decls= formalParameterDecls
                    {
                    char_literal12=(Token)match(input,29,FOLLOW_29_in_formalParameterDecls513); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal12_tree = (Object)adaptor.create(char_literal12);
                    adaptor.addChild(root_0, char_literal12_tree);
                    }
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls517);
                    decls=formalParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                       retval.lst =decls.lst; 
                    }

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:262:1: pointcutServiceSignatureDecl returns [ServiceSignature element] : (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters ;
    public final MViewParser.pointcutServiceSignatureDecl_return pointcutServiceSignatureDecl() throws RecognitionException {
        MViewParser.pointcutServiceSignatureDecl_return retval = new MViewParser.pointcutServiceSignatureDecl_return();
        retval.start = input.LT(1);
        int pointcutServiceSignatureDecl_StartIndex = input.index();
        Object root_0 = null;

        Token rtype=null;
        Token sig=null;
        MViewParser.negationModifier_return negate = null;

        MViewParser.pointcutServiceSignatureParameters_return pars = null;


        Object rtype_tree=null;
        Object sig_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:263:2: ( (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:263:4: (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:263:4: (negate= negationModifier )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==59) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:263:5: negate= negationModifier
                    {
                    pushFollow(FOLLOW_negationModifier_in_pointcutServiceSignatureDecl553);
                    negate=negationModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, negate.getTree());

                    }
                    break;

            }

            rtype=(Token)input.LT(1);
            if ( input.LA(1)==Identifier||input.LA(1)==30 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(rtype));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            sig=(Token)input.LT(1);
            if ( input.LA(1)==Identifier||input.LA(1)==30 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(sig));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl575);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:274:1: pointcutServiceSignatureParameters returns [List<Pair<String,String>> lst] : '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' ;
    public final MViewParser.pointcutServiceSignatureParameters_return pointcutServiceSignatureParameters() throws RecognitionException {
        MViewParser.pointcutServiceSignatureParameters_return retval = new MViewParser.pointcutServiceSignatureParameters_return();
        retval.start = input.LT(1);
        int pointcutServiceSignatureParameters_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal13=null;
        Token char_literal15=null;
        MViewParser.pointcutServiceSignatureParameterDecls_return pointcutServiceSignatureParameterDecls14 = null;


        Object char_literal13_tree=null;
        Object char_literal15_tree=null;

        retval.lst = new ArrayList<Pair<String,String>>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:276:2: ( '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:276:4: '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal13=(Token)match(input,27,FOLLOW_27_in_pointcutServiceSignatureParameters598); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal13_tree = (Object)adaptor.create(char_literal13);
            adaptor.addChild(root_0, char_literal13_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:276:8: ( pointcutServiceSignatureParameterDecls[$lst] )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Identifier||LA10_0==30) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:276:9: pointcutServiceSignatureParameterDecls[$lst]
                    {
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters601);
                    pointcutServiceSignatureParameterDecls14=pointcutServiceSignatureParameterDecls(retval.lst);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutServiceSignatureParameterDecls14.getTree());

                    }
                    break;

            }

            char_literal15=(Token)match(input,28,FOLLOW_28_in_pointcutServiceSignatureParameters607); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal15_tree = (Object)adaptor.create(char_literal15);
            adaptor.addChild(root_0, char_literal15_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:280:1: pointcutServiceSignatureParameterDecls[List<Pair<String,String>> lst] : t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? ;
    public final MViewParser.pointcutServiceSignatureParameterDecls_return pointcutServiceSignatureParameterDecls(List<Pair<String,String>> lst) throws RecognitionException {
        MViewParser.pointcutServiceSignatureParameterDecls_return retval = new MViewParser.pointcutServiceSignatureParameterDecls_return();
        retval.start = input.LT(1);
        int pointcutServiceSignatureParameterDecls_StartIndex = input.index();
        Object root_0 = null;

        Token t=null;
        Token name=null;
        Token char_literal16=null;
        MViewParser.pointcutServiceSignatureParameterDecls_return pointcutServiceSignatureParameterDecls17 = null;


        Object t_tree=null;
        Object name_tree=null;
        Object char_literal16_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:281:2: (t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:281:4: t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)input.LT(1);
            if ( input.LA(1)==Identifier||input.LA(1)==30 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(t));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:281:23: (name= Identifier )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Identifier) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:281:24: name= Identifier
                    {
                    name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls631); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    name_tree = (Object)adaptor.create(name);
                    adaptor.addChild(root_0, name_tree);
                    }

                    }
                    break;

            }

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:281:42: ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==29) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:281:43: ',' pointcutServiceSignatureParameterDecls[$lst]
                    {
                    char_literal16=(Token)match(input,29,FOLLOW_29_in_pointcutServiceSignatureParameterDecls636); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal16_tree = (Object)adaptor.create(char_literal16);
                    adaptor.addChild(root_0, char_literal16_tree);
                    }
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls638);
                    pointcutServiceSignatureParameterDecls17=pointcutServiceSignatureParameterDecls(lst);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutServiceSignatureParameterDecls17.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:294:1: connectorDeclaration returns [Connector element] : (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] ;
    public final MViewParser.connectorDeclaration_return connectorDeclaration() throws RecognitionException {
        MViewParser.connectorDeclaration_return retval = new MViewParser.connectorDeclaration_return();
        retval.start = input.LT(1);
        int connectorDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token conkw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs = null;

        MViewParser.refinementDeclaration_return refinementDeclaration18 = null;

        MViewParser.connectorBody_return connectorBody19 = null;


        Object conkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:295:2: ( (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:295:4: (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:295:4: (abs= abstractModifier )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==60) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:295:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_connectorDeclaration669);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

            conkw=(Token)match(input,31,FOLLOW_31_in_connectorDeclaration675); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            conkw_tree = (Object)adaptor.create(conkw);
            adaptor.addChild(root_0, conkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration679); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:305:3: ( refinementDeclaration[$element,Connector.class] )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==50) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:305:4: refinementDeclaration[$element,Connector.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_connectorDeclaration687);
                    refinementDeclaration18=refinementDeclaration(retval.element, Connector.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration18.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration694);
            connectorBody19=connectorBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorBody19.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:310:1: connectorBody[Connector element] : '{' ( connectorBodyDeclaration[$element] )* '}' ;
    public final MViewParser.connectorBody_return connectorBody(Connector element) throws RecognitionException {
        MViewParser.connectorBody_return retval = new MViewParser.connectorBody_return();
        retval.start = input.LT(1);
        int connectorBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal20=null;
        Token char_literal22=null;
        MViewParser.connectorBodyDeclaration_return connectorBodyDeclaration21 = null;


        Object char_literal20_tree=null;
        Object char_literal22_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:311:2: ( '{' ( connectorBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:311:4: '{' ( connectorBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal20=(Token)match(input,24,FOLLOW_24_in_connectorBody708); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal20_tree = (Object)adaptor.create(char_literal20);
            adaptor.addChild(root_0, char_literal20_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:311:8: ( connectorBodyDeclaration[$element] )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==32||(LA15_0>=46 && LA15_0<=47)||LA15_0==60) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: connectorBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_connectorBodyDeclaration_in_connectorBody710);
            	    connectorBodyDeclaration21=connectorBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorBodyDeclaration21.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            char_literal22=(Token)match(input,25,FOLLOW_25_in_connectorBody714); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal22_tree = (Object)adaptor.create(char_literal22);
            adaptor.addChild(root_0, char_literal22_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:315:1: connectorBodyDeclaration[Connector element] : (aoc= aoCompositionDeclaration | moduleProvideDependencyDeclaration[$element] | moduleRequireDependencyDeclaration[$element] );
    public final MViewParser.connectorBodyDeclaration_return connectorBodyDeclaration(Connector element) throws RecognitionException {
        MViewParser.connectorBodyDeclaration_return retval = new MViewParser.connectorBodyDeclaration_return();
        retval.start = input.LT(1);
        int connectorBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.aoCompositionDeclaration_return aoc = null;

        MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration23 = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration24 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:316:2: (aoc= aoCompositionDeclaration | moduleProvideDependencyDeclaration[$element] | moduleRequireDependencyDeclaration[$element] )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 32:
            case 60:
                {
                alt16=1;
                }
                break;
            case 47:
                {
                alt16=2;
                }
                break;
            case 46:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:316:4: aoc= aoCompositionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_aoCompositionDeclaration_in_connectorBodyDeclaration729);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:319:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_connectorBodyDeclaration736);
                    moduleProvideDependencyDeclaration23=moduleProvideDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleProvideDependencyDeclaration23.getTree());

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:320:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration742);
                    moduleRequireDependencyDeclaration24=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration24.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:324:1: aoCompositionDeclaration returns [AOComposition element] : (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclaration[$element,AOComposition.class] )? aoCompositionBody[$element] ;
    public final MViewParser.aoCompositionDeclaration_return aoCompositionDeclaration() throws RecognitionException {
        MViewParser.aoCompositionDeclaration_return retval = new MViewParser.aoCompositionDeclaration_return();
        retval.start = input.LT(1);
        int aoCompositionDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token kw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs = null;

        MViewParser.refinementDeclaration_return refinementDeclaration25 = null;

        MViewParser.aoCompositionBody_return aoCompositionBody26 = null;


        Object kw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:325:2: ( (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclaration[$element,AOComposition.class] )? aoCompositionBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:325:4: (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclaration[$element,AOComposition.class] )? aoCompositionBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:325:4: (abs= abstractModifier )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==60) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:325:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_aoCompositionDeclaration764);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

            kw=(Token)match(input,32,FOLLOW_32_in_aoCompositionDeclaration770); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kw_tree = (Object)adaptor.create(kw);
            adaptor.addChild(root_0, kw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_aoCompositionDeclaration774); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:335:3: ( refinementDeclaration[$element,AOComposition.class] )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==50) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:335:4: refinementDeclaration[$element,AOComposition.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_aoCompositionDeclaration782);
                    refinementDeclaration25=refinementDeclaration(retval.element, AOComposition.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration25.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_aoCompositionBody_in_aoCompositionDeclaration789);
            aoCompositionBody26=aoCompositionBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aoCompositionBody26.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:340:1: aoCompositionBody[AOComposition element] : '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' ;
    public final MViewParser.aoCompositionBody_return aoCompositionBody(AOComposition element) throws RecognitionException {
        MViewParser.aoCompositionBody_return retval = new MViewParser.aoCompositionBody_return();
        retval.start = input.LT(1);
        int aoCompositionBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal27=null;
        Token char_literal28=null;
        MViewParser.pointcutDeclaration_return pc = null;

        MViewParser.adviceDeclaration_return adv = null;


        Object char_literal27_tree=null;
        Object char_literal28_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:341:2: ( '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:341:4: '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal27=(Token)match(input,24,FOLLOW_24_in_aoCompositionBody803); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal27_tree = (Object)adaptor.create(char_literal27);
            adaptor.addChild(root_0, char_literal27_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:342:5: (pc= pointcutDeclaration )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==33) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: pc= pointcutDeclaration
                    {
                    pushFollow(FOLLOW_pointcutDeclaration_in_aoCompositionBody810);
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:345:6: (adv= adviceDeclaration )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==43) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: adv= adviceDeclaration
                    {
                    pushFollow(FOLLOW_adviceDeclaration_in_aoCompositionBody819);
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
            char_literal28=(Token)match(input,25,FOLLOW_25_in_aoCompositionBody826); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:351:1: pointcutDeclaration returns [Pointcut pointcut] : pckw= 'pointcut' pointcutBody[$pointcut] ;
    public final MViewParser.pointcutDeclaration_return pointcutDeclaration() throws RecognitionException {
        MViewParser.pointcutDeclaration_return retval = new MViewParser.pointcutDeclaration_return();
        retval.start = input.LT(1);
        int pointcutDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token pckw=null;
        MViewParser.pointcutBody_return pointcutBody29 = null;


        Object pckw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:352:2: (pckw= 'pointcut' pointcutBody[$pointcut] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:352:4: pckw= 'pointcut' pointcutBody[$pointcut]
            {
            root_0 = (Object)adaptor.nil();

            pckw=(Token)match(input,33,FOLLOW_33_in_pointcutDeclaration843); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            pckw_tree = (Object)adaptor.create(pckw);
            adaptor.addChild(root_0, pckw_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.pointcut = new Pointcut();
              				setKeyword(retval.pointcut,pckw);
              			
            }
            pushFollow(FOLLOW_pointcutBody_in_pointcutDeclaration847);
            pointcutBody29=pointcutBody(retval.pointcut);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBody29.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:359:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
    public final MViewParser.pointcutBody_return pointcutBody(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutBody_return retval = new MViewParser.pointcutBody_return();
        retval.start = input.LT(1);
        int pointcutBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal30=null;
        Token char_literal32=null;
        MViewParser.pointcutBodyDeclaration_return pointcutBodyDeclaration31 = null;


        Object char_literal30_tree=null;
        Object char_literal32_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:360:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:360:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal30=(Token)match(input,24,FOLLOW_24_in_pointcutBody863); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal30_tree = (Object)adaptor.create(char_literal30);
            adaptor.addChild(root_0, char_literal30_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:360:8: ( pointcutBodyDeclaration[$pointcut] )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==34||(LA21_0>=36 && LA21_0<=38)||(LA21_0>=57 && LA21_0<=58)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: pointcutBodyDeclaration[$pointcut]
            	    {
            	    pushFollow(FOLLOW_pointcutBodyDeclaration_in_pointcutBody865);
            	    pointcutBodyDeclaration31=pointcutBodyDeclaration(pointcut);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBodyDeclaration31.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            char_literal32=(Token)match(input,25,FOLLOW_25_in_pointcutBody869); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal32_tree = (Object)adaptor.create(char_literal32);
            adaptor.addChild(root_0, char_literal32_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:364:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] );
    public final MViewParser.pointcutBodyDeclaration_return pointcutBodyDeclaration(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutBodyDeclaration_return retval = new MViewParser.pointcutBodyDeclaration_return();
        retval.start = input.LT(1);
        int pointcutBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.pointcutKindDeclaration_return pointcutKindDeclaration33 = null;

        MViewParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration34 = null;

        MViewParser.pointcutActorDeclaration_return pointcutActorDeclaration35 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:365:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt22=1;
                }
                break;
            case 36:
            case 57:
            case 58:
                {
                alt22=2;
                }
                break;
            case 37:
            case 38:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:365:4: pointcutKindDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration883);
                    pointcutKindDeclaration33=pointcutKindDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutKindDeclaration33.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:366:4: pointcutSignatureDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration889);
                    pointcutSignatureDeclaration34=pointcutSignatureDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureDeclaration34.getTree());

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:367:4: pointcutActorDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration895);
                    pointcutActorDeclaration35=pointcutActorDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorDeclaration35.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:371:1: pointcutKindDeclaration[Pointcut pointcut] : kikw= 'kind' ':' kind= joinPointKind ';' ;
    public final MViewParser.pointcutKindDeclaration_return pointcutKindDeclaration(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutKindDeclaration_return retval = new MViewParser.pointcutKindDeclaration_return();
        retval.start = input.LT(1);
        int pointcutKindDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token kikw=null;
        Token char_literal36=null;
        Token char_literal37=null;
        MViewParser.joinPointKind_return kind = null;


        Object kikw_tree=null;
        Object char_literal36_tree=null;
        Object char_literal37_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:372:2: (kikw= 'kind' ':' kind= joinPointKind ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:372:4: kikw= 'kind' ':' kind= joinPointKind ';'
            {
            root_0 = (Object)adaptor.nil();

            kikw=(Token)match(input,34,FOLLOW_34_in_pointcutKindDeclaration912); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kikw_tree = (Object)adaptor.create(kikw);
            adaptor.addChild(root_0, kikw_tree);
            }
            char_literal36=(Token)match(input,35,FOLLOW_35_in_pointcutKindDeclaration914); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal36_tree = (Object)adaptor.create(char_literal36);
            adaptor.addChild(root_0, char_literal36_tree);
            }
            pushFollow(FOLLOW_joinPointKind_in_pointcutKindDeclaration918);
            kind=joinPointKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, kind.getTree());
            char_literal37=(Token)match(input,26,FOLLOW_26_in_pointcutKindDeclaration920); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal37_tree = (Object)adaptor.create(char_literal37);
            adaptor.addChild(root_0, char_literal37_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:379:1: pointcutSignatureDeclaration[Pointcut element] : (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' ;
    public final MViewParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration(Pointcut element) throws RecognitionException {
        MViewParser.pointcutSignatureDeclaration_return retval = new MViewParser.pointcutSignatureDeclaration_return();
        retval.start = input.LT(1);
        int pointcutSignatureDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token sikw=null;
        Token char_literal38=null;
        Token char_literal39=null;
        MViewParser.overrideOrExtend_return override = null;

        MViewParser.pointcutSignatureBody_return ps = null;


        Object sikw_tree=null;
        Object char_literal38_tree=null;
        Object char_literal39_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:380:2: ( (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:380:4: (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:380:4: (override= overrideOrExtend )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=57 && LA23_0<=58)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:380:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration939);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

            sikw=(Token)match(input,36,FOLLOW_36_in_pointcutSignatureDeclaration945); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            sikw_tree = (Object)adaptor.create(sikw);
            adaptor.addChild(root_0, sikw_tree);
            }
            char_literal38=(Token)match(input,35,FOLLOW_35_in_pointcutSignatureDeclaration947); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal38_tree = (Object)adaptor.create(char_literal38);
            adaptor.addChild(root_0, char_literal38_tree);
            }
            pushFollow(FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration951);
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
            char_literal39=(Token)match(input,26,FOLLOW_26_in_pointcutSignatureDeclaration955); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal39_tree = (Object)adaptor.create(char_literal39);
            adaptor.addChild(root_0, char_literal39_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:391:1: pointcutSignatureBody returns [PointcutSignature element] : pointcutSignatureBodyDecls[$element] ;
    public final MViewParser.pointcutSignatureBody_return pointcutSignatureBody() throws RecognitionException {
        MViewParser.pointcutSignatureBody_return retval = new MViewParser.pointcutSignatureBody_return();
        retval.start = input.LT(1);
        int pointcutSignatureBody_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls40 = null;



         retval.element = new PointcutSignature(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:393:2: ( pointcutSignatureBodyDecls[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:393:4: pointcutSignatureBodyDecls[$element]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody974);
            pointcutSignatureBodyDecls40=pointcutSignatureBodyDecls(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureBodyDecls40.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:397:1: pointcutSignatureBodyDecls[PointcutSignature element] : pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? ;
    public final MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls(PointcutSignature element) throws RecognitionException {
        MViewParser.pointcutSignatureBodyDecls_return retval = new MViewParser.pointcutSignatureBodyDecls_return();
        retval.start = input.LT(1);
        int pointcutSignatureBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal41=null;
        MViewParser.pointcutServiceSignatureDecl_return pss = null;

        MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls42 = null;


        Object char_literal41_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:398:2: (pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:398:4: pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls991);
            pss=pointcutServiceSignatureDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pss.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:398:37: ( ',' pointcutSignatureBodyDecls[$element] )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==29) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:398:39: ',' pointcutSignatureBodyDecls[$element]
                    {
                    char_literal41=(Token)match(input,29,FOLLOW_29_in_pointcutSignatureBodyDecls995); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal41_tree = (Object)adaptor.create(char_literal41);
                    adaptor.addChild(root_0, char_literal41_tree);
                    }
                    pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls997);
                    pointcutSignatureBodyDecls42=pointcutSignatureBodyDecls(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureBodyDecls42.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:404:1: pointcutActorDeclaration[Pointcut pointcut] : (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody );
    public final MViewParser.pointcutActorDeclaration_return pointcutActorDeclaration(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutActorDeclaration_return retval = new MViewParser.pointcutActorDeclaration_return();
        retval.start = input.LT(1);
        int pointcutActorDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token clkw=null;
        MViewParser.pointcutActorBody_return actor = null;


        Object clkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:405:2: (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==37) ) {
                alt25=1;
            }
            else if ( (LA25_0==38) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:405:4: clkw= 'caller' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();

                    clkw=(Token)match(input,37,FOLLOW_37_in_pointcutActorDeclaration1019); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    clkw_tree = (Object)adaptor.create(clkw);
                    adaptor.addChild(root_0, clkw_tree);
                    }
                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1023);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:410:3: clkw= 'callee' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();

                    clkw=(Token)match(input,38,FOLLOW_38_in_pointcutActorDeclaration1034); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    clkw_tree = (Object)adaptor.create(clkw);
                    adaptor.addChild(root_0, clkw_tree);
                    }
                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1038);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:421:1: pointcutActorBody returns [Actor element] : '{' ( pointcutActorBodyDecls[$element] )* '}' ;
    public final MViewParser.pointcutActorBody_return pointcutActorBody() throws RecognitionException {
        MViewParser.pointcutActorBody_return retval = new MViewParser.pointcutActorBody_return();
        retval.start = input.LT(1);
        int pointcutActorBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal43=null;
        Token char_literal45=null;
        MViewParser.pointcutActorBodyDecls_return pointcutActorBodyDecls44 = null;


        Object char_literal43_tree=null;
        Object char_literal45_tree=null;


        	retval.element = new Actor();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:425:2: ( '{' ( pointcutActorBodyDecls[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:425:4: '{' ( pointcutActorBodyDecls[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal43=(Token)match(input,24,FOLLOW_24_in_pointcutActorBody1066); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal43_tree = (Object)adaptor.create(char_literal43);
            adaptor.addChild(root_0, char_literal43_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:425:8: ( pointcutActorBodyDecls[$element] )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==23||(LA26_0>=39 && LA26_0<=42)||(LA26_0>=57 && LA26_0<=58)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: pointcutActorBodyDecls[$element]
            	    {
            	    pushFollow(FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1068);
            	    pointcutActorBodyDecls44=pointcutActorBodyDecls(retval.element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorBodyDecls44.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            char_literal45=(Token)match(input,25,FOLLOW_25_in_pointcutActorBody1072); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal45_tree = (Object)adaptor.create(char_literal45);
            adaptor.addChild(root_0, char_literal45_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:429:1: pointcutActorBodyDecls[Actor actor] : (override= overrideOrExtend )? (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' ;
    public final MViewParser.pointcutActorBodyDecls_return pointcutActorBodyDecls(Actor actor) throws RecognitionException {
        MViewParser.pointcutActorBodyDecls_return retval = new MViewParser.pointcutActorBodyDecls_return();
        retval.start = input.LT(1);
        int pointcutActorBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token kw=null;
        Token char_literal46=null;
        Token char_literal47=null;
        Token char_literal48=null;
        Token char_literal49=null;
        Token char_literal50=null;
        Token char_literal52=null;
        MViewParser.overrideOrExtend_return override = null;

        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls51 = null;


        Object kw_tree=null;
        Object char_literal46_tree=null;
        Object char_literal47_tree=null;
        Object char_literal48_tree=null;
        Object char_literal49_tree=null;
        Object char_literal50_tree=null;
        Object char_literal52_tree=null;


        	ActorProp prop = null;
        	Token propKw = null;
        	Class<? extends Declaration> declClass = null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:435:2: ( (override= overrideOrExtend )? (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:435:4: (override= overrideOrExtend )? (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:435:4: (override= overrideOrExtend )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=57 && LA27_0<=58)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:435:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1093);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:436:2: (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' )
            int alt28=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt28=1;
                }
                break;
            case 39:
                {
                alt28=2;
                }
                break;
            case 40:
                {
                alt28=3;
                }
                break;
            case 41:
                {
                alt28=4;
                }
                break;
            case 42:
                {
                alt28=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:437:3: kw= 'interface' ':'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_pointcutActorBodyDecls1104); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
                    }
                    char_literal46=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1106); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal46_tree = (Object)adaptor.create(char_literal46);
                    adaptor.addChild(root_0, char_literal46_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Interface.class;
                      			propKw = kw;
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:442:3: kw= 'component' ':'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_pointcutActorBodyDecls1118); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
                    }
                    char_literal47=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1120); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    adaptor.addChild(root_0, char_literal47_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Component.class;
                      			propKw = kw;
                      		
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:447:3: kw= 'application' ':'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_pointcutActorBodyDecls1131); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
                    }
                    char_literal48=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1133); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal48_tree = (Object)adaptor.create(char_literal48);
                    adaptor.addChild(root_0, char_literal48_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Application.class;
                      			propKw = kw;
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:452:3: kw= 'instance' ':'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_pointcutActorBodyDecls1144); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
                    }
                    char_literal49=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1146); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    adaptor.addChild(root_0, char_literal49_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Instance.class;
                      			propKw = kw;
                      		
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:457:3: kw= 'host' ':'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_pointcutActorBodyDecls1157); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
                    }
                    char_literal50=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal50_tree = (Object)adaptor.create(char_literal50);
                    adaptor.addChild(root_0, char_literal50_tree);
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
            pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1168);
            pointcutActorPropDecls51=pointcutActorPropDecls(prop, declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls51.getTree());
            char_literal52=(Token)match(input,26,FOLLOW_26_in_pointcutActorBodyDecls1171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal52_tree = (Object)adaptor.create(char_literal52);
            adaptor.addChild(root_0, char_literal52_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:473:1: pointcutActorPropDecls[ActorProp prop,Class<? extends Declaration> declClass] : (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? ;
    public final MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls(ActorProp prop, Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecls_return retval = new MViewParser.pointcutActorPropDecls_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecls_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal53=null;
        MViewParser.negationModifier_return negate = null;

        MViewParser.pointcutActorPropDecl_return apdref = null;

        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls54 = null;


        Object char_literal53_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:474:2: ( (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:474:5: (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:474:5: (negate= negationModifier )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==59) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:474:6: negate= negationModifier
                    {
                    pushFollow(FOLLOW_negationModifier_in_pointcutActorPropDecls1188);
                    negate=negationModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, negate.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1194);
            apdref=pointcutActorPropDecl(declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, apdref.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:474:73: ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==29) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:474:75: ',' pointcutActorPropDecls[$prop,$declClass]
                    {
                    char_literal53=(Token)match(input,29,FOLLOW_29_in_pointcutActorPropDecls1199); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal53_tree = (Object)adaptor.create(char_literal53);
                    adaptor.addChild(root_0, char_literal53_tree);
                    }
                    pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1201);
                    pointcutActorPropDecls54=pointcutActorPropDecls(prop, declClass);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls54.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:485:1: pointcutActorPropDecl[Class<? extends Declaration> declClass] returns [SimpleReference<? extends Declaration> relation] : name= Identifier ;
    public final MViewParser.pointcutActorPropDecl_return pointcutActorPropDecl(Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecl_return retval = new MViewParser.pointcutActorPropDecl_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecl_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;

        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:486:2: (name= Identifier )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:486:5: name= Identifier
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutActorPropDecl1226); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:494:1: adviceDeclaration returns [Advice advice] : avkw= 'advice' adviceBody[$advice] ;
    public final MViewParser.adviceDeclaration_return adviceDeclaration() throws RecognitionException {
        MViewParser.adviceDeclaration_return retval = new MViewParser.adviceDeclaration_return();
        retval.start = input.LT(1);
        int adviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token avkw=null;
        MViewParser.adviceBody_return adviceBody55 = null;


        Object avkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:495:2: (avkw= 'advice' adviceBody[$advice] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:495:4: avkw= 'advice' adviceBody[$advice]
            {
            root_0 = (Object)adaptor.nil();

            avkw=(Token)match(input,43,FOLLOW_43_in_adviceDeclaration1249); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            avkw_tree = (Object)adaptor.create(avkw);
            adaptor.addChild(root_0, avkw_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.advice = new Advice();
              			setKeyword(retval.advice,avkw);
              		
            }
            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration1253);
            adviceBody55=adviceBody(retval.advice);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBody55.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:502:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
    public final MViewParser.adviceBody_return adviceBody(Advice advice) throws RecognitionException {
        MViewParser.adviceBody_return retval = new MViewParser.adviceBody_return();
        retval.start = input.LT(1);
        int adviceBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal56=null;
        Token char_literal58=null;
        MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration57 = null;


        Object char_literal56_tree=null;
        Object char_literal58_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:503:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:503:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal56=(Token)match(input,24,FOLLOW_24_in_adviceBody1268); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal56_tree = (Object)adaptor.create(char_literal56);
            adaptor.addChild(root_0, char_literal56_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:503:8: ( adviceBodyDeclaration[$advice] )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==41||(LA31_0>=44 && LA31_0<=45)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: adviceBodyDeclaration[$advice]
            	    {
            	    pushFollow(FOLLOW_adviceBodyDeclaration_in_adviceBody1270);
            	    adviceBodyDeclaration57=adviceBodyDeclaration(advice);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBodyDeclaration57.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            char_literal58=(Token)match(input,25,FOLLOW_25_in_adviceBody1274); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal58_tree = (Object)adaptor.create(char_literal58);
            adaptor.addChild(root_0, char_literal58_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:507:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] | adviceInstanceDeclaration[$advice] );
    public final MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceBodyDeclaration_return retval = new MViewParser.adviceBodyDeclaration_return();
        retval.start = input.LT(1);
        int adviceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration59 = null;

        MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration60 = null;

        MViewParser.adviceInstanceDeclaration_return adviceInstanceDeclaration61 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:508:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] | adviceInstanceDeclaration[$advice] )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt32=1;
                }
                break;
            case 45:
                {
                alt32=2;
                }
                break;
            case 41:
                {
                alt32=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:508:4: adviceServiceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1289);
                    adviceServiceDeclaration59=adviceServiceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceServiceDeclaration59.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:509:4: adviceTypeDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1295);
                    adviceTypeDeclaration60=adviceTypeDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceTypeDeclaration60.getTree());

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:510:4: adviceInstanceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceInstanceDeclaration_in_adviceBodyDeclaration1301);
                    adviceInstanceDeclaration61=adviceInstanceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceInstanceDeclaration61.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:514:1: adviceServiceDeclaration[Advice advice] : svkw= 'method' ':' service= serviceReferenceDeclaration ';' ;
    public final MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceServiceDeclaration_return retval = new MViewParser.adviceServiceDeclaration_return();
        retval.start = input.LT(1);
        int adviceServiceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token svkw=null;
        Token char_literal62=null;
        Token char_literal63=null;
        MViewParser.serviceReferenceDeclaration_return service = null;


        Object svkw_tree=null;
        Object char_literal62_tree=null;
        Object char_literal63_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:515:2: (svkw= 'method' ':' service= serviceReferenceDeclaration ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:515:4: svkw= 'method' ':' service= serviceReferenceDeclaration ';'
            {
            root_0 = (Object)adaptor.nil();

            svkw=(Token)match(input,44,FOLLOW_44_in_adviceServiceDeclaration1319); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            svkw_tree = (Object)adaptor.create(svkw);
            adaptor.addChild(root_0, svkw_tree);
            }
            char_literal62=(Token)match(input,35,FOLLOW_35_in_adviceServiceDeclaration1321); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal62_tree = (Object)adaptor.create(char_literal62);
            adaptor.addChild(root_0, char_literal62_tree);
            }
            pushFollow(FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1325);
            service=serviceReferenceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal63=(Token)match(input,26,FOLLOW_26_in_adviceServiceDeclaration1327); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal63_tree = (Object)adaptor.create(char_literal63);
            adaptor.addChild(root_0, char_literal63_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:522:1: adviceTypeDeclaration[Advice advice] : tpkw= 'type' ':' avtype= adviceType ';' ;
    public final MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceTypeDeclaration_return retval = new MViewParser.adviceTypeDeclaration_return();
        retval.start = input.LT(1);
        int adviceTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token tpkw=null;
        Token char_literal64=null;
        Token char_literal65=null;
        MViewParser.adviceType_return avtype = null;


        Object tpkw_tree=null;
        Object char_literal64_tree=null;
        Object char_literal65_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:523:2: (tpkw= 'type' ':' avtype= adviceType ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:523:4: tpkw= 'type' ':' avtype= adviceType ';'
            {
            root_0 = (Object)adaptor.nil();

            tpkw=(Token)match(input,45,FOLLOW_45_in_adviceTypeDeclaration1346); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tpkw_tree = (Object)adaptor.create(tpkw);
            adaptor.addChild(root_0, tpkw_tree);
            }
            char_literal64=(Token)match(input,35,FOLLOW_35_in_adviceTypeDeclaration1348); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
            }
            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration1352);
            avtype=adviceType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, avtype.getTree());
            char_literal65=(Token)match(input,26,FOLLOW_26_in_adviceTypeDeclaration1354); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = (Object)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:529:1: adviceInstanceDeclaration[Advice advice] : inskw= 'instance' ':' instance= instanceReferenceDeclaration ';' ;
    public final MViewParser.adviceInstanceDeclaration_return adviceInstanceDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceInstanceDeclaration_return retval = new MViewParser.adviceInstanceDeclaration_return();
        retval.start = input.LT(1);
        int adviceInstanceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token inskw=null;
        Token char_literal66=null;
        Token char_literal67=null;
        MViewParser.instanceReferenceDeclaration_return instance = null;


        Object inskw_tree=null;
        Object char_literal66_tree=null;
        Object char_literal67_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:530:2: (inskw= 'instance' ':' instance= instanceReferenceDeclaration ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:530:4: inskw= 'instance' ':' instance= instanceReferenceDeclaration ';'
            {
            root_0 = (Object)adaptor.nil();

            inskw=(Token)match(input,41,FOLLOW_41_in_adviceInstanceDeclaration1370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            inskw_tree = (Object)adaptor.create(inskw);
            adaptor.addChild(root_0, inskw_tree);
            }
            char_literal66=(Token)match(input,35,FOLLOW_35_in_adviceInstanceDeclaration1372); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal66_tree = (Object)adaptor.create(char_literal66);
            adaptor.addChild(root_0, char_literal66_tree);
            }
            pushFollow(FOLLOW_instanceReferenceDeclaration_in_adviceInstanceDeclaration1376);
            instance=instanceReferenceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, instance.getTree());
            char_literal67=(Token)match(input,26,FOLLOW_26_in_adviceInstanceDeclaration1378); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal67_tree = (Object)adaptor.create(char_literal67);
            adaptor.addChild(root_0, char_literal67_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:536:1: instanceReferenceDeclaration returns [SimpleReference<Instance> relation] : name= Identifier ;
    public final MViewParser.instanceReferenceDeclaration_return instanceReferenceDeclaration() throws RecognitionException {
        MViewParser.instanceReferenceDeclaration_return retval = new MViewParser.instanceReferenceDeclaration_return();
        retval.start = input.LT(1);
        int instanceReferenceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;

        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:537:2: (name= Identifier )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:537:5: name= Identifier
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceReferenceDeclaration1399); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:548:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier ( refinementDeclaration[$element,Component.class] )? componentBody[$element] ;
    public final MViewParser.componentDeclaration_return componentDeclaration() throws RecognitionException {
        MViewParser.componentDeclaration_return retval = new MViewParser.componentDeclaration_return();
        retval.start = input.LT(1);
        int componentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token compkw=null;
        Token name=null;
        MViewParser.refinementDeclaration_return refinementDeclaration68 = null;

        MViewParser.componentBody_return componentBody69 = null;


        Object compkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:549:2: (compkw= 'component' name= Identifier ( refinementDeclaration[$element,Component.class] )? componentBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:549:5: compkw= 'component' name= Identifier ( refinementDeclaration[$element,Component.class] )? componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            compkw=(Token)match(input,39,FOLLOW_39_in_componentDeclaration1426); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            compkw_tree = (Object)adaptor.create(compkw);
            adaptor.addChild(root_0, compkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration1430); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                 			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                 			setKeyword(retval.element,compkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:554:3: ( refinementDeclaration[$element,Component.class] )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==50) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:554:4: refinementDeclaration[$element,Component.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_componentDeclaration1438);
                    refinementDeclaration68=refinementDeclaration(retval.element, Component.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration68.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_componentBody_in_componentDeclaration1445);
            componentBody69=componentBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBody69.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:559:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
    public final MViewParser.componentBody_return componentBody(Component element) throws RecognitionException {
        MViewParser.componentBody_return retval = new MViewParser.componentBody_return();
        retval.start = input.LT(1);
        int componentBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal70=null;
        Token char_literal72=null;
        MViewParser.componentBodyDeclaration_return componentBodyDeclaration71 = null;


        Object char_literal70_tree=null;
        Object char_literal72_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:560:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:560:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal70=(Token)match(input,24,FOLLOW_24_in_componentBody1467); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal70_tree = (Object)adaptor.create(char_literal70);
            adaptor.addChild(root_0, char_literal70_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:560:8: ( componentBodyDeclaration[$element] )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=46 && LA34_0<=47)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody1469);
            	    componentBodyDeclaration71=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration71.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            char_literal72=(Token)match(input,25,FOLLOW_25_in_componentBody1473); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal72_tree = (Object)adaptor.create(char_literal72);
            adaptor.addChild(root_0, char_literal72_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:564:1: componentBodyDeclaration[Component element] : ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] );
    public final MViewParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MViewParser.componentBodyDeclaration_return retval = new MViewParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);
        int componentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration73 = null;

        MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration74 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:565:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==46) ) {
                alt35=1;
            }
            else if ( (LA35_0==47) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:565:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1491);
                    moduleRequireDependencyDeclaration73=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration73.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:566:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1497);
                    moduleProvideDependencyDeclaration74=moduleProvideDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleProvideDependencyDeclaration74.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:576:1: moduleDependencyBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' ;
    public final MViewParser.moduleDependencyBody_return moduleDependencyBody() throws RecognitionException {
        MViewParser.moduleDependencyBody_return retval = new MViewParser.moduleDependencyBody_return();
        retval.start = input.LT(1);
        int moduleDependencyBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal75=null;
        Token char_literal76=null;
        MViewParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal75_tree=null;
        Object char_literal76_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:578:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:578:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal75=(Token)match(input,24,FOLLOW_24_in_moduleDependencyBody1525); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal75_tree = (Object)adaptor.create(char_literal75);
            adaptor.addChild(root_0, char_literal75_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:578:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==Identifier) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:578:9: decls= commaSeparatedBodyDecls[Interface.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1530);
                    decls=commaSeparatedBodyDecls(Interface.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                      retval.elements =(decls!=null?decls.elements:null); 
                    }

                    }
                    break;

            }

            char_literal76=(Token)match(input,25,FOLLOW_25_in_moduleDependencyBody1538); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal76_tree = (Object)adaptor.create(char_literal76);
            adaptor.addChild(root_0, char_literal76_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:582:1: moduleRequireDependencyDeclaration[Module element] : rekw= 'require' rd= moduleDependencyBody ;
    public final MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration(Module element) throws RecognitionException {
        MViewParser.moduleRequireDependencyDeclaration_return retval = new MViewParser.moduleRequireDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleRequireDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token rekw=null;
        MViewParser.moduleDependencyBody_return rd = null;


        Object rekw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:583:2: (rekw= 'require' rd= moduleDependencyBody )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:583:4: rekw= 'require' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            rekw=(Token)match(input,46,FOLLOW_46_in_moduleRequireDependencyDeclaration1555); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rekw_tree = (Object)adaptor.create(rekw);
            adaptor.addChild(root_0, rekw_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1559);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:591:1: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
    public final MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration(Module element) throws RecognitionException {
        MViewParser.moduleProvideDependencyDeclaration_return retval = new MViewParser.moduleProvideDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleProvideDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal77=null;
        MViewParser.moduleDependencyBody_return rd = null;


        Object string_literal77_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:592:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:592:4: 'provide' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal77=(Token)match(input,47,FOLLOW_47_in_moduleProvideDependencyDeclaration1574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal77_tree = (Object)adaptor.create(string_literal77);
            adaptor.addChild(root_0, string_literal77_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1578);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:631:1: applicationDeclaration returns [Application element] : (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] ;
    public final MViewParser.applicationDeclaration_return applicationDeclaration() throws RecognitionException {
        MViewParser.applicationDeclaration_return retval = new MViewParser.applicationDeclaration_return();
        retval.start = input.LT(1);
        int applicationDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token appkw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs = null;

        MViewParser.refinementDeclaration_return refinementDeclaration78 = null;

        MViewParser.applicationBody_return applicationBody79 = null;


        Object appkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:632:2: ( (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:632:4: (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:632:4: (abs= abstractModifier )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==60) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:632:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_applicationDeclaration1611);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

            appkw=(Token)match(input,40,FOLLOW_40_in_applicationDeclaration1617); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_applicationDeclaration1621); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:642:3: ( refinementDeclaration[$element,Application.class] )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==50) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:642:4: refinementDeclaration[$element,Application.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_applicationDeclaration1629);
                    refinementDeclaration78=refinementDeclaration(retval.element, Application.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration78.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_applicationBody_in_applicationDeclaration1636);
            applicationBody79=applicationBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBody79.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:647:1: applicationBody[Application element] : '{' ( applicationBodyDeclaration[$element] )* '}' ;
    public final MViewParser.applicationBody_return applicationBody(Application element) throws RecognitionException {
        MViewParser.applicationBody_return retval = new MViewParser.applicationBody_return();
        retval.start = input.LT(1);
        int applicationBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal80=null;
        Token char_literal82=null;
        MViewParser.applicationBodyDeclaration_return applicationBodyDeclaration81 = null;


        Object char_literal80_tree=null;
        Object char_literal82_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:648:2: ( '{' ( applicationBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:648:4: '{' ( applicationBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal80=(Token)match(input,24,FOLLOW_24_in_applicationBody1650); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal80_tree = (Object)adaptor.create(char_literal80);
            adaptor.addChild(root_0, char_literal80_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:648:8: ( applicationBodyDeclaration[$element] )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==Identifier||LA39_0==31||LA39_0==39||LA39_0==42||LA39_0==60) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:648:10: applicationBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_applicationBodyDeclaration_in_applicationBody1654);
            	    applicationBodyDeclaration81=applicationBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBodyDeclaration81.getTree());

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            char_literal82=(Token)match(input,25,FOLLOW_25_in_applicationBody1660); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal82_tree = (Object)adaptor.create(char_literal82);
            adaptor.addChild(root_0, char_literal82_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:652:1: applicationBodyDeclaration[Application element] : (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration );
    public final MViewParser.applicationBodyDeclaration_return applicationBodyDeclaration(Application element) throws RecognitionException {
        MViewParser.applicationBodyDeclaration_return retval = new MViewParser.applicationBodyDeclaration_return();
        retval.start = input.LT(1);
        int applicationBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.moduleContainerDeclarations_return mod = null;

        MViewParser.hostDeclaration_return hod = null;

        MViewParser.instanceDeclaration_return ind = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:653:2: (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 31:
            case 39:
            case 60:
                {
                alt40=1;
                }
                break;
            case 42:
                {
                alt40=2;
                }
                break;
            case Identifier:
                {
                alt40=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:653:4: mod= moduleContainerDeclarations
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1676);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:657:3: hod= hostDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hostDeclaration_in_applicationBodyDeclaration1687);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:661:3: ind= instanceDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1699);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:693:1: instanceDeclaration returns [Instance element] : ref= qualifiedDeclarationReference[Module.class] name= Identifier onkw= 'on' hst= Identifier ';' ;
    public final MViewParser.instanceDeclaration_return instanceDeclaration() throws RecognitionException {
        MViewParser.instanceDeclaration_return retval = new MViewParser.instanceDeclaration_return();
        retval.start = input.LT(1);
        int instanceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token onkw=null;
        Token hst=null;
        Token char_literal83=null;
        MViewParser.qualifiedDeclarationReference_return ref = null;


        Object name_tree=null;
        Object onkw_tree=null;
        Object hst_tree=null;
        Object char_literal83_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:694:2: (ref= qualifiedDeclarationReference[Module.class] name= Identifier onkw= 'on' hst= Identifier ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:694:4: ref= qualifiedDeclarationReference[Module.class] name= Identifier onkw= 'on' hst= Identifier ';'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_qualifiedDeclarationReference_in_instanceDeclaration1732);
            ref=qualifiedDeclarationReference(Module.class);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ref.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1737); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            onkw=(Token)match(input,48,FOLLOW_48_in_instanceDeclaration1741); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            onkw_tree = (Object)adaptor.create(onkw);
            adaptor.addChild(root_0, onkw_tree);
            }
            hst=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1745); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hst_tree = (Object)adaptor.create(hst);
            adaptor.addChild(root_0, hst_tree);
            }
            char_literal83=(Token)match(input,26,FOLLOW_26_in_instanceDeclaration1747); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal83_tree = (Object)adaptor.create(char_literal83);
            adaptor.addChild(root_0, char_literal83_tree);
            }
            if ( state.backtracking==0 ) {

              	
              			retval.element = new Instance(new SimpleNameSignature((name!=null?name.getText():null)));
              			setLocation(retval.element,name,"__NAME");

              			SimpleReference<Module> relation = (ref!=null?ref.reference:null);
              			//new SimpleReference<Module>($tpe.text,Module.class);
              			if (relation != null) {
              				retval.element.setType(relation);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:720:1: hostDeclaration returns [Host element] : hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';' ;
    public final MViewParser.hostDeclaration_return hostDeclaration() throws RecognitionException {
        MViewParser.hostDeclaration_return retval = new MViewParser.hostDeclaration_return();
        retval.start = input.LT(1);
        int hostDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token hkw=null;
        Token name=null;
        Token onkw=null;
        Token value=null;
        Token char_literal84=null;

        Object hkw_tree=null;
        Object name_tree=null;
        Object onkw_tree=null;
        Object value_tree=null;
        Object char_literal84_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:721:2: (hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:721:5: hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';'
            {
            root_0 = (Object)adaptor.nil();

            hkw=(Token)match(input,42,FOLLOW_42_in_hostDeclaration1774); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hkw_tree = (Object)adaptor.create(hkw);
            adaptor.addChild(root_0, hkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_hostDeclaration1778); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			
              			retval.element = new Host(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,hkw);
              			setLocation(retval.element,name,"__NAME");
              			
              		
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:727:5: (onkw= 'is' value= StringLiteral )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==49) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:727:7: onkw= 'is' value= StringLiteral
                    {
                    onkw=(Token)match(input,49,FOLLOW_49_in_hostDeclaration1786); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    onkw_tree = (Object)adaptor.create(onkw);
                    adaptor.addChild(root_0, onkw_tree);
                    }
                    value=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_hostDeclaration1790); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    value_tree = (Object)adaptor.create(value);
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

            char_literal84=(Token)match(input,26,FOLLOW_26_in_hostDeclaration1797); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal84_tree = (Object)adaptor.create(char_literal84);
            adaptor.addChild(root_0, char_literal84_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:741:1: moduleContainerDeclarations returns [Module element] : (cod= componentDeclaration | cnd= connectorDeclaration );
    public final MViewParser.moduleContainerDeclarations_return moduleContainerDeclarations() throws RecognitionException {
        MViewParser.moduleContainerDeclarations_return retval = new MViewParser.moduleContainerDeclarations_return();
        retval.start = input.LT(1);
        int moduleContainerDeclarations_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.componentDeclaration_return cod = null;

        MViewParser.connectorDeclaration_return cnd = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:742:2: (cod= componentDeclaration | cnd= connectorDeclaration )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==39) ) {
                alt42=1;
            }
            else if ( (LA42_0==31||LA42_0==60) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:743:3: cod= componentDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_componentDeclaration_in_moduleContainerDeclarations1822);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:747:3: cnd= connectorDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1833);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:774:1: refinementDeclarationSingle[RefinableDeclaration element, Class kind] : rfkw= 'refines' rel= refinementDeclarationBody[$kind] ;
    public final MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementDeclarationSingle_return retval = new MViewParser.refinementDeclarationSingle_return();
        retval.start = input.LT(1);
        int refinementDeclarationSingle_StartIndex = input.index();
        Object root_0 = null;

        Token rfkw=null;
        MViewParser.refinementDeclarationBody_return rel = null;


        Object rfkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:775:2: (rfkw= 'refines' rel= refinementDeclarationBody[$kind] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:775:4: rfkw= 'refines' rel= refinementDeclarationBody[$kind]
            {
            root_0 = (Object)adaptor.nil();

            rfkw=(Token)match(input,50,FOLLOW_50_in_refinementDeclarationSingle1858); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rfkw_tree = (Object)adaptor.create(rfkw);
            adaptor.addChild(root_0, rfkw_tree);
            }
            pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1862);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:782:1: refinementDeclaration[RefinableDeclaration element, Class kind] : refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )* ;
    public final MViewParser.refinementDeclaration_return refinementDeclaration(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementDeclaration_return retval = new MViewParser.refinementDeclaration_return();
        retval.start = input.LT(1);
        int refinementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal86=null;
        MViewParser.refinementDeclarationBody_return rel = null;

        MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle85 = null;


        Object char_literal86_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:783:2: ( refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:783:4: refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1879);
            refinementDeclarationSingle85=refinementDeclarationSingle(element, kind);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationSingle85.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:783:48: ( ',' rel= refinementDeclarationBody[$kind] )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==29) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:783:50: ',' rel= refinementDeclarationBody[$kind]
            	    {
            	    char_literal86=(Token)match(input,29,FOLLOW_29_in_refinementDeclaration1884); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal86_tree = (Object)adaptor.create(char_literal86);
            	    adaptor.addChild(root_0, char_literal86_tree);
            	    }
            	    pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclaration1888);
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
            	    break loop43;
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:789:1: refinementDeclarationBody[Class kind] returns [RefinementRelation relation] : parent= qualifiedDeclarationReference[$kind] ;
    public final MViewParser.refinementDeclarationBody_return refinementDeclarationBody(Class kind) throws RecognitionException {
        MViewParser.refinementDeclarationBody_return retval = new MViewParser.refinementDeclarationBody_return();
        retval.start = input.LT(1);
        int refinementDeclarationBody_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.qualifiedDeclarationReference_return parent = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:790:2: (parent= qualifiedDeclarationReference[$kind] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:790:4: parent= qualifiedDeclarationReference[$kind]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_qualifiedDeclarationReference_in_refinementDeclarationBody1916);
            parent=qualifiedDeclarationReference(kind);

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
            if ( state.backtracking>0 ) { memoize(input, 54, refinementDeclarationBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "refinementDeclarationBody"

    public static class qualifiedDeclarationReference_return extends ParserRuleReturnScope {
        public SimpleReference reference;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifiedDeclarationReference"
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:800:1: qualifiedDeclarationReference[Class kind] returns [SimpleReference reference] : name= Identifier ( '.' namex= Identifier )* ;
    public final MViewParser.qualifiedDeclarationReference_return qualifiedDeclarationReference(Class kind) throws RecognitionException {
        MViewParser.qualifiedDeclarationReference_return retval = new MViewParser.qualifiedDeclarationReference_return();
        retval.start = input.LT(1);
        int qualifiedDeclarationReference_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal87=null;

        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal87_tree=null;


        	Token start = null; 
        	Token end = null;
        	SimpleReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:809:2: (name= Identifier ( '.' namex= Identifier )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:809:4: name= Identifier ( '.' namex= Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_qualifiedDeclarationReference1949); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.reference = new SimpleReference((name!=null?name.getText():null),kind);
              			target = new SimpleReference((name!=null?name.getText():null),RefinableDeclaration.class);
              			start = name;
              			end = name;
              		
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:815:3: ( '.' namex= Identifier )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==51) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:815:4: '.' namex= Identifier
            	    {
            	    char_literal87=(Token)match(input,51,FOLLOW_51_in_qualifiedDeclarationReference1956); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal87_tree = (Object)adaptor.create(char_literal87);
            	    adaptor.addChild(root_0, char_literal87_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_qualifiedDeclarationReference1960); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    namex_tree = (Object)adaptor.create(namex);
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
            	    break loop44;
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
            if ( state.backtracking>0 ) { memoize(input, 55, qualifiedDeclarationReference_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "qualifiedDeclarationReference"

    public static class commaSeparatedBodyDecls_return extends ParserRuleReturnScope {
        public List<SimpleReference> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "commaSeparatedBodyDecls"
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:830:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
    public final MViewParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls(Class targetType) throws RecognitionException {
        MViewParser.commaSeparatedBodyDecls_return retval = new MViewParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);
        int commaSeparatedBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token char_literal88=null;
        MViewParser.commaSeparatedBodyDecls_return decls = null;


        Object id_tree=null;
        Object char_literal88_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:832:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:832:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls1991); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:832:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==29) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:832:19: ',' decls= commaSeparatedBodyDecls[$targetType]
                    {
                    char_literal88=(Token)match(input,29,FOLLOW_29_in_commaSeparatedBodyDecls1994); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal88_tree = (Object)adaptor.create(char_literal88);
                    adaptor.addChild(root_0, char_literal88_tree);
                    }
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1998);
                    decls=commaSeparatedBodyDecls(targetType);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                      retval.elements =(decls!=null?decls.elements:null);
                    }

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:846:1: adviceType returns [Modifier value] : ( 'before' | 'after' | 'around' );
    public final MViewParser.adviceType_return adviceType() throws RecognitionException {
        MViewParser.adviceType_return retval = new MViewParser.adviceType_return();
        retval.start = input.LT(1);
        int adviceType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal89=null;
        Token string_literal90=null;
        Token string_literal91=null;

        Object string_literal89_tree=null;
        Object string_literal90_tree=null;
        Object string_literal91_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:847:2: ( 'before' | 'after' | 'around' )
            int alt46=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt46=1;
                }
                break;
            case 53:
                {
                alt46=2;
                }
                break;
            case 54:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:847:4: 'before'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal89=(Token)match(input,52,FOLLOW_52_in_adviceType2027); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = (Object)adaptor.create(string_literal89);
                    adaptor.addChild(root_0, string_literal89_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Before();
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:848:4: 'after'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal90=(Token)match(input,53,FOLLOW_53_in_adviceType2034); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = (Object)adaptor.create(string_literal90);
                    adaptor.addChild(root_0, string_literal90_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new After();
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:849:4: 'around'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal91=(Token)match(input,54,FOLLOW_54_in_adviceType2041); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal91_tree = (Object)adaptor.create(string_literal91);
                    adaptor.addChild(root_0, string_literal91_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Around();
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:853:1: joinPointKind returns [Modifier value] : ( 'execution' | 'call' );
    public final MViewParser.joinPointKind_return joinPointKind() throws RecognitionException {
        MViewParser.joinPointKind_return retval = new MViewParser.joinPointKind_return();
        retval.start = input.LT(1);
        int joinPointKind_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal92=null;
        Token string_literal93=null;

        Object string_literal92_tree=null;
        Object string_literal93_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:854:2: ( 'execution' | 'call' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==55) ) {
                alt47=1;
            }
            else if ( (LA47_0==56) ) {
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:854:4: 'execution'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal92=(Token)match(input,55,FOLLOW_55_in_joinPointKind2061); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (Object)adaptor.create(string_literal92);
                    adaptor.addChild(root_0, string_literal92_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Execution();
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:855:4: 'call'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal93=(Token)match(input,56,FOLLOW_56_in_joinPointKind2068); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal93_tree = (Object)adaptor.create(string_literal93);
                    adaptor.addChild(root_0, string_literal93_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Call();
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:859:1: overrideOrExtend returns [Modifier value] : (okw= 'override' | ekw= 'merge' );
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:860:2: (okw= 'override' | ekw= 'merge' )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==57) ) {
                alt48=1;
            }
            else if ( (LA48_0==58) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:860:4: okw= 'override'
                    {
                    root_0 = (Object)adaptor.nil();

                    okw=(Token)match(input,57,FOLLOW_57_in_overrideOrExtend2090); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    okw_tree = (Object)adaptor.create(okw);
                    adaptor.addChild(root_0, okw_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Overridable(); setKeyword(retval.value,okw); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:861:4: ekw= 'merge'
                    {
                    root_0 = (Object)adaptor.nil();

                    ekw=(Token)match(input,58,FOLLOW_58_in_overrideOrExtend2099); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ekw_tree = (Object)adaptor.create(ekw);
                    adaptor.addChild(root_0, ekw_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Extendable(); setKeyword(retval.value,ekw); 
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:865:1: negationModifier returns [Modifier value] : '!' ;
    public final MViewParser.negationModifier_return negationModifier() throws RecognitionException {
        MViewParser.negationModifier_return retval = new MViewParser.negationModifier_return();
        retval.start = input.LT(1);
        int negationModifier_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal94=null;

        Object char_literal94_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:866:2: ( '!' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:866:5: '!'
            {
            root_0 = (Object)adaptor.nil();

            char_literal94=(Token)match(input,59,FOLLOW_59_in_negationModifier2119); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal94_tree = (Object)adaptor.create(char_literal94);
            adaptor.addChild(root_0, char_literal94_tree);
            }
            if ( state.backtracking==0 ) {
              retval.value = new Negate(); 
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:869:1: abstractModifier returns [Modifier value] : akw= 'abstract' ;
    public final MViewParser.abstractModifier_return abstractModifier() throws RecognitionException {
        MViewParser.abstractModifier_return retval = new MViewParser.abstractModifier_return();
        retval.start = input.LT(1);
        int abstractModifier_StartIndex = input.index();
        Object root_0 = null;

        Token akw=null;

        Object akw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:870:2: (akw= 'abstract' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:870:4: akw= 'abstract'
            {
            root_0 = (Object)adaptor.nil();

            akw=(Token)match(input,60,FOLLOW_60_in_abstractModifier2139); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            akw_tree = (Object)adaptor.create(akw);
            adaptor.addChild(root_0, akw_tree);
            }
            if ( state.backtracking==0 ) {
              retval.value = new Abstract(); setKeyword(retval.value,akw); 
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:873:1: voidType returns [BasicTypeReference value] : 'void' ;
    public final MViewParser.voidType_return voidType() throws RecognitionException {
        MViewParser.voidType_return retval = new MViewParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal95=null;

        Object string_literal95_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:875:5: ( 'void' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:875:7: 'void'
            {
            root_0 = (Object)adaptor.nil();

            string_literal95=(Token)match(input,61,FOLLOW_61_in_voidType2162); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal95_tree = (Object)adaptor.create(string_literal95);
            adaptor.addChild(root_0, string_literal95_tree);
            }
            if ( state.backtracking==0 ) {
              retval.value =new BasicTypeReference("void");
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:884:1: type returns [BasicTypeReference value] : (cd= classOrInterfaceType | pt= primitiveType );
    public final MViewParser.type_return type() throws RecognitionException {
        MViewParser.type_return retval = new MViewParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.classOrInterfaceType_return cd = null;

        MViewParser.primitiveType_return pt = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:886:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==Identifier) ) {
                alt49=1;
            }
            else if ( ((LA49_0>=62 && LA49_0<=69)) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:886:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceType_in_type2194);
                    cd=classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cd.getTree());
                    if ( state.backtracking==0 ) {
                      retval.value = (cd!=null?cd.element:null);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:887:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveType_in_type2203);
                    pt=primitiveType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pt.getTree());
                    if ( state.backtracking==0 ) {
                      retval.value = (pt!=null?pt.value:null);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
              setLocation(retval.value, ((Token)retval.start), ((Token)retval.stop));
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:891:1: classOrInterfaceType returns [BasicTypeReference element] : name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* ;
    public final MViewParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MViewParser.classOrInterfaceType_return retval = new MViewParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal97=null;
        MViewParser.typeArguments_return typeArguments96 = null;

        MViewParser.typeArguments_return typeArguments98 = null;


        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal97_tree=null;

        NamedTarget target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:893:2: (name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:893:4: name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new MViewBasicTypeReference((name!=null?name.getText():null));
              	           target =  new NamedTarget((name!=null?name.getText():null));
              	           setLocation(retval.element,name,name); 
              	          
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:899:4: ( typeArguments )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==70) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2247);
                    typeArguments96=typeArguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments96.getTree());

                    }
                    break;

            }

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:900:10: ( '.' namex= Identifier ( typeArguments )? )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==51) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:900:11: '.' namex= Identifier ( typeArguments )?
            	    {
            	    char_literal97=(Token)match(input,51,FOLLOW_51_in_classOrInterfaceType2261); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal97_tree = (Object)adaptor.create(char_literal97);
            	    adaptor.addChild(root_0, char_literal97_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2265); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    namex_tree = (Object)adaptor.create(namex);
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
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:911:11: ( typeArguments )?
            	    int alt51=2;
            	    int LA51_0 = input.LA(1);

            	    if ( (LA51_0==70) ) {
            	        alt51=1;
            	    }
            	    switch (alt51) {
            	        case 1 :
            	            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2291);
            	            typeArguments98=typeArguments();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments98.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:915:1: primitiveType returns [BasicTypeReference value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MViewParser.primitiveType_return primitiveType() throws RecognitionException {
        MViewParser.primitiveType_return retval = new MViewParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal99=null;
        Token string_literal100=null;
        Token string_literal101=null;
        Token string_literal102=null;
        Token string_literal103=null;
        Token string_literal104=null;
        Token string_literal105=null;
        Token string_literal106=null;

        Object string_literal99_tree=null;
        Object string_literal100_tree=null;
        Object string_literal101_tree=null;
        Object string_literal102_tree=null;
        Object string_literal103_tree=null;
        Object string_literal104_tree=null;
        Object string_literal105_tree=null;
        Object string_literal106_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:916:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt53=8;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt53=1;
                }
                break;
            case 63:
                {
                alt53=2;
                }
                break;
            case 64:
                {
                alt53=3;
                }
                break;
            case 65:
                {
                alt53=4;
                }
                break;
            case 66:
                {
                alt53=5;
                }
                break;
            case 67:
                {
                alt53=6;
                }
                break;
            case 68:
                {
                alt53=7;
                }
                break;
            case 69:
                {
                alt53=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:916:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal99=(Token)match(input,62,FOLLOW_62_in_primitiveType2316); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal99_tree = (Object)adaptor.create(string_literal99);
                    adaptor.addChild(root_0, string_literal99_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:917:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal100=(Token)match(input,63,FOLLOW_63_in_primitiveType2328); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal100_tree = (Object)adaptor.create(string_literal100);
                    adaptor.addChild(root_0, string_literal100_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("char");
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:918:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal101=(Token)match(input,64,FOLLOW_64_in_primitiveType2340); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal101_tree = (Object)adaptor.create(string_literal101);
                    adaptor.addChild(root_0, string_literal101_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("byte");
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:919:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal102=(Token)match(input,65,FOLLOW_65_in_primitiveType2352); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal102_tree = (Object)adaptor.create(string_literal102);
                    adaptor.addChild(root_0, string_literal102_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("short");
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:920:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal103=(Token)match(input,66,FOLLOW_66_in_primitiveType2364); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal103_tree = (Object)adaptor.create(string_literal103);
                    adaptor.addChild(root_0, string_literal103_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("int");
                    }

                    }
                    break;
                case 6 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:921:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal104=(Token)match(input,67,FOLLOW_67_in_primitiveType2376); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal104_tree = (Object)adaptor.create(string_literal104);
                    adaptor.addChild(root_0, string_literal104_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("long");
                    }

                    }
                    break;
                case 7 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:922:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal105=(Token)match(input,68,FOLLOW_68_in_primitiveType2388); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal105_tree = (Object)adaptor.create(string_literal105);
                    adaptor.addChild(root_0, string_literal105_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("float");
                    }

                    }
                    break;
                case 8 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:923:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal106=(Token)match(input,69,FOLLOW_69_in_primitiveType2400); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal106_tree = (Object)adaptor.create(string_literal106);
                    adaptor.addChild(root_0, string_literal106_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("double");
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:928:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final MViewParser.typeArguments_return typeArguments() throws RecognitionException {
        MViewParser.typeArguments_return retval = new MViewParser.typeArguments_return();
        retval.start = input.LT(1);
        int typeArguments_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal107=null;
        Token char_literal109=null;
        Token char_literal111=null;
        MViewParser.typeArgument_return typeArgument108 = null;

        MViewParser.typeArgument_return typeArgument110 = null;


        Object char_literal107_tree=null;
        Object char_literal109_tree=null;
        Object char_literal111_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal107=(Token)match(input,70,FOLLOW_70_in_typeArguments2423); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal107_tree = (Object)adaptor.create(char_literal107);
            adaptor.addChild(root_0, char_literal107_tree);
            }
            pushFollow(FOLLOW_typeArgument_in_typeArguments2425);
            typeArgument108=typeArgument();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument108.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:26: ( ',' typeArgument )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==29) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:28: ',' typeArgument
            	    {
            	    char_literal109=(Token)match(input,29,FOLLOW_29_in_typeArguments2429); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal109_tree = (Object)adaptor.create(char_literal109);
            	    adaptor.addChild(root_0, char_literal109_tree);
            	    }
            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2431);
            	    typeArgument110=typeArgument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument110.getTree());

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            char_literal111=(Token)match(input,71,FOLLOW_71_in_typeArguments2436); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal111_tree = (Object)adaptor.create(char_literal111);
            adaptor.addChild(root_0, char_literal111_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:932:1: typeArgument : (t= type | '?' ( ( 'extends' | 'super' ) t= type )? );
    public final MViewParser.typeArgument_return typeArgument() throws RecognitionException {
        MViewParser.typeArgument_return retval = new MViewParser.typeArgument_return();
        retval.start = input.LT(1);
        int typeArgument_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal112=null;
        Token set113=null;
        MViewParser.type_return t = null;


        Object char_literal112_tree=null;
        Object set113_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:933:5: (t= type | '?' ( ( 'extends' | 'super' ) t= type )? )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==Identifier||(LA56_0>=62 && LA56_0<=69)) ) {
                alt56=1;
            }
            else if ( (LA56_0==72) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:933:9: t= type
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_typeArgument2461);
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:933:20: '?' ( ( 'extends' | 'super' ) t= type )?
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal112=(Token)match(input,72,FOLLOW_72_in_typeArgument2467); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal112_tree = (Object)adaptor.create(char_literal112);
                    adaptor.addChild(root_0, char_literal112_tree);
                    }
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:933:25: ( ( 'extends' | 'super' ) t= type )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( ((LA55_0>=73 && LA55_0<=74)) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:933:27: ( 'extends' | 'super' ) t= type
                            {
                            set113=(Token)input.LT(1);
                            if ( (input.LA(1)>=73 && input.LA(1)<=74) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set113));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_type_in_typeArgument2482);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:940:1: annotations : ( annotation )+ ;
    public final MViewParser.annotations_return annotations() throws RecognitionException {
        MViewParser.annotations_return retval = new MViewParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotation_return annotation114 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:941:5: ( ( annotation )+ )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:941:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:941:9: ( annotation )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==75) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations2512);
            	    annotation114=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation114.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:944:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MViewParser.annotation_return annotation() throws RecognitionException {
        MViewParser.annotation_return retval = new MViewParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal115=null;
        Token char_literal117=null;
        Token char_literal120=null;
        MViewParser.annotationName_return annotationName116 = null;

        MViewParser.elementValuePairs_return elementValuePairs118 = null;

        MViewParser.elementValue_return elementValue119 = null;


        Object char_literal115_tree=null;
        Object char_literal117_tree=null;
        Object char_literal120_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:945:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:945:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            char_literal115=(Token)match(input,75,FOLLOW_75_in_annotation2532); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal115_tree = (Object)adaptor.create(char_literal115);
            adaptor.addChild(root_0, char_literal115_tree);
            }
            pushFollow(FOLLOW_annotationName_in_annotation2534);
            annotationName116=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName116.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:945:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==27) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:945:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal117=(Token)match(input,27,FOLLOW_27_in_annotation2538); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal117_tree = (Object)adaptor.create(char_literal117);
                    adaptor.addChild(root_0, char_literal117_tree);
                    }
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:945:34: ( elementValuePairs | elementValue )?
                    int alt58=3;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==Identifier) ) {
                        alt58=1;
                    }
                    else if ( (LA58_0==24||LA58_0==75) ) {
                        alt58=2;
                    }
                    switch (alt58) {
                        case 1 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:945:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation2542);
                            elementValuePairs118=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs118.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:945:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation2546);
                            elementValue119=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue119.getTree());

                            }
                            break;

                    }

                    char_literal120=(Token)match(input,28,FOLLOW_28_in_annotation2551); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal120_tree = (Object)adaptor.create(char_literal120);
                    adaptor.addChild(root_0, char_literal120_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:948:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MViewParser.annotationName_return annotationName() throws RecognitionException {
        MViewParser.annotationName_return retval = new MViewParser.annotationName_return();
        retval.start = input.LT(1);
        int annotationName_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier121=null;
        Token char_literal122=null;
        Token Identifier123=null;

        Object Identifier121_tree=null;
        Object char_literal122_tree=null;
        Object Identifier123_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:949:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:949:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            Identifier121=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2575); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier121_tree = (Object)adaptor.create(Identifier121);
            adaptor.addChild(root_0, Identifier121_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:949:18: ( '.' Identifier )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==51) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:949:19: '.' Identifier
            	    {
            	    char_literal122=(Token)match(input,51,FOLLOW_51_in_annotationName2578); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal122_tree = (Object)adaptor.create(char_literal122);
            	    adaptor.addChild(root_0, char_literal122_tree);
            	    }
            	    Identifier123=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2580); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier123_tree = (Object)adaptor.create(Identifier123);
            	    adaptor.addChild(root_0, Identifier123_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop60;
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:952:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MViewParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MViewParser.elementValuePairs_return retval = new MViewParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal125=null;
        MViewParser.elementValuePair_return elementValuePair124 = null;

        MViewParser.elementValuePair_return elementValuePair126 = null;


        Object char_literal125_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:953:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:953:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2601);
            elementValuePair124=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair124.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:953:26: ( ',' elementValuePair )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==29) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:953:27: ',' elementValuePair
            	    {
            	    char_literal125=(Token)match(input,29,FOLLOW_29_in_elementValuePairs2604); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal125_tree = (Object)adaptor.create(char_literal125);
            	    adaptor.addChild(root_0, char_literal125_tree);
            	    }
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2606);
            	    elementValuePair126=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair126.getTree());

            	    }
            	    break;

            	default :
            	    break loop61;
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:956:1: elementValuePair : Identifier '=' elementValue ;
    public final MViewParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MViewParser.elementValuePair_return retval = new MViewParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier127=null;
        Token char_literal128=null;
        MViewParser.elementValue_return elementValue129 = null;


        Object Identifier127_tree=null;
        Object char_literal128_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:957:5: ( Identifier '=' elementValue )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:957:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();

            Identifier127=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair2627); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier127_tree = (Object)adaptor.create(Identifier127);
            adaptor.addChild(root_0, Identifier127_tree);
            }
            char_literal128=(Token)match(input,76,FOLLOW_76_in_elementValuePair2629); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal128_tree = (Object)adaptor.create(char_literal128);
            adaptor.addChild(root_0, char_literal128_tree);
            }
            pushFollow(FOLLOW_elementValue_in_elementValuePair2631);
            elementValue129=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue129.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:960:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MViewParser.elementValue_return elementValue() throws RecognitionException {
        MViewParser.elementValue_return retval = new MViewParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotation_return annotation130 = null;

        MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer131 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:961:5: ( annotation | elementValueArrayInitializer )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==75) ) {
                alt62=1;
            }
            else if ( (LA62_0==24) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:961:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotation_in_elementValue2654);
                    annotation130=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation130.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:962:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue2664);
                    elementValueArrayInitializer131=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer131.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:965:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MViewParser.elementValueArrayInitializer_return retval = new MViewParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal132=null;
        Token char_literal134=null;
        Token char_literal136=null;
        Token char_literal137=null;
        MViewParser.elementValue_return elementValue133 = null;

        MViewParser.elementValue_return elementValue135 = null;


        Object char_literal132_tree=null;
        Object char_literal134_tree=null;
        Object char_literal136_tree=null;
        Object char_literal137_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:966:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:966:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal132=(Token)match(input,24,FOLLOW_24_in_elementValueArrayInitializer2687); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal132_tree = (Object)adaptor.create(char_literal132);
            adaptor.addChild(root_0, char_literal132_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:966:13: ( elementValue ( ',' elementValue )* )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==24||LA64_0==75) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:966:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2690);
                    elementValue133=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue133.getTree());
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:966:27: ( ',' elementValue )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==29) ) {
                            int LA63_1 = input.LA(2);

                            if ( (LA63_1==24||LA63_1==75) ) {
                                alt63=1;
                            }


                        }


                        switch (alt63) {
                    	case 1 :
                    	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:966:28: ',' elementValue
                    	    {
                    	    char_literal134=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2693); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal134_tree = (Object)adaptor.create(char_literal134);
                    	    adaptor.addChild(root_0, char_literal134_tree);
                    	    }
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2695);
                    	    elementValue135=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue135.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:966:49: ( ',' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==29) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:966:50: ','
                    {
                    char_literal136=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2702); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal136_tree = (Object)adaptor.create(char_literal136);
                    adaptor.addChild(root_0, char_literal136_tree);
                    }

                    }
                    break;

            }

            char_literal137=(Token)match(input,25,FOLLOW_25_in_elementValueArrayInitializer2706); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal137_tree = (Object)adaptor.create(char_literal137);
            adaptor.addChild(root_0, char_literal137_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:969:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MViewParser.annotationTypeDeclaration_return retval = new MViewParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal138=null;
        Token string_literal139=null;
        MViewParser.annotationTypeBody_return annotationTypeBody140 = null;


        Object name_tree=null;
        Object char_literal138_tree=null;
        Object string_literal139_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:970:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:970:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();

            char_literal138=(Token)match(input,75,FOLLOW_75_in_annotationTypeDeclaration2733); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal138_tree = (Object)adaptor.create(char_literal138);
            adaptor.addChild(root_0, char_literal138_tree);
            }
            string_literal139=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration2735); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal139_tree = (Object)adaptor.create(string_literal139);
            adaptor.addChild(root_0, string_literal139_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration2739); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2741);
            annotationTypeBody140=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody140.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:973:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MViewParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MViewParser.annotationTypeBody_return retval = new MViewParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal141=null;
        Token char_literal143=null;
        MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration142 = null;


        Object char_literal141_tree=null;
        Object char_literal143_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:974:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:974:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal141=(Token)match(input,24,FOLLOW_24_in_annotationTypeBody2764); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal141_tree = (Object)adaptor.create(char_literal141);
            adaptor.addChild(root_0, char_literal141_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:974:13: ( annotationTypeElementDeclaration )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==Identifier||(LA66_0>=62 && LA66_0<=69)||LA66_0==75) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:974:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2767);
            	    annotationTypeElementDeclaration142=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration142.getTree());

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            char_literal143=(Token)match(input,25,FOLLOW_25_in_annotationTypeBody2771); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal143_tree = (Object)adaptor.create(char_literal143);
            adaptor.addChild(root_0, char_literal143_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:977:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MViewParser.annotationTypeElementDeclaration_return retval = new MViewParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotationTypeElementRest_return annotationTypeElementRest144 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:978:5: ( annotationTypeElementRest )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:978:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2796);
            annotationTypeElementRest144=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest144.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:981:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MViewParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MViewParser.annotationTypeElementRest_return retval = new MViewParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal147=null;
        Token char_literal149=null;
        MViewParser.type_return type145 = null;

        MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest146 = null;

        MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration148 = null;


        Object char_literal147_tree=null;
        Object char_literal149_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:982:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==Identifier||(LA68_0>=62 && LA68_0<=69)) ) {
                alt68=1;
            }
            else if ( (LA68_0==75) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:982:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2819);
                    type145=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type145.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2821);
                    annotationMethodOrConstantRest146=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest146.getTree());
                    char_literal147=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2823); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal147_tree = (Object)adaptor.create(char_literal147);
                    adaptor.addChild(root_0, char_literal147_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:983:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2833);
                    annotationTypeDeclaration148=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration148.getTree());
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:983:35: ( ';' )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==26) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: ';'
                            {
                            char_literal149=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2835); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal149_tree = (Object)adaptor.create(char_literal149);
                            adaptor.addChild(root_0, char_literal149_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:986:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MViewParser.annotationMethodOrConstantRest_return retval = new MViewParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotationMethodRest_return annotationMethodRest150 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:987:5: ( annotationMethodRest )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:987:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2859);
            annotationMethodRest150=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest150.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:990:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MViewParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MViewParser.annotationMethodRest_return retval = new MViewParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier151=null;
        Token char_literal152=null;
        Token char_literal153=null;
        MViewParser.defaultValue_return defaultValue154 = null;


        Object Identifier151_tree=null;
        Object char_literal152_tree=null;
        Object char_literal153_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:991:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:991:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier151=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2882); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier151_tree = (Object)adaptor.create(Identifier151);
            adaptor.addChild(root_0, Identifier151_tree);
            }
            char_literal152=(Token)match(input,27,FOLLOW_27_in_annotationMethodRest2884); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal152_tree = (Object)adaptor.create(char_literal152);
            adaptor.addChild(root_0, char_literal152_tree);
            }
            char_literal153=(Token)match(input,28,FOLLOW_28_in_annotationMethodRest2886); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal153_tree = (Object)adaptor.create(char_literal153);
            adaptor.addChild(root_0, char_literal153_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:991:28: ( defaultValue )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==77) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest2888);
                    defaultValue154=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue154.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:994:1: defaultValue : 'default' elementValue ;
    public final MViewParser.defaultValue_return defaultValue() throws RecognitionException {
        MViewParser.defaultValue_return retval = new MViewParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal155=null;
        MViewParser.elementValue_return elementValue156 = null;


        Object string_literal155_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:995:5: ( 'default' elementValue )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:995:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();

            string_literal155=(Token)match(input,77,FOLLOW_77_in_defaultValue2916); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal155_tree = (Object)adaptor.create(string_literal155);
            adaptor.addChild(root_0, string_literal155_tree);
            }
            pushFollow(FOLLOW_elementValue_in_defaultValue2918);
            elementValue156=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue156.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 81, defaultValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit106 = new BitSet(new long[]{0x1000018080800002L});
    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit119 = new BitSet(new long[]{0x1000018080800002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_compilationUnit132 = new BitSet(new long[]{0x1000018080800002L});
    public static final BitSet FOLLOW_applicationDeclaration_in_compilationUnit145 = new BitSet(new long[]{0x1000018080800002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration179 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration183 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_interfaceDeclaration190 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_interfaceBody211 = new BitSet(new long[]{0xE000000002000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody213 = new BitSet(new long[]{0xE000000002000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_25_in_interfaceBody217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration233 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceBodyDeclaration235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_serviceReferenceDeclaration260 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_actualParameters_in_serviceReferenceDeclaration264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_actualParameters293 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameters298 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_actualParameters304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_actualParameterDecls329 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_actualParameterDecls332 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameterDecls336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceHeaderDeclaration389 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_serviceHeaderDeclaration393 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceHeaderDeclaration397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_formalParameters469 = new BitSet(new long[]{0xE000000010000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters474 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_formalParameters480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls506 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls510 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_formalParameterDecls513 = new BitSet(new long[]{0xE000000000000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negationModifier_in_pointcutServiceSignatureDecl553 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl559 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl567 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_pointcutServiceSignatureParameters598 = new BitSet(new long[]{0x0000000050000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters601 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_pointcutServiceSignatureParameters607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureParameterDecls622 = new BitSet(new long[]{0x0000000020000012L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls631 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutServiceSignatureParameterDecls636 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_connectorDeclaration669 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_connectorDeclaration675 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration679 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_connectorDeclaration687 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorBody708 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody710 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_25_in_connectorBody714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aoCompositionDeclaration_in_connectorBodyDeclaration729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_connectorBodyDeclaration736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_aoCompositionDeclaration764 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_aoCompositionDeclaration770 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_aoCompositionDeclaration774 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_aoCompositionDeclaration782 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_aoCompositionBody_in_aoCompositionDeclaration789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_aoCompositionBody803 = new BitSet(new long[]{0x0000080202000000L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_aoCompositionBody810 = new BitSet(new long[]{0x0000080002000000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_aoCompositionBody819 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_aoCompositionBody826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pointcutDeclaration843 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutBody863 = new BitSet(new long[]{0x0600007402000000L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody865 = new BitSet(new long[]{0x0600007402000000L});
    public static final BitSet FOLLOW_25_in_pointcutBody869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_pointcutKindDeclaration912 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutKindDeclaration914 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_joinPointKind_in_pointcutKindDeclaration918 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutKindDeclaration920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration939 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_pointcutSignatureDeclaration945 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutSignatureDeclaration947 = new BitSet(new long[]{0x0800000040000010L});
    public static final BitSet FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration951 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutSignatureDeclaration955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls991 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutSignatureBodyDecls995 = new BitSet(new long[]{0x0800000040000010L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_pointcutActorDeclaration1019 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_pointcutActorDeclaration1034 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutActorBody1066 = new BitSet(new long[]{0x0600078002800000L});
    public static final BitSet FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1068 = new BitSet(new long[]{0x0600078002800000L});
    public static final BitSet FOLLOW_25_in_pointcutActorBody1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1093 = new BitSet(new long[]{0x0000078000800000L});
    public static final BitSet FOLLOW_23_in_pointcutActorBodyDecls1104 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1106 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_39_in_pointcutActorBodyDecls1118 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1120 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_40_in_pointcutActorBodyDecls1131 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1133 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_41_in_pointcutActorBodyDecls1144 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1146 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_42_in_pointcutActorBodyDecls1157 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1159 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1168 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutActorBodyDecls1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negationModifier_in_pointcutActorPropDecls1188 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1194 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutActorPropDecls1199 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutActorPropDecl1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_adviceDeclaration1249 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_adviceBody1268 = new BitSet(new long[]{0x0000320002000000L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody1270 = new BitSet(new long[]{0x0000320002000000L});
    public static final BitSet FOLLOW_25_in_adviceBody1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceInstanceDeclaration_in_adviceBodyDeclaration1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_adviceServiceDeclaration1319 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceServiceDeclaration1321 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1325 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceServiceDeclaration1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_adviceTypeDeclaration1346 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceTypeDeclaration1348 = new BitSet(new long[]{0x0070000000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration1352 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceTypeDeclaration1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_adviceInstanceDeclaration1370 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceInstanceDeclaration1372 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_instanceReferenceDeclaration_in_adviceInstanceDeclaration1376 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceInstanceDeclaration1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_instanceReferenceDeclaration1399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_componentDeclaration1426 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration1430 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_componentDeclaration1438 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration1445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_componentBody1467 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody1469 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_25_in_componentBody1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_moduleDependencyBody1525 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1530 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_moduleDependencyBody1538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_moduleRequireDependencyDeclaration1555 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_moduleProvideDependencyDeclaration1574 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_applicationDeclaration1611 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_applicationDeclaration1617 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_applicationDeclaration1621 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_applicationDeclaration1629 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_applicationBody_in_applicationDeclaration1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_applicationBody1650 = new BitSet(new long[]{0x1000048082000010L});
    public static final BitSet FOLLOW_applicationBodyDeclaration_in_applicationBody1654 = new BitSet(new long[]{0x1000048082000010L});
    public static final BitSet FOLLOW_25_in_applicationBody1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hostDeclaration_in_applicationBodyDeclaration1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedDeclarationReference_in_instanceDeclaration1732 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1737 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_instanceDeclaration1741 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1745 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_instanceDeclaration1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_hostDeclaration1774 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_hostDeclaration1778 = new BitSet(new long[]{0x0002000004000000L});
    public static final BitSet FOLLOW_49_in_hostDeclaration1786 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_StringLiteral_in_hostDeclaration1790 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_hostDeclaration1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_componentDeclaration_in_moduleContainerDeclarations1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_refinementDeclarationSingle1858 = new BitSet(new long[]{0x1000048080000010L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1879 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_refinementDeclaration1884 = new BitSet(new long[]{0x1000048080000010L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclaration1888 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_qualifiedDeclarationReference_in_refinementDeclarationBody1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_qualifiedDeclarationReference1949 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_qualifiedDeclarationReference1956 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_qualifiedDeclarationReference1960 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls1991 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_commaSeparatedBodyDecls1994 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_adviceType2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_adviceType2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_adviceType2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_joinPointKind2061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_joinPointKind2068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_overrideOrExtend2090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_overrideOrExtend2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_negationModifier2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_abstractModifier2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_voidType2162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type2203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2228 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2247 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_classOrInterfaceType2261 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2265 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2291 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_primitiveType2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_primitiveType2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_primitiveType2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_primitiveType2364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_primitiveType2376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_primitiveType2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_primitiveType2400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_typeArguments2423 = new BitSet(new long[]{0xE000000000000010L,0x000000000000013FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2425 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_29_in_typeArguments2429 = new BitSet(new long[]{0xE000000000000010L,0x000000000000013FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2431 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_typeArguments2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_typeArgument2467 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_set_in_typeArgument2472 = new BitSet(new long[]{0xE000000000000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_typeArgument2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations2512 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_annotation2532 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation2534 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_annotation2538 = new BitSet(new long[]{0x0000000011000010L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation2542 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation2546 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotation2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2575 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_annotationName2578 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2580 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2601 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_elementValuePairs2604 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2606 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair2627 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_elementValuePair2629 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair2631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_elementValueArrayInitializer2687 = new BitSet(new long[]{0x0000000023000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2690 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2693 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2695 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2702 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elementValueArrayInitializer2706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_annotationTypeDeclaration2733 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration2735 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration2739 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeBody2764 = new BitSet(new long[]{0xE000000002000010L,0x000000000000083FL});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2767 = new BitSet(new long[]{0xE000000002000010L,0x000000000000083FL});
    public static final BitSet FOLLOW_25_in_annotationTypeBody2771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2819 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2821 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2833 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2882 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_annotationMethodRest2884 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotationMethodRest2886 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_defaultValue2916 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2918 = new BitSet(new long[]{0x0000000000000002L});

}
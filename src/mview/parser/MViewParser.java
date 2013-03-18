// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g 2013-03-05 15:21:58

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
            this.state.ruleMemo = new HashMap[170+1];
             
             
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:151:1: interfaceDeclaration returns [Interface element] : intkw= 'interface' name= Identifier interfaceBody[$element] ;
    public final MViewParser.interfaceDeclaration_return interfaceDeclaration() throws RecognitionException {
        MViewParser.interfaceDeclaration_return retval = new MViewParser.interfaceDeclaration_return();
        retval.start = input.LT(1);
        int interfaceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token intkw=null;
        Token name=null;
        MViewParser.interfaceBody_return interfaceBody1 = null;


        Object intkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:152:2: (intkw= 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:152:4: intkw= 'interface' name= Identifier interfaceBody[$element]
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
            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration189);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:161:1: interfaceBody[Interface element] : '{' ( interfaceBodyDeclaration[$element] )* '}' ;
    public final MViewParser.interfaceBody_return interfaceBody(Interface element) throws RecognitionException {
        MViewParser.interfaceBody_return retval = new MViewParser.interfaceBody_return();
        retval.start = input.LT(1);
        int interfaceBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal2=null;
        Token char_literal4=null;
        MViewParser.interfaceBodyDeclaration_return interfaceBodyDeclaration3 = null;


        Object char_literal2_tree=null;
        Object char_literal4_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:162:2: ( '{' ( interfaceBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:162:4: '{' ( interfaceBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal2=(Token)match(input,24,FOLLOW_24_in_interfaceBody203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:162:8: ( interfaceBodyDeclaration[$element] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||(LA2_0>=61 && LA2_0<=69)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: interfaceBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody205);
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

            char_literal4=(Token)match(input,25,FOLLOW_25_in_interfaceBody209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal4_tree = (Object)adaptor.create(char_literal4);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:166:1: interfaceBodyDeclaration[Interface element] : (service= serviceDeclaration ';' ) ;
    public final MViewParser.interfaceBodyDeclaration_return interfaceBodyDeclaration(Interface element) throws RecognitionException {
        MViewParser.interfaceBodyDeclaration_return retval = new MViewParser.interfaceBodyDeclaration_return();
        retval.start = input.LT(1);
        int interfaceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal5=null;
        MViewParser.serviceDeclaration_return service = null;


        Object char_literal5_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:167:2: ( (service= serviceDeclaration ';' ) )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:167:4: (service= serviceDeclaration ';' )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:167:4: (service= serviceDeclaration ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:167:5: service= serviceDeclaration ';'
            {
            pushFollow(FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration225);
            service=serviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal5=(Token)match(input,26,FOLLOW_26_in_interfaceBodyDeclaration227); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal5_tree = (Object)adaptor.create(char_literal5);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:178:1: serviceReferenceDeclaration returns [SimpleReference<Service> relation] : name= Identifier params= actualParameters ;
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:179:2: (name= Identifier params= actualParameters )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:179:4: name= Identifier params= actualParameters
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceReferenceDeclaration252); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_actualParameters_in_serviceReferenceDeclaration256);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:186:1: actualParameters returns [List<String> lst] : '(' (pars= actualParameterDecls )? ')' ;
    public final MViewParser.actualParameters_return actualParameters() throws RecognitionException {
        MViewParser.actualParameters_return retval = new MViewParser.actualParameters_return();
        retval.start = input.LT(1);
        int actualParameters_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal6=null;
        Token char_literal7=null;
        MViewParser.actualParameterDecls_return pars = null;


        Object char_literal6_tree=null;
        Object char_literal7_tree=null;

        retval.lst = new ArrayList<String>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:188:5: ( '(' (pars= actualParameterDecls )? ')' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:188:9: '(' (pars= actualParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal6=(Token)match(input,27,FOLLOW_27_in_actualParameters285); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:188:13: (pars= actualParameterDecls )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Identifier) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:188:14: pars= actualParameterDecls
                    {
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameters290);
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

            char_literal7=(Token)match(input,28,FOLLOW_28_in_actualParameters296); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal7_tree = (Object)adaptor.create(char_literal7);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:191:1: actualParameterDecls returns [List<String> lst] : name= Identifier ( ',' decls= actualParameterDecls )? ;
    public final MViewParser.actualParameterDecls_return actualParameterDecls() throws RecognitionException {
        MViewParser.actualParameterDecls_return retval = new MViewParser.actualParameterDecls_return();
        retval.start = input.LT(1);
        int actualParameterDecls_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal8=null;
        MViewParser.actualParameterDecls_return decls = null;


        Object name_tree=null;
        Object char_literal8_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:192:5: (name= Identifier ( ',' decls= actualParameterDecls )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:192:9: name= Identifier ( ',' decls= actualParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_actualParameterDecls321); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:192:25: ( ',' decls= actualParameterDecls )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==29) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:192:26: ',' decls= actualParameterDecls
                    {
                    char_literal8=(Token)match(input,29,FOLLOW_29_in_actualParameterDecls324); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (Object)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);
                    }
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameterDecls328);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:208:1: serviceDeclaration returns [Service element] : res= serviceHeaderDeclaration ;
    public final MViewParser.serviceDeclaration_return serviceDeclaration() throws RecognitionException {
        MViewParser.serviceDeclaration_return retval = new MViewParser.serviceDeclaration_return();
        retval.start = input.LT(1);
        int serviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.serviceHeaderDeclaration_return res = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:209:2: (res= serviceHeaderDeclaration )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:209:4: res= serviceHeaderDeclaration
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration361);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:215:1: serviceHeaderDeclaration returns [Service element] : rtype= serviceReturnType name= Identifier params= formalParameters ;
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:216:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:216:4: rtype= serviceReturnType name= Identifier params= formalParameters
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceReturnType_in_serviceHeaderDeclaration381);
            rtype=serviceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceHeaderDeclaration385); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_formalParameters_in_serviceHeaderDeclaration389);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:224:1: serviceReturnType returns [BasicTypeReference value] : (vt= voidType | tp= type ) ;
    public final MViewParser.serviceReturnType_return serviceReturnType() throws RecognitionException {
        MViewParser.serviceReturnType_return retval = new MViewParser.serviceReturnType_return();
        retval.start = input.LT(1);
        int serviceReturnType_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.voidType_return vt = null;

        MViewParser.type_return tp = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:225:2: ( (vt= voidType | tp= type ) )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:225:4: (vt= voidType | tp= type )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:225:4: (vt= voidType | tp= type )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==61) ) {
                alt5=1;
            }
            else if ( (LA5_0==Identifier||(LA5_0>=62 && LA5_0<=69)) ) {
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:226:4: vt= voidType
                    {
                    pushFollow(FOLLOW_voidType_in_serviceReturnType415);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:228:4: tp= type
                    {
                    pushFollow(FOLLOW_type_in_serviceReturnType429);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:233:1: formalParameters returns [List<FormalParameter> lst] : '(' (pars= formalParameterDecls )? ')' ;
    public final MViewParser.formalParameters_return formalParameters() throws RecognitionException {
        MViewParser.formalParameters_return retval = new MViewParser.formalParameters_return();
        retval.start = input.LT(1);
        int formalParameters_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal9=null;
        Token char_literal10=null;
        MViewParser.formalParameterDecls_return pars = null;


        Object char_literal9_tree=null;
        Object char_literal10_tree=null;

        retval.lst = new ArrayList<FormalParameter>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:235:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:235:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal9=(Token)match(input,27,FOLLOW_27_in_formalParameters461); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal9_tree = (Object)adaptor.create(char_literal9);
            adaptor.addChild(root_0, char_literal9_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:235:13: (pars= formalParameterDecls )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Identifier||(LA6_0>=62 && LA6_0<=69)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:235:14: pars= formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters466);
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

            char_literal10=(Token)match(input,28,FOLLOW_28_in_formalParameters472); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal10_tree = (Object)adaptor.create(char_literal10);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:239:1: formalParameterDecls returns [List<FormalParameter> lst] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
    public final MViewParser.formalParameterDecls_return formalParameterDecls() throws RecognitionException {
        MViewParser.formalParameterDecls_return retval = new MViewParser.formalParameterDecls_return();
        retval.start = input.LT(1);
        int formalParameterDecls_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal11=null;
        MViewParser.type_return t = null;

        MViewParser.formalParameterDecls_return decls = null;


        Object name_tree=null;
        Object char_literal11_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:240:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:240:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_type_in_formalParameterDecls498);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls502); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:240:32: ( ',' decls= formalParameterDecls )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==29) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:240:33: ',' decls= formalParameterDecls
                    {
                    char_literal11=(Token)match(input,29,FOLLOW_29_in_formalParameterDecls505); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal11_tree = (Object)adaptor.create(char_literal11);
                    adaptor.addChild(root_0, char_literal11_tree);
                    }
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls509);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:261:1: pointcutServiceSignatureDecl returns [ServiceSignature element] : (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters ;
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:262:2: ( (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:262:4: (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:262:4: (negate= negationModifier )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==59) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:262:5: negate= negationModifier
                    {
                    pushFollow(FOLLOW_negationModifier_in_pointcutServiceSignatureDecl545);
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

            pushFollow(FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl567);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:273:1: pointcutServiceSignatureParameters returns [List<Pair<String,String>> lst] : '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' ;
    public final MViewParser.pointcutServiceSignatureParameters_return pointcutServiceSignatureParameters() throws RecognitionException {
        MViewParser.pointcutServiceSignatureParameters_return retval = new MViewParser.pointcutServiceSignatureParameters_return();
        retval.start = input.LT(1);
        int pointcutServiceSignatureParameters_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal12=null;
        Token char_literal14=null;
        MViewParser.pointcutServiceSignatureParameterDecls_return pointcutServiceSignatureParameterDecls13 = null;


        Object char_literal12_tree=null;
        Object char_literal14_tree=null;

        retval.lst = new ArrayList<Pair<String,String>>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:275:2: ( '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:275:4: '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal12=(Token)match(input,27,FOLLOW_27_in_pointcutServiceSignatureParameters590); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:275:8: ( pointcutServiceSignatureParameterDecls[$lst] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Identifier||LA9_0==30) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:275:9: pointcutServiceSignatureParameterDecls[$lst]
                    {
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters593);
                    pointcutServiceSignatureParameterDecls13=pointcutServiceSignatureParameterDecls(retval.lst);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutServiceSignatureParameterDecls13.getTree());

                    }
                    break;

            }

            char_literal14=(Token)match(input,28,FOLLOW_28_in_pointcutServiceSignatureParameters599); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal14_tree = (Object)adaptor.create(char_literal14);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:279:1: pointcutServiceSignatureParameterDecls[List<Pair<String,String>> lst] : t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? ;
    public final MViewParser.pointcutServiceSignatureParameterDecls_return pointcutServiceSignatureParameterDecls(List<Pair<String,String>> lst) throws RecognitionException {
        MViewParser.pointcutServiceSignatureParameterDecls_return retval = new MViewParser.pointcutServiceSignatureParameterDecls_return();
        retval.start = input.LT(1);
        int pointcutServiceSignatureParameterDecls_StartIndex = input.index();
        Object root_0 = null;

        Token t=null;
        Token name=null;
        Token char_literal15=null;
        MViewParser.pointcutServiceSignatureParameterDecls_return pointcutServiceSignatureParameterDecls16 = null;


        Object t_tree=null;
        Object name_tree=null;
        Object char_literal15_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:280:2: (t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:280:4: t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
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

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:280:23: (name= Identifier )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Identifier) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:280:24: name= Identifier
                    {
                    name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls623); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    name_tree = (Object)adaptor.create(name);
                    adaptor.addChild(root_0, name_tree);
                    }

                    }
                    break;

            }

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:280:42: ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==29) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:280:43: ',' pointcutServiceSignatureParameterDecls[$lst]
                    {
                    char_literal15=(Token)match(input,29,FOLLOW_29_in_pointcutServiceSignatureParameterDecls628); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    adaptor.addChild(root_0, char_literal15_tree);
                    }
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls630);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:293:1: connectorDeclaration returns [Connector element] : (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] ;
    public final MViewParser.connectorDeclaration_return connectorDeclaration() throws RecognitionException {
        MViewParser.connectorDeclaration_return retval = new MViewParser.connectorDeclaration_return();
        retval.start = input.LT(1);
        int connectorDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token conkw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs = null;

        MViewParser.refinementDeclaration_return refinementDeclaration17 = null;

        MViewParser.connectorBody_return connectorBody18 = null;


        Object conkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:294:2: ( (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:294:4: (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:294:4: (abs= abstractModifier )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==60) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:294:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_connectorDeclaration661);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

            conkw=(Token)match(input,31,FOLLOW_31_in_connectorDeclaration667); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            conkw_tree = (Object)adaptor.create(conkw);
            adaptor.addChild(root_0, conkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration671); if (state.failed) return retval;
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:304:3: ( refinementDeclaration[$element,Connector.class] )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==50) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:304:4: refinementDeclaration[$element,Connector.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_connectorDeclaration679);
                    refinementDeclaration17=refinementDeclaration(retval.element, Connector.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration17.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration686);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:309:1: connectorBody[Connector element] : '{' ( connectorBodyDeclaration[$element] )* '}' ;
    public final MViewParser.connectorBody_return connectorBody(Connector element) throws RecognitionException {
        MViewParser.connectorBody_return retval = new MViewParser.connectorBody_return();
        retval.start = input.LT(1);
        int connectorBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal19=null;
        Token char_literal21=null;
        MViewParser.connectorBodyDeclaration_return connectorBodyDeclaration20 = null;


        Object char_literal19_tree=null;
        Object char_literal21_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:310:2: ( '{' ( connectorBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:310:4: '{' ( connectorBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal19=(Token)match(input,24,FOLLOW_24_in_connectorBody700); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:310:8: ( connectorBodyDeclaration[$element] )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==32||(LA14_0>=46 && LA14_0<=47)||LA14_0==60) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: connectorBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_connectorBodyDeclaration_in_connectorBody702);
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

            char_literal21=(Token)match(input,25,FOLLOW_25_in_connectorBody706); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal21_tree = (Object)adaptor.create(char_literal21);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:314:1: connectorBodyDeclaration[Connector element] : (aoc= aoCompositionDeclaration | moduleProvideDependencyDeclaration[$element] | moduleRequireDependencyDeclaration[$element] );
    public final MViewParser.connectorBodyDeclaration_return connectorBodyDeclaration(Connector element) throws RecognitionException {
        MViewParser.connectorBodyDeclaration_return retval = new MViewParser.connectorBodyDeclaration_return();
        retval.start = input.LT(1);
        int connectorBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.aoCompositionDeclaration_return aoc = null;

        MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration22 = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration23 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:315:2: (aoc= aoCompositionDeclaration | moduleProvideDependencyDeclaration[$element] | moduleRequireDependencyDeclaration[$element] )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 32:
            case 60:
                {
                alt15=1;
                }
                break;
            case 47:
                {
                alt15=2;
                }
                break;
            case 46:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:315:4: aoc= aoCompositionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_aoCompositionDeclaration_in_connectorBodyDeclaration721);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:318:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_connectorBodyDeclaration728);
                    moduleProvideDependencyDeclaration22=moduleProvideDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleProvideDependencyDeclaration22.getTree());

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:319:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration734);
                    moduleRequireDependencyDeclaration23=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration23.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:323:1: aoCompositionDeclaration returns [AOComposition element] : (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclaration[$element,AOComposition.class] )? aoCompositionBody[$element] ;
    public final MViewParser.aoCompositionDeclaration_return aoCompositionDeclaration() throws RecognitionException {
        MViewParser.aoCompositionDeclaration_return retval = new MViewParser.aoCompositionDeclaration_return();
        retval.start = input.LT(1);
        int aoCompositionDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token kw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs = null;

        MViewParser.refinementDeclaration_return refinementDeclaration24 = null;

        MViewParser.aoCompositionBody_return aoCompositionBody25 = null;


        Object kw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:324:2: ( (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclaration[$element,AOComposition.class] )? aoCompositionBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:324:4: (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclaration[$element,AOComposition.class] )? aoCompositionBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:324:4: (abs= abstractModifier )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==60) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:324:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_aoCompositionDeclaration756);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

            kw=(Token)match(input,32,FOLLOW_32_in_aoCompositionDeclaration762); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kw_tree = (Object)adaptor.create(kw);
            adaptor.addChild(root_0, kw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_aoCompositionDeclaration766); if (state.failed) return retval;
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:334:3: ( refinementDeclaration[$element,AOComposition.class] )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==50) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:334:4: refinementDeclaration[$element,AOComposition.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_aoCompositionDeclaration774);
                    refinementDeclaration24=refinementDeclaration(retval.element, AOComposition.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration24.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_aoCompositionBody_in_aoCompositionDeclaration781);
            aoCompositionBody25=aoCompositionBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aoCompositionBody25.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:339:1: aoCompositionBody[AOComposition element] : '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' ;
    public final MViewParser.aoCompositionBody_return aoCompositionBody(AOComposition element) throws RecognitionException {
        MViewParser.aoCompositionBody_return retval = new MViewParser.aoCompositionBody_return();
        retval.start = input.LT(1);
        int aoCompositionBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal26=null;
        Token char_literal27=null;
        MViewParser.pointcutDeclaration_return pc = null;

        MViewParser.adviceDeclaration_return adv = null;


        Object char_literal26_tree=null;
        Object char_literal27_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:340:2: ( '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:340:4: '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal26=(Token)match(input,24,FOLLOW_24_in_aoCompositionBody795); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal26_tree = (Object)adaptor.create(char_literal26);
            adaptor.addChild(root_0, char_literal26_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:341:5: (pc= pointcutDeclaration )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==33) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: pc= pointcutDeclaration
                    {
                    pushFollow(FOLLOW_pointcutDeclaration_in_aoCompositionBody802);
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:344:6: (adv= adviceDeclaration )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==43) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: adv= adviceDeclaration
                    {
                    pushFollow(FOLLOW_adviceDeclaration_in_aoCompositionBody811);
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
            char_literal27=(Token)match(input,25,FOLLOW_25_in_aoCompositionBody818); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal27_tree = (Object)adaptor.create(char_literal27);
            adaptor.addChild(root_0, char_literal27_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:350:1: pointcutDeclaration returns [Pointcut pointcut] : pckw= 'pointcut' pointcutBody[$pointcut] ;
    public final MViewParser.pointcutDeclaration_return pointcutDeclaration() throws RecognitionException {
        MViewParser.pointcutDeclaration_return retval = new MViewParser.pointcutDeclaration_return();
        retval.start = input.LT(1);
        int pointcutDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token pckw=null;
        MViewParser.pointcutBody_return pointcutBody28 = null;


        Object pckw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:351:2: (pckw= 'pointcut' pointcutBody[$pointcut] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:351:4: pckw= 'pointcut' pointcutBody[$pointcut]
            {
            root_0 = (Object)adaptor.nil();

            pckw=(Token)match(input,33,FOLLOW_33_in_pointcutDeclaration835); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            pckw_tree = (Object)adaptor.create(pckw);
            adaptor.addChild(root_0, pckw_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.pointcut = new Pointcut();
              				setKeyword(retval.pointcut,pckw);
              			
            }
            pushFollow(FOLLOW_pointcutBody_in_pointcutDeclaration839);
            pointcutBody28=pointcutBody(retval.pointcut);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBody28.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:358:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
    public final MViewParser.pointcutBody_return pointcutBody(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutBody_return retval = new MViewParser.pointcutBody_return();
        retval.start = input.LT(1);
        int pointcutBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal29=null;
        Token char_literal31=null;
        MViewParser.pointcutBodyDeclaration_return pointcutBodyDeclaration30 = null;


        Object char_literal29_tree=null;
        Object char_literal31_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:359:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:359:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal29=(Token)match(input,24,FOLLOW_24_in_pointcutBody855); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal29_tree = (Object)adaptor.create(char_literal29);
            adaptor.addChild(root_0, char_literal29_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:359:8: ( pointcutBodyDeclaration[$pointcut] )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==34||(LA20_0>=36 && LA20_0<=38)||(LA20_0>=57 && LA20_0<=58)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: pointcutBodyDeclaration[$pointcut]
            	    {
            	    pushFollow(FOLLOW_pointcutBodyDeclaration_in_pointcutBody857);
            	    pointcutBodyDeclaration30=pointcutBodyDeclaration(pointcut);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBodyDeclaration30.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            char_literal31=(Token)match(input,25,FOLLOW_25_in_pointcutBody861); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal31_tree = (Object)adaptor.create(char_literal31);
            adaptor.addChild(root_0, char_literal31_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:363:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] );
    public final MViewParser.pointcutBodyDeclaration_return pointcutBodyDeclaration(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutBodyDeclaration_return retval = new MViewParser.pointcutBodyDeclaration_return();
        retval.start = input.LT(1);
        int pointcutBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.pointcutKindDeclaration_return pointcutKindDeclaration32 = null;

        MViewParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration33 = null;

        MViewParser.pointcutActorDeclaration_return pointcutActorDeclaration34 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:364:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt21=1;
                }
                break;
            case 36:
            case 57:
            case 58:
                {
                alt21=2;
                }
                break;
            case 37:
            case 38:
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:364:4: pointcutKindDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration875);
                    pointcutKindDeclaration32=pointcutKindDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutKindDeclaration32.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:365:4: pointcutSignatureDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration881);
                    pointcutSignatureDeclaration33=pointcutSignatureDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureDeclaration33.getTree());

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:366:4: pointcutActorDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration887);
                    pointcutActorDeclaration34=pointcutActorDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorDeclaration34.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:370:1: pointcutKindDeclaration[Pointcut pointcut] : kikw= 'kind' ':' kind= joinPointKind ';' ;
    public final MViewParser.pointcutKindDeclaration_return pointcutKindDeclaration(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutKindDeclaration_return retval = new MViewParser.pointcutKindDeclaration_return();
        retval.start = input.LT(1);
        int pointcutKindDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token kikw=null;
        Token char_literal35=null;
        Token char_literal36=null;
        MViewParser.joinPointKind_return kind = null;


        Object kikw_tree=null;
        Object char_literal35_tree=null;
        Object char_literal36_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:371:2: (kikw= 'kind' ':' kind= joinPointKind ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:371:4: kikw= 'kind' ':' kind= joinPointKind ';'
            {
            root_0 = (Object)adaptor.nil();

            kikw=(Token)match(input,34,FOLLOW_34_in_pointcutKindDeclaration904); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kikw_tree = (Object)adaptor.create(kikw);
            adaptor.addChild(root_0, kikw_tree);
            }
            char_literal35=(Token)match(input,35,FOLLOW_35_in_pointcutKindDeclaration906); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal35_tree = (Object)adaptor.create(char_literal35);
            adaptor.addChild(root_0, char_literal35_tree);
            }
            pushFollow(FOLLOW_joinPointKind_in_pointcutKindDeclaration910);
            kind=joinPointKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, kind.getTree());
            char_literal36=(Token)match(input,26,FOLLOW_26_in_pointcutKindDeclaration912); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal36_tree = (Object)adaptor.create(char_literal36);
            adaptor.addChild(root_0, char_literal36_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:378:1: pointcutSignatureDeclaration[Pointcut element] : (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' ;
    public final MViewParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration(Pointcut element) throws RecognitionException {
        MViewParser.pointcutSignatureDeclaration_return retval = new MViewParser.pointcutSignatureDeclaration_return();
        retval.start = input.LT(1);
        int pointcutSignatureDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token sikw=null;
        Token char_literal37=null;
        Token char_literal38=null;
        MViewParser.overrideOrExtend_return override = null;

        MViewParser.pointcutSignatureBody_return ps = null;


        Object sikw_tree=null;
        Object char_literal37_tree=null;
        Object char_literal38_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:379:2: ( (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:379:4: (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:379:4: (override= overrideOrExtend )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=57 && LA22_0<=58)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:379:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration931);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

            sikw=(Token)match(input,36,FOLLOW_36_in_pointcutSignatureDeclaration937); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            sikw_tree = (Object)adaptor.create(sikw);
            adaptor.addChild(root_0, sikw_tree);
            }
            char_literal37=(Token)match(input,35,FOLLOW_35_in_pointcutSignatureDeclaration939); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal37_tree = (Object)adaptor.create(char_literal37);
            adaptor.addChild(root_0, char_literal37_tree);
            }
            pushFollow(FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration943);
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
            char_literal38=(Token)match(input,26,FOLLOW_26_in_pointcutSignatureDeclaration947); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal38_tree = (Object)adaptor.create(char_literal38);
            adaptor.addChild(root_0, char_literal38_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:390:1: pointcutSignatureBody returns [PointcutSignature element] : pointcutSignatureBodyDecls[$element] ;
    public final MViewParser.pointcutSignatureBody_return pointcutSignatureBody() throws RecognitionException {
        MViewParser.pointcutSignatureBody_return retval = new MViewParser.pointcutSignatureBody_return();
        retval.start = input.LT(1);
        int pointcutSignatureBody_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls39 = null;



         retval.element = new PointcutSignature(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:392:2: ( pointcutSignatureBodyDecls[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:392:4: pointcutSignatureBodyDecls[$element]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody966);
            pointcutSignatureBodyDecls39=pointcutSignatureBodyDecls(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureBodyDecls39.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:396:1: pointcutSignatureBodyDecls[PointcutSignature element] : pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? ;
    public final MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls(PointcutSignature element) throws RecognitionException {
        MViewParser.pointcutSignatureBodyDecls_return retval = new MViewParser.pointcutSignatureBodyDecls_return();
        retval.start = input.LT(1);
        int pointcutSignatureBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal40=null;
        MViewParser.pointcutServiceSignatureDecl_return pss = null;

        MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls41 = null;


        Object char_literal40_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:397:2: (pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:397:4: pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls983);
            pss=pointcutServiceSignatureDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pss.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:397:37: ( ',' pointcutSignatureBodyDecls[$element] )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:397:39: ',' pointcutSignatureBodyDecls[$element]
                    {
                    char_literal40=(Token)match(input,29,FOLLOW_29_in_pointcutSignatureBodyDecls987); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal40_tree = (Object)adaptor.create(char_literal40);
                    adaptor.addChild(root_0, char_literal40_tree);
                    }
                    pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls989);
                    pointcutSignatureBodyDecls41=pointcutSignatureBodyDecls(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureBodyDecls41.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:403:1: pointcutActorDeclaration[Pointcut pointcut] : (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody );
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:404:2: (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==37) ) {
                alt24=1;
            }
            else if ( (LA24_0==38) ) {
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:404:4: clkw= 'caller' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();

                    clkw=(Token)match(input,37,FOLLOW_37_in_pointcutActorDeclaration1011); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    clkw_tree = (Object)adaptor.create(clkw);
                    adaptor.addChild(root_0, clkw_tree);
                    }
                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1015);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:409:3: clkw= 'callee' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();

                    clkw=(Token)match(input,38,FOLLOW_38_in_pointcutActorDeclaration1026); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    clkw_tree = (Object)adaptor.create(clkw);
                    adaptor.addChild(root_0, clkw_tree);
                    }
                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1030);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:420:1: pointcutActorBody returns [Actor element] : '{' ( pointcutActorBodyDecls[$element] )* '}' ;
    public final MViewParser.pointcutActorBody_return pointcutActorBody() throws RecognitionException {
        MViewParser.pointcutActorBody_return retval = new MViewParser.pointcutActorBody_return();
        retval.start = input.LT(1);
        int pointcutActorBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal42=null;
        Token char_literal44=null;
        MViewParser.pointcutActorBodyDecls_return pointcutActorBodyDecls43 = null;


        Object char_literal42_tree=null;
        Object char_literal44_tree=null;


        	retval.element = new Actor();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:424:2: ( '{' ( pointcutActorBodyDecls[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:424:4: '{' ( pointcutActorBodyDecls[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal42=(Token)match(input,24,FOLLOW_24_in_pointcutActorBody1058); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal42_tree = (Object)adaptor.create(char_literal42);
            adaptor.addChild(root_0, char_literal42_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:424:8: ( pointcutActorBodyDecls[$element] )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==23||(LA25_0>=39 && LA25_0<=42)||(LA25_0>=57 && LA25_0<=58)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: pointcutActorBodyDecls[$element]
            	    {
            	    pushFollow(FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1060);
            	    pointcutActorBodyDecls43=pointcutActorBodyDecls(retval.element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorBodyDecls43.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            char_literal44=(Token)match(input,25,FOLLOW_25_in_pointcutActorBody1064); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal44_tree = (Object)adaptor.create(char_literal44);
            adaptor.addChild(root_0, char_literal44_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:428:1: pointcutActorBodyDecls[Actor actor] : (override= overrideOrExtend )? (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' ;
    public final MViewParser.pointcutActorBodyDecls_return pointcutActorBodyDecls(Actor actor) throws RecognitionException {
        MViewParser.pointcutActorBodyDecls_return retval = new MViewParser.pointcutActorBodyDecls_return();
        retval.start = input.LT(1);
        int pointcutActorBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token kw=null;
        Token char_literal45=null;
        Token char_literal46=null;
        Token char_literal47=null;
        Token char_literal48=null;
        Token char_literal49=null;
        Token char_literal51=null;
        MViewParser.overrideOrExtend_return override = null;

        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls50 = null;


        Object kw_tree=null;
        Object char_literal45_tree=null;
        Object char_literal46_tree=null;
        Object char_literal47_tree=null;
        Object char_literal48_tree=null;
        Object char_literal49_tree=null;
        Object char_literal51_tree=null;


        	ActorProp prop = null;
        	Token propKw = null;
        	Class<? extends Declaration> declClass = null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:434:2: ( (override= overrideOrExtend )? (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:434:4: (override= overrideOrExtend )? (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:434:4: (override= overrideOrExtend )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=57 && LA26_0<=58)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:434:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1085);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:435:2: (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' )
            int alt27=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt27=1;
                }
                break;
            case 39:
                {
                alt27=2;
                }
                break;
            case 40:
                {
                alt27=3;
                }
                break;
            case 41:
                {
                alt27=4;
                }
                break;
            case 42:
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:436:3: kw= 'interface' ':'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_pointcutActorBodyDecls1096); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
                    }
                    char_literal45=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1098); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    adaptor.addChild(root_0, char_literal45_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Interface.class;
                      			propKw = kw;
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:441:3: kw= 'component' ':'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_pointcutActorBodyDecls1110); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
                    }
                    char_literal46=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1112); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal46_tree = (Object)adaptor.create(char_literal46);
                    adaptor.addChild(root_0, char_literal46_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Component.class;
                      			propKw = kw;
                      		
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:446:3: kw= 'application' ':'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_pointcutActorBodyDecls1123); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
                    }
                    char_literal47=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1125); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    adaptor.addChild(root_0, char_literal47_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Application.class;
                      			propKw = kw;
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:451:3: kw= 'instance' ':'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_pointcutActorBodyDecls1136); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
                    }
                    char_literal48=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1138); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal48_tree = (Object)adaptor.create(char_literal48);
                    adaptor.addChild(root_0, char_literal48_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Instance.class;
                      			propKw = kw;
                      		
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:456:3: kw= 'host' ':'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_pointcutActorBodyDecls1149); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
                    }
                    char_literal49=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1151); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    adaptor.addChild(root_0, char_literal49_tree);
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
            pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1160);
            pointcutActorPropDecls50=pointcutActorPropDecls(prop, declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls50.getTree());
            char_literal51=(Token)match(input,26,FOLLOW_26_in_pointcutActorBodyDecls1163); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal51_tree = (Object)adaptor.create(char_literal51);
            adaptor.addChild(root_0, char_literal51_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:472:1: pointcutActorPropDecls[ActorProp prop,Class<? extends Declaration> declClass] : (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? ;
    public final MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls(ActorProp prop, Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecls_return retval = new MViewParser.pointcutActorPropDecls_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecls_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal52=null;
        MViewParser.negationModifier_return negate = null;

        MViewParser.pointcutActorPropDecl_return apdref = null;

        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls53 = null;


        Object char_literal52_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:473:2: ( (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:473:5: (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:473:5: (negate= negationModifier )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==59) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:473:6: negate= negationModifier
                    {
                    pushFollow(FOLLOW_negationModifier_in_pointcutActorPropDecls1180);
                    negate=negationModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, negate.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1186);
            apdref=pointcutActorPropDecl(declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, apdref.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:473:73: ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==29) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:473:75: ',' pointcutActorPropDecls[$prop,$declClass]
                    {
                    char_literal52=(Token)match(input,29,FOLLOW_29_in_pointcutActorPropDecls1191); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal52_tree = (Object)adaptor.create(char_literal52);
                    adaptor.addChild(root_0, char_literal52_tree);
                    }
                    pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1193);
                    pointcutActorPropDecls53=pointcutActorPropDecls(prop, declClass);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls53.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:484:1: pointcutActorPropDecl[Class<? extends Declaration> declClass] returns [SimpleReference<? extends Declaration> relation] : name= Identifier ;
    public final MViewParser.pointcutActorPropDecl_return pointcutActorPropDecl(Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecl_return retval = new MViewParser.pointcutActorPropDecl_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecl_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;

        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:485:2: (name= Identifier )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:485:5: name= Identifier
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutActorPropDecl1218); if (state.failed) return retval;
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:493:1: adviceDeclaration returns [Advice advice] : avkw= 'advice' adviceBody[$advice] ;
    public final MViewParser.adviceDeclaration_return adviceDeclaration() throws RecognitionException {
        MViewParser.adviceDeclaration_return retval = new MViewParser.adviceDeclaration_return();
        retval.start = input.LT(1);
        int adviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token avkw=null;
        MViewParser.adviceBody_return adviceBody54 = null;


        Object avkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:494:2: (avkw= 'advice' adviceBody[$advice] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:494:4: avkw= 'advice' adviceBody[$advice]
            {
            root_0 = (Object)adaptor.nil();

            avkw=(Token)match(input,43,FOLLOW_43_in_adviceDeclaration1241); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            avkw_tree = (Object)adaptor.create(avkw);
            adaptor.addChild(root_0, avkw_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.advice = new Advice();
              			setKeyword(retval.advice,avkw);
              		
            }
            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration1245);
            adviceBody54=adviceBody(retval.advice);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBody54.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:501:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
    public final MViewParser.adviceBody_return adviceBody(Advice advice) throws RecognitionException {
        MViewParser.adviceBody_return retval = new MViewParser.adviceBody_return();
        retval.start = input.LT(1);
        int adviceBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal55=null;
        Token char_literal57=null;
        MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration56 = null;


        Object char_literal55_tree=null;
        Object char_literal57_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:502:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:502:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal55=(Token)match(input,24,FOLLOW_24_in_adviceBody1260); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal55_tree = (Object)adaptor.create(char_literal55);
            adaptor.addChild(root_0, char_literal55_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:502:8: ( adviceBodyDeclaration[$advice] )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==41||(LA30_0>=44 && LA30_0<=45)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: adviceBodyDeclaration[$advice]
            	    {
            	    pushFollow(FOLLOW_adviceBodyDeclaration_in_adviceBody1262);
            	    adviceBodyDeclaration56=adviceBodyDeclaration(advice);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBodyDeclaration56.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            char_literal57=(Token)match(input,25,FOLLOW_25_in_adviceBody1266); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal57_tree = (Object)adaptor.create(char_literal57);
            adaptor.addChild(root_0, char_literal57_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:506:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] | adviceInstanceDeclaration[$advice] );
    public final MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceBodyDeclaration_return retval = new MViewParser.adviceBodyDeclaration_return();
        retval.start = input.LT(1);
        int adviceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration58 = null;

        MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration59 = null;

        MViewParser.adviceInstanceDeclaration_return adviceInstanceDeclaration60 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:507:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] | adviceInstanceDeclaration[$advice] )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt31=1;
                }
                break;
            case 45:
                {
                alt31=2;
                }
                break;
            case 41:
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:507:4: adviceServiceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1281);
                    adviceServiceDeclaration58=adviceServiceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceServiceDeclaration58.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:508:4: adviceTypeDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1287);
                    adviceTypeDeclaration59=adviceTypeDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceTypeDeclaration59.getTree());

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:509:4: adviceInstanceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceInstanceDeclaration_in_adviceBodyDeclaration1293);
                    adviceInstanceDeclaration60=adviceInstanceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceInstanceDeclaration60.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:513:1: adviceServiceDeclaration[Advice advice] : svkw= 'method' ':' service= serviceReferenceDeclaration ';' ;
    public final MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceServiceDeclaration_return retval = new MViewParser.adviceServiceDeclaration_return();
        retval.start = input.LT(1);
        int adviceServiceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token svkw=null;
        Token char_literal61=null;
        Token char_literal62=null;
        MViewParser.serviceReferenceDeclaration_return service = null;


        Object svkw_tree=null;
        Object char_literal61_tree=null;
        Object char_literal62_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:514:2: (svkw= 'method' ':' service= serviceReferenceDeclaration ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:514:4: svkw= 'method' ':' service= serviceReferenceDeclaration ';'
            {
            root_0 = (Object)adaptor.nil();

            svkw=(Token)match(input,44,FOLLOW_44_in_adviceServiceDeclaration1311); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            svkw_tree = (Object)adaptor.create(svkw);
            adaptor.addChild(root_0, svkw_tree);
            }
            char_literal61=(Token)match(input,35,FOLLOW_35_in_adviceServiceDeclaration1313); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal61_tree = (Object)adaptor.create(char_literal61);
            adaptor.addChild(root_0, char_literal61_tree);
            }
            pushFollow(FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1317);
            service=serviceReferenceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal62=(Token)match(input,26,FOLLOW_26_in_adviceServiceDeclaration1319); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal62_tree = (Object)adaptor.create(char_literal62);
            adaptor.addChild(root_0, char_literal62_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:521:1: adviceTypeDeclaration[Advice advice] : tpkw= 'type' ':' avtype= adviceType ';' ;
    public final MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceTypeDeclaration_return retval = new MViewParser.adviceTypeDeclaration_return();
        retval.start = input.LT(1);
        int adviceTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token tpkw=null;
        Token char_literal63=null;
        Token char_literal64=null;
        MViewParser.adviceType_return avtype = null;


        Object tpkw_tree=null;
        Object char_literal63_tree=null;
        Object char_literal64_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:522:2: (tpkw= 'type' ':' avtype= adviceType ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:522:4: tpkw= 'type' ':' avtype= adviceType ';'
            {
            root_0 = (Object)adaptor.nil();

            tpkw=(Token)match(input,45,FOLLOW_45_in_adviceTypeDeclaration1338); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tpkw_tree = (Object)adaptor.create(tpkw);
            adaptor.addChild(root_0, tpkw_tree);
            }
            char_literal63=(Token)match(input,35,FOLLOW_35_in_adviceTypeDeclaration1340); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal63_tree = (Object)adaptor.create(char_literal63);
            adaptor.addChild(root_0, char_literal63_tree);
            }
            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration1344);
            avtype=adviceType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, avtype.getTree());
            char_literal64=(Token)match(input,26,FOLLOW_26_in_adviceTypeDeclaration1346); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:528:1: adviceInstanceDeclaration[Advice advice] : inskw= 'instance' ':' instance= instanceReferenceDeclaration ';' ;
    public final MViewParser.adviceInstanceDeclaration_return adviceInstanceDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceInstanceDeclaration_return retval = new MViewParser.adviceInstanceDeclaration_return();
        retval.start = input.LT(1);
        int adviceInstanceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token inskw=null;
        Token char_literal65=null;
        Token char_literal66=null;
        MViewParser.instanceReferenceDeclaration_return instance = null;


        Object inskw_tree=null;
        Object char_literal65_tree=null;
        Object char_literal66_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:529:2: (inskw= 'instance' ':' instance= instanceReferenceDeclaration ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:529:4: inskw= 'instance' ':' instance= instanceReferenceDeclaration ';'
            {
            root_0 = (Object)adaptor.nil();

            inskw=(Token)match(input,41,FOLLOW_41_in_adviceInstanceDeclaration1362); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            inskw_tree = (Object)adaptor.create(inskw);
            adaptor.addChild(root_0, inskw_tree);
            }
            char_literal65=(Token)match(input,35,FOLLOW_35_in_adviceInstanceDeclaration1364); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = (Object)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);
            }
            pushFollow(FOLLOW_instanceReferenceDeclaration_in_adviceInstanceDeclaration1368);
            instance=instanceReferenceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, instance.getTree());
            char_literal66=(Token)match(input,26,FOLLOW_26_in_adviceInstanceDeclaration1370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal66_tree = (Object)adaptor.create(char_literal66);
            adaptor.addChild(root_0, char_literal66_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:535:1: instanceReferenceDeclaration returns [SimpleReference<Instance> relation] : name= Identifier ;
    public final MViewParser.instanceReferenceDeclaration_return instanceReferenceDeclaration() throws RecognitionException {
        MViewParser.instanceReferenceDeclaration_return retval = new MViewParser.instanceReferenceDeclaration_return();
        retval.start = input.LT(1);
        int instanceReferenceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;

        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:536:2: (name= Identifier )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:536:5: name= Identifier
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceReferenceDeclaration1391); if (state.failed) return retval;
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:547:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier componentBody[$element] ;
    public final MViewParser.componentDeclaration_return componentDeclaration() throws RecognitionException {
        MViewParser.componentDeclaration_return retval = new MViewParser.componentDeclaration_return();
        retval.start = input.LT(1);
        int componentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token compkw=null;
        Token name=null;
        MViewParser.componentBody_return componentBody67 = null;


        Object compkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:548:2: (compkw= 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:548:5: compkw= 'component' name= Identifier componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            compkw=(Token)match(input,39,FOLLOW_39_in_componentDeclaration1418); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            compkw_tree = (Object)adaptor.create(compkw);
            adaptor.addChild(root_0, compkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration1422); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                 			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                 			setKeyword(retval.element,compkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_componentBody_in_componentDeclaration1426);
            componentBody67=componentBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBody67.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:556:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
    public final MViewParser.componentBody_return componentBody(Component element) throws RecognitionException {
        MViewParser.componentBody_return retval = new MViewParser.componentBody_return();
        retval.start = input.LT(1);
        int componentBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal68=null;
        Token char_literal70=null;
        MViewParser.componentBodyDeclaration_return componentBodyDeclaration69 = null;


        Object char_literal68_tree=null;
        Object char_literal70_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:557:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:557:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal68=(Token)match(input,24,FOLLOW_24_in_componentBody1448); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal68_tree = (Object)adaptor.create(char_literal68);
            adaptor.addChild(root_0, char_literal68_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:557:8: ( componentBodyDeclaration[$element] )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=46 && LA32_0<=47)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody1450);
            	    componentBodyDeclaration69=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration69.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            char_literal70=(Token)match(input,25,FOLLOW_25_in_componentBody1454); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal70_tree = (Object)adaptor.create(char_literal70);
            adaptor.addChild(root_0, char_literal70_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:561:1: componentBodyDeclaration[Component element] : ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] );
    public final MViewParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MViewParser.componentBodyDeclaration_return retval = new MViewParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);
        int componentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration71 = null;

        MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration72 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:562:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==46) ) {
                alt33=1;
            }
            else if ( (LA33_0==47) ) {
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:562:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1472);
                    moduleRequireDependencyDeclaration71=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration71.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:563:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1478);
                    moduleProvideDependencyDeclaration72=moduleProvideDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleProvideDependencyDeclaration72.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:573:1: moduleDependencyBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' ;
    public final MViewParser.moduleDependencyBody_return moduleDependencyBody() throws RecognitionException {
        MViewParser.moduleDependencyBody_return retval = new MViewParser.moduleDependencyBody_return();
        retval.start = input.LT(1);
        int moduleDependencyBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal73=null;
        Token char_literal74=null;
        MViewParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal73_tree=null;
        Object char_literal74_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:575:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:575:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal73=(Token)match(input,24,FOLLOW_24_in_moduleDependencyBody1506); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal73_tree = (Object)adaptor.create(char_literal73);
            adaptor.addChild(root_0, char_literal73_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:575:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==Identifier) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:575:9: decls= commaSeparatedBodyDecls[Interface.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1511);
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

            char_literal74=(Token)match(input,25,FOLLOW_25_in_moduleDependencyBody1519); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal74_tree = (Object)adaptor.create(char_literal74);
            adaptor.addChild(root_0, char_literal74_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:579:1: moduleRequireDependencyDeclaration[Module element] : rekw= 'require' rd= moduleDependencyBody ;
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:580:2: (rekw= 'require' rd= moduleDependencyBody )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:580:4: rekw= 'require' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            rekw=(Token)match(input,46,FOLLOW_46_in_moduleRequireDependencyDeclaration1536); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rekw_tree = (Object)adaptor.create(rekw);
            adaptor.addChild(root_0, rekw_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1540);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:588:1: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
    public final MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration(Module element) throws RecognitionException {
        MViewParser.moduleProvideDependencyDeclaration_return retval = new MViewParser.moduleProvideDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleProvideDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal75=null;
        MViewParser.moduleDependencyBody_return rd = null;


        Object string_literal75_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:589:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:589:4: 'provide' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal75=(Token)match(input,47,FOLLOW_47_in_moduleProvideDependencyDeclaration1555); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal75_tree = (Object)adaptor.create(string_literal75);
            adaptor.addChild(root_0, string_literal75_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1559);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:628:1: applicationDeclaration returns [Application element] : (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] ;
    public final MViewParser.applicationDeclaration_return applicationDeclaration() throws RecognitionException {
        MViewParser.applicationDeclaration_return retval = new MViewParser.applicationDeclaration_return();
        retval.start = input.LT(1);
        int applicationDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token appkw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs = null;

        MViewParser.refinementDeclaration_return refinementDeclaration76 = null;

        MViewParser.applicationBody_return applicationBody77 = null;


        Object appkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:629:2: ( (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:629:4: (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:629:4: (abs= abstractModifier )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==60) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:629:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_applicationDeclaration1592);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

            appkw=(Token)match(input,40,FOLLOW_40_in_applicationDeclaration1598); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_applicationDeclaration1602); if (state.failed) return retval;
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:639:3: ( refinementDeclaration[$element,Application.class] )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==50) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:639:4: refinementDeclaration[$element,Application.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_applicationDeclaration1610);
                    refinementDeclaration76=refinementDeclaration(retval.element, Application.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration76.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_applicationBody_in_applicationDeclaration1617);
            applicationBody77=applicationBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBody77.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:644:1: applicationBody[Application element] : '{' ( applicationBodyDeclaration[$element] )* '}' ;
    public final MViewParser.applicationBody_return applicationBody(Application element) throws RecognitionException {
        MViewParser.applicationBody_return retval = new MViewParser.applicationBody_return();
        retval.start = input.LT(1);
        int applicationBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal78=null;
        Token char_literal80=null;
        MViewParser.applicationBodyDeclaration_return applicationBodyDeclaration79 = null;


        Object char_literal78_tree=null;
        Object char_literal80_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:645:2: ( '{' ( applicationBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:645:4: '{' ( applicationBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal78=(Token)match(input,24,FOLLOW_24_in_applicationBody1631); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal78_tree = (Object)adaptor.create(char_literal78);
            adaptor.addChild(root_0, char_literal78_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:645:8: ( applicationBodyDeclaration[$element] )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==Identifier||LA37_0==31||LA37_0==39||LA37_0==42||LA37_0==60) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:645:10: applicationBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_applicationBodyDeclaration_in_applicationBody1635);
            	    applicationBodyDeclaration79=applicationBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBodyDeclaration79.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            char_literal80=(Token)match(input,25,FOLLOW_25_in_applicationBody1641); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal80_tree = (Object)adaptor.create(char_literal80);
            adaptor.addChild(root_0, char_literal80_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:649:1: applicationBodyDeclaration[Application element] : (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration );
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:650:2: (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 31:
            case 39:
            case 60:
                {
                alt38=1;
                }
                break;
            case 42:
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:650:4: mod= moduleContainerDeclarations
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1657);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:654:3: hod= hostDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hostDeclaration_in_applicationBodyDeclaration1668);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:658:3: ind= instanceDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1680);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:690:1: instanceDeclaration returns [Instance element] : ref= qualifiedDeclarationReference[Module.class] name= Identifier onkw= 'on' hst= Identifier ';' ;
    public final MViewParser.instanceDeclaration_return instanceDeclaration() throws RecognitionException {
        MViewParser.instanceDeclaration_return retval = new MViewParser.instanceDeclaration_return();
        retval.start = input.LT(1);
        int instanceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token onkw=null;
        Token hst=null;
        Token char_literal81=null;
        MViewParser.qualifiedDeclarationReference_return ref = null;


        Object name_tree=null;
        Object onkw_tree=null;
        Object hst_tree=null;
        Object char_literal81_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:691:2: (ref= qualifiedDeclarationReference[Module.class] name= Identifier onkw= 'on' hst= Identifier ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:691:4: ref= qualifiedDeclarationReference[Module.class] name= Identifier onkw= 'on' hst= Identifier ';'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_qualifiedDeclarationReference_in_instanceDeclaration1713);
            ref=qualifiedDeclarationReference(Module.class);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ref.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1718); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            onkw=(Token)match(input,48,FOLLOW_48_in_instanceDeclaration1722); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            onkw_tree = (Object)adaptor.create(onkw);
            adaptor.addChild(root_0, onkw_tree);
            }
            hst=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1726); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hst_tree = (Object)adaptor.create(hst);
            adaptor.addChild(root_0, hst_tree);
            }
            char_literal81=(Token)match(input,26,FOLLOW_26_in_instanceDeclaration1728); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal81_tree = (Object)adaptor.create(char_literal81);
            adaptor.addChild(root_0, char_literal81_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:717:1: hostDeclaration returns [Host element] : hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';' ;
    public final MViewParser.hostDeclaration_return hostDeclaration() throws RecognitionException {
        MViewParser.hostDeclaration_return retval = new MViewParser.hostDeclaration_return();
        retval.start = input.LT(1);
        int hostDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token hkw=null;
        Token name=null;
        Token onkw=null;
        Token value=null;
        Token char_literal82=null;

        Object hkw_tree=null;
        Object name_tree=null;
        Object onkw_tree=null;
        Object value_tree=null;
        Object char_literal82_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:718:2: (hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:718:5: hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';'
            {
            root_0 = (Object)adaptor.nil();

            hkw=(Token)match(input,42,FOLLOW_42_in_hostDeclaration1755); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hkw_tree = (Object)adaptor.create(hkw);
            adaptor.addChild(root_0, hkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_hostDeclaration1759); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			
              			retval.element = new Host(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,hkw);
              			setLocation(retval.element,name,"__NAME");
              			
              		
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:724:5: (onkw= 'is' value= StringLiteral )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==49) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:724:7: onkw= 'is' value= StringLiteral
                    {
                    onkw=(Token)match(input,49,FOLLOW_49_in_hostDeclaration1767); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    onkw_tree = (Object)adaptor.create(onkw);
                    adaptor.addChild(root_0, onkw_tree);
                    }
                    value=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_hostDeclaration1771); if (state.failed) return retval;
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

            char_literal82=(Token)match(input,26,FOLLOW_26_in_hostDeclaration1778); if (state.failed) return retval;
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:738:1: moduleContainerDeclarations returns [Module element] : (cod= componentDeclaration | cnd= connectorDeclaration );
    public final MViewParser.moduleContainerDeclarations_return moduleContainerDeclarations() throws RecognitionException {
        MViewParser.moduleContainerDeclarations_return retval = new MViewParser.moduleContainerDeclarations_return();
        retval.start = input.LT(1);
        int moduleContainerDeclarations_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.componentDeclaration_return cod = null;

        MViewParser.connectorDeclaration_return cnd = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:739:2: (cod= componentDeclaration | cnd= connectorDeclaration )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==39) ) {
                alt40=1;
            }
            else if ( (LA40_0==31||LA40_0==60) ) {
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:740:3: cod= componentDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_componentDeclaration_in_moduleContainerDeclarations1803);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:744:3: cnd= connectorDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1814);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:771:1: refinementDeclarationSingle[RefinableDeclaration element, Class kind] : rfkw= 'refines' rel= refinementDeclarationBody[$kind] ;
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:772:2: (rfkw= 'refines' rel= refinementDeclarationBody[$kind] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:772:4: rfkw= 'refines' rel= refinementDeclarationBody[$kind]
            {
            root_0 = (Object)adaptor.nil();

            rfkw=(Token)match(input,50,FOLLOW_50_in_refinementDeclarationSingle1839); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rfkw_tree = (Object)adaptor.create(rfkw);
            adaptor.addChild(root_0, rfkw_tree);
            }
            pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1843);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:779:1: refinementDeclaration[RefinableDeclaration element, Class kind] : refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )* ;
    public final MViewParser.refinementDeclaration_return refinementDeclaration(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementDeclaration_return retval = new MViewParser.refinementDeclaration_return();
        retval.start = input.LT(1);
        int refinementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal84=null;
        MViewParser.refinementDeclarationBody_return rel = null;

        MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle83 = null;


        Object char_literal84_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:780:2: ( refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:780:4: refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1860);
            refinementDeclarationSingle83=refinementDeclarationSingle(element, kind);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationSingle83.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:780:48: ( ',' rel= refinementDeclarationBody[$kind] )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==29) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:780:50: ',' rel= refinementDeclarationBody[$kind]
            	    {
            	    char_literal84=(Token)match(input,29,FOLLOW_29_in_refinementDeclaration1865); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal84_tree = (Object)adaptor.create(char_literal84);
            	    adaptor.addChild(root_0, char_literal84_tree);
            	    }
            	    pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclaration1869);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:786:1: refinementDeclarationBody[Class kind] returns [RefinementRelation relation] : parent= qualifiedDeclarationReference[$kind] ;
    public final MViewParser.refinementDeclarationBody_return refinementDeclarationBody(Class kind) throws RecognitionException {
        MViewParser.refinementDeclarationBody_return retval = new MViewParser.refinementDeclarationBody_return();
        retval.start = input.LT(1);
        int refinementDeclarationBody_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.qualifiedDeclarationReference_return parent = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:787:2: (parent= qualifiedDeclarationReference[$kind] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:787:4: parent= qualifiedDeclarationReference[$kind]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_qualifiedDeclarationReference_in_refinementDeclarationBody1897);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:797:1: qualifiedDeclarationReference[Class kind] returns [SimpleReference reference] : name= Identifier ( '.' namex= Identifier )* ;
    public final MViewParser.qualifiedDeclarationReference_return qualifiedDeclarationReference(Class kind) throws RecognitionException {
        MViewParser.qualifiedDeclarationReference_return retval = new MViewParser.qualifiedDeclarationReference_return();
        retval.start = input.LT(1);
        int qualifiedDeclarationReference_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal85=null;

        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal85_tree=null;


        	Token start = null; 
        	Token end = null;
        	SimpleReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:806:2: (name= Identifier ( '.' namex= Identifier )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:806:4: name= Identifier ( '.' namex= Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_qualifiedDeclarationReference1930); if (state.failed) return retval;
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:812:3: ( '.' namex= Identifier )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==51) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:812:4: '.' namex= Identifier
            	    {
            	    char_literal85=(Token)match(input,51,FOLLOW_51_in_qualifiedDeclarationReference1937); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal85_tree = (Object)adaptor.create(char_literal85);
            	    adaptor.addChild(root_0, char_literal85_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_qualifiedDeclarationReference1941); if (state.failed) return retval;
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:827:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
    public final MViewParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls(Class targetType) throws RecognitionException {
        MViewParser.commaSeparatedBodyDecls_return retval = new MViewParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);
        int commaSeparatedBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token char_literal86=null;
        MViewParser.commaSeparatedBodyDecls_return decls = null;


        Object id_tree=null;
        Object char_literal86_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:829:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:829:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls1972); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:829:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==29) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:829:19: ',' decls= commaSeparatedBodyDecls[$targetType]
                    {
                    char_literal86=(Token)match(input,29,FOLLOW_29_in_commaSeparatedBodyDecls1975); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal86_tree = (Object)adaptor.create(char_literal86);
                    adaptor.addChild(root_0, char_literal86_tree);
                    }
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1979);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:843:1: adviceType returns [Modifier value] : ( 'before' | 'after' | 'around' );
    public final MViewParser.adviceType_return adviceType() throws RecognitionException {
        MViewParser.adviceType_return retval = new MViewParser.adviceType_return();
        retval.start = input.LT(1);
        int adviceType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal87=null;
        Token string_literal88=null;
        Token string_literal89=null;

        Object string_literal87_tree=null;
        Object string_literal88_tree=null;
        Object string_literal89_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:844:2: ( 'before' | 'after' | 'around' )
            int alt44=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt44=1;
                }
                break;
            case 53:
                {
                alt44=2;
                }
                break;
            case 54:
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:844:4: 'before'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal87=(Token)match(input,52,FOLLOW_52_in_adviceType2008); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal87_tree = (Object)adaptor.create(string_literal87);
                    adaptor.addChild(root_0, string_literal87_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Before();
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:845:4: 'after'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal88=(Token)match(input,53,FOLLOW_53_in_adviceType2015); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal88_tree = (Object)adaptor.create(string_literal88);
                    adaptor.addChild(root_0, string_literal88_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new After();
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:846:4: 'around'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal89=(Token)match(input,54,FOLLOW_54_in_adviceType2022); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = (Object)adaptor.create(string_literal89);
                    adaptor.addChild(root_0, string_literal89_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:850:1: joinPointKind returns [Modifier value] : ( 'execution' | 'call' );
    public final MViewParser.joinPointKind_return joinPointKind() throws RecognitionException {
        MViewParser.joinPointKind_return retval = new MViewParser.joinPointKind_return();
        retval.start = input.LT(1);
        int joinPointKind_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal90=null;
        Token string_literal91=null;

        Object string_literal90_tree=null;
        Object string_literal91_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:851:2: ( 'execution' | 'call' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==55) ) {
                alt45=1;
            }
            else if ( (LA45_0==56) ) {
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:851:4: 'execution'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal90=(Token)match(input,55,FOLLOW_55_in_joinPointKind2042); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = (Object)adaptor.create(string_literal90);
                    adaptor.addChild(root_0, string_literal90_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Execution();
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:852:4: 'call'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal91=(Token)match(input,56,FOLLOW_56_in_joinPointKind2049); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal91_tree = (Object)adaptor.create(string_literal91);
                    adaptor.addChild(root_0, string_literal91_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:856:1: overrideOrExtend returns [Modifier value] : (okw= 'override' | ekw= 'merge' );
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
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:857:2: (okw= 'override' | ekw= 'merge' )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==57) ) {
                alt46=1;
            }
            else if ( (LA46_0==58) ) {
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:857:4: okw= 'override'
                    {
                    root_0 = (Object)adaptor.nil();

                    okw=(Token)match(input,57,FOLLOW_57_in_overrideOrExtend2071); if (state.failed) return retval;
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:858:4: ekw= 'merge'
                    {
                    root_0 = (Object)adaptor.nil();

                    ekw=(Token)match(input,58,FOLLOW_58_in_overrideOrExtend2080); if (state.failed) return retval;
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:862:1: negationModifier returns [Modifier value] : '!' ;
    public final MViewParser.negationModifier_return negationModifier() throws RecognitionException {
        MViewParser.negationModifier_return retval = new MViewParser.negationModifier_return();
        retval.start = input.LT(1);
        int negationModifier_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal92=null;

        Object char_literal92_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:863:2: ( '!' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:863:5: '!'
            {
            root_0 = (Object)adaptor.nil();

            char_literal92=(Token)match(input,59,FOLLOW_59_in_negationModifier2100); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal92_tree = (Object)adaptor.create(char_literal92);
            adaptor.addChild(root_0, char_literal92_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:866:1: abstractModifier returns [Modifier value] : akw= 'abstract' ;
    public final MViewParser.abstractModifier_return abstractModifier() throws RecognitionException {
        MViewParser.abstractModifier_return retval = new MViewParser.abstractModifier_return();
        retval.start = input.LT(1);
        int abstractModifier_StartIndex = input.index();
        Object root_0 = null;

        Token akw=null;

        Object akw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:867:2: (akw= 'abstract' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:867:4: akw= 'abstract'
            {
            root_0 = (Object)adaptor.nil();

            akw=(Token)match(input,60,FOLLOW_60_in_abstractModifier2120); if (state.failed) return retval;
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:870:1: voidType returns [BasicTypeReference value] : 'void' ;
    public final MViewParser.voidType_return voidType() throws RecognitionException {
        MViewParser.voidType_return retval = new MViewParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal93=null;

        Object string_literal93_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:872:5: ( 'void' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:872:7: 'void'
            {
            root_0 = (Object)adaptor.nil();

            string_literal93=(Token)match(input,61,FOLLOW_61_in_voidType2143); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal93_tree = (Object)adaptor.create(string_literal93);
            adaptor.addChild(root_0, string_literal93_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:881:1: type returns [BasicTypeReference value] : (cd= classOrInterfaceType | pt= primitiveType );
    public final MViewParser.type_return type() throws RecognitionException {
        MViewParser.type_return retval = new MViewParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.classOrInterfaceType_return cd = null;

        MViewParser.primitiveType_return pt = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:883:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==Identifier) ) {
                alt47=1;
            }
            else if ( ((LA47_0>=62 && LA47_0<=69)) ) {
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:883:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceType_in_type2175);
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:884:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveType_in_type2184);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:888:1: classOrInterfaceType returns [BasicTypeReference element] : name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* ;
    public final MViewParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MViewParser.classOrInterfaceType_return retval = new MViewParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal95=null;
        MViewParser.typeArguments_return typeArguments94 = null;

        MViewParser.typeArguments_return typeArguments96 = null;


        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal95_tree=null;

        NamedTarget target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:890:2: (name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:890:4: name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new MViewBasicTypeReference((name!=null?name.getText():null));
              	           target =  new NamedTarget((name!=null?name.getText():null));
              	           setLocation(retval.element,name,name); 
              	          
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:896:4: ( typeArguments )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==70) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2228);
                    typeArguments94=typeArguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments94.getTree());

                    }
                    break;

            }

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:897:10: ( '.' namex= Identifier ( typeArguments )? )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==51) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:897:11: '.' namex= Identifier ( typeArguments )?
            	    {
            	    char_literal95=(Token)match(input,51,FOLLOW_51_in_classOrInterfaceType2242); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal95_tree = (Object)adaptor.create(char_literal95);
            	    adaptor.addChild(root_0, char_literal95_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2246); if (state.failed) return retval;
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
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:908:11: ( typeArguments )?
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==70) ) {
            	        alt49=1;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2272);
            	            typeArguments96=typeArguments();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments96.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:912:1: primitiveType returns [BasicTypeReference value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MViewParser.primitiveType_return primitiveType() throws RecognitionException {
        MViewParser.primitiveType_return retval = new MViewParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal97=null;
        Token string_literal98=null;
        Token string_literal99=null;
        Token string_literal100=null;
        Token string_literal101=null;
        Token string_literal102=null;
        Token string_literal103=null;
        Token string_literal104=null;

        Object string_literal97_tree=null;
        Object string_literal98_tree=null;
        Object string_literal99_tree=null;
        Object string_literal100_tree=null;
        Object string_literal101_tree=null;
        Object string_literal102_tree=null;
        Object string_literal103_tree=null;
        Object string_literal104_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:913:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt51=8;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt51=1;
                }
                break;
            case 63:
                {
                alt51=2;
                }
                break;
            case 64:
                {
                alt51=3;
                }
                break;
            case 65:
                {
                alt51=4;
                }
                break;
            case 66:
                {
                alt51=5;
                }
                break;
            case 67:
                {
                alt51=6;
                }
                break;
            case 68:
                {
                alt51=7;
                }
                break;
            case 69:
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:913:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal97=(Token)match(input,62,FOLLOW_62_in_primitiveType2297); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal97_tree = (Object)adaptor.create(string_literal97);
                    adaptor.addChild(root_0, string_literal97_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:914:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal98=(Token)match(input,63,FOLLOW_63_in_primitiveType2309); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal98_tree = (Object)adaptor.create(string_literal98);
                    adaptor.addChild(root_0, string_literal98_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("char");
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:915:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal99=(Token)match(input,64,FOLLOW_64_in_primitiveType2321); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal99_tree = (Object)adaptor.create(string_literal99);
                    adaptor.addChild(root_0, string_literal99_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("byte");
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:916:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal100=(Token)match(input,65,FOLLOW_65_in_primitiveType2333); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal100_tree = (Object)adaptor.create(string_literal100);
                    adaptor.addChild(root_0, string_literal100_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("short");
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:917:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal101=(Token)match(input,66,FOLLOW_66_in_primitiveType2345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal101_tree = (Object)adaptor.create(string_literal101);
                    adaptor.addChild(root_0, string_literal101_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("int");
                    }

                    }
                    break;
                case 6 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:918:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal102=(Token)match(input,67,FOLLOW_67_in_primitiveType2357); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal102_tree = (Object)adaptor.create(string_literal102);
                    adaptor.addChild(root_0, string_literal102_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("long");
                    }

                    }
                    break;
                case 7 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:919:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal103=(Token)match(input,68,FOLLOW_68_in_primitiveType2369); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal103_tree = (Object)adaptor.create(string_literal103);
                    adaptor.addChild(root_0, string_literal103_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("float");
                    }

                    }
                    break;
                case 8 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:920:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal104=(Token)match(input,69,FOLLOW_69_in_primitiveType2381); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal104_tree = (Object)adaptor.create(string_literal104);
                    adaptor.addChild(root_0, string_literal104_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:925:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final MViewParser.typeArguments_return typeArguments() throws RecognitionException {
        MViewParser.typeArguments_return retval = new MViewParser.typeArguments_return();
        retval.start = input.LT(1);
        int typeArguments_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal105=null;
        Token char_literal107=null;
        Token char_literal109=null;
        MViewParser.typeArgument_return typeArgument106 = null;

        MViewParser.typeArgument_return typeArgument108 = null;


        Object char_literal105_tree=null;
        Object char_literal107_tree=null;
        Object char_literal109_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:926:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:926:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal105=(Token)match(input,70,FOLLOW_70_in_typeArguments2404); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal105_tree = (Object)adaptor.create(char_literal105);
            adaptor.addChild(root_0, char_literal105_tree);
            }
            pushFollow(FOLLOW_typeArgument_in_typeArguments2406);
            typeArgument106=typeArgument();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument106.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:926:26: ( ',' typeArgument )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==29) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:926:28: ',' typeArgument
            	    {
            	    char_literal107=(Token)match(input,29,FOLLOW_29_in_typeArguments2410); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal107_tree = (Object)adaptor.create(char_literal107);
            	    adaptor.addChild(root_0, char_literal107_tree);
            	    }
            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2412);
            	    typeArgument108=typeArgument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument108.getTree());

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            char_literal109=(Token)match(input,71,FOLLOW_71_in_typeArguments2417); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal109_tree = (Object)adaptor.create(char_literal109);
            adaptor.addChild(root_0, char_literal109_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:1: typeArgument : (t= type | '?' ( ( 'extends' | 'super' ) t= type )? );
    public final MViewParser.typeArgument_return typeArgument() throws RecognitionException {
        MViewParser.typeArgument_return retval = new MViewParser.typeArgument_return();
        retval.start = input.LT(1);
        int typeArgument_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal110=null;
        Token set111=null;
        MViewParser.type_return t = null;


        Object char_literal110_tree=null;
        Object set111_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:930:5: (t= type | '?' ( ( 'extends' | 'super' ) t= type )? )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==Identifier||(LA54_0>=62 && LA54_0<=69)) ) {
                alt54=1;
            }
            else if ( (LA54_0==72) ) {
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:930:9: t= type
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_typeArgument2442);
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:930:20: '?' ( ( 'extends' | 'super' ) t= type )?
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal110=(Token)match(input,72,FOLLOW_72_in_typeArgument2448); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal110_tree = (Object)adaptor.create(char_literal110);
                    adaptor.addChild(root_0, char_literal110_tree);
                    }
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:930:25: ( ( 'extends' | 'super' ) t= type )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( ((LA53_0>=73 && LA53_0<=74)) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:930:27: ( 'extends' | 'super' ) t= type
                            {
                            set111=(Token)input.LT(1);
                            if ( (input.LA(1)>=73 && input.LA(1)<=74) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set111));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_type_in_typeArgument2463);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:937:1: annotations : ( annotation )+ ;
    public final MViewParser.annotations_return annotations() throws RecognitionException {
        MViewParser.annotations_return retval = new MViewParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotation_return annotation112 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:938:5: ( ( annotation )+ )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:938:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:938:9: ( annotation )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==75) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations2493);
            	    annotation112=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation112.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:941:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MViewParser.annotation_return annotation() throws RecognitionException {
        MViewParser.annotation_return retval = new MViewParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal113=null;
        Token char_literal115=null;
        Token char_literal118=null;
        MViewParser.annotationName_return annotationName114 = null;

        MViewParser.elementValuePairs_return elementValuePairs116 = null;

        MViewParser.elementValue_return elementValue117 = null;


        Object char_literal113_tree=null;
        Object char_literal115_tree=null;
        Object char_literal118_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:942:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:942:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            char_literal113=(Token)match(input,75,FOLLOW_75_in_annotation2513); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal113_tree = (Object)adaptor.create(char_literal113);
            adaptor.addChild(root_0, char_literal113_tree);
            }
            pushFollow(FOLLOW_annotationName_in_annotation2515);
            annotationName114=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName114.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:942:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==27) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:942:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal115=(Token)match(input,27,FOLLOW_27_in_annotation2519); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal115_tree = (Object)adaptor.create(char_literal115);
                    adaptor.addChild(root_0, char_literal115_tree);
                    }
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:942:34: ( elementValuePairs | elementValue )?
                    int alt56=3;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==Identifier) ) {
                        alt56=1;
                    }
                    else if ( (LA56_0==24||LA56_0==75) ) {
                        alt56=2;
                    }
                    switch (alt56) {
                        case 1 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:942:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation2523);
                            elementValuePairs116=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs116.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:942:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation2527);
                            elementValue117=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue117.getTree());

                            }
                            break;

                    }

                    char_literal118=(Token)match(input,28,FOLLOW_28_in_annotation2532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal118_tree = (Object)adaptor.create(char_literal118);
                    adaptor.addChild(root_0, char_literal118_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:945:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MViewParser.annotationName_return annotationName() throws RecognitionException {
        MViewParser.annotationName_return retval = new MViewParser.annotationName_return();
        retval.start = input.LT(1);
        int annotationName_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier119=null;
        Token char_literal120=null;
        Token Identifier121=null;

        Object Identifier119_tree=null;
        Object char_literal120_tree=null;
        Object Identifier121_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:946:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:946:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            Identifier119=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2556); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier119_tree = (Object)adaptor.create(Identifier119);
            adaptor.addChild(root_0, Identifier119_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:946:18: ( '.' Identifier )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==51) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:946:19: '.' Identifier
            	    {
            	    char_literal120=(Token)match(input,51,FOLLOW_51_in_annotationName2559); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal120_tree = (Object)adaptor.create(char_literal120);
            	    adaptor.addChild(root_0, char_literal120_tree);
            	    }
            	    Identifier121=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2561); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier121_tree = (Object)adaptor.create(Identifier121);
            	    adaptor.addChild(root_0, Identifier121_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:949:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MViewParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MViewParser.elementValuePairs_return retval = new MViewParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal123=null;
        MViewParser.elementValuePair_return elementValuePair122 = null;

        MViewParser.elementValuePair_return elementValuePair124 = null;


        Object char_literal123_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2582);
            elementValuePair122=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair122.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:26: ( ',' elementValuePair )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==29) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:27: ',' elementValuePair
            	    {
            	    char_literal123=(Token)match(input,29,FOLLOW_29_in_elementValuePairs2585); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal123_tree = (Object)adaptor.create(char_literal123);
            	    adaptor.addChild(root_0, char_literal123_tree);
            	    }
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2587);
            	    elementValuePair124=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair124.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:953:1: elementValuePair : Identifier '=' elementValue ;
    public final MViewParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MViewParser.elementValuePair_return retval = new MViewParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier125=null;
        Token char_literal126=null;
        MViewParser.elementValue_return elementValue127 = null;


        Object Identifier125_tree=null;
        Object char_literal126_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:954:5: ( Identifier '=' elementValue )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:954:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();

            Identifier125=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair2608); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier125_tree = (Object)adaptor.create(Identifier125);
            adaptor.addChild(root_0, Identifier125_tree);
            }
            char_literal126=(Token)match(input,76,FOLLOW_76_in_elementValuePair2610); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal126_tree = (Object)adaptor.create(char_literal126);
            adaptor.addChild(root_0, char_literal126_tree);
            }
            pushFollow(FOLLOW_elementValue_in_elementValuePair2612);
            elementValue127=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue127.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:957:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MViewParser.elementValue_return elementValue() throws RecognitionException {
        MViewParser.elementValue_return retval = new MViewParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotation_return annotation128 = null;

        MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer129 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:958:5: ( annotation | elementValueArrayInitializer )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==75) ) {
                alt60=1;
            }
            else if ( (LA60_0==24) ) {
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:958:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotation_in_elementValue2635);
                    annotation128=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation128.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:959:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue2645);
                    elementValueArrayInitializer129=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer129.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:962:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MViewParser.elementValueArrayInitializer_return retval = new MViewParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal130=null;
        Token char_literal132=null;
        Token char_literal134=null;
        Token char_literal135=null;
        MViewParser.elementValue_return elementValue131 = null;

        MViewParser.elementValue_return elementValue133 = null;


        Object char_literal130_tree=null;
        Object char_literal132_tree=null;
        Object char_literal134_tree=null;
        Object char_literal135_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:963:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:963:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal130=(Token)match(input,24,FOLLOW_24_in_elementValueArrayInitializer2668); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal130_tree = (Object)adaptor.create(char_literal130);
            adaptor.addChild(root_0, char_literal130_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:963:13: ( elementValue ( ',' elementValue )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==24||LA62_0==75) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:963:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2671);
                    elementValue131=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue131.getTree());
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:963:27: ( ',' elementValue )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==29) ) {
                            int LA61_1 = input.LA(2);

                            if ( (LA61_1==24||LA61_1==75) ) {
                                alt61=1;
                            }


                        }


                        switch (alt61) {
                    	case 1 :
                    	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:963:28: ',' elementValue
                    	    {
                    	    char_literal132=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2674); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal132_tree = (Object)adaptor.create(char_literal132);
                    	    adaptor.addChild(root_0, char_literal132_tree);
                    	    }
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2676);
                    	    elementValue133=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue133.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:963:49: ( ',' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==29) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:963:50: ','
                    {
                    char_literal134=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2683); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal134_tree = (Object)adaptor.create(char_literal134);
                    adaptor.addChild(root_0, char_literal134_tree);
                    }

                    }
                    break;

            }

            char_literal135=(Token)match(input,25,FOLLOW_25_in_elementValueArrayInitializer2687); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal135_tree = (Object)adaptor.create(char_literal135);
            adaptor.addChild(root_0, char_literal135_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:966:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MViewParser.annotationTypeDeclaration_return retval = new MViewParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal136=null;
        Token string_literal137=null;
        MViewParser.annotationTypeBody_return annotationTypeBody138 = null;


        Object name_tree=null;
        Object char_literal136_tree=null;
        Object string_literal137_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:967:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:967:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();

            char_literal136=(Token)match(input,75,FOLLOW_75_in_annotationTypeDeclaration2714); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal136_tree = (Object)adaptor.create(char_literal136);
            adaptor.addChild(root_0, char_literal136_tree);
            }
            string_literal137=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration2716); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal137_tree = (Object)adaptor.create(string_literal137);
            adaptor.addChild(root_0, string_literal137_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration2720); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2722);
            annotationTypeBody138=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody138.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:970:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MViewParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MViewParser.annotationTypeBody_return retval = new MViewParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal139=null;
        Token char_literal141=null;
        MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration140 = null;


        Object char_literal139_tree=null;
        Object char_literal141_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:971:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:971:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal139=(Token)match(input,24,FOLLOW_24_in_annotationTypeBody2745); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal139_tree = (Object)adaptor.create(char_literal139);
            adaptor.addChild(root_0, char_literal139_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:971:13: ( annotationTypeElementDeclaration )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==Identifier||(LA64_0>=62 && LA64_0<=69)||LA64_0==75) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:971:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2748);
            	    annotationTypeElementDeclaration140=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration140.getTree());

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            char_literal141=(Token)match(input,25,FOLLOW_25_in_annotationTypeBody2752); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal141_tree = (Object)adaptor.create(char_literal141);
            adaptor.addChild(root_0, char_literal141_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:974:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MViewParser.annotationTypeElementDeclaration_return retval = new MViewParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotationTypeElementRest_return annotationTypeElementRest142 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:975:5: ( annotationTypeElementRest )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:975:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2777);
            annotationTypeElementRest142=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest142.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:978:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MViewParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MViewParser.annotationTypeElementRest_return retval = new MViewParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal145=null;
        Token char_literal147=null;
        MViewParser.type_return type143 = null;

        MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest144 = null;

        MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration146 = null;


        Object char_literal145_tree=null;
        Object char_literal147_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:979:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==Identifier||(LA66_0>=62 && LA66_0<=69)) ) {
                alt66=1;
            }
            else if ( (LA66_0==75) ) {
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
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:979:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2800);
                    type143=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type143.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2802);
                    annotationMethodOrConstantRest144=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest144.getTree());
                    char_literal145=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2804); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal145_tree = (Object)adaptor.create(char_literal145);
                    adaptor.addChild(root_0, char_literal145_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:980:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2814);
                    annotationTypeDeclaration146=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration146.getTree());
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:980:35: ( ';' )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==26) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: ';'
                            {
                            char_literal147=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2816); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal147_tree = (Object)adaptor.create(char_literal147);
                            adaptor.addChild(root_0, char_literal147_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:983:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MViewParser.annotationMethodOrConstantRest_return retval = new MViewParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotationMethodRest_return annotationMethodRest148 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:984:5: ( annotationMethodRest )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:984:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2840);
            annotationMethodRest148=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest148.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:987:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MViewParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MViewParser.annotationMethodRest_return retval = new MViewParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier149=null;
        Token char_literal150=null;
        Token char_literal151=null;
        MViewParser.defaultValue_return defaultValue152 = null;


        Object Identifier149_tree=null;
        Object char_literal150_tree=null;
        Object char_literal151_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:988:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:988:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier149=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2863); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier149_tree = (Object)adaptor.create(Identifier149);
            adaptor.addChild(root_0, Identifier149_tree);
            }
            char_literal150=(Token)match(input,27,FOLLOW_27_in_annotationMethodRest2865); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal150_tree = (Object)adaptor.create(char_literal150);
            adaptor.addChild(root_0, char_literal150_tree);
            }
            char_literal151=(Token)match(input,28,FOLLOW_28_in_annotationMethodRest2867); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal151_tree = (Object)adaptor.create(char_literal151);
            adaptor.addChild(root_0, char_literal151_tree);
            }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:988:28: ( defaultValue )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==77) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest2869);
                    defaultValue152=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue152.getTree());

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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:991:1: defaultValue : 'default' elementValue ;
    public final MViewParser.defaultValue_return defaultValue() throws RecognitionException {
        MViewParser.defaultValue_return retval = new MViewParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal153=null;
        MViewParser.elementValue_return elementValue154 = null;


        Object string_literal153_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:992:5: ( 'default' elementValue )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:992:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();

            string_literal153=(Token)match(input,77,FOLLOW_77_in_defaultValue2897); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal153_tree = (Object)adaptor.create(string_literal153);
            adaptor.addChild(root_0, string_literal153_tree);
            }
            pushFollow(FOLLOW_elementValue_in_defaultValue2899);
            elementValue154=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue154.getTree());

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
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration183 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_interfaceBody203 = new BitSet(new long[]{0xE000000002000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody205 = new BitSet(new long[]{0xE000000002000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_25_in_interfaceBody209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration225 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceBodyDeclaration227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_serviceReferenceDeclaration252 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_actualParameters_in_serviceReferenceDeclaration256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_actualParameters285 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameters290 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_actualParameters296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_actualParameterDecls321 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_actualParameterDecls324 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameterDecls328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceHeaderDeclaration381 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_serviceHeaderDeclaration385 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceHeaderDeclaration389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_formalParameters461 = new BitSet(new long[]{0xE000000010000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters466 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_formalParameters472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls498 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls502 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_formalParameterDecls505 = new BitSet(new long[]{0xE000000000000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negationModifier_in_pointcutServiceSignatureDecl545 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl551 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl559 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_pointcutServiceSignatureParameters590 = new BitSet(new long[]{0x0000000050000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters593 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_pointcutServiceSignatureParameters599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureParameterDecls614 = new BitSet(new long[]{0x0000000020000012L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls623 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutServiceSignatureParameterDecls628 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_connectorDeclaration661 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_connectorDeclaration667 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration671 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_connectorDeclaration679 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorBody700 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody702 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_25_in_connectorBody706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aoCompositionDeclaration_in_connectorBodyDeclaration721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_connectorBodyDeclaration728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_aoCompositionDeclaration756 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_aoCompositionDeclaration762 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_aoCompositionDeclaration766 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_aoCompositionDeclaration774 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_aoCompositionBody_in_aoCompositionDeclaration781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_aoCompositionBody795 = new BitSet(new long[]{0x0000080202000000L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_aoCompositionBody802 = new BitSet(new long[]{0x0000080002000000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_aoCompositionBody811 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_aoCompositionBody818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pointcutDeclaration835 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutBody855 = new BitSet(new long[]{0x0600007402000000L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody857 = new BitSet(new long[]{0x0600007402000000L});
    public static final BitSet FOLLOW_25_in_pointcutBody861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_pointcutKindDeclaration904 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutKindDeclaration906 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_joinPointKind_in_pointcutKindDeclaration910 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutKindDeclaration912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration931 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_pointcutSignatureDeclaration937 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutSignatureDeclaration939 = new BitSet(new long[]{0x0800000040000010L});
    public static final BitSet FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration943 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutSignatureDeclaration947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls983 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutSignatureBodyDecls987 = new BitSet(new long[]{0x0800000040000010L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_pointcutActorDeclaration1011 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_pointcutActorDeclaration1026 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutActorBody1058 = new BitSet(new long[]{0x0600078002800000L});
    public static final BitSet FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1060 = new BitSet(new long[]{0x0600078002800000L});
    public static final BitSet FOLLOW_25_in_pointcutActorBody1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1085 = new BitSet(new long[]{0x0000078000800000L});
    public static final BitSet FOLLOW_23_in_pointcutActorBodyDecls1096 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1098 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_39_in_pointcutActorBodyDecls1110 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1112 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_40_in_pointcutActorBodyDecls1123 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1125 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_41_in_pointcutActorBodyDecls1136 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1138 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_42_in_pointcutActorBodyDecls1149 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1151 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1160 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutActorBodyDecls1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negationModifier_in_pointcutActorPropDecls1180 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1186 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutActorPropDecls1191 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutActorPropDecl1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_adviceDeclaration1241 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_adviceBody1260 = new BitSet(new long[]{0x0000320002000000L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody1262 = new BitSet(new long[]{0x0000320002000000L});
    public static final BitSet FOLLOW_25_in_adviceBody1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceInstanceDeclaration_in_adviceBodyDeclaration1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_adviceServiceDeclaration1311 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceServiceDeclaration1313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1317 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceServiceDeclaration1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_adviceTypeDeclaration1338 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceTypeDeclaration1340 = new BitSet(new long[]{0x0070000000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration1344 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceTypeDeclaration1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_adviceInstanceDeclaration1362 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceInstanceDeclaration1364 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_instanceReferenceDeclaration_in_adviceInstanceDeclaration1368 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceInstanceDeclaration1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_instanceReferenceDeclaration1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_componentDeclaration1418 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration1422 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_componentBody1448 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody1450 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_25_in_componentBody1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_moduleDependencyBody1506 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1511 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_moduleDependencyBody1519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_moduleRequireDependencyDeclaration1536 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_moduleProvideDependencyDeclaration1555 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_applicationDeclaration1592 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_applicationDeclaration1598 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_applicationDeclaration1602 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_applicationDeclaration1610 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_applicationBody_in_applicationDeclaration1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_applicationBody1631 = new BitSet(new long[]{0x1000048082000010L});
    public static final BitSet FOLLOW_applicationBodyDeclaration_in_applicationBody1635 = new BitSet(new long[]{0x1000048082000010L});
    public static final BitSet FOLLOW_25_in_applicationBody1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hostDeclaration_in_applicationBodyDeclaration1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedDeclarationReference_in_instanceDeclaration1713 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1718 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_instanceDeclaration1722 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1726 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_instanceDeclaration1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_hostDeclaration1755 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_hostDeclaration1759 = new BitSet(new long[]{0x0002000004000000L});
    public static final BitSet FOLLOW_49_in_hostDeclaration1767 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_StringLiteral_in_hostDeclaration1771 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_hostDeclaration1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_componentDeclaration_in_moduleContainerDeclarations1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_refinementDeclarationSingle1839 = new BitSet(new long[]{0x1000048080000010L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1860 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_refinementDeclaration1865 = new BitSet(new long[]{0x1000048080000010L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclaration1869 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_qualifiedDeclarationReference_in_refinementDeclarationBody1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_qualifiedDeclarationReference1930 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_qualifiedDeclarationReference1937 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_qualifiedDeclarationReference1941 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls1972 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_commaSeparatedBodyDecls1975 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_adviceType2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_adviceType2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_adviceType2022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_joinPointKind2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_joinPointKind2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_overrideOrExtend2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_overrideOrExtend2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_negationModifier2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_abstractModifier2120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_voidType2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type2175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2209 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2228 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_classOrInterfaceType2242 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2246 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2272 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType2297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_primitiveType2309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_primitiveType2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_primitiveType2333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_primitiveType2345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_primitiveType2357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_primitiveType2369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_primitiveType2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_typeArguments2404 = new BitSet(new long[]{0xE000000000000010L,0x000000000000013FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2406 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_29_in_typeArguments2410 = new BitSet(new long[]{0xE000000000000010L,0x000000000000013FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2412 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_typeArguments2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_typeArgument2448 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_set_in_typeArgument2453 = new BitSet(new long[]{0xE000000000000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_typeArgument2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations2493 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_annotation2513 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation2515 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_annotation2519 = new BitSet(new long[]{0x0000000011000010L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation2523 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation2527 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotation2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2556 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_annotationName2559 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2561 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2582 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_elementValuePairs2585 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2587 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair2608 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_elementValuePair2610 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair2612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue2635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_elementValueArrayInitializer2668 = new BitSet(new long[]{0x0000000023000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2671 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2674 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2676 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2683 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elementValueArrayInitializer2687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_annotationTypeDeclaration2714 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration2716 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration2720 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeBody2745 = new BitSet(new long[]{0xE000000002000010L,0x000000000000083FL});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2748 = new BitSet(new long[]{0xE000000002000010L,0x000000000000083FL});
    public static final BitSet FOLLOW_25_in_annotationTypeBody2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2800 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2802 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2814 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2863 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_annotationMethodRest2865 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotationMethodRest2867 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_defaultValue2897 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2899 = new BitSet(new long[]{0x0000000000000002L});

}
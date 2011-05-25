// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g 2011-05-25 20:47:58

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
import chameleon.core.namespace.NamespaceReference;
import chameleon.core.namespacepart.NamespacePart;
import chameleon.core.reference.SimpleReference;
import chameleon.core.reference.ElementReference;
import chameleon.core.variable.FormalParameter;
import chameleon.core.modifier.Modifier;
import chameleon.util.Pair;

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "StringLiteral", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "'{'", "'}'", "';'", "'('", "')'", "','", "'*'", "'connector'", "'ao-composition'", "'pointcut'", "'kind'", "':'", "'signature'", "'caller'", "'callee'", "'component'", "'application'", "'instance'", "'host'", "'advice'", "'service'", "'type'", "'require'", "'provide'", "'deployment'", "'on'", "'.'", "'before'", "'after'", "'around'", "'execution'", "'call'", "'override'", "'extend'", "'!'", "'abstract'", "'void'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'<'", "'>'", "'?'", "'extends'", "'super'", "'@'", "'='", "'default'"
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
        InvocationTarget target;
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
    public String getGrammarFileName() { return "/Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g"; }


    public static class compilationUnit_return extends ParserRuleReturnScope {
        public CompilationUnit element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compilationUnit"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:100:1: compilationUnit returns [CompilationUnit element] : (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )* ;
    public final MViewParser.compilationUnit_return compilationUnit() throws RecognitionException {
        MViewParser.compilationUnit_return retval = new MViewParser.compilationUnit_return();
        retval.start = input.LT(1);
        int compilationUnit_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.interfaceDeclaration_return ifd = null;

        MViewParser.componentDeclaration_return cod = null;

        MViewParser.connectorDeclaration_return cnd = null;

        MViewParser.applicationDeclaration_return apd = null;

        MViewParser.deploymentDeclaration_return dpd = null;



         
        	retval.element = getCompilationUnit();
        	NamespacePart npp = new NamespacePart(language().defaultNamespace());
        	retval.element.add(npp);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:106:2: ( (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:106:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:106:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )*
            loop1:
            do {
                int alt1=6;
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
                case 59:
                    {
                    switch ( input.LA(2) ) {
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
                    case 48:
                        {
                        alt1=5;
                        }
                        break;

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
                case 48:
                    {
                    alt1=5;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:107:4: ifd= interfaceDeclaration
            	    {
            	    pushFollow(FOLLOW_interfaceDeclaration_in_compilationUnit88);
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
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:109:4: cod= componentDeclaration
            	    {
            	    pushFollow(FOLLOW_componentDeclaration_in_compilationUnit101);
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
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:111:4: cnd= connectorDeclaration
            	    {
            	    pushFollow(FOLLOW_connectorDeclaration_in_compilationUnit114);
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
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:113:4: apd= applicationDeclaration
            	    {
            	    pushFollow(FOLLOW_applicationDeclaration_in_compilationUnit127);
            	    apd=applicationDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, apd.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((apd!=null?apd.element:null));
            	    }

            	    }
            	    break;
            	case 5 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:115:4: dpd= deploymentDeclaration
            	    {
            	    pushFollow(FOLLOW_deploymentDeclaration_in_compilationUnit140);
            	    dpd=deploymentDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, dpd.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((dpd!=null?dpd.element:null));
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:126:1: interfaceDeclaration returns [Interface element] : intkw= 'interface' name= Identifier interfaceBody[$element] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:127:2: (intkw= 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:127:4: intkw= 'interface' name= Identifier interfaceBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            intkw=(Token)match(input,23,FOLLOW_23_in_interfaceDeclaration170); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            intkw_tree = (Object)adaptor.create(intkw);
            adaptor.addChild(root_0, intkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration174); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Interface(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,intkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration180);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:136:1: interfaceBody[Interface element] : '{' ( interfaceBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:137:2: ( '{' ( interfaceBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:137:4: '{' ( interfaceBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal2=(Token)match(input,24,FOLLOW_24_in_interfaceBody194); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:137:8: ( interfaceBodyDeclaration[$element] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||(LA2_0>=60 && LA2_0<=68)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: interfaceBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody196);
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

            char_literal4=(Token)match(input,25,FOLLOW_25_in_interfaceBody200); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:141:1: interfaceBodyDeclaration[Interface element] : (service= serviceDeclaration ';' ) ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:142:2: ( (service= serviceDeclaration ';' ) )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:142:4: (service= serviceDeclaration ';' )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:142:4: (service= serviceDeclaration ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:142:5: service= serviceDeclaration ';'
            {
            pushFollow(FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration216);
            service=serviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal5=(Token)match(input,26,FOLLOW_26_in_interfaceBodyDeclaration218); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:153:1: serviceReferenceDeclaration returns [SimpleReference<Service> relation] : name= Identifier params= actualParameters ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:154:2: (name= Identifier params= actualParameters )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:154:4: name= Identifier params= actualParameters
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceReferenceDeclaration243); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_actualParameters_in_serviceReferenceDeclaration247);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:161:1: actualParameters returns [List<String> lst] : '(' (pars= actualParameterDecls )? ')' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:163:5: ( '(' (pars= actualParameterDecls )? ')' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:163:9: '(' (pars= actualParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal6=(Token)match(input,27,FOLLOW_27_in_actualParameters276); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:163:13: (pars= actualParameterDecls )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Identifier) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:163:14: pars= actualParameterDecls
                    {
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameters281);
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

            char_literal7=(Token)match(input,28,FOLLOW_28_in_actualParameters287); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:166:1: actualParameterDecls returns [List<String> lst] : name= Identifier ( ',' decls= actualParameterDecls )? ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:167:5: (name= Identifier ( ',' decls= actualParameterDecls )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:167:9: name= Identifier ( ',' decls= actualParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_actualParameterDecls312); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:167:25: ( ',' decls= actualParameterDecls )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==29) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:167:26: ',' decls= actualParameterDecls
                    {
                    char_literal8=(Token)match(input,29,FOLLOW_29_in_actualParameterDecls315); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (Object)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);
                    }
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameterDecls319);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:183:1: serviceDeclaration returns [Service element] : res= serviceHeaderDeclaration ;
    public final MViewParser.serviceDeclaration_return serviceDeclaration() throws RecognitionException {
        MViewParser.serviceDeclaration_return retval = new MViewParser.serviceDeclaration_return();
        retval.start = input.LT(1);
        int serviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.serviceHeaderDeclaration_return res = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:184:2: (res= serviceHeaderDeclaration )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:184:4: res= serviceHeaderDeclaration
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration352);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:190:1: serviceHeaderDeclaration returns [Service element] : rtype= serviceReturnType name= Identifier params= formalParameters ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:191:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:191:4: rtype= serviceReturnType name= Identifier params= formalParameters
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceReturnType_in_serviceHeaderDeclaration372);
            rtype=serviceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceHeaderDeclaration376); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_formalParameters_in_serviceHeaderDeclaration380);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:199:1: serviceReturnType returns [BasicTypeReference value] : (vt= voidType | tp= type ) ;
    public final MViewParser.serviceReturnType_return serviceReturnType() throws RecognitionException {
        MViewParser.serviceReturnType_return retval = new MViewParser.serviceReturnType_return();
        retval.start = input.LT(1);
        int serviceReturnType_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.voidType_return vt = null;

        MViewParser.type_return tp = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:200:2: ( (vt= voidType | tp= type ) )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:200:4: (vt= voidType | tp= type )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:200:4: (vt= voidType | tp= type )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==60) ) {
                alt5=1;
            }
            else if ( (LA5_0==Identifier||(LA5_0>=61 && LA5_0<=68)) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:201:4: vt= voidType
                    {
                    pushFollow(FOLLOW_voidType_in_serviceReturnType406);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:203:4: tp= type
                    {
                    pushFollow(FOLLOW_type_in_serviceReturnType420);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:208:1: formalParameters returns [List<FormalParameter> lst] : '(' (pars= formalParameterDecls )? ')' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:210:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:210:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal9=(Token)match(input,27,FOLLOW_27_in_formalParameters452); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal9_tree = (Object)adaptor.create(char_literal9);
            adaptor.addChild(root_0, char_literal9_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:210:13: (pars= formalParameterDecls )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Identifier||(LA6_0>=61 && LA6_0<=68)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:210:14: pars= formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters457);
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

            char_literal10=(Token)match(input,28,FOLLOW_28_in_formalParameters463); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:214:1: formalParameterDecls returns [List<FormalParameter> lst] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:215:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:215:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_type_in_formalParameterDecls489);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls493); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:215:32: ( ',' decls= formalParameterDecls )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==29) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:215:33: ',' decls= formalParameterDecls
                    {
                    char_literal11=(Token)match(input,29,FOLLOW_29_in_formalParameterDecls496); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal11_tree = (Object)adaptor.create(char_literal11);
                    adaptor.addChild(root_0, char_literal11_tree);
                    }
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls500);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:236:1: pointcutServiceSignatureDecl returns [ServiceSignature element] : rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters ;
    public final MViewParser.pointcutServiceSignatureDecl_return pointcutServiceSignatureDecl() throws RecognitionException {
        MViewParser.pointcutServiceSignatureDecl_return retval = new MViewParser.pointcutServiceSignatureDecl_return();
        retval.start = input.LT(1);
        int pointcutServiceSignatureDecl_StartIndex = input.index();
        Object root_0 = null;

        Token rtype=null;
        Token sig=null;
        MViewParser.pointcutServiceSignatureParameters_return pars = null;


        Object rtype_tree=null;
        Object sig_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:237:2: (rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:237:4: rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters
            {
            root_0 = (Object)adaptor.nil();

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

            pushFollow(FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl551);
            pars=pointcutServiceSignatureParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
            if ( state.backtracking==0 ) {

              			retval.element = new PatternSignature((rtype!=null?rtype.getText():null),(sig!=null?sig.getText():null),(pars!=null?pars.lst:null));
              		
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:243:1: pointcutServiceSignatureParameters returns [List<Pair<String,String>> lst] : '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:245:2: ( '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:245:4: '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal12=(Token)match(input,27,FOLLOW_27_in_pointcutServiceSignatureParameters574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:245:8: ( pointcutServiceSignatureParameterDecls[$lst] )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Identifier||LA8_0==30) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:245:9: pointcutServiceSignatureParameterDecls[$lst]
                    {
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters577);
                    pointcutServiceSignatureParameterDecls13=pointcutServiceSignatureParameterDecls(retval.lst);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutServiceSignatureParameterDecls13.getTree());

                    }
                    break;

            }

            char_literal14=(Token)match(input,28,FOLLOW_28_in_pointcutServiceSignatureParameters583); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:249:1: pointcutServiceSignatureParameterDecls[List<Pair<String,String>> lst] : t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:250:2: (t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:250:4: t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
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

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:250:23: (name= Identifier )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Identifier) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:250:24: name= Identifier
                    {
                    name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls607); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    name_tree = (Object)adaptor.create(name);
                    adaptor.addChild(root_0, name_tree);
                    }

                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:250:42: ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:250:43: ',' pointcutServiceSignatureParameterDecls[$lst]
                    {
                    char_literal15=(Token)match(input,29,FOLLOW_29_in_pointcutServiceSignatureParameterDecls612); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    adaptor.addChild(root_0, char_literal15_tree);
                    }
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls614);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:263:1: connectorDeclaration returns [Connector element] : (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:264:2: ( (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:264:4: (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:264:4: (abs= abstractModifier )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==59) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:264:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_connectorDeclaration645);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

            conkw=(Token)match(input,31,FOLLOW_31_in_connectorDeclaration651); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            conkw_tree = (Object)adaptor.create(conkw);
            adaptor.addChild(root_0, conkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration655); if (state.failed) return retval;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:274:3: ( refinementDeclaration[$element,Connector.class] )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==35) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:274:4: refinementDeclaration[$element,Connector.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_connectorDeclaration663);
                    refinementDeclaration17=refinementDeclaration(retval.element, Connector.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration17.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration670);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:279:1: connectorBody[Connector element] : '{' ( connectorBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:280:2: ( '{' ( connectorBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:280:4: '{' ( connectorBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal19=(Token)match(input,24,FOLLOW_24_in_connectorBody684); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:280:8: ( connectorBodyDeclaration[$element] )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==32||LA13_0==46||LA13_0==59) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: connectorBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_connectorBodyDeclaration_in_connectorBody686);
            	    connectorBodyDeclaration20=connectorBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorBodyDeclaration20.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            char_literal21=(Token)match(input,25,FOLLOW_25_in_connectorBody690); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:284:1: connectorBodyDeclaration[Connector element] : (aoc= connectorAOCompositionDeclaration | moduleRequireDependencyDeclaration[$element] );
    public final MViewParser.connectorBodyDeclaration_return connectorBodyDeclaration(Connector element) throws RecognitionException {
        MViewParser.connectorBodyDeclaration_return retval = new MViewParser.connectorBodyDeclaration_return();
        retval.start = input.LT(1);
        int connectorBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.connectorAOCompositionDeclaration_return aoc = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration22 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:285:2: (aoc= connectorAOCompositionDeclaration | moduleRequireDependencyDeclaration[$element] )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==32||LA14_0==59) ) {
                alt14=1;
            }
            else if ( (LA14_0==46) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:285:4: aoc= connectorAOCompositionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration705);
                    aoc=connectorAOCompositionDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aoc.getTree());
                    if ( state.backtracking==0 ) {

                      			element.addComposition((aoc!=null?aoc.element:null));
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:288:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration712);
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
            if ( state.backtracking>0 ) { memoize(input, 18, connectorBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "connectorBodyDeclaration"

    public static class connectorAOCompositionDeclaration_return extends ParserRuleReturnScope {
        public AOComposition element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectorAOCompositionDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:292:1: connectorAOCompositionDeclaration returns [AOComposition element] : (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclarationSingle[$element,AOComposition.class] )? connectorAOCompositionBody[$element] ;
    public final MViewParser.connectorAOCompositionDeclaration_return connectorAOCompositionDeclaration() throws RecognitionException {
        MViewParser.connectorAOCompositionDeclaration_return retval = new MViewParser.connectorAOCompositionDeclaration_return();
        retval.start = input.LT(1);
        int connectorAOCompositionDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token kw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs = null;

        MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle23 = null;

        MViewParser.connectorAOCompositionBody_return connectorAOCompositionBody24 = null;


        Object kw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:293:2: ( (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclarationSingle[$element,AOComposition.class] )? connectorAOCompositionBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:293:4: (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclarationSingle[$element,AOComposition.class] )? connectorAOCompositionBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:293:4: (abs= abstractModifier )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==59) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:293:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_connectorAOCompositionDeclaration734);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

            kw=(Token)match(input,32,FOLLOW_32_in_connectorAOCompositionDeclaration740); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kw_tree = (Object)adaptor.create(kw);
            adaptor.addChild(root_0, kw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorAOCompositionDeclaration744); if (state.failed) return retval;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:303:3: ( refinementDeclarationSingle[$element,AOComposition.class] )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:303:4: refinementDeclarationSingle[$element,AOComposition.class]
                    {
                    pushFollow(FOLLOW_refinementDeclarationSingle_in_connectorAOCompositionDeclaration752);
                    refinementDeclarationSingle23=refinementDeclarationSingle(retval.element, AOComposition.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationSingle23.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration759);
            connectorAOCompositionBody24=connectorAOCompositionBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorAOCompositionBody24.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 19, connectorAOCompositionDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "connectorAOCompositionDeclaration"

    public static class connectorAOCompositionBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectorAOCompositionBody"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:308:1: connectorAOCompositionBody[AOComposition element] : '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' ;
    public final MViewParser.connectorAOCompositionBody_return connectorAOCompositionBody(AOComposition element) throws RecognitionException {
        MViewParser.connectorAOCompositionBody_return retval = new MViewParser.connectorAOCompositionBody_return();
        retval.start = input.LT(1);
        int connectorAOCompositionBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal25=null;
        Token char_literal26=null;
        MViewParser.pointcutDeclaration_return pc = null;

        MViewParser.adviceDeclaration_return adv = null;


        Object char_literal25_tree=null;
        Object char_literal26_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:309:2: ( '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:309:4: '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal25=(Token)match(input,24,FOLLOW_24_in_connectorAOCompositionBody773); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:310:5: (pc= pointcutDeclaration )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: pc= pointcutDeclaration
                    {
                    pushFollow(FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody780);
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:313:6: (adv= adviceDeclaration )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==43) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: adv= adviceDeclaration
                    {
                    pushFollow(FOLLOW_adviceDeclaration_in_connectorAOCompositionBody789);
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
            char_literal26=(Token)match(input,25,FOLLOW_25_in_connectorAOCompositionBody796); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal26_tree = (Object)adaptor.create(char_literal26);
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
            if ( state.backtracking>0 ) { memoize(input, 20, connectorAOCompositionBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "connectorAOCompositionBody"

    public static class pointcutDeclaration_return extends ParserRuleReturnScope {
        public Pointcut pointcut;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:319:1: pointcutDeclaration returns [Pointcut pointcut] : pckw= 'pointcut' pointcutBody[$pointcut] ;
    public final MViewParser.pointcutDeclaration_return pointcutDeclaration() throws RecognitionException {
        MViewParser.pointcutDeclaration_return retval = new MViewParser.pointcutDeclaration_return();
        retval.start = input.LT(1);
        int pointcutDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token pckw=null;
        MViewParser.pointcutBody_return pointcutBody27 = null;


        Object pckw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:320:2: (pckw= 'pointcut' pointcutBody[$pointcut] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:320:4: pckw= 'pointcut' pointcutBody[$pointcut]
            {
            root_0 = (Object)adaptor.nil();

            pckw=(Token)match(input,33,FOLLOW_33_in_pointcutDeclaration813); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            pckw_tree = (Object)adaptor.create(pckw);
            adaptor.addChild(root_0, pckw_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.pointcut = new Pointcut();
              				setKeyword(retval.pointcut,pckw);
              			
            }
            pushFollow(FOLLOW_pointcutBody_in_pointcutDeclaration817);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:327:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
    public final MViewParser.pointcutBody_return pointcutBody(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutBody_return retval = new MViewParser.pointcutBody_return();
        retval.start = input.LT(1);
        int pointcutBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal28=null;
        Token char_literal30=null;
        MViewParser.pointcutBodyDeclaration_return pointcutBodyDeclaration29 = null;


        Object char_literal28_tree=null;
        Object char_literal30_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:328:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:328:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal28=(Token)match(input,24,FOLLOW_24_in_pointcutBody833); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:328:8: ( pointcutBodyDeclaration[$pointcut] )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==34||(LA19_0>=36 && LA19_0<=38)||(LA19_0>=56 && LA19_0<=57)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: pointcutBodyDeclaration[$pointcut]
            	    {
            	    pushFollow(FOLLOW_pointcutBodyDeclaration_in_pointcutBody835);
            	    pointcutBodyDeclaration29=pointcutBodyDeclaration(pointcut);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBodyDeclaration29.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            char_literal30=(Token)match(input,25,FOLLOW_25_in_pointcutBody839); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal30_tree = (Object)adaptor.create(char_literal30);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:332:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] );
    public final MViewParser.pointcutBodyDeclaration_return pointcutBodyDeclaration(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutBodyDeclaration_return retval = new MViewParser.pointcutBodyDeclaration_return();
        retval.start = input.LT(1);
        int pointcutBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.pointcutKindDeclaration_return pointcutKindDeclaration31 = null;

        MViewParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration32 = null;

        MViewParser.pointcutActorDeclaration_return pointcutActorDeclaration33 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:333:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt20=1;
                }
                break;
            case 36:
            case 56:
            case 57:
                {
                alt20=2;
                }
                break;
            case 37:
            case 38:
                {
                alt20=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:333:4: pointcutKindDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration853);
                    pointcutKindDeclaration31=pointcutKindDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutKindDeclaration31.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:334:4: pointcutSignatureDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration859);
                    pointcutSignatureDeclaration32=pointcutSignatureDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureDeclaration32.getTree());

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:335:4: pointcutActorDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration865);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:339:1: pointcutKindDeclaration[Pointcut pointcut] : kikw= 'kind' ':' kind= joinPointKind ';' ;
    public final MViewParser.pointcutKindDeclaration_return pointcutKindDeclaration(Pointcut pointcut) throws RecognitionException {
        MViewParser.pointcutKindDeclaration_return retval = new MViewParser.pointcutKindDeclaration_return();
        retval.start = input.LT(1);
        int pointcutKindDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token kikw=null;
        Token char_literal34=null;
        Token char_literal35=null;
        MViewParser.joinPointKind_return kind = null;


        Object kikw_tree=null;
        Object char_literal34_tree=null;
        Object char_literal35_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:340:2: (kikw= 'kind' ':' kind= joinPointKind ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:340:4: kikw= 'kind' ':' kind= joinPointKind ';'
            {
            root_0 = (Object)adaptor.nil();

            kikw=(Token)match(input,34,FOLLOW_34_in_pointcutKindDeclaration882); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kikw_tree = (Object)adaptor.create(kikw);
            adaptor.addChild(root_0, kikw_tree);
            }
            char_literal34=(Token)match(input,35,FOLLOW_35_in_pointcutKindDeclaration884); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal34_tree = (Object)adaptor.create(char_literal34);
            adaptor.addChild(root_0, char_literal34_tree);
            }
            pushFollow(FOLLOW_joinPointKind_in_pointcutKindDeclaration888);
            kind=joinPointKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, kind.getTree());
            char_literal35=(Token)match(input,26,FOLLOW_26_in_pointcutKindDeclaration890); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal35_tree = (Object)adaptor.create(char_literal35);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:347:1: pointcutSignatureDeclaration[Pointcut element] : (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' ;
    public final MViewParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration(Pointcut element) throws RecognitionException {
        MViewParser.pointcutSignatureDeclaration_return retval = new MViewParser.pointcutSignatureDeclaration_return();
        retval.start = input.LT(1);
        int pointcutSignatureDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token sikw=null;
        Token char_literal36=null;
        Token char_literal37=null;
        MViewParser.overrideOrExtend_return override = null;

        MViewParser.pointcutSignatureBody_return ps = null;


        Object sikw_tree=null;
        Object char_literal36_tree=null;
        Object char_literal37_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:348:2: ( (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:348:4: (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:348:4: (override= overrideOrExtend )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=56 && LA21_0<=57)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:348:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration909);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

            sikw=(Token)match(input,36,FOLLOW_36_in_pointcutSignatureDeclaration915); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            sikw_tree = (Object)adaptor.create(sikw);
            adaptor.addChild(root_0, sikw_tree);
            }
            char_literal36=(Token)match(input,35,FOLLOW_35_in_pointcutSignatureDeclaration917); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal36_tree = (Object)adaptor.create(char_literal36);
            adaptor.addChild(root_0, char_literal36_tree);
            }
            pushFollow(FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration921);
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
            char_literal37=(Token)match(input,26,FOLLOW_26_in_pointcutSignatureDeclaration925); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal37_tree = (Object)adaptor.create(char_literal37);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:359:1: pointcutSignatureBody returns [PointcutSignature element] : pointcutSignatureBodyDecls[$element] ;
    public final MViewParser.pointcutSignatureBody_return pointcutSignatureBody() throws RecognitionException {
        MViewParser.pointcutSignatureBody_return retval = new MViewParser.pointcutSignatureBody_return();
        retval.start = input.LT(1);
        int pointcutSignatureBody_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls38 = null;



         retval.element = new PointcutSignature(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:361:2: ( pointcutSignatureBodyDecls[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:361:4: pointcutSignatureBodyDecls[$element]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody944);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:365:1: pointcutSignatureBodyDecls[PointcutSignature element] : pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? ;
    public final MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls(PointcutSignature element) throws RecognitionException {
        MViewParser.pointcutSignatureBodyDecls_return retval = new MViewParser.pointcutSignatureBodyDecls_return();
        retval.start = input.LT(1);
        int pointcutSignatureBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal39=null;
        MViewParser.pointcutServiceSignatureDecl_return pss = null;

        MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls40 = null;


        Object char_literal39_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:366:2: (pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:366:4: pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls961);
            pss=pointcutServiceSignatureDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pss.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:366:37: ( ',' pointcutSignatureBodyDecls[$element] )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==29) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:366:39: ',' pointcutSignatureBodyDecls[$element]
                    {
                    char_literal39=(Token)match(input,29,FOLLOW_29_in_pointcutSignatureBodyDecls965); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal39_tree = (Object)adaptor.create(char_literal39);
                    adaptor.addChild(root_0, char_literal39_tree);
                    }
                    pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls967);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:372:1: pointcutActorDeclaration[Pointcut pointcut] : (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody );
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:373:2: (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==37) ) {
                alt23=1;
            }
            else if ( (LA23_0==38) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:373:4: clkw= 'caller' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();

                    clkw=(Token)match(input,37,FOLLOW_37_in_pointcutActorDeclaration989); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    clkw_tree = (Object)adaptor.create(clkw);
                    adaptor.addChild(root_0, clkw_tree);
                    }
                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration993);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:378:3: clkw= 'callee' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();

                    clkw=(Token)match(input,38,FOLLOW_38_in_pointcutActorDeclaration1004); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    clkw_tree = (Object)adaptor.create(clkw);
                    adaptor.addChild(root_0, clkw_tree);
                    }
                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1008);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:389:1: pointcutActorBody returns [Actor element] : '{' ( pointcutActorBodyDecls[$element] )* '}' ;
    public final MViewParser.pointcutActorBody_return pointcutActorBody() throws RecognitionException {
        MViewParser.pointcutActorBody_return retval = new MViewParser.pointcutActorBody_return();
        retval.start = input.LT(1);
        int pointcutActorBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal41=null;
        Token char_literal43=null;
        MViewParser.pointcutActorBodyDecls_return pointcutActorBodyDecls42 = null;


        Object char_literal41_tree=null;
        Object char_literal43_tree=null;


        	retval.element = new Actor();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:393:2: ( '{' ( pointcutActorBodyDecls[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:393:4: '{' ( pointcutActorBodyDecls[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal41=(Token)match(input,24,FOLLOW_24_in_pointcutActorBody1036); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = (Object)adaptor.create(char_literal41);
            adaptor.addChild(root_0, char_literal41_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:393:8: ( pointcutActorBodyDecls[$element] )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==23||(LA24_0>=39 && LA24_0<=42)||(LA24_0>=56 && LA24_0<=57)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: pointcutActorBodyDecls[$element]
            	    {
            	    pushFollow(FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1038);
            	    pointcutActorBodyDecls42=pointcutActorBodyDecls(retval.element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorBodyDecls42.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            char_literal43=(Token)match(input,25,FOLLOW_25_in_pointcutActorBody1042); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal43_tree = (Object)adaptor.create(char_literal43);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:397:1: pointcutActorBodyDecls[Actor actor] : (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' ;
    public final MViewParser.pointcutActorBodyDecls_return pointcutActorBodyDecls(Actor actor) throws RecognitionException {
        MViewParser.pointcutActorBodyDecls_return retval = new MViewParser.pointcutActorBodyDecls_return();
        retval.start = input.LT(1);
        int pointcutActorBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal44=null;
        Token char_literal45=null;
        Token string_literal46=null;
        Token char_literal47=null;
        Token string_literal48=null;
        Token char_literal49=null;
        Token string_literal50=null;
        Token char_literal51=null;
        Token string_literal52=null;
        Token char_literal53=null;
        Token char_literal55=null;
        MViewParser.overrideOrExtend_return override = null;

        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls54 = null;


        Object string_literal44_tree=null;
        Object char_literal45_tree=null;
        Object string_literal46_tree=null;
        Object char_literal47_tree=null;
        Object string_literal48_tree=null;
        Object char_literal49_tree=null;
        Object string_literal50_tree=null;
        Object char_literal51_tree=null;
        Object string_literal52_tree=null;
        Object char_literal53_tree=null;
        Object char_literal55_tree=null;


        	ActorProp prop = null;
        	Class<? extends Declaration> declClass = null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:402:2: ( (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:402:4: (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:402:4: (override= overrideOrExtend )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=56 && LA25_0<=57)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:402:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1063);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:403:2: ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' )
            int alt26=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt26=1;
                }
                break;
            case 39:
                {
                alt26=2;
                }
                break;
            case 40:
                {
                alt26=3;
                }
                break;
            case 41:
                {
                alt26=4;
                }
                break;
            case 42:
                {
                alt26=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:404:3: 'interface' ':'
                    {
                    string_literal44=(Token)match(input,23,FOLLOW_23_in_pointcutActorBodyDecls1072); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal44_tree = (Object)adaptor.create(string_literal44);
                    adaptor.addChild(root_0, string_literal44_tree);
                    }
                    char_literal45=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1074); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    adaptor.addChild(root_0, char_literal45_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Interface.class;
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:408:3: 'component' ':'
                    {
                    string_literal46=(Token)match(input,39,FOLLOW_39_in_pointcutActorBodyDecls1084); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal46_tree = (Object)adaptor.create(string_literal46);
                    adaptor.addChild(root_0, string_literal46_tree);
                    }
                    char_literal47=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1086); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    adaptor.addChild(root_0, char_literal47_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Component.class;
                      		
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:412:3: 'application' ':'
                    {
                    string_literal48=(Token)match(input,40,FOLLOW_40_in_pointcutActorBodyDecls1095); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal48_tree = (Object)adaptor.create(string_literal48);
                    adaptor.addChild(root_0, string_literal48_tree);
                    }
                    char_literal49=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1097); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    adaptor.addChild(root_0, char_literal49_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Application.class;
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:416:3: 'instance' ':'
                    {
                    string_literal50=(Token)match(input,41,FOLLOW_41_in_pointcutActorBodyDecls1106); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal50_tree = (Object)adaptor.create(string_literal50);
                    adaptor.addChild(root_0, string_literal50_tree);
                    }
                    char_literal51=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1108); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal51_tree = (Object)adaptor.create(char_literal51);
                    adaptor.addChild(root_0, char_literal51_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Instance.class;
                      		
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:420:3: 'host' ':'
                    {
                    string_literal52=(Token)match(input,42,FOLLOW_42_in_pointcutActorBodyDecls1117); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal52_tree = (Object)adaptor.create(string_literal52);
                    adaptor.addChild(root_0, string_literal52_tree);
                    }
                    char_literal53=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1119); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal53_tree = (Object)adaptor.create(char_literal53);
                    adaptor.addChild(root_0, char_literal53_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Host.class;
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		prop = new ActorProp(new PropModifier(declClass));
              		actor.addProp(prop);
              		if ((override!=null?override.value:null) != null) {
              			prop.addModifier((override!=null?override.value:null));
              		}
              	
            }
            pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1128);
            pointcutActorPropDecls54=pointcutActorPropDecls(prop, declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls54.getTree());
            char_literal55=(Token)match(input,26,FOLLOW_26_in_pointcutActorBodyDecls1131); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal55_tree = (Object)adaptor.create(char_literal55);
            adaptor.addChild(root_0, char_literal55_tree);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:433:1: pointcutActorPropDecls[ActorProp prop,Class<? extends Declaration> declClass] : (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? ;
    public final MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls(ActorProp prop, Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecls_return retval = new MViewParser.pointcutActorPropDecls_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecls_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal56=null;
        MViewParser.negationModifier_return negate = null;

        MViewParser.pointcutActorPropDecl_return apdref = null;

        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls57 = null;


        Object char_literal56_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:434:2: ( (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:434:5: (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:434:5: (negate= negationModifier )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==58) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:434:6: negate= negationModifier
                    {
                    pushFollow(FOLLOW_negationModifier_in_pointcutActorPropDecls1148);
                    negate=negationModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, negate.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1154);
            apdref=pointcutActorPropDecl(declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, apdref.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:434:73: ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==29) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:434:75: ',' pointcutActorPropDecls[$prop,$declClass]
                    {
                    char_literal56=(Token)match(input,29,FOLLOW_29_in_pointcutActorPropDecls1159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal56_tree = (Object)adaptor.create(char_literal56);
                    adaptor.addChild(root_0, char_literal56_tree);
                    }
                    pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1161);
                    pointcutActorPropDecls57=pointcutActorPropDecls(prop, declClass);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls57.getTree());

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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:445:1: pointcutActorPropDecl[Class<? extends Declaration> declClass] returns [SimpleReference<? extends Declaration> relation] : name= Identifier ;
    public final MViewParser.pointcutActorPropDecl_return pointcutActorPropDecl(Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecl_return retval = new MViewParser.pointcutActorPropDecl_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecl_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;

        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:446:2: (name= Identifier )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:446:5: name= Identifier
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutActorPropDecl1186); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:454:1: adviceDeclaration returns [Advice advice] : avkw= 'advice' adviceBody[$advice] ;
    public final MViewParser.adviceDeclaration_return adviceDeclaration() throws RecognitionException {
        MViewParser.adviceDeclaration_return retval = new MViewParser.adviceDeclaration_return();
        retval.start = input.LT(1);
        int adviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token avkw=null;
        MViewParser.adviceBody_return adviceBody58 = null;


        Object avkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:455:2: (avkw= 'advice' adviceBody[$advice] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:455:4: avkw= 'advice' adviceBody[$advice]
            {
            root_0 = (Object)adaptor.nil();

            avkw=(Token)match(input,43,FOLLOW_43_in_adviceDeclaration1209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            avkw_tree = (Object)adaptor.create(avkw);
            adaptor.addChild(root_0, avkw_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.advice = new Advice();
              			setKeyword(retval.advice,avkw);
              		
            }
            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration1213);
            adviceBody58=adviceBody(retval.advice);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBody58.getTree());

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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:462:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
    public final MViewParser.adviceBody_return adviceBody(Advice advice) throws RecognitionException {
        MViewParser.adviceBody_return retval = new MViewParser.adviceBody_return();
        retval.start = input.LT(1);
        int adviceBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal59=null;
        Token char_literal61=null;
        MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration60 = null;


        Object char_literal59_tree=null;
        Object char_literal61_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:463:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:463:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal59=(Token)match(input,24,FOLLOW_24_in_adviceBody1228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal59_tree = (Object)adaptor.create(char_literal59);
            adaptor.addChild(root_0, char_literal59_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:463:8: ( adviceBodyDeclaration[$advice] )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=44 && LA29_0<=45)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: adviceBodyDeclaration[$advice]
            	    {
            	    pushFollow(FOLLOW_adviceBodyDeclaration_in_adviceBody1230);
            	    adviceBodyDeclaration60=adviceBodyDeclaration(advice);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBodyDeclaration60.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            char_literal61=(Token)match(input,25,FOLLOW_25_in_adviceBody1234); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal61_tree = (Object)adaptor.create(char_literal61);
            adaptor.addChild(root_0, char_literal61_tree);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:467:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] );
    public final MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceBodyDeclaration_return retval = new MViewParser.adviceBodyDeclaration_return();
        retval.start = input.LT(1);
        int adviceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration62 = null;

        MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration63 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:468:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==44) ) {
                alt30=1;
            }
            else if ( (LA30_0==45) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:468:4: adviceServiceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1249);
                    adviceServiceDeclaration62=adviceServiceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceServiceDeclaration62.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:469:4: adviceTypeDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1255);
                    adviceTypeDeclaration63=adviceTypeDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceTypeDeclaration63.getTree());

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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:473:1: adviceServiceDeclaration[Advice advice] : svkw= 'service' ':' service= serviceReferenceDeclaration ';' ;
    public final MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceServiceDeclaration_return retval = new MViewParser.adviceServiceDeclaration_return();
        retval.start = input.LT(1);
        int adviceServiceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token svkw=null;
        Token char_literal64=null;
        Token char_literal65=null;
        MViewParser.serviceReferenceDeclaration_return service = null;


        Object svkw_tree=null;
        Object char_literal64_tree=null;
        Object char_literal65_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:474:2: (svkw= 'service' ':' service= serviceReferenceDeclaration ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:474:4: svkw= 'service' ':' service= serviceReferenceDeclaration ';'
            {
            root_0 = (Object)adaptor.nil();

            svkw=(Token)match(input,44,FOLLOW_44_in_adviceServiceDeclaration1273); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            svkw_tree = (Object)adaptor.create(svkw);
            adaptor.addChild(root_0, svkw_tree);
            }
            char_literal64=(Token)match(input,35,FOLLOW_35_in_adviceServiceDeclaration1275); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
            }
            pushFollow(FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1279);
            service=serviceReferenceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal65=(Token)match(input,26,FOLLOW_26_in_adviceServiceDeclaration1281); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = (Object)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:481:1: adviceTypeDeclaration[Advice advice] : tpkw= 'type' ':' avtype= adviceType ';' ;
    public final MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceTypeDeclaration_return retval = new MViewParser.adviceTypeDeclaration_return();
        retval.start = input.LT(1);
        int adviceTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token tpkw=null;
        Token char_literal66=null;
        Token char_literal67=null;
        MViewParser.adviceType_return avtype = null;


        Object tpkw_tree=null;
        Object char_literal66_tree=null;
        Object char_literal67_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:482:2: (tpkw= 'type' ':' avtype= adviceType ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:482:4: tpkw= 'type' ':' avtype= adviceType ';'
            {
            root_0 = (Object)adaptor.nil();

            tpkw=(Token)match(input,45,FOLLOW_45_in_adviceTypeDeclaration1300); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tpkw_tree = (Object)adaptor.create(tpkw);
            adaptor.addChild(root_0, tpkw_tree);
            }
            char_literal66=(Token)match(input,35,FOLLOW_35_in_adviceTypeDeclaration1302); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal66_tree = (Object)adaptor.create(char_literal66);
            adaptor.addChild(root_0, char_literal66_tree);
            }
            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration1306);
            avtype=adviceType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, avtype.getTree());
            char_literal67=(Token)match(input,26,FOLLOW_26_in_adviceTypeDeclaration1308); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal67_tree = (Object)adaptor.create(char_literal67);
            adaptor.addChild(root_0, char_literal67_tree);
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

    public static class componentDeclaration_return extends ParserRuleReturnScope {
        public Component element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:494:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier componentBody[$element] ;
    public final MViewParser.componentDeclaration_return componentDeclaration() throws RecognitionException {
        MViewParser.componentDeclaration_return retval = new MViewParser.componentDeclaration_return();
        retval.start = input.LT(1);
        int componentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token compkw=null;
        Token name=null;
        MViewParser.componentBody_return componentBody68 = null;


        Object compkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:495:2: (compkw= 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:495:5: compkw= 'component' name= Identifier componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            compkw=(Token)match(input,39,FOLLOW_39_in_componentDeclaration1335); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            compkw_tree = (Object)adaptor.create(compkw);
            adaptor.addChild(root_0, compkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration1339); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                 			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                 			setKeyword(retval.element,compkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_componentBody_in_componentDeclaration1343);
            componentBody68=componentBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBody68.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 38, componentDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentDeclaration"

    public static class componentBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentBody"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:503:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
    public final MViewParser.componentBody_return componentBody(Component element) throws RecognitionException {
        MViewParser.componentBody_return retval = new MViewParser.componentBody_return();
        retval.start = input.LT(1);
        int componentBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal69=null;
        Token char_literal71=null;
        MViewParser.componentBodyDeclaration_return componentBodyDeclaration70 = null;


        Object char_literal69_tree=null;
        Object char_literal71_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:504:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:504:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal69=(Token)match(input,24,FOLLOW_24_in_componentBody1365); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal69_tree = (Object)adaptor.create(char_literal69);
            adaptor.addChild(root_0, char_literal69_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:504:8: ( componentBodyDeclaration[$element] )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=46 && LA31_0<=47)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody1367);
            	    componentBodyDeclaration70=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration70.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            char_literal71=(Token)match(input,25,FOLLOW_25_in_componentBody1371); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal71_tree = (Object)adaptor.create(char_literal71);
            adaptor.addChild(root_0, char_literal71_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 39, componentBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentBody"

    public static class componentBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentBodyDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:508:1: componentBodyDeclaration[Component element] : ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] );
    public final MViewParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MViewParser.componentBodyDeclaration_return retval = new MViewParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);
        int componentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration72 = null;

        MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration73 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:509:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==46) ) {
                alt32=1;
            }
            else if ( (LA32_0==47) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:509:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1389);
                    moduleRequireDependencyDeclaration72=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration72.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:510:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1395);
                    moduleProvideDependencyDeclaration73=moduleProvideDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleProvideDependencyDeclaration73.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 40, componentBodyDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:520:1: moduleDependencyBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' ;
    public final MViewParser.moduleDependencyBody_return moduleDependencyBody() throws RecognitionException {
        MViewParser.moduleDependencyBody_return retval = new MViewParser.moduleDependencyBody_return();
        retval.start = input.LT(1);
        int moduleDependencyBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal74=null;
        Token char_literal75=null;
        MViewParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal74_tree=null;
        Object char_literal75_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:522:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:522:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal74=(Token)match(input,24,FOLLOW_24_in_moduleDependencyBody1423); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal74_tree = (Object)adaptor.create(char_literal74);
            adaptor.addChild(root_0, char_literal74_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:522:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==Identifier) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:522:9: decls= commaSeparatedBodyDecls[Interface.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1428);
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

            char_literal75=(Token)match(input,25,FOLLOW_25_in_moduleDependencyBody1436); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal75_tree = (Object)adaptor.create(char_literal75);
            adaptor.addChild(root_0, char_literal75_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 41, moduleDependencyBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "moduleDependencyBody"

    public static class moduleRequireDependencyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleRequireDependencyDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:526:1: moduleRequireDependencyDeclaration[Module element] : rekw= 'require' rd= moduleDependencyBody ;
    public final MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration(Module element) throws RecognitionException {
        MViewParser.moduleRequireDependencyDeclaration_return retval = new MViewParser.moduleRequireDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleRequireDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token rekw=null;
        MViewParser.moduleDependencyBody_return rd = null;


        Object rekw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:527:2: (rekw= 'require' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:527:4: rekw= 'require' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            rekw=(Token)match(input,46,FOLLOW_46_in_moduleRequireDependencyDeclaration1453); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rekw_tree = (Object)adaptor.create(rekw);
            adaptor.addChild(root_0, rekw_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1457);
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
            if ( state.backtracking>0 ) { memoize(input, 42, moduleRequireDependencyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "moduleRequireDependencyDeclaration"

    public static class moduleProvideDependencyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleProvideDependencyDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:535:1: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
    public final MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration(Module element) throws RecognitionException {
        MViewParser.moduleProvideDependencyDeclaration_return retval = new MViewParser.moduleProvideDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleProvideDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal76=null;
        MViewParser.moduleDependencyBody_return rd = null;


        Object string_literal76_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:536:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:536:4: 'provide' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal76=(Token)match(input,47,FOLLOW_47_in_moduleProvideDependencyDeclaration1472); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal76_tree = (Object)adaptor.create(string_literal76);
            adaptor.addChild(root_0, string_literal76_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1476);
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
            if ( state.backtracking>0 ) { memoize(input, 43, moduleProvideDependencyDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:575:1: applicationDeclaration returns [Application element] : (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] ;
    public final MViewParser.applicationDeclaration_return applicationDeclaration() throws RecognitionException {
        MViewParser.applicationDeclaration_return retval = new MViewParser.applicationDeclaration_return();
        retval.start = input.LT(1);
        int applicationDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token appkw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs = null;

        MViewParser.refinementDeclaration_return refinementDeclaration77 = null;

        MViewParser.applicationBody_return applicationBody78 = null;


        Object appkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:576:2: ( (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:576:4: (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:576:4: (abs= abstractModifier )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==59) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:576:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_applicationDeclaration1509);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

            appkw=(Token)match(input,40,FOLLOW_40_in_applicationDeclaration1515); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_applicationDeclaration1519); if (state.failed) return retval;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:586:3: ( refinementDeclaration[$element,Application.class] )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==35) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:586:4: refinementDeclaration[$element,Application.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_applicationDeclaration1527);
                    refinementDeclaration77=refinementDeclaration(retval.element, Application.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration77.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_applicationBody_in_applicationDeclaration1534);
            applicationBody78=applicationBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBody78.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 44, applicationDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "applicationDeclaration"

    public static class applicationBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "applicationBody"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:591:1: applicationBody[Application element] : '{' ( applicationBodyDeclaration[$element] )* '}' ;
    public final MViewParser.applicationBody_return applicationBody(Application element) throws RecognitionException {
        MViewParser.applicationBody_return retval = new MViewParser.applicationBody_return();
        retval.start = input.LT(1);
        int applicationBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal79=null;
        Token char_literal81=null;
        MViewParser.applicationBodyDeclaration_return applicationBodyDeclaration80 = null;


        Object char_literal79_tree=null;
        Object char_literal81_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:592:2: ( '{' ( applicationBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:592:4: '{' ( applicationBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal79=(Token)match(input,24,FOLLOW_24_in_applicationBody1548); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal79_tree = (Object)adaptor.create(char_literal79);
            adaptor.addChild(root_0, char_literal79_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:592:8: ( applicationBodyDeclaration[$element] )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==Identifier||LA36_0==31||LA36_0==39||LA36_0==42||LA36_0==59) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:592:10: applicationBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_applicationBodyDeclaration_in_applicationBody1552);
            	    applicationBodyDeclaration80=applicationBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBodyDeclaration80.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            char_literal81=(Token)match(input,25,FOLLOW_25_in_applicationBody1558); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal81_tree = (Object)adaptor.create(char_literal81);
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
            if ( state.backtracking>0 ) { memoize(input, 45, applicationBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "applicationBody"

    public static class applicationBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "applicationBodyDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:596:1: applicationBodyDeclaration[Application element] : (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration );
    public final MViewParser.applicationBodyDeclaration_return applicationBodyDeclaration(Application element) throws RecognitionException {
        MViewParser.applicationBodyDeclaration_return retval = new MViewParser.applicationBodyDeclaration_return();
        retval.start = input.LT(1);
        int applicationBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.moduleContainerDeclarations_return mod = null;

        MViewParser.hostDeclaration_return hod = null;

        MViewParser.instanceDeclaration_return ind = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:597:2: (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration )
            int alt37=3;
            switch ( input.LA(1) ) {
            case 31:
            case 39:
            case 59:
                {
                alt37=1;
                }
                break;
            case 42:
                {
                alt37=2;
                }
                break;
            case Identifier:
                {
                alt37=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:597:4: mod= moduleContainerDeclarations
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1574);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:601:3: hod= hostDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hostDeclaration_in_applicationBodyDeclaration1585);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:605:3: ind= instanceDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1597);
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
            if ( state.backtracking>0 ) { memoize(input, 46, applicationBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "applicationBodyDeclaration"

    public static class deploymentDeclaration_return extends ParserRuleReturnScope {
        public Deployment element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deploymentDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:615:1: deploymentDeclaration returns [Deployment element] : (abs= abstractModifier )? appkw= 'deployment' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] ;
    public final MViewParser.deploymentDeclaration_return deploymentDeclaration() throws RecognitionException {
        MViewParser.deploymentDeclaration_return retval = new MViewParser.deploymentDeclaration_return();
        retval.start = input.LT(1);
        int deploymentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token appkw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs = null;

        MViewParser.refinementDeclaration_return refinementDeclaration82 = null;

        MViewParser.applicationBody_return applicationBody83 = null;


        Object appkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:616:2: ( (abs= abstractModifier )? appkw= 'deployment' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:616:4: (abs= abstractModifier )? appkw= 'deployment' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:616:4: (abs= abstractModifier )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==59) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:616:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_deploymentDeclaration1623);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

            appkw=(Token)match(input,48,FOLLOW_48_in_deploymentDeclaration1629); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_deploymentDeclaration1633); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Deployment(new SimpleNameSignature((name!=null?name.getText():null)));

              			if ((abs!=null?abs.value:null) != null) {
              				retval.element.addModifier((abs!=null?abs.value:null));
              			}

              			setKeyword(retval.element,appkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:626:3: ( refinementDeclaration[$element,Application.class] )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==35) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:626:4: refinementDeclaration[$element,Application.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_deploymentDeclaration1641);
                    refinementDeclaration82=refinementDeclaration(retval.element, Application.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration82.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_applicationBody_in_deploymentDeclaration1648);
            applicationBody83=applicationBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBody83.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 47, deploymentDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "deploymentDeclaration"

    public static class instanceDeclaration_return extends ParserRuleReturnScope {
        public Instance element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instanceDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:636:1: instanceDeclaration returns [Instance element] : tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';' ;
    public final MViewParser.instanceDeclaration_return instanceDeclaration() throws RecognitionException {
        MViewParser.instanceDeclaration_return retval = new MViewParser.instanceDeclaration_return();
        retval.start = input.LT(1);
        int instanceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token tpe=null;
        Token name=null;
        Token onkw=null;
        Token hst=null;
        Token char_literal84=null;

        Object tpe_tree=null;
        Object name_tree=null;
        Object onkw_tree=null;
        Object hst_tree=null;
        Object char_literal84_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:637:2: (tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:637:4: tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';'
            {
            root_0 = (Object)adaptor.nil();

            tpe=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1671); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tpe_tree = (Object)adaptor.create(tpe);
            adaptor.addChild(root_0, tpe_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1675); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            onkw=(Token)match(input,49,FOLLOW_49_in_instanceDeclaration1679); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            onkw_tree = (Object)adaptor.create(onkw);
            adaptor.addChild(root_0, onkw_tree);
            }
            hst=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1683); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hst_tree = (Object)adaptor.create(hst);
            adaptor.addChild(root_0, hst_tree);
            }
            char_literal84=(Token)match(input,26,FOLLOW_26_in_instanceDeclaration1685); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal84_tree = (Object)adaptor.create(char_literal84);
            adaptor.addChild(root_0, char_literal84_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 48, instanceDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:663:1: hostDeclaration returns [Host element] : hkw= 'host' name= Identifier (onkw= 'on' value= StringLiteral )? ';' ;
    public final MViewParser.hostDeclaration_return hostDeclaration() throws RecognitionException {
        MViewParser.hostDeclaration_return retval = new MViewParser.hostDeclaration_return();
        retval.start = input.LT(1);
        int hostDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token hkw=null;
        Token name=null;
        Token onkw=null;
        Token value=null;
        Token char_literal85=null;

        Object hkw_tree=null;
        Object name_tree=null;
        Object onkw_tree=null;
        Object value_tree=null;
        Object char_literal85_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:664:2: (hkw= 'host' name= Identifier (onkw= 'on' value= StringLiteral )? ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:664:5: hkw= 'host' name= Identifier (onkw= 'on' value= StringLiteral )? ';'
            {
            root_0 = (Object)adaptor.nil();

            hkw=(Token)match(input,42,FOLLOW_42_in_hostDeclaration1712); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hkw_tree = (Object)adaptor.create(hkw);
            adaptor.addChild(root_0, hkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_hostDeclaration1716); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			
              			retval.element = new Host(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,hkw);
              			setLocation(retval.element,name,"__NAME");
              			
              		
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:670:5: (onkw= 'on' value= StringLiteral )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==49) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:670:7: onkw= 'on' value= StringLiteral
                    {
                    onkw=(Token)match(input,49,FOLLOW_49_in_hostDeclaration1724); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    onkw_tree = (Object)adaptor.create(onkw);
                    adaptor.addChild(root_0, onkw_tree);
                    }
                    value=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_hostDeclaration1728); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    value_tree = (Object)adaptor.create(value);
                    adaptor.addChild(root_0, value_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			
                      			HostName hostName = new HostName(new SimpleNameSignature((value!=null?value.getText():null)));
                      //			SimpleReference<HostName> hostNameRelation = new SimpleReference<HostName>((value!=null?value.getText():null),HostName.class);
                      			retval.element.setHostName(hostName);
                      			setKeyword(hostName,onkw);
                      			
                      		
                    }

                    }
                    break;

            }

            char_literal85=(Token)match(input,26,FOLLOW_26_in_hostDeclaration1735); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal85_tree = (Object)adaptor.create(char_literal85);
            adaptor.addChild(root_0, char_literal85_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 49, hostDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:686:1: moduleContainerDeclarations returns [Module element] : (cod= componentDeclaration | cnd= connectorDeclaration );
    public final MViewParser.moduleContainerDeclarations_return moduleContainerDeclarations() throws RecognitionException {
        MViewParser.moduleContainerDeclarations_return retval = new MViewParser.moduleContainerDeclarations_return();
        retval.start = input.LT(1);
        int moduleContainerDeclarations_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.componentDeclaration_return cod = null;

        MViewParser.connectorDeclaration_return cnd = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:687:2: (cod= componentDeclaration | cnd= connectorDeclaration )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==39) ) {
                alt41=1;
            }
            else if ( (LA41_0==31||LA41_0==59) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:688:3: cod= componentDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_componentDeclaration_in_moduleContainerDeclarations1761);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:692:3: cnd= connectorDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1772);
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
            if ( state.backtracking>0 ) { memoize(input, 50, moduleContainerDeclarations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "moduleContainerDeclarations"

    public static class refinementDeclarationSingle_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "refinementDeclarationSingle"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:719:1: refinementDeclarationSingle[RefinableDeclaration element, Class kind] : rfkw= ':' refinementDeclarationBody[$element,$kind] ;
    public final MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementDeclarationSingle_return retval = new MViewParser.refinementDeclarationSingle_return();
        retval.start = input.LT(1);
        int refinementDeclarationSingle_StartIndex = input.index();
        Object root_0 = null;

        Token rfkw=null;
        MViewParser.refinementDeclarationBody_return refinementDeclarationBody86 = null;


        Object rfkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:720:2: (rfkw= ':' refinementDeclarationBody[$element,$kind] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:720:4: rfkw= ':' refinementDeclarationBody[$element,$kind]
            {
            root_0 = (Object)adaptor.nil();

            rfkw=(Token)match(input,35,FOLLOW_35_in_refinementDeclarationSingle1797); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rfkw_tree = (Object)adaptor.create(rfkw);
            adaptor.addChild(root_0, rfkw_tree);
            }
            pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1799);
            refinementDeclarationBody86=refinementDeclarationBody(element, kind);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationBody86.getTree());
            if ( state.backtracking==0 ) {

              			setKeyword(element,rfkw);
              		
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
            if ( state.backtracking>0 ) { memoize(input, 51, refinementDeclarationSingle_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "refinementDeclarationSingle"

    public static class refinementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "refinementDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:726:1: refinementDeclaration[RefinableDeclaration element, Class kind] : refinementDeclarationSingle[$element,$kind] ( ',' refinementDeclarationBody[$element,$kind] )* ;
    public final MViewParser.refinementDeclaration_return refinementDeclaration(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementDeclaration_return retval = new MViewParser.refinementDeclaration_return();
        retval.start = input.LT(1);
        int refinementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal88=null;
        MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle87 = null;

        MViewParser.refinementDeclarationBody_return refinementDeclarationBody89 = null;


        Object char_literal88_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:727:2: ( refinementDeclarationSingle[$element,$kind] ( ',' refinementDeclarationBody[$element,$kind] )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:727:4: refinementDeclarationSingle[$element,$kind] ( ',' refinementDeclarationBody[$element,$kind] )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1816);
            refinementDeclarationSingle87=refinementDeclarationSingle(element, kind);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationSingle87.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:727:48: ( ',' refinementDeclarationBody[$element,$kind] )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==29) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:727:50: ',' refinementDeclarationBody[$element,$kind]
            	    {
            	    char_literal88=(Token)match(input,29,FOLLOW_29_in_refinementDeclaration1821); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal88_tree = (Object)adaptor.create(char_literal88);
            	    adaptor.addChild(root_0, char_literal88_tree);
            	    }
            	    pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclaration1823);
            	    refinementDeclarationBody89=refinementDeclarationBody(element, kind);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationBody89.getTree());

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
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 52, refinementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "refinementDeclaration"

    public static class refinementDeclarationBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "refinementDeclarationBody"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:731:1: refinementDeclarationBody[RefinableDeclaration element, Class kind] : parent= refinementParentDeclaration[$kind] ;
    public final MViewParser.refinementDeclarationBody_return refinementDeclarationBody(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementDeclarationBody_return retval = new MViewParser.refinementDeclarationBody_return();
        retval.start = input.LT(1);
        int refinementDeclarationBody_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.refinementParentDeclaration_return parent = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:732:2: (parent= refinementParentDeclaration[$kind] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:732:4: parent= refinementParentDeclaration[$kind]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_refinementParentDeclaration_in_refinementDeclarationBody1844);
            parent=refinementParentDeclaration(kind);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, parent.getTree());
            if ( state.backtracking==0 ) {

              			RefinementRelation relation = new RefinementRelation((parent!=null?parent.reference:null));
              			element.addRefinementRelation(relation);
              		
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
            if ( state.backtracking>0 ) { memoize(input, 53, refinementDeclarationBody_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:739:1: refinementParentDeclaration[Class kind] returns [SimpleReference reference] : name= Identifier ( '.' namex= Identifier )* ;
    public final MViewParser.refinementParentDeclaration_return refinementParentDeclaration(Class kind) throws RecognitionException {
        MViewParser.refinementParentDeclaration_return retval = new MViewParser.refinementParentDeclaration_return();
        retval.start = input.LT(1);
        int refinementParentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal90=null;

        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal90_tree=null;

        Token start = null; 
              Token end = null;
              SimpleReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:747:2: (name= Identifier ( '.' namex= Identifier )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:747:4: name= Identifier ( '.' namex= Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_refinementParentDeclaration1874); if (state.failed) return retval;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:753:3: ( '.' namex= Identifier )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==50) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:753:4: '.' namex= Identifier
            	    {
            	    char_literal90=(Token)match(input,50,FOLLOW_50_in_refinementParentDeclaration1881); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal90_tree = (Object)adaptor.create(char_literal90);
            	    adaptor.addChild(root_0, char_literal90_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_refinementParentDeclaration1885); if (state.failed) return retval;
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
            	      				start = namex;
            	      				end = namex;
            	      			
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
            if ( state.backtracking>0 ) { memoize(input, 54, refinementParentDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:773:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
    public final MViewParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls(Class targetType) throws RecognitionException {
        MViewParser.commaSeparatedBodyDecls_return retval = new MViewParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);
        int commaSeparatedBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token char_literal91=null;
        MViewParser.commaSeparatedBodyDecls_return decls = null;


        Object id_tree=null;
        Object char_literal91_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:775:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:775:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls1919); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:775:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==29) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:775:19: ',' decls= commaSeparatedBodyDecls[$targetType]
                    {
                    char_literal91=(Token)match(input,29,FOLLOW_29_in_commaSeparatedBodyDecls1922); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal91_tree = (Object)adaptor.create(char_literal91);
                    adaptor.addChild(root_0, char_literal91_tree);
                    }
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1926);
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
            if ( state.backtracking>0 ) { memoize(input, 55, commaSeparatedBodyDecls_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:789:1: adviceType returns [Modifier value] : ( 'before' | 'after' | 'around' );
    public final MViewParser.adviceType_return adviceType() throws RecognitionException {
        MViewParser.adviceType_return retval = new MViewParser.adviceType_return();
        retval.start = input.LT(1);
        int adviceType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal92=null;
        Token string_literal93=null;
        Token string_literal94=null;

        Object string_literal92_tree=null;
        Object string_literal93_tree=null;
        Object string_literal94_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:790:2: ( 'before' | 'after' | 'around' )
            int alt45=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt45=1;
                }
                break;
            case 52:
                {
                alt45=2;
                }
                break;
            case 53:
                {
                alt45=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:790:4: 'before'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal92=(Token)match(input,51,FOLLOW_51_in_adviceType1955); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (Object)adaptor.create(string_literal92);
                    adaptor.addChild(root_0, string_literal92_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Before();
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:791:4: 'after'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal93=(Token)match(input,52,FOLLOW_52_in_adviceType1962); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal93_tree = (Object)adaptor.create(string_literal93);
                    adaptor.addChild(root_0, string_literal93_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new After();
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:792:4: 'around'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal94=(Token)match(input,53,FOLLOW_53_in_adviceType1969); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal94_tree = (Object)adaptor.create(string_literal94);
                    adaptor.addChild(root_0, string_literal94_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 56, adviceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:796:1: joinPointKind returns [Modifier value] : ( 'execution' | 'call' );
    public final MViewParser.joinPointKind_return joinPointKind() throws RecognitionException {
        MViewParser.joinPointKind_return retval = new MViewParser.joinPointKind_return();
        retval.start = input.LT(1);
        int joinPointKind_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal95=null;
        Token string_literal96=null;

        Object string_literal95_tree=null;
        Object string_literal96_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:797:2: ( 'execution' | 'call' )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==54) ) {
                alt46=1;
            }
            else if ( (LA46_0==55) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:797:4: 'execution'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal95=(Token)match(input,54,FOLLOW_54_in_joinPointKind1989); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal95_tree = (Object)adaptor.create(string_literal95);
                    adaptor.addChild(root_0, string_literal95_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Execution();
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:798:4: 'call'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal96=(Token)match(input,55,FOLLOW_55_in_joinPointKind1996); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal96_tree = (Object)adaptor.create(string_literal96);
                    adaptor.addChild(root_0, string_literal96_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 57, joinPointKind_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:802:1: overrideOrExtend returns [Modifier value] : (okw= 'override' | ekw= 'extend' );
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:803:2: (okw= 'override' | ekw= 'extend' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==56) ) {
                alt47=1;
            }
            else if ( (LA47_0==57) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:803:4: okw= 'override'
                    {
                    root_0 = (Object)adaptor.nil();

                    okw=(Token)match(input,56,FOLLOW_56_in_overrideOrExtend2018); if (state.failed) return retval;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:804:4: ekw= 'extend'
                    {
                    root_0 = (Object)adaptor.nil();

                    ekw=(Token)match(input,57,FOLLOW_57_in_overrideOrExtend2027); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 58, overrideOrExtend_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:808:1: negationModifier returns [Modifier value] : '!' ;
    public final MViewParser.negationModifier_return negationModifier() throws RecognitionException {
        MViewParser.negationModifier_return retval = new MViewParser.negationModifier_return();
        retval.start = input.LT(1);
        int negationModifier_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal97=null;

        Object char_literal97_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:809:2: ( '!' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:809:5: '!'
            {
            root_0 = (Object)adaptor.nil();

            char_literal97=(Token)match(input,58,FOLLOW_58_in_negationModifier2047); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal97_tree = (Object)adaptor.create(char_literal97);
            adaptor.addChild(root_0, char_literal97_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 59, negationModifier_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:812:1: abstractModifier returns [Modifier value] : akw= 'abstract' ;
    public final MViewParser.abstractModifier_return abstractModifier() throws RecognitionException {
        MViewParser.abstractModifier_return retval = new MViewParser.abstractModifier_return();
        retval.start = input.LT(1);
        int abstractModifier_StartIndex = input.index();
        Object root_0 = null;

        Token akw=null;

        Object akw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:813:2: (akw= 'abstract' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:813:4: akw= 'abstract'
            {
            root_0 = (Object)adaptor.nil();

            akw=(Token)match(input,59,FOLLOW_59_in_abstractModifier2067); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 60, abstractModifier_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:816:1: voidType returns [BasicTypeReference value] : 'void' ;
    public final MViewParser.voidType_return voidType() throws RecognitionException {
        MViewParser.voidType_return retval = new MViewParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal98=null;

        Object string_literal98_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:818:5: ( 'void' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:818:7: 'void'
            {
            root_0 = (Object)adaptor.nil();

            string_literal98=(Token)match(input,60,FOLLOW_60_in_voidType2090); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal98_tree = (Object)adaptor.create(string_literal98);
            adaptor.addChild(root_0, string_literal98_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 61, voidType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:827:1: type returns [BasicTypeReference value] : (cd= classOrInterfaceType | pt= primitiveType );
    public final MViewParser.type_return type() throws RecognitionException {
        MViewParser.type_return retval = new MViewParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.classOrInterfaceType_return cd = null;

        MViewParser.primitiveType_return pt = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:829:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Identifier) ) {
                alt48=1;
            }
            else if ( ((LA48_0>=61 && LA48_0<=68)) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:829:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceType_in_type2122);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:830:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveType_in_type2131);
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
            if ( state.backtracking>0 ) { memoize(input, 62, type_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:834:1: classOrInterfaceType returns [BasicTypeReference element] : name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* ;
    public final MViewParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MViewParser.classOrInterfaceType_return retval = new MViewParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal100=null;
        MViewParser.typeArguments_return typeArguments99 = null;

        MViewParser.typeArguments_return typeArguments101 = null;


        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal100_tree=null;

        NamespaceOrTypeReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:836:2: (name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:836:4: name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2156); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new MViewBasicTypeReference((name!=null?name.getText():null));
              	           target =  new NamespaceOrTypeReference((name!=null?name.getText():null));
              	           setLocation(retval.element,name,name); 
              	          
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:842:4: ( typeArguments )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==69) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2175);
                    typeArguments99=typeArguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments99.getTree());

                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:843:10: ( '.' namex= Identifier ( typeArguments )? )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==50) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:843:11: '.' namex= Identifier ( typeArguments )?
            	    {
            	    char_literal100=(Token)match(input,50,FOLLOW_50_in_classOrInterfaceType2189); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal100_tree = (Object)adaptor.create(char_literal100);
            	    adaptor.addChild(root_0, char_literal100_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2193); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    namex_tree = (Object)adaptor.create(namex);
            	    adaptor.addChild(root_0, namex_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      	           if(target != null) {
            	      	             retval.element = new MViewBasicTypeReference(target,(namex!=null?namex.getText():null));
            	      	             // We must clone the target here, or else it will be removed from the
            	      	             // type reference we just created.
            	      	             target = new NamespaceOrTypeReference(target.clone(),(namex!=null?namex.getText():null));
            	      	           } else {
            	      	             retval.element = new MViewBasicTypeReference(retval.element,(namex!=null?namex.getText():null));
            	      	           }
            	      	          
            	    }
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:854:11: ( typeArguments )?
            	    int alt50=2;
            	    int LA50_0 = input.LA(1);

            	    if ( (LA50_0==69) ) {
            	        alt50=1;
            	    }
            	    switch (alt50) {
            	        case 1 :
            	            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2219);
            	            typeArguments101=typeArguments();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments101.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
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
            if ( state.backtracking>0 ) { memoize(input, 63, classOrInterfaceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:858:1: primitiveType returns [BasicTypeReference value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MViewParser.primitiveType_return primitiveType() throws RecognitionException {
        MViewParser.primitiveType_return retval = new MViewParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal102=null;
        Token string_literal103=null;
        Token string_literal104=null;
        Token string_literal105=null;
        Token string_literal106=null;
        Token string_literal107=null;
        Token string_literal108=null;
        Token string_literal109=null;

        Object string_literal102_tree=null;
        Object string_literal103_tree=null;
        Object string_literal104_tree=null;
        Object string_literal105_tree=null;
        Object string_literal106_tree=null;
        Object string_literal107_tree=null;
        Object string_literal108_tree=null;
        Object string_literal109_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:859:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt52=8;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt52=1;
                }
                break;
            case 62:
                {
                alt52=2;
                }
                break;
            case 63:
                {
                alt52=3;
                }
                break;
            case 64:
                {
                alt52=4;
                }
                break;
            case 65:
                {
                alt52=5;
                }
                break;
            case 66:
                {
                alt52=6;
                }
                break;
            case 67:
                {
                alt52=7;
                }
                break;
            case 68:
                {
                alt52=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:859:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal102=(Token)match(input,61,FOLLOW_61_in_primitiveType2244); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal102_tree = (Object)adaptor.create(string_literal102);
                    adaptor.addChild(root_0, string_literal102_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:860:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal103=(Token)match(input,62,FOLLOW_62_in_primitiveType2256); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal103_tree = (Object)adaptor.create(string_literal103);
                    adaptor.addChild(root_0, string_literal103_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("char");
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:861:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal104=(Token)match(input,63,FOLLOW_63_in_primitiveType2268); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal104_tree = (Object)adaptor.create(string_literal104);
                    adaptor.addChild(root_0, string_literal104_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("byte");
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:862:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal105=(Token)match(input,64,FOLLOW_64_in_primitiveType2280); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal105_tree = (Object)adaptor.create(string_literal105);
                    adaptor.addChild(root_0, string_literal105_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("short");
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:863:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal106=(Token)match(input,65,FOLLOW_65_in_primitiveType2292); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal106_tree = (Object)adaptor.create(string_literal106);
                    adaptor.addChild(root_0, string_literal106_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("int");
                    }

                    }
                    break;
                case 6 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:864:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal107=(Token)match(input,66,FOLLOW_66_in_primitiveType2304); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal107_tree = (Object)adaptor.create(string_literal107);
                    adaptor.addChild(root_0, string_literal107_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("long");
                    }

                    }
                    break;
                case 7 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:865:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal108=(Token)match(input,67,FOLLOW_67_in_primitiveType2316); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal108_tree = (Object)adaptor.create(string_literal108);
                    adaptor.addChild(root_0, string_literal108_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("float");
                    }

                    }
                    break;
                case 8 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:866:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal109=(Token)match(input,68,FOLLOW_68_in_primitiveType2328); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal109_tree = (Object)adaptor.create(string_literal109);
                    adaptor.addChild(root_0, string_literal109_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 64, primitiveType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primitiveType"

    public static class typeArguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArguments"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:871:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final MViewParser.typeArguments_return typeArguments() throws RecognitionException {
        MViewParser.typeArguments_return retval = new MViewParser.typeArguments_return();
        retval.start = input.LT(1);
        int typeArguments_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal110=null;
        Token char_literal112=null;
        Token char_literal114=null;
        MViewParser.typeArgument_return typeArgument111 = null;

        MViewParser.typeArgument_return typeArgument113 = null;


        Object char_literal110_tree=null;
        Object char_literal112_tree=null;
        Object char_literal114_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:872:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:872:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal110=(Token)match(input,69,FOLLOW_69_in_typeArguments2351); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal110_tree = (Object)adaptor.create(char_literal110);
            adaptor.addChild(root_0, char_literal110_tree);
            }
            pushFollow(FOLLOW_typeArgument_in_typeArguments2353);
            typeArgument111=typeArgument();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument111.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:872:26: ( ',' typeArgument )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==29) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:872:28: ',' typeArgument
            	    {
            	    char_literal112=(Token)match(input,29,FOLLOW_29_in_typeArguments2357); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal112_tree = (Object)adaptor.create(char_literal112);
            	    adaptor.addChild(root_0, char_literal112_tree);
            	    }
            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2359);
            	    typeArgument113=typeArgument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument113.getTree());

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            char_literal114=(Token)match(input,70,FOLLOW_70_in_typeArguments2364); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal114_tree = (Object)adaptor.create(char_literal114);
            adaptor.addChild(root_0, char_literal114_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 65, typeArguments_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArguments"

    public static class typeArgument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArgument"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:875:1: typeArgument : (t= type | '?' ( ( 'extends' | 'super' ) t= type )? );
    public final MViewParser.typeArgument_return typeArgument() throws RecognitionException {
        MViewParser.typeArgument_return retval = new MViewParser.typeArgument_return();
        retval.start = input.LT(1);
        int typeArgument_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal115=null;
        Token set116=null;
        MViewParser.type_return t = null;


        Object char_literal115_tree=null;
        Object set116_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:876:5: (t= type | '?' ( ( 'extends' | 'super' ) t= type )? )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==Identifier||(LA55_0>=61 && LA55_0<=68)) ) {
                alt55=1;
            }
            else if ( (LA55_0==71) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:876:9: t= type
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_typeArgument2389);
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:876:20: '?' ( ( 'extends' | 'super' ) t= type )?
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal115=(Token)match(input,71,FOLLOW_71_in_typeArgument2395); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal115_tree = (Object)adaptor.create(char_literal115);
                    adaptor.addChild(root_0, char_literal115_tree);
                    }
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:876:25: ( ( 'extends' | 'super' ) t= type )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( ((LA54_0>=72 && LA54_0<=73)) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:876:27: ( 'extends' | 'super' ) t= type
                            {
                            set116=(Token)input.LT(1);
                            if ( (input.LA(1)>=72 && input.LA(1)<=73) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set116));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_type_in_typeArgument2410);
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
            if ( state.backtracking>0 ) { memoize(input, 66, typeArgument_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArgument"

    public static class annotations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotations"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:883:1: annotations : ( annotation )+ ;
    public final MViewParser.annotations_return annotations() throws RecognitionException {
        MViewParser.annotations_return retval = new MViewParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotation_return annotation117 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:884:5: ( ( annotation )+ )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:884:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:884:9: ( annotation )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==74) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations2440);
            	    annotation117=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation117.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
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
            if ( state.backtracking>0 ) { memoize(input, 67, annotations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotations"

    public static class annotation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotation"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:887:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MViewParser.annotation_return annotation() throws RecognitionException {
        MViewParser.annotation_return retval = new MViewParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal118=null;
        Token char_literal120=null;
        Token char_literal123=null;
        MViewParser.annotationName_return annotationName119 = null;

        MViewParser.elementValuePairs_return elementValuePairs121 = null;

        MViewParser.elementValue_return elementValue122 = null;


        Object char_literal118_tree=null;
        Object char_literal120_tree=null;
        Object char_literal123_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            char_literal118=(Token)match(input,74,FOLLOW_74_in_annotation2460); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal118_tree = (Object)adaptor.create(char_literal118);
            adaptor.addChild(root_0, char_literal118_tree);
            }
            pushFollow(FOLLOW_annotationName_in_annotation2462);
            annotationName119=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName119.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==27) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal120=(Token)match(input,27,FOLLOW_27_in_annotation2466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal120_tree = (Object)adaptor.create(char_literal120);
                    adaptor.addChild(root_0, char_literal120_tree);
                    }
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:34: ( elementValuePairs | elementValue )?
                    int alt57=3;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==Identifier) ) {
                        alt57=1;
                    }
                    else if ( (LA57_0==24||LA57_0==74) ) {
                        alt57=2;
                    }
                    switch (alt57) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation2470);
                            elementValuePairs121=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs121.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation2474);
                            elementValue122=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue122.getTree());

                            }
                            break;

                    }

                    char_literal123=(Token)match(input,28,FOLLOW_28_in_annotation2479); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal123_tree = (Object)adaptor.create(char_literal123);
                    adaptor.addChild(root_0, char_literal123_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 68, annotation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotation"

    public static class annotationName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationName"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:891:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MViewParser.annotationName_return annotationName() throws RecognitionException {
        MViewParser.annotationName_return retval = new MViewParser.annotationName_return();
        retval.start = input.LT(1);
        int annotationName_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier124=null;
        Token char_literal125=null;
        Token Identifier126=null;

        Object Identifier124_tree=null;
        Object char_literal125_tree=null;
        Object Identifier126_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:892:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:892:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            Identifier124=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2503); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier124_tree = (Object)adaptor.create(Identifier124);
            adaptor.addChild(root_0, Identifier124_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:892:18: ( '.' Identifier )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==50) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:892:19: '.' Identifier
            	    {
            	    char_literal125=(Token)match(input,50,FOLLOW_50_in_annotationName2506); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal125_tree = (Object)adaptor.create(char_literal125);
            	    adaptor.addChild(root_0, char_literal125_tree);
            	    }
            	    Identifier126=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2508); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier126_tree = (Object)adaptor.create(Identifier126);
            	    adaptor.addChild(root_0, Identifier126_tree);
            	    }

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
            if ( state.backtracking>0 ) { memoize(input, 69, annotationName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationName"

    public static class elementValuePairs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePairs"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:895:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MViewParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MViewParser.elementValuePairs_return retval = new MViewParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal128=null;
        MViewParser.elementValuePair_return elementValuePair127 = null;

        MViewParser.elementValuePair_return elementValuePair129 = null;


        Object char_literal128_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:896:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:896:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2529);
            elementValuePair127=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair127.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:896:26: ( ',' elementValuePair )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==29) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:896:27: ',' elementValuePair
            	    {
            	    char_literal128=(Token)match(input,29,FOLLOW_29_in_elementValuePairs2532); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal128_tree = (Object)adaptor.create(char_literal128);
            	    adaptor.addChild(root_0, char_literal128_tree);
            	    }
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2534);
            	    elementValuePair129=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair129.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 70, elementValuePairs_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePairs"

    public static class elementValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePair"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:899:1: elementValuePair : Identifier '=' elementValue ;
    public final MViewParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MViewParser.elementValuePair_return retval = new MViewParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier130=null;
        Token char_literal131=null;
        MViewParser.elementValue_return elementValue132 = null;


        Object Identifier130_tree=null;
        Object char_literal131_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:900:5: ( Identifier '=' elementValue )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:900:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();

            Identifier130=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair2555); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier130_tree = (Object)adaptor.create(Identifier130);
            adaptor.addChild(root_0, Identifier130_tree);
            }
            char_literal131=(Token)match(input,75,FOLLOW_75_in_elementValuePair2557); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal131_tree = (Object)adaptor.create(char_literal131);
            adaptor.addChild(root_0, char_literal131_tree);
            }
            pushFollow(FOLLOW_elementValue_in_elementValuePair2559);
            elementValue132=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue132.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 71, elementValuePair_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePair"

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValue"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:903:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MViewParser.elementValue_return elementValue() throws RecognitionException {
        MViewParser.elementValue_return retval = new MViewParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotation_return annotation133 = null;

        MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer134 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:5: ( annotation | elementValueArrayInitializer )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==74) ) {
                alt61=1;
            }
            else if ( (LA61_0==24) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotation_in_elementValue2582);
                    annotation133=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation133.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:905:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue2592);
                    elementValueArrayInitializer134=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer134.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 72, elementValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValue"

    public static class elementValueArrayInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValueArrayInitializer"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:908:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MViewParser.elementValueArrayInitializer_return retval = new MViewParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal135=null;
        Token char_literal137=null;
        Token char_literal139=null;
        Token char_literal140=null;
        MViewParser.elementValue_return elementValue136 = null;

        MViewParser.elementValue_return elementValue138 = null;


        Object char_literal135_tree=null;
        Object char_literal137_tree=null;
        Object char_literal139_tree=null;
        Object char_literal140_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:909:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:909:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal135=(Token)match(input,24,FOLLOW_24_in_elementValueArrayInitializer2615); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal135_tree = (Object)adaptor.create(char_literal135);
            adaptor.addChild(root_0, char_literal135_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:909:13: ( elementValue ( ',' elementValue )* )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==24||LA63_0==74) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:909:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2618);
                    elementValue136=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue136.getTree());
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:909:27: ( ',' elementValue )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==29) ) {
                            int LA62_1 = input.LA(2);

                            if ( (LA62_1==24||LA62_1==74) ) {
                                alt62=1;
                            }


                        }


                        switch (alt62) {
                    	case 1 :
                    	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:909:28: ',' elementValue
                    	    {
                    	    char_literal137=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2621); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal137_tree = (Object)adaptor.create(char_literal137);
                    	    adaptor.addChild(root_0, char_literal137_tree);
                    	    }
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2623);
                    	    elementValue138=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue138.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:909:49: ( ',' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==29) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:909:50: ','
                    {
                    char_literal139=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2630); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal139_tree = (Object)adaptor.create(char_literal139);
                    adaptor.addChild(root_0, char_literal139_tree);
                    }

                    }
                    break;

            }

            char_literal140=(Token)match(input,25,FOLLOW_25_in_elementValueArrayInitializer2634); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal140_tree = (Object)adaptor.create(char_literal140);
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
            if ( state.backtracking>0 ) { memoize(input, 73, elementValueArrayInitializer_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:912:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MViewParser.annotationTypeDeclaration_return retval = new MViewParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal141=null;
        Token string_literal142=null;
        MViewParser.annotationTypeBody_return annotationTypeBody143 = null;


        Object name_tree=null;
        Object char_literal141_tree=null;
        Object string_literal142_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:913:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:913:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();

            char_literal141=(Token)match(input,74,FOLLOW_74_in_annotationTypeDeclaration2661); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal141_tree = (Object)adaptor.create(char_literal141);
            adaptor.addChild(root_0, char_literal141_tree);
            }
            string_literal142=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration2663); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal142_tree = (Object)adaptor.create(string_literal142);
            adaptor.addChild(root_0, string_literal142_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration2667); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2669);
            annotationTypeBody143=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody143.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 74, annotationTypeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeDeclaration"

    public static class annotationTypeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeBody"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:916:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MViewParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MViewParser.annotationTypeBody_return retval = new MViewParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal144=null;
        Token char_literal146=null;
        MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration145 = null;


        Object char_literal144_tree=null;
        Object char_literal146_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:917:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:917:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal144=(Token)match(input,24,FOLLOW_24_in_annotationTypeBody2692); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal144_tree = (Object)adaptor.create(char_literal144);
            adaptor.addChild(root_0, char_literal144_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:917:13: ( annotationTypeElementDeclaration )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==Identifier||(LA65_0>=61 && LA65_0<=68)||LA65_0==74) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:917:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2695);
            	    annotationTypeElementDeclaration145=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration145.getTree());

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            char_literal146=(Token)match(input,25,FOLLOW_25_in_annotationTypeBody2699); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal146_tree = (Object)adaptor.create(char_literal146);
            adaptor.addChild(root_0, char_literal146_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 75, annotationTypeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeBody"

    public static class annotationTypeElementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:920:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MViewParser.annotationTypeElementDeclaration_return retval = new MViewParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotationTypeElementRest_return annotationTypeElementRest147 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:5: ( annotationTypeElementRest )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2724);
            annotationTypeElementRest147=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest147.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 76, annotationTypeElementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementDeclaration"

    public static class annotationTypeElementRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementRest"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:924:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MViewParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MViewParser.annotationTypeElementRest_return retval = new MViewParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal150=null;
        Token char_literal152=null;
        MViewParser.type_return type148 = null;

        MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest149 = null;

        MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration151 = null;


        Object char_literal150_tree=null;
        Object char_literal152_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:925:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==Identifier||(LA67_0>=61 && LA67_0<=68)) ) {
                alt67=1;
            }
            else if ( (LA67_0==74) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:925:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2747);
                    type148=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type148.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2749);
                    annotationMethodOrConstantRest149=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest149.getTree());
                    char_literal150=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2751); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal150_tree = (Object)adaptor.create(char_literal150);
                    adaptor.addChild(root_0, char_literal150_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:926:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2761);
                    annotationTypeDeclaration151=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration151.getTree());
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:926:35: ( ';' )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==26) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: ';'
                            {
                            char_literal152=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2763); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal152_tree = (Object)adaptor.create(char_literal152);
                            adaptor.addChild(root_0, char_literal152_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 77, annotationTypeElementRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementRest"

    public static class annotationMethodOrConstantRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodOrConstantRest"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:929:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MViewParser.annotationMethodOrConstantRest_return retval = new MViewParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotationMethodRest_return annotationMethodRest153 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:930:5: ( annotationMethodRest )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:930:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2787);
            annotationMethodRest153=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest153.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 78, annotationMethodOrConstantRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodOrConstantRest"

    public static class annotationMethodRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodRest"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:933:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MViewParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MViewParser.annotationMethodRest_return retval = new MViewParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier154=null;
        Token char_literal155=null;
        Token char_literal156=null;
        MViewParser.defaultValue_return defaultValue157 = null;


        Object Identifier154_tree=null;
        Object char_literal155_tree=null;
        Object char_literal156_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:934:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:934:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier154=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2810); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier154_tree = (Object)adaptor.create(Identifier154);
            adaptor.addChild(root_0, Identifier154_tree);
            }
            char_literal155=(Token)match(input,27,FOLLOW_27_in_annotationMethodRest2812); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal155_tree = (Object)adaptor.create(char_literal155);
            adaptor.addChild(root_0, char_literal155_tree);
            }
            char_literal156=(Token)match(input,28,FOLLOW_28_in_annotationMethodRest2814); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal156_tree = (Object)adaptor.create(char_literal156);
            adaptor.addChild(root_0, char_literal156_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:934:28: ( defaultValue )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==76) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest2816);
                    defaultValue157=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue157.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 79, annotationMethodRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodRest"

    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultValue"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:937:1: defaultValue : 'default' elementValue ;
    public final MViewParser.defaultValue_return defaultValue() throws RecognitionException {
        MViewParser.defaultValue_return retval = new MViewParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal158=null;
        MViewParser.elementValue_return elementValue159 = null;


        Object string_literal158_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:938:5: ( 'default' elementValue )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:938:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();

            string_literal158=(Token)match(input,76,FOLLOW_76_in_defaultValue2844); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal158_tree = (Object)adaptor.create(string_literal158);
            adaptor.addChild(root_0, string_literal158_tree);
            }
            pushFollow(FOLLOW_elementValue_in_defaultValue2846);
            elementValue159=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue159.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 80, defaultValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit88 = new BitSet(new long[]{0x0801018080800002L});
    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit101 = new BitSet(new long[]{0x0801018080800002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_compilationUnit114 = new BitSet(new long[]{0x0801018080800002L});
    public static final BitSet FOLLOW_applicationDeclaration_in_compilationUnit127 = new BitSet(new long[]{0x0801018080800002L});
    public static final BitSet FOLLOW_deploymentDeclaration_in_compilationUnit140 = new BitSet(new long[]{0x0801018080800002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration170 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration174 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_interfaceBody194 = new BitSet(new long[]{0xF000000002000010L,0x000000000000001FL});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody196 = new BitSet(new long[]{0xF000000002000010L,0x000000000000001FL});
    public static final BitSet FOLLOW_25_in_interfaceBody200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration216 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceBodyDeclaration218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_serviceReferenceDeclaration243 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_actualParameters_in_serviceReferenceDeclaration247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_actualParameters276 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameters281 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_actualParameters287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_actualParameterDecls312 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_actualParameterDecls315 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameterDecls319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceHeaderDeclaration372 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_serviceHeaderDeclaration376 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceHeaderDeclaration380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_formalParameters452 = new BitSet(new long[]{0xF000000010000010L,0x000000000000001FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters457 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_formalParameters463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls489 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls493 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_formalParameterDecls496 = new BitSet(new long[]{0xF000000000000010L,0x000000000000001FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl535 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl543 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_pointcutServiceSignatureParameters574 = new BitSet(new long[]{0x0000000050000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters577 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_pointcutServiceSignatureParameters583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureParameterDecls598 = new BitSet(new long[]{0x0000000020000012L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls607 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutServiceSignatureParameterDecls612 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_connectorDeclaration645 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_connectorDeclaration651 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration655 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_connectorDeclaration663 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorBody684 = new BitSet(new long[]{0x0800400102000000L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody686 = new BitSet(new long[]{0x0800400102000000L});
    public static final BitSet FOLLOW_25_in_connectorBody690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_connectorAOCompositionDeclaration734 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_connectorAOCompositionDeclaration740 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorAOCompositionDeclaration744 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_refinementDeclarationSingle_in_connectorAOCompositionDeclaration752 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorAOCompositionBody773 = new BitSet(new long[]{0x0000080202000000L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody780 = new BitSet(new long[]{0x0000080002000000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_connectorAOCompositionBody789 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_connectorAOCompositionBody796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pointcutDeclaration813 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutBody833 = new BitSet(new long[]{0x0300007402000000L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody835 = new BitSet(new long[]{0x0300007402000000L});
    public static final BitSet FOLLOW_25_in_pointcutBody839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_pointcutKindDeclaration882 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutKindDeclaration884 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_joinPointKind_in_pointcutKindDeclaration888 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutKindDeclaration890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration909 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_pointcutSignatureDeclaration915 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutSignatureDeclaration917 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration921 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutSignatureDeclaration925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls961 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutSignatureBodyDecls965 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_pointcutActorDeclaration989 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_pointcutActorDeclaration1004 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutActorBody1036 = new BitSet(new long[]{0x0300078002800000L});
    public static final BitSet FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1038 = new BitSet(new long[]{0x0300078002800000L});
    public static final BitSet FOLLOW_25_in_pointcutActorBody1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1063 = new BitSet(new long[]{0x0000078000800000L});
    public static final BitSet FOLLOW_23_in_pointcutActorBodyDecls1072 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1074 = new BitSet(new long[]{0x0400000000000010L});
    public static final BitSet FOLLOW_39_in_pointcutActorBodyDecls1084 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1086 = new BitSet(new long[]{0x0400000000000010L});
    public static final BitSet FOLLOW_40_in_pointcutActorBodyDecls1095 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1097 = new BitSet(new long[]{0x0400000000000010L});
    public static final BitSet FOLLOW_41_in_pointcutActorBodyDecls1106 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1108 = new BitSet(new long[]{0x0400000000000010L});
    public static final BitSet FOLLOW_42_in_pointcutActorBodyDecls1117 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1119 = new BitSet(new long[]{0x0400000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1128 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutActorBodyDecls1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negationModifier_in_pointcutActorPropDecls1148 = new BitSet(new long[]{0x0400000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1154 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutActorPropDecls1159 = new BitSet(new long[]{0x0400000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutActorPropDecl1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_adviceDeclaration1209 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_adviceBody1228 = new BitSet(new long[]{0x0000300002000000L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody1230 = new BitSet(new long[]{0x0000300002000000L});
    public static final BitSet FOLLOW_25_in_adviceBody1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_adviceServiceDeclaration1273 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceServiceDeclaration1275 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1279 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceServiceDeclaration1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_adviceTypeDeclaration1300 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceTypeDeclaration1302 = new BitSet(new long[]{0x0038000000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration1306 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceTypeDeclaration1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_componentDeclaration1335 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration1339 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_componentBody1365 = new BitSet(new long[]{0x0800C00102000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody1367 = new BitSet(new long[]{0x0800C00102000000L});
    public static final BitSet FOLLOW_25_in_componentBody1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_moduleDependencyBody1423 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1428 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_moduleDependencyBody1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_moduleRequireDependencyDeclaration1453 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_moduleProvideDependencyDeclaration1472 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_applicationDeclaration1509 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_applicationDeclaration1515 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_applicationDeclaration1519 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_applicationDeclaration1527 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_applicationBody_in_applicationDeclaration1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_applicationBody1548 = new BitSet(new long[]{0x0800048082000010L});
    public static final BitSet FOLLOW_applicationBodyDeclaration_in_applicationBody1552 = new BitSet(new long[]{0x0800048082000010L});
    public static final BitSet FOLLOW_25_in_applicationBody1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hostDeclaration_in_applicationBodyDeclaration1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_deploymentDeclaration1623 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_deploymentDeclaration1629 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_deploymentDeclaration1633 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_deploymentDeclaration1641 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_applicationBody_in_deploymentDeclaration1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1671 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1675 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_instanceDeclaration1679 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1683 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_instanceDeclaration1685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_hostDeclaration1712 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_hostDeclaration1716 = new BitSet(new long[]{0x0002000004000000L});
    public static final BitSet FOLLOW_49_in_hostDeclaration1724 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_StringLiteral_in_hostDeclaration1728 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_hostDeclaration1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_componentDeclaration_in_moduleContainerDeclarations1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_refinementDeclarationSingle1797 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1816 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_refinementDeclaration1821 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclaration1823 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_refinementParentDeclaration_in_refinementDeclarationBody1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_refinementParentDeclaration1874 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_refinementParentDeclaration1881 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_refinementParentDeclaration1885 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls1919 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_commaSeparatedBodyDecls1922 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_adviceType1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_adviceType1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_adviceType1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_joinPointKind1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_joinPointKind1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_overrideOrExtend2018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_overrideOrExtend2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_negationModifier2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_abstractModifier2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_voidType2090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2156 = new BitSet(new long[]{0x0004000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2175 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_classOrInterfaceType2189 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2193 = new BitSet(new long[]{0x0004000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2219 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_61_in_primitiveType2244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_primitiveType2268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_primitiveType2280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_primitiveType2292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_primitiveType2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_primitiveType2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_primitiveType2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_typeArguments2351 = new BitSet(new long[]{0xF000000000000010L,0x000000000000009FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2353 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_29_in_typeArguments2357 = new BitSet(new long[]{0xF000000000000010L,0x000000000000009FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2359 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_typeArguments2364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_typeArgument2395 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_set_in_typeArgument2400 = new BitSet(new long[]{0xF000000000000010L,0x000000000000001FL});
    public static final BitSet FOLLOW_type_in_typeArgument2410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations2440 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_annotation2460 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation2462 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_annotation2466 = new BitSet(new long[]{0x0000000011000010L,0x0000000000000400L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation2470 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation2474 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotation2479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2503 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_annotationName2506 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2508 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2529 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_elementValuePairs2532 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2534 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair2555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_elementValuePair2557 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair2559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue2582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_elementValueArrayInitializer2615 = new BitSet(new long[]{0x0000000023000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2618 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2621 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2623 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2630 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elementValueArrayInitializer2634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_annotationTypeDeclaration2661 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration2663 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration2667 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeBody2692 = new BitSet(new long[]{0xF000000002000010L,0x000000000000041FL});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2695 = new BitSet(new long[]{0xF000000002000010L,0x000000000000041FL});
    public static final BitSet FOLLOW_25_in_annotationTypeBody2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2747 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2749 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2761 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2810 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_annotationMethodRest2812 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotationMethodRest2814 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_defaultValue2844 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2846 = new BitSet(new long[]{0x0000000000000002L});

}
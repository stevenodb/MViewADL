// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g 2010-12-15 12:55:31

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class MViewParser extends ChameleonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "StringLiteral", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "'{'", "'}'", "';'", "'('", "')'", "','", "'connector'", "'ao-composition'", "'pointcut'", "'kind'", "':'", "'signature'", "'caller'", "'callee'", "'component'", "'application'", "'instance'", "'host'", "'advice'", "'service'", "'type'", "'require'", "'provide'", "'deployment'", "'on'", "'before'", "'after'", "'around'", "'execution'", "'call'", "'override'", "'extend'", "'!'", "'void'", "'*'", "'.'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'<'", "'>'", "'?'", "'extends'", "'super'", "'@'", "'='", "'default'"
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
            this.state.ruleMemo = new HashMap[155+1];
             
             
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:97:1: compilationUnit returns [CompilationUnit element] : (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )* ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:103:2: ( (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:103:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:103:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )*
            loop1:
            do {
                int alt1=6;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    alt1=1;
                    }
                    break;
                case 38:
                    {
                    alt1=2;
                    }
                    break;
                case 30:
                    {
                    alt1=3;
                    }
                    break;
                case 39:
                    {
                    alt1=4;
                    }
                    break;
                case 47:
                    {
                    alt1=5;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:104:4: ifd= interfaceDeclaration
            	    {
            	    pushFollow(FOLLOW_interfaceDeclaration_in_compilationUnit89);
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
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:106:4: cod= componentDeclaration
            	    {
            	    pushFollow(FOLLOW_componentDeclaration_in_compilationUnit102);
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
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:110:4: cnd= connectorDeclaration
            	    {
            	    pushFollow(FOLLOW_connectorDeclaration_in_compilationUnit117);
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
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:112:4: apd= applicationDeclaration
            	    {
            	    pushFollow(FOLLOW_applicationDeclaration_in_compilationUnit130);
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
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:114:4: dpd= deploymentDeclaration
            	    {
            	    pushFollow(FOLLOW_deploymentDeclaration_in_compilationUnit143);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:125:1: interfaceDeclaration returns [Interface element] : intkw= 'interface' name= Identifier interfaceBody[$element] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:126:2: (intkw= 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:126:4: intkw= 'interface' name= Identifier interfaceBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            intkw=(Token)match(input,23,FOLLOW_23_in_interfaceDeclaration173); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            intkw_tree = (Object)adaptor.create(intkw);
            adaptor.addChild(root_0, intkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration177); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Interface(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,intkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration183);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:135:1: interfaceBody[Interface element] : '{' ( interfaceBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:136:2: ( '{' ( interfaceBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:136:4: '{' ( interfaceBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal2=(Token)match(input,24,FOLLOW_24_in_interfaceBody197); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:136:8: ( interfaceBodyDeclaration[$element] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||LA2_0==57||(LA2_0>=60 && LA2_0<=67)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: interfaceBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody199);
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

            char_literal4=(Token)match(input,25,FOLLOW_25_in_interfaceBody203); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:140:1: interfaceBodyDeclaration[Interface element] : (service= serviceDeclaration ';' ) ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:141:2: ( (service= serviceDeclaration ';' ) )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:141:4: (service= serviceDeclaration ';' )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:141:4: (service= serviceDeclaration ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:141:5: service= serviceDeclaration ';'
            {
            pushFollow(FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration219);
            service=serviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal5=(Token)match(input,26,FOLLOW_26_in_interfaceBodyDeclaration221); if (state.failed) return retval;
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

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceReferenceDeclaration247); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_actualParameters_in_serviceReferenceDeclaration251);
            params=actualParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, params.getTree());
            if ( state.backtracking==0 ) {

              			String signature = (name!=null?name.getText():null);
              			retval.relation = new SimpleReference<Service>(signature, Service.class);
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

            char_literal6=(Token)match(input,27,FOLLOW_27_in_actualParameters278); if (state.failed) return retval;
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
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameters283);
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

            char_literal7=(Token)match(input,28,FOLLOW_28_in_actualParameters289); if (state.failed) return retval;
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

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_actualParameterDecls314); if (state.failed) return retval;
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
                    char_literal8=(Token)match(input,29,FOLLOW_29_in_actualParameterDecls317); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (Object)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);
                    }
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameterDecls321);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:183:1: serviceDeclaration returns [Service element] : result= serviceHeaderDeclaration ;
    public final MViewParser.serviceDeclaration_return serviceDeclaration() throws RecognitionException {
        MViewParser.serviceDeclaration_return retval = new MViewParser.serviceDeclaration_return();
        retval.start = input.LT(1);
        int serviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.serviceHeaderDeclaration_return result = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:184:2: (result= serviceHeaderDeclaration )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:184:4: result= serviceHeaderDeclaration
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration354);
            result=serviceHeaderDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, result.getTree());
            if ( state.backtracking==0 ) {

              			Signature signature = new SimpleNameSignature((result!=null?result.signature:null));
              			retval.element = new Service(signature,(result!=null?result.returnType:null),(result!=null?result.parLst:null)); //TODO: add properties
              		
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
        public String signature;
        public TypeReference returnType;
        public List<FormalParameter> parLst;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "serviceHeaderDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:191:1: serviceHeaderDeclaration returns [String signature, TypeReference returnType, List<FormalParameter> parLst] : rtype= serviceReturnType name= Identifier params= formalParameters ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:192:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:192:4: rtype= serviceReturnType name= Identifier params= formalParameters
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceReturnType_in_serviceHeaderDeclaration374);
            rtype=serviceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceHeaderDeclaration378); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_formalParameters_in_serviceHeaderDeclaration382);
            params=formalParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, params.getTree());
            if ( state.backtracking==0 ) {

              			retval.signature = (name!=null?name.getText():null);
              			retval.returnType = (rtype!=null?rtype.value:null);
              			retval.parLst = (params!=null?params.lst:null);
              		
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
        public TypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "serviceReturnType"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:199:1: serviceReturnType returns [TypeReference value] : (vt= voidType | tp= type ) ;
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

            if ( (LA5_0==57) ) {
                alt5=1;
            }
            else if ( (LA5_0==Identifier||(LA5_0>=60 && LA5_0<=67)) ) {
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
                    pushFollow(FOLLOW_voidType_in_serviceReturnType407);
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
                    pushFollow(FOLLOW_type_in_serviceReturnType421);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:207:1: formalParameters returns [List<FormalParameter> lst] : '(' (pars= formalParameterDecls )? ')' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:209:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:209:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal9=(Token)match(input,27,FOLLOW_27_in_formalParameters452); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal9_tree = (Object)adaptor.create(char_literal9);
            adaptor.addChild(root_0, char_literal9_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:209:13: (pars= formalParameterDecls )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Identifier||(LA6_0>=60 && LA6_0<=67)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:209:14: pars= formalParameterDecls
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:212:1: formalParameterDecls returns [List<FormalParameter> lst] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:213:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:213:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_type_in_formalParameterDecls488);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls492); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:213:32: ( ',' decls= formalParameterDecls )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==29) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:213:33: ',' decls= formalParameterDecls
                    {
                    char_literal11=(Token)match(input,29,FOLLOW_29_in_formalParameterDecls495); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal11_tree = (Object)adaptor.create(char_literal11);
                    adaptor.addChild(root_0, char_literal11_tree);
                    }
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls499);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:234:1: pointcutServiceSignatureDecl returns [ServiceSignature element] : rtype= Identifier sig= Identifier pars= pointcutServiceSignatureParameters ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:235:2: (rtype= Identifier sig= Identifier pars= pointcutServiceSignatureParameters )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:235:4: rtype= Identifier sig= Identifier pars= pointcutServiceSignatureParameters
            {
            root_0 = (Object)adaptor.nil();

            rtype=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureDecl533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rtype_tree = (Object)adaptor.create(rtype);
            adaptor.addChild(root_0, rtype_tree);
            }
            sig=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureDecl537); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            sig_tree = (Object)adaptor.create(sig);
            adaptor.addChild(root_0, sig_tree);
            }
            pushFollow(FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl541);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:240:1: pointcutServiceSignatureParameters returns [List<Pair<String,String>> lst] : '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:242:2: ( '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:242:4: '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal12=(Token)match(input,27,FOLLOW_27_in_pointcutServiceSignatureParameters562); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:242:8: ( pointcutServiceSignatureParameterDecls[$lst] )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Identifier) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:242:9: pointcutServiceSignatureParameterDecls[$lst]
                    {
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters565);
                    pointcutServiceSignatureParameterDecls13=pointcutServiceSignatureParameterDecls(retval.lst);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutServiceSignatureParameterDecls13.getTree());

                    }
                    break;

            }

            char_literal14=(Token)match(input,28,FOLLOW_28_in_pointcutServiceSignatureParameters571); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:245:1: pointcutServiceSignatureParameterDecls[List<Pair<String,String>> lst] : t= Identifier name= Identifier ( ',' pointcutServiceSignatureParameterDecls[$lst] )? ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:246:2: (t= Identifier name= Identifier ( ',' pointcutServiceSignatureParameterDecls[$lst] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:246:4: t= Identifier name= Identifier ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls585); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (Object)adaptor.create(t);
            adaptor.addChild(root_0, t_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls589); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:246:33: ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==29) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:246:34: ',' pointcutServiceSignatureParameterDecls[$lst]
                    {
                    char_literal15=(Token)match(input,29,FOLLOW_29_in_pointcutServiceSignatureParameterDecls592); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    adaptor.addChild(root_0, char_literal15_tree);
                    }
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls594);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:305:1: connectorDeclaration returns [Connector element] : conkw= 'connector' name= Identifier refinementDeclaration[$element,Connector.class] connectorBody[$element] ;
    public final MViewParser.connectorDeclaration_return connectorDeclaration() throws RecognitionException {
        MViewParser.connectorDeclaration_return retval = new MViewParser.connectorDeclaration_return();
        retval.start = input.LT(1);
        int connectorDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token conkw=null;
        Token name=null;
        MViewParser.refinementDeclaration_return refinementDeclaration17 = null;

        MViewParser.connectorBody_return connectorBody18 = null;


        Object conkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:306:2: (conkw= 'connector' name= Identifier refinementDeclaration[$element,Connector.class] connectorBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:306:4: conkw= 'connector' name= Identifier refinementDeclaration[$element,Connector.class] connectorBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            conkw=(Token)match(input,30,FOLLOW_30_in_connectorDeclaration674); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            conkw_tree = (Object)adaptor.create(conkw);
            adaptor.addChild(root_0, conkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration678); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Connector(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,conkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_refinementDeclaration_in_connectorDeclaration685);
            refinementDeclaration17=refinementDeclaration(retval.element, Connector.class);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration17.getTree());
            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration690);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:316:1: connectorBody[Connector element] : '{' ( connectorBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:317:2: ( '{' ( connectorBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:317:4: '{' ( connectorBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal19=(Token)match(input,24,FOLLOW_24_in_connectorBody704); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:317:8: ( connectorBodyDeclaration[$element] )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==31||LA10_0==45) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: connectorBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_connectorBodyDeclaration_in_connectorBody706);
            	    connectorBodyDeclaration20=connectorBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorBodyDeclaration20.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            char_literal21=(Token)match(input,25,FOLLOW_25_in_connectorBody710); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:321:1: connectorBodyDeclaration[Connector element] : (aoc= connectorAOCompositionDeclaration | moduleRequireDependencyDeclaration[$element] );
    public final MViewParser.connectorBodyDeclaration_return connectorBodyDeclaration(Connector element) throws RecognitionException {
        MViewParser.connectorBodyDeclaration_return retval = new MViewParser.connectorBodyDeclaration_return();
        retval.start = input.LT(1);
        int connectorBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.connectorAOCompositionDeclaration_return aoc = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration22 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:322:2: (aoc= connectorAOCompositionDeclaration | moduleRequireDependencyDeclaration[$element] )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==31) ) {
                alt11=1;
            }
            else if ( (LA11_0==45) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:322:4: aoc= connectorAOCompositionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration725);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:325:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration732);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:329:1: connectorAOCompositionDeclaration returns [AOComposition element] : kw= 'ao-composition' name= Identifier refinementDeclaration[$element,AOComposition.class] connectorAOCompositionBody[$element] ;
    public final MViewParser.connectorAOCompositionDeclaration_return connectorAOCompositionDeclaration() throws RecognitionException {
        MViewParser.connectorAOCompositionDeclaration_return retval = new MViewParser.connectorAOCompositionDeclaration_return();
        retval.start = input.LT(1);
        int connectorAOCompositionDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token kw=null;
        Token name=null;
        MViewParser.refinementDeclaration_return refinementDeclaration23 = null;

        MViewParser.connectorAOCompositionBody_return connectorAOCompositionBody24 = null;


        Object kw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:330:2: (kw= 'ao-composition' name= Identifier refinementDeclaration[$element,AOComposition.class] connectorAOCompositionBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:330:4: kw= 'ao-composition' name= Identifier refinementDeclaration[$element,AOComposition.class] connectorAOCompositionBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            kw=(Token)match(input,31,FOLLOW_31_in_connectorAOCompositionDeclaration753); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kw_tree = (Object)adaptor.create(kw);
            adaptor.addChild(root_0, kw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorAOCompositionDeclaration757); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new AOComposition(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,kw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_refinementDeclaration_in_connectorAOCompositionDeclaration764);
            refinementDeclaration23=refinementDeclaration(retval.element, AOComposition.class);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration23.getTree());
            pushFollow(FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration770);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:340:1: connectorAOCompositionBody[AOComposition element] : '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:341:2: ( '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:341:4: '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal25=(Token)match(input,24,FOLLOW_24_in_connectorAOCompositionBody784); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:342:5: (pc= pointcutDeclaration )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==32) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: pc= pointcutDeclaration
                    {
                    pushFollow(FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody791);
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:345:6: (adv= adviceDeclaration )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==42) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: adv= adviceDeclaration
                    {
                    pushFollow(FOLLOW_adviceDeclaration_in_connectorAOCompositionBody800);
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
            char_literal26=(Token)match(input,25,FOLLOW_25_in_connectorAOCompositionBody807); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:351:1: pointcutDeclaration returns [Pointcut pointcut] : pckw= 'pointcut' pointcutBody[$pointcut] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:352:2: (pckw= 'pointcut' pointcutBody[$pointcut] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:352:4: pckw= 'pointcut' pointcutBody[$pointcut]
            {
            root_0 = (Object)adaptor.nil();

            pckw=(Token)match(input,32,FOLLOW_32_in_pointcutDeclaration824); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            pckw_tree = (Object)adaptor.create(pckw);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:359:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:360:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:360:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal28=(Token)match(input,24,FOLLOW_24_in_pointcutBody844); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:360:8: ( pointcutBodyDeclaration[$pointcut] )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==33||(LA14_0>=35 && LA14_0<=37)||(LA14_0>=54 && LA14_0<=55)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: pointcutBodyDeclaration[$pointcut]
            	    {
            	    pushFollow(FOLLOW_pointcutBodyDeclaration_in_pointcutBody846);
            	    pointcutBodyDeclaration29=pointcutBodyDeclaration(pointcut);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBodyDeclaration29.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            char_literal30=(Token)match(input,25,FOLLOW_25_in_pointcutBody850); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:364:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] );
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:365:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt15=1;
                }
                break;
            case 35:
            case 54:
            case 55:
                {
                alt15=2;
                }
                break;
            case 36:
            case 37:
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:365:4: pointcutKindDeclaration[$pointcut]
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:366:4: pointcutSignatureDeclaration[$pointcut]
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:367:4: pointcutActorDeclaration[$pointcut]
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:371:1: pointcutKindDeclaration[Pointcut pointcut] : kikw= 'kind' ':' kind= joinPointKind ';' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:372:2: (kikw= 'kind' ':' kind= joinPointKind ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:372:4: kikw= 'kind' ':' kind= joinPointKind ';'
            {
            root_0 = (Object)adaptor.nil();

            kikw=(Token)match(input,33,FOLLOW_33_in_pointcutKindDeclaration893); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kikw_tree = (Object)adaptor.create(kikw);
            adaptor.addChild(root_0, kikw_tree);
            }
            char_literal34=(Token)match(input,34,FOLLOW_34_in_pointcutKindDeclaration895); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal34_tree = (Object)adaptor.create(char_literal34);
            adaptor.addChild(root_0, char_literal34_tree);
            }
            pushFollow(FOLLOW_joinPointKind_in_pointcutKindDeclaration899);
            kind=joinPointKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, kind.getTree());
            char_literal35=(Token)match(input,26,FOLLOW_26_in_pointcutKindDeclaration901); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:379:1: pointcutSignatureDeclaration[Pointcut element] : (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:380:2: ( (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:380:4: (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:380:4: (override= overrideOrExtend )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=54 && LA16_0<=55)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:380:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration920);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

            sikw=(Token)match(input,35,FOLLOW_35_in_pointcutSignatureDeclaration926); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            sikw_tree = (Object)adaptor.create(sikw);
            adaptor.addChild(root_0, sikw_tree);
            }
            char_literal36=(Token)match(input,34,FOLLOW_34_in_pointcutSignatureDeclaration928); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal36_tree = (Object)adaptor.create(char_literal36);
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
            char_literal37=(Token)match(input,26,FOLLOW_26_in_pointcutSignatureDeclaration936); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:391:1: pointcutSignatureBody returns [PointcutSignature element] : pointcutSignatureBodyDecls[$element] ;
    public final MViewParser.pointcutSignatureBody_return pointcutSignatureBody() throws RecognitionException {
        MViewParser.pointcutSignatureBody_return retval = new MViewParser.pointcutSignatureBody_return();
        retval.start = input.LT(1);
        int pointcutSignatureBody_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls38 = null;



         retval.element = new PointcutSignature(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:393:2: ( pointcutSignatureBodyDecls[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:393:4: pointcutSignatureBodyDecls[$element]
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:397:1: pointcutSignatureBodyDecls[PointcutSignature element] : pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:398:2: (pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:398:4: pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls972);
            pss=pointcutServiceSignatureDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pss.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:398:37: ( ',' pointcutSignatureBodyDecls[$element] )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:398:39: ',' pointcutSignatureBodyDecls[$element]
                    {
                    char_literal39=(Token)match(input,29,FOLLOW_29_in_pointcutSignatureBodyDecls976); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal39_tree = (Object)adaptor.create(char_literal39);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:404:1: pointcutActorDeclaration[Pointcut pointcut] : (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody );
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:405:2: (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            else if ( (LA18_0==37) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:405:4: clkw= 'caller' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();

                    clkw=(Token)match(input,36,FOLLOW_36_in_pointcutActorDeclaration1000); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    clkw_tree = (Object)adaptor.create(clkw);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:410:3: clkw= 'callee' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();

                    clkw=(Token)match(input,37,FOLLOW_37_in_pointcutActorDeclaration1015); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    clkw_tree = (Object)adaptor.create(clkw);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:420:1: pointcutActorBody returns [Actor element] : '{' ( pointcutActorBodyDecls[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:424:2: ( '{' ( pointcutActorBodyDecls[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:424:4: '{' ( pointcutActorBodyDecls[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal41=(Token)match(input,24,FOLLOW_24_in_pointcutActorBody1046); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = (Object)adaptor.create(char_literal41);
            adaptor.addChild(root_0, char_literal41_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:424:8: ( pointcutActorBodyDecls[$element] )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==23||(LA19_0>=38 && LA19_0<=41)||(LA19_0>=54 && LA19_0<=55)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: pointcutActorBodyDecls[$element]
            	    {
            	    pushFollow(FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1048);
            	    pointcutActorBodyDecls42=pointcutActorBodyDecls(retval.element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorBodyDecls42.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            char_literal43=(Token)match(input,25,FOLLOW_25_in_pointcutActorBody1052); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:428:1: pointcutActorBodyDecls[Actor actor] : (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' ;
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
        	Class<? extends MViewDeclaration> declClass = null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:433:2: ( (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:433:4: (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:433:4: (override= overrideOrExtend )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=54 && LA20_0<=55)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:433:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1073);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:434:2: ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' )
            int alt21=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt21=1;
                }
                break;
            case 38:
                {
                alt21=2;
                }
                break;
            case 39:
                {
                alt21=3;
                }
                break;
            case 40:
                {
                alt21=4;
                }
                break;
            case 41:
                {
                alt21=5;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:435:3: 'interface' ':'
                    {
                    string_literal44=(Token)match(input,23,FOLLOW_23_in_pointcutActorBodyDecls1082); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal44_tree = (Object)adaptor.create(string_literal44);
                    adaptor.addChild(root_0, string_literal44_tree);
                    }
                    char_literal45=(Token)match(input,34,FOLLOW_34_in_pointcutActorBodyDecls1084); if (state.failed) return retval;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:439:3: 'component' ':'
                    {
                    string_literal46=(Token)match(input,38,FOLLOW_38_in_pointcutActorBodyDecls1094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal46_tree = (Object)adaptor.create(string_literal46);
                    adaptor.addChild(root_0, string_literal46_tree);
                    }
                    char_literal47=(Token)match(input,34,FOLLOW_34_in_pointcutActorBodyDecls1096); if (state.failed) return retval;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:443:3: 'application' ':'
                    {
                    string_literal48=(Token)match(input,39,FOLLOW_39_in_pointcutActorBodyDecls1105); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal48_tree = (Object)adaptor.create(string_literal48);
                    adaptor.addChild(root_0, string_literal48_tree);
                    }
                    char_literal49=(Token)match(input,34,FOLLOW_34_in_pointcutActorBodyDecls1107); if (state.failed) return retval;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:447:3: 'instance' ':'
                    {
                    string_literal50=(Token)match(input,40,FOLLOW_40_in_pointcutActorBodyDecls1116); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal50_tree = (Object)adaptor.create(string_literal50);
                    adaptor.addChild(root_0, string_literal50_tree);
                    }
                    char_literal51=(Token)match(input,34,FOLLOW_34_in_pointcutActorBodyDecls1118); if (state.failed) return retval;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:451:3: 'host' ':'
                    {
                    string_literal52=(Token)match(input,41,FOLLOW_41_in_pointcutActorBodyDecls1127); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal52_tree = (Object)adaptor.create(string_literal52);
                    adaptor.addChild(root_0, string_literal52_tree);
                    }
                    char_literal53=(Token)match(input,34,FOLLOW_34_in_pointcutActorBodyDecls1129); if (state.failed) return retval;
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
            pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1139);
            pointcutActorPropDecls54=pointcutActorPropDecls(prop, declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls54.getTree());
            char_literal55=(Token)match(input,26,FOLLOW_26_in_pointcutActorBodyDecls1142); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:464:1: pointcutActorPropDecls[ActorProp prop,Class<? extends Declaration> declClass] : (negate= negation )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? ;
    public final MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls(ActorProp prop, Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecls_return retval = new MViewParser.pointcutActorPropDecls_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecls_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal56=null;
        MViewParser.negation_return negate = null;

        MViewParser.pointcutActorPropDecl_return apdref = null;

        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls57 = null;


        Object char_literal56_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:465:2: ( (negate= negation )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:465:5: (negate= negation )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:465:5: (negate= negation )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==56) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:465:6: negate= negation
                    {
                    pushFollow(FOLLOW_negation_in_pointcutActorPropDecls1159);
                    negate=negation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, negate.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1165);
            apdref=pointcutActorPropDecl(declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, apdref.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:465:65: ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:465:67: ',' pointcutActorPropDecls[$prop,$declClass]
                    {
                    char_literal56=(Token)match(input,29,FOLLOW_29_in_pointcutActorPropDecls1170); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal56_tree = (Object)adaptor.create(char_literal56);
                    adaptor.addChild(root_0, char_literal56_tree);
                    }
                    pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1172);
                    pointcutActorPropDecls57=pointcutActorPropDecls(prop, declClass);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls57.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			PropValue propValue = new PropValue((apdref!=null?apdref.relation:null),(negate!=null?negate.value:null));
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:471:1: pointcutActorPropDecl[Class<? extends Declaration> declClass] returns [SimpleReference<? extends Declaration> relation] : name= Identifier ;
    public final MViewParser.pointcutActorPropDecl_return pointcutActorPropDecl(Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecl_return retval = new MViewParser.pointcutActorPropDecl_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecl_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;

        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:472:2: (name= Identifier )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:472:5: name= Identifier
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutActorPropDecl1197); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:480:1: adviceDeclaration returns [Advice advice] : avkw= 'advice' adviceBody[$advice] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:481:2: (avkw= 'advice' adviceBody[$advice] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:481:4: avkw= 'advice' adviceBody[$advice]
            {
            root_0 = (Object)adaptor.nil();

            avkw=(Token)match(input,42,FOLLOW_42_in_adviceDeclaration1220); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            avkw_tree = (Object)adaptor.create(avkw);
            adaptor.addChild(root_0, avkw_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.advice = new Advice();
              			setKeyword(retval.advice,avkw);
              		
            }
            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration1224);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:487:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:488:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:488:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal59=(Token)match(input,24,FOLLOW_24_in_adviceBody1237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal59_tree = (Object)adaptor.create(char_literal59);
            adaptor.addChild(root_0, char_literal59_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:488:8: ( adviceBodyDeclaration[$advice] )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=43 && LA24_0<=44)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: adviceBodyDeclaration[$advice]
            	    {
            	    pushFollow(FOLLOW_adviceBodyDeclaration_in_adviceBody1239);
            	    adviceBodyDeclaration60=adviceBodyDeclaration(advice);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBodyDeclaration60.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            char_literal61=(Token)match(input,25,FOLLOW_25_in_adviceBody1243); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:491:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] );
    public final MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceBodyDeclaration_return retval = new MViewParser.adviceBodyDeclaration_return();
        retval.start = input.LT(1);
        int adviceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration62 = null;

        MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration63 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:492:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==43) ) {
                alt25=1;
            }
            else if ( (LA25_0==44) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:492:4: adviceServiceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1256);
                    adviceServiceDeclaration62=adviceServiceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceServiceDeclaration62.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:493:4: adviceTypeDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1262);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:496:1: adviceServiceDeclaration[Advice advice] : svkw= 'service' ':' service= serviceReferenceDeclaration ';' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:497:2: (svkw= 'service' ':' service= serviceReferenceDeclaration ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:497:4: svkw= 'service' ':' service= serviceReferenceDeclaration ';'
            {
            root_0 = (Object)adaptor.nil();

            svkw=(Token)match(input,43,FOLLOW_43_in_adviceServiceDeclaration1278); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            svkw_tree = (Object)adaptor.create(svkw);
            adaptor.addChild(root_0, svkw_tree);
            }
            char_literal64=(Token)match(input,34,FOLLOW_34_in_adviceServiceDeclaration1280); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
            }
            pushFollow(FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1284);
            service=serviceReferenceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal65=(Token)match(input,26,FOLLOW_26_in_adviceServiceDeclaration1286); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:503:1: adviceTypeDeclaration[Advice advice] : tpkw= 'type' ':' avtype= adviceType ';' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:504:2: (tpkw= 'type' ':' avtype= adviceType ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:504:4: tpkw= 'type' ':' avtype= adviceType ';'
            {
            root_0 = (Object)adaptor.nil();

            tpkw=(Token)match(input,44,FOLLOW_44_in_adviceTypeDeclaration1303); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tpkw_tree = (Object)adaptor.create(tpkw);
            adaptor.addChild(root_0, tpkw_tree);
            }
            char_literal66=(Token)match(input,34,FOLLOW_34_in_adviceTypeDeclaration1305); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal66_tree = (Object)adaptor.create(char_literal66);
            adaptor.addChild(root_0, char_literal66_tree);
            }
            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration1309);
            avtype=adviceType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, avtype.getTree());
            char_literal67=(Token)match(input,26,FOLLOW_26_in_adviceTypeDeclaration1311); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:516:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier componentBody[$element] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:517:2: (compkw= 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:517:5: compkw= 'component' name= Identifier componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            compkw=(Token)match(input,38,FOLLOW_38_in_componentDeclaration1338); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            compkw_tree = (Object)adaptor.create(compkw);
            adaptor.addChild(root_0, compkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration1342); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                 			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                 			setKeyword(retval.element,compkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_componentBody_in_componentDeclaration1346);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:525:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:526:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:526:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal69=(Token)match(input,24,FOLLOW_24_in_componentBody1368); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal69_tree = (Object)adaptor.create(char_literal69);
            adaptor.addChild(root_0, char_literal69_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:526:8: ( componentBodyDeclaration[$element] )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=45 && LA26_0<=46)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody1370);
            	    componentBodyDeclaration70=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration70.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            char_literal71=(Token)match(input,25,FOLLOW_25_in_componentBody1374); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:530:1: componentBodyDeclaration[Component element] : ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] );
    public final MViewParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MViewParser.componentBodyDeclaration_return retval = new MViewParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);
        int componentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration72 = null;

        MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration73 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:531:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==45) ) {
                alt27=1;
            }
            else if ( (LA27_0==46) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:531:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1392);
                    moduleRequireDependencyDeclaration72=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration72.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:532:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1398);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:542:1: moduleDependencyBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:544:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:544:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal74=(Token)match(input,24,FOLLOW_24_in_moduleDependencyBody1426); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal74_tree = (Object)adaptor.create(char_literal74);
            adaptor.addChild(root_0, char_literal74_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:544:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==Identifier) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:544:9: decls= commaSeparatedBodyDecls[Interface.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1431);
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

            char_literal75=(Token)match(input,25,FOLLOW_25_in_moduleDependencyBody1439); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:548:1: moduleRequireDependencyDeclaration[Module element] : rekw= 'require' rd= moduleDependencyBody ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:549:2: (rekw= 'require' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:549:4: rekw= 'require' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            rekw=(Token)match(input,45,FOLLOW_45_in_moduleRequireDependencyDeclaration1456); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rekw_tree = (Object)adaptor.create(rekw);
            adaptor.addChild(root_0, rekw_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1460);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:557:1: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:558:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:558:4: 'provide' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal76=(Token)match(input,46,FOLLOW_46_in_moduleProvideDependencyDeclaration1475); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal76_tree = (Object)adaptor.create(string_literal76);
            adaptor.addChild(root_0, string_literal76_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1479);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:597:1: applicationDeclaration returns [Application element] : appkw= 'application' name= Identifier refinementDeclaration[$element,Application.class] applicationBody[$element] ;
    public final MViewParser.applicationDeclaration_return applicationDeclaration() throws RecognitionException {
        MViewParser.applicationDeclaration_return retval = new MViewParser.applicationDeclaration_return();
        retval.start = input.LT(1);
        int applicationDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token appkw=null;
        Token name=null;
        MViewParser.refinementDeclaration_return refinementDeclaration77 = null;

        MViewParser.applicationBody_return applicationBody78 = null;


        Object appkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:598:2: (appkw= 'application' name= Identifier refinementDeclaration[$element,Application.class] applicationBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:598:4: appkw= 'application' name= Identifier refinementDeclaration[$element,Application.class] applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            appkw=(Token)match(input,39,FOLLOW_39_in_applicationDeclaration1511); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_applicationDeclaration1515); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Application(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,appkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_refinementDeclaration_in_applicationDeclaration1522);
            refinementDeclaration77=refinementDeclaration(retval.element, Application.class);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration77.getTree());
            pushFollow(FOLLOW_applicationBody_in_applicationDeclaration1527);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:608:1: applicationBody[Application element] : '{' ( applicationBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:609:2: ( '{' ( applicationBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:609:4: '{' ( applicationBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal79=(Token)match(input,24,FOLLOW_24_in_applicationBody1541); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal79_tree = (Object)adaptor.create(char_literal79);
            adaptor.addChild(root_0, char_literal79_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:609:8: ( applicationBodyDeclaration[$element] )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==Identifier||LA29_0==30||LA29_0==38||LA29_0==41) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:609:10: applicationBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_applicationBodyDeclaration_in_applicationBody1545);
            	    applicationBodyDeclaration80=applicationBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBodyDeclaration80.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            char_literal81=(Token)match(input,25,FOLLOW_25_in_applicationBody1551); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:613:1: applicationBodyDeclaration[Application element] : (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration );
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:614:2: (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 30:
            case 38:
                {
                alt30=1;
                }
                break;
            case 41:
                {
                alt30=2;
                }
                break;
            case Identifier:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:614:4: mod= moduleContainerDeclarations
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1567);
                    mod=moduleContainerDeclarations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod.getTree());
                    if ( state.backtracking==0 ) {

                      			element.addModule(mod.element);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:618:3: hod= hostDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hostDeclaration_in_applicationBodyDeclaration1578);
                    hod=hostDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hod.getTree());
                    if ( state.backtracking==0 ) {

                      			element.addHost(hod.element);
                      		
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:622:3: ind= instanceDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1590);
                    ind=instanceDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ind.getTree());
                    if ( state.backtracking==0 ) {

                      			element.addInstance(ind.element); 
                      		
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:632:1: deploymentDeclaration returns [Deployment element] : appkw= 'deployment' name= Identifier refinementDeclaration[$element,Application.class] applicationBody[$element] ;
    public final MViewParser.deploymentDeclaration_return deploymentDeclaration() throws RecognitionException {
        MViewParser.deploymentDeclaration_return retval = new MViewParser.deploymentDeclaration_return();
        retval.start = input.LT(1);
        int deploymentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token appkw=null;
        Token name=null;
        MViewParser.refinementDeclaration_return refinementDeclaration82 = null;

        MViewParser.applicationBody_return applicationBody83 = null;


        Object appkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:633:2: (appkw= 'deployment' name= Identifier refinementDeclaration[$element,Application.class] applicationBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:633:4: appkw= 'deployment' name= Identifier refinementDeclaration[$element,Application.class] applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            appkw=(Token)match(input,47,FOLLOW_47_in_deploymentDeclaration1615); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_deploymentDeclaration1619); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Deployment(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,appkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_refinementDeclaration_in_deploymentDeclaration1626);
            refinementDeclaration82=refinementDeclaration(retval.element, Application.class);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration82.getTree());
            pushFollow(FOLLOW_applicationBody_in_deploymentDeclaration1631);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:690:1: instanceDeclaration returns [Instance element] : tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:691:2: (tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:691:4: tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';'
            {
            root_0 = (Object)adaptor.nil();

            tpe=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1656); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tpe_tree = (Object)adaptor.create(tpe);
            adaptor.addChild(root_0, tpe_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1660); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            onkw=(Token)match(input,48,FOLLOW_48_in_instanceDeclaration1664); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            onkw_tree = (Object)adaptor.create(onkw);
            adaptor.addChild(root_0, onkw_tree);
            }
            hst=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1668); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hst_tree = (Object)adaptor.create(hst);
            adaptor.addChild(root_0, hst_tree);
            }
            char_literal84=(Token)match(input,26,FOLLOW_26_in_instanceDeclaration1670); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:717:1: hostDeclaration returns [Host element] : hkw= 'host' name= Identifier (onkw= 'on' value= StringLiteral )? ';' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:718:2: (hkw= 'host' name= Identifier (onkw= 'on' value= StringLiteral )? ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:718:5: hkw= 'host' name= Identifier (onkw= 'on' value= StringLiteral )? ';'
            {
            root_0 = (Object)adaptor.nil();

            hkw=(Token)match(input,41,FOLLOW_41_in_hostDeclaration1697); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hkw_tree = (Object)adaptor.create(hkw);
            adaptor.addChild(root_0, hkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_hostDeclaration1701); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			
              			retval.element = new Host(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,hkw);
              			setLocation(retval.element,name,"__NAME");
              			
              		
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:724:5: (onkw= 'on' value= StringLiteral )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==48) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:724:7: onkw= 'on' value= StringLiteral
                    {
                    onkw=(Token)match(input,48,FOLLOW_48_in_hostDeclaration1709); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    onkw_tree = (Object)adaptor.create(onkw);
                    adaptor.addChild(root_0, onkw_tree);
                    }
                    value=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_hostDeclaration1713); if (state.failed) return retval;
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

            char_literal85=(Token)match(input,26,FOLLOW_26_in_hostDeclaration1720); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:740:1: moduleContainerDeclarations returns [Module element] : (cod= componentDeclaration | cnd= connectorDeclaration );
    public final MViewParser.moduleContainerDeclarations_return moduleContainerDeclarations() throws RecognitionException {
        MViewParser.moduleContainerDeclarations_return retval = new MViewParser.moduleContainerDeclarations_return();
        retval.start = input.LT(1);
        int moduleContainerDeclarations_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.componentDeclaration_return cod = null;

        MViewParser.connectorDeclaration_return cnd = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:741:2: (cod= componentDeclaration | cnd= connectorDeclaration )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==38) ) {
                alt32=1;
            }
            else if ( (LA32_0==30) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:742:3: cod= componentDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_componentDeclaration_in_moduleContainerDeclarations1746);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:746:3: cnd= connectorDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1757);
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

    public static class refinementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "refinementDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:772:1: refinementDeclaration[RefinableDeclaration element, Class kind] : (rfkw= ':' refinementRelationDeclarations[$element,$kind] )? ;
    public final MViewParser.refinementDeclaration_return refinementDeclaration(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementDeclaration_return retval = new MViewParser.refinementDeclaration_return();
        retval.start = input.LT(1);
        int refinementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token rfkw=null;
        MViewParser.refinementRelationDeclarations_return refinementRelationDeclarations86 = null;


        Object rfkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:773:2: ( (rfkw= ':' refinementRelationDeclarations[$element,$kind] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:773:4: (rfkw= ':' refinementRelationDeclarations[$element,$kind] )?
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:773:4: (rfkw= ':' refinementRelationDeclarations[$element,$kind] )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==34) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:773:5: rfkw= ':' refinementRelationDeclarations[$element,$kind]
                    {
                    rfkw=(Token)match(input,34,FOLLOW_34_in_refinementDeclaration1782); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    rfkw_tree = (Object)adaptor.create(rfkw);
                    adaptor.addChild(root_0, rfkw_tree);
                    }
                    pushFollow(FOLLOW_refinementRelationDeclarations_in_refinementDeclaration1784);
                    refinementRelationDeclarations86=refinementRelationDeclarations(element, kind);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementRelationDeclarations86.getTree());
                    if ( state.backtracking==0 ) {

                      			setKeyword(element,rfkw);
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 51, refinementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "refinementDeclaration"

    public static class refinementRelationDeclarations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "refinementRelationDeclarations"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:778:1: refinementRelationDeclarations[RefinableDeclaration element, Class kind] : name= Identifier ( ',' refinementRelationDeclarations[$element,$kind] )? ;
    public final MViewParser.refinementRelationDeclarations_return refinementRelationDeclarations(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementRelationDeclarations_return retval = new MViewParser.refinementRelationDeclarations_return();
        retval.start = input.LT(1);
        int refinementRelationDeclarations_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal87=null;
        MViewParser.refinementRelationDeclarations_return refinementRelationDeclarations88 = null;


        Object name_tree=null;
        Object char_literal87_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:779:2: (name= Identifier ( ',' refinementRelationDeclarations[$element,$kind] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:779:4: name= Identifier ( ',' refinementRelationDeclarations[$element,$kind] )?
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_refinementRelationDeclarations1803); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:779:20: ( ',' refinementRelationDeclarations[$element,$kind] )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==29) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:779:22: ',' refinementRelationDeclarations[$element,$kind]
                    {
                    char_literal87=(Token)match(input,29,FOLLOW_29_in_refinementRelationDeclarations1807); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal87_tree = (Object)adaptor.create(char_literal87);
                    adaptor.addChild(root_0, char_literal87_tree);
                    }
                    pushFollow(FOLLOW_refinementRelationDeclarations_in_refinementRelationDeclarations1809);
                    refinementRelationDeclarations88=refinementRelationDeclarations(element, kind);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementRelationDeclarations88.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			SimpleReference parentRef = new SimpleReference((name!=null?name.getText():null),kind);
              			RefinementRelation relation = new RefinementRelation(parentRef);
              			element.addRefinementRelation(relation);
              			setLocation(parentRef,name,name);
              		
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
            if ( state.backtracking>0 ) { memoize(input, 52, refinementRelationDeclarations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "refinementRelationDeclarations"

    public static class commaSeparatedBodyDecls_return extends ParserRuleReturnScope {
        public List<SimpleReference> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "commaSeparatedBodyDecls"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:792:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
    public final MViewParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls(Class targetType) throws RecognitionException {
        MViewParser.commaSeparatedBodyDecls_return retval = new MViewParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);
        int commaSeparatedBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token char_literal89=null;
        MViewParser.commaSeparatedBodyDecls_return decls = null;


        Object id_tree=null;
        Object char_literal89_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:794:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:794:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls1842); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:794:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==29) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:794:19: ',' decls= commaSeparatedBodyDecls[$targetType]
                    {
                    char_literal89=(Token)match(input,29,FOLLOW_29_in_commaSeparatedBodyDecls1845); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal89_tree = (Object)adaptor.create(char_literal89);
                    adaptor.addChild(root_0, char_literal89_tree);
                    }
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1849);
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
            if ( state.backtracking>0 ) { memoize(input, 53, commaSeparatedBodyDecls_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:809:1: adviceType returns [Modifier value] : ( 'before' | 'after' | 'around' );
    public final MViewParser.adviceType_return adviceType() throws RecognitionException {
        MViewParser.adviceType_return retval = new MViewParser.adviceType_return();
        retval.start = input.LT(1);
        int adviceType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal90=null;
        Token string_literal91=null;
        Token string_literal92=null;

        Object string_literal90_tree=null;
        Object string_literal91_tree=null;
        Object string_literal92_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:810:2: ( 'before' | 'after' | 'around' )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt36=1;
                }
                break;
            case 50:
                {
                alt36=2;
                }
                break;
            case 51:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:810:4: 'before'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal90=(Token)match(input,49,FOLLOW_49_in_adviceType1881); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = (Object)adaptor.create(string_literal90);
                    adaptor.addChild(root_0, string_literal90_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Before();
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:811:4: 'after'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal91=(Token)match(input,50,FOLLOW_50_in_adviceType1888); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal91_tree = (Object)adaptor.create(string_literal91);
                    adaptor.addChild(root_0, string_literal91_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new After();
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:812:4: 'around'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal92=(Token)match(input,51,FOLLOW_51_in_adviceType1895); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (Object)adaptor.create(string_literal92);
                    adaptor.addChild(root_0, string_literal92_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 54, adviceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:815:1: joinPointKind returns [Modifier value] : ( 'execution' | 'call' );
    public final MViewParser.joinPointKind_return joinPointKind() throws RecognitionException {
        MViewParser.joinPointKind_return retval = new MViewParser.joinPointKind_return();
        retval.start = input.LT(1);
        int joinPointKind_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal93=null;
        Token string_literal94=null;

        Object string_literal93_tree=null;
        Object string_literal94_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:816:2: ( 'execution' | 'call' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==52) ) {
                alt37=1;
            }
            else if ( (LA37_0==53) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:816:4: 'execution'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal93=(Token)match(input,52,FOLLOW_52_in_joinPointKind1913); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal93_tree = (Object)adaptor.create(string_literal93);
                    adaptor.addChild(root_0, string_literal93_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Execution();
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:817:4: 'call'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal94=(Token)match(input,53,FOLLOW_53_in_joinPointKind1920); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal94_tree = (Object)adaptor.create(string_literal94);
                    adaptor.addChild(root_0, string_literal94_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 55, joinPointKind_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:820:1: overrideOrExtend returns [Modifier value] : (okw= 'override' | ekw= 'extend' );
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:821:2: (okw= 'override' | ekw= 'extend' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==54) ) {
                alt38=1;
            }
            else if ( (LA38_0==55) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:821:4: okw= 'override'
                    {
                    root_0 = (Object)adaptor.nil();

                    okw=(Token)match(input,54,FOLLOW_54_in_overrideOrExtend1940); if (state.failed) return retval;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:822:4: ekw= 'extend'
                    {
                    root_0 = (Object)adaptor.nil();

                    ekw=(Token)match(input,55,FOLLOW_55_in_overrideOrExtend1949); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 56, overrideOrExtend_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "overrideOrExtend"

    public static class negation_return extends ParserRuleReturnScope {
        public Modifier value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "negation"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:825:1: negation returns [Modifier value] : '!' ;
    public final MViewParser.negation_return negation() throws RecognitionException {
        MViewParser.negation_return retval = new MViewParser.negation_return();
        retval.start = input.LT(1);
        int negation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal95=null;

        Object char_literal95_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:826:2: ( '!' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:826:5: '!'
            {
            root_0 = (Object)adaptor.nil();

            char_literal95=(Token)match(input,56,FOLLOW_56_in_negation1967); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal95_tree = (Object)adaptor.create(char_literal95);
            adaptor.addChild(root_0, char_literal95_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 57, negation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "negation"

    public static class voidType_return extends ParserRuleReturnScope {
        public TypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "voidType"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:829:1: voidType returns [TypeReference value] : 'void' ;
    public final MViewParser.voidType_return voidType() throws RecognitionException {
        MViewParser.voidType_return retval = new MViewParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal96=null;

        Object string_literal96_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:831:5: ( 'void' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:831:7: 'void'
            {
            root_0 = (Object)adaptor.nil();

            string_literal96=(Token)match(input,57,FOLLOW_57_in_voidType1989); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal96_tree = (Object)adaptor.create(string_literal96);
            adaptor.addChild(root_0, string_literal96_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 58, voidType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "voidType"

    public static class wildcardType_return extends ParserRuleReturnScope {
        public TypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "wildcardType"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:835:1: wildcardType returns [TypeReference value] : '*' ;
    public final MViewParser.wildcardType_return wildcardType() throws RecognitionException {
        MViewParser.wildcardType_return retval = new MViewParser.wildcardType_return();
        retval.start = input.LT(1);
        int wildcardType_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal97=null;

        Object char_literal97_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:836:2: ( '*' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:836:4: '*'
            {
            root_0 = (Object)adaptor.nil();

            char_literal97=(Token)match(input,58,FOLLOW_58_in_wildcardType2010); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal97_tree = (Object)adaptor.create(char_literal97);
            adaptor.addChild(root_0, char_literal97_tree);
            }
            if ( state.backtracking==0 ) {
               retval.value = new BasicTypeReference("wildcard"); 
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
            if ( state.backtracking>0 ) { memoize(input, 59, wildcardType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "wildcardType"

    public static class type_return extends ParserRuleReturnScope {
        public TypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:840:1: type returns [TypeReference value] : (cd= classOrInterfaceType | pt= primitiveType );
    public final MViewParser.type_return type() throws RecognitionException {
        MViewParser.type_return retval = new MViewParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.classOrInterfaceType_return cd = null;

        MViewParser.primitiveType_return pt = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:842:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Identifier) ) {
                alt39=1;
            }
            else if ( ((LA39_0>=60 && LA39_0<=67)) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:842:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceType_in_type2034);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:843:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveType_in_type2043);
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
            if ( state.backtracking>0 ) { memoize(input, 60, type_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class classOrInterfaceType_return extends ParserRuleReturnScope {
        public TypeReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classOrInterfaceType"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:847:1: classOrInterfaceType returns [TypeReference element] : name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* ;
    public final MViewParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MViewParser.classOrInterfaceType_return retval = new MViewParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal99=null;
        MViewParser.typeArguments_return typeArguments98 = null;

        MViewParser.typeArguments_return typeArguments100 = null;


        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal99_tree=null;

        NamespaceOrTypeReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:849:2: (name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:849:4: name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2068); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new BasicTypeReference((name!=null?name.getText():null)); 
              	           target =  new NamespaceOrTypeReference((name!=null?name.getText():null)); 
              	          
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:854:4: ( typeArguments )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==68) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2087);
                    typeArguments98=typeArguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments98.getTree());

                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:855:10: ( '.' namex= Identifier ( typeArguments )? )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==59) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:855:11: '.' namex= Identifier ( typeArguments )?
            	    {
            	    char_literal99=(Token)match(input,59,FOLLOW_59_in_classOrInterfaceType2101); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal99_tree = (Object)adaptor.create(char_literal99);
            	    adaptor.addChild(root_0, char_literal99_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2105); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    namex_tree = (Object)adaptor.create(namex);
            	    adaptor.addChild(root_0, namex_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      	           if(target != null) {
            	      	             retval.element = new BasicTypeReference(target,(namex!=null?namex.getText():null));
            	      	             // We must clone the target here, or else it will be removed from the
            	      	             // type reference we just created.
            	      	             target = new NamespaceOrTypeReference(target.clone(),(namex!=null?namex.getText():null));
            	      	           } else {
            	      	             retval.element = new BasicTypeReference(retval.element,(namex!=null?namex.getText():null));
            	      	           }
            	      	          
            	    }
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:866:11: ( typeArguments )?
            	    int alt41=2;
            	    int LA41_0 = input.LA(1);

            	    if ( (LA41_0==68) ) {
            	        alt41=1;
            	    }
            	    switch (alt41) {
            	        case 1 :
            	            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2132);
            	            typeArguments100=typeArguments();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments100.getTree());

            	            }
            	            break;

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
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, classOrInterfaceType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "classOrInterfaceType"

    public static class primitiveType_return extends ParserRuleReturnScope {
        public TypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primitiveType"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:870:1: primitiveType returns [TypeReference value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MViewParser.primitiveType_return primitiveType() throws RecognitionException {
        MViewParser.primitiveType_return retval = new MViewParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal101=null;
        Token string_literal102=null;
        Token string_literal103=null;
        Token string_literal104=null;
        Token string_literal105=null;
        Token string_literal106=null;
        Token string_literal107=null;
        Token string_literal108=null;

        Object string_literal101_tree=null;
        Object string_literal102_tree=null;
        Object string_literal103_tree=null;
        Object string_literal104_tree=null;
        Object string_literal105_tree=null;
        Object string_literal106_tree=null;
        Object string_literal107_tree=null;
        Object string_literal108_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:871:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt43=8;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt43=1;
                }
                break;
            case 61:
                {
                alt43=2;
                }
                break;
            case 62:
                {
                alt43=3;
                }
                break;
            case 63:
                {
                alt43=4;
                }
                break;
            case 64:
                {
                alt43=5;
                }
                break;
            case 65:
                {
                alt43=6;
                }
                break;
            case 66:
                {
                alt43=7;
                }
                break;
            case 67:
                {
                alt43=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:871:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal101=(Token)match(input,60,FOLLOW_60_in_primitiveType2157); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal101_tree = (Object)adaptor.create(string_literal101);
                    adaptor.addChild(root_0, string_literal101_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:872:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal102=(Token)match(input,61,FOLLOW_61_in_primitiveType2169); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal102_tree = (Object)adaptor.create(string_literal102);
                    adaptor.addChild(root_0, string_literal102_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("char");
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:873:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal103=(Token)match(input,62,FOLLOW_62_in_primitiveType2181); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal103_tree = (Object)adaptor.create(string_literal103);
                    adaptor.addChild(root_0, string_literal103_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("byte");
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:874:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal104=(Token)match(input,63,FOLLOW_63_in_primitiveType2193); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal104_tree = (Object)adaptor.create(string_literal104);
                    adaptor.addChild(root_0, string_literal104_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("short");
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:875:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal105=(Token)match(input,64,FOLLOW_64_in_primitiveType2205); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal105_tree = (Object)adaptor.create(string_literal105);
                    adaptor.addChild(root_0, string_literal105_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("int");
                    }

                    }
                    break;
                case 6 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:876:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal106=(Token)match(input,65,FOLLOW_65_in_primitiveType2217); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal106_tree = (Object)adaptor.create(string_literal106);
                    adaptor.addChild(root_0, string_literal106_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("long");
                    }

                    }
                    break;
                case 7 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:877:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal107=(Token)match(input,66,FOLLOW_66_in_primitiveType2229); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal107_tree = (Object)adaptor.create(string_literal107);
                    adaptor.addChild(root_0, string_literal107_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("float");
                    }

                    }
                    break;
                case 8 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:878:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal108=(Token)match(input,67,FOLLOW_67_in_primitiveType2241); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal108_tree = (Object)adaptor.create(string_literal108);
                    adaptor.addChild(root_0, string_literal108_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("double");
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
            if ( state.backtracking>0 ) { memoize(input, 62, primitiveType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primitiveType"

    public static class typeArguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArguments"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:883:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final MViewParser.typeArguments_return typeArguments() throws RecognitionException {
        MViewParser.typeArguments_return retval = new MViewParser.typeArguments_return();
        retval.start = input.LT(1);
        int typeArguments_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal109=null;
        Token char_literal111=null;
        Token char_literal113=null;
        MViewParser.typeArgument_return typeArgument110 = null;

        MViewParser.typeArgument_return typeArgument112 = null;


        Object char_literal109_tree=null;
        Object char_literal111_tree=null;
        Object char_literal113_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:884:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:884:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal109=(Token)match(input,68,FOLLOW_68_in_typeArguments2264); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal109_tree = (Object)adaptor.create(char_literal109);
            adaptor.addChild(root_0, char_literal109_tree);
            }
            pushFollow(FOLLOW_typeArgument_in_typeArguments2266);
            typeArgument110=typeArgument();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument110.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:884:26: ( ',' typeArgument )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==29) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:884:28: ',' typeArgument
            	    {
            	    char_literal111=(Token)match(input,29,FOLLOW_29_in_typeArguments2270); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal111_tree = (Object)adaptor.create(char_literal111);
            	    adaptor.addChild(root_0, char_literal111_tree);
            	    }
            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2272);
            	    typeArgument112=typeArgument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument112.getTree());

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            char_literal113=(Token)match(input,69,FOLLOW_69_in_typeArguments2277); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal113_tree = (Object)adaptor.create(char_literal113);
            adaptor.addChild(root_0, char_literal113_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 63, typeArguments_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArguments"

    public static class typeArgument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArgument"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:887:1: typeArgument : (t= type | '?' ( ( 'extends' | 'super' ) t= type )? );
    public final MViewParser.typeArgument_return typeArgument() throws RecognitionException {
        MViewParser.typeArgument_return retval = new MViewParser.typeArgument_return();
        retval.start = input.LT(1);
        int typeArgument_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal114=null;
        Token set115=null;
        MViewParser.type_return t = null;


        Object char_literal114_tree=null;
        Object set115_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:5: (t= type | '?' ( ( 'extends' | 'super' ) t= type )? )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==Identifier||(LA46_0>=60 && LA46_0<=67)) ) {
                alt46=1;
            }
            else if ( (LA46_0==70) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:9: t= type
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_typeArgument2302);
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:20: '?' ( ( 'extends' | 'super' ) t= type )?
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal114=(Token)match(input,70,FOLLOW_70_in_typeArgument2308); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal114_tree = (Object)adaptor.create(char_literal114);
                    adaptor.addChild(root_0, char_literal114_tree);
                    }
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:25: ( ( 'extends' | 'super' ) t= type )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( ((LA45_0>=71 && LA45_0<=72)) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:888:27: ( 'extends' | 'super' ) t= type
                            {
                            set115=(Token)input.LT(1);
                            if ( (input.LA(1)>=71 && input.LA(1)<=72) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set115));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_type_in_typeArgument2323);
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
            if ( state.backtracking>0 ) { memoize(input, 64, typeArgument_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArgument"

    public static class annotations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotations"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:895:1: annotations : ( annotation )+ ;
    public final MViewParser.annotations_return annotations() throws RecognitionException {
        MViewParser.annotations_return retval = new MViewParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotation_return annotation116 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:896:5: ( ( annotation )+ )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:896:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:896:9: ( annotation )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==73) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations2353);
            	    annotation116=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation116.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt47 >= 1 ) break loop47;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
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
            if ( state.backtracking>0 ) { memoize(input, 65, annotations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotations"

    public static class annotation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotation"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:899:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MViewParser.annotation_return annotation() throws RecognitionException {
        MViewParser.annotation_return retval = new MViewParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal117=null;
        Token char_literal119=null;
        Token char_literal122=null;
        MViewParser.annotationName_return annotationName118 = null;

        MViewParser.elementValuePairs_return elementValuePairs120 = null;

        MViewParser.elementValue_return elementValue121 = null;


        Object char_literal117_tree=null;
        Object char_literal119_tree=null;
        Object char_literal122_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:900:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:900:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            char_literal117=(Token)match(input,73,FOLLOW_73_in_annotation2373); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal117_tree = (Object)adaptor.create(char_literal117);
            adaptor.addChild(root_0, char_literal117_tree);
            }
            pushFollow(FOLLOW_annotationName_in_annotation2375);
            annotationName118=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName118.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:900:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==27) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:900:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal119=(Token)match(input,27,FOLLOW_27_in_annotation2379); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal119_tree = (Object)adaptor.create(char_literal119);
                    adaptor.addChild(root_0, char_literal119_tree);
                    }
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:900:34: ( elementValuePairs | elementValue )?
                    int alt48=3;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==Identifier) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==24||LA48_0==73) ) {
                        alt48=2;
                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:900:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation2383);
                            elementValuePairs120=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs120.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:900:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation2387);
                            elementValue121=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue121.getTree());

                            }
                            break;

                    }

                    char_literal122=(Token)match(input,28,FOLLOW_28_in_annotation2392); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal122_tree = (Object)adaptor.create(char_literal122);
                    adaptor.addChild(root_0, char_literal122_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 66, annotation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotation"

    public static class annotationName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationName"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:903:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MViewParser.annotationName_return annotationName() throws RecognitionException {
        MViewParser.annotationName_return retval = new MViewParser.annotationName_return();
        retval.start = input.LT(1);
        int annotationName_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier123=null;
        Token char_literal124=null;
        Token Identifier125=null;

        Object Identifier123_tree=null;
        Object char_literal124_tree=null;
        Object Identifier125_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            Identifier123=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2416); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier123_tree = (Object)adaptor.create(Identifier123);
            adaptor.addChild(root_0, Identifier123_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:18: ( '.' Identifier )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==59) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:19: '.' Identifier
            	    {
            	    char_literal124=(Token)match(input,59,FOLLOW_59_in_annotationName2419); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal124_tree = (Object)adaptor.create(char_literal124);
            	    adaptor.addChild(root_0, char_literal124_tree);
            	    }
            	    Identifier125=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2421); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier125_tree = (Object)adaptor.create(Identifier125);
            	    adaptor.addChild(root_0, Identifier125_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 67, annotationName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationName"

    public static class elementValuePairs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePairs"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:907:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MViewParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MViewParser.elementValuePairs_return retval = new MViewParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal127=null;
        MViewParser.elementValuePair_return elementValuePair126 = null;

        MViewParser.elementValuePair_return elementValuePair128 = null;


        Object char_literal127_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:908:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:908:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2442);
            elementValuePair126=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair126.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:908:26: ( ',' elementValuePair )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==29) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:908:27: ',' elementValuePair
            	    {
            	    char_literal127=(Token)match(input,29,FOLLOW_29_in_elementValuePairs2445); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal127_tree = (Object)adaptor.create(char_literal127);
            	    adaptor.addChild(root_0, char_literal127_tree);
            	    }
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2447);
            	    elementValuePair128=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair128.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 68, elementValuePairs_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePairs"

    public static class elementValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePair"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:911:1: elementValuePair : Identifier '=' elementValue ;
    public final MViewParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MViewParser.elementValuePair_return retval = new MViewParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier129=null;
        Token char_literal130=null;
        MViewParser.elementValue_return elementValue131 = null;


        Object Identifier129_tree=null;
        Object char_literal130_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:912:5: ( Identifier '=' elementValue )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:912:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();

            Identifier129=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair2468); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier129_tree = (Object)adaptor.create(Identifier129);
            adaptor.addChild(root_0, Identifier129_tree);
            }
            char_literal130=(Token)match(input,74,FOLLOW_74_in_elementValuePair2470); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal130_tree = (Object)adaptor.create(char_literal130);
            adaptor.addChild(root_0, char_literal130_tree);
            }
            pushFollow(FOLLOW_elementValue_in_elementValuePair2472);
            elementValue131=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue131.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, elementValuePair_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePair"

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValue"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:915:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MViewParser.elementValue_return elementValue() throws RecognitionException {
        MViewParser.elementValue_return retval = new MViewParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotation_return annotation132 = null;

        MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer133 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:916:5: ( annotation | elementValueArrayInitializer )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==73) ) {
                alt52=1;
            }
            else if ( (LA52_0==24) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:916:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotation_in_elementValue2495);
                    annotation132=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation132.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:917:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue2505);
                    elementValueArrayInitializer133=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer133.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 70, elementValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValue"

    public static class elementValueArrayInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValueArrayInitializer"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:920:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MViewParser.elementValueArrayInitializer_return retval = new MViewParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal134=null;
        Token char_literal136=null;
        Token char_literal138=null;
        Token char_literal139=null;
        MViewParser.elementValue_return elementValue135 = null;

        MViewParser.elementValue_return elementValue137 = null;


        Object char_literal134_tree=null;
        Object char_literal136_tree=null;
        Object char_literal138_tree=null;
        Object char_literal139_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal134=(Token)match(input,24,FOLLOW_24_in_elementValueArrayInitializer2528); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal134_tree = (Object)adaptor.create(char_literal134);
            adaptor.addChild(root_0, char_literal134_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:13: ( elementValue ( ',' elementValue )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==24||LA54_0==73) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2531);
                    elementValue135=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue135.getTree());
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:27: ( ',' elementValue )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==29) ) {
                            int LA53_1 = input.LA(2);

                            if ( (LA53_1==24||LA53_1==73) ) {
                                alt53=1;
                            }


                        }


                        switch (alt53) {
                    	case 1 :
                    	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:28: ',' elementValue
                    	    {
                    	    char_literal136=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2534); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal136_tree = (Object)adaptor.create(char_literal136);
                    	    adaptor.addChild(root_0, char_literal136_tree);
                    	    }
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2536);
                    	    elementValue137=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue137.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:49: ( ',' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==29) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:50: ','
                    {
                    char_literal138=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2543); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal138_tree = (Object)adaptor.create(char_literal138);
                    adaptor.addChild(root_0, char_literal138_tree);
                    }

                    }
                    break;

            }

            char_literal139=(Token)match(input,25,FOLLOW_25_in_elementValueArrayInitializer2547); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal139_tree = (Object)adaptor.create(char_literal139);
            adaptor.addChild(root_0, char_literal139_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 71, elementValueArrayInitializer_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:924:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MViewParser.annotationTypeDeclaration_return retval = new MViewParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal140=null;
        Token string_literal141=null;
        MViewParser.annotationTypeBody_return annotationTypeBody142 = null;


        Object name_tree=null;
        Object char_literal140_tree=null;
        Object string_literal141_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:925:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:925:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();

            char_literal140=(Token)match(input,73,FOLLOW_73_in_annotationTypeDeclaration2574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal140_tree = (Object)adaptor.create(char_literal140);
            adaptor.addChild(root_0, char_literal140_tree);
            }
            string_literal141=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration2576); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal141_tree = (Object)adaptor.create(string_literal141);
            adaptor.addChild(root_0, string_literal141_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration2580); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2582);
            annotationTypeBody142=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody142.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, annotationTypeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeDeclaration"

    public static class annotationTypeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeBody"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:928:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MViewParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MViewParser.annotationTypeBody_return retval = new MViewParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal143=null;
        Token char_literal145=null;
        MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration144 = null;


        Object char_literal143_tree=null;
        Object char_literal145_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:929:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:929:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal143=(Token)match(input,24,FOLLOW_24_in_annotationTypeBody2605); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal143_tree = (Object)adaptor.create(char_literal143);
            adaptor.addChild(root_0, char_literal143_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:929:13: ( annotationTypeElementDeclaration )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==Identifier||(LA56_0>=60 && LA56_0<=67)||LA56_0==73) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:929:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2608);
            	    annotationTypeElementDeclaration144=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration144.getTree());

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            char_literal145=(Token)match(input,25,FOLLOW_25_in_annotationTypeBody2612); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal145_tree = (Object)adaptor.create(char_literal145);
            adaptor.addChild(root_0, char_literal145_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 73, annotationTypeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeBody"

    public static class annotationTypeElementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:932:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MViewParser.annotationTypeElementDeclaration_return retval = new MViewParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotationTypeElementRest_return annotationTypeElementRest146 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:933:5: ( annotationTypeElementRest )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:933:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2637);
            annotationTypeElementRest146=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest146.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 74, annotationTypeElementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementDeclaration"

    public static class annotationTypeElementRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementRest"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:936:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MViewParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MViewParser.annotationTypeElementRest_return retval = new MViewParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal149=null;
        Token char_literal151=null;
        MViewParser.type_return type147 = null;

        MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest148 = null;

        MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration150 = null;


        Object char_literal149_tree=null;
        Object char_literal151_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:937:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==Identifier||(LA58_0>=60 && LA58_0<=67)) ) {
                alt58=1;
            }
            else if ( (LA58_0==73) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:937:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2660);
                    type147=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type147.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2662);
                    annotationMethodOrConstantRest148=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest148.getTree());
                    char_literal149=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2664); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal149_tree = (Object)adaptor.create(char_literal149);
                    adaptor.addChild(root_0, char_literal149_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:938:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2674);
                    annotationTypeDeclaration150=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration150.getTree());
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:938:35: ( ';' )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==26) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: ';'
                            {
                            char_literal151=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2676); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal151_tree = (Object)adaptor.create(char_literal151);
                            adaptor.addChild(root_0, char_literal151_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 75, annotationTypeElementRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementRest"

    public static class annotationMethodOrConstantRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodOrConstantRest"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:941:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MViewParser.annotationMethodOrConstantRest_return retval = new MViewParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotationMethodRest_return annotationMethodRest152 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:942:5: ( annotationMethodRest )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:942:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2700);
            annotationMethodRest152=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest152.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 76, annotationMethodOrConstantRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodOrConstantRest"

    public static class annotationMethodRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodRest"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:945:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MViewParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MViewParser.annotationMethodRest_return retval = new MViewParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier153=null;
        Token char_literal154=null;
        Token char_literal155=null;
        MViewParser.defaultValue_return defaultValue156 = null;


        Object Identifier153_tree=null;
        Object char_literal154_tree=null;
        Object char_literal155_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:946:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:946:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier153=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2723); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier153_tree = (Object)adaptor.create(Identifier153);
            adaptor.addChild(root_0, Identifier153_tree);
            }
            char_literal154=(Token)match(input,27,FOLLOW_27_in_annotationMethodRest2725); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal154_tree = (Object)adaptor.create(char_literal154);
            adaptor.addChild(root_0, char_literal154_tree);
            }
            char_literal155=(Token)match(input,28,FOLLOW_28_in_annotationMethodRest2727); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal155_tree = (Object)adaptor.create(char_literal155);
            adaptor.addChild(root_0, char_literal155_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:946:28: ( defaultValue )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==75) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest2729);
                    defaultValue156=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue156.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 77, annotationMethodRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodRest"

    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultValue"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:949:1: defaultValue : 'default' elementValue ;
    public final MViewParser.defaultValue_return defaultValue() throws RecognitionException {
        MViewParser.defaultValue_return retval = new MViewParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal157=null;
        MViewParser.elementValue_return elementValue158 = null;


        Object string_literal157_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:950:5: ( 'default' elementValue )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:950:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();

            string_literal157=(Token)match(input,75,FOLLOW_75_in_defaultValue2757); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal157_tree = (Object)adaptor.create(string_literal157);
            adaptor.addChild(root_0, string_literal157_tree);
            }
            pushFollow(FOLLOW_elementValue_in_defaultValue2759);
            elementValue158=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue158.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 78, defaultValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit89 = new BitSet(new long[]{0x000080C040800002L});
    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit102 = new BitSet(new long[]{0x000080C040800002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_compilationUnit117 = new BitSet(new long[]{0x000080C040800002L});
    public static final BitSet FOLLOW_applicationDeclaration_in_compilationUnit130 = new BitSet(new long[]{0x000080C040800002L});
    public static final BitSet FOLLOW_deploymentDeclaration_in_compilationUnit143 = new BitSet(new long[]{0x000080C040800002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration173 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration177 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_interfaceBody197 = new BitSet(new long[]{0xF200000002000010L,0x000000000000000FL});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody199 = new BitSet(new long[]{0xF200000002000010L,0x000000000000000FL});
    public static final BitSet FOLLOW_25_in_interfaceBody203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration219 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceBodyDeclaration221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_serviceReferenceDeclaration247 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_actualParameters_in_serviceReferenceDeclaration251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_actualParameters278 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameters283 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_actualParameters289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_actualParameterDecls314 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_actualParameterDecls317 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameterDecls321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceHeaderDeclaration374 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_serviceHeaderDeclaration378 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceHeaderDeclaration382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_formalParameters452 = new BitSet(new long[]{0xF200000010000010L,0x000000000000000FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters457 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_formalParameters463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls488 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls492 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_formalParameterDecls495 = new BitSet(new long[]{0xF200000000000010L,0x000000000000000FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureDecl533 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureDecl537 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_pointcutServiceSignatureParameters562 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters565 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_pointcutServiceSignatureParameters571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls585 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls589 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutServiceSignatureParameterDecls592 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_connectorDeclaration674 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration678 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_connectorDeclaration685 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorBody704 = new BitSet(new long[]{0x0000200082000000L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody706 = new BitSet(new long[]{0x0000200082000000L});
    public static final BitSet FOLLOW_25_in_connectorBody710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_connectorAOCompositionDeclaration753 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorAOCompositionDeclaration757 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_connectorAOCompositionDeclaration764 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorAOCompositionBody784 = new BitSet(new long[]{0x0000040102000000L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody791 = new BitSet(new long[]{0x0000040002000000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_connectorAOCompositionBody800 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_connectorAOCompositionBody807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_pointcutDeclaration824 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutBody844 = new BitSet(new long[]{0x00C0003A02000000L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody846 = new BitSet(new long[]{0x00C0003A02000000L});
    public static final BitSet FOLLOW_25_in_pointcutBody850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pointcutKindDeclaration893 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutKindDeclaration895 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_joinPointKind_in_pointcutKindDeclaration899 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutKindDeclaration901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration920 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutSignatureDeclaration926 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutSignatureDeclaration928 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration932 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutSignatureDeclaration936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls972 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutSignatureBodyDecls976 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_pointcutActorDeclaration1000 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_pointcutActorDeclaration1015 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutActorBody1046 = new BitSet(new long[]{0x00C003C002800000L});
    public static final BitSet FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1048 = new BitSet(new long[]{0x00C003C002800000L});
    public static final BitSet FOLLOW_25_in_pointcutActorBody1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1073 = new BitSet(new long[]{0x000003C000800000L});
    public static final BitSet FOLLOW_23_in_pointcutActorBodyDecls1082 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutActorBodyDecls1084 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_38_in_pointcutActorBodyDecls1094 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutActorBodyDecls1096 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_39_in_pointcutActorBodyDecls1105 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutActorBodyDecls1107 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_40_in_pointcutActorBodyDecls1116 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutActorBodyDecls1118 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_41_in_pointcutActorBodyDecls1127 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutActorBodyDecls1129 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1139 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutActorBodyDecls1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negation_in_pointcutActorPropDecls1159 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1165 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutActorPropDecls1170 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutActorPropDecl1197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_adviceDeclaration1220 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_adviceBody1237 = new BitSet(new long[]{0x0000180002000000L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody1239 = new BitSet(new long[]{0x0000180002000000L});
    public static final BitSet FOLLOW_25_in_adviceBody1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_adviceServiceDeclaration1278 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceServiceDeclaration1280 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1284 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceServiceDeclaration1286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_adviceTypeDeclaration1303 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceTypeDeclaration1305 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration1309 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceTypeDeclaration1311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_componentDeclaration1338 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration1342 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_componentBody1368 = new BitSet(new long[]{0x0000600082000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody1370 = new BitSet(new long[]{0x0000600082000000L});
    public static final BitSet FOLLOW_25_in_componentBody1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_moduleDependencyBody1426 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1431 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_moduleDependencyBody1439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_moduleRequireDependencyDeclaration1456 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_moduleProvideDependencyDeclaration1475 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_applicationDeclaration1511 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_applicationDeclaration1515 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_applicationDeclaration1522 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_applicationBody_in_applicationDeclaration1527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_applicationBody1541 = new BitSet(new long[]{0x0000024042000010L});
    public static final BitSet FOLLOW_applicationBodyDeclaration_in_applicationBody1545 = new BitSet(new long[]{0x0000024042000010L});
    public static final BitSet FOLLOW_25_in_applicationBody1551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hostDeclaration_in_applicationBodyDeclaration1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_deploymentDeclaration1615 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_deploymentDeclaration1619 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_deploymentDeclaration1626 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_applicationBody_in_deploymentDeclaration1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1656 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1660 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_instanceDeclaration1664 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1668 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_instanceDeclaration1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_hostDeclaration1697 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_hostDeclaration1701 = new BitSet(new long[]{0x0001000004000000L});
    public static final BitSet FOLLOW_48_in_hostDeclaration1709 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_StringLiteral_in_hostDeclaration1713 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_hostDeclaration1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_componentDeclaration_in_moduleContainerDeclarations1746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_refinementDeclaration1782 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_refinementRelationDeclarations_in_refinementDeclaration1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_refinementRelationDeclarations1803 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_refinementRelationDeclarations1807 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_refinementRelationDeclarations_in_refinementRelationDeclarations1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls1842 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_commaSeparatedBodyDecls1845 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_adviceType1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_adviceType1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_adviceType1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_joinPointKind1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_joinPointKind1920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_overrideOrExtend1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_overrideOrExtend1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_negation1967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_voidType1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_wildcardType2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type2043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2068 = new BitSet(new long[]{0x0800000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2087 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_classOrInterfaceType2101 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2105 = new BitSet(new long[]{0x0800000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2132 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_60_in_primitiveType2157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_primitiveType2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_primitiveType2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_primitiveType2205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_primitiveType2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_primitiveType2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_primitiveType2241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_typeArguments2264 = new BitSet(new long[]{0xF200000000000010L,0x000000000000004FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2266 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_29_in_typeArguments2270 = new BitSet(new long[]{0xF200000000000010L,0x000000000000004FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2272 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_typeArguments2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_typeArgument2308 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_set_in_typeArgument2313 = new BitSet(new long[]{0xF200000000000010L,0x000000000000000FL});
    public static final BitSet FOLLOW_type_in_typeArgument2323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations2353 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_annotation2373 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation2375 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_annotation2379 = new BitSet(new long[]{0x0000000011000010L,0x0000000000000200L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation2383 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation2387 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotation2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2416 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_annotationName2419 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2421 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2442 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_elementValuePairs2445 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2447 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair2468 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_elementValuePair2470 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair2472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue2495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_elementValueArrayInitializer2528 = new BitSet(new long[]{0x0000000023000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2531 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2534 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2536 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2543 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elementValueArrayInitializer2547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_annotationTypeDeclaration2574 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration2576 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration2580 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeBody2605 = new BitSet(new long[]{0xF200000002000010L,0x000000000000020FL});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2608 = new BitSet(new long[]{0xF200000002000010L,0x000000000000020FL});
    public static final BitSet FOLLOW_25_in_annotationTypeBody2612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2660 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2662 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2674 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2723 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_annotationMethodRest2725 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotationMethodRest2727 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_defaultValue2757 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2759 = new BitSet(new long[]{0x0000000000000002L});

}
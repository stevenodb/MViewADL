// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g 2010-12-08 16:05:17

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "StringLiteral", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "'{'", "'}'", "';'", "'('", "')'", "','", "'connector'", "'ao-composition'", "'pointcut'", "'kind'", "':'", "'signature'", "'caller'", "'callee'", "'component'", "'application'", "'instance'", "'host'", "'advice'", "'service'", "'type'", "'require'", "'provide'", "'on'", "'before'", "'after'", "'around'", "'execution'", "'call'", "'override'", "'extend'", "'void'", "'*'", "'.'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'<'", "'>'", "'?'", "'extends'", "'super'", "'@'", "'='", "'default'"
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
            this.state.ruleMemo = new HashMap[150+1];
             
             
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:94:1: compilationUnit returns [CompilationUnit element] : (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )* ;
    public final MViewParser.compilationUnit_return compilationUnit() throws RecognitionException {
        MViewParser.compilationUnit_return retval = new MViewParser.compilationUnit_return();
        retval.start = input.LT(1);
        int compilationUnit_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.interfaceDeclaration_return ifd = null;

        MViewParser.componentDeclaration_return cod = null;

        MViewParser.connectorDeclaration_return cnd = null;

        MViewParser.applicationDeclaration_return apd = null;



         
        	retval.element = getCompilationUnit();
        	NamespacePart npp = new NamespacePart(language().defaultNamespace());
        	retval.element.add(npp);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:100:2: ( (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:100:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:100:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )*
            loop1:
            do {
                int alt1=5;
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

                }

                switch (alt1) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:101:4: ifd= interfaceDeclaration
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
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:103:4: cod= componentDeclaration
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
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:107:4: cnd= connectorDeclaration
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
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:109:4: apd= applicationDeclaration
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:122:1: interfaceDeclaration returns [Interface element] : intkw= 'interface' name= Identifier interfaceBody[$element] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:123:2: (intkw= 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:123:4: intkw= 'interface' name= Identifier interfaceBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            intkw=(Token)match(input,23,FOLLOW_23_in_interfaceDeclaration162); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            intkw_tree = (Object)adaptor.create(intkw);
            adaptor.addChild(root_0, intkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration166); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Interface(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,intkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration172);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:132:1: interfaceBody[Interface element] : '{' ( interfaceBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:133:2: ( '{' ( interfaceBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:133:4: '{' ( interfaceBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal2=(Token)match(input,24,FOLLOW_24_in_interfaceBody186); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:133:8: ( interfaceBodyDeclaration[$element] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||LA2_0==55||(LA2_0>=58 && LA2_0<=65)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: interfaceBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody188);
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

            char_literal4=(Token)match(input,25,FOLLOW_25_in_interfaceBody192); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:137:1: interfaceBodyDeclaration[Interface element] : (service= serviceDeclaration ';' ) ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:138:2: ( (service= serviceDeclaration ';' ) )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:138:4: (service= serviceDeclaration ';' )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:138:4: (service= serviceDeclaration ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:138:5: service= serviceDeclaration ';'
            {
            pushFollow(FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration208);
            service=serviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal5=(Token)match(input,26,FOLLOW_26_in_interfaceBodyDeclaration210); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:150:1: serviceReferenceDeclaration returns [SimpleReference<Service> relation] : name= Identifier params= actualParameters ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:151:2: (name= Identifier params= actualParameters )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:151:4: name= Identifier params= actualParameters
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceReferenceDeclaration236); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_actualParameters_in_serviceReferenceDeclaration240);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:158:1: actualParameters returns [List<String> lst] : '(' (pars= actualParameterDecls )? ')' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:160:5: ( '(' (pars= actualParameterDecls )? ')' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:160:9: '(' (pars= actualParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal6=(Token)match(input,27,FOLLOW_27_in_actualParameters267); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:160:13: (pars= actualParameterDecls )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Identifier) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:160:14: pars= actualParameterDecls
                    {
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameters272);
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

            char_literal7=(Token)match(input,28,FOLLOW_28_in_actualParameters278); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:163:1: actualParameterDecls returns [List<String> lst] : name= Identifier ( ',' decls= actualParameterDecls )? ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:164:5: (name= Identifier ( ',' decls= actualParameterDecls )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:164:9: name= Identifier ( ',' decls= actualParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_actualParameterDecls303); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:164:25: ( ',' decls= actualParameterDecls )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==29) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:164:26: ',' decls= actualParameterDecls
                    {
                    char_literal8=(Token)match(input,29,FOLLOW_29_in_actualParameterDecls306); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (Object)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);
                    }
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameterDecls310);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:180:1: serviceDeclaration returns [Service element] : result= serviceHeaderDeclaration ;
    public final MViewParser.serviceDeclaration_return serviceDeclaration() throws RecognitionException {
        MViewParser.serviceDeclaration_return retval = new MViewParser.serviceDeclaration_return();
        retval.start = input.LT(1);
        int serviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.serviceHeaderDeclaration_return result = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:181:2: (result= serviceHeaderDeclaration )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:181:4: result= serviceHeaderDeclaration
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration343);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:188:1: serviceHeaderDeclaration returns [String signature, TypeReference returnType, List<FormalParameter> parLst] : rtype= serviceReturnType name= Identifier params= formalParameters ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:189:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:189:4: rtype= serviceReturnType name= Identifier params= formalParameters
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceReturnType_in_serviceHeaderDeclaration363);
            rtype=serviceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceHeaderDeclaration367); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_formalParameters_in_serviceHeaderDeclaration371);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:196:1: serviceReturnType returns [TypeReference value] : (vt= voidType | tp= type ) ;
    public final MViewParser.serviceReturnType_return serviceReturnType() throws RecognitionException {
        MViewParser.serviceReturnType_return retval = new MViewParser.serviceReturnType_return();
        retval.start = input.LT(1);
        int serviceReturnType_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.voidType_return vt = null;

        MViewParser.type_return tp = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:197:2: ( (vt= voidType | tp= type ) )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:197:4: (vt= voidType | tp= type )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:197:4: (vt= voidType | tp= type )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==55) ) {
                alt5=1;
            }
            else if ( (LA5_0==Identifier||(LA5_0>=58 && LA5_0<=65)) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:198:4: vt= voidType
                    {
                    pushFollow(FOLLOW_voidType_in_serviceReturnType396);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:200:4: tp= type
                    {
                    pushFollow(FOLLOW_type_in_serviceReturnType410);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:204:1: formalParameters returns [List<FormalParameter> lst] : '(' (pars= formalParameterDecls )? ')' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:206:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:206:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal9=(Token)match(input,27,FOLLOW_27_in_formalParameters441); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal9_tree = (Object)adaptor.create(char_literal9);
            adaptor.addChild(root_0, char_literal9_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:206:13: (pars= formalParameterDecls )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Identifier||(LA6_0>=58 && LA6_0<=65)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:206:14: pars= formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters446);
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

            char_literal10=(Token)match(input,28,FOLLOW_28_in_formalParameters452); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:209:1: formalParameterDecls returns [List<FormalParameter> lst] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:210:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:210:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_type_in_formalParameterDecls477);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls481); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:210:32: ( ',' decls= formalParameterDecls )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==29) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:210:33: ',' decls= formalParameterDecls
                    {
                    char_literal11=(Token)match(input,29,FOLLOW_29_in_formalParameterDecls484); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal11_tree = (Object)adaptor.create(char_literal11);
                    adaptor.addChild(root_0, char_literal11_tree);
                    }
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls488);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:231:1: pointcutServiceSignatureDecl returns [ServiceSignature element] : rtype= Identifier sig= Identifier pars= pointcutServiceSignatureParameters ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:232:2: (rtype= Identifier sig= Identifier pars= pointcutServiceSignatureParameters )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:232:4: rtype= Identifier sig= Identifier pars= pointcutServiceSignatureParameters
            {
            root_0 = (Object)adaptor.nil();

            rtype=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureDecl522); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rtype_tree = (Object)adaptor.create(rtype);
            adaptor.addChild(root_0, rtype_tree);
            }
            sig=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureDecl526); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            sig_tree = (Object)adaptor.create(sig);
            adaptor.addChild(root_0, sig_tree);
            }
            pushFollow(FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl530);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:237:1: pointcutServiceSignatureParameters returns [List<Pair<String,String>> lst] : '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:239:2: ( '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:239:4: '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal12=(Token)match(input,27,FOLLOW_27_in_pointcutServiceSignatureParameters551); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:239:8: ( pointcutServiceSignatureParameterDecls[$lst] )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Identifier) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:239:9: pointcutServiceSignatureParameterDecls[$lst]
                    {
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters554);
                    pointcutServiceSignatureParameterDecls13=pointcutServiceSignatureParameterDecls(retval.lst);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutServiceSignatureParameterDecls13.getTree());

                    }
                    break;

            }

            char_literal14=(Token)match(input,28,FOLLOW_28_in_pointcutServiceSignatureParameters560); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:242:1: pointcutServiceSignatureParameterDecls[List<Pair<String,String>> lst] : t= Identifier name= Identifier ( ',' pointcutServiceSignatureParameterDecls[$lst] )? ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:243:2: (t= Identifier name= Identifier ( ',' pointcutServiceSignatureParameterDecls[$lst] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:243:4: t= Identifier name= Identifier ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (Object)adaptor.create(t);
            adaptor.addChild(root_0, t_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls578); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:243:33: ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==29) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:243:34: ',' pointcutServiceSignatureParameterDecls[$lst]
                    {
                    char_literal15=(Token)match(input,29,FOLLOW_29_in_pointcutServiceSignatureParameterDecls581); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    adaptor.addChild(root_0, char_literal15_tree);
                    }
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls583);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:302:1: connectorDeclaration returns [Connector element] : conkw= 'connector' name= Identifier refinementDeclaration[$element] connectorBody[$element] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:303:2: (conkw= 'connector' name= Identifier refinementDeclaration[$element] connectorBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:303:4: conkw= 'connector' name= Identifier refinementDeclaration[$element] connectorBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            conkw=(Token)match(input,30,FOLLOW_30_in_connectorDeclaration663); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            conkw_tree = (Object)adaptor.create(conkw);
            adaptor.addChild(root_0, conkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration667); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Connector(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,conkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_refinementDeclaration_in_connectorDeclaration674);
            refinementDeclaration17=refinementDeclaration(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration17.getTree());
            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration679);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:313:1: connectorBody[Connector element] : '{' ( connectorBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:314:2: ( '{' ( connectorBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:314:4: '{' ( connectorBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal19=(Token)match(input,24,FOLLOW_24_in_connectorBody693); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:314:8: ( connectorBodyDeclaration[$element] )*
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
            	    pushFollow(FOLLOW_connectorBodyDeclaration_in_connectorBody695);
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

            char_literal21=(Token)match(input,25,FOLLOW_25_in_connectorBody699); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:318:1: connectorBodyDeclaration[Connector element] : (aoc= connectorAOCompositionDeclaration | moduleRequireDependencyDeclaration[$element] );
    public final MViewParser.connectorBodyDeclaration_return connectorBodyDeclaration(Connector element) throws RecognitionException {
        MViewParser.connectorBodyDeclaration_return retval = new MViewParser.connectorBodyDeclaration_return();
        retval.start = input.LT(1);
        int connectorBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.connectorAOCompositionDeclaration_return aoc = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration22 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:319:2: (aoc= connectorAOCompositionDeclaration | moduleRequireDependencyDeclaration[$element] )
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:319:4: aoc= connectorAOCompositionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration714);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:322:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration721);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:326:1: connectorAOCompositionDeclaration returns [AOComposition element] : kw= 'ao-composition' name= Identifier refinementDeclaration[$element] connectorAOCompositionBody[$element] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:327:2: (kw= 'ao-composition' name= Identifier refinementDeclaration[$element] connectorAOCompositionBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:327:4: kw= 'ao-composition' name= Identifier refinementDeclaration[$element] connectorAOCompositionBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            kw=(Token)match(input,31,FOLLOW_31_in_connectorAOCompositionDeclaration742); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kw_tree = (Object)adaptor.create(kw);
            adaptor.addChild(root_0, kw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorAOCompositionDeclaration746); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new AOComposition(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,kw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_refinementDeclaration_in_connectorAOCompositionDeclaration753);
            refinementDeclaration23=refinementDeclaration(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration23.getTree());
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:337:1: connectorAOCompositionBody[AOComposition element] : '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:338:2: ( '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:338:4: '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal25=(Token)match(input,24,FOLLOW_24_in_connectorAOCompositionBody773); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:339:5: (pc= pointcutDeclaration )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==32) ) {
                alt12=1;
            }
            switch (alt12) {
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:342:6: (adv= adviceDeclaration )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==42) ) {
                alt13=1;
            }
            switch (alt13) {
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:348:1: pointcutDeclaration returns [Pointcut pointcut] : pckw= 'pointcut' pointcutBody[$pointcut] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:349:2: (pckw= 'pointcut' pointcutBody[$pointcut] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:349:4: pckw= 'pointcut' pointcutBody[$pointcut]
            {
            root_0 = (Object)adaptor.nil();

            pckw=(Token)match(input,32,FOLLOW_32_in_pointcutDeclaration813); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:356:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:357:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:357:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal28=(Token)match(input,24,FOLLOW_24_in_pointcutBody833); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:357:8: ( pointcutBodyDeclaration[$pointcut] )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==33||(LA14_0>=35 && LA14_0<=37)||(LA14_0>=53 && LA14_0<=54)) ) {
                    alt14=1;
                }


                switch (alt14) {
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
            	    break loop14;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:361:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] );
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:362:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt15=1;
                }
                break;
            case 35:
            case 53:
            case 54:
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:362:4: pointcutKindDeclaration[$pointcut]
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:363:4: pointcutSignatureDeclaration[$pointcut]
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:364:4: pointcutActorDeclaration[$pointcut]
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:368:1: pointcutKindDeclaration[Pointcut pointcut] : kikw= 'kind' ':' kind= joinPointKind ';' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:369:2: (kikw= 'kind' ':' kind= joinPointKind ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:369:4: kikw= 'kind' ':' kind= joinPointKind ';'
            {
            root_0 = (Object)adaptor.nil();

            kikw=(Token)match(input,33,FOLLOW_33_in_pointcutKindDeclaration882); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kikw_tree = (Object)adaptor.create(kikw);
            adaptor.addChild(root_0, kikw_tree);
            }
            char_literal34=(Token)match(input,34,FOLLOW_34_in_pointcutKindDeclaration884); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:376:1: pointcutSignatureDeclaration[Pointcut element] : (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:377:2: ( (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:377:4: (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:377:4: (override= overrideOrExtend )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=53 && LA16_0<=54)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:377:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration909);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

            sikw=(Token)match(input,35,FOLLOW_35_in_pointcutSignatureDeclaration915); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            sikw_tree = (Object)adaptor.create(sikw);
            adaptor.addChild(root_0, sikw_tree);
            }
            char_literal36=(Token)match(input,34,FOLLOW_34_in_pointcutSignatureDeclaration917); if (state.failed) return retval;
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
              			if ((override!=null?override.value:null) != null) {
              				pcsig.addModifier((override!=null?override.value:null));
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:387:1: pointcutSignatureBody returns [PointcutSignature element] : pointcutSignatureBodyDecls[$element] ;
    public final MViewParser.pointcutSignatureBody_return pointcutSignatureBody() throws RecognitionException {
        MViewParser.pointcutSignatureBody_return retval = new MViewParser.pointcutSignatureBody_return();
        retval.start = input.LT(1);
        int pointcutSignatureBody_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls38 = null;



         retval.element = new PointcutSignature(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:389:2: ( pointcutSignatureBodyDecls[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:389:4: pointcutSignatureBodyDecls[$element]
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:393:1: pointcutSignatureBodyDecls[PointcutSignature element] : pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:394:2: (pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:394:4: pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls961);
            pss=pointcutServiceSignatureDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pss.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:394:37: ( ',' pointcutSignatureBodyDecls[$element] )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:394:39: ',' pointcutSignatureBodyDecls[$element]
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:400:1: pointcutActorDeclaration[Pointcut pointcut] : (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody );
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:401:2: (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody )
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:401:4: clkw= 'caller' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();

                    clkw=(Token)match(input,36,FOLLOW_36_in_pointcutActorDeclaration989); if (state.failed) return retval;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:406:3: clkw= 'callee' actor= pointcutActorBody
                    {
                    root_0 = (Object)adaptor.nil();

                    clkw=(Token)match(input,37,FOLLOW_37_in_pointcutActorDeclaration1004); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:416:1: pointcutActorBody returns [Actor element] : '{' ( pointcutActorBodyDecls[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:420:2: ( '{' ( pointcutActorBodyDecls[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:420:4: '{' ( pointcutActorBodyDecls[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal41=(Token)match(input,24,FOLLOW_24_in_pointcutActorBody1035); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = (Object)adaptor.create(char_literal41);
            adaptor.addChild(root_0, char_literal41_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:420:8: ( pointcutActorBodyDecls[$element] )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==23||(LA19_0>=38 && LA19_0<=41)||(LA19_0>=53 && LA19_0<=54)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: pointcutActorBodyDecls[$element]
            	    {
            	    pushFollow(FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1037);
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

            char_literal43=(Token)match(input,25,FOLLOW_25_in_pointcutActorBody1041); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:424:1: pointcutActorBodyDecls[Actor actor] : (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:429:2: ( (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:429:4: (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:429:4: (override= overrideOrExtend )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=53 && LA20_0<=54)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:429:5: override= overrideOrExtend
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1062);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:430:2: ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' )
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:431:3: 'interface' ':'
                    {
                    string_literal44=(Token)match(input,23,FOLLOW_23_in_pointcutActorBodyDecls1071); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal44_tree = (Object)adaptor.create(string_literal44);
                    adaptor.addChild(root_0, string_literal44_tree);
                    }
                    char_literal45=(Token)match(input,34,FOLLOW_34_in_pointcutActorBodyDecls1073); if (state.failed) return retval;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:435:3: 'component' ':'
                    {
                    string_literal46=(Token)match(input,38,FOLLOW_38_in_pointcutActorBodyDecls1083); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal46_tree = (Object)adaptor.create(string_literal46);
                    adaptor.addChild(root_0, string_literal46_tree);
                    }
                    char_literal47=(Token)match(input,34,FOLLOW_34_in_pointcutActorBodyDecls1085); if (state.failed) return retval;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:439:3: 'application' ':'
                    {
                    string_literal48=(Token)match(input,39,FOLLOW_39_in_pointcutActorBodyDecls1094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal48_tree = (Object)adaptor.create(string_literal48);
                    adaptor.addChild(root_0, string_literal48_tree);
                    }
                    char_literal49=(Token)match(input,34,FOLLOW_34_in_pointcutActorBodyDecls1096); if (state.failed) return retval;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:443:3: 'instance' ':'
                    {
                    string_literal50=(Token)match(input,40,FOLLOW_40_in_pointcutActorBodyDecls1105); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal50_tree = (Object)adaptor.create(string_literal50);
                    adaptor.addChild(root_0, string_literal50_tree);
                    }
                    char_literal51=(Token)match(input,34,FOLLOW_34_in_pointcutActorBodyDecls1107); if (state.failed) return retval;
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:447:3: 'host' ':'
                    {
                    string_literal52=(Token)match(input,41,FOLLOW_41_in_pointcutActorBodyDecls1116); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal52_tree = (Object)adaptor.create(string_literal52);
                    adaptor.addChild(root_0, string_literal52_tree);
                    }
                    char_literal53=(Token)match(input,34,FOLLOW_34_in_pointcutActorBodyDecls1118); if (state.failed) return retval;
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
              		if (override != null) {prop.addModifier((override!=null?override.value:null));}
              	
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:458:1: pointcutActorPropDecls[ActorProp prop,Class<? extends Declaration> declClass] : apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? ;
    public final MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls(ActorProp prop, Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecls_return retval = new MViewParser.pointcutActorPropDecls_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecls_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal56=null;
        MViewParser.pointcutActorPropDecl_return apdref = null;

        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls57 = null;


        Object char_literal56_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:459:2: (apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:459:5: apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1147);
            apdref=pointcutActorPropDecl(declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, apdref.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:459:46: ( ',' pointcutActorPropDecls[$prop,$declClass] )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==29) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:459:48: ',' pointcutActorPropDecls[$prop,$declClass]
                    {
                    char_literal56=(Token)match(input,29,FOLLOW_29_in_pointcutActorPropDecls1152); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal56_tree = (Object)adaptor.create(char_literal56);
                    adaptor.addChild(root_0, char_literal56_tree);
                    }
                    pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1154);
                    pointcutActorPropDecls57=pointcutActorPropDecls(prop, declClass);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls57.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			prop.addPropValue((apdref!=null?apdref.relation:null));
              		
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:464:1: pointcutActorPropDecl[Class<? extends Declaration> declClass] returns [SimpleReference<? extends Declaration> relation] : name= Identifier ;
    public final MViewParser.pointcutActorPropDecl_return pointcutActorPropDecl(Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecl_return retval = new MViewParser.pointcutActorPropDecl_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecl_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;

        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:465:2: (name= Identifier )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:465:5: name= Identifier
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutActorPropDecl1179); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:473:1: adviceDeclaration returns [Advice advice] : avkw= 'advice' adviceBody[$advice] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:474:2: (avkw= 'advice' adviceBody[$advice] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:474:4: avkw= 'advice' adviceBody[$advice]
            {
            root_0 = (Object)adaptor.nil();

            avkw=(Token)match(input,42,FOLLOW_42_in_adviceDeclaration1202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            avkw_tree = (Object)adaptor.create(avkw);
            adaptor.addChild(root_0, avkw_tree);
            }
            if ( state.backtracking==0 ) {
               
              				retval.advice = new Advice();
              				setKeyword(retval.advice,avkw);
              //				System.out.println("construct advice "+retval.advice);				
              			
            }
            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration1206);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:481:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:482:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:482:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal59=(Token)match(input,24,FOLLOW_24_in_adviceBody1219); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal59_tree = (Object)adaptor.create(char_literal59);
            adaptor.addChild(root_0, char_literal59_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:482:8: ( adviceBodyDeclaration[$advice] )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=43 && LA23_0<=44)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: adviceBodyDeclaration[$advice]
            	    {
            	    pushFollow(FOLLOW_adviceBodyDeclaration_in_adviceBody1221);
            	    adviceBodyDeclaration60=adviceBodyDeclaration(advice);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBodyDeclaration60.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            char_literal61=(Token)match(input,25,FOLLOW_25_in_adviceBody1225); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:485:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] );
    public final MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceBodyDeclaration_return retval = new MViewParser.adviceBodyDeclaration_return();
        retval.start = input.LT(1);
        int adviceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration62 = null;

        MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration63 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:486:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==43) ) {
                alt24=1;
            }
            else if ( (LA24_0==44) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:486:4: adviceServiceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1238);
                    adviceServiceDeclaration62=adviceServiceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceServiceDeclaration62.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:487:4: adviceTypeDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1244);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:490:1: adviceServiceDeclaration[Advice advice] : svkw= 'service' ':' service= serviceReferenceDeclaration ';' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:491:2: (svkw= 'service' ':' service= serviceReferenceDeclaration ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:491:4: svkw= 'service' ':' service= serviceReferenceDeclaration ';'
            {
            root_0 = (Object)adaptor.nil();

            svkw=(Token)match(input,43,FOLLOW_43_in_adviceServiceDeclaration1260); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            svkw_tree = (Object)adaptor.create(svkw);
            adaptor.addChild(root_0, svkw_tree);
            }
            char_literal64=(Token)match(input,34,FOLLOW_34_in_adviceServiceDeclaration1262); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
            }
            pushFollow(FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1266);
            service=serviceReferenceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal65=(Token)match(input,26,FOLLOW_26_in_adviceServiceDeclaration1268); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:497:1: adviceTypeDeclaration[Advice advice] : tpkw= 'type' ':' avtype= adviceType ';' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:498:2: (tpkw= 'type' ':' avtype= adviceType ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:498:4: tpkw= 'type' ':' avtype= adviceType ';'
            {
            root_0 = (Object)adaptor.nil();

            tpkw=(Token)match(input,44,FOLLOW_44_in_adviceTypeDeclaration1285); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tpkw_tree = (Object)adaptor.create(tpkw);
            adaptor.addChild(root_0, tpkw_tree);
            }
            char_literal66=(Token)match(input,34,FOLLOW_34_in_adviceTypeDeclaration1287); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal66_tree = (Object)adaptor.create(char_literal66);
            adaptor.addChild(root_0, char_literal66_tree);
            }
            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration1291);
            avtype=adviceType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, avtype.getTree());
            char_literal67=(Token)match(input,26,FOLLOW_26_in_adviceTypeDeclaration1293); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:510:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier componentBody[$element] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:511:2: (compkw= 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:511:5: compkw= 'component' name= Identifier componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            compkw=(Token)match(input,38,FOLLOW_38_in_componentDeclaration1320); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            compkw_tree = (Object)adaptor.create(compkw);
            adaptor.addChild(root_0, compkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration1324); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                  			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                  			setKeyword(retval.element,compkw);
                  			setLocation(retval.element,name,"__NAME");
              			
            }
            pushFollow(FOLLOW_componentBody_in_componentDeclaration1328);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:519:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:520:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:520:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal69=(Token)match(input,24,FOLLOW_24_in_componentBody1350); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal69_tree = (Object)adaptor.create(char_literal69);
            adaptor.addChild(root_0, char_literal69_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:520:8: ( componentBodyDeclaration[$element] )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=45 && LA25_0<=46)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody1352);
            	    componentBodyDeclaration70=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration70.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            char_literal71=(Token)match(input,25,FOLLOW_25_in_componentBody1356); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:524:1: componentBodyDeclaration[Component element] : ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] );
    public final MViewParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MViewParser.componentBodyDeclaration_return retval = new MViewParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);
        int componentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration72 = null;

        MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration73 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:525:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==45) ) {
                alt26=1;
            }
            else if ( (LA26_0==46) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:525:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1374);
                    moduleRequireDependencyDeclaration72=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration72.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:526:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1380);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:539:1: moduleDependencyBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:541:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:541:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal74=(Token)match(input,24,FOLLOW_24_in_moduleDependencyBody1411); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal74_tree = (Object)adaptor.create(char_literal74);
            adaptor.addChild(root_0, char_literal74_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:541:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Identifier) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:541:9: decls= commaSeparatedBodyDecls[Interface.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1416);
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

            char_literal75=(Token)match(input,25,FOLLOW_25_in_moduleDependencyBody1424); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:545:1: moduleRequireDependencyDeclaration[Module element] : rekw= 'require' rd= moduleDependencyBody ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:546:2: (rekw= 'require' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:546:4: rekw= 'require' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            rekw=(Token)match(input,45,FOLLOW_45_in_moduleRequireDependencyDeclaration1441); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rekw_tree = (Object)adaptor.create(rekw);
            adaptor.addChild(root_0, rekw_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1445);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:554:1: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:555:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:555:4: 'provide' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal76=(Token)match(input,46,FOLLOW_46_in_moduleProvideDependencyDeclaration1460); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal76_tree = (Object)adaptor.create(string_literal76);
            adaptor.addChild(root_0, string_literal76_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1464);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:595:1: applicationDeclaration returns [Application element] : appkw= 'application' name= Identifier refinementDeclaration[$element] applicationBody[$element] ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:596:2: (appkw= 'application' name= Identifier refinementDeclaration[$element] applicationBody[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:596:4: appkw= 'application' name= Identifier refinementDeclaration[$element] applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            appkw=(Token)match(input,39,FOLLOW_39_in_applicationDeclaration1497); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_applicationDeclaration1501); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Application(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,appkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_refinementDeclaration_in_applicationDeclaration1508);
            refinementDeclaration77=refinementDeclaration(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration77.getTree());
            pushFollow(FOLLOW_applicationBody_in_applicationDeclaration1513);
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:606:1: applicationBody[Application element] : '{' ( applicationBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:607:2: ( '{' ( applicationBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:607:4: '{' ( applicationBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal79=(Token)match(input,24,FOLLOW_24_in_applicationBody1527); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal79_tree = (Object)adaptor.create(char_literal79);
            adaptor.addChild(root_0, char_literal79_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:607:8: ( applicationBodyDeclaration[$element] )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==Identifier||LA28_0==30||LA28_0==38||LA28_0==41) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:607:10: applicationBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_applicationBodyDeclaration_in_applicationBody1531);
            	    applicationBodyDeclaration80=applicationBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBodyDeclaration80.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            char_literal81=(Token)match(input,25,FOLLOW_25_in_applicationBody1537); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:611:1: applicationBodyDeclaration[Application element] : (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration );
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
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:612:2: (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 30:
            case 38:
                {
                alt29=1;
                }
                break;
            case 41:
                {
                alt29=2;
                }
                break;
            case Identifier:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:612:4: mod= moduleContainerDeclarations
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1553);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:616:3: hod= hostDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hostDeclaration_in_applicationBodyDeclaration1564);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:620:3: ind= instanceDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1576);
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

    public static class instanceDeclaration_return extends ParserRuleReturnScope {
        public Instance element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instanceDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:678:1: instanceDeclaration returns [Instance element] : tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';' ;
    public final MViewParser.instanceDeclaration_return instanceDeclaration() throws RecognitionException {
        MViewParser.instanceDeclaration_return retval = new MViewParser.instanceDeclaration_return();
        retval.start = input.LT(1);
        int instanceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token tpe=null;
        Token name=null;
        Token onkw=null;
        Token hst=null;
        Token char_literal82=null;

        Object tpe_tree=null;
        Object name_tree=null;
        Object onkw_tree=null;
        Object hst_tree=null;
        Object char_literal82_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:679:2: (tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:679:4: tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';'
            {
            root_0 = (Object)adaptor.nil();

            tpe=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1608); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tpe_tree = (Object)adaptor.create(tpe);
            adaptor.addChild(root_0, tpe_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1612); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            onkw=(Token)match(input,47,FOLLOW_47_in_instanceDeclaration1616); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            onkw_tree = (Object)adaptor.create(onkw);
            adaptor.addChild(root_0, onkw_tree);
            }
            hst=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1620); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hst_tree = (Object)adaptor.create(hst);
            adaptor.addChild(root_0, hst_tree);
            }
            char_literal82=(Token)match(input,26,FOLLOW_26_in_instanceDeclaration1622); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal82_tree = (Object)adaptor.create(char_literal82);
            adaptor.addChild(root_0, char_literal82_tree);
            }
            if ( state.backtracking==0 ) {

              	
              			retval.element = new Instance(new SimpleNameSignature((name!=null?name.getText():null)));

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
            if ( state.backtracking>0 ) { memoize(input, 47, instanceDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:704:1: hostDeclaration returns [Host element] : hkw= 'host' name= Identifier (onkw= 'on' value= StringLiteral )? ';' ;
    public final MViewParser.hostDeclaration_return hostDeclaration() throws RecognitionException {
        MViewParser.hostDeclaration_return retval = new MViewParser.hostDeclaration_return();
        retval.start = input.LT(1);
        int hostDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token hkw=null;
        Token name=null;
        Token onkw=null;
        Token value=null;
        Token char_literal83=null;

        Object hkw_tree=null;
        Object name_tree=null;
        Object onkw_tree=null;
        Object value_tree=null;
        Object char_literal83_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:705:2: (hkw= 'host' name= Identifier (onkw= 'on' value= StringLiteral )? ';' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:705:5: hkw= 'host' name= Identifier (onkw= 'on' value= StringLiteral )? ';'
            {
            root_0 = (Object)adaptor.nil();

            hkw=(Token)match(input,41,FOLLOW_41_in_hostDeclaration1649); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            hkw_tree = (Object)adaptor.create(hkw);
            adaptor.addChild(root_0, hkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_hostDeclaration1653); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			
              			retval.element = new Host(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,hkw);
              			setLocation(retval.element,name,"__NAME");
              			
              		
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:711:5: (onkw= 'on' value= StringLiteral )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==47) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:711:7: onkw= 'on' value= StringLiteral
                    {
                    onkw=(Token)match(input,47,FOLLOW_47_in_hostDeclaration1661); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    onkw_tree = (Object)adaptor.create(onkw);
                    adaptor.addChild(root_0, onkw_tree);
                    }
                    value=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_hostDeclaration1665); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    value_tree = (Object)adaptor.create(value);
                    adaptor.addChild(root_0, value_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			
                      			HostName hostName = new HostName(new SimpleNameSignature((value!=null?value.getText():null)));
                      			SimpleReference<HostName> hostNameRelation = new SimpleReference<HostName>((value!=null?value.getText():null),HostName.class);
                      			retval.element.setHostName(hostNameRelation);
                      			setKeyword(hostNameRelation,onkw);
                      			
                      		
                    }

                    }
                    break;

            }

            char_literal83=(Token)match(input,26,FOLLOW_26_in_hostDeclaration1672); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal83_tree = (Object)adaptor.create(char_literal83);
            adaptor.addChild(root_0, char_literal83_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 48, hostDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:727:1: moduleContainerDeclarations returns [Module element] : (cod= componentDeclaration | cnd= connectorDeclaration );
    public final MViewParser.moduleContainerDeclarations_return moduleContainerDeclarations() throws RecognitionException {
        MViewParser.moduleContainerDeclarations_return retval = new MViewParser.moduleContainerDeclarations_return();
        retval.start = input.LT(1);
        int moduleContainerDeclarations_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.componentDeclaration_return cod = null;

        MViewParser.connectorDeclaration_return cnd = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:728:2: (cod= componentDeclaration | cnd= connectorDeclaration )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==38) ) {
                alt31=1;
            }
            else if ( (LA31_0==30) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:729:3: cod= componentDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_componentDeclaration_in_moduleContainerDeclarations1698);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:733:3: cnd= connectorDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1709);
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
            if ( state.backtracking>0 ) { memoize(input, 49, moduleContainerDeclarations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "moduleContainerDeclarations"

    public static class refinementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "refinementDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:759:1: refinementDeclaration[RefinableDeclaration element] : rfkw= ':' refinementRelationDeclarations[$element] ;
    public final MViewParser.refinementDeclaration_return refinementDeclaration(RefinableDeclaration element) throws RecognitionException {
        MViewParser.refinementDeclaration_return retval = new MViewParser.refinementDeclaration_return();
        retval.start = input.LT(1);
        int refinementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token rfkw=null;
        MViewParser.refinementRelationDeclarations_return refinementRelationDeclarations84 = null;


        Object rfkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:760:2: (rfkw= ':' refinementRelationDeclarations[$element] )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:760:4: rfkw= ':' refinementRelationDeclarations[$element]
            {
            root_0 = (Object)adaptor.nil();

            rfkw=(Token)match(input,34,FOLLOW_34_in_refinementDeclaration1733); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rfkw_tree = (Object)adaptor.create(rfkw);
            adaptor.addChild(root_0, rfkw_tree);
            }
            pushFollow(FOLLOW_refinementRelationDeclarations_in_refinementDeclaration1735);
            refinementRelationDeclarations84=refinementRelationDeclarations(element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementRelationDeclarations84.getTree());
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
            if ( state.backtracking>0 ) { memoize(input, 50, refinementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "refinementDeclaration"

    public static class refinementRelationDeclarations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "refinementRelationDeclarations"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:765:1: refinementRelationDeclarations[RefinableDeclaration element] : name= Identifier ( ',' refinementRelationDeclarations[$element] )? ;
    public final MViewParser.refinementRelationDeclarations_return refinementRelationDeclarations(RefinableDeclaration element) throws RecognitionException {
        MViewParser.refinementRelationDeclarations_return retval = new MViewParser.refinementRelationDeclarations_return();
        retval.start = input.LT(1);
        int refinementRelationDeclarations_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal85=null;
        MViewParser.refinementRelationDeclarations_return refinementRelationDeclarations86 = null;


        Object name_tree=null;
        Object char_literal85_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:766:2: (name= Identifier ( ',' refinementRelationDeclarations[$element] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:766:4: name= Identifier ( ',' refinementRelationDeclarations[$element] )?
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_refinementRelationDeclarations1752); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:766:20: ( ',' refinementRelationDeclarations[$element] )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==29) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:766:22: ',' refinementRelationDeclarations[$element]
                    {
                    char_literal85=(Token)match(input,29,FOLLOW_29_in_refinementRelationDeclarations1756); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal85_tree = (Object)adaptor.create(char_literal85);
                    adaptor.addChild(root_0, char_literal85_tree);
                    }
                    pushFollow(FOLLOW_refinementRelationDeclarations_in_refinementRelationDeclarations1758);
                    refinementRelationDeclarations86=refinementRelationDeclarations(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementRelationDeclarations86.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			SimpleReference parentRef = new SimpleReference((name!=null?name.getText():null),element.getClass());
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
            if ( state.backtracking>0 ) { memoize(input, 51, refinementRelationDeclarations_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:779:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
    public final MViewParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls(Class targetType) throws RecognitionException {
        MViewParser.commaSeparatedBodyDecls_return retval = new MViewParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);
        int commaSeparatedBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token char_literal87=null;
        MViewParser.commaSeparatedBodyDecls_return decls = null;


        Object id_tree=null;
        Object char_literal87_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:781:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:781:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls1791); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:781:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==29) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:781:19: ',' decls= commaSeparatedBodyDecls[$targetType]
                    {
                    char_literal87=(Token)match(input,29,FOLLOW_29_in_commaSeparatedBodyDecls1794); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal87_tree = (Object)adaptor.create(char_literal87);
                    adaptor.addChild(root_0, char_literal87_tree);
                    }
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1798);
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
            if ( state.backtracking>0 ) { memoize(input, 52, commaSeparatedBodyDecls_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:796:1: adviceType returns [Modifier value] : ( 'before' | 'after' | 'around' );
    public final MViewParser.adviceType_return adviceType() throws RecognitionException {
        MViewParser.adviceType_return retval = new MViewParser.adviceType_return();
        retval.start = input.LT(1);
        int adviceType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal88=null;
        Token string_literal89=null;
        Token string_literal90=null;

        Object string_literal88_tree=null;
        Object string_literal89_tree=null;
        Object string_literal90_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:797:2: ( 'before' | 'after' | 'around' )
            int alt34=3;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt34=1;
                }
                break;
            case 49:
                {
                alt34=2;
                }
                break;
            case 50:
                {
                alt34=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:797:4: 'before'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal88=(Token)match(input,48,FOLLOW_48_in_adviceType1830); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal88_tree = (Object)adaptor.create(string_literal88);
                    adaptor.addChild(root_0, string_literal88_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Before();
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:798:4: 'after'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal89=(Token)match(input,49,FOLLOW_49_in_adviceType1837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = (Object)adaptor.create(string_literal89);
                    adaptor.addChild(root_0, string_literal89_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new After();
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:799:4: 'around'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal90=(Token)match(input,50,FOLLOW_50_in_adviceType1844); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = (Object)adaptor.create(string_literal90);
                    adaptor.addChild(root_0, string_literal90_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 53, adviceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:802:1: joinPointKind returns [Modifier value] : ( 'execution' | 'call' );
    public final MViewParser.joinPointKind_return joinPointKind() throws RecognitionException {
        MViewParser.joinPointKind_return retval = new MViewParser.joinPointKind_return();
        retval.start = input.LT(1);
        int joinPointKind_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal91=null;
        Token string_literal92=null;

        Object string_literal91_tree=null;
        Object string_literal92_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:803:2: ( 'execution' | 'call' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==51) ) {
                alt35=1;
            }
            else if ( (LA35_0==52) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:803:4: 'execution'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal91=(Token)match(input,51,FOLLOW_51_in_joinPointKind1862); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal91_tree = (Object)adaptor.create(string_literal91);
                    adaptor.addChild(root_0, string_literal91_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Execution();
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:804:4: 'call'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal92=(Token)match(input,52,FOLLOW_52_in_joinPointKind1869); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (Object)adaptor.create(string_literal92);
                    adaptor.addChild(root_0, string_literal92_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 54, joinPointKind_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:807:1: overrideOrExtend returns [Modifier value] : ( 'override' | 'extend' );
    public final MViewParser.overrideOrExtend_return overrideOrExtend() throws RecognitionException {
        MViewParser.overrideOrExtend_return retval = new MViewParser.overrideOrExtend_return();
        retval.start = input.LT(1);
        int overrideOrExtend_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal93=null;
        Token string_literal94=null;

        Object string_literal93_tree=null;
        Object string_literal94_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:808:2: ( 'override' | 'extend' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==53) ) {
                alt36=1;
            }
            else if ( (LA36_0==54) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:808:4: 'override'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal93=(Token)match(input,53,FOLLOW_53_in_overrideOrExtend1887); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal93_tree = (Object)adaptor.create(string_literal93);
                    adaptor.addChild(root_0, string_literal93_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Overridable();
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:809:4: 'extend'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal94=(Token)match(input,54,FOLLOW_54_in_overrideOrExtend1894); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal94_tree = (Object)adaptor.create(string_literal94);
                    adaptor.addChild(root_0, string_literal94_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = null;
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
            if ( state.backtracking>0 ) { memoize(input, 55, overrideOrExtend_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "overrideOrExtend"

    public static class voidType_return extends ParserRuleReturnScope {
        public TypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "voidType"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:812:1: voidType returns [TypeReference value] : 'void' ;
    public final MViewParser.voidType_return voidType() throws RecognitionException {
        MViewParser.voidType_return retval = new MViewParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal95=null;

        Object string_literal95_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:814:5: ( 'void' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:814:7: 'void'
            {
            root_0 = (Object)adaptor.nil();

            string_literal95=(Token)match(input,55,FOLLOW_55_in_voidType1916); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 56, voidType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:818:1: wildcardType returns [TypeReference value] : '*' ;
    public final MViewParser.wildcardType_return wildcardType() throws RecognitionException {
        MViewParser.wildcardType_return retval = new MViewParser.wildcardType_return();
        retval.start = input.LT(1);
        int wildcardType_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal96=null;

        Object char_literal96_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:819:2: ( '*' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:819:4: '*'
            {
            root_0 = (Object)adaptor.nil();

            char_literal96=(Token)match(input,56,FOLLOW_56_in_wildcardType1937); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal96_tree = (Object)adaptor.create(char_literal96);
            adaptor.addChild(root_0, char_literal96_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 57, wildcardType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:823:1: type returns [TypeReference value] : (cd= classOrInterfaceType | pt= primitiveType );
    public final MViewParser.type_return type() throws RecognitionException {
        MViewParser.type_return retval = new MViewParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.classOrInterfaceType_return cd = null;

        MViewParser.primitiveType_return pt = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:825:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Identifier) ) {
                alt37=1;
            }
            else if ( ((LA37_0>=58 && LA37_0<=65)) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:825:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceType_in_type1959);
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:826:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveType_in_type1968);
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
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 58, type_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:830:1: classOrInterfaceType returns [TypeReference element] : name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* ;
    public final MViewParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MViewParser.classOrInterfaceType_return retval = new MViewParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal98=null;
        MViewParser.typeArguments_return typeArguments97 = null;

        MViewParser.typeArguments_return typeArguments99 = null;


        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal98_tree=null;

        NamespaceOrTypeReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:832:2: (name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:832:4: name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType1993); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new BasicTypeReference((name!=null?name.getText():null)); 
              	           target =  new NamespaceOrTypeReference((name!=null?name.getText():null)); 
              	          
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:837:4: ( typeArguments )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==66) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2012);
                    typeArguments97=typeArguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments97.getTree());

                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:838:10: ( '.' namex= Identifier ( typeArguments )? )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==57) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:838:11: '.' namex= Identifier ( typeArguments )?
            	    {
            	    char_literal98=(Token)match(input,57,FOLLOW_57_in_classOrInterfaceType2026); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal98_tree = (Object)adaptor.create(char_literal98);
            	    adaptor.addChild(root_0, char_literal98_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2030); if (state.failed) return retval;
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
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:849:11: ( typeArguments )?
            	    int alt39=2;
            	    int LA39_0 = input.LA(1);

            	    if ( (LA39_0==66) ) {
            	        alt39=1;
            	    }
            	    switch (alt39) {
            	        case 1 :
            	            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2057);
            	            typeArguments99=typeArguments();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments99.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
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
            if ( state.backtracking>0 ) { memoize(input, 59, classOrInterfaceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:853:1: primitiveType returns [TypeReference value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MViewParser.primitiveType_return primitiveType() throws RecognitionException {
        MViewParser.primitiveType_return retval = new MViewParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal100=null;
        Token string_literal101=null;
        Token string_literal102=null;
        Token string_literal103=null;
        Token string_literal104=null;
        Token string_literal105=null;
        Token string_literal106=null;
        Token string_literal107=null;

        Object string_literal100_tree=null;
        Object string_literal101_tree=null;
        Object string_literal102_tree=null;
        Object string_literal103_tree=null;
        Object string_literal104_tree=null;
        Object string_literal105_tree=null;
        Object string_literal106_tree=null;
        Object string_literal107_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:854:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt41=8;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt41=1;
                }
                break;
            case 59:
                {
                alt41=2;
                }
                break;
            case 60:
                {
                alt41=3;
                }
                break;
            case 61:
                {
                alt41=4;
                }
                break;
            case 62:
                {
                alt41=5;
                }
                break;
            case 63:
                {
                alt41=6;
                }
                break;
            case 64:
                {
                alt41=7;
                }
                break;
            case 65:
                {
                alt41=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:854:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal100=(Token)match(input,58,FOLLOW_58_in_primitiveType2082); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal100_tree = (Object)adaptor.create(string_literal100);
                    adaptor.addChild(root_0, string_literal100_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:855:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal101=(Token)match(input,59,FOLLOW_59_in_primitiveType2094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal101_tree = (Object)adaptor.create(string_literal101);
                    adaptor.addChild(root_0, string_literal101_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("char");
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:856:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal102=(Token)match(input,60,FOLLOW_60_in_primitiveType2106); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal102_tree = (Object)adaptor.create(string_literal102);
                    adaptor.addChild(root_0, string_literal102_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("byte");
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:857:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal103=(Token)match(input,61,FOLLOW_61_in_primitiveType2118); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal103_tree = (Object)adaptor.create(string_literal103);
                    adaptor.addChild(root_0, string_literal103_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("short");
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:858:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal104=(Token)match(input,62,FOLLOW_62_in_primitiveType2130); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal104_tree = (Object)adaptor.create(string_literal104);
                    adaptor.addChild(root_0, string_literal104_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("int");
                    }

                    }
                    break;
                case 6 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:859:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal105=(Token)match(input,63,FOLLOW_63_in_primitiveType2142); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal105_tree = (Object)adaptor.create(string_literal105);
                    adaptor.addChild(root_0, string_literal105_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("long");
                    }

                    }
                    break;
                case 7 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:860:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal106=(Token)match(input,64,FOLLOW_64_in_primitiveType2154); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal106_tree = (Object)adaptor.create(string_literal106);
                    adaptor.addChild(root_0, string_literal106_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("float");
                    }

                    }
                    break;
                case 8 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:861:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal107=(Token)match(input,65,FOLLOW_65_in_primitiveType2166); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal107_tree = (Object)adaptor.create(string_literal107);
                    adaptor.addChild(root_0, string_literal107_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 60, primitiveType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primitiveType"

    public static class typeArguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArguments"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:866:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final MViewParser.typeArguments_return typeArguments() throws RecognitionException {
        MViewParser.typeArguments_return retval = new MViewParser.typeArguments_return();
        retval.start = input.LT(1);
        int typeArguments_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal108=null;
        Token char_literal110=null;
        Token char_literal112=null;
        MViewParser.typeArgument_return typeArgument109 = null;

        MViewParser.typeArgument_return typeArgument111 = null;


        Object char_literal108_tree=null;
        Object char_literal110_tree=null;
        Object char_literal112_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:867:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:867:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal108=(Token)match(input,66,FOLLOW_66_in_typeArguments2189); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal108_tree = (Object)adaptor.create(char_literal108);
            adaptor.addChild(root_0, char_literal108_tree);
            }
            pushFollow(FOLLOW_typeArgument_in_typeArguments2191);
            typeArgument109=typeArgument();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument109.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:867:26: ( ',' typeArgument )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==29) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:867:28: ',' typeArgument
            	    {
            	    char_literal110=(Token)match(input,29,FOLLOW_29_in_typeArguments2195); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal110_tree = (Object)adaptor.create(char_literal110);
            	    adaptor.addChild(root_0, char_literal110_tree);
            	    }
            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2197);
            	    typeArgument111=typeArgument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument111.getTree());

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            char_literal112=(Token)match(input,67,FOLLOW_67_in_typeArguments2202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal112_tree = (Object)adaptor.create(char_literal112);
            adaptor.addChild(root_0, char_literal112_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 61, typeArguments_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArguments"

    public static class typeArgument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArgument"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:870:1: typeArgument : (t= type | '?' ( ( 'extends' | 'super' ) t= type )? );
    public final MViewParser.typeArgument_return typeArgument() throws RecognitionException {
        MViewParser.typeArgument_return retval = new MViewParser.typeArgument_return();
        retval.start = input.LT(1);
        int typeArgument_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal113=null;
        Token set114=null;
        MViewParser.type_return t = null;


        Object char_literal113_tree=null;
        Object set114_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:871:5: (t= type | '?' ( ( 'extends' | 'super' ) t= type )? )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==Identifier||(LA44_0>=58 && LA44_0<=65)) ) {
                alt44=1;
            }
            else if ( (LA44_0==68) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:871:9: t= type
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_typeArgument2227);
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:871:20: '?' ( ( 'extends' | 'super' ) t= type )?
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal113=(Token)match(input,68,FOLLOW_68_in_typeArgument2233); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal113_tree = (Object)adaptor.create(char_literal113);
                    adaptor.addChild(root_0, char_literal113_tree);
                    }
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:871:25: ( ( 'extends' | 'super' ) t= type )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( ((LA43_0>=69 && LA43_0<=70)) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:871:27: ( 'extends' | 'super' ) t= type
                            {
                            set114=(Token)input.LT(1);
                            if ( (input.LA(1)>=69 && input.LA(1)<=70) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set114));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_type_in_typeArgument2248);
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
            if ( state.backtracking>0 ) { memoize(input, 62, typeArgument_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArgument"

    public static class annotations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotations"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:878:1: annotations : ( annotation )+ ;
    public final MViewParser.annotations_return annotations() throws RecognitionException {
        MViewParser.annotations_return retval = new MViewParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotation_return annotation115 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:879:5: ( ( annotation )+ )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:879:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:879:9: ( annotation )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==71) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations2278);
            	    annotation115=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation115.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt45 >= 1 ) break loop45;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
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
            if ( state.backtracking>0 ) { memoize(input, 63, annotations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotations"

    public static class annotation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotation"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:882:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MViewParser.annotation_return annotation() throws RecognitionException {
        MViewParser.annotation_return retval = new MViewParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal116=null;
        Token char_literal118=null;
        Token char_literal121=null;
        MViewParser.annotationName_return annotationName117 = null;

        MViewParser.elementValuePairs_return elementValuePairs119 = null;

        MViewParser.elementValue_return elementValue120 = null;


        Object char_literal116_tree=null;
        Object char_literal118_tree=null;
        Object char_literal121_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:883:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:883:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            char_literal116=(Token)match(input,71,FOLLOW_71_in_annotation2298); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal116_tree = (Object)adaptor.create(char_literal116);
            adaptor.addChild(root_0, char_literal116_tree);
            }
            pushFollow(FOLLOW_annotationName_in_annotation2300);
            annotationName117=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName117.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:883:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==27) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:883:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal118=(Token)match(input,27,FOLLOW_27_in_annotation2304); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal118_tree = (Object)adaptor.create(char_literal118);
                    adaptor.addChild(root_0, char_literal118_tree);
                    }
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:883:34: ( elementValuePairs | elementValue )?
                    int alt46=3;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==Identifier) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==24||LA46_0==71) ) {
                        alt46=2;
                    }
                    switch (alt46) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:883:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation2308);
                            elementValuePairs119=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs119.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:883:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation2312);
                            elementValue120=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue120.getTree());

                            }
                            break;

                    }

                    char_literal121=(Token)match(input,28,FOLLOW_28_in_annotation2317); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal121_tree = (Object)adaptor.create(char_literal121);
                    adaptor.addChild(root_0, char_literal121_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 64, annotation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotation"

    public static class annotationName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationName"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:886:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MViewParser.annotationName_return annotationName() throws RecognitionException {
        MViewParser.annotationName_return retval = new MViewParser.annotationName_return();
        retval.start = input.LT(1);
        int annotationName_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier122=null;
        Token char_literal123=null;
        Token Identifier124=null;

        Object Identifier122_tree=null;
        Object char_literal123_tree=null;
        Object Identifier124_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:887:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:887:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            Identifier122=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2341); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier122_tree = (Object)adaptor.create(Identifier122);
            adaptor.addChild(root_0, Identifier122_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:887:18: ( '.' Identifier )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==57) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:887:19: '.' Identifier
            	    {
            	    char_literal123=(Token)match(input,57,FOLLOW_57_in_annotationName2344); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal123_tree = (Object)adaptor.create(char_literal123);
            	    adaptor.addChild(root_0, char_literal123_tree);
            	    }
            	    Identifier124=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2346); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier124_tree = (Object)adaptor.create(Identifier124);
            	    adaptor.addChild(root_0, Identifier124_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop48;
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
            if ( state.backtracking>0 ) { memoize(input, 65, annotationName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationName"

    public static class elementValuePairs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePairs"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:890:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MViewParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MViewParser.elementValuePairs_return retval = new MViewParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal126=null;
        MViewParser.elementValuePair_return elementValuePair125 = null;

        MViewParser.elementValuePair_return elementValuePair127 = null;


        Object char_literal126_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:891:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:891:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2367);
            elementValuePair125=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair125.getTree());
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:891:26: ( ',' elementValuePair )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==29) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:891:27: ',' elementValuePair
            	    {
            	    char_literal126=(Token)match(input,29,FOLLOW_29_in_elementValuePairs2370); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal126_tree = (Object)adaptor.create(char_literal126);
            	    adaptor.addChild(root_0, char_literal126_tree);
            	    }
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2372);
            	    elementValuePair127=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair127.getTree());

            	    }
            	    break;

            	default :
            	    break loop49;
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
            if ( state.backtracking>0 ) { memoize(input, 66, elementValuePairs_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePairs"

    public static class elementValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePair"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:894:1: elementValuePair : Identifier '=' elementValue ;
    public final MViewParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MViewParser.elementValuePair_return retval = new MViewParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier128=null;
        Token char_literal129=null;
        MViewParser.elementValue_return elementValue130 = null;


        Object Identifier128_tree=null;
        Object char_literal129_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:895:5: ( Identifier '=' elementValue )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:895:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();

            Identifier128=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair2393); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier128_tree = (Object)adaptor.create(Identifier128);
            adaptor.addChild(root_0, Identifier128_tree);
            }
            char_literal129=(Token)match(input,72,FOLLOW_72_in_elementValuePair2395); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal129_tree = (Object)adaptor.create(char_literal129);
            adaptor.addChild(root_0, char_literal129_tree);
            }
            pushFollow(FOLLOW_elementValue_in_elementValuePair2397);
            elementValue130=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue130.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, elementValuePair_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePair"

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValue"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:898:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MViewParser.elementValue_return elementValue() throws RecognitionException {
        MViewParser.elementValue_return retval = new MViewParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotation_return annotation131 = null;

        MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer132 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:899:5: ( annotation | elementValueArrayInitializer )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==71) ) {
                alt50=1;
            }
            else if ( (LA50_0==24) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:899:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotation_in_elementValue2420);
                    annotation131=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation131.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:900:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue2430);
                    elementValueArrayInitializer132=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer132.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 68, elementValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValue"

    public static class elementValueArrayInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValueArrayInitializer"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:903:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MViewParser.elementValueArrayInitializer_return retval = new MViewParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal133=null;
        Token char_literal135=null;
        Token char_literal137=null;
        Token char_literal138=null;
        MViewParser.elementValue_return elementValue134 = null;

        MViewParser.elementValue_return elementValue136 = null;


        Object char_literal133_tree=null;
        Object char_literal135_tree=null;
        Object char_literal137_tree=null;
        Object char_literal138_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal133=(Token)match(input,24,FOLLOW_24_in_elementValueArrayInitializer2453); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal133_tree = (Object)adaptor.create(char_literal133);
            adaptor.addChild(root_0, char_literal133_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:13: ( elementValue ( ',' elementValue )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==24||LA52_0==71) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2456);
                    elementValue134=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue134.getTree());
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:27: ( ',' elementValue )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==29) ) {
                            int LA51_1 = input.LA(2);

                            if ( (LA51_1==24||LA51_1==71) ) {
                                alt51=1;
                            }


                        }


                        switch (alt51) {
                    	case 1 :
                    	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:28: ',' elementValue
                    	    {
                    	    char_literal135=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2459); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal135_tree = (Object)adaptor.create(char_literal135);
                    	    adaptor.addChild(root_0, char_literal135_tree);
                    	    }
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2461);
                    	    elementValue136=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue136.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:49: ( ',' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==29) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:904:50: ','
                    {
                    char_literal137=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2468); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal137_tree = (Object)adaptor.create(char_literal137);
                    adaptor.addChild(root_0, char_literal137_tree);
                    }

                    }
                    break;

            }

            char_literal138=(Token)match(input,25,FOLLOW_25_in_elementValueArrayInitializer2472); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal138_tree = (Object)adaptor.create(char_literal138);
            adaptor.addChild(root_0, char_literal138_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 69, elementValueArrayInitializer_StartIndex); }
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
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:907:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MViewParser.annotationTypeDeclaration_return retval = new MViewParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal139=null;
        Token string_literal140=null;
        MViewParser.annotationTypeBody_return annotationTypeBody141 = null;


        Object name_tree=null;
        Object char_literal139_tree=null;
        Object string_literal140_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:908:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:908:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();

            char_literal139=(Token)match(input,71,FOLLOW_71_in_annotationTypeDeclaration2499); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal139_tree = (Object)adaptor.create(char_literal139);
            adaptor.addChild(root_0, char_literal139_tree);
            }
            string_literal140=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration2501); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal140_tree = (Object)adaptor.create(string_literal140);
            adaptor.addChild(root_0, string_literal140_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration2505); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2507);
            annotationTypeBody141=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody141.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 70, annotationTypeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeDeclaration"

    public static class annotationTypeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeBody"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:911:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MViewParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MViewParser.annotationTypeBody_return retval = new MViewParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal142=null;
        Token char_literal144=null;
        MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration143 = null;


        Object char_literal142_tree=null;
        Object char_literal144_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:912:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:912:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal142=(Token)match(input,24,FOLLOW_24_in_annotationTypeBody2530); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal142_tree = (Object)adaptor.create(char_literal142);
            adaptor.addChild(root_0, char_literal142_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:912:13: ( annotationTypeElementDeclaration )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==Identifier||(LA54_0>=58 && LA54_0<=65)||LA54_0==71) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:912:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2533);
            	    annotationTypeElementDeclaration143=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration143.getTree());

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            char_literal144=(Token)match(input,25,FOLLOW_25_in_annotationTypeBody2537); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal144_tree = (Object)adaptor.create(char_literal144);
            adaptor.addChild(root_0, char_literal144_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 71, annotationTypeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeBody"

    public static class annotationTypeElementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementDeclaration"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:915:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MViewParser.annotationTypeElementDeclaration_return retval = new MViewParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotationTypeElementRest_return annotationTypeElementRest145 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:916:5: ( annotationTypeElementRest )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:916:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2562);
            annotationTypeElementRest145=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest145.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, annotationTypeElementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementDeclaration"

    public static class annotationTypeElementRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementRest"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:919:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MViewParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MViewParser.annotationTypeElementRest_return retval = new MViewParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal148=null;
        Token char_literal150=null;
        MViewParser.type_return type146 = null;

        MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest147 = null;

        MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration149 = null;


        Object char_literal148_tree=null;
        Object char_literal150_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:920:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==Identifier||(LA56_0>=58 && LA56_0<=65)) ) {
                alt56=1;
            }
            else if ( (LA56_0==71) ) {
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
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:920:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2585);
                    type146=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type146.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2587);
                    annotationMethodOrConstantRest147=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest147.getTree());
                    char_literal148=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2589); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal148_tree = (Object)adaptor.create(char_literal148);
                    adaptor.addChild(root_0, char_literal148_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2599);
                    annotationTypeDeclaration149=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration149.getTree());
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:921:35: ( ';' )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==26) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: ';'
                            {
                            char_literal150=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2601); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal150_tree = (Object)adaptor.create(char_literal150);
                            adaptor.addChild(root_0, char_literal150_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 73, annotationTypeElementRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementRest"

    public static class annotationMethodOrConstantRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodOrConstantRest"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:924:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MViewParser.annotationMethodOrConstantRest_return retval = new MViewParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.annotationMethodRest_return annotationMethodRest151 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:925:5: ( annotationMethodRest )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:925:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2625);
            annotationMethodRest151=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest151.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 74, annotationMethodOrConstantRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodOrConstantRest"

    public static class annotationMethodRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodRest"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:928:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MViewParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MViewParser.annotationMethodRest_return retval = new MViewParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier152=null;
        Token char_literal153=null;
        Token char_literal154=null;
        MViewParser.defaultValue_return defaultValue155 = null;


        Object Identifier152_tree=null;
        Object char_literal153_tree=null;
        Object char_literal154_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:929:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:929:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier152=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2648); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier152_tree = (Object)adaptor.create(Identifier152);
            adaptor.addChild(root_0, Identifier152_tree);
            }
            char_literal153=(Token)match(input,27,FOLLOW_27_in_annotationMethodRest2650); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal153_tree = (Object)adaptor.create(char_literal153);
            adaptor.addChild(root_0, char_literal153_tree);
            }
            char_literal154=(Token)match(input,28,FOLLOW_28_in_annotationMethodRest2652); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal154_tree = (Object)adaptor.create(char_literal154);
            adaptor.addChild(root_0, char_literal154_tree);
            }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:929:28: ( defaultValue )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==73) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:0:0: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest2654);
                    defaultValue155=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue155.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 75, annotationMethodRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodRest"

    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultValue"
    // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:932:1: defaultValue : 'default' elementValue ;
    public final MViewParser.defaultValue_return defaultValue() throws RecognitionException {
        MViewParser.defaultValue_return retval = new MViewParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal156=null;
        MViewParser.elementValue_return elementValue157 = null;


        Object string_literal156_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:933:5: ( 'default' elementValue )
            // /Users/steveno/Documents/repos/mview-lang/src/mview/parser/MView.g:933:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();

            string_literal156=(Token)match(input,73,FOLLOW_73_in_defaultValue2682); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal156_tree = (Object)adaptor.create(string_literal156);
            adaptor.addChild(root_0, string_literal156_tree);
            }
            pushFollow(FOLLOW_elementValue_in_defaultValue2684);
            elementValue157=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue157.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 76, defaultValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit89 = new BitSet(new long[]{0x000000C040800002L});
    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit102 = new BitSet(new long[]{0x000000C040800002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_compilationUnit117 = new BitSet(new long[]{0x000000C040800002L});
    public static final BitSet FOLLOW_applicationDeclaration_in_compilationUnit130 = new BitSet(new long[]{0x000000C040800002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration162 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration166 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_interfaceBody186 = new BitSet(new long[]{0xFC80000002000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody188 = new BitSet(new long[]{0xFC80000002000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_25_in_interfaceBody192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration208 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceBodyDeclaration210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_serviceReferenceDeclaration236 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_actualParameters_in_serviceReferenceDeclaration240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_actualParameters267 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameters272 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_actualParameters278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_actualParameterDecls303 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_actualParameterDecls306 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameterDecls310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceHeaderDeclaration363 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_serviceHeaderDeclaration367 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceHeaderDeclaration371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_formalParameters441 = new BitSet(new long[]{0xFC80000010000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters446 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_formalParameters452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls477 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls481 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_formalParameterDecls484 = new BitSet(new long[]{0xFC80000000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureDecl522 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureDecl526 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_pointcutServiceSignatureParameters551 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters554 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_pointcutServiceSignatureParameters560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls574 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls578 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutServiceSignatureParameterDecls581 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_connectorDeclaration663 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration667 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_connectorDeclaration674 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorBody693 = new BitSet(new long[]{0x0000200082000000L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody695 = new BitSet(new long[]{0x0000200082000000L});
    public static final BitSet FOLLOW_25_in_connectorBody699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_connectorAOCompositionDeclaration742 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorAOCompositionDeclaration746 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_connectorAOCompositionDeclaration753 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorAOCompositionBody773 = new BitSet(new long[]{0x0000040102000000L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody780 = new BitSet(new long[]{0x0000040002000000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_connectorAOCompositionBody789 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_connectorAOCompositionBody796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_pointcutDeclaration813 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutBody833 = new BitSet(new long[]{0x0060003A02000000L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody835 = new BitSet(new long[]{0x0060003A02000000L});
    public static final BitSet FOLLOW_25_in_pointcutBody839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pointcutKindDeclaration882 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutKindDeclaration884 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_joinPointKind_in_pointcutKindDeclaration888 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutKindDeclaration890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration909 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutSignatureDeclaration915 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutSignatureDeclaration917 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration921 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutSignatureDeclaration925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls961 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutSignatureBodyDecls965 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_pointcutActorDeclaration989 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_pointcutActorDeclaration1004 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutActorBody1035 = new BitSet(new long[]{0x006003C002800000L});
    public static final BitSet FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1037 = new BitSet(new long[]{0x006003C002800000L});
    public static final BitSet FOLLOW_25_in_pointcutActorBody1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1062 = new BitSet(new long[]{0x000003C000800000L});
    public static final BitSet FOLLOW_23_in_pointcutActorBodyDecls1071 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutActorBodyDecls1073 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_38_in_pointcutActorBodyDecls1083 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutActorBodyDecls1085 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_39_in_pointcutActorBodyDecls1094 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutActorBodyDecls1096 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_40_in_pointcutActorBodyDecls1105 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutActorBodyDecls1107 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_41_in_pointcutActorBodyDecls1116 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutActorBodyDecls1118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1128 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutActorBodyDecls1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1147 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutActorPropDecls1152 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutActorPropDecl1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_adviceDeclaration1202 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_adviceBody1219 = new BitSet(new long[]{0x0000180002000000L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody1221 = new BitSet(new long[]{0x0000180002000000L});
    public static final BitSet FOLLOW_25_in_adviceBody1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_adviceServiceDeclaration1260 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceServiceDeclaration1262 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1266 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceServiceDeclaration1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_adviceTypeDeclaration1285 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceTypeDeclaration1287 = new BitSet(new long[]{0x0007000000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration1291 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceTypeDeclaration1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_componentDeclaration1320 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration1324 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_componentBody1350 = new BitSet(new long[]{0x0000600082000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody1352 = new BitSet(new long[]{0x0000600082000000L});
    public static final BitSet FOLLOW_25_in_componentBody1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_moduleDependencyBody1411 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1416 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_moduleDependencyBody1424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_moduleRequireDependencyDeclaration1441 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_moduleProvideDependencyDeclaration1460 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_applicationDeclaration1497 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_applicationDeclaration1501 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_applicationDeclaration1508 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_applicationBody_in_applicationDeclaration1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_applicationBody1527 = new BitSet(new long[]{0x0000024042000010L});
    public static final BitSet FOLLOW_applicationBodyDeclaration_in_applicationBody1531 = new BitSet(new long[]{0x0000024042000010L});
    public static final BitSet FOLLOW_25_in_applicationBody1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hostDeclaration_in_applicationBodyDeclaration1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1608 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1612 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_instanceDeclaration1616 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1620 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_instanceDeclaration1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_hostDeclaration1649 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_hostDeclaration1653 = new BitSet(new long[]{0x0000800004000000L});
    public static final BitSet FOLLOW_47_in_hostDeclaration1661 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_StringLiteral_in_hostDeclaration1665 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_hostDeclaration1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_componentDeclaration_in_moduleContainerDeclarations1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_refinementDeclaration1733 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_refinementRelationDeclarations_in_refinementDeclaration1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_refinementRelationDeclarations1752 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_refinementRelationDeclarations1756 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_refinementRelationDeclarations_in_refinementRelationDeclarations1758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls1791 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_commaSeparatedBodyDecls1794 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_adviceType1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_adviceType1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_adviceType1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_joinPointKind1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_joinPointKind1869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_overrideOrExtend1887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_overrideOrExtend1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_voidType1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_wildcardType1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType1993 = new BitSet(new long[]{0x0200000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2012 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_classOrInterfaceType2026 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2030 = new BitSet(new long[]{0x0200000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2057 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_58_in_primitiveType2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_primitiveType2094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_primitiveType2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_primitiveType2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_primitiveType2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_primitiveType2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_primitiveType2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_typeArguments2189 = new BitSet(new long[]{0xFC80000000000010L,0x0000000000000013L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2191 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_typeArguments2195 = new BitSet(new long[]{0xFC80000000000010L,0x0000000000000013L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2197 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_typeArguments2202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_typeArgument2233 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_set_in_typeArgument2238 = new BitSet(new long[]{0xFC80000000000010L,0x0000000000000003L});
    public static final BitSet FOLLOW_type_in_typeArgument2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations2278 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_annotation2298 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation2300 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_annotation2304 = new BitSet(new long[]{0x0000000011000010L,0x0000000000000080L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation2308 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation2312 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotation2317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2341 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_annotationName2344 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2346 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2367 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_elementValuePairs2370 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2372 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair2393 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_elementValuePair2395 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair2397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue2420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue2430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_elementValueArrayInitializer2453 = new BitSet(new long[]{0x0000000023000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2456 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2459 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2461 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2468 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elementValueArrayInitializer2472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_annotationTypeDeclaration2499 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration2501 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration2505 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeBody2530 = new BitSet(new long[]{0xFC80000002000010L,0x0000000000000083L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2533 = new BitSet(new long[]{0xFC80000002000010L,0x0000000000000083L});
    public static final BitSet FOLLOW_25_in_annotationTypeBody2537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2585 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2587 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2599 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2648 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_annotationMethodRest2650 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotationMethodRest2652 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_defaultValue2682 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2684 = new BitSet(new long[]{0x0000000000000002L});

}
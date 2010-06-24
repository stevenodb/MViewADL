// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g 2010-06-24 19:57:52

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class MstageParser extends ChameleonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "StringLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "'{'", "'}'", "';'", "'('", "')'", "','", "'connector'", "'ao-composition'", "'pointcut'", "'kind'", "':'", "'signature'", "'caller'", "'callee'", "'advice'", "'service'", "'type'", "'component'", "'require'", "'provide'", "'composite'", "'application'", "'deployment'", "'contain'", "'abstracthost'", "'none'", "'host'", "'map'", "'locate'", "'before'", "'after'", "'around'", "'execution'", "'call'", "'void'", "'.'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'<'", "'>'", "'?'", "'extends'", "'super'", "'@'", "'='", "'default'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int FloatTypeSuffix=11;
    public static final int T__25=25;
    public static final int OctalLiteral=9;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int CharacterLiteral=14;
    public static final int Exponent=10;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int HexDigit=5;
    public static final int Identifier=4;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int COMMENT=21;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int HexLiteral=7;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int LINE_COMMENT=22;
    public static final int IntegerTypeSuffix=6;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int DecimalLiteral=8;
    public static final int StringLiteral=15;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int WS=20;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int UnicodeEscape=16;
    public static final int FloatingPointLiteral=12;
    public static final int JavaIDDigit=19;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int Letter=18;
    public static final int OctalEscape=17;
    public static final int EscapeSequence=13;
    public static final int T__73=73;

    // delegates
    // delegators

    protected static class TargetScope_scope {
        InvocationTarget target;
        Token start;
    }
    protected Stack TargetScope_stack = new Stack();


        public MstageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MstageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[145+1];
             
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return MstageParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g"; }


    public static class compilationUnit_return extends ParserRuleReturnScope {
        public CompilationUnit element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compilationUnit"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:74:1: compilationUnit returns [CompilationUnit element] : (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration | ahd= abstractHostDeclaration | phd= physicalHostDeclaration )* ;
    public final MstageParser.compilationUnit_return compilationUnit() throws RecognitionException {
        MstageParser.compilationUnit_return retval = new MstageParser.compilationUnit_return();
        retval.start = input.LT(1);
        int compilationUnit_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.interfaceDeclaration_return ifd = null;

        MstageParser.componentDeclaration_return cod = null;

        MstageParser.compositeDeclaration_return cmd = null;

        MstageParser.connectorDeclaration_return cnd = null;

        MstageParser.applicationDeclaration_return apd = null;

        MstageParser.deploymentDeclaration_return dpd = null;

        MstageParser.abstractHostDeclaration_return ahd = null;

        MstageParser.physicalHostDeclaration_return phd = null;



         
        	retval.element = getCompilationUnit();
        	NamespacePart npp = new NamespacePart(language().defaultNamespace());
        	retval.element.add(npp);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:80:2: ( (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration | ahd= abstractHostDeclaration | phd= physicalHostDeclaration )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:80:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration | ahd= abstractHostDeclaration | phd= physicalHostDeclaration )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:80:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration | ahd= abstractHostDeclaration | phd= physicalHostDeclaration )*
            loop1:
            do {
                int alt1=9;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    alt1=1;
                    }
                    break;
                case 41:
                    {
                    alt1=2;
                    }
                    break;
                case 44:
                    {
                    alt1=3;
                    }
                    break;
                case 30:
                    {
                    alt1=4;
                    }
                    break;
                case 45:
                    {
                    alt1=5;
                    }
                    break;
                case 46:
                    {
                    alt1=6;
                    }
                    break;
                case 48:
                    {
                    alt1=7;
                    }
                    break;
                case 50:
                    {
                    alt1=8;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:81:4: ifd= interfaceDeclaration
            	    {
            	    pushFollow(FOLLOW_interfaceDeclaration_in_compilationUnit90);
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
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:83:4: cod= componentDeclaration
            	    {
            	    pushFollow(FOLLOW_componentDeclaration_in_compilationUnit103);
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
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:85:4: cmd= compositeDeclaration
            	    {
            	    pushFollow(FOLLOW_compositeDeclaration_in_compilationUnit119);
            	    cmd=compositeDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cmd.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((cmd!=null?cmd.element:null));
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:87:4: cnd= connectorDeclaration
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
            	case 5 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:89:4: apd= applicationDeclaration
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
            	case 6 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:91:4: dpd= deploymentDeclaration
            	    {
            	    pushFollow(FOLLOW_deploymentDeclaration_in_compilationUnit158);
            	    dpd=deploymentDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, dpd.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((dpd!=null?dpd.element:null));
            	    }

            	    }
            	    break;
            	case 7 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:93:4: ahd= abstractHostDeclaration
            	    {
            	    pushFollow(FOLLOW_abstractHostDeclaration_in_compilationUnit171);
            	    ahd=abstractHostDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ahd.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((ahd!=null?ahd.element:null));
            	    }

            	    }
            	    break;
            	case 8 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:95:4: phd= physicalHostDeclaration
            	    {
            	    pushFollow(FOLLOW_physicalHostDeclaration_in_compilationUnit185);
            	    phd=physicalHostDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, phd.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((phd!=null?phd.element:null));
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:107:1: interfaceDeclaration returns [Interface element] : intkw= 'interface' name= Identifier interfaceBody[$element] ;
    public final MstageParser.interfaceDeclaration_return interfaceDeclaration() throws RecognitionException {
        MstageParser.interfaceDeclaration_return retval = new MstageParser.interfaceDeclaration_return();
        retval.start = input.LT(1);
        int interfaceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token intkw=null;
        Token name=null;
        MstageParser.interfaceBody_return interfaceBody1 = null;


        Object intkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:108:2: (intkw= 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:108:4: intkw= 'interface' name= Identifier interfaceBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            intkw=(Token)match(input,23,FOLLOW_23_in_interfaceDeclaration216); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            intkw_tree = (Object)adaptor.create(intkw);
            adaptor.addChild(root_0, intkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration220); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Interface(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,intkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration226);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:117:1: interfaceBody[Interface element] : '{' ( interfaceBodyDeclaration[$element] )* '}' ;
    public final MstageParser.interfaceBody_return interfaceBody(Interface element) throws RecognitionException {
        MstageParser.interfaceBody_return retval = new MstageParser.interfaceBody_return();
        retval.start = input.LT(1);
        int interfaceBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal2=null;
        Token char_literal4=null;
        MstageParser.interfaceBodyDeclaration_return interfaceBodyDeclaration3 = null;


        Object char_literal2_tree=null;
        Object char_literal4_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:118:2: ( '{' ( interfaceBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:118:4: '{' ( interfaceBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal2=(Token)match(input,24,FOLLOW_24_in_interfaceBody240); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:118:8: ( interfaceBodyDeclaration[$element] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||LA2_0==58||(LA2_0>=60 && LA2_0<=67)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: interfaceBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody242);
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

            char_literal4=(Token)match(input,25,FOLLOW_25_in_interfaceBody246); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:123:1: interfaceBodyDeclaration[Interface element] : (service= serviceDeclaration ';' ) ;
    public final MstageParser.interfaceBodyDeclaration_return interfaceBodyDeclaration(Interface element) throws RecognitionException {
        MstageParser.interfaceBodyDeclaration_return retval = new MstageParser.interfaceBodyDeclaration_return();
        retval.start = input.LT(1);
        int interfaceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal5=null;
        MstageParser.serviceDeclaration_return service = null;


        Object char_literal5_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:124:2: ( (service= serviceDeclaration ';' ) )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:124:4: (service= serviceDeclaration ';' )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:124:4: (service= serviceDeclaration ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:124:5: service= serviceDeclaration ';'
            {
            pushFollow(FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration263);
            service=serviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal5=(Token)match(input,26,FOLLOW_26_in_interfaceBodyDeclaration264); if (state.failed) return retval;
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

    public static class serviceDeclaration_return extends ParserRuleReturnScope {
        public Service element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "serviceDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:137:1: serviceDeclaration returns [Service element] : rtype= serviceReturnType name= Identifier params= formalParameters ;
    public final MstageParser.serviceDeclaration_return serviceDeclaration() throws RecognitionException {
        MstageParser.serviceDeclaration_return retval = new MstageParser.serviceDeclaration_return();
        retval.start = input.LT(1);
        int serviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        MstageParser.serviceReturnType_return rtype = null;

        MstageParser.formalParameters_return params = null;


        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:138:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:138:4: rtype= serviceReturnType name= Identifier params= formalParameters
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceReturnType_in_serviceDeclaration291);
            rtype=serviceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceDeclaration295); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_formalParameters_in_serviceDeclaration299);
            params=formalParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, params.getTree());
            if ( state.backtracking==0 ) {

              			Signature signature = new SimpleNameSignature((name!=null?name.getText():null));
              			retval.element = new Service(signature,(rtype!=null?rtype.value:null),(params!=null?params.element:null),null); //TODO: add properties
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, serviceDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "serviceDeclaration"

    public static class serviceReturnType_return extends ParserRuleReturnScope {
        public TypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "serviceReturnType"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:144:1: serviceReturnType returns [TypeReference value] : (vt= voidType | tp= type ) ;
    public final MstageParser.serviceReturnType_return serviceReturnType() throws RecognitionException {
        MstageParser.serviceReturnType_return retval = new MstageParser.serviceReturnType_return();
        retval.start = input.LT(1);
        int serviceReturnType_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.voidType_return vt = null;

        MstageParser.type_return tp = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:145:2: ( (vt= voidType | tp= type ) )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:145:4: (vt= voidType | tp= type )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:145:4: (vt= voidType | tp= type )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==58) ) {
                alt3=1;
            }
            else if ( (LA3_0==Identifier||(LA3_0>=60 && LA3_0<=67)) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:146:4: vt= voidType
                    {
                    pushFollow(FOLLOW_voidType_in_serviceReturnType324);
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:148:4: tp= type
                    {
                    pushFollow(FOLLOW_type_in_serviceReturnType338);
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
            if ( state.backtracking>0 ) { memoize(input, 6, serviceReturnType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "serviceReturnType"

    public static class formalParameters_return extends ParserRuleReturnScope {
        public List<FormalParameter> element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formalParameters"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:152:1: formalParameters returns [List<FormalParameter> element] : '(' (pars= formalParameterDecls )? ')' ;
    public final MstageParser.formalParameters_return formalParameters() throws RecognitionException {
        MstageParser.formalParameters_return retval = new MstageParser.formalParameters_return();
        retval.start = input.LT(1);
        int formalParameters_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal6=null;
        Token char_literal7=null;
        MstageParser.formalParameterDecls_return pars = null;


        Object char_literal6_tree=null;
        Object char_literal7_tree=null;

        retval.element = new ArrayList<FormalParameter>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:154:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:154:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal6=(Token)match(input,27,FOLLOW_27_in_formalParameters370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:154:13: (pars= formalParameterDecls )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Identifier||(LA4_0>=60 && LA4_0<=67)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:154:14: pars= formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters375);
                    pars=formalParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element =(pars!=null?pars.element:null);
                    }

                    }
                    break;

            }

            char_literal7=(Token)match(input,28,FOLLOW_28_in_formalParameters381); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 7, formalParameters_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "formalParameters"

    public static class formalParameterDecls_return extends ParserRuleReturnScope {
        public List<FormalParameter> element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formalParameterDecls"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:157:1: formalParameterDecls returns [List<FormalParameter> element] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
    public final MstageParser.formalParameterDecls_return formalParameterDecls() throws RecognitionException {
        MstageParser.formalParameterDecls_return retval = new MstageParser.formalParameterDecls_return();
        retval.start = input.LT(1);
        int formalParameterDecls_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal8=null;
        MstageParser.type_return t = null;

        MstageParser.formalParameterDecls_return decls = null;


        Object name_tree=null;
        Object char_literal8_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:158:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:158:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_type_in_formalParameterDecls406);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls410); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:158:32: ( ',' decls= formalParameterDecls )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==29) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:158:33: ',' decls= formalParameterDecls
                    {
                    char_literal8=(Token)match(input,29,FOLLOW_29_in_formalParameterDecls413); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (Object)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);
                    }
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls417);
                    decls=formalParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                       retval.element =decls.element; 
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                  		if(retval.element == null) {
                       		retval.element =new ArrayList<FormalParameter>();
                       	}
              			
              			FormalParameter param = 
              				new FormalParameter(new SimpleNameSignature((name!=null?name.getText():null)),(t!=null?t.value:null));
              			
              			retval.element.add(0,param);
                       
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, formalParameterDecls_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "formalParameterDecls"

    public static class connectorDeclaration_return extends ParserRuleReturnScope {
        public Connector element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectorDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:177:1: connectorDeclaration returns [Connector element] : conkw= 'connector' name= Identifier connectorBody[$element] ;
    public final MstageParser.connectorDeclaration_return connectorDeclaration() throws RecognitionException {
        MstageParser.connectorDeclaration_return retval = new MstageParser.connectorDeclaration_return();
        retval.start = input.LT(1);
        int connectorDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token conkw=null;
        Token name=null;
        MstageParser.connectorBody_return connectorBody9 = null;


        Object conkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:178:2: (conkw= 'connector' name= Identifier connectorBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:178:4: conkw= 'connector' name= Identifier connectorBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            conkw=(Token)match(input,30,FOLLOW_30_in_connectorDeclaration451); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            conkw_tree = (Object)adaptor.create(conkw);
            adaptor.addChild(root_0, conkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration455); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Connector(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,conkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration459);
            connectorBody9=connectorBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorBody9.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, connectorDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "connectorDeclaration"

    public static class connectorBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectorBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:186:1: connectorBody[Connector element] : '{' ( connectorBodyDeclaration[$element] )* '}' ;
    public final MstageParser.connectorBody_return connectorBody(Connector element) throws RecognitionException {
        MstageParser.connectorBody_return retval = new MstageParser.connectorBody_return();
        retval.start = input.LT(1);
        int connectorBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal10=null;
        Token char_literal12=null;
        MstageParser.connectorBodyDeclaration_return connectorBodyDeclaration11 = null;


        Object char_literal10_tree=null;
        Object char_literal12_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:187:2: ( '{' ( connectorBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:187:4: '{' ( connectorBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal10=(Token)match(input,24,FOLLOW_24_in_connectorBody473); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal10_tree = (Object)adaptor.create(char_literal10);
            adaptor.addChild(root_0, char_literal10_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:187:9: ( connectorBodyDeclaration[$element] )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==31||LA6_0==42) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: connectorBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_connectorBodyDeclaration_in_connectorBody476);
            	    connectorBodyDeclaration11=connectorBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorBodyDeclaration11.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            char_literal12=(Token)match(input,25,FOLLOW_25_in_connectorBody481); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, connectorBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "connectorBody"

    public static class connectorBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectorBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:191:1: connectorBodyDeclaration[Connector element] : ( connectorAOCompositionDeclaration[$element] | moduleRequireDependencyDeclaration[$element] );
    public final MstageParser.connectorBodyDeclaration_return connectorBodyDeclaration(Connector element) throws RecognitionException {
        MstageParser.connectorBodyDeclaration_return retval = new MstageParser.connectorBodyDeclaration_return();
        retval.start = input.LT(1);
        int connectorBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.connectorAOCompositionDeclaration_return connectorAOCompositionDeclaration13 = null;

        MstageParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration14 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:192:2: ( connectorAOCompositionDeclaration[$element] | moduleRequireDependencyDeclaration[$element] )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==31) ) {
                alt7=1;
            }
            else if ( (LA7_0==42) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:192:4: connectorAOCompositionDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration494);
                    connectorAOCompositionDeclaration13=connectorAOCompositionDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorAOCompositionDeclaration13.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:193:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration500);
                    moduleRequireDependencyDeclaration14=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration14.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 11, connectorBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "connectorBodyDeclaration"

    public static class connectorAOCompositionDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectorAOCompositionDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:197:1: connectorAOCompositionDeclaration[Connector element] : kw= 'ao-composition' name= Identifier aoc= connectorAOCompositionBody ;
    public final MstageParser.connectorAOCompositionDeclaration_return connectorAOCompositionDeclaration(Connector element) throws RecognitionException {
        MstageParser.connectorAOCompositionDeclaration_return retval = new MstageParser.connectorAOCompositionDeclaration_return();
        retval.start = input.LT(1);
        int connectorAOCompositionDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token kw=null;
        Token name=null;
        MstageParser.connectorAOCompositionBody_return aoc = null;


        Object kw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:198:2: (kw= 'ao-composition' name= Identifier aoc= connectorAOCompositionBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:198:4: kw= 'ao-composition' name= Identifier aoc= connectorAOCompositionBody
            {
            root_0 = (Object)adaptor.nil();

            kw=(Token)match(input,31,FOLLOW_31_in_connectorAOCompositionDeclaration518); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kw_tree = (Object)adaptor.create(kw);
            adaptor.addChild(root_0, kw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorAOCompositionDeclaration522); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration526);
            aoc=connectorAOCompositionBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aoc.getTree());
            if ( state.backtracking==0 ) {

              			AOComposition composition = new AOComposition(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(composition,kw);
              			setLocation(composition,name,"__NAME");
              			
              			composition.setAdvice((aoc!=null?aoc.advice:null));
              			composition.setPointcut((aoc!=null?aoc.pointcut:null));
              			
              			element.addComposition(composition);
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, connectorAOCompositionDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "connectorAOCompositionDeclaration"

    public static class connectorAOCompositionBody_return extends ParserRuleReturnScope {
        public Pointcut pointcut;
        public Advice advice;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectorAOCompositionBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:211:1: connectorAOCompositionBody returns [Pointcut pointcut, Advice advice] : '{' pc= pointcutDeclaration adv= adviceDeclaration '}' ;
    public final MstageParser.connectorAOCompositionBody_return connectorAOCompositionBody() throws RecognitionException {
        MstageParser.connectorAOCompositionBody_return retval = new MstageParser.connectorAOCompositionBody_return();
        retval.start = input.LT(1);
        int connectorAOCompositionBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal15=null;
        Token char_literal16=null;
        MstageParser.pointcutDeclaration_return pc = null;

        MstageParser.adviceDeclaration_return adv = null;


        Object char_literal15_tree=null;
        Object char_literal16_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:212:2: ( '{' pc= pointcutDeclaration adv= adviceDeclaration '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:212:4: '{' pc= pointcutDeclaration adv= adviceDeclaration '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal15=(Token)match(input,24,FOLLOW_24_in_connectorAOCompositionBody544); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal15_tree = (Object)adaptor.create(char_literal15);
            adaptor.addChild(root_0, char_literal15_tree);
            }
            pushFollow(FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody548);
            pc=pointcutDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pc.getTree());
            if ( state.backtracking==0 ) {

              				retval.pointcut = (pc!=null?pc.pointcut:null);
              			
            }
            pushFollow(FOLLOW_adviceDeclaration_in_connectorAOCompositionBody554);
            adv=adviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, adv.getTree());
            char_literal16=(Token)match(input,25,FOLLOW_25_in_connectorAOCompositionBody556); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.advice = (adv!=null?adv.advice:null);
              			
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, connectorAOCompositionBody_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:219:1: pointcutDeclaration returns [Pointcut pointcut] : 'pointcut' pointcutBody[$pointcut] ;
    public final MstageParser.pointcutDeclaration_return pointcutDeclaration() throws RecognitionException {
        MstageParser.pointcutDeclaration_return retval = new MstageParser.pointcutDeclaration_return();
        retval.start = input.LT(1);
        int pointcutDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal17=null;
        MstageParser.pointcutBody_return pointcutBody18 = null;


        Object string_literal17_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:220:2: ( 'pointcut' pointcutBody[$pointcut] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:220:4: 'pointcut' pointcutBody[$pointcut]
            {
            root_0 = (Object)adaptor.nil();

            string_literal17=(Token)match(input,32,FOLLOW_32_in_pointcutDeclaration573); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal17_tree = (Object)adaptor.create(string_literal17);
            adaptor.addChild(root_0, string_literal17_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.pointcut = new Pointcut();
              			
            }
            pushFollow(FOLLOW_pointcutBody_in_pointcutDeclaration577);
            pointcutBody18=pointcutBody(retval.pointcut);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBody18.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, pointcutDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutDeclaration"

    public static class pointcutBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:226:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
    public final MstageParser.pointcutBody_return pointcutBody(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutBody_return retval = new MstageParser.pointcutBody_return();
        retval.start = input.LT(1);
        int pointcutBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal19=null;
        Token char_literal21=null;
        MstageParser.pointcutBodyDeclaration_return pointcutBodyDeclaration20 = null;


        Object char_literal19_tree=null;
        Object char_literal21_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:227:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:227:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal19=(Token)match(input,24,FOLLOW_24_in_pointcutBody593); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:227:8: ( pointcutBodyDeclaration[$pointcut] )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==33||LA8_0==35) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: pointcutBodyDeclaration[$pointcut]
            	    {
            	    pushFollow(FOLLOW_pointcutBodyDeclaration_in_pointcutBody595);
            	    pointcutBodyDeclaration20=pointcutBodyDeclaration(pointcut);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBodyDeclaration20.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            char_literal21=(Token)match(input,25,FOLLOW_25_in_pointcutBody599); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 15, pointcutBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutBody"

    public static class pointcutBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:230:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] );
    public final MstageParser.pointcutBodyDeclaration_return pointcutBodyDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutBodyDeclaration_return retval = new MstageParser.pointcutBodyDeclaration_return();
        retval.start = input.LT(1);
        int pointcutBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.pointcutKindDeclaration_return pointcutKindDeclaration22 = null;

        MstageParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration23 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:231:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==33) ) {
                alt9=1;
            }
            else if ( (LA9_0==35) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:231:4: pointcutKindDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration612);
                    pointcutKindDeclaration22=pointcutKindDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutKindDeclaration22.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:232:4: pointcutSignatureDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration618);
                    pointcutSignatureDeclaration23=pointcutSignatureDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureDeclaration23.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 16, pointcutBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutBodyDeclaration"

    public static class pointcutKindDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutKindDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:237:1: pointcutKindDeclaration[Pointcut pointcut] : 'kind' ':' kind= joinpointKind ';' ;
    public final MstageParser.pointcutKindDeclaration_return pointcutKindDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutKindDeclaration_return retval = new MstageParser.pointcutKindDeclaration_return();
        retval.start = input.LT(1);
        int pointcutKindDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal24=null;
        Token char_literal25=null;
        Token char_literal26=null;
        MstageParser.joinpointKind_return kind = null;


        Object string_literal24_tree=null;
        Object char_literal25_tree=null;
        Object char_literal26_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:238:2: ( 'kind' ':' kind= joinpointKind ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:238:4: 'kind' ':' kind= joinpointKind ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal24=(Token)match(input,33,FOLLOW_33_in_pointcutKindDeclaration634); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal24_tree = (Object)adaptor.create(string_literal24);
            adaptor.addChild(root_0, string_literal24_tree);
            }
            char_literal25=(Token)match(input,34,FOLLOW_34_in_pointcutKindDeclaration636); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);
            }
            pushFollow(FOLLOW_joinpointKind_in_pointcutKindDeclaration640);
            kind=joinpointKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, kind.getTree());
            char_literal26=(Token)match(input,26,FOLLOW_26_in_pointcutKindDeclaration642); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal26_tree = (Object)adaptor.create(char_literal26);
            adaptor.addChild(root_0, char_literal26_tree);
            }
            if ( state.backtracking==0 ) {

              				pointcut.setKind((kind!=null?kind.value:null));
              			
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, pointcutKindDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutKindDeclaration"

    public static class pointcutSignatureDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutSignatureDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:243:1: pointcutSignatureDeclaration[Pointcut pointcut] : 'signature' ':' pattern= ( ( . )* ) ';' ;
    public final MstageParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutSignatureDeclaration_return retval = new MstageParser.pointcutSignatureDeclaration_return();
        retval.start = input.LT(1);
        int pointcutSignatureDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token pattern=null;
        Token string_literal27=null;
        Token char_literal28=null;
        Token wildcard29=null;
        Token char_literal30=null;

        Object pattern_tree=null;
        Object string_literal27_tree=null;
        Object char_literal28_tree=null;
        Object wildcard29_tree=null;
        Object char_literal30_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:244:2: ( 'signature' ':' pattern= ( ( . )* ) ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:244:4: 'signature' ':' pattern= ( ( . )* ) ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal27=(Token)match(input,35,FOLLOW_35_in_pointcutSignatureDeclaration657); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal27_tree = (Object)adaptor.create(string_literal27);
            adaptor.addChild(root_0, string_literal27_tree);
            }
            char_literal28=(Token)match(input,34,FOLLOW_34_in_pointcutSignatureDeclaration659); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:244:28: ( ( . )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:244:29: ( . )*
            {
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:244:29: ( . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26) ) {
                    int LA10_1 = input.LA(2);

                    if ( (synpred17_Mstage()) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>=Identifier && LA10_0<=25)||(LA10_0>=27 && LA10_0<=75)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: .
            	    {
            	    wildcard29=(Token)input.LT(1);
            	    matchAny(input); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    wildcard29_tree = (Object)adaptor.create(wildcard29);
            	    adaptor.addChild(root_0, wildcard29_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            char_literal30=(Token)match(input,26,FOLLOW_26_in_pointcutSignatureDeclaration668); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal30_tree = (Object)adaptor.create(char_literal30);
            adaptor.addChild(root_0, char_literal30_tree);
            }
            if ( state.backtracking==0 ) {

              				JoinPoint jp = new PatternJoinPoint((pattern!=null?pattern.getText():null));
              				System.out.println((pattern!=null?pattern.getText():null));
              				pointcut.addJoinPoint(jp);
              			
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, pointcutSignatureDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutSignatureDeclaration"

    public static class pointcutCallerDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutCallerDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:258:1: pointcutCallerDeclaration[Pointcut pointcut] : 'caller' ;
    public final MstageParser.pointcutCallerDeclaration_return pointcutCallerDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutCallerDeclaration_return retval = new MstageParser.pointcutCallerDeclaration_return();
        retval.start = input.LT(1);
        int pointcutCallerDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal31=null;

        Object string_literal31_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:259:2: ( 'caller' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:259:4: 'caller'
            {
            root_0 = (Object)adaptor.nil();

            string_literal31=(Token)match(input,36,FOLLOW_36_in_pointcutCallerDeclaration688); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal31_tree = (Object)adaptor.create(string_literal31);
            adaptor.addChild(root_0, string_literal31_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, pointcutCallerDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutCallerDeclaration"

    public static class pointcutCalleeDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutCalleeDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:262:1: pointcutCalleeDeclaration[Pointcut pointcut] : 'callee' ;
    public final MstageParser.pointcutCalleeDeclaration_return pointcutCalleeDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutCalleeDeclaration_return retval = new MstageParser.pointcutCalleeDeclaration_return();
        retval.start = input.LT(1);
        int pointcutCalleeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal32=null;

        Object string_literal32_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:263:2: ( 'callee' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:263:4: 'callee'
            {
            root_0 = (Object)adaptor.nil();

            string_literal32=(Token)match(input,37,FOLLOW_37_in_pointcutCalleeDeclaration701); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal32_tree = (Object)adaptor.create(string_literal32);
            adaptor.addChild(root_0, string_literal32_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, pointcutCalleeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutCalleeDeclaration"

    public static class adviceDeclaration_return extends ParserRuleReturnScope {
        public Advice advice;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:267:1: adviceDeclaration returns [Advice advice] : 'advice' adviceBody[$advice] ;
    public final MstageParser.adviceDeclaration_return adviceDeclaration() throws RecognitionException {
        MstageParser.adviceDeclaration_return retval = new MstageParser.adviceDeclaration_return();
        retval.start = input.LT(1);
        int adviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal33=null;
        MstageParser.adviceBody_return adviceBody34 = null;


        Object string_literal33_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:268:2: ( 'advice' adviceBody[$advice] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:268:4: 'advice' adviceBody[$advice]
            {
            root_0 = (Object)adaptor.nil();

            string_literal33=(Token)match(input,38,FOLLOW_38_in_adviceDeclaration719); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal33_tree = (Object)adaptor.create(string_literal33);
            adaptor.addChild(root_0, string_literal33_tree);
            }
            if ( state.backtracking==0 ) {
               
              				retval.advice = new Advice(); 
              				System.out.println("construct advice "+retval.advice);				
              			
            }
            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration723);
            adviceBody34=adviceBody(retval.advice);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBody34.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, adviceDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceDeclaration"

    public static class adviceBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:274:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
    public final MstageParser.adviceBody_return adviceBody(Advice advice) throws RecognitionException {
        MstageParser.adviceBody_return retval = new MstageParser.adviceBody_return();
        retval.start = input.LT(1);
        int adviceBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal35=null;
        Token char_literal37=null;
        MstageParser.adviceBodyDeclaration_return adviceBodyDeclaration36 = null;


        Object char_literal35_tree=null;
        Object char_literal37_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:275:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:275:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal35=(Token)match(input,24,FOLLOW_24_in_adviceBody736); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal35_tree = (Object)adaptor.create(char_literal35);
            adaptor.addChild(root_0, char_literal35_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:275:8: ( adviceBodyDeclaration[$advice] )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=39 && LA11_0<=40)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: adviceBodyDeclaration[$advice]
            	    {
            	    pushFollow(FOLLOW_adviceBodyDeclaration_in_adviceBody738);
            	    adviceBodyDeclaration36=adviceBodyDeclaration(advice);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBodyDeclaration36.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            char_literal37=(Token)match(input,25,FOLLOW_25_in_adviceBody742); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 22, adviceBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceBody"

    public static class adviceBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:278:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] );
    public final MstageParser.adviceBodyDeclaration_return adviceBodyDeclaration(Advice advice) throws RecognitionException {
        MstageParser.adviceBodyDeclaration_return retval = new MstageParser.adviceBodyDeclaration_return();
        retval.start = input.LT(1);
        int adviceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.adviceServiceDeclaration_return adviceServiceDeclaration38 = null;

        MstageParser.adviceTypeDeclaration_return adviceTypeDeclaration39 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:279:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==39) ) {
                alt12=1;
            }
            else if ( (LA12_0==40) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:279:4: adviceServiceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration755);
                    adviceServiceDeclaration38=adviceServiceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceServiceDeclaration38.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:280:4: adviceTypeDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration761);
                    adviceTypeDeclaration39=adviceTypeDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceTypeDeclaration39.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 23, adviceBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceBodyDeclaration"

    public static class adviceServiceDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceServiceDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:283:1: adviceServiceDeclaration[Advice advice] : 'service' ':' service= ( ( . )* ) ';' ;
    public final MstageParser.adviceServiceDeclaration_return adviceServiceDeclaration(Advice advice) throws RecognitionException {
        MstageParser.adviceServiceDeclaration_return retval = new MstageParser.adviceServiceDeclaration_return();
        retval.start = input.LT(1);
        int adviceServiceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token service=null;
        Token string_literal40=null;
        Token char_literal41=null;
        Token wildcard42=null;
        Token char_literal43=null;

        Object service_tree=null;
        Object string_literal40_tree=null;
        Object char_literal41_tree=null;
        Object wildcard42_tree=null;
        Object char_literal43_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:284:2: ( 'service' ':' service= ( ( . )* ) ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:284:4: 'service' ':' service= ( ( . )* ) ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal40=(Token)match(input,39,FOLLOW_39_in_adviceServiceDeclaration775); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal40_tree = (Object)adaptor.create(string_literal40);
            adaptor.addChild(root_0, string_literal40_tree);
            }
            char_literal41=(Token)match(input,34,FOLLOW_34_in_adviceServiceDeclaration777); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = (Object)adaptor.create(char_literal41);
            adaptor.addChild(root_0, char_literal41_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:284:26: ( ( . )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:284:27: ( . )*
            {
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:284:27: ( . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) ) {
                    int LA13_1 = input.LA(2);

                    if ( (synpred20_Mstage()) ) {
                        alt13=1;
                    }


                }
                else if ( ((LA13_0>=Identifier && LA13_0<=25)||(LA13_0>=27 && LA13_0<=75)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: .
            	    {
            	    wildcard42=(Token)input.LT(1);
            	    matchAny(input); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    wildcard42_tree = (Object)adaptor.create(wildcard42);
            	    adaptor.addChild(root_0, wildcard42_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            char_literal43=(Token)match(input,26,FOLLOW_26_in_adviceServiceDeclaration786); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal43_tree = (Object)adaptor.create(char_literal43);
            adaptor.addChild(root_0, char_literal43_tree);
            }
            if ( state.backtracking==0 ) {

              			advice.setService(new SimpleReference((service!=null?service.getText():null),Service.class));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, adviceServiceDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceServiceDeclaration"

    public static class adviceTypeDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceTypeDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:289:1: adviceTypeDeclaration[Advice advice] : 'type' ':' advtype= adviceType ';' ;
    public final MstageParser.adviceTypeDeclaration_return adviceTypeDeclaration(Advice advice) throws RecognitionException {
        MstageParser.adviceTypeDeclaration_return retval = new MstageParser.adviceTypeDeclaration_return();
        retval.start = input.LT(1);
        int adviceTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal44=null;
        Token char_literal45=null;
        Token char_literal46=null;
        MstageParser.adviceType_return advtype = null;


        Object string_literal44_tree=null;
        Object char_literal45_tree=null;
        Object char_literal46_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:290:2: ( 'type' ':' advtype= adviceType ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:290:4: 'type' ':' advtype= adviceType ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal44=(Token)match(input,40,FOLLOW_40_in_adviceTypeDeclaration801); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal44_tree = (Object)adaptor.create(string_literal44);
            adaptor.addChild(root_0, string_literal44_tree);
            }
            char_literal45=(Token)match(input,34,FOLLOW_34_in_adviceTypeDeclaration803); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal45_tree = (Object)adaptor.create(char_literal45);
            adaptor.addChild(root_0, char_literal45_tree);
            }
            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration807);
            advtype=adviceType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, advtype.getTree());
            char_literal46=(Token)match(input,26,FOLLOW_26_in_adviceTypeDeclaration809); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal46_tree = (Object)adaptor.create(char_literal46);
            adaptor.addChild(root_0, char_literal46_tree);
            }
            if ( state.backtracking==0 ) {

              			advice.setType((advtype!=null?advtype.value:null));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, adviceTypeDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:301:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier componentBody[$element] ;
    public final MstageParser.componentDeclaration_return componentDeclaration() throws RecognitionException {
        MstageParser.componentDeclaration_return retval = new MstageParser.componentDeclaration_return();
        retval.start = input.LT(1);
        int componentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token compkw=null;
        Token name=null;
        MstageParser.componentBody_return componentBody47 = null;


        Object compkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:302:2: (compkw= 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:302:5: compkw= 'component' name= Identifier componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            compkw=(Token)match(input,41,FOLLOW_41_in_componentDeclaration836); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            compkw_tree = (Object)adaptor.create(compkw);
            adaptor.addChild(root_0, compkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration840); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                  			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                  			setKeyword(retval.element,compkw);
                  			setLocation(retval.element,name,"__NAME");
              			
            }
            pushFollow(FOLLOW_componentBody_in_componentDeclaration844);
            componentBody47=componentBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBody47.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, componentDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentDeclaration"

    public static class componentBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:310:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
    public final MstageParser.componentBody_return componentBody(Component element) throws RecognitionException {
        MstageParser.componentBody_return retval = new MstageParser.componentBody_return();
        retval.start = input.LT(1);
        int componentBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal48=null;
        Token char_literal50=null;
        MstageParser.componentBodyDeclaration_return componentBodyDeclaration49 = null;


        Object char_literal48_tree=null;
        Object char_literal50_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:311:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:311:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal48=(Token)match(input,24,FOLLOW_24_in_componentBody866); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal48_tree = (Object)adaptor.create(char_literal48);
            adaptor.addChild(root_0, char_literal48_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:311:8: ( componentBodyDeclaration[$element] )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=42 && LA14_0<=43)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody868);
            	    componentBodyDeclaration49=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration49.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            char_literal50=(Token)match(input,25,FOLLOW_25_in_componentBody872); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal50_tree = (Object)adaptor.create(char_literal50);
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
            if ( state.backtracking>0 ) { memoize(input, 27, componentBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentBody"

    public static class componentBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:315:1: componentBodyDeclaration[Component element] : ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] );
    public final MstageParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MstageParser.componentBodyDeclaration_return retval = new MstageParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);
        int componentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration51 = null;

        MstageParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration52 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:316:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==42) ) {
                alt15=1;
            }
            else if ( (LA15_0==43) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:316:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration890);
                    moduleRequireDependencyDeclaration51=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration51.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:317:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration896);
                    moduleProvideDependencyDeclaration52=moduleProvideDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleProvideDependencyDeclaration52.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 28, componentBodyDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:330:1: moduleDependencyBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' ;
    public final MstageParser.moduleDependencyBody_return moduleDependencyBody() throws RecognitionException {
        MstageParser.moduleDependencyBody_return retval = new MstageParser.moduleDependencyBody_return();
        retval.start = input.LT(1);
        int moduleDependencyBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal53=null;
        Token char_literal54=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal53_tree=null;
        Object char_literal54_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:332:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:332:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal53=(Token)match(input,24,FOLLOW_24_in_moduleDependencyBody927); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal53_tree = (Object)adaptor.create(char_literal53);
            adaptor.addChild(root_0, char_literal53_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:332:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==Identifier) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:332:9: decls= commaSeparatedBodyDecls[Interface.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody932);
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

            char_literal54=(Token)match(input,25,FOLLOW_25_in_moduleDependencyBody940); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal54_tree = (Object)adaptor.create(char_literal54);
            adaptor.addChild(root_0, char_literal54_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, moduleDependencyBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "moduleDependencyBody"

    public static class moduleRequireDependencyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleRequireDependencyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:336:1: moduleRequireDependencyDeclaration[Module element] : 'require' rd= moduleDependencyBody ;
    public final MstageParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration(Module element) throws RecognitionException {
        MstageParser.moduleRequireDependencyDeclaration_return retval = new MstageParser.moduleRequireDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleRequireDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal55=null;
        MstageParser.moduleDependencyBody_return rd = null;


        Object string_literal55_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:337:2: ( 'require' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:337:4: 'require' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal55=(Token)match(input,42,FOLLOW_42_in_moduleRequireDependencyDeclaration955); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal55_tree = (Object)adaptor.create(string_literal55);
            adaptor.addChild(root_0, string_literal55_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration959);
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
            if ( state.backtracking>0 ) { memoize(input, 30, moduleRequireDependencyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "moduleRequireDependencyDeclaration"

    public static class moduleProvideDependencyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleProvideDependencyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:345:1: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
    public final MstageParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration(Module element) throws RecognitionException {
        MstageParser.moduleProvideDependencyDeclaration_return retval = new MstageParser.moduleProvideDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleProvideDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal56=null;
        MstageParser.moduleDependencyBody_return rd = null;


        Object string_literal56_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:4: 'provide' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal56=(Token)match(input,43,FOLLOW_43_in_moduleProvideDependencyDeclaration974); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal56_tree = (Object)adaptor.create(string_literal56);
            adaptor.addChild(root_0, string_literal56_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration978);
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
            if ( state.backtracking>0 ) { memoize(input, 31, moduleProvideDependencyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "moduleProvideDependencyDeclaration"

    public static class compositeDeclaration_return extends ParserRuleReturnScope {
        public Composite element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compositeDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:361:1: compositeDeclaration returns [Composite element] : cmkw= 'composite' name= Identifier compositeBody[$element] ;
    public final MstageParser.compositeDeclaration_return compositeDeclaration() throws RecognitionException {
        MstageParser.compositeDeclaration_return retval = new MstageParser.compositeDeclaration_return();
        retval.start = input.LT(1);
        int compositeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token cmkw=null;
        Token name=null;
        MstageParser.compositeBody_return compositeBody57 = null;


        Object cmkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:362:2: (cmkw= 'composite' name= Identifier compositeBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:362:4: cmkw= 'composite' name= Identifier compositeBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            cmkw=(Token)match(input,44,FOLLOW_44_in_compositeDeclaration1007); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            cmkw_tree = (Object)adaptor.create(cmkw);
            adaptor.addChild(root_0, cmkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_compositeDeclaration1011); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.element = new Composite(new SimpleNameSignature((name!=null?name.getText():null)));
                  			setKeyword(retval.element,cmkw);
                  			setLocation(retval.element,name,"__NAME");
              			
            }
            pushFollow(FOLLOW_compositeBody_in_compositeDeclaration1017);
            compositeBody57=compositeBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, compositeBody57.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, compositeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compositeDeclaration"

    public static class compositeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compositeBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:1: compositeBody[Composite element] : '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}' ;
    public final MstageParser.compositeBody_return compositeBody(Composite element) throws RecognitionException {
        MstageParser.compositeBody_return retval = new MstageParser.compositeBody_return();
        retval.start = input.LT(1);
        int compositeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal58=null;
        Token char_literal61=null;
        MstageParser.compositeBodyDeclaration_return compositeBodyDeclaration59 = null;

        MstageParser.componentBodyDeclaration_return componentBodyDeclaration60 = null;


        Object char_literal58_tree=null;
        Object char_literal61_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:372:2: ( '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:372:4: '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal58=(Token)match(input,24,FOLLOW_24_in_compositeBody1031); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal58_tree = (Object)adaptor.create(char_literal58);
            adaptor.addChild(root_0, char_literal58_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:372:8: ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==47) ) {
                    alt17=1;
                }
                else if ( ((LA17_0>=42 && LA17_0<=43)) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:372:9: compositeBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_compositeBodyDeclaration_in_compositeBody1034);
            	    compositeBodyDeclaration59=compositeBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compositeBodyDeclaration59.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:372:46: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_compositeBody1039);
            	    componentBodyDeclaration60=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration60.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            char_literal61=(Token)match(input,25,FOLLOW_25_in_compositeBody1044); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 33, compositeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compositeBody"

    public static class compositeBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compositeBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:376:1: compositeBodyDeclaration[Composite element] : modulecontainerDeclaration[$element] ;
    public final MstageParser.compositeBodyDeclaration_return compositeBodyDeclaration(Composite element) throws RecognitionException {
        MstageParser.compositeBodyDeclaration_return retval = new MstageParser.compositeBodyDeclaration_return();
        retval.start = input.LT(1);
        int compositeBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.modulecontainerDeclaration_return modulecontainerDeclaration62 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:377:2: ( modulecontainerDeclaration[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:377:4: modulecontainerDeclaration[$element]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_modulecontainerDeclaration_in_compositeBodyDeclaration1057);
            modulecontainerDeclaration62=modulecontainerDeclaration(element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, modulecontainerDeclaration62.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, compositeBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compositeBodyDeclaration"

    public static class applicationDeclaration_return extends ParserRuleReturnScope {
        public Application element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "applicationDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:387:1: applicationDeclaration returns [Application element] : appkw= 'application' name= Identifier applicationBody[$element] ;
    public final MstageParser.applicationDeclaration_return applicationDeclaration() throws RecognitionException {
        MstageParser.applicationDeclaration_return retval = new MstageParser.applicationDeclaration_return();
        retval.start = input.LT(1);
        int applicationDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token appkw=null;
        Token name=null;
        MstageParser.applicationBody_return applicationBody63 = null;


        Object appkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:388:2: (appkw= 'application' name= Identifier applicationBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:388:4: appkw= 'application' name= Identifier applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            appkw=(Token)match(input,45,FOLLOW_45_in_applicationDeclaration1081); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_applicationDeclaration1085); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.element = new Application(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,appkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_applicationBody_in_applicationDeclaration1089);
            applicationBody63=applicationBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBody63.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, applicationDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "applicationDeclaration"

    public static class applicationBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "applicationBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:395:1: applicationBody[Application element] : '{' ( applicationBodyDeclaration[$element] )* '}' ;
    public final MstageParser.applicationBody_return applicationBody(Application element) throws RecognitionException {
        MstageParser.applicationBody_return retval = new MstageParser.applicationBody_return();
        retval.start = input.LT(1);
        int applicationBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal64=null;
        Token char_literal66=null;
        MstageParser.applicationBodyDeclaration_return applicationBodyDeclaration65 = null;


        Object char_literal64_tree=null;
        Object char_literal66_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:396:2: ( '{' ( applicationBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:396:4: '{' ( applicationBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal64=(Token)match(input,24,FOLLOW_24_in_applicationBody1102); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:396:8: ( applicationBodyDeclaration[$element] )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==47||(LA18_0>=51 && LA18_0<=52)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: applicationBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_applicationBodyDeclaration_in_applicationBody1104);
            	    applicationBodyDeclaration65=applicationBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBodyDeclaration65.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            char_literal66=(Token)match(input,25,FOLLOW_25_in_applicationBody1108); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal66_tree = (Object)adaptor.create(char_literal66);
            adaptor.addChild(root_0, char_literal66_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, applicationBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "applicationBody"

    public static class applicationBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "applicationBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:400:1: applicationBodyDeclaration[Application element] : ( modulecontainerDeclaration[$element] | locateDeclaration[$element] );
    public final MstageParser.applicationBodyDeclaration_return applicationBodyDeclaration(Application element) throws RecognitionException {
        MstageParser.applicationBodyDeclaration_return retval = new MstageParser.applicationBodyDeclaration_return();
        retval.start = input.LT(1);
        int applicationBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.modulecontainerDeclaration_return modulecontainerDeclaration67 = null;

        MstageParser.locateDeclaration_return locateDeclaration68 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:401:2: ( modulecontainerDeclaration[$element] | locateDeclaration[$element] )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==47) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=51 && LA19_0<=52)) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:401:4: modulecontainerDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_modulecontainerDeclaration_in_applicationBodyDeclaration1121);
                    modulecontainerDeclaration67=modulecontainerDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modulecontainerDeclaration67.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:402:4: locateDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_locateDeclaration_in_applicationBodyDeclaration1127);
                    locateDeclaration68=locateDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, locateDeclaration68.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 37, applicationBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "applicationBodyDeclaration"

    public static class locateDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "locateDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:406:1: locateDeclaration[Application element] : mappingDeclaration[$element, Module.class, AbstractHost.class] ;
    public final MstageParser.locateDeclaration_return locateDeclaration(Application element) throws RecognitionException {
        MstageParser.locateDeclaration_return retval = new MstageParser.locateDeclaration_return();
        retval.start = input.LT(1);
        int locateDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.mappingDeclaration_return mappingDeclaration69 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:407:2: ( mappingDeclaration[$element, Module.class, AbstractHost.class] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:407:4: mappingDeclaration[$element, Module.class, AbstractHost.class]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mappingDeclaration_in_locateDeclaration1143);
            mappingDeclaration69=mappingDeclaration(element, Module.class, AbstractHost.class);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mappingDeclaration69.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, locateDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "locateDeclaration"

    public static class deploymentDeclaration_return extends ParserRuleReturnScope {
        public Deployment element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deploymentDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:418:1: deploymentDeclaration returns [Deployment element] : depkw= 'deployment' name= Identifier deploymentBody[$element] ;
    public final MstageParser.deploymentDeclaration_return deploymentDeclaration() throws RecognitionException {
        MstageParser.deploymentDeclaration_return retval = new MstageParser.deploymentDeclaration_return();
        retval.start = input.LT(1);
        int deploymentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token depkw=null;
        Token name=null;
        MstageParser.deploymentBody_return deploymentBody70 = null;


        Object depkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:419:2: (depkw= 'deployment' name= Identifier deploymentBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:419:4: depkw= 'deployment' name= Identifier deploymentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            depkw=(Token)match(input,46,FOLLOW_46_in_deploymentDeclaration1168); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            depkw_tree = (Object)adaptor.create(depkw);
            adaptor.addChild(root_0, depkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_deploymentDeclaration1172); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.element = new Deployment(new SimpleNameSignature((name!=null?name.getText():null))); 
              			setKeyword(retval.element,depkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_deploymentBody_in_deploymentDeclaration1176);
            deploymentBody70=deploymentBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, deploymentBody70.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, deploymentDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "deploymentDeclaration"

    public static class deploymentBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deploymentBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:426:1: deploymentBody[Deployment element] : '{' ( deploymentBodyDeclaration[$element] )* '}' ;
    public final MstageParser.deploymentBody_return deploymentBody(Deployment element) throws RecognitionException {
        MstageParser.deploymentBody_return retval = new MstageParser.deploymentBody_return();
        retval.start = input.LT(1);
        int deploymentBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal71=null;
        Token char_literal73=null;
        MstageParser.deploymentBodyDeclaration_return deploymentBodyDeclaration72 = null;


        Object char_literal71_tree=null;
        Object char_literal73_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:427:2: ( '{' ( deploymentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:427:4: '{' ( deploymentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal71=(Token)match(input,24,FOLLOW_24_in_deploymentBody1189); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal71_tree = (Object)adaptor.create(char_literal71);
            adaptor.addChild(root_0, char_literal71_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:427:8: ( deploymentBodyDeclaration[$element] )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==47||(LA20_0>=51 && LA20_0<=52)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: deploymentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_deploymentBodyDeclaration_in_deploymentBody1191);
            	    deploymentBodyDeclaration72=deploymentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, deploymentBodyDeclaration72.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            char_literal73=(Token)match(input,25,FOLLOW_25_in_deploymentBody1195); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal73_tree = (Object)adaptor.create(char_literal73);
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
            if ( state.backtracking>0 ) { memoize(input, 40, deploymentBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "deploymentBody"

    public static class deploymentBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deploymentBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:431:1: deploymentBodyDeclaration[Deployment element] : ( appcontainDeclaration[$element] | hostMapDeclaration[$element] );
    public final MstageParser.deploymentBodyDeclaration_return deploymentBodyDeclaration(Deployment element) throws RecognitionException {
        MstageParser.deploymentBodyDeclaration_return retval = new MstageParser.deploymentBodyDeclaration_return();
        retval.start = input.LT(1);
        int deploymentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.appcontainDeclaration_return appcontainDeclaration74 = null;

        MstageParser.hostMapDeclaration_return hostMapDeclaration75 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:432:2: ( appcontainDeclaration[$element] | hostMapDeclaration[$element] )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==47) ) {
                alt21=1;
            }
            else if ( ((LA21_0>=51 && LA21_0<=52)) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:432:4: appcontainDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_appcontainDeclaration_in_deploymentBodyDeclaration1208);
                    appcontainDeclaration74=appcontainDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, appcontainDeclaration74.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:433:4: hostMapDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hostMapDeclaration_in_deploymentBodyDeclaration1214);
                    hostMapDeclaration75=hostMapDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hostMapDeclaration75.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 41, deploymentBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "deploymentBodyDeclaration"

    public static class appcontainDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "appcontainDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:437:1: appcontainDeclaration[Deployment element] : ctkw= 'contain' conts= appcontainBody ;
    public final MstageParser.appcontainDeclaration_return appcontainDeclaration(Deployment element) throws RecognitionException {
        MstageParser.appcontainDeclaration_return retval = new MstageParser.appcontainDeclaration_return();
        retval.start = input.LT(1);
        int appcontainDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token ctkw=null;
        MstageParser.appcontainBody_return conts = null;


        Object ctkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:438:2: (ctkw= 'contain' conts= appcontainBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:438:4: ctkw= 'contain' conts= appcontainBody
            {
            root_0 = (Object)adaptor.nil();

            ctkw=(Token)match(input,47,FOLLOW_47_in_appcontainDeclaration1232); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ctkw_tree = (Object)adaptor.create(ctkw);
            adaptor.addChild(root_0, ctkw_tree);
            }
            pushFollow(FOLLOW_appcontainBody_in_appcontainDeclaration1236);
            conts=appcontainBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, conts.getTree());
            if ( state.backtracking==0 ) {


              			for(SimpleReference<Application> app : (conts!=null?conts.elements:null)) {
              				element.addApplication(app);
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
            if ( state.backtracking>0 ) { memoize(input, 42, appcontainDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "appcontainDeclaration"

    public static class appcontainBody_return extends ParserRuleReturnScope {
        public List<SimpleReference> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "appcontainBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:447:1: appcontainBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Application.class] )? '}' ;
    public final MstageParser.appcontainBody_return appcontainBody() throws RecognitionException {
        MstageParser.appcontainBody_return retval = new MstageParser.appcontainBody_return();
        retval.start = input.LT(1);
        int appcontainBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal76=null;
        Token char_literal77=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal76_tree=null;
        Object char_literal77_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:449:2: ( '{' (decls= commaSeparatedBodyDecls[Application.class] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:449:4: '{' (decls= commaSeparatedBodyDecls[Application.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal76=(Token)match(input,24,FOLLOW_24_in_appcontainBody1259); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal76_tree = (Object)adaptor.create(char_literal76);
            adaptor.addChild(root_0, char_literal76_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:449:8: (decls= commaSeparatedBodyDecls[Application.class] )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Identifier) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:449:9: decls= commaSeparatedBodyDecls[Application.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_appcontainBody1264);
                    decls=commaSeparatedBodyDecls(Application.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                      retval.elements =(decls!=null?decls.elements:null);
                    }

                    }
                    break;

            }

            char_literal77=(Token)match(input,25,FOLLOW_25_in_appcontainBody1272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal77_tree = (Object)adaptor.create(char_literal77);
            adaptor.addChild(root_0, char_literal77_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, appcontainBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "appcontainBody"

    public static class hostMapDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hostMapDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:453:1: hostMapDeclaration[Deployment element] : mappingDeclaration[$element, AbstractHost.class, PhysicalHost.class] ;
    public final MstageParser.hostMapDeclaration_return hostMapDeclaration(Deployment element) throws RecognitionException {
        MstageParser.hostMapDeclaration_return retval = new MstageParser.hostMapDeclaration_return();
        retval.start = input.LT(1);
        int hostMapDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.mappingDeclaration_return mappingDeclaration78 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:454:2: ( mappingDeclaration[$element, AbstractHost.class, PhysicalHost.class] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:454:4: mappingDeclaration[$element, AbstractHost.class, PhysicalHost.class]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mappingDeclaration_in_hostMapDeclaration1286);
            mappingDeclaration78=mappingDeclaration(element, AbstractHost.class, PhysicalHost.class);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mappingDeclaration78.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, hostMapDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "hostMapDeclaration"

    public static class abstractHostDeclaration_return extends ParserRuleReturnScope {
        public AbstractHost element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "abstractHostDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:463:1: abstractHostDeclaration returns [AbstractHost element] : ahkw= 'abstracthost' name= Identifier abstractHostBody[$element] ;
    public final MstageParser.abstractHostDeclaration_return abstractHostDeclaration() throws RecognitionException {
        MstageParser.abstractHostDeclaration_return retval = new MstageParser.abstractHostDeclaration_return();
        retval.start = input.LT(1);
        int abstractHostDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token ahkw=null;
        Token name=null;
        MstageParser.abstractHostBody_return abstractHostBody79 = null;


        Object ahkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:464:2: (ahkw= 'abstracthost' name= Identifier abstractHostBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:464:4: ahkw= 'abstracthost' name= Identifier abstractHostBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            ahkw=(Token)match(input,48,FOLLOW_48_in_abstractHostDeclaration1309); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ahkw_tree = (Object)adaptor.create(ahkw);
            adaptor.addChild(root_0, ahkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_abstractHostDeclaration1313); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new AbstractHost(new SimpleNameSignature((name!=null?name.getText():null)));
              	    	setKeyword(retval.element,ahkw);
                  		setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_abstractHostBody_in_abstractHostDeclaration1317);
            abstractHostBody79=abstractHostBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, abstractHostBody79.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, abstractHostDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "abstractHostDeclaration"

    public static class abstractHostBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "abstractHostBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:472:1: abstractHostBody[AbstractHost element] : '{' ( abstractHostBodyDeclaration[$element] )* '}' ;
    public final MstageParser.abstractHostBody_return abstractHostBody(AbstractHost element) throws RecognitionException {
        MstageParser.abstractHostBody_return retval = new MstageParser.abstractHostBody_return();
        retval.start = input.LT(1);
        int abstractHostBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal80=null;
        Token char_literal82=null;
        MstageParser.abstractHostBodyDeclaration_return abstractHostBodyDeclaration81 = null;


        Object char_literal80_tree=null;
        Object char_literal82_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:473:2: ( '{' ( abstractHostBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:473:4: '{' ( abstractHostBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal80=(Token)match(input,24,FOLLOW_24_in_abstractHostBody1333); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal80_tree = (Object)adaptor.create(char_literal80);
            adaptor.addChild(root_0, char_literal80_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:473:8: ( abstractHostBodyDeclaration[$element] )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==49) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: abstractHostBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_abstractHostBodyDeclaration_in_abstractHostBody1335);
            	    abstractHostBodyDeclaration81=abstractHostBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, abstractHostBodyDeclaration81.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            char_literal82=(Token)match(input,25,FOLLOW_25_in_abstractHostBody1339); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 46, abstractHostBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "abstractHostBody"

    public static class abstractHostBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "abstractHostBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:477:1: abstractHostBodyDeclaration[AbstractHost element] : 'none' ;
    public final MstageParser.abstractHostBodyDeclaration_return abstractHostBodyDeclaration(AbstractHost element) throws RecognitionException {
        MstageParser.abstractHostBodyDeclaration_return retval = new MstageParser.abstractHostBodyDeclaration_return();
        retval.start = input.LT(1);
        int abstractHostBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal83=null;

        Object string_literal83_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:478:2: ( 'none' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:478:4: 'none'
            {
            root_0 = (Object)adaptor.nil();

            string_literal83=(Token)match(input,49,FOLLOW_49_in_abstractHostBodyDeclaration1352); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal83_tree = (Object)adaptor.create(string_literal83);
            adaptor.addChild(root_0, string_literal83_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, abstractHostBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "abstractHostBodyDeclaration"

    public static class physicalHostDeclaration_return extends ParserRuleReturnScope {
        public PhysicalHost element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "physicalHostDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:488:1: physicalHostDeclaration returns [PhysicalHost element] : phkw= 'host' name= Identifier physicalHostBody[$element] ;
    public final MstageParser.physicalHostDeclaration_return physicalHostDeclaration() throws RecognitionException {
        MstageParser.physicalHostDeclaration_return retval = new MstageParser.physicalHostDeclaration_return();
        retval.start = input.LT(1);
        int physicalHostDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token phkw=null;
        Token name=null;
        MstageParser.physicalHostBody_return physicalHostBody84 = null;


        Object phkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:489:2: (phkw= 'host' name= Identifier physicalHostBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:489:4: phkw= 'host' name= Identifier physicalHostBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            phkw=(Token)match(input,50,FOLLOW_50_in_physicalHostDeclaration1375); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            phkw_tree = (Object)adaptor.create(phkw);
            adaptor.addChild(root_0, phkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_physicalHostDeclaration1379); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new PhysicalHost(new SimpleNameSignature((name!=null?name.getText():null)));
              	    	setKeyword(retval.element,phkw);
                  		setLocation(retval.element,name,"__NAME");	
              		
            }
            pushFollow(FOLLOW_physicalHostBody_in_physicalHostDeclaration1383);
            physicalHostBody84=physicalHostBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, physicalHostBody84.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 48, physicalHostDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "physicalHostDeclaration"

    public static class physicalHostBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "physicalHostBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:496:1: physicalHostBody[PhysicalHost element] : '{' ( physicalHostBodyDeclaration[$element] )* '}' ;
    public final MstageParser.physicalHostBody_return physicalHostBody(PhysicalHost element) throws RecognitionException {
        MstageParser.physicalHostBody_return retval = new MstageParser.physicalHostBody_return();
        retval.start = input.LT(1);
        int physicalHostBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal85=null;
        Token char_literal87=null;
        MstageParser.physicalHostBodyDeclaration_return physicalHostBodyDeclaration86 = null;


        Object char_literal85_tree=null;
        Object char_literal87_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:497:2: ( '{' ( physicalHostBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:497:4: '{' ( physicalHostBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal85=(Token)match(input,24,FOLLOW_24_in_physicalHostBody1396); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal85_tree = (Object)adaptor.create(char_literal85);
            adaptor.addChild(root_0, char_literal85_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:497:8: ( physicalHostBodyDeclaration[$element] )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==49) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: physicalHostBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_physicalHostBodyDeclaration_in_physicalHostBody1398);
            	    physicalHostBodyDeclaration86=physicalHostBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, physicalHostBodyDeclaration86.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            char_literal87=(Token)match(input,25,FOLLOW_25_in_physicalHostBody1402); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal87_tree = (Object)adaptor.create(char_literal87);
            adaptor.addChild(root_0, char_literal87_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, physicalHostBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "physicalHostBody"

    public static class physicalHostBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "physicalHostBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:500:1: physicalHostBodyDeclaration[PhysicalHost element] : 'none' ;
    public final MstageParser.physicalHostBodyDeclaration_return physicalHostBodyDeclaration(PhysicalHost element) throws RecognitionException {
        MstageParser.physicalHostBodyDeclaration_return retval = new MstageParser.physicalHostBodyDeclaration_return();
        retval.start = input.LT(1);
        int physicalHostBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal88=null;

        Object string_literal88_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:501:2: ( 'none' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:501:4: 'none'
            {
            root_0 = (Object)adaptor.nil();

            string_literal88=(Token)match(input,49,FOLLOW_49_in_physicalHostBodyDeclaration1414); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal88_tree = (Object)adaptor.create(string_literal88);
            adaptor.addChild(root_0, string_literal88_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 50, physicalHostBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "physicalHostBodyDeclaration"

    public static class mappingDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mappingDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:509:1: mappingDeclaration[HostMapper element, Class<? extends MStageDeclaration> fromType, Class<? extends Host> toType] : mapkw= ( 'map' | 'locate' ) name= Identifier rfroms= mappingDeclarationBody[fromType] ;
    public final MstageParser.mappingDeclaration_return mappingDeclaration(HostMapper element, Class<? extends MStageDeclaration> fromType, Class<? extends Host> toType) throws RecognitionException {
        MstageParser.mappingDeclaration_return retval = new MstageParser.mappingDeclaration_return();
        retval.start = input.LT(1);
        int mappingDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token mapkw=null;
        Token name=null;
        MstageParser.mappingDeclarationBody_return rfroms = null;


        Object mapkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:510:2: (mapkw= ( 'map' | 'locate' ) name= Identifier rfroms= mappingDeclarationBody[fromType] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:510:4: mapkw= ( 'map' | 'locate' ) name= Identifier rfroms= mappingDeclarationBody[fromType]
            {
            root_0 = (Object)adaptor.nil();

            mapkw=(Token)input.LT(1);
            if ( (input.LA(1)>=51 && input.LA(1)<=52) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(mapkw));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_mappingDeclaration1440); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_mappingDeclarationBody_in_mappingDeclaration1444);
            rfroms=mappingDeclarationBody(fromType);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rfroms.getTree());
            if ( state.backtracking==0 ) {


              			HostMapping mapping = element.createEmptyMapping();

              			SimpleReference<? extends Host> to = 
              				new SimpleReference((name!=null?name.getText():null),toType);
              				
              			setLocation(to,name,name);
              			setKeyword(to,mapkw);					

              			// add host reference to host list
              			element.addHost(to);
              			
              			// set host to mapping target
              			mapping.setTo(to);

              	        for(SimpleReference<Module> from : (rfroms!=null?rfroms.elements:null)) { 	
              				mapping.addFrom(from);
              			}
              			
              			// add hostmapping
              			element.addHostMapping(mapping);
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, mappingDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "mappingDeclaration"

    public static class mappingDeclarationBody_return extends ParserRuleReturnScope {
        public List<SimpleReference> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mappingDeclarationBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:536:1: mappingDeclarationBody[Class<? extends MStageDeclaration> fromType] returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[fromType] )? '}' ;
    public final MstageParser.mappingDeclarationBody_return mappingDeclarationBody(Class<? extends MStageDeclaration> fromType) throws RecognitionException {
        MstageParser.mappingDeclarationBody_return retval = new MstageParser.mappingDeclarationBody_return();
        retval.start = input.LT(1);
        int mappingDeclarationBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal89=null;
        Token char_literal90=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal89_tree=null;
        Object char_literal90_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:537:2: ( '{' (decls= commaSeparatedBodyDecls[fromType] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:537:4: '{' (decls= commaSeparatedBodyDecls[fromType] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal89=(Token)match(input,24,FOLLOW_24_in_mappingDeclarationBody1467); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal89_tree = (Object)adaptor.create(char_literal89);
            adaptor.addChild(root_0, char_literal89_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:537:8: (decls= commaSeparatedBodyDecls[fromType] )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Identifier) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:537:10: decls= commaSeparatedBodyDecls[fromType]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_mappingDeclarationBody1475);
                    decls=commaSeparatedBodyDecls(fromType);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                       retval.elements = (decls!=null?decls.elements:null); 
                    }

                    }
                    break;

            }

            char_literal90=(Token)match(input,25,FOLLOW_25_in_mappingDeclarationBody1483); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal90_tree = (Object)adaptor.create(char_literal90);
            adaptor.addChild(root_0, char_literal90_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 52, mappingDeclarationBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "mappingDeclarationBody"

    public static class modulecontainerDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modulecontainerDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:546:1: modulecontainerDeclaration[ModuleContainer element] : ctkw= 'contain' conts= modulecontainerBody ;
    public final MstageParser.modulecontainerDeclaration_return modulecontainerDeclaration(ModuleContainer element) throws RecognitionException {
        MstageParser.modulecontainerDeclaration_return retval = new MstageParser.modulecontainerDeclaration_return();
        retval.start = input.LT(1);
        int modulecontainerDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token ctkw=null;
        MstageParser.modulecontainerBody_return conts = null;


        Object ctkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:547:2: (ctkw= 'contain' conts= modulecontainerBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:547:4: ctkw= 'contain' conts= modulecontainerBody
            {
            root_0 = (Object)adaptor.nil();

            ctkw=(Token)match(input,47,FOLLOW_47_in_modulecontainerDeclaration1503); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ctkw_tree = (Object)adaptor.create(ctkw);
            adaptor.addChild(root_0, ctkw_tree);
            }
            pushFollow(FOLLOW_modulecontainerBody_in_modulecontainerDeclaration1507);
            conts=modulecontainerBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, conts.getTree());
            if ( state.backtracking==0 ) {


              			for(SimpleReference<Module<?>> module : (conts!=null?conts.elements:null)) {
              				element.addModule(module);
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
            if ( state.backtracking>0 ) { memoize(input, 53, modulecontainerDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "modulecontainerDeclaration"

    public static class modulecontainerBody_return extends ParserRuleReturnScope {
        public List<SimpleReference> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modulecontainerBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:555:1: modulecontainerBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}' ;
    public final MstageParser.modulecontainerBody_return modulecontainerBody() throws RecognitionException {
        MstageParser.modulecontainerBody_return retval = new MstageParser.modulecontainerBody_return();
        retval.start = input.LT(1);
        int modulecontainerBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal91=null;
        Token char_literal92=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal91_tree=null;
        Object char_literal92_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:557:2: ( '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:557:4: '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal91=(Token)match(input,24,FOLLOW_24_in_modulecontainerBody1528); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal91_tree = (Object)adaptor.create(char_literal91);
            adaptor.addChild(root_0, char_literal91_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:557:8: (decls= commaSeparatedBodyDecls[Module.class] )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Identifier) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:557:9: decls= commaSeparatedBodyDecls[Module.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_modulecontainerBody1533);
                    decls=commaSeparatedBodyDecls(Module.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                      retval.elements =(decls!=null?decls.elements:null);
                    }

                    }
                    break;

            }

            char_literal92=(Token)match(input,25,FOLLOW_25_in_modulecontainerBody1541); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal92_tree = (Object)adaptor.create(char_literal92);
            adaptor.addChild(root_0, char_literal92_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 54, modulecontainerBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "modulecontainerBody"

    public static class commaSeparatedBodyDecls_return extends ParserRuleReturnScope {
        public List<SimpleReference> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "commaSeparatedBodyDecls"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:566:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
    public final MstageParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls(Class targetType) throws RecognitionException {
        MstageParser.commaSeparatedBodyDecls_return retval = new MstageParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);
        int commaSeparatedBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token char_literal93=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object id_tree=null;
        Object char_literal93_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:568:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:568:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls1569); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:568:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==29) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:568:19: ',' decls= commaSeparatedBodyDecls[$targetType]
                    {
                    char_literal93=(Token)match(input,29,FOLLOW_29_in_commaSeparatedBodyDecls1572); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal93_tree = (Object)adaptor.create(char_literal93);
                    adaptor.addChild(root_0, char_literal93_tree);
                    }
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1576);
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
        public AdviceType value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceType"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:583:1: adviceType returns [AdviceType value] : ( 'before' | 'after' | 'around' );
    public final MstageParser.adviceType_return adviceType() throws RecognitionException {
        MstageParser.adviceType_return retval = new MstageParser.adviceType_return();
        retval.start = input.LT(1);
        int adviceType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal94=null;
        Token string_literal95=null;
        Token string_literal96=null;

        Object string_literal94_tree=null;
        Object string_literal95_tree=null;
        Object string_literal96_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:584:2: ( 'before' | 'after' | 'around' )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt28=1;
                }
                break;
            case 54:
                {
                alt28=2;
                }
                break;
            case 55:
                {
                alt28=3;
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:584:4: 'before'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal94=(Token)match(input,53,FOLLOW_53_in_adviceType1608); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal94_tree = (Object)adaptor.create(string_literal94);
                    adaptor.addChild(root_0, string_literal94_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = AdviceType.BEFORE;
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:585:4: 'after'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal95=(Token)match(input,54,FOLLOW_54_in_adviceType1615); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal95_tree = (Object)adaptor.create(string_literal95);
                    adaptor.addChild(root_0, string_literal95_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = AdviceType.AFTER;
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:586:4: 'around'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal96=(Token)match(input,55,FOLLOW_55_in_adviceType1622); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal96_tree = (Object)adaptor.create(string_literal96);
                    adaptor.addChild(root_0, string_literal96_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = AdviceType.AROUND;
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

    public static class joinpointKind_return extends ParserRuleReturnScope {
        public JoinpointKind value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "joinpointKind"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:589:1: joinpointKind returns [JoinpointKind value] : ( 'execution' | 'call' );
    public final MstageParser.joinpointKind_return joinpointKind() throws RecognitionException {
        MstageParser.joinpointKind_return retval = new MstageParser.joinpointKind_return();
        retval.start = input.LT(1);
        int joinpointKind_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal97=null;
        Token string_literal98=null;

        Object string_literal97_tree=null;
        Object string_literal98_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:590:2: ( 'execution' | 'call' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==56) ) {
                alt29=1;
            }
            else if ( (LA29_0==57) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:590:4: 'execution'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal97=(Token)match(input,56,FOLLOW_56_in_joinpointKind1640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal97_tree = (Object)adaptor.create(string_literal97);
                    adaptor.addChild(root_0, string_literal97_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = JoinpointKind.EXECUTION;
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:591:4: 'call'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal98=(Token)match(input,57,FOLLOW_57_in_joinpointKind1647); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal98_tree = (Object)adaptor.create(string_literal98);
                    adaptor.addChild(root_0, string_literal98_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = JoinpointKind.CALL;
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
            if ( state.backtracking>0 ) { memoize(input, 57, joinpointKind_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "joinpointKind"

    public static class voidType_return extends ParserRuleReturnScope {
        public TypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "voidType"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:594:1: voidType returns [TypeReference value] : 'void' ;
    public final MstageParser.voidType_return voidType() throws RecognitionException {
        MstageParser.voidType_return retval = new MstageParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal99=null;

        Object string_literal99_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:596:7: ( 'void' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:596:10: 'void'
            {
            root_0 = (Object)adaptor.nil();

            string_literal99=(Token)match(input,58,FOLLOW_58_in_voidType1673); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal99_tree = (Object)adaptor.create(string_literal99);
            adaptor.addChild(root_0, string_literal99_tree);
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

    public static class type_return extends ParserRuleReturnScope {
        public TypeReference value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:600:1: type returns [TypeReference value] : (cd= classOrInterfaceType | pt= primitiveType );
    public final MstageParser.type_return type() throws RecognitionException {
        MstageParser.type_return retval = new MstageParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.classOrInterfaceType_return cd = null;

        MstageParser.primitiveType_return pt = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:602:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==Identifier) ) {
                alt30=1;
            }
            else if ( ((LA30_0>=60 && LA30_0<=67)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:602:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceType_in_type1700);
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:603:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveType_in_type1709);
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
            if ( state.backtracking>0 ) { memoize(input, 59, type_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:607:1: classOrInterfaceType returns [TypeReference element] : name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* ;
    public final MstageParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MstageParser.classOrInterfaceType_return retval = new MstageParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal101=null;
        MstageParser.typeArguments_return typeArguments100 = null;

        MstageParser.typeArguments_return typeArguments102 = null;


        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal101_tree=null;

        NamespaceOrTypeReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:609:2: (name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:609:4: name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType1734); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new BasicTypeReference((name!=null?name.getText():null)); 
              	           target =  new NamespaceOrTypeReference((name!=null?name.getText():null)); 
              	          
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:614:4: ( typeArguments )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==68) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType1753);
                    typeArguments100=typeArguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments100.getTree());

                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:615:10: ( '.' namex= Identifier ( typeArguments )? )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==59) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:615:11: '.' namex= Identifier ( typeArguments )?
            	    {
            	    char_literal101=(Token)match(input,59,FOLLOW_59_in_classOrInterfaceType1767); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal101_tree = (Object)adaptor.create(char_literal101);
            	    adaptor.addChild(root_0, char_literal101_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType1771); if (state.failed) return retval;
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
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:626:11: ( typeArguments )?
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==68) ) {
            	        alt32=1;
            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType1798);
            	            typeArguments102=typeArguments();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments102.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
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
            if ( state.backtracking>0 ) { memoize(input, 60, classOrInterfaceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:630:1: primitiveType returns [TypeReference value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MstageParser.primitiveType_return primitiveType() throws RecognitionException {
        MstageParser.primitiveType_return retval = new MstageParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal103=null;
        Token string_literal104=null;
        Token string_literal105=null;
        Token string_literal106=null;
        Token string_literal107=null;
        Token string_literal108=null;
        Token string_literal109=null;
        Token string_literal110=null;

        Object string_literal103_tree=null;
        Object string_literal104_tree=null;
        Object string_literal105_tree=null;
        Object string_literal106_tree=null;
        Object string_literal107_tree=null;
        Object string_literal108_tree=null;
        Object string_literal109_tree=null;
        Object string_literal110_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:631:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt34=8;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt34=1;
                }
                break;
            case 61:
                {
                alt34=2;
                }
                break;
            case 62:
                {
                alt34=3;
                }
                break;
            case 63:
                {
                alt34=4;
                }
                break;
            case 64:
                {
                alt34=5;
                }
                break;
            case 65:
                {
                alt34=6;
                }
                break;
            case 66:
                {
                alt34=7;
                }
                break;
            case 67:
                {
                alt34=8;
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:631:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal103=(Token)match(input,60,FOLLOW_60_in_primitiveType1823); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal103_tree = (Object)adaptor.create(string_literal103);
                    adaptor.addChild(root_0, string_literal103_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:632:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal104=(Token)match(input,61,FOLLOW_61_in_primitiveType1835); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal104_tree = (Object)adaptor.create(string_literal104);
                    adaptor.addChild(root_0, string_literal104_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("char");
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:633:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal105=(Token)match(input,62,FOLLOW_62_in_primitiveType1847); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal105_tree = (Object)adaptor.create(string_literal105);
                    adaptor.addChild(root_0, string_literal105_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("byte");
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:634:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal106=(Token)match(input,63,FOLLOW_63_in_primitiveType1859); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal106_tree = (Object)adaptor.create(string_literal106);
                    adaptor.addChild(root_0, string_literal106_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("short");
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:635:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal107=(Token)match(input,64,FOLLOW_64_in_primitiveType1871); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal107_tree = (Object)adaptor.create(string_literal107);
                    adaptor.addChild(root_0, string_literal107_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("int");
                    }

                    }
                    break;
                case 6 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:636:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal108=(Token)match(input,65,FOLLOW_65_in_primitiveType1883); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal108_tree = (Object)adaptor.create(string_literal108);
                    adaptor.addChild(root_0, string_literal108_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("long");
                    }

                    }
                    break;
                case 7 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:637:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal109=(Token)match(input,66,FOLLOW_66_in_primitiveType1895); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal109_tree = (Object)adaptor.create(string_literal109);
                    adaptor.addChild(root_0, string_literal109_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("float");
                    }

                    }
                    break;
                case 8 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:638:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal110=(Token)match(input,67,FOLLOW_67_in_primitiveType1907); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal110_tree = (Object)adaptor.create(string_literal110);
                    adaptor.addChild(root_0, string_literal110_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 61, primitiveType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primitiveType"

    public static class typeArguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArguments"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:643:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final MstageParser.typeArguments_return typeArguments() throws RecognitionException {
        MstageParser.typeArguments_return retval = new MstageParser.typeArguments_return();
        retval.start = input.LT(1);
        int typeArguments_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal111=null;
        Token char_literal113=null;
        Token char_literal115=null;
        MstageParser.typeArgument_return typeArgument112 = null;

        MstageParser.typeArgument_return typeArgument114 = null;


        Object char_literal111_tree=null;
        Object char_literal113_tree=null;
        Object char_literal115_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal111=(Token)match(input,68,FOLLOW_68_in_typeArguments1930); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal111_tree = (Object)adaptor.create(char_literal111);
            adaptor.addChild(root_0, char_literal111_tree);
            }
            pushFollow(FOLLOW_typeArgument_in_typeArguments1932);
            typeArgument112=typeArgument();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument112.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:26: ( ',' typeArgument )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==29) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:28: ',' typeArgument
            	    {
            	    char_literal113=(Token)match(input,29,FOLLOW_29_in_typeArguments1936); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal113_tree = (Object)adaptor.create(char_literal113);
            	    adaptor.addChild(root_0, char_literal113_tree);
            	    }
            	    pushFollow(FOLLOW_typeArgument_in_typeArguments1938);
            	    typeArgument114=typeArgument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument114.getTree());

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            char_literal115=(Token)match(input,69,FOLLOW_69_in_typeArguments1943); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal115_tree = (Object)adaptor.create(char_literal115);
            adaptor.addChild(root_0, char_literal115_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 62, typeArguments_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArguments"

    public static class typeArgument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArgument"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:647:1: typeArgument : (t= type | '?' ( ( 'extends' | 'super' ) t= type )? );
    public final MstageParser.typeArgument_return typeArgument() throws RecognitionException {
        MstageParser.typeArgument_return retval = new MstageParser.typeArgument_return();
        retval.start = input.LT(1);
        int typeArgument_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal116=null;
        Token set117=null;
        MstageParser.type_return t = null;


        Object char_literal116_tree=null;
        Object set117_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:648:5: (t= type | '?' ( ( 'extends' | 'super' ) t= type )? )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Identifier||(LA37_0>=60 && LA37_0<=67)) ) {
                alt37=1;
            }
            else if ( (LA37_0==70) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:648:9: t= type
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_typeArgument1968);
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:648:20: '?' ( ( 'extends' | 'super' ) t= type )?
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal116=(Token)match(input,70,FOLLOW_70_in_typeArgument1974); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal116_tree = (Object)adaptor.create(char_literal116);
                    adaptor.addChild(root_0, char_literal116_tree);
                    }
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:648:25: ( ( 'extends' | 'super' ) t= type )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( ((LA36_0>=71 && LA36_0<=72)) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:648:27: ( 'extends' | 'super' ) t= type
                            {
                            set117=(Token)input.LT(1);
                            if ( (input.LA(1)>=71 && input.LA(1)<=72) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set117));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_type_in_typeArgument1989);
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
            if ( state.backtracking>0 ) { memoize(input, 63, typeArgument_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArgument"

    public static class annotations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotations"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:656:1: annotations : ( annotation )+ ;
    public final MstageParser.annotations_return annotations() throws RecognitionException {
        MstageParser.annotations_return retval = new MstageParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation118 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:657:5: ( ( annotation )+ )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:657:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:657:9: ( annotation )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==73) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations2020);
            	    annotation118=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation118.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
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
            if ( state.backtracking>0 ) { memoize(input, 64, annotations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotations"

    public static class annotation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotation"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:660:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MstageParser.annotation_return annotation() throws RecognitionException {
        MstageParser.annotation_return retval = new MstageParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal119=null;
        Token char_literal121=null;
        Token char_literal124=null;
        MstageParser.annotationName_return annotationName120 = null;

        MstageParser.elementValuePairs_return elementValuePairs122 = null;

        MstageParser.elementValue_return elementValue123 = null;


        Object char_literal119_tree=null;
        Object char_literal121_tree=null;
        Object char_literal124_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:661:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:661:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            char_literal119=(Token)match(input,73,FOLLOW_73_in_annotation2040); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal119_tree = (Object)adaptor.create(char_literal119);
            adaptor.addChild(root_0, char_literal119_tree);
            }
            pushFollow(FOLLOW_annotationName_in_annotation2042);
            annotationName120=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName120.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:661:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==27) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:661:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal121=(Token)match(input,27,FOLLOW_27_in_annotation2046); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal121_tree = (Object)adaptor.create(char_literal121);
                    adaptor.addChild(root_0, char_literal121_tree);
                    }
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:661:34: ( elementValuePairs | elementValue )?
                    int alt39=3;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==Identifier) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==24||LA39_0==73) ) {
                        alt39=2;
                    }
                    switch (alt39) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:661:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation2050);
                            elementValuePairs122=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs122.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:661:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation2054);
                            elementValue123=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue123.getTree());

                            }
                            break;

                    }

                    char_literal124=(Token)match(input,28,FOLLOW_28_in_annotation2059); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal124_tree = (Object)adaptor.create(char_literal124);
                    adaptor.addChild(root_0, char_literal124_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 65, annotation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotation"

    public static class annotationName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationName"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:664:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MstageParser.annotationName_return annotationName() throws RecognitionException {
        MstageParser.annotationName_return retval = new MstageParser.annotationName_return();
        retval.start = input.LT(1);
        int annotationName_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier125=null;
        Token char_literal126=null;
        Token Identifier127=null;

        Object Identifier125_tree=null;
        Object char_literal126_tree=null;
        Object Identifier127_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            Identifier125=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2083); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier125_tree = (Object)adaptor.create(Identifier125);
            adaptor.addChild(root_0, Identifier125_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:18: ( '.' Identifier )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==59) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:19: '.' Identifier
            	    {
            	    char_literal126=(Token)match(input,59,FOLLOW_59_in_annotationName2086); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal126_tree = (Object)adaptor.create(char_literal126);
            	    adaptor.addChild(root_0, char_literal126_tree);
            	    }
            	    Identifier127=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2088); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier127_tree = (Object)adaptor.create(Identifier127);
            	    adaptor.addChild(root_0, Identifier127_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 66, annotationName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationName"

    public static class elementValuePairs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePairs"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:668:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MstageParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MstageParser.elementValuePairs_return retval = new MstageParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal129=null;
        MstageParser.elementValuePair_return elementValuePair128 = null;

        MstageParser.elementValuePair_return elementValuePair130 = null;


        Object char_literal129_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:669:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:669:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2109);
            elementValuePair128=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair128.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:669:26: ( ',' elementValuePair )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==29) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:669:27: ',' elementValuePair
            	    {
            	    char_literal129=(Token)match(input,29,FOLLOW_29_in_elementValuePairs2112); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal129_tree = (Object)adaptor.create(char_literal129);
            	    adaptor.addChild(root_0, char_literal129_tree);
            	    }
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2114);
            	    elementValuePair130=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair130.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 67, elementValuePairs_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePairs"

    public static class elementValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePair"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:672:1: elementValuePair : Identifier '=' elementValue ;
    public final MstageParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MstageParser.elementValuePair_return retval = new MstageParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier131=null;
        Token char_literal132=null;
        MstageParser.elementValue_return elementValue133 = null;


        Object Identifier131_tree=null;
        Object char_literal132_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:673:5: ( Identifier '=' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:673:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();

            Identifier131=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair2135); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier131_tree = (Object)adaptor.create(Identifier131);
            adaptor.addChild(root_0, Identifier131_tree);
            }
            char_literal132=(Token)match(input,74,FOLLOW_74_in_elementValuePair2137); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal132_tree = (Object)adaptor.create(char_literal132);
            adaptor.addChild(root_0, char_literal132_tree);
            }
            pushFollow(FOLLOW_elementValue_in_elementValuePair2139);
            elementValue133=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue133.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, elementValuePair_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePair"

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:676:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MstageParser.elementValue_return elementValue() throws RecognitionException {
        MstageParser.elementValue_return retval = new MstageParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation134 = null;

        MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer135 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:677:5: ( annotation | elementValueArrayInitializer )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==73) ) {
                alt43=1;
            }
            else if ( (LA43_0==24) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:677:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotation_in_elementValue2162);
                    annotation134=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation134.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:678:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue2172);
                    elementValueArrayInitializer135=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer135.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 69, elementValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValue"

    public static class elementValueArrayInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValueArrayInitializer"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:681:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MstageParser.elementValueArrayInitializer_return retval = new MstageParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal136=null;
        Token char_literal138=null;
        Token char_literal140=null;
        Token char_literal141=null;
        MstageParser.elementValue_return elementValue137 = null;

        MstageParser.elementValue_return elementValue139 = null;


        Object char_literal136_tree=null;
        Object char_literal138_tree=null;
        Object char_literal140_tree=null;
        Object char_literal141_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:682:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:682:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal136=(Token)match(input,24,FOLLOW_24_in_elementValueArrayInitializer2195); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal136_tree = (Object)adaptor.create(char_literal136);
            adaptor.addChild(root_0, char_literal136_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:682:13: ( elementValue ( ',' elementValue )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==24||LA45_0==73) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:682:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2198);
                    elementValue137=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue137.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:682:27: ( ',' elementValue )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==29) ) {
                            int LA44_1 = input.LA(2);

                            if ( (LA44_1==24||LA44_1==73) ) {
                                alt44=1;
                            }


                        }


                        switch (alt44) {
                    	case 1 :
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:682:28: ',' elementValue
                    	    {
                    	    char_literal138=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2201); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal138_tree = (Object)adaptor.create(char_literal138);
                    	    adaptor.addChild(root_0, char_literal138_tree);
                    	    }
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2203);
                    	    elementValue139=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue139.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:682:49: ( ',' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==29) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:682:50: ','
                    {
                    char_literal140=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2210); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal140_tree = (Object)adaptor.create(char_literal140);
                    adaptor.addChild(root_0, char_literal140_tree);
                    }

                    }
                    break;

            }

            char_literal141=(Token)match(input,25,FOLLOW_25_in_elementValueArrayInitializer2214); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 70, elementValueArrayInitializer_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:685:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MstageParser.annotationTypeDeclaration_return retval = new MstageParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal142=null;
        Token string_literal143=null;
        MstageParser.annotationTypeBody_return annotationTypeBody144 = null;


        Object name_tree=null;
        Object char_literal142_tree=null;
        Object string_literal143_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:686:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:686:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();

            char_literal142=(Token)match(input,73,FOLLOW_73_in_annotationTypeDeclaration2241); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal142_tree = (Object)adaptor.create(char_literal142);
            adaptor.addChild(root_0, char_literal142_tree);
            }
            string_literal143=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration2243); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal143_tree = (Object)adaptor.create(string_literal143);
            adaptor.addChild(root_0, string_literal143_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration2247); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2249);
            annotationTypeBody144=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody144.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, annotationTypeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeDeclaration"

    public static class annotationTypeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:689:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MstageParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MstageParser.annotationTypeBody_return retval = new MstageParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal145=null;
        Token char_literal147=null;
        MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration146 = null;


        Object char_literal145_tree=null;
        Object char_literal147_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:690:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:690:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal145=(Token)match(input,24,FOLLOW_24_in_annotationTypeBody2272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal145_tree = (Object)adaptor.create(char_literal145);
            adaptor.addChild(root_0, char_literal145_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:690:13: ( annotationTypeElementDeclaration )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==Identifier||(LA47_0>=60 && LA47_0<=67)||LA47_0==73) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:690:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2275);
            	    annotationTypeElementDeclaration146=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration146.getTree());

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            char_literal147=(Token)match(input,25,FOLLOW_25_in_annotationTypeBody2279); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal147_tree = (Object)adaptor.create(char_literal147);
            adaptor.addChild(root_0, char_literal147_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, annotationTypeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeBody"

    public static class annotationTypeElementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:693:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MstageParser.annotationTypeElementDeclaration_return retval = new MstageParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationTypeElementRest_return annotationTypeElementRest148 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:694:5: ( annotationTypeElementRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:694:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2304);
            annotationTypeElementRest148=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest148.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, annotationTypeElementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementDeclaration"

    public static class annotationTypeElementRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:697:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MstageParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MstageParser.annotationTypeElementRest_return retval = new MstageParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal151=null;
        Token char_literal153=null;
        MstageParser.type_return type149 = null;

        MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest150 = null;

        MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration152 = null;


        Object char_literal151_tree=null;
        Object char_literal153_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:698:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==Identifier||(LA49_0>=60 && LA49_0<=67)) ) {
                alt49=1;
            }
            else if ( (LA49_0==73) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:698:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2327);
                    type149=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type149.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2329);
                    annotationMethodOrConstantRest150=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest150.getTree());
                    char_literal151=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2331); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal151_tree = (Object)adaptor.create(char_literal151);
                    adaptor.addChild(root_0, char_literal151_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:699:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2341);
                    annotationTypeDeclaration152=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration152.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:699:35: ( ';' )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==26) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: ';'
                            {
                            char_literal153=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2343); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal153_tree = (Object)adaptor.create(char_literal153);
                            adaptor.addChild(root_0, char_literal153_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 74, annotationTypeElementRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementRest"

    public static class annotationMethodOrConstantRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodOrConstantRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:702:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MstageParser.annotationMethodOrConstantRest_return retval = new MstageParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationMethodRest_return annotationMethodRest154 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:703:5: ( annotationMethodRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:703:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2367);
            annotationMethodRest154=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest154.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, annotationMethodOrConstantRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodOrConstantRest"

    public static class annotationMethodRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:706:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MstageParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MstageParser.annotationMethodRest_return retval = new MstageParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier155=null;
        Token char_literal156=null;
        Token char_literal157=null;
        MstageParser.defaultValue_return defaultValue158 = null;


        Object Identifier155_tree=null;
        Object char_literal156_tree=null;
        Object char_literal157_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:707:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:707:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier155=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2390); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier155_tree = (Object)adaptor.create(Identifier155);
            adaptor.addChild(root_0, Identifier155_tree);
            }
            char_literal156=(Token)match(input,27,FOLLOW_27_in_annotationMethodRest2392); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal156_tree = (Object)adaptor.create(char_literal156);
            adaptor.addChild(root_0, char_literal156_tree);
            }
            char_literal157=(Token)match(input,28,FOLLOW_28_in_annotationMethodRest2394); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal157_tree = (Object)adaptor.create(char_literal157);
            adaptor.addChild(root_0, char_literal157_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:707:28: ( defaultValue )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==75) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest2396);
                    defaultValue158=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue158.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 76, annotationMethodRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodRest"

    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:710:1: defaultValue : 'default' elementValue ;
    public final MstageParser.defaultValue_return defaultValue() throws RecognitionException {
        MstageParser.defaultValue_return retval = new MstageParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal159=null;
        MstageParser.elementValue_return elementValue160 = null;


        Object string_literal159_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:711:5: ( 'default' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:711:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();

            string_literal159=(Token)match(input,75,FOLLOW_75_in_defaultValue2424); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal159_tree = (Object)adaptor.create(string_literal159);
            adaptor.addChild(root_0, string_literal159_tree);
            }
            pushFollow(FOLLOW_elementValue_in_defaultValue2426);
            elementValue160=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue160.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, defaultValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // $ANTLR start synpred17_Mstage
    public final void synpred17_Mstage_fragment() throws RecognitionException {   
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:244:29: ( . )
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:244:29: .
        {
        matchAny(input); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_Mstage

    // $ANTLR start synpred20_Mstage
    public final void synpred20_Mstage_fragment() throws RecognitionException {   
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:284:27: ( . )
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:284:27: .
        {
        matchAny(input); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_Mstage

    // Delegated rules

    public final boolean synpred20_Mstage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_Mstage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_Mstage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_Mstage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit90 = new BitSet(new long[]{0x0005720040800002L});
    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit103 = new BitSet(new long[]{0x0005720040800002L});
    public static final BitSet FOLLOW_compositeDeclaration_in_compilationUnit119 = new BitSet(new long[]{0x0005720040800002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_compilationUnit132 = new BitSet(new long[]{0x0005720040800002L});
    public static final BitSet FOLLOW_applicationDeclaration_in_compilationUnit145 = new BitSet(new long[]{0x0005720040800002L});
    public static final BitSet FOLLOW_deploymentDeclaration_in_compilationUnit158 = new BitSet(new long[]{0x0005720040800002L});
    public static final BitSet FOLLOW_abstractHostDeclaration_in_compilationUnit171 = new BitSet(new long[]{0x0005720040800002L});
    public static final BitSet FOLLOW_physicalHostDeclaration_in_compilationUnit185 = new BitSet(new long[]{0x0005720040800002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration216 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration220 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_interfaceBody240 = new BitSet(new long[]{0xF400000002000010L,0x000000000000000FL});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody242 = new BitSet(new long[]{0xF400000002000010L,0x000000000000000FL});
    public static final BitSet FOLLOW_25_in_interfaceBody246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration263 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceBodyDeclaration264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceDeclaration291 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_serviceDeclaration295 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceDeclaration299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_formalParameters370 = new BitSet(new long[]{0xF400000010000010L,0x000000000000000FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters375 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_formalParameters381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls406 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls410 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_formalParameterDecls413 = new BitSet(new long[]{0xF400000000000010L,0x000000000000000FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_connectorDeclaration451 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration455 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorBody473 = new BitSet(new long[]{0x0000040082000000L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody476 = new BitSet(new long[]{0x0000040082000000L});
    public static final BitSet FOLLOW_25_in_connectorBody481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_connectorAOCompositionDeclaration518 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorAOCompositionDeclaration522 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorAOCompositionBody544 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody548 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_connectorAOCompositionBody554 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_connectorAOCompositionBody556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_pointcutDeclaration573 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutBody593 = new BitSet(new long[]{0x0000000A02000000L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody595 = new BitSet(new long[]{0x0000000A02000000L});
    public static final BitSet FOLLOW_25_in_pointcutBody599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pointcutKindDeclaration634 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutKindDeclaration636 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_joinpointKind_in_pointcutKindDeclaration640 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutKindDeclaration642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_pointcutSignatureDeclaration657 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutSignatureDeclaration659 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000FFFL});
    public static final BitSet FOLLOW_26_in_pointcutSignatureDeclaration668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_pointcutCallerDeclaration688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_pointcutCalleeDeclaration701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_adviceDeclaration719 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_adviceBody736 = new BitSet(new long[]{0x0000018002000000L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody738 = new BitSet(new long[]{0x0000018002000000L});
    public static final BitSet FOLLOW_25_in_adviceBody742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_adviceServiceDeclaration775 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceServiceDeclaration777 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000FFFL});
    public static final BitSet FOLLOW_26_in_adviceServiceDeclaration786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_adviceTypeDeclaration801 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceTypeDeclaration803 = new BitSet(new long[]{0x00E0000000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration807 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceTypeDeclaration809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_componentDeclaration836 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration840 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_componentBody866 = new BitSet(new long[]{0x00000C0082000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody868 = new BitSet(new long[]{0x00000C0082000000L});
    public static final BitSet FOLLOW_25_in_componentBody872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_moduleDependencyBody927 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody932 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_moduleDependencyBody940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_moduleRequireDependencyDeclaration955 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_moduleProvideDependencyDeclaration974 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_compositeDeclaration1007 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_compositeDeclaration1011 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_compositeBody_in_compositeDeclaration1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_compositeBody1031 = new BitSet(new long[]{0x00008C0082000000L});
    public static final BitSet FOLLOW_compositeBodyDeclaration_in_compositeBody1034 = new BitSet(new long[]{0x00008C0082000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_compositeBody1039 = new BitSet(new long[]{0x00008C0082000000L});
    public static final BitSet FOLLOW_25_in_compositeBody1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modulecontainerDeclaration_in_compositeBodyDeclaration1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_applicationDeclaration1081 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_applicationDeclaration1085 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_applicationBody_in_applicationDeclaration1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_applicationBody1102 = new BitSet(new long[]{0x0018800002000000L});
    public static final BitSet FOLLOW_applicationBodyDeclaration_in_applicationBody1104 = new BitSet(new long[]{0x0018800002000000L});
    public static final BitSet FOLLOW_25_in_applicationBody1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modulecontainerDeclaration_in_applicationBodyDeclaration1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_locateDeclaration_in_applicationBodyDeclaration1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mappingDeclaration_in_locateDeclaration1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_deploymentDeclaration1168 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_deploymentDeclaration1172 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_deploymentBody_in_deploymentDeclaration1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_deploymentBody1189 = new BitSet(new long[]{0x0018800002000000L});
    public static final BitSet FOLLOW_deploymentBodyDeclaration_in_deploymentBody1191 = new BitSet(new long[]{0x0018800002000000L});
    public static final BitSet FOLLOW_25_in_deploymentBody1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_appcontainDeclaration_in_deploymentBodyDeclaration1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hostMapDeclaration_in_deploymentBodyDeclaration1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_appcontainDeclaration1232 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_appcontainBody_in_appcontainDeclaration1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_appcontainBody1259 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_appcontainBody1264 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_appcontainBody1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mappingDeclaration_in_hostMapDeclaration1286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_abstractHostDeclaration1309 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_abstractHostDeclaration1313 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_abstractHostBody_in_abstractHostDeclaration1317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_abstractHostBody1333 = new BitSet(new long[]{0x0002000002000000L});
    public static final BitSet FOLLOW_abstractHostBodyDeclaration_in_abstractHostBody1335 = new BitSet(new long[]{0x0002000002000000L});
    public static final BitSet FOLLOW_25_in_abstractHostBody1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_abstractHostBodyDeclaration1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_physicalHostDeclaration1375 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_physicalHostDeclaration1379 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_physicalHostBody_in_physicalHostDeclaration1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_physicalHostBody1396 = new BitSet(new long[]{0x0002000002000000L});
    public static final BitSet FOLLOW_physicalHostBodyDeclaration_in_physicalHostBody1398 = new BitSet(new long[]{0x0002000002000000L});
    public static final BitSet FOLLOW_25_in_physicalHostBody1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_physicalHostBodyDeclaration1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_mappingDeclaration1432 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_mappingDeclaration1440 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_mappingDeclarationBody_in_mappingDeclaration1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_mappingDeclarationBody1467 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_mappingDeclarationBody1475 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_mappingDeclarationBody1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_modulecontainerDeclaration1503 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_modulecontainerBody_in_modulecontainerDeclaration1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_modulecontainerBody1528 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_modulecontainerBody1533 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_modulecontainerBody1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls1569 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_commaSeparatedBodyDecls1572 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_adviceType1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_adviceType1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_adviceType1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_joinpointKind1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_joinpointKind1647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_voidType1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType1734 = new BitSet(new long[]{0x0800000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType1753 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_classOrInterfaceType1767 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType1771 = new BitSet(new long[]{0x0800000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType1798 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_60_in_primitiveType1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_primitiveType1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_primitiveType1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_primitiveType1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_primitiveType1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_primitiveType1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_primitiveType1907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_typeArguments1930 = new BitSet(new long[]{0xF400000000000010L,0x000000000000004FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments1932 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_29_in_typeArguments1936 = new BitSet(new long[]{0xF400000000000010L,0x000000000000004FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments1938 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_typeArguments1943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_typeArgument1974 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_set_in_typeArgument1979 = new BitSet(new long[]{0xF400000000000010L,0x000000000000000FL});
    public static final BitSet FOLLOW_type_in_typeArgument1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations2020 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_annotation2040 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation2042 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_annotation2046 = new BitSet(new long[]{0x0000000011000010L,0x0000000000000200L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation2050 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation2054 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotation2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2083 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_annotationName2086 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2088 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2109 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_elementValuePairs2112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2114 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair2135 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_elementValuePair2137 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue2162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_elementValueArrayInitializer2195 = new BitSet(new long[]{0x0000000023000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2198 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2201 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2203 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2210 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elementValueArrayInitializer2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_annotationTypeDeclaration2241 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration2243 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration2247 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeBody2272 = new BitSet(new long[]{0xF400000002000010L,0x000000000000020FL});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2275 = new BitSet(new long[]{0xF400000002000010L,0x000000000000020FL});
    public static final BitSet FOLLOW_25_in_annotationTypeBody2279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2327 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2329 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2341 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2390 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_annotationMethodRest2392 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotationMethodRest2394 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_defaultValue2424 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2426 = new BitSet(new long[]{0x0000000000000002L});

}
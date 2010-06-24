// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g 2010-06-24 09:24:49

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "StringLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "'{'", "'}'", "';'", "'('", "')'", "','", "'connector'", "'ao-composition'", "'pointcut'", "'kind'", "':'", "'signature'", "'caller'", "'callee'", "'advice'", "'service'", "'type'", "'component'", "'require'", "'provide'", "'composite'", "'application'", "'deployment'", "'contain'", "'abstracthost'", "'none'", "'map'", "'locate'", "'before'", "'after'", "'around'", "'execution'", "'call'", "'void'", "'.'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'<'", "'>'", "'?'", "'extends'", "'super'", "'@'", "'='", "'default'"
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
            this.state.ruleMemo = new HashMap[140+1];
             
             
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:74:1: compilationUnit returns [CompilationUnit element] : (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration | ahd= abstractHostDeclaration )* ;
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



         
        	retval.element = getCompilationUnit();
        	NamespacePart npp = new NamespacePart(language().defaultNamespace());
        	retval.element.add(npp);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:80:2: ( (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration | ahd= abstractHostDeclaration )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:80:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration | ahd= abstractHostDeclaration )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:80:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration | ahd= abstractHostDeclaration )*
            loop1:
            do {
                int alt1=8;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:105:1: interfaceDeclaration returns [Interface element] : intkw= 'interface' name= Identifier interfaceBody[$element] ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:106:2: (intkw= 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:106:4: intkw= 'interface' name= Identifier interfaceBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            intkw=(Token)match(input,23,FOLLOW_23_in_interfaceDeclaration205); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            intkw_tree = (Object)adaptor.create(intkw);
            adaptor.addChild(root_0, intkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Interface(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,intkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration215);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:115:1: interfaceBody[Interface element] : '{' ( interfaceBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:116:2: ( '{' ( interfaceBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:116:4: '{' ( interfaceBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal2=(Token)match(input,24,FOLLOW_24_in_interfaceBody229); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:116:8: ( interfaceBodyDeclaration[$element] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||LA2_0==57||(LA2_0>=59 && LA2_0<=66)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: interfaceBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody231);
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

            char_literal4=(Token)match(input,25,FOLLOW_25_in_interfaceBody235); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:121:1: interfaceBodyDeclaration[Interface element] : (service= serviceDeclaration ';' ) ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:122:2: ( (service= serviceDeclaration ';' ) )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:122:4: (service= serviceDeclaration ';' )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:122:4: (service= serviceDeclaration ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:122:5: service= serviceDeclaration ';'
            {
            pushFollow(FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration252);
            service=serviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal5=(Token)match(input,26,FOLLOW_26_in_interfaceBodyDeclaration253); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:135:1: serviceDeclaration returns [Service element] : rtype= serviceReturnType name= Identifier params= formalParameters ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:136:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:136:4: rtype= serviceReturnType name= Identifier params= formalParameters
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceReturnType_in_serviceDeclaration280);
            rtype=serviceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceDeclaration284); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_formalParameters_in_serviceDeclaration288);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:142:1: serviceReturnType returns [TypeReference value] : (vt= voidType | tp= type ) ;
    public final MstageParser.serviceReturnType_return serviceReturnType() throws RecognitionException {
        MstageParser.serviceReturnType_return retval = new MstageParser.serviceReturnType_return();
        retval.start = input.LT(1);
        int serviceReturnType_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.voidType_return vt = null;

        MstageParser.type_return tp = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:143:2: ( (vt= voidType | tp= type ) )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:143:4: (vt= voidType | tp= type )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:143:4: (vt= voidType | tp= type )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==57) ) {
                alt3=1;
            }
            else if ( (LA3_0==Identifier||(LA3_0>=59 && LA3_0<=66)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:144:4: vt= voidType
                    {
                    pushFollow(FOLLOW_voidType_in_serviceReturnType313);
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:146:4: tp= type
                    {
                    pushFollow(FOLLOW_type_in_serviceReturnType327);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:150:1: formalParameters returns [List<FormalParameter> element] : '(' (pars= formalParameterDecls )? ')' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:152:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:152:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal6=(Token)match(input,27,FOLLOW_27_in_formalParameters359); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:152:13: (pars= formalParameterDecls )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Identifier||(LA4_0>=59 && LA4_0<=66)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:152:14: pars= formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters364);
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

            char_literal7=(Token)match(input,28,FOLLOW_28_in_formalParameters370); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:155:1: formalParameterDecls returns [List<FormalParameter> element] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:156:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:156:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_type_in_formalParameterDecls395);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls399); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:156:32: ( ',' decls= formalParameterDecls )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==29) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:156:33: ',' decls= formalParameterDecls
                    {
                    char_literal8=(Token)match(input,29,FOLLOW_29_in_formalParameterDecls402); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (Object)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);
                    }
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls406);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:175:1: connectorDeclaration returns [Connector element] : conkw= 'connector' name= Identifier connectorBody[$element] ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:176:2: (conkw= 'connector' name= Identifier connectorBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:176:4: conkw= 'connector' name= Identifier connectorBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            conkw=(Token)match(input,30,FOLLOW_30_in_connectorDeclaration440); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            conkw_tree = (Object)adaptor.create(conkw);
            adaptor.addChild(root_0, conkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration444); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Connector(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,conkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration448);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:184:1: connectorBody[Connector element] : '{' ( connectorBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:185:2: ( '{' ( connectorBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:185:4: '{' ( connectorBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal10=(Token)match(input,24,FOLLOW_24_in_connectorBody462); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal10_tree = (Object)adaptor.create(char_literal10);
            adaptor.addChild(root_0, char_literal10_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:185:9: ( connectorBodyDeclaration[$element] )*
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
            	    pushFollow(FOLLOW_connectorBodyDeclaration_in_connectorBody465);
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

            char_literal12=(Token)match(input,25,FOLLOW_25_in_connectorBody470); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:189:1: connectorBodyDeclaration[Connector element] : ( connectorAOCompositionDeclaration[$element] | moduleRequireDependencyDeclaration[$element] );
    public final MstageParser.connectorBodyDeclaration_return connectorBodyDeclaration(Connector element) throws RecognitionException {
        MstageParser.connectorBodyDeclaration_return retval = new MstageParser.connectorBodyDeclaration_return();
        retval.start = input.LT(1);
        int connectorBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.connectorAOCompositionDeclaration_return connectorAOCompositionDeclaration13 = null;

        MstageParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration14 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:190:2: ( connectorAOCompositionDeclaration[$element] | moduleRequireDependencyDeclaration[$element] )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:190:4: connectorAOCompositionDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration483);
                    connectorAOCompositionDeclaration13=connectorAOCompositionDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorAOCompositionDeclaration13.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:191:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration489);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:195:1: connectorAOCompositionDeclaration[Connector element] : kw= 'ao-composition' name= Identifier aoc= connectorAOCompositionBody ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:196:2: (kw= 'ao-composition' name= Identifier aoc= connectorAOCompositionBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:196:4: kw= 'ao-composition' name= Identifier aoc= connectorAOCompositionBody
            {
            root_0 = (Object)adaptor.nil();

            kw=(Token)match(input,31,FOLLOW_31_in_connectorAOCompositionDeclaration507); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            kw_tree = (Object)adaptor.create(kw);
            adaptor.addChild(root_0, kw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorAOCompositionDeclaration511); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration515);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:209:1: connectorAOCompositionBody returns [Pointcut pointcut, Advice advice] : '{' pc= pointcutDeclaration adv= adviceDeclaration '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:210:2: ( '{' pc= pointcutDeclaration adv= adviceDeclaration '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:210:4: '{' pc= pointcutDeclaration adv= adviceDeclaration '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal15=(Token)match(input,24,FOLLOW_24_in_connectorAOCompositionBody533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal15_tree = (Object)adaptor.create(char_literal15);
            adaptor.addChild(root_0, char_literal15_tree);
            }
            pushFollow(FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody537);
            pc=pointcutDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pc.getTree());
            if ( state.backtracking==0 ) {

              				retval.pointcut = (pc!=null?pc.pointcut:null);
              			
            }
            pushFollow(FOLLOW_adviceDeclaration_in_connectorAOCompositionBody543);
            adv=adviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, adv.getTree());
            char_literal16=(Token)match(input,25,FOLLOW_25_in_connectorAOCompositionBody545); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:217:1: pointcutDeclaration returns [Pointcut pointcut] : 'pointcut' pointcutBody[$pointcut] ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:218:2: ( 'pointcut' pointcutBody[$pointcut] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:218:4: 'pointcut' pointcutBody[$pointcut]
            {
            root_0 = (Object)adaptor.nil();

            string_literal17=(Token)match(input,32,FOLLOW_32_in_pointcutDeclaration562); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal17_tree = (Object)adaptor.create(string_literal17);
            adaptor.addChild(root_0, string_literal17_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.pointcut = new Pointcut();
              			
            }
            pushFollow(FOLLOW_pointcutBody_in_pointcutDeclaration566);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:224:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:225:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:225:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal19=(Token)match(input,24,FOLLOW_24_in_pointcutBody582); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:225:8: ( pointcutBodyDeclaration[$pointcut] )*
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
            	    pushFollow(FOLLOW_pointcutBodyDeclaration_in_pointcutBody584);
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

            char_literal21=(Token)match(input,25,FOLLOW_25_in_pointcutBody588); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:228:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] );
    public final MstageParser.pointcutBodyDeclaration_return pointcutBodyDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutBodyDeclaration_return retval = new MstageParser.pointcutBodyDeclaration_return();
        retval.start = input.LT(1);
        int pointcutBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.pointcutKindDeclaration_return pointcutKindDeclaration22 = null;

        MstageParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration23 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:229:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:229:4: pointcutKindDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration601);
                    pointcutKindDeclaration22=pointcutKindDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutKindDeclaration22.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:230:4: pointcutSignatureDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration607);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:235:1: pointcutKindDeclaration[Pointcut pointcut] : 'kind' ':' kind= joinpointKind ';' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:236:2: ( 'kind' ':' kind= joinpointKind ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:236:4: 'kind' ':' kind= joinpointKind ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal24=(Token)match(input,33,FOLLOW_33_in_pointcutKindDeclaration623); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal24_tree = (Object)adaptor.create(string_literal24);
            adaptor.addChild(root_0, string_literal24_tree);
            }
            char_literal25=(Token)match(input,34,FOLLOW_34_in_pointcutKindDeclaration625); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);
            }
            pushFollow(FOLLOW_joinpointKind_in_pointcutKindDeclaration629);
            kind=joinpointKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, kind.getTree());
            char_literal26=(Token)match(input,26,FOLLOW_26_in_pointcutKindDeclaration631); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:241:1: pointcutSignatureDeclaration[Pointcut pointcut] : 'signature' ':' pattern= ( ( . )* ) ';' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:242:2: ( 'signature' ':' pattern= ( ( . )* ) ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:242:4: 'signature' ':' pattern= ( ( . )* ) ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal27=(Token)match(input,35,FOLLOW_35_in_pointcutSignatureDeclaration646); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal27_tree = (Object)adaptor.create(string_literal27);
            adaptor.addChild(root_0, string_literal27_tree);
            }
            char_literal28=(Token)match(input,34,FOLLOW_34_in_pointcutSignatureDeclaration648); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:242:28: ( ( . )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:242:29: ( . )*
            {
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:242:29: ( . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26) ) {
                    int LA10_1 = input.LA(2);

                    if ( (synpred16_Mstage()) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>=Identifier && LA10_0<=25)||(LA10_0>=27 && LA10_0<=74)) ) {
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

            char_literal30=(Token)match(input,26,FOLLOW_26_in_pointcutSignatureDeclaration657); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:256:1: pointcutCallerDeclaration[Pointcut pointcut] : 'caller' ;
    public final MstageParser.pointcutCallerDeclaration_return pointcutCallerDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutCallerDeclaration_return retval = new MstageParser.pointcutCallerDeclaration_return();
        retval.start = input.LT(1);
        int pointcutCallerDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal31=null;

        Object string_literal31_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:257:2: ( 'caller' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:257:4: 'caller'
            {
            root_0 = (Object)adaptor.nil();

            string_literal31=(Token)match(input,36,FOLLOW_36_in_pointcutCallerDeclaration677); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:260:1: pointcutCalleeDeclaration[Pointcut pointcut] : 'callee' ;
    public final MstageParser.pointcutCalleeDeclaration_return pointcutCalleeDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutCalleeDeclaration_return retval = new MstageParser.pointcutCalleeDeclaration_return();
        retval.start = input.LT(1);
        int pointcutCalleeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal32=null;

        Object string_literal32_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:261:2: ( 'callee' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:261:4: 'callee'
            {
            root_0 = (Object)adaptor.nil();

            string_literal32=(Token)match(input,37,FOLLOW_37_in_pointcutCalleeDeclaration690); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:265:1: adviceDeclaration returns [Advice advice] : 'advice' adviceBody[$advice] ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:266:2: ( 'advice' adviceBody[$advice] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:266:4: 'advice' adviceBody[$advice]
            {
            root_0 = (Object)adaptor.nil();

            string_literal33=(Token)match(input,38,FOLLOW_38_in_adviceDeclaration708); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal33_tree = (Object)adaptor.create(string_literal33);
            adaptor.addChild(root_0, string_literal33_tree);
            }
            if ( state.backtracking==0 ) {
               
              				retval.advice = new Advice(); 
              				System.out.println("construct advice "+retval.advice);				
              			
            }
            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration712);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:272:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:273:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:273:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal35=(Token)match(input,24,FOLLOW_24_in_adviceBody725); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal35_tree = (Object)adaptor.create(char_literal35);
            adaptor.addChild(root_0, char_literal35_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:273:8: ( adviceBodyDeclaration[$advice] )*
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
            	    pushFollow(FOLLOW_adviceBodyDeclaration_in_adviceBody727);
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

            char_literal37=(Token)match(input,25,FOLLOW_25_in_adviceBody731); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:276:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] );
    public final MstageParser.adviceBodyDeclaration_return adviceBodyDeclaration(Advice advice) throws RecognitionException {
        MstageParser.adviceBodyDeclaration_return retval = new MstageParser.adviceBodyDeclaration_return();
        retval.start = input.LT(1);
        int adviceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.adviceServiceDeclaration_return adviceServiceDeclaration38 = null;

        MstageParser.adviceTypeDeclaration_return adviceTypeDeclaration39 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:277:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:277:4: adviceServiceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration744);
                    adviceServiceDeclaration38=adviceServiceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceServiceDeclaration38.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:278:4: adviceTypeDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration750);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:281:1: adviceServiceDeclaration[Advice advice] : 'service' ':' service= ( ( . )* ) ';' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:282:2: ( 'service' ':' service= ( ( . )* ) ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:282:4: 'service' ':' service= ( ( . )* ) ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal40=(Token)match(input,39,FOLLOW_39_in_adviceServiceDeclaration764); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal40_tree = (Object)adaptor.create(string_literal40);
            adaptor.addChild(root_0, string_literal40_tree);
            }
            char_literal41=(Token)match(input,34,FOLLOW_34_in_adviceServiceDeclaration766); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = (Object)adaptor.create(char_literal41);
            adaptor.addChild(root_0, char_literal41_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:282:26: ( ( . )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:282:27: ( . )*
            {
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:282:27: ( . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) ) {
                    int LA13_1 = input.LA(2);

                    if ( (synpred19_Mstage()) ) {
                        alt13=1;
                    }


                }
                else if ( ((LA13_0>=Identifier && LA13_0<=25)||(LA13_0>=27 && LA13_0<=74)) ) {
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

            char_literal43=(Token)match(input,26,FOLLOW_26_in_adviceServiceDeclaration775); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:287:1: adviceTypeDeclaration[Advice advice] : 'type' ':' advtype= adviceType ';' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:288:2: ( 'type' ':' advtype= adviceType ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:288:4: 'type' ':' advtype= adviceType ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal44=(Token)match(input,40,FOLLOW_40_in_adviceTypeDeclaration790); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal44_tree = (Object)adaptor.create(string_literal44);
            adaptor.addChild(root_0, string_literal44_tree);
            }
            char_literal45=(Token)match(input,34,FOLLOW_34_in_adviceTypeDeclaration792); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal45_tree = (Object)adaptor.create(char_literal45);
            adaptor.addChild(root_0, char_literal45_tree);
            }
            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration796);
            advtype=adviceType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, advtype.getTree());
            char_literal46=(Token)match(input,26,FOLLOW_26_in_adviceTypeDeclaration798); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:299:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier componentBody[$element] ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:300:2: (compkw= 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:300:5: compkw= 'component' name= Identifier componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            compkw=(Token)match(input,41,FOLLOW_41_in_componentDeclaration825); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            compkw_tree = (Object)adaptor.create(compkw);
            adaptor.addChild(root_0, compkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration829); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                  			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                  			setKeyword(retval.element,compkw);
                  			setLocation(retval.element,name,"__NAME");
              			
            }
            pushFollow(FOLLOW_componentBody_in_componentDeclaration833);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:308:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:309:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:309:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal48=(Token)match(input,24,FOLLOW_24_in_componentBody855); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal48_tree = (Object)adaptor.create(char_literal48);
            adaptor.addChild(root_0, char_literal48_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:309:8: ( componentBodyDeclaration[$element] )*
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
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody857);
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

            char_literal50=(Token)match(input,25,FOLLOW_25_in_componentBody861); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:313:1: componentBodyDeclaration[Component element] : ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] );
    public final MstageParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MstageParser.componentBodyDeclaration_return retval = new MstageParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);
        int componentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration51 = null;

        MstageParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration52 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:314:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:314:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration879);
                    moduleRequireDependencyDeclaration51=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration51.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:315:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration885);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:328:1: moduleDependencyBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:330:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:330:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal53=(Token)match(input,24,FOLLOW_24_in_moduleDependencyBody916); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal53_tree = (Object)adaptor.create(char_literal53);
            adaptor.addChild(root_0, char_literal53_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:330:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==Identifier) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:330:9: decls= commaSeparatedBodyDecls[Interface.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody921);
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

            char_literal54=(Token)match(input,25,FOLLOW_25_in_moduleDependencyBody929); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:334:1: moduleRequireDependencyDeclaration[Module element] : 'require' rd= moduleDependencyBody ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:2: ( 'require' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:4: 'require' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal55=(Token)match(input,42,FOLLOW_42_in_moduleRequireDependencyDeclaration944); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal55_tree = (Object)adaptor.create(string_literal55);
            adaptor.addChild(root_0, string_literal55_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration948);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:343:1: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:344:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:344:4: 'provide' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal56=(Token)match(input,43,FOLLOW_43_in_moduleProvideDependencyDeclaration963); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal56_tree = (Object)adaptor.create(string_literal56);
            adaptor.addChild(root_0, string_literal56_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration967);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:359:1: compositeDeclaration returns [Composite element] : cmkw= 'composite' name= Identifier compositeBody[$element] ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:360:2: (cmkw= 'composite' name= Identifier compositeBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:360:4: cmkw= 'composite' name= Identifier compositeBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            cmkw=(Token)match(input,44,FOLLOW_44_in_compositeDeclaration996); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            cmkw_tree = (Object)adaptor.create(cmkw);
            adaptor.addChild(root_0, cmkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_compositeDeclaration1000); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.element = new Composite(new SimpleNameSignature((name!=null?name.getText():null)));
                  			setKeyword(retval.element,cmkw);
                  			setLocation(retval.element,name,"__NAME");
              			
            }
            pushFollow(FOLLOW_compositeBody_in_compositeDeclaration1006);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:369:1: compositeBody[Composite element] : '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:370:2: ( '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:370:4: '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal58=(Token)match(input,24,FOLLOW_24_in_compositeBody1020); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal58_tree = (Object)adaptor.create(char_literal58);
            adaptor.addChild(root_0, char_literal58_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:370:8: ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )*
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
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:370:9: compositeBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_compositeBodyDeclaration_in_compositeBody1023);
            	    compositeBodyDeclaration59=compositeBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compositeBodyDeclaration59.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:370:46: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_compositeBody1028);
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

            char_literal61=(Token)match(input,25,FOLLOW_25_in_compositeBody1033); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:374:1: compositeBodyDeclaration[Composite element] : modulecontainerDeclaration[$element] ;
    public final MstageParser.compositeBodyDeclaration_return compositeBodyDeclaration(Composite element) throws RecognitionException {
        MstageParser.compositeBodyDeclaration_return retval = new MstageParser.compositeBodyDeclaration_return();
        retval.start = input.LT(1);
        int compositeBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.modulecontainerDeclaration_return modulecontainerDeclaration62 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:2: ( modulecontainerDeclaration[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:4: modulecontainerDeclaration[$element]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_modulecontainerDeclaration_in_compositeBodyDeclaration1046);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:385:1: applicationDeclaration returns [Application element] : appkw= 'application' name= Identifier applicationBody[$element] ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:386:2: (appkw= 'application' name= Identifier applicationBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:386:4: appkw= 'application' name= Identifier applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            appkw=(Token)match(input,45,FOLLOW_45_in_applicationDeclaration1070); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_applicationDeclaration1074); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.element = new Application(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,appkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_applicationBody_in_applicationDeclaration1078);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:393:1: applicationBody[Application element] : '{' ( applicationBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:394:2: ( '{' ( applicationBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:394:4: '{' ( applicationBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal64=(Token)match(input,24,FOLLOW_24_in_applicationBody1091); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:394:8: ( applicationBodyDeclaration[$element] )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==47||(LA18_0>=50 && LA18_0<=51)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: applicationBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_applicationBodyDeclaration_in_applicationBody1093);
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

            char_literal66=(Token)match(input,25,FOLLOW_25_in_applicationBody1097); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:398:1: applicationBodyDeclaration[Application element] : ( modulecontainerDeclaration[$element] | locateDeclaration[$element] );
    public final MstageParser.applicationBodyDeclaration_return applicationBodyDeclaration(Application element) throws RecognitionException {
        MstageParser.applicationBodyDeclaration_return retval = new MstageParser.applicationBodyDeclaration_return();
        retval.start = input.LT(1);
        int applicationBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.modulecontainerDeclaration_return modulecontainerDeclaration67 = null;

        MstageParser.locateDeclaration_return locateDeclaration68 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:399:2: ( modulecontainerDeclaration[$element] | locateDeclaration[$element] )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==47) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=50 && LA19_0<=51)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:399:4: modulecontainerDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_modulecontainerDeclaration_in_applicationBodyDeclaration1110);
                    modulecontainerDeclaration67=modulecontainerDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modulecontainerDeclaration67.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:400:4: locateDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_locateDeclaration_in_applicationBodyDeclaration1116);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:404:1: locateDeclaration[Application element] : mappingDeclaration[$element, Module.class, AbstractHost.class] ;
    public final MstageParser.locateDeclaration_return locateDeclaration(Application element) throws RecognitionException {
        MstageParser.locateDeclaration_return retval = new MstageParser.locateDeclaration_return();
        retval.start = input.LT(1);
        int locateDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.mappingDeclaration_return mappingDeclaration69 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:405:2: ( mappingDeclaration[$element, Module.class, AbstractHost.class] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:405:4: mappingDeclaration[$element, Module.class, AbstractHost.class]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mappingDeclaration_in_locateDeclaration1132);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:416:1: deploymentDeclaration returns [Deployment element] : depkw= 'deployment' name= Identifier deploymentBody[$element] ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:417:2: (depkw= 'deployment' name= Identifier deploymentBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:417:4: depkw= 'deployment' name= Identifier deploymentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            depkw=(Token)match(input,46,FOLLOW_46_in_deploymentDeclaration1157); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            depkw_tree = (Object)adaptor.create(depkw);
            adaptor.addChild(root_0, depkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_deploymentDeclaration1161); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.element = new Deployment(new SimpleNameSignature((name!=null?name.getText():null))); 
              			setKeyword(retval.element,depkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_deploymentBody_in_deploymentDeclaration1165);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:424:1: deploymentBody[Deployment element] : '{' ( deploymentBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:425:2: ( '{' ( deploymentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:425:4: '{' ( deploymentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal71=(Token)match(input,24,FOLLOW_24_in_deploymentBody1178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal71_tree = (Object)adaptor.create(char_literal71);
            adaptor.addChild(root_0, char_literal71_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:425:8: ( deploymentBodyDeclaration[$element] )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==47||(LA20_0>=50 && LA20_0<=51)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: deploymentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_deploymentBodyDeclaration_in_deploymentBody1180);
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

            char_literal73=(Token)match(input,25,FOLLOW_25_in_deploymentBody1184); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:429:1: deploymentBodyDeclaration[Deployment element] : ( appcontainDeclaration[$element] | hostMapDeclaration[$element] );
    public final MstageParser.deploymentBodyDeclaration_return deploymentBodyDeclaration(Deployment element) throws RecognitionException {
        MstageParser.deploymentBodyDeclaration_return retval = new MstageParser.deploymentBodyDeclaration_return();
        retval.start = input.LT(1);
        int deploymentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.appcontainDeclaration_return appcontainDeclaration74 = null;

        MstageParser.hostMapDeclaration_return hostMapDeclaration75 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:430:2: ( appcontainDeclaration[$element] | hostMapDeclaration[$element] )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==47) ) {
                alt21=1;
            }
            else if ( ((LA21_0>=50 && LA21_0<=51)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:430:4: appcontainDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_appcontainDeclaration_in_deploymentBodyDeclaration1197);
                    appcontainDeclaration74=appcontainDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, appcontainDeclaration74.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:431:4: hostMapDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hostMapDeclaration_in_deploymentBodyDeclaration1203);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:435:1: appcontainDeclaration[Deployment element] : ctkw= 'contain' conts= appcontainBody ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:436:2: (ctkw= 'contain' conts= appcontainBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:436:4: ctkw= 'contain' conts= appcontainBody
            {
            root_0 = (Object)adaptor.nil();

            ctkw=(Token)match(input,47,FOLLOW_47_in_appcontainDeclaration1221); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ctkw_tree = (Object)adaptor.create(ctkw);
            adaptor.addChild(root_0, ctkw_tree);
            }
            pushFollow(FOLLOW_appcontainBody_in_appcontainDeclaration1225);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:445:1: appcontainBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Application.class] )? '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:447:2: ( '{' (decls= commaSeparatedBodyDecls[Application.class] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:447:4: '{' (decls= commaSeparatedBodyDecls[Application.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal76=(Token)match(input,24,FOLLOW_24_in_appcontainBody1248); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal76_tree = (Object)adaptor.create(char_literal76);
            adaptor.addChild(root_0, char_literal76_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:447:8: (decls= commaSeparatedBodyDecls[Application.class] )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Identifier) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:447:9: decls= commaSeparatedBodyDecls[Application.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_appcontainBody1253);
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

            char_literal77=(Token)match(input,25,FOLLOW_25_in_appcontainBody1261); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:451:1: hostMapDeclaration[Deployment element] : mappingDeclaration[$element, AbstractHost.class, PhysicalHost.class] ;
    public final MstageParser.hostMapDeclaration_return hostMapDeclaration(Deployment element) throws RecognitionException {
        MstageParser.hostMapDeclaration_return retval = new MstageParser.hostMapDeclaration_return();
        retval.start = input.LT(1);
        int hostMapDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.mappingDeclaration_return mappingDeclaration78 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:452:2: ( mappingDeclaration[$element, AbstractHost.class, PhysicalHost.class] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:452:4: mappingDeclaration[$element, AbstractHost.class, PhysicalHost.class]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mappingDeclaration_in_hostMapDeclaration1275);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:461:1: abstractHostDeclaration returns [AbstractHost element] : ahkw= 'abstracthost' name= Identifier abstractHostBody[$element] ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:462:2: (ahkw= 'abstracthost' name= Identifier abstractHostBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:462:4: ahkw= 'abstracthost' name= Identifier abstractHostBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            ahkw=(Token)match(input,48,FOLLOW_48_in_abstractHostDeclaration1298); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ahkw_tree = (Object)adaptor.create(ahkw);
            adaptor.addChild(root_0, ahkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_abstractHostDeclaration1302); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new AbstractHost(new SimpleNameSignature((name!=null?name.getText():null)));
              	    	setKeyword(retval.element,ahkw);
                  		setLocation(retval.element,name,"__NAME");	
              		
            }
            pushFollow(FOLLOW_abstractHostBody_in_abstractHostDeclaration1306);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:470:1: abstractHostBody[AbstractHost element] : '{' ( abstractHostBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:471:2: ( '{' ( abstractHostBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:471:4: '{' ( abstractHostBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal80=(Token)match(input,24,FOLLOW_24_in_abstractHostBody1322); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal80_tree = (Object)adaptor.create(char_literal80);
            adaptor.addChild(root_0, char_literal80_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:471:8: ( abstractHostBodyDeclaration[$element] )*
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
            	    pushFollow(FOLLOW_abstractHostBodyDeclaration_in_abstractHostBody1324);
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

            char_literal82=(Token)match(input,25,FOLLOW_25_in_abstractHostBody1328); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:475:1: abstractHostBodyDeclaration[AbstractHost element] : 'none' ;
    public final MstageParser.abstractHostBodyDeclaration_return abstractHostBodyDeclaration(AbstractHost element) throws RecognitionException {
        MstageParser.abstractHostBodyDeclaration_return retval = new MstageParser.abstractHostBodyDeclaration_return();
        retval.start = input.LT(1);
        int abstractHostBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal83=null;

        Object string_literal83_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:476:2: ( 'none' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:476:4: 'none'
            {
            root_0 = (Object)adaptor.nil();

            string_literal83=(Token)match(input,49,FOLLOW_49_in_abstractHostBodyDeclaration1341); if (state.failed) return retval;
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

    public static class mappingDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mappingDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:484:1: mappingDeclaration[HostMapper element, Class<? extends MStageDeclaration> fromType, Class<? extends Host> toType] : mapkw= ( 'map' | 'locate' ) name= Identifier rfroms= mappingDeclarationBody[fromType] ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:485:2: (mapkw= ( 'map' | 'locate' ) name= Identifier rfroms= mappingDeclarationBody[fromType] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:485:4: mapkw= ( 'map' | 'locate' ) name= Identifier rfroms= mappingDeclarationBody[fromType]
            {
            root_0 = (Object)adaptor.nil();

            mapkw=(Token)input.LT(1);
            if ( (input.LA(1)>=50 && input.LA(1)<=51) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(mapkw));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_mappingDeclaration1367); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_mappingDeclarationBody_in_mappingDeclaration1371);
            rfroms=mappingDeclarationBody(fromType);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rfroms.getTree());
            if ( state.backtracking==0 ) {


              				// create the host, as it is declared and defined here
              				Host<? extends Host> host = null;
              				try {
              					host = toType.newInstance();
              					host.setSignature(new SimpleNameSignature((name!=null?name.getText():null)));
              				} catch (Exception e) {
              					e.printStackTrace();
              				}
              				setLocation(host,name,"__NAME");
              				setKeyword(host,mapkw);				
              				
              				// add it to HostMapper
              				element.addHost(host);
              				
              				SimpleReference<? extends Host> to = new SimpleReference((name!=null?name.getText():null),toType);
              				
              		        for(SimpleReference<Module> from : (rfroms!=null?rfroms.elements:null)) {
              		        
              			        HostMapping mapping = 
              			        	element.createEmptyMapping();
              					
              					mapping.setFrom(from);
              					mapping.setTo(to);
              			
              					element.addHostMapping(mapping);
              					
              //					System.out.println(from.parentLink().getObject().signature() + 
              //						" --> " +to.parentLink().getObject().signature());
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
            if ( state.backtracking>0 ) { memoize(input, 48, mappingDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:519:1: mappingDeclarationBody[Class<? extends MStageDeclaration> fromType] returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[fromType] )? '}' ;
    public final MstageParser.mappingDeclarationBody_return mappingDeclarationBody(Class<? extends MStageDeclaration> fromType) throws RecognitionException {
        MstageParser.mappingDeclarationBody_return retval = new MstageParser.mappingDeclarationBody_return();
        retval.start = input.LT(1);
        int mappingDeclarationBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal84=null;
        Token char_literal85=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal84_tree=null;
        Object char_literal85_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:520:2: ( '{' (decls= commaSeparatedBodyDecls[fromType] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:520:4: '{' (decls= commaSeparatedBodyDecls[fromType] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal84=(Token)match(input,24,FOLLOW_24_in_mappingDeclarationBody1390); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal84_tree = (Object)adaptor.create(char_literal84);
            adaptor.addChild(root_0, char_literal84_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:520:8: (decls= commaSeparatedBodyDecls[fromType] )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Identifier) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:520:10: decls= commaSeparatedBodyDecls[fromType]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_mappingDeclarationBody1398);
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

            char_literal85=(Token)match(input,25,FOLLOW_25_in_mappingDeclarationBody1406); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 49, mappingDeclarationBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "mappingDeclarationBody"

    public static class modulecontainerDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modulecontainerDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:529:1: modulecontainerDeclaration[ModuleContainer element] : ctkw= 'contain' conts= modulecontainerBody ;
    public final MstageParser.modulecontainerDeclaration_return modulecontainerDeclaration(ModuleContainer element) throws RecognitionException {
        MstageParser.modulecontainerDeclaration_return retval = new MstageParser.modulecontainerDeclaration_return();
        retval.start = input.LT(1);
        int modulecontainerDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token ctkw=null;
        MstageParser.modulecontainerBody_return conts = null;


        Object ctkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:530:2: (ctkw= 'contain' conts= modulecontainerBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:530:4: ctkw= 'contain' conts= modulecontainerBody
            {
            root_0 = (Object)adaptor.nil();

            ctkw=(Token)match(input,47,FOLLOW_47_in_modulecontainerDeclaration1426); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ctkw_tree = (Object)adaptor.create(ctkw);
            adaptor.addChild(root_0, ctkw_tree);
            }
            pushFollow(FOLLOW_modulecontainerBody_in_modulecontainerDeclaration1430);
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
            if ( state.backtracking>0 ) { memoize(input, 50, modulecontainerDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:538:1: modulecontainerBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}' ;
    public final MstageParser.modulecontainerBody_return modulecontainerBody() throws RecognitionException {
        MstageParser.modulecontainerBody_return retval = new MstageParser.modulecontainerBody_return();
        retval.start = input.LT(1);
        int modulecontainerBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal86=null;
        Token char_literal87=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal86_tree=null;
        Object char_literal87_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:540:2: ( '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:540:4: '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal86=(Token)match(input,24,FOLLOW_24_in_modulecontainerBody1451); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal86_tree = (Object)adaptor.create(char_literal86);
            adaptor.addChild(root_0, char_literal86_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:540:8: (decls= commaSeparatedBodyDecls[Module.class] )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Identifier) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:540:9: decls= commaSeparatedBodyDecls[Module.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_modulecontainerBody1456);
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

            char_literal87=(Token)match(input,25,FOLLOW_25_in_modulecontainerBody1464); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 51, modulecontainerBody_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:549:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
    public final MstageParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls(Class targetType) throws RecognitionException {
        MstageParser.commaSeparatedBodyDecls_return retval = new MstageParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);
        int commaSeparatedBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token char_literal88=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object id_tree=null;
        Object char_literal88_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:551:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:551:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls1492); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:551:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==29) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:551:19: ',' decls= commaSeparatedBodyDecls[$targetType]
                    {
                    char_literal88=(Token)match(input,29,FOLLOW_29_in_commaSeparatedBodyDecls1495); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal88_tree = (Object)adaptor.create(char_literal88);
                    adaptor.addChild(root_0, char_literal88_tree);
                    }
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1499);
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
        public AdviceType value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceType"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:566:1: adviceType returns [AdviceType value] : ( 'before' | 'after' | 'around' );
    public final MstageParser.adviceType_return adviceType() throws RecognitionException {
        MstageParser.adviceType_return retval = new MstageParser.adviceType_return();
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:567:2: ( 'before' | 'after' | 'around' )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt27=1;
                }
                break;
            case 53:
                {
                alt27=2;
                }
                break;
            case 54:
                {
                alt27=3;
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:567:4: 'before'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal89=(Token)match(input,52,FOLLOW_52_in_adviceType1531); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = (Object)adaptor.create(string_literal89);
                    adaptor.addChild(root_0, string_literal89_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = AdviceType.BEFORE;
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:568:4: 'after'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal90=(Token)match(input,53,FOLLOW_53_in_adviceType1538); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = (Object)adaptor.create(string_literal90);
                    adaptor.addChild(root_0, string_literal90_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = AdviceType.AFTER;
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:569:4: 'around'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal91=(Token)match(input,54,FOLLOW_54_in_adviceType1545); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal91_tree = (Object)adaptor.create(string_literal91);
                    adaptor.addChild(root_0, string_literal91_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 53, adviceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:572:1: joinpointKind returns [JoinpointKind value] : ( 'execution' | 'call' );
    public final MstageParser.joinpointKind_return joinpointKind() throws RecognitionException {
        MstageParser.joinpointKind_return retval = new MstageParser.joinpointKind_return();
        retval.start = input.LT(1);
        int joinpointKind_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal92=null;
        Token string_literal93=null;

        Object string_literal92_tree=null;
        Object string_literal93_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:573:2: ( 'execution' | 'call' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==55) ) {
                alt28=1;
            }
            else if ( (LA28_0==56) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:573:4: 'execution'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal92=(Token)match(input,55,FOLLOW_55_in_joinpointKind1563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (Object)adaptor.create(string_literal92);
                    adaptor.addChild(root_0, string_literal92_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = JoinpointKind.EXECUTION;
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:574:4: 'call'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal93=(Token)match(input,56,FOLLOW_56_in_joinpointKind1570); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal93_tree = (Object)adaptor.create(string_literal93);
                    adaptor.addChild(root_0, string_literal93_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 54, joinpointKind_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:577:1: voidType returns [TypeReference value] : 'void' ;
    public final MstageParser.voidType_return voidType() throws RecognitionException {
        MstageParser.voidType_return retval = new MstageParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal94=null;

        Object string_literal94_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:579:7: ( 'void' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:579:10: 'void'
            {
            root_0 = (Object)adaptor.nil();

            string_literal94=(Token)match(input,57,FOLLOW_57_in_voidType1596); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal94_tree = (Object)adaptor.create(string_literal94);
            adaptor.addChild(root_0, string_literal94_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 55, voidType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:583:1: type returns [TypeReference value] : (cd= classOrInterfaceType | pt= primitiveType );
    public final MstageParser.type_return type() throws RecognitionException {
        MstageParser.type_return retval = new MstageParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.classOrInterfaceType_return cd = null;

        MstageParser.primitiveType_return pt = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:585:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==Identifier) ) {
                alt29=1;
            }
            else if ( ((LA29_0>=59 && LA29_0<=66)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:585:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceType_in_type1623);
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:586:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveType_in_type1632);
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
            if ( state.backtracking>0 ) { memoize(input, 56, type_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:590:1: classOrInterfaceType returns [TypeReference element] : name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* ;
    public final MstageParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MstageParser.classOrInterfaceType_return retval = new MstageParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal96=null;
        MstageParser.typeArguments_return typeArguments95 = null;

        MstageParser.typeArguments_return typeArguments97 = null;


        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal96_tree=null;

        NamespaceOrTypeReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:592:2: (name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:592:4: name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType1657); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new BasicTypeReference((name!=null?name.getText():null)); 
              	           target =  new NamespaceOrTypeReference((name!=null?name.getText():null)); 
              	          
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:597:4: ( typeArguments )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==67) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType1676);
                    typeArguments95=typeArguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments95.getTree());

                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:598:10: ( '.' namex= Identifier ( typeArguments )? )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==58) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:598:11: '.' namex= Identifier ( typeArguments )?
            	    {
            	    char_literal96=(Token)match(input,58,FOLLOW_58_in_classOrInterfaceType1690); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal96_tree = (Object)adaptor.create(char_literal96);
            	    adaptor.addChild(root_0, char_literal96_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType1694); if (state.failed) return retval;
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
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:609:11: ( typeArguments )?
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==67) ) {
            	        alt31=1;
            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType1721);
            	            typeArguments97=typeArguments();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments97.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
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
            if ( state.backtracking>0 ) { memoize(input, 57, classOrInterfaceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:613:1: primitiveType returns [TypeReference value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MstageParser.primitiveType_return primitiveType() throws RecognitionException {
        MstageParser.primitiveType_return retval = new MstageParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal98=null;
        Token string_literal99=null;
        Token string_literal100=null;
        Token string_literal101=null;
        Token string_literal102=null;
        Token string_literal103=null;
        Token string_literal104=null;
        Token string_literal105=null;

        Object string_literal98_tree=null;
        Object string_literal99_tree=null;
        Object string_literal100_tree=null;
        Object string_literal101_tree=null;
        Object string_literal102_tree=null;
        Object string_literal103_tree=null;
        Object string_literal104_tree=null;
        Object string_literal105_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:614:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt33=8;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt33=1;
                }
                break;
            case 60:
                {
                alt33=2;
                }
                break;
            case 61:
                {
                alt33=3;
                }
                break;
            case 62:
                {
                alt33=4;
                }
                break;
            case 63:
                {
                alt33=5;
                }
                break;
            case 64:
                {
                alt33=6;
                }
                break;
            case 65:
                {
                alt33=7;
                }
                break;
            case 66:
                {
                alt33=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:614:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal98=(Token)match(input,59,FOLLOW_59_in_primitiveType1746); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal98_tree = (Object)adaptor.create(string_literal98);
                    adaptor.addChild(root_0, string_literal98_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:615:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal99=(Token)match(input,60,FOLLOW_60_in_primitiveType1758); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal99_tree = (Object)adaptor.create(string_literal99);
                    adaptor.addChild(root_0, string_literal99_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("char");
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:616:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal100=(Token)match(input,61,FOLLOW_61_in_primitiveType1770); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal100_tree = (Object)adaptor.create(string_literal100);
                    adaptor.addChild(root_0, string_literal100_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("byte");
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:617:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal101=(Token)match(input,62,FOLLOW_62_in_primitiveType1782); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal101_tree = (Object)adaptor.create(string_literal101);
                    adaptor.addChild(root_0, string_literal101_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("short");
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:618:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal102=(Token)match(input,63,FOLLOW_63_in_primitiveType1794); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal102_tree = (Object)adaptor.create(string_literal102);
                    adaptor.addChild(root_0, string_literal102_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("int");
                    }

                    }
                    break;
                case 6 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:619:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal103=(Token)match(input,64,FOLLOW_64_in_primitiveType1806); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal103_tree = (Object)adaptor.create(string_literal103);
                    adaptor.addChild(root_0, string_literal103_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("long");
                    }

                    }
                    break;
                case 7 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:620:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal104=(Token)match(input,65,FOLLOW_65_in_primitiveType1818); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal104_tree = (Object)adaptor.create(string_literal104);
                    adaptor.addChild(root_0, string_literal104_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new BasicTypeReference("float");
                    }

                    }
                    break;
                case 8 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:621:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal105=(Token)match(input,66,FOLLOW_66_in_primitiveType1830); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal105_tree = (Object)adaptor.create(string_literal105);
                    adaptor.addChild(root_0, string_literal105_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 58, primitiveType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primitiveType"

    public static class typeArguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArguments"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:626:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final MstageParser.typeArguments_return typeArguments() throws RecognitionException {
        MstageParser.typeArguments_return retval = new MstageParser.typeArguments_return();
        retval.start = input.LT(1);
        int typeArguments_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal106=null;
        Token char_literal108=null;
        Token char_literal110=null;
        MstageParser.typeArgument_return typeArgument107 = null;

        MstageParser.typeArgument_return typeArgument109 = null;


        Object char_literal106_tree=null;
        Object char_literal108_tree=null;
        Object char_literal110_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:627:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:627:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal106=(Token)match(input,67,FOLLOW_67_in_typeArguments1853); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal106_tree = (Object)adaptor.create(char_literal106);
            adaptor.addChild(root_0, char_literal106_tree);
            }
            pushFollow(FOLLOW_typeArgument_in_typeArguments1855);
            typeArgument107=typeArgument();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument107.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:627:26: ( ',' typeArgument )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==29) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:627:28: ',' typeArgument
            	    {
            	    char_literal108=(Token)match(input,29,FOLLOW_29_in_typeArguments1859); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal108_tree = (Object)adaptor.create(char_literal108);
            	    adaptor.addChild(root_0, char_literal108_tree);
            	    }
            	    pushFollow(FOLLOW_typeArgument_in_typeArguments1861);
            	    typeArgument109=typeArgument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument109.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            char_literal110=(Token)match(input,68,FOLLOW_68_in_typeArguments1866); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal110_tree = (Object)adaptor.create(char_literal110);
            adaptor.addChild(root_0, char_literal110_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, typeArguments_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArguments"

    public static class typeArgument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArgument"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:630:1: typeArgument : (t= type | '?' ( ( 'extends' | 'super' ) t= type )? );
    public final MstageParser.typeArgument_return typeArgument() throws RecognitionException {
        MstageParser.typeArgument_return retval = new MstageParser.typeArgument_return();
        retval.start = input.LT(1);
        int typeArgument_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal111=null;
        Token set112=null;
        MstageParser.type_return t = null;


        Object char_literal111_tree=null;
        Object set112_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:631:5: (t= type | '?' ( ( 'extends' | 'super' ) t= type )? )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==Identifier||(LA36_0>=59 && LA36_0<=66)) ) {
                alt36=1;
            }
            else if ( (LA36_0==69) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:631:9: t= type
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_typeArgument1891);
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:631:20: '?' ( ( 'extends' | 'super' ) t= type )?
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal111=(Token)match(input,69,FOLLOW_69_in_typeArgument1897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal111_tree = (Object)adaptor.create(char_literal111);
                    adaptor.addChild(root_0, char_literal111_tree);
                    }
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:631:25: ( ( 'extends' | 'super' ) t= type )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( ((LA35_0>=70 && LA35_0<=71)) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:631:27: ( 'extends' | 'super' ) t= type
                            {
                            set112=(Token)input.LT(1);
                            if ( (input.LA(1)>=70 && input.LA(1)<=71) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set112));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_type_in_typeArgument1912);
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
            if ( state.backtracking>0 ) { memoize(input, 60, typeArgument_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArgument"

    public static class annotations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotations"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:639:1: annotations : ( annotation )+ ;
    public final MstageParser.annotations_return annotations() throws RecognitionException {
        MstageParser.annotations_return retval = new MstageParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation113 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:640:5: ( ( annotation )+ )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:640:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:640:9: ( annotation )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==72) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations1939);
            	    annotation113=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation113.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
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
            if ( state.backtracking>0 ) { memoize(input, 61, annotations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotations"

    public static class annotation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotation"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:643:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MstageParser.annotation_return annotation() throws RecognitionException {
        MstageParser.annotation_return retval = new MstageParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal114=null;
        Token char_literal116=null;
        Token char_literal119=null;
        MstageParser.annotationName_return annotationName115 = null;

        MstageParser.elementValuePairs_return elementValuePairs117 = null;

        MstageParser.elementValue_return elementValue118 = null;


        Object char_literal114_tree=null;
        Object char_literal116_tree=null;
        Object char_literal119_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            char_literal114=(Token)match(input,72,FOLLOW_72_in_annotation1959); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal114_tree = (Object)adaptor.create(char_literal114);
            adaptor.addChild(root_0, char_literal114_tree);
            }
            pushFollow(FOLLOW_annotationName_in_annotation1961);
            annotationName115=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName115.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==27) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal116=(Token)match(input,27,FOLLOW_27_in_annotation1965); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal116_tree = (Object)adaptor.create(char_literal116);
                    adaptor.addChild(root_0, char_literal116_tree);
                    }
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:34: ( elementValuePairs | elementValue )?
                    int alt38=3;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==Identifier) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==24||LA38_0==72) ) {
                        alt38=2;
                    }
                    switch (alt38) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation1969);
                            elementValuePairs117=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs117.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation1973);
                            elementValue118=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue118.getTree());

                            }
                            break;

                    }

                    char_literal119=(Token)match(input,28,FOLLOW_28_in_annotation1978); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal119_tree = (Object)adaptor.create(char_literal119);
                    adaptor.addChild(root_0, char_literal119_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 62, annotation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotation"

    public static class annotationName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationName"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:647:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MstageParser.annotationName_return annotationName() throws RecognitionException {
        MstageParser.annotationName_return retval = new MstageParser.annotationName_return();
        retval.start = input.LT(1);
        int annotationName_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier120=null;
        Token char_literal121=null;
        Token Identifier122=null;

        Object Identifier120_tree=null;
        Object char_literal121_tree=null;
        Object Identifier122_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:648:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:648:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            Identifier120=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2002); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier120_tree = (Object)adaptor.create(Identifier120);
            adaptor.addChild(root_0, Identifier120_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:648:18: ( '.' Identifier )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==58) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:648:19: '.' Identifier
            	    {
            	    char_literal121=(Token)match(input,58,FOLLOW_58_in_annotationName2005); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal121_tree = (Object)adaptor.create(char_literal121);
            	    adaptor.addChild(root_0, char_literal121_tree);
            	    }
            	    Identifier122=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2007); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier122_tree = (Object)adaptor.create(Identifier122);
            	    adaptor.addChild(root_0, Identifier122_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 63, annotationName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationName"

    public static class elementValuePairs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePairs"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:651:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MstageParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MstageParser.elementValuePairs_return retval = new MstageParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal124=null;
        MstageParser.elementValuePair_return elementValuePair123 = null;

        MstageParser.elementValuePair_return elementValuePair125 = null;


        Object char_literal124_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:652:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:652:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2028);
            elementValuePair123=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair123.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:652:26: ( ',' elementValuePair )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==29) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:652:27: ',' elementValuePair
            	    {
            	    char_literal124=(Token)match(input,29,FOLLOW_29_in_elementValuePairs2031); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal124_tree = (Object)adaptor.create(char_literal124);
            	    adaptor.addChild(root_0, char_literal124_tree);
            	    }
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2033);
            	    elementValuePair125=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair125.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 64, elementValuePairs_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePairs"

    public static class elementValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePair"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:655:1: elementValuePair : Identifier '=' elementValue ;
    public final MstageParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MstageParser.elementValuePair_return retval = new MstageParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier126=null;
        Token char_literal127=null;
        MstageParser.elementValue_return elementValue128 = null;


        Object Identifier126_tree=null;
        Object char_literal127_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:656:5: ( Identifier '=' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:656:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();

            Identifier126=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair2054); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier126_tree = (Object)adaptor.create(Identifier126);
            adaptor.addChild(root_0, Identifier126_tree);
            }
            char_literal127=(Token)match(input,73,FOLLOW_73_in_elementValuePair2056); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal127_tree = (Object)adaptor.create(char_literal127);
            adaptor.addChild(root_0, char_literal127_tree);
            }
            pushFollow(FOLLOW_elementValue_in_elementValuePair2058);
            elementValue128=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue128.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, elementValuePair_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePair"

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:659:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MstageParser.elementValue_return elementValue() throws RecognitionException {
        MstageParser.elementValue_return retval = new MstageParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation129 = null;

        MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer130 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:660:5: ( annotation | elementValueArrayInitializer )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==72) ) {
                alt42=1;
            }
            else if ( (LA42_0==24) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:660:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotation_in_elementValue2081);
                    annotation129=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation129.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:661:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue2091);
                    elementValueArrayInitializer130=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer130.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 66, elementValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValue"

    public static class elementValueArrayInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValueArrayInitializer"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:664:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MstageParser.elementValueArrayInitializer_return retval = new MstageParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal131=null;
        Token char_literal133=null;
        Token char_literal135=null;
        Token char_literal136=null;
        MstageParser.elementValue_return elementValue132 = null;

        MstageParser.elementValue_return elementValue134 = null;


        Object char_literal131_tree=null;
        Object char_literal133_tree=null;
        Object char_literal135_tree=null;
        Object char_literal136_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal131=(Token)match(input,24,FOLLOW_24_in_elementValueArrayInitializer2114); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal131_tree = (Object)adaptor.create(char_literal131);
            adaptor.addChild(root_0, char_literal131_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:13: ( elementValue ( ',' elementValue )* )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==24||LA44_0==72) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2117);
                    elementValue132=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue132.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:27: ( ',' elementValue )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==29) ) {
                            int LA43_1 = input.LA(2);

                            if ( (LA43_1==24||LA43_1==72) ) {
                                alt43=1;
                            }


                        }


                        switch (alt43) {
                    	case 1 :
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:28: ',' elementValue
                    	    {
                    	    char_literal133=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2120); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal133_tree = (Object)adaptor.create(char_literal133);
                    	    adaptor.addChild(root_0, char_literal133_tree);
                    	    }
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2122);
                    	    elementValue134=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue134.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:49: ( ',' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==29) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:665:50: ','
                    {
                    char_literal135=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2129); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal135_tree = (Object)adaptor.create(char_literal135);
                    adaptor.addChild(root_0, char_literal135_tree);
                    }

                    }
                    break;

            }

            char_literal136=(Token)match(input,25,FOLLOW_25_in_elementValueArrayInitializer2133); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal136_tree = (Object)adaptor.create(char_literal136);
            adaptor.addChild(root_0, char_literal136_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, elementValueArrayInitializer_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:668:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MstageParser.annotationTypeDeclaration_return retval = new MstageParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal137=null;
        Token string_literal138=null;
        MstageParser.annotationTypeBody_return annotationTypeBody139 = null;


        Object name_tree=null;
        Object char_literal137_tree=null;
        Object string_literal138_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:669:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:669:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();

            char_literal137=(Token)match(input,72,FOLLOW_72_in_annotationTypeDeclaration2160); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal137_tree = (Object)adaptor.create(char_literal137);
            adaptor.addChild(root_0, char_literal137_tree);
            }
            string_literal138=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration2162); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal138_tree = (Object)adaptor.create(string_literal138);
            adaptor.addChild(root_0, string_literal138_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration2166); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2168);
            annotationTypeBody139=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody139.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, annotationTypeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeDeclaration"

    public static class annotationTypeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:672:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MstageParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MstageParser.annotationTypeBody_return retval = new MstageParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal140=null;
        Token char_literal142=null;
        MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration141 = null;


        Object char_literal140_tree=null;
        Object char_literal142_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:673:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:673:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal140=(Token)match(input,24,FOLLOW_24_in_annotationTypeBody2191); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal140_tree = (Object)adaptor.create(char_literal140);
            adaptor.addChild(root_0, char_literal140_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:673:13: ( annotationTypeElementDeclaration )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==Identifier||(LA46_0>=59 && LA46_0<=66)||LA46_0==72) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:673:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2194);
            	    annotationTypeElementDeclaration141=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration141.getTree());

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            char_literal142=(Token)match(input,25,FOLLOW_25_in_annotationTypeBody2198); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal142_tree = (Object)adaptor.create(char_literal142);
            adaptor.addChild(root_0, char_literal142_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, annotationTypeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeBody"

    public static class annotationTypeElementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:676:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MstageParser.annotationTypeElementDeclaration_return retval = new MstageParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationTypeElementRest_return annotationTypeElementRest143 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:677:5: ( annotationTypeElementRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:677:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2223);
            annotationTypeElementRest143=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest143.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 70, annotationTypeElementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementDeclaration"

    public static class annotationTypeElementRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:680:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MstageParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MstageParser.annotationTypeElementRest_return retval = new MstageParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal146=null;
        Token char_literal148=null;
        MstageParser.type_return type144 = null;

        MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest145 = null;

        MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration147 = null;


        Object char_literal146_tree=null;
        Object char_literal148_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:681:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Identifier||(LA48_0>=59 && LA48_0<=66)) ) {
                alt48=1;
            }
            else if ( (LA48_0==72) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:681:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2246);
                    type144=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type144.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2248);
                    annotationMethodOrConstantRest145=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest145.getTree());
                    char_literal146=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2250); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal146_tree = (Object)adaptor.create(char_literal146);
                    adaptor.addChild(root_0, char_literal146_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:682:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2260);
                    annotationTypeDeclaration147=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration147.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:682:35: ( ';' )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==26) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: ';'
                            {
                            char_literal148=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2262); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal148_tree = (Object)adaptor.create(char_literal148);
                            adaptor.addChild(root_0, char_literal148_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 71, annotationTypeElementRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementRest"

    public static class annotationMethodOrConstantRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodOrConstantRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:685:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MstageParser.annotationMethodOrConstantRest_return retval = new MstageParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationMethodRest_return annotationMethodRest149 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:686:5: ( annotationMethodRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:686:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2286);
            annotationMethodRest149=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest149.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, annotationMethodOrConstantRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodOrConstantRest"

    public static class annotationMethodRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:689:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MstageParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MstageParser.annotationMethodRest_return retval = new MstageParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier150=null;
        Token char_literal151=null;
        Token char_literal152=null;
        MstageParser.defaultValue_return defaultValue153 = null;


        Object Identifier150_tree=null;
        Object char_literal151_tree=null;
        Object char_literal152_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:690:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:690:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier150=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2309); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier150_tree = (Object)adaptor.create(Identifier150);
            adaptor.addChild(root_0, Identifier150_tree);
            }
            char_literal151=(Token)match(input,27,FOLLOW_27_in_annotationMethodRest2311); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal151_tree = (Object)adaptor.create(char_literal151);
            adaptor.addChild(root_0, char_literal151_tree);
            }
            char_literal152=(Token)match(input,28,FOLLOW_28_in_annotationMethodRest2313); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal152_tree = (Object)adaptor.create(char_literal152);
            adaptor.addChild(root_0, char_literal152_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:690:28: ( defaultValue )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==74) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest2315);
                    defaultValue153=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue153.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 73, annotationMethodRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodRest"

    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:693:1: defaultValue : 'default' elementValue ;
    public final MstageParser.defaultValue_return defaultValue() throws RecognitionException {
        MstageParser.defaultValue_return retval = new MstageParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal154=null;
        MstageParser.elementValue_return elementValue155 = null;


        Object string_literal154_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:694:5: ( 'default' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:694:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();

            string_literal154=(Token)match(input,74,FOLLOW_74_in_defaultValue2343); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal154_tree = (Object)adaptor.create(string_literal154);
            adaptor.addChild(root_0, string_literal154_tree);
            }
            pushFollow(FOLLOW_elementValue_in_defaultValue2345);
            elementValue155=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue155.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 74, defaultValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // $ANTLR start synpred16_Mstage
    public final void synpred16_Mstage_fragment() throws RecognitionException {   
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:242:29: ( . )
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:242:29: .
        {
        matchAny(input); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_Mstage

    // $ANTLR start synpred19_Mstage
    public final void synpred19_Mstage_fragment() throws RecognitionException {   
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:282:27: ( . )
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:282:27: .
        {
        matchAny(input); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_Mstage

    // Delegated rules

    public final boolean synpred19_Mstage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_Mstage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_Mstage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_Mstage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit90 = new BitSet(new long[]{0x0001720040800002L});
    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit103 = new BitSet(new long[]{0x0001720040800002L});
    public static final BitSet FOLLOW_compositeDeclaration_in_compilationUnit119 = new BitSet(new long[]{0x0001720040800002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_compilationUnit132 = new BitSet(new long[]{0x0001720040800002L});
    public static final BitSet FOLLOW_applicationDeclaration_in_compilationUnit145 = new BitSet(new long[]{0x0001720040800002L});
    public static final BitSet FOLLOW_deploymentDeclaration_in_compilationUnit158 = new BitSet(new long[]{0x0001720040800002L});
    public static final BitSet FOLLOW_abstractHostDeclaration_in_compilationUnit171 = new BitSet(new long[]{0x0001720040800002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration205 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration209 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_interfaceBody229 = new BitSet(new long[]{0xFA00000002000010L,0x0000000000000007L});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody231 = new BitSet(new long[]{0xFA00000002000010L,0x0000000000000007L});
    public static final BitSet FOLLOW_25_in_interfaceBody235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration252 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceBodyDeclaration253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceDeclaration280 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_serviceDeclaration284 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceDeclaration288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_formalParameters359 = new BitSet(new long[]{0xFA00000010000010L,0x0000000000000007L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters364 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_formalParameters370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls395 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls399 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_formalParameterDecls402 = new BitSet(new long[]{0xFA00000000000010L,0x0000000000000007L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_connectorDeclaration440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration444 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorBody462 = new BitSet(new long[]{0x0000040082000000L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody465 = new BitSet(new long[]{0x0000040082000000L});
    public static final BitSet FOLLOW_25_in_connectorBody470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_connectorAOCompositionDeclaration507 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorAOCompositionDeclaration511 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorAOCompositionBody533 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody537 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_connectorAOCompositionBody543 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_connectorAOCompositionBody545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_pointcutDeclaration562 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutBody582 = new BitSet(new long[]{0x0000000A02000000L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody584 = new BitSet(new long[]{0x0000000A02000000L});
    public static final BitSet FOLLOW_25_in_pointcutBody588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pointcutKindDeclaration623 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutKindDeclaration625 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_joinpointKind_in_pointcutKindDeclaration629 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutKindDeclaration631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_pointcutSignatureDeclaration646 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutSignatureDeclaration648 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000007FFL});
    public static final BitSet FOLLOW_26_in_pointcutSignatureDeclaration657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_pointcutCallerDeclaration677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_pointcutCalleeDeclaration690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_adviceDeclaration708 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_adviceBody725 = new BitSet(new long[]{0x0000018002000000L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody727 = new BitSet(new long[]{0x0000018002000000L});
    public static final BitSet FOLLOW_25_in_adviceBody731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_adviceServiceDeclaration764 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceServiceDeclaration766 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000007FFL});
    public static final BitSet FOLLOW_26_in_adviceServiceDeclaration775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_adviceTypeDeclaration790 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceTypeDeclaration792 = new BitSet(new long[]{0x0070000000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration796 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceTypeDeclaration798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_componentDeclaration825 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration829 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_componentBody855 = new BitSet(new long[]{0x00000C0082000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody857 = new BitSet(new long[]{0x00000C0082000000L});
    public static final BitSet FOLLOW_25_in_componentBody861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_moduleDependencyBody916 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody921 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_moduleDependencyBody929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_moduleRequireDependencyDeclaration944 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_moduleProvideDependencyDeclaration963 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_compositeDeclaration996 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_compositeDeclaration1000 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_compositeBody_in_compositeDeclaration1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_compositeBody1020 = new BitSet(new long[]{0x00008C0082000000L});
    public static final BitSet FOLLOW_compositeBodyDeclaration_in_compositeBody1023 = new BitSet(new long[]{0x00008C0082000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_compositeBody1028 = new BitSet(new long[]{0x00008C0082000000L});
    public static final BitSet FOLLOW_25_in_compositeBody1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modulecontainerDeclaration_in_compositeBodyDeclaration1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_applicationDeclaration1070 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_applicationDeclaration1074 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_applicationBody_in_applicationDeclaration1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_applicationBody1091 = new BitSet(new long[]{0x000C800002000000L});
    public static final BitSet FOLLOW_applicationBodyDeclaration_in_applicationBody1093 = new BitSet(new long[]{0x000C800002000000L});
    public static final BitSet FOLLOW_25_in_applicationBody1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modulecontainerDeclaration_in_applicationBodyDeclaration1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_locateDeclaration_in_applicationBodyDeclaration1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mappingDeclaration_in_locateDeclaration1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_deploymentDeclaration1157 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_deploymentDeclaration1161 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_deploymentBody_in_deploymentDeclaration1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_deploymentBody1178 = new BitSet(new long[]{0x000C800002000000L});
    public static final BitSet FOLLOW_deploymentBodyDeclaration_in_deploymentBody1180 = new BitSet(new long[]{0x000C800002000000L});
    public static final BitSet FOLLOW_25_in_deploymentBody1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_appcontainDeclaration_in_deploymentBodyDeclaration1197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hostMapDeclaration_in_deploymentBodyDeclaration1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_appcontainDeclaration1221 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_appcontainBody_in_appcontainDeclaration1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_appcontainBody1248 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_appcontainBody1253 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_appcontainBody1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mappingDeclaration_in_hostMapDeclaration1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_abstractHostDeclaration1298 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_abstractHostDeclaration1302 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_abstractHostBody_in_abstractHostDeclaration1306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_abstractHostBody1322 = new BitSet(new long[]{0x0002000002000000L});
    public static final BitSet FOLLOW_abstractHostBodyDeclaration_in_abstractHostBody1324 = new BitSet(new long[]{0x0002000002000000L});
    public static final BitSet FOLLOW_25_in_abstractHostBody1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_abstractHostBodyDeclaration1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_mappingDeclaration1359 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_mappingDeclaration1367 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_mappingDeclarationBody_in_mappingDeclaration1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_mappingDeclarationBody1390 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_mappingDeclarationBody1398 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_mappingDeclarationBody1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_modulecontainerDeclaration1426 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_modulecontainerBody_in_modulecontainerDeclaration1430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_modulecontainerBody1451 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_modulecontainerBody1456 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_modulecontainerBody1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls1492 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_commaSeparatedBodyDecls1495 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_adviceType1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_adviceType1538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_adviceType1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_joinpointKind1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_joinpointKind1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_voidType1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType1657 = new BitSet(new long[]{0x0400000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType1676 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_classOrInterfaceType1690 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType1694 = new BitSet(new long[]{0x0400000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType1721 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_59_in_primitiveType1746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_primitiveType1758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_primitiveType1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType1782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_primitiveType1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_primitiveType1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_primitiveType1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_primitiveType1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_typeArguments1853 = new BitSet(new long[]{0xFA00000000000010L,0x0000000000000027L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments1855 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_29_in_typeArguments1859 = new BitSet(new long[]{0xFA00000000000010L,0x0000000000000027L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments1861 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_typeArguments1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_typeArgument1897 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_set_in_typeArgument1902 = new BitSet(new long[]{0xFA00000000000010L,0x0000000000000007L});
    public static final BitSet FOLLOW_type_in_typeArgument1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations1939 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_annotation1959 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation1961 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_annotation1965 = new BitSet(new long[]{0x0000000011000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation1969 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation1973 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotation1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2002 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_annotationName2005 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2007 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2028 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_elementValuePairs2031 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2033 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair2054 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_elementValuePair2056 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue2091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_elementValueArrayInitializer2114 = new BitSet(new long[]{0x0000000023000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2117 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2120 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2122 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2129 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elementValueArrayInitializer2133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_annotationTypeDeclaration2160 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration2162 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration2166 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeBody2191 = new BitSet(new long[]{0xFA00000002000010L,0x0000000000000107L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2194 = new BitSet(new long[]{0xFA00000002000010L,0x0000000000000107L});
    public static final BitSet FOLLOW_25_in_annotationTypeBody2198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2246 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2248 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2260 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2309 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_annotationMethodRest2311 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotationMethodRest2313 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_defaultValue2343 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2345 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g 2010-06-16 14:30:53

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "StringLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "'{'", "'}'", "';'", "'('", "')'", "','", "'connector'", "'ao-composition'", "'pointcut'", "'kind'", "':'", "'signature'", "'caller'", "'callee'", "'advice'", "'service'", "'type'", "'component'", "'require'", "'provide'", "'composite'", "'application'", "'locate'", "'deployment'", "'contain'", "'before'", "'after'", "'around'", "'execution'", "'call'", "'void'", "'.'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'<'", "'>'", "'?'", "'extends'", "'super'", "'@'", "'='", "'default'"
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
    public static final int Letter=18;
    public static final int OctalEscape=17;
    public static final int EscapeSequence=13;

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
            this.state.ruleMemo = new HashMap[126+1];
             
             
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:74:1: compilationUnit returns [CompilationUnit element] : (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )* ;
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



         
        	retval.element = getCompilationUnit();
        	NamespacePart npp = new NamespacePart(language().defaultNamespace());
        	retval.element.add(npp);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:80:2: ( (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:80:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:80:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cmd= compositeDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )*
            loop1:
            do {
                int alt1=7;
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
                case 47:
                    {
                    alt1=6;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:104:1: interfaceDeclaration returns [Interface element] : intkw= 'interface' name= Identifier interfaceBody[$element] ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:105:2: (intkw= 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:105:4: intkw= 'interface' name= Identifier interfaceBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            intkw=(Token)match(input,23,FOLLOW_23_in_interfaceDeclaration193); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            intkw_tree = (Object)adaptor.create(intkw);
            adaptor.addChild(root_0, intkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration197); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Interface(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,intkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration203);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:114:1: interfaceBody[Interface element] : '{' ( interfaceBodyDeclaration[$element] )* '}' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:115:2: ( '{' ( interfaceBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:115:4: '{' ( interfaceBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal2=(Token)match(input,24,FOLLOW_24_in_interfaceBody217); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:115:8: ( interfaceBodyDeclaration[$element] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||LA2_0==54||(LA2_0>=56 && LA2_0<=63)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: interfaceBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody219);
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

            char_literal4=(Token)match(input,25,FOLLOW_25_in_interfaceBody223); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:120:1: interfaceBodyDeclaration[Interface element] : (service= serviceDeclaration ';' ) ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:121:2: ( (service= serviceDeclaration ';' ) )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:121:4: (service= serviceDeclaration ';' )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:121:4: (service= serviceDeclaration ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:121:5: service= serviceDeclaration ';'
            {
            pushFollow(FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration240);
            service=serviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            char_literal5=(Token)match(input,26,FOLLOW_26_in_interfaceBodyDeclaration241); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:134:1: serviceDeclaration returns [Service element] : rtype= serviceReturnType name= Identifier params= formalParameters ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:135:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:135:4: rtype= serviceReturnType name= Identifier params= formalParameters
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceReturnType_in_serviceDeclaration268);
            rtype=serviceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceDeclaration272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_formalParameters_in_serviceDeclaration276);
            params=formalParameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, params.getTree());
            if ( state.backtracking==0 ) {

              			Signature signature = new SimpleNameSignature((name!=null?name.getText():null));
              			retval.element = new Service(signature,(rtype!=null?rtype.element:null),(params!=null?params.element:null),null); //TODO: add properties
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
        public TypeReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "serviceReturnType"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:141:1: serviceReturnType returns [TypeReference element] : (vt= voidType | tp= type ) ;
    public final MstageParser.serviceReturnType_return serviceReturnType() throws RecognitionException {
        MstageParser.serviceReturnType_return retval = new MstageParser.serviceReturnType_return();
        retval.start = input.LT(1);
        int serviceReturnType_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.voidType_return vt = null;

        MstageParser.type_return tp = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:142:2: ( (vt= voidType | tp= type ) )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:142:4: (vt= voidType | tp= type )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:142:4: (vt= voidType | tp= type )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==54) ) {
                alt3=1;
            }
            else if ( (LA3_0==Identifier||(LA3_0>=56 && LA3_0<=63)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:143:4: vt= voidType
                    {
                    pushFollow(FOLLOW_voidType_in_serviceReturnType301);
                    vt=voidType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vt.getTree());
                    if ( state.backtracking==0 ) {
                       retval.element =(vt!=null?vt.element:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:145:4: tp= type
                    {
                    pushFollow(FOLLOW_type_in_serviceReturnType315);
                    tp=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tp.getTree());
                    if ( state.backtracking==0 ) {
                       retval.element =(tp!=null?tp.element:null); 
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:149:1: formalParameters returns [List<FormalParameter> element] : '(' (pars= formalParameterDecls )? ')' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:151:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:151:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal6=(Token)match(input,27,FOLLOW_27_in_formalParameters347); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:151:13: (pars= formalParameterDecls )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Identifier||(LA4_0>=56 && LA4_0<=63)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:151:14: pars= formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters352);
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

            char_literal7=(Token)match(input,28,FOLLOW_28_in_formalParameters358); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:154:1: formalParameterDecls returns [List<FormalParameter> element] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:155:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:155:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_type_in_formalParameterDecls383);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls387); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:155:32: ( ',' decls= formalParameterDecls )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==29) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:155:33: ',' decls= formalParameterDecls
                    {
                    char_literal8=(Token)match(input,29,FOLLOW_29_in_formalParameterDecls390); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (Object)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);
                    }
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls394);
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
              				new FormalParameter(new SimpleNameSignature((name!=null?name.getText():null)),(t!=null?t.element:null));
              			
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

            conkw=(Token)match(input,30,FOLLOW_30_in_connectorDeclaration431); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            conkw_tree = (Object)adaptor.create(conkw);
            adaptor.addChild(root_0, conkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration435); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration437);
            connectorBody9=connectorBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorBody9.getTree());
            if ( state.backtracking==0 ) {

              			retval.element = new Connector(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,conkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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

            char_literal10=(Token)match(input,24,FOLLOW_24_in_connectorBody453); if (state.failed) return retval;
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
            	    pushFollow(FOLLOW_connectorBodyDeclaration_in_connectorBody456);
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

            char_literal12=(Token)match(input,25,FOLLOW_25_in_connectorBody461); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:191:1: connectorBodyDeclaration[Connector component] : ( connectorAOCompositionDeclaration | moduleRequireDependencyDeclaration[$component] );
    public final MstageParser.connectorBodyDeclaration_return connectorBodyDeclaration(Connector component) throws RecognitionException {
        MstageParser.connectorBodyDeclaration_return retval = new MstageParser.connectorBodyDeclaration_return();
        retval.start = input.LT(1);
        int connectorBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.connectorAOCompositionDeclaration_return connectorAOCompositionDeclaration13 = null;

        MstageParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration14 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:192:2: ( connectorAOCompositionDeclaration | moduleRequireDependencyDeclaration[$component] )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:192:4: connectorAOCompositionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration474);
                    connectorAOCompositionDeclaration13=connectorAOCompositionDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorAOCompositionDeclaration13.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:193:4: moduleRequireDependencyDeclaration[$component]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration479);
                    moduleRequireDependencyDeclaration14=moduleRequireDependencyDeclaration(component);

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
        public AOComposition element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectorAOCompositionDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:197:1: connectorAOCompositionDeclaration returns [AOComposition element] : 'ao-composition' name= Identifier aoc= connectorAOCompositionBody ;
    public final MstageParser.connectorAOCompositionDeclaration_return connectorAOCompositionDeclaration() throws RecognitionException {
        MstageParser.connectorAOCompositionDeclaration_return retval = new MstageParser.connectorAOCompositionDeclaration_return();
        retval.start = input.LT(1);
        int connectorAOCompositionDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token string_literal15=null;
        MstageParser.connectorAOCompositionBody_return aoc = null;


        Object name_tree=null;
        Object string_literal15_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:198:2: ( 'ao-composition' name= Identifier aoc= connectorAOCompositionBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:198:4: 'ao-composition' name= Identifier aoc= connectorAOCompositionBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal15=(Token)match(input,31,FOLLOW_31_in_connectorAOCompositionDeclaration498); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal15_tree = (Object)adaptor.create(string_literal15);
            adaptor.addChild(root_0, string_literal15_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorAOCompositionDeclaration502); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration506);
            aoc=connectorAOCompositionBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aoc.getTree());
            if ( state.backtracking==0 ) {

              			retval.element = new AOComposition(new SimpleNameSignature((name!=null?name.getText():null)));
              			
              			retval.element.setAdvice((aoc!=null?aoc.advice:null));
              			retval.element.setPointcut((aoc!=null?aoc.pointcut:null));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:207:1: connectorAOCompositionBody returns [Pointcut pointcut, Advice advice] : '{' pc= pointcutDeclaration adv= adviceDeclaration '}' ;
    public final MstageParser.connectorAOCompositionBody_return connectorAOCompositionBody() throws RecognitionException {
        MstageParser.connectorAOCompositionBody_return retval = new MstageParser.connectorAOCompositionBody_return();
        retval.start = input.LT(1);
        int connectorAOCompositionBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal16=null;
        Token char_literal17=null;
        MstageParser.pointcutDeclaration_return pc = null;

        MstageParser.adviceDeclaration_return adv = null;


        Object char_literal16_tree=null;
        Object char_literal17_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:208:2: ( '{' pc= pointcutDeclaration adv= adviceDeclaration '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:208:4: '{' pc= pointcutDeclaration adv= adviceDeclaration '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal16=(Token)match(input,24,FOLLOW_24_in_connectorAOCompositionBody524); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);
            }
            pushFollow(FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody528);
            pc=pointcutDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pc.getTree());
            pushFollow(FOLLOW_adviceDeclaration_in_connectorAOCompositionBody532);
            adv=adviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, adv.getTree());
            char_literal17=(Token)match(input,25,FOLLOW_25_in_connectorAOCompositionBody534); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal17_tree = (Object)adaptor.create(char_literal17);
            adaptor.addChild(root_0, char_literal17_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.pointcut = (pc!=null?pc.element:null);
              				retval.advice = (adv!=null?adv.element:null);
              			
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
        public Pointcut element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:220:1: pointcutDeclaration returns [Pointcut element] : 'pointcut' pointcutBody[$element] ;
    public final MstageParser.pointcutDeclaration_return pointcutDeclaration() throws RecognitionException {
        MstageParser.pointcutDeclaration_return retval = new MstageParser.pointcutDeclaration_return();
        retval.start = input.LT(1);
        int pointcutDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal18=null;
        MstageParser.pointcutBody_return pointcutBody19 = null;


        Object string_literal18_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:221:2: ( 'pointcut' pointcutBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:221:4: 'pointcut' pointcutBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            string_literal18=(Token)match(input,32,FOLLOW_32_in_pointcutDeclaration554); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal18_tree = (Object)adaptor.create(string_literal18);
            adaptor.addChild(root_0, string_literal18_tree);
            }
            pushFollow(FOLLOW_pointcutBody_in_pointcutDeclaration556);
            pointcutBody19=pointcutBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBody19.getTree());
            if ( state.backtracking==0 ) {

              				retval.element = new Pointcut();
              			
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:227:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
    public final MstageParser.pointcutBody_return pointcutBody(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutBody_return retval = new MstageParser.pointcutBody_return();
        retval.start = input.LT(1);
        int pointcutBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal20=null;
        Token char_literal22=null;
        MstageParser.pointcutBodyDeclaration_return pointcutBodyDeclaration21 = null;


        Object char_literal20_tree=null;
        Object char_literal22_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:228:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:228:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal20=(Token)match(input,24,FOLLOW_24_in_pointcutBody574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal20_tree = (Object)adaptor.create(char_literal20);
            adaptor.addChild(root_0, char_literal20_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:228:8: ( pointcutBodyDeclaration[$pointcut] )*
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
            	    pushFollow(FOLLOW_pointcutBodyDeclaration_in_pointcutBody576);
            	    pointcutBodyDeclaration21=pointcutBodyDeclaration(pointcut);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBodyDeclaration21.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            char_literal22=(Token)match(input,25,FOLLOW_25_in_pointcutBody580); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:231:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] );
    public final MstageParser.pointcutBodyDeclaration_return pointcutBodyDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutBodyDeclaration_return retval = new MstageParser.pointcutBodyDeclaration_return();
        retval.start = input.LT(1);
        int pointcutBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.pointcutKindDeclaration_return pointcutKindDeclaration23 = null;

        MstageParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration24 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:232:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:232:4: pointcutKindDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration593);
                    pointcutKindDeclaration23=pointcutKindDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutKindDeclaration23.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:233:4: pointcutSignatureDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration599);
                    pointcutSignatureDeclaration24=pointcutSignatureDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureDeclaration24.getTree());

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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:238:1: pointcutKindDeclaration[Pointcut pointcut] : 'kind' ':' kind= joinpointKind ';' ;
    public final MstageParser.pointcutKindDeclaration_return pointcutKindDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutKindDeclaration_return retval = new MstageParser.pointcutKindDeclaration_return();
        retval.start = input.LT(1);
        int pointcutKindDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal25=null;
        Token char_literal26=null;
        Token char_literal27=null;
        MstageParser.joinpointKind_return kind = null;


        Object string_literal25_tree=null;
        Object char_literal26_tree=null;
        Object char_literal27_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:239:2: ( 'kind' ':' kind= joinpointKind ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:239:4: 'kind' ':' kind= joinpointKind ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal25=(Token)match(input,33,FOLLOW_33_in_pointcutKindDeclaration615); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal25_tree = (Object)adaptor.create(string_literal25);
            adaptor.addChild(root_0, string_literal25_tree);
            }
            char_literal26=(Token)match(input,34,FOLLOW_34_in_pointcutKindDeclaration617); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal26_tree = (Object)adaptor.create(char_literal26);
            adaptor.addChild(root_0, char_literal26_tree);
            }
            pushFollow(FOLLOW_joinpointKind_in_pointcutKindDeclaration621);
            kind=joinpointKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, kind.getTree());
            char_literal27=(Token)match(input,26,FOLLOW_26_in_pointcutKindDeclaration623); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal27_tree = (Object)adaptor.create(char_literal27);
            adaptor.addChild(root_0, char_literal27_tree);
            }
            if ( state.backtracking==0 ) {

              				pointcut.setKind((kind!=null?kind.element:null));
              			
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:244:1: pointcutSignatureDeclaration[Pointcut pointcut] : 'signature' ':' pattern= ( ( . )* ) ';' ;
    public final MstageParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutSignatureDeclaration_return retval = new MstageParser.pointcutSignatureDeclaration_return();
        retval.start = input.LT(1);
        int pointcutSignatureDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token pattern=null;
        Token string_literal28=null;
        Token char_literal29=null;
        Token wildcard30=null;
        Token char_literal31=null;

        Object pattern_tree=null;
        Object string_literal28_tree=null;
        Object char_literal29_tree=null;
        Object wildcard30_tree=null;
        Object char_literal31_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:245:2: ( 'signature' ':' pattern= ( ( . )* ) ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:245:4: 'signature' ':' pattern= ( ( . )* ) ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal28=(Token)match(input,35,FOLLOW_35_in_pointcutSignatureDeclaration638); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal28_tree = (Object)adaptor.create(string_literal28);
            adaptor.addChild(root_0, string_literal28_tree);
            }
            char_literal29=(Token)match(input,34,FOLLOW_34_in_pointcutSignatureDeclaration640); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal29_tree = (Object)adaptor.create(char_literal29);
            adaptor.addChild(root_0, char_literal29_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:245:28: ( ( . )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:245:29: ( . )*
            {
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:245:29: ( . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26) ) {
                    int LA10_1 = input.LA(2);

                    if ( (synpred15_Mstage()) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>=Identifier && LA10_0<=25)||(LA10_0>=27 && LA10_0<=71)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: .
            	    {
            	    wildcard30=(Token)input.LT(1);
            	    matchAny(input); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    wildcard30_tree = (Object)adaptor.create(wildcard30);
            	    adaptor.addChild(root_0, wildcard30_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            char_literal31=(Token)match(input,26,FOLLOW_26_in_pointcutSignatureDeclaration649); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal31_tree = (Object)adaptor.create(char_literal31);
            adaptor.addChild(root_0, char_literal31_tree);
            }
            if ( state.backtracking==0 ) {

              				JoinPoint jp = new PatternJoinPoint((pattern!=null?pattern.getText():null));
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

        Token string_literal32=null;

        Object string_literal32_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:259:2: ( 'caller' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:259:4: 'caller'
            {
            root_0 = (Object)adaptor.nil();

            string_literal32=(Token)match(input,36,FOLLOW_36_in_pointcutCallerDeclaration669); if (state.failed) return retval;
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

        Token string_literal33=null;

        Object string_literal33_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:263:2: ( 'callee' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:263:4: 'callee'
            {
            root_0 = (Object)adaptor.nil();

            string_literal33=(Token)match(input,37,FOLLOW_37_in_pointcutCalleeDeclaration682); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal33_tree = (Object)adaptor.create(string_literal33);
            adaptor.addChild(root_0, string_literal33_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
        public Advice element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:267:1: adviceDeclaration returns [Advice element] : 'advice' adviceBody[$element] ;
    public final MstageParser.adviceDeclaration_return adviceDeclaration() throws RecognitionException {
        MstageParser.adviceDeclaration_return retval = new MstageParser.adviceDeclaration_return();
        retval.start = input.LT(1);
        int adviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal34=null;
        MstageParser.adviceBody_return adviceBody35 = null;


        Object string_literal34_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:268:2: ( 'advice' adviceBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:268:4: 'advice' adviceBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            string_literal34=(Token)match(input,38,FOLLOW_38_in_adviceDeclaration700); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal34_tree = (Object)adaptor.create(string_literal34);
            adaptor.addChild(root_0, string_literal34_tree);
            }
            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration702);
            adviceBody35=adviceBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBody35.getTree());
            if ( state.backtracking==0 ) {

              				retval.element = new Advice();
              			
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:273:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
    public final MstageParser.adviceBody_return adviceBody(Advice advice) throws RecognitionException {
        MstageParser.adviceBody_return retval = new MstageParser.adviceBody_return();
        retval.start = input.LT(1);
        int adviceBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal36=null;
        Token char_literal38=null;
        MstageParser.adviceBodyDeclaration_return adviceBodyDeclaration37 = null;


        Object char_literal36_tree=null;
        Object char_literal38_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:274:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:274:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal36=(Token)match(input,24,FOLLOW_24_in_adviceBody717); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal36_tree = (Object)adaptor.create(char_literal36);
            adaptor.addChild(root_0, char_literal36_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:274:8: ( adviceBodyDeclaration[$advice] )*
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
            	    pushFollow(FOLLOW_adviceBodyDeclaration_in_adviceBody719);
            	    adviceBodyDeclaration37=adviceBodyDeclaration(advice);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBodyDeclaration37.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            char_literal38=(Token)match(input,25,FOLLOW_25_in_adviceBody723); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:277:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] );
    public final MstageParser.adviceBodyDeclaration_return adviceBodyDeclaration(Advice advice) throws RecognitionException {
        MstageParser.adviceBodyDeclaration_return retval = new MstageParser.adviceBodyDeclaration_return();
        retval.start = input.LT(1);
        int adviceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.adviceServiceDeclaration_return adviceServiceDeclaration39 = null;

        MstageParser.adviceTypeDeclaration_return adviceTypeDeclaration40 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:278:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:278:4: adviceServiceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration736);
                    adviceServiceDeclaration39=adviceServiceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceServiceDeclaration39.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:279:4: adviceTypeDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration742);
                    adviceTypeDeclaration40=adviceTypeDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceTypeDeclaration40.getTree());

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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:282:1: adviceServiceDeclaration[Advice advice] : 'service' ':' service= ( ( . )* ) ';' ;
    public final MstageParser.adviceServiceDeclaration_return adviceServiceDeclaration(Advice advice) throws RecognitionException {
        MstageParser.adviceServiceDeclaration_return retval = new MstageParser.adviceServiceDeclaration_return();
        retval.start = input.LT(1);
        int adviceServiceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token service=null;
        Token string_literal41=null;
        Token char_literal42=null;
        Token wildcard43=null;
        Token char_literal44=null;

        Object service_tree=null;
        Object string_literal41_tree=null;
        Object char_literal42_tree=null;
        Object wildcard43_tree=null;
        Object char_literal44_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:283:2: ( 'service' ':' service= ( ( . )* ) ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:283:4: 'service' ':' service= ( ( . )* ) ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal41=(Token)match(input,39,FOLLOW_39_in_adviceServiceDeclaration756); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal41_tree = (Object)adaptor.create(string_literal41);
            adaptor.addChild(root_0, string_literal41_tree);
            }
            char_literal42=(Token)match(input,34,FOLLOW_34_in_adviceServiceDeclaration758); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal42_tree = (Object)adaptor.create(char_literal42);
            adaptor.addChild(root_0, char_literal42_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:283:26: ( ( . )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:283:27: ( . )*
            {
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:283:27: ( . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) ) {
                    int LA13_1 = input.LA(2);

                    if ( (synpred18_Mstage()) ) {
                        alt13=1;
                    }


                }
                else if ( ((LA13_0>=Identifier && LA13_0<=25)||(LA13_0>=27 && LA13_0<=71)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: .
            	    {
            	    wildcard43=(Token)input.LT(1);
            	    matchAny(input); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    wildcard43_tree = (Object)adaptor.create(wildcard43);
            	    adaptor.addChild(root_0, wildcard43_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            char_literal44=(Token)match(input,26,FOLLOW_26_in_adviceServiceDeclaration767); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal44_tree = (Object)adaptor.create(char_literal44);
            adaptor.addChild(root_0, char_literal44_tree);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:288:1: adviceTypeDeclaration[Advice advice] : 'type' ':' advtype= adviceType ';' ;
    public final MstageParser.adviceTypeDeclaration_return adviceTypeDeclaration(Advice advice) throws RecognitionException {
        MstageParser.adviceTypeDeclaration_return retval = new MstageParser.adviceTypeDeclaration_return();
        retval.start = input.LT(1);
        int adviceTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal45=null;
        Token char_literal46=null;
        Token char_literal47=null;
        MstageParser.adviceType_return advtype = null;


        Object string_literal45_tree=null;
        Object char_literal46_tree=null;
        Object char_literal47_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:289:2: ( 'type' ':' advtype= adviceType ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:289:4: 'type' ':' advtype= adviceType ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal45=(Token)match(input,40,FOLLOW_40_in_adviceTypeDeclaration782); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal45_tree = (Object)adaptor.create(string_literal45);
            adaptor.addChild(root_0, string_literal45_tree);
            }
            char_literal46=(Token)match(input,34,FOLLOW_34_in_adviceTypeDeclaration784); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal46_tree = (Object)adaptor.create(char_literal46);
            adaptor.addChild(root_0, char_literal46_tree);
            }
            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration788);
            advtype=adviceType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, advtype.getTree());
            char_literal47=(Token)match(input,26,FOLLOW_26_in_adviceTypeDeclaration790); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal47_tree = (Object)adaptor.create(char_literal47);
            adaptor.addChild(root_0, char_literal47_tree);
            }
            if ( state.backtracking==0 ) {

              			advice.setType((advtype!=null?advtype.element:null));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:300:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier componentBody[$element] ;
    public final MstageParser.componentDeclaration_return componentDeclaration() throws RecognitionException {
        MstageParser.componentDeclaration_return retval = new MstageParser.componentDeclaration_return();
        retval.start = input.LT(1);
        int componentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token compkw=null;
        Token name=null;
        MstageParser.componentBody_return componentBody48 = null;


        Object compkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:301:2: (compkw= 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:301:5: compkw= 'component' name= Identifier componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            compkw=(Token)match(input,41,FOLLOW_41_in_componentDeclaration817); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            compkw_tree = (Object)adaptor.create(compkw);
            adaptor.addChild(root_0, compkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration821); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                  			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                  			setKeyword(retval.element,compkw);
                  			setLocation(retval.element,name,"__NAME");
              			
            }
            pushFollow(FOLLOW_componentBody_in_componentDeclaration825);
            componentBody48=componentBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBody48.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:309:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
    public final MstageParser.componentBody_return componentBody(Component element) throws RecognitionException {
        MstageParser.componentBody_return retval = new MstageParser.componentBody_return();
        retval.start = input.LT(1);
        int componentBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal49=null;
        Token char_literal51=null;
        MstageParser.componentBodyDeclaration_return componentBodyDeclaration50 = null;


        Object char_literal49_tree=null;
        Object char_literal51_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:310:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:310:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal49=(Token)match(input,24,FOLLOW_24_in_componentBody847); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal49_tree = (Object)adaptor.create(char_literal49);
            adaptor.addChild(root_0, char_literal49_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:310:8: ( componentBodyDeclaration[$element] )*
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
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody849);
            	    componentBodyDeclaration50=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration50.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            char_literal51=(Token)match(input,25,FOLLOW_25_in_componentBody853); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:314:1: componentBodyDeclaration[Component element] : ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] );
    public final MstageParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MstageParser.componentBodyDeclaration_return retval = new MstageParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);
        int componentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration52 = null;

        MstageParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration53 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:315:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:315:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration871);
                    moduleRequireDependencyDeclaration52=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration52.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:316:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration877);
                    moduleProvideDependencyDeclaration53=moduleProvideDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleProvideDependencyDeclaration53.getTree());

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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:329:1: moduleDependencyBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' ;
    public final MstageParser.moduleDependencyBody_return moduleDependencyBody() throws RecognitionException {
        MstageParser.moduleDependencyBody_return retval = new MstageParser.moduleDependencyBody_return();
        retval.start = input.LT(1);
        int moduleDependencyBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal54=null;
        Token char_literal55=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal54_tree=null;
        Object char_literal55_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:331:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:331:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal54=(Token)match(input,24,FOLLOW_24_in_moduleDependencyBody908); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal54_tree = (Object)adaptor.create(char_literal54);
            adaptor.addChild(root_0, char_literal54_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:331:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==Identifier) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:331:9: decls= commaSeparatedBodyDecls[Interface.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody913);
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

            char_literal55=(Token)match(input,25,FOLLOW_25_in_moduleDependencyBody921); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:1: moduleRequireDependencyDeclaration[Module element] : 'require' rd= moduleDependencyBody ;
    public final MstageParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration(Module element) throws RecognitionException {
        MstageParser.moduleRequireDependencyDeclaration_return retval = new MstageParser.moduleRequireDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleRequireDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal56=null;
        MstageParser.moduleDependencyBody_return rd = null;


        Object string_literal56_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:336:2: ( 'require' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:336:4: 'require' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal56=(Token)match(input,42,FOLLOW_42_in_moduleRequireDependencyDeclaration936); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal56_tree = (Object)adaptor.create(string_literal56);
            adaptor.addChild(root_0, string_literal56_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration940);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:344:1: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
    public final MstageParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration(Module element) throws RecognitionException {
        MstageParser.moduleProvideDependencyDeclaration_return retval = new MstageParser.moduleProvideDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleProvideDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal57=null;
        MstageParser.moduleDependencyBody_return rd = null;


        Object string_literal57_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:345:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:345:4: 'provide' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal57=(Token)match(input,43,FOLLOW_43_in_moduleProvideDependencyDeclaration955); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal57_tree = (Object)adaptor.create(string_literal57);
            adaptor.addChild(root_0, string_literal57_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration959);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:360:1: compositeDeclaration returns [Composite element] : cmkw= 'composite' name= Identifier compositeBody[$element] ;
    public final MstageParser.compositeDeclaration_return compositeDeclaration() throws RecognitionException {
        MstageParser.compositeDeclaration_return retval = new MstageParser.compositeDeclaration_return();
        retval.start = input.LT(1);
        int compositeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token cmkw=null;
        Token name=null;
        MstageParser.compositeBody_return compositeBody58 = null;


        Object cmkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:361:2: (cmkw= 'composite' name= Identifier compositeBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:361:4: cmkw= 'composite' name= Identifier compositeBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            cmkw=(Token)match(input,44,FOLLOW_44_in_compositeDeclaration988); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            cmkw_tree = (Object)adaptor.create(cmkw);
            adaptor.addChild(root_0, cmkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_compositeDeclaration992); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.element = new Composite(new SimpleNameSignature((name!=null?name.getText():null)));
                  			setKeyword(retval.element,cmkw);
                  			setLocation(retval.element,name,"__NAME");
              			
            }
            pushFollow(FOLLOW_compositeBody_in_compositeDeclaration998);
            compositeBody58=compositeBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, compositeBody58.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:370:1: compositeBody[Composite element] : '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}' ;
    public final MstageParser.compositeBody_return compositeBody(Composite element) throws RecognitionException {
        MstageParser.compositeBody_return retval = new MstageParser.compositeBody_return();
        retval.start = input.LT(1);
        int compositeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal59=null;
        Token char_literal62=null;
        MstageParser.compositeBodyDeclaration_return compositeBodyDeclaration60 = null;

        MstageParser.componentBodyDeclaration_return componentBodyDeclaration61 = null;


        Object char_literal59_tree=null;
        Object char_literal62_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:2: ( '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:4: '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal59=(Token)match(input,24,FOLLOW_24_in_compositeBody1012); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal59_tree = (Object)adaptor.create(char_literal59);
            adaptor.addChild(root_0, char_literal59_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:8: ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==48) ) {
                    alt17=1;
                }
                else if ( ((LA17_0>=42 && LA17_0<=43)) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:9: compositeBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_compositeBodyDeclaration_in_compositeBody1015);
            	    compositeBodyDeclaration60=compositeBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compositeBodyDeclaration60.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:46: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_compositeBody1020);
            	    componentBodyDeclaration61=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration61.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            char_literal62=(Token)match(input,25,FOLLOW_25_in_compositeBody1025); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal62_tree = (Object)adaptor.create(char_literal62);
            adaptor.addChild(root_0, char_literal62_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:1: compositeBodyDeclaration[Composite element] : modulecontainerDeclaration[$element] ;
    public final MstageParser.compositeBodyDeclaration_return compositeBodyDeclaration(Composite element) throws RecognitionException {
        MstageParser.compositeBodyDeclaration_return retval = new MstageParser.compositeBodyDeclaration_return();
        retval.start = input.LT(1);
        int compositeBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.modulecontainerDeclaration_return modulecontainerDeclaration63 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:376:2: ( modulecontainerDeclaration[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:376:4: modulecontainerDeclaration[$element]
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_modulecontainerDeclaration_in_compositeBodyDeclaration1038);
            modulecontainerDeclaration63=modulecontainerDeclaration(element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, modulecontainerDeclaration63.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:386:1: applicationDeclaration returns [Application element] : appkw= 'application' name= Identifier applicationBody[$element] ;
    public final MstageParser.applicationDeclaration_return applicationDeclaration() throws RecognitionException {
        MstageParser.applicationDeclaration_return retval = new MstageParser.applicationDeclaration_return();
        retval.start = input.LT(1);
        int applicationDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token appkw=null;
        Token name=null;
        MstageParser.applicationBody_return applicationBody64 = null;


        Object appkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:387:2: (appkw= 'application' name= Identifier applicationBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:387:4: appkw= 'application' name= Identifier applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            appkw=(Token)match(input,45,FOLLOW_45_in_applicationDeclaration1062); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_applicationDeclaration1066); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.element = new Application(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,appkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_applicationBody_in_applicationDeclaration1070);
            applicationBody64=applicationBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBody64.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:394:1: applicationBody[Application element] : '{' ( applicationBodyDeclaration[$element] )* '}' ;
    public final MstageParser.applicationBody_return applicationBody(Application element) throws RecognitionException {
        MstageParser.applicationBody_return retval = new MstageParser.applicationBody_return();
        retval.start = input.LT(1);
        int applicationBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal65=null;
        Token char_literal67=null;
        MstageParser.applicationBodyDeclaration_return applicationBodyDeclaration66 = null;


        Object char_literal65_tree=null;
        Object char_literal67_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:395:2: ( '{' ( applicationBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:395:4: '{' ( applicationBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal65=(Token)match(input,24,FOLLOW_24_in_applicationBody1083); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = (Object)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:395:8: ( applicationBodyDeclaration[$element] )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==46||LA18_0==48) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: applicationBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_applicationBodyDeclaration_in_applicationBody1085);
            	    applicationBodyDeclaration66=applicationBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBodyDeclaration66.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            char_literal67=(Token)match(input,25,FOLLOW_25_in_applicationBody1089); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal67_tree = (Object)adaptor.create(char_literal67);
            adaptor.addChild(root_0, char_literal67_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:399:1: applicationBodyDeclaration[Application element] : ( modulecontainerDeclaration[$element] | locateDeclaration[$element] );
    public final MstageParser.applicationBodyDeclaration_return applicationBodyDeclaration(Application element) throws RecognitionException {
        MstageParser.applicationBodyDeclaration_return retval = new MstageParser.applicationBodyDeclaration_return();
        retval.start = input.LT(1);
        int applicationBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.modulecontainerDeclaration_return modulecontainerDeclaration68 = null;

        MstageParser.locateDeclaration_return locateDeclaration69 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:400:2: ( modulecontainerDeclaration[$element] | locateDeclaration[$element] )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==48) ) {
                alt19=1;
            }
            else if ( (LA19_0==46) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:400:4: modulecontainerDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_modulecontainerDeclaration_in_applicationBodyDeclaration1102);
                    modulecontainerDeclaration68=modulecontainerDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modulecontainerDeclaration68.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:401:4: locateDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_locateDeclaration_in_applicationBodyDeclaration1108);
                    locateDeclaration69=locateDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, locateDeclaration69.getTree());

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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:405:1: locateDeclaration[Application element] : lockw= 'locate' mappingDeclaration[$element, Module.class, AbstractHost.class] ;
    public final MstageParser.locateDeclaration_return locateDeclaration(Application element) throws RecognitionException {
        MstageParser.locateDeclaration_return retval = new MstageParser.locateDeclaration_return();
        retval.start = input.LT(1);
        int locateDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token lockw=null;
        MstageParser.mappingDeclaration_return mappingDeclaration70 = null;


        Object lockw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:406:2: (lockw= 'locate' mappingDeclaration[$element, Module.class, AbstractHost.class] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:406:4: lockw= 'locate' mappingDeclaration[$element, Module.class, AbstractHost.class]
            {
            root_0 = (Object)adaptor.nil();

            lockw=(Token)match(input,46,FOLLOW_46_in_locateDeclaration1126); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            lockw_tree = (Object)adaptor.create(lockw);
            adaptor.addChild(root_0, lockw_tree);
            }
            pushFollow(FOLLOW_mappingDeclaration_in_locateDeclaration1128);
            mappingDeclaration70=mappingDeclaration(element, Module.class, AbstractHost.class);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mappingDeclaration70.getTree());
            if ( state.backtracking==0 ) {

              			setKeyword(element,lockw);
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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

    public static class mappingDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mappingDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:412:1: mappingDeclaration[HostMapper element, Class<? extends MStageDeclaration> fromType, Class<? extends Host> toType] : name= Identifier rfroms= mappingDeclarationBody[fromType] ;
    public final MstageParser.mappingDeclaration_return mappingDeclaration(HostMapper element, Class<? extends MStageDeclaration> fromType, Class<? extends Host> toType) throws RecognitionException {
        MstageParser.mappingDeclaration_return retval = new MstageParser.mappingDeclaration_return();
        retval.start = input.LT(1);
        int mappingDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        MstageParser.mappingDeclarationBody_return rfroms = null;


        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:413:2: (name= Identifier rfroms= mappingDeclarationBody[fromType] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:413:4: name= Identifier rfroms= mappingDeclarationBody[fromType]
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_mappingDeclaration1146); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_mappingDeclarationBody_in_mappingDeclaration1150);
            rfroms=mappingDeclarationBody(fromType);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rfroms.getTree());
            if ( state.backtracking==0 ) {


              				// create the abstracthost, as it is declared and defined here
              				Host host = null;
              				try {
              					host = toType.newInstance();
              					host.setSignature(new SimpleNameSignature((name!=null?name.getText():null)));
              				} catch (Exception e) {
              					e.printStackTrace();
              				}
              				setLocation(host,name,"__NAME");
              				
              				// add it to HostMapper
              				element.addHost(host);
              				
              				SimpleReference<Host> to = new SimpleReference((name!=null?name.getText():null),toType);
              				System.out.println(name + " -- " + toType);
              				
              		        for(SimpleReference<Module> from : (rfroms!=null?rfroms.elements:null)) {
              		        
              			        HostMapping mapping = null;
              					mapping = element.createEmptyMapping();
              					
              					mapping.setFrom(from);
              					mapping.setTo(to);
              			
              					element.addHostMapping(mapping);
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
            if ( state.backtracking>0 ) { memoize(input, 39, mappingDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:445:1: mappingDeclarationBody[Class fromType] returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[fromType] )? '}' ;
    public final MstageParser.mappingDeclarationBody_return mappingDeclarationBody(Class fromType) throws RecognitionException {
        MstageParser.mappingDeclarationBody_return retval = new MstageParser.mappingDeclarationBody_return();
        retval.start = input.LT(1);
        int mappingDeclarationBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal71=null;
        Token char_literal72=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal71_tree=null;
        Object char_literal72_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:447:2: ( '{' (decls= commaSeparatedBodyDecls[fromType] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:447:4: '{' (decls= commaSeparatedBodyDecls[fromType] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal71=(Token)match(input,24,FOLLOW_24_in_mappingDeclarationBody1170); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal71_tree = (Object)adaptor.create(char_literal71);
            adaptor.addChild(root_0, char_literal71_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:447:8: (decls= commaSeparatedBodyDecls[fromType] )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==Identifier) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:447:10: decls= commaSeparatedBodyDecls[fromType]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_mappingDeclarationBody1178);
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

            char_literal72=(Token)match(input,25,FOLLOW_25_in_mappingDeclarationBody1186); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 40, mappingDeclarationBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "mappingDeclarationBody"

    public static class deploymentDeclaration_return extends ParserRuleReturnScope {
        public Deployment element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deploymentDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:469:1: deploymentDeclaration returns [Deployment element] : depkw= 'deployment' name= Identifier ;
    public final MstageParser.deploymentDeclaration_return deploymentDeclaration() throws RecognitionException {
        MstageParser.deploymentDeclaration_return retval = new MstageParser.deploymentDeclaration_return();
        retval.start = input.LT(1);
        int deploymentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token depkw=null;
        Token name=null;

        Object depkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:470:2: (depkw= 'deployment' name= Identifier )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:470:4: depkw= 'deployment' name= Identifier
            {
            root_0 = (Object)adaptor.nil();

            depkw=(Token)match(input,47,FOLLOW_47_in_deploymentDeclaration1213); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            depkw_tree = (Object)adaptor.create(depkw);
            adaptor.addChild(root_0, depkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_deploymentDeclaration1217); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.element = new Deployment(new SimpleNameSignature((name!=null?name.getText():null))); 
              			setKeyword(retval.element,depkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, deploymentDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "deploymentDeclaration"

    public static class modulecontainerDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modulecontainerDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:483:1: modulecontainerDeclaration[ModuleContainer element] : ctkw= 'contain' conts= modulecontainerBody ;
    public final MstageParser.modulecontainerDeclaration_return modulecontainerDeclaration(ModuleContainer element) throws RecognitionException {
        MstageParser.modulecontainerDeclaration_return retval = new MstageParser.modulecontainerDeclaration_return();
        retval.start = input.LT(1);
        int modulecontainerDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token ctkw=null;
        MstageParser.modulecontainerBody_return conts = null;


        Object ctkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:484:2: (ctkw= 'contain' conts= modulecontainerBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:484:4: ctkw= 'contain' conts= modulecontainerBody
            {
            root_0 = (Object)adaptor.nil();

            ctkw=(Token)match(input,48,FOLLOW_48_in_modulecontainerDeclaration1238); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ctkw_tree = (Object)adaptor.create(ctkw);
            adaptor.addChild(root_0, ctkw_tree);
            }
            pushFollow(FOLLOW_modulecontainerBody_in_modulecontainerDeclaration1242);
            conts=modulecontainerBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, conts.getTree());
            if ( state.backtracking==0 ) {


              			for(SimpleReference module : (conts!=null?conts.elements:null)) {
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
            if ( state.backtracking>0 ) { memoize(input, 42, modulecontainerDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:492:1: modulecontainerBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}' ;
    public final MstageParser.modulecontainerBody_return modulecontainerBody() throws RecognitionException {
        MstageParser.modulecontainerBody_return retval = new MstageParser.modulecontainerBody_return();
        retval.start = input.LT(1);
        int modulecontainerBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal73=null;
        Token char_literal74=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal73_tree=null;
        Object char_literal74_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:494:2: ( '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:494:4: '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal73=(Token)match(input,24,FOLLOW_24_in_modulecontainerBody1263); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal73_tree = (Object)adaptor.create(char_literal73);
            adaptor.addChild(root_0, char_literal73_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:494:8: (decls= commaSeparatedBodyDecls[Module.class] )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Identifier) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:494:9: decls= commaSeparatedBodyDecls[Module.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_modulecontainerBody1268);
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

            char_literal74=(Token)match(input,25,FOLLOW_25_in_modulecontainerBody1276); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 43, modulecontainerBody_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:503:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
    public final MstageParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls(Class targetType) throws RecognitionException {
        MstageParser.commaSeparatedBodyDecls_return retval = new MstageParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);
        int commaSeparatedBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token char_literal75=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object id_tree=null;
        Object char_literal75_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:505:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:505:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls1304); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:505:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==29) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:505:19: ',' decls= commaSeparatedBodyDecls[$targetType]
                    {
                    char_literal75=(Token)match(input,29,FOLLOW_29_in_commaSeparatedBodyDecls1307); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal75_tree = (Object)adaptor.create(char_literal75);
                    adaptor.addChild(root_0, char_literal75_tree);
                    }
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1311);
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
            if ( state.backtracking>0 ) { memoize(input, 44, commaSeparatedBodyDecls_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "commaSeparatedBodyDecls"

    public static class adviceType_return extends ParserRuleReturnScope {
        public AdviceType element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceType"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:520:1: adviceType returns [AdviceType element] : ( 'before' | 'after' | 'around' );
    public final MstageParser.adviceType_return adviceType() throws RecognitionException {
        MstageParser.adviceType_return retval = new MstageParser.adviceType_return();
        retval.start = input.LT(1);
        int adviceType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal76=null;
        Token string_literal77=null;
        Token string_literal78=null;

        Object string_literal76_tree=null;
        Object string_literal77_tree=null;
        Object string_literal78_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:521:2: ( 'before' | 'after' | 'around' )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt23=1;
                }
                break;
            case 50:
                {
                alt23=2;
                }
                break;
            case 51:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:521:4: 'before'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal76=(Token)match(input,49,FOLLOW_49_in_adviceType1343); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal76_tree = (Object)adaptor.create(string_literal76);
                    adaptor.addChild(root_0, string_literal76_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = AdviceType.BEFORE;
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:522:4: 'after'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal77=(Token)match(input,50,FOLLOW_50_in_adviceType1350); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal77_tree = (Object)adaptor.create(string_literal77);
                    adaptor.addChild(root_0, string_literal77_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = AdviceType.AFTER;
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:523:4: 'around'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal78=(Token)match(input,51,FOLLOW_51_in_adviceType1357); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal78_tree = (Object)adaptor.create(string_literal78);
                    adaptor.addChild(root_0, string_literal78_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = AdviceType.AROUND;
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
            if ( state.backtracking>0 ) { memoize(input, 45, adviceType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceType"

    public static class joinpointKind_return extends ParserRuleReturnScope {
        public JoinpointKind element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "joinpointKind"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:526:1: joinpointKind returns [JoinpointKind element] : ( 'execution' | 'call' );
    public final MstageParser.joinpointKind_return joinpointKind() throws RecognitionException {
        MstageParser.joinpointKind_return retval = new MstageParser.joinpointKind_return();
        retval.start = input.LT(1);
        int joinpointKind_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal79=null;
        Token string_literal80=null;

        Object string_literal79_tree=null;
        Object string_literal80_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:527:2: ( 'execution' | 'call' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==52) ) {
                alt24=1;
            }
            else if ( (LA24_0==53) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:527:4: 'execution'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal79=(Token)match(input,52,FOLLOW_52_in_joinpointKind1375); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal79_tree = (Object)adaptor.create(string_literal79);
                    adaptor.addChild(root_0, string_literal79_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = JoinpointKind.EXECUTION;
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:528:4: 'call'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal80=(Token)match(input,53,FOLLOW_53_in_joinpointKind1382); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal80_tree = (Object)adaptor.create(string_literal80);
                    adaptor.addChild(root_0, string_literal80_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = JoinpointKind.CALL;
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
            if ( state.backtracking>0 ) { memoize(input, 46, joinpointKind_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "joinpointKind"

    public static class voidType_return extends ParserRuleReturnScope {
        public TypeReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "voidType"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:531:1: voidType returns [TypeReference element] : 'void' ;
    public final MstageParser.voidType_return voidType() throws RecognitionException {
        MstageParser.voidType_return retval = new MstageParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal81=null;

        Object string_literal81_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:533:7: ( 'void' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:533:10: 'void'
            {
            root_0 = (Object)adaptor.nil();

            string_literal81=(Token)match(input,54,FOLLOW_54_in_voidType1408); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal81_tree = (Object)adaptor.create(string_literal81);
            adaptor.addChild(root_0, string_literal81_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element =new BasicTypeReference("void");
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, voidType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "voidType"

    public static class type_return extends ParserRuleReturnScope {
        public TypeReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:537:1: type returns [TypeReference element] : (cd= classOrInterfaceType | pt= primitiveType );
    public final MstageParser.type_return type() throws RecognitionException {
        MstageParser.type_return retval = new MstageParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.classOrInterfaceType_return cd = null;

        MstageParser.primitiveType_return pt = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:539:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Identifier) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=56 && LA25_0<=63)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:539:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceType_in_type1435);
                    cd=classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cd.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = (cd!=null?cd.element:null);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:540:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveType_in_type1444);
                    pt=primitiveType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pt.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element = (pt!=null?pt.element:null);
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
            if ( state.backtracking>0 ) { memoize(input, 48, type_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:544:1: classOrInterfaceType returns [TypeReference element] : name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* ;
    public final MstageParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MstageParser.classOrInterfaceType_return retval = new MstageParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal83=null;
        MstageParser.typeArguments_return typeArguments82 = null;

        MstageParser.typeArguments_return typeArguments84 = null;


        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal83_tree=null;

        NamespaceOrTypeReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:546:2: (name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:546:4: name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType1469); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new BasicTypeReference((name!=null?name.getText():null)); 
              	           target =  new NamespaceOrTypeReference((name!=null?name.getText():null)); 
              	          
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:551:4: ( typeArguments )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==64) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType1488);
                    typeArguments82=typeArguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments82.getTree());

                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:552:10: ( '.' namex= Identifier ( typeArguments )? )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==55) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:552:11: '.' namex= Identifier ( typeArguments )?
            	    {
            	    char_literal83=(Token)match(input,55,FOLLOW_55_in_classOrInterfaceType1502); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal83_tree = (Object)adaptor.create(char_literal83);
            	    adaptor.addChild(root_0, char_literal83_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType1506); if (state.failed) return retval;
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
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:563:11: ( typeArguments )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==64) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType1533);
            	            typeArguments84=typeArguments();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments84.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
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
            if ( state.backtracking>0 ) { memoize(input, 49, classOrInterfaceType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "classOrInterfaceType"

    public static class primitiveType_return extends ParserRuleReturnScope {
        public TypeReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primitiveType"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:567:1: primitiveType returns [TypeReference element] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MstageParser.primitiveType_return primitiveType() throws RecognitionException {
        MstageParser.primitiveType_return retval = new MstageParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal85=null;
        Token string_literal86=null;
        Token string_literal87=null;
        Token string_literal88=null;
        Token string_literal89=null;
        Token string_literal90=null;
        Token string_literal91=null;
        Token string_literal92=null;

        Object string_literal85_tree=null;
        Object string_literal86_tree=null;
        Object string_literal87_tree=null;
        Object string_literal88_tree=null;
        Object string_literal89_tree=null;
        Object string_literal90_tree=null;
        Object string_literal91_tree=null;
        Object string_literal92_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:568:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt29=8;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt29=1;
                }
                break;
            case 57:
                {
                alt29=2;
                }
                break;
            case 58:
                {
                alt29=3;
                }
                break;
            case 59:
                {
                alt29=4;
                }
                break;
            case 60:
                {
                alt29=5;
                }
                break;
            case 61:
                {
                alt29=6;
                }
                break;
            case 62:
                {
                alt29=7;
                }
                break;
            case 63:
                {
                alt29=8;
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:568:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal85=(Token)match(input,56,FOLLOW_56_in_primitiveType1558); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal85_tree = (Object)adaptor.create(string_literal85);
                    adaptor.addChild(root_0, string_literal85_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:569:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal86=(Token)match(input,57,FOLLOW_57_in_primitiveType1570); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal86_tree = (Object)adaptor.create(string_literal86);
                    adaptor.addChild(root_0, string_literal86_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("char");
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:570:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal87=(Token)match(input,58,FOLLOW_58_in_primitiveType1582); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal87_tree = (Object)adaptor.create(string_literal87);
                    adaptor.addChild(root_0, string_literal87_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("byte");
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:571:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal88=(Token)match(input,59,FOLLOW_59_in_primitiveType1594); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal88_tree = (Object)adaptor.create(string_literal88);
                    adaptor.addChild(root_0, string_literal88_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("short");
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:572:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal89=(Token)match(input,60,FOLLOW_60_in_primitiveType1606); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = (Object)adaptor.create(string_literal89);
                    adaptor.addChild(root_0, string_literal89_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("int");
                    }

                    }
                    break;
                case 6 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:573:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal90=(Token)match(input,61,FOLLOW_61_in_primitiveType1618); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = (Object)adaptor.create(string_literal90);
                    adaptor.addChild(root_0, string_literal90_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("long");
                    }

                    }
                    break;
                case 7 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:574:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal91=(Token)match(input,62,FOLLOW_62_in_primitiveType1630); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal91_tree = (Object)adaptor.create(string_literal91);
                    adaptor.addChild(root_0, string_literal91_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("float");
                    }

                    }
                    break;
                case 8 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:575:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal92=(Token)match(input,63,FOLLOW_63_in_primitiveType1642); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (Object)adaptor.create(string_literal92);
                    adaptor.addChild(root_0, string_literal92_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("double");
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
            if ( state.backtracking>0 ) { memoize(input, 50, primitiveType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primitiveType"

    public static class typeArguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArguments"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:580:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final MstageParser.typeArguments_return typeArguments() throws RecognitionException {
        MstageParser.typeArguments_return retval = new MstageParser.typeArguments_return();
        retval.start = input.LT(1);
        int typeArguments_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal93=null;
        Token char_literal95=null;
        Token char_literal97=null;
        MstageParser.typeArgument_return typeArgument94 = null;

        MstageParser.typeArgument_return typeArgument96 = null;


        Object char_literal93_tree=null;
        Object char_literal95_tree=null;
        Object char_literal97_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:581:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:581:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal93=(Token)match(input,64,FOLLOW_64_in_typeArguments1665); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal93_tree = (Object)adaptor.create(char_literal93);
            adaptor.addChild(root_0, char_literal93_tree);
            }
            pushFollow(FOLLOW_typeArgument_in_typeArguments1667);
            typeArgument94=typeArgument();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument94.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:581:26: ( ',' typeArgument )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==29) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:581:28: ',' typeArgument
            	    {
            	    char_literal95=(Token)match(input,29,FOLLOW_29_in_typeArguments1671); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal95_tree = (Object)adaptor.create(char_literal95);
            	    adaptor.addChild(root_0, char_literal95_tree);
            	    }
            	    pushFollow(FOLLOW_typeArgument_in_typeArguments1673);
            	    typeArgument96=typeArgument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument96.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            char_literal97=(Token)match(input,65,FOLLOW_65_in_typeArguments1678); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal97_tree = (Object)adaptor.create(char_literal97);
            adaptor.addChild(root_0, char_literal97_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, typeArguments_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArguments"

    public static class typeArgument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArgument"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:584:1: typeArgument : (t= type | '?' ( ( 'extends' | 'super' ) t= type )? );
    public final MstageParser.typeArgument_return typeArgument() throws RecognitionException {
        MstageParser.typeArgument_return retval = new MstageParser.typeArgument_return();
        retval.start = input.LT(1);
        int typeArgument_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal98=null;
        Token set99=null;
        MstageParser.type_return t = null;


        Object char_literal98_tree=null;
        Object set99_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:585:5: (t= type | '?' ( ( 'extends' | 'super' ) t= type )? )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==Identifier||(LA32_0>=56 && LA32_0<=63)) ) {
                alt32=1;
            }
            else if ( (LA32_0==66) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:585:9: t= type
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_typeArgument1703);
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:585:20: '?' ( ( 'extends' | 'super' ) t= type )?
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal98=(Token)match(input,66,FOLLOW_66_in_typeArgument1709); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal98_tree = (Object)adaptor.create(char_literal98);
                    adaptor.addChild(root_0, char_literal98_tree);
                    }
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:585:25: ( ( 'extends' | 'super' ) t= type )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0>=67 && LA31_0<=68)) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:585:27: ( 'extends' | 'super' ) t= type
                            {
                            set99=(Token)input.LT(1);
                            if ( (input.LA(1)>=67 && input.LA(1)<=68) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set99));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_type_in_typeArgument1724);
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
            if ( state.backtracking>0 ) { memoize(input, 52, typeArgument_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeArgument"

    public static class annotations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotations"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:593:1: annotations : ( annotation )+ ;
    public final MstageParser.annotations_return annotations() throws RecognitionException {
        MstageParser.annotations_return retval = new MstageParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation100 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:594:5: ( ( annotation )+ )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:594:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:594:9: ( annotation )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==69) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations1751);
            	    annotation100=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation100.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
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
            if ( state.backtracking>0 ) { memoize(input, 53, annotations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotations"

    public static class annotation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotation"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:597:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MstageParser.annotation_return annotation() throws RecognitionException {
        MstageParser.annotation_return retval = new MstageParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal101=null;
        Token char_literal103=null;
        Token char_literal106=null;
        MstageParser.annotationName_return annotationName102 = null;

        MstageParser.elementValuePairs_return elementValuePairs104 = null;

        MstageParser.elementValue_return elementValue105 = null;


        Object char_literal101_tree=null;
        Object char_literal103_tree=null;
        Object char_literal106_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:598:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:598:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            char_literal101=(Token)match(input,69,FOLLOW_69_in_annotation1771); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal101_tree = (Object)adaptor.create(char_literal101);
            adaptor.addChild(root_0, char_literal101_tree);
            }
            pushFollow(FOLLOW_annotationName_in_annotation1773);
            annotationName102=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName102.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:598:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==27) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:598:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal103=(Token)match(input,27,FOLLOW_27_in_annotation1777); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal103_tree = (Object)adaptor.create(char_literal103);
                    adaptor.addChild(root_0, char_literal103_tree);
                    }
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:598:34: ( elementValuePairs | elementValue )?
                    int alt34=3;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==Identifier) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==24||LA34_0==69) ) {
                        alt34=2;
                    }
                    switch (alt34) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:598:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation1781);
                            elementValuePairs104=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs104.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:598:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation1785);
                            elementValue105=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue105.getTree());

                            }
                            break;

                    }

                    char_literal106=(Token)match(input,28,FOLLOW_28_in_annotation1790); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal106_tree = (Object)adaptor.create(char_literal106);
                    adaptor.addChild(root_0, char_literal106_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 54, annotation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotation"

    public static class annotationName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationName"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:601:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MstageParser.annotationName_return annotationName() throws RecognitionException {
        MstageParser.annotationName_return retval = new MstageParser.annotationName_return();
        retval.start = input.LT(1);
        int annotationName_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier107=null;
        Token char_literal108=null;
        Token Identifier109=null;

        Object Identifier107_tree=null;
        Object char_literal108_tree=null;
        Object Identifier109_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:602:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:602:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            Identifier107=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName1814); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier107_tree = (Object)adaptor.create(Identifier107);
            adaptor.addChild(root_0, Identifier107_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:602:18: ( '.' Identifier )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==55) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:602:19: '.' Identifier
            	    {
            	    char_literal108=(Token)match(input,55,FOLLOW_55_in_annotationName1817); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal108_tree = (Object)adaptor.create(char_literal108);
            	    adaptor.addChild(root_0, char_literal108_tree);
            	    }
            	    Identifier109=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName1819); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier109_tree = (Object)adaptor.create(Identifier109);
            	    adaptor.addChild(root_0, Identifier109_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop36;
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
            if ( state.backtracking>0 ) { memoize(input, 55, annotationName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationName"

    public static class elementValuePairs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePairs"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:605:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MstageParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MstageParser.elementValuePairs_return retval = new MstageParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal111=null;
        MstageParser.elementValuePair_return elementValuePair110 = null;

        MstageParser.elementValuePair_return elementValuePair112 = null;


        Object char_literal111_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:606:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:606:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs1840);
            elementValuePair110=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair110.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:606:26: ( ',' elementValuePair )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==29) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:606:27: ',' elementValuePair
            	    {
            	    char_literal111=(Token)match(input,29,FOLLOW_29_in_elementValuePairs1843); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal111_tree = (Object)adaptor.create(char_literal111);
            	    adaptor.addChild(root_0, char_literal111_tree);
            	    }
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs1845);
            	    elementValuePair112=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair112.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
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
            if ( state.backtracking>0 ) { memoize(input, 56, elementValuePairs_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePairs"

    public static class elementValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePair"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:609:1: elementValuePair : Identifier '=' elementValue ;
    public final MstageParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MstageParser.elementValuePair_return retval = new MstageParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier113=null;
        Token char_literal114=null;
        MstageParser.elementValue_return elementValue115 = null;


        Object Identifier113_tree=null;
        Object char_literal114_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:610:5: ( Identifier '=' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:610:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();

            Identifier113=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair1866); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier113_tree = (Object)adaptor.create(Identifier113);
            adaptor.addChild(root_0, Identifier113_tree);
            }
            char_literal114=(Token)match(input,70,FOLLOW_70_in_elementValuePair1868); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal114_tree = (Object)adaptor.create(char_literal114);
            adaptor.addChild(root_0, char_literal114_tree);
            }
            pushFollow(FOLLOW_elementValue_in_elementValuePair1870);
            elementValue115=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue115.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, elementValuePair_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePair"

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:613:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MstageParser.elementValue_return elementValue() throws RecognitionException {
        MstageParser.elementValue_return retval = new MstageParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation116 = null;

        MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer117 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:614:5: ( annotation | elementValueArrayInitializer )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==69) ) {
                alt38=1;
            }
            else if ( (LA38_0==24) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:614:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotation_in_elementValue1893);
                    annotation116=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation116.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:615:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue1903);
                    elementValueArrayInitializer117=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer117.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 58, elementValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValue"

    public static class elementValueArrayInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValueArrayInitializer"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:618:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MstageParser.elementValueArrayInitializer_return retval = new MstageParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal118=null;
        Token char_literal120=null;
        Token char_literal122=null;
        Token char_literal123=null;
        MstageParser.elementValue_return elementValue119 = null;

        MstageParser.elementValue_return elementValue121 = null;


        Object char_literal118_tree=null;
        Object char_literal120_tree=null;
        Object char_literal122_tree=null;
        Object char_literal123_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:619:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:619:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal118=(Token)match(input,24,FOLLOW_24_in_elementValueArrayInitializer1926); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal118_tree = (Object)adaptor.create(char_literal118);
            adaptor.addChild(root_0, char_literal118_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:619:13: ( elementValue ( ',' elementValue )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==24||LA40_0==69) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:619:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer1929);
                    elementValue119=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue119.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:619:27: ( ',' elementValue )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==29) ) {
                            int LA39_1 = input.LA(2);

                            if ( (LA39_1==24||LA39_1==69) ) {
                                alt39=1;
                            }


                        }


                        switch (alt39) {
                    	case 1 :
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:619:28: ',' elementValue
                    	    {
                    	    char_literal120=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer1932); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal120_tree = (Object)adaptor.create(char_literal120);
                    	    adaptor.addChild(root_0, char_literal120_tree);
                    	    }
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer1934);
                    	    elementValue121=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue121.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:619:49: ( ',' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==29) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:619:50: ','
                    {
                    char_literal122=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer1941); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal122_tree = (Object)adaptor.create(char_literal122);
                    adaptor.addChild(root_0, char_literal122_tree);
                    }

                    }
                    break;

            }

            char_literal123=(Token)match(input,25,FOLLOW_25_in_elementValueArrayInitializer1945); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal123_tree = (Object)adaptor.create(char_literal123);
            adaptor.addChild(root_0, char_literal123_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, elementValueArrayInitializer_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:622:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MstageParser.annotationTypeDeclaration_return retval = new MstageParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal124=null;
        Token string_literal125=null;
        MstageParser.annotationTypeBody_return annotationTypeBody126 = null;


        Object name_tree=null;
        Object char_literal124_tree=null;
        Object string_literal125_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:623:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:623:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();

            char_literal124=(Token)match(input,69,FOLLOW_69_in_annotationTypeDeclaration1972); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal124_tree = (Object)adaptor.create(char_literal124);
            adaptor.addChild(root_0, char_literal124_tree);
            }
            string_literal125=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration1974); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal125_tree = (Object)adaptor.create(string_literal125);
            adaptor.addChild(root_0, string_literal125_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration1978); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration1980);
            annotationTypeBody126=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody126.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 60, annotationTypeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeDeclaration"

    public static class annotationTypeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:626:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MstageParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MstageParser.annotationTypeBody_return retval = new MstageParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal127=null;
        Token char_literal129=null;
        MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration128 = null;


        Object char_literal127_tree=null;
        Object char_literal129_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:627:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:627:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal127=(Token)match(input,24,FOLLOW_24_in_annotationTypeBody2003); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal127_tree = (Object)adaptor.create(char_literal127);
            adaptor.addChild(root_0, char_literal127_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:627:13: ( annotationTypeElementDeclaration )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==Identifier||(LA42_0>=56 && LA42_0<=63)||LA42_0==69) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:627:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2006);
            	    annotationTypeElementDeclaration128=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration128.getTree());

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            char_literal129=(Token)match(input,25,FOLLOW_25_in_annotationTypeBody2010); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal129_tree = (Object)adaptor.create(char_literal129);
            adaptor.addChild(root_0, char_literal129_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, annotationTypeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeBody"

    public static class annotationTypeElementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:630:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MstageParser.annotationTypeElementDeclaration_return retval = new MstageParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationTypeElementRest_return annotationTypeElementRest130 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:631:5: ( annotationTypeElementRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:631:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2035);
            annotationTypeElementRest130=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest130.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 62, annotationTypeElementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementDeclaration"

    public static class annotationTypeElementRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:634:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MstageParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MstageParser.annotationTypeElementRest_return retval = new MstageParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal133=null;
        Token char_literal135=null;
        MstageParser.type_return type131 = null;

        MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest132 = null;

        MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration134 = null;


        Object char_literal133_tree=null;
        Object char_literal135_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:635:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==Identifier||(LA44_0>=56 && LA44_0<=63)) ) {
                alt44=1;
            }
            else if ( (LA44_0==69) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:635:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2058);
                    type131=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type131.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2060);
                    annotationMethodOrConstantRest132=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest132.getTree());
                    char_literal133=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2062); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal133_tree = (Object)adaptor.create(char_literal133);
                    adaptor.addChild(root_0, char_literal133_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:636:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2072);
                    annotationTypeDeclaration134=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration134.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:636:35: ( ';' )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==26) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: ';'
                            {
                            char_literal135=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2074); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal135_tree = (Object)adaptor.create(char_literal135);
                            adaptor.addChild(root_0, char_literal135_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 63, annotationTypeElementRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementRest"

    public static class annotationMethodOrConstantRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodOrConstantRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:639:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MstageParser.annotationMethodOrConstantRest_return retval = new MstageParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationMethodRest_return annotationMethodRest136 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:640:5: ( annotationMethodRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:640:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2098);
            annotationMethodRest136=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest136.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 64, annotationMethodOrConstantRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodOrConstantRest"

    public static class annotationMethodRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:643:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MstageParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MstageParser.annotationMethodRest_return retval = new MstageParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier137=null;
        Token char_literal138=null;
        Token char_literal139=null;
        MstageParser.defaultValue_return defaultValue140 = null;


        Object Identifier137_tree=null;
        Object char_literal138_tree=null;
        Object char_literal139_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier137=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2121); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier137_tree = (Object)adaptor.create(Identifier137);
            adaptor.addChild(root_0, Identifier137_tree);
            }
            char_literal138=(Token)match(input,27,FOLLOW_27_in_annotationMethodRest2123); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal138_tree = (Object)adaptor.create(char_literal138);
            adaptor.addChild(root_0, char_literal138_tree);
            }
            char_literal139=(Token)match(input,28,FOLLOW_28_in_annotationMethodRest2125); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal139_tree = (Object)adaptor.create(char_literal139);
            adaptor.addChild(root_0, char_literal139_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:644:28: ( defaultValue )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==71) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest2127);
                    defaultValue140=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue140.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 65, annotationMethodRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodRest"

    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:647:1: defaultValue : 'default' elementValue ;
    public final MstageParser.defaultValue_return defaultValue() throws RecognitionException {
        MstageParser.defaultValue_return retval = new MstageParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal141=null;
        MstageParser.elementValue_return elementValue142 = null;


        Object string_literal141_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:648:5: ( 'default' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:648:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();

            string_literal141=(Token)match(input,71,FOLLOW_71_in_defaultValue2155); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal141_tree = (Object)adaptor.create(string_literal141);
            adaptor.addChild(root_0, string_literal141_tree);
            }
            pushFollow(FOLLOW_elementValue_in_defaultValue2157);
            elementValue142=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue142.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 66, defaultValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // $ANTLR start synpred15_Mstage
    public final void synpred15_Mstage_fragment() throws RecognitionException {   
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:245:29: ( . )
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:245:29: .
        {
        matchAny(input); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_Mstage

    // $ANTLR start synpred18_Mstage
    public final void synpred18_Mstage_fragment() throws RecognitionException {   
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:283:27: ( . )
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:283:27: .
        {
        matchAny(input); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_Mstage

    // Delegated rules

    public final boolean synpred15_Mstage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_Mstage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_Mstage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_Mstage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit90 = new BitSet(new long[]{0x0000B20040800002L});
    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit103 = new BitSet(new long[]{0x0000B20040800002L});
    public static final BitSet FOLLOW_compositeDeclaration_in_compilationUnit119 = new BitSet(new long[]{0x0000B20040800002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_compilationUnit132 = new BitSet(new long[]{0x0000B20040800002L});
    public static final BitSet FOLLOW_applicationDeclaration_in_compilationUnit145 = new BitSet(new long[]{0x0000B20040800002L});
    public static final BitSet FOLLOW_deploymentDeclaration_in_compilationUnit158 = new BitSet(new long[]{0x0000B20040800002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration193 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration197 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_interfaceBody217 = new BitSet(new long[]{0xFF40000002000010L});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody219 = new BitSet(new long[]{0xFF40000002000010L});
    public static final BitSet FOLLOW_25_in_interfaceBody223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration240 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceBodyDeclaration241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceDeclaration268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_serviceDeclaration272 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceDeclaration276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_formalParameters347 = new BitSet(new long[]{0xFF40000010000010L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters352 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_formalParameters358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls383 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls387 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_formalParameterDecls390 = new BitSet(new long[]{0xFF40000000000010L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_connectorDeclaration431 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration435 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorBody453 = new BitSet(new long[]{0x0000040082000000L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody456 = new BitSet(new long[]{0x0000040082000000L});
    public static final BitSet FOLLOW_25_in_connectorBody461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_connectorAOCompositionDeclaration498 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorAOCompositionDeclaration502 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorAOCompositionBody524 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody528 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_connectorAOCompositionBody532 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_connectorAOCompositionBody534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_pointcutDeclaration554 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutBody574 = new BitSet(new long[]{0x0000000A02000000L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody576 = new BitSet(new long[]{0x0000000A02000000L});
    public static final BitSet FOLLOW_25_in_pointcutBody580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pointcutKindDeclaration615 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutKindDeclaration617 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_joinpointKind_in_pointcutKindDeclaration621 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutKindDeclaration623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_pointcutSignatureDeclaration638 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutSignatureDeclaration640 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000000FFL});
    public static final BitSet FOLLOW_26_in_pointcutSignatureDeclaration649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_pointcutCallerDeclaration669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_pointcutCalleeDeclaration682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_adviceDeclaration700 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_adviceBody717 = new BitSet(new long[]{0x0000018002000000L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody719 = new BitSet(new long[]{0x0000018002000000L});
    public static final BitSet FOLLOW_25_in_adviceBody723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_adviceServiceDeclaration756 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceServiceDeclaration758 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000000FFL});
    public static final BitSet FOLLOW_26_in_adviceServiceDeclaration767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_adviceTypeDeclaration782 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceTypeDeclaration784 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration788 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceTypeDeclaration790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_componentDeclaration817 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration821 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_componentBody847 = new BitSet(new long[]{0x00000C0082000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody849 = new BitSet(new long[]{0x00000C0082000000L});
    public static final BitSet FOLLOW_25_in_componentBody853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_moduleDependencyBody908 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody913 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_moduleDependencyBody921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_moduleRequireDependencyDeclaration936 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_moduleProvideDependencyDeclaration955 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_compositeDeclaration988 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_compositeDeclaration992 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_compositeBody_in_compositeDeclaration998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_compositeBody1012 = new BitSet(new long[]{0x00010C0082000000L});
    public static final BitSet FOLLOW_compositeBodyDeclaration_in_compositeBody1015 = new BitSet(new long[]{0x00010C0082000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_compositeBody1020 = new BitSet(new long[]{0x00010C0082000000L});
    public static final BitSet FOLLOW_25_in_compositeBody1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modulecontainerDeclaration_in_compositeBodyDeclaration1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_applicationDeclaration1062 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_applicationDeclaration1066 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_applicationBody_in_applicationDeclaration1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_applicationBody1083 = new BitSet(new long[]{0x0001400002000000L});
    public static final BitSet FOLLOW_applicationBodyDeclaration_in_applicationBody1085 = new BitSet(new long[]{0x0001400002000000L});
    public static final BitSet FOLLOW_25_in_applicationBody1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modulecontainerDeclaration_in_applicationBodyDeclaration1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_locateDeclaration_in_applicationBodyDeclaration1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_locateDeclaration1126 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_mappingDeclaration_in_locateDeclaration1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_mappingDeclaration1146 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_mappingDeclarationBody_in_mappingDeclaration1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_mappingDeclarationBody1170 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_mappingDeclarationBody1178 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_mappingDeclarationBody1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_deploymentDeclaration1213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_deploymentDeclaration1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_modulecontainerDeclaration1238 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_modulecontainerBody_in_modulecontainerDeclaration1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_modulecontainerBody1263 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_modulecontainerBody1268 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_modulecontainerBody1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls1304 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_commaSeparatedBodyDecls1307 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_adviceType1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_adviceType1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_adviceType1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_joinpointKind1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_joinpointKind1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_voidType1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType1469 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType1488 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_classOrInterfaceType1502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType1506 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType1533 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_56_in_primitiveType1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_primitiveType1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_primitiveType1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_primitiveType1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_primitiveType1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_primitiveType1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_primitiveType1642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_typeArguments1665 = new BitSet(new long[]{0xFF40000000000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments1667 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_typeArguments1671 = new BitSet(new long[]{0xFF40000000000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments1673 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_typeArguments1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_typeArgument1709 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_set_in_typeArgument1714 = new BitSet(new long[]{0xFF40000000000010L});
    public static final BitSet FOLLOW_type_in_typeArgument1724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations1751 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_annotation1771 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation1773 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_annotation1777 = new BitSet(new long[]{0x0000000011000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation1781 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation1785 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotation1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName1814 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_annotationName1817 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName1819 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs1840 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_elementValuePairs1843 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs1845 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair1866 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_elementValuePair1868 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue1903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_elementValueArrayInitializer1926 = new BitSet(new long[]{0x0000000023000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer1929 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer1932 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer1934 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer1941 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elementValueArrayInitializer1945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_annotationTypeDeclaration1972 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration1974 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration1978 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeBody2003 = new BitSet(new long[]{0xFF40000002000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2006 = new BitSet(new long[]{0xFF40000002000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_25_in_annotationTypeBody2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2058 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2060 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2072 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2121 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_annotationMethodRest2123 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotationMethodRest2125 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_defaultValue2155 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2157 = new BitSet(new long[]{0x0000000000000002L});

}
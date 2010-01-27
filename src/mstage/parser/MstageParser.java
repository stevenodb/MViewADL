// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g 2010-01-27 14:04:01

package mstage.parser;

import mstage.model.application.AbstractHost;
import mstage.model.application.Application;
import mstage.model.application.Locate;
import mstage.model.composition.Advice;
import mstage.model.composition.AOComposition;
import mstage.model.composition.JoinPoint;
import mstage.model.composition.NamedJoinPoint;
import mstage.model.composition.PatternJoinPoint;
import mstage.model.composition.Pointcut;
import mstage.model.composition.PropertyJoinPoint;
import mstage.model.composition.SingleJoinPoint;
import mstage.model.deployment.Deployment;
import mstage.model.deployment.Host;
import mstage.model.deployment.HostMap;
import mstage.model.module.Component;
import mstage.model.module.Composite;
import mstage.model.module.Connector;
import mstage.model.module.Interface;
import mstage.model.module.JoinPointElement;
import mstage.model.module.Module;
import mstage.model.module.Property;
import mstage.model.module.Service;
import mstage.model.namespace.MStageDeclaration;


import chameleon.core.compilationunit.CompilationUnit;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.declaration.Signature;
import chameleon.core.expression.InvocationTarget;
import chameleon.core.type.TypeReference;
import chameleon.core.namespace.NamespaceOrTypeReference;
import chameleon.core.namespacepart.NamespacePart;
import chameleon.core.reference.SimpleReference;
import chameleon.core.variable.FormalParameter;

import chameleon.support.input.ChameleonParser;


import mstage.reuse.Mapping;
import mstage.reuse.HostMapper;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class MstageParser extends ChameleonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "StringLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "';'", "'('", "')'", "','", "'component'", "'{'", "'}'", "'require'", "'provide'", "'void'", "'.'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'@'", "'='", "'default'"
    };
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int OctalLiteral=9;
    public static final int T__23=23;
    public static final int HexDigit=5;
    public static final int T__39=39;
    public static final int Letter=18;
    public static final int T__30=30;
    public static final int EscapeSequence=13;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__34=34;
    public static final int FloatingPointLiteral=12;
    public static final int FloatTypeSuffix=11;
    public static final int T__35=35;
    public static final int Exponent=10;
    public static final int IntegerTypeSuffix=6;
    public static final int T__36=36;
    public static final int Identifier=4;
    public static final int WS=20;
    public static final int CharacterLiteral=14;
    public static final int T__44=44;
    public static final int COMMENT=21;
    public static final int StringLiteral=15;
    public static final int T__33=33;
    public static final int LINE_COMMENT=22;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int JavaIDDigit=19;
    public static final int UnicodeEscape=16;
    public static final int HexLiteral=7;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int DecimalLiteral=8;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int T__26=26;
    public static final int OctalEscape=17;
    public static final int T__25=25;
    public static final int T__41=41;

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
            this.state.ruleMemo = new HashMap[60+1];
             
             
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:82:1: compilationUnit returns [CompilationUnit element] : ( componentDeclaration | interfaceDeclaration );
    public final MstageParser.compilationUnit_return compilationUnit() throws RecognitionException {
        MstageParser.compilationUnit_return retval = new MstageParser.compilationUnit_return();
        retval.start = input.LT(1);
        int compilationUnit_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.componentDeclaration_return componentDeclaration1 = null;

        MstageParser.interfaceDeclaration_return interfaceDeclaration2 = null;



         
        NamespacePart npp = null;
        retval.element = getCompilationUnit();
        npp = new NamespacePart(language().defaultNamespace());
        retval.element.add(npp);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:89:2: ( componentDeclaration | interfaceDeclaration )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==28) ) {
                alt1=1;
            }
            else if ( (LA1_0==23) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:89:4: componentDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_componentDeclaration_in_compilationUnit86);
                    componentDeclaration1=componentDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentDeclaration1.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:90:4: interfaceDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_interfaceDeclaration_in_compilationUnit91);
                    interfaceDeclaration2=interfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, interfaceDeclaration2.getTree());

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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:97:1: interfaceDeclaration returns [Interface element] : 'interface' name= Identifier interfaceBody[$element] ;
    public final MstageParser.interfaceDeclaration_return interfaceDeclaration() throws RecognitionException {
        MstageParser.interfaceDeclaration_return retval = new MstageParser.interfaceDeclaration_return();
        retval.start = input.LT(1);
        int interfaceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token string_literal3=null;
        MstageParser.interfaceBody_return interfaceBody4 = null;


        Object name_tree=null;
        Object string_literal3_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:98:2: ( 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:98:4: 'interface' name= Identifier interfaceBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            string_literal3=(Token)match(input,23,FOLLOW_23_in_interfaceDeclaration110); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal3_tree = (Object)adaptor.create(string_literal3);
            adaptor.addChild(root_0, string_literal3_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration114); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Interface(new SimpleNameSignature((name!=null?name.getText():null)));
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration120);
            interfaceBody4=interfaceBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, interfaceBody4.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:106:1: interfaceBody[Interface element] : (service= interfaceServiceDeclaration ';' )* ;
    public final MstageParser.interfaceBody_return interfaceBody(Interface element) throws RecognitionException {
        MstageParser.interfaceBody_return retval = new MstageParser.interfaceBody_return();
        retval.start = input.LT(1);
        int interfaceBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal5=null;
        MstageParser.interfaceServiceDeclaration_return service = null;


        Object char_literal5_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:107:2: ( (service= interfaceServiceDeclaration ';' )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:107:4: (service= interfaceServiceDeclaration ';' )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:107:4: (service= interfaceServiceDeclaration ';' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||LA2_0==33||(LA2_0>=35 && LA2_0<=42)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:107:5: service= interfaceServiceDeclaration ';'
            	    {
            	    pushFollow(FOLLOW_interfaceServiceDeclaration_in_interfaceBody137);
            	    service=interfaceServiceDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            	    char_literal5=(Token)match(input,24,FOLLOW_24_in_interfaceBody138); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal5_tree = (Object)adaptor.create(char_literal5);
            	    adaptor.addChild(root_0, char_literal5_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

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
            if ( state.backtracking>0 ) { memoize(input, 3, interfaceBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "interfaceBody"

    public static class interfaceServiceDeclaration_return extends ParserRuleReturnScope {
        public Service element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "interfaceServiceDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:112:1: interfaceServiceDeclaration returns [Service element] : rtype= interfaceServiceReturnType name= Identifier params= formalParameters ;
    public final MstageParser.interfaceServiceDeclaration_return interfaceServiceDeclaration() throws RecognitionException {
        MstageParser.interfaceServiceDeclaration_return retval = new MstageParser.interfaceServiceDeclaration_return();
        retval.start = input.LT(1);
        int interfaceServiceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        MstageParser.interfaceServiceReturnType_return rtype = null;

        MstageParser.formalParameters_return params = null;


        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:113:2: (rtype= interfaceServiceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:113:4: rtype= interfaceServiceReturnType name= Identifier params= formalParameters
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_interfaceServiceReturnType_in_interfaceServiceDeclaration159);
            rtype=interfaceServiceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceServiceDeclaration163); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_formalParameters_in_interfaceServiceDeclaration167);
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
            if ( state.backtracking>0 ) { memoize(input, 4, interfaceServiceDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "interfaceServiceDeclaration"

    public static class interfaceServiceReturnType_return extends ParserRuleReturnScope {
        public TypeReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "interfaceServiceReturnType"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:119:1: interfaceServiceReturnType returns [TypeReference element] : (vt= voidType | tp= type );
    public final MstageParser.interfaceServiceReturnType_return interfaceServiceReturnType() throws RecognitionException {
        MstageParser.interfaceServiceReturnType_return retval = new MstageParser.interfaceServiceReturnType_return();
        retval.start = input.LT(1);
        int interfaceServiceReturnType_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.voidType_return vt = null;

        MstageParser.type_return tp = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:120:2: (vt= voidType | tp= type )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==33) ) {
                alt3=1;
            }
            else if ( (LA3_0==Identifier||(LA3_0>=35 && LA3_0<=42)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:120:4: vt= voidType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_voidType_in_interfaceServiceReturnType186);
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:121:4: tp= type
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_interfaceServiceReturnType195);
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
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, interfaceServiceReturnType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "interfaceServiceReturnType"

    public static class formalParameters_return extends ParserRuleReturnScope {
        public List<FormalParameter> element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formalParameters"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:124:1: formalParameters returns [List<FormalParameter> element] : '(' (pars= formalParameterDecls )? ')' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:126:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:126:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal6=(Token)match(input,25,FOLLOW_25_in_formalParameters222); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:126:13: (pars= formalParameterDecls )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Identifier||(LA4_0>=35 && LA4_0<=42)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:126:14: pars= formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters227);
                    pars=formalParameterDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pars.getTree());
                    if ( state.backtracking==0 ) {
                      retval.element =pars.element;
                    }

                    }
                    break;

            }

            char_literal7=(Token)match(input,26,FOLLOW_26_in_formalParameters233); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 6, formalParameters_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:129:1: formalParameterDecls returns [List<FormalParameter> element] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:130:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:130:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_type_in_formalParameterDecls258);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls262); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:130:32: ( ',' decls= formalParameterDecls )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:130:33: ',' decls= formalParameterDecls
                    {
                    char_literal8=(Token)match(input,27,FOLLOW_27_in_formalParameterDecls265); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (Object)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);
                    }
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls269);
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
            if ( state.backtracking>0 ) { memoize(input, 7, formalParameterDecls_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "formalParameterDecls"

    public static class componentDeclaration_return extends ParserRuleReturnScope {
        public Component element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:146:1: componentDeclaration returns [Component element] : 'component' name= Identifier componentBody[$element] ;
    public final MstageParser.componentDeclaration_return componentDeclaration() throws RecognitionException {
        MstageParser.componentDeclaration_return retval = new MstageParser.componentDeclaration_return();
        retval.start = input.LT(1);
        int componentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token string_literal9=null;
        MstageParser.componentBody_return componentBody10 = null;


        Object name_tree=null;
        Object string_literal9_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:147:2: ( 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:147:6: 'component' name= Identifier componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            string_literal9=(Token)match(input,28,FOLLOW_28_in_componentDeclaration301); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal9_tree = (Object)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration305); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                  			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                  			setLocation(retval.element,name,"__NAME");
              			
            }
            pushFollow(FOLLOW_componentBody_in_componentDeclaration309);
            componentBody10=componentBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBody10.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, componentDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentDeclaration"

    public static class componentBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:153:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
    public final MstageParser.componentBody_return componentBody(Component element) throws RecognitionException {
        MstageParser.componentBody_return retval = new MstageParser.componentBody_return();
        retval.start = input.LT(1);
        int componentBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal11=null;
        Token char_literal13=null;
        MstageParser.componentBodyDeclaration_return componentBodyDeclaration12 = null;


        Object char_literal11_tree=null;
        Object char_literal13_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:154:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:154:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal11=(Token)match(input,29,FOLLOW_29_in_componentBody326); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal11_tree = (Object)adaptor.create(char_literal11);
            adaptor.addChild(root_0, char_literal11_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:154:8: ( componentBodyDeclaration[$element] )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=31 && LA6_0<=32)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody328);
            	    componentBodyDeclaration12=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration12.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            char_literal13=(Token)match(input,30,FOLLOW_30_in_componentBody332); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal13_tree = (Object)adaptor.create(char_literal13);
            adaptor.addChild(root_0, char_literal13_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, componentBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentBody"

    public static class componentBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:157:1: componentBodyDeclaration[Component element] : ( 'require' rd= componentInterfaceDependencyBody | 'provide' pd= componentInterfaceDependencyBody );
    public final MstageParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MstageParser.componentBodyDeclaration_return retval = new MstageParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);
        int componentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal14=null;
        Token string_literal15=null;
        MstageParser.componentInterfaceDependencyBody_return rd = null;

        MstageParser.componentInterfaceDependencyBody_return pd = null;


        Object string_literal14_tree=null;
        Object string_literal15_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:158:2: ( 'require' rd= componentInterfaceDependencyBody | 'provide' pd= componentInterfaceDependencyBody )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==31) ) {
                alt7=1;
            }
            else if ( (LA7_0==32) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:158:4: 'require' rd= componentInterfaceDependencyBody
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal14=(Token)match(input,31,FOLLOW_31_in_componentBodyDeclaration348); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal14_tree = (Object)adaptor.create(string_literal14);
                    adaptor.addChild(root_0, string_literal14_tree);
                    }
                    pushFollow(FOLLOW_componentInterfaceDependencyBody_in_componentBodyDeclaration352);
                    rd=componentInterfaceDependencyBody();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rd.getTree());
                    if ( state.backtracking==0 ) {

                      			for(String iface : (rd!=null?rd.interfaces:null) ) {
                      				element.addRequiredInterface(new SimpleReference<Interface>(iface, Interface.class));
                      			}
                      		 
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:163:4: 'provide' pd= componentInterfaceDependencyBody
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal15=(Token)match(input,32,FOLLOW_32_in_componentBodyDeclaration359); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal15_tree = (Object)adaptor.create(string_literal15);
                    adaptor.addChild(root_0, string_literal15_tree);
                    }
                    pushFollow(FOLLOW_componentInterfaceDependencyBody_in_componentBodyDeclaration363);
                    pd=componentInterfaceDependencyBody();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pd.getTree());
                    if ( state.backtracking==0 ) {

                      			for(String iface : (pd!=null?pd.interfaces:null) ) {
                      				element.addProvidedInterface(new SimpleReference<Interface>(iface, Interface.class));
                      			}
                      		 
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
            if ( state.backtracking>0 ) { memoize(input, 10, componentBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentBodyDeclaration"

    public static class componentInterfaceDependencyBody_return extends ParserRuleReturnScope {
        public List<String> interfaces;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentInterfaceDependencyBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:170:1: componentInterfaceDependencyBody returns [List<String> interfaces] : '{' iface= Identifier ( ',' iface= Identifier )* '}' ;
    public final MstageParser.componentInterfaceDependencyBody_return componentInterfaceDependencyBody() throws RecognitionException {
        MstageParser.componentInterfaceDependencyBody_return retval = new MstageParser.componentInterfaceDependencyBody_return();
        retval.start = input.LT(1);
        int componentInterfaceDependencyBody_StartIndex = input.index();
        Object root_0 = null;

        Token iface=null;
        Token char_literal16=null;
        Token char_literal17=null;
        Token char_literal18=null;

        Object iface_tree=null;
        Object char_literal16_tree=null;
        Object char_literal17_tree=null;
        Object char_literal18_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:171:2: ( '{' iface= Identifier ( ',' iface= Identifier )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:171:4: '{' iface= Identifier ( ',' iface= Identifier )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal16=(Token)match(input,29,FOLLOW_29_in_componentInterfaceDependencyBody380); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);
            }
            if ( state.backtracking==0 ) {
               
              				retval.interfaces =new ArrayList<String>(); 
              			
            }
            iface=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentInterfaceDependencyBody386); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            iface_tree = (Object)adaptor.create(iface);
            adaptor.addChild(root_0, iface_tree);
            }
            if ( state.backtracking==0 ) {

              					retval.interfaces.add((iface!=null?iface.getText():null));
              				
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:176:7: ( ',' iface= Identifier )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==27) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:176:8: ',' iface= Identifier
            	    {
            	    char_literal17=(Token)match(input,27,FOLLOW_27_in_componentInterfaceDependencyBody396); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal17_tree = (Object)adaptor.create(char_literal17);
            	    adaptor.addChild(root_0, char_literal17_tree);
            	    }
            	    iface=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentInterfaceDependencyBody400); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    iface_tree = (Object)adaptor.create(iface);
            	    adaptor.addChild(root_0, iface_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      						retval.interfaces.add((iface!=null?iface.getText():null));
            	      					
            	    }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            char_literal18=(Token)match(input,30,FOLLOW_30_in_componentInterfaceDependencyBody414); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal18_tree = (Object)adaptor.create(char_literal18);
            adaptor.addChild(root_0, char_literal18_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, componentInterfaceDependencyBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentInterfaceDependencyBody"

    public static class voidType_return extends ParserRuleReturnScope {
        public TypeReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "voidType"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:222:1: voidType returns [TypeReference element] : 'void' ;
    public final MstageParser.voidType_return voidType() throws RecognitionException {
        MstageParser.voidType_return retval = new MstageParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal19=null;

        Object string_literal19_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:224:7: ( 'void' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:224:10: 'void'
            {
            root_0 = (Object)adaptor.nil();

            string_literal19=(Token)match(input,33,FOLLOW_33_in_voidType442); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal19_tree = (Object)adaptor.create(string_literal19);
            adaptor.addChild(root_0, string_literal19_tree);
            }
            if ( state.backtracking==0 ) {
              retval.element =new TypeReference("void");
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, voidType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:228:1: type returns [TypeReference element] : (cd= classOrInterfaceType | pt= primitiveType );
    public final MstageParser.type_return type() throws RecognitionException {
        MstageParser.type_return retval = new MstageParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.classOrInterfaceType_return cd = null;

        MstageParser.primitiveType_return pt = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:230:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Identifier) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=35 && LA9_0<=42)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:230:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceType_in_type469);
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:231:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveType_in_type478);
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
            if ( state.backtracking>0 ) { memoize(input, 13, type_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:235:1: classOrInterfaceType returns [TypeReference element] : name= Identifier ( '.' namex= Identifier )* ;
    public final MstageParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MstageParser.classOrInterfaceType_return retval = new MstageParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal20=null;

        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal20_tree=null;

        NamespaceOrTypeReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:237:2: (name= Identifier ( '.' namex= Identifier )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:237:4: name= Identifier ( '.' namex= Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType503); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new TypeReference((name!=null?name.getText():null)); 
              	           target =  new NamespaceOrTypeReference((name!=null?name.getText():null)); 
              	          
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:242:10: ( '.' namex= Identifier )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==34) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:242:11: '.' namex= Identifier
            	    {
            	    char_literal20=(Token)match(input,34,FOLLOW_34_in_classOrInterfaceType530); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal20_tree = (Object)adaptor.create(char_literal20);
            	    adaptor.addChild(root_0, char_literal20_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType534); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    namex_tree = (Object)adaptor.create(namex);
            	    adaptor.addChild(root_0, namex_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      	           if(target != null) {
            	      	             retval.element = new TypeReference(target,(namex!=null?namex.getText():null));
            	      	             // We must clone the target here, or else it will be removed from the
            	      	             // type reference we just created.
            	      	             target = new NamespaceOrTypeReference(target.clone(),(namex!=null?namex.getText():null));
            	      	           } else {
            	      	             retval.element = new TypeReference(retval.element,(namex!=null?namex.getText():null));
            	      	           }
            	      	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
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
            if ( state.backtracking>0 ) { memoize(input, 14, classOrInterfaceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:257:1: primitiveType returns [TypeReference element] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MstageParser.primitiveType_return primitiveType() throws RecognitionException {
        MstageParser.primitiveType_return retval = new MstageParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal21=null;
        Token string_literal22=null;
        Token string_literal23=null;
        Token string_literal24=null;
        Token string_literal25=null;
        Token string_literal26=null;
        Token string_literal27=null;
        Token string_literal28=null;

        Object string_literal21_tree=null;
        Object string_literal22_tree=null;
        Object string_literal23_tree=null;
        Object string_literal24_tree=null;
        Object string_literal25_tree=null;
        Object string_literal26_tree=null;
        Object string_literal27_tree=null;
        Object string_literal28_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:258:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt11=8;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt11=1;
                }
                break;
            case 36:
                {
                alt11=2;
                }
                break;
            case 37:
                {
                alt11=3;
                }
                break;
            case 38:
                {
                alt11=4;
                }
                break;
            case 39:
                {
                alt11=5;
                }
                break;
            case 40:
                {
                alt11=6;
                }
                break;
            case 41:
                {
                alt11=7;
                }
                break;
            case 42:
                {
                alt11=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:258:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal21=(Token)match(input,35,FOLLOW_35_in_primitiveType583); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal21_tree = (Object)adaptor.create(string_literal21);
                    adaptor.addChild(root_0, string_literal21_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:259:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal22=(Token)match(input,36,FOLLOW_36_in_primitiveType595); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal22_tree = (Object)adaptor.create(string_literal22);
                    adaptor.addChild(root_0, string_literal22_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("char");
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:260:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal23=(Token)match(input,37,FOLLOW_37_in_primitiveType607); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal23_tree = (Object)adaptor.create(string_literal23);
                    adaptor.addChild(root_0, string_literal23_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("byte");
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:261:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal24=(Token)match(input,38,FOLLOW_38_in_primitiveType619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal24_tree = (Object)adaptor.create(string_literal24);
                    adaptor.addChild(root_0, string_literal24_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("short");
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:262:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal25=(Token)match(input,39,FOLLOW_39_in_primitiveType631); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal25_tree = (Object)adaptor.create(string_literal25);
                    adaptor.addChild(root_0, string_literal25_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("int");
                    }

                    }
                    break;
                case 6 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:263:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal26=(Token)match(input,40,FOLLOW_40_in_primitiveType643); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal26_tree = (Object)adaptor.create(string_literal26);
                    adaptor.addChild(root_0, string_literal26_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("long");
                    }

                    }
                    break;
                case 7 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:264:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal27=(Token)match(input,41,FOLLOW_41_in_primitiveType655); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal27_tree = (Object)adaptor.create(string_literal27);
                    adaptor.addChild(root_0, string_literal27_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("float");
                    }

                    }
                    break;
                case 8 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:265:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal28=(Token)match(input,42,FOLLOW_42_in_primitiveType667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal28_tree = (Object)adaptor.create(string_literal28);
                    adaptor.addChild(root_0, string_literal28_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("double");
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
            if ( state.backtracking>0 ) { memoize(input, 15, primitiveType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primitiveType"

    public static class annotations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotations"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:271:1: annotations : ( annotation )+ ;
    public final MstageParser.annotations_return annotations() throws RecognitionException {
        MstageParser.annotations_return retval = new MstageParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation29 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:272:5: ( ( annotation )+ )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:272:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:272:9: ( annotation )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==43) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations691);
            	    annotation29=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation29.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
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
            if ( state.backtracking>0 ) { memoize(input, 16, annotations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotations"

    public static class annotation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotation"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:275:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MstageParser.annotation_return annotation() throws RecognitionException {
        MstageParser.annotation_return retval = new MstageParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal30=null;
        Token char_literal32=null;
        Token char_literal35=null;
        MstageParser.annotationName_return annotationName31 = null;

        MstageParser.elementValuePairs_return elementValuePairs33 = null;

        MstageParser.elementValue_return elementValue34 = null;


        Object char_literal30_tree=null;
        Object char_literal32_tree=null;
        Object char_literal35_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:276:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:276:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            char_literal30=(Token)match(input,43,FOLLOW_43_in_annotation711); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal30_tree = (Object)adaptor.create(char_literal30);
            adaptor.addChild(root_0, char_literal30_tree);
            }
            pushFollow(FOLLOW_annotationName_in_annotation713);
            annotationName31=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName31.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:276:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:276:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal32=(Token)match(input,25,FOLLOW_25_in_annotation717); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (Object)adaptor.create(char_literal32);
                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:276:34: ( elementValuePairs | elementValue )?
                    int alt13=3;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==Identifier) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==29||LA13_0==43) ) {
                        alt13=2;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:276:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation721);
                            elementValuePairs33=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs33.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:276:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation725);
                            elementValue34=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue34.getTree());

                            }
                            break;

                    }

                    char_literal35=(Token)match(input,26,FOLLOW_26_in_annotation730); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (Object)adaptor.create(char_literal35);
                    adaptor.addChild(root_0, char_literal35_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 17, annotation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotation"

    public static class annotationName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationName"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:279:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MstageParser.annotationName_return annotationName() throws RecognitionException {
        MstageParser.annotationName_return retval = new MstageParser.annotationName_return();
        retval.start = input.LT(1);
        int annotationName_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier36=null;
        Token char_literal37=null;
        Token Identifier38=null;

        Object Identifier36_tree=null;
        Object char_literal37_tree=null;
        Object Identifier38_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:280:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:280:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            Identifier36=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName754); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier36_tree = (Object)adaptor.create(Identifier36);
            adaptor.addChild(root_0, Identifier36_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:280:18: ( '.' Identifier )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==34) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:280:19: '.' Identifier
            	    {
            	    char_literal37=(Token)match(input,34,FOLLOW_34_in_annotationName757); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal37_tree = (Object)adaptor.create(char_literal37);
            	    adaptor.addChild(root_0, char_literal37_tree);
            	    }
            	    Identifier38=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName759); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier38_tree = (Object)adaptor.create(Identifier38);
            	    adaptor.addChild(root_0, Identifier38_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop15;
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
            if ( state.backtracking>0 ) { memoize(input, 18, annotationName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationName"

    public static class elementValuePairs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePairs"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:283:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MstageParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MstageParser.elementValuePairs_return retval = new MstageParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal40=null;
        MstageParser.elementValuePair_return elementValuePair39 = null;

        MstageParser.elementValuePair_return elementValuePair41 = null;


        Object char_literal40_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:284:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:284:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs780);
            elementValuePair39=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair39.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:284:26: ( ',' elementValuePair )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==27) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:284:27: ',' elementValuePair
            	    {
            	    char_literal40=(Token)match(input,27,FOLLOW_27_in_elementValuePairs783); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal40_tree = (Object)adaptor.create(char_literal40);
            	    adaptor.addChild(root_0, char_literal40_tree);
            	    }
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs785);
            	    elementValuePair41=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair41.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
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
            if ( state.backtracking>0 ) { memoize(input, 19, elementValuePairs_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePairs"

    public static class elementValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePair"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:287:1: elementValuePair : Identifier '=' elementValue ;
    public final MstageParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MstageParser.elementValuePair_return retval = new MstageParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier42=null;
        Token char_literal43=null;
        MstageParser.elementValue_return elementValue44 = null;


        Object Identifier42_tree=null;
        Object char_literal43_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:288:5: ( Identifier '=' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:288:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();

            Identifier42=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair806); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier42_tree = (Object)adaptor.create(Identifier42);
            adaptor.addChild(root_0, Identifier42_tree);
            }
            char_literal43=(Token)match(input,44,FOLLOW_44_in_elementValuePair808); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal43_tree = (Object)adaptor.create(char_literal43);
            adaptor.addChild(root_0, char_literal43_tree);
            }
            pushFollow(FOLLOW_elementValue_in_elementValuePair810);
            elementValue44=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue44.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, elementValuePair_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePair"

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:291:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MstageParser.elementValue_return elementValue() throws RecognitionException {
        MstageParser.elementValue_return retval = new MstageParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation45 = null;

        MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer46 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:292:5: ( annotation | elementValueArrayInitializer )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==43) ) {
                alt17=1;
            }
            else if ( (LA17_0==29) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:292:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotation_in_elementValue833);
                    annotation45=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation45.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:293:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue843);
                    elementValueArrayInitializer46=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer46.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 21, elementValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValue"

    public static class elementValueArrayInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValueArrayInitializer"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:296:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MstageParser.elementValueArrayInitializer_return retval = new MstageParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal47=null;
        Token char_literal49=null;
        Token char_literal51=null;
        Token char_literal52=null;
        MstageParser.elementValue_return elementValue48 = null;

        MstageParser.elementValue_return elementValue50 = null;


        Object char_literal47_tree=null;
        Object char_literal49_tree=null;
        Object char_literal51_tree=null;
        Object char_literal52_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:297:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:297:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal47=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer866); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal47_tree = (Object)adaptor.create(char_literal47);
            adaptor.addChild(root_0, char_literal47_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:297:13: ( elementValue ( ',' elementValue )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==29||LA19_0==43) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:297:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer869);
                    elementValue48=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue48.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:297:27: ( ',' elementValue )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==27) ) {
                            int LA18_1 = input.LA(2);

                            if ( (LA18_1==29||LA18_1==43) ) {
                                alt18=1;
                            }


                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:297:28: ',' elementValue
                    	    {
                    	    char_literal49=(Token)match(input,27,FOLLOW_27_in_elementValueArrayInitializer872); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    	    adaptor.addChild(root_0, char_literal49_tree);
                    	    }
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer874);
                    	    elementValue50=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue50.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:297:49: ( ',' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:297:50: ','
                    {
                    char_literal51=(Token)match(input,27,FOLLOW_27_in_elementValueArrayInitializer881); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal51_tree = (Object)adaptor.create(char_literal51);
                    adaptor.addChild(root_0, char_literal51_tree);
                    }

                    }
                    break;

            }

            char_literal52=(Token)match(input,30,FOLLOW_30_in_elementValueArrayInitializer885); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 22, elementValueArrayInitializer_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:300:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MstageParser.annotationTypeDeclaration_return retval = new MstageParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal53=null;
        Token string_literal54=null;
        MstageParser.annotationTypeBody_return annotationTypeBody55 = null;


        Object name_tree=null;
        Object char_literal53_tree=null;
        Object string_literal54_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:301:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:301:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();

            char_literal53=(Token)match(input,43,FOLLOW_43_in_annotationTypeDeclaration912); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal53_tree = (Object)adaptor.create(char_literal53);
            adaptor.addChild(root_0, char_literal53_tree);
            }
            string_literal54=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration914); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal54_tree = (Object)adaptor.create(string_literal54);
            adaptor.addChild(root_0, string_literal54_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration918); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration920);
            annotationTypeBody55=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody55.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, annotationTypeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeDeclaration"

    public static class annotationTypeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:304:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MstageParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MstageParser.annotationTypeBody_return retval = new MstageParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal56=null;
        Token char_literal58=null;
        MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration57 = null;


        Object char_literal56_tree=null;
        Object char_literal58_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:305:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:305:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal56=(Token)match(input,29,FOLLOW_29_in_annotationTypeBody943); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal56_tree = (Object)adaptor.create(char_literal56);
            adaptor.addChild(root_0, char_literal56_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:305:13: ( annotationTypeElementDeclaration )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Identifier||(LA21_0>=35 && LA21_0<=43)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:305:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody946);
            	    annotationTypeElementDeclaration57=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration57.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            char_literal58=(Token)match(input,30,FOLLOW_30_in_annotationTypeBody950); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 24, annotationTypeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeBody"

    public static class annotationTypeElementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:308:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MstageParser.annotationTypeElementDeclaration_return retval = new MstageParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationTypeElementRest_return annotationTypeElementRest59 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:309:5: ( annotationTypeElementRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:309:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration975);
            annotationTypeElementRest59=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest59.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, annotationTypeElementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementDeclaration"

    public static class annotationTypeElementRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:312:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MstageParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MstageParser.annotationTypeElementRest_return retval = new MstageParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal62=null;
        Token char_literal64=null;
        MstageParser.type_return type60 = null;

        MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest61 = null;

        MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration63 = null;


        Object char_literal62_tree=null;
        Object char_literal64_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:313:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Identifier||(LA23_0>=35 && LA23_0<=42)) ) {
                alt23=1;
            }
            else if ( (LA23_0==43) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:313:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_annotationTypeElementRest998);
                    type60=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type60.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest1000);
                    annotationMethodOrConstantRest61=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest61.getTree());
                    char_literal62=(Token)match(input,24,FOLLOW_24_in_annotationTypeElementRest1002); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal62_tree = (Object)adaptor.create(char_literal62);
                    adaptor.addChild(root_0, char_literal62_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:314:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest1012);
                    annotationTypeDeclaration63=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration63.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:314:35: ( ';' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==24) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: ';'
                            {
                            char_literal64=(Token)match(input,24,FOLLOW_24_in_annotationTypeElementRest1014); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal64_tree = (Object)adaptor.create(char_literal64);
                            adaptor.addChild(root_0, char_literal64_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 26, annotationTypeElementRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementRest"

    public static class annotationMethodOrConstantRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodOrConstantRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:317:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MstageParser.annotationMethodOrConstantRest_return retval = new MstageParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationMethodRest_return annotationMethodRest65 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:318:5: ( annotationMethodRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:318:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest1038);
            annotationMethodRest65=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest65.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, annotationMethodOrConstantRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodOrConstantRest"

    public static class annotationMethodRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:321:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MstageParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MstageParser.annotationMethodRest_return retval = new MstageParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier66=null;
        Token char_literal67=null;
        Token char_literal68=null;
        MstageParser.defaultValue_return defaultValue69 = null;


        Object Identifier66_tree=null;
        Object char_literal67_tree=null;
        Object char_literal68_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:322:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:322:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier66=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest1061); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier66_tree = (Object)adaptor.create(Identifier66);
            adaptor.addChild(root_0, Identifier66_tree);
            }
            char_literal67=(Token)match(input,25,FOLLOW_25_in_annotationMethodRest1063); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal67_tree = (Object)adaptor.create(char_literal67);
            adaptor.addChild(root_0, char_literal67_tree);
            }
            char_literal68=(Token)match(input,26,FOLLOW_26_in_annotationMethodRest1065); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal68_tree = (Object)adaptor.create(char_literal68);
            adaptor.addChild(root_0, char_literal68_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:322:28: ( defaultValue )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==45) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest1067);
                    defaultValue69=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue69.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 28, annotationMethodRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodRest"

    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:325:1: defaultValue : 'default' elementValue ;
    public final MstageParser.defaultValue_return defaultValue() throws RecognitionException {
        MstageParser.defaultValue_return retval = new MstageParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal70=null;
        MstageParser.elementValue_return elementValue71 = null;


        Object string_literal70_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:326:5: ( 'default' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:326:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();

            string_literal70=(Token)match(input,45,FOLLOW_45_in_defaultValue1095); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal70_tree = (Object)adaptor.create(string_literal70);
            adaptor.addChild(root_0, string_literal70_tree);
            }
            pushFollow(FOLLOW_elementValue_in_defaultValue1097);
            elementValue71=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue71.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, defaultValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration114 = new BitSet(new long[]{0x000007FA00000010L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceServiceDeclaration_in_interfaceBody137 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_interfaceBody138 = new BitSet(new long[]{0x000007FA00000012L});
    public static final BitSet FOLLOW_interfaceServiceReturnType_in_interfaceServiceDeclaration159 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceServiceDeclaration163 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_formalParameters_in_interfaceServiceDeclaration167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_interfaceServiceReturnType186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_interfaceServiceReturnType195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_formalParameters222 = new BitSet(new long[]{0x000007FA04000010L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters227 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_formalParameters233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls262 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_formalParameterDecls265 = new BitSet(new long[]{0x000007FA00000010L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_componentDeclaration301 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration305 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_componentBody326 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody328 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_30_in_componentBody332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_componentBodyDeclaration348 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_componentInterfaceDependencyBody_in_componentBodyDeclaration352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_componentBodyDeclaration359 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_componentInterfaceDependencyBody_in_componentBodyDeclaration363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_componentInterfaceDependencyBody380 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentInterfaceDependencyBody386 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_27_in_componentInterfaceDependencyBody396 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentInterfaceDependencyBody400 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_30_in_componentInterfaceDependencyBody414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_voidType442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType503 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_classOrInterfaceType530 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType534 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_35_in_primitiveType583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_primitiveType595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_primitiveType607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_primitiveType619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_primitiveType631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_primitiveType643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_primitiveType655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_primitiveType667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations691 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_annotation711 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation713 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_annotation717 = new BitSet(new long[]{0x0000080024000010L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation721 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation725 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotation730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName754 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_annotationName757 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName759 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs780 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_elementValuePairs783 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs785 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair806 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_elementValuePair808 = new BitSet(new long[]{0x0000080020000000L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer866 = new BitSet(new long[]{0x0000080068000000L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer869 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_27_in_elementValueArrayInitializer872 = new BitSet(new long[]{0x0000080020000000L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer874 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_27_in_elementValueArrayInitializer881 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_elementValueArrayInitializer885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_annotationTypeDeclaration912 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration914 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration918 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_annotationTypeBody943 = new BitSet(new long[]{0x00000FFA40000010L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody946 = new BitSet(new long[]{0x00000FFA40000010L});
    public static final BitSet FOLLOW_30_in_annotationTypeBody950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest998 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest1000 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_annotationTypeElementRest1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest1012 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeElementRest1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest1061 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_annotationMethodRest1063 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationMethodRest1065 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_defaultValue1095 = new BitSet(new long[]{0x0000080020000000L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue1097 = new BitSet(new long[]{0x0000000000000002L});

}
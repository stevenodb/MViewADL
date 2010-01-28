// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g 2010-01-28 14:11:45

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
import chameleon.core.type.Type;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "StringLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "';'", "'('", "')'", "','", "'connector'", "'composite'", "'{'", "'}'", "'contain'", "'component'", "'require'", "'provide'", "'void'", "'.'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'@'", "'='", "'default'"
    };
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int OctalLiteral=9;
    public static final int T__23=23;
    public static final int HexDigit=5;
    public static final int T__47=47;
    public static final int T__39=39;
    public static final int Letter=18;
    public static final int T__30=30;
    public static final int T__46=46;
    public static final int EscapeSequence=13;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__48=48;
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
            this.state.ruleMemo = new HashMap[70+1];
             
             
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:83:1: compilationUnit returns [CompilationUnit element] : ( componentDeclaration | interfaceDeclaration );
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:90:2: ( componentDeclaration | interfaceDeclaration )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==33) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:90:4: componentDeclaration
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:91:4: interfaceDeclaration
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:98:1: interfaceDeclaration returns [Interface element] : 'interface' name= Identifier interfaceBody[$element] ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:99:2: ( 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:99:4: 'interface' name= Identifier interfaceBody[$element]
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:107:1: interfaceBody[Interface element] : (service= interfaceServiceDeclaration ';' )* ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:108:2: ( (service= interfaceServiceDeclaration ';' )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:108:4: (service= interfaceServiceDeclaration ';' )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:108:4: (service= interfaceServiceDeclaration ';' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||LA2_0==36||(LA2_0>=38 && LA2_0<=45)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:108:5: service= interfaceServiceDeclaration ';'
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:113:1: interfaceServiceDeclaration returns [Service element] : rtype= interfaceServiceReturnType name= Identifier params= formalParameters ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:114:2: (rtype= interfaceServiceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:114:4: rtype= interfaceServiceReturnType name= Identifier params= formalParameters
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:120:1: interfaceServiceReturnType returns [TypeReference element] : (vt= voidType | tp= type );
    public final MstageParser.interfaceServiceReturnType_return interfaceServiceReturnType() throws RecognitionException {
        MstageParser.interfaceServiceReturnType_return retval = new MstageParser.interfaceServiceReturnType_return();
        retval.start = input.LT(1);
        int interfaceServiceReturnType_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.voidType_return vt = null;

        MstageParser.type_return tp = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:121:2: (vt= voidType | tp= type )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==36) ) {
                alt3=1;
            }
            else if ( (LA3_0==Identifier||(LA3_0>=38 && LA3_0<=45)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:121:4: vt= voidType
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:122:4: tp= type
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:125:1: formalParameters returns [List<FormalParameter> element] : '(' (pars= formalParameterDecls )? ')' ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:127:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:127:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal6=(Token)match(input,25,FOLLOW_25_in_formalParameters222); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:127:13: (pars= formalParameterDecls )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Identifier||(LA4_0>=38 && LA4_0<=45)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:127:14: pars= formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters227);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:130:1: formalParameterDecls returns [List<FormalParameter> element] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:131:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:131:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:131:32: ( ',' decls= formalParameterDecls )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:131:33: ',' decls= formalParameterDecls
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

    public static class connectorDeclaration_return extends ParserRuleReturnScope {
        public Connector element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectorDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:148:1: connectorDeclaration returns [Connector element] : 'connector' ;
    public final MstageParser.connectorDeclaration_return connectorDeclaration() throws RecognitionException {
        MstageParser.connectorDeclaration_return retval = new MstageParser.connectorDeclaration_return();
        retval.start = input.LT(1);
        int connectorDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal9=null;

        Object string_literal9_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:149:2: ( 'connector' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:149:4: 'connector'
            {
            root_0 = (Object)adaptor.nil();

            string_literal9=(Token)match(input,28,FOLLOW_28_in_connectorDeclaration300); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal9_tree = (Object)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, connectorDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "connectorDeclaration"

    public static class compositeDeclaration_return extends ParserRuleReturnScope {
        public Composite element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compositeDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:157:1: compositeDeclaration returns [Composite element] : 'composite' name= Identifier compositeBody[$element] ;
    public final MstageParser.compositeDeclaration_return compositeDeclaration() throws RecognitionException {
        MstageParser.compositeDeclaration_return retval = new MstageParser.compositeDeclaration_return();
        retval.start = input.LT(1);
        int compositeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token string_literal10=null;
        MstageParser.compositeBody_return compositeBody11 = null;


        Object name_tree=null;
        Object string_literal10_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:158:2: ( 'composite' name= Identifier compositeBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:158:4: 'composite' name= Identifier compositeBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            string_literal10=(Token)match(input,29,FOLLOW_29_in_compositeDeclaration320); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal10_tree = (Object)adaptor.create(string_literal10);
            adaptor.addChild(root_0, string_literal10_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_compositeDeclaration324); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.element = new Composite(new SimpleNameSignature((name!=null?name.getText():null)));
              			
            }
            pushFollow(FOLLOW_compositeBody_in_compositeDeclaration330);
            compositeBody11=compositeBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, compositeBody11.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, compositeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compositeDeclaration"

    public static class compositeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compositeBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:165:1: compositeBody[Composite element] : '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}' ;
    public final MstageParser.compositeBody_return compositeBody(Composite element) throws RecognitionException {
        MstageParser.compositeBody_return retval = new MstageParser.compositeBody_return();
        retval.start = input.LT(1);
        int compositeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal12=null;
        Token char_literal15=null;
        MstageParser.compositeBodyDeclaration_return compositeBodyDeclaration13 = null;

        MstageParser.componentBodyDeclaration_return componentBodyDeclaration14 = null;


        Object char_literal12_tree=null;
        Object char_literal15_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:166:2: ( '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:166:4: '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal12=(Token)match(input,30,FOLLOW_30_in_compositeBody344); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:166:8: ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==32) ) {
                    alt6=1;
                }
                else if ( ((LA6_0>=34 && LA6_0<=35)) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:166:9: compositeBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_compositeBodyDeclaration_in_compositeBody347);
            	    compositeBodyDeclaration13=compositeBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compositeBodyDeclaration13.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:166:46: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_compositeBody352);
            	    componentBodyDeclaration14=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration14.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            char_literal15=(Token)match(input,31,FOLLOW_31_in_compositeBody357); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 10, compositeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compositeBody"

    public static class compositeBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compositeBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:170:1: compositeBodyDeclaration[Composite element] : 'contain' conts= compositeContainBody ;
    public final MstageParser.compositeBodyDeclaration_return compositeBodyDeclaration(Composite element) throws RecognitionException {
        MstageParser.compositeBodyDeclaration_return retval = new MstageParser.compositeBodyDeclaration_return();
        retval.start = input.LT(1);
        int compositeBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal16=null;
        MstageParser.compositeContainBody_return conts = null;


        Object string_literal16_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:171:2: ( 'contain' conts= compositeContainBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:171:4: 'contain' conts= compositeContainBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal16=(Token)match(input,32,FOLLOW_32_in_compositeBodyDeclaration370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal16_tree = (Object)adaptor.create(string_literal16);
            adaptor.addChild(root_0, string_literal16_tree);
            }
            pushFollow(FOLLOW_compositeContainBody_in_compositeBodyDeclaration374);
            conts=compositeContainBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, conts.getTree());
            if ( state.backtracking==0 ) {

              			for(String module : (conts!=null?conts.elements:null)) {
              				element.addSubmodules(new SimpleReference<Module>(module,Module.class));
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
            if ( state.backtracking>0 ) { memoize(input, 11, compositeBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compositeBodyDeclaration"

    public static class compositeContainBody_return extends ParserRuleReturnScope {
        public List<String> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compositeContainBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:178:1: compositeContainBody returns [List<String> elements] : '{' (decls= commaSeparatedBodyDecls )? '}' ;
    public final MstageParser.compositeContainBody_return compositeContainBody() throws RecognitionException {
        MstageParser.compositeContainBody_return retval = new MstageParser.compositeContainBody_return();
        retval.start = input.LT(1);
        int compositeContainBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal17=null;
        Token char_literal18=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal17_tree=null;
        Object char_literal18_tree=null;

         retval.elements = new ArrayList<String>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:180:2: ( '{' (decls= commaSeparatedBodyDecls )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:180:4: '{' (decls= commaSeparatedBodyDecls )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal17=(Token)match(input,30,FOLLOW_30_in_compositeContainBody395); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal17_tree = (Object)adaptor.create(char_literal17);
            adaptor.addChild(root_0, char_literal17_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:180:8: (decls= commaSeparatedBodyDecls )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Identifier) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:180:9: decls= commaSeparatedBodyDecls
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_compositeContainBody400);
                    decls=commaSeparatedBodyDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                      retval.elements =(decls!=null?decls.elements:null);
                    }

                    }
                    break;

            }

            char_literal18=(Token)match(input,31,FOLLOW_31_in_compositeContainBody407); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 12, compositeContainBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compositeContainBody"

    public static class componentDeclaration_return extends ParserRuleReturnScope {
        public Component element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:186:1: componentDeclaration returns [Component element] : 'component' name= Identifier componentBody[$element] ;
    public final MstageParser.componentDeclaration_return componentDeclaration() throws RecognitionException {
        MstageParser.componentDeclaration_return retval = new MstageParser.componentDeclaration_return();
        retval.start = input.LT(1);
        int componentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token string_literal19=null;
        MstageParser.componentBody_return componentBody20 = null;


        Object name_tree=null;
        Object string_literal19_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:187:2: ( 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:187:6: 'component' name= Identifier componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            string_literal19=(Token)match(input,33,FOLLOW_33_in_componentDeclaration428); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal19_tree = (Object)adaptor.create(string_literal19);
            adaptor.addChild(root_0, string_literal19_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration432); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                  			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                  			setLocation(retval.element,name,"__NAME");
              			
            }
            pushFollow(FOLLOW_componentBody_in_componentDeclaration436);
            componentBody20=componentBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBody20.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, componentDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentDeclaration"

    public static class componentBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:193:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
    public final MstageParser.componentBody_return componentBody(Component element) throws RecognitionException {
        MstageParser.componentBody_return retval = new MstageParser.componentBody_return();
        retval.start = input.LT(1);
        int componentBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal21=null;
        Token char_literal23=null;
        MstageParser.componentBodyDeclaration_return componentBodyDeclaration22 = null;


        Object char_literal21_tree=null;
        Object char_literal23_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:194:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:194:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal21=(Token)match(input,30,FOLLOW_30_in_componentBody453); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal21_tree = (Object)adaptor.create(char_literal21);
            adaptor.addChild(root_0, char_literal21_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:194:8: ( componentBodyDeclaration[$element] )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=34 && LA8_0<=35)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody455);
            	    componentBodyDeclaration22=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration22.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            char_literal23=(Token)match(input,31,FOLLOW_31_in_componentBody459); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal23_tree = (Object)adaptor.create(char_literal23);
            adaptor.addChild(root_0, char_literal23_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, componentBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentBody"

    public static class componentBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:197:1: componentBodyDeclaration[Component element] : ( 'require' rd= componentDependencyBody | 'provide' pd= componentDependencyBody );
    public final MstageParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MstageParser.componentBodyDeclaration_return retval = new MstageParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);
        int componentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal24=null;
        Token string_literal25=null;
        MstageParser.componentDependencyBody_return rd = null;

        MstageParser.componentDependencyBody_return pd = null;


        Object string_literal24_tree=null;
        Object string_literal25_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:198:2: ( 'require' rd= componentDependencyBody | 'provide' pd= componentDependencyBody )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==34) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:198:4: 'require' rd= componentDependencyBody
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal24=(Token)match(input,34,FOLLOW_34_in_componentBodyDeclaration475); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal24_tree = (Object)adaptor.create(string_literal24);
                    adaptor.addChild(root_0, string_literal24_tree);
                    }
                    pushFollow(FOLLOW_componentDependencyBody_in_componentBodyDeclaration479);
                    rd=componentDependencyBody();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rd.getTree());
                    if ( state.backtracking==0 ) {

                      			for(String iface : (rd!=null?rd.elements:null) ) {
                      				element.addRequiredInterface(new SimpleReference<Interface>(iface, Interface.class));
                      			}
                      		 
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:203:4: 'provide' pd= componentDependencyBody
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal25=(Token)match(input,35,FOLLOW_35_in_componentBodyDeclaration486); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal25_tree = (Object)adaptor.create(string_literal25);
                    adaptor.addChild(root_0, string_literal25_tree);
                    }
                    pushFollow(FOLLOW_componentDependencyBody_in_componentBodyDeclaration490);
                    pd=componentDependencyBody();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pd.getTree());
                    if ( state.backtracking==0 ) {

                      			for(String iface : (pd!=null?pd.elements:null) ) {
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
            if ( state.backtracking>0 ) { memoize(input, 15, componentBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentBodyDeclaration"

    public static class componentDependencyBody_return extends ParserRuleReturnScope {
        public List<String> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentDependencyBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:211:1: componentDependencyBody returns [List<String> elements] : '{' (decls= commaSeparatedBodyDecls )? '}' ;
    public final MstageParser.componentDependencyBody_return componentDependencyBody() throws RecognitionException {
        MstageParser.componentDependencyBody_return retval = new MstageParser.componentDependencyBody_return();
        retval.start = input.LT(1);
        int componentDependencyBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal26=null;
        Token char_literal27=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal26_tree=null;
        Object char_literal27_tree=null;

         retval.elements = new ArrayList<String>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:213:2: ( '{' (decls= commaSeparatedBodyDecls )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:213:4: '{' (decls= commaSeparatedBodyDecls )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal26=(Token)match(input,30,FOLLOW_30_in_componentDependencyBody513); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal26_tree = (Object)adaptor.create(char_literal26);
            adaptor.addChild(root_0, char_literal26_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:213:8: (decls= commaSeparatedBodyDecls )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Identifier) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:213:9: decls= commaSeparatedBodyDecls
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_componentDependencyBody518);
                    decls=commaSeparatedBodyDecls();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decls.getTree());
                    if ( state.backtracking==0 ) {
                      retval.elements =(decls!=null?decls.elements:null); 
                    }

                    }
                    break;

            }

            char_literal27=(Token)match(input,31,FOLLOW_31_in_componentDependencyBody525); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 16, componentDependencyBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "componentDependencyBody"

    public static class commaSeparatedBodyDecls_return extends ParserRuleReturnScope {
        public List<String> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "commaSeparatedBodyDecls"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:285:1: commaSeparatedBodyDecls returns [List<String> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls )? ;
    public final MstageParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls() throws RecognitionException {
        MstageParser.commaSeparatedBodyDecls_return retval = new MstageParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);
        int commaSeparatedBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token char_literal28=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object id_tree=null;
        Object char_literal28_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:286:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:286:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls )?
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls554); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:286:18: ( ',' decls= commaSeparatedBodyDecls )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:286:19: ',' decls= commaSeparatedBodyDecls
                    {
                    char_literal28=(Token)match(input,27,FOLLOW_27_in_commaSeparatedBodyDecls557); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (Object)adaptor.create(char_literal28);
                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls561);
                    decls=commaSeparatedBodyDecls();

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

              			
              			if (retval.elements == null) {
              				retval.elements = new ArrayList<String>();
              			}
              			
              			retval.elements.add(0,(id!=null?id.getText():null));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, commaSeparatedBodyDecls_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "commaSeparatedBodyDecls"

    public static class voidType_return extends ParserRuleReturnScope {
        public TypeReference element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "voidType"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:296:1: voidType returns [TypeReference element] : 'void' ;
    public final MstageParser.voidType_return voidType() throws RecognitionException {
        MstageParser.voidType_return retval = new MstageParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal29=null;

        Object string_literal29_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:298:7: ( 'void' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:298:10: 'void'
            {
            root_0 = (Object)adaptor.nil();

            string_literal29=(Token)match(input,36,FOLLOW_36_in_voidType590); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal29_tree = (Object)adaptor.create(string_literal29);
            adaptor.addChild(root_0, string_literal29_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 18, voidType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:302:1: type returns [TypeReference element] : (cd= classOrInterfaceType | pt= primitiveType );
    public final MstageParser.type_return type() throws RecognitionException {
        MstageParser.type_return retval = new MstageParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.classOrInterfaceType_return cd = null;

        MstageParser.primitiveType_return pt = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:304:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Identifier) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=38 && LA12_0<=45)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:304:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceType_in_type617);
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:305:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveType_in_type626);
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
            if ( state.backtracking>0 ) { memoize(input, 19, type_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:309:1: classOrInterfaceType returns [TypeReference element] : name= Identifier ( '.' namex= Identifier )* ;
    public final MstageParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MstageParser.classOrInterfaceType_return retval = new MstageParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal30=null;

        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal30_tree=null;

        NamespaceOrTypeReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:311:2: (name= Identifier ( '.' namex= Identifier )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:311:4: name= Identifier ( '.' namex= Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType651); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new TypeReference((name!=null?name.getText():null)); 
              	           target =  new NamespaceOrTypeReference((name!=null?name.getText():null)); 
              	          
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:316:10: ( '.' namex= Identifier )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==37) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:316:11: '.' namex= Identifier
            	    {
            	    char_literal30=(Token)match(input,37,FOLLOW_37_in_classOrInterfaceType678); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal30_tree = (Object)adaptor.create(char_literal30);
            	    adaptor.addChild(root_0, char_literal30_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType682); if (state.failed) return retval;
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
            	    break loop13;
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
            if ( state.backtracking>0 ) { memoize(input, 20, classOrInterfaceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:331:1: primitiveType returns [TypeReference element] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MstageParser.primitiveType_return primitiveType() throws RecognitionException {
        MstageParser.primitiveType_return retval = new MstageParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal31=null;
        Token string_literal32=null;
        Token string_literal33=null;
        Token string_literal34=null;
        Token string_literal35=null;
        Token string_literal36=null;
        Token string_literal37=null;
        Token string_literal38=null;

        Object string_literal31_tree=null;
        Object string_literal32_tree=null;
        Object string_literal33_tree=null;
        Object string_literal34_tree=null;
        Object string_literal35_tree=null;
        Object string_literal36_tree=null;
        Object string_literal37_tree=null;
        Object string_literal38_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:332:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt14=8;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt14=1;
                }
                break;
            case 39:
                {
                alt14=2;
                }
                break;
            case 40:
                {
                alt14=3;
                }
                break;
            case 41:
                {
                alt14=4;
                }
                break;
            case 42:
                {
                alt14=5;
                }
                break;
            case 43:
                {
                alt14=6;
                }
                break;
            case 44:
                {
                alt14=7;
                }
                break;
            case 45:
                {
                alt14=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:332:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal31=(Token)match(input,38,FOLLOW_38_in_primitiveType731); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal31_tree = (Object)adaptor.create(string_literal31);
                    adaptor.addChild(root_0, string_literal31_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:333:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal32=(Token)match(input,39,FOLLOW_39_in_primitiveType743); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal32_tree = (Object)adaptor.create(string_literal32);
                    adaptor.addChild(root_0, string_literal32_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("char");
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:334:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal33=(Token)match(input,40,FOLLOW_40_in_primitiveType755); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal33_tree = (Object)adaptor.create(string_literal33);
                    adaptor.addChild(root_0, string_literal33_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("byte");
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal34=(Token)match(input,41,FOLLOW_41_in_primitiveType767); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal34_tree = (Object)adaptor.create(string_literal34);
                    adaptor.addChild(root_0, string_literal34_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("short");
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:336:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal35=(Token)match(input,42,FOLLOW_42_in_primitiveType779); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal35_tree = (Object)adaptor.create(string_literal35);
                    adaptor.addChild(root_0, string_literal35_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("int");
                    }

                    }
                    break;
                case 6 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:337:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal36=(Token)match(input,43,FOLLOW_43_in_primitiveType791); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal36_tree = (Object)adaptor.create(string_literal36);
                    adaptor.addChild(root_0, string_literal36_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("long");
                    }

                    }
                    break;
                case 7 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:338:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal37=(Token)match(input,44,FOLLOW_44_in_primitiveType803); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal37_tree = (Object)adaptor.create(string_literal37);
                    adaptor.addChild(root_0, string_literal37_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new TypeReference("float");
                    }

                    }
                    break;
                case 8 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:339:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal38=(Token)match(input,45,FOLLOW_45_in_primitiveType815); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal38_tree = (Object)adaptor.create(string_literal38);
                    adaptor.addChild(root_0, string_literal38_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 21, primitiveType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primitiveType"

    public static class annotations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotations"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:345:1: annotations : ( annotation )+ ;
    public final MstageParser.annotations_return annotations() throws RecognitionException {
        MstageParser.annotations_return retval = new MstageParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation39 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:5: ( ( annotation )+ )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:9: ( annotation )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==46) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations839);
            	    annotation39=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation39.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
            if ( state.backtracking>0 ) { memoize(input, 22, annotations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotations"

    public static class annotation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotation"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:349:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MstageParser.annotation_return annotation() throws RecognitionException {
        MstageParser.annotation_return retval = new MstageParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal40=null;
        Token char_literal42=null;
        Token char_literal45=null;
        MstageParser.annotationName_return annotationName41 = null;

        MstageParser.elementValuePairs_return elementValuePairs43 = null;

        MstageParser.elementValue_return elementValue44 = null;


        Object char_literal40_tree=null;
        Object char_literal42_tree=null;
        Object char_literal45_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:350:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:350:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            char_literal40=(Token)match(input,46,FOLLOW_46_in_annotation859); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal40_tree = (Object)adaptor.create(char_literal40);
            adaptor.addChild(root_0, char_literal40_tree);
            }
            pushFollow(FOLLOW_annotationName_in_annotation861);
            annotationName41=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName41.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:350:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:350:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal42=(Token)match(input,25,FOLLOW_25_in_annotation865); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal42_tree = (Object)adaptor.create(char_literal42);
                    adaptor.addChild(root_0, char_literal42_tree);
                    }
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:350:34: ( elementValuePairs | elementValue )?
                    int alt16=3;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==Identifier) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==30||LA16_0==46) ) {
                        alt16=2;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:350:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation869);
                            elementValuePairs43=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs43.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:350:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation873);
                            elementValue44=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue44.getTree());

                            }
                            break;

                    }

                    char_literal45=(Token)match(input,26,FOLLOW_26_in_annotation878); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    adaptor.addChild(root_0, char_literal45_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 23, annotation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotation"

    public static class annotationName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationName"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:353:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MstageParser.annotationName_return annotationName() throws RecognitionException {
        MstageParser.annotationName_return retval = new MstageParser.annotationName_return();
        retval.start = input.LT(1);
        int annotationName_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier46=null;
        Token char_literal47=null;
        Token Identifier48=null;

        Object Identifier46_tree=null;
        Object char_literal47_tree=null;
        Object Identifier48_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:354:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:354:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            Identifier46=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName902); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier46_tree = (Object)adaptor.create(Identifier46);
            adaptor.addChild(root_0, Identifier46_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:354:18: ( '.' Identifier )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==37) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:354:19: '.' Identifier
            	    {
            	    char_literal47=(Token)match(input,37,FOLLOW_37_in_annotationName905); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal47_tree = (Object)adaptor.create(char_literal47);
            	    adaptor.addChild(root_0, char_literal47_tree);
            	    }
            	    Identifier48=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName907); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier48_tree = (Object)adaptor.create(Identifier48);
            	    adaptor.addChild(root_0, Identifier48_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop18;
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
            if ( state.backtracking>0 ) { memoize(input, 24, annotationName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationName"

    public static class elementValuePairs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePairs"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:357:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MstageParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MstageParser.elementValuePairs_return retval = new MstageParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal50=null;
        MstageParser.elementValuePair_return elementValuePair49 = null;

        MstageParser.elementValuePair_return elementValuePair51 = null;


        Object char_literal50_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:358:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:358:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs928);
            elementValuePair49=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair49.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:358:26: ( ',' elementValuePair )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==27) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:358:27: ',' elementValuePair
            	    {
            	    char_literal50=(Token)match(input,27,FOLLOW_27_in_elementValuePairs931); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal50_tree = (Object)adaptor.create(char_literal50);
            	    adaptor.addChild(root_0, char_literal50_tree);
            	    }
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs933);
            	    elementValuePair51=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair51.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
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
            if ( state.backtracking>0 ) { memoize(input, 25, elementValuePairs_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePairs"

    public static class elementValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePair"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:361:1: elementValuePair : Identifier '=' elementValue ;
    public final MstageParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MstageParser.elementValuePair_return retval = new MstageParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier52=null;
        Token char_literal53=null;
        MstageParser.elementValue_return elementValue54 = null;


        Object Identifier52_tree=null;
        Object char_literal53_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:362:5: ( Identifier '=' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:362:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();

            Identifier52=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair954); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier52_tree = (Object)adaptor.create(Identifier52);
            adaptor.addChild(root_0, Identifier52_tree);
            }
            char_literal53=(Token)match(input,47,FOLLOW_47_in_elementValuePair956); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal53_tree = (Object)adaptor.create(char_literal53);
            adaptor.addChild(root_0, char_literal53_tree);
            }
            pushFollow(FOLLOW_elementValue_in_elementValuePair958);
            elementValue54=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue54.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, elementValuePair_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePair"

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:365:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MstageParser.elementValue_return elementValue() throws RecognitionException {
        MstageParser.elementValue_return retval = new MstageParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation55 = null;

        MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer56 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:366:5: ( annotation | elementValueArrayInitializer )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==46) ) {
                alt20=1;
            }
            else if ( (LA20_0==30) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:366:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotation_in_elementValue981);
                    annotation55=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation55.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:367:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue991);
                    elementValueArrayInitializer56=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer56.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 27, elementValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValue"

    public static class elementValueArrayInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValueArrayInitializer"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:370:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MstageParser.elementValueArrayInitializer_return retval = new MstageParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal57=null;
        Token char_literal59=null;
        Token char_literal61=null;
        Token char_literal62=null;
        MstageParser.elementValue_return elementValue58 = null;

        MstageParser.elementValue_return elementValue60 = null;


        Object char_literal57_tree=null;
        Object char_literal59_tree=null;
        Object char_literal61_tree=null;
        Object char_literal62_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal57=(Token)match(input,30,FOLLOW_30_in_elementValueArrayInitializer1014); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal57_tree = (Object)adaptor.create(char_literal57);
            adaptor.addChild(root_0, char_literal57_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:13: ( elementValue ( ',' elementValue )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30||LA22_0==46) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer1017);
                    elementValue58=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue58.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:27: ( ',' elementValue )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==27) ) {
                            int LA21_1 = input.LA(2);

                            if ( (LA21_1==30||LA21_1==46) ) {
                                alt21=1;
                            }


                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:28: ',' elementValue
                    	    {
                    	    char_literal59=(Token)match(input,27,FOLLOW_27_in_elementValueArrayInitializer1020); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal59_tree = (Object)adaptor.create(char_literal59);
                    	    adaptor.addChild(root_0, char_literal59_tree);
                    	    }
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer1022);
                    	    elementValue60=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue60.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:49: ( ',' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==27) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:371:50: ','
                    {
                    char_literal61=(Token)match(input,27,FOLLOW_27_in_elementValueArrayInitializer1029); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal61_tree = (Object)adaptor.create(char_literal61);
                    adaptor.addChild(root_0, char_literal61_tree);
                    }

                    }
                    break;

            }

            char_literal62=(Token)match(input,31,FOLLOW_31_in_elementValueArrayInitializer1033); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 28, elementValueArrayInitializer_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:374:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MstageParser.annotationTypeDeclaration_return retval = new MstageParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal63=null;
        Token string_literal64=null;
        MstageParser.annotationTypeBody_return annotationTypeBody65 = null;


        Object name_tree=null;
        Object char_literal63_tree=null;
        Object string_literal64_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();

            char_literal63=(Token)match(input,46,FOLLOW_46_in_annotationTypeDeclaration1060); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal63_tree = (Object)adaptor.create(char_literal63);
            adaptor.addChild(root_0, char_literal63_tree);
            }
            string_literal64=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration1062); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal64_tree = (Object)adaptor.create(string_literal64);
            adaptor.addChild(root_0, string_literal64_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration1066); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration1068);
            annotationTypeBody65=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody65.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, annotationTypeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeDeclaration"

    public static class annotationTypeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:378:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MstageParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MstageParser.annotationTypeBody_return retval = new MstageParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal66=null;
        Token char_literal68=null;
        MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration67 = null;


        Object char_literal66_tree=null;
        Object char_literal68_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:379:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:379:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal66=(Token)match(input,30,FOLLOW_30_in_annotationTypeBody1091); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal66_tree = (Object)adaptor.create(char_literal66);
            adaptor.addChild(root_0, char_literal66_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:379:13: ( annotationTypeElementDeclaration )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==Identifier||(LA24_0>=38 && LA24_0<=46)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:379:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody1094);
            	    annotationTypeElementDeclaration67=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration67.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            char_literal68=(Token)match(input,31,FOLLOW_31_in_annotationTypeBody1098); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal68_tree = (Object)adaptor.create(char_literal68);
            adaptor.addChild(root_0, char_literal68_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, annotationTypeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeBody"

    public static class annotationTypeElementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:382:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MstageParser.annotationTypeElementDeclaration_return retval = new MstageParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationTypeElementRest_return annotationTypeElementRest69 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:383:5: ( annotationTypeElementRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:383:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration1123);
            annotationTypeElementRest69=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest69.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, annotationTypeElementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementDeclaration"

    public static class annotationTypeElementRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:386:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MstageParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MstageParser.annotationTypeElementRest_return retval = new MstageParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal72=null;
        Token char_literal74=null;
        MstageParser.type_return type70 = null;

        MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest71 = null;

        MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration73 = null;


        Object char_literal72_tree=null;
        Object char_literal74_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:387:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Identifier||(LA26_0>=38 && LA26_0<=45)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:387:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_annotationTypeElementRest1146);
                    type70=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type70.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest1148);
                    annotationMethodOrConstantRest71=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest71.getTree());
                    char_literal72=(Token)match(input,24,FOLLOW_24_in_annotationTypeElementRest1150); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal72_tree = (Object)adaptor.create(char_literal72);
                    adaptor.addChild(root_0, char_literal72_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:388:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest1160);
                    annotationTypeDeclaration73=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration73.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:388:35: ( ';' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==24) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: ';'
                            {
                            char_literal74=(Token)match(input,24,FOLLOW_24_in_annotationTypeElementRest1162); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal74_tree = (Object)adaptor.create(char_literal74);
                            adaptor.addChild(root_0, char_literal74_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 32, annotationTypeElementRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementRest"

    public static class annotationMethodOrConstantRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodOrConstantRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:391:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MstageParser.annotationMethodOrConstantRest_return retval = new MstageParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationMethodRest_return annotationMethodRest75 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:392:5: ( annotationMethodRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:392:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest1186);
            annotationMethodRest75=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest75.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, annotationMethodOrConstantRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodOrConstantRest"

    public static class annotationMethodRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:395:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MstageParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MstageParser.annotationMethodRest_return retval = new MstageParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier76=null;
        Token char_literal77=null;
        Token char_literal78=null;
        MstageParser.defaultValue_return defaultValue79 = null;


        Object Identifier76_tree=null;
        Object char_literal77_tree=null;
        Object char_literal78_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:396:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:396:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier76=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest1209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier76_tree = (Object)adaptor.create(Identifier76);
            adaptor.addChild(root_0, Identifier76_tree);
            }
            char_literal77=(Token)match(input,25,FOLLOW_25_in_annotationMethodRest1211); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal77_tree = (Object)adaptor.create(char_literal77);
            adaptor.addChild(root_0, char_literal77_tree);
            }
            char_literal78=(Token)match(input,26,FOLLOW_26_in_annotationMethodRest1213); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal78_tree = (Object)adaptor.create(char_literal78);
            adaptor.addChild(root_0, char_literal78_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:396:28: ( defaultValue )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==48) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest1215);
                    defaultValue79=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue79.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 34, annotationMethodRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodRest"

    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:399:1: defaultValue : 'default' elementValue ;
    public final MstageParser.defaultValue_return defaultValue() throws RecognitionException {
        MstageParser.defaultValue_return retval = new MstageParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal80=null;
        MstageParser.elementValue_return elementValue81 = null;


        Object string_literal80_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:400:5: ( 'default' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:400:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();

            string_literal80=(Token)match(input,48,FOLLOW_48_in_defaultValue1243); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal80_tree = (Object)adaptor.create(string_literal80);
            adaptor.addChild(root_0, string_literal80_tree);
            }
            pushFollow(FOLLOW_elementValue_in_defaultValue1245);
            elementValue81=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue81.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, defaultValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration114 = new BitSet(new long[]{0x00003FD000000010L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceServiceDeclaration_in_interfaceBody137 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_interfaceBody138 = new BitSet(new long[]{0x00003FD000000012L});
    public static final BitSet FOLLOW_interfaceServiceReturnType_in_interfaceServiceDeclaration159 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceServiceDeclaration163 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_formalParameters_in_interfaceServiceDeclaration167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_interfaceServiceReturnType186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_interfaceServiceReturnType195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_formalParameters222 = new BitSet(new long[]{0x00003FD004000010L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters227 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_formalParameters233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls262 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_formalParameterDecls265 = new BitSet(new long[]{0x00003FD000000010L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_connectorDeclaration300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_compositeDeclaration320 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_compositeDeclaration324 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_compositeBody_in_compositeDeclaration330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_compositeBody344 = new BitSet(new long[]{0x0000000D80000000L});
    public static final BitSet FOLLOW_compositeBodyDeclaration_in_compositeBody347 = new BitSet(new long[]{0x0000000D80000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_compositeBody352 = new BitSet(new long[]{0x0000000D80000000L});
    public static final BitSet FOLLOW_31_in_compositeBody357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_compositeBodyDeclaration370 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_compositeContainBody_in_compositeBodyDeclaration374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_compositeContainBody395 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_compositeContainBody400 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_compositeContainBody407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_componentDeclaration428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration432 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_componentBody453 = new BitSet(new long[]{0x0000000D80000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody455 = new BitSet(new long[]{0x0000000D80000000L});
    public static final BitSet FOLLOW_31_in_componentBody459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_componentBodyDeclaration475 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_componentDependencyBody_in_componentBodyDeclaration479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_componentBodyDeclaration486 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_componentDependencyBody_in_componentBodyDeclaration490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_componentDependencyBody513 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_componentDependencyBody518 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_componentDependencyBody525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls554 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_commaSeparatedBodyDecls557 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_voidType590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType651 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_classOrInterfaceType678 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType682 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_38_in_primitiveType731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_primitiveType743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_primitiveType755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_primitiveType767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_primitiveType779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_primitiveType791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_primitiveType803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_primitiveType815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations839 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_annotation859 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation861 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_annotation865 = new BitSet(new long[]{0x0000400044000010L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation869 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation873 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotation878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName902 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_annotationName905 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName907 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs928 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_elementValuePairs931 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs933 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair954 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_elementValuePair956 = new BitSet(new long[]{0x0000400040000000L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_elementValueArrayInitializer1014 = new BitSet(new long[]{0x00004000C8000000L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer1017 = new BitSet(new long[]{0x0000000088000000L});
    public static final BitSet FOLLOW_27_in_elementValueArrayInitializer1020 = new BitSet(new long[]{0x0000400040000000L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer1022 = new BitSet(new long[]{0x0000000088000000L});
    public static final BitSet FOLLOW_27_in_elementValueArrayInitializer1029 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_elementValueArrayInitializer1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_annotationTypeDeclaration1060 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration1062 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration1066 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_annotationTypeBody1091 = new BitSet(new long[]{0x00007FD080000010L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody1094 = new BitSet(new long[]{0x00007FD080000010L});
    public static final BitSet FOLLOW_31_in_annotationTypeBody1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest1146 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest1148 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_annotationTypeElementRest1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest1160 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeElementRest1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest1209 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_annotationMethodRest1211 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationMethodRest1213 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_defaultValue1243 = new BitSet(new long[]{0x0000400040000000L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue1245 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g 2010-06-07 17:50:41

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
import chameleon.oo.type.TypeReference;
import chameleon.oo.type.BasicTypeReference;
import chameleon.oo.type.Type;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "StringLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "';'", "'('", "')'", "','", "'connector'", "'{'", "'}'", "'ao-composition'", "'pointcut'", "'kind'", "':'", "'signature'", "'caller'", "'callee'", "'advice'", "'service'", "'type'", "'composite'", "'contain'", "'component'", "'require'", "'provide'", "'before'", "'after'", "'around'", "'execution'", "'call'", "'void'", "'.'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'@'", "'='", "'default'"
    };
    public static final int T__29=29;
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
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
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
            this.state.ruleMemo = new HashMap[101+1];
             
             
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:71:1: compilationUnit returns [CompilationUnit element] : (cd= componentDeclaration | id= interfaceDeclaration );
    public final MstageParser.compilationUnit_return compilationUnit() throws RecognitionException {
        MstageParser.compilationUnit_return retval = new MstageParser.compilationUnit_return();
        retval.start = input.LT(1);
        int compilationUnit_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.componentDeclaration_return cd = null;

        MstageParser.interfaceDeclaration_return id = null;



         
        	NamespacePart npp = null;
        	retval.element = getCompilationUnit();
        	npp = new NamespacePart(language().defaultNamespace());
        	retval.element.add(npp);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:78:2: (cd= componentDeclaration | id= interfaceDeclaration )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==43) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:78:4: cd= componentDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_componentDeclaration_in_compilationUnit84);
                    cd=componentDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cd.getTree());
                    if ( state.backtracking==0 ) {
                      npp.add((cd!=null?cd.element:null));
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:79:4: id= interfaceDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_interfaceDeclaration_in_compilationUnit93);
                    id=interfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, id.getTree());
                    if ( state.backtracking==0 ) {
                      npp.add((id!=null?id.element:null));
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:89:2: interfaceDeclaration returns [Interface element] : 'interface' name= Identifier interfaceBody[$element] ;
    public final MstageParser.interfaceDeclaration_return interfaceDeclaration() throws RecognitionException {
        MstageParser.interfaceDeclaration_return retval = new MstageParser.interfaceDeclaration_return();
        retval.start = input.LT(1);
        int interfaceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token string_literal1=null;
        MstageParser.interfaceBody_return interfaceBody2 = null;


        Object name_tree=null;
        Object string_literal1_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:90:2: ( 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:90:4: 'interface' name= Identifier interfaceBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            string_literal1=(Token)match(input,23,FOLLOW_23_in_interfaceDeclaration118); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal1_tree = (Object)adaptor.create(string_literal1);
            adaptor.addChild(root_0, string_literal1_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration122); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Interface(new SimpleNameSignature((name!=null?name.getText():null)));
              			setLocation(retval.element,name,"__NAME");
              		
            }
            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration128);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:98:1: interfaceBody[Interface element] : (service= serviceDeclaration ';' )* ;
    public final MstageParser.interfaceBody_return interfaceBody(Interface element) throws RecognitionException {
        MstageParser.interfaceBody_return retval = new MstageParser.interfaceBody_return();
        retval.start = input.LT(1);
        int interfaceBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal3=null;
        MstageParser.serviceDeclaration_return service = null;


        Object char_literal3_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:99:2: ( (service= serviceDeclaration ';' )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:99:4: (service= serviceDeclaration ';' )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:99:4: (service= serviceDeclaration ';' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||LA2_0==51||(LA2_0>=53 && LA2_0<=60)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:99:5: service= serviceDeclaration ';'
            	    {
            	    pushFollow(FOLLOW_serviceDeclaration_in_interfaceBody145);
            	    service=serviceDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
            	    char_literal3=(Token)match(input,24,FOLLOW_24_in_interfaceBody146); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal3_tree = (Object)adaptor.create(char_literal3);
            	    adaptor.addChild(root_0, char_literal3_tree);
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

    public static class serviceDeclaration_return extends ParserRuleReturnScope {
        public Service element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "serviceDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:104:1: serviceDeclaration returns [Service element] : rtype= serviceReturnType name= Identifier params= formalParameters ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:105:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:105:4: rtype= serviceReturnType name= Identifier params= formalParameters
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_serviceReturnType_in_serviceDeclaration167);
            rtype=serviceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceDeclaration171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_formalParameters_in_serviceDeclaration175);
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
            if ( state.backtracking>0 ) { memoize(input, 4, serviceDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:111:1: serviceReturnType returns [TypeReference element] : (vt= voidType | tp= type );
    public final MstageParser.serviceReturnType_return serviceReturnType() throws RecognitionException {
        MstageParser.serviceReturnType_return retval = new MstageParser.serviceReturnType_return();
        retval.start = input.LT(1);
        int serviceReturnType_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.voidType_return vt = null;

        MstageParser.type_return tp = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:112:2: (vt= voidType | tp= type )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==51) ) {
                alt3=1;
            }
            else if ( (LA3_0==Identifier||(LA3_0>=53 && LA3_0<=60)) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:112:4: vt= voidType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_voidType_in_serviceReturnType194);
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:113:4: tp= type
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_serviceReturnType203);
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
            if ( state.backtracking>0 ) { memoize(input, 5, serviceReturnType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:116:1: formalParameters returns [List<FormalParameter> element] : '(' (pars= formalParameterDecls )? ')' ;
    public final MstageParser.formalParameters_return formalParameters() throws RecognitionException {
        MstageParser.formalParameters_return retval = new MstageParser.formalParameters_return();
        retval.start = input.LT(1);
        int formalParameters_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal4=null;
        Token char_literal5=null;
        MstageParser.formalParameterDecls_return pars = null;


        Object char_literal4_tree=null;
        Object char_literal5_tree=null;

        retval.element = new ArrayList<FormalParameter>();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:118:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:118:9: '(' (pars= formalParameterDecls )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal4=(Token)match(input,25,FOLLOW_25_in_formalParameters230); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal4_tree = (Object)adaptor.create(char_literal4);
            adaptor.addChild(root_0, char_literal4_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:118:13: (pars= formalParameterDecls )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Identifier||(LA4_0>=53 && LA4_0<=60)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:118:14: pars= formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters235);
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

            char_literal5=(Token)match(input,26,FOLLOW_26_in_formalParameters241); if (state.failed) return retval;
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:121:1: formalParameterDecls returns [List<FormalParameter> element] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
    public final MstageParser.formalParameterDecls_return formalParameterDecls() throws RecognitionException {
        MstageParser.formalParameterDecls_return retval = new MstageParser.formalParameterDecls_return();
        retval.start = input.LT(1);
        int formalParameterDecls_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal6=null;
        MstageParser.type_return t = null;

        MstageParser.formalParameterDecls_return decls = null;


        Object name_tree=null;
        Object char_literal6_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:122:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:122:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_type_in_formalParameterDecls266);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls270); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:122:32: ( ',' decls= formalParameterDecls )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:122:33: ',' decls= formalParameterDecls
                    {
                    char_literal6=(Token)match(input,27,FOLLOW_27_in_formalParameterDecls273); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal6_tree = (Object)adaptor.create(char_literal6);
                    adaptor.addChild(root_0, char_literal6_tree);
                    }
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls277);
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:144:1: connectorDeclaration returns [Connector element] : 'connector' name= Identifier connectorBody[$element] ;
    public final MstageParser.connectorDeclaration_return connectorDeclaration() throws RecognitionException {
        MstageParser.connectorDeclaration_return retval = new MstageParser.connectorDeclaration_return();
        retval.start = input.LT(1);
        int connectorDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token string_literal7=null;
        MstageParser.connectorBody_return connectorBody8 = null;


        Object name_tree=null;
        Object string_literal7_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:145:2: ( 'connector' name= Identifier connectorBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:145:4: 'connector' name= Identifier connectorBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            string_literal7=(Token)match(input,28,FOLLOW_28_in_connectorDeclaration312); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal7_tree = (Object)adaptor.create(string_literal7);
            adaptor.addChild(root_0, string_literal7_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration316); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration318);
            connectorBody8=connectorBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorBody8.getTree());
            if ( state.backtracking==0 ) {

              			retval.element = new Connector(new SimpleNameSignature((name!=null?name.getText():null)));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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

    public static class connectorBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectorBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:151:1: connectorBody[Connector element] : '{' ( connectorBodyDeclaration[$element] )* '}' ;
    public final MstageParser.connectorBody_return connectorBody(Connector element) throws RecognitionException {
        MstageParser.connectorBody_return retval = new MstageParser.connectorBody_return();
        retval.start = input.LT(1);
        int connectorBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal9=null;
        Token char_literal11=null;
        MstageParser.connectorBodyDeclaration_return connectorBodyDeclaration10 = null;


        Object char_literal9_tree=null;
        Object char_literal11_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:152:2: ( '{' ( connectorBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:152:4: '{' ( connectorBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal9=(Token)match(input,29,FOLLOW_29_in_connectorBody334); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal9_tree = (Object)adaptor.create(char_literal9);
            adaptor.addChild(root_0, char_literal9_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:152:9: ( connectorBodyDeclaration[$element] )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==31||LA6_0==44) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: connectorBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_connectorBodyDeclaration_in_connectorBody337);
            	    connectorBodyDeclaration10=connectorBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorBodyDeclaration10.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            char_literal11=(Token)match(input,30,FOLLOW_30_in_connectorBody342); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 9, connectorBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "connectorBody"

    public static class connectorBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectorBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:156:1: connectorBodyDeclaration[Connector component] : ( connectorAOCompositionDeclaration | moduleRequireDependencyDeclaration[$component] );
    public final MstageParser.connectorBodyDeclaration_return connectorBodyDeclaration(Connector component) throws RecognitionException {
        MstageParser.connectorBodyDeclaration_return retval = new MstageParser.connectorBodyDeclaration_return();
        retval.start = input.LT(1);
        int connectorBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.connectorAOCompositionDeclaration_return connectorAOCompositionDeclaration12 = null;

        MstageParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration13 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:157:2: ( connectorAOCompositionDeclaration | moduleRequireDependencyDeclaration[$component] )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==31) ) {
                alt7=1;
            }
            else if ( (LA7_0==44) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:157:4: connectorAOCompositionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration355);
                    connectorAOCompositionDeclaration12=connectorAOCompositionDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectorAOCompositionDeclaration12.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:158:4: moduleRequireDependencyDeclaration[$component]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration360);
                    moduleRequireDependencyDeclaration13=moduleRequireDependencyDeclaration(component);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration13.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 10, connectorBodyDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:162:1: connectorAOCompositionDeclaration returns [AOComposition element] : 'ao-composition' name= Identifier aoc= connectorAOCompositionBody ;
    public final MstageParser.connectorAOCompositionDeclaration_return connectorAOCompositionDeclaration() throws RecognitionException {
        MstageParser.connectorAOCompositionDeclaration_return retval = new MstageParser.connectorAOCompositionDeclaration_return();
        retval.start = input.LT(1);
        int connectorAOCompositionDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token string_literal14=null;
        MstageParser.connectorAOCompositionBody_return aoc = null;


        Object name_tree=null;
        Object string_literal14_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:163:2: ( 'ao-composition' name= Identifier aoc= connectorAOCompositionBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:163:4: 'ao-composition' name= Identifier aoc= connectorAOCompositionBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal14=(Token)match(input,31,FOLLOW_31_in_connectorAOCompositionDeclaration379); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal14_tree = (Object)adaptor.create(string_literal14);
            adaptor.addChild(root_0, string_literal14_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorAOCompositionDeclaration383); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration387);
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
            if ( state.backtracking>0 ) { memoize(input, 11, connectorAOCompositionDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:172:1: connectorAOCompositionBody returns [Pointcut pointcut, Advice advice] : '{' pc= pointcutDeclaration adv= adviceDeclaration '}' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:173:2: ( '{' pc= pointcutDeclaration adv= adviceDeclaration '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:173:4: '{' pc= pointcutDeclaration adv= adviceDeclaration '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal15=(Token)match(input,29,FOLLOW_29_in_connectorAOCompositionBody405); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal15_tree = (Object)adaptor.create(char_literal15);
            adaptor.addChild(root_0, char_literal15_tree);
            }
            pushFollow(FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody409);
            pc=pointcutDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pc.getTree());
            pushFollow(FOLLOW_adviceDeclaration_in_connectorAOCompositionBody413);
            adv=adviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, adv.getTree());
            char_literal16=(Token)match(input,30,FOLLOW_30_in_connectorAOCompositionBody415); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 12, connectorAOCompositionBody_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:185:1: pointcutDeclaration returns [Pointcut element] : 'pointcut' pointcutBody[$element] ;
    public final MstageParser.pointcutDeclaration_return pointcutDeclaration() throws RecognitionException {
        MstageParser.pointcutDeclaration_return retval = new MstageParser.pointcutDeclaration_return();
        retval.start = input.LT(1);
        int pointcutDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal17=null;
        MstageParser.pointcutBody_return pointcutBody18 = null;


        Object string_literal17_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:186:2: ( 'pointcut' pointcutBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:186:4: 'pointcut' pointcutBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            string_literal17=(Token)match(input,32,FOLLOW_32_in_pointcutDeclaration435); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal17_tree = (Object)adaptor.create(string_literal17);
            adaptor.addChild(root_0, string_literal17_tree);
            }
            pushFollow(FOLLOW_pointcutBody_in_pointcutDeclaration437);
            pointcutBody18=pointcutBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBody18.getTree());
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
            if ( state.backtracking>0 ) { memoize(input, 13, pointcutDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutDeclaration"

    public static class pointcutBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:192:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:193:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:193:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal19=(Token)match(input,29,FOLLOW_29_in_pointcutBody455); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:193:8: ( pointcutBodyDeclaration[$pointcut] )*
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
            	    pushFollow(FOLLOW_pointcutBodyDeclaration_in_pointcutBody457);
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

            char_literal21=(Token)match(input,30,FOLLOW_30_in_pointcutBody461); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 14, pointcutBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutBody"

    public static class pointcutBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:196:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] );
    public final MstageParser.pointcutBodyDeclaration_return pointcutBodyDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutBodyDeclaration_return retval = new MstageParser.pointcutBodyDeclaration_return();
        retval.start = input.LT(1);
        int pointcutBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.pointcutKindDeclaration_return pointcutKindDeclaration22 = null;

        MstageParser.pointcutSignatureDeclaration_return pointcutSignatureDeclaration23 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:197:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:197:4: pointcutKindDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration474);
                    pointcutKindDeclaration22=pointcutKindDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutKindDeclaration22.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:198:4: pointcutSignatureDeclaration[$pointcut]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration480);
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
            if ( state.backtracking>0 ) { memoize(input, 15, pointcutBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutBodyDeclaration"

    public static class pointcutKindDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutKindDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:203:1: pointcutKindDeclaration[Pointcut pointcut] : 'kind' ':' kind= joinpointKind ';' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:204:2: ( 'kind' ':' kind= joinpointKind ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:204:4: 'kind' ':' kind= joinpointKind ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal24=(Token)match(input,33,FOLLOW_33_in_pointcutKindDeclaration496); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal24_tree = (Object)adaptor.create(string_literal24);
            adaptor.addChild(root_0, string_literal24_tree);
            }
            char_literal25=(Token)match(input,34,FOLLOW_34_in_pointcutKindDeclaration498); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);
            }
            pushFollow(FOLLOW_joinpointKind_in_pointcutKindDeclaration502);
            kind=joinpointKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, kind.getTree());
            char_literal26=(Token)match(input,24,FOLLOW_24_in_pointcutKindDeclaration504); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal26_tree = (Object)adaptor.create(char_literal26);
            adaptor.addChild(root_0, char_literal26_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 16, pointcutKindDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutKindDeclaration"

    public static class pointcutSignatureDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutSignatureDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:209:1: pointcutSignatureDeclaration[Pointcut pointcut] : 'signature' ':' pattern= ( ( . )* ) ';' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:210:2: ( 'signature' ':' pattern= ( ( . )* ) ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:210:4: 'signature' ':' pattern= ( ( . )* ) ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal27=(Token)match(input,35,FOLLOW_35_in_pointcutSignatureDeclaration519); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal27_tree = (Object)adaptor.create(string_literal27);
            adaptor.addChild(root_0, string_literal27_tree);
            }
            char_literal28=(Token)match(input,34,FOLLOW_34_in_pointcutSignatureDeclaration521); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:210:28: ( ( . )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:210:29: ( . )*
            {
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:210:29: ( . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==24) ) {
                    int LA10_1 = input.LA(2);

                    if ( (synpred10_Mstage()) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>=Identifier && LA10_0<=23)||(LA10_0>=25 && LA10_0<=63)) ) {
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

            char_literal30=(Token)match(input,24,FOLLOW_24_in_pointcutSignatureDeclaration530); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal30_tree = (Object)adaptor.create(char_literal30);
            adaptor.addChild(root_0, char_literal30_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 17, pointcutSignatureDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutSignatureDeclaration"

    public static class pointcutCallerDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutCallerDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:223:1: pointcutCallerDeclaration[Pointcut pointcut] : 'caller' ;
    public final MstageParser.pointcutCallerDeclaration_return pointcutCallerDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutCallerDeclaration_return retval = new MstageParser.pointcutCallerDeclaration_return();
        retval.start = input.LT(1);
        int pointcutCallerDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal31=null;

        Object string_literal31_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:224:2: ( 'caller' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:224:4: 'caller'
            {
            root_0 = (Object)adaptor.nil();

            string_literal31=(Token)match(input,36,FOLLOW_36_in_pointcutCallerDeclaration550); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 18, pointcutCallerDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "pointcutCallerDeclaration"

    public static class pointcutCalleeDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointcutCalleeDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:227:1: pointcutCalleeDeclaration[Pointcut pointcut] : 'callee' ;
    public final MstageParser.pointcutCalleeDeclaration_return pointcutCalleeDeclaration(Pointcut pointcut) throws RecognitionException {
        MstageParser.pointcutCalleeDeclaration_return retval = new MstageParser.pointcutCalleeDeclaration_return();
        retval.start = input.LT(1);
        int pointcutCalleeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal32=null;

        Object string_literal32_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:228:2: ( 'callee' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:228:4: 'callee'
            {
            root_0 = (Object)adaptor.nil();

            string_literal32=(Token)match(input,37,FOLLOW_37_in_pointcutCalleeDeclaration563); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 19, pointcutCalleeDeclaration_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:232:1: adviceDeclaration returns [Advice element] : 'advice' adviceBody[$element] ;
    public final MstageParser.adviceDeclaration_return adviceDeclaration() throws RecognitionException {
        MstageParser.adviceDeclaration_return retval = new MstageParser.adviceDeclaration_return();
        retval.start = input.LT(1);
        int adviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal33=null;
        MstageParser.adviceBody_return adviceBody34 = null;


        Object string_literal33_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:233:2: ( 'advice' adviceBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:233:4: 'advice' adviceBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            string_literal33=(Token)match(input,38,FOLLOW_38_in_adviceDeclaration581); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal33_tree = (Object)adaptor.create(string_literal33);
            adaptor.addChild(root_0, string_literal33_tree);
            }
            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration583);
            adviceBody34=adviceBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBody34.getTree());
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
            if ( state.backtracking>0 ) { memoize(input, 20, adviceDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceDeclaration"

    public static class adviceBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:238:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:239:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:239:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal35=(Token)match(input,29,FOLLOW_29_in_adviceBody598); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal35_tree = (Object)adaptor.create(char_literal35);
            adaptor.addChild(root_0, char_literal35_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:239:8: ( adviceBodyDeclaration[$advice] )*
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
            	    pushFollow(FOLLOW_adviceBodyDeclaration_in_adviceBody600);
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

            char_literal37=(Token)match(input,30,FOLLOW_30_in_adviceBody604); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 21, adviceBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceBody"

    public static class adviceBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:242:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] );
    public final MstageParser.adviceBodyDeclaration_return adviceBodyDeclaration(Advice advice) throws RecognitionException {
        MstageParser.adviceBodyDeclaration_return retval = new MstageParser.adviceBodyDeclaration_return();
        retval.start = input.LT(1);
        int adviceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.adviceServiceDeclaration_return adviceServiceDeclaration38 = null;

        MstageParser.adviceTypeDeclaration_return adviceTypeDeclaration39 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:243:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:243:4: adviceServiceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration617);
                    adviceServiceDeclaration38=adviceServiceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceServiceDeclaration38.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:244:4: adviceTypeDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration623);
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
            if ( state.backtracking>0 ) { memoize(input, 22, adviceBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceBodyDeclaration"

    public static class adviceServiceDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceServiceDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:247:1: adviceServiceDeclaration[Advice advice] : 'service' ':' service= ( ( . )* ) ';' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:248:2: ( 'service' ':' service= ( ( . )* ) ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:248:4: 'service' ':' service= ( ( . )* ) ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal40=(Token)match(input,39,FOLLOW_39_in_adviceServiceDeclaration637); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal40_tree = (Object)adaptor.create(string_literal40);
            adaptor.addChild(root_0, string_literal40_tree);
            }
            char_literal41=(Token)match(input,34,FOLLOW_34_in_adviceServiceDeclaration639); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = (Object)adaptor.create(char_literal41);
            adaptor.addChild(root_0, char_literal41_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:248:26: ( ( . )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:248:27: ( . )*
            {
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:248:27: ( . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==24) ) {
                    int LA13_1 = input.LA(2);

                    if ( (synpred13_Mstage()) ) {
                        alt13=1;
                    }


                }
                else if ( ((LA13_0>=Identifier && LA13_0<=23)||(LA13_0>=25 && LA13_0<=63)) ) {
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

            char_literal43=(Token)match(input,24,FOLLOW_24_in_adviceServiceDeclaration648); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 23, adviceServiceDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceServiceDeclaration"

    public static class adviceTypeDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceTypeDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:253:1: adviceTypeDeclaration[Advice advice] : 'type' ':' advtype= adviceType ';' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:254:2: ( 'type' ':' advtype= adviceType ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:254:4: 'type' ':' advtype= adviceType ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal44=(Token)match(input,40,FOLLOW_40_in_adviceTypeDeclaration663); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal44_tree = (Object)adaptor.create(string_literal44);
            adaptor.addChild(root_0, string_literal44_tree);
            }
            char_literal45=(Token)match(input,34,FOLLOW_34_in_adviceTypeDeclaration665); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal45_tree = (Object)adaptor.create(char_literal45);
            adaptor.addChild(root_0, char_literal45_tree);
            }
            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration669);
            advtype=adviceType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, advtype.getTree());
            char_literal46=(Token)match(input,24,FOLLOW_24_in_adviceTypeDeclaration671); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal46_tree = (Object)adaptor.create(char_literal46);
            adaptor.addChild(root_0, char_literal46_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 24, adviceTypeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "adviceTypeDeclaration"

    public static class compositeDeclaration_return extends ParserRuleReturnScope {
        public Composite element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compositeDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:264:1: compositeDeclaration returns [Composite element] : 'composite' name= Identifier compositeBody[$element] ;
    public final MstageParser.compositeDeclaration_return compositeDeclaration() throws RecognitionException {
        MstageParser.compositeDeclaration_return retval = new MstageParser.compositeDeclaration_return();
        retval.start = input.LT(1);
        int compositeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token string_literal47=null;
        MstageParser.compositeBody_return compositeBody48 = null;


        Object name_tree=null;
        Object string_literal47_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:265:2: ( 'composite' name= Identifier compositeBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:265:4: 'composite' name= Identifier compositeBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            string_literal47=(Token)match(input,41,FOLLOW_41_in_compositeDeclaration695); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal47_tree = (Object)adaptor.create(string_literal47);
            adaptor.addChild(root_0, string_literal47_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_compositeDeclaration699); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.element = new Composite(new SimpleNameSignature((name!=null?name.getText():null)));
              			
            }
            pushFollow(FOLLOW_compositeBody_in_compositeDeclaration705);
            compositeBody48=compositeBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, compositeBody48.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, compositeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compositeDeclaration"

    public static class compositeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compositeBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:272:1: compositeBody[Composite element] : '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}' ;
    public final MstageParser.compositeBody_return compositeBody(Composite element) throws RecognitionException {
        MstageParser.compositeBody_return retval = new MstageParser.compositeBody_return();
        retval.start = input.LT(1);
        int compositeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal49=null;
        Token char_literal52=null;
        MstageParser.compositeBodyDeclaration_return compositeBodyDeclaration50 = null;

        MstageParser.componentBodyDeclaration_return componentBodyDeclaration51 = null;


        Object char_literal49_tree=null;
        Object char_literal52_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:273:2: ( '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:273:4: '{' ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal49=(Token)match(input,29,FOLLOW_29_in_compositeBody719); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal49_tree = (Object)adaptor.create(char_literal49);
            adaptor.addChild(root_0, char_literal49_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:273:8: ( compositeBodyDeclaration[$element] | componentBodyDeclaration[$element] )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==42) ) {
                    alt14=1;
                }
                else if ( ((LA14_0>=44 && LA14_0<=45)) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:273:9: compositeBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_compositeBodyDeclaration_in_compositeBody722);
            	    compositeBodyDeclaration50=compositeBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compositeBodyDeclaration50.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:273:46: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_compositeBody727);
            	    componentBodyDeclaration51=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration51.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            char_literal52=(Token)match(input,30,FOLLOW_30_in_compositeBody732); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 26, compositeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compositeBody"

    public static class compositeBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compositeBodyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:277:1: compositeBodyDeclaration[Composite element] : 'contain' conts= compositeContainBody ;
    public final MstageParser.compositeBodyDeclaration_return compositeBodyDeclaration(Composite element) throws RecognitionException {
        MstageParser.compositeBodyDeclaration_return retval = new MstageParser.compositeBodyDeclaration_return();
        retval.start = input.LT(1);
        int compositeBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal53=null;
        MstageParser.compositeContainBody_return conts = null;


        Object string_literal53_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:278:2: ( 'contain' conts= compositeContainBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:278:4: 'contain' conts= compositeContainBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal53=(Token)match(input,42,FOLLOW_42_in_compositeBodyDeclaration745); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal53_tree = (Object)adaptor.create(string_literal53);
            adaptor.addChild(root_0, string_literal53_tree);
            }
            pushFollow(FOLLOW_compositeContainBody_in_compositeBodyDeclaration749);
            conts=compositeContainBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, conts.getTree());
            if ( state.backtracking==0 ) {

              			for(SimpleReference module : (conts!=null?conts.elements:null)) {
              				element.addSubmodules(module);
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
            if ( state.backtracking>0 ) { memoize(input, 27, compositeBodyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compositeBodyDeclaration"

    public static class compositeContainBody_return extends ParserRuleReturnScope {
        public List<SimpleReference> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compositeContainBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:285:1: compositeContainBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}' ;
    public final MstageParser.compositeContainBody_return compositeContainBody() throws RecognitionException {
        MstageParser.compositeContainBody_return retval = new MstageParser.compositeContainBody_return();
        retval.start = input.LT(1);
        int compositeContainBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal54=null;
        Token char_literal55=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal54_tree=null;
        Object char_literal55_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:287:2: ( '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:287:4: '{' (decls= commaSeparatedBodyDecls[Module.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal54=(Token)match(input,29,FOLLOW_29_in_compositeContainBody770); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal54_tree = (Object)adaptor.create(char_literal54);
            adaptor.addChild(root_0, char_literal54_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:287:8: (decls= commaSeparatedBodyDecls[Module.class] )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==Identifier) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:287:9: decls= commaSeparatedBodyDecls[Module.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_compositeContainBody775);
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

            char_literal55=(Token)match(input,30,FOLLOW_30_in_compositeContainBody783); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 28, compositeContainBody_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:300:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier componentBody[$element] ;
    public final MstageParser.componentDeclaration_return componentDeclaration() throws RecognitionException {
        MstageParser.componentDeclaration_return retval = new MstageParser.componentDeclaration_return();
        retval.start = input.LT(1);
        int componentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token compkw=null;
        Token name=null;
        MstageParser.componentBody_return componentBody56 = null;


        Object compkw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:301:2: (compkw= 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:301:5: compkw= 'component' name= Identifier componentBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            compkw=(Token)match(input,43,FOLLOW_43_in_componentDeclaration813); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            compkw_tree = (Object)adaptor.create(compkw);
            adaptor.addChild(root_0, compkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration817); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                  			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                  			setKeyword(retval.element,compkw);
                  			setLocation(retval.element,name,"__NAME");
              			
            }
            pushFollow(FOLLOW_componentBody_in_componentDeclaration821);
            componentBody56=componentBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBody56.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, componentDeclaration_StartIndex); }
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

        Token char_literal57=null;
        Token char_literal59=null;
        MstageParser.componentBodyDeclaration_return componentBodyDeclaration58 = null;


        Object char_literal57_tree=null;
        Object char_literal59_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:310:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:310:4: '{' ( componentBodyDeclaration[$element] )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal57=(Token)match(input,29,FOLLOW_29_in_componentBody843); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal57_tree = (Object)adaptor.create(char_literal57);
            adaptor.addChild(root_0, char_literal57_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:310:8: ( componentBodyDeclaration[$element] )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=44 && LA16_0<=45)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: componentBodyDeclaration[$element]
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody845);
            	    componentBodyDeclaration58=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration58.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            char_literal59=(Token)match(input,30,FOLLOW_30_in_componentBody849); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal59_tree = (Object)adaptor.create(char_literal59);
            adaptor.addChild(root_0, char_literal59_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, componentBody_StartIndex); }
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

        MstageParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration60 = null;

        MstageParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration61 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:315:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==44) ) {
                alt17=1;
            }
            else if ( (LA17_0==45) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:315:4: moduleRequireDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration867);
                    moduleRequireDependencyDeclaration60=moduleRequireDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration60.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:316:4: moduleProvideDependencyDeclaration[$element]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration873);
                    moduleProvideDependencyDeclaration61=moduleProvideDependencyDeclaration(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleProvideDependencyDeclaration61.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 31, componentBodyDeclaration_StartIndex); }
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

        Token char_literal62=null;
        Token char_literal63=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object char_literal62_tree=null;
        Object char_literal63_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:331:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:331:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal62=(Token)match(input,29,FOLLOW_29_in_moduleDependencyBody904); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal62_tree = (Object)adaptor.create(char_literal62);
            adaptor.addChild(root_0, char_literal62_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:331:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==Identifier) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:331:9: decls= commaSeparatedBodyDecls[Interface.class]
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody909);
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

            char_literal63=(Token)match(input,30,FOLLOW_30_in_moduleDependencyBody917); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal63_tree = (Object)adaptor.create(char_literal63);
            adaptor.addChild(root_0, char_literal63_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, moduleDependencyBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "moduleDependencyBody"

    public static class moduleRequireDependencyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleRequireDependencyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:2: moduleRequireDependencyDeclaration[Module element] : 'require' rd= moduleDependencyBody ;
    public final MstageParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration(Module element) throws RecognitionException {
        MstageParser.moduleRequireDependencyDeclaration_return retval = new MstageParser.moduleRequireDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleRequireDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal64=null;
        MstageParser.moduleDependencyBody_return rd = null;


        Object string_literal64_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:336:2: ( 'require' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:336:4: 'require' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal64=(Token)match(input,44,FOLLOW_44_in_moduleRequireDependencyDeclaration933); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal64_tree = (Object)adaptor.create(string_literal64);
            adaptor.addChild(root_0, string_literal64_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration937);
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
            if ( state.backtracking>0 ) { memoize(input, 33, moduleRequireDependencyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "moduleRequireDependencyDeclaration"

    public static class moduleProvideDependencyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleProvideDependencyDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:344:2: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
    public final MstageParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration(Module element) throws RecognitionException {
        MstageParser.moduleProvideDependencyDeclaration_return retval = new MstageParser.moduleProvideDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleProvideDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal65=null;
        MstageParser.moduleDependencyBody_return rd = null;


        Object string_literal65_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:345:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:345:4: 'provide' rd= moduleDependencyBody
            {
            root_0 = (Object)adaptor.nil();

            string_literal65=(Token)match(input,45,FOLLOW_45_in_moduleProvideDependencyDeclaration953); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal65_tree = (Object)adaptor.create(string_literal65);
            adaptor.addChild(root_0, string_literal65_tree);
            }
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration957);
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
            if ( state.backtracking>0 ) { memoize(input, 34, moduleProvideDependencyDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "moduleProvideDependencyDeclaration"

    public static class commaSeparatedBodyDecls_return extends ParserRuleReturnScope {
        public List<SimpleReference> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "commaSeparatedBodyDecls"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:357:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
    public final MstageParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls(Class targetType) throws RecognitionException {
        MstageParser.commaSeparatedBodyDecls_return retval = new MstageParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);
        int commaSeparatedBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token char_literal66=null;
        MstageParser.commaSeparatedBodyDecls_return decls = null;


        Object id_tree=null;
        Object char_literal66_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:358:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:358:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls982); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:358:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:358:19: ',' decls= commaSeparatedBodyDecls[$targetType]
                    {
                    char_literal66=(Token)match(input,27,FOLLOW_27_in_commaSeparatedBodyDecls985); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal66_tree = (Object)adaptor.create(char_literal66);
                    adaptor.addChild(root_0, char_literal66_tree);
                    }
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls989);
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

              			
              			if (retval.elements == null) {
              				retval.elements = new ArrayList<SimpleReference>();
              			}
              			
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
            if ( state.backtracking>0 ) { memoize(input, 35, commaSeparatedBodyDecls_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:377:1: adviceType returns [AdviceType element] : ( 'before' | 'after' | 'around' );
    public final MstageParser.adviceType_return adviceType() throws RecognitionException {
        MstageParser.adviceType_return retval = new MstageParser.adviceType_return();
        retval.start = input.LT(1);
        int adviceType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal67=null;
        Token string_literal68=null;
        Token string_literal69=null;

        Object string_literal67_tree=null;
        Object string_literal68_tree=null;
        Object string_literal69_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:378:2: ( 'before' | 'after' | 'around' )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt20=1;
                }
                break;
            case 47:
                {
                alt20=2;
                }
                break;
            case 48:
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:378:4: 'before'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal67=(Token)match(input,46,FOLLOW_46_in_adviceType1022); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal67_tree = (Object)adaptor.create(string_literal67);
                    adaptor.addChild(root_0, string_literal67_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = AdviceType.BEFORE;
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:379:4: 'after'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal68=(Token)match(input,47,FOLLOW_47_in_adviceType1029); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal68_tree = (Object)adaptor.create(string_literal68);
                    adaptor.addChild(root_0, string_literal68_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = AdviceType.AFTER;
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:380:4: 'around'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal69=(Token)match(input,48,FOLLOW_48_in_adviceType1036); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal69_tree = (Object)adaptor.create(string_literal69);
                    adaptor.addChild(root_0, string_literal69_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 36, adviceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:383:1: joinpointKind returns [JoinpointKind element] : ( 'execution' | 'call' );
    public final MstageParser.joinpointKind_return joinpointKind() throws RecognitionException {
        MstageParser.joinpointKind_return retval = new MstageParser.joinpointKind_return();
        retval.start = input.LT(1);
        int joinpointKind_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal70=null;
        Token string_literal71=null;

        Object string_literal70_tree=null;
        Object string_literal71_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:384:2: ( 'execution' | 'call' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==49) ) {
                alt21=1;
            }
            else if ( (LA21_0==50) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:384:4: 'execution'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal70=(Token)match(input,49,FOLLOW_49_in_joinpointKind1054); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal70_tree = (Object)adaptor.create(string_literal70);
                    adaptor.addChild(root_0, string_literal70_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = JoinpointKind.EXECUTION;
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:385:4: 'call'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal71=(Token)match(input,50,FOLLOW_50_in_joinpointKind1061); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal71_tree = (Object)adaptor.create(string_literal71);
                    adaptor.addChild(root_0, string_literal71_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 37, joinpointKind_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:388:1: voidType returns [TypeReference element] : 'void' ;
    public final MstageParser.voidType_return voidType() throws RecognitionException {
        MstageParser.voidType_return retval = new MstageParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal72=null;

        Object string_literal72_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:390:7: ( 'void' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:390:10: 'void'
            {
            root_0 = (Object)adaptor.nil();

            string_literal72=(Token)match(input,51,FOLLOW_51_in_voidType1087); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal72_tree = (Object)adaptor.create(string_literal72);
            adaptor.addChild(root_0, string_literal72_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 38, voidType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:394:1: type returns [TypeReference element] : (cd= classOrInterfaceType | pt= primitiveType );
    public final MstageParser.type_return type() throws RecognitionException {
        MstageParser.type_return retval = new MstageParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.classOrInterfaceType_return cd = null;

        MstageParser.primitiveType_return pt = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:396:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Identifier) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=53 && LA22_0<=60)) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:396:4: cd= classOrInterfaceType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_classOrInterfaceType_in_type1114);
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:397:4: pt= primitiveType
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveType_in_type1123);
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
            if ( state.backtracking>0 ) { memoize(input, 39, type_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:401:1: classOrInterfaceType returns [TypeReference element] : name= Identifier ( '.' namex= Identifier )* ;
    public final MstageParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MstageParser.classOrInterfaceType_return retval = new MstageParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
        Token char_literal73=null;

        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal73_tree=null;

        NamespaceOrTypeReference target = null;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:403:2: (name= Identifier ( '.' namex= Identifier )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:403:4: name= Identifier ( '.' namex= Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType1148); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new BasicTypeReference((name!=null?name.getText():null)); 
              	           target =  new NamespaceOrTypeReference((name!=null?name.getText():null)); 
              	          
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:408:10: ( '.' namex= Identifier )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==52) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:408:11: '.' namex= Identifier
            	    {
            	    char_literal73=(Token)match(input,52,FOLLOW_52_in_classOrInterfaceType1175); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal73_tree = (Object)adaptor.create(char_literal73);
            	    adaptor.addChild(root_0, char_literal73_tree);
            	    }
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType1179); if (state.failed) return retval;
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

            	    }
            	    break;

            	default :
            	    break loop23;
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
            if ( state.backtracking>0 ) { memoize(input, 40, classOrInterfaceType_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:423:1: primitiveType returns [TypeReference element] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final MstageParser.primitiveType_return primitiveType() throws RecognitionException {
        MstageParser.primitiveType_return retval = new MstageParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal74=null;
        Token string_literal75=null;
        Token string_literal76=null;
        Token string_literal77=null;
        Token string_literal78=null;
        Token string_literal79=null;
        Token string_literal80=null;
        Token string_literal81=null;

        Object string_literal74_tree=null;
        Object string_literal75_tree=null;
        Object string_literal76_tree=null;
        Object string_literal77_tree=null;
        Object string_literal78_tree=null;
        Object string_literal79_tree=null;
        Object string_literal80_tree=null;
        Object string_literal81_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:424:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt24=8;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt24=1;
                }
                break;
            case 54:
                {
                alt24=2;
                }
                break;
            case 55:
                {
                alt24=3;
                }
                break;
            case 56:
                {
                alt24=4;
                }
                break;
            case 57:
                {
                alt24=5;
                }
                break;
            case 58:
                {
                alt24=6;
                }
                break;
            case 59:
                {
                alt24=7;
                }
                break;
            case 60:
                {
                alt24=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:424:9: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal74=(Token)match(input,53,FOLLOW_53_in_primitiveType1228); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal74_tree = (Object)adaptor.create(string_literal74);
                    adaptor.addChild(root_0, string_literal74_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:425:9: 'char'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal75=(Token)match(input,54,FOLLOW_54_in_primitiveType1240); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal75_tree = (Object)adaptor.create(string_literal75);
                    adaptor.addChild(root_0, string_literal75_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("char");
                    }

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:426:9: 'byte'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal76=(Token)match(input,55,FOLLOW_55_in_primitiveType1252); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal76_tree = (Object)adaptor.create(string_literal76);
                    adaptor.addChild(root_0, string_literal76_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("byte");
                    }

                    }
                    break;
                case 4 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:427:9: 'short'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal77=(Token)match(input,56,FOLLOW_56_in_primitiveType1264); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal77_tree = (Object)adaptor.create(string_literal77);
                    adaptor.addChild(root_0, string_literal77_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("short");
                    }

                    }
                    break;
                case 5 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:428:9: 'int'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal78=(Token)match(input,57,FOLLOW_57_in_primitiveType1276); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal78_tree = (Object)adaptor.create(string_literal78);
                    adaptor.addChild(root_0, string_literal78_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("int");
                    }

                    }
                    break;
                case 6 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:429:9: 'long'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal79=(Token)match(input,58,FOLLOW_58_in_primitiveType1288); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal79_tree = (Object)adaptor.create(string_literal79);
                    adaptor.addChild(root_0, string_literal79_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("long");
                    }

                    }
                    break;
                case 7 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:430:9: 'float'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal80=(Token)match(input,59,FOLLOW_59_in_primitiveType1300); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal80_tree = (Object)adaptor.create(string_literal80);
                    adaptor.addChild(root_0, string_literal80_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.element = new BasicTypeReference("float");
                    }

                    }
                    break;
                case 8 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:431:9: 'double'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal81=(Token)match(input,60,FOLLOW_60_in_primitiveType1312); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal81_tree = (Object)adaptor.create(string_literal81);
                    adaptor.addChild(root_0, string_literal81_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 41, primitiveType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primitiveType"

    public static class annotations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotations"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:437:1: annotations : ( annotation )+ ;
    public final MstageParser.annotations_return annotations() throws RecognitionException {
        MstageParser.annotations_return retval = new MstageParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation82 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:438:5: ( ( annotation )+ )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:438:9: ( annotation )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:438:9: ( annotation )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==61) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations1336);
            	    annotation82=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation82.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
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
            if ( state.backtracking>0 ) { memoize(input, 42, annotations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotations"

    public static class annotation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotation"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:441:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final MstageParser.annotation_return annotation() throws RecognitionException {
        MstageParser.annotation_return retval = new MstageParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal83=null;
        Token char_literal85=null;
        Token char_literal88=null;
        MstageParser.annotationName_return annotationName84 = null;

        MstageParser.elementValuePairs_return elementValuePairs86 = null;

        MstageParser.elementValue_return elementValue87 = null;


        Object char_literal83_tree=null;
        Object char_literal85_tree=null;
        Object char_literal88_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:442:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:442:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            char_literal83=(Token)match(input,61,FOLLOW_61_in_annotation1356); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal83_tree = (Object)adaptor.create(char_literal83);
            adaptor.addChild(root_0, char_literal83_tree);
            }
            pushFollow(FOLLOW_annotationName_in_annotation1358);
            annotationName84=annotationName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName84.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:442:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==25) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:442:30: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    char_literal85=(Token)match(input,25,FOLLOW_25_in_annotation1362); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal85_tree = (Object)adaptor.create(char_literal85);
                    adaptor.addChild(root_0, char_literal85_tree);
                    }
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:442:34: ( elementValuePairs | elementValue )?
                    int alt26=3;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==Identifier) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==29||LA26_0==61) ) {
                        alt26=2;
                    }
                    switch (alt26) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:442:36: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation1366);
                            elementValuePairs86=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs86.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:442:56: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation1370);
                            elementValue87=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue87.getTree());

                            }
                            break;

                    }

                    char_literal88=(Token)match(input,26,FOLLOW_26_in_annotation1375); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal88_tree = (Object)adaptor.create(char_literal88);
                    adaptor.addChild(root_0, char_literal88_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 43, annotation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotation"

    public static class annotationName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationName"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:445:1: annotationName : Identifier ( '.' Identifier )* ;
    public final MstageParser.annotationName_return annotationName() throws RecognitionException {
        MstageParser.annotationName_return retval = new MstageParser.annotationName_return();
        retval.start = input.LT(1);
        int annotationName_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier89=null;
        Token char_literal90=null;
        Token Identifier91=null;

        Object Identifier89_tree=null;
        Object char_literal90_tree=null;
        Object Identifier91_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:446:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:446:7: Identifier ( '.' Identifier )*
            {
            root_0 = (Object)adaptor.nil();

            Identifier89=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName1399); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier89_tree = (Object)adaptor.create(Identifier89);
            adaptor.addChild(root_0, Identifier89_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:446:18: ( '.' Identifier )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==52) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:446:19: '.' Identifier
            	    {
            	    char_literal90=(Token)match(input,52,FOLLOW_52_in_annotationName1402); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal90_tree = (Object)adaptor.create(char_literal90);
            	    adaptor.addChild(root_0, char_literal90_tree);
            	    }
            	    Identifier91=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName1404); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier91_tree = (Object)adaptor.create(Identifier91);
            	    adaptor.addChild(root_0, Identifier91_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 44, annotationName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationName"

    public static class elementValuePairs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePairs"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:449:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final MstageParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MstageParser.elementValuePairs_return retval = new MstageParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal93=null;
        MstageParser.elementValuePair_return elementValuePair92 = null;

        MstageParser.elementValuePair_return elementValuePair94 = null;


        Object char_literal93_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:450:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:450:9: elementValuePair ( ',' elementValuePair )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs1425);
            elementValuePair92=elementValuePair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair92.getTree());
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:450:26: ( ',' elementValuePair )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==27) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:450:27: ',' elementValuePair
            	    {
            	    char_literal93=(Token)match(input,27,FOLLOW_27_in_elementValuePairs1428); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal93_tree = (Object)adaptor.create(char_literal93);
            	    adaptor.addChild(root_0, char_literal93_tree);
            	    }
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs1430);
            	    elementValuePair94=elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair94.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
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
            if ( state.backtracking>0 ) { memoize(input, 45, elementValuePairs_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePairs"

    public static class elementValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePair"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:453:1: elementValuePair : Identifier '=' elementValue ;
    public final MstageParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MstageParser.elementValuePair_return retval = new MstageParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier95=null;
        Token char_literal96=null;
        MstageParser.elementValue_return elementValue97 = null;


        Object Identifier95_tree=null;
        Object char_literal96_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:454:5: ( Identifier '=' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:454:9: Identifier '=' elementValue
            {
            root_0 = (Object)adaptor.nil();

            Identifier95=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair1451); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier95_tree = (Object)adaptor.create(Identifier95);
            adaptor.addChild(root_0, Identifier95_tree);
            }
            char_literal96=(Token)match(input,62,FOLLOW_62_in_elementValuePair1453); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal96_tree = (Object)adaptor.create(char_literal96);
            adaptor.addChild(root_0, char_literal96_tree);
            }
            pushFollow(FOLLOW_elementValue_in_elementValuePair1455);
            elementValue97=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue97.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, elementValuePair_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValuePair"

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:457:1: elementValue : ( annotation | elementValueArrayInitializer );
    public final MstageParser.elementValue_return elementValue() throws RecognitionException {
        MstageParser.elementValue_return retval = new MstageParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotation_return annotation98 = null;

        MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer99 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:458:5: ( annotation | elementValueArrayInitializer )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==61) ) {
                alt30=1;
            }
            else if ( (LA30_0==29) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:458:9: annotation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotation_in_elementValue1478);
                    annotation98=annotation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation98.getTree());

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:459:9: elementValueArrayInitializer
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue1488);
                    elementValueArrayInitializer99=elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValueArrayInitializer99.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 47, elementValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "elementValue"

    public static class elementValueArrayInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValueArrayInitializer"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:462:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final MstageParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MstageParser.elementValueArrayInitializer_return retval = new MstageParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal100=null;
        Token char_literal102=null;
        Token char_literal104=null;
        Token char_literal105=null;
        MstageParser.elementValue_return elementValue101 = null;

        MstageParser.elementValue_return elementValue103 = null;


        Object char_literal100_tree=null;
        Object char_literal102_tree=null;
        Object char_literal104_tree=null;
        Object char_literal105_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:463:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:463:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal100=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer1511); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal100_tree = (Object)adaptor.create(char_literal100);
            adaptor.addChild(root_0, char_literal100_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:463:13: ( elementValue ( ',' elementValue )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==29||LA32_0==61) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:463:14: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer1514);
                    elementValue101=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue101.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:463:27: ( ',' elementValue )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==27) ) {
                            int LA31_1 = input.LA(2);

                            if ( (LA31_1==29||LA31_1==61) ) {
                                alt31=1;
                            }


                        }


                        switch (alt31) {
                    	case 1 :
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:463:28: ',' elementValue
                    	    {
                    	    char_literal102=(Token)match(input,27,FOLLOW_27_in_elementValueArrayInitializer1517); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal102_tree = (Object)adaptor.create(char_literal102);
                    	    adaptor.addChild(root_0, char_literal102_tree);
                    	    }
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer1519);
                    	    elementValue103=elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue103.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:463:49: ( ',' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==27) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:463:50: ','
                    {
                    char_literal104=(Token)match(input,27,FOLLOW_27_in_elementValueArrayInitializer1526); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal104_tree = (Object)adaptor.create(char_literal104);
                    adaptor.addChild(root_0, char_literal104_tree);
                    }

                    }
                    break;

            }

            char_literal105=(Token)match(input,30,FOLLOW_30_in_elementValueArrayInitializer1530); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal105_tree = (Object)adaptor.create(char_literal105);
            adaptor.addChild(root_0, char_literal105_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 48, elementValueArrayInitializer_StartIndex); }
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
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:466:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
    public final MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MstageParser.annotationTypeDeclaration_return retval = new MstageParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token char_literal106=null;
        Token string_literal107=null;
        MstageParser.annotationTypeBody_return annotationTypeBody108 = null;


        Object name_tree=null;
        Object char_literal106_tree=null;
        Object string_literal107_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:467:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:467:9: '@' 'interface' name= Identifier annotationTypeBody
            {
            root_0 = (Object)adaptor.nil();

            char_literal106=(Token)match(input,61,FOLLOW_61_in_annotationTypeDeclaration1557); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal106_tree = (Object)adaptor.create(char_literal106);
            adaptor.addChild(root_0, char_literal106_tree);
            }
            string_literal107=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration1559); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal107_tree = (Object)adaptor.create(string_literal107);
            adaptor.addChild(root_0, string_literal107_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration1563); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration1565);
            annotationTypeBody108=annotationTypeBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeBody108.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, annotationTypeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeDeclaration"

    public static class annotationTypeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeBody"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:470:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final MstageParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MstageParser.annotationTypeBody_return retval = new MstageParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal109=null;
        Token char_literal111=null;
        MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration110 = null;


        Object char_literal109_tree=null;
        Object char_literal111_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:471:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:471:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal109=(Token)match(input,29,FOLLOW_29_in_annotationTypeBody1588); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal109_tree = (Object)adaptor.create(char_literal109);
            adaptor.addChild(root_0, char_literal109_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:471:13: ( annotationTypeElementDeclaration )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==Identifier||(LA34_0>=53 && LA34_0<=61)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:471:14: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody1591);
            	    annotationTypeElementDeclaration110=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration110.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            char_literal111=(Token)match(input,30,FOLLOW_30_in_annotationTypeBody1595); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 50, annotationTypeBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeBody"

    public static class annotationTypeElementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementDeclaration"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:474:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
    public final MstageParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MstageParser.annotationTypeElementDeclaration_return retval = new MstageParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationTypeElementRest_return annotationTypeElementRest112 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:475:5: ( annotationTypeElementRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:475:23: annotationTypeElementRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration1620);
            annotationTypeElementRest112=annotationTypeElementRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementRest112.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, annotationTypeElementDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementDeclaration"

    public static class annotationTypeElementRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:478:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
    public final MstageParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MstageParser.annotationTypeElementRest_return retval = new MstageParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal115=null;
        Token char_literal117=null;
        MstageParser.type_return type113 = null;

        MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest114 = null;

        MstageParser.annotationTypeDeclaration_return annotationTypeDeclaration116 = null;


        Object char_literal115_tree=null;
        Object char_literal117_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:479:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==Identifier||(LA36_0>=53 && LA36_0<=60)) ) {
                alt36=1;
            }
            else if ( (LA36_0==61) ) {
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:479:9: type annotationMethodOrConstantRest ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_in_annotationTypeElementRest1643);
                    type113=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type113.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest1645);
                    annotationMethodOrConstantRest114=annotationMethodOrConstantRest();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest114.getTree());
                    char_literal115=(Token)match(input,24,FOLLOW_24_in_annotationTypeElementRest1647); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal115_tree = (Object)adaptor.create(char_literal115);
                    adaptor.addChild(root_0, char_literal115_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:480:9: annotationTypeDeclaration ( ';' )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest1657);
                    annotationTypeDeclaration116=annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration116.getTree());
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:480:35: ( ';' )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==24) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: ';'
                            {
                            char_literal117=(Token)match(input,24,FOLLOW_24_in_annotationTypeElementRest1659); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal117_tree = (Object)adaptor.create(char_literal117);
                            adaptor.addChild(root_0, char_literal117_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 52, annotationTypeElementRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementRest"

    public static class annotationMethodOrConstantRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodOrConstantRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:483:1: annotationMethodOrConstantRest : annotationMethodRest ;
    public final MstageParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MstageParser.annotationMethodOrConstantRest_return retval = new MstageParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

        MstageParser.annotationMethodRest_return annotationMethodRest118 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:484:5: ( annotationMethodRest )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:484:9: annotationMethodRest
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest1683);
            annotationMethodRest118=annotationMethodRest();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodRest118.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, annotationMethodOrConstantRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodOrConstantRest"

    public static class annotationMethodRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodRest"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:487:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
    public final MstageParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MstageParser.annotationMethodRest_return retval = new MstageParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

        Token Identifier119=null;
        Token char_literal120=null;
        Token char_literal121=null;
        MstageParser.defaultValue_return defaultValue122 = null;


        Object Identifier119_tree=null;
        Object char_literal120_tree=null;
        Object char_literal121_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:488:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:488:9: Identifier '(' ')' ( defaultValue )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier119=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest1706); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier119_tree = (Object)adaptor.create(Identifier119);
            adaptor.addChild(root_0, Identifier119_tree);
            }
            char_literal120=(Token)match(input,25,FOLLOW_25_in_annotationMethodRest1708); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal120_tree = (Object)adaptor.create(char_literal120);
            adaptor.addChild(root_0, char_literal120_tree);
            }
            char_literal121=(Token)match(input,26,FOLLOW_26_in_annotationMethodRest1710); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal121_tree = (Object)adaptor.create(char_literal121);
            adaptor.addChild(root_0, char_literal121_tree);
            }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:488:28: ( defaultValue )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==63) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:0:0: defaultValue
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest1712);
                    defaultValue122=defaultValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defaultValue122.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 54, annotationMethodRest_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "annotationMethodRest"

    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultValue"
    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:491:1: defaultValue : 'default' elementValue ;
    public final MstageParser.defaultValue_return defaultValue() throws RecognitionException {
        MstageParser.defaultValue_return retval = new MstageParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal123=null;
        MstageParser.elementValue_return elementValue124 = null;


        Object string_literal123_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:492:5: ( 'default' elementValue )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:492:9: 'default' elementValue
            {
            root_0 = (Object)adaptor.nil();

            string_literal123=(Token)match(input,63,FOLLOW_63_in_defaultValue1740); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal123_tree = (Object)adaptor.create(string_literal123);
            adaptor.addChild(root_0, string_literal123_tree);
            }
            pushFollow(FOLLOW_elementValue_in_defaultValue1742);
            elementValue124=elementValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue124.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, defaultValue_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // $ANTLR start synpred10_Mstage
    public final void synpred10_Mstage_fragment() throws RecognitionException {   
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:210:29: ( . )
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:210:29: .
        {
        matchAny(input); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_Mstage

    // $ANTLR start synpred13_Mstage
    public final void synpred13_Mstage_fragment() throws RecognitionException {   
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:248:27: ( . )
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:248:27: .
        {
        matchAny(input); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_Mstage

    // Delegated rules

    public final boolean synpred10_Mstage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_Mstage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_Mstage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_Mstage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration122 = new BitSet(new long[]{0x1FE8000000000010L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBody145 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_interfaceBody146 = new BitSet(new long[]{0x1FE8000000000012L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceDeclaration167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_serviceDeclaration171 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceDeclaration175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_formalParameters230 = new BitSet(new long[]{0x1FE8000004000010L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters235 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_formalParameters241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls266 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls270 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_formalParameterDecls273 = new BitSet(new long[]{0x1FE8000000000010L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_connectorDeclaration312 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration316 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_connectorBody334 = new BitSet(new long[]{0x00001000C0000000L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody337 = new BitSet(new long[]{0x00001000C0000000L});
    public static final BitSet FOLLOW_30_in_connectorBody342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorAOCompositionDeclaration_in_connectorBodyDeclaration355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_connectorAOCompositionDeclaration379 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorAOCompositionDeclaration383 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_connectorAOCompositionBody_in_connectorAOCompositionDeclaration387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_connectorAOCompositionBody405 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_connectorAOCompositionBody409 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_connectorAOCompositionBody413 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_connectorAOCompositionBody415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_pointcutDeclaration435 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_pointcutBody455 = new BitSet(new long[]{0x0000000A40000000L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody457 = new BitSet(new long[]{0x0000000A40000000L});
    public static final BitSet FOLLOW_30_in_pointcutBody461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pointcutKindDeclaration496 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutKindDeclaration498 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_joinpointKind_in_pointcutKindDeclaration502 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_pointcutKindDeclaration504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_pointcutSignatureDeclaration519 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pointcutSignatureDeclaration521 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L});
    public static final BitSet FOLLOW_24_in_pointcutSignatureDeclaration530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_pointcutCallerDeclaration550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_pointcutCalleeDeclaration563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_adviceDeclaration581 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_adviceBody598 = new BitSet(new long[]{0x0000018040000000L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody600 = new BitSet(new long[]{0x0000018040000000L});
    public static final BitSet FOLLOW_30_in_adviceBody604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_adviceServiceDeclaration637 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceServiceDeclaration639 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L});
    public static final BitSet FOLLOW_24_in_adviceServiceDeclaration648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_adviceTypeDeclaration663 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_adviceTypeDeclaration665 = new BitSet(new long[]{0x0001C00000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration669 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_adviceTypeDeclaration671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_compositeDeclaration695 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_compositeDeclaration699 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_compositeBody_in_compositeDeclaration705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_compositeBody719 = new BitSet(new long[]{0x00003400C0000000L});
    public static final BitSet FOLLOW_compositeBodyDeclaration_in_compositeBody722 = new BitSet(new long[]{0x00003400C0000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_compositeBody727 = new BitSet(new long[]{0x00003400C0000000L});
    public static final BitSet FOLLOW_30_in_compositeBody732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_compositeBodyDeclaration745 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_compositeContainBody_in_compositeBodyDeclaration749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_compositeContainBody770 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_compositeContainBody775 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_compositeContainBody783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_componentDeclaration813 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration817 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_componentBody843 = new BitSet(new long[]{0x00003400C0000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody845 = new BitSet(new long[]{0x00003400C0000000L});
    public static final BitSet FOLLOW_30_in_componentBody849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_moduleDependencyBody904 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody909 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_moduleDependencyBody917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_moduleRequireDependencyDeclaration933 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_moduleProvideDependencyDeclaration953 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls982 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_commaSeparatedBodyDecls985 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_adviceType1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_adviceType1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_adviceType1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_joinpointKind1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_joinpointKind1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_voidType1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType1148 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_classOrInterfaceType1175 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType1179 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_53_in_primitiveType1228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_primitiveType1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_primitiveType1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_primitiveType1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_primitiveType1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_primitiveType1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_primitiveType1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_primitiveType1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations1336 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_annotation1356 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation1358 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_annotation1362 = new BitSet(new long[]{0x2000000024000010L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation1366 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation1370 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotation1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName1399 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_annotationName1402 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName1404 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs1425 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_elementValuePairs1428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs1430 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair1451 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_elementValuePair1453 = new BitSet(new long[]{0x2000000020000000L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer1511 = new BitSet(new long[]{0x2000000068000000L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer1514 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_27_in_elementValueArrayInitializer1517 = new BitSet(new long[]{0x2000000020000000L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer1519 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_27_in_elementValueArrayInitializer1526 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_elementValueArrayInitializer1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_annotationTypeDeclaration1557 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration1559 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration1563 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_annotationTypeBody1588 = new BitSet(new long[]{0x3FE8000040000010L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody1591 = new BitSet(new long[]{0x3FE8000040000010L});
    public static final BitSet FOLLOW_30_in_annotationTypeBody1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest1643 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest1645 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_annotationTypeElementRest1647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest1657 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeElementRest1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest1683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest1706 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_annotationMethodRest1708 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationMethodRest1710 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest1712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_defaultValue1740 = new BitSet(new long[]{0x2000000020000000L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue1742 = new BitSet(new long[]{0x0000000000000002L});

}
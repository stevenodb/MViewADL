<<<<<<< local
// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g 2013-02-05 15:15:33
=======
// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/marko/hg/mview/src/mview/parser/MView.g 2012-10-12 22:28:43
>>>>>>> other

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
<<<<<<< local
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "StringLiteral", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "'{'", "'}'", "';'", "'('", "')'", "','", "'*'", "'connector'", "'ao-composition'", "'pointcut'", "'kind'", "':'", "'signature'", "'caller'", "'callee'", "'component'", "'application'", "'instance'", "'host'", "'advice'", "'service'", "'type'", "'require'", "'provide'", "'on'", "'is'", "'refines'", "'.'", "'before'", "'after'", "'around'", "'execution'", "'call'", "'override'", "'merge'", "'!'", "'abstract'", "'void'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'<'", "'>'", "'?'", "'extends'", "'super'", "'@'", "'='", "'default'"
=======
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "StringLiteral", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'interface'", "'{'", "'}'", "';'", "'('", "')'", "','", "'*'", "'connector'", "'ao-composition'", "'pointcut'", "'kind'", "':'", "'signature'", "'caller'", "'callee'", "'component'", "'application'", "'instance'", "'host'", "'advice'", "'service'", "'type'", "'require'", "'provide'", "'deployment'", "'on'", "'is'", "'.'", "'before'", "'after'", "'around'", "'execution'", "'call'", "'override'", "'merge'", "'!'", "'abstract'", "'void'", "'boolean'", "'char'", "'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'<'", "'>'", "'?'", "'extends'", "'super'", "'@'", "'='", "'default'"
>>>>>>> other
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
<<<<<<< local
            this.state.ruleMemo = new HashMap[169+1];
=======
            this.state.ruleMemo = new HashMap[170+1];
>>>>>>> other
             
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return MViewParser.tokenNames; }
<<<<<<< local
    public String getGrammarFileName() { return "/Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g"; }
=======
    public String getGrammarFileName() { return "/Users/marko/hg/mview/src/mview/parser/MView.g"; }
>>>>>>> other


    public static class compilationUnit_return extends ParserRuleReturnScope {
        public Document element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compilationUnit"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:113:1: compilationUnit returns [Document element] : (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )* ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:113:1: compilationUnit returns [Document element] : (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )* ;
>>>>>>> other
    public final MViewParser.compilationUnit_return compilationUnit() throws RecognitionException {
        MViewParser.compilationUnit_return retval = new MViewParser.compilationUnit_return();
        retval.start = input.LT(1);
        int compilationUnit_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.interfaceDeclaration_return ifd = null;

        MViewParser.componentDeclaration_return cod = null;

        MViewParser.connectorDeclaration_return cnd = null;

        MViewParser.applicationDeclaration_return apd = null;
<<<<<<< local
=======

        MViewParser.deploymentDeclaration_return dpd = null;
>>>>>>> other



         
        	retval.element = getDocument();
        	NamespaceDeclaration npp = new NamespaceDeclaration("");
        	retval.element.add(npp);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:119:2: ( (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:119:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )*
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:119:2: ( (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )* )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:119:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )*
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:119:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration )*
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:119:4: (ifd= interfaceDeclaration | cod= componentDeclaration | cnd= connectorDeclaration | apd= applicationDeclaration | dpd= deploymentDeclaration )*
>>>>>>> other
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
                case 60:
                    {
<<<<<<< local
                    int LA1_4 = input.LA(2);

                    if ( (LA1_4==31) ) {
=======
                    switch ( input.LA(2) ) {
                    case 31:
                        {
>>>>>>> other
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
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:120:4: ifd= interfaceDeclaration
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:120:4: ifd= interfaceDeclaration
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_interfaceDeclaration_in_compilationUnit101);
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
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:122:4: cod= componentDeclaration
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:122:4: cod= componentDeclaration
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_componentDeclaration_in_compilationUnit114);
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
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:124:4: cnd= connectorDeclaration
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:124:4: cnd= connectorDeclaration
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_connectorDeclaration_in_compilationUnit127);
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
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:126:4: apd= applicationDeclaration
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:126:4: apd= applicationDeclaration
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_applicationDeclaration_in_compilationUnit140);
            	    apd=applicationDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, apd.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((apd!=null?apd.element:null));
            	    }
<<<<<<< local
=======

            	    }
            	    break;
            	case 5 :
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:128:4: dpd= deploymentDeclaration
            	    {
            	    pushFollow(FOLLOW_deploymentDeclaration_in_compilationUnit153);
            	    dpd=deploymentDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, dpd.getTree());
            	    if ( state.backtracking==0 ) {
            	      npp.add((dpd!=null?dpd.element:null));
            	    }
>>>>>>> other

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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:139:1: interfaceDeclaration returns [Interface element] : intkw= 'interface' name= Identifier interfaceBody[$element] ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:139:1: interfaceDeclaration returns [Interface element] : intkw= 'interface' name= Identifier interfaceBody[$element] ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:140:2: (intkw= 'interface' name= Identifier interfaceBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:140:4: intkw= 'interface' name= Identifier interfaceBody[$element]
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:140:2: (intkw= 'interface' name= Identifier interfaceBody[$element] )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:140:4: intkw= 'interface' name= Identifier interfaceBody[$element]
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            intkw=(Token)match(input,23,FOLLOW_23_in_interfaceDeclaration174); if (state.failed) return retval;
=======
            intkw=(Token)match(input,23,FOLLOW_23_in_interfaceDeclaration183); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            intkw_tree = (Object)adaptor.create(intkw);
            adaptor.addChild(root_0, intkw_tree);
            }
<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration178); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_interfaceDeclaration187); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.element = new Interface(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,intkw);
              			setLocation(retval.element,name,"__NAME");
              		
            }
<<<<<<< local
            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration184);
=======
            pushFollow(FOLLOW_interfaceBody_in_interfaceDeclaration193);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:149:1: interfaceBody[Interface element] : '{' ( interfaceBodyDeclaration[$element] )* '}' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:149:1: interfaceBody[Interface element] : '{' ( interfaceBodyDeclaration[$element] )* '}' ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:150:2: ( '{' ( interfaceBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:150:4: '{' ( interfaceBodyDeclaration[$element] )* '}'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:150:2: ( '{' ( interfaceBodyDeclaration[$element] )* '}' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:150:4: '{' ( interfaceBodyDeclaration[$element] )* '}'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal2=(Token)match(input,24,FOLLOW_24_in_interfaceBody198); if (state.failed) return retval;
=======
            char_literal2=(Token)match(input,24,FOLLOW_24_in_interfaceBody207); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:150:8: ( interfaceBodyDeclaration[$element] )*
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:150:8: ( interfaceBodyDeclaration[$element] )*
>>>>>>> other
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier||(LA2_0>=61 && LA2_0<=69)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: interfaceBodyDeclaration[$element]
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: interfaceBodyDeclaration[$element]
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody209);
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

<<<<<<< local
            char_literal4=(Token)match(input,25,FOLLOW_25_in_interfaceBody204); if (state.failed) return retval;
=======
            char_literal4=(Token)match(input,25,FOLLOW_25_in_interfaceBody213); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:154:1: interfaceBodyDeclaration[Interface element] : (service= serviceDeclaration ';' ) ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:154:1: interfaceBodyDeclaration[Interface element] : (service= serviceDeclaration ';' ) ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:155:2: ( (service= serviceDeclaration ';' ) )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:155:4: (service= serviceDeclaration ';' )
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:155:2: ( (service= serviceDeclaration ';' ) )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:155:4: (service= serviceDeclaration ';' )
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:155:4: (service= serviceDeclaration ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:155:5: service= serviceDeclaration ';'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:155:4: (service= serviceDeclaration ';' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:155:5: service= serviceDeclaration ';'
>>>>>>> other
            {
            pushFollow(FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration229);
            service=serviceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
<<<<<<< local
            char_literal5=(Token)match(input,26,FOLLOW_26_in_interfaceBodyDeclaration222); if (state.failed) return retval;
=======
            char_literal5=(Token)match(input,26,FOLLOW_26_in_interfaceBodyDeclaration231); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:166:1: serviceReferenceDeclaration returns [SimpleReference<Service> relation] : name= Identifier params= actualParameters ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:166:1: serviceReferenceDeclaration returns [SimpleReference<Service> relation] : name= Identifier params= actualParameters ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:167:2: (name= Identifier params= actualParameters )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:167:4: name= Identifier params= actualParameters
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:167:2: (name= Identifier params= actualParameters )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:167:4: name= Identifier params= actualParameters
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceReferenceDeclaration247); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceReferenceDeclaration256); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
<<<<<<< local
            pushFollow(FOLLOW_actualParameters_in_serviceReferenceDeclaration251);
=======
            pushFollow(FOLLOW_actualParameters_in_serviceReferenceDeclaration260);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:174:1: actualParameters returns [List<String> lst] : '(' (pars= actualParameterDecls )? ')' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:174:1: actualParameters returns [List<String> lst] : '(' (pars= actualParameterDecls )? ')' ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:176:5: ( '(' (pars= actualParameterDecls )? ')' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:176:9: '(' (pars= actualParameterDecls )? ')'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:176:5: ( '(' (pars= actualParameterDecls )? ')' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:176:9: '(' (pars= actualParameterDecls )? ')'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal6=(Token)match(input,27,FOLLOW_27_in_actualParameters280); if (state.failed) return retval;
=======
            char_literal6=(Token)match(input,27,FOLLOW_27_in_actualParameters289); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:176:13: (pars= actualParameterDecls )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:176:13: (pars= actualParameterDecls )?
>>>>>>> other
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Identifier) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:176:14: pars= actualParameterDecls
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:176:14: pars= actualParameterDecls
>>>>>>> other
                    {
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameters294);
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

<<<<<<< local
            char_literal7=(Token)match(input,28,FOLLOW_28_in_actualParameters291); if (state.failed) return retval;
=======
            char_literal7=(Token)match(input,28,FOLLOW_28_in_actualParameters300); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:179:1: actualParameterDecls returns [List<String> lst] : name= Identifier ( ',' decls= actualParameterDecls )? ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:179:1: actualParameterDecls returns [List<String> lst] : name= Identifier ( ',' decls= actualParameterDecls )? ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:180:5: (name= Identifier ( ',' decls= actualParameterDecls )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:180:9: name= Identifier ( ',' decls= actualParameterDecls )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:180:5: (name= Identifier ( ',' decls= actualParameterDecls )? )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:180:9: name= Identifier ( ',' decls= actualParameterDecls )?
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_actualParameterDecls316); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_actualParameterDecls325); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:180:25: ( ',' decls= actualParameterDecls )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:180:25: ( ',' decls= actualParameterDecls )?
>>>>>>> other
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==29) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:180:26: ',' decls= actualParameterDecls
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:180:26: ',' decls= actualParameterDecls
>>>>>>> other
                    {
<<<<<<< local
                    char_literal8=(Token)match(input,29,FOLLOW_29_in_actualParameterDecls319); if (state.failed) return retval;
=======
                    char_literal8=(Token)match(input,29,FOLLOW_29_in_actualParameterDecls328); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (Object)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);
                    }
<<<<<<< local
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameterDecls323);
=======
                    pushFollow(FOLLOW_actualParameterDecls_in_actualParameterDecls332);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:196:1: serviceDeclaration returns [Service element] : res= serviceHeaderDeclaration ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:196:1: serviceDeclaration returns [Service element] : res= serviceHeaderDeclaration ;
>>>>>>> other
    public final MViewParser.serviceDeclaration_return serviceDeclaration() throws RecognitionException {
        MViewParser.serviceDeclaration_return retval = new MViewParser.serviceDeclaration_return();
        retval.start = input.LT(1);
        int serviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.serviceHeaderDeclaration_return res = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:197:2: (res= serviceHeaderDeclaration )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:197:4: res= serviceHeaderDeclaration
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:197:2: (res= serviceHeaderDeclaration )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:197:4: res= serviceHeaderDeclaration
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pushFollow(FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration356);
=======
            pushFollow(FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration365);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:203:1: serviceHeaderDeclaration returns [Service element] : rtype= serviceReturnType name= Identifier params= formalParameters ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:203:1: serviceHeaderDeclaration returns [Service element] : rtype= serviceReturnType name= Identifier params= formalParameters ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:204:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:204:4: rtype= serviceReturnType name= Identifier params= formalParameters
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:204:2: (rtype= serviceReturnType name= Identifier params= formalParameters )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:204:4: rtype= serviceReturnType name= Identifier params= formalParameters
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pushFollow(FOLLOW_serviceReturnType_in_serviceHeaderDeclaration376);
=======
            pushFollow(FOLLOW_serviceReturnType_in_serviceHeaderDeclaration385);
>>>>>>> other
            rtype=serviceReturnType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rtype.getTree());
<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceHeaderDeclaration380); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_serviceHeaderDeclaration389); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
<<<<<<< local
            pushFollow(FOLLOW_formalParameters_in_serviceHeaderDeclaration384);
=======
            pushFollow(FOLLOW_formalParameters_in_serviceHeaderDeclaration393);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:212:1: serviceReturnType returns [BasicTypeReference value] : (vt= voidType | tp= type ) ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:212:1: serviceReturnType returns [BasicTypeReference value] : (vt= voidType | tp= type ) ;
>>>>>>> other
    public final MViewParser.serviceReturnType_return serviceReturnType() throws RecognitionException {
        MViewParser.serviceReturnType_return retval = new MViewParser.serviceReturnType_return();
        retval.start = input.LT(1);
        int serviceReturnType_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.voidType_return vt = null;

        MViewParser.type_return tp = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:213:2: ( (vt= voidType | tp= type ) )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:213:4: (vt= voidType | tp= type )
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:213:2: ( (vt= voidType | tp= type ) )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:213:4: (vt= voidType | tp= type )
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:213:4: (vt= voidType | tp= type )
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:213:4: (vt= voidType | tp= type )
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:214:4: vt= voidType
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:214:4: vt= voidType
>>>>>>> other
                    {
                    pushFollow(FOLLOW_voidType_in_serviceReturnType419);
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:216:4: tp= type
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:216:4: tp= type
>>>>>>> other
                    {
                    pushFollow(FOLLOW_type_in_serviceReturnType433);
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:221:1: formalParameters returns [List<FormalParameter> lst] : '(' (pars= formalParameterDecls )? ')' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:221:1: formalParameters returns [List<FormalParameter> lst] : '(' (pars= formalParameterDecls )? ')' ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:223:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:223:9: '(' (pars= formalParameterDecls )? ')'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:223:5: ( '(' (pars= formalParameterDecls )? ')' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:223:9: '(' (pars= formalParameterDecls )? ')'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal9=(Token)match(input,27,FOLLOW_27_in_formalParameters456); if (state.failed) return retval;
=======
            char_literal9=(Token)match(input,27,FOLLOW_27_in_formalParameters465); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            char_literal9_tree = (Object)adaptor.create(char_literal9);
            adaptor.addChild(root_0, char_literal9_tree);
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:223:13: (pars= formalParameterDecls )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:223:13: (pars= formalParameterDecls )?
>>>>>>> other
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Identifier||(LA6_0>=62 && LA6_0<=69)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:223:14: pars= formalParameterDecls
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:223:14: pars= formalParameterDecls
>>>>>>> other
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters470);
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

<<<<<<< local
            char_literal10=(Token)match(input,28,FOLLOW_28_in_formalParameters467); if (state.failed) return retval;
=======
            char_literal10=(Token)match(input,28,FOLLOW_28_in_formalParameters476); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:227:1: formalParameterDecls returns [List<FormalParameter> lst] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:227:1: formalParameterDecls returns [List<FormalParameter> lst] : t= type name= Identifier ( ',' decls= formalParameterDecls )? ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:228:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:228:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:228:5: (t= type name= Identifier ( ',' decls= formalParameterDecls )? )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:228:9: t= type name= Identifier ( ',' decls= formalParameterDecls )?
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pushFollow(FOLLOW_type_in_formalParameterDecls493);
=======
            pushFollow(FOLLOW_type_in_formalParameterDecls502);
>>>>>>> other
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls497); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterDecls506); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:228:32: ( ',' decls= formalParameterDecls )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:228:32: ( ',' decls= formalParameterDecls )?
>>>>>>> other
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==29) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:228:33: ',' decls= formalParameterDecls
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:228:33: ',' decls= formalParameterDecls
>>>>>>> other
                    {
<<<<<<< local
                    char_literal11=(Token)match(input,29,FOLLOW_29_in_formalParameterDecls500); if (state.failed) return retval;
=======
                    char_literal11=(Token)match(input,29,FOLLOW_29_in_formalParameterDecls509); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
                    char_literal11_tree = (Object)adaptor.create(char_literal11);
                    adaptor.addChild(root_0, char_literal11_tree);
                    }
<<<<<<< local
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls504);
=======
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameterDecls513);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:249:1: pointcutServiceSignatureDecl returns [ServiceSignature element] : (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:249:1: pointcutServiceSignatureDecl returns [ServiceSignature element] : (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:250:2: ( (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:250:4: (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:250:2: ( (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:250:4: (negate= negationModifier )? rtype= ( Identifier | '*' ) sig= ( Identifier | '*' ) pars= pointcutServiceSignatureParameters
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:250:4: (negate= negationModifier )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:250:4: (negate= negationModifier )?
>>>>>>> other
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==59) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:250:5: negate= negationModifier
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:250:5: negate= negationModifier
>>>>>>> other
                    {
                    pushFollow(FOLLOW_negationModifier_in_pointcutServiceSignatureDecl549);
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

<<<<<<< local
            pushFollow(FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl562);
=======
            pushFollow(FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl571);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:261:1: pointcutServiceSignatureParameters returns [List<Pair<String,String>> lst] : '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:261:1: pointcutServiceSignatureParameters returns [List<Pair<String,String>> lst] : '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:263:2: ( '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:263:4: '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:263:2: ( '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:263:4: '(' ( pointcutServiceSignatureParameterDecls[$lst] )? ')'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal12=(Token)match(input,27,FOLLOW_27_in_pointcutServiceSignatureParameters585); if (state.failed) return retval;
=======
            char_literal12=(Token)match(input,27,FOLLOW_27_in_pointcutServiceSignatureParameters594); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:263:8: ( pointcutServiceSignatureParameterDecls[$lst] )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:263:8: ( pointcutServiceSignatureParameterDecls[$lst] )?
>>>>>>> other
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Identifier||LA9_0==30) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:263:9: pointcutServiceSignatureParameterDecls[$lst]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:263:9: pointcutServiceSignatureParameterDecls[$lst]
>>>>>>> other
                    {
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters597);
                    pointcutServiceSignatureParameterDecls13=pointcutServiceSignatureParameterDecls(retval.lst);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutServiceSignatureParameterDecls13.getTree());

                    }
                    break;

            }

<<<<<<< local
            char_literal14=(Token)match(input,28,FOLLOW_28_in_pointcutServiceSignatureParameters594); if (state.failed) return retval;
=======
            char_literal14=(Token)match(input,28,FOLLOW_28_in_pointcutServiceSignatureParameters603); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:267:1: pointcutServiceSignatureParameterDecls[List<Pair<String,String>> lst] : t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:267:1: pointcutServiceSignatureParameterDecls[List<Pair<String,String>> lst] : t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:268:2: (t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:268:4: t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:268:2: (t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )? )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:268:4: t= ( Identifier | '*' ) (name= Identifier )? ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
>>>>>>> other
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

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:268:23: (name= Identifier )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:268:23: (name= Identifier )?
>>>>>>> other
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Identifier) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:268:24: name= Identifier
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:268:24: name= Identifier
>>>>>>> other
                    {
                    name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls627); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    name_tree = (Object)adaptor.create(name);
                    adaptor.addChild(root_0, name_tree);
                    }

                    }
                    break;

            }

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:268:42: ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:268:42: ( ',' pointcutServiceSignatureParameterDecls[$lst] )?
>>>>>>> other
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==29) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:268:43: ',' pointcutServiceSignatureParameterDecls[$lst]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:268:43: ',' pointcutServiceSignatureParameterDecls[$lst]
>>>>>>> other
                    {
<<<<<<< local
                    char_literal15=(Token)match(input,29,FOLLOW_29_in_pointcutServiceSignatureParameterDecls623); if (state.failed) return retval;
=======
                    char_literal15=(Token)match(input,29,FOLLOW_29_in_pointcutServiceSignatureParameterDecls632); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    adaptor.addChild(root_0, char_literal15_tree);
                    }
<<<<<<< local
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls625);
=======
                    pushFollow(FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls634);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:281:1: connectorDeclaration returns [Connector element] : (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:281:1: connectorDeclaration returns [Connector element] : (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:282:2: ( (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:282:4: (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element]
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:282:2: ( (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element] )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:282:4: (abs= abstractModifier )? conkw= 'connector' name= Identifier ( refinementDeclaration[$element,Connector.class] )? connectorBody[$element]
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:282:4: (abs= abstractModifier )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:282:4: (abs= abstractModifier )?
>>>>>>> other
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==60) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:282:5: abs= abstractModifier
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:282:5: abs= abstractModifier
>>>>>>> other
                    {
                    pushFollow(FOLLOW_abstractModifier_in_connectorDeclaration665);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

<<<<<<< local
            conkw=(Token)match(input,31,FOLLOW_31_in_connectorDeclaration662); if (state.failed) return retval;
=======
            conkw=(Token)match(input,31,FOLLOW_31_in_connectorDeclaration671); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            conkw_tree = (Object)adaptor.create(conkw);
            adaptor.addChild(root_0, conkw_tree);
            }
<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration666); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_connectorDeclaration675); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:292:3: ( refinementDeclaration[$element,Connector.class] )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:292:3: ( refinementDeclaration[$element,Connector.class] )?
>>>>>>> other
            int alt13=2;
            int LA13_0 = input.LA(1);

<<<<<<< local
            if ( (LA13_0==50) ) {
=======
            if ( (LA13_0==35) ) {
>>>>>>> other
                alt13=1;
            }
            switch (alt13) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:292:4: refinementDeclaration[$element,Connector.class]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:292:4: refinementDeclaration[$element,Connector.class]
>>>>>>> other
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_connectorDeclaration683);
                    refinementDeclaration17=refinementDeclaration(retval.element, Connector.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration17.getTree());

                    }
                    break;

            }

<<<<<<< local
            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration681);
=======
            pushFollow(FOLLOW_connectorBody_in_connectorDeclaration690);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:297:1: connectorBody[Connector element] : '{' ( connectorBodyDeclaration[$element] )* '}' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:297:1: connectorBody[Connector element] : '{' ( connectorBodyDeclaration[$element] )* '}' ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:298:2: ( '{' ( connectorBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:298:4: '{' ( connectorBodyDeclaration[$element] )* '}'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:298:2: ( '{' ( connectorBodyDeclaration[$element] )* '}' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:298:4: '{' ( connectorBodyDeclaration[$element] )* '}'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal19=(Token)match(input,24,FOLLOW_24_in_connectorBody695); if (state.failed) return retval;
=======
            char_literal19=(Token)match(input,24,FOLLOW_24_in_connectorBody704); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:298:8: ( connectorBodyDeclaration[$element] )*
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:298:8: ( connectorBodyDeclaration[$element] )*
>>>>>>> other
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==32||LA14_0==46||LA14_0==60) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: connectorBodyDeclaration[$element]
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: connectorBodyDeclaration[$element]
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_connectorBodyDeclaration_in_connectorBody706);
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

<<<<<<< local
            char_literal21=(Token)match(input,25,FOLLOW_25_in_connectorBody701); if (state.failed) return retval;
=======
            char_literal21=(Token)match(input,25,FOLLOW_25_in_connectorBody710); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:302:1: connectorBodyDeclaration[Connector element] : (aoc= aoCompositionDeclaration | moduleRequireDependencyDeclaration[$element] );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:302:1: connectorBodyDeclaration[Connector element] : (aoc= aoCompositionDeclaration | moduleRequireDependencyDeclaration[$element] );
>>>>>>> other
    public final MViewParser.connectorBodyDeclaration_return connectorBodyDeclaration(Connector element) throws RecognitionException {
        MViewParser.connectorBodyDeclaration_return retval = new MViewParser.connectorBodyDeclaration_return();
        retval.start = input.LT(1);
        int connectorBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.aoCompositionDeclaration_return aoc = null;

        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration22 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:303:2: (aoc= aoCompositionDeclaration | moduleRequireDependencyDeclaration[$element] )
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:303:2: (aoc= aoCompositionDeclaration | moduleRequireDependencyDeclaration[$element] )
>>>>>>> other
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==32||LA15_0==60) ) {
                alt15=1;
            }
            else if ( (LA15_0==46) ) {
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:303:4: aoc= aoCompositionDeclaration
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:303:4: aoc= aoCompositionDeclaration
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_aoCompositionDeclaration_in_connectorBodyDeclaration716);
=======
                    pushFollow(FOLLOW_aoCompositionDeclaration_in_connectorBodyDeclaration725);
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:306:4: moduleRequireDependencyDeclaration[$element]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:306:4: moduleRequireDependencyDeclaration[$element]
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration723);
=======
                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration732);
>>>>>>> other
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

    public static class aoCompositionDeclaration_return extends ParserRuleReturnScope {
        public AOComposition element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "aoCompositionDeclaration"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:310:1: aoCompositionDeclaration returns [AOComposition element] : (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclaration[$element,AOComposition.class] )? aoCompositionBody[$element] ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:310:1: aoCompositionDeclaration returns [AOComposition element] : (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclarationSingle[$element,AOComposition.class] )? aoCompositionBody[$element] ;
>>>>>>> other
    public final MViewParser.aoCompositionDeclaration_return aoCompositionDeclaration() throws RecognitionException {
        MViewParser.aoCompositionDeclaration_return retval = new MViewParser.aoCompositionDeclaration_return();
        retval.start = input.LT(1);
        int aoCompositionDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token kw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs = null;

<<<<<<< local
        MViewParser.refinementDeclaration_return refinementDeclaration23 = null;
=======
        MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle23 = null;
>>>>>>> other

        MViewParser.aoCompositionBody_return aoCompositionBody24 = null;


        Object kw_tree=null;
        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:311:2: ( (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclaration[$element,AOComposition.class] )? aoCompositionBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:311:4: (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclaration[$element,AOComposition.class] )? aoCompositionBody[$element]
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:311:2: ( (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclarationSingle[$element,AOComposition.class] )? aoCompositionBody[$element] )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:311:4: (abs= abstractModifier )? kw= 'ao-composition' name= Identifier ( refinementDeclarationSingle[$element,AOComposition.class] )? aoCompositionBody[$element]
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:311:4: (abs= abstractModifier )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:311:4: (abs= abstractModifier )?
>>>>>>> other
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==60) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:311:5: abs= abstractModifier
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:311:5: abs= abstractModifier
>>>>>>> other
                    {
                    pushFollow(FOLLOW_abstractModifier_in_aoCompositionDeclaration754);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

<<<<<<< local
            kw=(Token)match(input,32,FOLLOW_32_in_aoCompositionDeclaration751); if (state.failed) return retval;
=======
            kw=(Token)match(input,32,FOLLOW_32_in_aoCompositionDeclaration760); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            kw_tree = (Object)adaptor.create(kw);
            adaptor.addChild(root_0, kw_tree);
            }
<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_aoCompositionDeclaration755); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_aoCompositionDeclaration764); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:321:3: ( refinementDeclaration[$element,AOComposition.class] )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:321:3: ( refinementDeclarationSingle[$element,AOComposition.class] )?
>>>>>>> other
            int alt17=2;
            int LA17_0 = input.LA(1);

<<<<<<< local
            if ( (LA17_0==50) ) {
=======
            if ( (LA17_0==35) ) {
>>>>>>> other
                alt17=1;
            }
            switch (alt17) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:321:4: refinementDeclaration[$element,AOComposition.class]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:321:4: refinementDeclarationSingle[$element,AOComposition.class]
>>>>>>> other
                    {
                    pushFollow(FOLLOW_refinementDeclarationSingle_in_aoCompositionDeclaration772);
                    refinementDeclarationSingle23=refinementDeclarationSingle(retval.element, AOComposition.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationSingle23.getTree());

                    }
                    break;

            }

<<<<<<< local
            pushFollow(FOLLOW_aoCompositionBody_in_aoCompositionDeclaration770);
=======
            pushFollow(FOLLOW_aoCompositionBody_in_aoCompositionDeclaration779);
>>>>>>> other
            aoCompositionBody24=aoCompositionBody(retval.element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aoCompositionBody24.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:326:1: aoCompositionBody[AOComposition element] : '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:326:1: aoCompositionBody[AOComposition element] : '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' ;
>>>>>>> other
    public final MViewParser.aoCompositionBody_return aoCompositionBody(AOComposition element) throws RecognitionException {
        MViewParser.aoCompositionBody_return retval = new MViewParser.aoCompositionBody_return();
        retval.start = input.LT(1);
        int aoCompositionBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal25=null;
        Token char_literal26=null;
        MViewParser.pointcutDeclaration_return pc = null;

        MViewParser.adviceDeclaration_return adv = null;


        Object char_literal25_tree=null;
        Object char_literal26_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:327:2: ( '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:327:4: '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:327:2: ( '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:327:4: '{' (pc= pointcutDeclaration )? (adv= adviceDeclaration )? '}'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal25=(Token)match(input,24,FOLLOW_24_in_aoCompositionBody784); if (state.failed) return retval;
=======
            char_literal25=(Token)match(input,24,FOLLOW_24_in_aoCompositionBody793); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:328:5: (pc= pointcutDeclaration )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:328:5: (pc= pointcutDeclaration )?
>>>>>>> other
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==33) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: pc= pointcutDeclaration
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: pc= pointcutDeclaration
>>>>>>> other
                    {
                    pushFollow(FOLLOW_pointcutDeclaration_in_aoCompositionBody800);
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:331:6: (adv= adviceDeclaration )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:331:6: (adv= adviceDeclaration )?
>>>>>>> other
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==43) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: adv= adviceDeclaration
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: adv= adviceDeclaration
>>>>>>> other
                    {
                    pushFollow(FOLLOW_adviceDeclaration_in_aoCompositionBody809);
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
<<<<<<< local
            char_literal26=(Token)match(input,25,FOLLOW_25_in_aoCompositionBody807); if (state.failed) return retval;
=======
            char_literal26=(Token)match(input,25,FOLLOW_25_in_aoCompositionBody816); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:337:1: pointcutDeclaration returns [Pointcut pointcut] : pckw= 'pointcut' pointcutBody[$pointcut] ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:337:1: pointcutDeclaration returns [Pointcut pointcut] : pckw= 'pointcut' pointcutBody[$pointcut] ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:338:2: (pckw= 'pointcut' pointcutBody[$pointcut] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:338:4: pckw= 'pointcut' pointcutBody[$pointcut]
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:338:2: (pckw= 'pointcut' pointcutBody[$pointcut] )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:338:4: pckw= 'pointcut' pointcutBody[$pointcut]
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pckw=(Token)match(input,33,FOLLOW_33_in_pointcutDeclaration824); if (state.failed) return retval;
=======
            pckw=(Token)match(input,33,FOLLOW_33_in_pointcutDeclaration833); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            pckw_tree = (Object)adaptor.create(pckw);
            adaptor.addChild(root_0, pckw_tree);
            }
            if ( state.backtracking==0 ) {

              				retval.pointcut = new Pointcut();
              				setKeyword(retval.pointcut,pckw);
              			
            }
<<<<<<< local
            pushFollow(FOLLOW_pointcutBody_in_pointcutDeclaration828);
=======
            pushFollow(FOLLOW_pointcutBody_in_pointcutDeclaration837);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:345:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:345:1: pointcutBody[Pointcut pointcut] : '{' ( pointcutBodyDeclaration[$pointcut] )* '}' ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:346:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:346:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:346:2: ( '{' ( pointcutBodyDeclaration[$pointcut] )* '}' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:346:4: '{' ( pointcutBodyDeclaration[$pointcut] )* '}'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal28=(Token)match(input,24,FOLLOW_24_in_pointcutBody844); if (state.failed) return retval;
=======
            char_literal28=(Token)match(input,24,FOLLOW_24_in_pointcutBody853); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:346:8: ( pointcutBodyDeclaration[$pointcut] )*
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:346:8: ( pointcutBodyDeclaration[$pointcut] )*
>>>>>>> other
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==34||(LA20_0>=36 && LA20_0<=38)||(LA20_0>=57 && LA20_0<=58)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: pointcutBodyDeclaration[$pointcut]
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: pointcutBodyDeclaration[$pointcut]
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_pointcutBodyDeclaration_in_pointcutBody855);
            	    pointcutBodyDeclaration29=pointcutBodyDeclaration(pointcut);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutBodyDeclaration29.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

<<<<<<< local
            char_literal30=(Token)match(input,25,FOLLOW_25_in_pointcutBody850); if (state.failed) return retval;
=======
            char_literal30=(Token)match(input,25,FOLLOW_25_in_pointcutBody859); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:350:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:350:1: pointcutBodyDeclaration[Pointcut pointcut] : ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] );
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:351:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] )
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:351:2: ( pointcutKindDeclaration[$pointcut] | pointcutSignatureDeclaration[$pointcut] | pointcutActorDeclaration[$pointcut] )
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:351:4: pointcutKindDeclaration[$pointcut]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:351:4: pointcutKindDeclaration[$pointcut]
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration864);
=======
                    pushFollow(FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration873);
>>>>>>> other
                    pointcutKindDeclaration31=pointcutKindDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutKindDeclaration31.getTree());

                    }
                    break;
                case 2 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:352:4: pointcutSignatureDeclaration[$pointcut]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:352:4: pointcutSignatureDeclaration[$pointcut]
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration870);
=======
                    pushFollow(FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration879);
>>>>>>> other
                    pointcutSignatureDeclaration32=pointcutSignatureDeclaration(pointcut);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutSignatureDeclaration32.getTree());

                    }
                    break;
                case 3 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:353:4: pointcutActorDeclaration[$pointcut]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:353:4: pointcutActorDeclaration[$pointcut]
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration876);
=======
                    pushFollow(FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration885);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:357:1: pointcutKindDeclaration[Pointcut pointcut] : kikw= 'kind' ':' kind= joinPointKind ';' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:357:1: pointcutKindDeclaration[Pointcut pointcut] : kikw= 'kind' ':' kind= joinPointKind ';' ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:358:2: (kikw= 'kind' ':' kind= joinPointKind ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:358:4: kikw= 'kind' ':' kind= joinPointKind ';'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:358:2: (kikw= 'kind' ':' kind= joinPointKind ';' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:358:4: kikw= 'kind' ':' kind= joinPointKind ';'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            kikw=(Token)match(input,34,FOLLOW_34_in_pointcutKindDeclaration893); if (state.failed) return retval;
=======
            kikw=(Token)match(input,34,FOLLOW_34_in_pointcutKindDeclaration902); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            kikw_tree = (Object)adaptor.create(kikw);
            adaptor.addChild(root_0, kikw_tree);
            }
<<<<<<< local
            char_literal34=(Token)match(input,35,FOLLOW_35_in_pointcutKindDeclaration895); if (state.failed) return retval;
=======
            char_literal34=(Token)match(input,35,FOLLOW_35_in_pointcutKindDeclaration904); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            char_literal34_tree = (Object)adaptor.create(char_literal34);
            adaptor.addChild(root_0, char_literal34_tree);
            }
<<<<<<< local
            pushFollow(FOLLOW_joinPointKind_in_pointcutKindDeclaration899);
=======
            pushFollow(FOLLOW_joinPointKind_in_pointcutKindDeclaration908);
>>>>>>> other
            kind=joinPointKind();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, kind.getTree());
<<<<<<< local
            char_literal35=(Token)match(input,26,FOLLOW_26_in_pointcutKindDeclaration901); if (state.failed) return retval;
=======
            char_literal35=(Token)match(input,26,FOLLOW_26_in_pointcutKindDeclaration910); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:365:1: pointcutSignatureDeclaration[Pointcut element] : (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:365:1: pointcutSignatureDeclaration[Pointcut element] : (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:366:2: ( (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:366:4: (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:366:2: ( (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:366:4: (override= overrideOrExtend )? sikw= 'signature' ':' ps= pointcutSignatureBody ';'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:366:4: (override= overrideOrExtend )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:366:4: (override= overrideOrExtend )?
>>>>>>> other
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=57 && LA22_0<=58)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:366:5: override= overrideOrExtend
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:366:5: override= overrideOrExtend
>>>>>>> other
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration929);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

<<<<<<< local
            sikw=(Token)match(input,36,FOLLOW_36_in_pointcutSignatureDeclaration926); if (state.failed) return retval;
=======
            sikw=(Token)match(input,36,FOLLOW_36_in_pointcutSignatureDeclaration935); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            sikw_tree = (Object)adaptor.create(sikw);
            adaptor.addChild(root_0, sikw_tree);
            }
<<<<<<< local
            char_literal36=(Token)match(input,35,FOLLOW_35_in_pointcutSignatureDeclaration928); if (state.failed) return retval;
=======
            char_literal36=(Token)match(input,35,FOLLOW_35_in_pointcutSignatureDeclaration937); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            char_literal36_tree = (Object)adaptor.create(char_literal36);
            adaptor.addChild(root_0, char_literal36_tree);
            }
<<<<<<< local
            pushFollow(FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration932);
=======
            pushFollow(FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration941);
>>>>>>> other
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
<<<<<<< local
            char_literal37=(Token)match(input,26,FOLLOW_26_in_pointcutSignatureDeclaration936); if (state.failed) return retval;
=======
            char_literal37=(Token)match(input,26,FOLLOW_26_in_pointcutSignatureDeclaration945); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:377:1: pointcutSignatureBody returns [PointcutSignature element] : pointcutSignatureBodyDecls[$element] ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:377:1: pointcutSignatureBody returns [PointcutSignature element] : pointcutSignatureBodyDecls[$element] ;
>>>>>>> other
    public final MViewParser.pointcutSignatureBody_return pointcutSignatureBody() throws RecognitionException {
        MViewParser.pointcutSignatureBody_return retval = new MViewParser.pointcutSignatureBody_return();
        retval.start = input.LT(1);
        int pointcutSignatureBody_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.pointcutSignatureBodyDecls_return pointcutSignatureBodyDecls38 = null;



         retval.element = new PointcutSignature(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:379:2: ( pointcutSignatureBodyDecls[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:379:4: pointcutSignatureBodyDecls[$element]
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:379:2: ( pointcutSignatureBodyDecls[$element] )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:379:4: pointcutSignatureBodyDecls[$element]
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody955);
=======
            pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody964);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:383:1: pointcutSignatureBodyDecls[PointcutSignature element] : pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:383:1: pointcutSignatureBodyDecls[PointcutSignature element] : pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:384:2: (pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:384:4: pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:384:2: (pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )? )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:384:4: pss= pointcutServiceSignatureDecl ( ',' pointcutSignatureBodyDecls[$element] )?
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pushFollow(FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls972);
=======
            pushFollow(FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls981);
>>>>>>> other
            pss=pointcutServiceSignatureDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pss.getTree());
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:384:37: ( ',' pointcutSignatureBodyDecls[$element] )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:384:37: ( ',' pointcutSignatureBodyDecls[$element] )?
>>>>>>> other
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:384:39: ',' pointcutSignatureBodyDecls[$element]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:384:39: ',' pointcutSignatureBodyDecls[$element]
>>>>>>> other
                    {
<<<<<<< local
                    char_literal39=(Token)match(input,29,FOLLOW_29_in_pointcutSignatureBodyDecls976); if (state.failed) return retval;
=======
                    char_literal39=(Token)match(input,29,FOLLOW_29_in_pointcutSignatureBodyDecls985); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
                    char_literal39_tree = (Object)adaptor.create(char_literal39);
                    adaptor.addChild(root_0, char_literal39_tree);
                    }
<<<<<<< local
                    pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls978);
=======
                    pushFollow(FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls987);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:390:1: pointcutActorDeclaration[Pointcut pointcut] : (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:390:1: pointcutActorDeclaration[Pointcut pointcut] : (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody );
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:391:2: (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody )
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:391:2: (clkw= 'caller' actor= pointcutActorBody | clkw= 'callee' actor= pointcutActorBody )
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:391:4: clkw= 'caller' actor= pointcutActorBody
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:391:4: clkw= 'caller' actor= pointcutActorBody
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    clkw=(Token)match(input,37,FOLLOW_37_in_pointcutActorDeclaration1000); if (state.failed) return retval;
=======
                    clkw=(Token)match(input,37,FOLLOW_37_in_pointcutActorDeclaration1009); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
                    clkw_tree = (Object)adaptor.create(clkw);
                    adaptor.addChild(root_0, clkw_tree);
                    }
<<<<<<< local
                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1004);
=======
                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1013);
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:396:3: clkw= 'callee' actor= pointcutActorBody
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:396:3: clkw= 'callee' actor= pointcutActorBody
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    clkw=(Token)match(input,38,FOLLOW_38_in_pointcutActorDeclaration1015); if (state.failed) return retval;
=======
                    clkw=(Token)match(input,38,FOLLOW_38_in_pointcutActorDeclaration1024); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
                    clkw_tree = (Object)adaptor.create(clkw);
                    adaptor.addChild(root_0, clkw_tree);
                    }
<<<<<<< local
                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1019);
=======
                    pushFollow(FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1028);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:407:1: pointcutActorBody returns [Actor element] : '{' ( pointcutActorBodyDecls[$element] )* '}' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:407:1: pointcutActorBody returns [Actor element] : '{' ( pointcutActorBodyDecls[$element] )* '}' ;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:411:2: ( '{' ( pointcutActorBodyDecls[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:411:4: '{' ( pointcutActorBodyDecls[$element] )* '}'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:411:2: ( '{' ( pointcutActorBodyDecls[$element] )* '}' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:411:4: '{' ( pointcutActorBodyDecls[$element] )* '}'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal41=(Token)match(input,24,FOLLOW_24_in_pointcutActorBody1047); if (state.failed) return retval;
=======
            char_literal41=(Token)match(input,24,FOLLOW_24_in_pointcutActorBody1056); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            char_literal41_tree = (Object)adaptor.create(char_literal41);
            adaptor.addChild(root_0, char_literal41_tree);
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:411:8: ( pointcutActorBodyDecls[$element] )*
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:411:8: ( pointcutActorBodyDecls[$element] )*
>>>>>>> other
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==23||(LA25_0>=39 && LA25_0<=42)||(LA25_0>=57 && LA25_0<=58)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: pointcutActorBodyDecls[$element]
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: pointcutActorBodyDecls[$element]
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1058);
            	    pointcutActorBodyDecls42=pointcutActorBodyDecls(retval.element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorBodyDecls42.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

<<<<<<< local
            char_literal43=(Token)match(input,25,FOLLOW_25_in_pointcutActorBody1053); if (state.failed) return retval;
=======
            char_literal43=(Token)match(input,25,FOLLOW_25_in_pointcutActorBody1062); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:415:1: pointcutActorBodyDecls[Actor actor] : (override= overrideOrExtend )? (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:415:1: pointcutActorBodyDecls[Actor actor] : (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' ;
>>>>>>> other
    public final MViewParser.pointcutActorBodyDecls_return pointcutActorBodyDecls(Actor actor) throws RecognitionException {
        MViewParser.pointcutActorBodyDecls_return retval = new MViewParser.pointcutActorBodyDecls_return();
        retval.start = input.LT(1);
        int pointcutActorBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal44=null;
        Token char_literal45=null;
        Token string_literal46=null;
        Token char_literal47=null;
<<<<<<< local
        Token char_literal48=null;
        Token char_literal50=null;
=======
        Token string_literal48=null;
        Token char_literal49=null;
        Token string_literal50=null;
        Token char_literal51=null;
        Token string_literal52=null;
        Token char_literal53=null;
        Token char_literal55=null;
>>>>>>> other
        MViewParser.overrideOrExtend_return override = null;

<<<<<<< local
        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls49 = null;
=======
        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls54 = null;
>>>>>>> other


<<<<<<< local
        Object kw_tree=null;
        Object char_literal44_tree=null;
=======
        Object string_literal44_tree=null;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:421:2: ( (override= overrideOrExtend )? (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:421:4: (override= overrideOrExtend )? (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:420:2: ( (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:420:4: (override= overrideOrExtend )? ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' ) pointcutActorPropDecls[prop,declClass] ';'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:421:4: (override= overrideOrExtend )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:420:4: (override= overrideOrExtend )?
>>>>>>> other
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=57 && LA26_0<=58)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:421:5: override= overrideOrExtend
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:420:5: override= overrideOrExtend
>>>>>>> other
                    {
                    pushFollow(FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1083);
                    override=overrideOrExtend();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, override.getTree());

                    }
                    break;

            }

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:422:2: (kw= 'interface' ':' | kw= 'component' ':' | kw= 'application' ':' | kw= 'instance' ':' | kw= 'host' ':' )
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:421:2: ( 'interface' ':' | 'component' ':' | 'application' ':' | 'instance' ':' | 'host' ':' )
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:423:3: kw= 'interface' ':'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:422:3: 'interface' ':'
>>>>>>> other
                    {
<<<<<<< local
                    kw=(Token)match(input,23,FOLLOW_23_in_pointcutActorBodyDecls1085); if (state.failed) return retval;
=======
                    string_literal44=(Token)match(input,23,FOLLOW_23_in_pointcutActorBodyDecls1092); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
=======
                    string_literal44_tree = (Object)adaptor.create(string_literal44);
                    adaptor.addChild(root_0, string_literal44_tree);
>>>>>>> other
                    }
<<<<<<< local
                    char_literal44=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1087); if (state.failed) return retval;
=======
                    char_literal45=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1094); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal44_tree = (Object)adaptor.create(char_literal44);
                    adaptor.addChild(root_0, char_literal44_tree);
=======
                    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    adaptor.addChild(root_0, char_literal45_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Interface.class;
<<<<<<< local
                      			propKw = kw;
=======
>>>>>>> other
                      		
                    }

                    }
                    break;
                case 2 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:428:3: kw= 'component' ':'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:426:3: 'component' ':'
>>>>>>> other
                    {
<<<<<<< local
                    kw=(Token)match(input,39,FOLLOW_39_in_pointcutActorBodyDecls1099); if (state.failed) return retval;
=======
                    string_literal46=(Token)match(input,39,FOLLOW_39_in_pointcutActorBodyDecls1104); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
=======
                    string_literal46_tree = (Object)adaptor.create(string_literal46);
                    adaptor.addChild(root_0, string_literal46_tree);
>>>>>>> other
                    }
<<<<<<< local
                    char_literal45=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1101); if (state.failed) return retval;
=======
                    char_literal47=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1106); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    adaptor.addChild(root_0, char_literal45_tree);
=======
                    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    adaptor.addChild(root_0, char_literal47_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Component.class;
<<<<<<< local
                      			propKw = kw;
=======
>>>>>>> other
                      		
                    }

                    }
                    break;
                case 3 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:433:3: kw= 'application' ':'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:430:3: 'application' ':'
>>>>>>> other
                    {
                    string_literal48=(Token)match(input,40,FOLLOW_40_in_pointcutActorBodyDecls1115); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
=======
                    string_literal48_tree = (Object)adaptor.create(string_literal48);
                    adaptor.addChild(root_0, string_literal48_tree);
>>>>>>> other
                    }
<<<<<<< local
                    char_literal46=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1114); if (state.failed) return retval;
=======
                    char_literal49=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1117); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal46_tree = (Object)adaptor.create(char_literal46);
                    adaptor.addChild(root_0, char_literal46_tree);
=======
                    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    adaptor.addChild(root_0, char_literal49_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Application.class;
<<<<<<< local
                      			propKw = kw;
=======
>>>>>>> other
                      		
                    }

                    }
                    break;
                case 4 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:438:3: kw= 'instance' ':'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:434:3: 'instance' ':'
>>>>>>> other
                    {
<<<<<<< local
                    kw=(Token)match(input,41,FOLLOW_41_in_pointcutActorBodyDecls1125); if (state.failed) return retval;
=======
                    string_literal50=(Token)match(input,41,FOLLOW_41_in_pointcutActorBodyDecls1126); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
=======
                    string_literal50_tree = (Object)adaptor.create(string_literal50);
                    adaptor.addChild(root_0, string_literal50_tree);
>>>>>>> other
                    }
<<<<<<< local
                    char_literal47=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1127); if (state.failed) return retval;
=======
                    char_literal51=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1128); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    adaptor.addChild(root_0, char_literal47_tree);
=======
                    char_literal51_tree = (Object)adaptor.create(char_literal51);
                    adaptor.addChild(root_0, char_literal51_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Instance.class;
<<<<<<< local
                      			propKw = kw;
=======
>>>>>>> other
                      		
                    }

                    }
                    break;
                case 5 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:443:3: kw= 'host' ':'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:438:3: 'host' ':'
>>>>>>> other
                    {
<<<<<<< local
                    kw=(Token)match(input,42,FOLLOW_42_in_pointcutActorBodyDecls1138); if (state.failed) return retval;
=======
                    string_literal52=(Token)match(input,42,FOLLOW_42_in_pointcutActorBodyDecls1137); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    kw_tree = (Object)adaptor.create(kw);
                    adaptor.addChild(root_0, kw_tree);
=======
                    string_literal52_tree = (Object)adaptor.create(string_literal52);
                    adaptor.addChild(root_0, string_literal52_tree);
>>>>>>> other
                    }
<<<<<<< local
                    char_literal48=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1140); if (state.failed) return retval;
=======
                    char_literal53=(Token)match(input,35,FOLLOW_35_in_pointcutActorBodyDecls1139); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal48_tree = (Object)adaptor.create(char_literal48);
                    adaptor.addChild(root_0, char_literal48_tree);
=======
                    char_literal53_tree = (Object)adaptor.create(char_literal53);
                    adaptor.addChild(root_0, char_literal53_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {

                      			declClass = Host.class;
<<<<<<< local
                      			propKw = kw;
=======
>>>>>>> other
                      		
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		prop = new ActorProp(new PropModifier(declClass));
<<<<<<< local
              		setKeyword(prop,propKw);
=======
>>>>>>> other
              		actor.addProp(prop);
              		if ((override!=null?override.value:null) != null) {
              			prop.addModifier((override!=null?override.value:null));
              		}
<<<<<<< local
              		
=======
>>>>>>> other
              	
            }
<<<<<<< local
            pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1149);
            pointcutActorPropDecls49=pointcutActorPropDecls(prop, declClass);
=======
            pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1148);
            pointcutActorPropDecls54=pointcutActorPropDecls(prop, declClass);
>>>>>>> other

            state._fsp--;
            if (state.failed) return retval;
<<<<<<< local
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls49.getTree());
            char_literal50=(Token)match(input,26,FOLLOW_26_in_pointcutActorBodyDecls1152); if (state.failed) return retval;
=======
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointcutActorPropDecls54.getTree());
            char_literal55=(Token)match(input,26,FOLLOW_26_in_pointcutActorBodyDecls1151); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal50_tree = (Object)adaptor.create(char_literal50);
            adaptor.addChild(root_0, char_literal50_tree);
=======
            char_literal55_tree = (Object)adaptor.create(char_literal55);
            adaptor.addChild(root_0, char_literal55_tree);
>>>>>>> other
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:459:1: pointcutActorPropDecls[ActorProp prop,Class<? extends Declaration> declClass] : (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:451:1: pointcutActorPropDecls[ActorProp prop,Class<? extends Declaration> declClass] : (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? ;
>>>>>>> other
    public final MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls(ActorProp prop, Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecls_return retval = new MViewParser.pointcutActorPropDecls_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecls_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token char_literal51=null;
=======
        Token char_literal56=null;
>>>>>>> other
        MViewParser.negationModifier_return negate = null;

        MViewParser.pointcutActorPropDecl_return apdref = null;

<<<<<<< local
        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls52 = null;
=======
        MViewParser.pointcutActorPropDecls_return pointcutActorPropDecls57 = null;
>>>>>>> other


<<<<<<< local
        Object char_literal51_tree=null;
=======
        Object char_literal56_tree=null;
>>>>>>> other

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:460:2: ( (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:460:5: (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:452:2: ( (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )? )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:452:5: (negate= negationModifier )? apdref= pointcutActorPropDecl[$declClass] ( ',' pointcutActorPropDecls[$prop,$declClass] )?
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:460:5: (negate= negationModifier )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:452:5: (negate= negationModifier )?
>>>>>>> other
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==59) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:460:6: negate= negationModifier
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:452:6: negate= negationModifier
>>>>>>> other
                    {
                    pushFollow(FOLLOW_negationModifier_in_pointcutActorPropDecls1168);
                    negate=negationModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, negate.getTree());

                    }
                    break;

            }

<<<<<<< local
            pushFollow(FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1175);
=======
            pushFollow(FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1174);
>>>>>>> other
            apdref=pointcutActorPropDecl(declClass);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, apdref.getTree());
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:460:73: ( ',' pointcutActorPropDecls[$prop,$declClass] )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:452:73: ( ',' pointcutActorPropDecls[$prop,$declClass] )?
>>>>>>> other
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==29) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:460:75: ',' pointcutActorPropDecls[$prop,$declClass]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:452:75: ',' pointcutActorPropDecls[$prop,$declClass]
>>>>>>> other
                    {
<<<<<<< local
                    char_literal51=(Token)match(input,29,FOLLOW_29_in_pointcutActorPropDecls1180); if (state.failed) return retval;
=======
                    char_literal56=(Token)match(input,29,FOLLOW_29_in_pointcutActorPropDecls1179); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal51_tree = (Object)adaptor.create(char_literal51);
                    adaptor.addChild(root_0, char_literal51_tree);
=======
                    char_literal56_tree = (Object)adaptor.create(char_literal56);
                    adaptor.addChild(root_0, char_literal56_tree);
>>>>>>> other
                    }
<<<<<<< local
                    pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1182);
                    pointcutActorPropDecls52=pointcutActorPropDecls(prop, declClass);
=======
                    pushFollow(FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1181);
                    pointcutActorPropDecls57=pointcutActorPropDecls(prop, declClass);
>>>>>>> other

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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:471:1: pointcutActorPropDecl[Class<? extends Declaration> declClass] returns [SimpleReference<? extends Declaration> relation] : name= Identifier ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:463:1: pointcutActorPropDecl[Class<? extends Declaration> declClass] returns [SimpleReference<? extends Declaration> relation] : name= Identifier ;
>>>>>>> other
    public final MViewParser.pointcutActorPropDecl_return pointcutActorPropDecl(Class<? extends Declaration> declClass) throws RecognitionException {
        MViewParser.pointcutActorPropDecl_return retval = new MViewParser.pointcutActorPropDecl_return();
        retval.start = input.LT(1);
        int pointcutActorPropDecl_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;

        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:472:2: (name= Identifier )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:472:5: name= Identifier
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:464:2: (name= Identifier )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:464:5: name= Identifier
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutActorPropDecl1207); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_pointcutActorPropDecl1206); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:480:1: adviceDeclaration returns [Advice advice] : avkw= 'advice' adviceBody[$advice] ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:472:1: adviceDeclaration returns [Advice advice] : avkw= 'advice' adviceBody[$advice] ;
>>>>>>> other
    public final MViewParser.adviceDeclaration_return adviceDeclaration() throws RecognitionException {
        MViewParser.adviceDeclaration_return retval = new MViewParser.adviceDeclaration_return();
        retval.start = input.LT(1);
        int adviceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token avkw=null;
<<<<<<< local
        MViewParser.adviceBody_return adviceBody53 = null;
=======
        MViewParser.adviceBody_return adviceBody58 = null;
>>>>>>> other


        Object avkw_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:481:2: (avkw= 'advice' adviceBody[$advice] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:481:4: avkw= 'advice' adviceBody[$advice]
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:473:2: (avkw= 'advice' adviceBody[$advice] )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:473:4: avkw= 'advice' adviceBody[$advice]
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            avkw=(Token)match(input,43,FOLLOW_43_in_adviceDeclaration1230); if (state.failed) return retval;
=======
            avkw=(Token)match(input,43,FOLLOW_43_in_adviceDeclaration1229); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            avkw_tree = (Object)adaptor.create(avkw);
            adaptor.addChild(root_0, avkw_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.advice = new Advice();
              			setKeyword(retval.advice,avkw);
              		
            }
<<<<<<< local
            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration1234);
            adviceBody53=adviceBody(retval.advice);
=======
            pushFollow(FOLLOW_adviceBody_in_adviceDeclaration1233);
            adviceBody58=adviceBody(retval.advice);
>>>>>>> other

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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:488:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:480:1: adviceBody[Advice advice] : '{' ( adviceBodyDeclaration[$advice] )* '}' ;
>>>>>>> other
    public final MViewParser.adviceBody_return adviceBody(Advice advice) throws RecognitionException {
        MViewParser.adviceBody_return retval = new MViewParser.adviceBody_return();
        retval.start = input.LT(1);
        int adviceBody_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token char_literal54=null;
        Token char_literal56=null;
        MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration55 = null;
=======
        Token char_literal59=null;
        Token char_literal61=null;
        MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration60 = null;
>>>>>>> other


<<<<<<< local
        Object char_literal54_tree=null;
        Object char_literal56_tree=null;
=======
        Object char_literal59_tree=null;
        Object char_literal61_tree=null;
>>>>>>> other

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:489:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:489:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:481:2: ( '{' ( adviceBodyDeclaration[$advice] )* '}' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:481:4: '{' ( adviceBodyDeclaration[$advice] )* '}'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal54=(Token)match(input,24,FOLLOW_24_in_adviceBody1249); if (state.failed) return retval;
=======
            char_literal59=(Token)match(input,24,FOLLOW_24_in_adviceBody1248); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal54_tree = (Object)adaptor.create(char_literal54);
            adaptor.addChild(root_0, char_literal54_tree);
=======
            char_literal59_tree = (Object)adaptor.create(char_literal59);
            adaptor.addChild(root_0, char_literal59_tree);
>>>>>>> other
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:489:8: ( adviceBodyDeclaration[$advice] )*
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:481:8: ( adviceBodyDeclaration[$advice] )*
>>>>>>> other
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

<<<<<<< local
                if ( (LA30_0==41||(LA30_0>=44 && LA30_0<=45)) ) {
=======
                if ( ((LA30_0>=44 && LA30_0<=45)) ) {
>>>>>>> other
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: adviceBodyDeclaration[$advice]
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: adviceBodyDeclaration[$advice]
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_adviceBodyDeclaration_in_adviceBody1250);
            	    adviceBodyDeclaration60=adviceBodyDeclaration(advice);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceBodyDeclaration60.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

<<<<<<< local
            char_literal56=(Token)match(input,25,FOLLOW_25_in_adviceBody1255); if (state.failed) return retval;
=======
            char_literal61=(Token)match(input,25,FOLLOW_25_in_adviceBody1254); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal56_tree = (Object)adaptor.create(char_literal56);
            adaptor.addChild(root_0, char_literal56_tree);
=======
            char_literal61_tree = (Object)adaptor.create(char_literal61);
            adaptor.addChild(root_0, char_literal61_tree);
>>>>>>> other
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:493:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] | adviceInstanceDeclaration[$advice] );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:485:1: adviceBodyDeclaration[Advice advice] : ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] );
>>>>>>> other
    public final MViewParser.adviceBodyDeclaration_return adviceBodyDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceBodyDeclaration_return retval = new MViewParser.adviceBodyDeclaration_return();
        retval.start = input.LT(1);
        int adviceBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration57 = null;
=======
        MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration62 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration58 = null;

        MViewParser.adviceInstanceDeclaration_return adviceInstanceDeclaration59 = null;
=======
        MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration63 = null;
>>>>>>> other



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:494:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] | adviceInstanceDeclaration[$advice] )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 44:
                {
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:486:2: ( adviceServiceDeclaration[$advice] | adviceTypeDeclaration[$advice] )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==44) ) {
>>>>>>> other
                alt31=1;
<<<<<<< local
                }
                break;
            case 45:
                {
=======
            }
            else if ( (LA31_0==45) ) {
>>>>>>> other
                alt31=2;
<<<<<<< local
                }
                break;
            case 41:
                {
                alt31=3;
                }
                break;
            default:
=======
            }
            else {
>>>>>>> other
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
<<<<<<< local

=======
>>>>>>> other
            switch (alt31) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:494:4: adviceServiceDeclaration[$advice]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:486:4: adviceServiceDeclaration[$advice]
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1270);
                    adviceServiceDeclaration57=adviceServiceDeclaration(advice);
=======
                    pushFollow(FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1269);
                    adviceServiceDeclaration62=adviceServiceDeclaration(advice);
>>>>>>> other

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceServiceDeclaration62.getTree());

                    }
                    break;
                case 2 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:495:4: adviceTypeDeclaration[$advice]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:487:4: adviceTypeDeclaration[$advice]
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1276);
                    adviceTypeDeclaration58=adviceTypeDeclaration(advice);
=======
                    pushFollow(FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1275);
                    adviceTypeDeclaration63=adviceTypeDeclaration(advice);
>>>>>>> other

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceTypeDeclaration63.getTree());

                    }
                    break;
<<<<<<< local
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:496:4: adviceInstanceDeclaration[$advice]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_adviceInstanceDeclaration_in_adviceBodyDeclaration1282);
                    adviceInstanceDeclaration59=adviceInstanceDeclaration(advice);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, adviceInstanceDeclaration59.getTree());

                    }
                    break;
=======
>>>>>>> other

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:500:1: adviceServiceDeclaration[Advice advice] : svkw= 'service' ':' service= serviceReferenceDeclaration ';' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:491:1: adviceServiceDeclaration[Advice advice] : svkw= 'service' ':' service= serviceReferenceDeclaration ';' ;
>>>>>>> other
    public final MViewParser.adviceServiceDeclaration_return adviceServiceDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceServiceDeclaration_return retval = new MViewParser.adviceServiceDeclaration_return();
        retval.start = input.LT(1);
        int adviceServiceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token svkw=null;
<<<<<<< local
        Token char_literal60=null;
        Token char_literal61=null;
=======
        Token char_literal64=null;
        Token char_literal65=null;
>>>>>>> other
        MViewParser.serviceReferenceDeclaration_return service = null;


        Object svkw_tree=null;
        Object char_literal64_tree=null;
        Object char_literal65_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:501:2: (svkw= 'service' ':' service= serviceReferenceDeclaration ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:501:4: svkw= 'service' ':' service= serviceReferenceDeclaration ';'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:492:2: (svkw= 'service' ':' service= serviceReferenceDeclaration ';' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:492:4: svkw= 'service' ':' service= serviceReferenceDeclaration ';'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            svkw=(Token)match(input,44,FOLLOW_44_in_adviceServiceDeclaration1300); if (state.failed) return retval;
=======
            svkw=(Token)match(input,44,FOLLOW_44_in_adviceServiceDeclaration1293); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            svkw_tree = (Object)adaptor.create(svkw);
            adaptor.addChild(root_0, svkw_tree);
            }
<<<<<<< local
            char_literal60=(Token)match(input,35,FOLLOW_35_in_adviceServiceDeclaration1302); if (state.failed) return retval;
=======
            char_literal64=(Token)match(input,35,FOLLOW_35_in_adviceServiceDeclaration1295); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal60_tree = (Object)adaptor.create(char_literal60);
            adaptor.addChild(root_0, char_literal60_tree);
=======
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
>>>>>>> other
            }
<<<<<<< local
            pushFollow(FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1306);
=======
            pushFollow(FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1299);
>>>>>>> other
            service=serviceReferenceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, service.getTree());
<<<<<<< local
            char_literal61=(Token)match(input,26,FOLLOW_26_in_adviceServiceDeclaration1308); if (state.failed) return retval;
=======
            char_literal65=(Token)match(input,26,FOLLOW_26_in_adviceServiceDeclaration1301); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal61_tree = (Object)adaptor.create(char_literal61);
            adaptor.addChild(root_0, char_literal61_tree);
=======
            char_literal65_tree = (Object)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:508:1: adviceTypeDeclaration[Advice advice] : tpkw= 'type' ':' avtype= adviceType ';' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:499:1: adviceTypeDeclaration[Advice advice] : tpkw= 'type' ':' avtype= adviceType ';' ;
>>>>>>> other
    public final MViewParser.adviceTypeDeclaration_return adviceTypeDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceTypeDeclaration_return retval = new MViewParser.adviceTypeDeclaration_return();
        retval.start = input.LT(1);
        int adviceTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token tpkw=null;
<<<<<<< local
        Token char_literal62=null;
        Token char_literal63=null;
=======
        Token char_literal66=null;
        Token char_literal67=null;
>>>>>>> other
        MViewParser.adviceType_return avtype = null;


        Object tpkw_tree=null;
        Object char_literal66_tree=null;
        Object char_literal67_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:509:2: (tpkw= 'type' ':' avtype= adviceType ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:509:4: tpkw= 'type' ':' avtype= adviceType ';'
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:500:2: (tpkw= 'type' ':' avtype= adviceType ';' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:500:4: tpkw= 'type' ':' avtype= adviceType ';'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            tpkw=(Token)match(input,45,FOLLOW_45_in_adviceTypeDeclaration1327); if (state.failed) return retval;
=======
            tpkw=(Token)match(input,45,FOLLOW_45_in_adviceTypeDeclaration1320); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            tpkw_tree = (Object)adaptor.create(tpkw);
            adaptor.addChild(root_0, tpkw_tree);
            }
<<<<<<< local
            char_literal62=(Token)match(input,35,FOLLOW_35_in_adviceTypeDeclaration1329); if (state.failed) return retval;
=======
            char_literal66=(Token)match(input,35,FOLLOW_35_in_adviceTypeDeclaration1322); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal62_tree = (Object)adaptor.create(char_literal62);
            adaptor.addChild(root_0, char_literal62_tree);
=======
            char_literal66_tree = (Object)adaptor.create(char_literal66);
            adaptor.addChild(root_0, char_literal66_tree);
>>>>>>> other
            }
<<<<<<< local
            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration1333);
=======
            pushFollow(FOLLOW_adviceType_in_adviceTypeDeclaration1326);
>>>>>>> other
            avtype=adviceType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, avtype.getTree());
<<<<<<< local
            char_literal63=(Token)match(input,26,FOLLOW_26_in_adviceTypeDeclaration1335); if (state.failed) return retval;
=======
            char_literal67=(Token)match(input,26,FOLLOW_26_in_adviceTypeDeclaration1328); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal63_tree = (Object)adaptor.create(char_literal63);
            adaptor.addChild(root_0, char_literal63_tree);
=======
            char_literal67_tree = (Object)adaptor.create(char_literal67);
            adaptor.addChild(root_0, char_literal67_tree);
>>>>>>> other
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

<<<<<<< local
    public static class adviceInstanceDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "adviceInstanceDeclaration"
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:515:1: adviceInstanceDeclaration[Advice advice] : inskw= 'instance' ':' instance= instanceReferenceDeclaration ';' ;
    public final MViewParser.adviceInstanceDeclaration_return adviceInstanceDeclaration(Advice advice) throws RecognitionException {
        MViewParser.adviceInstanceDeclaration_return retval = new MViewParser.adviceInstanceDeclaration_return();
        retval.start = input.LT(1);
        int adviceInstanceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token inskw=null;
        Token char_literal64=null;
        Token char_literal65=null;
        MViewParser.instanceReferenceDeclaration_return instance = null;


        Object inskw_tree=null;
        Object char_literal64_tree=null;
        Object char_literal65_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:516:2: (inskw= 'instance' ':' instance= instanceReferenceDeclaration ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:516:4: inskw= 'instance' ':' instance= instanceReferenceDeclaration ';'
            {
            root_0 = (Object)adaptor.nil();

            inskw=(Token)match(input,41,FOLLOW_41_in_adviceInstanceDeclaration1351); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            inskw_tree = (Object)adaptor.create(inskw);
            adaptor.addChild(root_0, inskw_tree);
            }
            char_literal64=(Token)match(input,35,FOLLOW_35_in_adviceInstanceDeclaration1353); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
            }
            pushFollow(FOLLOW_instanceReferenceDeclaration_in_adviceInstanceDeclaration1357);
            instance=instanceReferenceDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, instance.getTree());
            char_literal65=(Token)match(input,26,FOLLOW_26_in_adviceInstanceDeclaration1359); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = (Object)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);
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
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:522:1: instanceReferenceDeclaration returns [SimpleReference<Instance> relation] : name= Identifier ;
    public final MViewParser.instanceReferenceDeclaration_return instanceReferenceDeclaration() throws RecognitionException {
        MViewParser.instanceReferenceDeclaration_return retval = new MViewParser.instanceReferenceDeclaration_return();
        retval.start = input.LT(1);
        int instanceReferenceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;

        Object name_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:523:2: (name= Identifier )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:523:5: name= Identifier
            {
            root_0 = (Object)adaptor.nil();

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceReferenceDeclaration1380); if (state.failed) return retval;
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

=======
>>>>>>> other
    public static class componentDeclaration_return extends ParserRuleReturnScope {
        public Component element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentDeclaration"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:534:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier componentBody[$element] ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:512:1: componentDeclaration returns [Component element] : compkw= 'component' name= Identifier componentBody[$element] ;
>>>>>>> other
    public final MViewParser.componentDeclaration_return componentDeclaration() throws RecognitionException {
        MViewParser.componentDeclaration_return retval = new MViewParser.componentDeclaration_return();
        retval.start = input.LT(1);
        int componentDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token compkw=null;
        Token name=null;
<<<<<<< local
        MViewParser.componentBody_return componentBody66 = null;
=======
        MViewParser.componentBody_return componentBody68 = null;
>>>>>>> other


        Object compkw_tree=null;
        Object name_tree=null;

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:535:2: (compkw= 'component' name= Identifier componentBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:535:5: compkw= 'component' name= Identifier componentBody[$element]
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:513:2: (compkw= 'component' name= Identifier componentBody[$element] )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:513:5: compkw= 'component' name= Identifier componentBody[$element]
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            compkw=(Token)match(input,39,FOLLOW_39_in_componentDeclaration1407); if (state.failed) return retval;
=======
            compkw=(Token)match(input,39,FOLLOW_39_in_componentDeclaration1355); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            compkw_tree = (Object)adaptor.create(compkw);
            adaptor.addChild(root_0, compkw_tree);
            }
<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration1411); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_componentDeclaration1359); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

                 			retval.element = new Component(new SimpleNameSignature((name!=null?name.getText():null))); 
                 			setKeyword(retval.element,compkw);
                 			setLocation(retval.element,name,"__NAME");
              		
            }
<<<<<<< local
            pushFollow(FOLLOW_componentBody_in_componentDeclaration1415);
            componentBody66=componentBody(retval.element);
=======
            pushFollow(FOLLOW_componentBody_in_componentDeclaration1363);
            componentBody68=componentBody(retval.element);
>>>>>>> other

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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 40, componentDeclaration_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 38, componentDeclaration_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "componentDeclaration"

    public static class componentBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentBody"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:543:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:521:1: componentBody[Component element] : '{' ( componentBodyDeclaration[$element] )* '}' ;
>>>>>>> other
    public final MViewParser.componentBody_return componentBody(Component element) throws RecognitionException {
        MViewParser.componentBody_return retval = new MViewParser.componentBody_return();
        retval.start = input.LT(1);
        int componentBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal69=null;
<<<<<<< local
        MViewParser.componentBodyDeclaration_return componentBodyDeclaration68 = null;
=======
        Token char_literal71=null;
        MViewParser.componentBodyDeclaration_return componentBodyDeclaration70 = null;
>>>>>>> other


<<<<<<< local
        Object char_literal67_tree=null;
=======
>>>>>>> other
        Object char_literal69_tree=null;
        Object char_literal71_tree=null;

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:544:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:544:4: '{' ( componentBodyDeclaration[$element] )* '}'
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:522:2: ( '{' ( componentBodyDeclaration[$element] )* '}' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:522:4: '{' ( componentBodyDeclaration[$element] )* '}'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal67=(Token)match(input,24,FOLLOW_24_in_componentBody1437); if (state.failed) return retval;
=======
            char_literal69=(Token)match(input,24,FOLLOW_24_in_componentBody1385); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal67_tree = (Object)adaptor.create(char_literal67);
            adaptor.addChild(root_0, char_literal67_tree);
=======
            char_literal69_tree = (Object)adaptor.create(char_literal69);
            adaptor.addChild(root_0, char_literal69_tree);
>>>>>>> other
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:544:8: ( componentBodyDeclaration[$element] )*
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:522:8: ( componentBodyDeclaration[$element] )*
>>>>>>> other
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=46 && LA32_0<=47)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: componentBodyDeclaration[$element]
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: componentBodyDeclaration[$element]
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_componentBodyDeclaration_in_componentBody1387);
            	    componentBodyDeclaration70=componentBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, componentBodyDeclaration70.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

<<<<<<< local
            char_literal69=(Token)match(input,25,FOLLOW_25_in_componentBody1443); if (state.failed) return retval;
=======
            char_literal71=(Token)match(input,25,FOLLOW_25_in_componentBody1391); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal69_tree = (Object)adaptor.create(char_literal69);
            adaptor.addChild(root_0, char_literal69_tree);
=======
            char_literal71_tree = (Object)adaptor.create(char_literal71);
            adaptor.addChild(root_0, char_literal71_tree);
>>>>>>> other
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 41, componentBody_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 39, componentBody_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "componentBody"

    public static class componentBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "componentBodyDeclaration"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:548:1: componentBodyDeclaration[Component element] : ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:526:1: componentBodyDeclaration[Component element] : ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] );
>>>>>>> other
    public final MViewParser.componentBodyDeclaration_return componentBodyDeclaration(Component element) throws RecognitionException {
        MViewParser.componentBodyDeclaration_return retval = new MViewParser.componentBodyDeclaration_return();
        retval.start = input.LT(1);
        int componentBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration70 = null;
=======
        MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration72 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration71 = null;
=======
        MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration73 = null;
>>>>>>> other



        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:549:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:527:2: ( moduleRequireDependencyDeclaration[$element] | moduleProvideDependencyDeclaration[$element] )
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:549:4: moduleRequireDependencyDeclaration[$element]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:527:4: moduleRequireDependencyDeclaration[$element]
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1461);
                    moduleRequireDependencyDeclaration70=moduleRequireDependencyDeclaration(element);
=======
                    pushFollow(FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1409);
                    moduleRequireDependencyDeclaration72=moduleRequireDependencyDeclaration(element);
>>>>>>> other

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleRequireDependencyDeclaration72.getTree());

                    }
                    break;
                case 2 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:550:4: moduleProvideDependencyDeclaration[$element]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:528:4: moduleProvideDependencyDeclaration[$element]
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1467);
                    moduleProvideDependencyDeclaration71=moduleProvideDependencyDeclaration(element);
=======
                    pushFollow(FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1415);
                    moduleProvideDependencyDeclaration73=moduleProvideDependencyDeclaration(element);
>>>>>>> other

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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 42, componentBodyDeclaration_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 40, componentBodyDeclaration_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:560:1: moduleDependencyBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:538:1: moduleDependencyBody returns [List<SimpleReference> elements] : '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' ;
>>>>>>> other
    public final MViewParser.moduleDependencyBody_return moduleDependencyBody() throws RecognitionException {
        MViewParser.moduleDependencyBody_return retval = new MViewParser.moduleDependencyBody_return();
        retval.start = input.LT(1);
        int moduleDependencyBody_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token char_literal72=null;
        Token char_literal73=null;
=======
        Token char_literal74=null;
        Token char_literal75=null;
>>>>>>> other
        MViewParser.commaSeparatedBodyDecls_return decls = null;


<<<<<<< local
        Object char_literal72_tree=null;
        Object char_literal73_tree=null;
=======
        Object char_literal74_tree=null;
        Object char_literal75_tree=null;
>>>>>>> other

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:562:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:562:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:540:2: ( '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:540:4: '{' (decls= commaSeparatedBodyDecls[Interface.class] )? '}'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal72=(Token)match(input,24,FOLLOW_24_in_moduleDependencyBody1495); if (state.failed) return retval;
=======
            char_literal74=(Token)match(input,24,FOLLOW_24_in_moduleDependencyBody1443); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal72_tree = (Object)adaptor.create(char_literal72);
            adaptor.addChild(root_0, char_literal72_tree);
=======
            char_literal74_tree = (Object)adaptor.create(char_literal74);
            adaptor.addChild(root_0, char_literal74_tree);
>>>>>>> other
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:562:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:540:8: (decls= commaSeparatedBodyDecls[Interface.class] )?
>>>>>>> other
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==Identifier) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:562:9: decls= commaSeparatedBodyDecls[Interface.class]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:540:9: decls= commaSeparatedBodyDecls[Interface.class]
>>>>>>> other
                    {
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1448);
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

<<<<<<< local
            char_literal73=(Token)match(input,25,FOLLOW_25_in_moduleDependencyBody1508); if (state.failed) return retval;
=======
            char_literal75=(Token)match(input,25,FOLLOW_25_in_moduleDependencyBody1456); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal73_tree = (Object)adaptor.create(char_literal73);
            adaptor.addChild(root_0, char_literal73_tree);
=======
            char_literal75_tree = (Object)adaptor.create(char_literal75);
            adaptor.addChild(root_0, char_literal75_tree);
>>>>>>> other
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 43, moduleDependencyBody_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 41, moduleDependencyBody_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "moduleDependencyBody"

    public static class moduleRequireDependencyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleRequireDependencyDeclaration"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:566:1: moduleRequireDependencyDeclaration[Module element] : rekw= 'require' rd= moduleDependencyBody ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:544:1: moduleRequireDependencyDeclaration[Module element] : rekw= 'require' rd= moduleDependencyBody ;
>>>>>>> other
    public final MViewParser.moduleRequireDependencyDeclaration_return moduleRequireDependencyDeclaration(Module element) throws RecognitionException {
        MViewParser.moduleRequireDependencyDeclaration_return retval = new MViewParser.moduleRequireDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleRequireDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token rekw=null;
        MViewParser.moduleDependencyBody_return rd = null;


        Object rekw_tree=null;

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:567:2: (rekw= 'require' rd= moduleDependencyBody )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:567:4: rekw= 'require' rd= moduleDependencyBody
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:545:2: (rekw= 'require' rd= moduleDependencyBody )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:545:4: rekw= 'require' rd= moduleDependencyBody
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            rekw=(Token)match(input,46,FOLLOW_46_in_moduleRequireDependencyDeclaration1525); if (state.failed) return retval;
=======
            rekw=(Token)match(input,46,FOLLOW_46_in_moduleRequireDependencyDeclaration1473); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            rekw_tree = (Object)adaptor.create(rekw);
            adaptor.addChild(root_0, rekw_tree);
            }
<<<<<<< local
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1529);
=======
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1477);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 44, moduleRequireDependencyDeclaration_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 42, moduleRequireDependencyDeclaration_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "moduleRequireDependencyDeclaration"

    public static class moduleProvideDependencyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleProvideDependencyDeclaration"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:575:1: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:553:1: moduleProvideDependencyDeclaration[Module element] : 'provide' rd= moduleDependencyBody ;
>>>>>>> other
    public final MViewParser.moduleProvideDependencyDeclaration_return moduleProvideDependencyDeclaration(Module element) throws RecognitionException {
        MViewParser.moduleProvideDependencyDeclaration_return retval = new MViewParser.moduleProvideDependencyDeclaration_return();
        retval.start = input.LT(1);
        int moduleProvideDependencyDeclaration_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token string_literal74=null;
=======
        Token string_literal76=null;
>>>>>>> other
        MViewParser.moduleDependencyBody_return rd = null;


<<<<<<< local
        Object string_literal74_tree=null;
=======
        Object string_literal76_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:576:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:576:4: 'provide' rd= moduleDependencyBody
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:554:2: ( 'provide' rd= moduleDependencyBody )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:554:4: 'provide' rd= moduleDependencyBody
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            string_literal74=(Token)match(input,47,FOLLOW_47_in_moduleProvideDependencyDeclaration1544); if (state.failed) return retval;
=======
            string_literal76=(Token)match(input,47,FOLLOW_47_in_moduleProvideDependencyDeclaration1492); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            string_literal74_tree = (Object)adaptor.create(string_literal74);
            adaptor.addChild(root_0, string_literal74_tree);
=======
            string_literal76_tree = (Object)adaptor.create(string_literal76);
            adaptor.addChild(root_0, string_literal76_tree);
>>>>>>> other
            }
<<<<<<< local
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1548);
=======
            pushFollow(FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1496);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 45, moduleProvideDependencyDeclaration_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 43, moduleProvideDependencyDeclaration_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:615:1: applicationDeclaration returns [Application element] : (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:593:1: applicationDeclaration returns [Application element] : (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] ;
>>>>>>> other
    public final MViewParser.applicationDeclaration_return applicationDeclaration() throws RecognitionException {
        MViewParser.applicationDeclaration_return retval = new MViewParser.applicationDeclaration_return();
        retval.start = input.LT(1);
        int applicationDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token appkw=null;
        Token name=null;
        MViewParser.abstractModifier_return abs = null;

<<<<<<< local
        MViewParser.refinementDeclaration_return refinementDeclaration75 = null;
=======
        MViewParser.refinementDeclaration_return refinementDeclaration77 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.applicationBody_return applicationBody76 = null;
=======
        MViewParser.applicationBody_return applicationBody78 = null;
>>>>>>> other


        Object appkw_tree=null;
        Object name_tree=null;

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:616:2: ( (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:616:4: (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element]
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:594:2: ( (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:594:4: (abs= abstractModifier )? appkw= 'application' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element]
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:616:4: (abs= abstractModifier )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:594:4: (abs= abstractModifier )?
>>>>>>> other
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==60) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:616:5: abs= abstractModifier
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:594:5: abs= abstractModifier
>>>>>>> other
                    {
                    pushFollow(FOLLOW_abstractModifier_in_applicationDeclaration1529);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

<<<<<<< local
            appkw=(Token)match(input,40,FOLLOW_40_in_applicationDeclaration1587); if (state.failed) return retval;
=======
            appkw=(Token)match(input,40,FOLLOW_40_in_applicationDeclaration1535); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_applicationDeclaration1591); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_applicationDeclaration1539); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:626:3: ( refinementDeclaration[$element,Application.class] )?
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:604:3: ( refinementDeclaration[$element,Application.class] )?
>>>>>>> other
            int alt36=2;
            int LA36_0 = input.LA(1);

<<<<<<< local
            if ( (LA36_0==50) ) {
=======
            if ( (LA36_0==35) ) {
>>>>>>> other
                alt36=1;
            }
            switch (alt36) {
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:626:4: refinementDeclaration[$element,Application.class]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:604:4: refinementDeclaration[$element,Application.class]
>>>>>>> other
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_applicationDeclaration1547);
                    refinementDeclaration77=refinementDeclaration(retval.element, Application.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration77.getTree());

                    }
                    break;

            }

<<<<<<< local
            pushFollow(FOLLOW_applicationBody_in_applicationDeclaration1606);
            applicationBody76=applicationBody(retval.element);
=======
            pushFollow(FOLLOW_applicationBody_in_applicationDeclaration1554);
            applicationBody78=applicationBody(retval.element);
>>>>>>> other

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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 46, applicationDeclaration_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 44, applicationDeclaration_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "applicationDeclaration"

    public static class applicationBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "applicationBody"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:631:1: applicationBody[Application element] : '{' ( applicationBodyDeclaration[$element] )* '}' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:609:1: applicationBody[Application element] : '{' ( applicationBodyDeclaration[$element] )* '}' ;
>>>>>>> other
    public final MViewParser.applicationBody_return applicationBody(Application element) throws RecognitionException {
        MViewParser.applicationBody_return retval = new MViewParser.applicationBody_return();
        retval.start = input.LT(1);
        int applicationBody_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal79=null;
<<<<<<< local
        MViewParser.applicationBodyDeclaration_return applicationBodyDeclaration78 = null;
=======
        Token char_literal81=null;
        MViewParser.applicationBodyDeclaration_return applicationBodyDeclaration80 = null;
>>>>>>> other


<<<<<<< local
        Object char_literal77_tree=null;
=======
>>>>>>> other
        Object char_literal79_tree=null;
        Object char_literal81_tree=null;

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:632:2: ( '{' ( applicationBodyDeclaration[$element] )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:632:4: '{' ( applicationBodyDeclaration[$element] )* '}'
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:610:2: ( '{' ( applicationBodyDeclaration[$element] )* '}' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:610:4: '{' ( applicationBodyDeclaration[$element] )* '}'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal77=(Token)match(input,24,FOLLOW_24_in_applicationBody1620); if (state.failed) return retval;
=======
            char_literal79=(Token)match(input,24,FOLLOW_24_in_applicationBody1568); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal77_tree = (Object)adaptor.create(char_literal77);
            adaptor.addChild(root_0, char_literal77_tree);
=======
            char_literal79_tree = (Object)adaptor.create(char_literal79);
            adaptor.addChild(root_0, char_literal79_tree);
>>>>>>> other
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:632:8: ( applicationBodyDeclaration[$element] )*
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:610:8: ( applicationBodyDeclaration[$element] )*
>>>>>>> other
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==Identifier||LA37_0==31||LA37_0==39||LA37_0==42||LA37_0==60) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:632:10: applicationBodyDeclaration[$element]
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:610:10: applicationBodyDeclaration[$element]
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_applicationBodyDeclaration_in_applicationBody1572);
            	    applicationBodyDeclaration80=applicationBodyDeclaration(element);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, applicationBodyDeclaration80.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

<<<<<<< local
            char_literal79=(Token)match(input,25,FOLLOW_25_in_applicationBody1630); if (state.failed) return retval;
=======
            char_literal81=(Token)match(input,25,FOLLOW_25_in_applicationBody1578); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal79_tree = (Object)adaptor.create(char_literal79);
            adaptor.addChild(root_0, char_literal79_tree);
=======
            char_literal81_tree = (Object)adaptor.create(char_literal81);
            adaptor.addChild(root_0, char_literal81_tree);
>>>>>>> other
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 47, applicationBody_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 45, applicationBody_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "applicationBody"

    public static class applicationBodyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "applicationBodyDeclaration"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:636:1: applicationBodyDeclaration[Application element] : (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:614:1: applicationBodyDeclaration[Application element] : (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration );
>>>>>>> other
    public final MViewParser.applicationBodyDeclaration_return applicationBodyDeclaration(Application element) throws RecognitionException {
        MViewParser.applicationBodyDeclaration_return retval = new MViewParser.applicationBodyDeclaration_return();
        retval.start = input.LT(1);
        int applicationBodyDeclaration_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.moduleContainerDeclarations_return mod = null;

        MViewParser.hostDeclaration_return hod = null;

        MViewParser.instanceDeclaration_return ind = null;



        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:637:2: (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration )
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:615:2: (mod= moduleContainerDeclarations | hod= hostDeclaration | ind= instanceDeclaration )
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:637:4: mod= moduleContainerDeclarations
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:615:4: mod= moduleContainerDeclarations
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1646);
=======
                    pushFollow(FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1594);
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:641:3: hod= hostDeclaration
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:619:3: hod= hostDeclaration
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_hostDeclaration_in_applicationBodyDeclaration1657);
=======
                    pushFollow(FOLLOW_hostDeclaration_in_applicationBodyDeclaration1605);
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:645:3: ind= instanceDeclaration
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:623:3: ind= instanceDeclaration
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1669);
=======
                    pushFollow(FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1617);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 48, applicationBodyDeclaration_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 46, applicationBodyDeclaration_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "applicationBodyDeclaration"

<<<<<<< local
=======
    public static class deploymentDeclaration_return extends ParserRuleReturnScope {
        public Deployment element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deploymentDeclaration"
    // /Users/marko/hg/mview/src/mview/parser/MView.g:633:1: deploymentDeclaration returns [Deployment element] : (abs= abstractModifier )? appkw= 'deployment' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] ;
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
            // /Users/marko/hg/mview/src/mview/parser/MView.g:634:2: ( (abs= abstractModifier )? appkw= 'deployment' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element] )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:634:4: (abs= abstractModifier )? appkw= 'deployment' name= Identifier ( refinementDeclaration[$element,Application.class] )? applicationBody[$element]
            {
            root_0 = (Object)adaptor.nil();

            // /Users/marko/hg/mview/src/mview/parser/MView.g:634:4: (abs= abstractModifier )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==60) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:634:5: abs= abstractModifier
                    {
                    pushFollow(FOLLOW_abstractModifier_in_deploymentDeclaration1643);
                    abs=abstractModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, abs.getTree());

                    }
                    break;

            }

            appkw=(Token)match(input,48,FOLLOW_48_in_deploymentDeclaration1649); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            appkw_tree = (Object)adaptor.create(appkw);
            adaptor.addChild(root_0, appkw_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_deploymentDeclaration1653); if (state.failed) return retval;
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
            // /Users/marko/hg/mview/src/mview/parser/MView.g:644:3: ( refinementDeclaration[$element,Application.class] )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==35) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:644:4: refinementDeclaration[$element,Application.class]
                    {
                    pushFollow(FOLLOW_refinementDeclaration_in_deploymentDeclaration1661);
                    refinementDeclaration82=refinementDeclaration(retval.element, Application.class);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclaration82.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_applicationBody_in_deploymentDeclaration1668);
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

>>>>>>> other
    public static class instanceDeclaration_return extends ParserRuleReturnScope {
        public Instance element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instanceDeclaration"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:677:1: instanceDeclaration returns [Instance element] : ref= qualifiedDeclarationReference[Module.class] name= Identifier onkw= 'on' hst= Identifier ';' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:654:1: instanceDeclaration returns [Instance element] : tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';' ;
>>>>>>> other
    public final MViewParser.instanceDeclaration_return instanceDeclaration() throws RecognitionException {
        MViewParser.instanceDeclaration_return retval = new MViewParser.instanceDeclaration_return();
        retval.start = input.LT(1);
        int instanceDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token tpe=null;
        Token name=null;
        Token onkw=null;
        Token hst=null;
<<<<<<< local
        Token char_literal80=null;
        MViewParser.qualifiedDeclarationReference_return ref = null;
=======
        Token char_literal84=null;
>>>>>>> other

<<<<<<< local

=======
        Object tpe_tree=null;
>>>>>>> other
        Object name_tree=null;
        Object onkw_tree=null;
        Object hst_tree=null;
        Object char_literal84_tree=null;

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:678:2: (ref= qualifiedDeclarationReference[Module.class] name= Identifier onkw= 'on' hst= Identifier ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:678:4: ref= qualifiedDeclarationReference[Module.class] name= Identifier onkw= 'on' hst= Identifier ';'
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:655:2: (tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:655:4: tpe= Identifier name= Identifier onkw= 'on' hst= Identifier ';'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pushFollow(FOLLOW_qualifiedDeclarationReference_in_instanceDeclaration1702);
            ref=qualifiedDeclarationReference(Module.class);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ref.getTree());
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1707); if (state.failed) return retval;
=======
            tpe=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1691); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tpe_tree = (Object)adaptor.create(tpe);
            adaptor.addChild(root_0, tpe_tree);
            }
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1695); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
<<<<<<< local
            onkw=(Token)match(input,48,FOLLOW_48_in_instanceDeclaration1711); if (state.failed) return retval;
=======
            onkw=(Token)match(input,49,FOLLOW_49_in_instanceDeclaration1699); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            onkw_tree = (Object)adaptor.create(onkw);
            adaptor.addChild(root_0, onkw_tree);
            }
<<<<<<< local
            hst=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1715); if (state.failed) return retval;
=======
            hst=(Token)match(input,Identifier,FOLLOW_Identifier_in_instanceDeclaration1703); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            hst_tree = (Object)adaptor.create(hst);
            adaptor.addChild(root_0, hst_tree);
            }
<<<<<<< local
            char_literal80=(Token)match(input,26,FOLLOW_26_in_instanceDeclaration1717); if (state.failed) return retval;
=======
            char_literal84=(Token)match(input,26,FOLLOW_26_in_instanceDeclaration1705); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal80_tree = (Object)adaptor.create(char_literal80);
            adaptor.addChild(root_0, char_literal80_tree);
=======
            char_literal84_tree = (Object)adaptor.create(char_literal84);
            adaptor.addChild(root_0, char_literal84_tree);
>>>>>>> other
            }
            if ( state.backtracking==0 ) {

              	
              			retval.element = new Instance(new SimpleNameSignature((name!=null?name.getText():null)));
              			setLocation(retval.element,name,"__NAME");

<<<<<<< local
              			SimpleReference<Module> relation = (ref!=null?ref.reference:null);
              			//new SimpleReference<Module>($tpe.text,Module.class);
              			if (relation != null) {
              				retval.element.setType(relation);
=======
              			SimpleReference<Module> modRelation = new SimpleReference<Module>((tpe!=null?tpe.getText():null),Module.class);
              			if (modRelation != null) {
              				retval.element.setType(modRelation);
              				setLocation(modRelation,tpe,tpe);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 49, instanceDeclaration_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 48, instanceDeclaration_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:704:1: hostDeclaration returns [Host element] : hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:681:1: hostDeclaration returns [Host element] : hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';' ;
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:705:2: (hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:705:5: hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';'
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:682:2: (hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:682:5: hkw= 'host' name= Identifier (onkw= 'is' value= StringLiteral )? ';'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            hkw=(Token)match(input,42,FOLLOW_42_in_hostDeclaration1744); if (state.failed) return retval;
=======
            hkw=(Token)match(input,42,FOLLOW_42_in_hostDeclaration1732); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            hkw_tree = (Object)adaptor.create(hkw);
            adaptor.addChild(root_0, hkw_tree);
            }
<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_hostDeclaration1748); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_hostDeclaration1736); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              			
              			retval.element = new Host(new SimpleNameSignature((name!=null?name.getText():null)));
              			setKeyword(retval.element,hkw);
              			setLocation(retval.element,name,"__NAME");
              			
              		
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:711:5: (onkw= 'is' value= StringLiteral )?
            int alt39=2;
            int LA39_0 = input.LA(1);
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:688:5: (onkw= 'is' value= StringLiteral )?
            int alt41=2;
            int LA41_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA39_0==49) ) {
                alt39=1;
=======
            if ( (LA41_0==50) ) {
                alt41=1;
>>>>>>> other
            }
<<<<<<< local
            switch (alt39) {
=======
            switch (alt41) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:711:7: onkw= 'is' value= StringLiteral
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:688:7: onkw= 'is' value= StringLiteral
>>>>>>> other
                    {
<<<<<<< local
                    onkw=(Token)match(input,49,FOLLOW_49_in_hostDeclaration1756); if (state.failed) return retval;
=======
                    onkw=(Token)match(input,50,FOLLOW_50_in_hostDeclaration1744); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
                    onkw_tree = (Object)adaptor.create(onkw);
                    adaptor.addChild(root_0, onkw_tree);
                    }
<<<<<<< local
                    value=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_hostDeclaration1760); if (state.failed) return retval;
=======
                    value=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_hostDeclaration1748); if (state.failed) return retval;
>>>>>>> other
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

<<<<<<< local
            char_literal81=(Token)match(input,26,FOLLOW_26_in_hostDeclaration1767); if (state.failed) return retval;
=======
            char_literal85=(Token)match(input,26,FOLLOW_26_in_hostDeclaration1755); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal81_tree = (Object)adaptor.create(char_literal81);
            adaptor.addChild(root_0, char_literal81_tree);
=======
            char_literal85_tree = (Object)adaptor.create(char_literal85);
            adaptor.addChild(root_0, char_literal85_tree);
>>>>>>> other
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 50, hostDeclaration_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 49, hostDeclaration_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:725:1: moduleContainerDeclarations returns [Module element] : (cod= componentDeclaration | cnd= connectorDeclaration );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:703:1: moduleContainerDeclarations returns [Module element] : (cod= componentDeclaration | cnd= connectorDeclaration );
>>>>>>> other
    public final MViewParser.moduleContainerDeclarations_return moduleContainerDeclarations() throws RecognitionException {
        MViewParser.moduleContainerDeclarations_return retval = new MViewParser.moduleContainerDeclarations_return();
        retval.start = input.LT(1);
        int moduleContainerDeclarations_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.componentDeclaration_return cod = null;

        MViewParser.connectorDeclaration_return cnd = null;



        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:726:2: (cod= componentDeclaration | cnd= connectorDeclaration )
            int alt40=2;
            int LA40_0 = input.LA(1);
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:704:2: (cod= componentDeclaration | cnd= connectorDeclaration )
            int alt42=2;
            int LA42_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA40_0==39) ) {
                alt40=1;
=======
            if ( (LA42_0==39) ) {
                alt42=1;
>>>>>>> other
            }
<<<<<<< local
            else if ( (LA40_0==31||LA40_0==60) ) {
                alt40=2;
=======
            else if ( (LA42_0==31||LA42_0==60) ) {
                alt42=2;
>>>>>>> other
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
<<<<<<< local
            switch (alt40) {
=======
            switch (alt42) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:727:3: cod= componentDeclaration
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:705:3: cod= componentDeclaration
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_componentDeclaration_in_moduleContainerDeclarations1792);
=======
                    pushFollow(FOLLOW_componentDeclaration_in_moduleContainerDeclarations1781);
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:731:3: cnd= connectorDeclaration
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:709:3: cnd= connectorDeclaration
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1803);
=======
                    pushFollow(FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1792);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 51, moduleContainerDeclarations_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 50, moduleContainerDeclarations_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "moduleContainerDeclarations"

    public static class refinementDeclarationSingle_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "refinementDeclarationSingle"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:758:1: refinementDeclarationSingle[RefinableDeclaration element, Class kind] : rfkw= 'refines' rel= refinementDeclarationBody[$kind] ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:736:1: refinementDeclarationSingle[RefinableDeclaration element, Class kind] : rfkw= ':' refinementDeclarationBody[$element,$kind] ;
>>>>>>> other
    public final MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementDeclarationSingle_return retval = new MViewParser.refinementDeclarationSingle_return();
        retval.start = input.LT(1);
        int refinementDeclarationSingle_StartIndex = input.index();
        Object root_0 = null;

        Token rfkw=null;
<<<<<<< local
        MViewParser.refinementDeclarationBody_return rel = null;
=======
        MViewParser.refinementDeclarationBody_return refinementDeclarationBody86 = null;
>>>>>>> other


        Object rfkw_tree=null;

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:759:2: (rfkw= 'refines' rel= refinementDeclarationBody[$kind] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:759:4: rfkw= 'refines' rel= refinementDeclarationBody[$kind]
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:737:2: (rfkw= ':' refinementDeclarationBody[$element,$kind] )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:737:4: rfkw= ':' refinementDeclarationBody[$element,$kind]
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            rfkw=(Token)match(input,50,FOLLOW_50_in_refinementDeclarationSingle1828); if (state.failed) return retval;
=======
            rfkw=(Token)match(input,35,FOLLOW_35_in_refinementDeclarationSingle1817); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            rfkw_tree = (Object)adaptor.create(rfkw);
            adaptor.addChild(root_0, rfkw_tree);
            }
<<<<<<< local
            pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1832);
            rel=refinementDeclarationBody(kind);
=======
            pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1819);
            refinementDeclarationBody86=refinementDeclarationBody(element, kind);
>>>>>>> other

            state._fsp--;
            if (state.failed) return retval;
<<<<<<< local
            if ( state.backtracking==0 ) adaptor.addChild(root_0, rel.getTree());
=======
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationBody86.getTree());
>>>>>>> other
            if ( state.backtracking==0 ) {

<<<<<<< local
              			setKeyword(rel.relation,rfkw);
              			element.addRefinementRelation(rel.relation);
=======
              			setKeyword(element,rfkw);
>>>>>>> other
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 52, refinementDeclarationSingle_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 51, refinementDeclarationSingle_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "refinementDeclarationSingle"

    public static class refinementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "refinementDeclaration"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:766:1: refinementDeclaration[RefinableDeclaration element, Class kind] : refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )* ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:743:1: refinementDeclaration[RefinableDeclaration element, Class kind] : refinementDeclarationSingle[$element,$kind] ( ',' refinementDeclarationBody[$element,$kind] )* ;
>>>>>>> other
    public final MViewParser.refinementDeclaration_return refinementDeclaration(RefinableDeclaration element, Class kind) throws RecognitionException {
        MViewParser.refinementDeclaration_return retval = new MViewParser.refinementDeclaration_return();
        retval.start = input.LT(1);
        int refinementDeclaration_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token char_literal83=null;
        MViewParser.refinementDeclarationBody_return rel = null;
=======
        Token char_literal88=null;
        MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle87 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.refinementDeclarationSingle_return refinementDeclarationSingle82 = null;
=======
        MViewParser.refinementDeclarationBody_return refinementDeclarationBody89 = null;
>>>>>>> other


<<<<<<< local
        Object char_literal83_tree=null;
=======
        Object char_literal88_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:767:2: ( refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:767:4: refinementDeclarationSingle[$element,$kind] ( ',' rel= refinementDeclarationBody[$kind] )*
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:744:2: ( refinementDeclarationSingle[$element,$kind] ( ',' refinementDeclarationBody[$element,$kind] )* )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:744:4: refinementDeclarationSingle[$element,$kind] ( ',' refinementDeclarationBody[$element,$kind] )*
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pushFollow(FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1849);
            refinementDeclarationSingle82=refinementDeclarationSingle(element, kind);
=======
            pushFollow(FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1836);
            refinementDeclarationSingle87=refinementDeclarationSingle(element, kind);
>>>>>>> other

            state._fsp--;
            if (state.failed) return retval;
<<<<<<< local
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationSingle82.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:767:48: ( ',' rel= refinementDeclarationBody[$kind] )*
            loop41:
=======
            if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationSingle87.getTree());
            // /Users/marko/hg/mview/src/mview/parser/MView.g:744:48: ( ',' refinementDeclarationBody[$element,$kind] )*
            loop43:
>>>>>>> other
            do {
<<<<<<< local
                int alt41=2;
                int LA41_0 = input.LA(1);
=======
                int alt43=2;
                int LA43_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                if ( (LA41_0==29) ) {
                    alt41=1;
=======
                if ( (LA43_0==29) ) {
                    alt43=1;
>>>>>>> other
                }


                switch (alt43) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:767:50: ',' rel= refinementDeclarationBody[$kind]
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:744:50: ',' refinementDeclarationBody[$element,$kind]
>>>>>>> other
            	    {
<<<<<<< local
            	    char_literal83=(Token)match(input,29,FOLLOW_29_in_refinementDeclaration1854); if (state.failed) return retval;
=======
            	    char_literal88=(Token)match(input,29,FOLLOW_29_in_refinementDeclaration1841); if (state.failed) return retval;
>>>>>>> other
            	    if ( state.backtracking==0 ) {
<<<<<<< local
            	    char_literal83_tree = (Object)adaptor.create(char_literal83);
            	    adaptor.addChild(root_0, char_literal83_tree);
=======
            	    char_literal88_tree = (Object)adaptor.create(char_literal88);
            	    adaptor.addChild(root_0, char_literal88_tree);
>>>>>>> other
            	    }
<<<<<<< local
            	    pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclaration1858);
            	    rel=refinementDeclarationBody(kind);
=======
            	    pushFollow(FOLLOW_refinementDeclarationBody_in_refinementDeclaration1843);
            	    refinementDeclarationBody89=refinementDeclarationBody(element, kind);
>>>>>>> other

            	    state._fsp--;
            	    if (state.failed) return retval;
<<<<<<< local
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, rel.getTree());
            	    if ( state.backtracking==0 ) {

            	      			element.addRefinementRelation(rel.relation);
            	      		
            	    }
=======
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, refinementDeclarationBody89.getTree());
>>>>>>> other

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
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 53, refinementDeclaration_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 52, refinementDeclaration_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "refinementDeclaration"

    public static class refinementDeclarationBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "refinementDeclarationBody"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:773:1: refinementDeclarationBody[Class kind] returns [RefinementRelation relation] : parent= qualifiedDeclarationReference[$kind] ;
    public final MViewParser.refinementDeclarationBody_return refinementDeclarationBody(Class kind) throws RecognitionException {
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:748:1: refinementDeclarationBody[RefinableDeclaration element, Class kind] : parent= refinementParentDeclaration[$kind] ;
    public final MViewParser.refinementDeclarationBody_return refinementDeclarationBody(RefinableDeclaration element, Class kind) throws RecognitionException {
>>>>>>> other
        MViewParser.refinementDeclarationBody_return retval = new MViewParser.refinementDeclarationBody_return();
        retval.start = input.LT(1);
        int refinementDeclarationBody_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        MViewParser.qualifiedDeclarationReference_return parent = null;
=======
        MViewParser.refinementParentDeclaration_return parent = null;
>>>>>>> other



        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:774:2: (parent= qualifiedDeclarationReference[$kind] )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:774:4: parent= qualifiedDeclarationReference[$kind]
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:749:2: (parent= refinementParentDeclaration[$kind] )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:749:4: parent= refinementParentDeclaration[$kind]
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pushFollow(FOLLOW_qualifiedDeclarationReference_in_refinementDeclarationBody1886);
            parent=qualifiedDeclarationReference(kind);
=======
            pushFollow(FOLLOW_refinementParentDeclaration_in_refinementDeclarationBody1864);
            parent=refinementParentDeclaration(kind);
>>>>>>> other

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, parent.getTree());
            if ( state.backtracking==0 ) {

<<<<<<< local
              			retval.relation = new RefinementRelation(parent.reference);		
=======
              			RefinementRelation relation = new RefinementRelation((parent!=null?parent.reference:null));
              			element.addRefinementRelation(relation);
>>>>>>> other
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 54, refinementDeclarationBody_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 53, refinementDeclarationBody_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "refinementDeclarationBody"

<<<<<<< local
    public static class qualifiedDeclarationReference_return extends ParserRuleReturnScope {
=======
    public static class refinementParentDeclaration_return extends ParserRuleReturnScope {
>>>>>>> other
        public SimpleReference reference;
        Object tree;
        public Object getTree() { return tree; }
    };

<<<<<<< local
    // $ANTLR start "qualifiedDeclarationReference"
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:784:1: qualifiedDeclarationReference[Class kind] returns [SimpleReference reference] : name= Identifier ( '.' namex= Identifier )* ;
    public final MViewParser.qualifiedDeclarationReference_return qualifiedDeclarationReference(Class kind) throws RecognitionException {
        MViewParser.qualifiedDeclarationReference_return retval = new MViewParser.qualifiedDeclarationReference_return();
=======
    // $ANTLR start "refinementParentDeclaration"
    // /Users/marko/hg/mview/src/mview/parser/MView.g:756:1: refinementParentDeclaration[Class kind] returns [SimpleReference reference] : name= Identifier ( '.' namex= Identifier )* ;
    public final MViewParser.refinementParentDeclaration_return refinementParentDeclaration(Class kind) throws RecognitionException {
        MViewParser.refinementParentDeclaration_return retval = new MViewParser.refinementParentDeclaration_return();
>>>>>>> other
        retval.start = input.LT(1);
<<<<<<< local
        int qualifiedDeclarationReference_StartIndex = input.index();
=======
        int refinementParentDeclaration_StartIndex = input.index();
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:793:2: (name= Identifier ( '.' namex= Identifier )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:793:4: name= Identifier ( '.' namex= Identifier )*
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:764:2: (name= Identifier ( '.' namex= Identifier )* )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:764:4: name= Identifier ( '.' namex= Identifier )*
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_qualifiedDeclarationReference1919); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_refinementParentDeclaration1894); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:799:3: ( '.' namex= Identifier )*
            loop42:
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:770:3: ( '.' namex= Identifier )*
            loop44:
>>>>>>> other
            do {
<<<<<<< local
                int alt42=2;
                int LA42_0 = input.LA(1);
=======
                int alt44=2;
                int LA44_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                if ( (LA42_0==51) ) {
                    alt42=1;
=======
                if ( (LA44_0==51) ) {
                    alt44=1;
>>>>>>> other
                }


                switch (alt44) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:799:4: '.' namex= Identifier
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:770:4: '.' namex= Identifier
>>>>>>> other
            	    {
<<<<<<< local
            	    char_literal84=(Token)match(input,51,FOLLOW_51_in_qualifiedDeclarationReference1926); if (state.failed) return retval;
=======
            	    char_literal90=(Token)match(input,51,FOLLOW_51_in_refinementParentDeclaration1901); if (state.failed) return retval;
>>>>>>> other
            	    if ( state.backtracking==0 ) {
<<<<<<< local
            	    char_literal84_tree = (Object)adaptor.create(char_literal84);
            	    adaptor.addChild(root_0, char_literal84_tree);
=======
            	    char_literal90_tree = (Object)adaptor.create(char_literal90);
            	    adaptor.addChild(root_0, char_literal90_tree);
>>>>>>> other
            	    }
<<<<<<< local
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_qualifiedDeclarationReference1930); if (state.failed) return retval;
=======
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_refinementParentDeclaration1905); if (state.failed) return retval;
>>>>>>> other
            	    if ( state.backtracking==0 ) {
            	    namex_tree = (Object)adaptor.create(namex);
            	    adaptor.addChild(root_0, namex_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      				if (target != null) {
            	      //					setLocation($
            	      					retval.reference = new SimpleReference(target,(namex!=null?namex.getText():null),RefinableDeclaration.class);
            	      					target = new SimpleReference(target.clone(),(namex!=null?namex.getText():null),RefinableDeclaration.class);
<<<<<<< local
=======

>>>>>>> other
            	      				} else {
            	      					retval.reference = new SimpleReference((name!=null?name.getText():null),kind);
            	      				}
<<<<<<< local
            	      				//start = namex;
=======
            	      				start = namex;
>>>>>>> other
            	      				end = namex;
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

<<<<<<< local
              	check_null(retval.reference);
              	setLocation(retval.reference, start, end);
=======
                check_null(retval.reference);
                setLocation(retval.reference, start, end);
>>>>>>> other

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 55, qualifiedDeclarationReference_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 54, refinementParentDeclaration_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
<<<<<<< local
    // $ANTLR end "qualifiedDeclarationReference"
=======
    // $ANTLR end "refinementParentDeclaration"
>>>>>>> other

    public static class commaSeparatedBodyDecls_return extends ParserRuleReturnScope {
        public List<SimpleReference> elements;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "commaSeparatedBodyDecls"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:814:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:790:1: commaSeparatedBodyDecls[Class targetType] returns [List<SimpleReference> elements] : id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? ;
>>>>>>> other
    public final MViewParser.commaSeparatedBodyDecls_return commaSeparatedBodyDecls(Class targetType) throws RecognitionException {
        MViewParser.commaSeparatedBodyDecls_return retval = new MViewParser.commaSeparatedBodyDecls_return();
        retval.start = input.LT(1);
        int commaSeparatedBodyDecls_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
<<<<<<< local
        Token char_literal85=null;
=======
        Token char_literal91=null;
>>>>>>> other
        MViewParser.commaSeparatedBodyDecls_return decls = null;


        Object id_tree=null;
        Object char_literal91_tree=null;

         retval.elements = new ArrayList<SimpleReference>(); 
        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:816:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:816:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:792:2: (id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )? )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:792:4: id= Identifier ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls1961); if (state.failed) return retval;
=======
            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_commaSeparatedBodyDecls1939); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:816:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt43=2;
            int LA43_0 = input.LA(1);
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:792:18: ( ',' decls= commaSeparatedBodyDecls[$targetType] )?
            int alt45=2;
            int LA45_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA43_0==29) ) {
                alt43=1;
=======
            if ( (LA45_0==29) ) {
                alt45=1;
>>>>>>> other
            }
<<<<<<< local
            switch (alt43) {
=======
            switch (alt45) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:816:19: ',' decls= commaSeparatedBodyDecls[$targetType]
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:792:19: ',' decls= commaSeparatedBodyDecls[$targetType]
>>>>>>> other
                    {
<<<<<<< local
                    char_literal85=(Token)match(input,29,FOLLOW_29_in_commaSeparatedBodyDecls1964); if (state.failed) return retval;
=======
                    char_literal91=(Token)match(input,29,FOLLOW_29_in_commaSeparatedBodyDecls1942); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal85_tree = (Object)adaptor.create(char_literal85);
                    adaptor.addChild(root_0, char_literal85_tree);
=======
                    char_literal91_tree = (Object)adaptor.create(char_literal91);
                    adaptor.addChild(root_0, char_literal91_tree);
>>>>>>> other
                    }
<<<<<<< local
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1968);
=======
                    pushFollow(FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1946);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 56, commaSeparatedBodyDecls_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 55, commaSeparatedBodyDecls_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:830:1: adviceType returns [Modifier value] : ( 'before' | 'after' | 'around' );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:806:1: adviceType returns [Modifier value] : ( 'before' | 'after' | 'around' );
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:831:2: ( 'before' | 'after' | 'around' )
            int alt44=3;
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:807:2: ( 'before' | 'after' | 'around' )
            int alt46=3;
>>>>>>> other
            switch ( input.LA(1) ) {
            case 52:
                {
                alt46=1;
                }
                break;
            case 53:
                {
                alt46=2;
                }
                break;
            case 54:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

<<<<<<< local
            switch (alt44) {
=======
            switch (alt46) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:831:4: 'before'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:807:4: 'before'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal86=(Token)match(input,52,FOLLOW_52_in_adviceType1997); if (state.failed) return retval;
=======
                    string_literal92=(Token)match(input,52,FOLLOW_52_in_adviceType1975); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal86_tree = (Object)adaptor.create(string_literal86);
                    adaptor.addChild(root_0, string_literal86_tree);
=======
                    string_literal92_tree = (Object)adaptor.create(string_literal92);
                    adaptor.addChild(root_0, string_literal92_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Before();
                    }

                    }
                    break;
                case 2 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:832:4: 'after'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:808:4: 'after'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal87=(Token)match(input,53,FOLLOW_53_in_adviceType2004); if (state.failed) return retval;
=======
                    string_literal93=(Token)match(input,53,FOLLOW_53_in_adviceType1982); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal87_tree = (Object)adaptor.create(string_literal87);
                    adaptor.addChild(root_0, string_literal87_tree);
=======
                    string_literal93_tree = (Object)adaptor.create(string_literal93);
                    adaptor.addChild(root_0, string_literal93_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new After();
                    }

                    }
                    break;
                case 3 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:833:4: 'around'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:809:4: 'around'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal88=(Token)match(input,54,FOLLOW_54_in_adviceType2011); if (state.failed) return retval;
=======
                    string_literal94=(Token)match(input,54,FOLLOW_54_in_adviceType1989); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal88_tree = (Object)adaptor.create(string_literal88);
                    adaptor.addChild(root_0, string_literal88_tree);
=======
                    string_literal94_tree = (Object)adaptor.create(string_literal94);
                    adaptor.addChild(root_0, string_literal94_tree);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 57, adviceType_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 56, adviceType_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:837:1: joinPointKind returns [Modifier value] : ( 'execution' | 'call' );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:813:1: joinPointKind returns [Modifier value] : ( 'execution' | 'call' );
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:838:2: ( 'execution' | 'call' )
            int alt45=2;
            int LA45_0 = input.LA(1);
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:814:2: ( 'execution' | 'call' )
            int alt47=2;
            int LA47_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA45_0==55) ) {
                alt45=1;
=======
            if ( (LA47_0==55) ) {
                alt47=1;
>>>>>>> other
            }
<<<<<<< local
            else if ( (LA45_0==56) ) {
                alt45=2;
=======
            else if ( (LA47_0==56) ) {
                alt47=2;
>>>>>>> other
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
<<<<<<< local
            switch (alt45) {
=======
            switch (alt47) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:838:4: 'execution'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:814:4: 'execution'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal89=(Token)match(input,55,FOLLOW_55_in_joinPointKind2031); if (state.failed) return retval;
=======
                    string_literal95=(Token)match(input,55,FOLLOW_55_in_joinPointKind2009); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal89_tree = (Object)adaptor.create(string_literal89);
                    adaptor.addChild(root_0, string_literal89_tree);
=======
                    string_literal95_tree = (Object)adaptor.create(string_literal95);
                    adaptor.addChild(root_0, string_literal95_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new Execution();
                    }

                    }
                    break;
                case 2 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:839:4: 'call'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:815:4: 'call'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal90=(Token)match(input,56,FOLLOW_56_in_joinPointKind2038); if (state.failed) return retval;
=======
                    string_literal96=(Token)match(input,56,FOLLOW_56_in_joinPointKind2016); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal90_tree = (Object)adaptor.create(string_literal90);
                    adaptor.addChild(root_0, string_literal90_tree);
=======
                    string_literal96_tree = (Object)adaptor.create(string_literal96);
                    adaptor.addChild(root_0, string_literal96_tree);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 58, joinPointKind_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 57, joinPointKind_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:843:1: overrideOrExtend returns [Modifier value] : (okw= 'override' | ekw= 'merge' );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:819:1: overrideOrExtend returns [Modifier value] : (okw= 'override' | ekw= 'merge' );
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:844:2: (okw= 'override' | ekw= 'merge' )
            int alt46=2;
            int LA46_0 = input.LA(1);
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:820:2: (okw= 'override' | ekw= 'merge' )
            int alt48=2;
            int LA48_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA46_0==57) ) {
                alt46=1;
=======
            if ( (LA48_0==57) ) {
                alt48=1;
>>>>>>> other
            }
<<<<<<< local
            else if ( (LA46_0==58) ) {
                alt46=2;
=======
            else if ( (LA48_0==58) ) {
                alt48=2;
>>>>>>> other
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
<<<<<<< local
            switch (alt46) {
=======
            switch (alt48) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:844:4: okw= 'override'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:820:4: okw= 'override'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    okw=(Token)match(input,57,FOLLOW_57_in_overrideOrExtend2060); if (state.failed) return retval;
=======
                    okw=(Token)match(input,57,FOLLOW_57_in_overrideOrExtend2038); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:845:4: ekw= 'merge'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:821:4: ekw= 'merge'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    ekw=(Token)match(input,58,FOLLOW_58_in_overrideOrExtend2069); if (state.failed) return retval;
=======
                    ekw=(Token)match(input,58,FOLLOW_58_in_overrideOrExtend2047); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 59, overrideOrExtend_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 58, overrideOrExtend_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:849:1: negationModifier returns [Modifier value] : '!' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:825:1: negationModifier returns [Modifier value] : '!' ;
>>>>>>> other
    public final MViewParser.negationModifier_return negationModifier() throws RecognitionException {
        MViewParser.negationModifier_return retval = new MViewParser.negationModifier_return();
        retval.start = input.LT(1);
        int negationModifier_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal97=null;

        Object char_literal97_tree=null;

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:850:2: ( '!' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:850:5: '!'
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:826:2: ( '!' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:826:5: '!'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal91=(Token)match(input,59,FOLLOW_59_in_negationModifier2089); if (state.failed) return retval;
=======
            char_literal97=(Token)match(input,59,FOLLOW_59_in_negationModifier2067); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal91_tree = (Object)adaptor.create(char_literal91);
            adaptor.addChild(root_0, char_literal91_tree);
=======
            char_literal97_tree = (Object)adaptor.create(char_literal97);
            adaptor.addChild(root_0, char_literal97_tree);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 60, negationModifier_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 59, negationModifier_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:853:1: abstractModifier returns [Modifier value] : akw= 'abstract' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:829:1: abstractModifier returns [Modifier value] : akw= 'abstract' ;
>>>>>>> other
    public final MViewParser.abstractModifier_return abstractModifier() throws RecognitionException {
        MViewParser.abstractModifier_return retval = new MViewParser.abstractModifier_return();
        retval.start = input.LT(1);
        int abstractModifier_StartIndex = input.index();
        Object root_0 = null;

        Token akw=null;

        Object akw_tree=null;

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:854:2: (akw= 'abstract' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:854:4: akw= 'abstract'
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:830:2: (akw= 'abstract' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:830:4: akw= 'abstract'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            akw=(Token)match(input,60,FOLLOW_60_in_abstractModifier2109); if (state.failed) return retval;
=======
            akw=(Token)match(input,60,FOLLOW_60_in_abstractModifier2087); if (state.failed) return retval;
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 61, abstractModifier_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 60, abstractModifier_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:857:1: voidType returns [BasicTypeReference value] : 'void' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:833:1: voidType returns [BasicTypeReference value] : 'void' ;
>>>>>>> other
    public final MViewParser.voidType_return voidType() throws RecognitionException {
        MViewParser.voidType_return retval = new MViewParser.voidType_return();
        retval.start = input.LT(1);
        int voidType_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal98=null;

        Object string_literal98_tree=null;

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:859:5: ( 'void' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:859:7: 'void'
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:835:5: ( 'void' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:835:7: 'void'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            string_literal92=(Token)match(input,61,FOLLOW_61_in_voidType2132); if (state.failed) return retval;
=======
            string_literal98=(Token)match(input,61,FOLLOW_61_in_voidType2110); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            string_literal92_tree = (Object)adaptor.create(string_literal92);
            adaptor.addChild(root_0, string_literal92_tree);
=======
            string_literal98_tree = (Object)adaptor.create(string_literal98);
            adaptor.addChild(root_0, string_literal98_tree);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 62, voidType_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 61, voidType_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:868:1: type returns [BasicTypeReference value] : (cd= classOrInterfaceType | pt= primitiveType );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:844:1: type returns [BasicTypeReference value] : (cd= classOrInterfaceType | pt= primitiveType );
>>>>>>> other
    public final MViewParser.type_return type() throws RecognitionException {
        MViewParser.type_return retval = new MViewParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        Object root_0 = null;

        MViewParser.classOrInterfaceType_return cd = null;

        MViewParser.primitiveType_return pt = null;



        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:870:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt47=2;
            int LA47_0 = input.LA(1);
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:846:2: (cd= classOrInterfaceType | pt= primitiveType )
            int alt49=2;
            int LA49_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA47_0==Identifier) ) {
                alt47=1;
=======
            if ( (LA49_0==Identifier) ) {
                alt49=1;
>>>>>>> other
            }
<<<<<<< local
            else if ( ((LA47_0>=62 && LA47_0<=69)) ) {
                alt47=2;
=======
            else if ( ((LA49_0>=62 && LA49_0<=69)) ) {
                alt49=2;
>>>>>>> other
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
<<<<<<< local
            switch (alt47) {
=======
            switch (alt49) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:870:4: cd= classOrInterfaceType
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:846:4: cd= classOrInterfaceType
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_classOrInterfaceType_in_type2164);
=======
                    pushFollow(FOLLOW_classOrInterfaceType_in_type2142);
>>>>>>> other
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
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:871:4: pt= primitiveType
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:847:4: pt= primitiveType
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_primitiveType_in_type2173);
=======
                    pushFollow(FOLLOW_primitiveType_in_type2151);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 63, type_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 62, type_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:875:1: classOrInterfaceType returns [BasicTypeReference element] : name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:851:1: classOrInterfaceType returns [BasicTypeReference element] : name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* ;
>>>>>>> other
    public final MViewParser.classOrInterfaceType_return classOrInterfaceType() throws RecognitionException {
        MViewParser.classOrInterfaceType_return retval = new MViewParser.classOrInterfaceType_return();
        retval.start = input.LT(1);
        int classOrInterfaceType_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
        Token namex=null;
<<<<<<< local
        Token char_literal94=null;
        MViewParser.typeArguments_return typeArguments93 = null;
=======
        Token char_literal100=null;
        MViewParser.typeArguments_return typeArguments99 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.typeArguments_return typeArguments95 = null;
=======
        MViewParser.typeArguments_return typeArguments101 = null;
>>>>>>> other


        Object name_tree=null;
        Object namex_tree=null;
        Object char_literal100_tree=null;

        NamedTarget target = null;
        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:877:2: (name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:877:4: name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )*
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:853:2: (name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )* )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:853:4: name= Identifier ( typeArguments )? ( '.' namex= Identifier ( typeArguments )? )*
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2198); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2176); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            if ( state.backtracking==0 ) {

              	           retval.element = new MViewBasicTypeReference((name!=null?name.getText():null));
              	           target =  new NamedTarget((name!=null?name.getText():null));
              	           setLocation(retval.element,name,name); 
              	          
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:883:4: ( typeArguments )?
            int alt48=2;
            int LA48_0 = input.LA(1);
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:859:4: ( typeArguments )?
            int alt50=2;
            int LA50_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA48_0==70) ) {
                alt48=1;
=======
            if ( (LA50_0==70) ) {
                alt50=1;
>>>>>>> other
            }
<<<<<<< local
            switch (alt48) {
=======
            switch (alt50) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: typeArguments
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: typeArguments
>>>>>>> other
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2195);
                    typeArguments99=typeArguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArguments99.getTree());

                    }
                    break;

            }

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:884:10: ( '.' namex= Identifier ( typeArguments )? )*
            loop50:
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:860:10: ( '.' namex= Identifier ( typeArguments )? )*
            loop52:
>>>>>>> other
            do {
<<<<<<< local
                int alt50=2;
                int LA50_0 = input.LA(1);
=======
                int alt52=2;
                int LA52_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                if ( (LA50_0==51) ) {
                    alt50=1;
=======
                if ( (LA52_0==51) ) {
                    alt52=1;
>>>>>>> other
                }


                switch (alt52) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:884:11: '.' namex= Identifier ( typeArguments )?
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:860:11: '.' namex= Identifier ( typeArguments )?
>>>>>>> other
            	    {
<<<<<<< local
            	    char_literal94=(Token)match(input,51,FOLLOW_51_in_classOrInterfaceType2231); if (state.failed) return retval;
=======
            	    char_literal100=(Token)match(input,51,FOLLOW_51_in_classOrInterfaceType2209); if (state.failed) return retval;
>>>>>>> other
            	    if ( state.backtracking==0 ) {
<<<<<<< local
            	    char_literal94_tree = (Object)adaptor.create(char_literal94);
            	    adaptor.addChild(root_0, char_literal94_tree);
=======
            	    char_literal100_tree = (Object)adaptor.create(char_literal100);
            	    adaptor.addChild(root_0, char_literal100_tree);
>>>>>>> other
            	    }
<<<<<<< local
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2235); if (state.failed) return retval;
=======
            	    namex=(Token)match(input,Identifier,FOLLOW_Identifier_in_classOrInterfaceType2213); if (state.failed) return retval;
>>>>>>> other
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
            	      	          
<<<<<<< local
            	    }
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:895:11: ( typeArguments )?
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==70) ) {
            	        alt49=1;
=======
>>>>>>> other
            	    }
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:871:11: ( typeArguments )?
            	    int alt51=2;
            	    int LA51_0 = input.LA(1);

            	    if ( (LA51_0==70) ) {
            	        alt51=1;
            	    }
            	    switch (alt51) {
            	        case 1 :
<<<<<<< local
            	            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: typeArguments
=======
            	            // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: typeArguments
>>>>>>> other
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2239);
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
            	    break loop52;
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 64, classOrInterfaceType_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 63, classOrInterfaceType_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:899:1: primitiveType returns [BasicTypeReference value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:875:1: primitiveType returns [BasicTypeReference value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:900:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt51=8;
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:876:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            int alt53=8;
>>>>>>> other
            switch ( input.LA(1) ) {
            case 62:
                {
                alt53=1;
                }
                break;
            case 63:
                {
                alt53=2;
                }
                break;
            case 64:
                {
                alt53=3;
                }
                break;
            case 65:
                {
                alt53=4;
                }
                break;
            case 66:
                {
                alt53=5;
                }
                break;
            case 67:
                {
                alt53=6;
                }
                break;
            case 68:
                {
                alt53=7;
                }
                break;
            case 69:
                {
                alt53=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

<<<<<<< local
            switch (alt51) {
=======
            switch (alt53) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:900:9: 'boolean'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:876:9: 'boolean'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal96=(Token)match(input,62,FOLLOW_62_in_primitiveType2286); if (state.failed) return retval;
=======
                    string_literal102=(Token)match(input,62,FOLLOW_62_in_primitiveType2264); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal96_tree = (Object)adaptor.create(string_literal96);
                    adaptor.addChild(root_0, string_literal96_tree);
=======
                    string_literal102_tree = (Object)adaptor.create(string_literal102);
                    adaptor.addChild(root_0, string_literal102_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("boolean");
                    }

                    }
                    break;
                case 2 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:901:9: 'char'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:877:9: 'char'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal97=(Token)match(input,63,FOLLOW_63_in_primitiveType2298); if (state.failed) return retval;
=======
                    string_literal103=(Token)match(input,63,FOLLOW_63_in_primitiveType2276); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal97_tree = (Object)adaptor.create(string_literal97);
                    adaptor.addChild(root_0, string_literal97_tree);
=======
                    string_literal103_tree = (Object)adaptor.create(string_literal103);
                    adaptor.addChild(root_0, string_literal103_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("char");
                    }

                    }
                    break;
                case 3 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:902:9: 'byte'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:878:9: 'byte'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal98=(Token)match(input,64,FOLLOW_64_in_primitiveType2310); if (state.failed) return retval;
=======
                    string_literal104=(Token)match(input,64,FOLLOW_64_in_primitiveType2288); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal98_tree = (Object)adaptor.create(string_literal98);
                    adaptor.addChild(root_0, string_literal98_tree);
=======
                    string_literal104_tree = (Object)adaptor.create(string_literal104);
                    adaptor.addChild(root_0, string_literal104_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("byte");
                    }

                    }
                    break;
                case 4 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:903:9: 'short'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:879:9: 'short'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal99=(Token)match(input,65,FOLLOW_65_in_primitiveType2322); if (state.failed) return retval;
=======
                    string_literal105=(Token)match(input,65,FOLLOW_65_in_primitiveType2300); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal99_tree = (Object)adaptor.create(string_literal99);
                    adaptor.addChild(root_0, string_literal99_tree);
=======
                    string_literal105_tree = (Object)adaptor.create(string_literal105);
                    adaptor.addChild(root_0, string_literal105_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("short");
                    }

                    }
                    break;
                case 5 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:904:9: 'int'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:880:9: 'int'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal100=(Token)match(input,66,FOLLOW_66_in_primitiveType2334); if (state.failed) return retval;
=======
                    string_literal106=(Token)match(input,66,FOLLOW_66_in_primitiveType2312); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal100_tree = (Object)adaptor.create(string_literal100);
                    adaptor.addChild(root_0, string_literal100_tree);
=======
                    string_literal106_tree = (Object)adaptor.create(string_literal106);
                    adaptor.addChild(root_0, string_literal106_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("int");
                    }

                    }
                    break;
                case 6 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:905:9: 'long'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:881:9: 'long'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal101=(Token)match(input,67,FOLLOW_67_in_primitiveType2346); if (state.failed) return retval;
=======
                    string_literal107=(Token)match(input,67,FOLLOW_67_in_primitiveType2324); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal101_tree = (Object)adaptor.create(string_literal101);
                    adaptor.addChild(root_0, string_literal101_tree);
=======
                    string_literal107_tree = (Object)adaptor.create(string_literal107);
                    adaptor.addChild(root_0, string_literal107_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("long");
                    }

                    }
                    break;
                case 7 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:906:9: 'float'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:882:9: 'float'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal102=(Token)match(input,68,FOLLOW_68_in_primitiveType2358); if (state.failed) return retval;
=======
                    string_literal108=(Token)match(input,68,FOLLOW_68_in_primitiveType2336); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal102_tree = (Object)adaptor.create(string_literal102);
                    adaptor.addChild(root_0, string_literal102_tree);
=======
                    string_literal108_tree = (Object)adaptor.create(string_literal108);
                    adaptor.addChild(root_0, string_literal108_tree);
>>>>>>> other
                    }
                    if ( state.backtracking==0 ) {
                      retval.value = new MViewBasicTypeReference("float");
                    }

                    }
                    break;
                case 8 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:907:9: 'double'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:883:9: 'double'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    string_literal103=(Token)match(input,69,FOLLOW_69_in_primitiveType2370); if (state.failed) return retval;
=======
                    string_literal109=(Token)match(input,69,FOLLOW_69_in_primitiveType2348); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    string_literal103_tree = (Object)adaptor.create(string_literal103);
                    adaptor.addChild(root_0, string_literal103_tree);
=======
                    string_literal109_tree = (Object)adaptor.create(string_literal109);
                    adaptor.addChild(root_0, string_literal109_tree);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 65, primitiveType_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 64, primitiveType_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "primitiveType"

    public static class typeArguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArguments"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:912:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:888:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
>>>>>>> other
    public final MViewParser.typeArguments_return typeArguments() throws RecognitionException {
        MViewParser.typeArguments_return retval = new MViewParser.typeArguments_return();
        retval.start = input.LT(1);
        int typeArguments_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token char_literal104=null;
        Token char_literal106=null;
        Token char_literal108=null;
        MViewParser.typeArgument_return typeArgument105 = null;
=======
        Token char_literal110=null;
        Token char_literal112=null;
        Token char_literal114=null;
        MViewParser.typeArgument_return typeArgument111 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.typeArgument_return typeArgument107 = null;
=======
        MViewParser.typeArgument_return typeArgument113 = null;
>>>>>>> other


<<<<<<< local
        Object char_literal104_tree=null;
        Object char_literal106_tree=null;
        Object char_literal108_tree=null;
=======
        Object char_literal110_tree=null;
        Object char_literal112_tree=null;
        Object char_literal114_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:913:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:913:9: '<' typeArgument ( ',' typeArgument )* '>'
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:889:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:889:9: '<' typeArgument ( ',' typeArgument )* '>'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal104=(Token)match(input,70,FOLLOW_70_in_typeArguments2393); if (state.failed) return retval;
=======
            char_literal110=(Token)match(input,70,FOLLOW_70_in_typeArguments2371); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal104_tree = (Object)adaptor.create(char_literal104);
            adaptor.addChild(root_0, char_literal104_tree);
=======
            char_literal110_tree = (Object)adaptor.create(char_literal110);
            adaptor.addChild(root_0, char_literal110_tree);
>>>>>>> other
            }
<<<<<<< local
            pushFollow(FOLLOW_typeArgument_in_typeArguments2395);
            typeArgument105=typeArgument();
=======
            pushFollow(FOLLOW_typeArgument_in_typeArguments2373);
            typeArgument111=typeArgument();
>>>>>>> other

            state._fsp--;
            if (state.failed) return retval;
<<<<<<< local
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument105.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:913:26: ( ',' typeArgument )*
            loop52:
=======
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument111.getTree());
            // /Users/marko/hg/mview/src/mview/parser/MView.g:889:26: ( ',' typeArgument )*
            loop54:
>>>>>>> other
            do {
<<<<<<< local
                int alt52=2;
                int LA52_0 = input.LA(1);
=======
                int alt54=2;
                int LA54_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                if ( (LA52_0==29) ) {
                    alt52=1;
=======
                if ( (LA54_0==29) ) {
                    alt54=1;
>>>>>>> other
                }


                switch (alt54) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:913:28: ',' typeArgument
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:889:28: ',' typeArgument
>>>>>>> other
            	    {
<<<<<<< local
            	    char_literal106=(Token)match(input,29,FOLLOW_29_in_typeArguments2399); if (state.failed) return retval;
=======
            	    char_literal112=(Token)match(input,29,FOLLOW_29_in_typeArguments2377); if (state.failed) return retval;
>>>>>>> other
            	    if ( state.backtracking==0 ) {
<<<<<<< local
            	    char_literal106_tree = (Object)adaptor.create(char_literal106);
            	    adaptor.addChild(root_0, char_literal106_tree);
=======
            	    char_literal112_tree = (Object)adaptor.create(char_literal112);
            	    adaptor.addChild(root_0, char_literal112_tree);
>>>>>>> other
            	    }
<<<<<<< local
            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2401);
            	    typeArgument107=typeArgument();
=======
            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2379);
            	    typeArgument113=typeArgument();
>>>>>>> other

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeArgument113.getTree());

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

<<<<<<< local
            char_literal108=(Token)match(input,71,FOLLOW_71_in_typeArguments2406); if (state.failed) return retval;
=======
            char_literal114=(Token)match(input,71,FOLLOW_71_in_typeArguments2384); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal108_tree = (Object)adaptor.create(char_literal108);
            adaptor.addChild(root_0, char_literal108_tree);
=======
            char_literal114_tree = (Object)adaptor.create(char_literal114);
            adaptor.addChild(root_0, char_literal114_tree);
>>>>>>> other
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 66, typeArguments_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 65, typeArguments_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "typeArguments"

    public static class typeArgument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeArgument"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:916:1: typeArgument : (t= type | '?' ( ( 'extends' | 'super' ) t= type )? );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:892:1: typeArgument : (t= type | '?' ( ( 'extends' | 'super' ) t= type )? );
>>>>>>> other
    public final MViewParser.typeArgument_return typeArgument() throws RecognitionException {
        MViewParser.typeArgument_return retval = new MViewParser.typeArgument_return();
        retval.start = input.LT(1);
        int typeArgument_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token char_literal109=null;
        Token set110=null;
=======
        Token char_literal115=null;
        Token set116=null;
>>>>>>> other
        MViewParser.type_return t = null;


<<<<<<< local
        Object char_literal109_tree=null;
        Object set110_tree=null;
=======
        Object char_literal115_tree=null;
        Object set116_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:917:5: (t= type | '?' ( ( 'extends' | 'super' ) t= type )? )
            int alt54=2;
            int LA54_0 = input.LA(1);
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:893:5: (t= type | '?' ( ( 'extends' | 'super' ) t= type )? )
            int alt56=2;
            int LA56_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA54_0==Identifier||(LA54_0>=62 && LA54_0<=69)) ) {
                alt54=1;
=======
            if ( (LA56_0==Identifier||(LA56_0>=62 && LA56_0<=69)) ) {
                alt56=1;
>>>>>>> other
            }
<<<<<<< local
            else if ( (LA54_0==72) ) {
                alt54=2;
=======
            else if ( (LA56_0==72) ) {
                alt56=2;
>>>>>>> other
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
<<<<<<< local
            switch (alt54) {
=======
            switch (alt56) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:917:9: t= type
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:893:9: t= type
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_type_in_typeArgument2431);
=======
                    pushFollow(FOLLOW_type_in_typeArgument2409);
>>>>>>> other
                    t=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

                    }
                    break;
                case 2 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:917:20: '?' ( ( 'extends' | 'super' ) t= type )?
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:893:20: '?' ( ( 'extends' | 'super' ) t= type )?
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    char_literal109=(Token)match(input,72,FOLLOW_72_in_typeArgument2437); if (state.failed) return retval;
=======
                    char_literal115=(Token)match(input,72,FOLLOW_72_in_typeArgument2415); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal109_tree = (Object)adaptor.create(char_literal109);
                    adaptor.addChild(root_0, char_literal109_tree);
=======
                    char_literal115_tree = (Object)adaptor.create(char_literal115);
                    adaptor.addChild(root_0, char_literal115_tree);
>>>>>>> other
                    }
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:917:25: ( ( 'extends' | 'super' ) t= type )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:893:25: ( ( 'extends' | 'super' ) t= type )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                    if ( ((LA53_0>=73 && LA53_0<=74)) ) {
                        alt53=1;
=======
                    if ( ((LA55_0>=73 && LA55_0<=74)) ) {
                        alt55=1;
>>>>>>> other
                    }
<<<<<<< local
                    switch (alt53) {
=======
                    switch (alt55) {
>>>>>>> other
                        case 1 :
<<<<<<< local
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:917:27: ( 'extends' | 'super' ) t= type
=======
                            // /Users/marko/hg/mview/src/mview/parser/MView.g:893:27: ( 'extends' | 'super' ) t= type
>>>>>>> other
                            {
<<<<<<< local
                            set110=(Token)input.LT(1);
=======
                            set116=(Token)input.LT(1);
>>>>>>> other
                            if ( (input.LA(1)>=73 && input.LA(1)<=74) ) {
                                input.consume();
<<<<<<< local
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set110));
=======
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set116));
>>>>>>> other
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

<<<<<<< local
                            pushFollow(FOLLOW_type_in_typeArgument2452);
=======
                            pushFollow(FOLLOW_type_in_typeArgument2430);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 67, typeArgument_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 66, typeArgument_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "typeArgument"

    public static class annotations_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotations"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:924:1: annotations : ( annotation )+ ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:900:1: annotations : ( annotation )+ ;
>>>>>>> other
    public final MViewParser.annotations_return annotations() throws RecognitionException {
        MViewParser.annotations_return retval = new MViewParser.annotations_return();
        retval.start = input.LT(1);
        int annotations_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        MViewParser.annotation_return annotation111 = null;
=======
        MViewParser.annotation_return annotation117 = null;
>>>>>>> other



        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:925:5: ( ( annotation )+ )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:925:9: ( annotation )+
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:901:5: ( ( annotation )+ )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:901:9: ( annotation )+
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:925:9: ( annotation )+
            int cnt55=0;
            loop55:
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:901:9: ( annotation )+
            int cnt57=0;
            loop57:
>>>>>>> other
            do {
<<<<<<< local
                int alt55=2;
                int LA55_0 = input.LA(1);
=======
                int alt57=2;
                int LA57_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                if ( (LA55_0==75) ) {
                    alt55=1;
=======
                if ( (LA57_0==75) ) {
                    alt57=1;
>>>>>>> other
                }


                switch (alt57) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: annotation
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: annotation
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations2460);
            	    annotation117=annotation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation117.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 68, annotations_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 67, annotations_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "annotations"

    public static class annotation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotation"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:928:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:904:1: annotation : '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
>>>>>>> other
    public final MViewParser.annotation_return annotation() throws RecognitionException {
        MViewParser.annotation_return retval = new MViewParser.annotation_return();
        retval.start = input.LT(1);
        int annotation_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token char_literal112=null;
        Token char_literal114=null;
        Token char_literal117=null;
        MViewParser.annotationName_return annotationName113 = null;
=======
        Token char_literal118=null;
        Token char_literal120=null;
        Token char_literal123=null;
        MViewParser.annotationName_return annotationName119 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.elementValuePairs_return elementValuePairs115 = null;
=======
        MViewParser.elementValuePairs_return elementValuePairs121 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.elementValue_return elementValue116 = null;
=======
        MViewParser.elementValue_return elementValue122 = null;
>>>>>>> other


<<<<<<< local
        Object char_literal112_tree=null;
        Object char_literal114_tree=null;
        Object char_literal117_tree=null;
=======
        Object char_literal118_tree=null;
        Object char_literal120_tree=null;
        Object char_literal123_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:905:5: ( '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:905:9: '@' annotationName ( '(' ( elementValuePairs | elementValue )? ')' )?
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal112=(Token)match(input,75,FOLLOW_75_in_annotation2502); if (state.failed) return retval;
=======
            char_literal118=(Token)match(input,75,FOLLOW_75_in_annotation2480); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal112_tree = (Object)adaptor.create(char_literal112);
            adaptor.addChild(root_0, char_literal112_tree);
=======
            char_literal118_tree = (Object)adaptor.create(char_literal118);
            adaptor.addChild(root_0, char_literal118_tree);
>>>>>>> other
            }
<<<<<<< local
            pushFollow(FOLLOW_annotationName_in_annotation2504);
            annotationName113=annotationName();
=======
            pushFollow(FOLLOW_annotationName_in_annotation2482);
            annotationName119=annotationName();
>>>>>>> other

            state._fsp--;
            if (state.failed) return retval;
<<<<<<< local
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName113.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt57=2;
            int LA57_0 = input.LA(1);
=======
            if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationName119.getTree());
            // /Users/marko/hg/mview/src/mview/parser/MView.g:905:28: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt59=2;
            int LA59_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA57_0==27) ) {
                alt57=1;
=======
            if ( (LA59_0==27) ) {
                alt59=1;
>>>>>>> other
            }
<<<<<<< local
            switch (alt57) {
=======
            switch (alt59) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:30: '(' ( elementValuePairs | elementValue )? ')'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:905:30: '(' ( elementValuePairs | elementValue )? ')'
>>>>>>> other
                    {
<<<<<<< local
                    char_literal114=(Token)match(input,27,FOLLOW_27_in_annotation2508); if (state.failed) return retval;
=======
                    char_literal120=(Token)match(input,27,FOLLOW_27_in_annotation2486); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal114_tree = (Object)adaptor.create(char_literal114);
                    adaptor.addChild(root_0, char_literal114_tree);
=======
                    char_literal120_tree = (Object)adaptor.create(char_literal120);
                    adaptor.addChild(root_0, char_literal120_tree);
>>>>>>> other
                    }
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:34: ( elementValuePairs | elementValue )?
                    int alt56=3;
                    int LA56_0 = input.LA(1);
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:905:34: ( elementValuePairs | elementValue )?
                    int alt58=3;
                    int LA58_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                    if ( (LA56_0==Identifier) ) {
                        alt56=1;
=======
                    if ( (LA58_0==Identifier) ) {
                        alt58=1;
>>>>>>> other
                    }
<<<<<<< local
                    else if ( (LA56_0==24||LA56_0==75) ) {
                        alt56=2;
=======
                    else if ( (LA58_0==24||LA58_0==75) ) {
                        alt58=2;
>>>>>>> other
                    }
<<<<<<< local
                    switch (alt56) {
=======
                    switch (alt58) {
>>>>>>> other
                        case 1 :
<<<<<<< local
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:36: elementValuePairs
=======
                            // /Users/marko/hg/mview/src/mview/parser/MView.g:905:36: elementValuePairs
>>>>>>> other
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation2490);
                            elementValuePairs121=elementValuePairs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePairs121.getTree());

                            }
                            break;
                        case 2 :
<<<<<<< local
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:929:56: elementValue
=======
                            // /Users/marko/hg/mview/src/mview/parser/MView.g:905:56: elementValue
>>>>>>> other
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation2494);
                            elementValue122=elementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue122.getTree());

                            }
                            break;

                    }

<<<<<<< local
                    char_literal117=(Token)match(input,28,FOLLOW_28_in_annotation2521); if (state.failed) return retval;
=======
                    char_literal123=(Token)match(input,28,FOLLOW_28_in_annotation2499); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal117_tree = (Object)adaptor.create(char_literal117);
                    adaptor.addChild(root_0, char_literal117_tree);
=======
                    char_literal123_tree = (Object)adaptor.create(char_literal123);
                    adaptor.addChild(root_0, char_literal123_tree);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 69, annotation_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 68, annotation_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "annotation"

    public static class annotationName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationName"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:932:1: annotationName : Identifier ( '.' Identifier )* ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:908:1: annotationName : Identifier ( '.' Identifier )* ;
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:933:5: ( Identifier ( '.' Identifier )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:933:7: Identifier ( '.' Identifier )*
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:909:5: ( Identifier ( '.' Identifier )* )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:909:7: Identifier ( '.' Identifier )*
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            Identifier118=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2545); if (state.failed) return retval;
=======
            Identifier124=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2523); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            Identifier118_tree = (Object)adaptor.create(Identifier118);
            adaptor.addChild(root_0, Identifier118_tree);
=======
            Identifier124_tree = (Object)adaptor.create(Identifier124);
            adaptor.addChild(root_0, Identifier124_tree);
>>>>>>> other
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:933:18: ( '.' Identifier )*
            loop58:
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:909:18: ( '.' Identifier )*
            loop60:
>>>>>>> other
            do {
<<<<<<< local
                int alt58=2;
                int LA58_0 = input.LA(1);
=======
                int alt60=2;
                int LA60_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                if ( (LA58_0==51) ) {
                    alt58=1;
=======
                if ( (LA60_0==51) ) {
                    alt60=1;
>>>>>>> other
                }


                switch (alt60) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:933:19: '.' Identifier
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:909:19: '.' Identifier
>>>>>>> other
            	    {
<<<<<<< local
            	    char_literal119=(Token)match(input,51,FOLLOW_51_in_annotationName2548); if (state.failed) return retval;
=======
            	    char_literal125=(Token)match(input,51,FOLLOW_51_in_annotationName2526); if (state.failed) return retval;
>>>>>>> other
            	    if ( state.backtracking==0 ) {
<<<<<<< local
            	    char_literal119_tree = (Object)adaptor.create(char_literal119);
            	    adaptor.addChild(root_0, char_literal119_tree);
=======
            	    char_literal125_tree = (Object)adaptor.create(char_literal125);
            	    adaptor.addChild(root_0, char_literal125_tree);
>>>>>>> other
            	    }
<<<<<<< local
            	    Identifier120=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2550); if (state.failed) return retval;
=======
            	    Identifier126=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationName2528); if (state.failed) return retval;
>>>>>>> other
            	    if ( state.backtracking==0 ) {
<<<<<<< local
            	    Identifier120_tree = (Object)adaptor.create(Identifier120);
            	    adaptor.addChild(root_0, Identifier120_tree);
=======
            	    Identifier126_tree = (Object)adaptor.create(Identifier126);
            	    adaptor.addChild(root_0, Identifier126_tree);
>>>>>>> other
            	    }

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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 70, annotationName_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 69, annotationName_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "annotationName"

    public static class elementValuePairs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePairs"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:936:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:912:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
>>>>>>> other
    public final MViewParser.elementValuePairs_return elementValuePairs() throws RecognitionException {
        MViewParser.elementValuePairs_return retval = new MViewParser.elementValuePairs_return();
        retval.start = input.LT(1);
        int elementValuePairs_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token char_literal122=null;
        MViewParser.elementValuePair_return elementValuePair121 = null;
=======
        Token char_literal128=null;
        MViewParser.elementValuePair_return elementValuePair127 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.elementValuePair_return elementValuePair123 = null;
=======
        MViewParser.elementValuePair_return elementValuePair129 = null;
>>>>>>> other


<<<<<<< local
        Object char_literal122_tree=null;
=======
        Object char_literal128_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:937:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:937:9: elementValuePair ( ',' elementValuePair )*
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:913:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:913:9: elementValuePair ( ',' elementValuePair )*
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2571);
            elementValuePair121=elementValuePair();
=======
            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2549);
            elementValuePair127=elementValuePair();
>>>>>>> other

            state._fsp--;
            if (state.failed) return retval;
<<<<<<< local
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair121.getTree());
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:937:26: ( ',' elementValuePair )*
            loop59:
=======
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair127.getTree());
            // /Users/marko/hg/mview/src/mview/parser/MView.g:913:26: ( ',' elementValuePair )*
            loop61:
>>>>>>> other
            do {
<<<<<<< local
                int alt59=2;
                int LA59_0 = input.LA(1);
=======
                int alt61=2;
                int LA61_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                if ( (LA59_0==29) ) {
                    alt59=1;
=======
                if ( (LA61_0==29) ) {
                    alt61=1;
>>>>>>> other
                }


                switch (alt61) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:937:27: ',' elementValuePair
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:913:27: ',' elementValuePair
>>>>>>> other
            	    {
<<<<<<< local
            	    char_literal122=(Token)match(input,29,FOLLOW_29_in_elementValuePairs2574); if (state.failed) return retval;
=======
            	    char_literal128=(Token)match(input,29,FOLLOW_29_in_elementValuePairs2552); if (state.failed) return retval;
>>>>>>> other
            	    if ( state.backtracking==0 ) {
<<<<<<< local
            	    char_literal122_tree = (Object)adaptor.create(char_literal122);
            	    adaptor.addChild(root_0, char_literal122_tree);
=======
            	    char_literal128_tree = (Object)adaptor.create(char_literal128);
            	    adaptor.addChild(root_0, char_literal128_tree);
>>>>>>> other
            	    }
<<<<<<< local
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2576);
            	    elementValuePair123=elementValuePair();
=======
            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs2554);
            	    elementValuePair129=elementValuePair();
>>>>>>> other

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValuePair129.getTree());

            	    }
            	    break;

            	default :
            	    break loop61;
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 71, elementValuePairs_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 70, elementValuePairs_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "elementValuePairs"

    public static class elementValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValuePair"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:940:1: elementValuePair : Identifier '=' elementValue ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:916:1: elementValuePair : Identifier '=' elementValue ;
>>>>>>> other
    public final MViewParser.elementValuePair_return elementValuePair() throws RecognitionException {
        MViewParser.elementValuePair_return retval = new MViewParser.elementValuePair_return();
        retval.start = input.LT(1);
        int elementValuePair_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token Identifier124=null;
        Token char_literal125=null;
        MViewParser.elementValue_return elementValue126 = null;
=======
        Token Identifier130=null;
        Token char_literal131=null;
        MViewParser.elementValue_return elementValue132 = null;
>>>>>>> other


<<<<<<< local
        Object Identifier124_tree=null;
        Object char_literal125_tree=null;
=======
        Object Identifier130_tree=null;
        Object char_literal131_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:941:5: ( Identifier '=' elementValue )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:941:9: Identifier '=' elementValue
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:917:5: ( Identifier '=' elementValue )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:917:9: Identifier '=' elementValue
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            Identifier124=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair2597); if (state.failed) return retval;
=======
            Identifier130=(Token)match(input,Identifier,FOLLOW_Identifier_in_elementValuePair2575); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            Identifier124_tree = (Object)adaptor.create(Identifier124);
            adaptor.addChild(root_0, Identifier124_tree);
=======
            Identifier130_tree = (Object)adaptor.create(Identifier130);
            adaptor.addChild(root_0, Identifier130_tree);
>>>>>>> other
            }
<<<<<<< local
            char_literal125=(Token)match(input,76,FOLLOW_76_in_elementValuePair2599); if (state.failed) return retval;
=======
            char_literal131=(Token)match(input,76,FOLLOW_76_in_elementValuePair2577); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal125_tree = (Object)adaptor.create(char_literal125);
            adaptor.addChild(root_0, char_literal125_tree);
=======
            char_literal131_tree = (Object)adaptor.create(char_literal131);
            adaptor.addChild(root_0, char_literal131_tree);
>>>>>>> other
            }
<<<<<<< local
            pushFollow(FOLLOW_elementValue_in_elementValuePair2601);
            elementValue126=elementValue();
=======
            pushFollow(FOLLOW_elementValue_in_elementValuePair2579);
            elementValue132=elementValue();
>>>>>>> other

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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 72, elementValuePair_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 71, elementValuePair_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "elementValuePair"

    public static class elementValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValue"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:944:1: elementValue : ( annotation | elementValueArrayInitializer );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:920:1: elementValue : ( annotation | elementValueArrayInitializer );
>>>>>>> other
    public final MViewParser.elementValue_return elementValue() throws RecognitionException {
        MViewParser.elementValue_return retval = new MViewParser.elementValue_return();
        retval.start = input.LT(1);
        int elementValue_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        MViewParser.annotation_return annotation127 = null;
=======
        MViewParser.annotation_return annotation133 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer128 = null;
=======
        MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer134 = null;
>>>>>>> other



        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:945:5: ( annotation | elementValueArrayInitializer )
            int alt60=2;
            int LA60_0 = input.LA(1);
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:921:5: ( annotation | elementValueArrayInitializer )
            int alt62=2;
            int LA62_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA60_0==75) ) {
                alt60=1;
=======
            if ( (LA62_0==75) ) {
                alt62=1;
>>>>>>> other
            }
<<<<<<< local
            else if ( (LA60_0==24) ) {
                alt60=2;
=======
            else if ( (LA62_0==24) ) {
                alt62=2;
>>>>>>> other
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
<<<<<<< local
            switch (alt60) {
=======
            switch (alt62) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:945:9: annotation
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:921:9: annotation
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_annotation_in_elementValue2624);
                    annotation127=annotation();
=======
                    pushFollow(FOLLOW_annotation_in_elementValue2602);
                    annotation133=annotation();
>>>>>>> other

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation133.getTree());

                    }
                    break;
                case 2 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:946:9: elementValueArrayInitializer
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:922:9: elementValueArrayInitializer
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue2634);
                    elementValueArrayInitializer128=elementValueArrayInitializer();
=======
                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue2612);
                    elementValueArrayInitializer134=elementValueArrayInitializer();
>>>>>>> other

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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 73, elementValue_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 72, elementValue_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "elementValue"

    public static class elementValueArrayInitializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elementValueArrayInitializer"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:949:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:925:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
>>>>>>> other
    public final MViewParser.elementValueArrayInitializer_return elementValueArrayInitializer() throws RecognitionException {
        MViewParser.elementValueArrayInitializer_return retval = new MViewParser.elementValueArrayInitializer_return();
        retval.start = input.LT(1);
        int elementValueArrayInitializer_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token char_literal129=null;
        Token char_literal131=null;
        Token char_literal133=null;
        Token char_literal134=null;
        MViewParser.elementValue_return elementValue130 = null;
=======
        Token char_literal135=null;
        Token char_literal137=null;
        Token char_literal139=null;
        Token char_literal140=null;
        MViewParser.elementValue_return elementValue136 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.elementValue_return elementValue132 = null;
=======
        MViewParser.elementValue_return elementValue138 = null;
>>>>>>> other


<<<<<<< local
        Object char_literal129_tree=null;
        Object char_literal131_tree=null;
        Object char_literal133_tree=null;
        Object char_literal134_tree=null;
=======
        Object char_literal135_tree=null;
        Object char_literal137_tree=null;
        Object char_literal139_tree=null;
        Object char_literal140_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:926:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:926:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal129=(Token)match(input,24,FOLLOW_24_in_elementValueArrayInitializer2657); if (state.failed) return retval;
=======
            char_literal135=(Token)match(input,24,FOLLOW_24_in_elementValueArrayInitializer2635); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal129_tree = (Object)adaptor.create(char_literal129);
            adaptor.addChild(root_0, char_literal129_tree);
=======
            char_literal135_tree = (Object)adaptor.create(char_literal135);
            adaptor.addChild(root_0, char_literal135_tree);
>>>>>>> other
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:13: ( elementValue ( ',' elementValue )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:926:13: ( elementValue ( ',' elementValue )* )?
            int alt64=2;
            int LA64_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA62_0==24||LA62_0==75) ) {
                alt62=1;
=======
            if ( (LA64_0==24||LA64_0==75) ) {
                alt64=1;
>>>>>>> other
            }
<<<<<<< local
            switch (alt62) {
=======
            switch (alt64) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:14: elementValue ( ',' elementValue )*
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:926:14: elementValue ( ',' elementValue )*
>>>>>>> other
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2638);
                    elementValue136=elementValue();

                    state._fsp--;
                    if (state.failed) return retval;
<<<<<<< local
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue130.getTree());
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:27: ( ',' elementValue )*
                    loop61:
=======
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue136.getTree());
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:926:27: ( ',' elementValue )*
                    loop63:
>>>>>>> other
                    do {
<<<<<<< local
                        int alt61=2;
                        int LA61_0 = input.LA(1);
=======
                        int alt63=2;
                        int LA63_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                        if ( (LA61_0==29) ) {
                            int LA61_1 = input.LA(2);
=======
                        if ( (LA63_0==29) ) {
                            int LA63_1 = input.LA(2);
>>>>>>> other

<<<<<<< local
                            if ( (LA61_1==24||LA61_1==75) ) {
                                alt61=1;
=======
                            if ( (LA63_1==24||LA63_1==75) ) {
                                alt63=1;
>>>>>>> other
                            }


                        }


                        switch (alt63) {
                    	case 1 :
<<<<<<< local
                    	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:28: ',' elementValue
=======
                    	    // /Users/marko/hg/mview/src/mview/parser/MView.g:926:28: ',' elementValue
>>>>>>> other
                    	    {
<<<<<<< local
                    	    char_literal131=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2663); if (state.failed) return retval;
=======
                    	    char_literal137=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2641); if (state.failed) return retval;
>>>>>>> other
                    	    if ( state.backtracking==0 ) {
<<<<<<< local
                    	    char_literal131_tree = (Object)adaptor.create(char_literal131);
                    	    adaptor.addChild(root_0, char_literal131_tree);
=======
                    	    char_literal137_tree = (Object)adaptor.create(char_literal137);
                    	    adaptor.addChild(root_0, char_literal137_tree);
>>>>>>> other
                    	    }
<<<<<<< local
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2665);
                    	    elementValue132=elementValue();
=======
                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer2643);
                    	    elementValue138=elementValue();
>>>>>>> other

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, elementValue138.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);


                    }
                    break;

            }

<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:49: ( ',' )?
            int alt63=2;
            int LA63_0 = input.LA(1);
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:926:49: ( ',' )?
            int alt65=2;
            int LA65_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA63_0==29) ) {
                alt63=1;
=======
            if ( (LA65_0==29) ) {
                alt65=1;
>>>>>>> other
            }
<<<<<<< local
            switch (alt63) {
=======
            switch (alt65) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:950:50: ','
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:926:50: ','
>>>>>>> other
                    {
<<<<<<< local
                    char_literal133=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2672); if (state.failed) return retval;
=======
                    char_literal139=(Token)match(input,29,FOLLOW_29_in_elementValueArrayInitializer2650); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal133_tree = (Object)adaptor.create(char_literal133);
                    adaptor.addChild(root_0, char_literal133_tree);
=======
                    char_literal139_tree = (Object)adaptor.create(char_literal139);
                    adaptor.addChild(root_0, char_literal139_tree);
>>>>>>> other
                    }

                    }
                    break;

            }

<<<<<<< local
            char_literal134=(Token)match(input,25,FOLLOW_25_in_elementValueArrayInitializer2676); if (state.failed) return retval;
=======
            char_literal140=(Token)match(input,25,FOLLOW_25_in_elementValueArrayInitializer2654); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal134_tree = (Object)adaptor.create(char_literal134);
            adaptor.addChild(root_0, char_literal134_tree);
=======
            char_literal140_tree = (Object)adaptor.create(char_literal140);
            adaptor.addChild(root_0, char_literal140_tree);
>>>>>>> other
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 74, elementValueArrayInitializer_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 73, elementValueArrayInitializer_StartIndex); }
>>>>>>> other
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
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:953:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:929:1: annotationTypeDeclaration returns [Type element] : '@' 'interface' name= Identifier annotationTypeBody ;
>>>>>>> other
    public final MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration() throws RecognitionException {
        MViewParser.annotationTypeDeclaration_return retval = new MViewParser.annotationTypeDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeDeclaration_StartIndex = input.index();
        Object root_0 = null;

        Token name=null;
<<<<<<< local
        Token char_literal135=null;
        Token string_literal136=null;
        MViewParser.annotationTypeBody_return annotationTypeBody137 = null;
=======
        Token char_literal141=null;
        Token string_literal142=null;
        MViewParser.annotationTypeBody_return annotationTypeBody143 = null;
>>>>>>> other


        Object name_tree=null;
        Object char_literal141_tree=null;
        Object string_literal142_tree=null;

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:954:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:954:9: '@' 'interface' name= Identifier annotationTypeBody
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:930:5: ( '@' 'interface' name= Identifier annotationTypeBody )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:930:9: '@' 'interface' name= Identifier annotationTypeBody
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal135=(Token)match(input,75,FOLLOW_75_in_annotationTypeDeclaration2703); if (state.failed) return retval;
=======
            char_literal141=(Token)match(input,75,FOLLOW_75_in_annotationTypeDeclaration2681); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal135_tree = (Object)adaptor.create(char_literal135);
            adaptor.addChild(root_0, char_literal135_tree);
=======
            char_literal141_tree = (Object)adaptor.create(char_literal141);
            adaptor.addChild(root_0, char_literal141_tree);
>>>>>>> other
            }
<<<<<<< local
            string_literal136=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration2705); if (state.failed) return retval;
=======
            string_literal142=(Token)match(input,23,FOLLOW_23_in_annotationTypeDeclaration2683); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            string_literal136_tree = (Object)adaptor.create(string_literal136);
            adaptor.addChild(root_0, string_literal136_tree);
=======
            string_literal142_tree = (Object)adaptor.create(string_literal142);
            adaptor.addChild(root_0, string_literal142_tree);
>>>>>>> other
            }
<<<<<<< local
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration2709); if (state.failed) return retval;
=======
            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationTypeDeclaration2687); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
            name_tree = (Object)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
<<<<<<< local
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2711);
            annotationTypeBody137=annotationTypeBody();
=======
            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2689);
            annotationTypeBody143=annotationTypeBody();
>>>>>>> other

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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 75, annotationTypeDeclaration_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 74, annotationTypeDeclaration_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "annotationTypeDeclaration"

    public static class annotationTypeBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeBody"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:957:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:933:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
>>>>>>> other
    public final MViewParser.annotationTypeBody_return annotationTypeBody() throws RecognitionException {
        MViewParser.annotationTypeBody_return retval = new MViewParser.annotationTypeBody_return();
        retval.start = input.LT(1);
        int annotationTypeBody_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token char_literal138=null;
        Token char_literal140=null;
        MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration139 = null;
=======
        Token char_literal144=null;
        Token char_literal146=null;
        MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration145 = null;
>>>>>>> other


<<<<<<< local
        Object char_literal138_tree=null;
        Object char_literal140_tree=null;
=======
        Object char_literal144_tree=null;
        Object char_literal146_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:958:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:958:9: '{' ( annotationTypeElementDeclaration )* '}'
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:934:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:934:9: '{' ( annotationTypeElementDeclaration )* '}'
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            char_literal138=(Token)match(input,24,FOLLOW_24_in_annotationTypeBody2734); if (state.failed) return retval;
=======
            char_literal144=(Token)match(input,24,FOLLOW_24_in_annotationTypeBody2712); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal138_tree = (Object)adaptor.create(char_literal138);
            adaptor.addChild(root_0, char_literal138_tree);
=======
            char_literal144_tree = (Object)adaptor.create(char_literal144);
            adaptor.addChild(root_0, char_literal144_tree);
>>>>>>> other
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:958:13: ( annotationTypeElementDeclaration )*
            loop64:
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:934:13: ( annotationTypeElementDeclaration )*
            loop66:
>>>>>>> other
            do {
<<<<<<< local
                int alt64=2;
                int LA64_0 = input.LA(1);
=======
                int alt66=2;
                int LA66_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                if ( (LA64_0==Identifier||(LA64_0>=62 && LA64_0<=69)||LA64_0==75) ) {
                    alt64=1;
=======
                if ( (LA66_0==Identifier||(LA66_0>=62 && LA66_0<=69)||LA66_0==75) ) {
                    alt66=1;
>>>>>>> other
                }


                switch (alt66) {
            	case 1 :
<<<<<<< local
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:958:14: annotationTypeElementDeclaration
=======
            	    // /Users/marko/hg/mview/src/mview/parser/MView.g:934:14: annotationTypeElementDeclaration
>>>>>>> other
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2715);
            	    annotationTypeElementDeclaration145=annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeElementDeclaration145.getTree());

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

<<<<<<< local
            char_literal140=(Token)match(input,25,FOLLOW_25_in_annotationTypeBody2741); if (state.failed) return retval;
=======
            char_literal146=(Token)match(input,25,FOLLOW_25_in_annotationTypeBody2719); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal140_tree = (Object)adaptor.create(char_literal140);
            adaptor.addChild(root_0, char_literal140_tree);
=======
            char_literal146_tree = (Object)adaptor.create(char_literal146);
            adaptor.addChild(root_0, char_literal146_tree);
>>>>>>> other
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 76, annotationTypeBody_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 75, annotationTypeBody_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "annotationTypeBody"

    public static class annotationTypeElementDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementDeclaration"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:961:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:937:1: annotationTypeElementDeclaration : annotationTypeElementRest ;
>>>>>>> other
    public final MViewParser.annotationTypeElementDeclaration_return annotationTypeElementDeclaration() throws RecognitionException {
        MViewParser.annotationTypeElementDeclaration_return retval = new MViewParser.annotationTypeElementDeclaration_return();
        retval.start = input.LT(1);
        int annotationTypeElementDeclaration_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        MViewParser.annotationTypeElementRest_return annotationTypeElementRest141 = null;
=======
        MViewParser.annotationTypeElementRest_return annotationTypeElementRest147 = null;
>>>>>>> other



        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:962:5: ( annotationTypeElementRest )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:962:23: annotationTypeElementRest
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:938:5: ( annotationTypeElementRest )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:938:23: annotationTypeElementRest
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2766);
            annotationTypeElementRest141=annotationTypeElementRest();
=======
            pushFollow(FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2744);
            annotationTypeElementRest147=annotationTypeElementRest();
>>>>>>> other

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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 77, annotationTypeElementDeclaration_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 76, annotationTypeElementDeclaration_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementDeclaration"

    public static class annotationTypeElementRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationTypeElementRest"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:965:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:941:1: annotationTypeElementRest : ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? );
>>>>>>> other
    public final MViewParser.annotationTypeElementRest_return annotationTypeElementRest() throws RecognitionException {
        MViewParser.annotationTypeElementRest_return retval = new MViewParser.annotationTypeElementRest_return();
        retval.start = input.LT(1);
        int annotationTypeElementRest_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token char_literal144=null;
        Token char_literal146=null;
        MViewParser.type_return type142 = null;
=======
        Token char_literal150=null;
        Token char_literal152=null;
        MViewParser.type_return type148 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest143 = null;
=======
        MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest149 = null;
>>>>>>> other

<<<<<<< local
        MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration145 = null;
=======
        MViewParser.annotationTypeDeclaration_return annotationTypeDeclaration151 = null;
>>>>>>> other


<<<<<<< local
        Object char_literal144_tree=null;
        Object char_literal146_tree=null;
=======
        Object char_literal150_tree=null;
        Object char_literal152_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:966:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt66=2;
            int LA66_0 = input.LA(1);
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:942:5: ( type annotationMethodOrConstantRest ';' | annotationTypeDeclaration ( ';' )? )
            int alt68=2;
            int LA68_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA66_0==Identifier||(LA66_0>=62 && LA66_0<=69)) ) {
                alt66=1;
=======
            if ( (LA68_0==Identifier||(LA68_0>=62 && LA68_0<=69)) ) {
                alt68=1;
>>>>>>> other
            }
<<<<<<< local
            else if ( (LA66_0==75) ) {
                alt66=2;
=======
            else if ( (LA68_0==75) ) {
                alt68=2;
>>>>>>> other
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
<<<<<<< local
            switch (alt66) {
=======
            switch (alt68) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:966:9: type annotationMethodOrConstantRest ';'
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:942:9: type annotationMethodOrConstantRest ';'
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2789);
                    type142=type();
=======
                    pushFollow(FOLLOW_type_in_annotationTypeElementRest2767);
                    type148=type();
>>>>>>> other

                    state._fsp--;
                    if (state.failed) return retval;
<<<<<<< local
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type142.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2791);
                    annotationMethodOrConstantRest143=annotationMethodOrConstantRest();
=======
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type148.getTree());
                    pushFollow(FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2769);
                    annotationMethodOrConstantRest149=annotationMethodOrConstantRest();
>>>>>>> other

                    state._fsp--;
                    if (state.failed) return retval;
<<<<<<< local
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest143.getTree());
                    char_literal144=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2793); if (state.failed) return retval;
=======
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationMethodOrConstantRest149.getTree());
                    char_literal150=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2771); if (state.failed) return retval;
>>>>>>> other
                    if ( state.backtracking==0 ) {
<<<<<<< local
                    char_literal144_tree = (Object)adaptor.create(char_literal144);
                    adaptor.addChild(root_0, char_literal144_tree);
=======
                    char_literal150_tree = (Object)adaptor.create(char_literal150);
                    adaptor.addChild(root_0, char_literal150_tree);
>>>>>>> other
                    }

                    }
                    break;
                case 2 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:967:9: annotationTypeDeclaration ( ';' )?
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:943:9: annotationTypeDeclaration ( ';' )?
>>>>>>> other
                    {
                    root_0 = (Object)adaptor.nil();

<<<<<<< local
                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2803);
                    annotationTypeDeclaration145=annotationTypeDeclaration();
=======
                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2781);
                    annotationTypeDeclaration151=annotationTypeDeclaration();
>>>>>>> other

                    state._fsp--;
                    if (state.failed) return retval;
<<<<<<< local
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration145.getTree());
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:967:35: ( ';' )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);
=======
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, annotationTypeDeclaration151.getTree());
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:943:35: ( ';' )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
                    if ( (LA65_0==26) ) {
                        alt65=1;
=======
                    if ( (LA67_0==26) ) {
                        alt67=1;
>>>>>>> other
                    }
<<<<<<< local
                    switch (alt65) {
=======
                    switch (alt67) {
>>>>>>> other
                        case 1 :
<<<<<<< local
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: ';'
=======
                            // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: ';'
>>>>>>> other
                            {
<<<<<<< local
                            char_literal146=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2805); if (state.failed) return retval;
=======
                            char_literal152=(Token)match(input,26,FOLLOW_26_in_annotationTypeElementRest2783); if (state.failed) return retval;
>>>>>>> other
                            if ( state.backtracking==0 ) {
<<<<<<< local
                            char_literal146_tree = (Object)adaptor.create(char_literal146);
                            adaptor.addChild(root_0, char_literal146_tree);
=======
                            char_literal152_tree = (Object)adaptor.create(char_literal152);
                            adaptor.addChild(root_0, char_literal152_tree);
>>>>>>> other
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 78, annotationTypeElementRest_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 77, annotationTypeElementRest_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "annotationTypeElementRest"

    public static class annotationMethodOrConstantRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodOrConstantRest"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:970:1: annotationMethodOrConstantRest : annotationMethodRest ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:946:1: annotationMethodOrConstantRest : annotationMethodRest ;
>>>>>>> other
    public final MViewParser.annotationMethodOrConstantRest_return annotationMethodOrConstantRest() throws RecognitionException {
        MViewParser.annotationMethodOrConstantRest_return retval = new MViewParser.annotationMethodOrConstantRest_return();
        retval.start = input.LT(1);
        int annotationMethodOrConstantRest_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        MViewParser.annotationMethodRest_return annotationMethodRest147 = null;
=======
        MViewParser.annotationMethodRest_return annotationMethodRest153 = null;
>>>>>>> other



        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:971:5: ( annotationMethodRest )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:971:9: annotationMethodRest
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:947:5: ( annotationMethodRest )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:947:9: annotationMethodRest
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2829);
            annotationMethodRest147=annotationMethodRest();
=======
            pushFollow(FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2807);
            annotationMethodRest153=annotationMethodRest();
>>>>>>> other

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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 79, annotationMethodOrConstantRest_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 78, annotationMethodOrConstantRest_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "annotationMethodOrConstantRest"

    public static class annotationMethodRest_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationMethodRest"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:974:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:950:1: annotationMethodRest : Identifier '(' ')' ( defaultValue )? ;
>>>>>>> other
    public final MViewParser.annotationMethodRest_return annotationMethodRest() throws RecognitionException {
        MViewParser.annotationMethodRest_return retval = new MViewParser.annotationMethodRest_return();
        retval.start = input.LT(1);
        int annotationMethodRest_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token Identifier148=null;
        Token char_literal149=null;
        Token char_literal150=null;
        MViewParser.defaultValue_return defaultValue151 = null;
=======
        Token Identifier154=null;
        Token char_literal155=null;
        Token char_literal156=null;
        MViewParser.defaultValue_return defaultValue157 = null;
>>>>>>> other


<<<<<<< local
        Object Identifier148_tree=null;
        Object char_literal149_tree=null;
        Object char_literal150_tree=null;
=======
        Object Identifier154_tree=null;
        Object char_literal155_tree=null;
        Object char_literal156_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:975:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:975:9: Identifier '(' ')' ( defaultValue )?
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:951:5: ( Identifier '(' ')' ( defaultValue )? )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:951:9: Identifier '(' ')' ( defaultValue )?
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            Identifier148=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2852); if (state.failed) return retval;
=======
            Identifier154=(Token)match(input,Identifier,FOLLOW_Identifier_in_annotationMethodRest2830); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            Identifier148_tree = (Object)adaptor.create(Identifier148);
            adaptor.addChild(root_0, Identifier148_tree);
=======
            Identifier154_tree = (Object)adaptor.create(Identifier154);
            adaptor.addChild(root_0, Identifier154_tree);
>>>>>>> other
            }
<<<<<<< local
            char_literal149=(Token)match(input,27,FOLLOW_27_in_annotationMethodRest2854); if (state.failed) return retval;
=======
            char_literal155=(Token)match(input,27,FOLLOW_27_in_annotationMethodRest2832); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal149_tree = (Object)adaptor.create(char_literal149);
            adaptor.addChild(root_0, char_literal149_tree);
=======
            char_literal155_tree = (Object)adaptor.create(char_literal155);
            adaptor.addChild(root_0, char_literal155_tree);
>>>>>>> other
            }
<<<<<<< local
            char_literal150=(Token)match(input,28,FOLLOW_28_in_annotationMethodRest2856); if (state.failed) return retval;
=======
            char_literal156=(Token)match(input,28,FOLLOW_28_in_annotationMethodRest2834); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            char_literal150_tree = (Object)adaptor.create(char_literal150);
            adaptor.addChild(root_0, char_literal150_tree);
=======
            char_literal156_tree = (Object)adaptor.create(char_literal156);
            adaptor.addChild(root_0, char_literal156_tree);
>>>>>>> other
            }
<<<<<<< local
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:975:28: ( defaultValue )?
            int alt67=2;
            int LA67_0 = input.LA(1);
=======
            // /Users/marko/hg/mview/src/mview/parser/MView.g:951:28: ( defaultValue )?
            int alt69=2;
            int LA69_0 = input.LA(1);
>>>>>>> other

<<<<<<< local
            if ( (LA67_0==77) ) {
                alt67=1;
=======
            if ( (LA69_0==77) ) {
                alt69=1;
>>>>>>> other
            }
<<<<<<< local
            switch (alt67) {
=======
            switch (alt69) {
>>>>>>> other
                case 1 :
<<<<<<< local
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:0:0: defaultValue
=======
                    // /Users/marko/hg/mview/src/mview/parser/MView.g:0:0: defaultValue
>>>>>>> other
                    {
                    pushFollow(FOLLOW_defaultValue_in_annotationMethodRest2836);
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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 80, annotationMethodRest_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 79, annotationMethodRest_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "annotationMethodRest"

    public static class defaultValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultValue"
<<<<<<< local
    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:978:1: defaultValue : 'default' elementValue ;
=======
    // /Users/marko/hg/mview/src/mview/parser/MView.g:954:1: defaultValue : 'default' elementValue ;
>>>>>>> other
    public final MViewParser.defaultValue_return defaultValue() throws RecognitionException {
        MViewParser.defaultValue_return retval = new MViewParser.defaultValue_return();
        retval.start = input.LT(1);
        int defaultValue_StartIndex = input.index();
        Object root_0 = null;

<<<<<<< local
        Token string_literal152=null;
        MViewParser.elementValue_return elementValue153 = null;
=======
        Token string_literal158=null;
        MViewParser.elementValue_return elementValue159 = null;
>>>>>>> other


<<<<<<< local
        Object string_literal152_tree=null;
=======
        Object string_literal158_tree=null;
>>>>>>> other

        try {
<<<<<<< local
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return retval; }
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:979:5: ( 'default' elementValue )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:979:9: 'default' elementValue
=======
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return retval; }
            // /Users/marko/hg/mview/src/mview/parser/MView.g:955:5: ( 'default' elementValue )
            // /Users/marko/hg/mview/src/mview/parser/MView.g:955:9: 'default' elementValue
>>>>>>> other
            {
            root_0 = (Object)adaptor.nil();

<<<<<<< local
            string_literal152=(Token)match(input,77,FOLLOW_77_in_defaultValue2886); if (state.failed) return retval;
=======
            string_literal158=(Token)match(input,77,FOLLOW_77_in_defaultValue2864); if (state.failed) return retval;
>>>>>>> other
            if ( state.backtracking==0 ) {
<<<<<<< local
            string_literal152_tree = (Object)adaptor.create(string_literal152);
            adaptor.addChild(root_0, string_literal152_tree);
=======
            string_literal158_tree = (Object)adaptor.create(string_literal158);
            adaptor.addChild(root_0, string_literal158_tree);
>>>>>>> other
            }
<<<<<<< local
            pushFollow(FOLLOW_elementValue_in_defaultValue2888);
            elementValue153=elementValue();
=======
            pushFollow(FOLLOW_elementValue_in_defaultValue2866);
            elementValue159=elementValue();
>>>>>>> other

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
<<<<<<< local
            if ( state.backtracking>0 ) { memoize(input, 81, defaultValue_StartIndex); }
=======
            if ( state.backtracking>0 ) { memoize(input, 80, defaultValue_StartIndex); }
>>>>>>> other
        }
        return retval;
    }
    // $ANTLR end "defaultValue"

    // Delegated rules


 

<<<<<<< local
    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit101 = new BitSet(new long[]{0x1000018080800002L});
    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit114 = new BitSet(new long[]{0x1000018080800002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_compilationUnit127 = new BitSet(new long[]{0x1000018080800002L});
    public static final BitSet FOLLOW_applicationDeclaration_in_compilationUnit140 = new BitSet(new long[]{0x1000018080800002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration174 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration178 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_interfaceBody198 = new BitSet(new long[]{0xE000000002000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody200 = new BitSet(new long[]{0xE000000002000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_25_in_interfaceBody204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration220 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceBodyDeclaration222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_serviceReferenceDeclaration247 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_actualParameters_in_serviceReferenceDeclaration251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_actualParameters280 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameters285 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_actualParameters291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_actualParameterDecls316 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_actualParameterDecls319 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameterDecls323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceHeaderDeclaration376 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_serviceHeaderDeclaration380 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceHeaderDeclaration384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_formalParameters456 = new BitSet(new long[]{0xE000000010000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters461 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_formalParameters467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls493 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls497 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_formalParameterDecls500 = new BitSet(new long[]{0xE000000000000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negationModifier_in_pointcutServiceSignatureDecl540 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl546 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl554 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_pointcutServiceSignatureParameters585 = new BitSet(new long[]{0x0000000050000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters588 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_pointcutServiceSignatureParameters594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureParameterDecls609 = new BitSet(new long[]{0x0000000020000012L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls618 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutServiceSignatureParameterDecls623 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_connectorDeclaration656 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_connectorDeclaration662 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration666 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_connectorDeclaration674 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorBody695 = new BitSet(new long[]{0x1000400102000000L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody697 = new BitSet(new long[]{0x1000400102000000L});
    public static final BitSet FOLLOW_25_in_connectorBody701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aoCompositionDeclaration_in_connectorBodyDeclaration716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_aoCompositionDeclaration745 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_aoCompositionDeclaration751 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_aoCompositionDeclaration755 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_aoCompositionDeclaration763 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_aoCompositionBody_in_aoCompositionDeclaration770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_aoCompositionBody784 = new BitSet(new long[]{0x0000080202000000L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_aoCompositionBody791 = new BitSet(new long[]{0x0000080002000000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_aoCompositionBody800 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_aoCompositionBody807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pointcutDeclaration824 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutBody844 = new BitSet(new long[]{0x0600007402000000L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody846 = new BitSet(new long[]{0x0600007402000000L});
    public static final BitSet FOLLOW_25_in_pointcutBody850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_pointcutKindDeclaration893 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutKindDeclaration895 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_joinPointKind_in_pointcutKindDeclaration899 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutKindDeclaration901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration920 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_pointcutSignatureDeclaration926 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutSignatureDeclaration928 = new BitSet(new long[]{0x0800000040000010L});
    public static final BitSet FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration932 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutSignatureDeclaration936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls972 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutSignatureBodyDecls976 = new BitSet(new long[]{0x0800000040000010L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_pointcutActorDeclaration1000 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_pointcutActorDeclaration1015 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutActorBody1047 = new BitSet(new long[]{0x0600078002800000L});
    public static final BitSet FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1049 = new BitSet(new long[]{0x0600078002800000L});
    public static final BitSet FOLLOW_25_in_pointcutActorBody1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1074 = new BitSet(new long[]{0x0000078000800000L});
    public static final BitSet FOLLOW_23_in_pointcutActorBodyDecls1085 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1087 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_39_in_pointcutActorBodyDecls1099 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1101 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_40_in_pointcutActorBodyDecls1112 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1114 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_41_in_pointcutActorBodyDecls1125 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1127 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_42_in_pointcutActorBodyDecls1138 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1140 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1149 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutActorBodyDecls1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negationModifier_in_pointcutActorPropDecls1169 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1175 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutActorPropDecls1180 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutActorPropDecl1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_adviceDeclaration1230 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_adviceBody1249 = new BitSet(new long[]{0x0000320002000000L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody1251 = new BitSet(new long[]{0x0000320002000000L});
    public static final BitSet FOLLOW_25_in_adviceBody1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceInstanceDeclaration_in_adviceBodyDeclaration1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_adviceServiceDeclaration1300 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceServiceDeclaration1302 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1306 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceServiceDeclaration1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_adviceTypeDeclaration1327 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceTypeDeclaration1329 = new BitSet(new long[]{0x0070000000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration1333 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceTypeDeclaration1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_adviceInstanceDeclaration1351 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceInstanceDeclaration1353 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_instanceReferenceDeclaration_in_adviceInstanceDeclaration1357 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceInstanceDeclaration1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_instanceReferenceDeclaration1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_componentDeclaration1407 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration1411 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_componentBody1437 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody1439 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_25_in_componentBody1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_moduleDependencyBody1495 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1500 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_moduleDependencyBody1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_moduleRequireDependencyDeclaration1525 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_moduleProvideDependencyDeclaration1544 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_applicationDeclaration1581 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_applicationDeclaration1587 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_applicationDeclaration1591 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_applicationDeclaration1599 = new BitSet(new long[]{0x0004000001000000L});
    public static final BitSet FOLLOW_applicationBody_in_applicationDeclaration1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_applicationBody1620 = new BitSet(new long[]{0x1000048082000010L});
    public static final BitSet FOLLOW_applicationBodyDeclaration_in_applicationBody1624 = new BitSet(new long[]{0x1000048082000010L});
    public static final BitSet FOLLOW_25_in_applicationBody1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hostDeclaration_in_applicationBodyDeclaration1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedDeclarationReference_in_instanceDeclaration1702 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1707 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_instanceDeclaration1711 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1715 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_instanceDeclaration1717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_hostDeclaration1744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_hostDeclaration1748 = new BitSet(new long[]{0x0002000004000000L});
    public static final BitSet FOLLOW_49_in_hostDeclaration1756 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_StringLiteral_in_hostDeclaration1760 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_hostDeclaration1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_componentDeclaration_in_moduleContainerDeclarations1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_refinementDeclarationSingle1828 = new BitSet(new long[]{0x1000048080000010L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1849 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_refinementDeclaration1854 = new BitSet(new long[]{0x1000048080000010L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclaration1858 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_qualifiedDeclarationReference_in_refinementDeclarationBody1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_qualifiedDeclarationReference1919 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_qualifiedDeclarationReference1926 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_qualifiedDeclarationReference1930 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls1961 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_commaSeparatedBodyDecls1964 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_adviceType1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_adviceType2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_adviceType2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_joinPointKind2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_joinPointKind2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_overrideOrExtend2060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_overrideOrExtend2069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_negationModifier2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_abstractModifier2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_voidType2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2198 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2217 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_classOrInterfaceType2231 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2235 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2261 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType2286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_primitiveType2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_primitiveType2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_primitiveType2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_primitiveType2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_primitiveType2346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_primitiveType2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_primitiveType2370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_typeArguments2393 = new BitSet(new long[]{0xE000000000000010L,0x000000000000013FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2395 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_29_in_typeArguments2399 = new BitSet(new long[]{0xE000000000000010L,0x000000000000013FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2401 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_typeArguments2406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_typeArgument2437 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_set_in_typeArgument2442 = new BitSet(new long[]{0xE000000000000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_typeArgument2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations2482 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_annotation2502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation2504 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_annotation2508 = new BitSet(new long[]{0x0000000011000010L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation2512 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation2516 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotation2521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2545 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_annotationName2548 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2550 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2571 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_elementValuePairs2574 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2576 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair2597 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_elementValuePair2599 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue2624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue2634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_elementValueArrayInitializer2657 = new BitSet(new long[]{0x0000000023000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2660 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2663 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2665 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2672 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elementValueArrayInitializer2676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_annotationTypeDeclaration2703 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration2705 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration2709 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeBody2734 = new BitSet(new long[]{0xE000000002000010L,0x000000000000083FL});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2737 = new BitSet(new long[]{0xE000000002000010L,0x000000000000083FL});
    public static final BitSet FOLLOW_25_in_annotationTypeBody2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2789 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2791 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2803 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2852 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_annotationMethodRest2854 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotationMethodRest2856 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_defaultValue2886 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2888 = new BitSet(new long[]{0x0000000000000002L});
=======
    public static final BitSet FOLLOW_interfaceDeclaration_in_compilationUnit101 = new BitSet(new long[]{0x1001018080800002L});
    public static final BitSet FOLLOW_componentDeclaration_in_compilationUnit114 = new BitSet(new long[]{0x1001018080800002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_compilationUnit127 = new BitSet(new long[]{0x1001018080800002L});
    public static final BitSet FOLLOW_applicationDeclaration_in_compilationUnit140 = new BitSet(new long[]{0x1001018080800002L});
    public static final BitSet FOLLOW_deploymentDeclaration_in_compilationUnit153 = new BitSet(new long[]{0x1001018080800002L});
    public static final BitSet FOLLOW_23_in_interfaceDeclaration183 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_interfaceDeclaration187 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_interfaceBody_in_interfaceDeclaration193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_interfaceBody207 = new BitSet(new long[]{0xE000000002000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody209 = new BitSet(new long[]{0xE000000002000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_25_in_interfaceBody213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceDeclaration_in_interfaceBodyDeclaration229 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_interfaceBodyDeclaration231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_serviceReferenceDeclaration256 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_actualParameters_in_serviceReferenceDeclaration260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_actualParameters289 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameters294 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_actualParameters300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_actualParameterDecls325 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_actualParameterDecls328 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_actualParameterDecls_in_actualParameterDecls332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceHeaderDeclaration_in_serviceDeclaration365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceReturnType_in_serviceHeaderDeclaration385 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_serviceHeaderDeclaration389 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_formalParameters_in_serviceHeaderDeclaration393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voidType_in_serviceReturnType419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_serviceReturnType433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_formalParameters465 = new BitSet(new long[]{0xE000000010000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters470 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_formalParameters476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameterDecls502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterDecls506 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_formalParameterDecls509 = new BitSet(new long[]{0xE000000000000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameterDecls513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negationModifier_in_pointcutServiceSignatureDecl549 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl555 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureDecl563 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameters_in_pointcutServiceSignatureDecl571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_pointcutServiceSignatureParameters594 = new BitSet(new long[]{0x0000000050000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameters597 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_pointcutServiceSignatureParameters603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pointcutServiceSignatureParameterDecls618 = new BitSet(new long[]{0x0000000020000012L});
    public static final BitSet FOLLOW_Identifier_in_pointcutServiceSignatureParameterDecls627 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutServiceSignatureParameterDecls632 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_pointcutServiceSignatureParameterDecls_in_pointcutServiceSignatureParameterDecls634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_connectorDeclaration665 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_connectorDeclaration671 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_connectorDeclaration675 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_connectorDeclaration683 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_connectorBody_in_connectorDeclaration690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_connectorBody704 = new BitSet(new long[]{0x1000400102000000L});
    public static final BitSet FOLLOW_connectorBodyDeclaration_in_connectorBody706 = new BitSet(new long[]{0x1000400102000000L});
    public static final BitSet FOLLOW_25_in_connectorBody710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aoCompositionDeclaration_in_connectorBodyDeclaration725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_connectorBodyDeclaration732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_aoCompositionDeclaration754 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_aoCompositionDeclaration760 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_aoCompositionDeclaration764 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_refinementDeclarationSingle_in_aoCompositionDeclaration772 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_aoCompositionBody_in_aoCompositionDeclaration779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_aoCompositionBody793 = new BitSet(new long[]{0x0000080202000000L});
    public static final BitSet FOLLOW_pointcutDeclaration_in_aoCompositionBody800 = new BitSet(new long[]{0x0000080002000000L});
    public static final BitSet FOLLOW_adviceDeclaration_in_aoCompositionBody809 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_aoCompositionBody816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_pointcutDeclaration833 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutBody_in_pointcutDeclaration837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutBody853 = new BitSet(new long[]{0x0600007402000000L});
    public static final BitSet FOLLOW_pointcutBodyDeclaration_in_pointcutBody855 = new BitSet(new long[]{0x0600007402000000L});
    public static final BitSet FOLLOW_25_in_pointcutBody859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutKindDeclaration_in_pointcutBodyDeclaration873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureDeclaration_in_pointcutBodyDeclaration879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutActorDeclaration_in_pointcutBodyDeclaration885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_pointcutKindDeclaration902 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutKindDeclaration904 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_joinPointKind_in_pointcutKindDeclaration908 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutKindDeclaration910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutSignatureDeclaration929 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_pointcutSignatureDeclaration935 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutSignatureDeclaration937 = new BitSet(new long[]{0x0800000040000010L});
    public static final BitSet FOLLOW_pointcutSignatureBody_in_pointcutSignatureDeclaration941 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutSignatureDeclaration945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBody964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointcutServiceSignatureDecl_in_pointcutSignatureBodyDecls981 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutSignatureBodyDecls985 = new BitSet(new long[]{0x0800000040000010L});
    public static final BitSet FOLLOW_pointcutSignatureBodyDecls_in_pointcutSignatureBodyDecls987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_pointcutActorDeclaration1009 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_pointcutActorDeclaration1024 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_pointcutActorBody_in_pointcutActorDeclaration1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_pointcutActorBody1056 = new BitSet(new long[]{0x0600078002800000L});
    public static final BitSet FOLLOW_pointcutActorBodyDecls_in_pointcutActorBody1058 = new BitSet(new long[]{0x0600078002800000L});
    public static final BitSet FOLLOW_25_in_pointcutActorBody1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_overrideOrExtend_in_pointcutActorBodyDecls1083 = new BitSet(new long[]{0x0000078000800000L});
    public static final BitSet FOLLOW_23_in_pointcutActorBodyDecls1092 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1094 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_39_in_pointcutActorBodyDecls1104 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1106 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_40_in_pointcutActorBodyDecls1115 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1117 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_41_in_pointcutActorBodyDecls1126 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1128 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_42_in_pointcutActorBodyDecls1137 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_pointcutActorBodyDecls1139 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorBodyDecls1148 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_pointcutActorBodyDecls1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negationModifier_in_pointcutActorPropDecls1168 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecl_in_pointcutActorPropDecls1174 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_pointcutActorPropDecls1179 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_pointcutActorPropDecls_in_pointcutActorPropDecls1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_pointcutActorPropDecl1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_adviceDeclaration1229 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_adviceBody_in_adviceDeclaration1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_adviceBody1248 = new BitSet(new long[]{0x0000300002000000L});
    public static final BitSet FOLLOW_adviceBodyDeclaration_in_adviceBody1250 = new BitSet(new long[]{0x0000300002000000L});
    public static final BitSet FOLLOW_25_in_adviceBody1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceServiceDeclaration_in_adviceBodyDeclaration1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_adviceTypeDeclaration_in_adviceBodyDeclaration1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_adviceServiceDeclaration1293 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceServiceDeclaration1295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_serviceReferenceDeclaration_in_adviceServiceDeclaration1299 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceServiceDeclaration1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_adviceTypeDeclaration1320 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_adviceTypeDeclaration1322 = new BitSet(new long[]{0x0070000000000000L});
    public static final BitSet FOLLOW_adviceType_in_adviceTypeDeclaration1326 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_adviceTypeDeclaration1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_componentDeclaration1355 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_componentDeclaration1359 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_componentBody_in_componentDeclaration1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_componentBody1385 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_componentBodyDeclaration_in_componentBody1387 = new BitSet(new long[]{0x1000C00102000000L});
    public static final BitSet FOLLOW_25_in_componentBody1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleRequireDependencyDeclaration_in_componentBodyDeclaration1409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleProvideDependencyDeclaration_in_componentBodyDeclaration1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_moduleDependencyBody1443 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_moduleDependencyBody1448 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_moduleDependencyBody1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_moduleRequireDependencyDeclaration1473 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleRequireDependencyDeclaration1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_moduleProvideDependencyDeclaration1492 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleDependencyBody_in_moduleProvideDependencyDeclaration1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_applicationDeclaration1529 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_applicationDeclaration1535 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_applicationDeclaration1539 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_applicationDeclaration1547 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_applicationBody_in_applicationDeclaration1554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_applicationBody1568 = new BitSet(new long[]{0x1000048082000010L});
    public static final BitSet FOLLOW_applicationBodyDeclaration_in_applicationBody1572 = new BitSet(new long[]{0x1000048082000010L});
    public static final BitSet FOLLOW_25_in_applicationBody1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleContainerDeclarations_in_applicationBodyDeclaration1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hostDeclaration_in_applicationBodyDeclaration1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instanceDeclaration_in_applicationBodyDeclaration1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstractModifier_in_deploymentDeclaration1643 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_deploymentDeclaration1649 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_deploymentDeclaration1653 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_refinementDeclaration_in_deploymentDeclaration1661 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_applicationBody_in_deploymentDeclaration1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1691 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1695 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_instanceDeclaration1699 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_instanceDeclaration1703 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_instanceDeclaration1705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_hostDeclaration1732 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_hostDeclaration1736 = new BitSet(new long[]{0x0004000004000000L});
    public static final BitSet FOLLOW_50_in_hostDeclaration1744 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_StringLiteral_in_hostDeclaration1748 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_hostDeclaration1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_componentDeclaration_in_moduleContainerDeclarations1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectorDeclaration_in_moduleContainerDeclarations1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_refinementDeclarationSingle1817 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclarationSingle1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_refinementDeclarationSingle_in_refinementDeclaration1836 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_refinementDeclaration1841 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_refinementDeclarationBody_in_refinementDeclaration1843 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_refinementParentDeclaration_in_refinementDeclarationBody1864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_refinementParentDeclaration1894 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_refinementParentDeclaration1901 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_refinementParentDeclaration1905 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_Identifier_in_commaSeparatedBodyDecls1939 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_commaSeparatedBodyDecls1942 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_commaSeparatedBodyDecls_in_commaSeparatedBodyDecls1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_adviceType1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_adviceType1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_adviceType1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_joinPointKind2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_joinPointKind2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_overrideOrExtend2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_overrideOrExtend2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_negationModifier2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_abstractModifier2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_voidType2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_type2151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2176 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2195 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_classOrInterfaceType2209 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_classOrInterfaceType2213 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2239 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_62_in_primitiveType2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_primitiveType2276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_primitiveType2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_primitiveType2300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_primitiveType2312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_primitiveType2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_primitiveType2336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_primitiveType2348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_typeArguments2371 = new BitSet(new long[]{0xE000000000000010L,0x000000000000013FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2373 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_29_in_typeArguments2377 = new BitSet(new long[]{0xE000000000000010L,0x000000000000013FL});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2379 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_typeArguments2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_typeArgument2415 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_set_in_typeArgument2420 = new BitSet(new long[]{0xE000000000000010L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_typeArgument2430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations2460 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_annotation2480 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationName_in_annotation2482 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_annotation2486 = new BitSet(new long[]{0x0000000011000010L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation2490 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation2494 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotation2499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2523 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_annotationName2526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationName2528 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2549 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_elementValuePairs2552 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs2554 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Identifier_in_elementValuePair2575 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_elementValuePair2577 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair2579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue2602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue2612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_elementValueArrayInitializer2635 = new BitSet(new long[]{0x0000000023000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2638 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2641 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer2643 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_elementValueArrayInitializer2650 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elementValueArrayInitializer2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_annotationTypeDeclaration2681 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_annotationTypeDeclaration2683 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_annotationTypeDeclaration2687 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_annotationTypeBody2712 = new BitSet(new long[]{0xE000000002000010L,0x000000000000083FL});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody2715 = new BitSet(new long[]{0xE000000002000010L,0x000000000000083FL});
    public static final BitSet FOLLOW_25_in_annotationTypeBody2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeElementRest_in_annotationTypeElementDeclaration2744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_annotationTypeElementRest2767 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_annotationMethodOrConstantRest_in_annotationTypeElementRest2769 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementRest2781 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_annotationTypeElementRest2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodRest_in_annotationMethodOrConstantRest2807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_annotationMethodRest2830 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_annotationMethodRest2832 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_annotationMethodRest2834 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_defaultValue_in_annotationMethodRest2836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_defaultValue2864 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_elementValue_in_defaultValue2866 = new BitSet(new long[]{0x0000000000000002L});
>>>>>>> other

}
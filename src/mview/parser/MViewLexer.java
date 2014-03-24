// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g 2013-11-27 13:17:21
/**
 * Copyright 2013 KU Leuven Research and Development - iMinds - DistriNet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Administrative Contact: dnet-project-office@cs.kuleuven.be
 * Technical Contact: steven@opdebeeck.org
 */
package mview.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MViewLexer extends Lexer {
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

    public MViewLexer() {;} 
    public MViewLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MViewLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g"; }

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:7:7: ( 'interface' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:7:9: 'interface'
            {
            match("interface"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:8:7: ( '{' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:8:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:9:7: ( '}' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:9:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:10:7: ( ';' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:10:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:11:7: ( '(' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:11:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:12:7: ( ')' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:12:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:13:7: ( ',' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:13:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:14:7: ( '*' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:14:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:15:7: ( 'connector' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:15:9: 'connector'
            {
            match("connector"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:16:7: ( 'ao-composition' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:16:9: 'ao-composition'
            {
            match("ao-composition"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:17:7: ( 'pointcut' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:17:9: 'pointcut'
            {
            match("pointcut"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:18:7: ( 'kind' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:18:9: 'kind'
            {
            match("kind"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:19:7: ( ':' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:19:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:20:7: ( 'signature' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:20:9: 'signature'
            {
            match("signature"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:21:7: ( 'caller' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:21:9: 'caller'
            {
            match("caller"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:22:7: ( 'callee' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:22:9: 'callee'
            {
            match("callee"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:23:7: ( 'component' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:23:9: 'component'
            {
            match("component"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:24:7: ( 'application' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:24:9: 'application'
            {
            match("application"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:25:7: ( 'instance' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:25:9: 'instance'
            {
            match("instance"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:26:7: ( 'host' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:26:9: 'host'
            {
            match("host"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:27:7: ( 'advice' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:27:9: 'advice'
            {
            match("advice"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:28:7: ( 'method' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:28:9: 'method'
            {
            match("method"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:29:7: ( 'type' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:29:9: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:30:7: ( 'require' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:30:9: 'require'
            {
            match("require"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:31:7: ( 'provide' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:31:9: 'provide'
            {
            match("provide"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:32:7: ( 'on' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:32:9: 'on'
            {
            match("on"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:33:7: ( 'is' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:33:9: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:34:7: ( 'refines' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:34:9: 'refines'
            {
            match("refines"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:35:7: ( '.' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:35:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:36:7: ( 'before' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:36:9: 'before'
            {
            match("before"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:37:7: ( 'after' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:37:9: 'after'
            {
            match("after"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:38:7: ( 'around' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:38:9: 'around'
            {
            match("around"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:39:7: ( 'execution' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:39:9: 'execution'
            {
            match("execution"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:40:7: ( 'call' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:40:9: 'call'
            {
            match("call"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:41:7: ( 'override' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:41:9: 'override'
            {
            match("override"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:42:7: ( 'merge' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:42:9: 'merge'
            {
            match("merge"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:43:7: ( '!' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:43:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:44:7: ( 'abstract' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:44:9: 'abstract'
            {
            match("abstract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:45:7: ( 'void' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:45:9: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:46:7: ( 'boolean' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:46:9: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:47:7: ( 'char' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:47:9: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:48:7: ( 'byte' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:48:9: 'byte'
            {
            match("byte"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:49:7: ( 'short' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:49:9: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:50:7: ( 'int' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:50:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:51:7: ( 'long' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:51:9: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:52:7: ( 'float' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:52:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:53:7: ( 'double' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:53:9: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:54:7: ( '<' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:54:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:55:7: ( '>' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:55:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:56:7: ( '?' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:56:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:57:7: ( 'extends' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:57:9: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:58:7: ( 'super' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:58:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:59:7: ( '@' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:59:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:60:7: ( '=' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:60:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:61:7: ( 'default' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:61:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "HexLiteral"
    public final void mHexLiteral() throws RecognitionException {
        try {
            int _type = HexLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1014:12: ( '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1014:14: '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )?
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1014:28: ( HexDigit )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='F')||(LA1_0>='a' && LA1_0<='f')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1014:28: HexDigit
            	    {
            	    mHexDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1014:38: ( IntegerTypeSuffix )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='L'||LA2_0=='l') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1014:38: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HexLiteral"

    // $ANTLR start "DecimalLiteral"
    public final void mDecimalLiteral() throws RecognitionException {
        try {
            int _type = DecimalLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1016:16: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1016:18: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )?
            {
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1016:18: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='0') ) {
                alt4=1;
            }
            else if ( ((LA4_0>='1' && LA4_0<='9')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1016:19: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1016:25: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1016:34: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1016:34: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1016:45: ( IntegerTypeSuffix )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='L'||LA5_0=='l') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1016:45: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DecimalLiteral"

    // $ANTLR start "OctalLiteral"
    public final void mOctalLiteral() throws RecognitionException {
        try {
            int _type = OctalLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1018:14: ( '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )? )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1018:16: '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )?
            {
            match('0'); 
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1018:20: ( '0' .. '7' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='7')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1018:21: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1018:32: ( IntegerTypeSuffix )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='L'||LA7_0=='l') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1018:32: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OctalLiteral"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1021:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1021:12: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "IntegerTypeSuffix"
    public final void mIntegerTypeSuffix() throws RecognitionException {
        try {
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1024:19: ( ( 'l' | 'L' ) )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1024:21: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "IntegerTypeSuffix"

    // $ANTLR start "FloatingPointLiteral"
    public final void mFloatingPointLiteral() throws RecognitionException {
        try {
            int _type = FloatingPointLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1027:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ FloatTypeSuffix )
            int alt18=4;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1027:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )?
                    {
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1027:9: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1027:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    match('.'); 
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1027:25: ( '0' .. '9' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1027:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1027:37: ( Exponent )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1027:37: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1027:47: ( FloatTypeSuffix )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='D'||LA11_0=='F'||LA11_0=='d'||LA11_0=='f') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1027:47: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1028:9: '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )?
                    {
                    match('.'); 
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1028:13: ( '0' .. '9' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1028:14: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1028:25: ( Exponent )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='E'||LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1028:25: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1028:35: ( FloatTypeSuffix )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='D'||LA14_0=='F'||LA14_0=='d'||LA14_0=='f') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1028:35: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1029:9: ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )?
                    {
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1029:9: ( '0' .. '9' )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1029:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    mExponent(); 
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1029:30: ( FloatTypeSuffix )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='D'||LA16_0=='F'||LA16_0=='d'||LA16_0=='f') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1029:30: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1030:9: ( '0' .. '9' )+ FloatTypeSuffix
                    {
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1030:9: ( '0' .. '9' )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1030:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    mFloatTypeSuffix(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FloatingPointLiteral"

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1034:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1034:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1034:22: ( '+' | '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='+'||LA19_0=='-') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1034:33: ( '0' .. '9' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='0' && LA20_0<='9')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1034:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "FloatTypeSuffix"
    public final void mFloatTypeSuffix() throws RecognitionException {
        try {
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1037:17: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1037:19: ( 'f' | 'F' | 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "FloatTypeSuffix"

    // $ANTLR start "CharacterLiteral"
    public final void mCharacterLiteral() throws RecognitionException {
        try {
            int _type = CharacterLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1040:5: ( '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1040:9: '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1040:14: ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\\') ) {
                alt21=1;
            }
            else if ( ((LA21_0>='\u0000' && LA21_0<='&')||(LA21_0>='(' && LA21_0<='[')||(LA21_0>=']' && LA21_0<='\uFFFF')) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1040:16: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1040:33: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CharacterLiteral"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1044:5: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1044:8: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1044:12: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='\\') ) {
                    alt22=1;
                }
                else if ( ((LA22_0>='\u0000' && LA22_0<='!')||(LA22_0>='#' && LA22_0<='[')||(LA22_0>=']' && LA22_0<='\uFFFF')) ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1044:14: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1044:31: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "StringLiteral"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1049:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEscape | OctalEscape )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt23=1;
                    }
                    break;
                case 'u':
                    {
                    alt23=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt23=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1049:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1050:9: UnicodeEscape
                    {
                    mUnicodeEscape(); 

                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1051:9: OctalEscape
                    {
                    mOctalEscape(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "OctalEscape"
    public final void mOctalEscape() throws RecognitionException {
        try {
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1056:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='\\') ) {
                int LA24_1 = input.LA(2);

                if ( ((LA24_1>='0' && LA24_1<='3')) ) {
                    int LA24_2 = input.LA(3);

                    if ( ((LA24_2>='0' && LA24_2<='7')) ) {
                        int LA24_4 = input.LA(4);

                        if ( ((LA24_4>='0' && LA24_4<='7')) ) {
                            alt24=1;
                        }
                        else {
                            alt24=2;}
                    }
                    else {
                        alt24=3;}
                }
                else if ( ((LA24_1>='4' && LA24_1<='7')) ) {
                    int LA24_3 = input.LA(3);

                    if ( ((LA24_3>='0' && LA24_3<='7')) ) {
                        alt24=2;
                    }
                    else {
                        alt24=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1056:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1056:14: ( '0' .. '3' )
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1056:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1056:25: ( '0' .. '7' )
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1056:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1056:36: ( '0' .. '7' )
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1056:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1057:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1057:14: ( '0' .. '7' )
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1057:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1057:25: ( '0' .. '7' )
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1057:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1058:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1058:14: ( '0' .. '7' )
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1058:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OctalEscape"

    // $ANTLR start "UnicodeEscape"
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1063:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1063:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('\\'); 
            match('u'); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UnicodeEscape"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1067:5: ( Letter ( Letter | JavaIDDigit )* )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1067:9: Letter ( Letter | JavaIDDigit )*
            {
            mLetter(); 
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1067:15: ( Letter | JavaIDDigit )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0=='$'||LA25_0=='*'||(LA25_0>='0' && LA25_0<='9')||(LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='z')||(LA25_0>='\u00C0' && LA25_0<='\u00D6')||(LA25_0>='\u00D8' && LA25_0<='\u00F6')||(LA25_0>='\u00F8' && LA25_0<='\u1FFF')||(LA25_0>='\u3040' && LA25_0<='\u318F')||(LA25_0>='\u3300' && LA25_0<='\u337F')||(LA25_0>='\u3400' && LA25_0<='\u3D2D')||(LA25_0>='\u4E00' && LA25_0<='\u9FFF')||(LA25_0>='\uF900' && LA25_0<='\uFAFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:
            	    {
            	    if ( input.LA(1)=='$'||input.LA(1)=='*'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Identifier"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1075:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' | '*' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:
            {
            if ( input.LA(1)=='$'||input.LA(1)=='*'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "JavaIDDigit"
    public final void mJavaIDDigit() throws RecognitionException {
        try {
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1093:5: ( '\\u0030' .. '\\u0039' | '\\u0660' .. '\\u0669' | '\\u06f0' .. '\\u06f9' | '\\u0966' .. '\\u096f' | '\\u09e6' .. '\\u09ef' | '\\u0a66' .. '\\u0a6f' | '\\u0ae6' .. '\\u0aef' | '\\u0b66' .. '\\u0b6f' | '\\u0be7' .. '\\u0bef' | '\\u0c66' .. '\\u0c6f' | '\\u0ce6' .. '\\u0cef' | '\\u0d66' .. '\\u0d6f' | '\\u0e50' .. '\\u0e59' | '\\u0ed0' .. '\\u0ed9' | '\\u1040' .. '\\u1049' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u06F0' && input.LA(1)<='\u06F9')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09EF')||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A6F')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "JavaIDDigit"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1110:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1110:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1114:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1114:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1114:14: ( options {greedy=false; } : . )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0=='*') ) {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1=='/') ) {
                        alt26=2;
                    }
                    else if ( ((LA26_1>='\u0000' && LA26_1<='.')||(LA26_1>='0' && LA26_1<='\uFFFF')) ) {
                        alt26=1;
                    }


                }
                else if ( ((LA26_0>='\u0000' && LA26_0<=')')||(LA26_0>='+' && LA26_0<='\uFFFF')) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1114:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            match("*/"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1118:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1118:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1118:12: (~ ( '\\n' | '\\r' ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='\u0000' && LA27_0<='\t')||(LA27_0>='\u000B' && LA27_0<='\f')||(LA27_0>='\u000E' && LA27_0<='\uFFFF')) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1118:12: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1118:26: ( '\\r' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0=='\r') ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1118:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:8: ( T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | CharacterLiteral | StringLiteral | Identifier | WS | COMMENT | LINE_COMMENT )
        int alt29=65;
        alt29 = dfa29.predict(input);
        switch (alt29) {
            case 1 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:10: T__23
                {
                mT__23(); 

                }
                break;
            case 2 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:16: T__24
                {
                mT__24(); 

                }
                break;
            case 3 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:22: T__25
                {
                mT__25(); 

                }
                break;
            case 4 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:28: T__26
                {
                mT__26(); 

                }
                break;
            case 5 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:34: T__27
                {
                mT__27(); 

                }
                break;
            case 6 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:40: T__28
                {
                mT__28(); 

                }
                break;
            case 7 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:46: T__29
                {
                mT__29(); 

                }
                break;
            case 8 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:52: T__30
                {
                mT__30(); 

                }
                break;
            case 9 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:58: T__31
                {
                mT__31(); 

                }
                break;
            case 10 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:64: T__32
                {
                mT__32(); 

                }
                break;
            case 11 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:70: T__33
                {
                mT__33(); 

                }
                break;
            case 12 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:76: T__34
                {
                mT__34(); 

                }
                break;
            case 13 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:82: T__35
                {
                mT__35(); 

                }
                break;
            case 14 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:88: T__36
                {
                mT__36(); 

                }
                break;
            case 15 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:94: T__37
                {
                mT__37(); 

                }
                break;
            case 16 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:100: T__38
                {
                mT__38(); 

                }
                break;
            case 17 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:106: T__39
                {
                mT__39(); 

                }
                break;
            case 18 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:112: T__40
                {
                mT__40(); 

                }
                break;
            case 19 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:118: T__41
                {
                mT__41(); 

                }
                break;
            case 20 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:124: T__42
                {
                mT__42(); 

                }
                break;
            case 21 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:130: T__43
                {
                mT__43(); 

                }
                break;
            case 22 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:136: T__44
                {
                mT__44(); 

                }
                break;
            case 23 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:142: T__45
                {
                mT__45(); 

                }
                break;
            case 24 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:148: T__46
                {
                mT__46(); 

                }
                break;
            case 25 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:154: T__47
                {
                mT__47(); 

                }
                break;
            case 26 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:160: T__48
                {
                mT__48(); 

                }
                break;
            case 27 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:166: T__49
                {
                mT__49(); 

                }
                break;
            case 28 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:172: T__50
                {
                mT__50(); 

                }
                break;
            case 29 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:178: T__51
                {
                mT__51(); 

                }
                break;
            case 30 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:184: T__52
                {
                mT__52(); 

                }
                break;
            case 31 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:190: T__53
                {
                mT__53(); 

                }
                break;
            case 32 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:196: T__54
                {
                mT__54(); 

                }
                break;
            case 33 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:202: T__55
                {
                mT__55(); 

                }
                break;
            case 34 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:208: T__56
                {
                mT__56(); 

                }
                break;
            case 35 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:214: T__57
                {
                mT__57(); 

                }
                break;
            case 36 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:220: T__58
                {
                mT__58(); 

                }
                break;
            case 37 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:226: T__59
                {
                mT__59(); 

                }
                break;
            case 38 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:232: T__60
                {
                mT__60(); 

                }
                break;
            case 39 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:238: T__61
                {
                mT__61(); 

                }
                break;
            case 40 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:244: T__62
                {
                mT__62(); 

                }
                break;
            case 41 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:250: T__63
                {
                mT__63(); 

                }
                break;
            case 42 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:256: T__64
                {
                mT__64(); 

                }
                break;
            case 43 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:262: T__65
                {
                mT__65(); 

                }
                break;
            case 44 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:268: T__66
                {
                mT__66(); 

                }
                break;
            case 45 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:274: T__67
                {
                mT__67(); 

                }
                break;
            case 46 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:280: T__68
                {
                mT__68(); 

                }
                break;
            case 47 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:286: T__69
                {
                mT__69(); 

                }
                break;
            case 48 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:292: T__70
                {
                mT__70(); 

                }
                break;
            case 49 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:298: T__71
                {
                mT__71(); 

                }
                break;
            case 50 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:304: T__72
                {
                mT__72(); 

                }
                break;
            case 51 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:310: T__73
                {
                mT__73(); 

                }
                break;
            case 52 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:316: T__74
                {
                mT__74(); 

                }
                break;
            case 53 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:322: T__75
                {
                mT__75(); 

                }
                break;
            case 54 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:328: T__76
                {
                mT__76(); 

                }
                break;
            case 55 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:334: T__77
                {
                mT__77(); 

                }
                break;
            case 56 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:340: HexLiteral
                {
                mHexLiteral(); 

                }
                break;
            case 57 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:351: DecimalLiteral
                {
                mDecimalLiteral(); 

                }
                break;
            case 58 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:366: OctalLiteral
                {
                mOctalLiteral(); 

                }
                break;
            case 59 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:379: FloatingPointLiteral
                {
                mFloatingPointLiteral(); 

                }
                break;
            case 60 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:400: CharacterLiteral
                {
                mCharacterLiteral(); 

                }
                break;
            case 61 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:417: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 62 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:431: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 63 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:442: WS
                {
                mWS(); 

                }
                break;
            case 64 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:445: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 65 :
                // /Users/steveno/repos/PhD/tooling/chameleon/mview/src/mview/parser/MView.g:1:453: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA29 dfa29 = new DFA29(this);
    static final String DFA18_eotS =
        "\6\uffff";
    static final String DFA18_eofS =
        "\6\uffff";
    static final String DFA18_minS =
        "\2\56\4\uffff";
    static final String DFA18_maxS =
        "\1\71\1\146\4\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\2\1\1\1\3\1\4";
    static final String DFA18_specialS =
        "\6\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\12\uffff\1\5\1\4\1\5\35\uffff\1\5\1\4\1\5",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1026:1: FloatingPointLiteral : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ FloatTypeSuffix );";
        }
    }
    static final String DFA29_eotS =
        "\1\uffff\1\45\6\uffff\1\52\4\45\1\uffff\6\45\1\100\2\45\1\uffff"+
        "\4\45\5\uffff\2\114\5\uffff\1\45\1\123\1\uffff\23\45\1\152\1\45"+
        "\2\uffff\11\45\2\uffff\1\166\1\114\2\uffff\1\170\1\45\1\uffff\4"+
        "\45\1\uffff\21\45\1\uffff\13\45\1\uffff\1\45\1\uffff\3\45\1\u009f"+
        "\1\u00a0\7\45\1\u00a8\3\45\1\u00ac\2\45\1\u00af\5\45\1\u00b5\2\45"+
        "\1\u00b8\1\u00b9\10\45\2\uffff\2\45\1\u00c5\4\45\1\uffff\1\45\1"+
        "\u00cb\1\u00cc\1\uffff\1\45\1\u00ce\1\uffff\5\45\1\uffff\2\45\2"+
        "\uffff\1\u00d6\6\45\1\u00dd\1\u00de\1\45\1\u00e0\1\uffff\1\u00e1"+
        "\4\45\2\uffff\1\u00e6\1\uffff\3\45\1\u00ea\3\45\1\uffff\1\u00ee"+
        "\5\45\2\uffff\1\45\2\uffff\2\45\1\u00f7\1\45\1\uffff\1\u00f9\1\u00fa"+
        "\1\45\1\uffff\1\u00fc\1\45\1\u00fe\1\uffff\1\u00ff\1\45\1\u0101"+
        "\3\45\1\u0105\1\u0106\1\uffff\1\45\2\uffff\1\u0108\1\uffff\1\45"+
        "\2\uffff\1\u010a\1\uffff\1\u010b\1\u010c\1\45\2\uffff\1\u010e\1"+
        "\uffff\1\u010f\3\uffff\1\45\2\uffff\1\u0111\1\uffff";
    static final String DFA29_eofS =
        "\u0112\uffff";
    static final String DFA29_minS =
        "\1\11\1\156\6\uffff\1\44\1\141\1\142\1\157\1\151\1\uffff\1\150\1"+
        "\157\1\145\1\171\1\145\1\156\1\60\1\145\1\170\1\uffff\2\157\1\154"+
        "\1\145\5\uffff\2\56\4\uffff\1\52\1\163\1\44\1\uffff\1\155\1\154"+
        "\1\141\1\55\1\160\1\166\1\164\1\157\1\163\1\151\1\157\1\156\1\147"+
        "\1\157\1\160\1\163\1\162\1\160\1\146\1\44\1\145\2\uffff\1\146\1"+
        "\157\1\164\1\145\1\151\1\156\1\157\1\165\1\146\2\uffff\2\56\2\uffff"+
        "\1\44\1\164\1\uffff\1\156\1\160\1\154\1\162\1\uffff\1\154\1\151"+
        "\1\145\1\165\1\164\1\156\1\166\1\144\1\156\1\162\1\145\1\164\1\150"+
        "\1\147\1\145\1\165\1\151\1\uffff\1\162\1\157\1\154\1\145\1\143\1"+
        "\145\1\144\1\147\1\141\1\142\1\141\1\uffff\1\162\1\uffff\1\141\1"+
        "\145\1\157\2\44\1\151\1\143\1\162\1\156\1\162\1\164\1\151\1\44\1"+
        "\141\1\164\1\162\1\44\1\157\1\145\1\44\1\151\1\156\2\162\1\145\1"+
        "\44\1\165\1\156\2\44\1\164\1\154\1\165\1\146\1\156\1\143\1\156\1"+
        "\145\2\uffff\1\143\1\145\1\44\1\144\1\141\1\143\1\144\1\uffff\1"+
        "\164\2\44\1\uffff\1\144\1\44\1\uffff\1\162\1\145\1\151\1\145\1\141"+
        "\1\uffff\1\164\1\144\2\uffff\1\44\1\145\1\154\1\141\1\143\1\164"+
        "\1\145\2\44\1\141\1\44\1\uffff\1\44\1\143\1\165\1\145\1\165\2\uffff"+
        "\1\44\1\uffff\1\145\1\163\1\144\1\44\1\156\1\151\1\163\1\uffff\1"+
        "\44\1\164\1\143\1\145\1\157\1\156\2\uffff\1\164\2\uffff\2\164\1"+
        "\44\1\162\1\uffff\2\44\1\145\1\uffff\1\44\1\157\1\44\1\uffff\1\44"+
        "\1\145\1\44\1\162\1\164\1\151\2\44\1\uffff\1\145\2\uffff\1\44\1"+
        "\uffff\1\156\2\uffff\1\44\1\uffff\2\44\1\157\2\uffff\1\44\1\uffff"+
        "\1\44\3\uffff\1\156\2\uffff\1\44\1\uffff";
    static final String DFA29_maxS =
        "\1\ufaff\1\163\6\uffff\1\ufaff\1\157\2\162\1\151\1\uffff\1\165\1"+
        "\157\1\145\1\171\1\145\1\166\1\71\1\171\1\170\1\uffff\2\157\1\154"+
        "\1\157\5\uffff\1\170\1\146\4\uffff\1\57\1\164\1\ufaff\1\uffff\1"+
        "\156\1\154\1\141\1\55\1\160\1\166\1\164\1\157\1\163\1\151\1\157"+
        "\1\156\1\147\1\157\1\160\1\163\1\164\1\160\1\161\1\ufaff\1\145\2"+
        "\uffff\1\146\1\157\2\164\1\151\1\156\1\157\1\165\1\146\2\uffff\2"+
        "\146\2\uffff\1\ufaff\1\164\1\uffff\1\156\1\160\1\154\1\162\1\uffff"+
        "\1\154\1\151\1\145\1\165\1\164\1\156\1\166\1\144\1\156\1\162\1\145"+
        "\1\164\1\150\1\147\1\145\1\165\1\151\1\uffff\1\162\1\157\1\154\1"+
        "\145\1\143\1\145\1\144\1\147\1\141\1\142\1\141\1\uffff\1\162\1\uffff"+
        "\1\141\1\145\1\157\2\ufaff\1\151\1\143\1\162\1\156\1\162\1\164\1"+
        "\151\1\ufaff\1\141\1\164\1\162\1\ufaff\1\157\1\145\1\ufaff\1\151"+
        "\1\156\2\162\1\145\1\ufaff\1\165\1\156\2\ufaff\1\164\1\154\1\165"+
        "\1\146\1\156\1\143\1\156\1\162\2\uffff\1\143\1\145\1\ufaff\1\144"+
        "\1\141\1\143\1\144\1\uffff\1\164\2\ufaff\1\uffff\1\144\1\ufaff\1"+
        "\uffff\1\162\1\145\1\151\1\145\1\141\1\uffff\1\164\1\144\2\uffff"+
        "\1\ufaff\1\145\1\154\1\141\1\143\1\164\1\145\2\ufaff\1\141\1\ufaff"+
        "\1\uffff\1\ufaff\1\143\1\165\1\145\1\165\2\uffff\1\ufaff\1\uffff"+
        "\1\145\1\163\1\144\1\ufaff\1\156\1\151\1\163\1\uffff\1\ufaff\1\164"+
        "\1\143\1\145\1\157\1\156\2\uffff\1\164\2\uffff\2\164\1\ufaff\1\162"+
        "\1\uffff\2\ufaff\1\145\1\uffff\1\ufaff\1\157\1\ufaff\1\uffff\1\ufaff"+
        "\1\145\1\ufaff\1\162\1\164\1\151\2\ufaff\1\uffff\1\145\2\uffff\1"+
        "\ufaff\1\uffff\1\156\2\uffff\1\ufaff\1\uffff\2\ufaff\1\157\2\uffff"+
        "\1\ufaff\1\uffff\1\ufaff\3\uffff\1\156\2\uffff\1\ufaff\1\uffff";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\5\uffff\1\15\11\uffff\1\45\4\uffff"+
        "\1\60\1\61\1\62\1\65\1\66\2\uffff\1\74\1\75\1\76\1\77\3\uffff\1"+
        "\10\25\uffff\1\35\1\73\11\uffff\1\70\1\71\2\uffff\1\100\1\101\2"+
        "\uffff\1\33\4\uffff\1\12\21\uffff\1\32\13\uffff\1\72\1\uffff\1\54"+
        "\46\uffff\1\42\1\51\7\uffff\1\14\3\uffff\1\24\2\uffff\1\27\5\uffff"+
        "\1\52\2\uffff\1\47\1\55\13\uffff\1\37\5\uffff\1\53\1\64\1\uffff"+
        "\1\44\7\uffff\1\56\6\uffff\1\17\1\20\1\uffff\1\25\1\40\4\uffff\1"+
        "\26\3\uffff\1\36\3\uffff\1\57\10\uffff\1\31\1\uffff\1\30\1\34\1"+
        "\uffff\1\50\1\uffff\1\63\1\67\1\uffff\1\23\3\uffff\1\46\1\13\1\uffff"+
        "\1\43\1\uffff\1\1\1\11\1\21\1\uffff\1\16\1\41\1\uffff\1\22";
    static final String DFA29_specialS =
        "\u0112\uffff}>";
    static final String[] DFA29_transitionS = {
            "\2\46\1\uffff\2\46\22\uffff\1\46\1\27\1\44\1\uffff\1\45\2\uffff"+
            "\1\43\1\5\1\6\1\10\1\uffff\1\7\1\uffff\1\24\1\47\1\41\11\42"+
            "\1\15\1\4\1\34\1\40\1\35\1\36\1\37\32\45\4\uffff\1\45\1\uffff"+
            "\1\12\1\25\1\11\1\33\1\26\1\32\1\45\1\17\1\1\1\45\1\14\1\31"+
            "\1\20\1\45\1\23\1\13\1\45\1\22\1\16\1\21\1\45\1\30\4\45\1\2"+
            "\1\uffff\1\3\102\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\50\4\uffff\1\51",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\54\6\uffff\1\55\6\uffff\1\53",
            "\1\63\1\uffff\1\60\1\uffff\1\61\10\uffff\1\56\1\57\1\uffff"+
            "\1\62",
            "\1\64\2\uffff\1\65",
            "\1\66",
            "",
            "\1\70\1\67\13\uffff\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76\7\uffff\1\77",
            "\12\101",
            "\1\102\11\uffff\1\103\11\uffff\1\104",
            "\1\105",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\112\11\uffff\1\111",
            "",
            "",
            "",
            "",
            "",
            "\1\101\1\uffff\10\115\2\101\12\uffff\3\101\21\uffff\1\113\13"+
            "\uffff\3\101\21\uffff\1\113",
            "\1\101\1\uffff\12\116\12\uffff\3\101\35\uffff\3\101",
            "",
            "",
            "",
            "",
            "\1\117\4\uffff\1\120",
            "\1\122\1\121",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "",
            "\1\125\1\124",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\146\1\uffff\1\145",
            "\1\147",
            "\1\151\12\uffff\1\150",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\153",
            "",
            "",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157\16\uffff\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "",
            "",
            "\1\101\1\uffff\10\115\2\101\12\uffff\3\101\35\uffff\3\101",
            "\1\101\1\uffff\12\116\12\uffff\3\101\35\uffff\3\101",
            "",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\4\45\1\167\25\45\105\uffff\27\45\1\uffff\37\45\1\uffff"+
            "\u1f08\45\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff"+
            "\u092e\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\171",
            "",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "",
            "\1\u009a",
            "",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\4\45\1\u009e\25\45\105\uffff\27\45\1\uffff\37\45\1"+
            "\uffff\u1f08\45\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080"+
            "\uffff\u092e\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00ad",
            "\1\u00ae",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00b6",
            "\1\u00b7",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c2\14\uffff\1\u00c1",
            "",
            "",
            "\1\u00c3",
            "\1\u00c4",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "",
            "\1\u00ca",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "",
            "\1\u00cd",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "",
            "\1\u00d4",
            "\1\u00d5",
            "",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00df",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "",
            "",
            "\1\u00f4",
            "",
            "",
            "\1\u00f5",
            "\1\u00f6",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00f8",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00fb",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u00fd",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u0100",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "",
            "\1\u0107",
            "",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "",
            "\1\u0109",
            "",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "\1\u010d",
            "",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            "",
            "",
            "",
            "\1\u0110",
            "",
            "",
            "\1\45\5\uffff\1\45\5\uffff\12\45\7\uffff\32\45\4\uffff\1\45"+
            "\1\uffff\32\45\105\uffff\27\45\1\uffff\37\45\1\uffff\u1f08\45"+
            "\u1040\uffff\u0150\45\u0170\uffff\u0080\45\u0080\uffff\u092e"+
            "\45\u10d2\uffff\u5200\45\u5900\uffff\u0200\45",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | CharacterLiteral | StringLiteral | Identifier | WS | COMMENT | LINE_COMMENT );";
        }
    }
 

}
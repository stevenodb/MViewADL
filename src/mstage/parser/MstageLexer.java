// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g 2010-01-27 14:04:01

package mstage.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MstageLexer extends Lexer {
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

    public MstageLexer() {;} 
    public MstageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MstageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g"; }

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:7:7: ( 'interface' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:7:9: 'interface'
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:8:7: ( ';' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:8:9: ';'
            {
            match(';'); 

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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:9:7: ( '(' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:9:9: '('
            {
            match('('); 

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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:10:7: ( ')' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:10:9: ')'
            {
            match(')'); 

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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:11:7: ( ',' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:11:9: ','
            {
            match(','); 

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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:12:7: ( 'component' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:12:9: 'component'
            {
            match("component"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:13:7: ( '{' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:13:9: '{'
            {
            match('{'); 

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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:14:7: ( '}' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:14:9: '}'
            {
            match('}'); 

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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:15:7: ( 'require' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:15:9: 'require'
            {
            match("require"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:16:7: ( 'provide' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:16:9: 'provide'
            {
            match("provide"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:17:7: ( 'void' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:17:9: 'void'
            {
            match("void"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:18:7: ( '.' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:18:9: '.'
            {
            match('.'); 

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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:19:7: ( 'boolean' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:19:9: 'boolean'
            {
            match("boolean"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:20:7: ( 'char' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:20:9: 'char'
            {
            match("char"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:21:7: ( 'byte' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:21:9: 'byte'
            {
            match("byte"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:22:7: ( 'short' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:22:9: 'short'
            {
            match("short"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:23:7: ( 'int' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:23:9: 'int'
            {
            match("int"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:24:7: ( 'long' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:24:9: 'long'
            {
            match("long"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:25:7: ( 'float' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:25:9: 'float'
            {
            match("float"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:26:7: ( 'double' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:26:9: 'double'
            {
            match("double"); 


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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:27:7: ( '@' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:27:9: '@'
            {
            match('@'); 

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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:28:7: ( '=' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:28:9: '='
            {
            match('='); 

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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:29:7: ( 'default' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:29:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "HexLiteral"
    public final void mHexLiteral() throws RecognitionException {
        try {
            int _type = HexLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:333:12: ( '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:333:14: '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )?
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:333:28: ( HexDigit )+
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
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:333:28: HexDigit
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

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:333:38: ( IntegerTypeSuffix )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='L'||LA2_0=='l') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:333:38: IntegerTypeSuffix
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:16: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:18: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )?
            {
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:18: ( '0' | '1' .. '9' ( '0' .. '9' )* )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:19: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:25: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:34: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:34: '0' .. '9'
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

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:45: ( IntegerTypeSuffix )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='L'||LA5_0=='l') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:335:45: IntegerTypeSuffix
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:337:14: ( '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )? )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:337:16: '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )?
            {
            match('0'); 
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:337:20: ( '0' .. '7' )+
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
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:337:21: '0' .. '7'
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

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:337:32: ( IntegerTypeSuffix )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='L'||LA7_0=='l') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:337:32: IntegerTypeSuffix
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:340:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:340:12: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:343:19: ( ( 'l' | 'L' ) )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:343:21: ( 'l' | 'L' )
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ FloatTypeSuffix )
            int alt18=4;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )?
                    {
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:9: ( '0' .. '9' )+
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
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:10: '0' .. '9'
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:25: ( '0' .. '9' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:37: ( Exponent )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:37: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:47: ( FloatTypeSuffix )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='D'||LA11_0=='F'||LA11_0=='d'||LA11_0=='f') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:346:47: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:347:9: '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )?
                    {
                    match('.'); 
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:347:13: ( '0' .. '9' )+
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
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:347:14: '0' .. '9'
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

                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:347:25: ( Exponent )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='E'||LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:347:25: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:347:35: ( FloatTypeSuffix )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='D'||LA14_0=='F'||LA14_0=='d'||LA14_0=='f') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:347:35: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:348:9: ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )?
                    {
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:348:9: ( '0' .. '9' )+
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
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:348:10: '0' .. '9'
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:348:30: ( FloatTypeSuffix )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='D'||LA16_0=='F'||LA16_0=='d'||LA16_0=='f') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:348:30: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:349:9: ( '0' .. '9' )+ FloatTypeSuffix
                    {
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:349:9: ( '0' .. '9' )+
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
                    	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:349:10: '0' .. '9'
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:353:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:353:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:353:22: ( '+' | '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='+'||LA19_0=='-') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:
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

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:353:33: ( '0' .. '9' )+
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
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:353:34: '0' .. '9'
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:356:17: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:356:19: ( 'f' | 'F' | 'd' | 'D' )
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:359:5: ( '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:359:9: '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:359:14: ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:359:16: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:359:33: ~ ( '\\'' | '\\\\' )
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:363:5: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:363:8: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:363:12: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
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
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:363:14: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:363:31: ~ ( '\\\\' | '\"' )
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:368:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEscape | OctalEscape )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:368:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:369:9: UnicodeEscape
                    {
                    mUnicodeEscape(); 

                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:370:9: OctalEscape
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
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
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:14: ( '0' .. '3' )
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:25: ( '0' .. '7' )
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:36: ( '0' .. '7' )
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:375:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:376:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:376:14: ( '0' .. '7' )
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:376:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:376:25: ( '0' .. '7' )
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:376:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:377:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:377:14: ( '0' .. '7' )
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:377:15: '0' .. '7'
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:382:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:382:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:386:5: ( Letter ( Letter | JavaIDDigit )* )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:386:9: Letter ( Letter | JavaIDDigit )*
            {
            mLetter(); 
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:386:16: ( Letter | JavaIDDigit )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0=='$'||(LA25_0>='0' && LA25_0<='9')||(LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='z')||(LA25_0>='\u00C0' && LA25_0<='\u00D6')||(LA25_0>='\u00D8' && LA25_0<='\u00F6')||(LA25_0>='\u00F8' && LA25_0<='\u1FFF')||(LA25_0>='\u3040' && LA25_0<='\u318F')||(LA25_0>='\u3300' && LA25_0<='\u337F')||(LA25_0>='\u3400' && LA25_0<='\u3D2D')||(LA25_0>='\u4E00' && LA25_0<='\u9FFF')||(LA25_0>='\uF900' && LA25_0<='\uFAFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:394:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:411:5: ( '\\u0030' .. '\\u0039' | '\\u0660' .. '\\u0669' | '\\u06f0' .. '\\u06f9' | '\\u0966' .. '\\u096f' | '\\u09e6' .. '\\u09ef' | '\\u0a66' .. '\\u0a6f' | '\\u0ae6' .. '\\u0aef' | '\\u0b66' .. '\\u0b6f' | '\\u0be7' .. '\\u0bef' | '\\u0c66' .. '\\u0c6f' | '\\u0ce6' .. '\\u0cef' | '\\u0d66' .. '\\u0d6f' | '\\u0e50' .. '\\u0e59' | '\\u0ed0' .. '\\u0ed9' | '\\u1040' .. '\\u1049' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:428:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:428:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:432:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:432:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:432:14: ( options {greedy=false; } : . )*
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
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:432:42: .
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
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:436:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:436:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:436:12: (~ ( '\\n' | '\\r' ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='\u0000' && LA27_0<='\t')||(LA27_0>='\u000B' && LA27_0<='\f')||(LA27_0>='\u000E' && LA27_0<='\uFFFF')) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:436:12: ~ ( '\\n' | '\\r' )
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

            // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:436:26: ( '\\r' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0=='\r') ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:436:26: '\\r'
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
        // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:8: ( T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | CharacterLiteral | StringLiteral | Identifier | WS | COMMENT | LINE_COMMENT )
        int alt29=33;
        alt29 = dfa29.predict(input);
        switch (alt29) {
            case 1 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:10: T__23
                {
                mT__23(); 

                }
                break;
            case 2 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:16: T__24
                {
                mT__24(); 

                }
                break;
            case 3 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:22: T__25
                {
                mT__25(); 

                }
                break;
            case 4 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:28: T__26
                {
                mT__26(); 

                }
                break;
            case 5 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:34: T__27
                {
                mT__27(); 

                }
                break;
            case 6 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:40: T__28
                {
                mT__28(); 

                }
                break;
            case 7 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:46: T__29
                {
                mT__29(); 

                }
                break;
            case 8 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:52: T__30
                {
                mT__30(); 

                }
                break;
            case 9 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:58: T__31
                {
                mT__31(); 

                }
                break;
            case 10 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:64: T__32
                {
                mT__32(); 

                }
                break;
            case 11 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:70: T__33
                {
                mT__33(); 

                }
                break;
            case 12 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:76: T__34
                {
                mT__34(); 

                }
                break;
            case 13 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:82: T__35
                {
                mT__35(); 

                }
                break;
            case 14 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:88: T__36
                {
                mT__36(); 

                }
                break;
            case 15 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:94: T__37
                {
                mT__37(); 

                }
                break;
            case 16 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:100: T__38
                {
                mT__38(); 

                }
                break;
            case 17 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:106: T__39
                {
                mT__39(); 

                }
                break;
            case 18 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:112: T__40
                {
                mT__40(); 

                }
                break;
            case 19 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:118: T__41
                {
                mT__41(); 

                }
                break;
            case 20 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:124: T__42
                {
                mT__42(); 

                }
                break;
            case 21 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:130: T__43
                {
                mT__43(); 

                }
                break;
            case 22 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:136: T__44
                {
                mT__44(); 

                }
                break;
            case 23 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:142: T__45
                {
                mT__45(); 

                }
                break;
            case 24 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:148: HexLiteral
                {
                mHexLiteral(); 

                }
                break;
            case 25 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:159: DecimalLiteral
                {
                mDecimalLiteral(); 

                }
                break;
            case 26 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:174: OctalLiteral
                {
                mOctalLiteral(); 

                }
                break;
            case 27 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:187: FloatingPointLiteral
                {
                mFloatingPointLiteral(); 

                }
                break;
            case 28 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:208: CharacterLiteral
                {
                mCharacterLiteral(); 

                }
                break;
            case 29 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:225: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 30 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:239: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 31 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:250: WS
                {
                mWS(); 

                }
                break;
            case 32 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:253: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 33 :
                // /Users/steveno/Documents/repos/mstage-lang/src/mstage/parser/Mstage.g:1:261: LINE_COMMENT
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
        "\2\uffff\1\2\1\4\1\1\1\3";
    static final String DFA18_specialS =
        "\6\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\4\1\uffff\12\1\12\uffff\1\3\1\5\1\3\35\uffff\1\3\1\5\1\3",
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
            return "345:1: FloatingPointLiteral : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ FloatTypeSuffix );";
        }
    }
    static final String DFA29_eotS =
        "\1\uffff\1\30\4\uffff\1\30\2\uffff\3\30\1\41\5\30\2\uffff\2\54\5"+
        "\uffff\6\30\2\uffff\7\30\1\uffff\1\75\1\uffff\1\54\2\uffff\1\77"+
        "\14\30\1\uffff\1\30\1\uffff\1\30\1\116\2\30\1\121\1\30\1\123\1\30"+
        "\1\125\5\30\1\uffff\2\30\1\uffff\1\30\1\uffff\1\136\1\uffff\1\137"+
        "\7\30\2\uffff\1\147\3\30\1\153\1\154\1\155\1\uffff\1\156\2\30\4"+
        "\uffff\1\161\1\162\2\uffff";
    static final String DFA29_eofS =
        "\163\uffff";
    static final String DFA29_minS =
        "\1\11\1\156\4\uffff\1\150\2\uffff\1\145\1\162\1\157\1\60\1\157\1"+
        "\150\1\157\1\154\1\145\2\uffff\2\56\4\uffff\1\52\1\164\1\155\1\141"+
        "\1\161\1\157\1\151\2\uffff\1\157\1\164\1\157\1\156\1\157\1\165\1"+
        "\146\1\uffff\1\56\1\uffff\1\56\2\uffff\1\44\1\160\1\162\1\165\1"+
        "\166\1\144\1\154\1\145\1\162\1\147\1\141\1\142\1\141\1\uffff\1\162"+
        "\1\uffff\1\157\1\44\2\151\1\44\1\145\1\44\1\164\1\44\1\164\1\154"+
        "\1\165\1\146\1\156\1\uffff\1\162\1\144\1\uffff\1\141\1\uffff\1\44"+
        "\1\uffff\1\44\1\145\1\154\1\141\3\145\1\156\2\uffff\1\44\1\164\1"+
        "\143\1\156\3\44\1\uffff\1\44\1\145\1\164\4\uffff\2\44\2\uffff";
    static final String DFA29_maxS =
        "\1\ufaff\1\156\4\uffff\1\157\2\uffff\1\145\1\162\1\157\1\71\1\171"+
        "\1\150\1\157\1\154\1\157\2\uffff\1\170\1\146\4\uffff\1\57\1\164"+
        "\1\155\1\141\1\161\1\157\1\151\2\uffff\1\157\1\164\1\157\1\156\1"+
        "\157\1\165\1\146\1\uffff\1\146\1\uffff\1\146\2\uffff\1\ufaff\1\160"+
        "\1\162\1\165\1\166\1\144\1\154\1\145\1\162\1\147\1\141\1\142\1\141"+
        "\1\uffff\1\162\1\uffff\1\157\1\ufaff\2\151\1\ufaff\1\145\1\ufaff"+
        "\1\164\1\ufaff\1\164\1\154\1\165\1\146\1\156\1\uffff\1\162\1\144"+
        "\1\uffff\1\141\1\uffff\1\ufaff\1\uffff\1\ufaff\1\145\1\154\1\141"+
        "\3\145\1\156\2\uffff\1\ufaff\1\164\1\143\1\156\3\ufaff\1\uffff\1"+
        "\ufaff\1\145\1\164\4\uffff\2\ufaff\2\uffff";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\11\uffff\1\25\1\26\2\uffff"+
        "\1\34\1\35\1\36\1\37\7\uffff\1\14\1\33\7\uffff\1\30\1\uffff\1\31"+
        "\1\uffff\1\40\1\41\15\uffff\1\32\1\uffff\1\21\16\uffff\1\16\2\uffff"+
        "\1\13\1\uffff\1\17\1\uffff\1\22\10\uffff\1\20\1\23\7\uffff\1\24"+
        "\3\uffff\1\11\1\12\1\15\1\27\2\uffff\1\1\1\6";
    static final String DFA29_specialS =
        "\163\uffff}>";
    static final String[] DFA29_transitionS = {
            "\2\31\1\uffff\2\31\22\uffff\1\31\1\uffff\1\27\1\uffff\1\30\2"+
            "\uffff\1\26\1\3\1\4\2\uffff\1\5\1\uffff\1\14\1\32\1\24\11\25"+
            "\1\uffff\1\2\1\uffff\1\23\2\uffff\1\22\32\30\4\uffff\1\30\1"+
            "\uffff\1\30\1\15\1\6\1\21\1\30\1\20\2\30\1\1\2\30\1\17\3\30"+
            "\1\12\1\30\1\11\1\16\2\30\1\13\4\30\1\7\1\uffff\1\10\102\uffff"+
            "\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff\u0150\30\u0170"+
            "\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff\u5200\30\u5900"+
            "\uffff\u0200\30",
            "\1\33",
            "",
            "",
            "",
            "",
            "\1\35\6\uffff\1\34",
            "",
            "",
            "\1\36",
            "\1\37",
            "\1\40",
            "\12\42",
            "\1\43\11\uffff\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\51\11\uffff\1\50",
            "",
            "",
            "\1\42\1\uffff\10\53\2\42\12\uffff\3\42\21\uffff\1\52\13\uffff"+
            "\3\42\21\uffff\1\52",
            "\1\42\1\uffff\12\55\12\uffff\3\42\35\uffff\3\42",
            "",
            "",
            "",
            "",
            "\1\56\4\uffff\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "",
            "",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "\1\42\1\uffff\10\53\2\42\12\uffff\3\42\35\uffff\3\42",
            "",
            "\1\42\1\uffff\12\55\12\uffff\3\42\35\uffff\3\42",
            "",
            "",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\4\30"+
            "\1\76\25\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040"+
            "\uffff\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2"+
            "\uffff\u5200\30\u5900\uffff\u0200\30",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "",
            "\1\114",
            "",
            "\1\115",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "\1\117",
            "\1\120",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "\1\122",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "\1\124",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "",
            "\1\133",
            "\1\134",
            "",
            "\1\135",
            "",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "",
            "",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "\1\157",
            "\1\160",
            "",
            "",
            "",
            "",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "\1\30\13\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32"+
            "\30\105\uffff\27\30\1\uffff\37\30\1\uffff\u1f08\30\u1040\uffff"+
            "\u0150\30\u0170\uffff\u0080\30\u0080\uffff\u092e\30\u10d2\uffff"+
            "\u5200\30\u5900\uffff\u0200\30",
            "",
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
            return "1:1: Tokens : ( T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | CharacterLiteral | StringLiteral | Identifier | WS | COMMENT | LINE_COMMENT );";
        }
    }
 

}
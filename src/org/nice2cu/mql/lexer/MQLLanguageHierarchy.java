
package org.nice2cu.mql.lexer;

import java.util.*;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author Nicolas
 */
public class MQLLanguageHierarchy extends LanguageHierarchy<MQLTokenId>{
    
    private static List<MQLTokenId> tokens;
    private static Map<Integer, MQLTokenId> idToToken;
    
    private static void init() {
        tokens = Arrays.<MQLTokenId>asList(new MQLTokenId[]{
            new MQLTokenId("EOF", "whitespace", 0),
            new MQLTokenId("WHITESPACE", "whitespace", 1),
            new MQLTokenId("SINGLE_LINE_COMMENT", "comment", 4),
            new MQLTokenId("FORMAL_COMMENT", "comment", 5),
            new MQLTokenId("MULTI_LINE_COMMENT", "comment", 6),
            new MQLTokenId("AND", "keyword", 8),
            new MQLTokenId("BEGIN", "keyword", 9),
            new MQLTokenId("BOOL", "keyword", 10),
            new MQLTokenId("CASE", "keyword", 11),
            new MQLTokenId("DEF", "keyword", 12),
            new MQLTokenId("_DEFAULT", "keyword", 13),
            new MQLTokenId("DEFINE", "keyword", 14),
            new MQLTokenId("ELSE", "keyword", 15),
            new MQLTokenId("END", "keyword", 16),
            new MQLTokenId("EXTERN", "keyword", 17),
            new MQLTokenId("FN", "keyword", 18),
            new MQLTokenId("IF", "keyword", 19),
            new MQLTokenId("IFF", "keyword", 20),
            new MQLTokenId("IN", "keyword", 21),
            new MQLTokenId("INCLUDE", "keyword", 22),
            new MQLTokenId("IS", "keyword", 23),
            new MQLTokenId("LAZY", "keyword", 24),
            new MQLTokenId("LET", "keyword", 25),
            new MQLTokenId("MODULE", "keyword", 26),
            new MQLTokenId("NOT", "keyword", 27),
            new MQLTokenId("OBJECT", "keyword", 28),
            new MQLTokenId("OF", "keyword", 29),
            new MQLTokenId("OR", "keyword", 30),
            new MQLTokenId("PRIVATE", "keyword", 31),
            new MQLTokenId("PUBLIC", "keyword", 32),
            new MQLTokenId("REC", "keyword", 33),
            new MQLTokenId("SIGNATURE", "keyword", 34),
            new MQLTokenId("SIGNED", "keyword", 35),
            new MQLTokenId("STRING", "keyword", 36),           
            new MQLTokenId("SWITCH", "keyword", 37),
            new MQLTokenId("THEN", "keyword", 38),
            new MQLTokenId("TYPEDEF", "keyword", 39),
            new MQLTokenId("_TYPEINFO_", "keyword", 40),
            new MQLTokenId("UNSIGNED", "keyword", 41),
            new MQLTokenId("_XOR", "keyword", 42),
            new MQLTokenId("INTEGER_LITERAL", "literal", 43),
            new MQLTokenId("DECIMAL_LITERAL", "literal", 44),
            new MQLTokenId("HEX_LITERAL", "literal", 45),
            new MQLTokenId("OCTAL_LITERAL", "literal", 46),
            new MQLTokenId("FLOATING_POINT_LITERAL", "literal", 47),
            new MQLTokenId("DECIMAL_FLOATING_POINT_LITERAL", "literal", 48),
            new MQLTokenId("DECIMAL_EXPONENT", "number", 49),
            new MQLTokenId("HEXADECIMAL_FLOATING_POINT_LITERAL", "literal", 50),
            new MQLTokenId("HEXADECIMAL_EXPONENT", "number", 51),
            new MQLTokenId("CHARACTER_LITERAL", "literal", 52),
            new MQLTokenId("STRING_LITERAL", "literal", 53),
            new MQLTokenId("IDENTIFIER", "literal", 54),
            new MQLTokenId("LETTER", "literal", 55),
            new MQLTokenId("PART_LETTER", "literal", 56),
            new MQLTokenId("LPAREN", "operator", 57),
            new MQLTokenId("RPAREN", "operator", 58),
            new MQLTokenId("LBRACE", "operator", 59),
            new MQLTokenId("RBRACE", "operator", 60),
            new MQLTokenId("LBRACKET", "operator", 61),
            new MQLTokenId("RBRACKET", "operator", 62),
            new MQLTokenId("SEMICOLON", "operator", 63),
            new MQLTokenId("COMMA", "operator", 64),
            new MQLTokenId("DOT", "operator", 65),
            new MQLTokenId("AT", "operator", 66),
            new MQLTokenId("ASSIGN", "operator", 67),
            new MQLTokenId("LT", "operator", 68),
            new MQLTokenId("BANG", "operator", 69),
            new MQLTokenId("TILDE", "operator", 70),
            new MQLTokenId("HOOK", "operator", 71),
            new MQLTokenId("COLON", "operator", 72),
            new MQLTokenId("EQ", "operator", 73),
            new MQLTokenId("LE", "operator", 74),
            new MQLTokenId("GE", "operator", 75),
            new MQLTokenId("NE", "operator", 76),
            new MQLTokenId("SC_OR", "operator", 77),
            new MQLTokenId("SC_AND", "operator", 78),
            new MQLTokenId("INCR", "operator", 79),
            new MQLTokenId("DECR", "operator", 80),
            new MQLTokenId("PLUS", "operator", 81),
            new MQLTokenId("MINUS", "operator", 82),
            new MQLTokenId("STAR", "operator", 83),
            new MQLTokenId("SLASH", "operator", 84),
            new MQLTokenId("BIT_AND", "operator", 85),
            new MQLTokenId("BIT_OR", "operator", 86),
            new MQLTokenId("XOR", "operator", 87),
            new MQLTokenId("REM", "operator", 88),
            new MQLTokenId("LSHIFT", "operator", 89),
            new MQLTokenId("PLUSASSIGN", "operator", 90),
            new MQLTokenId("MINUSASSIGN", "operator", 91),
            new MQLTokenId("STARASSIGN", "operator", 92),
            new MQLTokenId("SLASHASSIGN", "operator", 93),
            new MQLTokenId("ANDASSIGN", "operator", 94),
            new MQLTokenId("ORASSIGN", "operator", 95),
            new MQLTokenId("XORASSIGN", "operator", 96),
            new MQLTokenId("REMASSIGN", "operator", 97),
            new MQLTokenId("LSHIFTASSIGN", "operator", 98),
            new MQLTokenId("RSIGNEDSHIFTASSIGN", "operator", 99),
            new MQLTokenId("RUNSIGNEDSHIFTASSIGN", "operator", 100),
            new MQLTokenId("ELLIPSIS", "operator", 101)
                
                //[PENDING]
        });
        idToToken = new HashMap<Integer, MQLTokenId>();
        for (MQLTokenId token : tokens) {
            idToToken.put(token.ordinal(), token);
        }
    }
    
    static synchronized MQLTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }
    
    @Override
    protected synchronized Collection<MQLTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }
    
    @Override
    protected synchronized Lexer<MQLTokenId> createLexer(LexerRestartInfo<MQLTokenId> info) {
        return new MQLLexer(info);
    }
    
    @Override
    protected String mimeType() {
        return "text/x-mql";
    }
    
}

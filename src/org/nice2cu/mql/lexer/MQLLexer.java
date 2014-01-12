/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nice2cu.mql.lexer;

import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.nice2cu.mql.jcclexer.JavaCharStream;
import org.nice2cu.mql.jcclexer.JavaParserTokenManager;
import org.nice2cu.mql.jcclexer.Token;

/**
 *
 * @author Nicolas
 */
public class MQLLexer implements Lexer<MQLTokenId> {
    
    private LexerRestartInfo<MQLTokenId> info;
    private JavaParserTokenManager javaParserTokenManager;

    MQLLexer(LexerRestartInfo<MQLTokenId> info) {
        this.info = info;
        JavaCharStream stream = new JavaCharStream(info.input());
        javaParserTokenManager = new JavaParserTokenManager(stream);
    }

    @Override
    public org.netbeans.api.lexer.Token<MQLTokenId> nextToken() {
        Token token = javaParserTokenManager.getNextToken();
        if (info.input().readLength() < 1) {
            return null;
        }
        return info.tokenFactory().createToken(MQLLanguageHierarchy.getToken(token.kind));
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }
    
}

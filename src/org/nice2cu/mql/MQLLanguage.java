/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nice2cu.mql;

import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.nice2cu.mql.lexer.MQLTokenId;

@LanguageRegistration(mimeType = "text/x-mql")
public class MQLLanguage extends DefaultLanguageConfig {

    @Override
    public Language getLexerLanguage() {
        return MQLTokenId.getLanguage();
    }

    @Override
    public String getDisplayName() {
        return "MQL";
    }

}

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.nice2cu.mql.lexer;

import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;

/**
 *
 * @author Nicolas
 */
public class MQLTokenId implements TokenId{
    
    private final String name;
    private final String primaryCategory;
    private final int id;
    
    MQLTokenId(
            String name,
            String primaryCategory,
            int id) {
        this.name = name;
        this.primaryCategory = primaryCategory;
        this.id = id;
    }
    
    @Override
    public String primaryCategory() {
        return primaryCategory;
    }
    
    @Override
    public int ordinal() {
        return id;
    }
    
    @Override
    public String name() {
        return name;
    }
    
    public static Language<MQLTokenId> getLanguage() {
        return new MQLLanguageHierarchy().language();
    }
    
}

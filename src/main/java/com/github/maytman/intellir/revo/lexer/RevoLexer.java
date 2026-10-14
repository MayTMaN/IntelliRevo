package com.github.maytman.intellir.revo.lexer;

import com.intellij.lexer.DummyLexer;
import com.intellij.psi.tree.IElementType;

public class RevoLexer extends DummyLexer {
    public RevoLexer() {
        super(RevoTypes.TEXT);
    }
}

package com.github.maytman.intellir.revo.lexer;

import com.github.maytman.intellir.revo.RevoLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class RevoTokenType extends IElementType {

    public RevoTokenType(@NotNull String debugName) {
        super(debugName, RevoLanguage.INSTANCE);
    }
}

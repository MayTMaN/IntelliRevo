package com.github.maytman.intellir.revo.lexer;

import com.github.maytman.intellir.revo.RevoLanguage;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;

public class RevoTypes {

    public static final IElementType TEXT = new RevoTokenType("TEXT");
    public static final IFileElementType FILE = new IFileElementType(RevoLanguage.INSTANCE);

}

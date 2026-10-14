package com.github.maytman.intellir.revo.psi;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class RevoParser implements PsiParser {
    @Override
    public @NotNull ASTNode parse(@NotNull IElementType iElementType, @NotNull PsiBuilder psiBuilder) {
        PsiBuilder.Marker marker = psiBuilder.mark();
        while (!psiBuilder.eof()) {
            psiBuilder.advanceLexer();
        }
        marker.done(iElementType);
        return psiBuilder.getTreeBuilt();
    }
}

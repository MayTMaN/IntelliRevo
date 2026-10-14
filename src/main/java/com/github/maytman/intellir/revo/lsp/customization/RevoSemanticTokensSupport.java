package com.github.maytman.intellir.revo.lsp.customization;

import com.github.maytman.intellir.revo.RevoFileType;
import com.intellij.platform.lsp.api.customization.LspSemanticTokensCustomizer;
import com.intellij.platform.lsp.api.customization.LspSemanticTokensSupport;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class RevoSemanticTokensSupport extends LspSemanticTokensSupport {

    @Override
    public boolean shouldAskServerForSemanticTokens(@NotNull PsiFile psiFile) {
        return psiFile.getFileType() == RevoFileType.INSTANCE;
    }

}

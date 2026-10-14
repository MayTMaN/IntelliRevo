package com.github.maytman.intellir.revo.lsp.customization;

import com.intellij.platform.lsp.api.customization.LspCustomization;
import com.intellij.platform.lsp.api.customization.LspSemanticTokensCustomizer;
import org.jetbrains.annotations.NotNull;

public class RevoLspCustomization extends LspCustomization {

    @Override
    public @NotNull LspSemanticTokensCustomizer getSemanticTokensCustomizer() {
        return new RevoSemanticTokensSupport();
    }

}

package com.github.maytman.intellir.revo.psi;

import com.github.maytman.intellir.revo.RevoFileType;
import com.github.maytman.intellir.revo.RevoLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class RevoPsiFile extends PsiFileBase {


    public RevoPsiFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, RevoLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return RevoFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Revo File";
    }
}

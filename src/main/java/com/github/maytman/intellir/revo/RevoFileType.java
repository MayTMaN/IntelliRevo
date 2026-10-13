package com.github.maytman.intellir.revo;

import com.github.maytman.intellir.revo.icons.RevoIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RevoFileType extends LanguageFileType {
    public static final RevoFileType INSTANCE = new RevoFileType();

    private RevoFileType() {
        super(RevoLanguage.INSTANCE);
    }


    @Override
    public @NonNls @NotNull String getName() {
        return "Revo";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "révo source file";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "rv";
    }

    @Override
    public @Nullable Icon getIcon() {
        return RevoIcons.FILE;
    }
}

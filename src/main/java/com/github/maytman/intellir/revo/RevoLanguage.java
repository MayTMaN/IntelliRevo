package com.github.maytman.intellir.revo;

import com.intellij.lang.Language;

public class RevoLanguage extends Language {
    public static final RevoLanguage INSTANCE = new RevoLanguage();

    private RevoLanguage() {
        super("Revo");
    }
}

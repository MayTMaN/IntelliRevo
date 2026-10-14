package com.github.maytman.intellir.revo.psi;

import com.github.maytman.intellir.revo.lexer.RevoLexer;
import com.github.maytman.intellir.revo.lexer.RevoTypes;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class RevoParserDefinition implements ParserDefinition {

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new RevoLexer();
    }

    @Override
    public @NotNull PsiParser createParser(Project project) {
        return new RevoParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return RevoTypes.FILE;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode astNode) {
        return new ASTWrapperPsiElement(astNode);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider fileViewProvider) {
        return new RevoPsiFile(fileViewProvider);
    }
}

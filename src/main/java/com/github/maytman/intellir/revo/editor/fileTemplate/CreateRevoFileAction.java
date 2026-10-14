package com.github.maytman.intellir.revo.editor.fileTemplate;

import com.github.maytman.intellir.revo.icons.RevoIcons;
import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.psi.PsiDirectory;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CreateRevoFileAction extends CreateFileFromTemplateAction {

    public CreateRevoFileAction() {
        super("Revo File", "Create Revo File", RevoIcons.FILE);
    }

    @Override
    protected void buildDialog(@NotNull Project project, @NotNull PsiDirectory psiDirectory, CreateFileFromTemplateDialog.@NotNull Builder builder) {
        builder.setTitle("New Revo File");
        builder.addKind("Revo File", RevoIcons.FILE, "RevoTemplate");
    }

    @Override
    protected @NlsContexts.Command String getActionName(PsiDirectory psiDirectory, @NonNls @NotNull String s, @NonNls String s1) {
        return "Create Revo File";
    }
}

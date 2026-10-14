package com.github.maytman.intellir.revo.lsp;

import com.github.maytman.intellir.revo.RevoFileType;
import com.github.maytman.intellir.revo.editor.settings.RevoSettings;
import com.github.maytman.intellir.revo.editor.settings.RevoSettingsConfigurable;
import com.github.maytman.intellir.revo.lsp.customization.RevoLspCustomization;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.platform.lsp.api.LspServerSupportProvider;
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor;
import com.intellij.platform.lsp.api.customization.LspCustomization;
import org.jetbrains.annotations.NotNull;

public class RevoLspIntegration implements LspServerSupportProvider {


    @Override
    public void fileOpened(
            @NotNull Project project,
            @NotNull VirtualFile virtualFile,
            @NotNull LspServerSupportProvider.LspServerStarter lspServerStarter) {
        if(virtualFile.getFileType() == RevoFileType.INSTANCE) {
            lspServerStarter.ensureServerStarted(new RevoLspClientDescriptor(project));
        }

    }

    public static class RevoLspClientDescriptor extends ProjectWideLspServerDescriptor {
        public RevoLspClientDescriptor(@NotNull Project project) {
            super(project, "Revo");
        }

        @Override
        public boolean isSupportedFile(@NotNull VirtualFile virtualFile) {
            return virtualFile.getFileType() == RevoFileType.INSTANCE;
        }

        @Override
        public @NotNull GeneralCommandLine createCommandLine() throws ExecutionException {
            if(RevoSettings.getInstance().getRevoPath().trim().isBlank()) {
                return new GeneralCommandLine("revo", "lsp");
            } else {
                return new GeneralCommandLine(RevoSettings.getInstance().getRevoPath(), "lsp");
            }

        }

        @Override
        public @NotNull LspCustomization getLspCustomization() {
            return new RevoLspCustomization();
        }
    }



}

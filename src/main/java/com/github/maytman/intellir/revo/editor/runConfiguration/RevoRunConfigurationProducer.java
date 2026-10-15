package com.github.maytman.intellir.revo.editor.runConfiguration;

import com.github.maytman.intellir.revo.RevoFileType;
import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.actions.LazyRunConfigurationProducer;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class RevoRunConfigurationProducer extends LazyRunConfigurationProducer<RevoRunConfiguration> {

    @Override
    public @NotNull ConfigurationFactory getConfigurationFactory() {
        return RevoRunConfigurationType.getInstance().getConfigurationFactories()[0];
    }

    @Override
    protected boolean setupConfigurationFromContext(@NotNull RevoRunConfiguration revoRunConfiguration, @NotNull ConfigurationContext configurationContext, @NotNull Ref<PsiElement> ref) {
        VirtualFile file = findRevoFile(configurationContext);
        if (file == null) {
            return false;
        }
        revoRunConfiguration.setScriptPath(file.getPath());
        revoRunConfiguration.setName(file.getName());

        return true;
    }

    @Override
    public boolean isConfigurationFromContext(@NotNull RevoRunConfiguration revoRunConfiguration, @NotNull ConfigurationContext configurationContext) {
        VirtualFile file = findRevoFile(configurationContext);
        if (file == null) {
            return false;
        }
        return FileUtil.pathsEqual(file.getPath(), revoRunConfiguration.getScriptPath());
    }

    private VirtualFile findRevoFile(ConfigurationContext configurationContext) {

        PsiElement element = configurationContext.getPsiLocation();

        if(element == null) {
            return null;
        }

        PsiFile psiFile = element.getContainingFile();
        if (psiFile == null) {
            return null;
        }

        VirtualFile file = psiFile.getVirtualFile();
        if (file == null || file.getFileType() != RevoFileType.INSTANCE) {
            return null;
        }

        return file;
    }

}

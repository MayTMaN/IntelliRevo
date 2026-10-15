package com.github.maytman.intellir.revo.editor.runConfiguration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.components.BaseState;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RevoConfigurationFactory extends ConfigurationFactory {

    protected RevoConfigurationFactory(ConfigurationType type) {
        super(type);
    }

    @Override
    public @NotNull String getId() {
        return RevoRunConfigurationType.ID;
    }

    @Override
    public @NotNull RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new RevoRunConfiguration(project, this, "Revo");
    }

    @Nullable
    @Override
    public Class<? extends BaseState> getOptionsClass() {
        return RevoRunConfigurationOptions.class;
    }

}

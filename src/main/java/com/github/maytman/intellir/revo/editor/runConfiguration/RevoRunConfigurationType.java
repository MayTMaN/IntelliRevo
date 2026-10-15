package com.github.maytman.intellir.revo.editor.runConfiguration;

import com.github.maytman.intellir.revo.icons.RevoIcons;
import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.execution.configurations.ConfigurationTypeUtil;

public class RevoRunConfigurationType extends ConfigurationTypeBase {

    static final String ID = "RevoRunConfigurationType";

    protected RevoRunConfigurationType() {
        super(ID, "Revo", "Revo run configuration type", RevoIcons.FILE);
        addFactory(new RevoConfigurationFactory(this));
    }

    public static RevoRunConfigurationType getInstance() {
        return ConfigurationTypeUtil.findConfigurationType(RevoRunConfigurationType.class);
    }
}

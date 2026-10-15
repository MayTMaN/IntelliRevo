package com.github.maytman.intellir.revo.editor.runConfiguration;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

public class RevoRunConfigurationOptions extends RunConfigurationOptions {

    private final StoredProperty<String> myScriptPath =
            string("").provideDelegate(this, "scriptPath");

    public String getScriptPath() {
        return myScriptPath.getValue(this);
    }

    public void setScriptPath(String scriptPath) {
        myScriptPath.setValue(this, scriptPath);
    }

}

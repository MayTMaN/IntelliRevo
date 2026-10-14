package com.github.maytman.intellir.revo.editor.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Objects;

public class RevoSettingsConfigurable implements Configurable {

    private RevoSettingsComponent mySettingsComponent;

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Revo";
    }

    @Override
    public @Nullable JComponent createComponent() {
        mySettingsComponent = new RevoSettingsComponent();
        return mySettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        RevoSettings.State state =
                Objects.requireNonNull(RevoSettings.getInstance().getState());
        return !mySettingsComponent.getRevoPath().equals(state.pathToRevo);
    }

    @Override
    public void apply() throws ConfigurationException {
        RevoSettings.State state =
                Objects.requireNonNull(RevoSettings.getInstance().getState());
        state.pathToRevo = mySettingsComponent.getRevoPath();
    }

    @Override
    public void reset() {
        RevoSettings.State state =
                Objects.requireNonNull(RevoSettings.getInstance().getState());
        mySettingsComponent.setRevoPath(state.pathToRevo);
    }

    @Override
    public void disposeUIResources() {
        mySettingsComponent = null;
    }
}

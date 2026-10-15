package com.github.maytman.intellir.revo.editor.settings;

import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;

@State(
        name = "com.github.maytman.intellir.RevoSettings",
        storages = @Storage("revoSettings.xml")
)
public final class RevoSettings implements PersistentStateComponent<RevoSettings.State> {

    public static class State {
        public String pathToRevo = "";
    }

    private State myState = new State();

    public static RevoSettings getInstance() {
        return ApplicationManager.getApplication()
                .getService(RevoSettings.class);
    }

    public String getRevoExecutable() {
        if(getRevoPath().isBlank()) {
            return "revo";
        } else {
            return getRevoPath().trim();
        }
    }

    @Override
    public State getState() {
        return myState;
    }

    @Override
    public void loadState(@NotNull State state) {
        myState = state;
    }

    public String getRevoPath() {
        return myState.pathToRevo;
    }
}

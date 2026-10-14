package com.github.maytman.intellir.revo.editor.settings;

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

    public State myState = new State();

    public static RevoSettings getInstance() {
        return ApplicationManager.getApplication()
                .getService(RevoSettings.class);
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

package com.github.maytman.intellir.revo.editor.runConfiguration;

import com.github.maytman.intellir.revo.editor.settings.RevoSettings;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessHandlerFactory;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class RevoRunConfiguration extends RunConfigurationBase<RevoRunConfigurationOptions> {

    protected RevoRunConfiguration(Project project,
                                   ConfigurationFactory factory,
                                   String name) {
        super(project, factory, name);
    }

    @NotNull
    @Override
    protected RevoRunConfigurationOptions getOptions() {
        return (RevoRunConfigurationOptions) super.getOptions();
    }

    public String getScriptPath() {
        return getOptions().getScriptPath();
    }

    public void setScriptPath(String scriptPath) {
        getOptions().setScriptPath(scriptPath);
    }

    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new RevoSettingsEditor();
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor,
                                    @NotNull ExecutionEnvironment environment) {
        return new CommandLineState(environment) {
            @NotNull
            @Override
            protected ProcessHandler startProcess() throws ExecutionException {
                GeneralCommandLine commandLine =
                        new GeneralCommandLine(RevoSettings.getInstance().getRevoExecutable(), getScriptPath())
                                .withWorkDirectory(Path.of(getScriptPath()).getParent().toString());
                OSProcessHandler processHandler = ProcessHandlerFactory.getInstance()
                        .createColoredProcessHandler(commandLine);
                ProcessTerminatedListener.attach(processHandler);
                return processHandler;
            }
        };
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
            String scriptPath = getScriptPath();

            if(scriptPath == null || scriptPath.isBlank()) {
                throw new RuntimeConfigurationError("No Revo script selected");
            }

        try {
            if (!Files.isRegularFile(Path.of(scriptPath))) {
                throw new RuntimeConfigurationError("Revo script not found: " + scriptPath);
            }
        } catch (InvalidPathException e) {
            throw new RuntimeConfigurationError("Invalid path: " + scriptPath);
        }
    }

}

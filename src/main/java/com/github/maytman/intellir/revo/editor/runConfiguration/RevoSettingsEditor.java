package com.github.maytman.intellir.revo.editor.runConfiguration;

import com.github.maytman.intellir.revo.RevoFileType;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class RevoSettingsEditor extends SettingsEditor<RevoRunConfiguration> {

    private final JPanel myPanel;
    private final TextFieldWithBrowseButton scriptPathField;

    public RevoSettingsEditor() {
        scriptPathField = new TextFieldWithBrowseButton();
        scriptPathField.addBrowseFolderListener(null,
                FileChooserDescriptorFactory.createSingleFileDescriptor(RevoFileType.INSTANCE).withTitle("Select Revo File"));
        myPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent("Revo file", scriptPathField)
                .getPanel();
    }

    @Override
    protected void resetEditorFrom(@NotNull RevoRunConfiguration revoRunConfiguration) {
        scriptPathField.setText(revoRunConfiguration.getScriptPath());
    }

    @Override
    protected void applyEditorTo(@NotNull RevoRunConfiguration revoRunConfiguration) throws ConfigurationException {
        revoRunConfiguration.setScriptPath(scriptPathField.getText());
    }

    @Override
    protected @NotNull JComponent createEditor() {
        return myPanel;
    }
}

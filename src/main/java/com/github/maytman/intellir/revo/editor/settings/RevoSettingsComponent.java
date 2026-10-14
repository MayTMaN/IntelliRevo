package com.github.maytman.intellir.revo.editor.settings;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class RevoSettingsComponent {

    private final JPanel myMainPanel;
    private final JBTextField pathToRevo = new JBTextField();

    public RevoSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Path to revo executable:"), pathToRevo, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    @NotNull
    public String getRevoPath() {
        return pathToRevo.getText();
    }

    public void setRevoPath(@NotNull String newText) {
        pathToRevo.setText(newText);
    }


}

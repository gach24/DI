package examples.unit01.components.dialogs.optionsdialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class OptionDialogFrame extends JFrame {
    private ButtonPanel typePanel;
    private ButtonPanel messagePanel;
    private ButtonPanel messageTypePanel;
    private ButtonPanel optionTypePanel;
    private ButtonPanel optionsPanel;
    private ButtonPanel inputPanel;

    private String messageString = "Message";
    private Icon messageIcon = new ImageIcon("blue-ball.gif");
    private Object messageObject = new Date();
    private Component messageComponent = new SampleComponent();

    public OptionDialogFrame() {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2,3));

        typePanel = new ButtonPanel("Type", "Message", "Confirm", "Option", "Input");
        messageTypePanel = new ButtonPanel(
                "Message Type",
                "ERROR_MESSAGE",
                        "INFORMATION_MESSAGE",
                        "WARNING_MESSAGE",
                        "QUESTION_MESSAGE",
                        "PLAIN_MESSAGE");

        messagePanel = new ButtonPanel(
                "Message",
                "String",
                        "Icon",
                        "Component",
                        "Other",
                        "Object[]");
        optionTypePanel = new ButtonPanel(
                "Confirm",
                "DEFAULT_OPTION",
                        "YES_NO_OPTION",
                        "YES_NO_CANCEL_OPTION",
                        "OK_CANCEL_OPTION");

        optionsPanel = new ButtonPanel(
                "Option",
                "String[]",
                        "Icon[]",
                        "Object[]");

        inputPanel = new ButtonPanel("Input", "Test field", "Combo box");

        gridPanel.add(typePanel);
        gridPanel.add(messageTypePanel);
        gridPanel.add(messagePanel);
        gridPanel.add(optionTypePanel);
        gridPanel.add(optionsPanel);
        gridPanel.add(inputPanel);

        JPanel showPanel = new JPanel();
        JButton showButton = new JButton("Show");
        showButton.addActionListener(new ShowAction());
        showPanel.add(showButton);

        add(gridPanel, BorderLayout.CENTER);
        add(showPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Gets the currently selected message
     * @return a string, icon, component, or object array, depending on the message panel selection
     */
    public Object getMessage() {
        String s = messagePanel.getSelecction();
        if (s.equals("String"))
            return messageString;
        else if (s.equals("Icon"))
            return messageIcon;
        else if (s.equals("Component"))
            return messageComponent;
        else if (s.equals("Object[]"))
            return new Object[] { messageString, messageIcon, messageComponent, messageObject };
        else if (s.equals("Other"))
            return messageObject;
        else
            return null;
    }

    /**
     * Gets the currently selected options
     * @return an array of strings, icons, or objects, depending on the Option panel selection
     */
    public Object[] getOptions() {
        String s = optionsPanel.getSelecction();
        if (s.equals("String[]")) {
            return new String[]{"Yellow", "Blue", "Red"};
        } else if (s.equals("Icon[]")) {
            return new Icon[]{
                    new ImageIcon("yellow-ball.gif"),
                    new ImageIcon("blue-ball.gif"),
                    new ImageIcon("red-ball.gif")
            };
        } else if (s.equals("Object[]")) {
            return new Object[]{
                    messageString,
                    messageIcon,
                    messageComponent,
                    messageObject
            };
        } else {
            return null;
        }
    }

    /**
     * Get the selected message or option type
     * @param panel the Message Type of Confirm panel
     * @return The selected XXX_MESSAGE or XXX_OPTION constant from JOptionPane class
     */
    public int getType(ButtonPanel panel) {
        String s = panel.getSelecction();
        try {
            return JOptionPane.class.getField(s).getInt(null);
        } catch (Exception e) {
            return -1;
        }
    }

    private class ShowAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (typePanel.getSelecction().equals("Confirm")) {
                JOptionPane.showConfirmDialog(
                        OptionDialogFrame.this,
                        getMessage(),
                        "Title",
                        getType(optionTypePanel),
                        getType(messageTypePanel)
                );
            } else if (typePanel.getSelecction().equals("Input")) {
                if (inputPanel.getSelecction().equals("Text field")) {
                    JOptionPane.showInputDialog(
                            OptionDialogFrame.this,
                            getMessage(),
                            "Title",
                            getType(messageTypePanel)
                    );
                } else {
                    JOptionPane.showInputDialog(
                            OptionDialogFrame.this,
                            getMessage(),
                           "Title",
                           getType(messageTypePanel),
                            null,
                            new String[] { "Yellow", "Blue", "Red"},
                            "Blue"
                    );
                }
            } else if (typePanel.getSelecction().equals("Message")) {
                JOptionPane.showMessageDialog(
                        OptionDialogFrame.this,
                        getMessage(),
                        "Title",
                        getType(messageTypePanel)
                );
            } else if (typePanel.getSelecction().equals("Option")) {
                JOptionPane.showOptionDialog(
                        OptionDialogFrame.this,
                        getMessage(),
                        "Title",
                        getType(optionTypePanel),
                        getType(messageTypePanel),
                        null,
                        getOptions(),
                        getOptions()[0]
                );
            }
        }
    }
}

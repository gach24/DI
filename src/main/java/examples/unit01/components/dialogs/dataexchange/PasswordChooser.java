package examples.unit01.components.dialogs.dataexchange;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * A password chooser that is shown inside a dialog
 */
public class PasswordChooser extends JPanel{
    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;

    public PasswordChooser() {
        setLayout(new BorderLayout());

        // Construct a panel with username and password fields
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("User name:"));
        panel.add(username = new JTextField(""));
        panel.add(new JLabel("Password:"));
        panel.add(password = new JPasswordField(""));
        add(panel, BorderLayout.CENTER);

        // create Ok and Cancel buttons that terminate the dialog
        okButton = new JButton("Ok");
        okButton.addActionListener(e -> {
            ok = true;
            dialog.setVisible(false);
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dialog.setVisible(false));

        // Add buttons to southern border
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setUser(User user) {
        username.setText(user.getName());
    }

    public User getUser() {
        return new User(username.getText(), password.getPassword());
    }

    public boolean showDialog(Component parent, String title) {
        ok = false;

        Frame owner = null;
        if (parent instanceof Frame)
            owner = (Frame)parent;
        else
            owner = (Frame)SwingUtilities.getAncestorOfClass(Frame.class, parent);

        // if first time, or if owner has changed, make a new dialog
        if (dialog == null || dialog.getOwner() != owner) {
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        // set title and show dialog
        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }
}

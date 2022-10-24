package examples.unit01.components.dialogs.dataexchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataExchangeFrame extends JFrame {

    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 40;
    private PasswordChooser dialog = null;
    private JTextArea textArea;

    public DataExchangeFrame() {
        // Construct a File menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem connectItem = new JMenuItem("Connect");
        connectItem.addActionListener(new ConnectAction());
        fileMenu.add(connectItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();
    }

    /**
     * The connect action pops up the password dialog
     */
    private class ConnectAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // if first time, construct dialog
            if (dialog == null)
                dialog = new PasswordChooser();

            dialog.setUser(new User("German", null));
            if (dialog.showDialog(DataExchangeFrame.this, "Connect")) {
                User user = dialog.getUser();
                textArea.append("Username = "
                        + user.getName() + ", password = "
                        + (new String(user.getPassword() + "\n"))
                );
            }
        }
    }
}

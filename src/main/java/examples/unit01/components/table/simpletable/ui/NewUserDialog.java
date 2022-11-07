package examples.unit01.components.table.simpletable.ui;

import examples.unit01.components.table.simpletable.dto.Client;

import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class NewUserDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtName;
    private JLabel lblName;
    private JPanel pnlMain;
    private JPanel pnlButtons;
    private JSpinner spinner1;
    private MainFrame owner;

    public NewUserDialog(MainFrame owner) {
        this.owner = owner;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        Client client = new Client(
                "Nombre 1",
                "Apellido 1", new Date(),
                "Asturias");
        owner.addClient(client);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        //NewUserDialog dialog = new NewUserDialog();
        //dialog.pack();
        //dialog.setVisible(true);
        //System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

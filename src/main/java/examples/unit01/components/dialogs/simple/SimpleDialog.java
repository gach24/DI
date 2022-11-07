package examples.unit01.components.dialogs.simple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;

    public SimpleDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    public SimpleDialog(Frame owner, boolean modal) {
        super(owner, modal);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void main(String[] args) {
        SimpleDialog dialog = new SimpleDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

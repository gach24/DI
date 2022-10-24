package examples.unit01.components.dialogs.custom;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {
    public AboutDialog(JFrame owner) {
        super(owner, "About DialogTest", true);

        add(
                new JLabel("<html><h1><i>Java Book</i></h1><hr />By Germán Carreño</html>"),
                BorderLayout.CENTER
        );

        JButton ok = new JButton("OK");
        ok.addActionListener(e -> setVisible(true));

        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);

        pack();
    }
}

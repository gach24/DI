package examples.unit01.components.e08_checkbox_frame;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

public class CheckBoxFrame extends JFrame {

    private JLabel label        = new JLabel("The quick brown fox jumps over the lazy dog");;
    private JCheckBox bold      = new JCheckBox("Bold");
    private JCheckBox italic    = new JCheckBox("Italic");
    private static final int FONT_SIZE = 24;

    public CheckBoxFrame() {
        // add the sample text label
        label.setFont(new Font("Serif", Font.BOLD, FONT_SIZE));
        add(label, BorderLayout.CENTER);

        ActionListener listener = event -> {
            int mode = 0;
            if (bold.isSelected())
                mode += Font.BOLD;
            else if (italic.isSelected())
                mode += Font.ITALIC;
            label.setFont(new Font("Serif", mode, FONT_SIZE));
        };

        JPanel buttonPanel = new JPanel();
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}

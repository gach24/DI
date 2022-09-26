package examples.unit01.components.e11_combobox_frame;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;

/**
 * ComboBoxFrame
 * A Frame with a sample text label and a combo box for selecting font frames
 * @author German Carreño
 */
public class ComboBoxFrame extends JFrame {

    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;

    public ComboBoxFrame() {
        // Add the sample text label
        label = new JLabel("The quick brown fox jumps over the lazy dog");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        // Make a combo box and add face names
        faceCombo = new JComboBox<String>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");


        faceCombo.addActionListener(e -> {
            String text = faceCombo.getItemAt(faceCombo.getSelectedIndex());
            label.setFont(new Font(text, Font.PLAIN, DEFAULT_SIZE));
        });

        JPanel comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel, BorderLayout.SOUTH);
        pack();
    }

}

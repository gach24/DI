package examples.unit01.components.radiobuttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * RadioButtonFrame
 * A Frame with a sample text label and radio buttons for select font sizes
 * @author German Carreño
 */
public class RadioButtonFrame extends JFrame {

    public static final int DEFAULT_SIZE = 36;
    private final JPanel buttonPanel;
    private final ButtonGroup group;
    private final JLabel label;

    public RadioButtonFrame() {
        // Add the sample text label
        label = new JLabel("The quick brown fox jumps over the lazy dog");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        // Add radio buttons
        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Small", 8);
        addRadioButton("Medium", 12);
        addRadioButton("Large", 16);
        addRadioButton("Extra Large", 36);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addRadioButton(String name, int size) {
        boolean selected = size == DEFAULT_SIZE;
        JRadioButton button = new JRadioButton(name, selected);
        group.add(button);
        buttonPanel.add(button);

        ActionListener listener = e -> label.setFont(new Font("Serif", Font.PLAIN, size));
        button.addActionListener(listener);
    }
}

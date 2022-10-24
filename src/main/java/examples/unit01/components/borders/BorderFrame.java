package examples.unit01.components.borders;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * BorderFrame
 * A Frame with radio buttons to pick a border style
 * @author German Carreño
 */
public class BorderFrame extends JFrame {

    private JPanel demoPanel;
    private JPanel buttonPanel;
    private ButtonGroup group;



    public BorderFrame() {
        demoPanel = new JPanel();
        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Loweded bebel", BorderFactory.createLoweredBevelBorder());
        addRadioButton("Raised bevel", BorderFactory.createRaisedBevelBorder());
        addRadioButton("Etched", BorderFactory.createEtchedBorder());
        addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
        addRadioButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
        addRadioButton("Empty", BorderFactory.createEmptyBorder());

        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, "Border Types");
        buttonPanel.setBorder(titled);

        setLayout(new GridLayout(2,1));
        add(buttonPanel);
        add(demoPanel);
        pack();

    }

    public void addRadioButton(String buttonName, Border b) {
        JRadioButton button = new JRadioButton(buttonName);
        group.add(button);
        buttonPanel.add(button);
        button.addActionListener(e -> demoPanel.setBorder(b));
    }
}

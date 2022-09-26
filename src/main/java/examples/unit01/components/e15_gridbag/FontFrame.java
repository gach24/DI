package examples.unit01.components.e15_gridbag;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

/**
 * A frame that uses a grid bag layout to arrange font selection components
 * @author German Carreño
 */
public class FontFrame extends JFrame {

    public static final int DEFAULT_ROWS = 10;
    public static final int DEFAULT_COLUMNS = 20;

    private JComboBox<String> face;
    private JComboBox<Integer> size;
    private JCheckBox bold;
    private JCheckBox italic;
    private JTextArea sample;

    public FontFrame() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        ActionListener listener = e -> updateSample();

        // Constructor components
        JLabel faceLabel = new JLabel("Face");
        face = new JComboBox<>(new String[] { "Serif", "SansSerif", "Monopaced", "Dialog", "DialogInput" });
        face.addActionListener(listener);

        JLabel sizeLabel = new JLabel("Size: ");
        size = new JComboBox<>(new Integer[] { 8, 10, 12, 15, 18, 24, 36, 48 });
        size.addActionListener(listener);

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);

        sample = new JTextArea(DEFAULT_ROWS, DEFAULT_COLUMNS);
        sample.setText("The quick brown fox jumps over the lazy dog");
        sample.setEditable(true);
        sample.setLineWrap(true);
        sample.setBorder(BorderFactory.createEtchedBorder());

        // Add components to grid, using GBC convenience class
        add(faceLabel, new GBC(0, 0).setAnchor(GBC.EAST));
        add(face, new GBC(1,0)
                    .setFill(GBC.HORIZONTAL)
                    .setWeight(1.0, 0)
                    .setInsets(1));
        add(sizeLabel, new GBC(0,1)
                            .setAnchor(GBC.EAST));
        add(size, new GBC(1,1)
                        .setFill(GBC.HORIZONTAL)
                        .setWeight(1.0, 1.0));
        add(bold, new GBC(0, 2, 2, 1)
                        .setAnchor(GBC.CENTER)
                        .setWeight(0, 1.0));
        add(italic, new GBC(0, 3, 2, 1)
                            .setAnchor(GBC.CENTER)
                            .setWeight(1.0, 1.0));
        add(sample, new GBC(2, 0, 1, 4)
                            .setFill(GBC.BOTH)
                            .setWeight(1.0, 1.0));
        pack();
        updateSample();
    }

    public void updateSample() {
        String fontFace = (String)face.getSelectedItem();
        int fontStyle = (bold.isSelected() ? Font.BOLD : 0) + (italic.isSelected() ? Font.ITALIC : 0);
        int fontSize = size.getItemAt(size.getSelectedIndex());
        Font font = new Font(fontFace, fontStyle, fontSize);
        sample.setFont(font);
        sample.repaint();
    }
}

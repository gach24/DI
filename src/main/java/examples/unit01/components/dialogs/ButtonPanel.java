package examples.unit01.components.dialogs;

import javax.swing.*;

/**
 * A panel with radio buttons inside a titled border
 */
public class ButtonPanel extends JPanel {

    private ButtonGroup group;

    /**
     * Constructs a button panel
     * @param title the title shown in the border
     * @param options an array of radio buttons labels
     */
    public ButtonPanel(String title, String... options) {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        group = new ButtonGroup();

        // make a radio button for each option
        for (String option: options) {
            JRadioButton radio = new JRadioButton(option);
            radio.setActionCommand(option);
            add(radio);
            group.add(radio);
            radio.setSelected(option == options[0]);
        }
    }

    /**
     * Gets the currently selected option
     * @return the label of the currently selected radio button
     */
    public String getSelecction() {
        return group.getSelection().getActionCommand();
    }
}

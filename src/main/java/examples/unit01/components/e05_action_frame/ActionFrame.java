package examples.unit01.components.e05_action_frame;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;


/**
 * ActionFrame
 * @author German Carreño
 */
public class ActionFrame extends JFrame {

    private JPanel buttonPanel = new JPanel();
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;



    public ActionFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        Action yellowAction = new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"), Color.yellow);
        Action blueAction   = new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.blue);
        Action redAction    = new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.red);

        // Add buttons for these actions
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        add(buttonPanel);

        // Associate the Y, B, and R keys with names
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

        // Associate the names with actions
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);

    }

    public class ColorAction extends AbstractAction {

        /**
         * Constuctor a color action
         * @param name the name of the button
         * @param icon The icon to display on the button
         * @param color The background color
         */
        public ColorAction(String name, Icon icon, Color color) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
            putValue("color", color);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color)getValue("color");
            buttonPanel.setBackground(c);
        }
    }




    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            ActionFrame frame = new ActionFrame();
            frame.setTitle("SizedFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}



package examples.unit01.components.buttons.plaf;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


/**
 * PlafFrame
 * @author German Carreño
 */
public class PlafFrame extends JFrame {

    private JPanel buttonPanel = new JPanel();

    public PlafFrame() {

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();

        for (UIManager.LookAndFeelInfo info: infos)
            makeButton(info.getName(), info.getClassName());

        add(buttonPanel);
        pack();
    }

    /**
     * Makes a button to change the pluggable look-and-feel
     * @param name The button name
     * @param className The name of the look-and-feel class
     */
    private void makeButton(String name, String className)
    {
        JButton button = new JButton(name);
        buttonPanel.add(button);

        button.addActionListener(event -> {
            try
            {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                // pack();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }
}

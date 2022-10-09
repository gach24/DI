package examples.unit01.components.e02_sized_frame;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

/**
 * SizedFrame
 * @author German Carreño
 */
public class SizedFrame extends JFrame {

    public SizedFrame() {
        // Get screen dimensions
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Set frame width, height and let platform pick screen location
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

        // Set icon frame
        Image img = new ImageIcon("/icon.gif").getImage();
        setIconImage(img);
    }
}

package examples.unit01.components.jframe.simple;

import javax.swing.JFrame;
import java.awt.EventQueue;

/**
 * Main Class
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SimpleFrame frame = new SimpleFrame();
            frame.setTitle("ActionFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

package examples.unit01.components.e05_action_frame;

import javax.swing.JFrame;
import java.awt.EventQueue;

public class Main extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ActionFrame frame = new ActionFrame();
            frame.setTitle("CalculatorFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

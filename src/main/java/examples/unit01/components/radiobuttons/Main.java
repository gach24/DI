package examples.unit01.components.radiobuttons;


import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            RadioButtonFrame frame = new RadioButtonFrame();
            frame.setTitle("TextComponentFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

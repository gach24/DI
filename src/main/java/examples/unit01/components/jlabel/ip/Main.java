package examples.unit01.components.jlabel.ip;

import examples.unit01.components.jbutton.plaf.PlafFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new IpFrame();
            frame.setTitle("Ip ");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

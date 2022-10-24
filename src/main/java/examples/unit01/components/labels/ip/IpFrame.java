package examples.unit01.components.labels.ip;

import javax.swing.*;
import java.net.Inet4Address;
import java.util.Optional;

public class IpFrame extends JFrame {
    private final static int DEFAULT_WIDTH = 400;
    private final static int DEFAULT_HEIGHT = 400;



    public IpFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(null);

        JTextField host = new JTextField();
        host.setBounds(50, 50, 150, 30);
        add(host);

        JLabel ipLabel = new JLabel();
        ipLabel.setBounds(50, 100, 250, 20);
        add(ipLabel);

        JButton button = new JButton("Find Ip");
        button.setBounds(50, 150, 95, 30);
        button.addActionListener((event) -> {
            try {
                String hostName = host.getText();
                String ip = Inet4Address.getByName(hostName).getHostAddress();
                ipLabel.setText(ip);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        add(button);
    }
}

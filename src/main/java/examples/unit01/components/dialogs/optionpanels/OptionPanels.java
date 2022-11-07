package examples.unit01.components.dialogs.optionpanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionPanels extends JFrame {

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 300;

    private JButton btnMessage;
    private JPanel pnlButtons;
    private JButton btnConfirm;
    private JButton btnInput;


    public OptionPanels() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setContentPane(pnlButtons);

        btnMessage.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        pnlButtons,
                        "Un mensaje de prueba",
                        "Título",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnConfirm.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        pnlButtons,
                        "¿Está seguro de que quiere borrar el registro",
                        "Título",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    JOptionPane.showMessageDialog(
                            pnlButtons,
                            "Registro borrado",
                            "Title",
                            JOptionPane.INFORMATION_MESSAGE);
                else if (result == JOptionPane.NO_OPTION)
                    JOptionPane.showMessageDialog(
                            pnlButtons,
                            "Registro no borrado",
                            "Title",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnInput.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //Diálogo para preguntar por un dato simple
                String nombre = JOptionPane.showInputDialog(
                        pnlButtons,
                        "Introduce tu nombre",
                        "Pregunta",
                        JOptionPane.QUESTION_MESSAGE);
                JOptionPane.showMessageDialog(btnMessage,
                        "Hola "+nombre,
                        "Título",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            OptionPanels frame = new OptionPanels();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

package examples.unit01.components.e06_calculator_frame;

import javax.swing.*;


/**
 * GridLayout
 * @author German Carreño
 */
public class CalculatorFrame extends JFrame {

    public CalculatorFrame() {
        add(new CalculatorPanel());
        pack();
    }


}



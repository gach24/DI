package examples.unit01.components.jbutton.calculator;

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



package examples.unit01.components.frames.simple;

import javax.swing.JFrame;

/**
 * SampleFrame
 * @author German Carreño
 */
public class SimpleFrame extends JFrame {
    // CONSTANTS
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    // CONSTRUCTORS
    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

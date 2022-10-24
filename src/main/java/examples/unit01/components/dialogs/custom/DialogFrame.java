package examples.unit01.components.dialogs.custom;

import javax.swing.*;

/**
 * A frame with a menu File->About action shows a dialog
 */
public class DialogFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;
    private AboutDialog dialog;

    public DialogFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // Construct a File menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // The about item shows the AboutDialog
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> {
            if (dialog == null)
                dialog = new AboutDialog(DialogFrame.this);
            dialog.setVisible(true);
        });
        fileMenu.add(aboutItem);

        // The exit item
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

    }


}

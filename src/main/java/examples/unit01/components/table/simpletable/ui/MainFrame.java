package examples.unit01.components.table.simpletable.ui;

import examples.unit01.components.table.simpletable.dto.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 300;
    private JPanel pnlClients;
    private JTable tblClients;
    private JMenuBar menuBar;
    private JMenu mnuClients;
    private JMenuItem  itemNew;


    public MainFrame(String title) {
        super(title);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setContentPane(pnlClients);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        initTable();

        mnuClients = new JMenu("Clientes");
        itemNew = new JMenuItem("Alta");

        menuBar.add(mnuClients);
        mnuClients.add(itemNew);

        itemNew.addActionListener((e)-> {
            NewUserDialog dialog = new NewUserDialog(this);
            dialog.pack();
            dialog.setVisible(true);

        });

    }

    public void initTable() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(
                new String[] { "Nombre", "Apellidos", "Fecha Alta", "Provincia" }
        );
        tblClients.setModel(tableModel);
    }

    public void addClient(Client client) {
        DefaultTableModel table = (DefaultTableModel) tblClients.getModel();
        table.addRow(client.toArrayString());
    }





    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            MainFrame frame = new MainFrame("Simple Table");
            frame.setContentPane(frame.pnlClients);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }



}

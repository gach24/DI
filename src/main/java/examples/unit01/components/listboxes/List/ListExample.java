package examples.unit01.components.listboxes.List;

import javax.swing.*;
import java.awt.*;

class ListExample extends JFrame
{
    private DefaultListModel lm1 = new DefaultListModel();
    private DefaultListModel lm2 = new DefaultListModel();

    private JList list1 = new JList(lm1);
    private JList list2 = new JList(lm2);

    private JButton btnRight = new JButton(">>>");
    private JButton btnLeft = new JButton("<<<");


    public ListExample()
    {
        setLocation(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] text1 = { "abc", "def", "ghi" };

        String[] text2 = { "123", "456", "789" };

        for(int x = 0; x < text1.length; x++)
            lm1.addElement(text1[x]);

        for(int x = 0; x < text2.length; x++)
            lm2.addElement(text2[x]);

        JScrollPane sp1 = new JScrollPane(list1);
        JScrollPane sp2 = new JScrollPane(list2);

        sp1.setPreferredSize(new Dimension(75,200));
        sp2.setPreferredSize(new Dimension(75,200));

        btnRight.addActionListener(ae -> leftToRight());

        btnLeft.addActionListener(ae -> rightToLeft());

        JPanel main = new JPanel(new BorderLayout());

        add(sp1,BorderLayout.WEST);
        add(sp2,BorderLayout.EAST);

        JPanel mid = new JPanel(new GridLayout(2,1));
        mid.add(btnRight);
        mid.add(btnLeft);

        JPanel holdingPanel = new JPanel(new GridBagLayout());

        holdingPanel.add(mid,new GridBagConstraints());

        add(holdingPanel,BorderLayout.CENTER);


        pack();
    }

    public void leftToRight()
    {
        int index = list1.getSelectedIndex();
        if(index > -1)
        {
            lm2.addElement((String)list1.getSelectedValue());
            lm1.removeElementAt(index);
        }
        else {
            JOptionPane.showMessageDialog(null,"No selection made in LH List");
        }
    }

    public void rightToLeft()
    {
        int index = list2.getSelectedIndex();
        if(index > -1)
        {
            lm1.addElement((String)list2.getSelectedValue());
            lm2.removeElementAt(index);
        }
        else JOptionPane.showMessageDialog(null,"No selection made in RH List");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ListExample().setVisible(true);
        });
    }
}
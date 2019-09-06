package ex6;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener
{
    JPanel panelBtns = new JPanel();
    JPanel panelContent = new JPanel();
    JRadioButton[] btns = {new JRadioButton("C"), new JRadioButton("C++"), new JRadioButton("C#")};
    JLabel lbl = new JLabel();
    ButtonGroup btnGroup = new ButtonGroup();

    public MyFrame()
    {
        panelBtns.setLayout(new BoxLayout(panelBtns, BoxLayout.PAGE_AXIS));
        initBtns();
        add(BorderLayout.WEST,panelBtns);
        panelContent.add(lbl);
        add(BorderLayout.CENTER, panelContent);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public void initBtns()
    {
        for(int i = 0; i < btns.length; i++)
        {
            btnGroup.add(btns[i]);
            panelBtns.add(btns[i]);
            btns[i].addActionListener(this);
            if (i != 2)
                panelBtns.add(Box.createVerticalGlue());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < btns.length; i++)
        {
            if (btns[i].isSelected())
            {
                lbl.setIcon(new ImageIcon(getClass().getResource(i + ".png")));
            }
        }
    }
}

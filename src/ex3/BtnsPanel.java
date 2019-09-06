package ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnsPanel extends JFrame implements ActionListener
{
    String disponibilidade[][] = new String[5][10];
    JButton[][] btns = new JButton[5][10];
    JPanel panel = new JPanel();
    MyFrame myFrame;

    public BtnsPanel(String[][] s, MyFrame myFrame)
    {
        this.myFrame = myFrame;
        panel.setLayout(new GridLayout(5, 10));
        disponibilidade = s;
        initDisp();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setSize(1000, 500);
        panel.setBackground(new Color(30, 30, 30));
        add(panel);
        setVisible(true);
    }

    private void initDisp()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                btns[i][j] = new JButton((i + 1) + "-" + (j + 1) + " " + disponibilidade[i][j]);
                btns[i][j].setForeground(Color.WHITE);
                btns[i][j].setBackground(new Color(60, 60, 60));
                btns[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                btns[i][j].addActionListener(this);
                panel.add(btns[i][j]);
            }
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        boolean timeToBreak = false;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (e.getSource() == btns[i][j])
                {
                    disponibilidade[i][j] = myFrame.changeAvaliability(i, j);
                    btns[i][j].setText((i + 1) + "-" + (j + 1) + " " + disponibilidade[i][j]);
                    timeToBreak = true;
                    break;
                }
            }
            if (timeToBreak)
            {
                break;
            }
        }
        myFrame.updateLbls();
    }
}

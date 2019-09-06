package ex3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame
{
    private String[][] disponibilidade = new String[5][10];
    private JButton[] btns = new JButton[3];
    private JLabel[][] dispLbl = new JLabel[5][10];
    private String[] btnName = {"Imprimir lista de quartos", "Definir Ocupação", "Sair"};
    private JPanel contentPanel = new JPanel();
    private JPanel btnPanel = new JPanel();
    private Font f = new Font("Consolas", Font.BOLD, 15);

    private Color bg = new Color(30,30,30);
    private Color bgBtn = new Color(60,60,60);


    private boolean isActiveted = false;

    public MyFrame()
    {
        btnPanel.setBackground(bg);
        contentPanel.setBackground(bg);
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.PAGE_AXIS));
        contentPanel.setLayout(new GridLayout(5, 10));
        btnPanel.setMaximumSize(new Dimension(100, 500));
        redButtons();
        initDisp();
        add(BorderLayout.WEST, btnPanel);
        add(contentPanel);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initDisp()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                disponibilidade[i][j] = "Disponivel";
                dispLbl[i][j] = new JLabel();
                dispLbl[i][j].setForeground(Color.WHITE);
                dispLbl[i][j].setFont(f);
                dispLbl[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                dispLbl[i][j].setVisible(false);
                contentPanel.add(dispLbl[i][j]);
            }
        }
    }

    public void updateLbls()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                dispLbl[i][j].setText((i + 1) + "-" + (j + 1) + " " + disponibilidade[i][j]);
            }
        }
    }

    private void setBtnActive()
    {
        new BtnsPanel(disponibilidade, this);
    }

    public String changeAvaliability(int n1, int n2)
    {
        if (disponibilidade[n1][n2] == "Disponivel")
        {
            disponibilidade[n1][n2] = "Indisponivel";
        } else
        {
            disponibilidade[n1][n2] = "Disponivel";
        }
        return disponibilidade[n1][n2];
    }

    private void redButtons()
    {
        Dimension d = new Dimension(200, 30);
        for (int i = 0; i < btns.length; i++)
        {
            btns[i] = new JButton(btnName[i]);
            btns[i].setBackground(bgBtn);
            btns[i].setForeground(Color.WHITE);
            btns[i].setMinimumSize(d);
            btns[i].setMaximumSize(d);
            btns[i].setSize(d);
            btnPanel.add(btns[i]);
            if (i != 2)
                btnPanel.add(Box.createVerticalGlue());
        }
        btns[0].addActionListener(new PrintRooms());
        btns[1].addActionListener(new DefineAvalability());
        btns[2].addActionListener(new ExitAplication());
    }

    private void setPrint()
    {
        isActiveted = !isActiveted;
        updateLbls();
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                dispLbl[i][j].setVisible(isActiveted);
            }
        }
    }


    class PrintRooms implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            setPrint();
        }
    }

    class DefineAvalability implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            setBtnActive();
        }
    }

    class ExitAplication implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}

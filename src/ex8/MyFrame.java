package ex8;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class MyFrame extends JFrame implements ActionListener
{
    Dimension btnsNumDim;
    JButton[] numBtns = new JButton[10];
    JButton espBtna = new JButton("*");
    JButton espBtnb = new JButton("#");
    JButton clearBtn = new JButton("Limpar");
    JPanel numPanel = new JPanel();

    JTextField lblTxt = new JTextField();

    JMenuBar menuBar = new JMenuBar();
    JMenu menuArquivo = new JMenu("Arquivo");
    JMenu menuExemplos = new JMenu("Exemplos");

    String txt = new String();

    public MyFrame()
    {
        addComponentListener(new Resizing());
        numPanel.addComponentListener(new Resizing());
        numPanel.setLayout(null);
        initBtns();
        resizeComps();
        numPanel.add(lblTxt);
        lblTxt.setEnabled(false);
        menuBar.add(menuArquivo);
        menuBar.add(menuExemplos);
        setJMenuBar(menuBar);
        add(BorderLayout.CENTER, numPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(500, 500);
    }

    private void resizeComps()
    {
        add(BorderLayout.WEST, Box.createRigidArea(new Dimension(getSize().width / 6, getSize().height / 6)));
        add(BorderLayout.EAST, Box.createRigidArea(new Dimension(getSize().width / 6, getSize().height / 6)));
        btnsSize();
    }

    private void initBtns()
    {
        for (Integer i = 0; i < numBtns.length; i++)
        {
            numBtns[i] = new JButton(i.toString());
            numBtns[i].addActionListener(this);
            numPanel.add(numBtns[i]);
        }
        numPanel.add(espBtna);
        numPanel.add(espBtnb);
        numPanel.add(clearBtn);
        espBtna.addActionListener(this);
        espBtnb.addActionListener(this);
        clearBtn.addActionListener(this);
    }

    private void btnsSize()
    {
        btnsNumDim = new Dimension(numPanel.getWidth() / 4, numPanel.getHeight() / 9);
        numBtns[1].setBounds(0, 0, btnsNumDim.width, btnsNumDim.height);
        numBtns[2].setBounds(numPanel.getSize().width / 2 - (btnsNumDim.width / 2), 0, btnsNumDim.width, btnsNumDim.height);
        numBtns[3].setBounds(numPanel.getSize().width - btnsNumDim.width, 0, btnsNumDim.width, btnsNumDim.height);
        numBtns[4].setBounds(0, numBtns[1].getY() + (3 * btnsNumDim.height / 2), btnsNumDim.width, btnsNumDim.height);
        numBtns[5].setBounds(numPanel.getSize().width / 2 - (btnsNumDim.width / 2), numBtns[1].getY() + (3 * btnsNumDim.height / 2), btnsNumDim.width, btnsNumDim.height);
        numBtns[6].setBounds(numPanel.getSize().width - btnsNumDim.width, numBtns[1].getY() + (3 * btnsNumDim.height / 2), btnsNumDim.width, btnsNumDim.height);
        numBtns[7].setBounds(0, numBtns[4].getY() + (3 * btnsNumDim.height / 2), btnsNumDim.width, btnsNumDim.height);
        numBtns[8].setBounds(numPanel.getSize().width / 2 - (btnsNumDim.width / 2), numBtns[4].getY() + (3 * btnsNumDim.height / 2), btnsNumDim.width, btnsNumDim.height);
        numBtns[9].setBounds(numPanel.getSize().width - btnsNumDim.width, numBtns[4].getY() + (3 * btnsNumDim.height / 2), btnsNumDim.width, btnsNumDim.height);
        espBtna.setBounds(0, numBtns[7].getY() + (3 * btnsNumDim.height / 2), btnsNumDim.width, btnsNumDim.height);
        numBtns[0].setBounds(numPanel.getSize().width / 2 - (btnsNumDim.width / 2), numBtns[7].getY() + (3 * btnsNumDim.height / 2), btnsNumDim.width, btnsNumDim.height);
        espBtnb.setBounds(numPanel.getSize().width - btnsNumDim.width, numBtns[7].getY() + (3 * btnsNumDim.height / 2), btnsNumDim.width, btnsNumDim.height);
        clearBtn.setBounds(0, numBtns[0].getY() + (3 * btnsNumDim.height / 2), numPanel.getWidth(), btnsNumDim.height);
        lblTxt.setBounds(0, clearBtn.getY() + (3 * btnsNumDim.height / 2), numPanel.getWidth(), btnsNumDim.height);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < numBtns.length; i++)
        {
            if (e.getSource() == numBtns[i])
            {
                txt += i;
                lblTxt.setText(txt);
                return;
            }
        }
        if (e.getSource() == espBtna)
            txt += "*";
        else if (e.getSource() == espBtnb)
            txt += "#";
        else
            txt = "";
        lblTxt.setText(txt);
    }


    public static void main(String[] args)
    {
        new MyFrame();
    }

    private class Resizing extends ComponentAdapter
    {
        public void componentResized(ComponentEvent e)
        {
            resizeComps();
        }
    }
}

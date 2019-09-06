package ex5;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class FrameEx extends JFrame
{
    Jogo jogo;
    JButton btnAndar, btnPular, btnChutar;
    public FrameEx(Jogo jogo)
    {
        this.jogo = jogo;

        btnAndar = new JButton("Andar");
        btnPular = new JButton("Pular");
        btnChutar = new JButton("Chutar");

        btnAndar.addActionListener(new Andar());
        btnPular.addActionListener(new Pular());
        btnChutar.addActionListener(new Chutar());

        add(BorderLayout.WEST, btnAndar);
        add(BorderLayout.CENTER, btnPular);
        add(BorderLayout.EAST, btnChutar);

        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }



    private class Andar implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            new Play().andar();
        }
    }

    private class Pular implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            new Play().pular();
        }
    }
    private class Chutar implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            new Play().chutar();
        }
    }
}

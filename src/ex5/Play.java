package ex5;

import javax.swing.*;

public class Play implements Jogo
{
    @Override
    public void andar()
    {
        JOptionPane.showMessageDialog(null, "Andou");
    }
    @Override
    public void pular()
    {
        JOptionPane.showMessageDialog(null, "Pulou");
    }
    @Override
    public void chutar()
    {
        JOptionPane.showMessageDialog(null, "Chutou");
    }
}

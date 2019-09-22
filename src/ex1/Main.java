package ex1;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {

        double preco = takenumber("digite o preço");
        int codigo = (int) takenumber("digite o codigo");

        double desconto;

        if (codigo == 1)
        {
            desconto = preco * 0.05;
        } else if (codigo == 2)
        {
            desconto = preco * 0.10;
        } else if (codigo == 3)
        {
            desconto = preco * 0.15;
        } else if (codigo == 4)
        {
            desconto = preco * 0.20;
        } else
        {
            desconto = 0;
        }
        double precototal = preco - desconto;
        JOptionPane.showMessageDialog(new Frame(), "o preco é R$ " + precototal);
    }
    private static double takenumber(String s)
    {
        double preco;

        while (true)
        {
            try
            {
                preco = Double.parseDouble(JOptionPane.showInputDialog(s));
            } catch (NumberFormatException e)
            {
                if (s == "digite o codigo")
                {
                    return 0;
                }
                JOptionPane.showMessageDialog(new Frame(), "codigo invalido");
                continue;
            }
            return preco;
        }
    }
}

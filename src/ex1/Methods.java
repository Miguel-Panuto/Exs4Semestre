package ex1;

import javax.swing.*;

public class Methods
{
    public static double calculateDiscount(int id, double price)
    {
        if (id == 1)
        {
            return price * 0.05;
        } else if (id == 2)
        {
            return price * 0.1;
        } else if (id == 3)
        {
            return price * 0.2;
        } else if (id == 4)
        {
            return price * 0.5;
        }
        return 0;
    }
    public static double takeNumber(String msg)
    {
        double value;
        while (true)
        {
            try
            {
                value = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor"));

            } catch (NumberFormatException e)
            {
                if (msg == "Insire o código de desconto (se tiver)")
                {
                    value = 0;
                    break;
                }
                JOptionPane.showMessageDialog(new JFrame(), "Insira um valor correto", "ERROR", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            break;
        }
        return value;
    }
}

package media;

import javax.swing.*;

public class MatClass
{
    static double takeNumber(Integer i)
    {
        String stringAux;
        double doubleAux;
        String verf;
        if (i == 2)
        {
            verf = "do Trabalho";
        } else
        {
            i++;
            verf = i.toString();
        }
        while (true)
        {
            try
            {
                stringAux = JOptionPane.showInputDialog("Insira a nota " + verf);
                doubleAux = Double.parseDouble(stringAux);
                if (!(doubleAux >= 0 && doubleAux <= 10))
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Insira um número correto", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            } catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Insira um número correto", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            break;

        }
        return doubleAux;
    }
    static double media(double n[])
    {
        return (n[0] * 0.4) + (n[1] * 0.35) + (n[2] * 0.25);
    }
    static void apareceOsBaguiNaTela(double notaFinal)
    {
        JOptionPane.showMessageDialog(new JFrame(), "A nota final é " + notaFinal, "Nota", JOptionPane.INFORMATION_MESSAGE);
    }
}

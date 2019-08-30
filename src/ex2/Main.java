package ex2;


import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        while (true)
        {
            int n = (int) (Math.random() * 10);
            int number;
            while (true)
            {
                try
                {
                    number = Integer.parseInt(JOptionPane.showInputDialog("Insira um número (insira entre 0 e 9, caso contrario parará)"));
                } catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Put a correct number", "ERROR", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            }

            if (number > 9 || number < 0)
            {
                break;
            }
            String afirmacao = (n == number) ? "acertou, o número foi " + n : "errou, o número foi " + n + " e o seu " + number;

            JOptionPane.showMessageDialog(new JFrame(), "Você " + afirmacao);
        }
    }
}

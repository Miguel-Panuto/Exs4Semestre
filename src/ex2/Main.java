package ex2;

import java.awt.Frame;
import javax.swing.*;


public class Main
{

    public static void main(String[] args)
    {


        int number = Integer.parseInt(JOptionPane.showInputDialog("escolha um numero de 0 a 9"));
        int random = (int) (Math.random() * 10);

        if (number == random)
        {

            JOptionPane.showMessageDialog(new Frame(), "voce acertou o numero");
            System.out.println("voce acertou o numero");
            System.out.println("o numero era  " + random);

        } else
        {

            JOptionPane.showMessageDialog(new Frame(), "voce errou o numero");
            System.out.println("voce errou  ");
            System.out.println("o numero era  " + random);
        }

    }

}

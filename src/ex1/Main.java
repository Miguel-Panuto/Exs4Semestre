package ex1;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        double price = Methods.takeNumber("Insire o valor");
        int id = (int) Methods.takeNumber("Insire o código de desconto (se tiver)");

        double fullPrice = price - Methods.calculateDiscount(id, price);

        JOptionPane.showMessageDialog(new JFrame(), "O preço do produto é R$" + fullPrice, "Preço", JOptionPane.INFORMATION_MESSAGE);
    }
}

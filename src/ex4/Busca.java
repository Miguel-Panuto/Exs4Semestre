package ex4;

import javax.swing.*;

public class Busca
{
    public static boolean buscaNumero(int numero, int[] vetor)
    {
        if (numero <= vetor.length && numero > 0)
            return true;
        else
            return false;
    }
    public static String buscaPalavra(String[] palavras)
    {
        for (int i = 0; i < palavras.length; i++)
        {
            if (palavras[i].charAt(0) == 'j' && palavras[i].charAt(1) == 'a' && palavras[i].charAt(2) == 'v' && palavras[i].charAt(3) == 'a')
            {
                return "Sim";
            }
        }
        return "Não";
    }

    public static int insercaoNumeros(String msg)
    {
        int num;
        while (true)
        {
            String s = JOptionPane.showInputDialog(msg);
            try
            {
                num = Integer.parseInt(s);
            }catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Insira um número", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            return num;
        }
    }
}

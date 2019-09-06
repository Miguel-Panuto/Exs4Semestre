package ex4;

import javax.swing.JOptionPane;

public class UsaBuscas
{
    public static void main(String[] args)
    {
        int cont = 0;
        int nums[] = new int[1000];
        while (true)
        {
            nums[cont] = Busca.insercaoNumeros("Insira algum número");
            cont++;
            if (JOptionPane.showConfirmDialog(null, "Deseja colocar mais números", " ", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
            {
                break;
            }
        }

        int numeros[] = new int[cont];
        for (int i = 0; i < cont; i++)
        {
            numeros[i] = nums[i];
        }

        int n = Busca.insercaoNumeros("Insira a posição a ser buscada");

        if (Busca.buscaNumero(n, numeros))
        {
            JOptionPane.showMessageDialog(null, "Existe algum número nessa posição", "", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            JOptionPane.showMessageDialog(null, "Não existe nenhum número nessa posição", "", JOptionPane.INFORMATION_MESSAGE);
        }
        String[] aux = new String[1000];
        cont = 0;
        while (true)
        {
            aux[cont] = JOptionPane.showInputDialog("Insira alguma string");
            cont++;
            if (JOptionPane.showConfirmDialog(null, "Deseja colocar strings", " ", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
            {
                break;
            }
        }

        String[] nomes = new String[cont];

        for (int i = 0; i < cont; i++)
        {
            nomes[i] = aux[i];
        }
        JOptionPane.showMessageDialog(null, "A palavra java, " + Busca.buscaPalavra(nomes) + " existe no array");
    }
}

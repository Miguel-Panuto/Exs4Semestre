package ex7;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame implements ActionListener
{
    JButton btnExcluir = new JButton("Excluir");

    public MyFrame()
    {
        btnExcluir.addActionListener(this);
        add(btnExcluir);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int n = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir?",  "Excluir", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION)
        {
            btnExcluir.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Arquivo excluido com sucesso", "Excluido", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args)
    {
        new MyFrame();
    }
}

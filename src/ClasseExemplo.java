import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class ClasseExemplo extends JFrame
{
    ButtonGroup btnGp = new ButtonGroup();
    JRadioButton masc = new JRadioButton("Masculino");
    JRadioButton fem = new JRadioButton("Feminino");
    JLabel lbl = new JLabel("Selecione o sexo");
    JButton btn = new JButton("Enviar");
    public ClasseExemplo()
    {
        setTitle("Exemplo");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(BorderLayout.NORTH, lbl);
        masc.setSelected(true);
        btnGp.add(masc);
        btnGp.add(fem);
        btn.addActionListener(new Acao());
        add(BorderLayout.SOUTH,btn);
        add(BorderLayout.WEST,masc);
        add(BorderLayout.EAST,fem);
        setVisible(true);
    }

    private class Acao implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String s = masc.isSelected() ? "Masculino":"Feminino";
            JOptionPane.showMessageDialog(null, "O sexo é " + s);
        }
    }
    public static void main(String[] args)
    {
        new ClasseExemplo();
    }
}

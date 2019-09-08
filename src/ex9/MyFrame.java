package ex9;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MyFrame extends JFrame implements ActionListener
{

    private JPanel panel = new JPanel(null);

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuArc = new JMenu("Arquivo");
    private JMenu menuExe = new JMenu("Exemplos");

    private JLabel lblVl = new JLabel("Valor de Venda: ");
    private JLabel lblTot = new JLabel("Valor total: ");

    private JCheckBox chIcms = new JCheckBox("ICMS (18%)");
    private JCheckBox chIpi = new JCheckBox("IPI (5%)");

    private JButton btnCal = new JButton("Calcular");
    private JButton btnLim = new JButton("Limpar");

    private JTextField txtVal = new JTextField();
    private JTextField txtIcms = new JTextField();
    private JTextField txtIpi = new JTextField();
    private JTextField txtTot = new JTextField();

    public MyFrame()
    {
        addComponentListener(new Resizing());
        initMenu();
        initComps();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComps()
    {
        panel.add(lblVl);
        panel.add(lblTot);
        panel.add(chIcms);
        panel.add(chIpi);
        panel.add(btnCal);
        panel.add(btnLim);
        panel.add(txtVal);
        panel.add(txtIcms);
        panel.add(txtIpi);
        panel.add(txtTot);

        resizeComps();
        txtIcms.setEnabled(false);
        txtIpi.setEnabled(false);
        txtTot.setEnabled(false);

        btnCal.addActionListener(this);
        btnLim.addActionListener(this);

        add(BorderLayout.CENTER, panel);
    }

    private void initMenu()
    {
        menuBar.add(menuArc);
        menuBar.add(menuExe);
        setJMenuBar(menuBar);
    }

    private void resizeComps()
    {
        Dimension comDim = new Dimension(panel.getWidth() / 2, panel.getHeight() / 9);
        int space = comDim.height / 2;
        int widthSpace = panel.getWidth() - comDim.width;
        add(BorderLayout.WEST, Box.createRigidArea(new Dimension(getSize().width / 6, getSize().height / 6)));
        add(BorderLayout.EAST, Box.createRigidArea(new Dimension(getSize().width / 6, getSize().height / 6)));
        lblVl.setBounds(0, space, comDim.width, comDim.height);
        txtVal.setBounds(widthSpace, space, comDim.width, comDim.height);
        space += 3 * comDim.height / 2;
        chIcms.setBounds(0, space, comDim.width, comDim.height);
        txtIcms.setBounds(widthSpace, space, comDim.width, comDim.height);
        space += 3 * comDim.height / 2;
        chIpi.setBounds(0, space, comDim.width, comDim.height);
        txtIpi.setBounds(widthSpace, space, comDim.width, comDim.height);
        space += 3 * comDim.height / 2;
        lblTot.setBounds(0, space, comDim.width, comDim.height);
        txtTot.setBounds(widthSpace, space, comDim.width, comDim.height);
        space += 3 * comDim.height / 2;
        btnCal.setBounds(0, space, 50 * panel.getWidth() / 101, comDim.height);
        btnLim.setBounds(panel.getWidth() - btnCal.getWidth(), space, 50 * panel.getWidth() / 101, comDim.height);
    }

    private void attVals(double val)
    {
        Double icms = 0d;
        Double ipi = 0d;
        Double valTot;
        if (chIcms.isSelected())
            icms = val * 0.18;
        if (chIpi.isSelected())
            ipi = val * 0.05;
        valTot = val + icms + ipi;
        txtIcms.setText(icms.toString());
        txtIpi.setText(ipi.toString());
        txtTot.setText(valTot.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnCal)
        {
            try
            {
                double val = Double.parseDouble(txtVal.getText());
                attVals(val);
            } catch (NumberFormatException a)
            {
                JOptionPane.showMessageDialog(null, "Insira um valor correto!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnLim)
        {
            txtVal.setText("");
            txtIcms.setText("");
            txtIpi.setText("");
            txtTot.setText("");
        }
    }

    private class Resizing extends ComponentAdapter
    {
        public void componentResized(ComponentEvent e)
        {
            resizeComps();
        }
    }

    public static void main(String[] args)
    {
        new MyFrame();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class East extends GUI{
    private JButton b;

    public East(){
        super();
    }

    public void put(JFrame f, JTextField loan, JTextField payment, JComboBox<Double> l, JTextField m, JTextField n){
        b = new JButton("calculate");
        add(b);
        f.add(this, BorderLayout.EAST);
        b.addActionListener(new CBn(loan, payment, l, m, n));
    }
}
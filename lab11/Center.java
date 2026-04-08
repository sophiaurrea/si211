import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Center extends GUI{
    private JLabel lab1;
    private JTextField text1;

    public Center(){
        super();
    }

    public void put(JFrame f){
        lab1 = new JLabel("months to payoff");
        text1 = new JTextField(10);
        text1.setEditable(false);
        add(lab1);
        add(text1);
        f.add(this, BorderLayout.CENTER);
    }

    public JTextField getPaymentField(){return text1;}
}
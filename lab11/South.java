import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class South extends GUI{
    private JLabel lab1;
    private JTextField text1;

    public South(){
        super();
    }

    public void put(JFrame f){
        lab1 = new JLabel("cost");
        text1 = new JTextField(10);
        text1.setEditable(false);
        add(lab1);
        add(text1);
        f.add(this, BorderLayout.SOUTH);
    }

    public JTextField getPaymentField(){return text1;}
}
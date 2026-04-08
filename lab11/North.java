import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class North extends GUI{
    private JLabel lab1, lab2, lab3;
    private JComboBox<Double> cbox1;
    protected JTextField text1, text2;

    public North(){
        super();
    }

    public void put(JFrame f){
        lab1 = new JLabel("loan amount");
        text1 = new JTextField(10);
        lab2 = new JLabel("interest rate");
        cbox1 = new JComboBox<Double>(new Double[] 
        {3.50, 3.75, 4.00, 4.25, 4.50, 4.75, 5.00, 
        5.25, 5.50, 5.75, 6.00, 6.25, 6.50, 6.75, 
        7.00, 7.25, 7.50});        
        lab3 = new JLabel("monthly payment");
        text2 = new JTextField(10);
        add(lab1);
        add(text1);
        add(lab2);
        add(cbox1);
        add(lab3);
        add(text2);
        f.add(this, BorderLayout.NORTH);
    }

    public JTextField getLoanField(){return text1;}
    public JTextField getPaymentField(){return text2;}
    public JComboBox<Double> getInterestBox(){return cbox1;}
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JPanel{
    public GUI(){
        super(new FlowLayout());
    }

    public void put(JFrame f){};
    public JTextField getLoanField(){return null;}
    public JTextField getPaymentField(){return null;}
    public JComboBox<Double> getInterestBox(){return null;}

    public static void main(String[] args){
        JFrame f = new JFrame();
        GUI[] A = {new North(), new South(), new Center(), new East()};
        for(int i = 0; i < A.length; i++)
            A[i].put(f);
        f.pack();
        f.setVisible(true);
    }
}
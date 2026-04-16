import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab11 extends JFrame implements ActionListener {
    private GUI[] A = {new North(), new South(), new Center() };
    private East e = new East();


    public void update() {
        Loan A = new Loan(Double.parseDouble(A[0].getLoanField().getText()), (Double)A[0].getInterestBox().getSelectedItem(), Integer.parseInt(text2.getText()));
        A.calculate();
        A[0].getLoanField().setText(String.valueOf(A.getTotal()));
        A[0].getPaymentField().setText(String.valueOf(A.getMonths()));
        A[1].getPaymentField().setText("");
        A[2].getPaymentField().setText("");
    }

    public void actionPerformed(ActionEvent e)
    {
        try{
            update();  
    }catch(Exception ex){System.out.println("Input Valid Numbers!");}
  }

    public Lab11() {
        
        for(int i = 0; i < A.length; i++)
            A[i].put(this);
        e.put(this, A[0].getLoanField(), A[0].getPaymentField(), A[0].getInterestBox(), A[1].getPaymentField(), A[2].getPaymentField());
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        Lab11 f = new Lab11();
        f.setVisible(true);
    }
}
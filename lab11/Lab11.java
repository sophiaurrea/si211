import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab11{
    public static void main(String[] args){
        JFrame f = new JFrame();
        GUI[] A = {new North(), new South(), new Center()};
        for(int i = 0; i < A.length; i++)
            A[i].put(f);
        
        East east = new East();
        east.put(f, A[0].getLoanField(), A[0].getPaymentField(), A[0].getInterestBox(), A[1].getPaymentField(), A[2].getPaymentField());

        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
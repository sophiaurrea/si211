import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CBn implements ActionListener{
  private JTextField text1, text2, m, n;
  JComboBox<Double> box;

  public CBn(JTextField t, JTextField l, JComboBox<Double> box, JTextField m, JTextField n)
  { 
    this.text1 = t;
    this.text2 = l;
    this.box = box;
    this.m = m;
    this.n = n;
  }
  public void actionPerformed(ActionEvent e)
  {
    Loan A = new Loan(Double.parseDouble(text1.getText()), (Double)box.getSelectedItem(), Integer.parseInt(text2.getText()));
    A.calculate();
    m.setText(String.valueOf(A.getTotal()));
    n.setText(String.valueOf(A.getMonths()));
    text1.setText("");
    text2.setText("");
  }
 
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class L11a
{  
  public static void main(String[] args)
  {
    JLabel label = new JLabel(" DONE ");
    label.setForeground(Color.red);

    JTextField text1 = new JTextField(10);
   
    JButton b1 = new JButton("countdown");
    b1.addActionListener(new Count(label));

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(label,BorderLayout.WEST);
    f.add(text1,BorderLayout.CENTER);
    f.add(b1,BorderLayout.EAST);
    f.pack();
    f.setVisible(true);

    if (!flag)
      while(true)
	CChange.changeColor(label);
  }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CBn extends JButton implements ActionListener, WindowListener
{
  private int  count = 0;
  public CBn(String label)
  { 
    super(label); 
    this.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    count++;
  }
  public void windowClosing(WindowEvent e)
  { 
    System.out.println("Button clicked " + count + " times.");
    System.exit(0);
  }
  public void windowOpened(WindowEvent e) {}

  public void windowClosed(WindowEvent e) {}

  public void windowIconified(WindowEvent e) {}

  public void windowDeiconified(WindowEvent e) {}

  public void windowActivated(WindowEvent e) {}

  public void windowDeactivated(WindowEvent e) {}
}
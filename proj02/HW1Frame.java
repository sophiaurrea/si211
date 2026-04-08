import javax.swing.*;
import java.awt.*;

public class HW1Frame extends JFrame
{
  public HW1Frame()
  {
    CBn b = new CBn("click me");
    add(b,BorderLayout.NORTH);
    addWindowListener(b);
    pack();
  }
}
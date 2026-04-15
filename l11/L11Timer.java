import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class L11Timer
{
    public static void main(String[] args)
    {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(" DONE ");
        JTextField text1 = new JTextField(10);
        JButton button = new JButton("countdown");

        label.setForeground(Color.red);
        label.setPrefferredSize(new Dimension(60,15));
        text1.setText("10");

        panel.add(text1);
        panel.add(label);
        panel.add(button);

        b.addActionListener(new ButtonClicked(text1, label));

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        f.pack();
        f.setVisible(true);
    }
}
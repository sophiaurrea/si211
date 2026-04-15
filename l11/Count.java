import java.awt.event.*;
import javax.swing.*;

public class Count implements ActionListener
{
    private JTextField textField;
    private JLabel label;

    public Count(JTextField textField, JLabel label)
    {
        this.textField = textField;
        this.label = label;
    }

    public void actionPerformed(ActionEvent e)
    {
        try {
            int count = Integer.parseInt(textField.getText());
            Foo foo = new Foo(count, label);
            foo.start(); // start the countdown thread
        } catch (Exception ex) {
            label.setText("ERROR");
        }
    }
}
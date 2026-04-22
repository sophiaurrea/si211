import java.awt.event.*;
import javax.swing.*;

public class StartListener implements ActionListener {
    private Foo thread;
    private JButton button;

    public StartListener(Foo t, JButton b) {
        thread = t;
        button = b;
    }

    public void actionPerformed(ActionEvent e) {
        try{
            thread.start();
        }catch(Exception e1){}
    }
}
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Foo extends Thread
{
    private int count;
    private JLabel label;

    public Foo(int count, JLabel label)
    {
        this.count = count;
        this.label = label;
    }

    public void run(){
        try{
            for(int i = count; i >= 0; i--){
                label.setText(" " + i);
                sleep(1000);
            }
            label.setText(" DONE ");
        }catch(Exception e){l.setText("ERROR");}
    }
}
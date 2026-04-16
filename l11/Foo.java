import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Foo extends Thread
{
    private int count;
    private JLabel label;
    private boolean running = false;

    public Foo(int count, JLabel label)
    {
        this.count = count;
        this.label = label;
    }

    public void run(){
        running = true;
        try{
            for(int i = count; i >= 0; i--){
                label.setText(" " + i);
                Thread.sleep(1000);
            }
            label.setText(" DONE ");
        }catch(Exception e){label.setText("ERROR");}

        running = false;
    }

    public boolean running(){
        return running;
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Foo extends Thread{
    private JLabel label;

    public Foo(JLabel label){
        this.label = label;
    }

    public void run(){
        CChange.changeColor(label);
    }
}
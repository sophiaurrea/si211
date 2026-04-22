import javax.swing.*;
import java.util.ArrayList;

public class Foo extends Thread {
    private Drawing da;

    public Foo(Drawing d) {
        da = d;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (Exception e) { }

            da.step();
            da.repaint();
        }
    }
}
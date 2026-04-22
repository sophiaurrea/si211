import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Drawing extends JComponent {
    private ArrayList<Circles> bodies;

    public Drawing( ArrayList<Circles> bodies) {
        this.bodies = bodies;
        setPreferredSize(new Dimension(800, 500));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < bodies.size(); i++) {
            Circles c = bodies.get(i);
            c.draw(g);
        }
    }

    public void step() {
        for (int i = 0; i < bodies.size(); i++) {
            bodies.get(i).update();
        }
    }
}

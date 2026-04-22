import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.Color;

public class Part1
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton button = new JButton("start");
        
        Sun sun = new Sun(300, 300);
        Circles planet = new Circles(sun, 100, 5, 0, 0.02, Color.MAGENTA);
        Circles moon = new Circles(planet, 40, 5, 0, 0.05, new Color(80, 0, 150));

        panel.add(button);
        frame.add(panel, BorderLayout.NORTH);

        ArrayList<Circles> bodies = new ArrayList<>();
        bodies.add(planet);
        bodies.add(moon);

        Drawing drawing = new Drawing(bodies);
        frame.add(drawing, BorderLayout.CENTER);

        Foo t = new Foo(drawing);
        button.addActionListener(new StartListener(t, button));

        frame.pack();
        frame.setVisible(true);
    }
}
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

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
        Circles c = new Circles(100);
        Circles c2 = new Circles(50);

        c.makeColor(255, 51, 255);
        c.setPosition(200, 200);
        c2.makeColor(155, 51, 255);
        c2.setPosition(c.getPx(), c.getPy());

        panel.add(button);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(c, BorderLayout.CENTER);
        //frame.add(c2, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
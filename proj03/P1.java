import java.util.*;
import javax.swing.*;
import java.awt.*;

public class P1
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Labels with centered text
        frame.add(new JLabel("NORTH", SwingConstants.CENTER), BorderLayout.NORTH);
        frame.add(new JLabel("SOUTH", SwingConstants.CENTER), BorderLayout.SOUTH);
        frame.add(new JLabel("EAST", SwingConstants.CENTER), BorderLayout.EAST);
        frame.add(new JLabel("WEST", SwingConstants.CENTER), BorderLayout.WEST);

        // Center tile
        Tile tile = new Tile();
        frame.add(tile, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
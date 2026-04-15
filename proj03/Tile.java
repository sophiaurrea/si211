import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tile extends JPanel implements MouseListener
{
    private boolean activated = false;

    public Tile()
    {
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        addMouseListener(this);
    }

    public void mousePressed(MouseEvent e)
    {
        // Toggle state immediately on press
        activated = !activated;
        
        // Optional extra prints
        System.out.println("  Tile pressed");

        if (activated)
            System.out.println("Tile activated");
        else
            System.out.println("Tile deactivated");
    }

    public void mouseReleased(MouseEvent e)
    {
        System.out.println("  Tile released");
    }

    // We ignore mouseClicked as instructed
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
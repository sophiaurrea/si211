import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import si211.*;

public class Tile extends JPanel implements MouseListener
{
    private boolean activated = false;
    private int row, col;
    private int kindID;

    public Tile(int row, int col, int kindID)
    {
        this.row = row;
        this.col = col;
        this.kindID = kindID;

        setPreferredSize(new Dimension(100, 100));
        setBackground(P3Tools.getSwatchColor(kindID));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        addMouseListener(this);
    }

    public void mousePressed(MouseEvent e)
    {
        // Toggle state immediately on press
        activated = !activated;
        
        // Optional extra prints
        // System.out.println("  Tile pressed");

         if (activated)
            System.out.println("Tile " + row + ", " + col + "activated");
         else
            System.out.println("Tile " + row + ", " + col + "deativated");
    }

    public void mouseReleased(MouseEvent e)
    {
        //System.out.println("  Tile released");
    }

    // We ignore mouseClicked as instructed
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
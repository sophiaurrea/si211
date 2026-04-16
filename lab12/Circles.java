import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Circles extends JComponent
{
    private int rad;
    private int lr = 20;
    private int r, g, b;
    private int x, y;

    public Circles(int rad)
    {
        super();
        setPreferredSize(new Dimension (400, 400));
        this.rad = rad;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void makeColor(int r, int g, int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, 
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(
            RenderingHints.KEY_RENDERING, 
        RenderingHints.VALUE_RENDER_QUALITY);

        g2.setColor(new Color(r, this.g, b, 255));
        g2.fill(new Ellipse2D.Double(x+rad-lr, y-lr, 2*lr, 2*lr));
        g2.setColor(new Color(r, this.g, b, 255));
        g2.draw(new Ellipse2D.Double(x-rad, y-rad, 2*rad, 2*rad));

        Toolkit.getDefaultToolkit().sync();    
    }

    public int getPx()
    {
        return x+rad-lr;
    }

    public int getPy()
    {
        return y-lr;
    }
}
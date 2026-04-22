import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.awt.geom.*;

public class Circles implements Locatable
{
    private Locatable center;
    private double orbitRadius;
    private double radius;
    private double angle;
    private double angVel;
    private Color color;

    public Circles(Locatable center, double orbitRadius, double radius, double angle, double angVel, Color color)
    {
        this.center = center;
        this.orbitRadius = orbitRadius;
        this.radius = radius;
        this.angle = angle;
        this.angVel = angVel;
        this.color = color;
    }

    public void update()
    {
        angle += angVel;
    }

    public double getX()
    {
        return center.getX() + (orbitRadius * Math.cos(angle));
    }

    public double getY()
    {
        return center.getY() + (orbitRadius * Math.sin(angle));
    }

    protected void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, 
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(
            RenderingHints.KEY_RENDERING, 
        RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, 
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(
            RenderingHints.KEY_RENDERING, 
        RenderingHints.VALUE_RENDER_QUALITY);

        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(getX()-radius, getY()-radius, 2*radius, 2*radius));
        g2.setColor(color);
        g2.draw(new Ellipse2D.Double(center.getX()-orbitRadius, center.getY()-orbitRadius, 2*orbitRadius, 2*orbitRadius));

        Toolkit.getDefaultToolkit().sync();    
    }
}
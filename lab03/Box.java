import java.util.*;

public class Box
{
  //box variables
  private double x1;
  private double x2;
  private double y1;
  private double y2;

  // constructor for Box taking a single point
  public Box(Point p)
  {
    x1 = x2 = p.get('x');
    y1 = y2 = p.get('y');
  }

  // constructor for Box taking two initial points
  public Box(Point a, Point b)
  {
    x1 = Math.min(a.get('x'), b.get('x'));
    x2 = Math.max(a.get('x'), b.get('x'));
    y1 = Math.min(a.get('y'), b.get('y'));
    y2 = Math.max(a.get('y'), b.get('y'));
  }

  // expand the bounding box (if needed) to include point p
  public void growBy(Point p)
  {
    x1 = Math.min(p.get('x'), x1);
    x2 = Math.max(p.get('x'), x2);
    y1 = Math.min(p.get('y'), y1);
    y2 = Math.max(p.get('y'), y2);
  }

  // given point p in the bounding box, return associated
  // point in the unit square (see notes); return null if
  // p is not inside the bounding box.
  public Point mapIntoUnitSquare(Point p)
  {
    if(p.get('x') - x1 < 0)
        return null;
    if(x2 - p.get('x') < 0)
        return null;
    if(p.get('y') - y1 < 0)
        return null;
    if(y2 - p.get('y') < 0)
        return null;
    Point q = new Point((p.get('x') - x1)/(x2 - x1), (p.get('y') - y1)/(y2-y1));
    return q;
  }

  // returns string representation like: 
  // 2.0 < x < 9.0, 3.0 < y < 7.0
  public String toString()
  {
    return(x1 + " < x < " + x2 + ", " + y1 + " < y < " + y2);
  }

  //main to test other methods
  public static void main(String[] args)
  {
    Point p = new Point(3,5);
    Point g = new Point(4,7);
    Box B = new Box(p,g);
    String s = B.toString();
    System.out.println(s);
    Point q = new Point(1,6);
    B.growBy(q);
    String s2 = B.toString();
    System.out.println(s2);

  }
}

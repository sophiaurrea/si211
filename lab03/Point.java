import java.util.*;

public class Point{
    //point variables
    private double x;
    private double y;
    
    //constructor that initializes points
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    //method that takes input and returns a point
    public static Point read(Scanner sc)
    {
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        Point P = new Point(x, y);
        return P;
    }

    //method that returns a point as a string
    public String toString()//instance not a static function
    {
        return(x + " " + y);
    }

    //main function to test others
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Point P = read(sc);
        System.out.println(P.toString());
        System.out.println(P.get('y'));

    }

    //returns the x or y
    public double get(char c)
    {
        if(c == 'x')
            return x;
        if(c == 'y')
            return y;
        return x;
    }
}

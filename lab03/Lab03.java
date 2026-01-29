import java.util.*;

public class Lab03
{
    //read tostring only
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        Point p = Point.read(in);
        Box b = new Box(p);
        s = in.next();
        while(!s.equals("done"))
        {
            if(s.equals("add"))
            {
                p = Point.read(in);
                b.growBy(p);
            }
            else if(s.equals("box"))
            {
                String s2 = b.toString();
                System.out.println(s2);
            }
            else if(s.equals("map"))
            {
                p = Point.read(in);
                Point q = b.mapIntoUnitSquare(p);
                if(q == null){
                    System.out.println("error");
                }else
                    System.out.println(q.toString());
            }
            else{
                System.out.println("Error! Unknown command " + '"' + s + '"' + "!");
            }
            s = in.next();
        }

    }
}
import java.util.*;

public class HW3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        Mid[] mids = new Mid[num];
        for(int i = 0; i < num; i++)
            mids[i] = createMid(in);

        int company = in.nextInt();
        for(int i = 0; i < num; i++){
            if(mids[i].company == company){
                printMid(mids[i]);
            }
        }
    }

    public static Mid createMid(Scanner in)
    {
        Mid info = new Mid();
        info.alpha = in.next();
        info.firstName = in.next();
        info.lastName = in.next();            
        info.company = in.nextInt();
        return info;
    }

    public static void printMid(Mid who)
    {
            System.out.print(who.alpha + " ");
            System.out.print(who.firstName + " ");
            System.out.print(who.lastName + " ");
            System.out.println(who.company);
    }
}
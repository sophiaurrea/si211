import java.util.*;

public class Lab1c {
    public static int fact(int k){
        int den = 1;
        for(int i = k; i > 0; i--)
            den = den*i;
        return den;
    }

    public static int prod(int n, int k){
        int num = 1;
        for(int i = (n-k+1); i <= n; i++)
            num = num*i;
        return num;
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String name = args[0];
        for(int i = 1; i < args.length-2; i++)
            name = name + " " + args[i];
        int n = Integer.parseInt(args[args.length-2]);
        int k = Integer.parseInt(args[args.length-1]);
        System.out.println("The two ints were " + n + " and " + k);

        int num = prod(n, k);
        System.out.println("numerator = " + num);

        int den = fact(k);
        System.out.println("denominator = " + den);

        System.out.println("odds = 1 in " + num/den + " = " + (double)den/num);
        System.out.println("Goodbye " + name + ".");
    }
}
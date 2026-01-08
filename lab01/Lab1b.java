import java.util.*;

public class Lab1b {
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
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        System.out.print("Please input an integer ");
        int n = in.nextInt();
        System.out.print("Please input a second integer ");
        int k = in.nextInt();
        System.out.println("The two ints were " + n + " and " + k);

        int num = prod(n, k);
        System.out.println("numerator = " + num);

        int den = fact(k);
        System.out.println("denominator = " + den);

        System.out.println("odds = 1 in " + num/den + " = " + (double)den/num);
        System.out.println("Goodbye " + name + ".");
    }
}
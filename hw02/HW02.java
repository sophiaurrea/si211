import java.util.*;

public class HW02 {
    public static int maxLength(String[] A){
        int max = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i].length() > max)
                max = A[i].length();
        }
        return max;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String[] words = new String[n];
        for(int i = 0; i < n; i++)
            words[i] = in.next();

        int max = maxLength(words);
        for(int i = 0; i < max; i++){
            for(int j = 0; j < n; j++){
                if(i >= words[j].length())
                    System.out.print("  ");
                else
                    System.out.print(words[j].charAt(i) + " ");
            }
            System.out.println();
        }
    }
}
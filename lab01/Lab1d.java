import java.util.*;

public class Lab1d {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Random rand = new Random(System.currentTimeMillis());
        int num = rand.nextInt(11);

        String[] insults = {"Not quite... ", "Are you serious?? ", "You're messing with me. ", "How are you so dumb? ", "Theres no hope. ", "Just give up. "};
        int turn = 1;
        System.out.print("Guess a number beween 0 and 10: ");
        int guess = in.nextInt();

        while(guess != num)
        {
            System.out.print(insults[turn-1] + "Guess again: ");
            guess = in.nextInt();
            turn++;
        }

        System.out.println("Right after " + turn + " guesses!");
    }
}
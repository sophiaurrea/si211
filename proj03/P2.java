import java.util.*;
import javax.swing.*;
import java.awt.*;
import si211.*;

public class P2
{
    public static void main(String[] args){
        int seed;
        
        if(args.length == 0){
            seed = (int)(Math.random() * 10000);
        }else{
            seed = Integer.parseInt(args[0]);            
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        Board board = new Board(seed);
        frame.add(board);

        frame.setSize(600,600);
        frame.setVisible(true);
    }
}
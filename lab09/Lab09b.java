import java.util.*;
import java.io.*;

public class Lab09b{
    public static void main(String[] args){
        Scanner sc = null;
        boolean verbose = false;
        boolean fileInpt = false;

        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-v")){
                verbose = true;
            }else{
                try{
                    sc = new Scanner(new FileReader(args[i]));
                    fileInpt = true;
                }catch(IOException e){
                    System.out.println("File '" + args[i] + "' could not be opened; switching input to standard in.");
                }
            }
        }

        if(sc == null)
            sc = new Scanner(System.in);

        ModQueue Q = new ModQueue();

        while(1 == 1){
            if(!fileInpt){
                System.out.print("> ");
            }

            String cmd;
            try{
                cmd = sc.next();
            }catch(NoSuchElementException e){
                break;
            }

            if(cmd.equals("quit")){
                break;
            }else if(cmd.equals("clearto")){
                try{
                    String x = sc.next();
                    try{
                        Q.dequeue(x);
                    }catch(QueueException e){
                        if(verbose){
                            System.out.println("String '" + x + "' not found!");
                        }
                    }
                }catch(NoSuchElementException e){
                    System.out.println("Unexpected end of input.");
                    return;
                }
            }else if(cmd.equals("add")){
                try{
                    Q.enqueue(sc.next());
                }catch(NoSuchElementException e){
                    System.out.println("Unexpected end of input.");
                    return;
                }
            }else if(cmd.equals("dump")){
                try{
                    System.out.println(Q.dump());
                }catch(QueueException e){}
            }else{
                if(verbose){
                    System.out.println("Unknown command '" + cmd + "'.");
                }else{
                    continue;
                }
            }
        }
    }
}
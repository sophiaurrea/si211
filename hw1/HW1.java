import java.util.*;
import java.io.*;

public class HW1
{
  public static void main(String[] args)
  {
    LineNumberReader lnr = null;

    try{
        if(args.length > 0){
            try{
                lnr = new LineNumberReader(new FileReader(args[0]));
            }catch(FileNotFoundException e){
                System.out.println("File \"" + args[0] + "\" not found");
                return;
            }
        }else{
            lnr = new LineNumberReader(new InputStreamReader(System.in));
        }

        Scanner sc = new Scanner(lnr);
        System.out.println(Mystery.compute(sc));
    }catch(Exception e){
        System.out.println("Error " + e.getMessage() + " at line " + lnr.getLineNumber());
    }
  }
}
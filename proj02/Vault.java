import java.util.*;

public class Vault{
    public static void main(String[] args)throws Exception{
        Boolean add;
        String fname;
        Scanner in = new Scanner(System.in);
        ArrayList<User> A1 = null;
        
        try{
            if(args[0].equals("-au")){
                add = true;
                fname = args[1];
            }else{
                add = false;
                fname = args[0];
            }

            A1 = User.readIn(fname);
        }catch(Exception e){System.out.println("usage: java Vault [-au] <filename>"); return;}
        
        if(add){
            User.add(A1, fname);
            return;
        }

        System.out.print("username: ");
        String name = System.console().readLine();
        System.out.print("password: ");
        char[] password = System.console().readPassword();
            
        int i = 0;
        while(i < A1.size()){
            if(A1.get(i).userMatch(name))
            {
                if(A1.get(i).match(password)){
                    System.out.println("Access granted!"); break;}
            }
            if(i == (A1.size() - 1)){
                System.out.println("Access denied!"); return;}    
            i++;
        }
        
        System.out.print("> ");
        String cmd = in.next();

        while(!cmd.equals("quit"))
        {

            if(cmd.equals("labels"))
                A1.get(i).labels(password, null);
            else if(cmd.equals("get")){
                String label = in.next();
                A1.get(i).labels(password, label);
            }else if(cmd.equals("quit")){
                return;
            }else{
                System.out.println("Unknown command '" + cmd + "'.");
            }

            System.out.print("> ");
            cmd = in.next();
        }

        return;

        // for(int i = 0; i < A1.size(); i++)
        //     A1.get(i).print();
    }
}
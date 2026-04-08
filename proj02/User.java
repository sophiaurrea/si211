import java.util.*;
import java.io.*;

public class User{
    private String name;
    private String algorithm;
    private String hash;
    private ArrayList<UserData> data = new ArrayList<UserData>();
    private ArrayList<Encryptor> E = new ArrayList<Encryptor>(Arrays.asList(new Clear(), new Caesar(), new Vigenere(), new Padcut(), new SC(), new SV()));

    public static ArrayList<User> readIn(String name){
        Scanner sc = null;
        try { sc = new Scanner(new FileReader(name));}
        catch(IOException e) {System.out.println("Error! File '" + name + "' could not be opened."); System.exit(1);}

        ArrayList<User> A1 = new ArrayList<User>();
        try{
            while(sc.hasNext()){
                String type = sc.next();
                if(type.equals("data")){
                    String user = sc.next();
                    for(int i = 0; i < A1.size(); i++){
                        if(A1.get(i).name.equals(user)){
                            UserData U = new UserData(sc.next(), sc.next());
                            A1.get(i).data.add(U);
                        }
                    }
                }else{
                    User S = new User();
                    S.name = sc.next();
                    S.algorithm = sc.next();
                    S.hash = sc.next();
                    A1.add(S);
                }
            }
        }catch(Exception e){System.out.println("Error! File '" + name + "' improperly formatted."); System.exit(-1);}
        
        if(sc!=null) sc.close();
        return A1;
    }

    public void labels(char[] password, String label){
        Encryptor enc = encrypt(this.algorithm, this.E, "Encryption");
        if(enc == null)
            return;
        for(int i = 0; i < data.size(); i++){
            data.get(i).printLabel(password, label);
        }
    }

    public static void add(ArrayList<User> A1, String fname){
        User A = new User();
        System.out.print("username: ");
        A.name = System.console().readLine();
        System.out.print("password: ");
        char[] password = System.console().readPassword();
        System.out.print("Hash algorithm: ");
        A.algorithm = System.console().readLine();
        
        for(int i = 0; i < A1.size(); i++){
            if(A1.get(i).name.equals(A.name)){
                System.out.println("Error! Username '" + A.name + "' already in use.");
                System.exit(-1);
            }
        }

        Encryptor enc = encrypt(A.algorithm, A.E, "Hash");
        String key = null;
        try{
            enc.init(password);
            key = new String(password);
            key = enc.encrypt(key);
        }catch(MyException e){System.out.println("Error! Invalid symbol '" + e.getBadChar() + "' in password."); System.exit(-1);}
        A.hash = key;
        
        A1.add(A);

        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new File(fname));
        }catch(FileNotFoundException fnfe){fnfe.printStackTrace();}

        for(int i = 0; i < A1.size(); i++)
            A1.get(i).print(pw);
        if(pw!=null)pw.close();
    }

    public static Encryptor encrypt(String algorithm, ArrayList<Encryptor> E, String type){
        Encryptor enc = null;

        try{
            int i = 0;
            while(i < E.size() && !E.get(i).getAlgName().equals(algorithm))
                i++;
            enc = E.get(i);
        }catch(Exception e){
            System.out.println("Error! " + type + " algorithm '" + algorithm + "' not supported."); 
            if(type.equals("Hash"))
                System.exit(1);
            else   
                return null;
        }
        return enc;
    }

    public boolean userMatch(String name){
        return this.name.equals(name);
    }

    public void print(PrintWriter pw){
        pw.println("user " + name + " " + algorithm + " " + hash);
    }

    public boolean match(char[] key)throws Exception{
        Encryptor enc = encrypt(this.algorithm, this.E, "Hash");
        String password = null;
        try{
            enc.init(key);
            password = new String(key);
        }catch(Exception e){System.out.println("Access denied!"); System.exit(-1);}
        return enc.encrypt(password).equals(hash);
    }
}
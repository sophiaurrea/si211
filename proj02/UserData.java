import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class UserData{
    private String algorithm;
    private String hash;
    private ArrayList<Encryptor> E = new ArrayList<Encryptor>(Arrays.asList(new Clear(), new Caesar(), new Vigenere()));

    public UserData(String algorithm, String hash){
        this.algorithm = algorithm;
        this.hash = hash;
    }

    public void printLabel(char[] password, String label){
        Encryptor enc = User.encrypt(this.algorithm, this.E, "Encryption");
        String[] labelParts = null;
        String labelContents = null;
        String decoded = null;
        try{
            enc.init(password);
            decoded = enc.decrypt(hash);
            labelParts = decoded.split("_");
            labelContents = String.join("_", java.util.Arrays.copyOfRange(labelParts, 1, labelParts.length));
        }catch(Exception e){System.exit(-1);}
        if(labelParts.length == 1){
            System.out.println("Error! corrupted entry '" + hash + "' in vault file."); 
            return;
        }
        if(label == null){
            System.out.println(labelParts[0]);
            return;
        }else{
            if(label.equals(labelParts[0]))
                System.out.println(labelContents);
        }
    }
}
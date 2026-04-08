import java.util.*;

public class TestHashers {
    public static void main(String[] args)throws Throwable{
    // Create ArrayList of all supported encryptors
    ArrayList<Encryptor> E = new ArrayList<Encryptor>();
    E.add(new Padcut());
    E.add(new SC());
    E.add(new SV());

    // Get alg,psw,msg from user
    System.out.print("algorithm: ");
    String hashalg = System.console().readLine();
    System.out.print("password : ");
    char[] password = System.console().readPassword();
    String plain = new String(password);
    
    // Find encryptor (throw exception if not found)
    int i = 0;
    while(i < E.size() && !E.get(i).getAlgName().equals(hashalg))
      i++;
    if (i == E.size())
      throw new Exception("Unknown algorithm '"+hashalg+"'.");
    Encryptor enc = E.get(i);

    // Encrypt, decrypt print sumamry of results
    enc.init(password);
    String ciphertext = enc.encrypt(plain);
    System.out.println("password read : " + plain);
    System.out.println("hash computed : " + ciphertext);
    }
}

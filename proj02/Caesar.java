import java.util.*;

public class Caesar implements Encryptor{
  private int shift;
  public String getAlgName() { return "caesar"; }
  public void   init(char[] key)throws MyException{
    String password = new String(key);
    test(password);

    int sum = 18;
    for(int i = 0; i < key.length; i++){
        sum += key[i];
        sum -= 42;
    }
    shift = 42 + (sum % 81);
  }

  public String encrypt(String plain) throws MyException{ 
    test(plain);
    String result = "";
    for(int i = 0; i < plain.length(); i++){
      result += encryptAid(shift, plain.charAt(i));
    }
    return result; 
  }

  public String decrypt(String cipher){ 
    String result = "";
    for(int i = 0; i < cipher.length(); i++){
      int k = shift - 42;
      int c = cipher.charAt(i) - 42;
      result += decryptAid(k, c);
    }
    return result; 
  }

  public static char decryptAid(int k, int c){
    int p = (c + (81 - k)) % 81;
    return (char)(p + 42);
  }

  public static char encryptAid(int i, int j){
    int k = i - 42;
    int p = j - 42;
    int c = (p + k)%81;
    return (char)(42 + c);
  }

  public static void test(String plain) throws MyException{
    for(int l = 0; l < plain.length(); l++){
      if(plain.charAt(l) < '*' || plain.charAt(l) > 'z' )
            throw new MyException("error " + plain.charAt(l) + " not allowed in plaintext", plain.charAt(l));
    }
  }
}


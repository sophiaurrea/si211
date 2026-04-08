
import java.util.*;

public class SV implements Encryptor {
  private char[] shift;
  public String getAlgName(){ return "shift+vigenere"; }
  public void   init(char[] key)throws MyException{ 
    String password = new String(key);
    Caesar.test(password);
    shift = key; 
  }
  
  public String encrypt(String plain)throws MyException{
    String result = "GO_NAVY_2018^mid";
    String x = "";
    for(int i = 0; i < 16; i++){
        char c = result.charAt(i);
        int k = c % 16;

        x = "";
        for(int j = 0; j < result.length(); j++){
            x += result.charAt((j + k) % result.length());
        }
        
        Vigenere enc = new Vigenere();
        enc.init(shift);
        x = enc.encrypt(x);
        result = x;
    }
    return x;
  }
  public String decrypt(String cipher){
    String result = "";
    int n = shift.length;
    for(int i = 0; i < cipher.length(); i++){
        int k = shift[i%n];
        int c = cipher.charAt(i);
        result += Caesar.decryptAid(k, c);
    }
    return result;
  }
}
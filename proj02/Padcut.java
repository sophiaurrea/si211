
import java.util.*;

public class Padcut implements Encryptor {
  private char[] shift;
  public String getAlgName(){ return "padcut"; }
  public void   init(char[] key)throws MyException{ 
    String password = new String(key);
    Caesar.test(password);
    shift = key;
  }
  
  public String encrypt(String plain){
    String result = "";
    for(int i = 0; i < 16; i++){
        if(i >= plain.length())
            result += 'x';
        else
            result += plain.charAt(i);
    }
    return result;
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
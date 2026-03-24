import java.util.*;

public class Caesar implements Encryptor{
  private int shift;
  public String getAlgName() { return "caesar"; }
  public void   init(char[] key){
    int sum = 18;
    for(int i = 0; i < key.length; i++){
        sum += key[i];
        sum -= 42;
    }
    shift = 42 + (sum % 81);
  }
  public String encrypt(String plain) { 
    String result = "";
    for(int i = 0; i < plain.length(); i++){
      int k = shift - 42;
      int p = plain.charAt(i) - 42;
      int c = (p + k)%81;
      result += (char)(42 + c);
    }
    return result; 
  }
  public String decrypt(String cipher){ 
    String result = "";
    for(int i = 0; i < cipher.length(); i++){
      int k = shift - 42;
      int c = cipher.charAt(i) - 42;
      int p = (c + (81 - k)) % 81;
      result += (char)(p + 42);
    }
    return result; 
  }
}
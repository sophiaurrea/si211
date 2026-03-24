
import java.util.*;

public class Vigenere implements Encryptor {
  private char[] shift;
  public String getAlgName(){ return "vigenere"; }
  public void   init(char[] key){ shift = key; }
  public String encrypt(String plain){
    String result = "";
    int n = shift.length;
    for(int i = 0; i < plain.length(); i++){
        int k = plain.charAt(i) - 42;
        int p = shift[i%n] - 42;
        int c = (p + k) % 81;
        result += (char)(42 + c);
    }
    return result;
  }
  public String decrypt(String cipher){
    String result = "";
    int n = shift.length;
    for(int i = 0; i < cipher.length(); i++){
        int k = shift[i%n];
        int c = cipher.charAt(i);
        int p = (c + (81 - k)) % 81;
        result += (char)(42 + p);
    }
    return result;
  }
}
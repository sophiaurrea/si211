// Encryptor providing the clear algorithm, which is to
// not change the plaintext at all.
public class Clear implements Encryptor {
  public String getAlgName() { return "clear"; }
  public void   init(char[] key)throws MyException {
    String password = new String(key);
    Caesar.test(password);
  }
  public String encrypt(String plain)throws MyException { 
    Caesar.test(plain);
    return plain; 
  }
  public String decrypt(String cipher){ return cipher; }
}
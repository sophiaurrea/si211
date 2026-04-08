// interface for objects that provide
// encryption functionality.
public interface Encryptor {
  public String getAlgName();
  public void   init(char[] key)throws MyException;
  public String encrypt(String plain) throws MyException;
  public String decrypt(String cipher);
}
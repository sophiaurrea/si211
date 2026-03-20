public class Caesar implements Encryptor{
  private int shift;
  public String getAlgName() { return "Caesar"; }
  public void   init(char[] key){
    int sum = 18;
    try{
      for(int i = 0; i < key.length; i++){
          if(key[i] < '*' || key[i] > 'z' )
            throw new Exception("error " + key[i] + " not allowed in key");
          sum += key[i];
          sum -= 42;
      }
      shift = 42 + (sum % 81);
      System.out.println(shift);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
  public String encrypt(String plain) { return plain; }
  public String decrypt(String cipher){ return cipher; }
}
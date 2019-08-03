package ugsbo.com.buchhaltung;

import java.security.MessageDigest;

public class Block {


  int data;
  int kontostand;
  Block vorher;
  
  String ownHash;
  String previousHash;
  
  
  //erste Block
  public Block(int data) {
    this.data = data;
    ownHash = createNewHash(Integer.toString(data));
    
    kontostand = this.data;
    
    this.vorher = null;
    this.previousHash = null;
  }

  //Alle anderen Blöcke
  public Block(int data, Block vorher, String previousHash, int konto) {
    this.data = data;
    ownHash = createNewHash(Integer.toString(data)+previousHash);
    
    kontostand = konto + this.data;
    
    this.vorher = vorher;
    this.previousHash = previousHash;
  }
  
  private String createNewHash(String input) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");            
      //Applies sha256 to our input, 
      byte[] hash = digest.digest(input.getBytes("UTF-8"));           
      StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
      for (int i = 0; i < hash.length; i++) {
          String hex = Integer.toHexString(0xff & hash[i]);
          if(hex.length() == 1) hexString.append('0');
          hexString.append(hex);
      }
      return hexString.toString();
  }
  catch(Exception e) {
      throw new RuntimeException(e);
  }
  }
  
  public int getKontostand() {
    return kontostand;
  }
  
  public Block getVorher() {
    return vorher;
  }
  
  public String getHash() {
    return ownHash;
  }
}

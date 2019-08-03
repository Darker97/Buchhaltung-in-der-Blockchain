package ugsbo.com.buchhaltung;

import com.google.gson.*;

public class Blockchain {
 
  Block Workingobjekt;
  
  
  public Blockchain() {
    Workingobjekt = new Block(0);
  }


  public void add(int eingabe) {
    Block newWorkingobjekt = new Block(eingabe, Workingobjekt, Workingobjekt.getHash(), Workingobjekt.getKontostand());
    
    Workingobjekt = newWorkingobjekt;
  }


  public int kontostand() {
    return Workingobjekt.getKontostand();
  }
  
  public String toString() {
    String JSON = new GsonBuilder().setPrettyPrinting().create().toJson(Workingobjekt);      
    return JSON;
  }

  
}

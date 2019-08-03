package ugsbo.com.buchhaltung;

public class Auswertung {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Blockchain Work = new Blockchain();
    Work.add(50);
    Work.add(-20);
    
    System.out.println(Work.kontostand());
    System.out.print(Work.toString());
  }

}

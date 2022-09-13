package bwl.main.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSV {

  /**
   * @param args
   */
    public static void main(String[] args) {
      Scanner scan = null;
      String allesZusammen = "";
      try {
          scan = new Scanner(new File("c:/0_ml/0_ml_muell/brent-daily_csv.csv"));
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      while (scan.hasNext()) {
         String textstueck = scan.nextLine();
         //System.out.println(textstueck);
         allesZusammen = allesZusammen + textstueck + "\n";
      }
      scan.close();

      
      // Fertig dann steht alle in diesem String
      System.out.println(allesZusammen);
      System.out.println("==================================================");
//      if(allesZusammen.indexOf("WKN")>0){
        //String a = allesZusammen.substring(0,36);
//        System.out.println("WKN gibts");
//        int positionVonWKNBegriff = allesZusammen.indexOf("WKN");
//        System.out.println(positionVonWKNBegriff);
//        String gefundeneWKN = allesZusammen.substring(positionVonWKNBegriff + 4, positionVonWKNBegriff + 10);
//        System.out.println(gefundeneWKN);
        
      //}

      int erstesKomma = allesZusammen.indexOf(",");
      System.out.println(erstesKomma);
      String datum = allesZusammen.substring(0,erstesKomma);
      System.out.println(datum);
      int zeilenEnde = allesZusammen.indexOf("\n");
      System.out.println(zeilenEnde);
      
      String kurs1 = allesZusammen.substring(erstesKomma+1,zeilenEnde);
      System.out.println(kurs1);
      
      int zweitesKomma = allesZusammen.indexOf(",", zeilenEnde);
      System.out.println(zweitesKomma);
      
    


  }

}


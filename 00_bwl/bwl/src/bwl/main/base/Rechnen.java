package bwl.main.base;

import com.ml.utils.Trivials;


public class Rechnen {

  public static void main(String[] args) {
    
    // Hier startet alles
    System.out.println("Hallo ich bin in dieser Zeile angekommen !");
    
    // Dies ist eine einzeilige Kommentarzeile
    
    /* Dies ist eine lange Kommentarzeile
     * ueber mehrere Zeilen
     * Zeilen
     * Zeilen
     */
    
    // So bekomme ich eine Zahl in eine Variable
    int a;
    System.out.print("Bitte gib eine Zahl ein und druecke Return: ");
    a = Trivials.readInt();
    
    // So gebe ich den Wert der Variablen a aus
    System.out.println("Die Variable a enthaelt jetzt den Wert a=" + a);
    
    // So bekomme ich eine weitere Zahl in eine Variable
    int b;
    System.out.print("Bitte gib eine weitere Zahl ein und druecke Return: ");
    b = Trivials.readInt();
    
    // So gebe ich den Wert der Variablen b aus
    System.out.println("Die Variable b enthaelt jetzt den Wert b=" + b);
    
    // So addiere ich die Zahlen
    int s = a + b;

    // So gebe ich den Wert der Variablen s aus
    System.out.println("Die Variable s enthaelt jetzt den Wert s=" + s);
    
    // So multiplizere ich die Zahlen
    int m = a * b;

    // So gebe ich den Wert der Variablen s aus
    System.out.println("Die Variable m enthaelt jetzt den Wert m=" + m);


    // So dividiere ich die Zahl a durch b
    int d = a / b;

    // So gebe ich den Wert der Variablen d aus
    System.out.println("Wenn die Division von " + a + " geteilt durch " +
                        + b + " moeglich war dann ist nun d=" + d);
    
    // So erhalte ich den Rest der Divison von Zahl a durch b (z.B. 5/2 = 2 Rest 1 )
    int mo = a%b;

    // So gebe ich den Wert der Variablen mo aus
    System.out.println("Rest der Division von " + a + " geteilt durch " +
                        + b + " ist " + mo); 
  }
}


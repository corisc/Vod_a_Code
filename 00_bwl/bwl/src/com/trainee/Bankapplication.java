package com.trainee;

public class Bankapplication {
  
  public static void main(String[] args) {
    
    // =========================== G U I =============================
    new GUIbankApp();
    
    
    // ========================== CONSOLE =============================
    // Bank anlegen
    Bank dresdner = new Bank("Dresdner Bank", "78260000");
    Bank raiffeisen = new Bank("Raiffeisen Volksbank", "65464546");
    
    // Kunden anlegen
    Kunde kunde1 = new Kunde("Hanz", "Meier", 0);
    Kunde kunde2 = new Kunde("Frank", "Mueller", 1);
    Kunde kunde3 = new Kunde("Volkan", "Erdogan", 2);
    
    // Kunden zu Banken zuordnen
    dresdner.neuenKundenHinzufuegen(kunde1);
    dresdner.neuenKundenHinzufuegen(kunde2);
    
    raiffeisen.neuenKundenHinzufuegen(kunde3);
    
    // Konten der Kunden anlegen
    Konto kontoVonKunde1 = new Konto("Girokonto", 9876543l);
    kunde1.addKonto(kontoVonKunde1);
    
    Konto hanzm2 = new Konto("Referenzkonto", 4654654757l);
    kunde1.addKonto(hanzm2);
    
    Konto kontoVolkan = new Konto("Girokonto", 56756776667l);
    kunde3.addKonto(kontoVolkan);
    
    System.out.println("\n\t\t***********************\n");
    
    // Name aendern
    kunde1.nameAendern("Haenschen", "Mayer");    
    System.out.println("");
    
    // Geld einzahlen + abheben
    System.out.println("\n********* Geldgeschaefte der Kunden *********");
    kontoVonKunde1.geldEinzahlen(200.0);
    kontoVonKunde1.geldEinzahlen(3.0);    
    
    kontoVonKunde1.geldAbheben(50.0);
    kontoVonKunde1.geldAbheben(155.0);
    
    kontoVolkan.geldEinzahlen(1000000.0);
    System.out.println("********************************************\n\n");

    kunde1.kontrollausgabe();
    kunde2.kontrollausgabe();
    kunde3.kontrollausgabe();
    //System.out.println(kunde1);       // "com.trainee.Kunde@a62fc3"
    
    // Vermoegen der Banken berechnen
    dresdner.berechneGesamtguthaben();
    raiffeisen.berechneGesamtguthaben();
    
    boolean kreditOK = raiffeisen.kreditBeantragen(500000.0);     // Kreditantrag stellen
    if (kreditOK == true)
    {
      kontoVonKunde1.kreditBeantragen(500000.0, "Hauskauf", 250.0, 180);
      System.out.println("");
      kontoVonKunde1.kreditTeiltilgung();
      kontoVonKunde1.kreditEinmalZuzahlung(300.0);
      kontoVonKunde1.kreditTeiltilgung();
    }
    
    dresdner.berechneGesamtkredite();
    raiffeisen.berechneGesamtkredite();

  }// Ende main
}// Ende Bankapplication



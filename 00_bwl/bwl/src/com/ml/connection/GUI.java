package com.ml.connection;

import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class GUI {
  
  Fenster eingabe = new Fenster ("Customer Entrance System");
  Ueberschrift ue = new Ueberschrift("Customer Entrance System");
  Text textID = new Text("Kunden ID: ");
  Text textName = new Text("Kundenname: ");
  
  EingabeFeld eingabeID = new EingabeFeld();
  EingabeFeld eingabeName = new EingabeFeld();
  
  Schalter eingabeSchalter = new Schalter("Eingabe");
  
  
  
  public GUI() {
      
      eingabe.zeige(ue, 50,50);
      eingabe.zeige(textID, 50, 150);
      eingabe.zeige(eingabeID, 150,150, 200);
      eingabe.zeige(textName, 50,200);
      eingabe.zeige(eingabeName, 150,200, 200);
      eingabe.zeige(eingabeSchalter, 50, 300, 200);
      
}
  
  public void eingeben() {
    eingabeSchalter.warteAufEingabe();
    eingabe.schliessen();
      
  }
  public String getname () {
    String name = eingabeName.getText();
    return name;
  }
  public String getID () {
    String id = eingabeID.getText();
    return id;
  }
}
 

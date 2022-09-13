package com.ml.connection;

import java.util.LinkedList;
import com.ml.utils.Helfer;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class Start {

  public static void main(String[] args) {
    
    boolean weiter;
    
    LinkedList<String> linkedlist = new LinkedList<String>();
    
    
    while (weiter = true) {
    
    GUI gui = new GUI();
    gui.eingeben();
    
    
    String name = gui.getname();
    String id = gui.getID();
    
    String customerinfos = new String (
    "<KUNDE>"                                       +"\n"+
    "<NAME>" +name+   "</NAME>"                     +"\n"+
    "<ID>"   +id+     "</ID>"                       +"\n"+
    "</KUNDE>"                                      +"\n");
    
    linkedlist.add(customerinfos);
    
    String info1 = linkedlist.toString();
    String info = (info1.substring(1, info1.length()-1));
    
    String infoXML = new String (
    "<CUSTOMERENTRANCESYSTEM>"                       +"\n"+
    info                                             +
    "</CUSTOMERENTRANCESYSTEM>"                      +"\n");
    
    MultithreadedServer server = new MultithreadedServer(5555, infoXML);
    new Thread(server).start();
    
    Fenster f = new Fenster ("Erfolgreich !");
    
    Ueberschrift ue = new Ueberschrift ("Eintrag Erfolgreich ");
    Text t = new Text ("Wie moechten sie fortfahren ?");
    
    Schalter s2 = new Schalter("Neuer Eintrag");
    
    f.zeige(ue, 50,50);
    f.zeige(t, 50, 150);
    f.zeige(s2, 50, 200, 200);
    

    
    while (true) {
      if (s2.wurdeGedrueckt()) {
      f.loeschen();
      server.stop();
      break;
      }
      }
      }
    }
    }
    
  
  
  

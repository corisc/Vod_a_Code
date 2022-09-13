package com.framework;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import com.conf.BasicEnvConfiguration;
import com.ml.datenbank.Datenbank;
import com.ml.views.Bild;
import com.ml.views.DBErgebnisFenster;
import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.TextFeld;

public class SQLFenster {

  private boolean test = false;
  private Datenbank datenbank;
  private EingabeFeld e1;
  
  public SQLFenster(boolean test) {
    this.test = test;
    this.ausfuehren();
  }
  
  public SQLFenster() {
    this(false);    
  }
  
  private void ausfuehren(){
    // Anfangsbild
    SplashScreen splash = new SplashScreen(500, "SQL", "sql_splash.jpg", 319, 158);
    splash.anzeigen();
    
    // Banner setzen auf 50,50
    Fenster w = new Fenster("Aufruf", 1600, 800);
    Bild b = new Bild("sql_splash.jpg");
    w.zeige(b, 50, 20);
    
    Text t1 = new Text("Datenbank Befehl: ");
    w.zeige(t1, 50, 190);
    
    e1 = new EingabeFeld(new Font("Arial", Font.BOLD, 22));
    w.zeige(e1, 50, 210, 1580);

    this.datenbank = new Datenbank();

    Schalter s1 = new Schalter("SQL schicken");
    w.zeige(s1, 580, 300, 200);

    JButton button = new JButton();    
    button.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        String[] text = datenbank.textAllerTabellenInDatenbank();
        datenbank.zeigeDatenbank();
      }
    });

    JButton button4 = new JButton();    
    button4.setText("SQL+Ergebnis Fenster");
    button4.setBounds(580, 370, 200, 20);
    button4.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        System.out.println("t: " + e1.getText());
        String text = e1.getText() + "\n\n" +  datenbank.abfragen(e1.getText());
        e1.setText("");
        DBErgebnisFenster aus = new DBErgebnisFenster("Ergebnis");
        aus.ausgeben(text);
      }
    });
    w.getPanel().add(button4);

    w.getPanel().repaint();

    button.setText("Zeige DB");
    button.setBounds(50, 430, 150, 20);
    w.getPanel().add(button);

    JButton button2 = new JButton();    
    button2.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        datenbank.loescheAlleTabellen();
      }
    });

    button2.setText("loesche DB");
    button2.setBounds(580, 430, 150, 20);
    w.getPanel().add(button2);

    w.getPanel().repaint();

    while(true){
      if(test){
        e1.setText("ALTER TABLE TABELLE add REIHE2 char(50)");
      }
      else{
        e1.setText("");
      }
      
      s1.warteAufEingabe();
      String message = datenbank.verarbeiteSQLBefehl(e1.getText());
      w.removeTextFeld();
      TextFeld f = new TextFeld(1000, 180, "");
      f.setText(message);
      w.zeige(f, 50, 240);
    }
  }

  public static void main(String[] args) {
    if(args.length == 1){
      String parameter = args[0];
      parameter.trim();
      System.out.println("file: " + parameter);
      BasicEnvConfiguration.HELPER_ARBEITSVERZEICHNIS_OVERWRITE = args[0];
    }
    SQLFenster sqlFenster = new SQLFenster(false);
    


  }

}


package bwl.main.vortrag;

import com.ml.connection.WebServer;
import com.ml.datenbank.Datenbank;
import com.ml.views.AusgabeFenster;
import com.ml.views.Fenster;
import com.ml.views.Text;
import com.ml.views.ZeichenFenster;

public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // Middleware
    Person p1 = new Person("Superman", "Ken");
    Person p2 = new Person("Superwoman", "Jane");
    Person p3 = new Person("Batman", "Bruce");
    Person p4 = new Person("Robin", "John");
    Person p5 = new Person("Catwoman", "Jeany");
    
    ErfassungsFenster erfassungsFenster = new ErfassungsFenster();
    
    // View 1
    ZeichenFenster zf = new ZeichenFenster("Daten");
    zf.textZeichnen("Facebook Verwaltung", 10, 700, 30, "blau");
    zf.linieZeichnen(10, 680, 400, 680, 10, "blau");
    
    zf.textZeichnen(p1.nickName, 10, 600, 16, "rot");
    zf.textZeichnen(p1.realNachname, 10, 580, 12);
    
    zf.textZeichnen(p2.nickName, 10, 560, 16, "rot");
    zf.textZeichnen(p2.realNachname, 10, 540, 12);
    
    zf.textZeichnen(p3.nickName, 10, 520, 16, "rot");
    zf.textZeichnen(p3.realNachname, 10, 500, 12);

    zf.textZeichnen(p4.nickName, 10, 480, 16, "rot");
    zf.textZeichnen(p4.realNachname, 10, 460, 12);

    zf.textZeichnen(p5.nickName, 10, 440, 16, "rot");
    zf.textZeichnen(p5.realNachname, 10, 420, 12);
    
  }

}




// Backend
//Datenbank d = new Datenbank();
//String nickname1 = d.abfragen("select person.nickname from person where person.id = 1");
//String realname1 = d.abfragen("select person.realname from person where person.id = 1");
//nickname1 = d.zeileAbfragen("person", "nickname", 0);
//realname1 = d.zeileAbfragen("person", "realname", 0);
//Person p6 = new Person(nickname1, realname1);
//AusgabeFenster aus = new AusgabeFenster();
//aus.ausgeben("Erzeugt aus DB: " + p6.nickName + " " + p6.realNachname);


package bwl.main.vortrag;


import com.ml.connection.WebServer;
import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class ErfassungsFenster {

  public ErfassungsFenster() {
    // Banner setzen auf 50,50
    Fenster w = new Fenster("Eingabe");
    Bild b = new Bild("facebook.png");
    w.zeige(b, 50, 20);

    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Erfassung");
    w.zeige(u, 350, 50);

    Text t0 = new Text("Name");
    w.zeige(t0, 50, 140);

    EingabeFeld e0 = new EingabeFeld();
    w.zeige(e0, 50, 160, 200);

    Text t1 = new Text("Nickname");
    w.zeige(t1, 50, 200);

    EingabeFeld e1 = new EingabeFeld();
    w.zeige(e1, 50, 220, 200);

    Schalter s1 = new Schalter("Erfassen");
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();
    w.loeschen();

    String name = e0.getText();
    String nickname = e1.getText();

    Person p = new Person(name, nickname);

    Facebook.nimmEineWeiterePersonauf(p);

    if (name.length() == 0) {
      // View 2
      String htmlSeite = new String("");
      htmlSeite = htmlSeite + "<body> \n";
      htmlSeite = htmlSeite + "<html> \n";

      for (int t = 0; t < Facebook.wievielePersonenSindDrin(); t++) {
        htmlSeite = htmlSeite + "<h1> \n";
        htmlSeite = htmlSeite + 
        Facebook.holePersonNachReihenfolge(t).nickName + " \n";
        htmlSeite = htmlSeite + "</h1> \n";

        htmlSeite = htmlSeite + "<h2> \n";
        htmlSeite = htmlSeite + 
        Facebook.holePersonNachReihenfolge(t).realNachname + " \n";
        htmlSeite = htmlSeite + "</h2> \n";
      }

      htmlSeite = htmlSeite + "</body> \n";
      htmlSeite = htmlSeite + "</html> \n";

      System.out.println(""+htmlSeite);

      WebServer we = new WebServer(htmlSeite);
      we.start();
    }
    else{
      new ErfassungsFenster();
    }

  }

}

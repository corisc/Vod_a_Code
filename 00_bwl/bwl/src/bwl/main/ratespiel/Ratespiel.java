package bwl.main.ratespiel;

import com.ml.connection.Anfrage;
import com.ml.views.Fenster;
import com.ml.utils.XMLAnalyse;
import com.ml.views.Bild;
import com.ml.views.EingabeFeld;
import com.ml.views.Schalter;
import com.ml.views.SplashScreen;
import com.ml.views.Text;
import com.ml.views.TextFeld;
import com.ml.views.Ueberschrift;

public class Ratespiel {

  // Einstiegspunkt
  public static void main(String[] args) {
    // Banner setzen auf 50,50
    Fenster w = new Fenster("Abruf");
    Bild b = new Bild("banner.jpg");
    w.zeige(b, 50, 50);
    
    // Ueberschrift
    Ueberschrift u = new Ueberschrift("Wird wird Millionaer");
    w.zeige(u, 50, 200);
    
    Text t1 = new Text("Wieviel Gold wurde bisher insgesamt von der Menschheit gefoerdert: ");
    w.zeige(t1, 50, 300);
    
    Schalter s1 = new Schalter("Ein Wuerfel mit Kante 1km");
    w.zeige(s1, 450, 380, 200);

    Schalter s2 = new Schalter("Ein Wuerfel mit Kante 20m");
    w.zeige(s2, 210, 380, 200);

    Schalter s3 = new Schalter("Ein Wuerfel mit Kante 20km");
    w.zeige(s3, 450, 420, 200);

    Schalter s4 = new Schalter("Ein Wuerfel mit Kante 3km");
    w.zeige(s4, 210, 420, 200);
    
  }

}



package bwl.main.send;

import com.ml.utils.SMSSender;
import com.ml.views.SplashScreen;

import e.com.ml.views.copy.Button;
import e.com.ml.views.copy.GUIWindow;
import e.com.ml.views.copy.Headline;
import e.com.ml.views.copy.InputField;
import e.com.ml.views.copy.Picture;
import e.com.ml.views.copy.Text;

public class Program {
  public static void main(String[] args) {

    // Anfangsbild
    SplashScreen splash = new SplashScreen(1000, "BWL Applikation - 2009",
        "start_bild.jpg");
    splash.present();

    // Banner setzen auf 50,50
    GUIWindow w = new GUIWindow("Sender");
    Picture p = new Picture("banner.jpg");
    w.present(p, 50, 50);

    // Ueberschrift
    Headline h = new Headline("Sende Programm");
    w.present(h, 50, 200);

    Text t1 = new Text("Geben sie ein Nummer ein");
    w.present(t1, 50, 300);

    InputField e1 = new InputField();
    w.present(e1, 50, 320, 200);

    Text t2 = new Text("Geben Sie einen Text ein");
    w.present(t2, 50, 360);

    InputField e2 = new InputField();
    w.present(e2, 50, 380, 200);

    Button s1 = new Button("Senden");
    w.present(s1, 450, 380, 200);

    s1.awaitClick();
    w.erase();

    String number = e1.getText();
    String message = e2.getText();

    SMSSender m1 = new SMSSender();
    m1.sende(number, message);

  }
}

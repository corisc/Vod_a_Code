package bwl.darstellung;

import com.ml.views.Bild;
import com.ml.views.ComboBox;
import com.ml.views.DropDown;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;
import com.ml.views.Ueberschrift;

public class ComboBoxAngewendet {

  public static void main(String[] args) {

    // Das Drumherum
    Fenster w = new Fenster("SAP'chen");

    Ueberschrift u = new Ueberschrift("Uebungsuebersicht");
    w.zeige(u, 50, 50);

    Text t1 = new Text("Waehlen Sie den Vorgang:");
    w.zeige(t1, 50, 150);

    // Erste Combo Box
    ComboBox comboBox = new ComboBox("Personalliste", "Gehaltsliste");
    w.zeige(comboBox, 50, 200);

    // Zweite Combo Box
    ComboBox comboBox1 = new ComboBox("A", "B", "C", "D");
    w.zeige(comboBox1, 50, 300);

    Schalter s1 = new Schalter("Auswahlen getroffen");
    w.zeige(s1, 450, 380, 200);

    s1.warteAufEingabe();

    int entscheidung = comboBox.zahlDerEntscheidung();
    int entscheidung1 = comboBox1.zahlDerEntscheidung();

    System.out.println("" + entscheidung);
    System.out.println("" + entscheidung1);

    if (entscheidung == 1) {
      System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + entscheidung);

      w.schliessen();

      Fenster w1 = new Fenster("Neues Fenster");
      Ueberschrift u1 = new Ueberschrift("Neues Fenster");
      w1.zeige(u1, 50, 50);
    }

    if (entscheidung == 2) {
      System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + entscheidung1);
    }

  }
}



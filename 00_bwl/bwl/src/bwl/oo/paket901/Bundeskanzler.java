package bwl.oo.paket901;

import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;

public class Bundeskanzler extends Regierungsmitarbeiter{
    private double amtszeit;

    public Bundeskanzler(String name, String vorname, Partei partei, double amtszeit){
        super(name, vorname, partei);
        this.amtszeit = amtszeit;
    }

    public double getAmtszeit() {
        return amtszeit;
    }

    public void setAmtszeit(double amtszeit) {
        this.amtszeit = amtszeit;
    }

    public static Bundeskanzler createBundeskanzler(){
        Fenster form = new Fenster("Bundeskanzler erstellen", 1300, 1000);
        Text name = new Text("Name");
        Text vorname = new Text("Vorname");
        Text party = new Text("Partei");
        Text amtszeit = new Text("Amtszeit");
        EingabeFeld vornameE = new EingabeFeld("Vorname");
        EingabeFeld nameE = new EingabeFeld("Name");
        EingabeFeld ParteiE = new EingabeFeld("Partei");
        EingabeFeld amtszeitE = new EingabeFeld("Amtszeit");
        Schalter eingabe = new Schalter("Erstellen");
        form.zeige(vorname,200,300);
        form.zeige(vornameE,200,330, 900);
        form.zeige(name,200,400);
        form.zeige(nameE,200,430, 900);
        form.zeige(party,200,500);
        form.zeige(ParteiE,200,530, 900);
        form.zeige(amtszeit,200,600);
        form.zeige(amtszeitE,200,630, 900);
        form.zeige(eingabe,200,700, 900);
        form.anzeigen();
        eingabe.warteAufEingabe();
        Partei p = new Partei(ParteiE.getText());
        Bundeskanzler bk = new Bundeskanzler(vornameE.getText(), nameE.getText(),p,amtszeitE.getWert());
        p.setMitglied(bk);
        form.schliessen();
        return bk;

    }
}

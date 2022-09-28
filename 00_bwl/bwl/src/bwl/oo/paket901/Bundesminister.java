package bwl.oo.paket901;

import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;

public class Bundesminister extends Regierungsmitarbeiter{
    private String aufgabengebiet;
    private Ministerium ministerium;

    public Bundesminister(String name, String vorname, Partei partei, String aufgabengebiet, Ministerium ministerium){
        super(name,vorname, partei);
        this.aufgabengebiet = aufgabengebiet;
        this.ministerium = ministerium;
    }

    public String getAufgabengebiet() {
        return aufgabengebiet;
    }

    public void setAufgabengebiet(String aufgabengebiet) {
        this.aufgabengebiet = aufgabengebiet;
    }

    public Ministerium getMinisterium() {
        return ministerium;
    }

    public void setMinisterium(Ministerium ministerium) {
        this.ministerium = ministerium;
    }

   /* public Bundesminister createBM(){
        Bundesminister BM;
        /*Fenster formular = new Fenster("Bundesminister erstellen", 1300, 1000);
        EingabeFeld vorname = new EingabeFeld("Vorname");
        EingabeFeld Name = new EingabeFeld("Name");
        EingabeFeld Aufgabengebiet = new EingabeFeld("Aufgabengebiet");
        EingabeFeld vorname = new EingabeFeld("vorname");
        EingabeFeld vorname = new EingabeFeld("vorname");

        String*/
        //return BM;
    //}
}



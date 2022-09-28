package bwl.oo.paket3;

import java.util.ArrayList;

public class XFachschaft {
    private static ArrayList<XFachschaft> listeF = new ArrayList<>();
    private String name;
    public String getName() {return name;}
    public String getInfo(){return name;}
    public static ArrayList<XFachschaft> getListeF() {return listeF;}
    public XFachschaft getAusListeF(int fIndex) {return listeF.get(fIndex);}
    public void setInListeF(XFachschaft  fObjekt) {listeF.add(fObjekt);}

    public XFachschaft (){
        //Fenster
        XFenster ff = new XFenster("Fachschaft");
        //Überschrift
        ff.erstelleText("Erstelle neue Fachschaft", 100,50,200);
        //Eingabefelder
        ff.erstelleBeschriftetesEingabefeld("Name",100,80,100);
        //Speichern
        ff.erstelleSchalter("Speichern",100,300,200);
        name =ff.getEingabeFeldSpeicherListe(0).getText();
        ff.loeschen();
    }
}















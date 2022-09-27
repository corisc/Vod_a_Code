package bwl.oo.paket3;

import java.util.ArrayList;

public class XVorlesung {
    private static ArrayList<XVorlesung> listeV = new ArrayList<>();
    private String name;
    private String datum;
    public String getName() {return name;}
    public String getDatum() {return datum;}
    public String getInfo(){return name +" "+ datum;}
    public static ArrayList<XVorlesung> getListeV() {return listeV;}
    public XVorlesung getAusListeV(int vIndex) {return listeV.get(vIndex);}
    public void setInListeV(XVorlesung  vObjekt) {listeV.add(vObjekt);}
    public XVorlesung (){
        //Fenster
        XFenster ff = new XFenster("Vorlesung");
        //Überschrift
        ff.erstelleText("Erstelle neue Vorlesung", 100,50,200);
        //Eingabefelder
        ff.erstelleBeschriftetesEingabefeld("Name",100,80,100);
        ff.erstelleBeschriftetesEingabefeld("Datum",100,120,100);
        //Speichern
        ff.erstelleSchalter("Speichern",100,300,200);
        name =ff.getEingabeFeldSpeicherListe(0).getText();
        datum =ff.getEingabeFeldSpeicherListe(1).getText();
        ff.loeschen();
    }
}


















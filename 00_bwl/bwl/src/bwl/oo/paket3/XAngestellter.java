package bwl.oo.paket3;

import java.util.ArrayList;

public class XAngestellter {
    private static ArrayList<XAngestellter> listeA = new ArrayList<>();
    private String vorname;
    private String nachname;
    private int alter;
    public String getVorname() {return vorname;}
    public String getNachname() {return nachname;}
    public int getAlter() {return alter;}
    public String getInfo (){return vorname +" "+ nachname +" "+ alter;}
    public static ArrayList<XAngestellter> getListeA()
    {return listeA;}
    public void setInListeA(XAngestellter  aObjekt) {listeA.add(aObjekt);}
    public XAngestellter (){
        //Fenster
        XFenster ff = new XFenster("Angestellter");
        //Überschrift
        ff.erstelleText("Erstelle neuen Angestellten", 100,50,200);
        //Eingabefelder
        ff.erstelleBeschriftetesEingabefeld("Vorname",100,80,100);
        ff.erstelleBeschriftetesEingabefeld("Nachname",100,120,100);
        ff.erstelleBeschriftetesEingabefeld("Alter",100,160,100);
        //Speichern
        ff.erstelleSchalter("Speichern",100,300,200);
        vorname =ff.getEingabeFeldSpeicherListe(0).getText();
        nachname =ff.getEingabeFeldSpeicherListe(1).getText();
        alter =ff.getEingabeFeldSpeicherListe(2).getGanzahligenWert();
        ff.loeschen();
    }
}













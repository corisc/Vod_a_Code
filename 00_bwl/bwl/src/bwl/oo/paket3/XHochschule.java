package bwl.oo.paket3;

import java.util.ArrayList;

public class XHochschule{
    private static ArrayList<XHochschule> listeH = new ArrayList<>();
    private String name;
    private String adresse;

    public String getName() {return name;}
    public String getAdresse() {
        return adresse;
    }
    public String getInfo(){return name +" "+ adresse;}
    public static ArrayList<XHochschule> getListeH() {return listeH;}
    public void setInListeH(XHochschule  objektHochschule)
    {listeH.add(objektHochschule);}
    public XHochschule (){
        //HochschuleErstellen
        //Fenster
        XFenster ff = new XFenster("Hochschule");
        //Überschrift
        ff.erstelleText("Erstelle neue Hochschule", 100,50,200);
        //Eingabefelder
        ff.erstelleBeschriftetesEingabefeld("Name",100,80,100);
        ff.erstelleBeschriftetesEingabefeld("Adresse",100,120,100);
        //Speichern
        ff.erstelleSchalter("Speichern",100,300,200);
        name =ff.getEingabeFeldSpeicherListe(0).getText();
        adresse =ff.getEingabeFeldSpeicherListe(1).getText();
        ff.loeschen();
    }
}










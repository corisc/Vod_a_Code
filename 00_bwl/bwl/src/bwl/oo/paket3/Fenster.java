package bwl.oo.paket3;

import com.ml.views.*;

import java.util.ArrayList;

public class Fenster {
    private ArrayList<EingabeFeld> eingabeFeldSpeicherListe = new ArrayList<>();
    private com.ml.views.Fenster fenster;
    public com.ml.views.Fenster getFenster(){return fenster;}
    public Fenster(String ueberschrift){
        fenster =new com.ml.views.Fenster(ueberschrift,1000,500);
    }
    public void erstelleText(String text, int x, int y, int laenge){
    Text t1 = new Text(text);
        fenster.zeige(t1,x,y,laenge);
    }
    public void erstelleBeschriftetesEingabefeld(String beschriftung,int x,int y, int laenge){
        erstelleText(beschriftung, x, y, laenge);
        EingabeFeld e1 = new EingabeFeld();
        fenster.zeige(e1,x,y+20,laenge);
        this. eingabeFeldSpeicherListe.add(e1);
    }
    public EingabeFeld getEingabeFeldSpeicherListe(int index){
        return  eingabeFeldSpeicherListe.get(index);
    }
    public void erstelleSchalter(String name, int x, int y, int laenge){
        Schalter s = new Schalter(name);
        fenster.zeige(s,x,y,laenge);
            s.warteAufEingabe();
    }
    public void schliessen(){
        fenster.schliessen();
    }
    //Fenster
    public Fenster(Klassen objekt){
            fenster = new com.ml.views.Fenster();
        //Überschrift
            erstelleText("Erstelle "+objekt.klasse, 100,50,200);
        //Eingabefelder
            int y=80;
            for (String x1:objekt.instanzVariablenBeschriftung){
                    erstelleBeschriftetesEingabefeld(x1,100,y,100);
                    y+=40;
                }
        //Speichern
            erstelleSchalter("Speichern",100,300,200);
            for (EingabeFeld x2:eingabeFeldSpeicherListe){
                objekt.instanzVariableWert.add(x2.getText());
            }
            schliessen();
    }
}




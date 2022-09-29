package bwl.oo.paket3;

import com.ml.views.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class XFenster {
    private ArrayList<EingabeFeld> eingabeFeldSpeicherListe = new ArrayList<>();
    private Fenster fenster;
    public Fenster getFenster(){return fenster;}
    public XFenster(String ueberschrift){
        fenster =new Fenster(ueberschrift,1000,500);
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
    public XFenster(XKlassen objekt){
            fenster = new Fenster();
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




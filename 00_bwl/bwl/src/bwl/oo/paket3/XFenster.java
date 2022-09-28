package bwl.oo.paket3;

import com.ml.views.*;

import java.util.ArrayList;

public class XFenster {
    private ArrayList<EingabeFeld> eingabeFeldSpeicherListe = new ArrayList<>();
    private Fenster f;
    public Fenster getF(){return f;}
    public XFenster(String ueberschrift){
        f=new Fenster(ueberschrift,1000,500);
    }
    public void erstelleText(String text, int x, int y, int laenge){
    Text t1 = new Text(text);
        f.zeige(t1,x,y,laenge);
    }
    public void erstelleBeschriftetesEingabefeld(String beschriftung,int x,int y, int laenge){
        erstelleText(beschriftung, x, y, laenge);
        EingabeFeld e1 = new EingabeFeld();
        f.zeige(e1,x,y+20,laenge);
        this. eingabeFeldSpeicherListe.add(e1);
    }
    public EingabeFeld getEingabeFeldSpeicherListe(int index){
        return  eingabeFeldSpeicherListe.get(index);
    }
    public void erstelleSchalter(String name, int x, int y, int laenge){
        Schalter s = new Schalter(name);
        f.zeige(s,x,y,laenge);
            s.warteAufEingabe();
    }
    public void loeschen(){
        f.loeschen();
    }

}




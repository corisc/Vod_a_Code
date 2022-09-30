package bwl.oo.paket3;

import bwl.oo.paket8.Konto;
import com.ml.views.DropDown;

import java.util.ArrayList;

public class Game {
    ArrayList<Hochschule> hochschuleListe = new ArrayList<>();
    ArrayList<Angestellter> angestellterListe = new ArrayList<>();
    ArrayList<Vorlesung> vorlesungListe = new ArrayList<>();
    ArrayList<Fachschaft> fachschaftListe = new ArrayList<>();
    ArrayList<Verbindung> verbindungListe = new ArrayList<>();
    ArrayList<Konto> kontoListe = new ArrayList<>();
    public void start (){
        while(true){
            Fenster ff = new Fenster("Hochschulen");
            com.ml.views.Fenster f=ff.getFenster();

            DropDown dd1 =new DropDown();
            dd1.eintragHinzufuegen("Bitte Auswählen");
            for (Hochschule x:hochschuleListe){
                dd1.eintragHinzufuegen(x.getInfo());}

            DropDown dd2 =new DropDown();
            dd2.eintragHinzufuegen("Bitte Auswählen");
            dd2.eintragHinzufuegen("Hinzufügen");
            dd2.eintragHinzufuegen("Löschen");
            dd2.eintragHinzufuegen("Manage");

            f.zeige(dd1,10,10);
            f.zeige(dd2,300,10);
            ff.erstelleSchalter("Bestätige",500,10,100);
            f.schliessen();

            if (dd2.zahlDerEntscheidung()==2){ //Hinzufügen
                Hochschule h = new Hochschule();
                ff = new Fenster(h);
                hochschuleListe.add(h);
            } else if (dd1.zahlDerEntscheidung()==1 || dd2.zahlDerEntscheidung()==1){
                f.schliessen();
                ff = new Fenster("Error");
                ff.erstelleText("Bitte wähle beide Felder aus",10,10,300);
                ff.erstelleSchalter("Weiter",10,30,100);
            } else if (dd2.zahlDerEntscheidung()==3) { //Löschen
                hochschuleListe.remove(dd1.zahlDerEntscheidung()-2);
            } else if (dd2.zahlDerEntscheidung()==4) { //Details
                Hochschule h = hochschuleListe.get(dd1.zahlDerEntscheidung()-2);
                main(h);
                break;
            }
        }
    }
    public void main(Hochschule h){
        int hIndex = hochschuleListe.indexOf(h);
        while(true){
            Fenster ff = new Fenster(h.getInfo()+" - Main");
            com.ml.views.Fenster f=ff.getFenster();

            DropDown dd01=new DropDown();
            dd01.eintragHinzufuegen("Auswahl: Objekt");
            dd01.eintragHinzufuegen("Zurück");//2
            dd01.eintragHinzufuegen("Fachschaft");//3
            dd01.eintragHinzufuegen("Angestellter");//4
            dd01.eintragHinzufuegen("Vorlesung");//5
            dd01.eintragHinzufuegen("Konto");//6

            f.zeige(dd01,10,10);

            DropDown dd02=new DropDown();
            dd02.eintragHinzufuegen("Auswahl: Aktion");
            dd02.eintragHinzufuegen("Zurück");//2
            dd02.eintragHinzufuegen("Einsehen");//3
            dd02.eintragHinzufuegen("Erstellen");//4

            f.zeige(dd02,310,10);

            ff.erstelleText("Verbinde",10,110,100);
            DropDown ddf=new DropDown();
            ddf.eintragHinzufuegen("Auswahl: Fachschaft");
            for (Fachschaft x:fachschaftListe){
                ddf.eintragHinzufuegen(x.getInfo());}
            f.zeige(ddf,10,130);

            DropDown dda=new DropDown();
            dda.eintragHinzufuegen("Auswahl: Angestellter");
            for (Angestellter x:angestellterListe){
                dda.eintragHinzufuegen(x.getInfo());}
            f.zeige(dda,10,170);

            DropDown ddv=new DropDown();
            ddv.eintragHinzufuegen("Auswahl: Vorlesung");
            for (Vorlesung x:vorlesungListe){
                ddv.eintragHinzufuegen(x.getInfo());}
            f.zeige(ddv,10,210);

            DropDown ddk=new DropDown();
            ddk.eintragHinzufuegen("Auswahl: Konto");
            for (Konto x:kontoListe){
                ddk.eintragHinzufuegen(x.getInfo());}
            f.zeige(ddk,10,250);

            ff.erstelleSchalter("Bestätige",10,290,100);
            f.schliessen();

            //Zurück
            if (dd01.zahlDerEntscheidung()==2 || dd02.zahlDerEntscheidung()==2){
                start();
                break;
            }

            //Erstelle
            if (dd01.zahlDerEntscheidung()==3 && dd02.zahlDerEntscheidung()==4){
                f.schliessen();
                Fachschaft fachschaft = new Fachschaft();
                ff = new Fenster(fachschaft);
                fachschaftListe.add(fachschaft);
                Verbindung verbindung = new Verbindung("f", hIndex,
                        fachschaftListe.indexOf(fachschaft));
                verbindungListe.add(verbindung);
            }
            if (dd01.zahlDerEntscheidung()==4 && dd02.zahlDerEntscheidung()==4){
                f.schliessen();
                Angestellter angestellter = new Angestellter();
                ff = new Fenster(angestellter);
                angestellterListe.add(angestellter);
                Verbindung verbindung = new Verbindung("a", hIndex,
                        angestellterListe.indexOf(angestellter));
                verbindungListe.add(verbindung);
            }
            if (dd01.zahlDerEntscheidung()==5 && dd02.zahlDerEntscheidung()==4){
                f.schliessen();
                Vorlesung vorlesung = new Vorlesung();
                ff = new Fenster(vorlesung);
                vorlesungListe.add(vorlesung);
                Verbindung verbindung = new Verbindung("a", hIndex,
                        vorlesungListe.indexOf(vorlesung));
                verbindungListe.add(verbindung);
            }
            if (dd01.zahlDerEntscheidung()==6 && dd02.zahlDerEntscheidung()==4){
                f.schliessen();
                Konto konto = new Konto();
                ff = new Fenster(konto);
                kontoListe.add(konto);
                Verbindung verbindung = new Verbindung("k", hIndex,
                        kontoListe.indexOf(konto));
                verbindungListe.add(verbindung);
            }
            //Verbinde
            if (ddv.zahlDerEntscheidung()!=1||ddf.zahlDerEntscheidung()!=1||dda.zahlDerEntscheidung()!=1
            ||ddk.zahlDerEntscheidung()!=1) {
                f.schliessen();
                Verbindung x = new Verbindung(
                        hochschuleListe.indexOf(h),
                        ddf.zahlDerEntscheidung(),
                        dda.zahlDerEntscheidung(),
                        ddv.zahlDerEntscheidung(),
                        ddk.zahlDerEntscheidung());
                verbindungListe.add(x);
            }
            if (dd02.zahlDerEntscheidung()==3){//Einsehen
                einsicht(h ,dd01.zahlDerEntscheidung());
                break;
            }
        }
    }
//                dd01.eintragHinzufuegen("Fachschaft");//3
//            dd01.eintragHinzufuegen("Angestellter");//4
//            dd01.eintragHinzufuegen("Vorlesung");//5
//            dd01.eintragHinzufuegen("Konto");//6
//            dd01.eintragHinzufuegen("Verbindung");//7
    public void einsicht(Hochschule h , int z){ //z=zahlDerEntscheidung
        int hIndex = hochschuleListe.indexOf(h);
        Fenster ff =new Fenster("Einsicht");
        int x=10; int y=40; int laenge=700;
        if (z==3){
            ff.erstelleText("Fachschaften Liste",10,10,300);
            for (Verbindung vv : verbindungListe){
                if (vv.getH()==hIndex && vv.getA()==-1 && vv.getF()!=-1 && vv.getV()==-1){
                    ff.erstelleText(fachschaftListe.get(vv.getF()).getInfo(),x,y,laenge);y=y+20;
                }}}
        if (z==4){
            ff.erstelleText("Angestellten Liste",10,10,300);
            for (Verbindung vv : verbindungListe){
                if (vv.getH()==hIndex &&
                        vv.getA()!=-1 && vv.getF()==-1 && vv.getV()==-1 && vv.getK()==-1){
                    ff.erstelleText(angestellterListe.get(vv.getA()).getInfo(),x,y,laenge);y=y+20;
                }}}
        if (z==5){
            ff.erstelleText("Vorlesungen Liste",10,10,300);
            for (Verbindung vv : verbindungListe){
                if (vv.getH()==hIndex &&
                        vv.getA()==-1 && vv.getF()==-1 && vv.getV()!=-1&& vv.getK()==-1){
                    ff.erstelleText(vorlesungListe.get(vv.getV()).getInfo(),x,y,laenge);y=y+20;
                }}}
        if (z==6){
            ff.erstelleText("Konto Liste",10,10,300);
            for (Verbindung vv : verbindungListe){
                if (vv.getH()==hIndex &&
                        vv.getA()==-1 && vv.getF()==-1 && vv.getV()!=-1&& vv.getK()!=-1){
                    ff.erstelleText(kontoListe.get(vv.getK()).getInfo(),x,y,laenge);y=y+20;
                }}}

        if (z==7){
            ff.erstelleText("Verbindung Liste",10,10,300);
            for (Verbindung vv : verbindungListe){
                if (vv.getH()==hIndex){
                    ff.erstelleText(angestellterListe.
                            get(vv.getA()).getInfo(),10,30,laenge);y=y+80;
                    ff.erstelleText(fachschaftListe.
                            get(vv.getF()).getInfo(),10,50,laenge);y=y+80;
                    ff.erstelleText(vorlesungListe.
                            get(vv.getV()).getInfo(),10,70,laenge);y=y+80;
                    ff.erstelleText(kontoListe.
                            get(vv.getV()).getInfo(),10,70,laenge);y=y+80;}}}

        ff.erstelleSchalter("Zurück",200,10,200);
        ff.schliessen();
        main(h);
    }
    public static void main(String[] args) {
        Game g = new Game();
        g.start();

    }
}






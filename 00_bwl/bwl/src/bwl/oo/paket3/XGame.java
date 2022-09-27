package bwl.oo.paket3;

import com.ml.views.DropDown;
import com.ml.views.Fenster;

public class XGame {

    public void start (){
        while(true){
            XFenster ff = new XFenster("Hochschulen");
            Fenster f=ff.getF();

            DropDown dd1 =new DropDown();
            dd1.eintragHinzufuegen("Bitte Auswählen");
            for (XHochschule x:XHochschule.getListeH()){
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
                XHochschule h = new XHochschule();
                h.setInListeH(h);
            } else if (dd1.zahlDerEntscheidung()==1 || dd2.zahlDerEntscheidung()==1){
                f.schliessen();
                ff = new XFenster("Error");
                ff.erstelleText("Bitte wähle beide Felder aus",10,10,300);
                ff.erstelleSchalter("Weiter",10,30,100);
            } else if (dd2.zahlDerEntscheidung()==3) { //Löschen
                XHochschule.getListeH().remove(dd1.zahlDerEntscheidung()-2);
            } else if (dd2.zahlDerEntscheidung()==4) { //Details
                XHochschule h = XHochschule.getListeH().get(dd1.zahlDerEntscheidung()-2);
                main(h);
                break;
            }
        }
    }
    public void main(XHochschule h){
        int hIndex = XHochschule.getListeH().indexOf(h);
        while(true){
            XFenster ff = new XFenster(h.getInfo()+" - Main");
            Fenster f=ff.getF();

            DropDown dd1=new DropDown();
            dd1.eintragHinzufuegen("Auswahl: Einsicht");//1
            dd1.eintragHinzufuegen("Angestellter");//2
            dd1.eintragHinzufuegen("Vorlesung");//3
            dd1.eintragHinzufuegen("Fachschaft");//4
            dd1.eintragHinzufuegen("AF");//5
            dd1.eintragHinzufuegen("FA");//6
            dd1.eintragHinzufuegen("VFA");//7
            dd1.eintragHinzufuegen("VAF");//8
            dd1.eintragHinzufuegen("AVF");//9
            dd1.eintragHinzufuegen("AFV");//10
            dd1.eintragHinzufuegen("FAV");//11
            dd1.eintragHinzufuegen("FVA");//12
            dd1.eintragHinzufuegen("Zurück zu Hochschule");//13
            f.zeige(dd1,10,10);

            DropDown dd2=new DropDown();
            dd2.eintragHinzufuegen("Auswahl: Erstellung");//1
            dd2.eintragHinzufuegen("Fachschaft");//2
            dd2.eintragHinzufuegen("Angestellter");//3
            dd2.eintragHinzufuegen("Vorlesung");//4
            dd2.eintragHinzufuegen("Zurück zu Hochschule");//5
            f.zeige(dd2,310,10);

            ff.erstelleText("Verbinde",10,110,100);
            DropDown ddf=new DropDown();
            ddf.eintragHinzufuegen("Auswahl: Fachschaft");
            for (XFachschaft x:XFachschaft.getListeF()){
                ddf.eintragHinzufuegen(x.getInfo());}
            f.zeige(ddf,10,130);

            DropDown dda=new DropDown();
            dda.eintragHinzufuegen("Auswahl: Angestellter");
            for (XAngestellter x:XAngestellter.getListeA()){
                dda.eintragHinzufuegen(x.getInfo());}
            f.zeige(dda,10,170);

            DropDown ddv=new DropDown();
            ddv.eintragHinzufuegen("Auswahl: Vorlesung");
            for (XVorlesung x:XVorlesung.getListeV()){
                ddv.eintragHinzufuegen(x.getInfo());}
            f.zeige(ddv,10,210);

            ff.erstelleSchalter("Bestätige",10,250,100);
            f.schliessen();

            //Zurück
            if (dd1.zahlDerEntscheidung()==13 || dd2.zahlDerEntscheidung()==5){
                start();
                break;
            }

            //Erstelle
            if (dd2.zahlDerEntscheidung()==2){
                f.schliessen();
                XFachschaft x = new XFachschaft();
                x.setInListeF(x);
                XVerbindung y = new XVerbindung("f", hIndex,
                        XFachschaft.getListeF().indexOf(x));
                y.setInVerbindungsListe(y);
            }
            if (dd2.zahlDerEntscheidung()==3){
                f.schliessen();
                XAngestellter x = new XAngestellter();
                x.setInListeA(x);
                XVerbindung y = new XVerbindung("a", hIndex,
                        XAngestellter.getListeA().indexOf(x));
                y.setInVerbindungsListe(y);
            }
            if (dd2.zahlDerEntscheidung()==4){
                f.schliessen();
                XVorlesung x = new XVorlesung();
                x.setInListeV(x);
                XVerbindung y = new XVerbindung("v", hIndex,
                        XVorlesung.getListeV().indexOf(x));
                y.setInVerbindungsListe(y);
            }
            //Verbinde
            if ((ddv.zahlDerEntscheidung()!=1&&ddf.zahlDerEntscheidung()!=1&&dda.zahlDerEntscheidung()==1)||
                    (ddv.zahlDerEntscheidung()!=1 && dda.zahlDerEntscheidung()!=1&&ddf.zahlDerEntscheidung()==1)||
                    (ddf.zahlDerEntscheidung()!=1&&ddv.zahlDerEntscheidung()==1 && dda.zahlDerEntscheidung()==1)||
                    (dda.zahlDerEntscheidung()!=1&&ddv.zahlDerEntscheidung()==1 && ddf.zahlDerEntscheidung()==1))
            {f.schliessen();
                ff = new XFenster("Error");
                ff.erstelleText(
                        "Unter 'Verbinde' bitte triff eine Wahl zu allen Dropdowns" +
                                " oder allen außer Vorlesung",10,10,1000);
                ff.erstelleSchalter("Weiter",10,30,100);
                ff.loeschen();
            } else {
                XVerbindung x = new XVerbindung(
                        XHochschule.getListeH().indexOf(h),
                        ddf.zahlDerEntscheidung(),
                        dda.zahlDerEntscheidung(),
                        ddv.zahlDerEntscheidung());
                x.setInVerbindungsListe(x);
            }
            if (dd1.zahlDerEntscheidung()!=1){//Einsicht
                einsicht(h ,dd1.zahlDerEntscheidung());
                break;
            }
        }
    }
    public void einsicht(XHochschule h , int z){ //z=zahlDerEntscheidung
        int hIndex = XHochschule.getListeH().indexOf(h);
        XFenster ff =new XFenster("Einsicht");
        int x=10; int y=40; int laenge=700;
        if (z==2){
            ff.erstelleText("Angestellten Liste",10,10,300);
            for (XVerbindung vv : XVerbindung.getVerbindungsListe()){
                if (vv.getH()==hIndex &&
                        vv.getA()!=-1 &&
                        vv.getF()==-1 &&
                        vv.getV()==-1){
                    //Am besten erstmal den vorcode schreiben:
                    //Nachschauen in ListX
                    //vergleichen mit listeY
                    //Wenn ja dann Z ausgeben
                    //Die mehtoden so nennen und aneinander reihen
                    //so wir der code sicher und verständlich
                    ff.erstelleText(
                            XAngestellter.getListeA().
                            get(vv.getA()).
                            getInfo(),x,y,laenge);
                    y=y+20;
                }}}
        if (z==3){
            ff.erstelleText("Vorlesungen Liste",10,10,300);
            for (XVerbindung vv : XVerbindung.getVerbindungsListe()){
                if (vv.getH()==hIndex && vv.getA()==-1 && vv.getF()==-1 && vv.getV()!=-1){
                    ff.erstelleText(XVorlesung.getListeV().get(vv.getV()).getInfo(),x,y,laenge);
                    y=y+20;
                }}}
        if (z==4){
            ff.erstelleText("Fachschaften Liste",10,10,300);
            for (XVerbindung vv : XVerbindung.getVerbindungsListe()){
                if (vv.getH()==hIndex && vv.getA()==-1 && vv.getF()!=-1 && vv.getV()==-1){
                    ff.erstelleText(XFachschaft.getListeF().get(vv.getF()).getInfo(),x,y,laenge);
                    y=y+20;
                }}}
        if (z==5){
            ff.erstelleText("AF Liste",10,10,300);
            for (XVerbindung vv : XVerbindung.getVerbindungsListe()){
                if (vv.getH()==hIndex &&
                        vv.getA()!=-1 &&
                        vv.getF()!=-1 &&
                        vv.getV()==-1){
                    ff.erstelleText(XFachschaft.getListeF().
                            get(vv.getF()).getInfo(),x,y,laenge);y=y+20;}}}
        if (z==6){
            ff.erstelleText("AF Liste",10,10,300);
            for (XVerbindung vv : XVerbindung.getVerbindungsListe()){
                if (vv.getH()==hIndex &&
                        vv.getA()!=-1 &&
                        vv.getF()!=-1 &&
                        vv.getV()==-1){
                    ff.erstelleText(XFachschaft.getListeF().
                            get(vv.getF()).getInfo(),x,y,laenge);y=y+20;}}}
        if (z==5||z==6){
            ff.erstelleText("AF Liste",10,10,300);
            for (XVerbindung vv : XVerbindung.getVerbindungsListe()){
                if (vv.getH()==hIndex &&
                        vv.getA()!=-1 &&
                        vv.getF()!=-1 &&
                        vv.getV()==-1){
                    ff.erstelleText(XAngestellter.getListeA().
                            get(vv.getA()).getInfo(),10,30,laenge);y=y+60;
                    ff.erstelleText(XFachschaft.getListeF().
                            get(vv.getF()).getInfo(),10,50,laenge);y=y+60;}}}
        if (z==7||z==8||z==9||z==10||z==11||z==12){
            ff.erstelleText("AF Liste",10,10,300);
            for (XVerbindung vv : XVerbindung.getVerbindungsListe()){
                if (vv.getH()==hIndex &&
                        vv.getA()!=-1 &&
                        vv.getF()!=-1 &&
                        vv.getV()!=-1){
                    ff.erstelleText(XAngestellter.getListeA().
                            get(vv.getA()).getInfo(),10,30,laenge);y=y+80;
                    ff.erstelleText(XFachschaft.getListeF().
                            get(vv.getF()).getInfo(),10,50,laenge);y=y+80;
                    ff.erstelleText(XVorlesung.getListeV().
                            get(vv.getV()).getInfo(),10,70,laenge);y=y+80;}}}

//        dd1.eintragHinzufuegen("AF");//5
//        dd1.eintragHinzufuegen("FA");//6
//        dd1.eintragHinzufuegen("VFA");//7
//        dd1.eintragHinzufuegen("VAF");//8
//        dd1.eintragHinzufuegen("AVF");//9
//        dd1.eintragHinzufuegen("AFV");//10
//        dd1.eintragHinzufuegen("FAV");//11
//        dd1.eintragHinzufuegen("FVA");//12

        ff.erstelleSchalter("Weiter/Bestätige",200,10,200);
        ff.loeschen();
        main(h);
    }
}






package bwl.oo.paket901;

import com.ml.views.ComboBox;
import com.ml.views.Fenster;
import com.ml.views.Schalter;

import java.util.ArrayList;
import java.util.LinkedList;

public class Bundesregierung {
    private Bundeskanzler vorsitzender;
    private LinkedList<Ministerium> ministerien;
    private LinkedList<Bundesminister> kabinett;
    private LinkedList<Partei> parteien;


    public Bundesregierung(Bundeskanzler vorsitzender){
        this.vorsitzender = vorsitzender;
        this.kabinett = new LinkedList<Bundesminister>();
        this.ministerien = new LinkedList<Ministerium>();
        this.parteien = new LinkedList<Partei>();
    }

    public Bundeskanzler getVorsitzender() {
        return vorsitzender;
    }

    public void setVorsitzender(Bundeskanzler vorsitzender) {
        this.vorsitzender = vorsitzender;
    }

    public LinkedList<Ministerium> getMinisterien() {
        return ministerien;
    }

    public void setMinisterien(LinkedList<Ministerium> ministerien) {
        this.ministerien = ministerien;
    }

    public LinkedList<Bundesminister> getKabinett() {
        return kabinett;
    }

    public void setKabinett(LinkedList<Bundesminister> kabinett) {
        this.kabinett = kabinett;
    }

    public void ministerEntlassen(Bundesminister minister){

        ministerien.remove(minister.getMinisterium());
        kabinett.remove(minister);

    }

    public void setMinister(Bundesminister minister){
        kabinett.add(minister);
    }
    public LinkedList<Partei> getParteien(){
        return parteien;
    }

    public void addPartei(Partei partei){
        parteien.add(partei);
    }
    public void addBundesminister(Bundesminister bundesminister){
        kabinett.add(bundesminister);
        //TODO: Kontrolle ob ministerium schon vergeben
        ministerien.add(bundesminister.getMinisterium());
    }

    public void removeBundesminister(Bundesminister bundesminister){
        kabinett.remove(bundesminister);
    }

    public static Bundesregierung createNewBRD(){
        Fenster start = new Fenster("Eine neue BRD", 1300, 1000);
        Schalter startb  = new Schalter("Starte eine neue BRD");
        start.zeige(startb, 200, 500, 900);
        start.anzeigen();
        startb.warteAufEingabe();
        Bundeskanzler one = Bundeskanzler.createBundeskanzler();
        Bundesregierung brd = new Bundesregierung(one);
        brd.addPartei(one.getPartei());
        start.schliessen();
        brd.manageBRD(brd);
        return  brd;
    }

    public void manageBRD(Bundesregierung brd){
        Bundesregierung a = brd;
        Fenster start = new Fenster("Mitarbeiter Verwaltungssystem", 1300, 1000);
        ComboBox drop = new ComboBox("Minsterien verwalten", "Parteien verwalten");
        Schalter kabinett = new Schalter("Bestätige Auswahl");
        start.zeige(drop,400,450);
        start.zeige(kabinett,200,700,900);
        start.anzeigen();
        kabinett.warteAufEingabe();
        int track = drop.zahlDerEntscheidung();
        switch (track) {
            case 2:
                a = Ministerium.manageMinisterien(a);
                manageBRD(a);
                break;
            case 3:
                Partei.showParty(brd.vorsitzender.getPartei());
                manageBRD(a);
                break;

        }



    }
}

package bwl.oo.paket901;


import java.util.ArrayList;
import java.util.LinkedList;

import com.ml.views.ComboBox;
import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;

public class Partei {
    private String name;
    private ArrayList<Regierungsmitarbeiter> mitglieder;
    private String parteiId;


    public Partei(){

    }
    public Partei( String name){
        this.name = name;
        this.mitglieder = new ArrayList<Regierungsmitarbeiter>();
        this.parteiId = generateID(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Regierungsmitarbeiter> getMitglieder() {
        return mitglieder;
    }

    public void setMitglied(Regierungsmitarbeiter mitglieder) {
        this.mitglieder.add(mitglieder);
    }

    public String getParteiId() {
        return parteiId;
    }

    private String generateID(String name){
        String [] n = name.split(" ");
        String id = "";
        for (int i = 0; i <= n.length-1; i++){
            id += n[i].charAt(0);
        }
        return id;
    }

    public static void giveChoser(Bundesregierung brd){
        LinkedList<Partei> parteien = brd.getParteien();
        Fenster chose = new Fenster("Mitarbeiter Verwaltungssystem", 1300, 1000);
        if (parteien.isEmpty()){
            Schalter anlage = new Schalter("Neue partei anlegen");
            chose.zeige(anlage,200,650,900);
            chose.anzeigen();
            anlage.warteAufEingabe();
            chose.schliessen();
            Partei.createParty();

        }
        else{
            ComboBox choser = new ComboBox();
            choser.eintragHinzufuegen("Keine");
            for (int i = 0; i<= parteien.size();i++){
                choser.eintragHinzufuegen(parteien.get(i).getName());
            }
            Schalter anlage = new Schalter("Neue partei anlegen");
            chose.zeige(choser, 200,500);
            chose.zeige(anlage, 200, 600, 900);
            choser.warteAufEingabe();
            if (choser.zahlDerEntscheidung() == 1){
                anlage.warteAufEingabe();
                chose.schliessen();
                Partei.createParty();
            }
            else {
                int a = choser.zahlDerEntscheidung();
                chose.schliessen();
                Partei.showParty(parteien.get(a-2));
            }

        }

    }
    private static void createParty(){

    }
    public static Partei create1Party(){
        Fenster create = new Fenster("erstelle Partei", 1300, 1000);
        EingabeFeld parteiname = new EingabeFeld("Parteiname");
        EingabeFeld Gruender = new EingabeFeld("Gruender");
        Schalter erstellen = new Schalter("Erstellen");
        create.zeige(parteiname, 200, 500, 500);
        create.zeige(Gruender, 200, 600, 500);
        create.zeige(erstellen, 200,700, 500);
        create.anzeigen();
        erstellen.warteAufEingabe();
        String[]a = Gruender.getText().split(" ");
        Partei p = new Partei(parteiname.getText());
        Bundeskanzler gr = new Bundeskanzler(a[1], a[0], p, 4.0);
        p.setMitglied(gr);
        create.schliessen();
        return p;

    }

    public static void showParty(Partei partei){
        ArrayList<Regierungsmitarbeiter> mitgl = partei.getMitglieder();
        Fenster shower = new Fenster("Parteiverwaltungssystem", 1300, 1000);
        String table = "";
        for (int i = 0; i< mitgl.size(); i++){
            table += mitgl.get(i).getVorname() + " " + mitgl.get(i).getName() + "    " + mitgl.get(i).getPersNr() + "    ";
        }
        Text anzeige = new Text(table);
        shower.zeige(anzeige, 200, 200);
        shower.anzeigen();

    }
}


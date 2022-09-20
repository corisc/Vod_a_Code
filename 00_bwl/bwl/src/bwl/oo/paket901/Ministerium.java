package bwl.oo.paket901;

import bwl.oo.paket9.Minister;
import com.ml.views.*;

import java.util.ArrayList;

public class Ministerium {
    private String name;
    private String ministeriumID;
    private Bundesminister vorsitzender;


    public Ministerium (String name, String ministeriumID){
        this.name = name;
        this.ministeriumID = ministeriumID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinisteriumID() {
        return ministeriumID;
    }

    public void setMinisteriumID(String ministeriumID) {
        this.ministeriumID = ministeriumID;
    }

    public Bundesminister getVorsitzender() {
        return vorsitzender;
    }

    public void setVorsitzender(Bundesminister vorsitzender) {
        this.vorsitzender = vorsitzender;
    }

    public static Bundesregierung createMinisterium(Bundesregierung brd){
        Fenster create = new Fenster("erstelle ein neues Ministerium",1300,1000);
        Text name = new Text("Name des Ministeriums");
        Text id = new Text("Ministeriums ID");
        Text nname = new Text("Nachname des Meinisters");
        Text vname = new Text("Vorname des Ministers");
        EingabeFeld namee = new EingabeFeld("Name");
        EingabeFeld ide = new EingabeFeld("Minsteriums ID");
        EingabeFeld nnamee = new EingabeFeld("Name");
        EingabeFeld vnamee = new EingabeFeld("Vorname");
        create.zeige(name, 200, 500);
        create.zeige(namee,200,530,900);
        create.zeige(id,200,600);
        create.zeige(ide,200,630,900);
        create.zeige(vname, 200,700, 900);
        create.zeige(nnamee,200,730, 900 );
        create.zeige(nname,200,800,900);
        create.zeige(vnamee,200,830,900);
        Schalter s = new Schalter("Erstellen");
        create.zeige(s,200,800,900);
        create.anzeigen();
        s.warteAufEingabe();
        Ministerium min = new Ministerium(namee.getText(),ide.getText());
        Bundesminister a = new Bundesminister(nnamee.getText(), vnamee.getText(),brd.getParteien().get(0),namee.getText(),min);
        min.setVorsitzender(a);
        a.getPartei().setMitglied(a);
        brd.addBundesminister(a);
        create.schliessen();
        return brd;
    }

    public static Bundesregierung deletMinisterium(Bundesregierung brd){
        Fenster create = new Fenster("Lösche ein ministerium",1300,1000);
        //ToDO: if einfügen wenn keine Ministerien vorhanden
        ComboBox a = new ComboBox();
        Bundesminister min ;
        for (int i = 0;i<brd.getMinisterien().size();i++){
            a.eintragHinzufuegen(brd.getMinisterien().get(i).getMinisteriumID());

        }
        if(brd.getMinisterien().size() != 0){
        Schalter best = new Schalter("Bestätige");
        create.zeige(a, 200,400);
        create.zeige(best,200,600,900);
        create.anzeigen();
        best.warteAufEingabe();
        int track = a.zahlDerEntscheidung();
        min = brd.getMinisterien().get(track-1).getVorsitzender();
        brd.ministerEntlassen(min);}
        else{
            Schalter best = new Schalter("Zurück");
            create.zeige(best,200,600,900);
            create.anzeigen();
            best.warteAufEingabe();
        }
        create.schliessen();
        brd.manageBRD(brd);
        return brd;
    }

    public static Bundesregierung manageMinisterien(Bundesregierung brd){
        Bundesregierung a = brd;
        Fenster manage = new Fenster("Managen sie die Ministerien", 1300, 1000);
        ComboBox drop = new ComboBox("Ministerium löschen", "Minsiterium hinzufügen");
        Schalter best = new Schalter("Bestätige");
        manage.zeige(drop,450,400);
        manage.zeige(best, 200, 600, 900);
        manage.anzeigen();
        best.warteAufEingabe();
        int track = drop.zahlDerEntscheidung();
        switch(track){
            case 2:
                a = deletMinisterium(a);
            case 3:
                a = createMinisterium(a);
        }
        return a;

    }
}

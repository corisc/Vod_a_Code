package bwl.oo.paket6;

import bwl.oo.paket2.Mitarbeiter;
import bwl.oo.paket2.Projekt;
import bwl.oo.paket8.Bankfiliale;
import com.framework.SQLFenster;
import com.ml.utils.Scanner;
import com.ml.views.*;

public class Main extends javax.swing.JFrame {
    public static void main(String[] args) {

        Fenster f1 = new Fenster("Vodafone Shop");
        Farbe farbeVod = new Farbe(230,0,0);
        Ueberschrift uSchrift = new Ueberschrift("Herzlich willkommen bei Vodafone");
        Text t1 = new Text("Bitte wählen Sie aus:");
        Rechteck rGross = new Rechteck(760,430,farbeVod);
        Rechteck rKlein = new Rechteck(740, 330, farbeVod);
        f1.zeige(rKlein, 20, 100);
        f1.zeige(rGross, 10, 10);
        f1.zeige(uSchrift, 55, 30);
        f1.zeige(t1, 130, 150);

        Schalter ownerBut = new Schalter("Besitzer");
        Schalter custmBut = new Schalter ("Kunde");
        f1.zeige(ownerBut, 260, 180, 100);
        f1.zeige(custmBut, 260, 210, 100);

        //Besitzer Interface
        ownerBut.warteAufEingabe();
        Fenster f2 = new Fenster("Besitzer");

        Rechteck rKleinOwn = new Rechteck(740, 290, farbeVod);
        Text firstname = new Text("Ihr Vorname: ");
        Text lastname = new Text("Ihr Nachname: ");
        EingabeFeld fName = new EingabeFeld();
        EingabeFeld lName = new EingabeFeld();


        f2.zeige(rKleinOwn, 20, 140);
        f2.zeige(rGross, 10, 10);
        f2.zeige(firstname, 230, 200, 100);
        f2.zeige(fName, 320, 200, 150);
        f2.zeige(lastname, 230, 250, 100);
        f2.zeige(lName, 320, 250, 150);

        Schalter getBes = new Schalter ("Speichern");
        f2.zeige(getBes, 340, 300, 100);
        getBes.warteAufEingabe();

        String firstName = fName.getText();
        String lastName = lName.getText();


        f2.schliessen();

        //Window with options for owner
        Fenster f2_1 = new Fenster("Besitzer");
        Schalter create = new Schalter("Neue Filiale hinzufügen");
        Schalter count = new Schalter("Anzahl der Filialen zeigen");
        Schalter zinsSatzAendern = new Schalter("Zinssatz ändern");
        Ueberschrift u1Own = new Ueberschrift("Was möchten Sie tun?");

        //2_1.zeige(b1,40,20);
        f2_1.zeige(u1Own, 180, 160);

        f2_1.zeige(rKleinOwn, 20, 140);
        f2_1.zeige(rGross, 10, 10);

        f2_1.zeige(create, 260, 250, 250);
        f2_1.zeige(count, 260, 300, 250);
        f2_1.zeige(zinsSatzAendern, 260, 350, 250);


        create.warteAufEingabe();

        //Neue Filiale hinzufügen
        Fenster f2_2 = new Fenster("Neue Filiale hinzufügen");
        Rechteck rKleinFil = new Rechteck(740, 250, farbeVod);
        Text filAdresse = new Text("Tragen Sie bitte die Adresse von der neuen Filialen:");
        EingabeFeld filAd = new EingabeFeld();
        Schalter saveFil = new Schalter("Speichern");

        f2_2.zeige(rGross, 10, 10);
        f2_2.zeige(rKleinFil, 20, 180);
        f2_2.zeige(filAdresse, 30, 220);
        f2_2.zeige(filAd, 30, 250, 300);
        f2_2.zeige(saveFil, 300, 300, 150);


        saveFil.warteAufEingabe();

        Mitarbeiter mitarbeiterOne = new Mitarbeiter("Laura", "Robertson");
        Projekt projektOne = new Projekt("Vodafone for kids", mitarbeiterOne);

        Besitzer owner = new Besitzer(firstName, lastName, mitarbeiterOne,projektOne);

        Filiale fil = new Filiale(filAd.getText());
        owner.fuegeFilialeHinzu();

        f2_2.schliessen();


        //Neue Filiale hinzufuegen
        Fenster f2_3 = new Fenster("Neue Filiale hinzufügen");
        Ueberschrift filHinzufuegt= new Ueberschrift("Neue Filiale wurde hinzufügt!");
        Text filAdresseOne = new Text("Adresse von der neuen Filiale lautet ");
        Text filAdresseTwo = new Text(fil.getStandort());

        f2_3.zeige(rGross, 10, 10);
        f2_3.zeige(rKleinFil, 20, 180);
        f2_3.zeige(filHinzufuegt, 120, 200);
        f2_3.zeige(filAdresseOne, 150, 270);
        f2_3.zeige(filAdresseTwo, 370, 270);

        zinsSatzAendern.warteAufEingabe();
        f2_3.schliessen();

        //Zinssatz ändern
        Fenster f2_3z = new Fenster("Zinssatz ändern");
        Text textEintragen = new Text("Tragen Sie, bitte, den neuen Zinssatz ein: ");
        EingabeFeld zinsEing = new EingabeFeld();

        Schalter projekteZeigen = new Schalter("Aktuelle Projekte zeigen");

        f2_3z.zeige(rGross, 10, 10);
        f2_3z.zeige(textEintragen, 30, 220);
        f2_3z.zeige(zinsEing, 30, 250, 100);
        f2_3z.zeige(projekteZeigen, 260, 400, 250);

        projekteZeigen.warteAufEingabe();
        f2_3z.schliessen();

        //Projekte zeigen

        Fenster f6 = new Fenster("Ihre Projekte");
        Text projeken = new Text(owner.projekteZeigen());

        f6.zeige(projeken, 50, 50);

        //Anzahl der Filialen zeigen
        count.warteAufEingabe();
        Fenster f2_4 = new Fenster("Anzahl der Filialen zeigen");
        Text countFilOne = new Text("Gesamte Anzahl der Filialen:");
        Text countFilTwo = new Text(String.valueOf(owner.getFilialen()));
        Schalter assortiment = new Schalter("Zum Vodafone Shop");

        f2_4.zeige(rGross, 10, 10);
        f2_4.zeige(rKleinFil, 20, 180);
        f2_4.zeige(countFilOne, 220, 270);
        f2_4.zeige(countFilTwo, 390, 270);
        f2_4.zeige(assortiment, 290, 350, 200);
        assortiment.warteAufEingabe();

        f2_4.schliessen();

        //Assortiment zeigen

       Fenster f3 = new Fenster("Vodafone Shop");
        Text t1_iP = new Text("iPhone 6:");
        Text t2_iP = new Text("iPhone 7:");
        Text t3_iP = new Text("iPhone 8:");
        Text t4_iP = new Text("iPhone X:");

        f3.zeige(rKleinOwn, 20, 140);
        f3.zeige(rGross, 10, 10);
        f3.zeige(t1_iP, 60,170);
        f3.zeige(t2_iP, 360,170);
        f3.zeige(t3_iP, 60,290);
        f3.zeige(t4_iP, 360,290);



        //Customer Interface
        custmBut.warteAufEingabe();

        //Fenster schliessen
        f2_1.schliessen();
        f2_2.schliessen();
        f2_3.schliessen();
        f2_4.schliessen();
        f3.schliessen();

        Fenster f4 = new Fenster("Kunde");

        f4.zeige(rKleinOwn, 20, 140);
        f4.zeige(rGross, 10, 10);
        f4.zeige(firstname, 230, 200, 100);
        f4.zeige(fName, 320, 200, 150);
        f4.zeige(lastname, 230, 250, 100);
        f4.zeige(lName, 320, 250, 150);

        Schalter getKun= new Schalter ("Gewinnspiel");
        f4.zeige(getKun, 320, 300, 150);
        getKun.warteAufEingabe();

        Kunde kunde = new Kunde(fName.getText(),lName.getText());

        //Gewinnspiel
        Fenster f5 = new Fenster("Gewinnspiel");
        Text tGewOne = new Text("Liebe Kunde, senden Sie bitte SMS mit dem unten gegebenen Nummer an den Telefonnummer +490889876577.");
        Text tGewTwo = new Text("Die SMS sind kostenlos innerhalb des EU-Raums.");
        Text gewNum = new Text(String.valueOf(kunde.gewinnspiel()));

        //f5.zeige(b1,40,20);
        f5.zeige(rKleinOwn, 20, 140);
        f5.zeige(rGross, 10, 10);

        f5.zeige(tGewOne, 40, 170);
        f5.zeige(tGewTwo, 40, 185);
        f5.zeige(gewNum, 300, 230);
    }
}

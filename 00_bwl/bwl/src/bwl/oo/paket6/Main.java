package bwl.oo.paket6;

import com.framework.SQLFenster;
import com.ml.views.*;

public class Main extends javax.swing.JFrame {
    public static void main(String[] args) {
        SplashScreen sOne = new SplashScreen(3000,"Vodafone Shop","vf_logo.jpg");
        sOne.anzeigen();

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
        Bild b1 = new Bild("lange5.jpg");
        Text firstname = new Text("Ihr Vorname: ");
        Text lastname = new Text("Ihr Nachname: ");
        EingabeFeld fName = new EingabeFeld();
        EingabeFeld lName = new EingabeFeld();

        f2.zeige(b1,40,20);
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

        SplashScreen sTwo = new SplashScreen(3000,"","sTwo.gif");
        sTwo.anzeigen();

        //Window with options for owner
        Fenster f2_1 = new Fenster("Besitzer");
        Schalter create = new Schalter("Neue Filiale hinzufügen");
        Schalter count = new Schalter("Anzahl der Filialen zeigen");
        Ueberschrift u1Own = new Ueberschrift("Was möchten Sie tun?");

        f2_1.zeige(b1,40,20);
        f2_1.zeige(u1Own, 180, 160);

        f2_1.zeige(rKleinOwn, 20, 140);
        f2_1.zeige(rGross, 10, 10);

        f2_1.zeige(create, 260, 250, 250);
        f2_1.zeige(count, 260, 300, 250);

        create.warteAufEingabe();

        //Neue Filiale hinzufügen
        Fenster f2_2 = new Fenster("Neue Filiale hinzufügen");
        Rechteck rKleinFil = new Rechteck(740, 250, farbeVod);
        Bild logo = new Bild("vf_logo.jpg");
        Bild filiale = new Bild("filiale.jpg");
        Text filAdresse = new Text("Tragen Sie bitte die Adresse von der neuen Filialen:");
        EingabeFeld filAd = new EingabeFeld();
        Schalter saveFil = new Schalter("Speichern");

        f2_2.zeige(rGross, 10, 10);
        f2_2.zeige(rKleinFil, 20, 180);
        f2_2.zeige(logo, 20, 20);
        f2_2.zeige(filiale, 520, 20);
        f2_2.zeige(filAdresse, 30, 220);
        f2_2.zeige(filAd, 30, 250, 300);
        f2_2.zeige(saveFil, 300, 300, 150);


        saveFil.warteAufEingabe();

        Besitzer owner = new Besitzer(firstName, lastName);
        Filiale fil = new Filiale(filAd.getText());
        owner.fuegeFilialeHinzu();

        f2_2.schliessen();

        sTwo.anzeigen();

        //??
        Fenster f2_3 = new Fenster("Neue Filiale hinzufügen");
        Ueberschrift filHinzufuegt= new Ueberschrift("Neue Filiale wurde hinzufügt!");
        Text filAdresseOne = new Text("Adresse von der neuen Filiale lautet ");
        Text filAdresseTwo = new Text(fil.getStandort());

        f2_3.zeige(rGross, 10, 10);
        f2_3.zeige(rKleinFil, 20, 180);
        f2_3.zeige(logo, 20, 20);
        f2_3.zeige(filiale, 520, 20);
        f2_3.zeige(filHinzufuegt, 120, 200);
        f2_3.zeige(filAdresseOne, 150, 270);
        f2_3.zeige(filAdresseTwo, 355, 270);



        //Anzahl der Filialen zeigen
        //??
        count.warteAufEingabe();
        Fenster f2_4 = new Fenster("Anzahl der Filialen zeigen");
        Text countFilOne = new Text("Gesamte Anzahl der Filialen:");
        Text countFilTwo = new Text(String.valueOf(owner.getFilialen()));
        Schalter assortiment = new Schalter("Zum Vodafone Shop");

        f2_4.zeige(rGross, 10, 10);
        f2_4.zeige(rKleinFil, 20, 180);
        f2_4.zeige(logo, 20, 20);
        f2_4.zeige(filiale, 520, 20);
        f2_4.zeige(countFilOne, 220, 270);
        f2_4.zeige(countFilTwo, 390, 270);
        f2_4.zeige(assortiment, 290, 350, 200);
        assortiment.warteAufEingabe();

        f2_4.schliessen();

        //Assortiment zeigen

        Fenster f3 = new Fenster("Vodafone Shop");
        Bild iP6 = new Bild("iPhone 6.jpg");
        Bild iP7 = new Bild("iPhone 7.jpg");
        Bild iP8 = new Bild("iPhone 8.jpg");
        Bild iPx = new Bild("iPhone x.jpg");

        Text t1_iP = new Text("iPhone 6:");
        Text t2_iP = new Text("iPhone 7:");
        Text t3_iP = new Text("iPhone 8:");
        Text t4_iP = new Text("iPhone X:");


        f3.zeige(b1,40,20);
        f3.zeige(rKleinOwn, 20, 140);
        f3.zeige(rGross, 10, 10);

        f3.zeige(iP6, 140, 170);
        f3.zeige(iP7, 440, 170);
        f3.zeige(iP8, 140, 290);
        f3.zeige(iPx, 440, 290);

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

        f4.zeige(b1,40,20);
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



        SplashScreen sThree = new SplashScreen(3000,"","gewinnspiel.gif");
        sThree.anzeigen();

        //Gewinnspiel
        Fenster f5 = new Fenster("Gewinnspiel");
        Text tGewOne = new Text("Liebe Kunde, senden Sie bitte SMS mit dem unten gegebenen Nummer an den Telefonnummer +490889876577.");
        Text tGewTwo = new Text("Die SMS sind kostenlos innerhalb des EU-Raums.");
        Text gewNum = new Text(String.valueOf(kunde.gewinnspiel()));

        f5.zeige(b1,40,20);
        f5.zeige(rKleinOwn, 20, 140);
        f5.zeige(rGross, 10, 10);

        f5.zeige(tGewOne, 40, 170);
        f5.zeige(tGewTwo, 40, 185);
        f5.zeige(gewNum, 300, 230);
    }
}

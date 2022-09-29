package bwl;

import com.ml.utils.*;
import com.ml.views.*;
import com.framework.SQLFenster;
import com.framework.server.BasicServer;
import com.framework.server.ParameterServer;
import com.ml.connection.*;
import com.ml.utils.*;
import com.ml.views.*;
import com.ml.datenbank.*;

import bwl.oo.paket1.*;
import bwl.oo.paket2.*;
import bwl.oo.paket3.*;
import bwl.oo.paket4.*;
import bwl.oo.paket5.*;
import bwl.oo.paket6.*;
import bwl.oo.paket7.*;
import bwl.oo.paket8.*;
import bwl.oo.paket9.*;

public class Programm2 {

    public static void main(String[] args) {
        SplashScreen startFenster = new SplashScreen(3000, "Vodafone Shop",
                "banner_vf.jpg");

        Fenster f1 = new Fenster("Vodafone", 815, 540);
        Farbe farbeRot = new Farbe(250, 0, 0);
        Rechteck r1 = new Rechteck(800, 500, 10, farbeRot);
        Rechteck r2 = new Rechteck(800, 200, 10, farbeRot);
        Bild b1 = new Bild("vf_logo.jpg");
        Bild b2 = new Bild("angebot.jpg");
        Helfer h1 = new Helfer();

        Text t1 = new Text(h1.liefereZeit());

        EingabeFeld e2 = new EingabeFeld("Lagerbestand");
        EingabeFeld e3 = new EingabeFeld("Lagerbestand");
        EingabeFeld e4 = new EingabeFeld("Lagerbestand");
        EingabeFeld e5 = new EingabeFeld("Lagerbestand");

        Schalter s1 = new Schalter("Speichern");


        Text t2 = new Text("Iphone 6");
        Text t3 = new Text("Iphone 7");
        Text t4 = new Text("Iphone 8");
        Text t5 = new Text("Iphone X");


        startFenster.anzeigen();

        // Erstellung des Fensters mit Werbung
        f1.zeige(r1, 0, 0);
        f1.zeige(r2, 0, 300);
        f1.zeige(b1, 0, 0);
        f1.zeige(b2, 566, 0);
        f1.zeige(t1, 10, 150);

        // Iphone 6
        f1.zeige(e2, 50, 340, 100);
        f1.zeige(t2, 50, 320, 100);

        // Iphone 7
        f1.zeige(e3, 250, 340, 100);
        f1.zeige(t3, 250, 320, 100);

        // Iphone 8
        f1.zeige(e4, 450, 340, 100);
        f1.zeige(t4, 450, 320, 100);

        // Iphone X
        f1.zeige(e5, 650, 340, 100);
        f1.zeige(t5, 650, 320, 100);

        // Schalter
        f1.zeige(s1, 650, 440, 100);

        s1.warteAufEingabe();
        f1.allesBeenden();

    }
}

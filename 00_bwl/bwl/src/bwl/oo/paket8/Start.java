package bwl.oo.paket8;

import bwl.oo.paket10.Employee;
import bwl.oo.paket6.Kunde;
import com.ml.views.AusgabeFenster;

import java.awt.*;

public class Start {

    public static void main(String args[]) {
        Bankfiliale bf = new Bankfiliale(1, "Augsburger Sparkasse");
        Girokonto g1 = new Girokonto(1, 3);
        Bezirk b1 = new Bezirk("Augsburg",3 );
        Konto k = new Konto(104, "Sabrina", 3000);
        Konto k2 = new Konto(108, "Max", 300);
        Konto k3 = new Konto(109, "Luisa", 30000);
        Employee e1 = new Employee (10,"Günther", "Jauch");
        Kunde ku1 = new Kunde ("Maria", "Müller");

        bf.addEmployee(e1);
        bf.addKunde(ku1);
        bf.fuegeKontoHinzu(k);
        bf.fuegeKontoHinzu(k2);
        bf.fuegeKontoHinzu(k3);
        bf.loescheKonto(k.getKontoID());
        b1.fuegeFilialeHinzu(bf);
        b1.wievieleFilialenHatDieserBezirk();
        k.toString();

        AusgabeFenster aus = new AusgabeFenster();
        aus.ausgeben(k2.toString());
        aus.ausgeben(b1.wievieleFilialenHatDieserBezirk());
        aus.ausgeben(k.zeigeKontostand());
        aus.ausgeben(bf.getEmployees().toString());
        aus.ausgeben(bf.getKunde().toString());

    }
}


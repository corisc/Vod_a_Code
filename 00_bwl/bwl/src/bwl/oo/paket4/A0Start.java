package bwl.oo.paket4;

import com.ml.views.AusgabeFenster;

public class A0Start {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    OnlineShop os = new OnlineShop("Amazon", 100100);
    Angestellter a1 = new Angestellter("Big", "Boss");
    Rechenzentrum rz = new Rechenzentrum("Muenchen", a1);
    Server s1 = new Server("81.159.169.70", "amazone.de", rz);
    os.fuegeServerHinzu(s1);
    Budget b1 = new Budget(239000);
    ITAbteilung itAbteilung = new ITAbteilung("Kuemmerer");
    itAbteilung.fuegeBudgetHinzu(b1);
    rz.abteilung = itAbteilung;
    Angestellter a2 = new Angestellter("Armer", "Hund");
    Angestellter a3 = new Angestellter("Shining", "Star");
    Angestellter a4 = new Angestellter("Love", "It");
    itAbteilung.fuegeMitarbeiterHinzu(a2);
    itAbteilung.fuegeMitarbeiterHinzu(a3);
    itAbteilung.fuegeMitarbeiterHinzu(a4);
    
    AusgabeFenster aus = new AusgabeFenster("Love it !");
    
    aus.ausgeben("Der Nachname des zweiten Angestellten (nach Anlage) der ITAbteilung fuer das Rechenzentrum des Online Shop - Servers 81.159.169.70 ist:");
    aus.ausgeben(os.liefereServer("81.159.169.70").rechenzentrum.abteilung.liefereMitarbeiter(2).nachname);
    
    aus.ausgeben("Der Nachname des Leiters fuer das Rechenzentrum des Online Shop - Servers 81.159.169.70 ist:");
    aus.ausgeben(os.liefereServer("81.159.169.70").rechenzentrum.leiter.nachname);
    
    aus.ausgeben("Der Betrag des Budgets fuer das Rechenzentrum ist:");
    aus.ausgeben(os.liefereServer("81.159.169.70").rechenzentrum.abteilung.budget.betrag);
    aus.ausgeben("Der Betrag des Budgets fuer das Rechenzentrum ist:");
    aus.ausgeben(os.liefereServer("81.159.169.70").rechenzentrum.abteilung.budget.betrag);
    aus.ausgeben(a2.arbeiten());
    aus.ausgeben(a2.urlaubBeantragen());
    aus.ausgeben(os.werbungZeigen());
  }

}


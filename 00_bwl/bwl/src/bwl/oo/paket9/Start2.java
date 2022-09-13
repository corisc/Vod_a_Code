package bwl.oo.paket9;

import com.ml.views.AusgabeFenster;

public class Start2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // Objekte Staatswesen

    Waehler w1 = new Waehler("Markus", "Leue", "Betastraße 9");
    Waehler w2 = new Waehler("Peter", "Mantel", "Beatestr. 6-8");

    Person p1 = new Person("Niklas", "Sittel", "Neuendorferstrße 15");

    Wahlkreis wk1 = new Wahlkreis(1, "Augsburg", p1);

    wk1.fuegeWaehlerhinzu(w1);
    wk1.fuegeWaehlerhinzu(w2);

    // Muenchen

    Buergermeister buergermeister1 = new Buergermeister("Dieter", "Reiter",
        "Marienplatz8 80331 Muenchen");
    Stadt stadt1 = new Stadt("Muenchen", 1450000, buergermeister1);

    // Bayern

    Landtagspraesident bayernLandtagspraesident1 = new Landtagspraesident(
        "Ilse", "Aigner", "Maximilianeum 81627 Muenchen");
    Landesparlament bayernLandesparlament1 = new Landesparlament(
        bayernLandtagspraesident1);

    Regierungschef bayernRegierungschef1 = new Regierungschef("Markus",
        "Soeder", "Jakobstraße 46 90402 Nuernberg");
    Minister ministerBayern1 = new Minister("Joachim", "Herrmann", "Muenchen",
        "Staatsminister des Innern fuer Sport und Integration");
    Minister ministerBayern2 = new Minister("Bernd", "Sibler", "Muenchen",
        "Staatsminister fuer Wissenschaft und Kunst");
    Landesregierung bayernLandesregierung = new Landesregierung(
        bayernRegierungschef1);
    bayernLandesregierung.fuegeMinisterhinzu(ministerBayern1);
    bayernLandesregierung.fuegeMinisterhinzu(ministerBayern2);

    Bundesland bundesland1 = new Bundesland("Bayern", stadt1,
        bayernLandesparlament1, bayernLandesregierung);

    // Abgeordnete Landesparlament Bayern

    Abgeordneter abgeordneterBayern1 = new Abgeordneter("Martin", "Bachhuber",
        "");
    bayernLandesparlament1.fuegeAbgeordnetenhinzu(abgeordneterBayern1);
    Abgeordneter abgeordneterBayern2 = new Abgeordneter("Peter", "Bauer", "");
    bayernLandesparlament1.fuegeAbgeordnetenhinzu(abgeordneterBayern2);

    // Abfrage 1

    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben("Regierungschef von Bayern: "
        + bundesland1.liefereLandesregierung().liefereRegierungschef()
            .liefereVorname()
        + " "
        + bundesland1.liefereLandesregierung().liefereRegierungschef()
            .liefereNachname());

    aus.ausgeben("Abgeordnete bayrisches Landesparlament: "
        + bayernLandesparlament1.liefereAbgeordneten(1).liefereVorname() + " "
        + bayernLandesparlament1.liefereAbgeordneten(1).liefereNachname());

    aus.ausgeben("Abgeordnete bayrisches Landesparlament: "
        + bayernLandesparlament1.liefereAbgeordneten(2).liefereVorname() + " "
        + bayernLandesparlament1.liefereAbgeordneten(2).liefereNachname());

    // Weitere Objekte

    // Bundesrat

    Bundesratspraesident bundesratspraesident = new Bundesratspraesident(
        "Daniel", "Guenther", "Kiel");
    Bundesrat bundesrat = new Bundesrat(bundesratspraesident);

    // Parteien

    Partei partei1 = new Partei("Die Gruenen");
    Partei partei2 = new Partei("SPD");
    Partei partei3 = new Partei("CDU/CSU");

    Parteimitglied pm1 = new Parteimitglied("Klaus", "Mueller",
        "Alleenstraße 5 96450 Coburg", "Die Gruenen");
    Parteimitglied pm2 = new Parteimitglied("Peter", "Hiller",
        "Am Star 9 96450 Coburg", "SPD");
    Parteimitglied pm3 = new Parteimitglied("Melanie", "Nagel",
        "Waldstraße 14 96450 Coburg", "Die Gruenen");
    Parteimitglied pm4 = new Parteimitglied("Jane", "Doe",
        "Friedrich Streib Weg 23 96450 Coburg", "CDU/CSU");

    partei1.fuegeMitgliederhinzu(pm1);
    partei1.fuegeMitgliederhinzu(pm3);
    partei2.fuegeMitgliederhinzu(pm2);
    partei3.fuegeMitgliederhinzu(pm4);

    // Bundestag

    GekoreneMitgliederBundestag gkmb1 = new GekoreneMitgliederBundestag(
        "Stephan", "Albani", "", "Diplom-Physiker", partei3);
    GekoreneMitgliederBundestag gkmb2 = new GekoreneMitgliederBundestag(
        "Luise", "Amtsberg", "", "Islamwissenschaftlerin", partei1);

    Bundestagspraesident bundestagspraesident = new Bundestagspraesident(
        "Wolfgang", "Schaeuble", "Ueberall und Nirgendwo");

    Bundestag bundestag = new Bundestag();
    bundestag.fuegeMitgliedhinzu(gkmb1);
    bundestag.fuegeMitgliedhinzu(gkmb2);
    bundestag.setzeBundestagspraesident(bundestagspraesident);

    // Grundgesetz

    Grundgesetz grundgesetz = new Grundgesetz(1949, 2019);
    grundgesetz.fuegeArtikelhinzu("104b", bundesrat, bundestag);
    grundgesetz.fuegeArtikelhinzu("107c", bundesrat, bundestag);

    // Bundesverfassungsgericht

    Buergermeister buergermeisterKarlsruhe = new Buergermeister("Frank",
        "Mentrup", "Irgendwo in Karlsruhe");
    Stadt bvgstadt = new Stadt("Karlsruhe", 307000, buergermeisterKarlsruhe);
    Bundesverfassungsgerichtspraesident bundesverfassungsgerichtpresident = new Bundesverfassungsgerichtspraesident(
        "Andreas", "Voßkuhle", "Detmold");
    Bundesverfassungsgericht bundesverfassungsgericht = new Bundesverfassungsgericht(
        bvgstadt, grundgesetz, bundesverfassungsgerichtpresident);

    // Abfrage 2

    aus.ausgeben("Sitz des Bundesverfassungsgerichtes: "
        + bundesverfassungsgericht.liefereSitz().liefereName());

    aus.ausgeben("Artikel aus Grundgesetz " + grundgesetz.liefereAlleArtikel());

    aus.ausgeben("1. Gekorenes Mitglied des Bundestages: "
        + bundestag.holeMitglied("Stephan").liefereVorname() + " "
        + bundestag.holeMitglied("Stephan").liefereNachname());

    aus.ausgeben("2. Gekorenes Mitglied des Bundestages: "
        + bundestag.holeMitglied("Luise").liefereVorname() + " "
        + bundestag.holeMitglied("Luise").liefereNachname());

    // Weitere Objekte

    Minister ministerBayern3 = new Minister("Hans", "Reichhart", "",
        "Staatsministerium fuer Wohnen, Bau und Verkehr");
    Minister ministerBayern4 = new Minister("Albert", "Fueracker", "",
        "Bayerisches Staatsministerium der Finanzen und fuer Heimat");

    Ministerium ministerium1 = new Ministerium(
        "Staatsministerium des Innern fuer Sport und Integration",
        ministerBayern1);
    Ministerium ministerium2 = new Ministerium(
        "Staatsministerium fuer Wissenschaft und Kunst", ministerBayern2);
    Ministerium ministerium3 = new Ministerium(
        "Staatsministerium fuer Wohnen, Bau und Verkehr", ministerBayern3);
    Ministerium ministerium4 = new Ministerium(
        "Bayerisches Staatsministerium der Finanzen und fuer Heimat",
        ministerBayern4);

    bayernLandesregierung.fuegeMinisterhinzu(ministerBayern1);
    bayernLandesregierung.fuegeMinisterhinzu(ministerBayern2);
    bayernLandesregierung.fuegeMinisterhinzu(ministerBayern3);
    bayernLandesregierung.fuegeMinisterhinzu(ministerBayern4);

    // Abfrage 3

    aus.ausgeben("Landesminister: "
        + ministerium1.liefereLeitenderMinister().liefereNachname()
        + " Ministerium: " + ministerium1.liefereName());
    aus.ausgeben("Landesminister: "
        + ministerium2.liefereLeitenderMinister().liefereNachname()
        + " Ministerium: " + ministerium2.liefereName());
    aus.ausgeben("Landesminister: "
        + ministerium3.liefereLeitenderMinister().liefereNachname()
        + " Ministerium: " + ministerium3.liefereName());
    aus.ausgeben("Landesminister: "
        + ministerium4.liefereLeitenderMinister().liefereNachname()
        + " Ministerium: " + ministerium4.liefereName());

    // Weitere Objekte

    Bundeskanzler bundeskanzler = new Bundeskanzler("Angela", "Merkel", "", 7.5);

    Bundesregierung bundesregierung = new Bundesregierung(bundeskanzler);

    // Minister in Bundesministerien
    Minister ministerBMVI = new Minister("Andreas", "Scheuer", "",
        "Bundesminister fuer Verkehr und digitale Infrastruktur");
    Minister ministerBMZ = new Minister("Gerd", "Mueller", "",
        "Bundesminister fuer wirtschaftliche Zusammenarbeit und Entwicklung");
    Minister ministerBMF = new Minister("Olaf", "Scholz", "",
        "Bundesfinanzminister");
    Minister ministerBMI = new Minister("Horst", "Seehofer", "",
        "Bundesinnenminister");
    Minister ministerAA = new Minister("Heiko", "Maas", "", "Außenminister");
    Minister ministerBMWi = new Minister("Peter", "Altmaier", "",
        "Bundesminister fuer Wirtschaft und Energie");
    Minister ministerBMJV = new Minister("Katarina", "Barley", "",
        "Bundesministerin der Justiz und fuer Verbraucherschutz");
    Minister ministerBMAS = new Minister("Hubertus", "Heil", "",
        "Bundesminister fuer Arbeit und Soziales");
    Minister ministerBMVg = new Minister("Ursula", " von der Leyen", "",
        "Verteidigungsministerin");
    Minister ministerBMEL = new Minister("Julia", "Kloeckner", "",
        "Bundesministerin fuer Ernaehrung und Landwirtschaft");
    Minister ministerBMFSFJ = new Minister("Franziska", "Giffey", "",
        "Bundesministerin fuer Familie, Senioren, Frauen und Jugend");
    Minister ministerBMG = new Minister("Jens", "Spahn", "",
        "Bundesminister fuer Gesundheit");
    Minister ministerBMU = new Minister("Svenja", "", "Schulze",
        "Bundesministerin fuer Umwelt, Naturschutz und nukleare Sicherheit");
    Minister ministerBMBF = new Minister("Anja", "Karliczek", "",
        "Bundesministerin fuer Bildung und Forschung");

    // Ministerien
    Ministerium BMVI = new Ministerium(
        "Bundesministerium fuer Verkehr und digitale Infrastruktur",
        ministerBMVI);
    Ministerium BMF = new Ministerium("Bundesministerium der Finanzen",
        ministerBMF);
    Ministerium BMI = new Ministerium(
        "Bundesministerium des Innern, fuer Bau und Heimat", ministerBMI);
    Ministerium AA = new Ministerium("Auswaertiges Amt", ministerAA);
    Ministerium BMWi = new Ministerium(
        "Bundesministerium fuer Wirtschaft und Energie", ministerBMWi);
    Ministerium BMJV = new Ministerium(
        "Bundesministerium der Justiz und fuer Verbraucherschutz", ministerBMJV);
    Ministerium BMAS = new Ministerium(
        "Bundesministerium fuer Arbeit und Soziales", ministerBMAS);
    Ministerium BMVg = new Ministerium("Bundesministerium der Verteidigung",
        ministerBMVg);
    Ministerium BMEL = new Ministerium(
        "Bundesministerium fuer Ernaehrung und Landwirtschaft", ministerBMEL);
    Ministerium BMFSFJ = new Ministerium(
        "Bundesministerium fuer Familie, Senioren, Frauen und Jugend",
        ministerBMFSFJ);
    Ministerium BMG = new Ministerium("Bundesministerium fuer Gesundheit",
        ministerBMG);
    Ministerium BMU = new Ministerium(
        "Bundesministerium fuer Umwelt, Naturschutz und nukleare Sicherheit",
        ministerBMU);
    Ministerium BMBF = new Ministerium(
        "Bundesministerium fuer Bildung und Forschung", ministerBMBF);
    Ministerium BMZ = new Ministerium(
        "Bundesministerium fuer wirtschaftliche Zusammenarbeit und Entwicklung",
        ministerBMZ);

    bundesregierung.fuegeBundesministerhinzu(ministerBMBF);
    bundesregierung.fuegeBundesministerhinzu(ministerAA);
    bundesregierung.fuegeBundesministerhinzu(ministerBMVI);
    bundesregierung.fuegeBundesministerhinzu(ministerBMF);
    bundesregierung.fuegeBundesministerhinzu(ministerBMI);
    bundesregierung.fuegeBundesministerhinzu(ministerBMWi);
    bundesregierung.fuegeBundesministerhinzu(ministerBMJV);
    bundesregierung.fuegeBundesministerhinzu(ministerBMAS);
    bundesregierung.fuegeBundesministerhinzu(ministerBMVg);
    bundesregierung.fuegeBundesministerhinzu(ministerBMFSFJ);
    bundesregierung.fuegeBundesministerhinzu(ministerBMG);
    bundesregierung.fuegeBundesministerhinzu(ministerBMU);
    bundesregierung.fuegeBundesministerhinzu(ministerBMBF);
    bundesregierung.fuegeBundesministerhinzu(ministerBMZ);

    // Abfrage 4

    aus.ausgeben("Die Bundesregierung hat: "
        + bundesregierung.lieferAnzahlBundesminister() + " Minister.");

    aus.ausgeben("Die Bundeskanzlerin heißt: "
        + bundesregierung.liefereBundeskanzler().liefereVorname() + " "
        + bundesregierung.liefereBundeskanzler().liefereNachname());

    aus.ausgeben("Ministerium: "
        + bundesregierung.liefereBundesminister(1).liefereRessort()
        + " Leitender Minister: "
        + bundesregierung.liefereBundesminister(1).liefereVorname() + " "
        + bundesregierung.liefereBundesminister(1).liefereNachname());
    aus.ausgeben("Ministerium: "
        + bundesregierung.liefereBundesminister(2).liefereRessort()
        + " Leitender Minister: "
        + bundesregierung.liefereBundesminister(2).liefereVorname() + " "
        + bundesregierung.liefereBundesminister(2).liefereNachname());
    aus.ausgeben("Ministerium: "
        + bundesregierung.liefereBundesminister(3).liefereRessort()
        + " Leitender Minister: "
        + bundesregierung.liefereBundesminister(3).liefereVorname() + " "
        + bundesregierung.liefereBundesminister(3).liefereNachname());
    aus.ausgeben("Ministerium: "
        + bundesregierung.liefereBundesminister(4).liefereRessort()
        + " Leitender Minister: "
        + bundesregierung.liefereBundesminister(4).liefereVorname() + " "
        + bundesregierung.liefereBundesminister(4).liefereNachname());
  }

}

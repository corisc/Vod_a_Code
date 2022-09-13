package bwl.oo.paket9;


import java.util.ArrayList;

import com.ml.views.AusgabeFenster;


//import com.ml.views.ZeichenFenster;


public class Start {

    
    /**
     * @param args
     */
    public static void main(String[] args) {
      // TODO Auto-generated method stub
//      Waehler w1 = new Waehler("Markus", "Leue", "An der Schinderlohe 13");
//      Waehler w2 = new Waehler("Niklas", "Sittel", "Beatestr. 6-8");
//      
//      ArrayList<Waehler> waehlerwk1 = new ArrayList<Waehler>();
//      
//      Person p1 = new Person("Niklas", "Sittel", "Beatestr. 6-8");
//      
//      Wahlkreis wk1 = new Wahlkreis(1, "Augsburg", p1, waehlerwk1);
//      
//      //wk1.holeAbgeordneten(vorname)
//      
//      //Muenchen    
//      Buergermeister buergermeister1 = new Buergermeister("Dieter", "Reiter","Marienplatz8 80331 Muenchen");
//      Stadt stadt1 = new Stadt("Muenchen",1450000,buergermeister1);
//      
//      //Lankreise Bayern
//      Landkreis bayernLk1 = new Landkreis("Altoetting", 1, 110000);
//      Landkreis bayernLk2 = new Landkreis("Deckendorf", 2, 117000);
//      
//      //Bayern
//      Landtagspraesident bayernLandtagspraesident1 = new Landtagspraesident("Ilse","Aigner","Maximilianeum 81627 Muenchen");
//      Landesparlament bayernLandesparlament1 = new Landesparlament(bayernLandtagspraesident1);
//      Regierungschef bayernRegierungschef1 = new Regierungschef("Markus", "Soeder", "Jakobstraße 46 90402 Nuernberg");
//      ArrayList<Minister> ministerBayern = new ArrayList<Minister>();
//      Minister ministerBayern1 = new Minister("Joachim", "Herrmann", "", "Staatsminister des Innern fuer Sport und Integration");
//      Minister ministerBayern2 = new Minister("Bernd", "Sibler", "Salvatorstraße 2 80333 Muenchen", "Staatsminister fuer Wissenschaft und Kunst");
//      ministerBayern.add(ministerBayern1);
//      ministerBayern.add(ministerBayern2);
//      Landesregierung bayernLandesregierung = new Landesregierung(bayernRegierungschef1, ministerBayern);
//      Bundesland bundesland1 = new Bundesland("Bayern",stadt1,bayernLandesparlament1,bayernLandesregierung);
//      
//      bundesland1.setzeLandkreis(bayernLk1);
//      bundesland1.setzeLandkreis(bayernLk2);
//
//      //Richter Kammern Bayern
//      Richter bayernr1 = new Richter("Georg", "Falk", "Muenchen");
//      Richter bayernr2 = new Richter("Brigitta", "Dr. Steinlehner-Stelzner", "Muenchen");
//      Richter bayernr3 = new Richter("Hannes", "Seebacher", "Muenchen");
//      
//      //Hinzufuegen zu Array List
//      ArrayList<Richter> rZivilkammerBayern = new ArrayList<Richter>();
//      rZivilkammerBayern.add(bayernr1);
//      rZivilkammerBayern.add(bayernr2);
//      
//      ArrayList<Richter> rStrafkammerBayern = new ArrayList<Richter>();
//      rStrafkammerBayern.add(bayernr3);
//     
//      //Kammern Bayern
//      Kammer bayernk1 = new Kammer("Zivilkammer",rZivilkammerBayern);
//      Kammer bayernk2 = new Kammer("Strafkammer",rStrafkammerBayern);
//      
//      
//      
//      
//      //Stuttgart
//      Buergermeister bwBuergermeister1 = new Buergermeister("Fritz", "Kuhn", "Marktplatz 1 70173 Stuttgart");
//      Stadt bwstadt1 = new Stadt("Stuttgart", 628000, bwBuergermeister1);
//      
//      //Landkreise Baden Wuerttemberg
//      Landkreis bwLk1 = new Landkreis("Heilbronn", 1);
//      Landkreis bwLk2 = new Landkreis("Tuebingen", 2);
//
//      //Baden Wuerttemberg
//      Landtagspraesident bwLandtagspraesident1 = new Landtagspraesident("Muhterem","Aras","Konrad Adenauer Straße 3 70173 Stuttgart");
//      Landesparlament bwLandesparlament = new Landesparlament(bwLandtagspraesident1);
//      Regierungschef bwRegierungschef = new Regierungschef("Winfried", "Kretschmann", "Koenigstraße 78 70173 Stuttgart");
//      ArrayList<Minister> ministerBW = new ArrayList<Minister>();
//      Minister ministerBW1 =new Minister("Thomas", "Strobl", "Stuttgart", "Innenminister fuer die Polizei und Sicherheit");
//      Minister ministerBW2 =new Minister("Edith", "Sitzmann", "Stuttgart", "Ministerin fuer Finanzen");
//      ministerBW.add(ministerBW1);
//      ministerBW.add(ministerBW2);
//      //Landesregierung bwlandesregierung = new Landesregierung(bwRegierungschef, ministerBW);
//      //Bundesland bundesland2 = new Bundesland("Baden Wuerttemberg",bwstadt1,bwLandesparlament,bwlandesregierung);
//      
//      //bundesland2.setzeLandkreis(bwLk1);
//      //bundesland2.setzeLandkreis(bwLk2);
//      
//      //Richter Kammern Baden Wuerttemberg
//      Richter bwr1 = new Richter("Hans Eberhard", "Lorenz ", "Stuttgart");
//      Richter bwr2 = new Richter("Juergen", "Dr. Brinkmann", "Stuttgart");
//      Richter bwr3 = new Richter("Bernhard Joachim","Dr. Scholz", "Stuttgart");
//      Richter bwr4 = new Richter("Thomas","Jochem", "Stuttgart");
//
//      
//      //Hinzufuegen zu Array List
//      ArrayList<Richter> rZivilkammerBW = new ArrayList<Richter>();
//      rZivilkammerBW.add(bwr1);
//      rZivilkammerBW.add(bwr2);
//      
//      ArrayList<Richter> rStrafkammerBW = new ArrayList<Richter>();
//      rStrafkammerBW.add(bwr3);
//      rStrafkammerBW.add(bwr4);
//
//     
//      //Kammern Baden Wuerttemberg
//      Kammer bwk1 = new Kammer("Zivilkammer",rZivilkammerBW);
//      Kammer bwk2 = new Kammer("Strafkammer",rStrafkammerBW);
//
//      
//      
//      //Gesetze
//      Gesetz gesetz1 = new Gesetz();
//      gesetz1.fuegeArtikelhinzu("104b");
//      Gesetz gesetz2 = new Gesetz();
//      gesetz2.fuegeArtikelhinzu("125d");    
//      Gesetz gesetz3 = new Gesetz();
//      gesetz3.fuegeArtikelhinzu("125c");
//      
//      //Gesetzbuch
//      Gesetzbuch gesetzbuch = new Gesetzbuch();
//      gesetzbuch.fuegeGesetzhinzu(gesetz3);
//      gesetzbuch.fuegeGesetzhinzu(gesetz2);
//      gesetzbuch.fuegeGesetzhinzu(gesetz1);
//
//      //Bundesverfassungsgericht
//      Bundesverfassungsgerichtspraesident bundesverfassungsgaerichtpresident = new Bundesverfassungsgerichtspraesident("Andreas", "Voßkuhle", "Detmold");
//      Buergermeister buergermeisterKarlsruhe = new Buergermeister("Frank", "Mentrup", "Irgendwo in Karlsruhe");
//      Stadt bvgstadt = new Stadt("Karlsruhe",307000,buergermeisterKarlsruhe);
//
//      //Kammern Bundesverfassungsgericht
//      
//      
//      
//      //Minister in Bundesministerien
//      Minister ministerBMVI = new Minister("Andreas", "Scheuer", "", "Bundesminister fuer Verkehr und digitale Infrastruktur");
//      Minister ministerBMZ = new Minister("Gerd", "Mueller", "", "Bundesminister fuer wirtschaftliche Zusammenarbeit und Entwicklung");
//      Minister ministerBMF = new Minister("Olaf", "Scholz", "", "Bundesfinanzminister");
//      Minister ministerBMI = new Minister("Horst", "Seehofer", "", "Bundesinnenminister");
//      Minister ministerAA = new Minister("Heiko", "Maas", "", "Außenminister");
//      Minister ministerBMWi = new Minister("Peter", "Altmaier", "", "Bundesminister fuer Wirtschaft und Energie");
//      Minister ministerBMJV = new Minister("Katarina", "Barley", "", "Bundesministerin der Justiz und fuer Verbraucherschutz");
//      Minister ministerBMAS = new Minister("Hubertus", "Heil", "", "Bundesminister fuer Arbeit und Soziales");
//      Minister ministerBMVg = new Minister("Ursula", " von der Leyen", "", "Verteidigungsministerin");
//      Minister ministerBMEL = new Minister("Julia", "Kloeckner", "", "Bundesministerin fuer Ernaehrung und Landwirtschaft");
//      Minister ministerBMFSFJ = new Minister("Franziska", "Giffey", "", "Bundesministerin fuer Familie, Senioren, Frauen und Jugend");
//      Minister ministerBMG = new Minister("Jens", "Spahn", "", "Bundesminister fuer Gesundheit");
//      Minister ministerBMU = new Minister("Svenja", "", "Schulze", "Bundesministerin fuer Umwelt, Naturschutz und nukleare Sicherheit");
//      Minister ministerBMBF = new Minister("Anja", "Karliczek", "", "Bundesministerin fuer Bildung und Forschung");
//      
//      //Ministerien
//      Ministerium BMVI = new Ministerium("Bundesministerium fuer Verkehr und digitale Infrastruktur", ministerBMVI);
//      Ministerium BMF = new Ministerium("Bundesministerium der Finanzen", ministerBMF);
//      Ministerium BMI = new Ministerium("Bundesministerium des Innern, fuer Bau und Heimat", ministerBMI);
//      Ministerium AA = new Ministerium("Auswaertiges Amt", ministerAA);
//      Ministerium BMWi = new Ministerium("Bundesministerium fuer Wirtschaft und Energie", ministerBMWi);
//      Ministerium BMJV = new Ministerium("Bundesministerium der Justiz und fuer Verbraucherschutz", ministerBMJV);
//      Ministerium BMAS = new Ministerium("Bundesministerium fuer Arbeit und Soziales", ministerBMAS);
//      Ministerium BMVg = new Ministerium("Bundesministerium der Verteidigung", ministerBMVg);
//      Ministerium BMEL = new Ministerium("Bundesministerium fuer Ernaehrung und Landwirtschaft", ministerBMEL);
//      Ministerium BMFSFJ = new Ministerium("Bundesministerium fuer Familie, Senioren, Frauen und Jugend", ministerBMFSFJ);
//      Ministerium BMG = new Ministerium("Bundesministerium fuer Gesundheit", ministerBMG);
//      Ministerium BMU = new Ministerium("Bundesministerium fuer Umwelt, Naturschutz und nukleare Sicherheit", ministerBMU);
//      Ministerium BMBF = new Ministerium("Bundesministerium fuer Bildung und Forschung", ministerBMBF);
//      Ministerium BMZ = new Ministerium("Bundesministerium fuer wirtschaftliche Zusammenarbeit und Entwicklung", ministerBMZ);
//
//      //Partei
//      Partei partei1 = new Partei("Die Gruenen");
//      Partei partei2 = new Partei("SPD");
//      Partei partei3 = new Partei("CDU/CSU");
//      
//      //Parteimitglied
//      Parteimitglied pm1 = new Parteimitglied("Klaus", "Mueller", "Alleenstraße 5 96450 Coburg","Die Gruenen");
//      Parteimitglied pm2 = new Parteimitglied("Peter", "Hiller", "Am Star 9 96450 Coburg","SPD");
//      Parteimitglied pm3 = new Parteimitglied("Melanie", "Nagel", "Waldstraße 14 96450 Coburg","Die Gruenen");
//      Parteimitglied pm4 = new Parteimitglied("Jane", "Doe", "Friedrich Streib Weg 23 96450 Coburg","CDU/CSU");
//      
//      //Parteimitglieder den Parteien hinzufuegen
//      partei1.fuegeMitgliederhinzu(pm1);
//      partei1.fuegeMitgliederhinzu(pm3);
//      partei2.fuegeMitgliederhinzu(pm2);
//      partei3.fuegeMitgliederhinzu(pm4);
//          
//      
//      //Mitglieder Bundestag
//      GekoreneMitgliederBundestag gkmb1 = new GekoreneMitgliederBundestag("Stephan", "albani", "", "Diplom-Physiker", partei3);
//      GekoreneMitgliederBundestag gkmb2 = new GekoreneMitgliederBundestag("Luise", "Amtsberg", "", "Islamwissenschaftlerin", partei1);
//      GekoreneMitgliederBundestag gkmb3 = new GekoreneMitgliederBundestag("Philipp", "Amthor", "", "Jurist", partei3);
//      GekoreneMitgliederBundestag gkmb4 = new GekoreneMitgliederBundestag("Niels", "Annen", "", "Politikwissenschaftler", partei2);
//      GekoreneMitgliederBundestag gkmb5 = new GekoreneMitgliederBundestag("Ingrid", "Arndt-Brauer", "", "Diplom-Kauffrau, Diplom-Soziologin", partei2);
//      GekoreneMitgliederBundestag gkmb6 = new GekoreneMitgliederBundestag("Annalena", "Baerbock", "", "Voelkerrechtlerin", partei1);
//
//      //Bundestagspraesident
//      Bundestagspraesident bundestagspraesident = new Bundestagspraesident("Wolfgang", "Schaeuble", "Ueberall und Nirgendwo");
//      
//      //Bundestag
//      Bundestag bundestag = new Bundestag();
//      bundestag.fuegeMitgliedhinzu(gkmb1);
//      bundestag.fuegeMitgliedhinzu(gkmb2);
//      bundestag.fuegeMitgliedhinzu(gkmb3);
//      bundestag.fuegeMitgliedhinzu(gkmb4);
//      bundestag.fuegeMitgliedhinzu(gkmb5);
//      bundestag.fuegeMitgliedhinzu(gkmb6);
//      bundestag.setzeBundestagspraesident(bundestagspraesident);
//
//      //Bundesversammlung
//      Bundesversammlung bundesversammlung = new Bundesversammlung(630);
//
//      //Bundespraesident
//      Bundespraesident bundesPraesident = new Bundespraesident("Frank-Walter", "Steinmeier", "Berlin", 2);
//      
//      
//      //Bundeskanzler
//      Bundeskanzler bundeskanzler = new Bundeskanzler("Angela", "Merkel", "Willy Brandt Straße 1 10557 Berlin", 14);
//      
//      //Bundesregierung
//      Bundesregierung bundesregierung = new Bundesregierung(bundeskanzler);
//      bundesregierung.setzeBundeskanzler(bundeskanzler);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMBF);
//      bundesregierung.fuegeBundesministerhinzu(ministerAA);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMVI);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMF);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMI);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMWi);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMJV);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMAS);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMVg);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMFSFJ);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMG);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMU);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMBF);
//      bundesregierung.fuegeBundesministerhinzu(ministerBMZ);
//
//      //Bundesrat
//      Bundesratspraesident bundesratspraesident = new Bundesratspraesident("Daniel", "Guenther", "Kiel");
//      Bundesrat bundesrat = new Bundesrat(bundesratspraesident);
//      
//      //Bundesratabgeordneter
//      Bundesratsabgeordneter bundesratsabgeordneter1 = new Bundesratsabgeordneter("Doris Maria", "Ahnen", "Trier");
//      Bundesratsabgeordneter bundesratsabgeordneter2 = new Bundesratsabgeordneter("Hubert", "Aiwanger", "Bayern");
//      Bundesratsabgeordneter bundesratsabgeordneter3 = new Bundesratsabgeordneter("Tarek", "Al-Wazir", "Offenbach am Main");
//      Bundesratsabgeordneter bundesratsabgeordneter4 = new Bundesratsabgeordneter("Jan Philipp", "Albrecht", "Wolfenbuettel");
//      Bundesratsabgeordneter bundesratsabgeordneter5 = new Bundesratsabgeordneter("Bernd", "Althusmann", "Oldenburg");
//
//      bundesrat.fuegeBundesratsabgeordnetenhinzu(bundesratsabgeordneter1);
//      bundesrat.fuegeBundesratsabgeordnetenhinzu(bundesratsabgeordneter2);
//      bundesrat.fuegeBundesratsabgeordnetenhinzu(bundesratsabgeordneter3);
//      bundesrat.fuegeBundesratsabgeordnetenhinzu(bundesratsabgeordneter4);
//      bundesrat.fuegeBundesratsabgeordnetenhinzu(bundesratsabgeordneter5);
//
//      
//      //Grundgesetz
//      Grundgesetz grundgesetz = new Grundgesetz(1949, 2019);
//      grundgesetz.fuegeArtikelhinzu("104b",bundesrat,bundestag);
//      grundgesetz.fuegeArtikelhinzu("104b",bundesrat,bundestag);
//      grundgesetz.fuegeArtikelhinzu("104b",bundesrat,bundestag);
//      
//      Bundesverfassungsgericht bundesverfassungsgericht = new Bundesverfassungsgericht(bvgstadt, grundgesetz, bundesverfassungsgaerichtpresident);
//      bundesverfassungsgericht.setzeGrundgesetz(grundgesetz);
//
//      
//      AusgabeFenster aus = new AusgabeFenster();
//      
//      aus.ausgeben("Anzahl der (eingepflegten) Minister in Bayern: " + bundesland1.liefereLandesregierung().liefereAnzahlMinister());
//      aus.ausgeben("Nachname des Bundestagspraesidenten: " + bundestag.liefereBundestagspraesident().liefereNachname());
//      aus.ausgeben("Liefere Bundesgesetz Entstehungsjahr: " + bundesverfassungsgericht.liefereGrundgesetz().liefereEntstehungsjahr());


  }

}

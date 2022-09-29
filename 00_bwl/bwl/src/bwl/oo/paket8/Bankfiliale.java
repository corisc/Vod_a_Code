package bwl.oo.paket8;

import bwl.oo.paket6.Filiale;

import java.util.Vector;

public class Bankfiliale {
    public Vector<Konto> konten = new Vector<Konto>();
    int BankID;
    String Name;

    public Bankfiliale(int BankID, String Name) {
        this.BankID = BankID;
        this.Name = Name;
    }

    public void fuegeKontoHinzu(Konto konto){
        this.konten.add(konto);
    }

    public Vector<Konto> getKonten() {
        return konten;
    }

    public Konto loescheKonto(int kontoID){
        for(Konto ko : konten) {
            if(ko.getKontoID() == kontoID){
                konten.remove(ko);
                return ko;
            }
        }

        System.out.println("Unter der" + kontoID + " ist kein Konto vorhanden");
        return null;

    }

    public void setKonten(Vector<Konto> konten) {
        this.konten = konten;
    }

    public int getBankID() {
        return BankID;
    }

    public void setBankID(int bankID) {
        BankID = bankID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

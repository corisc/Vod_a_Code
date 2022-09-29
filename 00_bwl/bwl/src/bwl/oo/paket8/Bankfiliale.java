package bwl.oo.paket8;

import bwl.oo.paket10.Employee;
import bwl.oo.paket6.Filiale;
import bwl.oo.paket6.Kunde;

import java.util.ArrayList;
import java.util.Vector;

public class Bankfiliale {
    public Vector<Konto> konten = new Vector<Konto>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Kunde> kunde = new ArrayList<Kunde>();
    int BankID;
    String Name;
    public Bankfiliale(int BankID, String Name) {
        this.BankID = BankID;
        this.Name = Name;
    }
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }
    public void addKunde(Kunde k) {
        kunde.add(k);
    }

    public ArrayList<Kunde> getKunde() {
        return kunde;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
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

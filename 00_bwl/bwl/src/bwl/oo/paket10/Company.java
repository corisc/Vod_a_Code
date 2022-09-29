package bwl.oo.paket10;


import bwl.oo.paket6.Kunde;
import bwl.oo.paket8.Konto;

import java.util.ArrayList;
import java.util.logging.Level;


/**
 * A company has a name, a bank account and a list of customers
 */
public class Company {

    private String name;
    private Konto konto;
    private ArrayList<Kunde> customer = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public void addCustomer(Kunde customer){
        this.customer.add(customer);
    }

    public int amountOfCustomer(){
        return customer.size();
    }

}


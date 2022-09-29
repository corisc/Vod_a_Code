package bwl.oo.paket8;

import java.util.Vector;

public class Bezirk {

    public Vector<Bankfiliale> bankfilialen = new Vector<Bankfiliale>();
    String name;
    int bezirkID;
    public Bezirk(String name, int bezirkID) {
        this.name = name;
        this.bezirkID = bezirkID;
    }

    public String getName() {
        return name;
    }

    public void fuegeFilialeHinzu(Bankfiliale Bankfiliale){
        this.bankfilialen.add(Bankfiliale);
    }
    public int wievieleFilialenHatDieserBezirk(){
        return bankfilialen.size();
    }

    public Vector<Bankfiliale> getBankfilialen() {
        return bankfilialen;
    }

    public void setBankfilialen(Vector<Bankfiliale> bankfilialen) {
        this.bankfilialen = bankfilialen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBezirkID() {
        return bezirkID;
    }

    public void setBezirkID(int bezirkID) {
        this.bezirkID = bezirkID;
    }
}


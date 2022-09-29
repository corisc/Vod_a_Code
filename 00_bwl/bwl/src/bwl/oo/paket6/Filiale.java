package bwl.oo.paket6;

/**
 * Klasse Filiale hat nur eine Eigenschaft: Standort
 * */

public class Filiale {

    private String standort;

    public Filiale(String standort) {
        this.standort = standort;
    }

    public String getStandort() {
        return standort;
    }

    public void setStandort(String place){
        standort = place;
    }

}



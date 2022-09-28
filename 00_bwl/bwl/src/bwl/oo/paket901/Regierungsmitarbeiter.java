package bwl.oo.paket901;
import java.util.Random;

public class Regierungsmitarbeiter {
    private String name;
    private String vorname;
    private String persNr;
    private Partei partei;

    public Regierungsmitarbeiter(String name, String vorname, Partei partei){
        this.name = name;
        this.vorname = vorname;
        this.partei = partei;
        Random random = new Random();
        this. persNr = partei.getParteiId() + random.nextInt(99999 - 1) + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getPersNr() {
        return persNr;
    }

    public void setPersNr(String persNr) {
        this.persNr = persNr;
    }

    public Partei getPartei() {
        return partei;
    }

    public void setPartei(Partei partei) {
        this.partei = partei;
    }
}




package bwl.oo.paket8;

public class Konto {

    private int KontoID;
    private String Inhaber;
    private Integer Kontostand;

    public Konto (int KontoID, String Inhaber, Integer Kontostand) {
        super();
        this.KontoID = KontoID;
        this.Inhaber = Inhaber;
        this.Kontostand = Kontostand;
    }



    public int getKontoID() {
        return KontoID;
    }

    public void setKontoID(int kontoID) {
        KontoID = kontoID;
    }

    public String getInhaber() {
        return Inhaber;
    }

    public void setInhaber(String inhaber) {
        Inhaber = inhaber;
    }

    public Integer getKontostand() {
        return Kontostand;
    }

    public void setKontostand(Integer kontostand) {
        Kontostand = kontostand;
    }

    public String zeigeKontostand() {
        return "Konto{" +
                "Kontostand=" + Kontostand +
                '}';
    }

    @Override
    public String toString() {
        return "Konto{" +
                "KontoID=" + KontoID +
                ", Inhaber='" + Inhaber + '\'' +
                ", Kontostand=" + Kontostand +
                '}';
    }
}


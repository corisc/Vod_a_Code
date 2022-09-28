package bwl.oo.paket8;

public class Girokonto {
    int Sollzinsen;
    int HabenZinsen;

    public Girokonto(int Sollzinsen, int HabenZinsen) {
        this.Sollzinsen = Sollzinsen;
        this.HabenZinsen = HabenZinsen;
    }

    public int getSollzinsen() {
        return Sollzinsen;
    }

    public void setSollzinsen(int sollzinsen) {
        Sollzinsen = sollzinsen;
    }

    public int getHabenZinsen() {
        return HabenZinsen;
    }

    public void setHabenZinsen(int habenZinsen) {
        HabenZinsen = habenZinsen;
    }
}

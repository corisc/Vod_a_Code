package bwl.oo.paket3;

public class Verbindung {
    private int h;
    private int f;
    private int a;
    private int v;
    private int k;
    public void setH(int h) {
        this.h = h;
    }
    public void setA(int a) {this.a = a;}
    public void setF(int f) {this.f = f;}
    public void setV(int v) {this.v = v;}
    public void setK(int k) {
        this.k = k;
    }

    public int getH() {
        return h;
    }
    public int getA() {
        return a;
    }
    public int getF() {
        return f;
    }
    public int getV() {
        return v;
    }
    public int getK() {
        return k;
    }

    public Verbindung(int hIndex, int fIndex, int aIndex, int vIndex, int kIndex) {
        setH(hIndex);
        setF(fIndex-2);
        setA(aIndex-2);
        setV(vIndex-2);
        setK(kIndex-2);
    }
//    public Verbindung(int hIndex, int fIndex, int aIndex) {
//        setH(hIndex);
//        setF(fIndex-2);
//        setA(aIndex-2);
//        setV(-1);
//    }
    public Verbindung(String fORaORv, int hIndex, int Index) {
        if (fORaORv=="f"){
            setH(hIndex);
            setF(Index);
            setA(-1);
            setV(-1);
            setK(-1);
        }
        if (fORaORv=="a"){
            setH(hIndex);
            setF(-1);
            setA(Index);
            setV(-1);
            setK(-1);
        }
        if (fORaORv=="v"){
            setH(hIndex);
            setF(-1);
            setA(-1);
            setV(Index);
            setK(-1);
        }
        if (fORaORv=="k"){
            setH(hIndex);
            setF(-1);
            setA(-1);
            setV(-1);
            setK(Index);
        }
    }
}
package bwl.oo.paket3;

import java.util.ArrayList;

public class XVerbindung {
    private int h;
    private int f;
    private int a;
    private int v;
    public void setH(int h) {
        this.h = h;
    }
    public void setA(int a) {this.a = a;}
    public void setF(int f) {this.f = f;}
    public void setV(int v) {this.v = v;}
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
    public XVerbindung(int hIndex, int fIndex, int aIndex, int vIndex) {
        setH(hIndex);
        setF(fIndex-2);
        setA(aIndex-2);
        setV(vIndex-2);
    }
    public XVerbindung(int hIndex, int fIndex, int aIndex) {
        setH(hIndex);
        setF(fIndex-2);
        setA(aIndex-2);
        setV(-1);
    }
    public XVerbindung(String fORaORv, int hIndex, int Index) {
        if (fORaORv=="f"){
            setH(hIndex);
            setF(Index);
            setA(-1);
            setV(-1);
        }
        if (fORaORv=="a"){
            setH(hIndex);
            setF(-1);
            setA(Index);
            setV(-1);
        }
        if (fORaORv=="v"){
            setH(hIndex);
            setF(-1);
            setA(-1);
            setV(Index);
        }
    }
}
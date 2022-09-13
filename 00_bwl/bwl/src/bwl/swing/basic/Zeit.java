package bwl.swing.basic;

import java.text.DecimalFormat;


public class Zeit {

    static int aus = 0;
    static String sekunden = "";
    static int sekundenZaehler = 0;
    static String minuten = "";
    static int minutenZaehler = 0;
    static String stunden = "";
    static int stundenZaehler = 0;
   
    public Zeit() {
    }
   
    public void setAus(int ausschalter) {
        aus = ausschalter;
    }
   
    public void setEin(int einschalten) {
        aus = einschalten;
    }

    public void macheZeit() {
        sekundenZaehler++;
        if(sekundenZaehler<=59) {  
            DecimalFormat df = new DecimalFormat("00");
            sekunden = df.format(sekundenZaehler);
        } else {
            sekundenZaehler = 0;   
            minutenZaehler++;
        }
       
        if(minutenZaehler<=59) {
            DecimalFormat df = new DecimalFormat("00");
            minuten = df.format(minutenZaehler);
            } else {
                minutenZaehler = 0;
                stundenZaehler++;
            }
       
        DecimalFormat df = new DecimalFormat("00");
        stunden = df.format(stundenZaehler);
       
        Stoppuhr.lblzeit.setText(stunden + ":" + minuten + ":" + sekunden);
    }
   
}
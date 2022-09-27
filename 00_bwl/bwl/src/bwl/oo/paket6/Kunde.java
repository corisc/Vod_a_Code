package bwl.oo.paket6;

import java.util.Random;



public class Kunde extends Person{
    private String vorname;
    private String nachname;

    public Kunde(String vorname, String nachname){
        super(nachname, nachname);
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setVorname(String firstname){
        vorname = firstname;
    }

    public void setNachname(String lastname){
        nachname = lastname;
    }

    public int gewinnspiel(){
        Random rand = new Random();
        int n = rand.nextInt(800);
        int number = (int) Math.random()*n + 76;
        return number;

    }

}


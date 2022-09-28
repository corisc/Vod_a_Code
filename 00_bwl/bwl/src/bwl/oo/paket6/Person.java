package bwl.oo.paket6;

/***
 * Klasse Person ist eine Super-Klasse, die hat
 * zwei Eigenschaften Vorname und Nachmane
 */

public abstract class Person {
    public String vorname;
    public String nachname;

    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }
}

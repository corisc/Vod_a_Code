package bwl.main.bitcoin2;

public class Block {

//Variablen

   public String hash;
   public String previousHash;
   private String data;
   private int number;
   private int nonce;

//GETTER und SETTER fuer diese Klasse


   public String getHash() {
       return hash;
   }

   public void setHash(String hash) {
       this.hash = hash;
   }

   public String getPreviousHash() {
       return previousHash;
   }

   public void setPreviousHash(String previousHash) {
       this.previousHash = previousHash;
   }

   public String getData() {
       return data;
   }

   public void setData(String data) {
       this.data = data;
   }

   public int getNumber() {
       return number;
   }

   public void setNumber(int number) {
       this.number = number;
   }


   public int getNonce() {
       return nonce;
   }


//Konstruktor fuer einen Block


   public Block(int number, String data,String previousHash ) {
       this.data = data;
       this.previousHash = previousHash;
       this.hash = berechneHash();
       this.number = number;

   }

//Methode zur Berechnung des Hashes mit der Klasse Hash

   public String berechneHash() {
       Hash h1 = new Hash();
       String hash = h1.hashfunktion(previousHash + Integer.toString(nonce) + data);
       return hash;

   }

//Methode um einen Block mit einer gegebenen Schwierigkeit zu berechnen

   public String mineBlock(int schwierigkeit){
       String target = new String(new char[schwierigkeit]).replace('\0','0');
       hash = "Zuruecksetzen des Hashes";
       nonce = 0;
       while(!hash.substring(0,schwierigkeit).equals(target)){
           nonce ++;
           this.hash = berechneHash();
       }
       System.out.println("Block mined!! My Hash is: " + hash);
       return hash;
   }




}


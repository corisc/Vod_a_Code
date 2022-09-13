package bwl.main.bitcoin2;

import java.util.ArrayList;


public class Chain {

// Variablen + Erstellung der Blockchain als ArrayList

    public static int getSchwierigkeit() {
        return schwierigkeit;
    }

    public static void setSchwierigkeit(int schwierigkeit) {
        Chain.schwierigkeit = schwierigkeit;
    }

    public static int schwierigkeit;
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

// GETTER und SETTER fuer diese Klasse

    public void setschwierigkeit(int schwierigkeit){
        this.schwierigkeit=schwierigkeit;
    }

    public int getschwierigkeit(){return this.schwierigkeit;}


// Konstruktor mit dem die Schwierigkeit der Berechnung festgelegt wird

    public Chain() {
        this.schwierigkeit = schwierigkeit;
        this.schwierigkeit= 3;


    }

// Methode um einen Block der Blockchain hinzuzufuegen


    public void addBlock(int number){

        if(number==0) {

            blockchain.add(new Block(0, "", ""));
            System.out.println(blockchain.get(0).getData());
            blockchain.get(0).mineBlock(schwierigkeit);

        }else {


            String x = String.valueOf(number);
            blockchain.add(new Block(number, "", blockchain.get(blockchain.size() - 1).hash));
            blockchain.get(number).mineBlock(schwierigkeit);

        }




        System.out.println("\nBlockchain is Valid: " + isChainValid());


    }

// Methode um zu pruefen ob die Kette richtig ist

    public static Boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;

        for(int i=1;i < blockchain.size();i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            //Prueft ob der Hash des Blocks genauso ist wie ein neu berechneter

            if(!currentBlock.hash.equals(currentBlock.berechneHash())){
                System.out.println("Current Hashes not equal");
                return false;
            }

            //Prueft ob der Hash vom Block vorher der Previous Hash vom derzeitigen Block ist

            if(!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("Previous Hash not equal");
                return false;
            }


        }
        return true;
    }

// SETTER und GETTER fuer Block

    public void setData(int blocknummer, String data){
        blockchain.get(blocknummer).setData(data);
    }

    public String getDataofBlock(int blocknummer){
        return blockchain.get(blocknummer).getData();
    }

    public String mineBestimmtenBlock(int blocknummer){


            return blockchain.get(blocknummer).mineBlock(this.schwierigkeit);

    }


}


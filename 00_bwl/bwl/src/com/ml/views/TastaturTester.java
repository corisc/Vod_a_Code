package com.ml.views;

import java.util.Random;

public class TastaturTester {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ZeichenFenster z1 = new ZeichenFenster("Aufzugspiel");
    
    z1.textZeichnen("Verbleibende Zeit", 100, 700);
    int [] coinCounter ={0, 0};
    while(true){
      printEnvironment(z1);
      
      z1.loeschbarenTextZeichnen("Press any key to start game!", 150, 300,40, "rot");
      String letzteTaste = Tastatur.liefereTastaturEingabe(z1);
      System.out.println(""+letzteTaste);
      
     
      long endTime = System.currentTimeMillis()+180000;
      enterGame(z1, endTime);
      
      boolean[][] goldCoins = new boolean[400][400];
      boolean [][] silverCoins = new boolean[400][400];
      setCoinsRandom(goldCoins);
      setCoinsRandom(silverCoins);
   
      //0 = gold, 10 silver
      
      
      
      startPlaying(z1, endTime, coinCounter, goldCoins, silverCoins);
      
      
      //z1.polygonZeichnen(6, new Farbe(255,255,0), 100,100,100,200,200,200,200,100,100,100);
    }
    
  }
  
 
  private static void setCoinsRandom(boolean[][] coins) {
    Random random = new Random ();
    for(int i = 0; i<5; i++) {
      int x =(random.nextInt(400/5))*5;
      int y =(random.nextInt(400/5))*5;
      coins[x][y]=true;
      System.out.println("coin set at "+x+","+y);
    }
    
  }


  private static void startPlaying(ZeichenFenster z1, long endTime, int[] coinCounter, boolean[][] goldCoins, boolean[][] silverCoins) {
    int pos[] = {205, 150};
    
    z1.loeschbarenTextZeichnen(""+(char)165, pos[0], pos[1], 28);
    do {
      
     
      String letzteTaste = Tastatur.liefereTastaturEingabe(z1);
      z1.loescheAlleTexte();
      
      
      
      
      System.out.println(""+letzteTaste);
      char key = letzteTaste.charAt(0);
      switch(key){
      case 'w':
        if(pos[1]<=475) pos[1]+=5;
        break;
      case 'a':
        if(pos[0]>=205) pos[0]-=5;
        break;
      case 's':
        if(pos[1]>=105)pos[1]-=5;
        break;
      case 'd':
        if(pos[0]<=580)
        pos[0]+=5;
        break;
      default:
        break;
    }
      if(goldCoins[pos[0]-200][pos[1]-100]){
        coinCounter[0]++;
        z1.loeschbarenTextZeichnen("Congrats! \n You found a gold coin!", 400, 400, "rot");
      }
      if(silverCoins[pos[0]-200][pos[1]-100]){
        coinCounter[1]++;
      }
      
      z1.loeschbarenTextZeichnen(""+(char)165, pos[0], pos[1], 28);
      z1.loeschbarenTextZeichnen(""+(endTime-System.currentTimeMillis())/1000+" seconds", 300, 700, 20);
      z1.loeschbarenTextZeichnen(""+coinCounter[0], 830, 580);
      z1.loeschbarenTextZeichnen(""+coinCounter[1], 830, 550);
      
      if(System.currentTimeMillis()>=endTime){
        coinCounter[0] = 0;
        coinCounter[1]=0;
        break;
      }
      
    } while ((pos[0]!=205 || pos[1]!=150));
    
    leaveGame(z1, coinCounter);
    
    
  }
  
  private static void leaveGame(ZeichenFenster z1, int[] coinCounter) {
    for(int i= 150; i<=555; i++){
      z1.loeschbarenTextZeichnen(""+(char)165, 110, i, 28);
      z1.loescheAlleTexte();
    }
    
    for (int i= 210; i>=210; i--){
      z1.loeschbarenTextZeichnen(""+(char)165, i, 150, 28);
      z1.loescheAlleTexte();
    }
    for(int i= 105; i<=550; i++){
      z1.loeschbarenTextZeichnen(""+(char)165, i, 550, 28);
      z1.loescheAlleTexte();
      }
      
      
      
      
      
    
  }


  private static long printTime(ZeichenFenster z1, long endTime){
    z1.loeschbarenTextZeichnen(""+(endTime-System.currentTimeMillis()), 300, 600);
    return endTime-System.currentTimeMillis();
  }

  private static void enterGame(ZeichenFenster z1, long endTime) {
    
    for(int i= 550; i>=105; i--){
    z1.loeschbarenTextZeichnen(""+(char)165, i, 550, 28);
    z1.loescheAlleTexte();
    }
    
    for(int i= 555; i>=150; i--){
      z1.loeschbarenTextZeichnen(""+(char)165, 110, i, 28);
      z1.loescheAlleTexte();
    }
    
    for (int i= 150; i<=210; i++){
      z1.loeschbarenTextZeichnen(""+(char)165, i, 150, 28);
      z1.loescheAlleTexte();
    }
    
    
  }

  private static void printEnvironment(ZeichenFenster z1) {
    // Draw walking line
    z1.linieZeichnen(160, 550, 600, 550);
    // Draw elevator
    z1.polygonZeichnen(5, new Farbe( 255, 255 , 255), 100, 100, 100, 550, 150, 550, 150, 100, 100, 100);
    
    //draw game area
    //spacing: l: 200, u: 100
    //wxh: 300x300
    z1.linieZeichnen(200,100,200,500);
    z1.linieZeichnen(200, 500, 600, 500);
    z1.linieZeichnen(600, 500, 600, 100);
    z1.linieZeichnen(200, 100, 600, 100);
    
    //draw going back area
    z1.polygonZeichnen(5, new Farbe (255, 255, 0), 200, 150, 200, 180, 220, 180, 220, 150);
    
    z1.textZeichnen("Coins in this game:", 700, 630, 20);
    z1.textZeichnen("o", 700, 570, 50, "gelb");
    z1.textZeichnen("Golden Coins:", 730, 580);
    z1.textZeichnen("o", 700, 540, 50, "grau");
    z1.textZeichnen("Silver Coins:", 730, 550);
    
    
  }
  
  

}


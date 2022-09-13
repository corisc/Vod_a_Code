package bwl.main.bitcoin;

public class Main {

  static Controller bitcoinController;

  public static void main(String []args){
      bitcoinController  = new Controller();

      bitcoinController.showView();
  }



}


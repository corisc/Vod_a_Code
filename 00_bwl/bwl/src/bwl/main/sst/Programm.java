package bwl.main.sst;

public class Programm {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new EinleserDateiImpl().leseConfigEin();
    new EinleserDBImpl().leseConfigEin();
  }

}


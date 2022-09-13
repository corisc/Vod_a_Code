package bwl.oo.paket5;

public class IndexCounter {

  private int index;
  
  public IndexCounter() {
    this.index = 0;
  }
  
  public int liefereIndex(){
    this.index++;
    return this.index-1;
  }

}


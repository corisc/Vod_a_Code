package bwl.oo.paket5;

public abstract class One {

  protected String oneName1;
  protected String oneName2;
  protected String oneName3;
  protected String oneName4;
  protected int oneNumber1;
  protected int oneNumber2;
  protected int oneNumber3;
  protected int oneNumber4;

  protected One(){
  }
  
  protected One(String oneName1){
    this.oneName1 = oneName1;
  }

  protected One(String oneName1, String oneName2){
    this.oneName1 = oneName1;
    this.oneName2 = oneName2;
  }

  protected One(int oneIndex, String oneName1, String oneName2){
    this.oneNumber1 = oneIndex;
    this.oneName1 = oneName1;
    this.oneName2 = oneName2;
  }
}


package bwl.oo.paket7;

public class One{

  private String oneName1;
  private String oneName2;
  private String oneName3;
  private String oneName4;
  private int oneNumber1;
  private int oneNumber2;
  private int oneNumber3;
  private int oneNumber4;

  One(){
  }
  
  One(String oneName1){
    this.oneName1 = oneName1;
  }

  One(String oneName1, String oneName2){
    this.oneName1 = oneName1;
    this.oneName2 = oneName2;
  }

  One(int oneIndex, String oneName1, String oneName2){
    this.oneNumber1 = oneIndex;
    this.oneName1 = oneName1;
    this.oneName2 = oneName2;
  }

  public String getOneName1() {
    return oneName1;
  }

  public void setOneName1(String oneName1) {
    this.oneName1 = oneName1;
  }

  public String getOneName2() {
    return oneName2;
  }

  public void setOneName2(String oneName2) {
    this.oneName2 = oneName2;
  }

  public String getOneName3() {
    return oneName3;
  }

  public void setOneName3(String oneName3) {
    this.oneName3 = oneName3;
  }

  public String getOneName4() {
    return oneName4;
  }

  public void setOneName4(String oneName4) {
    this.oneName4 = oneName4;
  }

  public int getOneNumber1() {
    return oneNumber1;
  }

  public void setOneNumber1(int oneNumber1) {
    this.oneNumber1 = oneNumber1;
  }

  public int getOneNumber2() {
    return oneNumber2;
  }

  public void setOneNumber2(int oneNumber2) {
    this.oneNumber2 = oneNumber2;
  }

  public int getOneNumber3() {
    return oneNumber3;
  }

  public void setOneNumber3(int oneNumber3) {
    this.oneNumber3 = oneNumber3;
  }

  public int getOneNumber4() {
    return oneNumber4;
  }

  public void setOneNumber4(int oneNumber4) {
    this.oneNumber4 = oneNumber4;
  }
  
}


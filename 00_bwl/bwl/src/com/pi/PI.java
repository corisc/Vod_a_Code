package com.pi;

public class PI {

  public enum TRAIN {
    DST,
    PST
  }
  
  int year;
  int number;
  TRAIN train;
  
  
  
  public PI(TRAIN newTrain, int newYear, int newNumber) {
    this.year = newYear;
    this.number = newNumber;
    this.train = newTrain;
  }
  
  public String getCombinedNumberOfPI(){
    return this.year + "-" + this.number;
  }

  public String getTrain() {
    return this.train.toString();
  }
  
  
  

}


package com.ml.utils;

import java.util.Random;



public final class Gauss {

  public static void main(String... aArgs){
    Gauss gaussian = new Gauss();
    double MEAN = 12119; 
    double VARIANCE = 40;
    for (int idx = 1; idx <= 10; ++idx){
      log("Generated : " + gaussian.getGaussian(MEAN, VARIANCE));
    }
  }

  private Random fRandom = new Random();

  public double getGaussian(double aMean, double aVariance){
    return aMean + fRandom.nextGaussian() * aVariance;
  }

  private static void log(Object aMsg){
    System.out.println(String.valueOf(aMsg));
  }
} 

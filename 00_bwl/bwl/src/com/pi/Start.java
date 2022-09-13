package com.pi;

public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    PI pi1 = new PI(PI.TRAIN.DST, 22, 16);
    
    System.out.println(""+pi1.getCombinedNumberOfPI());
    System.out.println(""+pi1.getTrain());
    
    RTE eble = new RTE("Markus", "Eble", "VF");
    SA sittel = new SA("Niklas", "Sittel", "VF");
    
    System.out.println(""+ eble.getNachname());
    System.out.println(""+ sittel.getNachname());
    sittel.setTerminEnablerFreigabe(System.currentTimeMillis());
    System.out.println(""+ sittel.getTerminEnablerFreigabe());
    
  }

}


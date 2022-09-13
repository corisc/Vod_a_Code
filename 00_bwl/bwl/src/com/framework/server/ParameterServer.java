package com.framework.server;

import java.util.Properties;

import com.ml.utils.Helfer;
import com.ml.views.DatenReihe;

public class ParameterServer extends Thread{

  /** Fuer eine Test Main
    ParameterServer ps = new ParameterServer();
    ps.starten();
    Helfer h = new Helfer();
    while(!ps.datenEmpfangen()){
      System.out.println("wert: " + ps.holeLetzteParameter());
    }
   */

  public static void main(String args[]){
    ParameterServer ps = new ParameterServer();
    ps.starten();
    Helfer h = new Helfer();
    while(!ps.datenEmpfangen()){
      System.out.println("wert: " + ps.holeLetzteParameter());
    }
    
  }
  
  private Properties parameter = new Properties();
  private boolean    datenEmpfangen = false;

  public ParameterServer() {
  }
  
  public void run(){
    this.starten();
  }
  
  public void starten(){
    Helfer helfer = new Helfer();
    BasicServer basicServer = new BasicServer(this);
    basicServer.start();
  }
  
  public void empfange(Properties para){
    System.out.println("empfange: " + para);
    if(para == null){
      
    }
    else{
      this.parameter = para;
      this.datenEmpfangen = true;
    }
  }
  
  public Properties holeLetzteParameter(){
    this.datenEmpfangen = false;
    return this.parameter;
  }

  public boolean datenEmpfangen() {
    return datenEmpfangen;
  }
  
  
  

}

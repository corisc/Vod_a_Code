package com.programs.usbcopier.copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class RoboCopy extends Thread{

  private long                  sizeMes         = 0;
  private ICheckEvent           checkEvent;
  private String                sourceDir;             
  private String                destDir;
  private boolean               done            = false;
  
  public RoboCopy(ICheckEvent checkEvent, String sourceDir, String destDir){
    super();
    this.checkEvent = checkEvent;
    this.sourceDir  = sourceDir;
    this.destDir    = destDir;
    this.sourceDir.replace("/", "\\");
    this.destDir.replace("/", "\\");
    
  }
  
  public void run(){
    this.call();
  }
  
  public void call(){
    this.callSystemProcess(false, new String[]{("/c robocopy " + this.sourceDir + " " + this.destDir + " /MIR")}, checkEvent);

//    File f = new File("c:/0_ml/0_ml_muell/zwei/AdbeRdr920_de_DE.exe");
//    f.delete();
    
  }
    
  public void analyse(){
  }
  
  public boolean callSystemProcess(boolean debug, String[] params, ICheckEvent checkEvent){
    OutputStream    stdin = null;
    String          line  = "";

    try{
      ProcessBuilder launcher = new ProcessBuilder();
      //Map<String, String> environment = launcher.environment();
      launcher.redirectErrorStream(true);
  
      // Befehle aufbereiten
      String[] uebergabeParameter = new String[1 + params.length];
      if(debug){
        System.out.println("p: " + params.length);
      }
      for(int t=1; t<=params.length; t++){
        if(debug){
          System.out.println("!! " + params[t-1]);
        }
        uebergabeParameter[t] = params[t-1];
      }

      uebergabeParameter[0] = "cmd.exe";
      
      if(debug){
        System.out.println("aufruf mit");
        for(String u : uebergabeParameter){
          System.out.println("- " + u);
        }
      }
      //environment.put("name", "var");
      launcher.command(uebergabeParameter);
      Process p = launcher.start(); // And launch a new process
      stdin = p.getOutputStream ();

      BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
      while ((line = output.readLine()) != null){
        if(debug){
          System.out.println(line);
        }
        checkEvent.check(line);
      }
  
      // The process should be done now, but wait to be sure.
      p.waitFor();
      this.done = true;
    }
    catch(Exception e){
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  public boolean isDone() {
    return done;
  }

  public static void main(String[] args) {
//    TestCheckEvent testCheckEvent = new TestCheckEvent();
//    RoboCopy r = new RoboCopy(testCheckEvent);
//    r.start();
//    System.out.println("done");
  }

}


package com.ml.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.conf.BasicEnvConfiguration;

/**
 * @author marleu12224
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class Helfer {
	
	public String readString(){
		String inputString = null;
		
		byte[] out = new byte[100];
		try
		{
			System.in.read(out);
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		int i;
		for(i = 0; ; i++)
		{
			if(out[i] == '\n')
				break;
		}
		i--;
		byte[] out2 = new byte[i];
		for(i = 0; i < out2.length ; i++)
		{
			out2[i] = out[i];
		}		
		
		inputString = new String(out2);
		return inputString;
	}
	
	public int readInt(){
		String inputString = null;
		
		byte[] out = new byte[100];
		try
		{
			System.in.read(out);
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		int i;
		for(i = 0; ; i++)
		{
			if(out[i] == '\n')
				break;
		}
		i--;
		byte[] out2 = new byte[i];
		for(i = 0; i < out2.length ; i++)
		{
			out2[i] = out[i];
		}		
		
		inputString = new String(out2);
		return new Integer (inputString).intValue();
	}
	
	public void warteSeks(int sekunden){
	  try {
        Thread.sleep(sekunden * 1000);
      }
      catch (InterruptedException e){
        e.printStackTrace();
      }
	}
	
    public void warteMillis(int millis){
      try {
        Thread.sleep(millis);
      }
      catch (InterruptedException e){
        e.printStackTrace();
      }
    }
	
    public String liefereZeit(){
      String result = "";
      Date d = new Date();
      SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      DATE_FORMAT.setLenient(false);

      synchronized(DATE_FORMAT){
        result = DATE_FORMAT.format(d);
      }
      
      return result;
    }
    
    public String aktuellesArbeitsverzeichnis(){
      if(BasicEnvConfiguration.HELPER_ARBEITSVERZEICHNIS_OVERWRITE != null){
        return BasicEnvConfiguration.HELPER_ARBEITSVERZEICHNIS_OVERWRITE;
      }
      String result = "c:/bwl";
      try{
        // Fuer SQL Fenster
        String einsDrueber = new File(System.getProperties().getProperty("user.dir")).getParent();
        System.out.println("user.dir: " + einsDrueber);
        String zweiDrueber = new File(einsDrueber).getParent();
        String dreiDrueber = new File(zweiDrueber).getParent();
        result = dreiDrueber;
      }
      catch(Exception e){
        String workspaceDir = System.getProperties().getProperty("user.dir");
        System.out.println("Arbeitsverzeichnis konnte nicht festgestellt werden. Es wird genommen: " + workspaceDir);
        return workspaceDir;
      }
      
      // pruefen ob 50_daten dort existiert
      
      System.out.println("AZ: " + result);
      return result;
    }
    
    public int liefereZufallsZahl1bis100(){
        return (int)(Math.random() * 100);
      }
    public int liefereZufallsZahl1bis1000(){
      Random rn = new Random();
      return (int)(Math.random() * 1000);
    }
    }


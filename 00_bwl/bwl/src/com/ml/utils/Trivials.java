package com.ml.utils;

import java.io.IOException;

/**
 * @author marleu12224
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class Trivials {
	
	public static String readString(){
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
	
	public static int readInt(){
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
	
	public static void warteSeks(int sekunden){
	  try {
        Thread.sleep(sekunden * 1000);
      }
      catch (InterruptedException e){
        e.printStackTrace();
      }
	}
	
    public static void warteMillis(int millis){
      try {
        Thread.sleep(millis);
      }
      catch (InterruptedException e){
        e.printStackTrace();
      }
    }
	
}

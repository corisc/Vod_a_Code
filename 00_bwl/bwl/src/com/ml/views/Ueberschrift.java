package com.ml.views;

public class Ueberschrift {
	
	private String textzeile = "";
	
	public String getTextzeile() {
		return textzeile;
	}

	public void setTextzeile(String textzeile) {
		this.textzeile = textzeile;
	}

    public void setTextzeile(int zahl) {
      try{  
        this.textzeile = String.valueOf(zahl);
      }
      catch(Exception e){
        this.textzeile = "zahl konnte nicht gelesen werden";
      }
    }

    public Ueberschrift(String textzeile){
		this.textzeile = textzeile;
	}

    public Ueberschrift(int zahl){
      try{  
        this.textzeile = String.valueOf(zahl);
      }
      catch(Exception e){
        this.textzeile = "zahl konnte nicht gelesen werden";
      }
    }

}

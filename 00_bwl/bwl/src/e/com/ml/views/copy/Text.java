package e.com.ml.views.copy;

public class Text {
	
	private String     textzeile = "";
	private int        schriftgroesse = 12;
	
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

    public Text(String textzeile){
		this.textzeile = textzeile;
	}

    public Text(int zahl){
      try{  
        this.textzeile = String.valueOf(zahl);
      }
      catch(Exception e){
        this.textzeile = "zahl konnte nicht gelesen werden";
      }
    }

    public Text(double zahl){
      try{  
        this.textzeile = Double.toString(zahl);
      }
      catch(Exception e){
        this.textzeile = "zahl konnte nicht gelesen werden";
      }
    }

    public void setTextzeile(int zahl, int schriftgroesse) {
      this.schriftgroesse = schriftgroesse;
      try{  
        this.textzeile = String.valueOf(zahl);
      }
      catch(Exception e){
        this.textzeile = "zahl konnte nicht gelesen werden";
      }
    }

    public Text(String textzeile, int schriftgroesse){
      this.schriftgroesse = schriftgroesse;
      this.textzeile = textzeile;
    }

    public Text(int zahl, int schriftgroesse){
      this.schriftgroesse = schriftgroesse;
      try{  
        this.textzeile = String.valueOf(zahl);
      }
      catch(Exception e){
        this.textzeile = "zahl konnte nicht gelesen werden";
      }
    }

    public Text(double zahl, int schriftgroesse){
      this.schriftgroesse = schriftgroesse;
      try{  
        this.textzeile = Double.toString(zahl);
      }
      catch(Exception e){
        this.textzeile = "zahl konnte nicht gelesen werden";
      }
    }

    public int getSchriftgroesse() {
      return schriftgroesse;
    }
    
    
}

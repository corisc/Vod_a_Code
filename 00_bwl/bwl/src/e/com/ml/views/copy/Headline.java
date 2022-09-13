package e.com.ml.views.copy;

public class Headline {
	
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

    public Headline(String textzeile){
		this.textzeile = textzeile;
	}

    public Headline(int zahl){
      try{  
        this.textzeile = String.valueOf(zahl);
      }
      catch(Exception e){
        this.textzeile = "zahl konnte nicht gelesen werden";
      }
    }

}

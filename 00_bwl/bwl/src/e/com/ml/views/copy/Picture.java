package e.com.ml.views.copy;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import com.ml.utils.Helfer;

public class Picture
{
  private Image img;
  
  public Picture(String dateiname)
  {
    Helfer h = new Helfer();
    String pfad = h.aktuellesArbeitsverzeichnis() + "/50_daten/"+ dateiname;
    File f = new File(pfad);
    if(f.exists()){
      img = Toolkit.getDefaultToolkit().getImage(pfad);
    }
    else{
      System.out.println("Fehler: Es fehlt entweder des Verzeichnis " + h.aktuellesArbeitsverzeichnis() + "/50_daten/"+ " oder das Bildes existiert nicht namens: " + dateiname);
    }
  }
  
  public Picture(String dateiname, boolean mitPfad)
  {
    Helfer h = new Helfer();
    String pfad = dateiname;
    File f = new File(pfad);
    if(f.exists()){
      img = Toolkit.getDefaultToolkit().getImage(pfad);
    }
    else{
      System.out.println("Fehler: Es fehlt entweder des Verzeichnis " + h.aktuellesArbeitsverzeichnis() + "/50_daten/"+ " oder das Bildes existiert nicht namens: " + dateiname);
    }
  }

  public Image getImage()
  {
    return img;
  }
  
  
}

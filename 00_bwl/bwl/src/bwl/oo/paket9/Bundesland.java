package bwl.oo.paket9;

import java.util.ArrayList;
import java.util.Vector;


public class Bundesland {

  public String name;
  public Stadt hauptstadt; 
  private Landesparlament landesparlament;
  private Landesregierung landesregierung;
  private ArrayList<Landkreis> landkreise;

  public Bundesland(String name, Stadt hauptstadt, Landesparlament landesparlament, Landesregierung landesregierung) {
    this.name = name;
    this.hauptstadt = hauptstadt;
    this.landesparlament = landesparlament;
    this.landesregierung = landesregierung;
    this.landkreise = new ArrayList<Landkreis>();
  }

  
  //Landkreis
  public Landkreis liefereLandkreis(int landkreisSortiertNachAnlage) {
    if (landkreisSortiertNachAnlage < 1) {
      System.out.println("Es gibt keinen Landkreis mit der Nummer: "
          + landkreisSortiertNachAnlage);
      return null;
    }
    if (landkreisSortiertNachAnlage > this.landkreise.size()) {
      System.out.println("Es gibt keinen Landkreis mit der Nummer: "
          + landkreisSortiertNachAnlage);
      return null;
    }
    return landkreise.get(landkreisSortiertNachAnlage - 1);
  }
  
  public int liefereAnzahlLandkreise() {
	return landkreise.size();
  }
  
  public void setzeLandkreis(Landkreis landkreis) {
	landkreise.add(landkreis);
  }

  public Landesparlament liefereLandesparlament() {
    return landesparlament;
  }

  public void setzeLandesparlament(Landesparlament landesparlament) {
    this.landesparlament = landesparlament;
  }
  
  public Landesregierung liefereLandesregierung() {
    return landesregierung;
  }

  public void setzeLandesregierung(Landesregierung landesregierung) {
    this.landesregierung = landesregierung;
  }
}

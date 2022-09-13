package bwl.main.oo;

import com.conf.BasicEnvConfiguration;
import com.ml.utils.Dax;
import com.ml.utils.Kurs;

public class Boerse {
  private String standort;
  // DE0008469008
  private String wkn;
  private Dax dax = new Dax(BasicEnvConfiguration.PROXY_HOST, BasicEnvConfiguration.PROXY_PORT);

  public Boerse(String standort) {
    super();
    this.standort = standort;
  }
  
  public Kurs holeNeuenKurs(String wkn){
    return dax.getKurs();
  }
  
  

}


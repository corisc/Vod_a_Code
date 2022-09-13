package bwl.oo.paket901;

import java.util.ArrayList;

public class Bundesregierung {

	private ArrayList<Bundesminister> bundesminister = new ArrayList<Bundesminister>();
	private Bundeskanzler bundeskanzler;
	
	
    public Bundesregierung(Bundeskanzler bundeskanzler) {
      this.bundeskanzler = bundeskanzler;
    }


    
    ///////////////////////////////////////////////////////////////////////////////////
    
    public int lieferAnzahlBundesminister() {
      return bundesminister.size();
    }

    public void fuegeBundesministerHinzu(Bundesminister minister) {
      this.bundesminister.add(minister);
    }


    public Bundesminister liefereBundesminister(int bundesministerSortiertNachAnlage) {
      if (bundesministerSortiertNachAnlage < 1) {
        System.out.println("Es gibt keinen Bundesminister mit der Nummer: "
            + bundesministerSortiertNachAnlage);
        return null;
      }
      if (bundesministerSortiertNachAnlage > this.bundesminister.size()) {
        System.out.println("Es gibt kein Bundesminister mit der Nummer: "
            + bundesministerSortiertNachAnlage);
        return null;
      }
      return bundesminister.get(bundesministerSortiertNachAnlage - 1);
    }
    
   //////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Bundesminister> liefereAlleBundesminister() {
      return bundesminister;
    }
    public void setzeBundesminister(Bundesminister bundesminister) {
      this.bundesminister.add(bundesminister);
    }


    public Bundeskanzler liefereBundeskanzler() {
      return bundeskanzler;
    }
    public void setzeBundeskanzler(Bundeskanzler bundeskanzler) {
      this.bundeskanzler = bundeskanzler;
    }
}

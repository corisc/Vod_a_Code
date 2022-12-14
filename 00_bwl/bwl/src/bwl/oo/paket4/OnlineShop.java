package bwl.oo.paket4;

import java.util.Vector;


public class OnlineShop {
  
  public String name;
  public int handelsregisterEintrag;
  public Vector<Server> server = new Vector<Server>();
    
  public OnlineShop(String name, int handelsregisterEintrag) {
    super();
    this.name = name;
    this.handelsregisterEintrag = handelsregisterEintrag;
  }

  public Server liefereServer(String ipAdresse){
    if(ipAdresse == null || ipAdresse.length()<1){
      System.out.println("Es wurde nichts angegeben");
      return null;
    }
    for(Server f : this.server){
      if(f.ipAdresse.equalsIgnoreCase(ipAdresse)){
        return f;
      }
    }   
    System.out.println("Den Server: " + name + " gibt es nicht");
    return null;
  }

  public void fuegeServerHinzu(Server server){
    this.server.add(server);
  }

  public String werbungZeigen(){
    String aa = new String("Der Staubsauger BOBO5000 ist im Angebot für 199€");
    return aa;}
  public void setName(){
    this.name = name;}
  public String getName(){
    return name;}
  public void setHandelsregisterEintrag(){
    this.handelsregisterEintrag = handelsregisterEintrag;}
  public int getHandelsregisterEintrag(){
    return handelsregisterEintrag;}
}


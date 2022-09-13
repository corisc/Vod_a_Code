package bwl.oo.paket4;


public class Server {
  
  public String ipAdresse;
  public String domainName;
  public Rechenzentrum rechenzentrum;

  
  public Server(String ipAdresse, String domainName, Rechenzentrum rechenzentrum) {
    super();
    this.ipAdresse = ipAdresse;
    this.domainName = domainName;
    this.rechenzentrum = rechenzentrum;
  }


}


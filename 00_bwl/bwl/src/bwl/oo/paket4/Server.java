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
  public void setIpAdresse(){
    this.ipAdresse = ipAdresse;
  }
  public String getIpAdresse(){
    return ipAdresse;
  }
  public void setDomainName(){
    this.domainName = domainName;
  }
  public String getDomainName(){
    return domainName;
  }
  public void setRechenzentrum(){
    this.rechenzentrum = rechenzentrum;
  }
  public Rechenzentrum getRechenzentrum(){
    return rechenzentrum;
  }


}


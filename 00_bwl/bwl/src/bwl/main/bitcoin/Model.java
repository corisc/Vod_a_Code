package bwl.main.bitcoin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Model {

  String zuHashenderWert;
  String finalHash;


  public Model(){
      zurueckSetzen();

  }

  public String berechneHash(String zuHashenderWert) throws NoSuchAlgorithmException {


      this.zuHashenderWert = zuHashenderWert;

      MessageDigest md = MessageDigest.getInstance("SHA-256");

      byte[] hashObject = md.digest(zuHashenderWert.getBytes());

      StringBuffer finalHash = new StringBuffer();

      for(byte b : hashObject){
          finalHash.append(String.format("%02x",b & 0xff) );

      }

      this.finalHash = finalHash.toString();

      return finalHash.toString();
  }

  public String getZuHashenderWert() {
      return zuHashenderWert;
  }

  public void setZuHashenderWert(String zuHashenderWert) {
      this.zuHashenderWert = zuHashenderWert;
  }

  public String getFinalHash() {
      return this.finalHash;
  }

  public void setFinalHash(String finalHash) {
      this.finalHash = finalHash;
  }

  public void zurueckSetzen(){
      this.zuHashenderWert = "";
  }




}


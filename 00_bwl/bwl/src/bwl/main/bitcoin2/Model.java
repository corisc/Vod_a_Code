package bwl.main.bitcoin2;

public class Model {

  private Chain _chain;

  public Model(){

      this._chain = new Chain();

  }

  public void setMiningSchwierigkeit(int schwierigkeit){
      _chain.setschwierigkeit(schwierigkeit);
  }

  public void addBlock(int number){
      _chain.addBlock(number);
  }

  public void setData(int blocknummer, String data){
      _chain.setData(blocknummer,data);
  }

  public String mineBestimmtenBlock(int blocknummer){

      return _chain.mineBestimmtenBlock(blocknummer);
  }

  public String returnData(int blocknummer){
      return _chain.getDataofBlock(blocknummer);
  }


}


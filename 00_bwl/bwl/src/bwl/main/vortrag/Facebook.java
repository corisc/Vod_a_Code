package bwl.main.vortrag;

import java.util.ArrayList;

public class Facebook {
  
  static ArrayList<Person> personen = new ArrayList<Person>();
  
  
  static void nimmEineWeiterePersonauf(Person person){
    personen.add(person);
  }
  
  static int wievielePersonenSindDrin(){
    return personen.size();
  }
  
  static Person holePersonNachReihenfolge(int t){
    return personen.get(t);
  }
  
  
  

}


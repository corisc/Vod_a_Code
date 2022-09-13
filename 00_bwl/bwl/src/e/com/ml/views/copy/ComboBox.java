package e.com.ml.views.copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

public class ComboBox
{
  private String[] texts;
  private boolean clicked;
  JComboBox result;
  private MyActionListener myActionListener;

  public ComboBox()
  {
    
  }
  
  public ComboBox(String ... texts)
  {
    if(texts == null || texts.length == 0){
      System.out.println("Es muss mindestens ein Text fuer einen ComboBox angegeben werden.");
      System.exit(1);
    }
    this.texts = new String[texts.length+1];
    this.texts[0] = "---";
    for(int t=0;t<texts.length;t=t+1){
      this.texts[t+1] = texts[t];
    }
    this.myActionListener = new MyActionListener();
  }
  
  public JComboBox getComboBox()
  {
    this.result = new JComboBox(texts);
    this.result.addActionListener(this.myActionListener);
    return result;
  }
  
  public void eintragHinzufuegen(String eintrag){
    if(texts != null){
      int urlaenge = texts.length;
      String[] newtexts = new String[urlaenge+1];
      for(int t=0;t<urlaenge;t=t+1){
        newtexts[t] = texts[t];
      }
      newtexts[urlaenge] = eintrag;
      this.texts = newtexts;
    }
    else{
      this.myActionListener = new MyActionListener();
      this.texts = new String[1];
      this.texts[0] = eintrag;
    }
  }
  
  public void warteAufEingabe()
  {
    while(!myActionListener.getGeKlickt()){
    }
  }

  public boolean wurdeGedrueckt() {
    return myActionListener.getGeKlickt();
  }

  public int zahlDerEntscheidung(){
    return this.myActionListener.getWhichCommand()+1;
  }

  private class MyActionListener implements ActionListener{
    private int whichCommand = 0;
    private boolean geklickt = false;
    public void actionPerformed(ActionEvent e) {
      this.whichCommand = ((JComboBox)e.getSource()).getSelectedIndex();
      this.geklickt = true;
    }
    public int getWhichCommand() {
      return whichCommand;
    }
    public boolean getGeKlickt() {
      return geklickt;
    }
  }
}


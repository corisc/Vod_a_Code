package e.com.ml.views.copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu
{
  private String[] texts;
  private JMenuBar result;
  private MyActionListener myActionListener;
  
  public Menu(String ... texts)
  {
    if(texts == null || texts.length == 0){
      System.out.println("Es muss mindestens ein Text fuer einen ComboBox angegeben werden.");
      System.exit(1);
    }
    this.texts = texts;
    this.myActionListener = new MyActionListener();
  }
  
  public JMenuBar getJMenuBar()
  {
    this.result = new JMenuBar();
    JMenu menu = new JMenu();
    for(int t=0;t<texts.length;t++){
      JMenuItem item = new JMenuItem(texts[t]);
      item.addActionListener(this.myActionListener);
      menu.add(item);
    }
    this.result.add(menu);
    return result;
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
      for(int t=0;t<texts.length;t++){
        if(e.getSource().toString().equalsIgnoreCase((texts[t]))){
          this.whichCommand = t;
          break;
        }
      }
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


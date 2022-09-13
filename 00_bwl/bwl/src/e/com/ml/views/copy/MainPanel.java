package e.com.ml.views.copy;

import java.awt.Component;
import java.awt.GradientPaint;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.ml.views.BasicFenster;
import com.ml.views.Farbe;
import com.ml.views.Polygon;


public class MainPanel extends JPanel{

  private static final long serialVersionUID = -4126168345806373791L;

  private JLayeredPane layeredPane;

  private Vector<Component> lastComponentsTextZumLoeschen = new Vector<Component>(); 
  
  public MainPanel(){
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

    // Panel which can handle layers
    this.layeredPane = new JLayeredPane();

    this.layeredPane.setOpaque(false);

    add(layeredPane);
    layeredPane.validate();
    this.layeredPane.setVisible(true);
  }
  
  public void addline(double xa,double ya,double xb,double yb, int breite, String farbe){
    JPanel liPanel = new Line((int)xa,(int)ya,(int)xb,(int)yb, breite, farbe);
    liPanel.setBounds(0, 0, 1000, (int)BasicWindowInfo.HOEHE);
    liPanel.setOpaque(false);
    this.layeredPane.add(liPanel, new Integer(4));
    
    layeredPane.validate();
  }
  
  public void addKreis(double xa, double ya, double radius){
    JPanel liPanel = new Circle((int)xa,(int)ya, (int)radius);
    liPanel.setBounds(0, 0, 1000, (int)BasicWindowInfo.HOEHE);
    liPanel.setOpaque(false);
    this.layeredPane.add(liPanel, new Integer(4));

    layeredPane.validate();
  }
//  public void addText(String text, double xa,double ya){
//    JPanel liPanel = new TextGrafik(text, (int)xa,(int)ya);
//    liPanel.setBounds(0, 0, 1000, (int)BasicFenster.HOEHE);
//    liPanel.setOpaque(false);
//    this.layeredPane.add(liPanel, new Integer(5));
//
//    layeredPane.validate();
//  }
//
//  public void addText(String text, double xa,double ya, String farbe){
//    JPanel liPanel = new TextGrafik(text, (int)xa,(int)ya, farbe);
//    liPanel.setBounds(0, 0, 1000, (int)BasicFenster.HOEHE);
//    liPanel.setOpaque(false);
//    this.layeredPane.add(liPanel, new Integer(5));
//
//    layeredPane.validate();
//  }
//
//  public void addText(String text, double xa,double ya, Label label){
//    JPanel liPanel = new TextGrafik(text, (int)xa,(int)ya, label.getTextSize(), false, "schwarz");
//    liPanel.setBounds(0, 0, 1000, (int)BasicFenster.HOEHE);
//    liPanel.setOpaque(false);
//    this.layeredPane.add(liPanel, new Integer(6));
//    label.setComponent(liPanel);
//    
//    layeredPane.validate();
//  }

  public void addText(String text, double xa,double ya, int schriftgroesse, boolean fett, String farbe, boolean loeschbar){
    JPanel liPanel = new TextGraphic(text, (int)xa,(int)ya, schriftgroesse, fett, farbe);
    liPanel.setBounds(0, 0, 1000, (int)BasicWindowInfo.HOEHE);
    liPanel.setOpaque(false);
    this.layeredPane.add(liPanel, new Integer(7));
    if(loeschbar){
      this.lastComponentsTextZumLoeschen.add(liPanel);
    }
    layeredPane.validate();
  }
  
  public void loescheTexte(){
    if(this.lastComponentsTextZumLoeschen != null){
      for(Component c : this.lastComponentsTextZumLoeschen){
        this.layeredPane.remove(c);
      }
    }    
  }

  public void loescheLabel(Label label){
    synchronized(this.layeredPane){
      this.layeredPane.remove(label.getComponent());
    }
    this.layeredPane.repaint();
  }

  public void loeschen(){
    synchronized(this.layeredPane){
      this.layeredPane.removeAll();
    }
    this.layeredPane.repaint();
  }
  
  public void addPolygon(Farbe farbe, double ... punkte){
    JPanel liPanel = new Polygon(farbe, punkte);
    liPanel.setBounds(0, 0, 1000, (int)BasicFenster.HOEHE);
    liPanel.setOpaque(false);
    this.layeredPane.add(liPanel, new Integer(4));

    layeredPane.validate();
  }


}

package e.com.ml.views.copy;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ml.views.Farbe;



/**
 * 
 * @author chrhof12069
 * 
 */
public class DrawWindow extends JFrame
{
  private static final long serialVersionUID = -4126168345806373794L;
  private static final String STANDARD_FARBE = "schwarz";
  
  private MainPanel       mainPanel;

  public DrawWindow(String titel)
  {
    this.mainPanel = new MainPanel();
    
    this.setTitle(titel);

    this.getContentPane().add(mainPanel);
    this.setWindowSize((int)BasicWindowInfo.BREITE, (int)BasicWindowInfo.HOEHE);
    this.setResizable(false);
    this.setVisible(true);

    this.addWindowListener(new WindowListener() {
        public void windowActivated(WindowEvent e){}
        public void windowClosed(WindowEvent e){}
        public void windowDeactivated(WindowEvent e){}
        public void windowDeiconified(WindowEvent e){}
        public void windowIconified(WindowEvent e){}
        public void windowOpened(WindowEvent e){}
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });
    
  }
  
  public void showWindow()
  {
    this.setVisible(true);
  }
  
  public void erase(){
    synchronized(this.mainPanel){
      this.mainPanel.loeschen();
    }
  }

  public void closeAll(){
    this.setVisible(false);
    System.exit(1);
  }

  public void setWindowSize(int breite, int hoehe)
  {
    this.setSize(breite, hoehe);
    this.setVisible(true);
  }

  /**
   *  LinieZeichen
   */
  
  public void drawLine(double xa,double ya,double xb,double yb){
    ya = Monitor.rechneYUmAufNullPunkt(ya);
    yb = Monitor.rechneYUmAufNullPunkt(yb);
    this.mainPanel.addline(xa, ya, xb, yb, 1, STANDARD_FARBE);
  }
  
  public void drawLine(double xa,double ya,double xb,double yb, int thickness){
    ya = Monitor.rechneYUmAufNullPunkt(ya);
    yb = Monitor.rechneYUmAufNullPunkt(yb);
    this.mainPanel.addline(xa, ya, xb, yb, thickness, STANDARD_FARBE);
  }

  public void drawLine(double xa,double ya,double xb,double yb, String color){
    ya = Monitor.rechneYUmAufNullPunkt(ya);
    yb = Monitor.rechneYUmAufNullPunkt(yb);
    this.mainPanel.addline(xa, ya, xb, yb, 1, color);
  }

  public void drawLine(double xa,double ya,double xb,double yb, int thickness, String color){
    ya = Monitor.rechneYUmAufNullPunkt(ya);
    yb = Monitor.rechneYUmAufNullPunkt(yb);
    this.mainPanel.addline(xa, ya, xb, yb, thickness, color);
  }

  /**
   *  Quadrat Zeichen
   */

  public void drawSquare(double x,double y, double length){
    y = Monitor.rechneYUmAufNullPunkt(y);
    this.mainPanel.addline(x, y, x, y+length, 2, STANDARD_FARBE);
    this.mainPanel.addline(x, y+length, x+length, y+length, 2, STANDARD_FARBE);
    this.mainPanel.addline(x+length, y+length, x+length, y, 2, STANDARD_FARBE);
    this.mainPanel.addline(x+length, y, x, y, 2, STANDARD_FARBE);
  }

  /**
   *  Punkt Zeichen
   */

  public void drawDot(double x,double y){
    y = Monitor.rechneYUmAufNullPunkt(y);

    this.mainPanel.addline(x - 1, y , x +1 , y, 1, STANDARD_FARBE);
    this.mainPanel.addline(x, y + 1 , x , y - 1, 1, STANDARD_FARBE);
  }

  /**
   *  Polygon zeichnen
   */
  public void drawPolygon(Paint color, double ... punkte){
    Farbe f = new Farbe(color.getR(), color.getG(), color.getB());
    this.mainPanel.addPolygon(f, punkte);
  }

  
  /**
   *  Kreis Zeichen
   */
  public void drawCircle(double x,double y, double radius){
    y = Monitor.rechneYUmAufNullPunkt(y);
    this.mainPanel.addKreis(x,y,radius);
  }

  /**
   *  Text Zeichen
   */
  // MASTER
  // Master String
  private void masterZeichnen(Double zahlText, String text, double x,double y, int schriftgroesse, String farbe, boolean loeschbarFlag){
    y = Monitor.rechneYUmAufNullPunkt(y);
    if(text == null){
      try{
        text = "" + zahlText.toString();
      }
      catch(Exception e){
        text = "0";
      }
    }
    this.mainPanel.addText(text, x, y, schriftgroesse, false, farbe, loeschbarFlag); 
  }

  
  // String
  public void drawText(String text, int x, int y){
    this.drawText(text, (double)x, (double)y);
  }
  public void drawText(String text, double x,double y){
    this.masterZeichnen(null, text, x, y, 12, "schwarz", false);
  }

  public void drawText(String text, int x, int y, String color){
    this.drawText(text, (double)x, (double)y, color);
  }
  public void drawText(String text, double x,double y, String color){
    this.masterZeichnen(null, text, x, y, 12, color, false);
  }

  public void drawText(String text, int x, int y, int size){
    this.drawText(text, (double)x, (double)y, size);
  }
  public void drawText(String text, double x,double y, int size){
    this.masterZeichnen(null, text, x, y, size, "schwarz", false);
  }

  public void drawText(String text, int x, int y, int size, String color){
    this.drawText(text, (double)x, (double)y, size, color);
  }
  public void drawText(String text, double x,double y, int size, String color){
    this.masterZeichnen(null, text, x, y, size, color, false);
  }

  // String loeschbar
  public void removeableDrawText(String text, int x, int y){
    this.removeableDrawText(text, (double)x, (double)y);
  }
  public void removeableDrawText(String text, double x,double y){
    this.masterZeichnen(null, text, x, y, 12, "schwarz", true);
  }

  public void removeableDrawText(String text, int x, int y, String farbe){
    this.removeableDrawText(text, (double)x, (double)y, farbe);
  }
  public void removeableDrawText(String text, double x,double y, String farbe){
    this.masterZeichnen(null, text, x, y, 12, farbe, true);
  }

  public void removeableDrawText(String text, int x, int y, int schriftgroesse){
    this.removeableDrawText(text, (double)x, (double)y, schriftgroesse);
  }
  public void removeableDrawText(String text, double x,double y, int schriftgroesse){
    this.masterZeichnen(null, text, x, y, schriftgroesse, "schwarz", true);
  }

  public void removeableDrawText(String text, int x, int y, int schriftgroesse, String farbe){
    this.removeableDrawText(text, (double)x, (double)y, schriftgroesse, farbe);
  }
  public void removeableDrawText(String text, double x,double y, int schriftgroesse, String farbe){
    this.masterZeichnen(null, text, x, y, schriftgroesse, farbe, true);
  }
  
  // double
  public void drawText(double text, int x, int y){
    this.drawText(text, (double)x, (double)y);
  }
  public void drawText(double text, double x,double y){
    this.masterZeichnen(text, null, x, y, 12, "schwarz", false);
  }

  public void drawText(double text, int x, int y, String color){
    this.drawText(text, (double)x, (double)y, color);
  }
  public void drawText(double text, double x,double y, String color){
    this.masterZeichnen(text, null, x, y, 12, color, false);
  }

  public void drawText(double text, int x, int y, int size){
    this.drawText(text, (double)x, (double)y, size);
  }
  public void drawText(double text, double x,double y, int size){
    this.masterZeichnen(text, null, x, y, size, "schwarz", false);
  }

  public void drawText(double text, int x, int y, int size, String color){
    this.drawText(text, (double)x, (double)y, size, color);
  }
  public void drawText(double text, double x,double y, int size, String color){
    this.masterZeichnen(text, null, x, y, size, color, false);
  }

  // double loeschbar 
  public void removeableDrawText(double text, int x, int y){
    this.removeableDrawText(text, (double)x, (double)y);
  }
  public void removeableDrawText(double text, double x,double y){
    this.masterZeichnen(text, null, x, y, 12, "schwarz", true);
  }

  public void removeableDrawText(double text, int x, int y, String farbe){
    this.removeableDrawText(text, (double)x, (double)y, farbe);
  }
  public void removeableDrawText(double text, double x,double y, String farbe){
    this.masterZeichnen(text, null, x, y, 12, farbe, true);
  }

  public void removeableDrawText(double text, int x, int y, int schriftgroesse){
    this.removeableDrawText(text, (double)x, (double)y, schriftgroesse);
  }
  public void removeableDrawText(double text, double x,double y, int schriftgroesse){
    this.masterZeichnen(text, null, x, y, schriftgroesse, "schwarz", true);
  }

  public void removeableDrawText(double text, int x, int y, int schriftgroesse, String farbe){
    this.removeableDrawText(text, (double)x, (double)y, schriftgroesse, farbe);
  }
  public void removeableDrawText(double text, double x,double y, int schriftgroesse, String farbe){
    this.masterZeichnen(text, null, x, y, schriftgroesse, farbe, true);
  }

  public void removeAllTexts(){
    this.mainPanel.loescheTexte();
  }
  
  public void labelLoeschen(Label label){
    if(label == null){
      return;
    }
    this.mainPanel.loescheLabel(label);
  }

}

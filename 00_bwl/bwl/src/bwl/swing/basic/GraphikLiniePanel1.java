package bwl.swing.basic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JPanel;

public class GraphikLiniePanel1  extends JPanel {

  private static final long serialVersionUID = -4126168345806373792L;
  
  public GraphikLiniePanel1(){
  }

  public void paint(Graphics g) {
    Graphics2D g1 = (Graphics2D)g;

    Image img = getToolkit().getImage( "c:/0_ml/0_ml_muell/1_ml.jpg" );
    MediaTracker mt = new MediaTracker( this );
    mt.addImage( img, 0 );
    try { mt.waitForAll(); } catch( InterruptedException ex ) { }
    g1.drawImage( img, 0, 0, this );

  }

} 

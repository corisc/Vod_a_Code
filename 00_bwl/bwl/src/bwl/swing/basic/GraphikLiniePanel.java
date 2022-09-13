package bwl.swing.basic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JPanel;

public class GraphikLiniePanel  extends JPanel {

  private static final long serialVersionUID = -4126168345806373792L;
  
  public GraphikLiniePanel(){
  }

  public void paint(Graphics g) {
    Graphics2D g1 = (Graphics2D)g;
    g1.setStroke(new BasicStroke(10));
    g1.setColor(Color.RED);
    g1.drawLine(100,100,500,500);
    
    g1.setColor(Color.BLUE);
    g1.setStroke(new BasicStroke(5));
    g1.drawRect(100, 100, 500, 300);
    
    
    g1.setColor(Color.YELLOW);
    g1.setStroke(new BasicStroke(7));
    g1.drawOval(200, 200, 400, 600);
    
    Color c = new Color(0, 0, 230);
    g1.setColor(c);
    g1.setStroke(new BasicStroke(40));
    Font f = new Font("Comic Sans MS", Font.BOLD, 80);
    g1.setFont(f);
    g1.drawString("Hallo", 100, 100);

  }

} 

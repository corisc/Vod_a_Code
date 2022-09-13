package com.ml.views;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.text.AttributedString;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ml.utils.Helfer;

/**
 * 
 * @author chrhof12069
 * 
 */
public class Fenster extends JFrame
{
  private static final long serialVersionUID = -4126168345806373794L;
  private static final Vector<Color> balkenfarben = new Vector<Color>(20);
  static{
    balkenfarben.add(Color.RED);
    balkenfarben.add(Color.BLUE);
    balkenfarben.add(Color.CYAN);
    balkenfarben.add(Color.GREEN);
    balkenfarben.add(Color.MAGENTA);
    balkenfarben.add(Color.ORANGE);
    balkenfarben.add(Color.PINK);
    balkenfarben.add(Color.RED);
    balkenfarben.add(Color.YELLOW);
    balkenfarben.add(Color.RED);
    balkenfarben.add(Color.BLUE);
    balkenfarben.add(Color.CYAN);
    balkenfarben.add(Color.GREEN);
    balkenfarben.add(Color.MAGENTA);
    balkenfarben.add(Color.ORANGE);
    balkenfarben.add(Color.PINK);
    balkenfarben.add(Color.RED);
    balkenfarben.add(Color.YELLOW);
    balkenfarben.add(Color.ORANGE);
    balkenfarben.add(Color.PINK);
  }

  private JLabel    textLabel   = new JLabel();
  private JTextArea textArea    = new JTextArea();
  private Bild bild;
  private boolean weiter = false;;
  private int sizeX = 800;
  private int sizeY = 500;
  
  JPanel panel;

  public Fenster()
  {
    this(null);
  }
  
  public Fenster(String titel)
  {
    this(titel,800,500);
  }
  
  public Fenster(String titel, int sizeX, int sizeY)
  {

    
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.setLayout(null);

    if(titel == null){
      titel = "";
    }
    
    this.setTitle(titel);
    this.setSize(this.sizeX, this.sizeY);
    //this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    this.setLocation(50, 50);
    //this.setVisible(true);

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
    this.panel = new JPanel();
    this.panel.setLayout(null);
    this.panel.setSize(this.sizeX, this.sizeY);
    this.panel.setLocation(0,0);
    this.add(this.panel);
    this.anzeigen();
    
    
    

  }
  
  public void anzeigen()
  {
    this.setVisible(true);
  }
  
  public void loeschen(){
    this.dispose();
  }

  public void inhalteLoeschen(){
    synchronized(this.panel){
      Helfer h = new Helfer();
      h.warteMillis(500);
      for(Component c : this.panel.getComponents()){
        //System.out.println("!" + c);
        this.panel.remove(c);
      }
    }
  }

  public void allesBeenden(){
    this.setVisible(false);
    System.exit(1);
  }

  public void setHeadline(String headline)
  {
    textLabel.setText(headline);
  }

  public void setzeGroesse(int breite, int hoehe)
  {
    this.setSize(breite, hoehe);
    this.setVisible(true);
  }

  public void setzePosition(int xpos, int ypos)
  {
    this.setLocation(xpos, ypos);
    this.setVisible(true);
  }

  public void zeige(Text o, int x, int y)
  {
    Text t = o;
    JLabel label = new JLabel(t.getTextzeile());
    this.panel.add(label);
    label.setFont(new Font("Arial", Font.BOLD, o.getSchriftgroesse()));

    label.setBounds(x, y, 1000, o.getSchriftgroesse());
    this.panel.add(label);
    this.repaint();
  }
  
  public void zeige(Ueberschrift o, int x, int y)
  {
    Ueberschrift t = o;
    JLabel label = new JLabel(t.getTextzeile());
    JPanel panel = new JPanel();
    panel.add(label);

    label.setFont(new Font("Arial", Font.BOLD, 40));
    label.setBounds(x, y-30, 1000, 100);
    this.panel.add(label);
    this.repaint();
  }
  
  public void zeige(TextFeld o, int x, int y)
  {
    this.textArea = new JTextArea();
    textArea.setBounds(x, y, o.getW(), o.getH());
    textArea.setText(o.getText());
    this.panel.add(textArea);

    this.repaint();
    this.setVisible(true);
  }
  
  public void zeige(Text o, int x, int y, int laenge)
  {
    Text t = o;
    JLabel label = new JLabel(t.getTextzeile());
    this.panel.add(label);

    label.setBounds(x, y, laenge, o.getSchriftgroesse());
    this.panel.add(label);
    this.repaint();
  }

  public void zeige(EingabeFeld o, int x, int y, int laenge)
  {
    EingabeFeld e = o;
    JTextField textField = e.getTextField();
    textField.setText(e.getText());
    int size = 20;
    if(e.getFont() != null){
      size = e.getFont().getSize()*2;
    }
    textField.setBounds(x, y, laenge, size);
    this.panel.add(textField);
    this.repaint();
  }
  
  public void zeige(Balkendiagramm balkendiagramm, int x, int y)
  {
    BalkendiagrammPanel balkendiagrammPanel = new BalkendiagrammPanel(balkendiagramm);
    balkendiagrammPanel.setBounds(x, y, this.sizeX, this.sizeX);
    this.panel.add(balkendiagrammPanel);
    this.repaint();
  }

  public void zeige(Rechteck rechteck, int x, int y)
  {
    rechteck.setX(x);
    rechteck.setY(y);
    RechteckPanel rechteckPanel = new RechteckPanel(rechteck);
    // Achtung Panel hart auf 0,0 -> im drawrect erfolgt dann die Positionierung.
    rechteckPanel.setBounds(0, 0, this.sizeX, this.sizeX);
    
    // Debug
    System.out.println("Rechteckpanel Bounds set (x, y, this.sizeX, this.sizeX):\n" + 
        "x:" + x + " y:" + y + " sizeX:" + this.sizeX + " y:" + this.sizeY);

    
    this.panel.add(rechteckPanel);
    this.panel.repaint();
    this.rootPane.repaint();
    this.repaint();
    this.refresh();
    super.repaint();
  }

  
  public void zeige(Graphik graphik, int x, int y)
  {
    GraphikPanel graphikPanel = new GraphikPanel(graphik);
    graphikPanel.setBounds(x, y, this.sizeX, this.sizeX);
    this.panel.add(graphikPanel);
    this.repaint();
  }

  public void zeige(Schalter o, int x, int y, int laenge)
  {
    JButton button = o.getButton();
    button.setBounds(x, y, laenge, 20);
    this.panel.add(button);
    this.panel.repaint();
    this.repaint();
    this.refresh();
  }
  
  public void zeige(RadioButton o, int x, int y)
  {
    JRadioButton[] buttons = o.getButtons();
    JRadioButton button;
    for(int t=0; t<buttons.length; t++){
      button = buttons[t];
      button.setBounds(x, y+t*20, 100, 20);
      this.panel.add(button);
    }
    this.repaint();
  }

  public void zeige(ComboBox o, int x, int y)
  {
    JComboBox combo = o.getComboBox();
    combo.setBounds(x, y, 200, 20);
    this.panel.add(combo);
    this.repaint();
  }

  public synchronized void zeige(DropDown o, int x, int y)
  {
    JComboBox combo = o.getComboBox();
    combo.setBounds(x, y, 200, 20);
    this.panel.add(combo);
    this.repaint();
  }

  public void zeige(Menu o)
  {
    JMenuBar menu = o.getJMenuBar();
    menu.setBounds(0,0,300,300);
    this.panel.add(menu);
    this.repaint();
  }

  public void zeige(Bild o, int x, int y)
  {
    bild = (Bild)o;


//    if(bild.getBreite()!=0){
//      int type = BufferedImage.TYPE_INT_ARGB;
//      BufferedImage resizedImage = new BufferedImage(bild.getBreite(), bild.getHoehe(), type);
//      Graphics2D g = resizedImage.createGraphics();
//      g.setComposite(AlphaComposite.Src);
//      g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//      g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//      g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//      bild.setImg(resizedImage);
//    }
    
    MediaTracker md = new MediaTracker(this);
    md.addImage(bild.getImage(), 0);
    try
    {
      md.waitForID(0);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    BildPanel bildPanel = new BildPanel(o);
    bildPanel.setBounds(x, y, bild.getImage().getWidth(this), bild.getImage().getHeight(this));
    
    this.panel.add(bildPanel);
    this.repaint();
  }
  
  public void removeTextFeld()
  {
    synchronized(this.panel){
      this.panel.remove(this.textArea);
      this.repaint();
    }
  }
  
  class BildPanel extends JPanel
  {
    private Bild bild;
  
    public BildPanel(Bild bild){
      this.bild = bild;
    }
    private static final long serialVersionUID = -2703883741595286889L;

    protected void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      g.drawImage(this.bild.getImage(), 0, 0, this);
    }
  }
  
  class RechteckPanel extends JPanel
  {
    private static final long serialVersionUID = -27038837225944L;
    private Graphics g;
    private Rechteck rechteck;
    
    public RechteckPanel(Rechteck rechteck){
      this.rechteck = rechteck;
    }
    
    public void paint(Graphics g) {
        this.g = g;
        //this.balkenVonLinksUntenAus(10, 10, 30, 150);
        g.setColor(new Color(this.rechteck.getFarbe().r, this.rechteck.getFarbe().g, this.rechteck.getFarbe().b));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(this.rechteck.getLinienBreite()));
        
        // Debug fuer 
        System.out.println("Rechteckobjekt: " + this.rechteck.toString());
        
        
        //g2.drawRect(this.rechteck.getX(), (200-this.rechteck.getHoehe()-this.rechteck.getY()), this.rechteck.getBreite(), this.rechteck.getHoehe());
        //System.out.println(" x: " + this.rechteck.getX() + " y: " + this.rechteck.getY() + " b: " + this.rechteck.getBreite() + " h: " + this.rechteck.getHoehe());
        g2.drawRect(this.rechteck.getX(), this.rechteck.getY(), this.rechteck.getBreite(), this.rechteck.getHoehe());
        String message = "drawrect \n";
        message = message + "x: " + this.rechteck.getX() + "\n";
        message = message + "y: " + this.rechteck.getY() + "\n";
        message = message + "breite: " + this.rechteck.getBreite() + "\n";
        message = message + "hoehe: " + this.rechteck.getHoehe() + "\n";
        System.out.println(message);
        g.setColor(Color.BLACK);
        }
    
  }  
  
  

  class BalkendiagrammPanel extends JPanel
  {
    private static final long serialVersionUID = -27038837415944L;
    private Graphics g;
    private Balkendiagramm balkendiagramm;
    
    public BalkendiagrammPanel(Balkendiagramm balkendiagramm){
      this.balkendiagramm = balkendiagramm;
    }
    
    protected void paintComponent(Graphics g)
    {      
      super.paintComponent(g);
      this.g = g;
      //this.balkenVonLinksUntenAus(10, 10, 30, 150);
      int size = this.balkendiagramm.getWerte().size();
      for(int t=0;t<size;t++){
        g.setColor(balkenfarben.get(t));
        double wert = this.balkendiagramm.getWerte().get(t);
        //System.out.println("wert: " + wert);
        this.balkenVonLinksUntenAus(10+(t*50), 10, 40, wert);
        g.setColor(Color.BLACK);
        this.textVonLinksUntenAus(10+(t*50), 10, 40, wert, this.balkendiagramm.getTexte().get(t));
      }
      
      // Rand zeichnen obenlinks startend
      g.setColor(Color.black);
      g.drawRect(0,0,(size*50)+20,200);
    }
    
    private void balkenVonLinksUntenAus(double x, double y, double w, double h){
      // Balken zeichnen
      g.fill3DRect((int)x, (int)(200-h-y), (int)w, (int)h, true);
    }
    private void textVonLinksUntenAus(double x, double y, double w, double h, String text){
      AttributedString as = new AttributedString(text);
      Font font = new Font("Arial", Font.BOLD, 8);
      as.addAttribute(TextAttribute.FONT, font);
      g.drawString(as.getIterator(), (int)x, (int)(200-y+6));
    }
  }

  class GraphikPanel extends JPanel
  {
    private static final long serialVersionUID = -27038837415944L;
    private Graphics g;
    private Graphik graphik;
    private volatile double lastx = 0;
    private volatile double lasty = 200;
    
    public GraphikPanel(Graphik graphik){
      this.graphik = graphik;
    }
    
    protected void paintComponent(Graphics g)
    {
      synchronized(g){
        super.paintComponent(g);
        this.g = g;
        //this.balkenVonLinksUntenAus(10, 10, 30, 150);
        int size = this.graphik.getWerte().size();
        for(int t=0;t<size;t++){
          g.setColor(Color.RED);
          double wert = this.graphik.getWerte().get(t);
          //System.out.println("wert: " + wert);
          this.graphVonLinksUntenAus(10+(t*50), 10, 40, wert);
          g.setColor(Color.BLACK);
          this.textVonLinksUntenAus(10+(t*50), 10, 40, wert, this.graphik.getTexte().get(t));
        }
        
        // Rand zeichnen obenlinks startend
        g.setColor(Color.black);
        g.drawRect(0,0,(size*50)+20,200);
      }
    }
    
    private void graphVonLinksUntenAus(double x, double y, double w, double h){
      // Balken zeichnen
      g.drawLine((int)this.lastx, (int)this.lasty, (int)x, (int)(200-h-y));
      this.lastx = x;
      this.lasty = (200-h-y);
    }
    private void textVonLinksUntenAus(double x, double y, double w, double h, String text){
      AttributedString as = new AttributedString(text);
      Font font = new Font("Arial", Font.BOLD, 8);
      as.addAttribute(TextAttribute.FONT, font);
      g.drawString(as.getIterator(), (int)x, (int)(200-h-y - 6));
    }
  }

  public void setWeiter(boolean weiter) {
    this.weiter = weiter;
  }
  
  public void refresh(){
    this.repaint();
  }
  
  public JPanel getPanel(){
    return this.panel;
  }
  
  public void warteAufAntwort(){
    while(true){
      if(this.weiter){
        return;
      }
      new Helfer().warteSeks(1);
    }
  }
  
  public void schliessen(){
    this.dispose();
  }
}

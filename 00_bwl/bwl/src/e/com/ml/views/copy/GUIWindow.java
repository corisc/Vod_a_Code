package e.com.ml.views.copy;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
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
public class GUIWindow extends JFrame
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
  private Picture bild;
  private boolean weiter = false;;
  private int sizeX = 800;
  private int sizeY = 500;
  
  JPanel panel;

  public GUIWindow()
  {
    this(null);
  }
  
  public GUIWindow(String titel)
  {
    this(titel,800,500);
  }
  
  public GUIWindow(String titel, int sizeX, int sizeY)
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
  
  public void erase(){
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

  public void present(Text o, int x, int y)
  {
    Text t = o;
    JLabel label = new JLabel(t.getTextzeile());
    this.panel.add(label);
    label.setFont(new Font("Arial", Font.BOLD, o.getSchriftgroesse()));

    label.setBounds(x, y, 1000, o.getSchriftgroesse());
    this.panel.add(label);
    this.repaint();
  }
  
  public void present(Headline o, int x, int y)
  {
    Headline t = o;
    JLabel label = new JLabel(t.getTextzeile());
    JPanel panel = new JPanel();
    panel.add(label);

    label.setFont(new Font("Arial", Font.BOLD, 40));
    label.setBounds(x, y, 1000, 100);
    this.panel.add(label);
    this.repaint();
  }
  
  public void present(TextField o, int x, int y)
  {
    this.textArea = new JTextArea();
    textArea.setBounds(x, y, o.getW(), o.getH());
    textArea.setText(o.getText());
    this.panel.add(textArea);

    this.repaint();
    this.setVisible(true);
  }
  
  public void present(Text o, int x, int y, int laenge)
  {
    Text t = o;
    JLabel label = new JLabel(t.getTextzeile());
    this.panel.add(label);

    label.setBounds(x, y, laenge, o.getSchriftgroesse());
    this.panel.add(label);
    this.repaint();
  }

  public void present(InputField o, int x, int y, int laenge)
  {
    InputField e = o;
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
  
  public void present(Graphik graphik, int x, int y)
  {
    GraphikPanel graphikPanel = new GraphikPanel(graphik);
    graphikPanel.setBounds(x, y, this.sizeX, this.sizeX);
    this.panel.add(graphikPanel);
    this.repaint();
  }

  public void present(Button o, int x, int y, int laenge)
  {
    JButton button = o.getButton();
    button.setBounds(x, y, laenge, 20);
    this.panel.add(button);
    this.repaint();
  }
  
  public void present(RadioButton o, int x, int y)
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

  public synchronized void present(ComboBox o, int x, int y)
  {
    JComboBox combo = o.getComboBox();
    combo.setBounds(x, y, 200, 20);
    this.panel.add(combo);
    this.repaint();
  }

  public void present(Menu o)
  {
    JMenuBar menu = o.getJMenuBar();
    menu.setBounds(0,0,300,300);
    this.panel.add(menu);
    this.repaint();
  }

  public void present(Picture o, int x, int y)
  {
    bild = (Picture)o;

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
    private Picture bild;
  
    public BildPanel(Picture bild){
      this.bild = bild;
    }
    private static final long serialVersionUID = -2703883741595286889L;

    protected void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      g.drawImage(this.bild.getImage(), 0, 0, this);
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

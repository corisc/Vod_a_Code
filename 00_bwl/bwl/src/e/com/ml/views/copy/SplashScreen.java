package e.com.ml.views.copy;

import java.awt.*;
import java.io.File;

import javax.swing.*;

import com.ml.utils.Helfer;

public class SplashScreen extends JWindow {
    private static final long serialVersionUID = -4126168345806373794L;    
    private int duration;
    private String text;
    private String bildName;
    private int w = 450;
    private int h = 115;
    
    public SplashScreen(int d, String text, String bildName) {
        duration        = d;
        this.text       = text;
        this.bildName   = bildName;
    }
    
    public SplashScreen(int d, String text, String bildName, int w, int h) {
      duration        = d;
      this.text       = text;
      this.bildName   = bildName;
      this.w = w;
      this.h = h;
    }

    public void anzeigen(){
      this.showSplash(false);
    }
    
    public void anzeigenUndBeenden(){
      this.showSplash(true);
    }

    // A simple little method to show a title screen in the center
    // of the screen for the amount of time given in the constructor
    private void showSplash(boolean endIt){
        
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);
        
        // Set the window's bounds, centering the window
        int width  = this.w;
        int height = this.h;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
        
        Helfer h = new Helfer();
        String pfad = h.aktuellesArbeitsverzeichnis() + "/50_daten/"+ this.bildName;
        File f = new File(pfad);
        String bildNameUndPfad = "";
        if(f.exists()){
          bildNameUndPfad = pfad;
        }
        else{
          System.out.println("Fehler: Es fehlt entweder des Verzeichnis " + h.aktuellesArbeitsverzeichnis() + "/50_daten/"+ " oder das Bildes existiert nicht namens: " + this.bildName);
        }

        // Build the splash screen
        JLabel label = new JLabel(new ImageIcon(bildNameUndPfad));
        JLabel copyrt = new JLabel
                (this.text, JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = new Color(156, 20, 20,  255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 10));
        
        // Display it
        setVisible(true);
        
        // Wait a little while, maybe while loading resources
        try { Thread.sleep(duration); } catch (Exception e) {}
        
        setVisible(false);
        this.dispose();
        if(endIt){
          System.exit(0);
        }
    }
} 
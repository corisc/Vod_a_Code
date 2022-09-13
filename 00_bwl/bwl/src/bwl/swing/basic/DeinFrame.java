package bwl.swing.basic;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.ml.views.Linie;

public class DeinFrame extends JFrame {

  private JLayeredPane layeredPane;

  public DeinFrame() {

    // Panel which can handle layers
    this.layeredPane = new JLayeredPane();
    this.layeredPane.setOpaque(true);
    this.add(layeredPane);
    
    this.layeredPane.validate();
    this.layeredPane.setVisible(true);

    JPanel liPanel = new GraphikLiniePanel();
    liPanel.setBounds(0, 0, 1000, 1000);
    liPanel.setOpaque(false);
    this.layeredPane.add(liPanel, new Integer(5));

    JPanel liPanel1 = new GraphikLiniePanel1();
    liPanel1.setBounds(0, 0, 1000, 1000);
    liPanel1.setOpaque(false);
    this.layeredPane.add(liPanel1, new Integer(4));

    layeredPane.validate();

  }

}

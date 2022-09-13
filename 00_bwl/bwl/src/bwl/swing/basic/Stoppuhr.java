package bwl.swing.basic;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class Stoppuhr extends JFrame {

    static Stoppuhr su = new Stoppuhr();
   
    public static void main(String[] args) {
         
    }
   
    public Stoppuhr() {
        this.getContentPane().setLayout(null);
        this.initWindow();
        this.setBounds(750,100,250,150);
        this.setTitle("Stoppuhr");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
   
    static JLabel lblzeit;
   
    private void initWindow() {
   
       
        lblzeit = new JLabel("00:00:00");
        JButton btnstart = new JButton("Start");
        JButton btnstopp = new JButton("Stop");
       
        lblzeit.setBounds(70,20,250,25);
        btnstart.setBounds(10,75,100,25);
        btnstopp.setBounds(130,75,100,25);
       
        lblzeit.setFont(new Font("Arial", Font.BOLD, 25));
       
        this.add(lblzeit);
        this.add(btnstart);
        this.add(btnstopp);
       
        this.pack();
       
        btnstart.addActionListener(new ActionListener() {  
              public void actionPerformed(ActionEvent arg0) {  
                 
                  final Timer timer = new Timer();
                  final Zeit z = new Zeit();
                  z.setEin(0);
                  final TimerTask task = new TimerTask() {
                      public void run() {
                      if (Zeit.aus == 1) timer.cancel();
                      else z.macheZeit();
                      }
                     
                      };
                      timer.scheduleAtFixedRate(task, 0, 1000);
              }
        });
       
        btnstopp.addActionListener(new ActionListener() {  
              public void actionPerformed(ActionEvent arg0) {  
                  Zeit z = new Zeit();
                  z.setAus(1);
              }
        });
       
    }

}
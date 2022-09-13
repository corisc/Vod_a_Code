package com.ml.connection;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class IPAdressFenster {

  JLabel jlbLabel1;
  public IPAdressFenster(int x, int y){
    Vector<String> ipAdressen = this.ipAdresseBestimmen();
    final JFrame frame = new JFrame("ip");
    frame.setSize(300, 400);
    frame.setLocation(x, y);
    frame.addWindowListener(new IPAdressFensterListener());
    frame.setLayout(new GridLayout(ipAdressen.size()+1, 1));
    frame.setUndecorated(true);
    
    frame.getContentPane().setBackground(Color.GREEN);      
    String text = "";
    
    for(int t= 0; t<ipAdressen.size(); t++){
      text = "  " + "IP: " + ipAdressen.get(t) + "  ";
    
    
      jlbLabel1 = new JLabel(text, JLabel.LEFT);
      jlbLabel1.setFont(new Font("Arial", Font.BOLD, 20));
      jlbLabel1.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
      frame.add(jlbLabel1);
    }
    
    JButton button = new JButton("Schliessen");
    button.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        System.exit(0);
      }
    });
    frame.add(button);
    frame.setVisible(true);
  }
  
  private Vector<String> ipAdresseBestimmen(){
    
    Vector<String> ipAdressen = new Vector<String>(1);
    
    try {      
      InetAddress address = InetAddress.getLocalHost();
      String ipAdresse = address.getHostName();
      
      for (InetAddress ia : InetAddress.getAllByName(ipAdresse)){
        ipAdressen.add(ia.getHostAddress());
      }

    }
    catch (UnknownHostException e) {
      ipAdressen.add("???.???.???.???");
    }
    
    return ipAdressen;
  }
}
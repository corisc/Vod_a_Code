package bwl.main.bitcoin;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class View extends JFrame{

    private JLabel eingabeLabel = new JLabel("Eingabe: ");
    private JTextField eingabeHash = new JTextField(500);
    private JButton hashBerechnenButton = new JButton("Hash berechnen");
    private JLabel ausgabeLabel = new JLabel("Ausgabe Hash: ");
    private JTextField hashAusgeben = new JTextField( 64);
    private JButton resetButton = new JButton("Reset Hashfunktion");



    public View(){
        super("Hash berechnen");


        initForm();
    }

    private void initForm(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setLocation(50, 50);
        this.setVisible(true);
        this.getContentPane().setLayout(null);

        eingabeLabel.setBounds(50,50,100,100);
        this.add(eingabeLabel);

        eingabeHash.setBounds(50,150, 800,40);
        this.add(eingabeHash);

        hashBerechnenButton.setBounds(50,400,200,40);
        //this.add(hashBerechnenButton);

        ausgabeLabel.setBounds(50,200,100,100);
        this.add(ausgabeLabel);

        hashAusgeben.setBounds(50,300,800,40);
        this.add(hashAusgeben);

        resetButton.setBounds(300,400,200,40);
        //this.add(resetButton);

    }

    public void resetView(){
        this.hashAusgeben.setText("");
        this.eingabeHash.setText("");
    }

    public String getEingabe(){
        return this.eingabeHash.getText();
    }

    public void setErgebnis(String ergebnis){
        this.hashAusgeben.setText(ergebnis);
    }

    public void setHashberechnenListener(ActionListener l){
        this.hashBerechnenButton.addActionListener(l);
    }

    public void setHasberechnenListenerTextfield(KeyListener l){ this.eingabeHash.addKeyListener(l);}

    public void setResetFormListener(ActionListener l){
        this.resetButton.addActionListener(l);
    }


}



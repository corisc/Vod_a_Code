package bwl.main.bitcoin2;

import javax.swing.*;


public class View extends JFrame{


    private JLabel difficultyLabel = new JLabel("Mining Schwierigkeit: ");
    private JTextField difficultyTextfield = new JTextField();
    private JButton difficultyButton = new JButton("Bestaetigen");

    private JLabel blockNrLabel0;
    public JTextArea dataTextfield0;
    private JLabel nonceLabel0;
    private JLabel previousHashLabel0;
    private JLabel hashLabel0;
    private JButton mineButton0;




    public View()
    {
        super("Blockchain");

        initform();
        addDifficulty();

        addblock0();



    }



    public void initform() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocation(50, 50);
        this.getContentPane().setLayout(null);



        this.setVisible(true);

    }

    public void addDifficulty() {

        difficultyLabel.setBounds(20, 100, 150, 30);
        difficultyTextfield.setBounds(170, 100, 30, 30);
        difficultyButton.setBounds(220, 100, 100, 30);

        this.add(difficultyLabel);
        this.add(difficultyTextfield);
        this.add(difficultyButton);

    }

    public void setSchwierigkeitsListener(Controller.SchwierigkeitsListener l){
        this.difficultyButton.addActionListener(l);
    }


    public int getDifficulty() {

        int x = Integer.parseInt(difficultyTextfield.getText());

        return x;
    }

// Block 0

    public void addblock0() {
        blockNrLabel0 = new JLabel("Blocknummer: 0");
        dataTextfield0 = new JTextArea("");
        nonceLabel0 = new JLabel("Nonce: ");
        previousHashLabel0 = new JLabel("Previous Hash: ");
        hashLabel0 = new JLabel("Da muss der Hash stehen");
        mineButton0 = new JButton("Mine");



        blockNrLabel0.setBounds(20,150,100,30);
        dataTextfield0.setBounds(20,200,300,100);
        nonceLabel0.setBounds(20,400,100,30);
        previousHashLabel0.setBounds(20,450,200,30);
        hashLabel0.setBounds(20,500,500,30);
        mineButton0.setBounds(20,550,100,50);


        this.add(blockNrLabel0);
        this.add(dataTextfield0);
        this.add(nonceLabel0);
        this.add(previousHashLabel0);
        this.add(hashLabel0);
        this.add(mineButton0);

    }

    public void setMineListener0(Controller.MineListener0 l){
        this.mineButton0.addActionListener(l);
        }

    public String getData0(){

        String data = dataTextfield0.getText();

        return data;
    }

    public void setBlock01(String hash, int nonce){
        hashLabel0.setText("Hash: " + hash);
        //previousHashLabel1.setText(hash);
        nonceLabel0.setText("Nonce: " + String.valueOf(nonce));
        repaint();
    }

    public void setTextfieldListener0(Controller.TextfieldListener0 l){
        this.dataTextfield0.addKeyListener(l);
    }



}


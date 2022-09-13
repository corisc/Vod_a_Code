package bwl.main.bitcoin2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ExecutionException;

public class Controller {

    private  Model _model;
    private View _view;


    public Controller() {
        this._view = new View();
        this._model = new Model();

        this.addListener();

        for(int i = 0; i<20; i++){
            addBlock(i);


        }



    }

    public void showView(){

        this._view.setVisible(true);

    }

    public void addBlock(int nummerblock){

        _model.addBlock(nummerblock);

    }

    public void addListener(){

        this._view.setSchwierigkeitsListener(new SchwierigkeitsListener());

        this._view.setMineListener0(new MineListener0());
        this._view.setTextfieldListener0(new TextfieldListener0());

    }

// Schwierigkeit einstellen

    class SchwierigkeitsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new Copydifficulty().execute();

        }
    }

    class Copydifficulty extends SwingWorker<Integer,Object>    {

        protected Integer doInBackground() throws Exception {

            int x = _view.getDifficulty();

            return x;
        }

        protected void done(){
            try {
                Chain.setSchwierigkeit(get());
                System.out.println("Schwierigkeit: " + get());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

// Block 0

    class MineListener0 implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            new Mine0().execute();
        }
    }

    class Mine0 extends SwingWorker<String,Object>{

        protected String doInBackground() throws Exception {
            String hash =_model.mineBestimmtenBlock(0);

            Chain.blockchain.get(0).setHash(hash);
            Chain.blockchain.get(0+1).setPreviousHash(hash);

            return hash;
        }
        protected void done() {

            try {
                _view.setBlock01(get(),Chain.blockchain.get(0).getNonce());
                System.out.println("Previous Hash von Block 1: " + Chain.blockchain.get(1).previousHash);
                System.out.println("Die Data aus block 0 ist: \n" + Chain.blockchain.get(0).getData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
    }

    class TextfieldListener0 implements KeyListener{

        
        public void keyTyped(KeyEvent e) {

        }

        
        public void keyPressed(KeyEvent e) {

        }

        
        public void keyReleased(KeyEvent e) {

            new textfieldDataUpdate0().execute();

        }
    }

    class  textfieldDataUpdate0 extends SwingWorker {
        
        protected Object doInBackground() throws Exception {
            String data = _view.getData0();
            Chain.blockchain.get(0).setData(data);
            System.out.println(Chain.blockchain.get(0).getData());
            return null;
        }
    }


}

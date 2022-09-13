package bwl.main.bitcoin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.NoSuchAlgorithmException;

public class Controller {

  private  View _view;
  private Model _model;


  public Controller(){

      this._view = new View();
      this._model = new Model();

      addListener();

      /*while (true){
          String wert = _view.getEingabe();


          try {
              _model.berechneHash(wert);
          } catch (NoSuchAlgorithmException e1) {
              e1.printStackTrace();
          }

          _view.setErgebnis(_model.getFinalHash());

      }*/

  }

  public void showView(){

      this._view.setVisible(true);

  }



  private void addListener(){
      this._view.setHasberechnenListenerTextfield(new HashberechnenListener());
      this._view.setResetFormListener(new ResetFormListener());
  }


  class HashberechnenListener implements KeyListener {
      /*@Override
      public void actionPerformed(ActionEvent e) {
          String wert = _view.getEingabe();


          try {
              _model.berechneHash(wert);
          } catch (NoSuchAlgorithmException e1) {
              e1.printStackTrace();
          }

          _view.setErgebnis(_model.getFinalHash());

      }*/

      public void keyTyped(KeyEvent e) {

      }

      public void keyPressed(KeyEvent e) {

      }

      public void keyReleased(KeyEvent e) {
          String wert = _view.getEingabe();


          try {
              _model.berechneHash(wert);
          } catch (NoSuchAlgorithmException e1) {
              e1.printStackTrace();
          }

          _view.setErgebnis(_model.getFinalHash());

      }
  }

  class ResetFormListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
          _view.resetView();
          _model.zurueckSetzen();
      }
  }
}

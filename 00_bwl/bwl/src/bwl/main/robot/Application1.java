package bwl.main.robot;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;

import javax.swing.JFrame;


public class Application1 {
    public static void main(String[] args) {
        Toolkit.getDefaultToolkit().addAWTEventListener(
          new Listener(), AWTEvent.MOUSE_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static class Listener implements AWTEventListener {
        public void eventDispatched(AWTEvent event) {
            System.out.print(MouseInfo.getPointerInfo().getLocation() + " | ");
            System.out.println(event);
            Robot robot;
            try {
              robot = new Robot();
              Color c = robot.getPixelColor(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
              
              System.out.println(c.getRed() + " " + c.getBlue() + " " + c.getGreen());
            } catch (AWTException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }

            
        }
    }
}


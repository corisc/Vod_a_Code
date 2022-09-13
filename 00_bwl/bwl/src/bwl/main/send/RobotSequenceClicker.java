package bwl.main.send;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ml.views.EingabeFeld;
import com.ml.views.Fenster;
import com.ml.views.Schalter;
import com.ml.views.Text;

public class RobotSequenceClicker {

  private Robot robot;

  public static void main(String args[]) throws Exception {
    new RobotSequenceClicker();
  }

  // https://youtu.be/GSgsQMECF9E

  public RobotSequenceClicker() throws Exception {

    List<List<String>> records = new ArrayList<List<String>>();
    List<String> values = null;
    System.out.println("" + System.getProperty("user.dir"));

    try {
      Scanner scanner = new Scanner(new File("seq.csv"));
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        values = new ArrayList<String>();
        Scanner rowScanner = new Scanner(line);
        rowScanner.useDelimiter("\\,");
        while (rowScanner.hasNext()) {
          values.add(rowScanner.next());
        }
      }
      records.add(values);
    } catch (Exception e) {
      e.printStackTrace();
    }

    int mins = 1;

    Fenster w1 = new Fenster("Eingabe");

    String ausgabe = "Klicking: ";
    for (int t = 0; t < records.get(0).size(); t = t + 3) {
      ausgabe = ausgabe + " " + new Integer(records.get(0).get(t)).intValue()
          + " " + new Integer(records.get(0).get(t + 1)).intValue();
      ausgabe = ausgabe + " mins: "
          + (new Integer(records.get(0).get(t + 2))).intValue() + " ";

    }

    Text t4 = new Text("Schleife laeuft: " + ausgabe);
    w1.zeige(t4, 50, 100);
    Thread.sleep(5000);

    for (;;) {

      for (int t = 0; t < records.get(0).size(); t = t + 3) {

        this.robot = new Robot();

        this.robot.mouseMove(new Integer(records.get(0).get(t)).intValue(),
            new Integer(records.get(0).get(t + 1)).intValue());
          mins = (new Integer(records.get(0).get(t + 2))).intValue();
          if (mins < 1) {
            mins = 1;
            Thread.sleep(50);
            this.robot.mousePress(InputEvent.BUTTON1_MASK);
            Thread.sleep(50);
            this.robot.mouseRelease(InputEvent.BUTTON1_MASK);
          }
          if (mins == 9999){
            mins = 1;
            this.robot.mousePress(InputEvent.BUTTON1_MASK);
            this.robot.mouseRelease(InputEvent.BUTTON1_MASK);
            this.robot.delay(50);
            this.robot.mousePress(InputEvent.BUTTON1_MASK);
            this.robot.mouseRelease(InputEvent.BUTTON1_MASK);
          }


        Thread.sleep(mins * 60000);
      }
    }

  }

  public RobotSequenceClicker(Robot robot) {
    this.robot = robot;
  }

  public void type(CharSequence characters) {
    int length = characters.length();
    for (int i = 0; i < length; i++) {
      char character = characters.charAt(i);
      type(character);
    }
  }

  public void type(char character) {
    System.out.println("FOUND!!!!!!!!!!: " + character);
    switch (character) {
    case 'a':
      doType(KeyEvent.VK_A);
      break;
    case 'b':
      doType(KeyEvent.VK_B);
      break;
    case 'c':
      doType(KeyEvent.VK_C);
      break;
    case 'd':
      doType(KeyEvent.VK_D);
      break;
    case 'e':
      doType(KeyEvent.VK_E);
      break;
    case 'f':
      doType(KeyEvent.VK_F);
      break;
    case 'g':
      doType(KeyEvent.VK_G);
      break;
    case 'h':
      doType(KeyEvent.VK_H);
      break;
    case 'i':
      doType(KeyEvent.VK_I);
      break;
    case 'j':
      doType(KeyEvent.VK_J);
      break;
    case 'k':
      doType(KeyEvent.VK_K);
      break;
    case 'l':
      doType(KeyEvent.VK_L);
      break;
    case 'm':
      doType(KeyEvent.VK_M);
      break;
    case 'n':
      doType(KeyEvent.VK_N);
      break;
    case 'o':
      doType(KeyEvent.VK_O);
      break;
    case 'p':
      doType(KeyEvent.VK_P);
      break;
    case 'q':
      doType(KeyEvent.VK_Q);
      break;
    case 'r':
      doType(KeyEvent.VK_R);
      break;
    case 's':
      doType(KeyEvent.VK_S);
      break;
    case 't':
      doType(KeyEvent.VK_T);
      break;
    case 'u':
      doType(KeyEvent.VK_U);
      break;
    case 'v':
      doType(KeyEvent.VK_V);
      break;
    case 'w':
      doType(KeyEvent.VK_W);
      break;
    case 'x':
      doType(KeyEvent.VK_X);
      break;
    case 'y':
      doType(KeyEvent.VK_Y);
      break;
    case 'z':
      doType(KeyEvent.VK_Z);
      break;
    case 'A':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_A);
      break;
    case 'B':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
      break;
    case 'C':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_C);
      break;
    case 'D':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_D);
      break;
    case 'E':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_E);
      break;
    case 'F':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_F);
      break;
    case 'G':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_G);
      break;
    case 'H':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_H);
      break;
    case 'I':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_I);
      break;
    case 'J':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_J);
      break;
    case 'K':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_K);
      break;
    case 'L':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_L);
      break;
    case 'M':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_M);
      break;
    case 'N':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_N);
      break;
    case 'O':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_O);
      break;
    case 'P':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_P);
      break;
    case 'Q':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Q);
      break;
    case 'R':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_R);
      break;
    case 'S':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_S);
      break;
    case 'T':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_T);
      break;
    case 'U':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_U);
      break;
    case 'V':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_V);
      break;
    case 'W':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_W);
      break;
    case 'X':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_X);
      break;
    case 'Y':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Y);
      break;
    case 'Z':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Z);
      break;
    case '`':
      doType(KeyEvent.VK_BACK_QUOTE);
      break;
    case '0':
      doType(KeyEvent.VK_0);
      break;
    case '1':
      doType(KeyEvent.VK_1);
      break;
    case '2':
      doType(KeyEvent.VK_2);
      break;
    case '3':
      doType(KeyEvent.VK_3);
      break;
    case '4':
      doType(KeyEvent.VK_4);
      break;
    case '5':
      doType(KeyEvent.VK_5);
      break;
    case '6':
      doType(KeyEvent.VK_6);
      break;
    case '7':
      doType(KeyEvent.VK_7);
      break;
    case '8':
      doType(KeyEvent.VK_8);
      break;
    case '9':
      doType(KeyEvent.VK_9);
      break;
    case '-':
      doType(KeyEvent.VK_MINUS);
      break;
    case '=':
      doType(KeyEvent.VK_EQUALS);
      break;
    case '~':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE);
      break;
    case '!':
      pressTwo(KeyEvent.VK_SHIFT, KeyEvent.VK_1);
      break;
    case '@':
      doType(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_Q);
      break;
    case '#':
      doType(KeyEvent.VK_NUMBER_SIGN);
      break;
    case '$':
      doType(KeyEvent.VK_DOLLAR);
      break;
    case '%':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_5);
      break;
    case '^':
      doType(KeyEvent.VK_CIRCUMFLEX);
      break;
    case '&':
      doType(KeyEvent.VK_AMPERSAND);
      break;
    case '*':
      doType(KeyEvent.VK_ASTERISK);
      break;
    case '(':
      doType(KeyEvent.VK_LEFT_PARENTHESIS);
      break;
    case ')':
      doType(KeyEvent.VK_RIGHT_PARENTHESIS);
      break;
    case '_':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_MINUS);
      break;
    case '+':
      doType(KeyEvent.VK_PLUS);
      break;
    case '\t':
      doType(KeyEvent.VK_TAB);
      break;
    case '\n':
      doType(KeyEvent.VK_ENTER);
      break;
    case '[':
      doType(KeyEvent.VK_OPEN_BRACKET);
      break;
    case ']':
      doType(KeyEvent.VK_CLOSE_BRACKET);
      break;
    case '\\':
      doType(KeyEvent.VK_BACK_SLASH);
      break;
    case '{':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET);
      break;
    case '}':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET);
      break;
    case '|':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH);
      break;
    case ';':
      pressTwo(KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA);
      break;
    case ':':
      doType(KeyEvent.VK_COLON);
      break;
    case '\'':
      doType(KeyEvent.VK_QUOTE);
      break;
    case '"':
      doType(KeyEvent.VK_QUOTEDBL);
      break;
    case ',':
      doType(KeyEvent.VK_COMMA);
      break;
    case '<':
      doType(KeyEvent.VK_LESS);
      break;
    case '.':
      doType(KeyEvent.VK_PERIOD);
      break;
    case '>':
      doType(KeyEvent.VK_GREATER);
      break;
    case '/':
      pressTwo(KeyEvent.VK_SHIFT, KeyEvent.VK_7);
      break;
    case '?':
      doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH);
      break;
    case ' ':
      doType(KeyEvent.VK_SPACE);
      break;
    default:
      throw new IllegalArgumentException("Cannot type character " + character);
    }
  }

  public void doType(int... keyCodes) {
    doType(keyCodes, 0, keyCodes.length);
  }

  public void pressTwo(int keycode1, int keycode2) {
    robot.keyPress(keycode1);
    robot.keyPress(keycode2);
    robot.delay(200);
    robot.keyRelease(keycode1);
    robot.keyRelease(keycode2);
  }

  public void doType(int[] keyCodes, int offset, int length) {
    if (length == 0) {
      return;
    }
    robot.keyPress(keyCodes[offset]);
    doType(keyCodes, offset + 1, length - 1);
    robot.keyRelease(keyCodes[offset]);
  }

}

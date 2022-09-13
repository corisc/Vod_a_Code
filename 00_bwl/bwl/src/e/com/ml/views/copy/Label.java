package e.com.ml.views.copy;

import java.awt.Component;

public class Label {

  private String text;
  private Double zahl;
  private Component component;
  private int textSize = 11;

  public Label(String text) {
    super();
    this.text = text;
  }

  public Label(double zahl) {
    super();
    this.zahl = zahl;
  }

  public Label(String text, int textSize) {
    super();
    this.text = text;
    this.textSize = textSize;
  }

  public Label(double zahl, int textSize) {
    super();
    this.zahl = zahl;
    this.textSize = textSize;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Double getZahl() {
    return zahl;
  }

  public void setZahl(double zahl) {
    this.zahl = zahl;
  }

  public Component getComponent() {
    return component;
  }

  public void setComponent(Component component) {
    this.component = component;
  }

  public int getTextSize() {
    return textSize;
  }
}

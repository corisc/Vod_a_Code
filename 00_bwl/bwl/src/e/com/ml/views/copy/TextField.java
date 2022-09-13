package e.com.ml.views.copy;

public class TextField {
	
	private String text = "";
	private int    w,h;
	
	public String getText() {
	  return text;
	}

	public TextField(String text){
	  this.text = text;
	  this.w = 400;
	  this.h = 100;
	}

	public TextField(int w, int h, String text){
      this.text = text;
      this.w = w;
      this.h = h;
  }

  public int getW() {
    return w;
  }

  public int getH() {
    return h;
  }

  public void setText(String text) {
    this.text = text;
  }
  
}

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Text extends Shape { // child class

	public Text(int x, int y, Color c, String str, Font f) {
		super(x, y, c, str, f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		
		// draws the text
		g.setColor(c);
		g.setFont(f);
		g.drawString(str, x, y);
		
	}

	@Override
	public boolean isOn(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reSize(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		
	}

}

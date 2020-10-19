import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	public Circle(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(c);
		g.fillOval(x, y, width, height);
		
	}

	@Override
	public boolean isOn(int x, int y) {

		int centerX = (this.x+(width/2));
		int centerY = (this.y+(height/2));
		
		int d1 = (int)(Math.sqrt(Math.pow((centerX-(this.x+(width/2))), 2) + Math.pow((centerY-this.y), 2)));
		int d2 = (int)(Math.sqrt(Math.pow((centerX-x), 2) + Math.pow((centerY-y), 2)));
		
		if (d2 <= d1) {
			
			return true;
			
		} else {
			
			return false;
		
		}
		
	}

	@Override
	public void reSize(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		
	}

}

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	public Circle(int x, int y, int w, int h, Color c) { // child class
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

		// draws the circle
		g.setColor(c);
		g.fillOval(x, y, width, height);
		
	}

	@Override
	public boolean isOn(int x, int y) {

		// checks if the user is clicking on the circle by using the distance formula
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
		
		//changes the size of the circle depending on where the user's mouse is

		int xlen = 0;
		int ylen = 0;
		
		if (x1 <= x2) {
			
			x = x1;
			xlen = x2-x1;
			
		} else if (x1 > x2) {
			
			x = x2;
			xlen = x1-x2;
			
		}
		
		if (y1 <= y2) {
			
			y = y1;
			ylen = y2-y1;
			
		} else if (y1 > y2) {
			
			y = y2;
			ylen = y1-y2;
			
		}
		
		width = 2*(int)(Math.sqrt(Math.pow(xlen,2)+Math.pow(ylen, 2)));
		height = 2*(int)(Math.sqrt(Math.pow(xlen,2)+Math.pow(ylen, 2)));
		
	}

}

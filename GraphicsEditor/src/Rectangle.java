import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	public Rectangle(int x, int y, int w, int h, Color c) {
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

		//draws the rectangle
		
		g.setColor(c);
		g.fillRect(x, y, width, height);
		
	}

	@Override
	public boolean isOn(int x, int y) {
		// TODO Auto-generated method stub
		
		// checks if the user is clicking on the rectangle by checking if the user is clicking between the top
		// left and right points in the rectangle
		
		if (x < (this.x+width) && x > (this.x) && y < (this.y+height) && y > (this.y)) {
			
			return true;
			
		} else {
			
			return false;
			
		}
	
	}

	@Override
	public void reSize(int x1, int y1, int x2, int y2) {
		
		// changes the size of the rectangle depending on  where the user drags

		if (x1 <= x2) {
			
			x = x1;
			width = x2-x1;
			
		} else if (x1 > x2) {
			
			x = x2;
			width = x1-x2;
			
		}
		
		if (y1 <= y2) {
			
			y = y1;
			height = y2-y1;
			
		} else if (y1 > y2) {
			
			y = y2;
			height = y1-y2;
			
		}
		
		
	}

}

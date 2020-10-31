import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{

	public Line(int x, int y, int w, int h, Color c) {
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

		// draws the line
		g.setColor(c);
		g.drawLine(this.x, this.y, x+(width), y+(height));
		
	}

	@Override
	public boolean isOn(int x, int y) {

		// checks if the user is clicking on the line by using the distance formula 
		int d1 = (int)(Math.sqrt(Math.pow((this.x-x), 2) + Math.pow((this.y-y), 2)));
		int d2 = (int)(Math.sqrt(Math.pow(((this.x+width)-x), 2) + Math.pow(((this.y+height)-y), 2)));
		int d3 = (int)(Math.sqrt(Math.pow(((this.x+width)-this.x), 2) + Math.pow(((this.y+height)-this.y), 2)));
		
		if (d1+d2 <= d3) {
			
			return true;
			
		} else {
			
			return false;
			
		}
	
	}

	@Override
	public void reSize(int x1, int y1, int x2, int y2) { 
			
		// changes the length of the line depending on where the user drags their mouse
		
		x = x1;
		width = (x2-x1);
			
		y = y1;
		height = (y2-y1);
		
	}

}

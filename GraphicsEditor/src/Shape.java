import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

	int x, y, width, height;
	Color c;
	String type;
	
	public Shape (int x, int y, int w, int h, Color c) {
		
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		this.c = c;
		
	}
	
	public void move() {};
	
	public abstract Shape copy();
	public abstract void draw (Graphics g) ;
	public abstract boolean isOn(int x, int y);
	public abstract void reSize(int x1, int y1, int x2, int y2);
	
}

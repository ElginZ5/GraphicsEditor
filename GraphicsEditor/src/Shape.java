import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

// the parent shape class
public abstract class Shape {

	// variables we need for each shape
	int x, y, width, height;
	Color c;
	String str;
	Font f;
	
	// constructor for the rectangle circle and line
	public Shape (int x, int y, int w, int h, Color c) {
		
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		this.c = c;
		
	}
	
	// constructor for text
	public Shape(int x2, int y2, Color c2, String str, Font f) {

		this.x = x2;
		this.y = y2;
		this.c = c2;
		this.str = str;
		this.f = f;
		
	}
	
	// the move method
	public void move(int x1, int y1, int x2, int y2) {
		
		x = x2-x1;
		y = y2-y1;
		
	};
	
	public abstract Shape copy();
	public abstract void draw (Graphics g) ;
	public abstract boolean isOn(int x, int y);
	public abstract void reSize(int x1, int y1, int x2, int y2);
	
}

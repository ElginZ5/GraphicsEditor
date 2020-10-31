import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.text.BadLocationException;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsEditor {

	private final int WIDTH = 700, HEIGHT = 600, BUTTON_HEIGHT = 90; // width and height of the canvas and the button height
	
	public int xLoc, yLoc; // x coord y coord
	
	Color c; // color of the shape
	
	public int currShape; // the shape the user is clicking on
	
	public int tSize = 0;
	
	public int mode = 0; // rect = 1; circle = 2; delete = 3; line = 4; copy = 5; paste = 6; clear = 7; text = 8
	
	ArrayList<Shape> Shapes = new ArrayList<Shape>(); // the arraylist with the shapes the user has drawn in it
	ArrayList<Shape> copiedShapes = new ArrayList<Shape>(); // the arraylist that has the copied shape in it
	
	private JTextArea displayAreaText, displayAreaTSize, textContent, textSize; // display and text areas for text
	
	private Font myFont = new Font("Arial", Font.BOLD, 16); // font of the textt
	
	public GraphicsEditor () { // constructor
		
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		
		JColorChooser colorChooser = new JColorChooser();
		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		
		JTextArea textContent = new JTextArea(); // text area for inputing the text
		textContent.setEditable(true);
		
		JTextArea textSize = new JTextArea(); // text area for inputing the size
		textSize.setEditable(true);
		
		// setting up the displayareas
		displayAreaText = new JTextArea();
		displayAreaText.setEditable(false);
		displayAreaText.setBackground(Color.CYAN);
		
		displayAreaText.setFont(myFont);
		displayAreaText.setText("Text: ");
		
		displayAreaTSize = new JTextArea();
		displayAreaTSize.setEditable(false);
		displayAreaTSize.setBackground(Color.CYAN);
		
		displayAreaTSize.setFont(myFont);
		displayAreaTSize.setText("Text Size: ");
		
		textContent.setPreferredSize(new Dimension(100, 20)); // size of the textboxes
		textSize.setPreferredSize(new Dimension(100, 20));
		
		panel.setBorder(BorderFactory.createTitledBorder("Graphics Editor")); // border
		
		// all of the buttons
		JButton rectangle = new JButton("Rectangle");
		JButton circle = new JButton("Circle");
		JButton line = new JButton("Line");
		JButton delete = new JButton("Delete");
		JButton copy = new JButton("Copy");
		JButton paste = new JButton("Paste");
		JButton clear = new JButton("Clear Canvas");
		JButton move = new JButton("Move");
		JButton colorPicker = new JButton("Choose Color");
		JButton text = new JButton("Text");
		
		// when you click the button the mode changes
		rectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				mode = 1;
				
			}
			
		});
		
		circle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				mode = 2;
				
			}
			
		});
		
		line.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mode = 4;
				
			}
			
			
		});
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mode = 3;
				
			}
			
		});
		
		copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mode = 5;
				
			}
			
		});
		
		paste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mode = 6;
				
			}
			
		});
		
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < Shapes.size(); i++) {
					
					Shapes.remove(i);
					frame.getContentPane().repaint();
					
				}
				
			}
			
		});
		
		move.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mode = 7;
				
			}
			
		});
		
		colorPicker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				c = colorChooser.showDialog(null, "Select a Color", Color.CYAN); // the color is the color the user picks
				
			}
			
		});
		
		text.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mode = 8;
				
			}
			
		});
		
		JPanel innerPanel = new JPanel(); // panel to add the buttons
		innerPanel.setPreferredSize(new Dimension(HEIGHT, BUTTON_HEIGHT)); // size of the inner panel
		innerPanel.setBackground(Color.CYAN);
		// adding all of the buttons, textareas, and display areas
		innerPanel.add(circle);
		innerPanel.add(rectangle);
		innerPanel.add(line);
		innerPanel.add(delete);
		innerPanel.add(copy);
		innerPanel.add(paste);
		innerPanel.add(clear);
		innerPanel.add(move);
		innerPanel.add(colorPicker);
		innerPanel.add(text);
		innerPanel.add(displayAreaText);
		innerPanel.add(textContent);
		innerPanel.add(displayAreaTSize);
		innerPanel.add(textSize);
		
		// draw panel to draw the shapes
		JPanel drawPanel = new JPanel() {
			
			public void paint (Graphics g) {
				
				for (int i = 0; i < Shapes.size(); i++) {
					
					Shapes.get(i).draw(g);
					
				}
				
			
				
			}
			
		};
		
		drawPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT-BUTTON_HEIGHT));
		
		// mouse listener for when the user clicks on the draw panel
		drawPanel.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent e) {

				// if the user clicks on the rectangle button a rectangle is drawn
				if (mode == 1) {
					
					xLoc = e.getX(); // the location of were the user clicked
					yLoc = e.getY();
					Shapes.add(new Rectangle(0, 0, 0, 0, c));
					
				// same thing for the circle
				} else if (mode == 2) {
					
					xLoc = e.getX();
					yLoc = e.getY();
					Shapes.add(new Circle(0, 0, 0, 0, c));
					
				// if the user clicks the delete button and if the user actually clicked a shape, it gets removed
				} else if (mode == 3) {
					
					for (int i = 0; i < Shapes.size(); i++) {
					
						if (Shapes.get(i).isOn(e.getX(), e.getY())) {
						
							xLoc = e.getX();
							yLoc = e.getY();
						
							Shapes.remove(i);
							frame.getContentPane().repaint();
						
						}
					}
				
				// if user clicks line, a line is drawn
				} else if (mode == 4) {
					
					xLoc = e.getX();
					yLoc = e.getY();
					Shapes.add(new Line(0, 0, 0, 0, c));
					
				// if the user clicks the copy button all of the shapes that have been drawn
				// are saved into an array for later use
				} else if (mode == 5) {
					
					for (int i = 0; i < Shapes.size(); i++) {
						
						copiedShapes.add(Shapes.get(i));
						
					}
					
				// if the user clicks the paste button all of the shapes he copied and pasted back onto the panel
				} else if (mode == 6) {
					
					for (int i = 0; i < copiedShapes.size(); i++) {
						
						Shapes.add(copiedShapes.get(i));
						frame.getContentPane().repaint();
						
					}
					
				// if the user clicks the move button and if he actually clicked a shape,
				// the shape he clicked is saved into currShape
				} else if (mode == 7) {
					
					for (int i = 0; i < Shapes.size(); i++) {
						
						if (Shapes.get(i).isOn(e.getX(), e.getY())) {
							
							xLoc = e.getX();
							yLoc = e.getY();
							currShape = i;
							
						}
						
					}
					
				// if the user clicked text, the text he typed will be pasted and the size will be what the user
				// put in, unless he left the textsize box empty
				}	else if (mode == 8) {
					
					if (!textSize.getText().equals("")) 
						tSize = Integer.parseInt(textSize.getText().trim());
					else
						tSize = 20;
					
					Font textFont = new Font("Arial", Font.PLAIN, tSize);
					Shapes.add(new Text(e.getX(), e.getY(), c, textContent.getText().trim(), textFont));
					frame.getContentPane().repaint();
					
				}
				
				frame.getContentPane().repaint();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
						
			
		});
		
		drawPanel.addMouseMotionListener(new MouseMotionListener() {

			// when user drags the mouse
			@Override
			public void mouseDragged(MouseEvent e) {

				if (mode == 1 || mode == 2 || mode == 4) {
					
					// if the mode is rectangle, circle, or line, the size of the shapes get resized
					// depending on where the user moves his mouse
					Shapes.get(Shapes.size()-1).reSize(xLoc, yLoc, e.getX(), e.getY());
					
				} else if (mode == 7) {
					
					// if the mode is move, the shape gets moved to wherever the user's mouse is
					Shapes.get(currShape).move(0, 0, e.getX(), e.getY());
					
				}

				frame.getContentPane().repaint();
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			
		});
		
		// adding the inner and draw panels
		panel.add(innerPanel);
		panel.add(drawPanel);
		
		// setting up the frame
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.setVisible(true);
		
		
	}
	
	public static void main (String args[]) {
		
		// running the graphics editor
		new GraphicsEditor();
		
	}
	

}

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsEditor {

	private final int WIDTH = 700, HEIGHT = 600, BUTTON_HEIGHT = 90;
	
	public int xLoc, yLoc;
	
	public int shapeMode = 0; // rect = 1; circle = 2
	
	ArrayList<Shape> Shapes = new ArrayList<Shape>();
	
	private JTextArea displayArea;
	
	public GraphicsEditor () {
		
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		
		panel.setBorder(BorderFactory.createTitledBorder("Graphics Editor"));
		
		JButton rectangle = new JButton("Rectangle");
		JButton circle = new JButton("Circle");
		
		rectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				shapeMode = 1;
				
			}
			
		});
		
		circle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				shapeMode = 2;
				
			}
			
		});
		
		JPanel innerPanel = new JPanel();
		innerPanel.setPreferredSize(new Dimension(HEIGHT, BUTTON_HEIGHT));
		innerPanel.setBackground(Color.CYAN);
		innerPanel.add(circle);
		innerPanel.add(rectangle);
		
		panel.add(innerPanel);
		

		JPanel drawPanel = new JPanel() {
			
			public void paint (Graphics g) {
				
				for (int i = 0; i < Shapes.size(); i++) {
					
					Shapes.get(i).draw(g);
					
				}
				
			}
			
		};
		
		drawPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT-BUTTON_HEIGHT));
		drawPanel.setBackground(Color.PINK);
		
		drawPanel.addMouseListener(new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (shapeMode == 1) {
					
					xLoc = e.getX();
					yLoc = e.getY();
					Shapes.add(new Rectangle(xLoc, yLoc, 200, 100, Color.BLUE));
					frame.getContentPane().repaint();
					
				} else if (shapeMode == 2) {
					
					xLoc = e.getX();
					yLoc = e.getY();
					Shapes.add(new Circle(xLoc, yLoc, 100, 100, Color.BLUE));
					frame.getContentPane().repaint();
					
				}
				
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
		
		panel.add(drawPanel);
		
		
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.setVisible(true);
		
		
	}
	
	public static void main (String args[]) {
		
		new GraphicsEditor();
		
	}
	

}

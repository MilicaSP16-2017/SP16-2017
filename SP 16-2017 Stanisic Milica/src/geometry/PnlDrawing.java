package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PnlDrawing extends JPanel {
	  
	

	/**
	 * 
	 */
	
	public  ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public PnlDrawing() {
		
		setBackground(Color.WHITE);
	}
	public static void main(String[] args) {
		
	}
	@Override
	public void paint(Graphics g) {
	super.paint(g);
	for (int i = 0; i < shapes.size(); i++)
	{
		
		shapes.get(i).draw(g);
	}
	}

}

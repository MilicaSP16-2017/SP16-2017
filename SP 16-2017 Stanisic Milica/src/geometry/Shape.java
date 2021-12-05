package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable {
	protected boolean selected;
	protected Color edgeColor;
	protected Color innerColor;
	
	public Shape() {
		edgeColor = Color.BLACK;
		innerColor = Color.WHITE;
		
	}
	
	public Shape(boolean selected) {
		edgeColor = Color.BLACK;
		innerColor = Color.WHITE;
		this.selected = selected;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
	
}

package fares;

import java.awt.Color;
import java.awt.Point;

public class VisualNode {
	protected final static int RADIUS = 40;
	private Node node;
	private Point position;
	private Color color;
	
	public VisualNode(Node node, Point position) {
		this.node = node;
		this.position = position;
		this.color = Color.BLUE;  // Default color
	}
	
	public void draw() {
		Canvas.PEN.setColor(color);
		Canvas.PEN.fillOval(position.x, position.y, RADIUS, RADIUS);
		Canvas.PEN.setColor(Color.WHITE);
		Canvas.PEN.drawString("" + node.getId(), position.x+15, position.y+25);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void resetColor() {
		this.color = Color.BLUE;
	}

	public Point getPos() {
		return position;
	}
	
	public Node getNode() {
		return node;
	}
	
	public int getId() {
		return node.getId();
	}
}

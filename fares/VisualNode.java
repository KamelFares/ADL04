package fares;

import java.awt.Color;
import java.awt.Point;

public class VisualNode {
	protected final static int RADIUS = 40;
	private Node node;  // Link to the graph Node
	private Point position;
	
	public VisualNode(Node node, Point position) {
		this.node = node;
		this.position = position;
	}
	
	public void draw() {
		Canvas.PEN.setColor(Color.BLUE);
		Canvas.PEN.fillOval(position.x, position.y, RADIUS, RADIUS);
		Canvas.PEN.setColor(Color.WHITE);
		Canvas.PEN.drawString("" + node.getId(), position.x+15, position.y+25);
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

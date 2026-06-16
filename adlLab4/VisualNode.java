package adlLab4;

import java.awt.Color;
import java.awt.Point;

public class VisualNode {
	protected final static int RADIUS = 40;
	private int id;
	private Point position;
	
	public VisualNode(int id, Point position) {
		this.id = id;
		this.position = position;
	}
	
	public void draw() {
		Canvas.PEN.setColor(Color.BLUE);
		Canvas.PEN.fillOval(position.x, position.y, RADIUS, RADIUS);
		Canvas.PEN.setColor(Color.WHITE);
		Canvas.PEN.drawString("" + id, position.x+15, position.y+25);
	}

	public Point getPos() {
		return position;
	}
}

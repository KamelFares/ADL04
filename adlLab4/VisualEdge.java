package adlLab4;

import java.awt.Color;

public class VisualEdge {
	private int x1, y1, x2, y2;
	
	public VisualEdge(VisualNode sourceNode, VisualNode destinationNode) {
		x1 = sourceNode.getPos().x + (VisualNode.RADIUS / 2);
		y1 = sourceNode.getPos().y + (VisualNode.RADIUS / 2);
		x2 = destinationNode.getPos().x + (VisualNode.RADIUS / 2);
		y2 = destinationNode.getPos().y + (VisualNode.RADIUS / 2);
	}
	
	public void draw() {
		Canvas.PEN.setColor(Color.BLACK);
		Canvas.PEN.drawLine(x1, y1, x2, y2);
	}
}
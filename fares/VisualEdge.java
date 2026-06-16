package fares;

import java.awt.Color;

public class VisualEdge {
	private int x1, y1, x2, y2;
	private int weight;
	
	public VisualEdge(VisualNode sourceNode, VisualNode destinationNode, int weight) {
		x1 = sourceNode.getPos().x + (VisualNode.RADIUS / 2);
		y1 = sourceNode.getPos().y + (VisualNode.RADIUS / 2);
		x2 = destinationNode.getPos().x + (VisualNode.RADIUS / 2);
		y2 = destinationNode.getPos().y + (VisualNode.RADIUS / 2);
		this.weight = weight;
	}
	
	public void draw() {
		Canvas.PEN.setColor(Color.BLACK);
		Canvas.PEN.drawLine(x1, y1, x2, y2);
		
		// Draw weight in the middle of the edge
		int midX = (x1 + x2) / 2;
		int midY = (y1 + y2) / 2;
		Canvas.PEN.setColor(Color.RED);
		Canvas.PEN.drawString("" + weight, midX, midY);
	}
}
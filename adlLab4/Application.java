package adlLab4;

import java.awt.Color;
import java.awt.Point;

public class Application {
	private VisualNode testNode1, testNode2;
	private VisualEdge testEdge;

	public Application() {
		// construct your graph
		testNode1 = new VisualNode(1, new Point(100, 100));
		testNode2 = new VisualNode(2, new Point(300, 300));
		testEdge = new VisualEdge(testNode1, testNode2);
	}

	public void draw() { 
		// just a too simple minimal example 
		// to draw a graph with two vertices
		testEdge.draw();
		testNode1.draw();
		testNode2.draw();

		/*
		 * here you would include appropriate getters 
		 * for the components of your graph,
		 * which you are going to draw
		 */
		
	}
}

package fares;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Application {
	private Graph graph;
	private Map<Integer, VisualNode> visualNodes;
	
	public Application() {
		// Create the graph data structure
		graph = new Graph();
		visualNodes = new HashMap<>();
		
		// Create nodes with positions forming a K shape
		addVisualVertex(1, new Point(100, 80));   // Top-left
		addVisualVertex(2, new Point(100, 200));  // Middle-left (junction)
		addVisualVertex(3, new Point(100, 320));  // Bottom-left
		addVisualVertex(4, new Point(280, 100));  // Top-right diagonal
		addVisualVertex(5, new Point(280, 300));  // Bottom-right diagonal
		
		// Add edges forming K shape
		graph.addEdge(1, 2, 5);  // Vertical down
		graph.addEdge(2, 3, 3);  // Vertical down
		graph.addEdge(2, 4, 7);  // Diagonal up-right
		graph.addEdge(2, 5, 2);  // Diagonal down-right
		graph.addEdge(1, 4, 4);  // Top diagonal connection
		graph.addEdge(3, 5, 6);  // Bottom diagonal connection
	}
	
	private void addVisualVertex(int id, Point position) {
		Node node = new Node(id, 0);
		VisualNode vNode = new VisualNode(node, position);
		visualNodes.put(id, vNode);
	}
	
	/**
	 * Highlight a path by coloring vertices RED.
	 * Call this method to visualize the path found by somePath().
	 */
	public void showPath() {
		// Reset all nodes to default color
		for (VisualNode vNode : visualNodes.values()) {
			vNode.resetColor();
		}
		
		// Find a path of length 4 starting from vertex 1
		AdjacencyList path = graph.somePath(1, 4);
		
		// Color all vertices in the path RED
		Iterator<Integer> pathIter = path.getNeighbors();
		while (pathIter.hasNext()) {
			int vertexId = pathIter.next();
			VisualNode vNode = visualNodes.get(vertexId);
			if (vNode != null) {
				vNode.setColor(Color.RED);
			}
		}
	}
	
	public void draw() {
		// Draw all edges first (so they appear behind nodes)
		for (Integer vertexId : visualNodes.keySet()) {
			AdjacencyList neighbors = graph.getNeighboursFor(vertexId);
			if (neighbors != null) {
				Iterator<Integer> iter = neighbors.getNeighbors();
				while (iter.hasNext()) {
					int neighborId = iter.next();
					VisualNode source = visualNodes.get(vertexId);
					VisualNode dest = visualNodes.get(neighborId);
					int weight = graph.getWeight(vertexId, neighborId);
					
					if (source != null && dest != null) {
						VisualEdge edge = new VisualEdge(source, dest, weight);
						edge.draw();
					}
				}
			}
		}
		
		// Draw all nodes on top
		for (VisualNode vNode : visualNodes.values()) {
			vNode.draw();
		}
	}
	
	public Graph getGraph() {
		return graph;
	}
}

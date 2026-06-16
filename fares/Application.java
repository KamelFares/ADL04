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
		
		// Create nodes with positions
		addVisualVertex(1, new Point(100, 100));
		addVisualVertex(2, new Point(300, 100));
		addVisualVertex(3, new Point(500, 100));
		addVisualVertex(4, new Point(200, 300));
		addVisualVertex(5, new Point(400, 300));
		
		// Add edges with weights
		graph.addEdge(1, 2, 5);
		graph.addEdge(2, 3, 3);
		graph.addEdge(1, 4, 7);
		graph.addEdge(2, 4, 2);
		graph.addEdge(3, 5, 4);
		graph.addEdge(4, 5, 6);
	}
	
	private void addVisualVertex(int id, Point position) {
		graph.addVertex(id);
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

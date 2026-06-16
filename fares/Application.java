package fares;

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
		Node node = new Node(id, 0);  // value can be 0 by default
		VisualNode vNode = new VisualNode(node, position);
		visualNodes.put(id, vNode);
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

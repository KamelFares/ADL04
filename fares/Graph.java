package fares;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Simple weighted directed graph.
 */
public class Graph {
	private AdjacencyLists adjLists;
	private Map<String, Integer> edgeWeights;
	private int edgeCount;

	public Graph() {
		adjLists = new AdjacencyLists();
		edgeWeights = new HashMap<>();
		edgeCount = 0;
	}
 // should we add a method to remove edges or vertices? nah i think the edge do it by itself when we remove the vertex, and we dont need to remove edges for this task
	public void addEdge(int u, int v, int weight) {
		if (!adjLists.vertexExists(u)) adjLists.addVertex(u);
		if (!adjLists.vertexExists(v)) adjLists.addVertex(v);

		AdjacencyList neighbors = adjLists.getList(u);
		if (neighbors != null && !neighbors.contains(v)) {
			neighbors.add(v);
			edgeWeights.put(u + "-" + v, weight);
			edgeCount++;
		}
	}

	public AdjacencyList getNeighboursFor(int v) {
		return adjLists.getList(v);
	}

	public int numOfVertices() {
		return adjLists.numVertices();
	}

	public int numOfEdges() {
		return edgeCount;
	}

	public int getWeight(int u, int v) {
		Integer weight = edgeWeights.get(u + "-" + v);
		return weight != null ? weight : -1;
	}

	/**
	 * Simple algorithm to find a path of specific length.
	 * Returns the path as an AdjacencyList for easy visualization.
	 */
	public AdjacencyList somePath(int start, int length) {
		AdjacencyList path = new AdjacencyList();
		if (length <= 0 || !adjLists.vertexExists(start)) return path;
		
		Set<Integer> visited = new HashSet<>();
		findPath(start, length, path, visited);
		return path;
	}

	/**
	 * Recursively find a path by following edges.
	 */
	private void findPath(int current, int needed, AdjacencyList path, Set<Integer> visited) {
		path.add(current);
		if (needed == 1) return;
		
		visited.add(current);
		AdjacencyList neighbors = adjLists.getList(current);
		
		if (neighbors != null) {
			Iterator<Integer> iter = neighbors.getNeighbors();
			while (iter.hasNext()) {
				int next = iter.next();
				if (!visited.contains(next)) {
					findPath(next, needed - 1, path, visited);
					break;
				}
			}
		}
		
		visited.remove(current);
	}
}

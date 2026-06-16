package fares;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * A weighted directed graph.
 * Each edge has a source vertex, destination vertex, and a weight.
 */
public class Graph {
	// Store all vertices and their neighbors
	private AdjacencyLists adjLists;
	
	// Store edge weights using "from-to" as key
	private Map<String, Integer> edgeWeights;
	
	// Count total edges
	private int edgeCount;

	public Graph() {
		adjLists = new AdjacencyLists();
		edgeWeights = new HashMap<>();
		edgeCount = 0;
	}

	// Add a new vertex to the graph
	public void addVertex(int vertexId) {
		adjLists.addVertex(vertexId);
	}

	// Add a directed edge from u to v with a weight
	public void addEdge(int u, int v, int weight) {
		// Create vertices if they don't exist
		if (!adjLists.vertexExists(u)) {
			adjLists.addVertex(u);
		}
		if (!adjLists.vertexExists(v)) {
			adjLists.addVertex(v);
		}

		// Add edge only if it doesn't already exist
		AdjacencyList neighborsOfU = adjLists.getList(u);
		if (neighborsOfU != null && !neighborsOfU.contains(v)) {
			neighborsOfU.add(v);
			edgeWeights.put(u + "-" + v, weight);
			edgeCount++;
		}
	}

	// Get all neighbors of a vertex
	public AdjacencyList getNeighboursFor(int v) {
		return adjLists.getList(v);
	}

	// Count total vertices
	public int numOfVertices() {
		return adjLists.numVertices();
	}

	// Count total edges
	public int numOfEdges() {
		return edgeCount;
	}

	// Get weight of edge from u to v (returns -1 if edge doesn't exist)
	public int getWeight(int u, int v) {
		Integer weight = edgeWeights.get(u + "-" + v);
		return weight != null ? weight : -1;
	}

	/**
	 * Find a path of exactly 'length' vertices starting from vertex u.
	 * Uses Depth-First Search to explore the graph.
	 */
	public AdjacencyList somePath(int startVertex, int length) {
		AdjacencyList path = new AdjacencyList();
		
		// Check if request is valid
		if (length <= 0 || !adjLists.vertexExists(startVertex)) {
			return path;
		}

		// Track visited vertices to avoid cycles
		Set<Integer> visited = new HashSet<>();
		
		// Start exploring from the start vertex
		explore(startVertex, length, path, visited);
		return path;
	}

	/**
	 * Recursive helper method to explore the graph and build a path.
	 * 
	 * @param current Current vertex we're visiting
	 * @param remaining How many more vertices we need
	 * @param path The path being built
	 * @param visited Set of vertices already in the current path
	 */
	private void explore(int current, int remaining, AdjacencyList path, Set<Integer> visited) {
		// Step 1: Add current vertex to path
		path.add(current);
		
		// Step 2: Check if we're done (found path of desired length)
		if (remaining == 1) {
			return;
		}

		// Step 3: Mark current vertex as visited
		visited.add(current);

		// Step 4: Get neighbors of current vertex
		AdjacencyList neighbors = adjLists.getList(current);
		if (neighbors == null) {
			visited.remove(current);  // Backtrack
			return;
		}

		// Step 5: Try to visit an unvisited neighbor
		Iterator<Integer> neighborIter = neighbors.getNeighbors();
		while (neighborIter.hasNext()) {
			int neighbor = neighborIter.next();
			
			// If neighbor not yet visited, explore it
			if (!visited.contains(neighbor)) {
				explore(neighbor, remaining - 1, path, visited);
				break;  // Stop after first path found
			}
		}
		
		// Step 6: Backtrack - remove from visited for other paths
		visited.remove(current);
	}
}

package fares;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 * Authors: Kamel Fares
 * Date: 2026-06-15
 * Purpose: Represents a weighted directed graph using adjacency lists and stores edge weights.
 *          Provides methods to add vertices/edges, query neighbors, and find paths of a specific length.
 * 
 * Public Methods:
 *   - Graph(): Constructor to initialize an empty graph.
 *   - add(Node n): Adds a vertex to the graph.
 *   - addEdge(int u, int v, int weight): Adds a directed weighted edge from u to v.
 *   - getNeighboursFor(int v): Returns the adjacency list of neighbors for vertex v.
 *   - numOfVertices(): Returns the total number of vertices.
 *   - numOfEdges(): Returns the total number of edges.
 *   - getWeight(int u, int v): Returns the weight of edge from u to v (or -1 if not found).
 *   - somePath(int u, int length): Finds and returns a path of specified length starting from vertex u.
 */
public class Graph {
	private AdjacencyLists adjLists;
	private Map<String, Integer> edgeWeights;
	private int edgeCount;

	public Graph() {
		this.adjLists = new AdjacencyLists();
		this.edgeWeights = new HashMap<>();
		this.edgeCount = 0;
	}

	public void add(Node n) {
		adjLists.addVertex(n.getId());
	}

	public void addEdge(int u, int v, int weight) {
		// Ensure both vertices exist
		if (!adjLists.vertexExists(u)) {
			adjLists.addVertex(u);
		}
		if (!adjLists.vertexExists(v)) {
			adjLists.addVertex(v);
		}

		// Add edge if it doesn't already exist
		AdjacencyList listU = adjLists.getList(u);
		if (listU != null && !listU.contains(v)) {
			listU.add(v);
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

	public AdjacencyList somePath(int u, int length) {
		AdjacencyList resultPath = new AdjacencyList();

		// Edge case: length must be positive
		if (length <= 0) {
			return resultPath;
		}

		// Edge case: starting vertex must exist
		if (!adjLists.vertexExists(u)) {
			return resultPath;
		}

		// Start traversal using depth-first search
		dfsTraverse(u, length, resultPath, new boolean[numOfVertices() + getMaxVertexId()]);

		return resultPath;
	}

	/**
	 * Helper method: Performs depth-first traversal to find a path of specified length.
	 * Uses a visited array to avoid infinite loops and backtracking.
	 * 
	 * @param current Current vertex being explored
	 * @param remainingLength Remaining steps to traverse
	 * @param resultPath Accumulates vertices found along the path
	 * @param visited Array tracking visited vertices to prevent cycles
	 */
	private void dfsTraverse(int current, int remainingLength, AdjacencyList resultPath, boolean[] visited) {
		// Add current vertex to path
		resultPath.add(current);

		// Base case: reached desired path length
		if (remainingLength == 1) {
			return;
		}

		// Mark as visited to avoid revisiting in this path
		visited[current] = true;

		// Get neighbors of current vertex
		AdjacencyList neighbors = adjLists.getList(current);
		if (neighbors == null) {
			visited[current] = false;
			return;
		}

		// Try to extend path through each unvisited neighbor
		Iterator<Integer> neighborIter = neighbors.getNeighbors();
		while (neighborIter.hasNext() && remainingLength > 1) {
			int neighbor = neighborIter.next();
			if (!visited[neighbor]) {
				dfsTraverse(neighbor, remainingLength - 1, resultPath, visited);
				break; // Take first available path to keep it simple
			}
		}

		visited[current] = false; // Backtrack
	}

	/**
	 * Helper method: Finds the maximum vertex ID to size the visited array appropriately.
	 * 
	 * @return Maximum vertex ID in the graph
	 */
	private int getMaxVertexId() {
		int maxId = 0;
		for (String key : edgeWeights.keySet()) {
			String[] parts = key.split("-");
			maxId = Math.max(maxId, Math.max(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
		}
		return maxId;
	}
}

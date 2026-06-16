package fares;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages all adjacency lists for the entire graph.
 * Maps each vertex ID to its list of neighbors.
 * Example: {1 → [2,3], 2 → [3], 3 → []}
 */
public class AdjacencyLists {
	private Map<Integer, AdjacencyList> lists;

	public AdjacencyLists() {
		lists = new HashMap<>();
	}

	// Get the neighbor list for a specific vertex
	public AdjacencyList getList(int vertexId) {
		return lists.get(vertexId);
	}

	// Add a new vertex with empty neighbor list
	public void addVertex(int vertexId) {
		if (!lists.containsKey(vertexId)) {
			lists.put(vertexId, new AdjacencyList());
		}
	}

	// Remove a vertex and its neighbor list
	public void removeVertex(int vertexId) {
		lists.remove(vertexId);
	}

	// Check if a vertex exists
	public boolean vertexExists(int vertexId) {
		return lists.containsKey(vertexId);
	}

	// Count total vertices
	public int numVertices() {
		return lists.size();
	}
}

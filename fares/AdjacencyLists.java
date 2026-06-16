package fares;

import java.util.HashMap;
import java.util.Map;

/**
 * Authors: Kamel Fares
 * Date: 2026-06-15
 * Purpose: Manages a collection of AdjacencyList objects, one for each vertex in the graph.
 * 
 * Public Methods:
 *   - getList(int vertexId): Returns the AdjacencyList for a specific vertex.
 *   - addVertex(int vertexId): Creates an empty AdjacencyList for a new vertex.
 *   - removeVertex(int vertexId): Removes a vertex's adjacency list.
 *   - vertexExists(int vertexId): Checks if a vertex exists in the collection.
 *   - numVertices(): Returns the total number of vertices.
 */
public class AdjacencyLists {
	private Map<Integer, AdjacencyList> lists;

	public AdjacencyLists() {
		lists = new HashMap<>();
	}

	public AdjacencyList getList(int vertexId) {
		return lists.get(vertexId);
	}

	public void addVertex(int vertexId) {
		if (!lists.containsKey(vertexId)) {
			lists.put(vertexId, new AdjacencyList());
		}
	}

	public void removeVertex(int vertexId) {
		lists.remove(vertexId);
	}

	public boolean vertexExists(int vertexId) {
		return lists.containsKey(vertexId);
	}

	public int numVertices() {
		return lists.size();
	}
}

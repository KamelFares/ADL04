package fares;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages adjacency lists for all vertices in the graph.
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

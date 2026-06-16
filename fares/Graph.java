package fares;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Represents a weighted directed graph using adjacency lists.
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

	public void addVertex(int vertexId) {
		adjLists.addVertex(vertexId);
	}

	public void addEdge(int u, int v, int weight) {
		if (!adjLists.vertexExists(u)) {
			adjLists.addVertex(u);
		}
		if (!adjLists.vertexExists(v)) {
			adjLists.addVertex(v);
		}

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
		
		if (length <= 0 || !adjLists.vertexExists(u)) {
			return resultPath;
		}

		Set<Integer> visited = new HashSet<>();
		dfsTraverse(u, length, resultPath, visited);
		return resultPath;
	}

	private void dfsTraverse(int current, int remainingLength, AdjacencyList resultPath, Set<Integer> visited) {
		resultPath.add(current);
		
		if (remainingLength == 1) {
			return;
		}

		visited.add(current);

		AdjacencyList neighbors = adjLists.getList(current);
		if (neighbors == null) {
			visited.remove(current);
			return;
		}

		Iterator<Integer> neighborIter = neighbors.getNeighbors();
		while (neighborIter.hasNext()) {
			int neighbor = neighborIter.next();
			if (!visited.contains(neighbor)) {
				dfsTraverse(neighbor, remainingLength - 1, resultPath, visited);
				break;
			}
		}
		
		visited.remove(current);
	}
}

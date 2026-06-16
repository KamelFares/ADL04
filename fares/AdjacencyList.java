package fares;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * List of neighbors for one vertex.
 */
public class AdjacencyList {
	private LinkedList<Integer> neighbors;

	public AdjacencyList() {
		neighbors = new LinkedList<>();
	}

	public void add(int neighbor) {
		if (!neighbors.contains(neighbor)) {
			neighbors.add(neighbor);
		}
	}

	public boolean contains(int neighbor) {
		return neighbors.contains(neighbor);
	}

	public void remove(int neighbor) {
		neighbors.remove(Integer.valueOf(neighbor));
	}

	public Iterator<Integer> getNeighbors() {
		return neighbors.iterator();
	}

	public int size() {
		return neighbors.size();
	}
}

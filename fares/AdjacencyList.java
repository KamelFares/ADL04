package fares;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Stores all neighbors of a single vertex.
 * Example: If vertex 2 has edges to vertices 3 and 5,
 * this list contains [3, 5].
 */
public class AdjacencyList {
	private LinkedList<Integer> neighbors;

	public AdjacencyList() {
		neighbors = new LinkedList<>();
	}

	// Add a neighbor (no duplicates allowed)
	public void add(int neighbor) {
		if (!neighbors.contains(neighbor)) {
			neighbors.add(neighbor);
		}
	}

	// Check if a neighbor exists
	public boolean contains(int neighbor) {
		return neighbors.contains(neighbor);
	}

	// Remove a neighbor
	public void remove(int neighbor) {
		neighbors.remove(Integer.valueOf(neighbor));
	}

	// Get iterator to loop through all neighbors
	public Iterator<Integer> getNeighbors() {
		return neighbors.iterator();
	}

	// Count how many neighbors
	public int size() {
		return neighbors.size();
	}
}

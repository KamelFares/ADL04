package fares;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Authors: Kamel Fares
 * Date: 2026-06-15
 * Purpose: represents all of neighboring vertices for a 1 vertex in the graph 
 *   - add(int neighbor): Adds a neighbor vertex ID to the list.
 *   - contains(int neighbor): Checks
 *   - remove(int neighbor): Removes a neighbor vertex ID from the list.
 *   - getNeighbors(): Returns an iterator over all neighbors.
 *      we need to know the size of the neighbor list to loop through it, so we also have size() method
 * 
 *  *   - add() checks contains() first to prevent duplicates. This is O(n) per add.
 *     ALTERNATIVE: Use HashSet instead of LinkedList for O(1) duplicate checking.
 *     TRADE-OFF: LinkedList maintains insertion order; HashSet does not.
 * 
 *   - contains() method is somewhat redundant since we already have it in LinkedList.
 *     ALTERNATIVE: Could remove this method and let users call getNeighbors() and iterate.
 *     BENEFIT: Slightly cleaner code. DOWNSIDE: Less convenient for callers.
 * 
 *   - remove() uses Integer.valueOf() for type safety.
 */
public class AdjacencyList {
	private LinkedList<Integer> neighbors;

	// COMMENT: Constructor - initializes empty list
	public AdjacencyList() {
		neighbors = new LinkedList<>();
	}

	//  adds a neighbor only if NOT already present
	// ALTERNATIVE WAY TO WRITE THIS (with return value):
	//   public boolean add(int neighbor) {
	//       if (!neighbors.contains(neighbor)) {
	//           neighbors.add(neighbor);
	//           return true;  // Added successfully
	//       }
	//       return false;  // Already existed
	//   }
	public void add(int neighbor) {
		if (!neighbors.contains(neighbor)) {
			neighbors.add(neighbor);
		}
	}

	// COMMENT: Check if neighbor exists
	// QUESTION: Is this method necessary? Yes - it's useful for external code.
	// ALTERNATIVE: Remove this and make users call getNeighbors() and loop through.
	public boolean contains(int neighbor) {
		return neighbors.contains(neighbor);
	}

	// COMMENT: Removes a neighbor
	// NOTE: Integer.valueOf() converts primitive int to Integer object
	// ALTERNATIVE WAY (using lambda - more modern Java):
	//   public void remove(int neighbor) {
	//       neighbors.removeIf(n -> n == neighbor);
	//   }
	public void remove(int neighbor) {
		neighbors.remove(Integer.valueOf(neighbor));
	}

	// COMMENT: Returns iterator to safely loop through neighbors
	// NOTE: Iterator is safer than exposing the LinkedList directly
	// ALTERNATIVE (expose LinkedList directly - NOT RECOMMENDED):
	//   public LinkedList<Integer> getNeighbors() {
	//       return neighbors;  // Dangerous! External code could corrupt it
	//   }
	public Iterator<Integer> getNeighbors() {
		return neighbors.iterator();
	}

	// COMMENT: Returns count of neighbors
	// ALTERNATIVE WAY (just one line, but less readable):
	//   public int size() { return neighbors.size(); }
	public int size() {
		return neighbors.size();
	}
}

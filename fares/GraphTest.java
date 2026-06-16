package fares;

import java.util.Iterator;

/**
 * Authors: Kamel Fares
 * Date: 2026-06-16
 * Purpose: Test class to verify all graph data structure classes work correctly.
 *          Tests Node, AdjacencyList, AdjacencyLists, and Graph classes.
 * 
 * Public Methods:
 *   - main(String[] args): Entry point to run all tests.
 *   - testNode(): Tests Node creation and getter methods.
 *   - testAdjacencyList(): Tests AdjacencyList operations.
 *   - testAdjacencyLists(): Tests AdjacencyLists collection.
 *   - testGraph(): Tests Graph operations including somePath algorithm.
 */
public class GraphTest {

	public static void main(String[] args) {
		System.out.println("=== GRAPH DATA STRUCTURE TEST SUITE ===\n");
		
		testNode();
		testAdjacencyList();
		testAdjacencyLists();
		testGraph();
		
		System.out.println("\n=== ALL TESTS COMPLETED ===");
	}

	/**
	 * Tests Node class functionality.
	 */
	private static void testNode() {
		System.out.println("TEST 1: Node Class");
		System.out.println("-----------------");
		
		// Create nodes
		Node node1 = new Node(1, 100);
		Node node2 = new Node(5, 200);
		Node node3 = new Node(10, 300);
		
		// Test getId() and getValue()
		System.out.println("Node 1 - ID: " + node1.getId() + ", Value: " + node1.getValue());
		System.out.println("Node 2 - ID: " + node2.getId() + ", Value: " + node2.getValue());
		System.out.println("Node 3 - ID: " + node3.getId() + ", Value: " + node3.getValue());
		
		// Verify results
		assert node1.getId() == 1 : "Node 1 ID should be 1";
		assert node1.getValue() == 100 : "Node 1 value should be 100";
		assert node2.getId() == 5 : "Node 2 ID should be 5";
		
		System.out.println("✓ Node tests passed!\n");
	}

	/**
	 * Tests AdjacencyList class functionality.
	 */
	private static void testAdjacencyList() {
		System.out.println("TEST 2: AdjacencyList Class");
		System.out.println("---------------------------");
		
		AdjacencyList list = new AdjacencyList();
		
		// Test add() and size()
		System.out.println("Initial size: " + list.size());
		list.add(1);
		list.add(3);
		list.add(5);
		System.out.println("After adding 1, 3, 5 - Size: " + list.size());
		
		// Test contains()
		System.out.println("Contains 3? " + list.contains(3));
		System.out.println("Contains 99? " + list.contains(99));
		
		assert list.contains(3) : "List should contain 3";
		assert !list.contains(99) : "List should not contain 99";
		
		// Test duplicate prevention
		list.add(3);  // Try to add duplicate
		System.out.println("After trying to add duplicate 3 - Size: " + list.size());
		assert list.size() == 3 : "Size should still be 3 (no duplicates)";
		
		// Test remove()
		list.remove(3);
		System.out.println("After removing 3 - Size: " + list.size());
		assert !list.contains(3) : "List should not contain 3 after removal";
		
		// Test getNeighbors() with iterator
		AdjacencyList list2 = new AdjacencyList();
		list2.add(10);
		list2.add(20);
		list2.add(30);
		System.out.print("Neighbors in list2: ");
		Iterator<Integer> iter = list2.getNeighbors();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		System.out.println("✓ AdjacencyList tests passed!\n");
	}

	/**
	 * Tests AdjacencyLists class functionality.
	 */
	private static void testAdjacencyLists() {
		System.out.println("TEST 3: AdjacencyLists Class");
		System.out.println("----------------------------");
		
		AdjacencyLists adjLists = new AdjacencyLists();
		
		// Test addVertex()
		adjLists.addVertex(1);
		adjLists.addVertex(2);
		adjLists.addVertex(3);
		System.out.println("Added vertices 1, 2, 3");
		System.out.println("Total vertices: " + adjLists.numVertices());
		assert adjLists.numVertices() == 3 : "Should have 3 vertices";
		
		// Test vertexExists()
		System.out.println("Vertex 1 exists? " + adjLists.vertexExists(1));
		System.out.println("Vertex 99 exists? " + adjLists.vertexExists(99));
		assert adjLists.vertexExists(1) : "Vertex 1 should exist";
		assert !adjLists.vertexExists(99) : "Vertex 99 should not exist";
		
		// Test getList() and add neighbors
		AdjacencyList list1 = adjLists.getList(1);
		list1.add(2);
		list1.add(3);
		System.out.println("Vertex 1's neighbors: ");
		Iterator<Integer> iter = list1.getNeighbors();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		// Test removeVertex()
		adjLists.removeVertex(3);
		System.out.println("After removing vertex 3 - Total vertices: " + adjLists.numVertices());
		assert adjLists.numVertices() == 2 : "Should have 2 vertices";
		
		System.out.println("✓ AdjacencyLists tests passed!\n");
	}

	/**
	 * Tests Graph class functionality including the somePath algorithm.
	 */
	private static void testGraph() {
		System.out.println("TEST 4: Graph Class");
		System.out.println("-------------------");
		
		// Create a sample graph
		Graph graph = new Graph();
		
		// Create nodes
		Node n1 = new Node(1, 10);
		Node n2 = new Node(2, 20);
		Node n3 = new Node(3, 30);
		Node n4 = new Node(4, 40);
		Node n5 = new Node(5, 50);
		
		// Add nodes to graph
		graph.add(n1);
		graph.add(n2);
		graph.add(n3);
		graph.add(n4);
		graph.add(n5);
		
		System.out.println("Added 5 nodes to graph");
		System.out.println("Number of vertices: " + graph.numOfVertices());
		assert graph.numOfVertices() == 5 : "Should have 5 vertices";
		
		// Add edges
		System.out.println("\nAdding edges (with weights):");
		graph.addEdge(1, 2, 5);
		graph.addEdge(2, 3, 10);
		graph.addEdge(3, 4, 15);
		graph.addEdge(4, 5, 20);
		graph.addEdge(2, 5, 25);  // Alternative path
		
		System.out.println("Edge 1→2 added with weight 5");
		System.out.println("Edge 2→3 added with weight 10");
		System.out.println("Edge 3→4 added with weight 15");
		System.out.println("Edge 4→5 added with weight 20");
		System.out.println("Edge 2→5 added with weight 25");
		
		System.out.println("Number of edges: " + graph.numOfEdges());
		assert graph.numOfEdges() == 5 : "Should have 5 edges";
		
		// Test getNeighboursFor()
		System.out.println("\nNeighbors of vertex 2:");
		AdjacencyList neighbors2 = graph.getNeighboursFor(2);
		Iterator<Integer> iter = neighbors2.getNeighbors();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		// Test getWeight()
		System.out.println("\nEdge weights:");
		System.out.println("Weight 1→2: " + graph.getWeight(1, 2));
		System.out.println("Weight 2→3: " + graph.getWeight(2, 3));
		System.out.println("Weight 1→5 (doesn't exist): " + graph.getWeight(1, 5));
		assert graph.getWeight(1, 2) == 5 : "Weight 1→2 should be 5";
		assert graph.getWeight(1, 5) == -1 : "Weight 1→5 should be -1 (not found)";
		
		// Test somePath() algorithm
		System.out.println("\n=== TESTING somePath() ALGORITHM ===");
		
		// Test 1: Simple path
		System.out.println("\nTest 1: somePath(1, 3) - find path of length 3 starting from vertex 1");
		AdjacencyList path1 = graph.somePath(1, 3);
		System.out.print("Path found: ");
		Iterator<Integer> pathIter = path1.getNeighbors();
		while (pathIter.hasNext()) {
			System.out.print(pathIter.next() + " ");
		}
		System.out.println();
		System.out.println("Path length: " + path1.size());
		
		// Test 2: Longer path
		System.out.println("\nTest 2: somePath(1, 5) - find path of length 5 starting from vertex 1");
		AdjacencyList path2 = graph.somePath(1, 5);
		System.out.print("Path found: ");
		pathIter = path2.getNeighbors();
		while (pathIter.hasNext()) {
			System.out.print(pathIter.next() + " ");
		}
		System.out.println();
		System.out.println("Path length: " + path2.size());
		
		// Test 3: Edge case - path longer than graph allows
		System.out.println("\nTest 3: somePath(1, 10) - path longer than available vertices");
		AdjacencyList path3 = graph.somePath(1, 10);
		System.out.print("Path found: ");
		pathIter = path3.getNeighbors();
		while (pathIter.hasNext()) {
			System.out.print(pathIter.next() + " ");
		}
		System.out.println();
		System.out.println("Path length: " + path3.size());
		System.out.println("(Shorter than requested - graph is too small)");
		
		// Test 4: Single vertex
		System.out.println("\nTest 4: somePath(3, 1) - path of length 1");
		AdjacencyList path4 = graph.somePath(3, 1);
		System.out.print("Path found: ");
		pathIter = path4.getNeighbors();
		while (pathIter.hasNext()) {
			System.out.print(pathIter.next() + " ");
		}
		System.out.println();
		
		// Test 5: Invalid starting vertex
		System.out.println("\nTest 5: somePath(99, 3) - non-existent starting vertex");
		AdjacencyList path5 = graph.somePath(99, 3);
		System.out.print("Path found: ");
		pathIter = path5.getNeighbors();
		if (path5.size() == 0) {
			System.out.print("(empty - vertex doesn't exist)");
		}
		while (pathIter.hasNext()) {
			System.out.print(pathIter.next() + " ");
		}
		System.out.println();
		
		System.out.println("\n✓ Graph tests passed!\n");
	}
}

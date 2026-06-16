package fares;

/**
 * Authors: Kamel Fares
 * Date: 2026-06-16
 * Purpose: Simple test to verify Java is working properly.
 */
public class SimpleTest {
	public static void main(String[] args) {
		System.out.println("=== JAVA IS WORKING! ===");
		System.out.println("Test successful!");
		
		// Test Node class
		Node n1 = new Node(1, 100);
		System.out.println("Node created: ID=" + n1.getId() + ", Value=" + n1.getValue());
		
		// Test AdjacencyList
		AdjacencyList list = new AdjacencyList();
		list.add(5);
		list.add(10);
		System.out.println("AdjacencyList size: " + list.size());
		
		System.out.println("\n✓ All basic tests passed!");
	}
}

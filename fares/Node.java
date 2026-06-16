package fares;

/**
 * Represents a graph vertex with an ID and value.
 * The ID uniquely identifies the vertex.
 * The value stores additional data.
 */
public class Node {
	private int id;
	private int value;

	public Node(int id, int value) {
		this.id = id;
		this.value = value;
	}

	// Get the vertex ID
	public int getId() {
		return id;
	}

	// Get the vertex value
	public int getValue() {
		return value;
	}
}

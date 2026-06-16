package fares;

/**
 * A vertex with ID and value.
 */
public class Node {
	private int id;
	private int value;

	public Node(int id, int value) {
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public int getValue() {
		return value;
	}
}

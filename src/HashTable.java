
public class HashTable {
	private Node head;

	// field variables
	Node[] table;
	int tableSize;

	public void IsHeadAvailable(Node node) {
		if (head == null) {
			head = node;
			return;
		}
		System.out.println("Already has head node");
	}// end method

	public HashTable() {
		int defaultSize = 3;
		int tableSize = 0;

		table = new Node[defaultSize];
	}// end constructor

	public void Add() {
		System.out.print("Enter a number: ");

		int value = Main.CheckUserInput("Enter a number: ");
		Node node = new Node(value, HashSum(value, table.length));

		HashSum(value, table.length);
		HashFunction(node);

		// code here
		ViewHashTable();
	}// end method

	public void ViewHashTable() {
		System.out.println("testcode plz end my suffering :(   ");
		for (int index = 0; index < table.length; index++) {
			if (table[index] == null) {
				System.out.println("Key: " + index + " Value: N/A");
			} else {
				Node node = table[index];
				System.out.println("Key: " + index + " Value: " + node.getData());
			} // end method
		} // end method
	}// end method

	public int HashSum(int value, int tableLength) {
		int key = value % tableLength;
		return key;
	}// end method

	public void HashFunction(Node node) {
		table[LinearProbe(node)] = node;
		tableSize++;
	}// end method

	public int LinearProbe(Node node) {
		if (node.getKey() + 1 > table.length) {
			node.setKey(0);
		} else if (tableSize == table.length) {
			System.out.println("HashTable Already full");
			return node.getKey();
		} // end method

		if (table[node.getKey()] != null) {
			node.setKey(node.getKey() + 1);
			LinearProbe(node);
			return node.getKey();
		} // end if
		return node.getKey();
	}// end method
}// end method

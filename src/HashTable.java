public class HashTable {
	private Node head;

	// field variables
	Node[] table;
	int tableSize;
	int increment = 1;

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
		if (tableSize == table.length) {
			System.out.println("Table is full");
			ViewHashTable();
			return;
		}
		System.out.print("Enter a number: ");

		int value = Main.CheckUserInput("Enter a number: ");
		Node node = new Node(value, HashCode(value, table.length));

		HashFunction(node);

		// code here
		ViewHashTable();
	}// end method

	public int HashCode(int value, int tableLength) {
		int key = value % tableLength;
		return key;
	}// end method

	public void HashFunction(Node node) {
		System.out.println("Increment: " + increment);
		if (table[node.getKey()] != null) {
			HashFunction(LinearProbe(node));
			return;

		} else {
			tableSize++;
			table[node.getKey()] = node;
		} // end if else
	}// end method

	public Node LinearProbe(Node node) {
		int key = ((node.getData() + increment++) % table.length);

		if (node.getKey() >= table.length && tableSize != table.length) {
			node.setKey(0);
			return node;
		} // end if

		node.setKey(key);
		return node;
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

}// end method

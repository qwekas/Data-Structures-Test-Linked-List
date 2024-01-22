public class DoublyLinkedList {
	// Attributes to mark the first and last items on the list (for iteration purposes)
	private Node first;
	private Node last;
	
	// Constructor
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	// Getters and setters
	public Node getFirst() {
		return this.first;
	}
	
	public void setFirst(Node first) {
		this.first = first;
	}
	
	public Node getLast() {
		return this.last;
	}
	
	public void setLast(Node last) {
		this.last = last;
	}
	
	// Compares two given nodes and returns true if their data integer values are the same, false otherwise
	public boolean areSame(Node node1, Node node2) {
		if (node1.getData() == node2.getData())  {
			return true;
		} else {
			return false;
		}
	}
	
	// Adds new node with given integer data to the end of the linked list
	public void add(int data) {
		// Create new node with integer data
		Node newNode = new Node(data);
		if (this.first == null) {
			// Assuming if first is null the list is empty and set the newly created node as the first and last element
			this.setFirst(newNode);
			this.setLast(newNode);
		} else {
			// add the newly created node as next of the currently last one
			this.last.setNext(newNode);
			// set the formerly last node as the previous of the newly created node
			newNode.setPrev(this.getLast());
			// set the newly created node as the last node in the linked list
			this.setLast(newNode);
		}
	}
	
	// Removes the first occurrence of the node with given integer data from the linked list
	public void remove(int data) {
		Node currentNode = this.getFirst();
		Node newNode = new Node(data);
		// Iterate over nodes when currentNode is not null (meaning it's predecessor getNext method returned a value) 
		while (currentNode != null) {
			if (this.areSame(currentNode, newNode)) {
				// found a match
				// get the previous and next nodes of the current one
				Node prevNode = currentNode.getPrev();
				Node nextNode = currentNode.getNext();
				if (prevNode == null) {
					// if there was no previous node (meaning it was the first on the list),
					// mark the next node as the first one on the list
					// effectively erasing the current node from the list
					this.first = nextNode;
				} else {
					// if there was a previous node (meaning it was not the first on the list),
					// mark the next node as the next node of the previous one on the list
					// effectively erasing the current node from the list
					prevNode.setNext(nextNode);
				}
				if (nextNode == null) {
					// if there was no next node (meaning it was the last on the list),
					// mark the previous node as the last one on the list
					// effectively erasing the current node from the list
					this.last = prevNode;
				} else {
					// if there was a next node (meaning it was not the last on the list),
					// mark the previous node as the previous node of the next one on the list
					// effectively erasing the current node from the list
					nextNode.setPrev(prevNode);
				}
				// stop loop after first occurrence found
				// remove next line if you would like to remove all occurrences
				break;
			}
			currentNode = currentNode.getNext();
		}
	}
	
	// Prints out the list
	public void printList() {
		Node currentNode = this.getFirst();
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList DLList = new DoublyLinkedList();
		DLList.add(1);
		DLList.add(9);
		DLList.add(14);
		DLList.add(6);
		DLList.add(1);
		DLList.add(17);
		DLList.add(12);
		DLList.add(1);
		DLList.printList();
		DLList.remove(1);
		DLList.printList();
	}

}

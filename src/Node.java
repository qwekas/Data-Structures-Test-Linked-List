public class Node {
	private int data;
	private Node next;
	private Node prev;
	
	// Constructor with pointers to the next and previous nodes set to null
	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	// Getters and setters
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}	
	
	public Node getPrev() {
		return prev;
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}

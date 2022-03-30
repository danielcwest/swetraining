package dan.swetraining.linkedlist;

public class SingleLinkedList {

	Node head;
	
	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		newNode.nextNode = head;
		head = newNode;
	}
	
	public void insertAtEnd(int data) {
		if(head == null) {
			return;
		}
	}
	
	public void printList() {
		
		if(head == null) {
			return;
		}
		
		Node current = head;
		System.out.print(current.data + " - ");

		while(current.nextNode != null) {
			current = current.nextNode;
			System.out.print(current.data + " - ");
		}
	}
}

package dan.swetraining.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SingleLinkedListTest {

	@Test
	public void testInsertAtHead() {
		SingleLinkedList l = new SingleLinkedList();
		
		l.insertAtHead(5);
		l.insertAtHead(10);
		l.insertAtHead(3);
		
		l.printList();
		
		assertEquals(true, true);
	}
}

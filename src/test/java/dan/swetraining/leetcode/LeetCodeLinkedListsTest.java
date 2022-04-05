package dan.swetraining.leetcode;

import org.junit.jupiter.api.Test;

public class LeetCodeLinkedListsTest {
	LeetCodeLinkedLists ll = new LeetCodeLinkedLists();

	@Test
	public void testRotateLinkedList() {
		
		
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		//head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);
		
		ll.rotateRight(head, 4);
	}
	
	
	@Test
	public void testSplitIntoParts() {
		
		ListNode head = new ListNode(1);
		
		ListNode current = head;

		for(int i = 2; i < 11; i++) {
			current.next = new ListNode(i);
			current = current.next;
		}

		//ll.splitListAtIndexes(head, new int[] {3,5});
		//ll.splitIntoParts(head, 3);
		
		
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		
		ListNode[] result = ll.splitIntoParts(head2, 5);

	}
	
	@Test
	public void testDeleteNode() {

		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);
		
		ll.deleteNode(head.next);
		
		System.out.println();

	}
	
	@Test
	public void testDeleteNthFromEnd() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);
		
		//ListNode head = new ListNode(1);
		//head.next = new ListNode(2);
		
		ListNode result = ll.removeNthFromEnd(head, 3);
		
		System.out.println();
		
	}
	
	@Test
	public void testReverseLinkedList() {
		ListNode head = new ListNode(1);
		//head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);
		
		ListNode reversed = ll.reverseList(head);
		
		System.out.println();
	}
	
	@Test
	public void testMergeTwoLists() {
		
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(4);
		
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(4);
		
		ListNode merged = ll.mergeTwoLists2(null, null);
		
		System.out.println();
		
	}
}

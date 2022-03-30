package dan.swetraining.leetcode;

import org.junit.jupiter.api.Test;

public class LeetCodeLinkedListsTest {

	@Test
	public void testRotateLinkedList() {
		
		LeetCodeLinkedLists ll = new LeetCodeLinkedLists();
		
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		//head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);
		
		ll.rotateRight(head, 4);
	}
	
	
	@Test
	public void testSplitIntoParts() {
		LeetCodeLinkedLists ll = new LeetCodeLinkedLists();
		
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
}

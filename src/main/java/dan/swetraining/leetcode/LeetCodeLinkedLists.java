package dan.swetraining.leetcode;

public class LeetCodeLinkedLists {

	public ListNode rotateRight(ListNode head, int k) {
		
        if(head == null){
            return head;
        }
        
		int length = findListLength(head);
		
		k = k % length;
		
		for(int i = 0; i < k; i++) {
			head = rotateRightOnce(head);
		}
		return head;
	}
	
	public ListNode rotateRightOnce(ListNode head) {
		ListNode current = head;
		ListNode previous = null;
		while(current.next != null) {			
			previous = current;
			current = current.next;
		}
		
		previous.next = null;
		current.next = head;
		
		return current;
	}
	
	public ListNode[] splitIntoParts(ListNode head, int k) {
		
		ListNode[] results = new ListNode[k];
				
		int numNodes = findListLength(head);
		
		int numItemsPerPart = numNodes / k;
		
		int numPartsWithExtraItem = numNodes % k;
		
		ListNode current = head;
		
		for(int i = 0; i < k; i++) {
			ListNode[] parts = splitListAtIndex2(current, i < numPartsWithExtraItem ? numItemsPerPart + 1 : numItemsPerPart);
			results[i] = parts[0];
			current = parts[1];
		}
		
		return results;
	}
	
	public ListNode splitListAtIndex(ListNode head, int index) {
		
		ListNode current = head;
		ListNode previous = null;
		ListNode first = current;
		
		int i = 0;
		
		while(i < index) {
			previous = current;
			current = current.next;
			i++;
		}
		
		previous.next = null;
		
		return first;
	}
	
	public ListNode[] splitListAtIndex2(ListNode head, int index) {
		
		ListNode[] result = new ListNode[2];
		
		if(head == null) return result;
		
		ListNode current = head;
		ListNode previous = null;
		ListNode first = current;
		
		int i = 0;
		
		while(i < index) {
			previous = current;
			current = current.next;
			i++;
		}
		
		previous.next = null;
		
		result[0] = first;
		result[1] = current;
		return result;
	}
	
	public ListNode[] splitListAtIndexes(ListNode head, int[] indexes) {
		
		ListNode[] lists = new ListNode[indexes.length];
		
		ListNode original = head;
		
		for(int i = 0; i < indexes.length; i++) {
			
			ListNode current = original;
			ListNode previous = null;
			ListNode first = current;
			
			int j = 0;
			while(j < indexes[i]) {
				previous = current;
				current = current.next;
				j++;
			}
			
			previous.next = null;
			original = current;
			lists[i] = first;
		}	
		
		return lists;
	}
	
	public int findListLength(ListNode head) {
		int length = 1;
		
		if(head == null) return 0;
		
		ListNode current = head;
		while(current.next != null) {			
			current = current.next;
			length++;
		}
		return length;
	}
}

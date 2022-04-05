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
	
	public void deleteNode(ListNode node) {        
		node.val = node.next.val;
		node.next = node.next.next;
    }
	
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
		int i = 1;
		ListNode current = head;
		ListNode toDelete = head;
		ListNode previous = null;
		while(current.next != null) {	
			if(i >= n) {
				previous = toDelete;
				toDelete = toDelete.next;
			}
			current = current.next;
			i++;
		}
		
		if(toDelete == head) {
			head = head.next;
		}else {
			previous.next = previous.next.next;
		}
		
		
		return head;
    }
	
	public ListNode reverseList(ListNode head) {
        
		ListNode current = head;
		ListNode previous = null;
		
		while(current.next != null) {
			ListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		
		current.next = previous;
		
		return current;
    }
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
		ListNode current1 = list1;
		ListNode current2 = list2;
		ListNode current1Prev = null;
		
		while(current1.next != null) {			
			if(current1.val < current2.val) {
				current1Prev = current1;
				current1 = current1.next;
			}else {
				ListNode temp = current2.next;
				current2.next = current1;
				//current1 = current2;
				list1 = current2;
				current2 = temp;
				//merged = current1;
			}
		}
		
		while(current2.next != null) {
			if(current1.val < current2.val) {
				System.out.println();
			}else {
				System.out.println();
				ListNode temp = current2.next;
				current2.next = current1;
				//current1 = current2;
				current2 = temp;
				current1Prev.next = current1;
			}
		}
		 
		
		return current1;
    }
	
	public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        
		ListNode current1 = list1;		
		ListNode current2 = list2;
		ListNode merged = null;
		
		while(current1 != null && current2 != null) {
			if(current1.val < current2.val) { //Insert current2 in front
				merged = addNode(merged, current1.val);
				current1 = current1.next;
			}else {//
				merged = addNode(merged, current2.val);
				current2 = current2.next;
			}
		}
		
		while(current1 != null) {
			merged = addNode(merged, current1.val);
			current1 = current1.next;
		}
		
		while(current2 != null) {
			merged = addNode(merged, current2.val);
			current2 = current2.next;
		}
				
		return merged;
    }
	
	public ListNode addNode(ListNode head, int value) {
		
		if(head == null) {
			head = new ListNode(value);
		}else {
			head.next = addNode(head.next, value);
		}
		return head;
	}
}

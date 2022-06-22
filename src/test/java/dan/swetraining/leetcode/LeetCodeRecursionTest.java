package dan.swetraining.leetcode;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LeetCodeRecursionTest {

	LeetCodeRecursion lc = new LeetCodeRecursion();
	
	@Test
	public void testReverseString() {
		String str = "Hello World!";
		
		lc.printReverse(str);
		
		System.out.println();
	}
	
	@Test
	public void testSwapPairs() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		ListNode result = lc.swapPairs(head);
		
		System.out.println();
	}
	
	
	@Test
	public void testReverseLinkedList() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode reversed = lc.reverseList(head);
		
		System.out.println();
	}
	
	@Test
	public void testSearchBST() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		TreeNode found = lc.searchBST(root, 1);
		
		System.out.println();
	}
	
	@Test
	public void testPascalsTriangleValue() {
		
		int value = lc.pascalsTriangleValue(4, 2);
		
		System.out.println();
	}
	
	@Test
	public void testGetRow() {
		List<Integer> results = lc.getRow(3);
		
		System.out.println();
	}
	
	@Test
	public void testFib() {
		int result = lc.fibonacci(4);
		
		System.out.println();
	}
	
	@Test
	public void testClimbStairs() {
		int numSteps = lc.climbStairs(5);
		
		System.out.println();
	}
	
	@Test
	public void testMyPow() {
		double x = 2.000; 
		int n = -2;		
		
		double value = lc.myPow(x, n);
		
		System.out.println();
	}
}

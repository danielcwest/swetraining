package dan.swetraining.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCodeRecursion {

	public void printReverse(String str) {
		printSubstringReverse(0, str);
	}
	
	public void printSubstringReverse(int index, String str) {
		
		if(index >= str.length()) {
			return;
		}
			
		printSubstringReverse(index + 1, str);
		System.out.print(str.charAt(index));
		
	}
	
	public void reverseString(char[] s) {
        for(int i = 0; i < s.length / 2; i++) {
        	char first = s[i];
        	char last = s[s.length - 1 - i];
        	s[i] = last;
        	s[s.length - 1 - i] = first;
        }
    }
	
	
	/*
	 * 1 2 -> 2 1 swap( 3 4)
	 * 2 1 4 3
	 * null
	 */
	public ListNode swapPairs(ListNode head) {
		//ListNode current = head;
        if(head == null || head.next == null) {
        	return head;
        }else {
        	ListNode temp = head.next;
        	head.next = head.next.next;
        	temp.next = head;
        	head = temp;
        	head.next.next = swapPairs(head.next.next);
        }
        return head;
    }
	
	
	public ListNode reverseList(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}else {
			ListNode newHead = reverseList(head.next);
			
			head.next.next = head;
			head.next = null;
			
			return newHead;
		}
	}
	
	
	public TreeNode searchBST(TreeNode root, int val) {
		if(root == null) return root;
		
		if(root.val == val) {
			return root;
		}else if(val < root.val) {
			return searchBST(root.left, val);
		}else {
			return searchBST(root.right, val);
		}			
    }
	
	Map<String,Integer> cache = new HashMap<String,Integer>();

	public int pascalsTriangleValue(int i, int j) {		
		
		if(cache.containsKey(i + "" + j + "")) {
			return cache.get(i + "" + j + "");
		}
		if(j == 0 || i == j) {
			return 1;
		}else {
			int val =  pascalsTriangleValue(i - 1, j - 1) + pascalsTriangleValue(i - 1, j);	
			cache.put(i + "" + j + "", val);
			return val;
		}
	}
	
	public List<Integer> getRow(int rowIndex) {
        List<Integer> results = new ArrayList<Integer>();
		for(int j = 0; j <= rowIndex; j++) {
			int value = pascalsTriangleValue(rowIndex, j);
			results.add(value);
		}		
		return results;
    }
	
	Map<Integer,Integer> cacheInt = new HashMap<Integer,Integer>();
	
	public int fibonacci(int n) {
		if(cacheInt.containsKey(n)) {
			return cacheInt.get(n);
		}
		if(n < 2) {
			return n;
		}else {
			int val = fibonacci(n - 1) + fibonacci(n - 2);
			cacheInt.put(n, val);
			return val;
		}
	}
	
	public int climbStairs(int n) {
		if(cacheInt.containsKey(n)) {
			return cacheInt.get(n);
		}
        if(n < 3) {
        	return n;
        }else {
        	int numSteps = climbStairs(n - 1) + climbStairs(n - 2);
        	cacheInt.put(n, numSteps);
        	return numSteps;
        }
    }
	
	public double myPow(double x, int n) {
        if(n == 0) {
        	return 1;
        }
        
        if(n == Integer.MIN_VALUE){
    		x = x * x;
    		n = n/2;
    	}
        if( n % 2 == 0){
        	double val = myPow(x, Math.abs(n)/2);
        	return n < 0 ? 1 / (val * val) : val * val;
        }else {
        	double val = myPow(x, Math.abs(n)/2);
        	return n < 0 ? 1 / (val * val * x) : val * val * x;
        }
	}
}

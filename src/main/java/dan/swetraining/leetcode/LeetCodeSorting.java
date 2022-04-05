package dan.swetraining.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCodeSorting {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
        
		Queue<Integer> q = new PriorityQueue<Integer>(m + n);
		
		for(int i = 0; i < m; i++) {
			q.add(nums1[i]);
		}
		
		for(int j = 0; j < n; j++) {
			q.add(nums2[j]);
		}
		
		int i = 0;
		while(q.peek() != null) {
			nums1[i] = q.poll();
			i++;
		}
		
		System.out.println();
    }
	
	public void merge3(int[] nums1, int m, int[] nums2, int n) {
        	
		while(m > 0 && n > 0) {
			int num1 = nums1[m - 1];
			int num2 = nums2[n - 1];
			
			if(num1 > num2) {
				nums1[m + n - 1] = num1;
				m--;
			}else {
				nums1[m + n - 1] = num2;
				n--;
			}
		}		
		
		while(n > 0) {
			nums1[m + n - 1] = nums2[n - 1];
			n--;
		}
		
		while(m > 0) {
			nums1[m + n - 1] = nums1[m - 1];
			m--;
		}
		
		System.out.println();
    }
	
	public int firstBadVersion(int n) {      

		int low = 0; int high = n;
		
		while(high - low != 1) {
			int mid = low + (high - low) / 2;
			System.out.println();
			
			if(isBadVersion(mid)) {
				high = mid;
			}
			else {
				low = mid;
			}
		}

		return high;
    }
	
	public boolean isBadVersion(int n) {
        return n >= 2 ? true : false;
    }
}

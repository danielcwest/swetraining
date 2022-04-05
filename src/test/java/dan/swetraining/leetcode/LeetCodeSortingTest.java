package dan.swetraining.leetcode;

import org.junit.jupiter.api.Test;

public class LeetCodeSortingTest {

	LeetCodeSorting lc = new LeetCodeSorting();
	
	@Test
	public void testMerge() {
		int[] nums1 = new int[] {2,4,6,0,0,0};
		int[] nums2 = new int[] {1,2,3};
		
		lc.merge3(nums1, 3, nums2, 3);
		
		//nums1 = new int[] {0};
		//nums2 = new int[] {1};
		
		//lc.merge3(nums1, 0, nums2, 1);
	}
	
	@Test
	public void testFirstBadVersion() {
		int first = lc.firstBadVersion(2);
		
		System.out.println();
	}
}

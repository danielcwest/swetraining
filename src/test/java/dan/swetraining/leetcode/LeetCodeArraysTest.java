package dan.swetraining.leetcode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodeArraysTest {

	LeetCodeArrays lc = new LeetCodeArrays();
	
	@Test
	public void testRemoveDuplicates() {
		
		int k = lc.removeDuplicates(new int[] {1,1,2});
		assertEquals(2, k);
		
		k = lc.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4});
		assertEquals(5, k);
	}
	
	
	@Test
	public void testRotateArray() {
		
		 lc.rotate3(new int[] {1,2,3,4,5,6,7}, 3);
	}
	
	@Test 
	public void testContainsDuplicate() {
		
		//lc.containsDuplicate(new int[] {1,2,3,1});
		assertEquals(true, lc.containsDuplicate(new int[] {1,2,3,1}));
		assertEquals(false, lc.containsDuplicate(new int[] {1,2,3,4}));
		assertEquals(true, lc.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
	}
	
	
	@Test
	public void testIntersection() {
		

		int[] result = lc.intersect(new int[] {1,2,2,1}, new int[] {2,2});
		
		int[] result2 = lc.intersect(new int[] {4,9,5}, new int[] {9,4,9,8,4});
	}
	
	@Test
	public void testminimalHeaviestSet() {
		List<Integer> list = Arrays.asList(5,3, 1);
		
		List<Integer> result = lc.minimalHeaviestSetA(list);
		
		System.out.println();
	}
	
	@Test
	public void testCountGroups() {
		List<String> list = Arrays.asList("1100","1110", "0110", "0001");
		
		int result = lc.countGroups(list);
		
		System.out.println();
	}
	
	@Test
	public void testPlusOne() {
		int[] digits = new int[] {9,8,7,6,5,4,3,2,1,0};
		
		int[] result = lc.plusOne(digits);
		
		System.out.println();
	}
	
	@Test
	public void testMoveZeros() {
		int[] nums = new int[] {0,1,0,3,12};
		
		lc.moveZeroes(nums);
		
		System.out.println();
	}
	
	@Test
	public void testTwoSum() {
		int[] nums = new int[] {3,3};
		
		int[] result = lc.twoSum(nums, 6);
		
		System.out.println();
	}
}

package dan.swetraining.leetcode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}

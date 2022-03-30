package dan.swetraining.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LeetCodeTreesTest {
	
	@Test
	public void testMaxDepth() {
		
		LeetCodeTrees t = new LeetCodeTrees();
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		int max = t.maxDepth(root);
		
		System.out.println();	

	}
	
	
	@Test
	public void testTraversals() {
		LeetCodeTrees t = new LeetCodeTrees();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		
		
		//root.right = new TreeNode(3);
		
		t.inOrderTraversal(root);
		System.out.println();	
		t.preOrderTraversal(root);
		System.out.println();	
		t.postOrderTraversal(root);
		System.out.println();	

		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(2);
		//root2.left.left = new TreeNode(3);
		root2.left.right = new TreeNode(3);
		//root2.right.left = new TreeNode(4);
		root2.right.right = new TreeNode(3);
		
		t.inOrderTraversal(root2);
		System.out.println();	
	}
	
	@Test
	public void testToArray() {
		LeetCodeTrees t = new LeetCodeTrees();
		
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(2);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(4);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(3);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(2);
		root.right.left = new TreeNode(2);
		
		List<Integer> arr = new ArrayList<Integer>();
		
		t.inOrderTraversalToArray(root, arr);
		
		boolean result = t.isListSymetric(arr);
		System.out.println();	

	}
	
	
	@Test
	public void testIsBst() {
		LeetCodeTrees t = new LeetCodeTrees();
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);

		//TreeNode root = new TreeNode(5);
		//root.left = new TreeNode(4);
		//root.right = new TreeNode(6);
		//root.right.left = new TreeNode(3);
		//root.right.right = new TreeNode(7);
		
		//TreeNode root = new TreeNode(0);
		//root.left = new TreeNode(-1);
		
		boolean result = t.isValidBST2(root);
		System.out.println();	
	}
	
	
	@Test
	public void testIsMax() {
		LeetCodeTrees t = new LeetCodeTrees();

		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		
		//root.left = new TreeNode(4);
		//root.right = new TreeNode(6);
		//root.right.left = new TreeNode(3);
		//root.right.right = new TreeNode(7);
		
		//int max = t.validBst(root, true);
		//int min = t.validBst(root, false);
		
		int m = t.findMax(root);
		
		System.out.println();	

	}
	
	
	
	@Test
	public void testIsSymmetric() {
		LeetCodeTrees t = new LeetCodeTrees();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(2);
//		root.left.left = new TreeNode(2);
//		root.right.left = new TreeNode(2);
		
		boolean result = t.isSymmetric(root);
		
		System.out.println();	
		
	}
	
	
	@Test
	public void testLevelOrder() {
		LeetCodeTrees t = new LeetCodeTrees();
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		//root.left.left = new TreeNode(3);
		//root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> results = t.levelOrder(null);
		
		System.out.println();
	}
	
	@Test
	public void testSortedArrayToBST() {
		LeetCodeTrees t = new LeetCodeTrees();

		//int[] nums = new int[] {-10,-3,0,5,9};
		
		//int[] nums = new int[] {0,1,2,3,4,5};
		int[] nums = new int[] {-1,0,1,2};
//
		TreeNode root = t.sortedArrayToBST(nums);
		
		
		System.out.println();
	}
}

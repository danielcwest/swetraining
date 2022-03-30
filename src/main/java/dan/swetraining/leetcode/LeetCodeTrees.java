package dan.swetraining.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.support.RootBeanDefinition;

public class LeetCodeTrees {
	
	//TreeNode root;
	
	public void addNode(int value) {		
		
		//root = addNodeHelper(root, value);
				
		System.out.println();

	}
	
	public TreeNode addNodeHelper(TreeNode current, int value) {
		if(current == null) {
			current = new TreeNode(value);
		}else if(value < current.val) {
			current.left = addNodeHelper(current.left, value);
		}else {
			current.right = addNodeHelper(current.right, value);
		}
		return current;
	}
	
	public void inOrderTraversal(TreeNode current) {
		
		if(current == null) return;
		
		inOrderTraversal(current.left);		
		System.out.println(current.val);	
		inOrderTraversal(current.right);
	}
	
	public void preOrderTraversal(TreeNode current) {
		if(current == null) return;
		
		System.out.println(current.val);
		preOrderTraversal(current.left);			
		preOrderTraversal(current.right);
	}
	
	public void postOrderTraversal(TreeNode current) {
		if(current == null) return;		

		postOrderTraversal(current.left);				
		postOrderTraversal(current.right);		
		System.out.println(current.val);

	}
	
    public void breadthFirstTraversal(TreeNode root) {
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	queue.add(root);
    	
    	while(queue.peek() != null) {
    		  		
    		TreeNode current = queue.poll();
    		System.out.print(current.val + " ");
    		
    		if(current.left != null) { 
    			queue.add(current.left);
    		}
    		
    		if(current.right != null) {
    			queue.add(current.right);
    		}
    	} 	  	
    }
	

	
//	public void preOrderTraversal(TreeNode current) {
//		if(current == null) return;
//		
//		System.out.println(current.val);
//		preOrderTraversal(current.left);			
//		preOrderTraversal(current.right);
//	}
//	
//	public void postOrderTraversal(TreeNode current) {
//		if(current == null) return;		
//
//		postOrderTraversal(current.left);				
//		postOrderTraversal(current.right);		
//		System.out.println(current.val);
//
//	}
	
	
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
			
		if(root.left == null && root.right == null) {
			return 1;
		}else {
			int depthLeft = maxDepth(root.left);
			int depthRight = maxDepth(root.right);
			
			return 1 + Math.max(depthLeft, depthRight);
		}	
	}
	
	public boolean isValidBST2(TreeNode root) {
		
		return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isValidBSTHelper(TreeNode root, int min, int max) {
		
		if(root == null) return true;
		
		if(root.val > max || root.val < min) return false;
		
		boolean isLeftBst = isValidBSTHelper(root.left, min, root.val -1);
		boolean isRightBst = isValidBSTHelper(root.right, root.val + 1, max);
		
		return (isLeftBst && isRightBst);	
	}
	
	public boolean isValidBST(TreeNode root) {
		//boolean result = false;
		
		if(root == null) return true;
		
		if(root.left != null && findMax(root.left) >= root.val) return false;
		
		if(root.right != null && findMin(root.right) <= root.val) return false;

		boolean isLeftBst = isValidBST(root.left);
		boolean isRightBst = isValidBST(root.right);
		
		if(!isLeftBst || !isRightBst) return false;
		
		return true;
	}	
	
	public int findMax(TreeNode current) {
		if(current == null) return Integer.MIN_VALUE;
		
		if(current.left == null && current.right == null) {
			return current.val;
		}else{
			
			int leftMax = findMax(current.left);
			int rightMax = findMax(current.right);
							
			return Math.max(current.val, Math.max(leftMax, rightMax));
		}
	}
	
	public int findMin(TreeNode current) {
		if(current == null) return Integer.MAX_VALUE;
		
		if(current.left == null && current.right == null) {
			return current.val;
		}else{
			
			int leftMax = findMin(current.left);
			int rightMax = findMin(current.right);
							
			return Math.min(current.val, Math.min(leftMax, rightMax));
		}
	}

    public boolean isSymmetric2(TreeNode root) {
		List<Integer> arr = new ArrayList<Integer>();
		inOrderTraversalToArray(root, arr);
		return isListSymetric(arr);
    }
		
	public void inOrderTraversalToArray(TreeNode current, List<Integer> items) {
		
		if(current == null) return;
		
		inOrderTraversalToArray(current.left, items);		
		items.add(current.val);
		inOrderTraversalToArray(current.right, items);
	}
	
	public boolean isListSymetric(List<Integer> list) {
		for(int i = 0; i < list.size() / 2; i++) {
			if(list.get(i) != list.get(list.size() - 1 - i)) return false;
		}
		return true;
	}
	
	public boolean isSymmetric(TreeNode root) {
		
		if(root == null) return true;				
		return isMirror(root.left, root.right);
	}
	
	public boolean isMirror(TreeNode left, TreeNode right) {
		if(left == null && right == null) return true;
		
		if(left == null || right == null) return false;//If one is null but not both its not symetric
		
		if(left.val != right.val) return false;
		
		boolean isLeftMirror = isMirror(left.left, right.right);
		boolean isRightMirror = isMirror(left.right, right.left);
		
		return (isLeftMirror && isRightMirror);
	}
	
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	
    	if(root == null) return results;
    	
    	List<List<TreeNode>> nodes = new ArrayList<List<TreeNode>>();
    	
    	int maxDepth = maxDepth(root);
    	
    	List<TreeNode> initial = new ArrayList<TreeNode>();
    	List<Integer> initialVal = new ArrayList<Integer>();
    	initial.add(root);
    	initialVal.add(root.val);
    	
    	nodes.add(initial);
    	results.add(initialVal);
    	
    	for(int i = 0; i < maxDepth; i++) {
    		List<TreeNode> level = new ArrayList<TreeNode>();
    		List<Integer> levelVal = new ArrayList<Integer>();
    		
    		List<TreeNode> current = nodes.get(i);
    		
    		for(TreeNode node : current) {
    			if(node.left != null) { 
    				level.add(node.left);
    				levelVal.add(node.left.val);
    			}
    			if(node.right != null) {
    				level.add(node.right);
    				levelVal.add(node.right.val);
    			}
    		}
    		
    		if(level.size() > 0) {
    			nodes.add(level);
    			results.add(levelVal);
    		}
    	}
    	  	
    	return results;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
    	
    	if(nums.length == 0) {
    		return null;
    	}else if(nums.length == 1) {
    		return new TreeNode(nums[0]);
    	}else {
        	int middleNum = nums[nums.length / 2];
            int[] firstHalf = Arrays.copyOfRange(nums, 0, nums.length/2);
            int[] secondHalf = Arrays.copyOfRange(nums, nums.length/2 + 1, nums.length);
            
            TreeNode root = new TreeNode(middleNum);
            root.left = sortedArrayToBST(firstHalf);
            root.right = sortedArrayToBST(secondHalf);
            return root;
    	}	
    }

}

package dan.swetraining.binarytree;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

	BinaryTree tree = new BinaryTree();
	
	@Test
	public void testBuildTree() {
		
		tree.addNode(10);
		tree.addNode(12);
		tree.addNode(6);
		tree.addNode(1);
		
		System.out.println("");
		
		Node subTree = tree.findNode(6);
		
		System.out.println("");

	}
	
}

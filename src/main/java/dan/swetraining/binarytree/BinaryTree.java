package dan.swetraining.binarytree;

public class BinaryTree {

	public Node root;
	
	public void addNode(int value) {
		
		root = this.addNodeHelper(root, value);
	}
	
	private Node addNodeHelper(Node current, int value) {
			
		if(current == null) {
			current = new Node(value);
		}
		else if(value < current.value) {
			current.left = addNodeHelper(current.left, value);
		}else {
			current.right = addNodeHelper(current.right, value);
		}
		return current;
	}
	
	
	//Because we split the searchable values in half each iteration
	// The search time is O(log2N)
	public Node findNode(int value) {
		return findNodeHelper(root, value);
	}
	
	public Node findNodeHelper(Node current, int value) {
				
		if(current == null || current.value == value) {
			return current;
		}else if(value < current.value) {
			return findNodeHelper(current.left, value);
		}else{
			return findNodeHelper(current.right, value);
		}
	}
}

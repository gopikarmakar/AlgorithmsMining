package Trees.BinaryTrees;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Calculate the height of a given binary tree
 * 
 * @author gopi_karmakar
 */
public class CalculateHeight {
	
	public static void main(String[] args) {		
		
		Node<Integer> root = BinaryTree.buildDefault();
		BinaryTree.printBFS(root);
		System.out.println("Height Of The Binary Tree = " + compute(root));		
	}
	
	/**
	 * An efficient solution
	 * Accepted in Leetcode with 0ms 100% runtime.  
	 * 
	 * An O(h) time complexity PostOrder traversal   
	 * algorithm to calculate the height of a Binary Tree.	 
	 */
	private static int compute(Node<Integer> node) {
		
		if(node == null)
			return 0;
		
		int lh = compute(node.left);
		
		int rh = compute(node.right);
		
		return Math.max(lh, rh) + 1;
	}
}

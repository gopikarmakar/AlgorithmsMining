package Trees.BinaryTrees;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/**
 * Iteratively traversing InOrder traversal for a Binary Tree.
 *  
 * @author gopi_karmakar
 */
public class InorderTraversalIterative {
	

	public static void main(String[] args) {
		
		Node<Integer> tree = BinaryTree.buildDefault();	
		
		BinaryTree.printInOrderRecursive(tree);
		System.out.println(traverseInOrder(tree));
	}
	
	/**
	 * The time complexity is O(n), since the total time spent on each node is O(1).
	 * The space complexity is O(h), where h is the height of the tree.
	 */
	private static List<Integer> traverseInOrder(Node<Integer> tree) {		
		
		Node<Integer> current = tree;
		List<Integer> list = new ArrayList<>();
		Stack<Node<Integer>> stack = new Stack<>();		
		
		while(!stack.isEmpty() || current != null) {
			
			if(current != null) {
				stack.push(current);
				current = current.left; //Going Left
			}
			else {
				current = stack.pop();
				list.add(current.key);
				current = current.right; //Going Right
			}
		}
		return list;
	}
}

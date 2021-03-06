package Trees.BinaryTrees;

import java.util.Iterator;

import LinkedLists.DoublyLinkedLists.DoublyLinkedList;

/**
 * Convert a Binary Tree into Doubly Linked List
 * 
 * @author gopi_karmakar
 */
public class ConvertInToDoublyLinkedList {
	
	private static DoublyLinkedList<Node<?>> dll = new DoublyLinkedList<>();
	
	public static void main(String[] args) {
		
		Node<Integer> tree = BinaryTree.buildDefault();
		convert(tree);
		print(DoublyLinkedList.FORWARD);
	}	
	
	/**
	 * O(n) time complexity recursive InOrder solution.
	 * 
	 * @param node
	 */
	public static void convert(Node<?> node) {
		
		if(node == null) return;			
		
		dll.add(node);
		convert(node.left);		
		convert(node.right);		
	}
	
	public static void print(int order) {				
		
		Iterator<Node<?>> itr = dll.getIterator(order);
		
		while(itr.hasNext()) {
			
			Node<?> node = itr.next();
			System.out.println("Key = " + node.key);
		}
	}
}
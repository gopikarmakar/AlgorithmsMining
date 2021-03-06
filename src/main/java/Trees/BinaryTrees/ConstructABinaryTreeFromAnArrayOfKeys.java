package Trees.BinaryTrees;

/**
 * Building a Binary Tree in level order fashion 
 * from an array or list of keys.
 * 							A
 * 				B							C	
 * 		D				E			F				G
 * 	H		I		J		K	L		M		N		O
 * 
 * Variant: Build a minimum height BT from an array/list of values.
 * 
 * @author gopi_karmakar
 */
public class ConstructABinaryTreeFromAnArrayOfKeys {

	public static void main(String[] args) {
		
		String[] keys = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};
		
		Node<String> tree = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		
		BinaryTree.printBFS(tree, true);
	} 
}

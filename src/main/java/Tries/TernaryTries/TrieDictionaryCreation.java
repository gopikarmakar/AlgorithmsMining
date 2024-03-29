package Tries.TernaryTries;

import java.util.ArrayList;

/**
 * Ternary Trie Dictionary Insertion.
 * 
 * Takes O(log n) time for search and insertion.
 * 
 * @author gopi_karmakar
 */
public class TrieDictionaryCreation<K, V> {
	
	private Node<Character, String> root = null;
	
	public Node<Character, String> create(String[] keys) {
		for(String key : keys)
			root = createDefault(root, key, 0);
		
		return root;
	}
	
	public Node<Character, String> createDefault(String key) {
		root = createDefault(root, key, 0);
		return root;
	}
	
	Node<Character, V> trie = null;
	public Node<Character, V> createDefault(String key, V keyToSave) {
		
		trie = createDefault(trie, key, keyToSave, 0);		
		return trie;
	}
	
	
	public Node<Character, String> createPrefixTrie(String key, boolean saveEveryValue) {
		root = createPrefixTrie(root, "", key, 0, saveEveryValue);
		return root;
	}
	
	public Node<Character, String> createSuffixTrie(String key, boolean saveEveryValue) {		
		root = createSuffixTrie(root, "", key, key.length()-1, saveEveryValue);
		return root;
	}
	
	/**
	 * Default Trie Creation
	 */
	private Node<Character, String> createDefault(Node<Character, String> node, String key, int d) {
		
		Character ch = key.charAt(d);
		
		if(node == null) {			
			node = new Node<Character, String>(ch, null);
		}

		if(ch < node.k) 				node.left = createDefault(node.left, key, d);

		else if(ch > node.k)			node.right = createDefault(node.right, key, d);

		else if(d < key.length()-1)		node.mid = createDefault(node.mid, key, d+1);

		else 							node.v = key;

		return node;
	}

	/**
	 * Creation of Trie O(log n) time complexity
	 */
	private Node<Character, V> createDefault(Node<Character, V> node, String key, V keyToSave, int d) {

		Character ch = key.charAt(d);

		if(node == null) {
			node = new Node<Character, V>(ch,  null);
			node.values = new ArrayList<V>();
		}

		if(ch < node.k)			node.left = createDefault(node.left, key, keyToSave, d);

		else if(ch > node.k)	node.right = createDefault(node.right, key, keyToSave, d);

		else if(d < key.length() - 1) {

			node.mid = createDefault(node.mid, key, keyToSave, d + 1);
		}
		else {

			node.values.add(keyToSave);
		}

		return node;
	}

	/**
	 * Prefix Trie Creation
	 */
	private Node<Character, String> createPrefixTrie(Node<Character, String> node,
			String prefix, String key, int d, boolean saveEveryValue) {

		Character ch = key.charAt(d);

		if(node == null) {
			node = new Node<Character, String>(ch, (saveEveryValue) ? prefix+ch : null);
		}

		if(ch < node.k) 				node.left = createPrefixTrie(node.left, node.v, key, d, saveEveryValue);

		else if(ch > node.k)			node.right = createPrefixTrie(node.right, node.v, key, d, saveEveryValue);

		else if(d < key.length()-1)	{

			node.frequency += 1;
			if(node.v != null) 	node.length = node.v.length();
			node.mid = createPrefixTrie(node.mid, node.v, key, d+1, saveEveryValue);
		}

		else {
			node.v = key;
			node.frequency += 1;
			node.length = node.v.length();
		}

		return node;
	}



	/**
	 * Suffix Trie Creation
	 */
	private Node<Character, String> createSuffixTrie(Node<Character, String> node,
			String sufix, String key, int d, boolean saveEveryValue) {

		Character ch = key.charAt(d);

		if(node == null) {
			node = new Node<Character, String>(ch, (saveEveryValue) ? ch+sufix : null);
		}
		
		if(ch < node.k)					node.left = createSuffixTrie(node.left, sufix, key, d, saveEveryValue); 
			
		else if(ch > node.k)			node.right = createSuffixTrie(node.right, sufix, key, d, saveEveryValue);			
			
		else if(d > 0) {
			
			node.frequency += 1;
			if(node.v != null)	node.length = node.v.length();
			node.mid = createSuffixTrie(node.mid, node.v, key, d-1, saveEveryValue);
		}
			
		else {			
			node.v = key;
			node.frequency += 1;
			node.length = node.v.length();
		}
			
		return node;
	}
}
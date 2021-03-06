package Tries.ArrayTrie;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayTrieDictionary<E> {

	private int alphabets = 26;
	private Node root;
	
	public static void main(String[] args) {
		
		ArrayTrieDictionary<String> trie = new ArrayTrieDictionary<>();		
	}
	
	public class Node {
		
		E value;
		public String prefix;
		
		@SuppressWarnings("unchecked")
		Node[] next = new ArrayTrieDictionary.Node[alphabets];
	}
	
	public void put(String key, E value) {
		
		root = put(root, key.toLowerCase(), value, 0);
	}
	
	private Node put(Node x, String key, E value, int d) {
		
		if(x == null) x = new Node();
		if(d == key.length()) { x.value = value; x.prefix = key; return x; }
		char c = key.charAt(d);
				
		x.next[(c - 'a')] = put(x.next[(c - 'a')], key, value, d+1);
		return x;
	}

	public E get(String key) {
		
		Node x = get(root, key.toLowerCase(), 0);
		if(x == null) return null;
		else return x.value;
	}
	
	private Node get(Node x, String key, int d) {
		
		if(x == null) return null;	
		if(d == key.length()) return x;
		char c = key.charAt(d);
		return get(x.next[(c - 'a')], key, d+1);
	}
		
	private int get(Node x) {
		
		if(x == null) return 0;
		
		int count = 0;
		for(int i = 0; i < alphabets; i++) {
			if(x.next[i] != null) {
				count += get(x.next[i]);
			}
		}
		// Return count of nodes of subtrie and plus 1 because of root node's own count. 
		return 1+count;
	}
	
	public Iterable<Node> keysWithPrefix(String prefix) {
		
		Queue<Node> queue = new LinkedList<Node>();
		collect(get(root, prefix.toLowerCase(), 0), prefix.toLowerCase(), queue);
		return queue;
	}
	
	private void collect(Node x, String prefix, Queue<Node> queue) {
		
		if(x == null) return;
		if(x.value != null) queue.add(x);
		for(char c = 0; c < alphabets; c++) {
			collect(x.next[c], prefix + c, queue);
		}
	}
	
	public String longestCommonPrefixOf(String str) {
		
		int length = longestCommonPrefixOf(root, str.toLowerCase(), 0, 0);
		System.out.println("Length = " + length);
		return str.substring(0, length);
	}
	
	private int longestCommonPrefixOf(Node x, String str, int d, int length) {
		
		if(x == null) return length;
		if(x.value != null) length = d;
		if(d == str.length()) return length;
		
		char c = str.charAt(d);
		return longestCommonPrefixOf(x.next[(c - 'a')], str, d+1, length);
	}
	
	/**
	 * Suffix Trie Creation.
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int allDistinctSubstrings(String key) {
		
		int index = 0, cnt = 0;
		int length = key.length();
		while(index < length) {
			String suffix = key.substring(index++);
			put(suffix, (E)suffix);
		}
		index = 0;
		while(index < length) {
			cnt = get(root);
			index += 1;
		}
		return cnt;
	}
}
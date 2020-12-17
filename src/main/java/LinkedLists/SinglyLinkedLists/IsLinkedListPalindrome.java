package LinkedLists.SinglyLinkedLists;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * @author gopi_karmakar
 */
public class IsLinkedListPalindrome {

	public static void main(String[] args) {
		
		String[] keys1 = {"O", "O"};
		String[] keys = {"M", "A", "D", "A", "M"};
		String[] keys2 = {"M", "A", "L", "A", "Y", "A", "L", "A", "M"};
		String[] keys3 = {"H", "A", "N", "N", "A", "H"};
		String[] keys4 = {"G", "O", "O", "G", "L", "E"};
		
		SinglyLinkedList<String> sll = SinglyLinkedList.create(keys4);
		System.out.println(isPalindrome(sll.head));	
	}
	
	/**
	 * 1st: Slowest but easiest solution accepted in Leetcode with 9% runtime
	 * Insight:
	 * 1: Add all the nodes to an ArrayDeque.
	 * 2: Poll first and last elements of Deque in tandem.
	 * 3: Check first and last elements for palindromicity in tandem. 
	 * 
	 * @see IsLinkedListPalindromeII for more efficient solution.	 
	 */	 
	private static boolean isPalindrome(Node<String> head) {
				
		Deque<String> dq = new ArrayDeque<>();		
		Node<String> current = head;		
		
		while(current != null) {		
			dq.addLast(current.k);
			current = current.next;
		}		
		
		int start = 0, end = dq.size()-1;
		
		while(start++ < end--) {			
			if(!dq.pollFirst().equals(dq.pollLast())) return false;						
		}		
		return true;
	}	
}
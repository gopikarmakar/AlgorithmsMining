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
		
		String[] keys = {"M", "A", "D", "A", "M"};
		String[] keys2 = {"H", "A", "N", "N", "A", "H"};
		String[] keys3 = {"G", "O", "O", "G", "L", "E"};
		
		Integer[] nums = {-129, -129};
		
		SinglyLinkedList<String> sll = SinglyLinkedList.create(keys2);		
		
		System.out.println(isPalindrome(sll.head));		
	}
	
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

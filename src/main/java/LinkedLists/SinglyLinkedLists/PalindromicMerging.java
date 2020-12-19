package LinkedLists.SinglyLinkedLists;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Facebook and Amazon Interview Question
 * 
 * Given:  A->B->C->D->E
 * Return: A->E->B->D->C
 * 
 * @author gopi_karmakar
 */
public class PalindromicMerging {

	public static void main(String[] args) {
	
		String[] keys = {"A"};
		String[] keys1 = {"A", "B"};
		String[] keys2 = {"A", "B", "C", "D", "E"};
		String[] keys3 = {"A", "B", "C", "D", "E", "F"};
		
		SinglyLinkedList<String> sll = SinglyLinkedList.create(keys3);
		
		SinglyLinkedList.print(merge(sll.head));
	}
	
	/**
	 * 1st Solution: Simple Solution
	 * Insight:
	 * 1: Add all the nodes to an ArrayDeque.
	 * 2: Poll first and last elements of Deque in tandem.
	 * 3: Create a new list and merge first and last elements in tandem. 
	 * 
	 * @see PalindromicMergingII for more efficient solution.
	 */
	private static Node<String> merge(Node<String> head) {
		
		if(head == null || head.next == null) return head;
		
		Node<String> dummyHead = new Node<>();
		Node<String> newHead = head;
		
		Deque<String> dq = new ArrayDeque<>();
		
		while(newHead != null) {
			
			dq.addLast(newHead.k);
			newHead = newHead.next;
		}		
		
		Node<String> current = dummyHead;
		
		while(!dq.isEmpty()) {
			
			if(!dq.isEmpty()) {
				current.next = new Node<>(dq.pollFirst());
				current = current.next;
			}
			
			if(!dq.isEmpty()) {
				current.next = new Node<>(dq.pollLast());
				current = current.next;
			}			
		}
		
		return dummyHead.next;
	}
}

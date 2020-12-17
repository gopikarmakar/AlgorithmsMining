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
	
		String[] keys = {"A", "B", "C", "D", "E"};
		
		SinglyLinkedList<String> sll = SinglyLinkedList.create(keys);
		
		SinglyLinkedList.print(merge(sll.head));
	}
	
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

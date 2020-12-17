package LinkedLists.SinglyLinkedLists;

/**
 * Reverse a linked list
 * 
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * @author gopi_karmakar
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> sll = SinglyLinkedList.createDefault();			
		
		SinglyLinkedList.print(reverse(sll.head));
	}
	
	/**
	 * Accepted in Leetcode with 0ms 100% runtime
	 * 
	 * O(n) time complexity with O(1) extra space.
	 * 
	 * 1->2->3->4->5->NULL
	 */
	private static Node<Integer> reverse(Node<Integer> head) {
		
		if(head == null || head.next == null)
            return head;
		
		Node<Integer> current = head, prev = null, next = null;
		
		while(current!= null) {
			
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}
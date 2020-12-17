package LinkedLists.SinglyLinkedLists;

/**
 * Facebook and Amazon Interview Question
 * 
 * Given:  A->B->C->D->E
 * Return: A->E->B->D->C
 * 
 * @author gopi_karmakar
 */
public class PalindromeMergingII {

	public static void main(String[] args) {
		
		String[] keys = {"A"};
		String[] keys1 = {"A", "B"};
		String[] keys2 = {"A", "B", "C", "D", "E"};
		String[] keys3 = {"A", "B", "C", "D", "E", "F"};
		
		SinglyLinkedList<String> sll = SinglyLinkedList.create(keys3);
		
		//SinglyLinkedList.print(merge(sll.head));
		
		SinglyLinkedList.print(merge(sll.head));
	}
	
	/**
	 * 2nd Solution:
	 * Insight: 
	 * Similar like Palindrome Linked List
	 * 1: Take two pointers slow and fast.
	 * 2: Move fast pointer twice than slow pointer.
	 * 3: When fast pointer reaches end of list slow pointer will be at the center node of list. 
	 * 4: Reverse the second half of the list and finally
	 * 5: Loop through from the firstHalh and secondHalf of the list in tandem. 
	 * 6: Create a new list and keep adding firstHalf & secondHalf nodes in tandem and return the new list. 
	 */
	private static Node<String> merge(Node<String> head) {
		
		if(head == null || head.next == null) return head;
		
		Node<String> dummyHead = new Node<>();
		Node<String> current = dummyHead;
		
		Node<String> firstHalf = head;
		Node<String> secondHalf = reverseSecondHalf(findCenterPoint(head));				
		
		while(firstHalf != null && secondHalf != null) {			
			
			/**
			 * In case of even list firstHalf & secondHalf won't be the same.
			 */
			if(firstHalf != secondHalf) {
				
				current.next = new Node<String>(firstHalf.k);	
				current = current.next;
				firstHalf = firstHalf.next;
													
				current.next = new Node<String>(secondHalf.k);
				current = current.next;
				secondHalf = secondHalf.next;
			}
			/**
			 * In case of odd list adding only one one of them
			 * since the center point will be the same for 
			 * firstHalf and secondHalf.
			 */
			else {   
				current.next = new Node<String>(firstHalf.k);	
				current = current.next;
				firstHalf = firstHalf.next;
			}
		}
		
		return dummyHead.next;
	}
	
	private static Node<String> findCenterPoint(Node<String> head) {
		
		Node<String> slow, fast;		
		slow = fast = head;
		while(fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private static Node<String> reverseSecondHalf(Node<String> head) { 
		
		if(head == null || head.next == null) return head;
		
		Node<String> current = head;
		Node<String> prev = null;
		
		while(current != null) {						
			Node<String> next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}
package LinkedLists.SinglyLinkedLists;

/**
 * https://leetcode.com/problems/rotate-list/
 * 
 * @author gopi_karmakar
 */
public class CyclicallyRightShiftList {

	public static void main(String[] args) {
	
		Integer[] keys = {0, 1, 2};
		Integer[] keys2 = {1, 2, 3, 4, 5};
		SinglyLinkedList<Integer> sll = SinglyLinkedList.create(keys);
		
		SinglyLinkedList.print(cyclicShift(sll.head, 4));
	}		
	
	/**
	 * Accepted in Leetcode with 0ms 100 % runtime memory usage < 90.49%
	 * Insight:
	 * 1: Linked lists can be cut and the sublists reassembled very efficiently.
	 * 2: Reach to the tail and count the total no. of nodes n.
	 * 3: Take the mod of k with total length. It's because if(k > n).
	 * 4: Attach head to tail.next and make a circular linked list.
	 * 5: Now cache the tail into newTail and iterate till (n-k) from the newTail.
	 * 6: The new head will be newTail.next after (n-k) iterations.
	 * 7: And finally break the circular loop with the tail.next = null
	 */
	private static Node<Integer> cyclicShift(Node<Integer> head, int k) {
		
		if(head == null || head.next == null) return head;
		
		Node<Integer> tail = head;
		
		int n = 1;
		while(tail.next != null) {
			
			n += 1;
			tail = tail.next;			
		}
		
		// if(k > n) then we just need to iterate till mod of k,
		// Since we'll make a circular linked list. 		
		k = k % n;  
		
		if(k == 0)
			return head;
		
		//0->1->2->0->1->2
		tail.next = head;
		Node<Integer> newTail = tail;
		
		int stepsToNewHead = n - k;		
		
		while(stepsToNewHead-- > 0) {
			newTail = newTail.next;
		}
		
		Node<Integer> newHead = newTail.next;
		newTail.next = null;
		
		return newHead;
	}
}
package LinkedLists.SinglyLinkedLists;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * @author gopi_karmakar
 */
public class IsLinkedListPalindromeII {

	public static void main(String[] args) {
		
		String[] keys1 = {"O", "O"};
		String[] keys = {"M", "A", "D", "A", "M"};
		String[] keys2 = {"M", "A", "L", "A", "Y", "A", "L", "A", "M"};
		String[] keys3 = {"H", "A", "N", "N", "A", "H"};
		String[] keys4 = {"G", "O", "O", "G", "L", "E"};
		
		SinglyLinkedList<String> sll = SinglyLinkedList.create(keys4);
	
		System.out.println(isPalindrome2(sll.head));
	}

	/**
	 * 2nd: Solution Accepted in Leetcode with 95% runtime.
	 * Insights:
	 * 1: Take two pointers slow and fast.
	 * 2: Move fast pointer twice than slow pointer.
	 * 3: When fast pointer reaches end of list slow pointer will be at the center node of list. 
	 * 4: Reverse the second half of the list and finally
	 * 5: Loop through from the firstHalh and secondHalf of the list in tandem.
	 * 6: Return false if any two node isn't equals to each other else true. 
	 */
	private static boolean isPalindrome2(Node<String> head) {
		
		if(head == null || head.next == null) return true;
		
		Node<String> firstHalf = head;
		Node<String> secondHalf = reverse(findCenterPoint(head));		
		
		while(firstHalf != null && secondHalf != null) {			
			
			if(!firstHalf.equals(secondHalf)) return false;			
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}		
		return true;
	}
	
	private static Node<String> findCenterPoint(Node<String> head) {
		
		Node<String> slow, fast;		
		slow = fast = head;
		
		while(fast != null) {
			slow = slow.next;
			fast = (fast.next == null) ? null : fast.next.next;
		}
		return slow;
	}
	
	private static Node<String> reverse(Node<String> head) { 
		
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

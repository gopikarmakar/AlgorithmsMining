package LinkedLists.SinglyLinkedLists;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * @author gopi_karmakar
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		
		Integer[] keys = {1, 1, 2};
		Integer[] keys2 = {1, 1, 2, 2, 3};
		
		SinglyLinkedList<Integer> sll = SinglyLinkedList.create(keys2);
		SinglyLinkedList.print(removeDuplicates(sll.head));
	}
	
	/**
	 * Submitted to LeetCode with 0ms 100% runtime and 98.99% less memory usage.
	 * Insight:
	 * 1: Two pointer solution prev and current.
	 * 2: Initialize prev = head and current = prev.next
	 * 3: if (prev == current) then move current to current.next
	 * 4: Delete the old current stored in temp.
	 * 5: Keep repeating the 3 & 4 until (prev == current). 
	 * 6: The list will be left with non duplicate elements and return head.
	 */
	private static Node<Integer> removeDuplicates(Node<Integer> head) {
		
		if(head == null || head.next == null) return head;
        
        Node<Integer> prev = head;
        Node<Integer> current = prev.next;        
     
        while(current != null) {
            
            if(prev.k == current.k) {
            	
                Node<Integer> temp = current;
                current = current.next;
                prev.next = current;
                temp = null;
            }
            else {
                prev = prev.next;
                current = current.next;
            }
        }
        return head;
	}
}

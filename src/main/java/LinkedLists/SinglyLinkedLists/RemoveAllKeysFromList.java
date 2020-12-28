package LinkedLists.SinglyLinkedLists;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * Remove all elements from a linked list of integers that have a given key K.
 * 
 * @author gopi_karmakar
 */
public class RemoveAllKeysFromList {

	public static void main(String[] args) {
		
		Integer[] keys = {1, 2, 6, 3, 4, 5, 6};
		SinglyLinkedList<Integer> sll = SinglyLinkedList.create(keys);
		
		int k = 6;		
		SinglyLinkedList.print(remove(sll.head, k));
	}
	
	/**
	 * Submitted to LeetCode with 1ms 75.43% runtime and 89.82% less memory usage.	 
	 * 1: Two pointer solution prev and current.
	 * 2: Initialize prev = new Node() and current = head
	 * 3: Keep track if the given k is the head then keep moving the head to next and delete matching k
	 * 4: Move the current to next and link the prev.next to current.
	 * 5: Else move the prev and current to next if not k. 
	 * 6: The list will be left with the elements except k and finally return the new head.
	 */
	private static Node<Integer> remove(Node<Integer> head, int k) {
		
		if(head == null) return head;
				
		Node<Integer> prev = new Node<>();		
        Node<Integer> current = head;
        prev.next = current;       
        
        while(current != null) {
            
            if(current.k == k) {
            	            	
            	if(current == head)
            		head = head.next;
            	
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
	
	private static Node<Integer> remove2(Node<Integer> head, int k) {
				
		if(head == null) return head;
		
		/**
		 * Move the head to the 1st node which does not have the given value *k*
		 * From that head we will start our main code and return this *head* at the end.
		 */		
		while(head != null && head.k == k) head = head.next;
		
		if(head == null)return null;
		
		Node<Integer> current = head;		
		
		while(current != null && current.next != null){
			
			//Moving the only next pointer, keeping the current head fixed until the next *non k* node found
			if(current.next.k == k) current.next = current.next.next;  
	        
			//Move the current head only when a non-k node found
	        else current = current.next;
	    }
		return head;
	}
}

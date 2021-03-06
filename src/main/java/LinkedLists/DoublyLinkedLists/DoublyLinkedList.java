package LinkedLists.DoublyLinkedLists;

import java.util.Iterator;

/**
 * Concrete Doubly LinkedList Implementation.
 *
 * @author gopi_karmakar
 */
public class DoublyLinkedList<K> {	
	
	public static final int FORWARD = 1;
	public static final int REVERSE = 2;
	
	private int size = 0;
	public Node<K> head = null;
	public Node<K> tail = null;
	
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> dll = createDefault();		
		dll.printAllNodes(FORWARD);
	}
	
	public static DoublyLinkedList<Integer> createDefault() {
		
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		
		for(Integer i = 1; i <= 10; i++)
			dll.add(i);
		
		return dll;
	}
	
	public void add(K k) {		
		Node<K> node = new Node<>(k);
		addNode(node);
	}
	
	private void addNode(Node<K> node) {
		size += 1;
		Node<K> temp = tail;
		tail = node;
		if(head == null) {
			head = tail;
			return;
		}
		temp.next = tail;
		tail.prev = temp;
	}
	
	public int size() {		
		return size;
	}
	
	public void printAllNodes(int order) {
		
		Iterator<K> itr = getIterator(order); 
		while(itr.hasNext()) {
			
			K k = itr.next();
			System.out.println(k);
		}
	}
	
	public Iterator<K> getIterator(int order) {		
		
		Iterator<K> itr = new Iterator<K>() {
			
			Node<K> current = (order == REVERSE) ? tail : head;
			
			@Override
			public boolean hasNext() {				
				return (current != null);
			}
			
			@Override
			public K next() {
				K item = current.key;
				current = (order == REVERSE) ? current.prev : current.next;
				return item;
			}
			
			@Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
		};
		return itr;
	}
}
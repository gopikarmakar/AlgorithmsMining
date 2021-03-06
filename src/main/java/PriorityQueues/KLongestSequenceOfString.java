package PriorityQueues;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Write a program which takes a sequence of strings 
 * presented in "streaming" fashion: you cannot back up 
 * to read an earlier value. The program must compute the
 * k longest strings in the sequence. All that is required is 
 * the k longest strings—it is not required to order these strings
 * 
 * @author gopi_karmakar
 */
public class KLongestSequenceOfString {

	public static void main(String[] args) {
		
		String[] sequence = {"Republic-Of-India", "England", "Australia", "New-Zealand",
			"South-Africa", "West-Indies", "Pakistan", "Bangladesh", "Sri-Lanka", "Afghanistan"};
				
		System.out.println(topK(3, sequence));
	}
			
	/**
	 * 	An O(n log n) time complexity solution
	 */
	public static List<String> topK(int k, String...seq) {			
		
		/*PriorityQueue<String> pq = new PriorityQueue<>(k, new Comparator<String>() {
			
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});*/

		// Using primitive data type lambda comparator. 
		//PriorityQueue<String> pq = new PriorityQueue<>(k, Comparator.comparing(String::length));
		PriorityQueue<String> pq = new PriorityQueue<>(k, (a, b)-> a.length() - b.length());
		for(String s : seq) {
			
			pq.add(s);				
			if(pq.size() > k) 
				pq.remove();
		}
		return new ArrayList<String>(pq);
	}
}

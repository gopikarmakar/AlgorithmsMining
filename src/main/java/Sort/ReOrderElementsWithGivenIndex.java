package Sort;

import java.util.HashMap;
import java.util.Map;

/**
 * Facebook Interview Question
 * 
 * keys = 	 {"D", "A", "E", "B", "C"};
 * indexes = {3, 0, 4, 1, 2}
 * sort(keys, indexes) = return {A, B, C, D, E}
 * 
 * @author gopi_karmakar
 */
public class ReOrderElementsWithGivenIndex {

	public static void main(String[] args) {
		
		String[] keys = {"D", "A", "E", "B", "C"};		
		int[] indexes = {3, 0, 4, 1, 2};
		
		Sort(keys, indexes);
		for(String k : keys) {
			System.out.println(k);
		}
	}
	
	/**
	 * An efficient O(n) time & space complexity solution.
	 * Insight:
	 * Store the Mapping of the indexes and keys,
	 * Cyclic sort the indexes in O(n) time.
	 * Fetch the keys as per theirs index mapping & place them accordingly. 
	 */
	private static void Sort(String[] keys, int[] indexes) {
		
		Map<Integer, String> map = new HashMap<>();		
		for(int i = 0; i < indexes.length; i++) { 
			map.put(indexes[i], keys[i]);
		}		
		for(int i = 0; i < indexes.length;) {			
			if(indexes[i] < indexes.length && indexes[indexes[i]] != indexes[i]) {				
				swap(indexes, i, indexes[i]);
			}
			else i++;
		}		
		for(int i = 0; i < indexes.length; i++) {
			keys[i] = map.get(indexes[i]);
		}
	}
	
	private static void swap(int[] indexes, int a, int b) {		
		int temp = indexes[a];
		indexes[a] = indexes[b];
		indexes[b] = temp;
	}
}
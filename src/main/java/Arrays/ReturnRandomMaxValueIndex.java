package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * A Google, Facebook, Amazon Interview Question
 * 
 * https://leetcode.com/problems/random-pick-index/
 * 
 * @author gopi_karmakar
 */
public class ReturnRandomMaxValueIndex {

	public static void main(String[] args) {
		
		int[] nums = {-2, 3, 2, 6, 5, 6, 4, 6};
		
		//randomMax(nums);
		
		System.out.println("Random Index Of Max Value = " + randomMax(nums));
		randomMax2(nums);
	}
	
	/**
	 * 1st Solution:
	 * Simple Java Solution 
	 * Accepted in Leetcode with 41% runtime.
	 */
	private static int randomMax(int[] nums) {
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			
			List<Integer> list = map.getOrDefault(nums[i], new ArrayList<Integer>());
			list.add(i);
			map.put(nums[i], list);
		}
		
		List<Integer> list = map.get(Collections.max(map.keySet()));
		
		return list.get(new Random().nextInt(list.size()));
	}
	
	/**
	 * 2nd Solution:
	 */
	private static void randomMax2(int[] nums) {		
		
		int maxCount = 0, maxVal = Integer.MIN_VALUE;				
		
		for(int i = 0; i < nums.length; i++) {
			
			if(nums[i] > maxVal) {
				maxVal = nums[i];
				maxCount = 1;
			}
			else if(maxVal == nums[i]) {
				maxCount++;
			}
		}				
		
		int random = (new Random().nextInt(maxCount) + 1);
				
		System.out.println(random);
		
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			
			if(nums[i] == maxVal) {
				
				count++;
				
				if(count == random) {
					System.out.println("Random Index Of Max Value = " + i);
					break;
				}
			}
		}
	}
}

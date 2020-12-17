package Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 * 
 * Move all the zeroes to end without changing 
 * the order of the array.
 * 
 * @author gopi_karmakar
 */
public class MoveZeroes {

	public static void main(String[] args) {
		
		int[] nums = {0, 1, 0, 3, 12};

		move(nums);
		
		for(int e : nums)
			System.out.println(e);
	}
	
	/**
	 * Accepted in Leetcode with 0ms 100% runtime	 
	 */
	private static void move(int[] nums) {
		
		int index = 0;
		for(int i = 0; i < nums.length && index < nums.length; i++) {
			
			if(nums[i] != 0) {
			
				swap(nums, index++, i);
			}			
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
	
		int x = nums[i];
		nums[i] = nums[j];
		nums[j] = x;
	}
}

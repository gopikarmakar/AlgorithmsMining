package Arrays;

/**
 * A Google & Facebook interview question
 * 
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * e.g: {1, 0} = {0, 1} or {0, 4, 0} = {0, 0, 0} or 
 * {1, 2, 0, 3, 4} = {0, 0, 24, 0, 0} or {1, 2, 3, 4} = {24, 12, 8, 6}
 * 
 * @author gopi_karmakar
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		
		int[] nums = {0, 0};
		int[] nums0 = {1, 1};
		int[] nums1 = {1, 0};
		int[] nums2 = {0, 4, 0};
		int[] nums3 = {9, 0, -2};	
		int[] nums4 = {2, 3, 0, 0};
		int[] nums5 = {1, 2, 3, 4};		
		int[] nums6 = {4, 3, 2, 1};
		int[] nums7 = {1, 2, 0, 3, 4};
		
		for(int n : product(nums7)) {
			System.out.print(n + " ");
		}
		System.out.println();		
		for(int n : product2(nums7)) {
			System.out.print(n + " ");
		}
	}
	
	/**
	 * 1st: Easy solution accepted in LeetCode with 1ms 100% runtime. 
	 * O(n) time complexity and O(1) space complexity
	 *    
	 * Insight:
	 * 1: Cache total product of all the elements except zeros and count the total zeros.
	 * 2: if the total no. of countZeros > 1 then the product of the rest elements will always be zero. 
	 * 3: So simply return the zero initialized empty array.
	 * 4: Else if countZero == 1 then except the zero element rest all will be zeros and 
	 * 	  the zero element will be the total product. 
	 * 5: Else Divide the total product by ith value and store in a result array. Return the result array. 	
	 */
	private static int[] product(int[] nums) {
		
		if(nums.length == 0 || nums.length == 1)
            return nums;
		
		int totalProduct = 1, countZeros = 0;	

		int[] result = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {		
			if(nums[i] != 0) {
				totalProduct  = totalProduct * nums[i];
			}
			else {
				countZeros++;
			}
			if(countZeros > 1)
				return result;
		}		
		for(int i = 0; i < nums.length; i++) {			
			if(countZeros == 1 && nums[i] == 0) {
				result[i] = totalProduct;				
			}
			else if(countZeros == 1 && nums[i] != 0) {
				result[i] = 0;							
			}
			else {
				result[i] = totalProduct/nums[i];;
			}
		}
		return result;
	}
	
	/**
	 * 2nd: Solution accepted in LeetCode with 1ms 100% runtime. 
	 * O(n) time complexity and O(1) space complexity
	 * 
	 * Insights:
	 * 1: Two pass solution with prefix and suffix multiplications.
	 * 2: 1st pass: store prefix products till n-2. Where n = nums.length
	 * 3: 2nd pass: Start from n-1 and product of nums[n-1...0] * prefixes[i] 
	 */
	private static int[] product2(int[] nums) {
		
		int[] result = new int[nums.length];
		
		/**
		 * First pass nums = {1, 2, 3, 4} 
		 * result = {1, 1, 2, 6}
		 */
		int prefix = 1;
		for(int i = 0; i < nums.length; i++) {
			
			result[i] = prefix;
			prefix = prefix * nums[i]; 
		}
		
		/**
		 * Second pass result[i] = result[i] * nums[i];
		 * result = {1 * 24, 1 * 12, 2 * 4, 6 * 1}
		 */
		int suffix = 1;
		for(int i = nums.length-1; i >= 0; i--) {
			
			result[i] = result[i] * suffix;			
			suffix = nums[i] * suffix;
		}
		
		return result;
	}
}

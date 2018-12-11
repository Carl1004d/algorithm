package 递归回溯;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1: Input: nums is [1, 1, 1, 1, 1], S is 3. Output: 5 Explanation:
 * -1+1+1+1+1 = 3 +1-1+1+1+1 = 3 +1+1-1+1+1 = 3 +1+1+1-1+1 = 3 +1+1+1+1-1 = 3
 * 
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3. Note:
 * The length of the given array is positive and will not exceed 20. The sum of
 * elements in the given array will not exceed 1000. Your output answer is
 * guaranteed to be fitted in a 32-bit integer.
 * 
 */
public class _494TargetSum {
//	public static void main(String[] args) {
//		_494TargetSum o = new _494TargetSum();
//		int i = o.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3);
//		System.out.println(i);
//	}
	public static void main(String[] args) {
		_494TargetSum o = new _494TargetSum();
		o.subsetSum(new int[]{1,2,4,6,8,2,4}, 8);
	}
	  public int subsetSum(int[] nums, int s) {
	        int[] dp = new int[s + 1]; 
	        dp[0] = 1;
	        for (int n : nums)
	            for (int i = s; i >= n; i--)
	                dp[i] += dp[i - n]; 
	        return dp[s];
	    } 

	public int findTargetSumWays(int[] nums, int S) {
		int res = 0;
		res = backtrack(nums, 1, S + nums[0]) + backtrack(nums, 1, S - nums[0]);
		return res;
	}

	private int backtrack(int[] nums, int start, int remain) {
		if (start == nums.length) {
			if (remain == 0)
				return 1;
			else
				return 0;
		}
		int res = 0;
		res = backtrack(nums, start+1, remain + nums[start]) + backtrack(nums, start+1, remain - nums[start]);
		return res;
	}
}

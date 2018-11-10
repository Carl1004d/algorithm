package dynamicProgrammingMedium;

/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing
 * subsequence is [2,3,7,101], therefore the length is 4. Note:
 * 
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length. Your algorithm should run in O(n2) complexity.
 */

// 有点难...这个思路是存放每个数对应的之前所有小于这个数中的最大的子序列长度加一
public class _300LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) { // {10,9,2,5,3,7,101,18}
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int maxans = 1;
		for (int i = 1; i < dp.length; i++) { // {10,9,2,5,3,7,101,18}
			int maxval = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					maxval = Math.max(maxval, dp[j]);
				}
			}
			dp[i] = maxval + 1;
			maxans = Math.max(maxans, dp[i]);
		}
		return maxans;
	}

	public static void main(String[] args) {
		_300LongestIncreasingSubsequence o = new _300LongestIncreasingSubsequence();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		o.lengthOfLIS(nums);
	}
}

package mediumArraysWrong;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example:
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the subarray [4,3]
 * has the minimal length under the problem constraint.
 *
 */
public class _209MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
		while (j < nums.length) {
			sum += nums[j++];
			while (sum >= s) {
				min = Math.min(j - i, min);
				sum -= nums[i++];

			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;

	}
}

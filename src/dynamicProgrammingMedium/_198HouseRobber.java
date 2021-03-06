package dynamicProgrammingMedium;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and then rob
 * house 3 (money = 3). Total amount you can rob = 1 + 3 = 4. Example 2:
 * 
 * Input: [2,7,9,3,1] Output: 12 Explanation: Rob house 1 (money = 2), rob house
 * 3 (money = 9) and rob house 5 (money = 1). Total amount you can rob = 2 + 9 +
 * 1 = 12.
 * 
 */
// 哈哈哈哈,自己做的动态规划方法
public class _198HouseRobber {
	public int rob(int[] nums) {
		int length = nums.length;
		if (length == 0)
			return 0;
		if (length == 1)
			return nums[0];
		int[] result = new int[length + 1];
		result[1] = nums[0];
		result[2] = Math.max(nums[0], nums[1]);
		for (int i = 3; i <= length; i++) {
			result[i] = Math.max(result[i - 2] + nums[i - 1], result[i - 1]);
		}
		return result[length];
	}

	// 贪心算法
	public int rob2(int[] nums) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				a = Math.max(a + nums[i], b);
			} else {
				b = Math.max(a, b + nums[i]);
			}
		}
		return Math.max(a, b);
	}
}

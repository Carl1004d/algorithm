package dynamicProgrammingMedium;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * Example 1:
 * 
 * Input: [2,3,2] Output: 3 Explanation: You cannot rob house 1 (money = 2) and
 * then rob house 3 (money = 2), because they are adjacent houses. Example 2:
 * 
 * Input: [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and then rob
 * house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 * 
 * @author 84135
 *
 */
public class _213HouseRobberII {
		public int rob(int[] nums) {
			if(nums.length==0) return 0;
			if(nums.length==0) return nums[0];
			return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
		}

		public int rob(int[] nums, int lo, int hi) {
		    int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
		    for (int i = lo; i <= hi; i++) {
		      	rob = preNotRob + nums[i];
		    	notRob = Math.max(preRob, preNotRob);
		    	
		    	preNotRob = notRob;
		    	preRob = rob;
		    }
		    return Math.max(rob, notRob);
		}
}
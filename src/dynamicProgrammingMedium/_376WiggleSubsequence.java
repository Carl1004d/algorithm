package dynamicProgrammingMedium;

/**
 * A sequence of numbers is called a wiggle sequence if the differences between
 * successive numbers strictly alternate between positive and negative. The
 * first difference (if one exists) may be either positive or negative. A
 * sequence with fewer than two elements is trivially a wiggle sequence.
 * 
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences
 * (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5]
 * and [1,7,4,5,5] are not wiggle sequences, the first because its first two
 * differences are positive and the second because its last difference is zero.
 * 
 * Given a sequence of integers, return the length of the longest subsequence
 * that is a wiggle sequence. A subsequence is obtained by deleting some number
 * of elements (eventually, also zero) from the original sequence, leaving the
 * remaining elements in their original order.
 * 
 * Example 1:
 * 
 * Input: [1,7,4,9,2,5] Output: 6 Explanation: The entire sequence is a wiggle
 * sequence. Example 2:
 * 
 * Input: [1,17,5,10,13,15,10,5,16,8] Output: 7 Explanation: There are several
 * subsequences that achieve this length. One is [1,17,10,13,10,16,8]. Example
 * 3:
 * 
 * Input: [1,2,3,4,5,6,7,8,9] Output: 2 Follow up: Can you do it in O(n) time?
 */
public class _376WiggleSubsequence {
	private int calculate(int[] nums, int index, boolean isUp) {
		int maxcount = 0;
		for (int i = index + 1; i < nums.length; i++) {
			if ((isUp && nums[i] > nums[index]) || (!isUp && nums[i] < nums[index]))
				maxcount = Math.max(maxcount, 1 + calculate(nums, i, !isUp));
		}
		return maxcount;
	}

	// 暴力求解
	public int wiggleMaxLength1(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		return 1 + Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
	}

	// 动态规划
	public int wiggleMaxLength2(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int[] up = new int[nums.length];
		int[] down = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					up[i] = Math.max(up[i], down[j] + 1);
				} else if (nums[i] < nums[j]) {
					down[i] = Math.max(down[i], up[j] + 1);
				}
			}
		}
		return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
	}

	// 线性动态规划  		遍历一次出结果	这个可以将up,down数组改进为O(1)
	public int wiggleMaxLength3(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int[] up = new int[nums.length];
		int[] down = new int[nums.length];
		up[0] = down[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			// 判断和上一个数的差异(波动),加入到up/down中
			if (nums[i] > nums[i - 1]) {
				up[i] = down[i - 1] + 1;
				down[i] = down[i - 1];
			} else if (nums[i] < nums[i - 1]) {
				down[i] = up[i - 1] + 1;
				up[i] = up[i - 1];
			} else {
				down[i] = down[i - 1];
				up[i] = up[i - 1];
			}
		}
		return Math.max(down[nums.length - 1], up[nums.length - 1]);
	}
	
	// 贪心算法,只记录发生波动的位置(用和前一个值对比,再参考前一次的上升/下降序列判断波动),波动了就加一
	 public int wiggleMaxLength4(int[] nums) {
	        if (nums.length < 2)
	            return nums.length;
	        int prevdiff = nums[1] - nums[0];
	        int count = prevdiff != 0 ? 2 : 1;
	        for (int i = 2; i < nums.length; i++) {
	            int diff = nums[i] - nums[i - 1];
	            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
	                count++;
	                prevdiff = diff;
	            }
	        }
	        return count;
	    }
}

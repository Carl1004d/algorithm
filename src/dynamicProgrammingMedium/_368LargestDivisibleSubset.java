package dynamicProgrammingMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies:
 * 
 * Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * 
 * Input: [1,2,3] Output: [1,2] (of course, [1,3] will also be ok) Example 2:
 * 
 * Input: [1,2,4,8] Output: [1,2,4,8]
 */

public class _368LargestDivisibleSubset {
	public static void main(String[] args) {
		_368LargestDivisibleSubset o = new _368LargestDivisibleSubset();
		int nums[] = {1,2,3};
		o.largestDivisibleSubset(nums);
	}
	public List<Integer> largestDivisibleSubset(int[] nums) {

		int n = nums.length;
		if (n == 0)
			return new ArrayList();
		int[] sum = new int[n];
		int[] pre = new int[n]; // 用来记录最优解的前一个要加入集合的数
		Arrays.sort(nums);
		int maxIndex = 0; // 最大集合的最大元素的下标
		// 找到最大集合的长度
		for (int i = 0; i < nums.length; i++) {
			sum[i] = 1; // 这两个值每次循环时候赋
			pre[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (sum[j] + 1 > sum[i]) {
						sum[i] = sum[j] + 1;
						pre[i] = j;
					}
				}
			}
			maxIndex = sum[i] > sum[maxIndex] ? i : maxIndex;
		}
		List<Integer> result = new ArrayList<Integer>();
		while (maxIndex != -1) {
			result.add(nums[maxIndex]);
			maxIndex = pre[maxIndex];
		}
		return result;
	}

}

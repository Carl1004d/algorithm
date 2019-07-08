package mediumArraysWrong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 */
public class _003Sum15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		int length = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < length; i++) {
			if (nums[i] > 0)
				break;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			// 往后找，避免重复
			int begin = i + 1;
			int end = length - 1;
			while (begin < end) {
				int sum = nums[i] + nums[begin] + nums[end];
				if (sum == 0) {
					List<Integer> listInt = new ArrayList<>();
					listInt.add(nums[i]);
					listInt.add(nums[begin]);
					listInt.add(nums[end]);
					list.add(listInt);
					begin++;
					end--;
					// 避免重复！！！！
					while (begin < end && nums[begin] == nums[begin - 1])
						begin++;
					while (begin < end && nums[end] == nums[end + 1])
						end--;
				} else if (sum > 0)
					end--;
				else
					begin++;
			}
		}
		return list;
	}
}

package mediumArraysWrong.递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations.
 * 
 * @author 84135
 *
 */
public class _039CombinationSum {
	public static void main(String[] args) {
		int[] a = { 2, 5, 4, 6, 3, 7, 8 };
		_039CombinationSum b = new _039CombinationSum();
		long t1 = System.nanoTime();
		b.combinationSum(a, 8);
		System.out.println(System.nanoTime() - t1);
	}

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i); // not i +
																		// 1
																		// because
																		// we
																		// can
																		// reuse
																		// same
																		// elements
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}

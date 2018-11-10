package mediumArraysWrong.递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Note:
 * 
 * All numbers will be positive integers. The solution set must not contain
 * duplicate combinations. Example 1:
 * 
 * Input: k = 3, n = 7 Output: [[1,2,4]] Example 2:
 * 
 * Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class _216CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> tempList = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();

		backtrack(result, tempList, k, n, 1, n);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> tempList, int frequency, int remain, int start,
			int n) {
		if (remain < 0)
			return;
		if (frequency < 0)
			return;
		if (remain == 0 && frequency == 0) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		}
		for (int i = start; i <= 9; i++) {
			tempList.add(i);// i就是当前遍历的值
			backtrack(result, tempList, frequency - 1, remain - i, i + 1, n);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
		_216CombinationSumIII a = new _216CombinationSumIII();
		System.out.println(a.combinationSum3(3, 15));
	}
}

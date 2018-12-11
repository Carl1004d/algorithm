package 递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * Input: "aab" Output: [ ["aa","b"], ["a","a","b"] ]
 */
public class _131PalindromePartitioning {
	int[][] dp;

	public static void main(String[] args) {
		_131PalindromePartitioning o = new _131PalindromePartitioning();
		List<List<String>> result = o.partition("aab");
		System.out.println(result);
	}

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		dp = new int[s.length() + 1][s.length() + 1];
		backtrack(result, new ArrayList<String>(), s, 0);
		return result;
	}

	// 从s的start索引向后面截取
	private void backtrack(List<List<String>> result, ArrayList<String> temp, String s, int start) {
		if (start == s.length()) {
			result.add(new ArrayList<>(temp));
		}

		for (int i = 1; i <= s.length() - start; i++) {
			String stemp = s.substring(start, start + i);
			if (isPalindrome(stemp)) {
				temp.add(stemp);
				backtrack(result, temp, s, start + i);
				temp.remove(temp.size() - 1);
			}
		}
	}

	// 从s的start索引向后面截取,用了dp,但空间消耗不少
	private void backtrack2(List<List<String>> result, ArrayList<String> temp, String s, int start) {
		if (start == s.length()) {
			result.add(new ArrayList<>(temp));
		}

		for (int i = 1; i <= s.length() - start; i++) {
			if (dp[start][start + i] == 0) { // 未访问过
				String stemp = s.substring(start, start + i);
				if (isPalindrome(stemp)) {
					dp[start][start + 1] = 1;
					temp.add(stemp);
					backtrack(result, temp, s, start + i);
					temp.remove(temp.size() - 1);
				}
			} else if (dp[start][start + i] == 1) { // 是回文
				String stemp = s.substring(start, start + i);
				temp.add(stemp);
				backtrack(result, temp, s, start + i);
				temp.remove(temp.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}

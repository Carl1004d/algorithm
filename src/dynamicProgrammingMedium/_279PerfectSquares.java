package dynamicProgrammingMedium;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4. Example 2:
 * 
 * Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
 */
public class _279PerfectSquares {
	public int numSquares(int n) {
		int[] result = new int[n + 1];
		for(int i = 1; i < result.length; i++){
			result[i] = Integer.MAX_VALUE;
		}
		result[0]=0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j * j <= i; j++) {
				result[i] = Math.min(result[i], result[i-j*j]+1);
			}
		return result[n];
	}
}

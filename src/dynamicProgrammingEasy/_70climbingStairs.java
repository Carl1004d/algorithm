package dynamicProgrammingEasy;

public class _70climbingStairs {
	public class Solution {
		// 暴力求解
	    public int climbStairs(int n) {
	        if (n == 1) {
	            return 1;
	        }
	        int[] dp = new int[n + 1];
	        dp[1] = 1;
	        dp[2] = 2;
	        for (int i = 3; i <= n; i++) {
	            dp[i] = dp[i - 1] + dp[i - 2];
	        }
	        return dp[n];
	    }
	}
	
	// 存一下
	public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
    
    // 动态规划
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

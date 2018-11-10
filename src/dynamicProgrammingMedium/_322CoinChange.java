package dynamicProgrammingMedium;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * 
 * Input: coins = [2], amount = 3 Output: -1 Note: You may assume that you have
 * an infinite number of each kind of coin.
 */

public class _322CoinChange {
	// 自己做的!!!!!!!!!!!!!
	public int coinChange(int[] coins, int amount) {// [474,83,404,3]
		// 264
		if (amount == 0) {
			return 0;
		}
		int[] result = new int[amount + 1];
		Arrays.fill(result, -1);
		result[0] = 0;
		for (int i = 0; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					if (result[i - coin] != -1) {
						if (result[i] != -1) {
							result[i] = Math.min(result[i], result[i - coin] + 1);
						} else {
							result[i] = result[i - coin] + 1;
						}

					}
				}
			}
		}
		return result[amount];
	}

	public static void main(String[] args) {
		_322CoinChange o = new _322CoinChange();
		int[] a = { 2 };
		o.coinChange3(a, 3);
	}


	// 递归回溯,暴力求解
	private int coinChange1(int idxCoin, int[] coins, int amount) {
		if (amount == 0)
			return 0;
		if (idxCoin < coins.length && amount > 0) {
			int maxVal = amount / coins[idxCoin];
			int minCost = Integer.MAX_VALUE;
			for (int x = 0; x <= maxVal; x++) {
				if (amount >= x * coins[idxCoin]) {
					int res = coinChange1(idxCoin + 1, coins, amount - x * coins[idxCoin]);
					if (res != -1)
						minCost = Math.min(minCost, res + x);
				}
			}
			return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
		}
		return -1;
	}

	// 缓存一下,递归回溯
	private int coinChange2(int[] coins, int rem, int[] count) {
		if (rem < 0)
			return -1;
		if (rem == 0)
			return 0;
		if (count[rem - 1] != 0)
			return count[rem - 1];
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChange2(coins, rem - coin, count);
			if (res >= 0 && res < min)
				min = 1 + res;
		}
		count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[rem - 1];
	}

	// 动态规划
	public int coinChange3(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}

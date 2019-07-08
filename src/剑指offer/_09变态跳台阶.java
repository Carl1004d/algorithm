package 剑指offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @author 84135
 *
 */
public class _09变态跳台阶 {
	public int JumpFloorII(int target) {
		int[] dp = new int[target+1];
		dp[0] = 0;
		for(int i = 1; i <= target; i++){
			int temp = 0;
			for(int j = 0; j < i; j++){
				temp+= dp[j];
			}
			dp[i] = temp+1;
		}
		return dp[target];
	}
}

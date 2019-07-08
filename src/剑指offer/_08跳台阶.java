package 剑指offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 */
public class _08跳台阶 {
	public static void main(String[] args) {
		_08跳台阶 o = new _08跳台阶();
		int result = o.JumpFloor(4);
		System.out.println(result);
	}
	public int JumpFloor(int target) {
		if(target < 2) return target;
		int[] dp = new int[target+1];
		dp[1] = 1;
		dp[2] = 2;
		// [1,target]台阶所有结果
		for(int i = 3; i < target+1; i++){
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[target];
	}
	public int JumpFloor2(int target) {
		if(target < 2) return target;
	
		int prepre = 1;
		int pre = 2;
		// [1,target]台阶所有结果
		for(int i = 3; i < target+1; i++){
			int temp = prepre;
			prepre = pre;
			pre = temp+pre;
		}
		return pre;
	}
}

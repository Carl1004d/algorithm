package dynamicProgrammingEasy;

public class Test4399 {
	// 完全背包:装备战斗力[1,5,50,150],装备无限多,凑一套4399战斗力的装备,求一共有几套
	public int getResult(int[] arr, int K){
		int[] dp = new int[K+1];
		dp[0] = 1;
		for(int i = 0; i < arr.length; i++){
			// dp总战斗力
			for(int j = arr[i]; j <= K; j++) {
				dp[j] = dp[j] + dp[j-arr[i]];
			}
		}
		return dp[K];
	}
}

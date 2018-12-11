package dynamicProgrammingMedium;

import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * Note: Each of the array element will not exceed 100. The array size will not
 * exceed 200. Example 1:
 * 
 * Input: [1, 5, 11, 5]
 * 
 * Output: true
 * 
 * Explanation: The array can be partitioned as [1, 5, 5] and [11]. Example 2:
 * 
 * Input: [1, 2, 3, 5]
 * 
 * Output: false
 * 
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class _416PartitionEqualSubsetSum {

	public boolean canPartition(int[] nums) {

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 == 1)
			return false;
		else {

			Arrays.sort(nums);
			if (nums[nums.length - 1] > sum / 2)
				return false;
			return canPart(nums, sum / 2, 0);
		}

	}

	private boolean canPart(int[] nums, int remain, int start) {
		if (remain == 0)
			return true;
		else if (remain < 0)
			return false;
		else {
			boolean flag = false;
			for (int i = start; i < nums.length; i++) {
				flag = canPart(nums, remain - nums[i], i + 1);
				if (flag)
					return flag;
			}
		}
		return false;
	}
	// 人家总结出来的动态规划,其实自己应该可以做出来....
	public boolean canPartition2(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 0; i < nums.length; i++) {
            for (int j = volumn; j >= nums[i]; j--) {	// 这里一定是反着来,要不nums[i]==1的话,j从1开始,dp就会全是true
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[volumn];
    }
	
	// 动态规划,二维数组
	public boolean canPartition_2(int[] nums) {  
	     int sum=0;  
	     for (int num:nums) sum+= num;
	     if(sum % 2 == 1) return false;
	     else{  
	        sum /=2;
	        int n=nums.length;  
	        // dp[i][j] 表示 如果我们取前i个数字，且背包容量为j的情况下，最多能放入多少东西
	        int dp[][]=new int[n][sum + 1];  
	        // dp[0][0] 为初始状态，表示，没有任何没有东西没有体积，其余部分初始化
	        for(int i=nums[0];i<=sum;i++){
	             dp[0][i] = nums[0];
	        }
	        //遍历n个数字，即视为n个产品
	        for(int i=1;i<n;i++){  
	            //加入了这种物品后更新状态
	            for(int j=nums[i];j<=sum;j++){  
	                dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);  
	            }  
	        }  
	        //放满了才能表示正好1/2
	        if(dp[n-1][sum]==sum) 
	            return true;  
	        else
	            return false;  
	     }  

	 }  
	
	public static void main(String[] args) {
		_416PartitionEqualSubsetSum o = new _416PartitionEqualSubsetSum();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		boolean f = o.canPartition(nums);
		System.out.println(f);
	}
}

package easyArrays;

import org.junit.Test;

public class LongestContinuousIncreasingSubsequence674 {
	public int findLengthOfLCIS(int[] nums) {
//		if(nums == null || nums.length==0){
//			return 0;
//		}
//		if(nums.length == 1){
//			return 1;
//		}
//		int len = nums.length;
//		int max = 0,temp = 1;
//		for(int i = 0;i < len-1; i++){
//			
//			if(nums[i] < nums[i+1]){
//				temp++;
//				if(temp > max){
//					max = temp;
//				}
//			}else {
//				temp = 1;
//				if(temp > max){
//					max = temp;
//				}
//			}
//		}
//		
//		return max;
		 int n = nums.length;
	        if (n == 0) return 0;
	        int max = 1;
	        for (int i = 1, k = 1; i < n; ++i) {
	            if (nums[i] > nums[i - 1]) {
	                k ++;
	                max = Math.max(max, k);
	            }
	            else {
	                k = 1;
	            }
	        }
	        return max;
	}
	@Test
	public void fun1(){
		int[] nums = {1};
		System.out.println(findLengthOfLCIS(nums));
	}
}

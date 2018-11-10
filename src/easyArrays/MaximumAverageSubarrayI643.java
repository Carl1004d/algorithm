package easyArrays;

import org.junit.Test;
/**
 * 一个sum就可以完成的事情不用sum[n]完成
 * @author 84135
 *
 */
/*
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value.
And you need to output the maximum average value. 
Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75

Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
 */
public class MaximumAverageSubarrayI643 {
	public double findMaxAverage(int[] nums, int k) {
		
		int sum = 0;
		for(int i = 0; i < k; i++){
			sum += nums[i];
		}
		double average = (double)sum/k;
		for(int i = 1; i < nums.length-k+1; i++){
			sum = sum - nums[i-1]+nums[i+k-1];
			if((double)sum/k>average){
				average = (double)sum/k;
			}
		}
		return average;
	}
	@Test
	public void fun1(){
		int[] a = {1,12,-5,-6,50,3};
		System.out.println(findMaxAverage(a,4));
	}
}

package easyArrays;

import org.junit.Test;

/*
	Given a non-empty array of non-negative integers nums, 
	the degree of this array is defined as the maximum frequency of any one of its elements.
	Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
	在一个非空非负的int型数组中，定义degree为一个数组中的元素出现频率最大值。你的任务就是要寻找这个数组中出现频率最大的元素的最小距离
	Input: [1, 2, 2, 3, 1] 
	Output: 2 
	Explanation: 
	The input array has a degree of 2 because both elements 1 and 2 appear twice. 
	Of the subarrays that have the same degree: 
	[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2] 
	The shortest length is 2. So return 2.
	Input: [1,2,2,3,1,4,2] 
	Output: 6
	nums.length will be between 1 and 50,000. 
	nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeofanArray697 {
	@Test
	public void fun1(){
		int[] a = {1,2,2,3,1};
		System.out.println(findShortestSubArray(a));
	}
	public int findShortestSubArray(int[] nums) {
		if(nums.length == 1){
			return 1;
		}
		int[] frequency = new int[50001];
		int[] pos = new int[50001];
		int maxFrequency = 0;
		int minLength = 50000;  // 这里赋一个不可能超过的值
		int currentLength;
		for (int i = 0; i < nums.length; i++) { // 这个i是遍历 i+1是数组中的位置
			if (pos[nums[i]] != 0) {
				frequency[nums[i]]++;
				currentLength = (i + 1) - pos[nums[i]] + 1;
				if (frequency[nums[i]] > maxFrequency) { // 大于,重新计算:当前位置-所在位置+1
					maxFrequency = frequency[nums[i]];
					minLength = currentLength;
				} else if (frequency[nums[i]] == maxFrequency) {
					minLength = currentLength < minLength ? currentLength : minLength;
				} else{
					// 如果小于最大频率不用变 
				}
			} else {
				pos[nums[i]] = i + 1;
			}
		}
		// 因为maxFrequency比真实的少算了一次,所以==0时候是没有重复出现的数字的情况
		// 这种情况下minLength=50000初始值,不会改变
		if(maxFrequency == 0){
			return 1;
		}
		return minLength;
	}
}

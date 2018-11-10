package easyArrays;

import java.util.Arrays;

/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.
Example 1:
Input: [1,2,3]
Output: 6

Example 2:
Input: [1,2,3,4]
Output: 24

Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

 */
public class MaximumProductofThreeNumbers628 {

	public int maximumProduct(int[] nums) {
//		int max1 = -1001, max2 = -1001, max3 = -1001; // max最大 max2第二大 max3第三大
//		int min1 = 1001, min2 = 1001; // min1最小 min2第二小
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] < min1) {
//				min2 = min1;
//				min1 = nums[i];
//			} else if (nums[i] < min2)
//				min2 = nums[i];
//			if (nums[i] > max1) {
//				max3 = max2;
//				max2 = max1;
//				max1 = nums[i];
//			} else if (nums[i] > max2) {
//				max3 = max2;
//				max2 = nums[i];
//			} else if (nums[i] > max3)
//				max3 = nums[i];
//		}
//		int a = max1 * max2 * max3;
//		int b = min1 * min2 * max1;
//		return a > b ? a : b;

		int len = nums.length;
		int max = -1001, indexmax = 0, max2 = -1001, max3 = -1001;
		int min1 = 1001, min2 = 1001;
		for (int i = 0; i < len; i++) {
			if (nums[i] > max) {
				max = nums[i];
				indexmax = i;
			}
		}
		for (int i = 0; i < len; i++) {
			if (i == indexmax)
				continue;
			if (nums[i] < min1) {
				min2 = min1;
				min1 = nums[i];
			} else if (nums[i] < min2)
				min2 = nums[i];

			if (nums[i] > max2) {
				max3 = max2;
				max2 = nums[i];
			} else if (nums[i] > max3)
				max3 = nums[i];
		}
		int a = max * max2 * max3;
		int b = min1 * min2 * max;
		return a > b ? a : b;

	}
}

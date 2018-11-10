package easyArrays;
/*561. Array Partition I 

Pick One
Given an array of 2n integers, your task is to group these integers into n pairs of integer, 
say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible. 
Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).

Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].*/
/*
方法：将数组从小到大排序，然后选择索引为偶数的数相加。
翻译：给2n个数的数组，把它们分为n组，取每组中最小的数使其相加和最大。
思想：贪心算法。理解：简单点说一组已经从小到排好序的数组，从最大值开始，最大值肯定是取不到的，那么，取次大的数，也就是倒数第二个数，以此类推，顺其自然，都是取的索引位置为偶数的数。
 */

import java.util.Arrays;
import java.util.List;

public class ArrayPartition1 {
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		for(int i = 0; i <= nums.length-2; i+=2){
			result += nums[i];
		}
		return result;
	}
}

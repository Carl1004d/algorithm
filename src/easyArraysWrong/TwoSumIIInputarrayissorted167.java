package easyArraysWrong;

/**
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number. The function
 * twoSum should return indices of the two numbers such that they add up to the
 * target, where index1 must be less than index2. Please note that your returned
 * answers (both index1 and index2) are not zero-based. You may assume that each
 * input would have exactly one solution and you may not use the same element
 * twice. Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */
public class TwoSumIIInputarrayissorted167 {
	// 基本算法
	// public int[] twoSum(int[] numbers, int target) {
	// for(int i = 0; i < numbers.length - 1; i++){
	// for(int j = i + 1; j < numbers.length; j++){
	// if(numbers[i] + numbers[j] == target){
	// int[] result = {i+1,j+1};
	// return result;
	// }
	// }
	// }
	// // 循环出来没结果 (题目中假定不存在这种情况)
	// return null;
	// }
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 1)
			return null;
		int i = 0, j = numbers.length - 1;

		while (i < j) {
			int x = numbers[i] + numbers[j];
			if (x < target) {
				++i;
			} else if (x > target) {
				--j;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
		return null;
	}
}

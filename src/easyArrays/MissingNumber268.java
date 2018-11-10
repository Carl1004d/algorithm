package easyArrays;

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array. 
Example 1 
Input: [3,0,1]
Output: 2

Example 2 
Input: [9,6,4,2,3,5,7,0,1]
Output: 8
*/
public class MissingNumber268 {
	public int missingNumber(int[] nums) {
		// if (nums.length == 0 || nums == null) {
		// return -1;
		// }
		// boolean[] temp = new boolean[nums.length + 1];
		// for (int num : nums) {
		// temp[num] = true;
		// }
		// for (int i = 0; i < temp.length; i++) {
		// if (temp[i] == false) {
		// return i;
		// }
		// }
		// return -1;
//		int sum = 0;
//		for (int num : nums)
//			sum += num;
//		int n = nums.length;
//		return (n * (n + 1)) / 2 - sum;
		int res = 0;  
        for (int i = 1; i <= nums.length; i++)   
            res =res ^ i ^ nums[i-1];   
        return res;   
	}
}

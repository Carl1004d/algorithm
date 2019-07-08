package easyArraysWrong;

import org.junit.Test;

/**
 * 基本操作:
 * 	数组重复后替前
 * @author 84135
 *
 */
/**
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * @author 84135
 *
 */
public class RemoveDuplicatesfromSortedArray26 {
	public int removeDuplicates(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] != nums[i]) {
				nums[++index] = nums[i];
			}
		}
		return index + 1;
	}

}

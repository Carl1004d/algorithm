package easyArraysWrong;

import org.junit.Test;
/**
 * 基本操作:
 * 	数组重复后替前
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
		return index+1;
	}

	@Test
	public void fun1() {
		int[] a = { 1, 1, 2 };
		System.out.println(removeDuplicates(a));
	}
}

package easyArraysWrong;
/**
 * 旋转数组,每一次右边移到左边.可以选择复制一个,用(i+k)%nums.length就是所需要替换的位置
 * @author 84135
 *
 */
/*
Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem. 
 */
public class RotateArray189 {
	public void rotate(int[] nums, int k) {
		int[] clone = nums.clone();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			nums[(i + k) % len] = clone[i];
		}
	}
}

package mediumArraysWrong;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Example 1:
 * 
 * Input: [1,3,4,2,2] Output: 2 Example 2:
 * 
 * Input: [3,1,3,4,2] Output: 3 Note:
 * 
 * You must not modify the array (assume the array is read only). You must use
 * only constant, O(1) extra space. Your runtime complexity should be less than
 * O(n2). There is only one duplicate number in the array, but it could be
 * repeated more than once.
 */
public class _287FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		if (nums.length > 1) {
			int slow = nums[0], fast = nums[nums[0]];
			while (slow != fast) {
				fast = nums[nums[fast]];
				slow = nums[slow];
			}
			// 从头来一次,和slow撞在环的初始点
			fast = 0;
			while (slow != fast) {
				fast = nums[fast];
				slow = nums[slow];
			}

			return slow;
		}
		return -1;
	}
}
// 最大数n,空间n+1,不算0,只能有一个重复,找出来.
// slow = num[slow] fast = nums[nums[fast]] 慢的走一步,快的走两步
// 这样因为数组中有重复元素,在中间形成了一个环.在slow进入环时,设已走路程n0,这时,fast在环里也已经走了n0.
// 设环长度n,两者相交时(fast==slow),也就是slow在环中走过n-n0时候,距离环的起始点,也就是数组重复元素,距离为n0
// 再从头走一次,就会和slow相碰在重复元素点

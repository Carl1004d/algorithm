package mediumArraysWrong;

/*
   Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

	(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	
	You are given a target value to search. If found in the array return its index, otherwise return -1.
	
	You may assume no duplicate exists in the array.
	
	Your algorithm's runtime complexity must be in the order of O(log n).
	
	Example 1:
	
	Input: nums = [4,5,6,7,0,1,2], target = 0
	Output: 4
	Example 2:
	
	Input: nums = [4,5,6,7,0,1,2], target = 3
	Output: -1
 */
public class _033SearchRotatedSortedArray {
	public int search(int[] nums, int target) {
		// 先用二分法获取旋转开始点的索引
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (nums[mid] < nums[high]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		// 此时high == mid, 即旋转开始位置
		int rotate = low;
		int length = nums.length;
		low = 0;
		high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;				// 算出现在的中间
			int realmid = (mid + rotate) % length;	// 平移获得真正的中间位置,若出界取余获得
			if (nums[realmid] < target) {
				low = mid + 1;
			} else if (nums[realmid] == target) {
				return realmid;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		_033SearchRotatedSortedArray obj = new _033SearchRotatedSortedArray();
		int[] nums = {5,6,7,1,2,3};
		int i = obj.search(nums, -2);
		System.out.println(i);
	}
}
/**
 * 总结:
 * 	注意[6,7,1,2,3,4,5]
 * 	获取6:[6,7,1,2,3,4,5,[6,7]]
 * 	: 7%7 = 0
 * 	获取7:
 * 	8%7 = 1
 */

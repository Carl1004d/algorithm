package mediumArraysWrong;

import java.util.ArrayList;
import java.util.List;
/**
 * 判断重复出现,非常典型代码,注意1<=a[i]<=n,n为数组长度,所以temp作为下标要减一,防止越界
 * @author 84135
 *
 */
/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[2,3]
 */
public class FindAllDuplicatesinanArray442 {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			int temp = Math.abs(num);
			if(nums[temp-1] >= 0){
				nums[temp-1] = -nums[temp-1];
			} else{
				list.add(temp);
			}
		}
		return list;
	}
}

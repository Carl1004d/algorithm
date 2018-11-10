package easyArraysWrong;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
/**
 * 这个注意集合的灵活运用
 * @author 84135
 *
 */
/*
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k. 
 * 给定一个整数数组nums与一个整数k，当且仅当存在两个不同的下标i和j满足nums[i] = nums[j]并且|i-j|<=k时返回true，否则返回false。
 */
public class ContainsDuplicateII219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int temp = i - map.get(nums[i]);
				if(temp <= k)
					return true;
				else
					map.put(nums[i], i);
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}
	@Test
	public void fun1(){
		int[] a = {1,0,1,1};
		System.out.println(containsNearbyDuplicate(a,1));
	}
}

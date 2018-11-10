package easyArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * 改进:
 * 可以设置一个数组,全部赋值-1.
 * 然后按照同样方法用给的nums[]的每个元素给-1的数组赋值
 * 最后仍然是-1的索引就是所求
 * @author 84135
 * 总结:
 * 	因为给定了数组元素的范围 1 - n
 * 	所以如果判断出没出现过只需要设置一个不在范围内的元素,将他的改变作为标志
 */
/*
	Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
	some elements appear twice and others appear once.
	Find all the elements of [1, n] inclusive that do not appear in this array.
	Input:
	[4,3,2,7,8,2,3,1]
	Output:
	[5,6]
 */
public class FindAllNumbersDisappearedinanArray448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		 if(nums == null || nums.length == 0)
	            return list;
		int n = nums.length;
		boolean[] bools = new boolean[n + 1];
		Arrays.fill(bools, true);
		for (int i = 0; i < nums.length; i++) {
			if (bools[nums[i]]) {
				bools[nums[i]] = false;
			}
		}
		
		for (int i = 1; i < bools.length; i++) {
			if (bools[i]) {
				list.add(i);
			}
		}

		return list;
	}

	@Test
	public void fun1() {
		int[] a = {4,3,2,7,8,2,3,1};
		List<Integer> list = findDisappearedNumbers(a);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}

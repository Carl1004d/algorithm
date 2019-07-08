package 剑指offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
// 对应每个测试案例，输出两个数，小的先输出。
public class _33和为S的两个数字 {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> result = new ArrayList<>();
		if (array.length < 2)
			return result;
		int low = 0;
		int high = array.length - 1;
		for (; low < high;) {
			int temp = array[low] + array[high];
			if (temp == sum) {
				result.add(array[low]);
				result.add(array[high]);
				return result;
			} else if (temp > sum) {
				high--;
			} else {
				low++;
			}
		}
		return result;
	}
}

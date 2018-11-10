package easyArrays;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

public class ShortestUnsortedContinuousSubarray581 {
	@Test
	public int findUnsortedSubarray(int[] nums) {
		long date1T = System.currentTimeMillis();
		System.out.println(date1T);
		int[] temp = nums.clone();
		Arrays.sort(temp);
		int len = nums.length;
		int start = 0;
		for(; start < len; start++) 
			if(temp[start] != nums[start])
				break;
		int end = len-1;
		for(; end > start; end--)
			if(temp[end] != nums[end])
				break;
		for(int i = 0;i < 10000;i++){i++;}
		long date2T = System.currentTimeMillis();
		System.out.println(date2T);
		System.out.println(date2T-date1T);
		return end - start+1;
	}
	@Test
	public void fun1(){
		int[] a = {2, 6, 4, 8, 10, 9, 15};
		System.out.println(findUnsortedSubarray(a));
	}
}

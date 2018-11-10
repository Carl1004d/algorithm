package easyArrays;

import org.junit.Test;

public class MaxConsecutiveOnes485 {
	public int findMaxConsecutiveOnes(int[] nums) {
		int result = 0;
		int temp = 0;
		for (int num : nums) {
			if (num == 1) {
				temp += 1;
				if(temp > result){
					result = temp;
				}
			} else {
				temp = 0;
			}
		}
		return result;
	}
	@Test
	public void fun1(){
		int[] a = {1,0,1,0,0,0,1,1,1};
		int i = findMaxConsecutiveOnes(a);
		System.out.println(i);
	}
}

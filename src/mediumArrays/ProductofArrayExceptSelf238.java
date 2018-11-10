package mediumArrays;

import org.junit.Test;

public class ProductofArrayExceptSelf238 {
	public int[] productExceptSelf(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		result[0] = 1;
		// 算左边乘积
		for(int i = 1; i < length; i++){
			result[i] = result[i - 1] * nums[i - 1];
		}
		// 算右边乘积
		int right = 1;
		for(int i = length - 1; i >= 0; i--){
			result[i] *= right;
			right *= nums[i];
		}
		return result;
	}
	@Test
	public void fun1(){
		int[] a = {0,0};
		int[] b = productExceptSelf(a);
		for(int m : b){
			System.out.println(m);
		}
	}
}

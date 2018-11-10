package easyArrays;

import java.util.Stack;

import org.junit.Test;

/*
	Given a non-negative integer represented as a non-empty array of digits, 
	plus one to the integer.
	You may assume the integer do not contain any leading zero, except the number 0 itself.
	The digits are stored such that the most significant digit is at the head of the list.
	给定一非负整数，将其当做一个包含数字的数组来看待，求对其"加1"后所得到的数组。
         例如数字999对应于数组[9,9,9]，那么“加1”后得到的数组为[1,0,0,0]。
 */
public class PlusOne {
	public static int[] plusOne(int[] digits) {
		if (digits.length == 0) {
			return null;
		}
		int length = digits.length;
		// 判断是否需要进位
		if (digits[length - 1] < 9) {
			digits[length - 1] += 1;
		} else {
			// 判断进几次位,中间有一个不是9就可停止进位
			for (int i = length - 1; i >= 0; i--) {
				if (digits[i] != 9) {
					digits[i] += 1;
					break;
				} else {
					digits[i] = 0;
				}
			}
		}
		// 判断加一之后最高位是否是0, 是0即产生了进位位
		if (digits[0] == 0) {
			int[] result = new int[length + 1];
			result[0] = 1;
			for (int i = 0; i < digits.length; i++) {
				result[i + 1] = digits[i];
			}
			return result;
		} else {
			return digits;
		}

	}

	public static void main(String[] args) {
		int[] a = { 8, 9 };
		int[] aa = plusOne(a);
		for (int i : aa) {
			System.out.println(i);
		}
	}

}

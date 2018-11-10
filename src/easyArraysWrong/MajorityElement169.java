package easyArraysWrong;
/**
 * 巧解:
 * 	用一个标记cnt记录某个元素出现的次数，如果后面的元素和它相同就加一，有一个元素和他不相同就减一，当cnt小于等于0时重新记录新的元素。 
 * @author 84135
 *
 */
/*
Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement169 {
	public int majorityElement(int[] nums) {
		// 用于记录主元素，假设第一个是主元素
		int main = nums[0];
		// 用于抵消数的个数
		int count = 1;
		for(int i = 1; i < nums.length; i++){// 从第二个元素开始到最后一个元素
			if(main == nums[i]){// 如果两个数相同就不能抵消
				count++;// 用于抵消的数据加1
			}else{
				if(count > 0){// 如果不相同，并且有可以抵消的数
					count--;// 进行数据抵消
				}else{// 如果不相同，并且没有可以抵消的数
					main = nums[i];// 记录最后不可以抵消的数
				}
			}
		}
		// 对于数组中可能没有主元素的情况，题中说明存在，此步可以省略。
//      count = 0;
//      for (int a : num) {
//          if (a == main) {
//              count++;
//          }
//      }
//
//      if (count >= num.length / 2) {
//          return main;
//      } else {
//          throw new RuntimeException("No majority element");
//      }
		return main;
	}
}

package easyArraysWrong;

import java.util.HashMap;
import java.util.Map;
/**
首先，我能想到最简单的思路就是两个 for 循环，遍历整个数组，n 平方的时间复杂度，这个思路就不再写了，很容易。
看了一下标签，发现是 Array 和 Hash Table，结合讨论区的朋友们解答，理解了如下思路：
创建一个 int 数组 result 存放需要返回的下标，因为只需要返回两个，所以数组大小为 2。
创建一个 HashMap<Integer, Integer> 类型的变量 map，key 存放数值，value 存放下标。
循环遍历数组 nums，判断在 map 中是否存在 target-nums[i]：若存在，直接将两个下标存入 result 数组，并返回；若不存在，将 nums[i] 的值和下标放入 map，进入下一次循环。


作者：秋名山菜车手
链接：https://www.jianshu.com/p/ac0a7235c651
來源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author 84135
 *
 */
public class TwoSum1 {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target - nums[i])){
				int j = map.get(target - nums[i]);
					result[0] = j;
					result[1] = i;
			}else{
				map.put(nums[i], i);
			}
		}
		return result;
	}
}

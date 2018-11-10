package mediumArraysWrong.递归回溯;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;

public class _040CombinationSumII {
	public static void main(String[] args) {
		_040CombinationSumII a = new _040CombinationSumII();
		int[] as = {10,1,2,7,6,1,5};
		List<List<Integer>> list = a.combinationSum2(as, 8);
		System.out.println(list);
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<Integer>(), candidates, target, 0);
		return result;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{
	        for(int i = start; i < nums.length; i++){
	            if(i > start && nums[i] == nums[i-1]) continue; // 注意有一个i > start条件,是用来控制第一层循环中的相同数字的
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i + 1);
	            tempList.remove(tempList.size() - 1); 
	        }
	    }
	} 
}

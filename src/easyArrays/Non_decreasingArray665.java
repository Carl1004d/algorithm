package easyArrays;

public class Non_decreasingArray665 {
	public boolean checkPossibility(int[] nums) {
		boolean flag = false;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] < nums[i-1]){
				if(!flag){
					flag = true;
					if( i-2 >= 0 && nums[i] < nums[i-2]){
						nums[i] = nums[i-1];
					} 
				}else{
					return false;
				}
			}
		}
		return true;
	}
}

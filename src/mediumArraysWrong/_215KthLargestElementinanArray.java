package mediumArraysWrong;

public class _215KthLargestElementinanArray {
	public static void main(String[] args) {
		int[] a = {3,2,1,5,6,4};
		_215KthLargestElementinanArray o = new _215KthLargestElementinanArray();
		int r = o.findKthLargest(a, 2);
		System.out.println(r);
	}
	public int findKthLargest(int[] nums, int k) {
		int lo = 0;
		int hi = nums.length - 1;
		int index = nums.length - k;
		while (lo < hi) {
			int j = partition(nums, lo, hi);
			if (j > index) {
				hi = j - 1;
			} else if (j < index) {
				lo = j + 1;
			} else {
				break;
			}
		}
		return nums[nums.length-k];
	}

	public int partition(int[] nums, int lo, int hi) {	// 排[lo,....,hi]
		int i = lo - 1;
		int j = hi + 1;
		int temp = nums[lo];
		int t = lo;
		for(; t < j;){
			if(nums[t] == temp){
				t++;
			} else if (nums[t] > temp){
				swap(nums,t,--j);
			} else {
				swap(nums,t++,++i);
			}
		}
		return t-1;
	}
	public void swap(int[] nums,int indexA ,int indexB){
		int temp = nums[indexA];
		nums[indexA] = nums[indexB];
		nums[indexB] = temp;
	}
}

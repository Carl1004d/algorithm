package 剑指offer;

import java.util.ArrayList;

public class _22最小的K个数 {
	public static void main(String[] args) {
		
	}
	
	
	
	
	// [start,end] 进行排序
	private void partition(int[] arr, int start, int end) {
		if(start>=end) return;
		int temp = arr[start];
		int low = start+1, high = end+1;
		// [start+1,low)之间表示小于temp,[high,end]之间表示大于temp
		for(;low < high;) {
			if(temp > arr[low]) {
				low++;
			} else {
				swap(arr,low,--high);
			}
		}
		low--;
		swap(arr,start,low);
		partition(arr,start,low-1);
		partition(arr,low+1,end);
	}
	private void swap(int[] arr, int start, int low) {
		int temp = arr[start];
		arr[start] = arr[low];
		arr[low] = temp;
	}
}

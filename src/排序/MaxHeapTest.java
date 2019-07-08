package 排序;

import org.junit.Test;

public class MaxHeapTest {
	@Test
	// 使用堆,插入,再取出进行排序
	public void test1() {
		MaxHeap maxHeap = new MaxHeap(100);
		for (int i = 0; i < 20; i++) {
			int ran = (int) (Math.random() * (100 + 1)); // [0,101)即[0,100]的整型
			maxHeap.insert(ran);
		}
		// 一个一个往外取最后就是有序的
		while (!maxHeap.isEmpty()) {
			int extractMax = maxHeap.extractMax();
			System.out.print(extractMax + " ");
		}
	}

	@Test
	// 将一个数组转化成堆,调用另一个构造方法
	public void test2() {
		int[] arr = new int[20];
		for (int i = 0; i < 20; i++) {
			int ran = (int) (Math.random() * (100 + 1)); // [0,101)即[0,100]的整型
			arr[i] = ran;
		}
		MaxHeap maxHeap = new MaxHeap(arr, arr.length);
		while (!maxHeap.isEmpty()) {
			int extractMax = maxHeap.extractMax();
			System.out.print(extractMax + " ");
		}
	}
	@Test
	// 原地堆排序
	public void test3() {
		MaxHeapTest o = new MaxHeapTest();
		int[] arr = new int[20];
		for(int i = 0; i < 20; i++){
			arr[i] = (int)(Math.random()*(100+1));
		}
		o.heapSort(arr, arr.length);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	// 原地堆排序
	public void heapSort(int[] arr, int n) {
		// 数组是一个二叉堆,索引从0开始,非叶子节点的左孩子 = 2*i+1,右孩子 = 2 * i + 2, 最后一个非叶子节点的索引 = (count-1)/2
		
		// 将arr数组构建成堆
		for(int i = (n-1)/2; i >= 0; i--){
			__shiftDown(arr, n, i);
		}
		for(int i = n-1; i > 0; i--){
			swap(arr,0,i);
			__shiftDown(arr,i,0);// 每次循环count减一,所以堆大小为i
		}
	}
	// 0为开始的shiftdown
	private void __shiftDown(int[] arr, int n, int i) {
		while (i * 2 + 1 < n) {
			int j = 2 * i +1; // data[index]与data[j]交换
			if (j + 1 < n && arr[j + 1] > arr[j])
				j += 1;
			if (arr[i] > arr[j]) // 如果当前节点比两个子节点大,不用shiftDown
				break;
			swap(arr, i, j);
			i = j;
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

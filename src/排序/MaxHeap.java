package 排序;

import org.junit.Test;

public class MaxHeap {
	public int[] data;
	private int count; // 拥有元素数量
	private int capacity;

	public MaxHeap() {
	}

	public MaxHeap(int capacity) {
		data = new int[capacity + 1]; // 因为存储从1索引开始,0不用
		count = 0;
		this.capacity = capacity;
	}

	// 给个数组,建立最大堆,heapify过程
	public MaxHeap(int[] arr, int n) {
		data = new int[n + 1];
		capacity = n;
		for (int i = 0; i < n; i++) {
			data[i + 1] = arr[i];
		}
		count = n;
		// count/2 结果是第一个非叶子节点的节点,从它开始对数组进行shiftDown,使arr变成最大堆
		for (int i = count / 2; i >= 1; i--) {
			shiftDown(i);
		}
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void insert(int n) {
		// 需要判断一下count+1越界问题, 建议扩容(略)
		data[count + 1] = n;
		count++;
		shiftUp(count);
	}

	// 将索引index位置元素移动到堆的恰当位置
	private void shiftUp(int index) {
		while (index > 1 && data[index / 2] < data[index]) {
			swap(data, index / 2, index);
			index /= 2;
		}
	}

	// 取出最大值,将根节点取出,把data[count]元素放到根节点,再向下挪动
	public int extractMax() {
		assert (count > 0);
		int max = data[1];
		data[1] = data[count];
		count--;
		shiftDown(1);
		return max;
	}

	// 将索引index的节点向下挪动
	private void shiftDown(int index) {
		while (index * 2 <= count) {
			int j = 2 * index; // data[index]与data[j]交换
			if (j + 1 <= count && data[j + 1] > data[j])
				j += 1;
			if (data[index] > data[j]) // 如果当前节点比两个子节点大,不用shiftDown
				break;
			swap(data, index, j);
			index = j;
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	

}

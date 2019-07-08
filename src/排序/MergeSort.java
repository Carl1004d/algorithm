package 排序;

public class MergeSort {
	public static void main(String[] args) {
		MergeSort o = new MergeSort();
		int[] arr = new int[] { 1, 4, 5, 8, 2, 6, 6 };
		o.mergeSort(arr, arr.length);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	// 自顶向下
	void mergeSort(int[] arr, int n) {
		__mergeSort(arr, 0, n - 1);
	}

	// 递归使用归并排序,对arr[l....r]的范围进行排序
	private void __mergeSort(int[] arr, int l, int r) {
		if (l >= r)
			return;
		int mid = (l + r) / 2;
		__mergeSort(arr, l, mid);
		__mergeSort(arr, mid + 1, r);
		if (arr[mid] > arr[mid + 1]) // 优化,arr[mid] > arr[mid+1] 再去归并
			__merge(arr, l, mid, r);
	}

	// 将arr[l...mid]和arr[mid+1...r]两部分进行归并
	private void __merge(int[] arr, int l, int mid, int r) {
		int[] temp = new int[r - l + 1];
		// 放入临时空间
		for (int i = l; i <= r; i++) {
			temp[i - l] = arr[i]; // 需要平移,因为i从l索引开始,temp从0索引开始
		}
		int i = l, j = mid + 1;

		for (int k = l; k <= r; k++) {
			if (i > mid) { // i走完了,剩j
				arr[k] = temp[j - l];
				j++;
			} else if (j > r) { // j走完了,剩i
				arr[k] = temp[i - l];
				i++;
			} else if (temp[i - l] > temp[j - l]) {// 都没走完
				arr[k] = temp[j - l];
				j++;
			} else {
				arr[k] = temp[i - l];
				i++;
			}
		}
	}

	// 自底向上归并
	void mergeSort2(int[] arr, int n) {
		for (int size = 1; size <= n; size += size) { // 每次归并规模为上次两倍
			for (int i = 0; i + size < n; i += size + size) { // 每次跨过两个size区域
				// 对arr[i...i+size-1] 和 arr[i+size...i+size+size-1]进行归并
				__merge(arr, i, i + size - 1, Math.min(i + size + size - 1, n - 1));// Math.min处理最后位置可能越界情况
			}
		}
	}
}

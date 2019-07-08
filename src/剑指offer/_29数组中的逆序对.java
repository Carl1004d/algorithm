package 剑指offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *
 */
public class _29数组中的逆序对 {
	int result = 0;

	public static void main(String[] args) {
		_29数组中的逆序对 o = new _29数组中的逆序对();
		// 5, 3, 6, 1, 2, 8, 4, 9, 7
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 0 };
		int m = o.InversePairs(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println(m);
	}

	public int InversePairs(int[] array) {
		if (array.length == 0)
			return 0;
		int n = array.length;
		mergeSort(0, n - 1, array);
		return result%1000000007;
	}

	// 对[start,end]进行归并排序
	private void mergeSort(int start, int end, int[] array) {
		if (end <= start)
			return;
		int mid = (start + end) / 2;
		mergeSort(start, mid, array);
		mergeSort(mid + 1, end, array);
		merge(start, mid, end, array);
	}

	// 对array的[start,mid],[mid+1,end]进行归并
	private void merge(int start, int mid, int end, int[] array) {
		if (end <= start)
			return;
		int[] temp = new int[end - start + 1];
		for (int i = start, j = 0; i <= end; i++, j++) {
			temp[j] = array[i];
		}
		int mid2 = mid - start;
		int i = mid2;
		int j = temp.length - 1;
		int start2 = end;
		while (i >= 0 && j > mid2) {
			if (temp[i] > temp[j]) {
				array[start2--] = temp[i--];
				result += j - mid2;
				// result = result%1000000007; //
			} else {
				array[start2--] = temp[j--];
			}
		}
		if (i == -1) {
			// 前面的走完了
			for (; start2 >= start; start2--, j--) {
				array[start2] = temp[j];
			}
		} else {
			// j == temp.length,后面的走完了
			for (; start2 >= start; start2--, i--) {
				array[start2] = temp[i];
			}
		}
	}
}

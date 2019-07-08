package 排序;

public class QuickTest {
	public static void main(String[] args) {
		QuickTest o = new QuickTest();
		int[] arr = new int[] { 98, 2, 6, 9, 6, 4, 5 };
		o.__quickSort(arr, 0, 6);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	void quickSort(int[] arr, int n) {
		__quickSort(arr, 0, n - 1);
	}
	// 对arr[l...r]快速排序
	private void __quickSort(int[] arr, int l, int r) {
		if (l >= r)
			return;
		int p = partition(arr, l, r);
		__quickSort(arr, l, p - 1);
		__quickSort(arr, p + 1, r);

	}
	private int partition(int[] arr, int l, int r) {
		// 随机选择一个标定点,保证随机性
		int random = (int) (Math.random() * (r - l + 1) + l);
		swap(arr, l, random);
		
		int temp = arr[l];
		int j = l;
		// arr[l+1...j] < temp, arr[j+1...i) > temp
		for (int i = l + 1; i <= r; i++) {
			if (arr[i] < temp) {
				swap(arr, j + 1, i);
				j++;
			} else {
				continue;
			}
		}
		swap(arr, l, j);
		return j;
	}
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

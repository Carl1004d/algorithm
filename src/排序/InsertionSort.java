package 排序;
// 插入排序,可以提前终止内层循环,若数组基本有序,效率会非常高
// 时间复杂度O(n方)
public class InsertionSort {
	// 普通插入排序
	void insertionSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			// 寻找元素arr[i]合适的插入位置
			for (int j = i; j > 0; j--) { // 大于0,因为要和前一个位置比,大于等于会超界
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
				} else {
					break;
				}

			}
		}
	}

	// 改进插入排序,不是每次都交换,把元素拿出来待插入
	void insertionSort2(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			// 寻找元素arr[i]合适的插入位置
			int temp = arr[i];
			for (int j = i; j > 0; j--) { // 大于0,因为要和前一个位置比,大于等于会超界
				if (temp < arr[j - 1]) {
					arr[j] = arr[j-1];
				} else {
					arr[j] = temp;
					break;
				}

			}
		}
	}

	private void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}

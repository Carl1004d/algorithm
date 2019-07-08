package 排序;

// 快速排序
public class QuickSort {
	public static void main(String[] args) {
		QuickSort o = new QuickSort();
		int[] arr = new int[]{15,2,6,9,6,5,5};
		o.__quickSort(arr,0,6);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	void quickSort(int[] arr, int n) {
		__quickSort(arr, 0, n - 1);
	}

	// 对arr[l...r]快速排序
	private void __quickSort(int[] arr, int l, int r) {
		if (l >= r)
			return;
		int p = partition2(arr, l, r);
		__quickSort(arr, l, p - 1);
		__quickSort(arr, p + 1, r);

	}

	// 对arr[l...r]进行partition,返回元素最终位置p,使得arr[l...p-1]<arr[p],arr[p+1...r] >= arr[p]
	private int partition(int[] arr, int l, int r) {
		// 这两行是随机选取元素位置
		int random = (int) (Math.random() * (r - l + 1) + l);
		swap(arr, l, random);

		int temp = arr[l];
		int j = l;
		// arr[l+1...j] < temp, arr[j+1...i) > temp
		for (int i = l + 1; i <= r; i++) {
			if (arr[i] < temp) {
				swap(arr, j+1, i);
				j++;
			} else {
				continue;
			}
		}
		swap(arr, l, j);
		return j;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// 双路快排,当重复元素非常多时,左右指针
	private int partition2(int[] arr, int l, int r) {
		int random = (int) (Math.random() * (r - l + 1) + l);
		swap(arr, l, random);
		int v = arr[l];

		// arr[l+1...i) <= v; arr(j...r] >= v
		int i, j;
		i = l + 1;
		j = r;
		while (true) {
			while (i <= r && arr[i] < v)
				i++;
			while (j >= l + 1 && arr[j] > v)
				j--;
			if (i > j) {
				break;
			}
			swap(arr, i, j);
			i++;
			j--;
		}
		swap(arr, l, j);
		return j;
	}

	// 三路快排,当重复元素非常多时,左右指针
	// arr[l...r] < v;==v; > v
	private void __quickSort3Ways(int[] arr, int l, int r) {
		if(l > r) return;	// 这里可以在数量少的时候使用插入排序优化
		
		swap(arr,l,(int) (Math.random() * (r - l + 1) + l));
		int v = arr[l];
		
		int lt = l; // arr[l+1...lt] < v
		int gt = r+1;	// arr[gt...r] > v
		int i = l+1;	// arr[lt+1...i)==v,i正在考察,不算入
		while(i < gt) {
			if(arr[i] < v) {
				swap(arr,i,lt+1);
				lt++;
				i++;
			} else if(arr[i] > v){
				swap(arr,i,gt-1);
				gt--;
			} else {
				i++;
			}
		}
		swap(arr,l,lt);	// 标定点和<v的最后一个交换
		__quickSort3Ways(arr,l,lt-1);
		__quickSort3Ways(arr,gt,r);
	}
	
	
}

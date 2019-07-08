package 剑指offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 */
public class _06旋转数组的最小数字 {
	public int minNumberInRotateArray(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		
		return getMin(array,0,array.length-1);
	}
	// [i,j]中获取最小值
	private int getMin(int[] array, int start, int end) {
		if(start == end) return array[start];
		int mid = (start+end)/2;
		if(array[mid] > array[end]){
			return getMin(array,mid+1,end);
		} else {
			return getMin(array,start,mid);
		}
	}
}

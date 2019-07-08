package 剑指offer;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字， 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12
 * 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 */
public class _17顺时针打印矩阵 {
	@Test
	public void test1(){
		printMatrix(new int[][]{{1,2},{3,4}});
	}
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		// start1横向遍历开始的第一列,end1结束的第一列,start2纵向遍历开始的第一列,end2纵向遍历结束的第一列
		int start1 = 0, end1 = col - 1, start2 = 0, end2 = row - 1;
		int i = start1, j = start2;
		// 在[start1,end1][start2,end2]循环遍历
		for (;;) {
			if (start1 > end1)
				break;
			for (j = start1; j <= end1; j++) {
				list.add(matrix[i][j]);
			}
			start2++;j--;
			
			if (start2 > end2)
				break;
			for (i = start2; i <= end2; i++) {
				list.add(matrix[i][j]);
			}
			end1--;i--;
			
			if(start1>end1) break;
			for (j = end1; j >= start1; j--) {
				list.add(matrix[i][j]);
			}
			end2--;j++;
			if(start2 > end2) break;
			for (i = end2; i >= start2; i--) {
				list.add(matrix[i][j]);
			}
			start1++;i++;
		}
		return list;
	}
}

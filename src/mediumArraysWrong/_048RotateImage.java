package mediumArraysWrong;

import java.nio.charset.MalformedInputException;

/**
 * You are given an n x n 2D matrix representing an image. Rotate the image by
 * 90 degrees (clockwise). Note: You have to rotate the image in-place, which
 * means you have to modify the input 2D matrix directly. DO NOT allocate
 * another 2D matrix and do the rotation. Example 1: Given input matrix = [
 * [1,2,3], 
 * [4,5,6], 
 * [7,8,9] ], rotate the input matrix in-place such that it
 * becomes: [ 
 * [7,4,1], 
 * [8,5,2], 
 * [9,6,3] ] Example 2: Given input matrix = [ 
 * [ 5, 1, 9,11], 
 * [ 2, 4, 8,10], 
 * [13, 3, 6, 7], 
 * [15,14,12,16] ], rotate the input
 * matrix in-place such that it becomes: [ 
 * [15,13, 2, 5], 
 * [14, 3, 4, 1], 
 * [12, 6, 8, 9], 
 * [16, 7,10,11] ]
 */
public class _048RotateImage {
	public void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i < j) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
		for (int i = 0, j = matrix.length-1; i < j; i++, j--) {
			for (int row = 0; row < matrix[i].length; row++) {
				int temp = matrix[row][i];
				matrix[row][i] = matrix[row][j];
				matrix[row][j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		_048RotateImage obj = new _048RotateImage();
		obj.rotate(matrix);
		for (int[] is : matrix) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
/**
 * 反正怎么转圈都可以,都是行换列,列对换/行对换,列换行 /* clockwise rotate first swap the symmetry (i.e.
 * transpose the matrix), then reverse each row 
 * 1 2 3     1 4 7     7 4 1
 * 4 5 6  => 2 5 8  => 8 5 2
 * 7 8 9     3 6 9     9 6 3
 * anti-clockwise rotate first swap the symmetry (i.e. transpose the matrix),
 * then reverse each col
 */

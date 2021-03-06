package mediumArraysWrong;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * Input: [ 
 * [ 1, 2, 3 ], 
 * [ 4, 5, 6 ], 
 * [ 7, 8, 9 ] ] Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * 
 * Input: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] Output:
 * [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class _054SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;
		List result = new ArrayList<Integer>();
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			for (int j = colBegin; j <= colEnd; j++) {
				result.add(matrix[rowBegin][j]);
			}
			rowBegin++;

			// Traverse Down
			for (int j = rowBegin; j <= rowEnd; j++) {
				result.add(matrix[j][colEnd]);
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// Traverse Left
				for (int j = colEnd; j >= colBegin; j--) {
					result.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// Traver Up
				for (int j = rowEnd; j >= rowBegin; j--) {
					result.add(matrix[j][colBegin]);
				}
			}
			colBegin++;
		}
		return result;
	}
}

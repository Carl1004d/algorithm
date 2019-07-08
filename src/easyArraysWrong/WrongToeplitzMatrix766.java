package easyArraysWrong;

import org.junit.Test;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same element. Now given an M x N matrix, return True if and only if the
 * matrix is Toeplitz.
 * 
 * Example 1: Input: matrix = [ [1,2,3,4],
 * 								[5,1,2,3],
 * 								[9,5,1,2]] Output: True
 * Explanation: 1234 5123 9512
 * 
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2,
 * 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the
 * answer is True. Example 2: Input: matrix = [[1,2],[2,2]] Output: False
 * Explanation: The diagonal "[1, 2]" has different elements.
 */
/*
 * 原来把这个题想难了，想如何是true，如何分类讨论问题，其实反过来就好了，看了答案之后就豁然开朗了！！！不过与答案稍微有点差别！但思路一样！！！
 * class Solution { 
 * 	public boolean isToeplitzMatrix(int[][] matrix) { 
 * 		for(int i=1;i<matrix.length;i++){ 	
 * 			for(int j = 1;j<matrix[i].length;j++){
 * 				if(matrix[i][j]!=matrix[i-1][j-1]) return false; 
 * 			} 
 * 		} 
 * 		return true; 
 * } 
 * }
 */
public class WrongToeplitzMatrix766 {
	public boolean isToeplitzMatrix(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		int size = rows * columns;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i - 1][j - 1] != matrix[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}

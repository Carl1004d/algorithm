package mediumArraysWrong;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * 
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * Note: m and n will be at most 100.
 * 
 * @author 84135
 *
 */
public class _063UniquePathII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		int[] result = new int[row];
		result[0] = 1;
		for (int j = 0; j < col; j++) {
			for (int i = 0; i < row; i++) {
				if (obstacleGrid[i][j] == 1) {
					result[i] = 0;
				} else if (i > 0) {
					result[i] += result[i - 1];
				}

			}
		}
		return result[row - 1];
	}
}
/**
 * 动态规划,可以result[][]
 * 之后优化成result[]   result[i] = result[i]+result[i-1]
 */

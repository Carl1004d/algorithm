package easyArraysWrong;

import org.junit.Test;
/**
 * 递归实现一定要先判断结束时候条件   才能让思路清晰!!!!!!!
 */
/*int[][] grid
 * Given a non-empty 2D array grid of 0's and 1's, 
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array.(If there is no island, the maximum area is 0.) 
 * 题目给了我们一个 2d grid array， 让我们找到所有岛中区域最大的一个，返回区域值。0代表海洋，1代表陆地。陆地与陆地相连，只能是横向和纵向，不可以斜着。
　　因为只能横向和纵向相连，所以每一个cell 只能是4个方向延伸，左 上 右 下。
　　这道题目要用到Depth-first Search，遍历2d array，遇到1的时候，就利用dfs把这个岛的区域大小找全。我的dps顺序是 左，上，右，下。在递归dfs之前，要把目前的cell
 */
public class MaxAreaofIsland695 {
	@Test
	public int maxAreaOfIsland(int[][] grid) {
		int result = 0;
		int rows = grid.length;
		int columns = grid[0].length;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				int temp = getThisNum(grid,i,j);
				if(temp > result){
					result = temp;
				}
			}
		}
		return result;
	}
	public int getThisNum(int[][] grid, int i, int j) {
		// 判断结束条件
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
			return 0;
		// 没结束 就是1
		int num = 1;
		// 变成0 防止下次被访问
		grid[i][j] = 0;
		num += getThisNum(grid, i - 1, j) + getThisNum(grid, i + 1, j) + getThisNum(grid, i, j - 1)
				+ getThisNum(grid, i, j + 1);

		return num;
	}

}
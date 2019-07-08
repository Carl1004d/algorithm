package mediumArraysWrong;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as
 * Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
 * diagonal) using the following four rules (taken from the above Wikipedia
 * article):
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population. 		活着的细胞拥有少于2个活着的邻居下一代死亡
 * Any live cell with two or three live neighbors lives on to
 * the next generation. 	活着的细胞拥有2-3个活着的邻居可以活到下一代
 * Any live cell with more than three live neighbors dies,
 * as if by over-population.. 活着的细胞拥有三个以上活着的邻居下一代死亡
 * Any dead cell with exactly three live neighbors
 * becomes a live cell, as if by reproduction. 死的细胞拥有三个活着的邻居,下一代活
 * Write a function to compute the
 * next state (after one update) of the board given its current state. The next
 * state is created by applying the above rules simultaneously to every cell in
 * the current state, where births and deaths occur simultaneously.
 * 
 * Example:
 * 
 * Input: [ 
 * [0,1,0], 
 * [0,0,1], 
 * [1,1,1], 
 * [0,0,0] 
 * ] Output: [ 
 * [0,0,0], 
 * [1,0,1],
 * [0,1,1], 
 * [0,1,0] 
 * ]
 */
public class _289GameOfLife {
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0)
			return;

		int m = board.length; // rows
		int n = board[0].length; // columns

		// first iteration: mark states for each cell
		for (int i = 0; i < m; i++) // rows
		{
			for (int j = 0; j < n; j++) // columns
			{
				int cnt = 0;
				// count cell's live neighbors 3x3 matrix and set boundary
				for (int x = Math.max(0, i - 1); x <= Math.min(m - 1, i + 1); x++) {
					for (int y = Math.max(0, j - 1); y <= Math.min(n - 1, j + 1); y++) {
						if (x == i && y == j) // skip itself
							continue;
						// only state 1 and 2: cell are live for previous state
						if (board[x][y] == 1 || board[x][y] == 2)
							cnt++;
					}
				}

				if (board[i][j] == 0 && cnt == 3) // current is dead cell
					board[i][j] = 3; // dead -> live
				else if (board[i][j] == 1 && (cnt < 2 || cnt > 3)) // current
																	// live cell
					board[i][j] = 2; // live -> dead
			}
		}

		// second iteration: convert state back to dead or live
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				board[i][j] %= 2;
	}
}
// 0 dead -> dead 没有变化
//
// 1 live -> live 没有变化
//
// 2 live -> dead 从live 变为 dead
//
// 3 dead -> live 从dead 变为live
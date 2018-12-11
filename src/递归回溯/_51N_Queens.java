package 递归回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 */
// n皇后问题
public class _51N_Queens {
	boolean[] dia1;
	boolean[] dia2;
	boolean[] col;

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		if (n == 0)
			return result;
		int[][] matrix = new int[n][n];
		dia1 = new boolean[n + n];
		dia2 = new boolean[n + n];
		col = new boolean[n];
		backtrack(result, new LinkedList(), 0, n);
		return result;
	}

	// n皇后在index行尝试摆放
	private void backtrack(List<List<String>> result, List<Integer> row, int index, int n) {
		if(index == n){
			result.add(generatBoard(n,row));
			return;
		}
		for (int i = 0; i < n; i++) {
			// 对角线和相等,差相等,差的为了防止负数加上n-1
			if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
				row.add(i);
				col[i] = true;
				dia1[i + index] = true;
				dia2[index - i + n - 1] = true;
				backtrack(result, row, index + 1, n);
				col[i] = false;
				dia1[i + index] = false;
				dia2[index - i + n - 1] = false;
				row.remove(row.size()-1);
			}
		}
		return;
	}

	private List<String> generatBoard(int n, List<Integer> row) {
		List result = new ArrayList<>();
		
		for(int i = 0; i < n; i++){
			String s = "";
			Integer temp = row.get(i);
			for(int j = 0 ;j < n; j ++){
				if(j == temp){
					s+='Q';
				} else {
					s+='.';
				}
			}
			result.add(s);
		}
		return result;
	}
	public static void main(String[] args) {
		_51N_Queens o = new _51N_Queens();
		List<List<String>> r = o.solveNQueens(4);
		for (List<String> list : r) {
			System.out.println("[");
			for (String string : list) {
				System.out.println(string);
			}
			System.out.println("]");
		}
	}
}

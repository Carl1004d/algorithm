package dynamicProgrammingMedium;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * Input:
 * 1 0 1 0 
 * 0 1 0 1 
 * 1 1 1 1 
 * 1 1 1 1 
 * 0 0 1 0
 * 
 * Output: 4
 */
public class _221MaximalSquare {
	    public int maximalSquare(char[][] matrix) {
	        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
	        int[][] dp = new int[rows + 1][cols + 1];
	        int maxsqlen = 0;
	        for (int i = 1; i <= rows; i++) {
	            for (int j = 1; j <= cols; j++) {
	                if (matrix[i-1][j-1] == '1'){
	                	// 右下角的值等于左上角,上,左最小的加一
	                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;	
	                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
	                }
	            }
	        }
	        return maxsqlen * maxsqlen;
	    }
	    public int maximalSquare2(char[][] matrix) {
	        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
	        int maxsqlen = 0;
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                if (matrix[i][j] == '1') {
	                    int sqlen = 1;
	                    boolean flag = true;
	                    while (sqlen + i < rows && sqlen + j < cols && flag) {
	                        for (int k = j; k <= sqlen + j; k++) {
	                            if (matrix[i + sqlen][k] == '0') {
	                                flag = false;
	                                break;
	                            }
	                        }
	                        for (int k = i; k <= sqlen + i; k++) {
	                            if (matrix[k][j + sqlen] == '0') {
	                                flag = false;
	                                break;
	                            }
	                        }
	                        if (flag)
	                            sqlen++;
	                    }
	                    if (maxsqlen < sqlen) {
	                        maxsqlen = sqlen;
	                    }
	                }
	            }
	        }
	        return maxsqlen * maxsqlen;
	    }
}

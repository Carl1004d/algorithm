package mediumArraysWrong;

public class _059SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int rowBegin = 0;
		int colBegin = 0;
		int rowEnd = result[0].length-1;
		int colEnd = result[0].length-1;
		int temp = 0;
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			for(int i = colBegin; i <= colEnd; i++){
				result[rowBegin][i] = temp++;
			}
			rowBegin++;
			for(int i = rowBegin; i <= rowEnd; i++){
				result[i][colEnd] = temp++;
			}
			colEnd--;
			if(rowBegin <= rowEnd) {
				for(int i = colEnd;i >= colBegin;i--){
					result[rowEnd][i] = temp++;
				}
			}
			rowEnd--;
			if(colBegin <= colEnd){
				for(int i = rowEnd;i >= rowBegin;i--){
					result[i][colBegin] = temp++;
				}
			}
			colBegin++;
		}
		return result;
	}
}

package mediumArraysWrong;

public class _074Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		if(row == 0){
			return false;
		}
		int col = matrix[0].length;
		if(col == 0){
			return false;
		}
		int targetRow = -1;
		for (int i = 0; i < row; i++) {
			if(matrix[i][0] < target) {
				targetRow = i;
			} else if(matrix[i][0] > target){
				break;
			} else {
				return true;
			}
		}
		if(targetRow == -1)
			return false;
		for(int j = 0; j < col; j++){
			if(matrix[targetRow][j] > target){
				return false;
			} else if(matrix[targetRow][j] < target){
				continue;
			} else {
				return true;
			}
		}
		return false;
	}
}

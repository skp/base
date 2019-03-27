package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class ClokewisePrint_29 {

	static Stack<Integer> stack = new Stack<>();

	/**
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
	 * 例如，如果输入如下4 X 4矩阵： {1 2 3 4} {5 6 7 8} {9 10 11 12} {13 14 15 16}
	 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 * @param matrix
	 * @return
	 */
	static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		printMatrixCore(list, matrix, 0, 0);
		return list;
	}

	static void printMatrixCore(List<Integer> list, int[][] matrix, int startRow, int startCol) {
		int rows = matrix.length - 2* startRow;
		int cols = matrix[0].length - 2*startCol;
		if (rows > 0 && cols > 0) {
			for (int i = startRow; i < rows + startRow; i++) {
				if (i == startRow) {
					for (int j = startCol; j < cols + startCol; j++) {
						list.add(matrix[i][j]);
					}
				} else if (i == rows - 1) {
					for (int j = cols + startCol - 1; j >= startCol; j--) {
						list.add(matrix[i][j]);
					}
				} else {
					list.add(matrix[i][cols + startCol - 1]);
					if (cols + startCol - 1 > startCol)
						stack.add(matrix[i][startCol]);
				}
			}
			while (!stack.isEmpty()) {
				list.add(stack.pop());
			}
			printMatrixCore(list, matrix, startRow + 1, startCol + 1);
		}

	}

	public static void main(String[] args) {
		printMatrix(new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}});
	}
}

package array;

public class Matrix_12 {

	/**
	 * a b c e
	 * s f c s
	 * a d e e
	 * 是否包含 bcced 的路径 走过的路径不能重复走.
	 *
	 * @param matrix
	 * @param rows
	 * @param cols
	 * @param str
	 *
	 * @return
	 */
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (null == matrix || rows < 1 || cols < 1 || null == str) {
			return false;
		}
		char[][] charMatrix = new char[rows][cols];
		for (int i = 0, count = rows * cols; i < count; i++) {
			charMatrix[i / cols][i % cols] = matrix[i];
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				boolean[] visited = new boolean[rows * cols];
				if (hasPathCore(charMatrix, i, j, rows, cols, str, 0, str.length, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hasPathCore(char[][] charMatrix, int i, int j, int row, int cols, char[] str, int v,
			int length, boolean[] visited) {
		if (i < 0 || i >= row || j < 0 || j >= cols) {
			return false;
		}
		if (charMatrix[i][j] == str[v]) {
			if (visited[i * cols + j]) {
				return false;
			}
			if (v == length - 1) {
				return true;
			}
			visited[i * cols + j] = true;
			v++;
			return hasPathCore(charMatrix, i - 1, j, row, cols, str, v, length, visited)
					|| hasPathCore(charMatrix, i + 1, j, row, cols, str, v, length, visited)
					|| hasPathCore(charMatrix, i, j - 1, row, cols, str, v, length, visited)
					|| hasPathCore(charMatrix, i, j + 1, row, cols, str, v, length, visited);
		}
		return false;
	}

	public static void main(String[] args) {
		char[] matrix = "AAAAAAAA".toCharArray();
		char[] strCharArr = "AAAAAAAA".toCharArray();
		System.out.println(Matrix_12
				.hasPath(matrix, 1, 8, strCharArr));
	}
}

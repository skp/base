package array;

public class Robot_13 {

	public static int movingCount(int threshold, int rows, int cols) {
		if (rows < 1 || cols < 1 || threshold < 0) {
			return 0;
		}
		boolean[] visited = new boolean[rows * cols];
		return movingCountCore(threshold, 0, 0, rows, cols, visited);
	}

	private static int movingCountCore(int threshold, int row, int col, int rows, int cols, boolean[] visited) {
		if (canInto(threshold, row, col, rows, cols, visited)) {
			visited[row * cols + col] = true;
			return 1 + movingCountCore(threshold, row - 1, col, rows, cols, visited)
					+ movingCountCore(threshold, row + 1, col, rows, cols, visited)
					+ movingCountCore(threshold, row, col - 1, rows, cols, visited)
					+ movingCountCore(threshold, row, col + 1, rows, cols, visited);
		}
		return 0;
	}

	private static boolean canInto(int threshold, int row, int col, int rows, int cols, boolean[] visited) {
		if (row < 0 || row > rows - 1 || col < 0 || col > cols - 1 || visited[row * cols + col])
			return false;
		int sum = 0;
		while (row > 0) {
			sum += row % 10;
			row = row / 10;
		}
		while (col > 0) {
			sum += col % 10;
			col = col / 10;
		}
		return sum <= threshold;
	}

	public static void main(String[] args) {
		System.out.println(Robot_13.movingCount(5, 10, 10));
	}
}

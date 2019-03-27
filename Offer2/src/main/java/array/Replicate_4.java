package array;

public class Replicate_4 {

	/**
	 * 二位数组找出k
	 * 二维数组 从上到下依次递增 从左到右依次递增
	 *
	 * @param numbers
	 * @param k
	 *
	 * @return
	 */
	public boolean duplicate(int[][] numbers, int k) {
		int i = 0, j = numbers[0].length - 1;
		while (i < numbers.length && j >= 0) {
			System.out.println(numbers[i][j]);
			if (numbers[i][j] == k) {
				return true;
			} else if (numbers[i][j] < k) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[]{1, 2, 8, 9};
		int[] arr2 = new int[]{2, 4, 9, 12};
		int[] arr3 = new int[]{4, 7, 10, 13};
		int[] arr4 = new int[]{6, 8, 11, 15};
		int[][] arr = new int[][]{arr1, arr2, arr3, arr4};
		System.out.println(new Replicate_4().duplicate(arr, 3));
		// System.out.println(7>>1);
	}
}

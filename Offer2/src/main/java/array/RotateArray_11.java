package array;

public class RotateArray_11 {

	public static int minNumberInRotateArray(int[] array) {
		if (null == array || array.length == 0) {
			return 0;
		}
		int left = 0;
		int right = array.length - 1;
		// 说明本身就是完全排序的
		if (array[left] < array[right]) {
			return array[left];
		}
		for (; ; ) {
			if (left >= right - 1) {
				break;
			}
			int mid = left + (right - left) / 2;
			if (array[left] < array[mid]) {
				left = mid;
			} else if (array[left] == array[mid]) {
				left++;
			} else {
				right = mid;
			}
		}

		return array[right];
	}

	public static void main(String[] args) {
		System.out.println(RotateArray_11.minNumberInRotateArray(new int[]{5, 6, 7, 8, 1, 2, 3, 4}));
	}
}

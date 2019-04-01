package array;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class OddEven_21 {

	public static int[] reOrderArray(int[] array) {
		// return orderCore(array, 0, array.length - 1); // 次序会变
		return orderCore2(array); // 次序不变
	}

	private static int[] orderCore2(int[] array) {
		int l = array.length;
		int i = 0, j = 1;
		while (i < l && j < l) {
			while (i < l && isConditionEstablished(array, i))
				i++;
			while (j < l && !isConditionEstablished(array, j))
				j++;
			if (i < j && i < l && j < l) {
				swap(array, i, j);
			}
		}
		return array;
	}

	private static int[] orderCore(int[] array, int start, int end) {

		while (start < end) {
			while (start < end && isConditionEstablished(array, start)) {
				start++;
			}

			while (start < end && !isConditionEstablished(array, end)) {
				end--;
			}
			if (start < end)
				swap(array, start, end);

		}
		return array;
	}

	private static boolean isConditionEstablished(int[] array, int i) {
		return array[i] % 2 == 1;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		Arrays.stream(OddEven_21.reOrderArray(new int[]{1, 2, 3, 4, 5, 6, 7})).forEach(System.out :: print);
	}
}

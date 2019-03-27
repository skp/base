package array;

public class MoreThanHalf_39 {

	public int moreThanHalfNum(int[] array) {
		if (null == array || array.length == 0) {
			return 0;
		}
		int num = array[0], time = 1;
		for (int i = 1; i < array.length; i++) {
			if (time == 0) {
				num = array[i];
				time++;
			} else if (num != array[i]) {
				time--;
			} else {
				time++;
				if (time >= array.length / 2) {
					return num;
				}
			}
		}
		return checkMoreThanHalf(array, num);
	}

	private int checkMoreThanHalf(int[] array, int n) {
		int time = 0;
		for (int i = 0; i < array.length; i++) {
			if (n == array[i]) {
				if (++time > array.length / 2) {
					return n;
				}
			}
		}
		return 0;
	}
}

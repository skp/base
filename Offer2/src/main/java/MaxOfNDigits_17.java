public class MaxOfNDigits_17 {
	public static void printMaxOfNDigits(int n) {
		if (n <= 0)
			return;
		int[] digits = new int[n + 1];

		while (increment(digits, n)) {
			printDigits(digits);
		}
	}


	private static boolean increment(int[] digits, int n) {
		if (n == 0) {
			return false;
		}
		if (digits[n] == 9) {
			digits[n] = 0;
			return increment(digits, n - 1);
		} else {
			digits[n] += 1;
			return true;
		}
	}

	private static void printDigits(int[] digits) {
		int beginningLocation = 0;
		for (int i = 0, l = digits.length; i < l; i++) {
			if (digits[i] != 0) {
				beginningLocation = i;
				break;
			}
			System.out.print(" ");
		}

		for (int i = beginningLocation, l = digits.length; i < l; i++) {
			System.out.print(digits[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MaxOfNDigits_17.printMaxOfNDigits(5);
	}
}

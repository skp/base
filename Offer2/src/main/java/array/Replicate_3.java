package array;

public class Replicate_3 {

	public int duplicate(int[] numbers, int start, int end) {
		while (start <= end) {
			int middle = start + (end - start) / 2;
			int count = countRange(numbers, start, middle);
			if (middle == start && count > 1) {
				return start;
			}

			if (count > middle - start + 1) {
				end = middle;
				// return duplicate(numbers, start, middle);
			} else {
				start = middle + 1;
				// return duplicate(numbers, middle + 1, end);
			}
		}


		// }
		// int middle = (end - start) / 2;

		/*int b = 0, f = 0;
		for (int i : numbers) {
			if (start <= i && i <= start + middle) {
				b++;
			} else if(start + middle < i && i < end) {
				f++;
			}
			if (middle == 1 && b >= 2) {
				System.out.printf("%d  %d", start, start + middle);
			}
			if (middle == 1 && f >= 2) {
				System.out.printf("%d  %d", start + middle, end);
			}
			if (b >= middle) {
				duplicate(numbers, start, middle);
			}
			if (f >= middle) {
				duplicate(numbers, middle + 1, end);
			}
		}*/

		return 0;
	}

	private int countRange(int[] numbers, int start, int end) {
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= start && numbers[i] <= end)
				count++;
		}
		// System.out.println(count);
		return count;
	}



	public static void main(String[] args) {
		System.out.println(new Replicate_3().duplicate(new int[]{10, 11, 9, 8, 7, 6, 9, 4, 3, 1, 1, 11}, 1, 11));
		// System.out.println(7>>1);
	}
}

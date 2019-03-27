package array;

public class Replicate_1_2 {

	// Parameters:
	//    numbers:     an array of integers
	//    length:      the length of array numbers
	//    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
	//                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
	//    这里要特别注意~返回任意重复的一个，赋值duplication[0]
	// Return value:       true if the input is valid, and there are some duplications in the array number
	//                     otherwise false
	public boolean duplicate(int numbers[], int length, int[] duplication) {

		for (int i = 0; i < length; i++) {
			int num = numbers[i];
			if (num >= length) {
				return false;
			}
			if (num != i) {
				if (num == numbers[num]) {
					duplication[0] = num;
					return true;
				} else {
					swap(numbers, num, i);
				}
			}
		}

		return false;
	}

	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		System.out.println(new Replicate_1_2().duplicate(new int[]{10, 11, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, 12, new int[1]));
	}
}

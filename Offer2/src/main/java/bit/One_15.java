package bit;

public class One_15 {
	public static int countOf1_1(int num) {
		int count = 0;
		int n = 1;
		while (n != 0) {
			if ((num & n) != 0) {
				count++;
			}
			n = n << 1;
		}
		System.out.println(count);
		return count;
	}

	public static int countOf1_2(int num) {
		int count = 0;
		while (num != 0) {
			count++;
			num = num & (num - 1);
		}
		System.out.println(count);
		return count;
	}

	public static void main(String[] args) {
		// One_15.countOf1_1(-12341235);
		// One_15.countOf1_2(-12341235);
		//
		// System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		// System.out.println(Integer.MIN_VALUE-1);
		// System.out.println(Integer.toBinaryString(Integer.MIN_VALUE-1));

		System.out.println(1.2345 == 1.2345);
	}
}

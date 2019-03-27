public class Fibonacci {

	public static long getFibonacci(int n) {
		long[] results = {0, 1};
		if (n < 2) {
			return results[n];
		}

		int location = 1;
		long temp = 0;
		while (++location <= n) {
			temp = Math.addExact(results[0], results[1]);
			results[0] = results[1];
			results[1] = temp;
		}
		return temp;
	}

	public static void main(String[] args) {
		System.out.println(Fibonacci.getFibonacci(70));
	}
}

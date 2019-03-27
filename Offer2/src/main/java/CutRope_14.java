public class CutRope_14 {

	/**
	 * 长度为length的绳子, 截成n段, 要求n段的乘积是最大的. 最大值是多少
	 * 动态规划 最少要剪一刀
	 * @param length
	 * @return
	 */
	public static int maxProduct(int length) {
		int[] products = new int[length + 1];
		if (length < 2)
			return 0;
		if (length == 2)
			return 1;
		if (length == 3)
			return 2;

		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;

		for (int i = 4; i <= length; i++) {
			int max = 0;
			for (int j = 1; j <= i/2; j++) {
				int product = products[j] * products[i-j];
				if (product > max) {
					max = product;
				}
			}
			products[i] = max;
		}
		return products[length];
	}

	/**
	 * 长度为length的绳子, 截成n段, 要求n段的乘积是最大的. 最大值是多少
	 * 贪婪 最少要剪一刀
	 * @param length
	 * @return
	 */
	public static int maxProduct1(int length) {
		if (length < 2)
			return 0;
		if (length == 2)
			return 1;
		if (length == 3)
			return 2;

		// 当n >= 5 时
		// 3(n-3) >= 2(n-2) 所以多剪成长度为3的段 是最优解
		int timeOf3 = length / 3;
		if (length - timeOf3 * 3 == 1) {
			timeOf3--;
		}

		int timeOf2 = (length - timeOf3 * 3) / 2;
		return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));
	}

	public static void main(String[] args) {
		System.out.println(CutRope_14.maxProduct1(18));
	}
}

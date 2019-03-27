public class Power_16 {
	public static double power(double base, int exponent) {
		if (base == 0)
			return 0;
		if (base == 1)
			return 1;
		double result = 1;
		if (exponent < 0) {
			for (int i = 0; i < -exponent; i++) {
				result *= base;
			}
			result = 1/result;
		}

		if (exponent > 0) {
			for (int i = 0; i < exponent; i++) {
				result *= base;
			}
		}

		return result;
	}

	/**
	 * 斐波那契 exponent 满足 例如 32次方 = 2的五次方 只用计算5次.
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double power2(double base, int exponent) {
		if (base == 0)
			return 0;
		if (base == 1)
			return 1;
		boolean isPositive = exponent > 0;
		int absExponent = exponent > 0 ? exponent : -exponent;
		double result = powerCore(base, absExponent);
		if (!isPositive) {
			result = 1 / result;
		}
		return result;
	}

	private static double powerCore(double base, int absExponent) {
		if (absExponent == 0) {
			return 1;
		}
		if (absExponent == 1) {
			return base;
		}

		double result = powerCore(base, absExponent >> 1);
		result *= result;
		if ((absExponent & 1) == 1) {
			result *= base;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Power_16.power2(3, 11));
		// System.out.println(Math.pow(0, -1));
	}

}

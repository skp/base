package string;

public class Numeric_20 {

	private static int i = 0;

	public static boolean isNumeric(char[] str) {
		if (str == null || str.length < 1) {
			return false;
		}

		boolean isNumeric = scanInteger(str);

		if (i < str.length && str[i] == '.') {
			i++;
			isNumeric = scanUnsignedInteger(str) && isNumeric;
		}

		if (i < str.length && (str[i] == 'e' || str[i] == 'E')) {
			i++;
			isNumeric = scanInteger(str) && isNumeric;
		}

		return isNumeric && i == str.length;
	}

	private static boolean scanUnsignedInteger(char[] str) {
		int start = i;
		while (i < str.length && str[i] >= '0' && str[i] <= '9')
			i++;
		return start < i;
	}

	private static boolean scanInteger(char[] str) {
		if (i < str.length && (str[i] == '+' || str[i] == '-'))
			i++;
		if (i < str.length && str[i] == '.') {
			i++;
		}
		return scanUnsignedInteger(str);
	}

	public static void main(String[] args) {
		// System.out.println(Numeric_20.isNumeric("100".toCharArray()));
		// System.out.println(Numeric_20.isNumeric("123.45e+6".toCharArray()));
		// System.out.println(Numeric_20.isNumeric("-.123".toCharArray()));
		System.out.println(Numeric_20.isNumeric("+500".toCharArray()));
	}
}

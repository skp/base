package string;

import java.util.Scanner;

public class StringToInt_1 {

	public int strToInt(String str) {
		if (null == str || str.length() == 0 || str.trim().equals("")) {
			return 0;
		}
		boolean symbol = true;
		char[] charArray = str.trim().toCharArray();
		char[] ret = new char[str.trim().length()];
		for (int i = 0, l = charArray.length; i < l; i++) {
			char c = charArray[i];
			if (c > '9' || c < '0') {
				if (i == 0) {
					if (c == '+') {
						ret[i] = '0';
					} else if (c == '-') {
						symbol = false;
						ret[i] = '0';
					} else {
						return 0;
					}
				} else {
					return 0;
				}
			} else {
				ret[i] = c;
			}
		}
		int retInt = 0;
		for (char c : ret) {
			int temp = (c - '0');
			int prev = retInt;
			retInt = retInt * 10 + temp;
			if ((retInt - temp) / 10 != prev) {
				return 0;
			}
		}
		return symbol ? retInt : retInt * -1;
	}

	public static void main(String[] args) {
		while (true) {

			System.out.print("输入");
			Scanner scan = new Scanner(System.in);
			String read = scan.nextLine();
			// System.out.println("输入数据："+read);
			System.out.println(new StringToInt_1().strToInt(read));
		}
	}
}

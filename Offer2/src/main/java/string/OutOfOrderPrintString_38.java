package string;

import java.util.ArrayList;

public class OutOfOrderPrintString_38 {

	static ArrayList<String> list = new ArrayList<>();
	public static ArrayList<String> permutation(String str) {
		if (null == str || str.length() == 0)
			return null;
		p(str.toCharArray(), 0);
		return list;
	}

	private static void p(char[] strCharArr, int start) {
		if (start >= strCharArr.length && !list.contains(new String(strCharArr))) {
			list.add(new String(strCharArr));
			return;
		}
		char[] newChar = strCharArr.clone();
		for (int i = start; i < newChar.length; i++) {
			char[] newStr = swap(newChar, start, i);
			p(newStr, start + 1);
		}
	}

	private static char[] swap(char[] ca, int i, int j){
		char iVal = ca[i];
		ca[i] = ca[j];
		ca[j] = iVal;
		return ca;
	}

	public static void main(String[] args) {
		OutOfOrderPrintString_38.permutation("abc");
	}
}

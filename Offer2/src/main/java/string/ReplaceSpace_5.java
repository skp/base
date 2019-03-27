package string;

import java.util.Objects;

public class ReplaceSpace_5 {
	public String replaceSpace(String str) {
		if (Objects.isNull(str))
			return "";
		int count = 0;
		char[] charArr = str.toCharArray();
		for (char c : charArr) {
			if (c == 32) {
				++count;
			}
		}
		int length = str.length();
		int newLength = str.length() + (count << 1);
		char[] newCharArr = new char[newLength];
		for (int i = length - 1, j = newLength - 1; i >= 0; i--, j--) {
			if (charArr[i] == ' ') {
				newCharArr[j] = '0';
				newCharArr[--j] = '2';
				newCharArr[--j] = '%';
			} else {
				newCharArr[j] = charArr[i];
			}
		}
		return new String(newCharArr);
	}

	public static void main(String[] args) {
		System.out.println(new ReplaceSpace_5().replaceSpace("we are happy "));
		System.out.println(new ReplaceSpace_5().replaceSpace(" "));
	}
}

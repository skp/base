package string;

public class RegularExpression_19 {

	/**
	 * 正则匹配   可有 .和*
	 * @param str aaa
	 * @param pattern a.a    aa.a    ab*ac*ad*
	 *
	 * @return
	 */
	public static boolean match(char[] str, char[] pattern) {
		if (null == str || null == pattern) {
			return false;
		}

		return matchCore(str, 0, str.length, pattern, 0, pattern.length);
	}

	private static boolean matchCore(char[] str, int i, int strLen, char[] pattern, int j, int pLen) {
		if (i == strLen && j == pLen) {
			return true;
		}
		//pattern先到尾，匹配失败
		if (i != str.length && j == pattern.length) {
			return false;
		}

		int nextJ = j + 1;

		if (nextJ < pLen && pattern[nextJ] == '*') {
			if (i != strLen && (pattern[j] == '.' || str[i] == pattern[j])) {
				return matchCore(str, i, str.length, pattern, j + 2, pattern.length) //模式后移2位, 字符串匹配0个字符
						|| matchCore(str, i + 1, str.length, pattern, j + 2, pattern.length) // 模式后移2位, 字符串匹配1个字符
						|| matchCore(str, i + 1, str.length, pattern, j, pattern.length); // 模式不变, 字符串匹配1个字符 然后继续匹配.
			} else {
				return matchCore(str, i, str.length, pattern, j + 2, pattern.length); //模式后移2位, 字符串匹配0个字符
			}
		}

		if (i != strLen && (pattern[j] == '.' || str[i] == pattern[j])) {
			return matchCore(str, i + 1, str.length, pattern, j + 1, pattern.length);
		}

		return false;
	}

	public static void main(String[] args) {
		RegularExpression_19.match("a".toCharArray(), ".*".toCharArray());
	}
}

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinNumber_45 {

	public String printMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return "";
		}
		int len = numbers.length;
		String[] str = new String[len];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			str[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(str, (o1, o2) -> (o1 + "" + o2).compareTo(o2 + "" + o1));

		for(int i = 0; i < len; i++){
			sb.append(str[i]);
		}
		return sb.toString();
	}
}

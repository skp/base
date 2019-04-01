package array;

import java.util.ArrayList;
import java.util.TreeSet;

public class SmallestNNumber_40 {


	public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
		if (input == null || k == 0 || k > input.length)
			return new ArrayList<>();
		TreeSet<Integer> set = new TreeSet<>();
		for (int i : input) {
			if (set.size() < k) {
				set.add(i);
			} else if (set.last() > i) {
				set.pollLast();
				set.add(i);
			}
		}
		return new ArrayList<>(set);
	}
}

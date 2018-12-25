package v1ch09.shuffle;

//import map.Employee;

import java.util.*;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 *
 * @author Cay Horstmann
 * @version 1.11 2012-01-26
 */
public class ShuffleTest {
	
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= 49; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		System.out.println(numbers);
		numbers.sort(Comparator.comparingDouble(Integer::intValue));
		System.out.println(numbers);
		List<Integer> winningCombination = numbers.subList(0, 6);
		Collections.sort(winningCombination);
		System.out.println(winningCombination);
	}
	
}

package v1ch07.exceptional;

import java.util.*;

/**
 * @author Cay Horstmann
 * @version 1.11 2012-01-26
 */
public class ExceptionalTest {
	
	public static void main(String[] args) {
		int i = 0;
		int ntry = 10000000;
		Stack<String> s = new Stack<>();
		long s1;
		long s2;
		
		// Test a stack for emptiness ntry times
		System.out.println("Testing for empty stack");
		s1 = System.currentTimeMillis();
		for (i = 0; i <= ntry; i++) {
			if (!s.empty()) {
				s.pop();
			}
		}
		s2 = System.currentTimeMillis();
		System.out.println((s2 - s1) + " milliseconds");
		
		// pop an empty stack ntry times and catch the resulting exception
		System.out.println("Catching EmptyStackException");
		s1 = System.currentTimeMillis();
		for (i = 0; i <= ntry; i++) {
			try {
				s.pop();
			} catch (EmptyStackException e) {
			}
		}
		s2 = System.currentTimeMillis();
		System.out.println((s2 - s1) + " milliseconds");
	}
}

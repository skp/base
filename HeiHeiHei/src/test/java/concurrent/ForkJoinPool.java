package concurrent;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPool {
	
	@Test
	public void test() {
		int[] ints = new int[10000];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = i + 1;
		}
		System.out.println(Arrays.stream(ints).sum());
	}
	
	class AddTask extends RecursiveTask<Integer> {
		
		AddTask() {
		
		}
		
		@Override
		protected Integer compute() {
			
			return null;
		}
	}
}

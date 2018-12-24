package concurrent;

import javafx.concurrent.Task;
import org.junit.Test;

import java.util.concurrent.*;

public class CallableFuture {
	
	@Test
	public void call() throws ExecutionException, InterruptedException {
		FutureTask<Integer> task = new FutureTask<>(() -> 1);
		new Thread(task).start();
		System.out.println(task.get());
		
		ExecutorService service = Executors.newFixedThreadPool(1);
		Future<Integer> f = service.submit(() -> 2);
		System.out.println(f.get());
		
	}
}

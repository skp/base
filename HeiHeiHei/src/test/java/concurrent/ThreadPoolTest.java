package concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	
	@Test
	public void executor() {
		ExecutorService es = Executors.newCachedThreadPool();
	}
}

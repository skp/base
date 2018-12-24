package concurrent;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class AThreadTest {
	
	private ThreadLocal threadLocal = new ThreadLocal();
	private static List<String> stringList = new ArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
//		new Thread(() -> System.out.println("aaa"), "a1");
//		Collections.synchronizedMap()
//		ConcurrentMap
//		ConcurrentHashMap
//		stringList.forEach(System.out:: println);
//		ConcurrentLinkedQueue
//		SynchronousQueue
//		ThreadPoolExecutor
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(10);
		for (int i = 0; i < 10; i++) {
			bq.put("a" + i);
		}
		Thread.currentThread().interrupt();
//		Arrays.stream()
//		DefaultThreadFactory
	}
}
